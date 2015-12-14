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
public class RamCache {

	
	private static Map<String,String[]> zzjgList = new HashMap<String,String[]>();

	private static Map<String,CountBean> gzjkMapContList = new HashMap<String,CountBean>();
	

	@Resource(name = "gzjkDao")
	private GzjkDao gzjkDao;


	
//	public void init2(){
//		gzjkMapContList = gzjkDao.queryOrgAll();
//		for(String key: gzjkMapContList.keySet()){
//			gzjkMapList.put(key, gzjkDao.queryTop20(key));
//		}
//	}
	
	/**
	 * 
	 * @Title: init2
	 * @Description: TODO(绯荤粺鍒濆鍖栨柟娉曪紝璁剧疆缁勭粐鏋勬爲涓庡垵濮嬪寲鏁版嵁)
	 * @param @param map    璁惧畾鏂囦欢
	 * @return void    杩斿洖绫诲瀷
	 * @throws
	 */
	public void init2(Map<String,String[]> map){
		gzjkMapContList.putAll(gzjkDao.queryOrgAll());
		zzjgList = map;
		/*for(String key: gzjkMapContList.keySet()){
			gzjkDao.insertTop20(key);
			
		}*/
	}
	
	/**
	 * 
	 * @Title: finGzjkXjCount
	 * @Description: TODO(鑾峰彇涓嬩竴绾у崟浣嶇粺璁￠泦鍚�
	 * @param @param bmid
	 * @param @return    璁惧畾鏂囦欢
	 * @return List<CountBean>    杩斿洖绫诲瀷
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
	 * @Description: TODO(鍙栧綋鍓嶅崟浣嶆�鏁�
	 * @param @param bmid
	 * @param @return    璁惧畾鏂囦欢
	 * @return CountBean    杩斿洖绫诲瀷
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
	 *  澧炲姞鏂扮殑瀹炴湁浜哄彛淇敼淇℃伅
	 * @param ryid
	 * @param type
	 */
	public void addGzjkList(String ryid, String type,String orgcode) {
		String level="";
		String orgcodeValue="";
		if(orgcode !=null && !"".equals(orgcode)){
			String dwdmValue="";
			if("000000".equals(orgcode.substring(6, orgcode.length()))){
				orgcodeValue = orgcode.substring(0,6);
				level="0";
			}else if("0000".equals(orgcode.substring(8, orgcode.length()))){
				orgcodeValue = orgcode.substring(0,8);
				level="1";
			}else{
				orgcodeValue = orgcode;
				level="2";
			}
		}
		GzjkTemp gzjkTemp = gzjkDao.queryGzjkByRyid(ryid,orgcodeValue,level);
		if(gzjkTemp != null){
			gzjkTemp.setBdlx("add".equals(type)?"0":"update".equals(type)?"1":"2");
			gzjkDao.insertLSB(gzjkTemp);
			processingResults(gzjkTemp);
		}
	}

	/**
	 * 
	 * @Title: processingResults
	 * @Description: TODO(鏇存柊缁熻鏁伴噺)
	 * @param @param gzjkTemp    璁惧畾鏂囦欢
	 * @return void    杩斿洖绫诲瀷
	 * @throws
	 */
	public void processingResults(GzjkTemp gzjkTemp){
		
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
			CountBean countBean ;
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
			} else if ("1".equals(gzjkTemp.getBdlx())) {
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
				countBean = (CountBean)  gzjkMapContList.get(gzjkTemp.getGxfxjdm());
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
	
	/**
	 * 
	 * @Title: setZero
	 * @Description: TODO(娓呴櫎褰撴棩缁熻鏁�
	 * @param     璁惧畾鏂囦欢
	 * @return void    杩斿洖绫诲瀷
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
