package com.founder.gzjk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.DateUtils;
import com.founder.gzjk.bean.Dttjb;
import com.founder.gzjk.bean.Gzdt;
import com.founder.gzjk.dao.GzjkDao;
import com.founder.gzjk.romcache.BzdzRamCache;
import com.founder.gzjk.romcache.RamCache;
import com.founder.gzjk.romcache.SydwRamCache;
import com.founder.gzjk.romcache.SyfwRamCache;
import com.founder.gzjk.romcache.ZdryRamCache;
import com.founder.gzjk.service.GzjkService;
import com.founder.gzjk.vo.CountBean;
import com.founder.gzjk.vo.GzjkTemp;
import com.founder.gzjk.vo.GzjkZdry;

@Service("gzjkService")
public class GzjkServiceImpl extends BaseService implements GzjkService {

	@Resource(name = "gzjkDao")
	private GzjkDao gzjkDao;
	
	@Override
	public List<ComboBox> searchOrgList() {
		return gzjkDao.searchOrgList();
	}

	@Override
	public List<ComboBox> searchOrgListLower(String orgCode) {
		orgCode = orgCode.substring(0,6);
		return gzjkDao.searchOrgListLower(orgCode);
	}

	@Override
	public List<GzjkZdry> queryZdryRylb(String dwdm, String rylbdm) {
		return gzjkDao.queryZdryRylb(dwdm,rylbdm);
	}
	
	//常东旭 2014-09-12 添加
	@Override
	public List<ComboBox> searchOrgListLowest(String orgCode) {
		orgCode = orgCode.substring(0,8);
		return gzjkDao.searchOrgListLowest(orgCode);
	}

