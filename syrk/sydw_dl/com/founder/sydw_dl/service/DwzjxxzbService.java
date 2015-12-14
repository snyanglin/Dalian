package com.founder.sydw_dl.service;
import java.util.List;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Dwzjb;




@TypeAnnotation("实有单位")
public interface DwzjxxzbService {
	@MethodAnnotation(value = "新增实有单位证件信息", type = logType.insert)
	public void saveZjxx(Dwzjb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "更新实有单位证件信息", type = logType.insert)
	public void updateZjxx(Dwzjb entity, SessionBean sessionBean);
	
	
	@MethodAnnotation(value = "查询单条-人员证件信息", type = logType.query)
	public 	Dwzjb queryZjxx(Dwzjb entity);
	
	public List<Dwzjb> queryDwzjxx(String zjzldm, String zjbh);
}
