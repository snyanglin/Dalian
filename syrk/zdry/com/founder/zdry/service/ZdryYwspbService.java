package com.founder.zdry.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.vo.ZdryYwspbVo;

/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.service.ZdryYwspbService.java]  
 * @ClassName:    [ZdryYwspbService]   
 * @Description:  [业务审批功能表接口]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-16 下午9:03:58]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-16 下午9:03:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryYwspbService {
	/***
	 * 
	 * @Title: updateZdryYwspb
	 * @Description: TODO根据审批记过修改业务表的业务结果
	 * @param @param zdryYwspb
	 * @param @param sessionBean
	 * @param @param messageid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void  updateZdryYwspb(ZdryYwspb zdryYwspb,SessionBean sessionBean,String messageid);
	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询实体)
	 * @param @param id    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public ZdryYwspb queryById(String id);
	
	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO(审批列表查询)
	 * @param @param entity
	 * @param @param page
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryYwspbVo entity, EasyUIPage page,
			SessionBean sessionBean);
}
