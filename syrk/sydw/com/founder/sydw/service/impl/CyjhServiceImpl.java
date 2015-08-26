package com.founder.sydw.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwcyjcrwxxb;
import com.founder.sydw.bean.Xfdwcccsxxb;
import com.founder.sydw.dao.CyjhDao;
import com.founder.sydw.service.CyjhService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.impl.CyjhServiceImpl.java]  
 * @ClassName:    [CyjhServiceImpl]   
 * @Description:  抽样计划
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-7-6 上午9:28:00]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-6 上午9:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("cyjhService")
@Transactional
public class CyjhServiceImpl extends BaseService  implements CyjhService {
	
	@Resource(name = "cyjhDao")
	private CyjhDao cyjhDao;

	@Override
	public Map<String, Object> queryXfdwlxByJbdwlb(Map<String, Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		String zzxfjdjcrymzjcdws = SystemConfig.getString("zzxfjdjcrymzjcdws");
		map.put("zzxfjdjcrymzjcdws", zzxfjdjcrymzjcdws);
		String jzxfjdjcrymzjcdws = SystemConfig.getString("jzxfjdjcrymzjcdws");
		map.put("jzxfjdjcrymzjcdws", jzxfjdjcrymzjcdws);
		String mngzzs = SystemConfig.getString("mngzzs");
		map.put("mngzzs", mngzzs);
		String mcssjcsjcrys  = SystemConfig.getString("mcssjcsjcrys");
		map.put("mcssjcsjcrys", mcssjcsjcrys);
		List<Map<String,Object>> list = cyjhDao.queryXfdwlxByJbdwlb(param);
		String[]  jgdwlbs = {"zddws","ybdws","jxcss","qtdws"};//1、重点单位，2、一般单位，3、九小场所，4、其他单位
		for(int i=0;i<jgdwlbs.length;i++){
			boolean flag = true;
			if(list!=null&&list.size()>0){
				for(int j=0;j<list.size();j++){
					String jgdwlb = String.valueOf(i+1);
					String objjgdwlb =  (String)list.get(j).get("jgdwlb");
					String val = (String)list.get(j).get("val");
					if(jgdwlb.equals(objjgdwlb)){
						map.put(jgdwlbs[i], val);
						flag = false;
					}
				}
			}
			if(flag){
				map.put(jgdwlbs[i], "0");
			}
		}
		return map;
	}

	@Override
	public void saveXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		String zzxfjdjcrymzjcdws = SystemConfig.getString("zzxfjdjcrymzjcdws");
		String jzxfjdjcrymzjcdws = SystemConfig.getString("jzxfjdjcrymzjcdws");
		String mngzzs = SystemConfig.getString("mngzzs");
		String mcssjcsjcrys  = SystemConfig.getString("mcssjcsjcrys");
		//总数
		Integer zs = (Integer.parseInt(zzxfjdjcrymzjcdws)*Integer.parseInt(entity.getZzjcrs())+Integer.parseInt(jzxfjdjcrymzjcdws)*Integer.parseInt(entity.getJzjcrs()))*Integer.parseInt(mngzzs)/Integer.parseInt(mcssjcsjcrys);
		entity.setZs(String.valueOf(zs));
		//重点数
		double zddwzccdwdbfb = Double.parseDouble(entity.getZddwzccdwdbfb());
		double d = (zs*zddwzccdwdbfb)/100;
		BigDecimal zddws = new BigDecimal(d).setScale(0, BigDecimal.ROUND_HALF_UP);
		entity.setZddws(zddws.toString());
		//非重点数
		Integer fzddws = zs-zddws.intValue();
		entity.setFzddws(String.valueOf(fzddws));
		cyjhDao.saveXfdwcccsxxb(entity, sessionBean);
	}

	@Override
	public void modifyXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean) {
		BaseService.setSaveProperties(entity, sessionBean);
		String zzxfjdjcrymzjcdws = SystemConfig.getString("zzxfjdjcrymzjcdws");
		String jzxfjdjcrymzjcdws = SystemConfig.getString("jzxfjdjcrymzjcdws");
		String mngzzs = SystemConfig.getString("mngzzs");
		String mcssjcsjcrys  = SystemConfig.getString("mcssjcsjcrys");
		//总数
		Integer zs = (Integer.parseInt(zzxfjdjcrymzjcdws)*Integer.parseInt(entity.getZzjcrs())+Integer.parseInt(jzxfjdjcrymzjcdws)*Integer.parseInt(entity.getJzjcrs()))*Integer.parseInt(mngzzs)/Integer.parseInt(mcssjcsjcrys);
		entity.setZs(String.valueOf(zs));
		//重点数
		double zddwzccdwdbfb = Double.parseDouble(entity.getZddwzccdwdbfb());
		double d = (zs*zddwzccdwdbfb)/100;
		BigDecimal zddws = new BigDecimal(d).setScale(0, BigDecimal.ROUND_HALF_UP);
		entity.setZddws(zddws.toString());
		//非重点数
		Integer fzddws = zs-zddws.intValue();
		entity.setFzddws(String.valueOf(fzddws));
		cyjhDao.modifyXfdwcccsxxb(entity, sessionBean);
	}

	@Override
	public void deleteXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean) {
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setXt_zxbz("1");
		cyjhDao.deleteXfdwcccsxxb(entity, sessionBean);
	}

	@Override
	public EasyUIPage queryXfdwcccsxxbForPage(EasyUIPage page, Xfdwcccsxxb entity) {
		return cyjhDao.queryXfdwcccsxxbForPage(page, entity);
	}

	@Override
	public Xfdwcccsxxb queryXfdwcccsxxb(Xfdwcccsxxb entity) {
		return cyjhDao.queryXfdwcccsxxb(entity);
	}

	@Override
	public void modifyDwcyjcrwxxb(Dwcyjcrwxxb entity, SessionBean sessionBean) {
		cyjhDao.modifyDwcyjcrwxxb(entity, sessionBean);
	}

	@Override
	public EasyUIPage queryDwcyjcrwxxbForPage(EasyUIPage page, Dwcyjcrwxxb entity) {
		return cyjhDao.queryDwcyjcrwxxbForPage(page, entity);
	}

	@Override
	public void saveDwcyjcrwxxb(Dwcyjcrwxxb entity, SessionBean sessionBean) {
		cyjhDao.saveDwcyjcrwxxb(entity, sessionBean);
	}

	@Override
	public List<Dwcyjcrwxxb> queryDwcyjcrwxxbsByRwid(Map<String, Object> param) {
		return cyjhDao.queryDwcyjcrwxxbsByRwid(param);
	}
}
