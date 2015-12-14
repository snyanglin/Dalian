package com.founder.aqff.service;

import java.util.List;
import com.founder.aqff.bean.Aqffrfryxxb;
import com.founder.aqff.bean.AqffRfxxb;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
/******************************************************************************
 * @Package:      [com.founder.aqff.service.RfxxbService]  
 * @ClassName:    [RfxxbService]   
 * @Description:  [人防信息Service]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-2 上午2:12:09]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 上午2:12:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("安全防范-人防信息")
public interface RfxxbService {
	
	@MethodAnnotation(value = "查询组织下的全部人防信息", type = logType.query)
	public EasyUIPage queryRf(EasyUIPage page, String lrrbmid);
	@MethodAnnotation(value = "人防信息添加", type = logType.insert)
	public void insertRfxx(AqffRfxxb entity, SessionBean sessionBean);
	//@MethodAnnotation(value = "新增安全防范-人防和人员信息", type = logType.insert)
	//public void insertRfxx(AqffRfxxb entity, SessionBean sessionBean,List<Aqffrfryxxb> insertList);
	@MethodAnnotation(value = "通过id查询人防信息", type = logType.query)
	public AqffRfxxb queryRfxxById(AqffRfxxb entity);
	@MethodAnnotation(value = "人防信息修改", type = logType.update)
	public int updateRfxx(AqffRfxxb entity, SessionBean sessionBean);
	//@MethodAnnotation(value = "更改安全防范-人防和人员信息", type = logType.update)
	//public void updateRfxx(AqffRfxxb entity, SessionBean sessionBean,List<Aqffrfryxxb> insertList);
	//@MethodAnnotation(value = "更改安全防范-人防和人员信息", type = logType.update)
	//public void updateRfxxAndDE(AqffRfxxb entity, SessionBean sessionBean,List<Aqffrfryxxb> deleteList);
	//@MethodAnnotation(value = "更改安全防范-人防和人员信息", type = logType.update)
	//public void updateRfxx(AqffRfxxb entity, SessionBean sessionBean,List<Aqffrfryxxb> insertList,List<Aqffrfryxxb> deleteList);
	@MethodAnnotation(value = "人防信息删除", type = logType.delete)
	public int deleteRfxx(AqffRfxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "人防信息模糊查询", type = logType.query)
	public EasyUIPage queryMHRf(EasyUIPage page, AqffRfxxb entity);
	@MethodAnnotation(value = "人防信息精确查询", type = logType.query)
	public EasyUIPage queryJQRf(EasyUIPage page, AqffRfxxb entity);
	@MethodAnnotation(value = "人防成员信息添加", type = logType.insert)
	public void saveRfcyxx(Aqffrfryxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "人防成员信息修改", type = logType.update)
	public int updateRfcyxx(Aqffrfryxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "人防成员信息删除", type = logType.delete)
	public int deleteRfcyxx(Aqffrfryxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "通过id查询人防成员信息", type = logType.query)
	public Aqffrfryxxb queryRfcyxxById(Aqffrfryxxb entity);
	@MethodAnnotation(value = "查看页面查询人防成员信息", type = logType.query)
	public EasyUIPage queryRfcyxx(EasyUIPage page, Aqffrfryxxb entity);
	//public void saveRfcyxx(List<Aqffrfryxxb> entity, SessionBean sessionBean,String id);
	//public void deleteRfcyxx(List<Aqffrfryxxb> entity, SessionBean sessionBean);
	//public void updateRfcyxx(List<Aqffrfryxxb> entity, SessionBean sessionBean);
	@MethodAnnotation(value = "通过证件号码查询人防成员信息", type = logType.query)
	public int queryRfcyxxByZjhm(Aqffrfryxxb entity);
	@MethodAnnotation(value = "删除人防信息关联人员", type = logType.delete)
	public void deleteRfryxx(AqffRfxxb entity);
	@MethodAnnotation(value = "人防信息重复性查询", type = logType.query)
	public int queryRfxxCF(AqffRfxxb entity);
	@MethodAnnotation(value = "人防人员单位查询", type = logType.query)
	public Aqffrfryxxb queryRfcyxxByZjhmForDW(Aqffrfryxxb entity);
}
