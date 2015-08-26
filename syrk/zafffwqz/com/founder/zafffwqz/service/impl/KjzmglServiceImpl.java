/**********************************************************************   
 * <p>文件名：KjzmglServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-12 下午1:46:35 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.service.BaseService;
import com.founder.service.requestservice.ZtryRequestService;
import com.founder.service.requestservice.ZtryResult;
import com.founder.zafffwqz.bean.KjzmglBean;
import com.founder.zafffwqz.service.KjzmglService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.KjzmglServiceImpl.java]  
 * @ClassName:    [KjzmglServiceImpl]   
 * @Description:  [开具证明服务实现类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-12 下午1:46:35]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-12 下午1:46:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604 
 * @Version:      [v1.0] 
 */
@Service("kjzmglService")
@Transactional
public class KjzmglServiceImpl extends BaseService implements KjzmglService {


	/*
	 * (非 Javadoc)
	 * <p>Title: query</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return 返回结果 key对应资源库类型 value对应查询结果
	 * @see com.founder.zafffwqz.service.KjzmglService#query(com.founder.zafffwqz.bean.KjzmglBean)
	 */
	@RestfulAnnotation(serverId = "",valiField="sfz,zyks",queryField="sfz,zyks")
	@Override
	public Map<String, String[]> query(KjzmglBean entity) {
		Map<String,String[]> m=new HashMap<String, String[]>();
		String[] zyk=entity.getZyks().split("#");
		for(String z:zyk){
			m.put(z, queryInfo(z,entity.getSfz()));
		}
		return m;
	}
	
	/*
	 * @Title: queryInfo
	 * @Description: 根据传入类型查询对应资源库是否存在对应数据
	 * 1全国违法犯罪人员库 2吸毒人员库 3重点人员库 4全国在逃人员库
	 * @param @param type
	 * @param @param sfz
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String[] queryInfo(String type,String sfz){
		switch(Integer.parseInt(type)){
			case 1:
				//TODO
				//等待调用全国违反犯罪人员库
				break;
			case 2:
				//TODO
				//等待调用实有人口提供的吸毒人员库
				break;
			case 3:
				//TODO
				//等待调用实有人口提供的重点人员库
				break;
			case 4:
				ZtryResult ztry=ZtryRequestService.selectZtry(sfz);
				if(ztry!=null)return new String[]{"1",ztry.getXM(),ztry.getHJDSSXQ()};
				break;
		}
		return new String[]{"0","",""};
	}
}
