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
public class SyfwRamCache {

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
		gzjkMapContList = gzjkDao.querySyfwOrgAll();
		zzjgList = map;
		gzjkDao.insertAllTop20();
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
	
	
	/**
	 *  增加新的实有人口修改信息
	 * @param ryid
	 * @param type
	 */
	public void addGzjkList(String id, String type) {
		GzjkTemp gzjkTemp = gzjkDao.queryGzjkSyfwById(id);
		if(gzjkTemp != null){
			gzjkTemp.setBdlx("add".equals(type)?"0":"update".equals(type)?"1":"2");
//			updateListDate(gzjkTemp , type);
//			ProcessingResults(gzjkTemp);
			gzjkDao.insertLSB(gzjkTemp);
			ProcessingResults(gzjkTemp);
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
			//大连市公安局
			countBean = (CountBean) gzjkMapContList.get("210200000000");
			if(countBean != null){
				if("1".equals(gzjkTemp.getDwmc())){
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
						if(countBean.getAddCount() > 0){
						   countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
					}else if("1".equals(gzjkTemp.getBdlx())){
						countBean.setAddCount(countBean.getAddCount()+1);//出租房屋总数
						countBean.setCount(countBean.getCount());//修改时不变
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}else{
						countBean.setCount(countBean.getCount()+1);//房屋总数
						countBean.setEditCount(countBean.getEditCount() + 2);//今日新增房屋
						countBean.setAddCount(countBean.getAddCount() + 1);//出租房屋数据
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
					}
				}else{
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
					}else if("1".equals(gzjkTemp.getBdlx())){
						if(countBean.getAddCount()>0){
							countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
						countBean.setCount(countBean.getCount());//修改时不变
					}else{
						countBean.setCount(countBean.getCount()+1);
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}
				}
			}
			
			
			//分县局
			countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxfxjdm());
			if(countBean != null){
				if("1".equals(gzjkTemp.getDwmc())){
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
						if(countBean.getAddCount() > 0){
						   countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
					}else if("1".equals(gzjkTemp.getBdlx())){
						countBean.setAddCount(countBean.getAddCount()+1);//出租房屋总数
						countBean.setCount(countBean.getCount());//修改时不变
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}else{
						countBean.setCount(countBean.getCount()+1);//房屋总数
						countBean.setEditCount(countBean.getEditCount() + 2);//今日新增房屋
						countBean.setAddCount(countBean.getAddCount() + 1);//出租房屋数据
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
					}
				}else{
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
					}else if("1".equals(gzjkTemp.getBdlx())){
						if(countBean.getAddCount()>0){
							countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
						countBean.setCount(countBean.getCount());//修改时不变
					}else{
						countBean.setCount(countBean.getCount()+1);
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}
				}
			}
			//派出所
			countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxpcsdm());
			if(countBean != null){
				if("1".equals(gzjkTemp.getDwmc())){
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
						if(countBean.getAddCount() > 0){
						   countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
					}else if("1".equals(gzjkTemp.getBdlx())){
						countBean.setAddCount(countBean.getAddCount()+1);//出租房屋总数
						countBean.setCount(countBean.getCount());//修改时不变
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}else{
						countBean.setCount(countBean.getCount()+1);//房屋总数
						countBean.setEditCount(countBean.getEditCount() + 2);//今日新增房屋
						countBean.setAddCount(countBean.getAddCount() + 1);//出租房屋数据
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
					}
				}else{
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
					}else if("1".equals(gzjkTemp.getBdlx())){
						if(countBean.getAddCount()>0){
							countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
						countBean.setCount(countBean.getCount());//修改时不变
					}else{
						countBean.setCount(countBean.getCount()+1);
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}
				}
			}
			//责任区
			countBean = (CountBean) gzjkMapContList.get(gzjkTemp.getGxzrqdm());
			if(countBean != null){
				if("1".equals(gzjkTemp.getDwmc())){
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
						if(countBean.getAddCount() > 0){
						   countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
					}else if("1".equals(gzjkTemp.getBdlx())){
						countBean.setAddCount(countBean.getAddCount()+1);//出租房屋总数
						countBean.setCount(countBean.getCount());//修改时不变
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
					}else{
						countBean.setCount(countBean.getCount()+1);//房屋总数
						countBean.setEditCount(countBean.getEditCount() + 2);//今日新增房屋
						countBean.setAddCount(countBean.getAddCount() + 1);//出租房屋数据
						countBean.setCancellCont(countBean.getCancellCont() + 1);//今日新增出租房
					}
				}else{
					if("2".equals(gzjkTemp.getBdlx())){//注销是总数减去1
						countBean.setCount(countBean.getCount()-1);
					}else if("1".equals(gzjkTemp.getBdlx())){
						if(countBean.getAddCount()>0){
							countBean.setAddCount(countBean.getAddCount()-1);//出租房屋总数
						}
						countBean.setCount(countBean.getCount());//修改时不变
					}else{
						countBean.setCount(countBean.getCount()+1);
						countBean.setEditCount(countBean.getEditCount() + 1);//今日新增房屋
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
