package com.founder.syrkgl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkLdrkxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkLdrkxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.SyrkLdrkxxbServiceImpl.java]  
 * @ClassName:    [SyrkLdrkxxbServiceImpl]   
 * @Description:  [流动人口业务服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-9 上午10:23:45]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-9 上午10:23:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
@Service("syrkLdrkxxbService")
public class SyrkLdrkxxbServiceImpl extends BaseService implements
		SyrkLdrkxxbService {

	@Resource(name="syrkLdrkxxbDao")
	private SyrkLdrkxxbDao syrkLdrkxxbDao;
	
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Resource
	private SysMessageDao sysMessageDao;
	
	@Override
	public SyrkLdrkxxb queryById(String id) {
		return syrkLdrkxxbDao.queryById(id);
	}

	@Override
	public void save(SyrkLdrkxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		syrkLdrkxxbDao.insert(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
	}

	@Override
	public void update(SyrkLdrkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		//判断 如果户籍地址描述被修改了，要给其他地的实有人口民警发消息
		RyRyjbxxb ryjbxxb=this.ryRyjbxxbService.queryById(entity.getRyid());
		String oldHjd_ms=StringUtils.isBlank(ryjbxxb.getHjd_dzms())?"":ryjbxxb.getHjd_dzms();
		String newHjd_ms=StringUtils.isBlank(entity.getHjd_dzms())?"":entity.getHjd_dzms();
		//新户籍地址和旧户籍地址都不等，则发消息给其他责任区的民警提醒户籍地址已变更
		if(!newHjd_ms.equals(oldHjd_ms)){
			//判断这个人是否在其他地区是实有人口  是的话 给其他责任区发消息提醒
			SyrkSyrkxxzb syrkzb=new SyrkSyrkxxzb();
			syrkzb.setCyzjdm(entity.getCyzjdm());
			syrkzb.setZjhm(entity.getZjhm());
			List<SyrkSyrkxxzb> syrkZbs=this.syrkxxzbService.queryList(syrkzb);
			if(syrkZbs!=null && syrkZbs.size()>0){
				for(SyrkSyrkxxzb zb:syrkZbs){
					//不给自己发
					if(!entity.getId().equals(zb.getId())){
						SysMessage message = new SysMessage();
						message.setFsr(sessionBean.getUserName());
						message.setFsrdm(sessionBean.getUserId());
						message.setFssj(DateUtils.getSystemDateTimeString());
						message.setFsrssdw(sessionBean.getUserOrgName());
						message.setFsrssdwdm(sessionBean.getUserOrgCode());
						if(StringUtils.isBlank(newHjd_ms)){
							message.setXxnr(sessionBean.getUserOrgName()+"民警"+sessionBean.getUserName()+"删除了实有人口"+entity.getXm()+"的户籍地址描述");
	
						}else{
							message.setXxnr(sessionBean.getUserOrgName()+"民警"+sessionBean.getUserName()+"将实有人口"+entity.getXm()+"的户籍地址描述修改为"+entity.getHjd_dzms());

						}
						message.setXxbt("流动人口户籍地址描述修改提醒");
						message.setXxlb("1");
						sysMessageDao.saveMessageByOrgCondition(message, zb.getGxzrqdm(), "01", "50", "04", false, false);

					
					}
				}
			}
			
			
		}
		
		syrkLdrkxxbDao.update(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
		ryRyjbxxbService.synchronizeRyjbxxb(entity, sessionBean);
		if (!StringUtils.isBlank(entity.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(),
					sessionBean);
		}
	}

	@Override
	public void delete(SyrkLdrkxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		syrkLdrkxxbDao.delete(entity);
		syrkxxzbService.synchronizeCrossoutSyrkxxzb(entity);
	}


}
