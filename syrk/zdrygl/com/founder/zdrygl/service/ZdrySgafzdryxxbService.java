package com.founder.zdrygl.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.vo.ZdrySgafzdryAddVO;

public interface ZdrySgafzdryxxbService {

	public String queryRyidByZdrySgafzdryId(String zdrySgafzdryId);
	
	public ZdrySgafzdryxxb queryById(String id);
	
	public EasyUIPage queryList(ZdrySgafzdryxxb entity, EasyUIPage page);
	
	public void sgafzdryXiaFa(ZdrySgafzdryxxb entity,SessionBean sessionBean);
	
	public void saveAdd(ZdrySgafzdryAddVO addVO,SessionBean sessionBean);
}
