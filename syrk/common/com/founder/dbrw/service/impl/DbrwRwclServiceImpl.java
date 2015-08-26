package com.founder.dbrw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwfkb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.dao.DbrwRwclDao;
import com.founder.dbrw.service.DbrwRwclService;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;


@Service("dbrwRwclService")
@Transactional
public class DbrwRwclServiceImpl extends BaseService implements DbrwRwclService {

	@Resource(name = "dbrwRwclDao")
	private DbrwRwclDao dbrwRwclDao;
	
	
	@Override
	public DbrwDbrwb queryDbrwb(DbrwDbrwb entity) {
		return dbrwRwclDao.queryDbrwb(entity);
	}

	@Override
	public EasyUIPage queryDbrwsjmxb(DbrwDbrwsjmxb dbrwDbrwsjmxb,SessionBean sessionBean,EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "dbfklxdm";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		dbrwDbrwsjmxb.setSszrqdm(sessionBean.getUserOrgCode());
		map.put("dbrwDbrwsjmxb", dbrwDbrwsjmxb);
		page.setTotal(dbrwRwclDao.queryDbrwsjmxbCount(map));
		page.setRows(dbrwRwclDao.queryDbrwsjmxb(map));
		return page;
	}

	public DbrwDbrwfkb getSaveDbrwDbrwfkb(DbrwDbrwfkb dbrwDbrwfkb,SessionBean sessionBean){
		
		DbrwDbrwsjmxb dbrwDbrwsjmxb = new DbrwDbrwsjmxb();
		dbrwDbrwsjmxb.setDbrwid(dbrwDbrwfkb.getDbrwid());
		dbrwDbrwsjmxb.setSszrqdm(sessionBean.getUserOrgCode());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dbrwDbrwsjmxb", dbrwDbrwsjmxb);
		dbrwDbrwfkb.setId(UUID.create());
		dbrwDbrwfkb.setRwzsl(Long.parseLong(dbrwRwclDao.queryDbrwsjmxbCount(map).toString()));
		dbrwDbrwfkb.setWcrwzsl(1l);
		dbrwDbrwfkb.setSdhssl(1l);
		dbrwDbrwfkb.setFksj(DateUtils.getSystemDateTimeString());
		dbrwDbrwfkb.setFkbmdm(sessionBean.getUserOrgCode());
		dbrwDbrwfkb.setFkbmmc(sessionBean.getUserOrgName());
		setSaveProperties(dbrwDbrwfkb, sessionBean);
		return dbrwDbrwfkb;
	}
	
	
	public DbrwDbrwfkb getUpdataDbrwDbrwfkb(DbrwDbrwfkb dbrwDbrwfkb,SessionBean sessionBean){
		dbrwDbrwfkb.setWcrwzsl(dbrwDbrwfkb.getWcrwzsl()+1);
		dbrwDbrwfkb.setSdhssl(dbrwDbrwfkb.getSdhssl()+1);
		dbrwDbrwfkb.setFkbmdm(sessionBean.getUserOrgCode());
		dbrwDbrwfkb.setFkbmmc(sessionBean.getUserOrgName());
		setUpdateProperties(dbrwDbrwfkb, sessionBean);
		return dbrwDbrwfkb;
	}

	@Override
	public void saveFk(DbrwDbrwsjmxb entity,SessionBean sessionBean) {
		//更改DBRW_DBRWFKB信息
		DbrwDbrwfkb dbrwDbrwfkb = new DbrwDbrwfkb();
		dbrwDbrwfkb.setDbrwid(entity.getDbrwid());
		dbrwDbrwfkb.setFkbmdm(sessionBean.getUserOrgCode());
		dbrwDbrwfkb = dbrwRwclDao.queryDbrwDbrwfkb(dbrwDbrwfkb);
		
		if(dbrwDbrwfkb!=null){
			if(null != entity.getDbfklxdm() && !entity.getDbfklxdm().equals("2")){
				dbrwRwclDao.updateDbrwfkb(getUpdataDbrwDbrwfkb(dbrwDbrwfkb,sessionBean));
			}
		}else{
			dbrwDbrwfkb = new DbrwDbrwfkb();
			dbrwDbrwfkb.setDbrwid(entity.getDbrwid());
			dbrwRwclDao.saveDbrwfkb(getSaveDbrwDbrwfkb(dbrwDbrwfkb,sessionBean));
		}
		
		entity.setSjclsj(DateUtils.getSystemDateTimeString());
		entity.setSjclr(sessionBean.getUserName());
		entity.setSjclrid(sessionBean.getUserId());
		entity.setDbfklxdm("2");
		//修改反馈后不为完成督办 begin
		//entity.setSfwcdm("1");
		setUpdateProperties(entity, sessionBean);
		dbrwRwclDao.saveFK(entity);
	}

