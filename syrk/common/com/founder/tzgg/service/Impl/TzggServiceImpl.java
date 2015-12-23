package com.founder.tzgg.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.tzgg.bean.Node;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.bean.Sys_Tzggb;
import com.founder.tzgg.dao.TzggDao;
import com.founder.tzgg.service.TzggService;

@Service("tzggService")
@Transactional
public class TzggServiceImpl extends BaseService implements TzggService {
	
	@Resource(name = "tzggDao")
	private TzggDao tzggDao;
	
	@Resource
	private SysMessageDao sysMessageDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, Sys_Tzggb entity) {
		// TODO Auto-generated method stub
		return tzggDao.queryList(page, entity);
	}

	@Override
	public Sys_Tzggb queryById(Sys_Tzggb entity) {
		// TODO Auto-generated method stub
		return tzggDao.queryById(entity);
	}

	@Override
	public void save(Sys_Tzggb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		
		saveBmByArray(entity,sessionBean);
		tzggDao.save(entity);
	}

	@Override
	public void update(Sys_Tzggb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setUpdateProperties(entity, sessionBean);
		if("0".equals(entity.getFbztdm())){
			//发布时，向系统发消息
			sendMessage(entity,sessionBean);
		}
		updateBmByArray(entity,sessionBean);
		
		tzggDao.update(entity);
	}

	@Override
	public void delete(Sys_Tzggb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setCrossoutProperties(entity, sessionBean);
		tzggDao.delete(entity);
	}

	public List<Node> queryOrg(Org_Organization organization) {
		
		List<Node> nodeList = new ArrayList<Node>();
		/*List<Org_Organization> orgList = tzggDao.queryOrg(organization);
		if(orgList!=null && orgList.size() >0){
			for(Org_Organization o:orgList){
				Node node = new Node();
				node.setId(o.getId());
				node.setText(o.getOrgname());
				node.setState("open");
				node.setIconCls("icon-group");
				nodeList.add(node);
			}*/
		//}
		
		return nodeList;
	}

	public void sendMessage(Sys_Tzggb tzgg,SessionBean sessionBean){
		SysMessage entity =new SysMessage();
		String ywurl ="";
		if(tzgg.getZjtk()!=null && !"".equals(tzgg.getZjtk()) && tzgg.getZjtk().equals("0")&& tzgg.getLjym()!=null && tzgg.getLjym()!=""){
			ywurl =tzgg.getLjym();
		}else{
			ywurl=tzgg.getId();
		}
		
		entity.setFsr(sessionBean.getUserName());
		entity.setFsrdm(sessionBean.getUserId());
		entity.setFsrssdw(sessionBean.getUserOrgName());
		entity.setFsrssdwdm(sessionBean.getUserOrgCode());
			
		if("1".equals(tzgg.getTzgglx())){
			//通知
			entity.setXxlb("3");//消息类别
			String xxnr ="通知公告【 "+tzgg.getGgbt()+"】 发布，请知晓。";
			entity.setXxnr(xxnr);
		}else if("2".equals(tzgg.getTzgglx())){
			//通报
			entity.setXxlb("4");//消息类别
			String xxnr ="通报公告【 "+tzgg.getGgbt()+"】 发布，请知晓。";
			entity.setXxnr(xxnr);
		}
		entity.setYwurl(ywurl);//业务url
		entity.setFssj(DateUtils.getSystemDateTimeString());
		entity.setDxzt("0");
		entity.setSfck("0");
		entity.setXxbt(tzgg.getGgbt());
		//这个接收单位的组织机构，字符串，按照逗号分隔；
		//String orgCodeString = tzgg.getJsbmid();
		//boolean inculdeSubOrg = true;
		//boolean noRepeatUser =true;
		//重复的用户不再添加，子部门的不再添加 
		//sysMessageDao.saveMessageByOrg(entity, orgCodeString, inculdeSubOrg, noRepeatUser);
		//后期修改的用sql的方式保存数据
		//String fsbmid = tzgg.getJsbmid()+","+sessionBean.getUserOrgCode();
		String fsbmid = tzgg.getJsbmid();
		
		//
		forOrgCode(entity,fsbmid);
		//insertMessage(entity,fsbmid);
	}
	
	/**
	 * 循环保存部门子表
	 * @param tzgg
	 * @param sessionBean
	 */
	public void saveBmByArray(Sys_Tzggb tzgg,SessionBean sessionBean){
		
		String[] jsbmid = tzgg.getJsbmid().split(",");
		String[] jsbm = tzgg.getJsbm().split(",");
		if(jsbmid.length>0 &&jsbm.length>0 ){
			for(int i=0;i<jsbmid.length;i++){
				Sys_Tzggb tzgg1 =  new Sys_Tzggb();
				setSaveProperties(tzgg1, sessionBean);
				tzgg1.setId(UUID.create());
				tzgg1.setTzggid(tzgg.getId());
				tzgg1.setJsbm(jsbm[i]);
				tzgg1.setJsbmid(jsbmid[i]);
				
				tzggDao.saveBm(tzgg1);
			}
		}
		
	}
	/**
	 * 循环更新 部门子表
	 * @param tzgg
	 * @param sessionBean
	 */
	public void updateBmByArray(Sys_Tzggb tzgg,SessionBean sessionBean){
		
		tzggDao.deleteBm(tzgg);
		
		String[] jsbmid = tzgg.getJsbmid().split(",");
		String[] jsbm = tzgg.getJsbm().split(",");
		if(jsbmid.length>0 &&jsbm.length>0 ){
			for(int i=0;i<jsbmid.length;i++){
				Sys_Tzggb tzgg1 =  new Sys_Tzggb();
				setSaveProperties(tzgg1, sessionBean);
				
				tzgg1.setId(UUID.create());
				tzgg1.setTzggid(tzgg.getId());
				tzgg1.setJsbm(jsbm[i]);
				tzgg1.setJsbmid(jsbmid[i]);
				
				tzggDao.saveBm(tzgg1);
			}
		}
		
	}

	@Override
	public List<Sys_Tzggb> queryByTzggId(Sys_Tzggb entity) {
		// TODO Auto-generated method stub
		return tzggDao.queryByTzggId(entity);
	}

	@Override
	public List<ZpfjFjxxb> queryFj(ZpfjFjxxb zpfjFjxxb) {
		// TODO Auto-generated method stub
		return tzggDao.queryFj(zpfjFjxxb);
	}

	@Override
	public void insertMessage(SysMessage entity, String fsbmid) {
		// TODO Auto-generated method stub
		tzggDao.insertMessage(entity, fsbmid);
	}
	
	/**
	 * 循环保存消息;
	 * @param entity
	 * @param fsbmid
	 */
	public void forOrgCode(SysMessage entity,String fsbmid){
		if(fsbmid.indexOf(",")>0){
			String[] fsbmidArray = fsbmid.split(",");
			int len = fsbmidArray.length;
			for(int i=0;i<len;i++){
				tzggDao.insertMessage2(entity, fsbmidArray[i]);
			}
		}else{
			tzggDao.insertMessage2(entity, fsbmid);
		}
		
		
	}
	
}
