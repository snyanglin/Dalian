package com.founder.tzgg.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.EasyUIPage;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.tzgg.bean.Node;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.bean.Sys_Tzggb;

@TypeAnnotation("通知公告")
public interface TzggService {

	
	public EasyUIPage queryList(EasyUIPage page, Sys_Tzggb entity);
	@MethodAnnotation(value = "查询通知公告", type = logType.query)
	public Sys_Tzggb queryById(Sys_Tzggb entity);
	@MethodAnnotation(value = "新增通知公告", type = logType.insert)
	public void save(Sys_Tzggb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "更新通知公告", type = logType.update)
	public void update(Sys_Tzggb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "注销通知公告", type = logType.delete)
	public void delete(Sys_Tzggb entity, SessionBean sessionBean);
	public List<Sys_Tzggb> queryByTzggId(Sys_Tzggb entity);
	//public List<Node> queryOrg(Org_Organization organization);
	public List<ZpfjFjxxb> queryFj(ZpfjFjxxb zpfjFjxxb);
	public void insertMessage(SysMessage entity,String fsbmid);
}
