package com.founder.zakh.quartzjob;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.framework.utils.UUID;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.gzjk.dao.GzltjbDao;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.dao.TzggDao;
import com.founder.zakh.bean.Khfstjb;
import com.founder.zakh.dao.KhfstjbDao;
import com.founder.zakh.dao.ZakhCjclDao;
import com.founder.zakh.tools.Dateutil;

public class ZakhFstjJob {

	@Resource
	private KhfstjbDao khfstjbDao;
	@Resource
	private TzggDao tzggDao;
	@Resource
	private ZakhCjclDao zakhCjclDao;
	@Resource(name = "gzltjbDao")
	private GzltjbDao gzltjbDao;
	public void khfstj(){
		 Dateutil dt=new Dateutil();
		 Calendar cal=Calendar.getInstance();
		 int nowYear = cal.get(Calendar.YEAR);
		 int nowWeek = dt.getWeekOfYear(new Date());
		 int tjYear=nowYear;
		 int tjWeek=nowWeek-1;
		 if(nowWeek==1){
			 tjWeek=dt.getMaxWeekNumOfYear(nowYear-1);
			 tjYear=nowYear-1;
		 }
		 Date startDate=dt.getFirstDayOfWeek(tjYear, tjWeek);
		 Date endDate=dt.getLastDayOfWeek(tjYear, tjWeek);

		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1225 = sdf.parse(tjYear+"-12-25");
			Date date1226 = sdf.parse(tjYear+"-12-26");
			 int week1225=dt.getWeekOfYear(date1225);
			 int week1226=dt.getWeekOfYear(date1226);
			 //如果12月25号和26号在一周内
			 if(tjWeek==week1225 && week1225==week1226){
				 //需要执行两个周期内的  假如 周期是12-23到12月29 则 需要执行一次12-23到12-25一次    和  12-26到12-29一次
				 
				 //判断这周是否执行过，防止集群重复执行
				 Map<String,String> paramMap=new HashMap<String, String>();
				 paramMap.put("year", String.valueOf(tjYear));
				 paramMap.put("week", String.valueOf(tjWeek));
				 List<Khfstjb> list= this.khfstjbDao.queryKhtjb(paramMap);
				 if(null!=list && list.size()>0){
					 return;
				 }
				 
				 
				 Date startDate1=startDate;
				 Date endDate1=date1225;
				 Date startDate2=date1226;
				 Date endDate2=endDate;
				 this.tjZrq(tjYear, tjWeek,startDate1, endDate1);
				 this.tjPcs(tjYear,tjWeek, startDate1, endDate1);
				 this.tjFj(tjYear,tjWeek, startDate1, endDate1);
				 
				 this.tjZrq(tjYear, tjWeek,startDate2, endDate2);
				 this.tjPcs(tjYear,tjWeek, startDate2, endDate2);
				 this.tjFj(tjYear,tjWeek, startDate2, endDate2);
			 }else{
				 //判断这周是否执行过，防止集群重复执行
				 Map<String,String> paramMap=new HashMap<String, String>();
				 paramMap.put("year", String.valueOf(tjYear));
				 paramMap.put("week", String.valueOf(tjWeek));
				 List<Khfstjb> list= this.khfstjbDao.queryKhtjb(paramMap);
				 if(null!=list && list.size()>0){
					 return;
				 }
				 
				 this.tjZrq(tjYear, tjWeek,startDate, endDate);
				 this.tjPcs(tjYear,tjWeek, startDate, endDate);
				 this.tjFj(tjYear,tjWeek, startDate, endDate);
			 }
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	private void tjFj(int tjYear,int tjWeek, Date startDate, Date endDate){
		Org_Organization org=new Org_Organization();
		//查询分局sql语句
		org.setOrglevel("21");
		org.setOrgbiztype("01");
		List<Org_Organization> fjOrgs=tzggDao.queryOrg(org);
		
		createData(tjYear, tjWeek, startDate, endDate, fjOrgs,"fj");
	}


	private void tjPcs(int tjYear,int tjWeek, Date startDate, Date endDate){
		Org_Organization org=new Org_Organization();
		//查询派出所sql语句
		org.setOrglevel("32");
		org.setOrgbiztype("01");
		List<Org_Organization> pcsOrgs=tzggDao.queryOrg(org);
        this.createData(tjYear, tjWeek, startDate, endDate, pcsOrgs, "pcs");
	}
	
	private void tjZrq(int tjYear,int tjWeek, Date startDate, Date endDate) {
		Org_Organization org=new Org_Organization();
		//查询责任区sql语句
		org.setOrglevel("50");
		org.setOrgbiztype("04");
		List<Org_Organization> zrqOrgs=tzggDao.queryOrg(org);
		this.createData(tjYear, tjWeek, startDate, endDate, zrqOrgs, "zrq");
	}
	private void createData(int tjYear, int tjWeek, Date startDate,
			Date endDate, List<Org_Organization> orgs,String zzjgdj) {
		List<Khfstjb> list=new ArrayList<Khfstjb>();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		for(Org_Organization org:orgs){
			Map<String,String> clParamMap=new HashMap<String, String>();
			clParamMap.put("orgCode", org.getOrgcode());
			Long cl=this.zakhCjclDao.querySumCl(clParamMap);
			if(cl==null){
				cl=0L;
			}
			Map<String,String> paramMap=new HashMap<String, String>();
			paramMap.put("startDate",sdf.format(startDate));
			paramMap.put("endDate", sdf.format(endDate));
			paramMap.put("orgCode", org.getOrgcode());
			Gzltjb gzltj = gzltjbDao.queryGzltjForKh(paramMap);
			    //新增数
			long sumAdd=(gzltj.getRhfl_add()!=null?gzltj.getRhfl_add():0)+(gzltj.getRhyz_add()!=null?gzltj.getRhyz_add():0)
						   +(gzltj.getJzrk_add()!=null?gzltj.getJzrk_add():0)+(gzltj.getLdrk_add()!=null?gzltj.getLdrk_add():0)
						   +(gzltj.getJwry_add()!=null?gzltj.getJwry_add():0)+(gzltj.getWlhry_add()!=null?gzltj.getWlhry_add():0)
						   +(gzltj.getCzfw_add()!=null?gzltj.getCzfw_add():0)+(gzltj.getCzr_add()!=null?gzltj.getCzr_add():0)
						   +(gzltj.getDw_add()!=null?gzltj.getDw_add():0)+(gzltj.getCyry_add()!=null?gzltj.getCyry_add():0);
				//注销数
			long sumDelete=(gzltj.getRhfl_delete()!=null?gzltj.getRhfl_delete():0)+(gzltj.getRhyz_delete()!=null?gzltj.getRhyz_delete():0)
						   +(gzltj.getJzrk_delete()!=null?gzltj.getJzrk_delete():0)+(gzltj.getLdrk_delete()!=null?gzltj.getLdrk_delete():0)
						   +(gzltj.getJwry_delete()!=null?gzltj.getJwry_delete():0)+(gzltj.getWlhry_delete()!=null?gzltj.getWlhry_delete():0)
						   +(gzltj.getCzfw_delete()!=null?gzltj.getCzfw_delete():0)+(gzltj.getCzr_delete()!=null?gzltj.getCzr_delete():0)
						   +(gzltj.getDw_delete()!=null?gzltj.getDw_delete():0)+(gzltj.getCyry_delete()!=null?gzltj.getCyry_delete():0);
				//考核数
			long khs=sumAdd-sumDelete>0?sumAdd-sumDelete:0;			
				//总分
			BigDecimal totalScore=new BigDecimal("100");
				//TODO 需要查数据库查当年上周的考核数据（12月26号开始算下一年的） 上周数据
			Map<String,String> szsjMap=new HashMap<String, String>();
			szsjMap.put("orgCode",org.getOrgcode());
			
		    Date weekStartDate=null;
		    Date weekEndDate=null;
			try {
				weekStartDate = sdf.parse((tjYear-1)+"-12-26");
			     weekEndDate=sdf.parse(tjYear+"-12-25");

			} catch (ParseException e) {
				e.printStackTrace();
			}
			szsjMap.put("weekStartDate", sdf.format(weekStartDate));
			szsjMap.put("weekEndDate", sdf.format(weekEndDate));            
			Khfstjb szsj=this.khfstjbDao.querySzkhtj(szsjMap);				
			BigDecimal nowScore=new BigDecimal("100");
				
				//责任区周考核数据
			Khfstjb tj=new Khfstjb();
			if(khs>=cl){
					tj.setJcxxkf(0d);
					tj.setJcxxkfhj(szsj.getJcxxkfhj()==null?0d:szsj.getJcxxkfhj());
					tj.setJcxxkhdf(szsj.getJcxxkhdf()==null?100d:szsj.getJcxxkhdf());
			}else{
					BigDecimal lessPercent = new BigDecimal(cl-khs).divide(new BigDecimal(cl),5,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
					lessPercent=lessPercent.setScale(2, BigDecimal.ROUND_HALF_UP);
					tj.setJcxxkf(lessPercent.doubleValue());
					BigDecimal kfhj=null;
					if(szsj.getJcxxkfhj()==null){
						kfhj=lessPercent;
					}else{
						kfhj =new BigDecimal(szsj.getJcxxkfhj()).add(lessPercent);
						//如果扣分合计大于100 则等于100
						if(kfhj.compareTo(new BigDecimal(100))==1){
							kfhj=new BigDecimal(100);
						}
						
					}
					tj.setJcxxkfhj(kfhj.doubleValue());
					
					BigDecimal khdf=null;
					if(szsj.getJcxxkhdf()==null){
						khdf=nowScore.subtract(lessPercent);
					}else{
						khdf =new BigDecimal(szsj.getJcxxkhdf()).subtract(lessPercent);
						if(khdf.compareTo(new BigDecimal(0))==-1){
							khdf=new BigDecimal(0);
						}
					}
					
					tj.setJcxxkhdf(khdf.doubleValue());

			}			
			tj.setJcxxkhzf(totalScore.doubleValue());
			tj.setYear(String.valueOf(tjYear));
			tj.setWeek(String.valueOf(tjWeek));
			tj.setWeekStartDate(sdf.format(startDate));
			tj.setWeekEndDate(sdf.format(endDate));
		    tj.setZzjgdm(org.getOrgcode());
		    tj.setZzjgname(org.getOrgname());
		    tj.setZzjgdj(zzjgdj);
		    list.add(tj);
		}
			
		for(Khfstjb tj:list){
			tj.setId(UUID.create());
			this.khfstjbDao.save(tj);
		}
	}
	
}
