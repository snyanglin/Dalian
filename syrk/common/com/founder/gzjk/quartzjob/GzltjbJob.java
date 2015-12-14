package com.founder.gzjk.quartzjob;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.UUID;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.gzjk.dao.GzltjbDao;
import com.founder.gzjk.vo.GzltjVo;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.dao.TzggDao;

/******************************************************************************
 * @Package: [com.founder.gzjk.quartzjob.GzltjbbJob.java]
 * @ClassName: [GzltjbbJob]
 * @Description: [工作量统计-定时任务]
 * @Author: [cong_rihong]
 * @CreateDate: [2015-5-13 上午10:14:59]
 * @UpdateDate: 
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

public class GzltjbJob {
	
	
	@Resource(name="tzggDao")
	private TzggDao tzggDao;
	
	@Resource(name="gzltjbDao")
	private GzltjbDao gzltjDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	/**
	 * @Title: tj
	 * @Description: 工作量统计
	 * @param 
	 * @return void 返回类型
	 * @throws
	 */
	public void tj() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=sdf.format(date);
		
		Map<String,String> dateMap=new HashMap<String, String>();
		dateMap.put("tjrq", dateString);
		//查看当天是否执行过（适用于集群）
		long count  = gzltjDao.queryCount(dateMap);
		if(count>0){
			return;
		}
		Org_Organization org=new Org_Organization();
		//查询责任区sql语句
		org.setOrglevel("50");
		org.setOrgbiztype("04");
		List<Org_Organization> orgs=tzggDao.queryOrg(org);
		//每个责任区每天一条统计数据
		List<Gzltjb> list=new ArrayList<Gzltjb>();
		for(Org_Organization organization:orgs){
			Gzltjb gzltj=new Gzltjb();
			gzltj.setGxzrqdm(organization.getOrgcode());
			gzltj.setGxzrqname(organization.getOrgname());

			OrgOrganization pcs=orgOrganizationService
					.queryParentOrgByOrgcode(organization.getOrgcode());
			String pcsName= pcs.getOrgname();	
			String pcsCode = pcs.getOrgcode();
			OrgOrganization fxj=orgOrganizationService
					.queryParentOrgByOrgcode(pcsCode);
		    String fxjName=fxj.getOrgname();
			String fxjCode=fxj.getOrgcode();

		    gzltj.setGxpcsdm(pcsCode);
		    gzltj.setGxpcsname(pcsName);
		    gzltj.setGxfjdm(fxjCode);
		    gzltj.setGxfjname(fxjName);		    
			gzltj.setTjrq(dateString);
			list.add(gzltj);
		}
	    this.rhyzTj(list,dateString);
	    this.rhflTj(list,dateString);
	    this.jzrkTj(list,dateString);
	    this.ldrkTj(list,dateString);
	    this.jwryTj(list,dateString);
	    this.wlhryTj(list,dateString);
	    this.czfwTj(list,dateString);
	    this.czrTj(list,dateString);
	    this.sydwTj(list,dateString);
	    this.cyryTj(list,dateString);
	    
	    for(Gzltjb entity:list){
	    	entity.setId(UUID.create());
	    	
	    	this.gzltjDao.save(entity);
	    }

	}

	/**
	 * 人户一致统计
	 * @param list
	 * @return
	 */
	private void rhyzTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("sfrhyzdm", "1");
		map.put("date", date);
	    List<GzltjVo> rhyzGzltjList = gzltjDao.czrkTj(map);
	    for(int i=0;i<list.size();i++){
	    	for(GzltjVo vo:rhyzGzltjList){
	    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
	    			list.get(i).setRhyz_add(vo.getXz());
	    			list.get(i).setRhyz_update(vo.getXg());
	    			list.get(i).setRhyz_delete(vo.getZx());	    			
	    			break;
	    		}
	    	}
	    }
		
		
	}
	/**
	 * 人户分离统计
	 * @param list
	 * @return
	 */
	private void rhflTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("sfrhyzdm", "0");
		map.put("date", date);
		 List<GzltjVo> rhflGzltjList = gzltjDao.czrkTj(map);
		    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:rhflGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setRhfl_add(vo.getXz());
		    			list.get(i).setRhfl_update(vo.getXg());
		    			list.get(i).setRhfl_delete(vo.getZx());			
		    			break;
		    		}
		    	}
		    }

	}
	/**
	 * 寄住人口统计
	 * @param list
	 * @return
	 */
	private void jzrkTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("syrkywlxdm", "2");
		map.put("date", date);
		List<GzltjVo> jzrkGzltjList = gzltjDao.syrkTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:jzrkGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setJzrk_add(vo.getXz());
		    			list.get(i).setJzrk_update(vo.getXg());
		    			list.get(i).setJzrk_delete(vo.getZx());

		    			
		    			break;
		    		}
		    	}
		    }

	}
	/**
	 * 流动人口统计
	 * @param list
	 * @return
	 */
	private void ldrkTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("syrkywlxdm", "3");
		map.put("date", date);
		List<GzltjVo> ldrkGzltjList = gzltjDao.syrkTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:ldrkGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setLdrk_add(vo.getXz());
		    			list.get(i).setLdrk_update(vo.getXg());
		    			list.get(i).setLdrk_delete(vo.getZx());

		    			break;
		    		}
		    	}
		    }

	}
	/**
	 * 境外人员
	 * @param list
	 * @return
	 */
	private void jwryTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("syrkywlxdm", "4");
		map.put("date", date);
		List<GzltjVo> jwryGzltjList = gzltjDao.syrkTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:jwryGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setJwry_add(vo.getXz());
		    			list.get(i).setJwry_update(vo.getXg());
		    			list.get(i).setJwry_delete(vo.getZx());
		    			
		    			break;
		    		}
		    	}
		    }
	}
	/**
	 * 未落户人员
	 * @param list
	 * @return
	 */
	private void wlhryTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("syrkywlxdm", "5");
		map.put("date", date);
		List<GzltjVo> wlhryGzltjList = gzltjDao.syrkTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:wlhryGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setWlhry_add(vo.getXz());
		    			list.get(i).setWlhry_update(vo.getXg());
		    			list.get(i).setWlhry_delete(vo.getZx());		   
		    			
		    			break;
		    		}
		    	}
		    }
	}
	/**
	 * 出租房屋统计
	 * @param list
	 * @return
	 */
	private void czfwTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("syrkywlxdm", "5");
		map.put("date", date);
		List<GzltjVo> czfwGzltjList = gzltjDao.czfwTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:czfwGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setCzfw_add(vo.getXz());
		    			list.get(i).setCzfw_update(vo.getXg());
		    			list.get(i).setCzfw_delete(vo.getZx());	
		    			
		    			break;
		    		}
		    	}
		    }

	}
	/**
	 * 承租人统计
	 * @param list
	 * @return
	 */
	private void czrTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("date", date);
		List<GzltjVo> czrGzltjList = gzltjDao.czrTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:czrGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setCzr_add(vo.getXz());
		    			list.get(i).setCzr_update(vo.getXg());
		    			list.get(i).setCzr_delete(vo.getZx());
		    			
		    			break;
		    		}
		    	}
		    }

	}
	/**
	 * 实有单位统计
	 * @param list
	 * @return
	 */
	private void sydwTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("date", date);
		List<GzltjVo> dwGzltjList =  gzltjDao.sydwTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:dwGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setDw_add(vo.getXz());
		    			list.get(i).setDw_update(vo.getXg());
		    			list.get(i).setDw_delete(vo.getZx());	
		    		
		    			break;
		    		}
		    	}
		    }
	}
	/**
	 * 从业人员统计
	 * @param list
	 * @return
	 */
	private void cyryTj(List<Gzltjb> list,String date){
		Map<String,String> map=new HashMap<String, String>();
		map.put("date", date);
		List<GzltjVo> cyryGzltjList = gzltjDao.cyryTj(map);
	    for(int i=0;i<list.size();i++){
		    	for(GzltjVo vo:cyryGzltjList){
		    		if(list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())){
		    			list.get(i).setCyry_add(vo.getXz());
		    			list.get(i).setCyry_update(vo.getXg());
		    			list.get(i).setCyry_delete(vo.getZx());		
		    			
		    			break;
		    		}
		    	}
		    }
	}


    public static void main(String args[]){
    	
    	GzltjbJob gzl=new GzltjbJob();
    	gzl.tj();
    }
}
