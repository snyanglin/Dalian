package com.founder.shhxxcj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.EmEmployees;
import com.founder.shhxxcj.dao.EmEmployeesDao;
import com.founder.shhxxcj.service.EmEmployeesService;
import com.founder.sydw_dl.bean.Cyryxxb;
import com.founder.sydw_dl.service.CyryxxbService;
@Service
@Transactional
public class EmEmployeesServiceImpl implements
		EmEmployeesService {

	@Resource
	private EmEmployeesDao emEmployeesDao;
	@Resource
	private CyryxxbService cyryxxbService;
	@Override
	public EasyUIPage queryList(EmEmployees entity, EasyUIPage page,
			SessionBean sessionBean) {

		return this.emEmployeesDao.queryList(entity, page);
	}

	@Override
	public void update(EmEmployees entity, SessionBean sessionBean) {
		this.emEmployeesDao.update(entity);
	}

	@Override
	public EmEmployees queryById(String id) {
		
		return this.emEmployeesDao.queryById(id);
	}

	@Override
	public void saveCyryhs(Cyryxxb entity,String emEmployeeId, SessionBean sessionBean) {
		
        String cyryid=this.cyryxxbService.add(entity, sessionBean);
        EmEmployees employee=this.emEmployeesDao.queryById(emEmployeeId);
        employee.setCyryid(cyryid);
        employee.setHszt("1");//设置成已核实
        this.emEmployeesDao.update(employee);
             
	}

}
