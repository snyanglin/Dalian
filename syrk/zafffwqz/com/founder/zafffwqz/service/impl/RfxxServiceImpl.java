package com.founder.zafffwqz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.ZaffRfcyxxb;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.dao.RfxxDao;
import com.founder.zafffwqz.service.RfxxService;
@Service("rfxxService")
@Transactional
public class RfxxServiceImpl extends BaseService implements RfxxService {
	@Resource(name = "rfxxDao")
	private RfxxDao rfxxDao;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public EasyUIPage queryRf(EasyUIPage page, ZaffRfxxb entity) {
		return rfxxDao.queryRf(page, entity);
	}

	@Override
	public void insertRfxx(ZaffRfxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		//一次保存时，要把参与人员也保存进去;
		setSaveProperties(entity, sessionBean);
		rfxxDao.insertRfxx(entity);
		//联系电话变更提醒
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", entity.getFffzrid());
		map.put("lxdh", entity.getFfzrrlxdh());
		map.put("lxdhlxdm", "1");
		map.put("lxfsColName", "lxfs");
		map.put("tableName", "rk_rylxfszb");
		map.put("ywmc", "【人防信息登记】");
		sysMessageDao.lxdhBgTx(map, sessionBean, false);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ryid", entity.getFfzrrid());
//		map.put("lxdh", entity.getFfzrrlxdh());
//		map.put("ywmc", "【人防信息登记】");
//		sysMessageDao.lxdhBgTx(map, sessionBean, false);

		
	}

	@Override
	public ZaffRfxxb queryRfxxById(ZaffRfxxb entity) {
		return rfxxDao.queryRfxxById(entity);
	}

	@Override
	public int updateRfxx(ZaffRfxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		//联系电话变更提醒
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", entity.getFffzrid());
		map.put("lxdh", entity.getFfzrrlxdh());
		map.put("lxdhlxdm", "1");
		map.put("lxfsColName", "lxdh");
		map.put("tableName", "dw_cyryxxb");
		map.put("idColName", "id");
		map.put("idColValue", entity.getId());
		map.put("ywmc", "【人防信息登记】");
		sysMessageDao.lxdhBgTx(map, sessionBean, false);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ryid", entity.getFfzrrid());
//		map.put("lxdh", entity.getFfzrrlxdh());
//		map.put("ywmc", "【人防信息登记】");
//		sysMessageDao.lxdhBgTx(map, sessionBean, false);
		return rfxxDao.updateRfxx(entity);
	}

	@Override
	public int deleteRfxx(ZaffRfxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		return rfxxDao.deleteRfxx(entity);
	}

	@Override
	public void saveRfcyxx(ZaffRfcyxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		rfxxDao.saveRfcyxx(entity);
	}

	@Override
	public int updateRfcyxx(ZaffRfcyxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return rfxxDao.updateRfcyxx(entity);
	}

	@Override
	public int deleteRfcyxx(ZaffRfcyxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		return rfxxDao.deleteRfcyxx(entity);
	}

	@Override
	public ZaffRfcyxxb queryRfcyxxById(ZaffRfcyxxb entity) {
		return rfxxDao.queryRfcyxxById(entity);
	}

	@Override
	public EasyUIPage queryRfcyxx(EasyUIPage page, ZaffRfcyxxb entity) {
		return rfxxDao.queryRfcyxx(page, entity);
	}

	@Override
	public void saveRfcyxx(List<ZaffRfcyxxb> entity, SessionBean sessionBean,String id) {
		if(entity.size()>0){
			for(int i=0;i<entity.size();i++){
				entity.get(i).setRfid(id);
				setSaveProperties(entity.get(i), sessionBean);
				saveRfcyxx(entity.get(i),sessionBean);
			}
		}
		
	}

	@Override
	public void deleteRfcyxx(List<ZaffRfcyxxb> entity, SessionBean sessionBean) {
		if(entity.size()>0){
			for(int i=0;i<entity.size();i++){
				setCrossoutProperties(entity.get(i), sessionBean);
				deleteRfcyxx(entity.get(i),sessionBean);
			}
		}
	}

	@Override
	public void updateRfcyxx(List<ZaffRfcyxxb> entity, SessionBean sessionBean) {
		if(entity.size()>0){
			for(int i=0;i<entity.size();i++){
				setUpdateProperties(entity.get(i), sessionBean);
				updateRfcyxx(entity.get(i),sessionBean);
			}
		}
	}

	@Override
	public void insertRfxx(ZaffRfxxb entity, SessionBean sessionBean,
			List<ZaffRfcyxxb> insertList) {
		String id =  UUID.create();
		entity.setId(id);
		//一次保存时，要把参与人员也保存进去;
		setSaveProperties(entity, sessionBean);
		saveRfcyxx(insertList,sessionBean,id);		
		rfxxDao.insertRfxx(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getFffzrid(), entity.getFfzrrlxdh(), sessionBean);
		this.ryRylxfsxxbService.saveLxdh(entity.getFffzrid(), entity.getFfzzlxdh(), sessionBean);
	}

	@Override
	public void updateRfxx(ZaffRfxxb entity, SessionBean sessionBean,
			List<ZaffRfcyxxb> insertList) {
		saveRfcyxx(insertList,sessionBean,entity.getId());
		updateRfxx(entity,sessionBean);
	}

	@Override
	public void updateRfxx(ZaffRfxxb entity, SessionBean sessionBean,
			List<ZaffRfcyxxb> insertList, List<ZaffRfcyxxb> deleteList) {
		saveRfcyxx(insertList,sessionBean,entity.getId());
		deleteRfcyxx(deleteList,sessionBean);
		updateRfxx(entity,sessionBean);
		this.ryRylxfsxxbService.saveLxdh(entity.getFffzrid(),entity.getFfzrrlxdh(), sessionBean);
		this.ryRylxfsxxbService.saveLxdh(entity.getFffzrid(),entity.getFfzzlxdh(), sessionBean);
	}

	@Override
	public void updateRfxxAndDE(ZaffRfxxb entity, SessionBean sessionBean,
			List<ZaffRfcyxxb> deleteList) {
		deleteRfcyxx(deleteList,sessionBean);
		updateRfxx(entity,sessionBean);
	}
}
