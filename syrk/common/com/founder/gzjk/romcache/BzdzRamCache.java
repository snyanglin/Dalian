package com.founder.gzjk.romcache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.founder.framework.utils.StringUtils;
import com.founder.gzjk.dao.GzjkDao;
import com.founder.gzjk.vo.CountBean;
import com.founder.gzjk.vo.GzjkTemp;
import com.founder.service.socketMessage.SendWebSocket;

@Component
public class BzdzRamCache {
	// 閸屻劌鐡ㄥ銉ょ稊閸斻劍锟介惃鍕付鏉╂垼顔囪ぐ锟介崠鍛儓閹槒顔囪ぐ锟�
	private static Map<String, String[]> zzjgList = new HashMap<String, String[]>();
	
	private static Map<String,List<GzjkTemp>> gzjkMapList = new HashMap<String,List<GzjkTemp>>();

	private static Map<String, CountBean> gzjkMapContList = new HashMap<String, CountBean>();

	private static boolean isInit = false;

	@Resource(name = "gzjkDao")
	private GzjkDao gzjkDao;

	// 婢跺嫮鎮婇弻銉嚄缂佹挻鐏�
	public void ProcessingResults(GzjkTemp gzjkBzdzTemp) {
        
		/*JSONObject  messageJson = new JSONObject();
		messageJson.element("type","1");
		messageJson.element("entity",gzjkBzdzTemp);
		Map coultMap = new HashMap();                           
		
		String returnString=gzjkBzdzTemp.getGxfxjdm()+","+gzjkBzdzTemp.getGxpcsdm()+","+gzjkBzdzTemp.getGxzrqdm()+",210200000000";
		coultMap.put("sendType", "3");
		coultMap.put("sendCode", returnString);
		coultMap.put("sendMsg",messageJson);
		coultMap.put("callback","BackFunc");
		SendWebSocket sendWebSocket = new SendWebSocket();
		sendWebSocket.shendMessage(coultMap);*/
		if (gzjkBzdzTemp != null) {

			CountBean countBean;
			String pcsdm = StringUtils.nullToStr(gzjkBzdzTemp.getGxpcsdm());
			String xtczsj = StringUtils.nullToStr(gzjkBzdzTemp.getXt_cjsj());
			String zhxgsj = StringUtils.nullToStr(gzjkBzdzTemp.getXt_lrsj());
			if (!StringUtils.isBlank(pcsdm) && pcsdm.length() >= 8
					&& !StringUtils.isBlank(xtczsj)
					&& !StringUtils.isBlank(zhxgsj)) {
				if ("2".equals(gzjkBzdzTemp.getBdlx())) {
					countBean = (CountBean) gzjkMapContList.get(pcsdm
							.substring(0, 4) + "00000000");
					if (countBean != null) {
						countBean
								.setCancellCont(countBean.getCancellCont() + 1);
						countBean.setCount(countBean.getCount() - 1);
					}
					countBean = (CountBean) gzjkMapContList.get(pcsdm
							.substring(0, 6) + "000000");
					if (countBean != null) {
						countBean
								.setCancellCont(countBean.getCancellCont() + 1);
						countBean.setCount(countBean.getCount() - 1);
					}
					countBean = (CountBean) gzjkMapContList.get(pcsdm
							.substring(0, 8) + "0000");
					if (countBean != null) {
						countBean
								.setCancellCont(countBean.getCancellCont() + 1);
						countBean.setCount(countBean.getCount() - 1);
					}
				} else {

					if ("1".equals(gzjkBzdzTemp.getBdlx())) {
						countBean = (CountBean) gzjkMapContList.get(pcsdm
								.substring(0, 4) + "00000000");
						if (countBean != null) {
							countBean
									.setEditCount(countBean.getEditCount() + 1);
						}
						countBean = (CountBean) gzjkMapContList.get(pcsdm
								.substring(0, 6) + "000000");
						if (countBean != null) {
							countBean
									.setEditCount(countBean.getEditCount() + 1);
						}
						countBean = (CountBean) gzjkMapContList.get(pcsdm
								.substring(0, 8) + "0000");
						if (countBean != null) {
							countBean
									.setEditCount(countBean.getEditCount() + 1);
						}
					} else {

						countBean = (CountBean) gzjkMapContList.get(pcsdm
								.substring(0, 4) + "00000000");
						if (countBean != null) {
							countBean.setAddCount(countBean.getAddCount() + 1);
							countBean.setCount(countBean.getCount() + 1);
						}
						countBean = (CountBean) gzjkMapContList.get(pcsdm
								.substring(0, 6) + "000000");
						if (countBean != null) {
							countBean.setAddCount(countBean.getAddCount() + 1);
							countBean.setCount(countBean.getCount() + 1);
						}
						countBean = (CountBean) gzjkMapContList.get(pcsdm
								.substring(0, 8) + "0000");
						if (countBean != null) {
							countBean.setAddCount(countBean.getAddCount() + 1);
							countBean.setCount(countBean.getCount() + 1);
						}
					}
				}
			} else {
				gzjkBzdzTemp = null; // 娑撳秶顑侀崥鍫熸蒋娴犲墎娈戦弫鐗堝祦娑撳秴顦甸悶锟�
			}
		}
	}