	@Override
	public CountBean queryBean(String dwdm, String rylbdm) {
		GzjkZdry co = new GzjkZdry();
		co.setXm(dwdm);
		co.setBdlx(rylbdm);
		return gzjkDao.count(co);
	}
   /**
	 * 工作推送生成图形
	 */
	@Override
	public Map<String, Object> gzdxChart(String dwdm) {
		//创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Integer [] a1 = new Integer[5];/*新增 */
		Integer [] a2 =  new Integer[5];/*修改*/
		Integer [] a3 =  new Integer[5];/*注销*/
		String[] labels = new String[5];
		
		Gzdt Gzdt = new Gzdt();
		Gzdt.setDwdm(dwdm);
		Gzdt.setCurrentDay(DateUtils.getSystemDateString());
		Gzdt syrkGzdt = querySyrkGzdt(Gzdt);
		Gzdt syfwGzdt = querySyfwGzdt(Gzdt);
		Gzdt sydwGzdt = querySydwGzdt(Gzdt);
		Gzdt bzdzGzdt = queryBzdzGzdt(Gzdt);
		Gzdt zdryGzdt = queryZdryGzdt(Gzdt);
		
		
		/*新增 */
		Map<String,Object> map = new HashMap<String,Object>();
		/*修改*/
		Map<String,Object> map2 = new HashMap<String,Object>();
		/*注销*/
		Map<String,Object> map3 = new HashMap<String,Object>();
		a1[0] = Integer.parseInt(syrkGzdt.getXz());
		a2[0] = Integer.parseInt(syrkGzdt.getXg());
		a3[0] = Integer.parseInt(syrkGzdt.getZx());
		labels[0] = "实有人口";
		a1[1] = Integer.parseInt(sydwGzdt.getXz());
		a2[1] = Integer.parseInt(sydwGzdt.getXg());
		a3[1] = Integer.parseInt(sydwGzdt.getZx());
		labels[1] = "实有单位";
		a1[2] = Integer.parseInt(syfwGzdt.getXz());
		a2[2] = Integer.parseInt(syfwGzdt.getXg());
		a3[2] = Integer.parseInt(syfwGzdt.getZx());
		labels[2] = "实有房屋";
		a1[3] = Integer.parseInt(zdryGzdt.getXz());
		a2[3] = 0;
		a3[3] = Integer.parseInt(zdryGzdt.getZx());
		labels[3] = "重点人员";
		a1[4] = Integer.parseInt(bzdzGzdt.getXz());
		a2[4] = Integer.parseInt(bzdzGzdt.getXg());;
		a3[4] = Integer.parseInt(bzdzGzdt.getZx());
		labels[4] = "标准地址";
		//冒泡
        int[] arr = new int[]{a1[0],a1[1],a1[2],a1[3],a1[4],a2[0],a2[1],a2[2],a2[3],a1[4],a3[0],a3[1],a3[2],a3[3],a3[4]};
        int max=0;
        for(int i = 0;i<arr.length;i++){
    		if(max<arr[i]){
				max = arr[i];
			}
        }
		map.put("type", "bar");
		map.put("colour", "#e96a3b");
		map.put("font-size", 12);
		map.put("values", a1 );
		map2.put("type", "bar");
		map2.put("colour", "#4dc2ed");
		map2.put("font-size",12);
		map2.put("values", a2 );
		map3.put("type", "bar");
		map3.put("colour", "#85d021");
		map3.put("font-size",12);
		map3.put("values", a3 );
		//柱子特效
		Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "grow-up");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		map.put("on-show", xtc);
		//柱子特效
		Map<String, Object> xtc1 = new HashMap<String, Object>();
		xtc1.put("type", "grow-up");//柱子特效（随即特效）
		xtc1.put("cascade", 1);
		xtc1.put("delay", 0.5);//设置柱子的颜色
		map2.put("on-show", xtc1);
		//柱子特效
		Map<String, Object> xtc2 = new HashMap<String, Object>();
		xtc2.put("type", "grow-up");//柱子特效（随即特效）
		xtc2.put("cascade", 1);
		xtc2.put("delay", 0.5);//设置柱子的颜色
		map3.put("on-show", xtc2);
		Object [] elements = {map,map2,map3};
		Map<String, Object> xaxisMap = new HashMap<String, Object>();
        xaxisMap.put("labels",labels);
        xaxisMap.put("size", 12);
        Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
        xaxisMap2.put("labels", xaxisMap);
		//最大值最小值
		Map<String,Object> y_axisMap = new HashMap<String,Object>();
		y_axisMap.put("max", max+max/15);
		y_axisMap.put("steps",max/15);
		y_axisMap.put("min", 0);
        //生成JSON格式
		returnMap.put("elements", elements);
		returnMap.put("y_axis", y_axisMap);
		returnMap.put("x_axis", xaxisMap2);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}

	@Override
	public List<GzjkTemp> queryListByLevel(String dwdm, Integer level,String ywlx) {
		String dwdmValue="";
		if("00000000".equals(dwdm.substring(4, dwdm.length()))){
			dwdmValue = dwdm.substring(0,4);
		}else if("000000".equals(dwdm.substring(6, dwdm.length()))){
			dwdmValue = dwdm.substring(0,6);
		}else if("0000".equals(dwdm.substring(8, dwdm.length()))){
			dwdmValue = dwdm.substring(0,8);
		}
		return gzjkDao.queryListByLevel(dwdmValue,level,ywlx);
	}

	@Override
	public Gzdt querySyrkGzdt(Gzdt Gzdt) {
		// TODO Auto-generated method stub
		return gzjkDao.querySyrkGzdt(Gzdt);
	}

	@Override
	public Gzdt querySyfwGzdt(Gzdt Gzdt) {
		// TODO Auto-generated method stub
		return gzjkDao.querySyfwGzdt(Gzdt);
	}

	@Override
	public Gzdt querySydwGzdt(Gzdt Gzdt) {
		// TODO Auto-generated method stub
		return gzjkDao.querySydwGzdt(Gzdt);
	}

	@Override
	public Gzdt queryBzdzGzdt(Gzdt Gzdt) {
		// TODO Auto-generated method stub
		return gzjkDao.queryBzdzGzdt(Gzdt);
	}

	@Override
	public Gzdt queryZdryGzdt(Gzdt Gzdt) {
		// TODO Auto-generated method stub
		return gzjkDao.queryZdryGzdt(Gzdt);
	}

	@Override
	public Gzdt queryCount(Gzdt Gzdt) {
		Gzdt syrkGzdt = querySyrkGzdt(Gzdt);
		Gzdt syfwGzdt = querySyfwGzdt(Gzdt);
		Gzdt sydwGzdt = querySydwGzdt(Gzdt);
		Gzdt bzdzGzdt = queryBzdzGzdt(Gzdt);
		Gzdt zdryGzdt = queryZdryGzdt(Gzdt);
		Gzdt gzdt = new Gzdt();
		int xz = Integer.valueOf(syrkGzdt.getXz())+ Integer.valueOf(syfwGzdt.getXz())+Integer.valueOf(sydwGzdt.getXz())+Integer.valueOf(bzdzGzdt.getXz())+Integer.valueOf(zdryGzdt.getXz());//新增总数
		int xg = Integer.valueOf(syrkGzdt.getXg())+ Integer.valueOf(syfwGzdt.getXg())+Integer.valueOf(sydwGzdt.getXg())+Integer.valueOf(bzdzGzdt.getXg());//修改总数
		int zx = Integer.valueOf(syrkGzdt.getZx())+ Integer.valueOf(syfwGzdt.getZx())+Integer.valueOf(sydwGzdt.getZx())+Integer.valueOf(bzdzGzdt.getZx())+Integer.valueOf(zdryGzdt.getZx());//注销总数
		gzdt.setXz(xz+"");
		gzdt.setXg(xg+"");
		gzdt.setZx(zx+"");
		Dttjb dttjb = queryAllCount(Gzdt);
		if(dttjb !=null){
			gzdt.setSyrkCount(dttjb.getRk_cnt());
			gzdt.setSydwCount(dttjb.getDw_cnt());
			gzdt.setSyfwCount(dttjb.getFw_cnt());
			gzdt.setBzdzCount(dttjb.getBzdz_cnt());
			gzdt.setZdryCount(dttjb.getZdry_cnt());
		}else{
			gzdt.setSyrkCount("0");
			gzdt.setSydwCount("0");
			gzdt.setSyfwCount("0");
			gzdt.setBzdzCount("0");
			gzdt.setZdryCount("0");
		}
		
		return gzdt;
	}

	public Dttjb queryAllCount(Gzdt Gzdt) {
		// TODO Auto-generated method stub
		return gzjkDao.queryAllCount(Gzdt);
	}
		
	
}
