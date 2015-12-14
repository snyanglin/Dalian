package com.founder.gzjk.romcache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.founder.gzjk.dao.GzjkDao;
import com.founder.gzjk.vo.CountBean;
import com.founder.gzjk.vo.GzjkTemp;
import com.founder.service.socketMessage.SendWebSocket;

@Component
public class SydwRamCache {

	// 储存工作动态的最近记录 包含总记录
	private static Map<String,String[]> zzjgList = new HashMap<String,String[]>();
	private static Map<String,CountBean> gzjkMapContList = new HashMap<String,CountBean>();
	
	@Resource(name = "gzjkDao")
	private GzjkDao gzjkDao;

	/**
	 * 
	 * @Title: init2
	 * @Description: TODO(系统初始化方法，设置组织构树与初始化数据)
	 * @param @param map    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void init2(Map<String,String[]> map){
		gzjkMapContList = gzjkDao.querySydwOrgAll();
		zzjgList = map;
	/*	for(String key: gzjkMapContList.keySet()){
			gzjkDao.insertSydwTop20(key);
			
		}*/
	}
	
	
	/**
	 *  增加新的实有人口修改信息
	 * @param ryid
	 * @param type
	 */
	public void addGzjkList(String id, String type) {
		GzjkTemp gzjkTemp = gzjkDao.queryGzjkSydwById(id);
		if(gzjkTemp != null){
			gzjkTemp.setBdlx("add".equals(type)?"0":"update".equals(type)?"1":"2");
//			updateListDate(gzjkTemp , type);
//			ProcessingResults(gzjkTemp);
			gzjkDao.insertLSB(gzjkTemp);
			ProcessingResults(gzjkTemp);
		}
	}
	
	

	/**
	 * 
	 * @Title: finGzjkXjCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param bmid
	 * @param @return    设定文件
	 * @return List<CountBean>    返回类型
	 * @throws
	 */
	public static Map<String,Object> finGzjkXjCount(String bmid){
		String [] temp  = zzjgList.get(bmid);
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> dwList = new ArrayList<String>();
		List<CountBean> list = new ArrayList<CountBean>();
		CountBean cb = null;
		for (int i = 0; i < temp.length; i++) {
			try{
				cb = gzjkMapContList.get(temp[i]);
				if(cb != null){
					list.add(cb);
					dwList.add(temp[i]);
				}
			}catch(Exception e){}
		}
		map.put("countList", list);
		map.put("dwList", dwList);
		
		return map;
	}
	
	
	
	/**
	 * 
	 * @Title: findGzjkCount
	 * @Description: TODO(取当前单位总数)
	 * @param @param bmid
	 * @param @return    设定文件
	 * @return CountBean    返回类型
	 * @throws
	 */
	public static CountBean findGzjkCount(String bmid) {
		CountBean countBean = (CountBean) gzjkMapContList.get(bmid);
		if (countBean != null) {
			return countBean;
		} else {
			return new CountBean();
		}
	}



	// 处理查询结果
	public void ProcessingResults(GzjkTemp gzjkTemp) {
		/*JSONObject  messageJson = new JSONObject();
		messageJson.element("type","1");
		messageJson.element("entity",gzjkTemp);
		Map coultMap = new HashMap();                           
		
		String returnString=gzjkTemp.getGxfxjdm()+","+gzjkTemp.getGxpcsdm()+","+gzjkTemp.getGxzrqdm()+",210200000000";
		coultMap.put("sendType", "3");
		coultMap.put("sendCode", returnString);
		coultMap.put("sendMsg",messageJson);
		coultMap.put("callback","BackFunc");
		SendWebSocket sendWebSocket = new SendWebSocket();
		sendWebSocket.shendMessage(coultMap);*/
		
		

		if (gzjkTemp != null) {

			CountBean countBean;

			if ("2".equals(gzjkTemp.getBdlx())) {
				countBean = (CountBean) gzjkMapContList.get("210200000000");
				if(countBean != null){
					countBean.setCancellCont(countBean.getCancellCont() + 1);
					countBean.setCount(countBean.getCount()-1);
				}
				countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxfxjdm());
				if(countBean != null){
					countBean.setCancellCont(countBean.getCancellCont() + 1);
					countBean.setCount(countBean.getCount()-1);
				}
				countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxpcsdm());
				if(countBean != null){
					countBean.setCancellCont(countBean.getCancellCont() + 1);
					countBean.setCount(countBean.getCount()-1);
				}
				countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxzrqdm());
				if(countBean != null){
					countBean.setCancellCont(countBean.getCancellCont() + 1);
					countBean.setCount(countBean.getCount()-1);
				}

			} else {
				if ("1".equals(gzjkTemp.getBdlx())) {
					countBean = (CountBean) gzjkMapContList.get("210200000000");
					if(countBean != null)
					   countBean.setEditCount(countBean.getEditCount() + 1);
					countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxfxjdm());
					if(countBean != null)
						countBean.setEditCount(countBean.getEditCount() + 1);
					
					countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxpcsdm());
					if(countBean != null)
						countBean.setEditCount(countBean.getEditCount() + 1);

					countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxzrqdm());
					if(countBean != null)
						countBean.setEditCount(countBean.getEditCount() + 1);

				} else {
					countBean = (CountBean) gzjkMapContList.get("210200000000");
					if(countBean != null){
						countBean.setAddCount(countBean.getAddCount() + 1);
						countBean.setCount(countBean.getCount()+1);
					}
					countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxfxjdm());
					if(countBean != null){
						countBean.setAddCount(countBean.getAddCount() + 1);
						countBean.setCount(countBean.getCount()+1);
					}
					countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxpcsdm());
					if(countBean != null){
						countBean.setAddCount(countBean.getAddCount() + 1);
						countBean.setCount(countBean.getCount()+1);
					}
					countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxzrqdm());
					if(countBean != null){
						countBean.setAddCount(countBean.getAddCount() + 1);
						countBean.setCount(countBean.getCount()+1);
					}
				}
			}
		}
	}


	


	
	
	/**
	 * 
	 * @Title: setZero
	 * @Description: TODO(清除当日统计数)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void setZero(){
		for(CountBean value : gzjkMapContList.values()){
			value.setAddCount(0);
			value.setCancellCont(0);
			value.setEditCount(0);
		}
	}
	
}
