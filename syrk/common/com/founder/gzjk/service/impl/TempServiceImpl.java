package com.founder.gzjk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import com.founder.gzjk.dao.TempDao;
import com.founder.gzjk.service.TempService;
import com.founder.gzjk.vo.LogGzjltjb;

@Service("tempService")
public class TempServiceImpl extends BaseService implements TempService {
	
	@Resource(name = "tempDao")
	private TempDao tempDao;

	@Override
	public LogGzjltjb querySingle(LogGzjltjb entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 更新工作记录统计表(插入|更新)
	 */
	@Override
	public void updateGzjl(String id, String type, String businessType, SessionBean sessionBean) {
		LogGzjltjb entity = new LogGzjltjb();
		//部门id
		entity.setBmid(sessionBean.getUserOrgCode());
		//业务id
		if("syrk".equals(businessType)){
			entity.setYwid("实有人口");
		}else if("zdry".equals(businessType)){
			entity.setYwid("重点人员");
		}else if("sydw".equals(businessType)){
			entity.setYwid("实有单位");
		}else if("cyry".equals(businessType)){
			entity.setYwid("从业人员");
		}else if("syfw".equals(businessType)){
			entity.setYwid("实有房屋");
		}else if("czfw".equals(businessType)){
			entity.setYwid("出租房屋");
		}
		entity.setRq(DateUtils.getSystemDateString());
		LogGzjltjb temp = tempDao.querySingle(entity);
		if(temp != null){//已存在
			if("add".equals(type)){//新增
				Long xzsl = temp.getXzsl() != null ? temp.getXzsl() : 0;
				temp.setXzsl(xzsl + 1);
			}else if("delete".equals(type)){//注销
				Long zxsl = temp.getZxsl() != null ? temp.getZxsl() : 0;
				temp.setZxsl(zxsl + 1);
			}
			setUpdateProperties(temp, sessionBean);
			tempDao.update("LogGzjltjb.update", temp);
		}else{//不存在
			if("add".equals(type)){//新增
				entity.setXzsl(Long.parseLong("1"));
				entity.setZxsl(Long.parseLong("0"));
			}else if("delete".equals(type)){//注销
				entity.setXzsl(Long.parseLong("0"));
				entity.setZxsl(Long.parseLong("1"));
			}
			entity.setId(UUID.create());
			setSaveProperties(entity, sessionBean);
			tempDao.insert("LogGzjltjb.insert", entity);
		}
	}

}
