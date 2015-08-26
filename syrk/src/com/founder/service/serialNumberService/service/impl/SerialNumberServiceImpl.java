/**********************************************************************   
 * <p>文件名：SerialNumberServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-18 上午11:31:05 
 * @history
 * @department：研发部
 *
*/
package com.founder.service.serialNumberService.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.serialNumberService.bean.GgYwgzxxb;
import com.founder.service.serialNumberService.dao.SerialNumberDao;
import com.founder.service.serialNumberService.service.SerialNumberService;

/******************************************************************************
 * @Package:      [com.founder.service.serialNumberService.service.impl.SerialNumberServiceImpl.java]  
 * @ClassName:    [SerialNumberServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-18 上午11:31:05]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-18 上午11:31:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("serialNumberService")
@Transactional
public class SerialNumberServiceImpl extends BaseService implements
		SerialNumberService {
	
	@Resource(name = "serialNumberDao")
	private  SerialNumberDao serialNumberDao;
	
	public void creatSequence(String sequenceName){
		serialNumberDao.creatSequence(sequenceName);
	}
	
	public String getDwbh(	SessionBean sessionBean) {
		String userOrgCode = sessionBean.getUserOrgCode();
		String bh = userOrgCode.substring(0, 4);//组织机构代码前4位
		String dateDate = DateUtils.getSystemDateString();
		String dateYear = dateDate.substring(0,4);//年份4位
		String sequenceName="dw_"+bh;//序列名称规则为dw_加组织机构代码前4位
		GgYwgzxxb ggYwgzxxb =serialNumberDao.queryYwgzxxb("实有单位编号");//业务名称
		String  sequenceNumbe="";
		if(ggYwgzxxb==null){//如果查询不出来，则添加业务规则
			 ggYwgzxxb = new GgYwgzxxb();
			 ggYwgzxxb.setId(UUID.create()); // 生成主键
			 ggYwgzxxb.setYwmc("实有单位编号");
			 ggYwgzxxb.setYwms("实有单位编号生成规则");
			 ggYwgzxxb.setYwxx1(dateYear);
			 ggYwgzxxb.setYwgz("单位编号的要求：组织机构代码前4位+年份4位+8位序号（序号是按照00000001开始生成的），不同的机构代码和年份组装，后面的序号都是从1开始计算。");
			ggYwgzxxb.setYwxx2(sequenceName+",");
			BaseService.setSaveProperties(ggYwgzxxb, sessionBean);
		}
		else{
			try {
				if(!dateYear.equals(ggYwgzxxb.getYwxx1())){//ywxx1储存时间，判断是否跨年是否需要重置Sequence,如果多个Sequence则逻辑有错误
					serialNumberDao.resetSequence(sequenceName);
					ggYwgzxxb.setYwxx1(dateYear);
					ggYwgzxxb.setYwxx2(sequenceName+",");
					serialNumberDao.updateYwgzxxb(ggYwgzxxb);
				}
				sequenceNumbe=serialNumberDao.getSequence(sequenceName).toString();
			} catch (Exception e) {
				//未建立当前部门Sequence,建立Sequence
				e.printStackTrace();
				serialNumberDao.creatSequence(sequenceName);
				sequenceNumbe=serialNumberDao.getSequence(sequenceName).toString();
			}
			 sequenceNumbe = StringUtils.getRightSpecifyString(sequenceNumbe, 8, "0");
		}
		 return bh+=dateYear+sequenceNumbe;
		
		
		
	}

}