	@Override
	public List<Map> getFiledTitle(String dbmxID) {
		Map filedMap = dbrwRwclDao.getFiledTitle(dbmxID);
		List<Map> mapList = new ArrayList();
		String filedName = (String)filedMap.get("DBSJXBTM");
		String filedRatio = (String)filedMap.get("DBSJXBTBL");
		
		String[] filedNameArray = null;
		String[] filedRatioArray = null;
		
		if( null != filedName && !filedName.equals("")){
			filedNameArray = filedName.split("#");
		}
		
		if( null != filedRatio && !filedRatio.equals("")){
			filedRatioArray = filedRatio.split("#");
		}
		
		if(null != filedNameArray && filedNameArray.length > 0){
			Map mapTemp;
			for( int i = 0 ; i < filedNameArray.length ; i++ ){
				mapTemp = new HashMap();
				mapTemp.put("filedName", filedNameArray[i]);
				if(null != filedRatioArray && filedRatioArray.length > 0){
					if(filedRatioArray.length >= (i + 1) ){
						mapTemp.put("filedRatio", filedRatioArray[i]);
					}else{
						mapTemp.put("filedRatio", "10");
					}
				}
				mapList.add(mapTemp);
			}
		}
		return mapList;
	}

	@Override
	public DbrwDbrwsjmxb queryDbrwDbrwsjmxb(DbrwDbrwsjmxb entity) {
		return dbrwRwclDao.queryDbrwDbrwsjmxb(entity);
	}
	
	
	/**
	 * 完成任务处理
	 * @return
	 */
	@Override
	public void Complete(DbrwDbrwb entity,SessionBean sessionBean,String MessageID) {
		Map Coultmap = new HashMap();
		Coultmap.put("id", entity.getId());
		Coultmap.put("dbmxid", entity.getDbmxid());
		Coultmap.put("sszrqdm", sessionBean.getUserOrgCode());
		Coultmap.put("czlx", "2");
		Coultmap.put("czr", sessionBean.getUserName());
		Coultmap.put("czrid",sessionBean.getUserId());
		dbrwRwclDao.Complete(Coultmap);
		dbrwRwclDao.ChangeMessage(MessageID);
	}
	
	/**
	 * 刷新处理情况
	 * @return
	 */
	@Override
	public void Refresh(DbrwDbrwb entity,SessionBean sessionBean) {
		Map Coultmap = new HashMap();
		Coultmap.put("id", entity.getId());
		Coultmap.put("dbmxid", entity.getDbmxid());
		Coultmap.put("sszrqdm", sessionBean.getUserOrgCode());
		Coultmap.put("czlx", "1");
		Coultmap.put("czr", sessionBean.getUserName());
		Coultmap.put("czrid",sessionBean.getUserId());
		dbrwRwclDao.Refresh(Coultmap);
	}

	
	/**
	 * 获取图标展示数据
	 * @return
	 */
	@Override
	public Map<String, Object> getFigData(DbrwDbrwsjmxb dbrwDbrwsjmxb,SessionBean sessionBean) {
		Map<String, Object> CoultMap = new HashMap<String, Object>();
		dbrwDbrwsjmxb.setSszrqdm(sessionBean.getUserOrgCode());
		CoultMap.put("dbrwDbrwsjmxb",dbrwDbrwsjmxb);
		int rwCount = dbrwRwclDao.queryDbrwsjmxbCount(CoultMap);
		int rwWcCount = dbrwRwclDao.queryDbrwsjmxbWcCount(CoultMap);
		int rwWwcCont = ( rwCount - rwWcCount );
		int jgNumber = 0;
		
		if(rwCount < 5){
			jgNumber = 1;
		}else{
			jgNumber = (rwCount / 5);
		}
			
		
		int[] ShowFig = {rwWcCount,rwWwcCont};
		
		
		//
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		Object[] elements = new Object[1];
		
		Map<String,Object> elementsMap = new HashMap<String,Object>();
		
		String[] colourStr = {"#C4D318","#ff0000"};
		
		int[][] values = new int[1][2];
		
		int[] value = {rwWcCount,rwWwcCont};
		
		values[0] = value;
		
		Map[] keysArray = new Map[2];
		
		
		Map<String,Object> keysMap = new HashMap<String,Object>();
		keysMap.put("colour", "#C4D318");
		keysMap.put("text", "已处理");
		keysMap.put("font-size", "12");
		keysArray[0] = keysMap;
		
		keysMap = new HashMap<String,Object>();
		keysMap.put("colour", "#ff0000");
		keysMap.put("text", "未处理");
		keysMap.put("font-size", "12");
		keysArray[1] = keysMap;
		
		elementsMap.put("type", "bar_stack");
		elementsMap.put("colours",colourStr);
		elementsMap.put("values", values);
		elementsMap.put("keys",keysArray);
		elementsMap.put("tip", "已完成: [#val#] 总数：[#total#]");
		
		elements[0] = elementsMap;
		
		Map<String,Object> titleMap = new HashMap<String,Object>();
		titleMap.put("text","完成情况图");
		titleMap.put("style", "{font-size: 20px; color: #F24062; text-align: center;}");
		
		
		Map<String,Object> x_axisMap = new HashMap<String,Object>();
		Map<String,Object> labelsMap = new HashMap<String,Object>();
		String[] labels = new String[1];
		labels[0] = "";
		x_axisMap.put("labels", labelsMap);
		labelsMap.put("labels", labels);
		
		Map<String,Object> y_axisMap = new HashMap<String,Object>();
		y_axisMap.put("min", 0);
		y_axisMap.put("max", rwCount);
		y_axisMap.put("steps",jgNumber);
		
		
		Map<String,Object> tooltipMap = new HashMap<String,Object>();
		tooltipMap.put("mouse", 2);
		
		
		json.put("elements", elements);
		json.put("title", titleMap);
		json.put("x_axis", x_axisMap);
		json.put("y_axis", y_axisMap);
		json.put("tooltip", tooltipMap);
		
		return json;
	}

}
