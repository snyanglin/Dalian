package com.founder.spsxt.service.impl;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Spjkxt;
import com.founder.spsxt.dao.SpjkxtDao;
import com.founder.spsxt.dao.SpsxtDao;
import com.founder.spsxt.service.SpjkxtService;
@Service("spjkxtService")
@Transactional
public class SpjkxtServiceImpl extends BaseService implements SpjkxtService {

	@Resource(name="spjkxtDao")
	private SpjkxtDao spjkxtDao;
	//摄像头
	@Resource(name="spsxtDao")
	private SpsxtDao spsxtDao;
	@Override
	public void insertSpjkxt(Spjkxt entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		spjkxtDao.insertSpjkxt(entity);
	}
	@Override
	public void updateSpjkxt(Spjkxt entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		spjkxtDao.updateSpjkxt(entity);
	}
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return spjkxtDao.queryList(page, map);
	}
	@Override
	public Spjkxt querySpjkxtByXh(int xh) {
		return spjkxtDao.querySpjkxtByXh(xh);
	}
	
	//删除监控系统Xh删除其关联的摄像头极其系统本身
	@Override
	public String deleteSpjkxtByXh(String xh) {
		// TODO Auto-generated method stub
		//删除摄像头
		int affectedRow1=spsxtDao.deleteSxtByJkxtXh(xh);
		//删除监控系统
		int affectedRow2=spjkxtDao.deleteSpjkxtByXh(xh);
		return affectedRow1+"/"+affectedRow2;
	}
	
	@Override	
	public Integer checkSameName(Map map){
		return spjkxtDao.checkSameName(map);		
	}
	@Override
	public Map<String, String> queryLwsxByXh(String xh){
		Map map = new HashMap();
		map =spjkxtDao.queryLwsxByXh(xh);
		return  map;
	}
}
