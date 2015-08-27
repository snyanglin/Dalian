package com.founder.zdrygl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryGzb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryGzbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.until.ZdryUntil;
import com.founder.zdrygl.vo.ZdryZdryzbVO;

@Service("zdryZdryzbService")
public class ZdryZdryzbServiceImpl extends BaseService implements
		ZdryZdryzbService {

	@Resource(name="zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	
	@Resource(name="zdryGzbDao")
	private ZdryGzbDao zdryGzbDao;
	
	@Resource(name="ZdryUntil")
	private ZdryUntil zdryUntil;
	
	@Override
	public List<ZdryZdryzb> queryZdryByRyid(String ryid) {
		return zdryZdryzbDao.queryZdryByRyid(ryid);
	}

	@Override 
	public List<ZdryZdryzb> queryZdryBySyrkid(String syrkid) {
		return zdryZdryzbDao.queryZdryBySyrkid(syrkid);
	}
	
	@Override
	public void insert(ZdryZdryzb entity,SessionBean sessionBean) {
		super.setSaveProperties(entity, sessionBean);
		zdryZdryzbDao.insert(entity);
	}

	@Override
	public void update(ZdryZdryzb entity,SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryZdryzbDao.update(entity);
	}

	@Override
	public void delete(ZdryZdryzb entity,SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryZdryzbDao.delete(entity);
	}

	@Override
	public ZdryZdryzb queryById(String id) {
		return (ZdryZdryzb) zdryZdryzbDao.queryById(id);
	}

	@Override
	public EasyUIPage queryList(ZdryZdryzbVO entity, EasyUIPage page) {
		return zdryZdryzbDao.queryManagerList(entity, page);
	}
	
	@Override
	public List queryList(String ryid){
		
		return zdryZdryzbDao.queryZdryVoByRyid(ryid);
	}
	
	@Override
	public List querySgafList(String ryid){
		
		return zdryZdryzbDao.querySgafZdryVOByRyid(ryid);
	}

	@Override
	public ZdryZdryzb queryBySyrkidAndgllx(String syrkid, String gllx) {
		return zdryZdryzbDao.queryBySyrkidAndgllx(syrkid,gllx);
	}

	@Override
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, ZdryZdryzbVO entity){
		return zdryZdryzbDao.queryDwDzOnPT(page, entity);
	}
	@Override
	public List<ZdryZdryzb> queryZdrylxdmByGmsfhm(String zjhm){
		return zdryZdryzbDao.queryZdrylxdmByGmsfhm(zjhm);
	}

	@Override
	public Integer queryForCount(String syrkId) {
		return zdryZdryzbDao.queryCount(syrkId);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: queryKlglx</p>
	 * <p>Description: 根据已列管类型查可列管类型，取交集</p>
	 * @param ylglxStr
	 * @return
	 * @see com.founder.zdrygl.service.ZdryZdryzbService#queryKlglx(java.lang.String)
	 */
	@Override
	public String queryKlglx(String ylglxStr){
		String[] ylglxAry=ylglxStr.split(",");		
		String queryStr;
		String[] queryAry;
		ZdryGzb zdryGzb;
		Map map=new HashMap();
		for(int i=0;i<ylglxAry.length;i++){
			zdryGzb=zdryGzbDao.queryByZdrylx(ylglxAry[i],zdryUntil.querySYSConfig());
			if(zdryGzb!=null){
				queryStr=zdryGzb.getTslglx();//同时可列管的类型
				if(queryStr==null) continue;
				queryAry=queryStr.split(",");
				if(i>0){//已查询有可列管的类型
					if(map.size()==0)//已不能再列管其他类型
						break;
					if(queryAry.length>0){
						Map tempMap=new HashMap();//临时存储可列管类型的交集
						for(int j=0;j<queryAry.length;j++){
							if(map.get(queryAry[j])!=null){//可列管此类型，是交集
								tempMap.put(queryAry[j], true);//该类型可列管
							}
						}
						
						//保存最新可列管的类型
						map=tempMap;
					}
				}else{//还没有可列管类型，所以本次查询结果全都可列管
					for(int j=0;j<queryAry.length;j++){	
						map.put(queryAry[j],true);//该类型可列管										
					}
				}
				
				
			}
		}		
		String klglxStr=map.keySet().toString();
		klglxStr=klglxStr.replaceAll(",", "|");
		klglxStr=klglxStr.replaceAll(" ", "");
		return klglxStr.substring(1,klglxStr.length()-1);
	}
	
	public String queryKcglx(String zdrylxdm){
		ZdryGzb zdryGzb=zdryGzbDao.queryByZdrylx(zdrylxdm,zdryUntil.querySYSConfig());
		if(zdryGzb!=null) return zdryGzb.getCglx();
		return null;
	}
}
