package com.founder.zdrygl.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.vo.ZdryZdryzbVO;

/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryZdryzbService.java]  
 * @ClassName:    [ZdryZdryzbService]   
 * @Description:  [重点人员总表接口]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015年7月29日 下午3:06:01]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年7月29日 下午3:06:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("重点人员总表")
public interface ZdryZdryzbService {

	/**
	 * 
	 * @Title: queryZdryByRyid
	 * @Description: TODO(根据人员ID查询重口)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<ZdryZdryzb>    返回类型
	 * @throws
	 */
	public List<ZdryZdryzb> queryZdryByRyid(String ryid) ;
	/**
	 * 
	 * @Title: queryZdryBySyrkid
	 * @Description: TODO(根据实有人口ID查询重口)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<ZdryZdryzb>    返回类型
	 * @throws
	 */
	public List<ZdryZdryzb> queryZdryBySyrkid(String syrkid) ;
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询重口)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<ZdryZdryzb>    返回类型
	 * @throws
	 */
	public ZdryZdryzb queryById(String id);

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(新增)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<ZdryZdryzb>    返回类型
	 * @throws
	 */
	public void insert(ZdryZdryzb entity,SessionBean sessionBean);
	
	public void update(ZdryZdryzb entity,SessionBean sessionBean);
	
	public void delete(ZdryZdryzb entity,SessionBean sessionBean);
	
	public EasyUIPage queryList(ZdryZdryzbVO entity, EasyUIPage page);
	
	public List queryList(String ryid);
	
	public List querySgafList(String ryid);

	
	public ZdryZdryzb queryBySyrkidAndgllx(String syrkid , String gllx);
	
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, ZdryZdryzbVO entity);
	
	public List<ZdryZdryzb> queryZdrylxdmByGmsfhm(String zjhm);
	
	public Integer queryForCount(String syrkId);
}