	/**
	 * 
	 * @Title: init2
	 * @Description: TODO(绯荤粺鍒濆鍖栨柟娉曪紝璁剧疆缁勭粐鏋勬爲涓庡垵濮嬪寲鏁版嵁)
	 * @param @param map 璁惧畾鏂囦欢
	 * @return void 杩斿洖绫诲瀷
	 * @throws
	 */
	public void init2(Map<String, String[]> map) {
		gzjkMapContList.putAll(gzjkDao.queryBzdzOrgAll());
		zzjgList = map;
		/*for (String key : gzjkMapContList.keySet()) {
			gzjkDao.insertTop20(key);
		}*/
	}

	/**
	 * 
	 * @Title: finGzjkXjCount
	 * @Description: TODO(鑾峰彇涓嬩竴绾у崟浣嶇粺璁￠泦鍚�
	 * @param @param bmid
	 * @param @return 璁惧畾鏂囦欢
	 * @return List<CountBean> 杩斿洖绫诲瀷
	 * @throws
	 */
	public static Map<String, Object> finGzjkXjCount(String bmid) {
		String[] temp = zzjgList.get(bmid);
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> dwList = new ArrayList<String>();
		List<CountBean> list = new ArrayList<CountBean>();
		CountBean cb = null;
		for (int i = 0; i < temp.length; i++) {
			try {
				cb = gzjkMapContList.get(temp[i]);
				if (cb != null) {
					list.add(cb);
					dwList.add(temp[i]);
				}
			} catch (Exception e) {
			}
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
	 * @param @return 璁惧畾鏂囦欢
	 * @return CountBean 杩斿洖绫诲瀷
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
	 * 澧炲姞鏂扮殑瀹炴湁浜哄彛淇敼淇℃伅
	 * 
	 * @param ryid
	 * @param type
	 */
	public void addGzjkList(String ryid, String type) {
		GzjkTemp gzjkTemp = gzjkDao.queryGzjkByBzdzid(ryid);
		if (gzjkTemp != null) {
			gzjkTemp.setBdlx("0".equals(type) ? "0"
					: "1".equals(type) ? "1" : "2");
			gzjkDao.insertLSB(gzjkTemp);
			ProcessingResults(gzjkTemp);
		}
	}

	/**
	 * 
	 * @Title: setZero
	 * @Description: TODO(娓呴櫎褰撴棩缁熻鏁�
	 * @param 璁惧畾鏂囦欢
	 * @return void 杩斿洖绫诲瀷
	 * @throws
	 */
	public static void setZero() {
		for (CountBean value : gzjkMapContList.values()) {
			value.setAddCount(0);
			value.setCancellCont(0);
			value.setEditCount(0);
		}
	}
	
	

}
