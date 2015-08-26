package com.founder.ywxt.factory;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.exception.BussinessException;
import com.founder.ywxt.service.XtTaskService;

/***
 * ****************************************************************************
 * @Package:      [com.founder.ywxt.factory.XtFactory.java]  
 * @ClassName:    [XtFactory]   
 * @Description:  [协同工厂类，生产不同的协同]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-5-29 上午11:08:33]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-29 上午11:08:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("xtFactory")
public class XtFactory {
	
	@Resource(name = "rhflXtServiceImpl")
	private XtTaskService rhflXtServiceImpl;
	@Resource(name = "rkzxXtServiceImpl")
	private XtTaskService rkzxXtServiceImpl;
	@Resource(name = "rylxdhXtServiceImpl")
	private XtTaskService rylxdhXtServiceImpl;
	@Resource(name = "cyrySyrkXtServiceImpl")
	private XtTaskService cyrySyrkXtServiceImpl;
	@Resource(name = "rygzdwXtServiceImpl")
	private XtTaskService rygzdwXtServiceImpl;
	
	
	
	public final String RHFL="常住人口人户分离协同";
	public final String RKZX="人口注销协同";
	public final String RYLXDH="人员联系电话真实性协同";
	public final String RYGZDW="人员工作单位协同";
	public final String CYRYSYRK="从业人员实有人口协同";
	
	public XtTaskService factory(String swich){
		if(RHFL.equals(swich)){
			return rhflXtServiceImpl;
		}else if(RKZX.equals(swich)){
			return rkzxXtServiceImpl;
		}
		else if(RYLXDH.equals(swich)){
			return rylxdhXtServiceImpl;
		}
		else if(RYGZDW.equals(swich)){
			return rygzdwXtServiceImpl;
		}
		else if(CYRYSYRK.equals(swich)){
			return cyrySyrkXtServiceImpl;
		}
		else{
			throw new BussinessException("没有找到协同类型");
		}
	}
}
