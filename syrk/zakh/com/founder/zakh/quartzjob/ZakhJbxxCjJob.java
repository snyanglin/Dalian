/**********************************************************************   
 * <p>文件名：ZakhJbxxCjJob.java </p>
 * <p>文件描述：治安考核-基本信息采集定时类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:58:22 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.quartzjob;

import java.util.*;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.google.gson.Gson;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import com.founder.zakh.bean.ZakhCjclBean;
import com.founder.zakh.bean.ZakhJbxxCjBean;
import com.founder.zakh.dao.ZakhCjclDao;
import com.founder.zakh.dao.ZakhJbxxCjDao;
import com.founder.zakh.tools.*;

/******************************************************************************
 * @Package:      [com.founder.zakh.quartzjob.ZakhJbxxCjJob.java]  
 * @ClassName:    [ZakhJbxxCjJob]   
 * @Description:  [治安考核-基本信息采集定时类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:58:22]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:58:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ZakhJbxxCjJob {
	
	@Resource(name = "zakhJbxxCjDao")
	private ZakhJbxxCjDao cjDao;
	
	@Resource(name = "zakhCjclDao")
	private ZakhCjclDao clDao;
	/**
	 * 
	 * @Title: cj
	 * @Description: 按考核规则进行考核信息采集
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public void cj(){
		List<ZakhJbxxCjBean> countList=new ArrayList<ZakhJbxxCjBean>();
		//存储详细信息，用于以json形式存入cjxx字段
		Map<String,Map<String,String[]>> cjxxMap=new HashMap<String,Map<String,String[]>>();
		//处理统计时间
		Date currDate=new Date();
		int currWeek=Dateutil.getWeekOfYear(currDate);
		int year=Integer.parseInt(DateUtils.getSystemDateString().substring(0,4));
		int preWeek=currWeek-1;
		if(preWeek==0)preWeek=Dateutil.getMaxWeekNumOfYear(--year);
		String weekbtime=DateUtils.getShortString(Dateutil.getFirstDayOfWeek(year,preWeek));
		String weeketime=DateUtils.getShortString(Dateutil.getLastDayOfWeek(year,preWeek));
		//初始化查询参数
		Map<String,Object> parameter=new HashMap<String, Object>();
		parameter.put("btime", weekbtime);
		parameter.put("etime", weeketime);
		//责任区查询参数
		Map<String,Object> orgParameter=new HashMap<String, Object>();
		orgParameter.put("level", "50");
		orgParameter.put("type", "04");
		List<Map<String,Object>> orgZrqList=cjDao.getORG(orgParameter);
		//初始化常量值列表
		List<ZakhCjclBean> clList=clDao.query(null);
		Map<String,String> clMap=new HashMap<String, String>();
		for(ZakhCjclBean z:clList){
			clMap.put(z.getOrgid(), z.getCl());
		}
		
		
		//根据组织机构信息初始化采集数据
		for(Map<String,Object> m:orgZrqList){
			ZakhJbxxCjBean cjBean=new ZakhJbxxCjBean();
			cjBean.setId(UUID.create());
			cjBean.setOrgid(m.get("ORGID").toString());
			cjBean.setOrgname(m.get("ORGNAME").toString());
//			cjBean.setCl("50");
			cjBean.setCl(clMap.get(m.get("ORGID").toString()));
			cjBean.setWeek(Integer.toString(preWeek));
			cjBean.setWeekbtime(weekbtime+" 00:00:00");
			cjBean.setWeeketime(weeketime+" 23:59:59");
			cjBean.setCounttime(weeketime);
			countList.add(cjBean);
			
			Map<String,String[]> cjxx=new HashMap<String,String[]>();
			cjxxMap.put(cjBean.getOrgid(), cjxx);
		}
		
		//统计人口
		//人户一致人口
		List<Map<String,Object>> rhyzrkList=cjDao.getRHYZRK(parameter);
		dealCountResult(rhyzrkList, countList, cjxxMap, "人户一致人口");
		//空挂人口
		List<Map<String,Object>> kgrkList=cjDao.getKGRK(parameter);
		dealCountResult(kgrkList, countList, cjxxMap, "空挂人口");
		//寄住人口
		List<Map<String,Object>> jzrkList=cjDao.getJZRK(parameter);
		dealCountResult(jzrkList, countList, cjxxMap, "寄住人口");
		//暂住/流动人口
		List<Map<String,Object>> zzrkList=cjDao.getZZRK(parameter);
		dealCountResult(zzrkList, countList, cjxxMap, "暂住人口");
		//境外人口
		List<Map<String,Object>> jwrkList=cjDao.getJWRK(parameter);
		dealCountResult(jwrkList, countList, cjxxMap, "境外人口");
		//未落户人口
		List<Map<String,Object>> wlhrkList=cjDao.getWLHRK(parameter);
		dealCountResult(wlhrkList, countList, cjxxMap, "未落户人口");
		
		//统计房屋
		//出租房屋
		List<Map<String,Object>> czfwList=cjDao.getWLHRK(parameter);
		dealCountResult(czfwList, countList, cjxxMap, "出租房屋");
		//承租人
		List<Map<String,Object>> czrList=cjDao.getCZR(parameter);
		dealCountResult(czrList, countList, cjxxMap, "承租人");
		
		//统计单位
		//单位基本信息
		List<Map<String,Object>> dwjbxxList=cjDao.getDWJBXX(parameter);
		dealCountResult(dwjbxxList, countList, cjxxMap, "单位基本信息");
		//从业人员
		List<Map<String,Object>> cyryList=cjDao.getCYRY(parameter);
		dealCountResult(cyryList, countList, cjxxMap, "从业人员");
		
		addRKCJXX(countList, cjxxMap);
//		cjDao.saveByList(countList);
		for(ZakhJbxxCjBean z:countList){
			cjDao.save(z);
		}
		//批量存储耗时过长 导致假死
//		Gson gson=new Gson();
//		System.out.println(gson.toJson(countList));
	}
	
	/**
	 * @Title: dealCountResult
	 * @Description: 处理统计结果
	 * @param @param r 
	 * @param @param c
	 * @param @param cm
	 * @param @param type    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void dealCountResult(List<Map<String,Object>> r,List<ZakhJbxxCjBean> c,Map<String,Map<String,String[]>> cm,String type){
		for(Map<String,Object> m:r){
			for(ZakhJbxxCjBean z:c){
				if(z.getOrgid().equals(m.get("ORGID"))){
					z.setAddnum(StringFormulaCountUtil.countStringFormula(z.getAddnum()+"+"+m.get("ADDNUM")));
					z.setDelnum(StringFormulaCountUtil.countStringFormula(z.getDelnum()+"+"+m.get("DELNUM")));
					cm.get(z.getOrgid()).put(type, new String[]{m.get("ADDNUM").toString(),m.get("DELNUM").toString()});
					break;
				}
			}
		}
	}
	
	/**
	 * @Title: addRKCJXX
	 * @Description: 添加人口采集详细信息
	 * @param @param c
	 * @param @param cm    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void addRKCJXX(List<ZakhJbxxCjBean> c,Map<String,Map<String,String[]>> cm){
		Gson gson=new Gson();
		for(ZakhJbxxCjBean z:c){
			z.setCjxx(gson.toJson(cm.get(z.getOrgid())));
		}
	}
}
