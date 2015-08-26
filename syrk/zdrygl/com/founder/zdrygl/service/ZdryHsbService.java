package com.founder.zdrygl.service;

import java.util.List;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryHsb;
import com.founder.zdrygl.bean.ZdryHsbZdls;
import com.founder.zdrygl.bean.ZdryYwspb;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.service.ZdryHsbService.java]
 * @ClassName: [ZdryHsbService]
 * @Description: [核实逻辑处理]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-17 下午7:42:23]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-17 下午7:42:23，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public interface ZdryHsbService {
	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO(核实列表查询)
	 * @param @param entity
	 * @param @param page
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryHsb entity, EasyUIPage page,
			SessionBean sessionBean);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryHsb 返回类型
	 * @throws
	 */
	public ZdryHsb queryById(String id);

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(跟新对象)
	 * @param @param zdryHsb 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void update(ZdryHsb zdryHsb, SessionBean sessionBean);

	/***
	 * 
	 * @Title: saveHsCg
	 * @Description: TODO(核实撤管，发送审批
	 * @param @param id
	 * @param @param zdryYwspb 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveHsCg(ZdryHsb zdryHsb, ZdryYwspb zdryYwspb,
			SessionBean sessionBean);

	/***
	 * 
	 * @Title: saveApproval
	 * @Description: TODO(保存审批状态 )
	 * @param @param zdryYwspb
	 * @param @param messageid
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveApproval(ZdryYwspb zdryYwspb, String messageid,
			SessionBean sessionBean);

	/**
	 * 核实转递保存<br>
	 * 
	 * @param entity
	 */
	public void saveHszd(ZdryHsbZdls entity, SessionBean sessionBean);

}
