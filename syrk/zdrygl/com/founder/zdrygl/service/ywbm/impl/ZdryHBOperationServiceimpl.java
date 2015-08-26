package com.founder.zdrygl.service.ywbm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.impl.ZdryQYOperationServiceimpl;
import com.founder.zdrygl.vo.ZdryVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.za.impl.ZdryHBOperationServiceimpl.java]  
 * @ClassName:    [ZdryHBOperationServiceimpl]   
 * @Description:  [环保部门]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015年8月5日 下午2:03:46]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月5日 下午2:03:46，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Service("zdryHBOperationService")
@Transactional
public class ZdryHBOperationServiceimpl extends ZdryQYOperationServiceimpl {
	@Resource(name="zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		ZdryZdryzb zdryZdryzb=vo.getZdryZdryzb();
		//看是否已经被列管过
		List<ZdryZdryzb> ylg=this.zdryZdryzbDao.queryZdryByRyid(zdryZdryzb.getRyid());
		if(ylg!=null &&ylg.size()>0){
			
			throw new BussinessException("此人已被列管为涉环保重点人员，不可重复了列管");
		}
		
		zdryZdryzb.setSfjm("0");// 默认不加密
		zdryZdryzb.setGlzt("1");
		zdryZdryzb.setId(UUID.create());	
		
		//zdryZdryzb.setRyid("开发数据");
		//zdryZdryzb.setSyrkid("未绑定实有人口");
		
		vo.getZdryShbzdryxxb().setId(zdryZdryzb.getId());		
		zdryZdryzb.setGlzt("1");
		zdryZdryzbDao.insert(zdryZdryzb);
		zdryShbzdryxxbDao.save(vo.getZdryShbzdryxxb());
	}
	@Override
	public void saveCg(ZdryVO vo) throws BussinessException {
		// TODO Auto-generated method stub
		
	}
}

