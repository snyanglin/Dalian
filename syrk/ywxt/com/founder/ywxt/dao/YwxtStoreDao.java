package com.founder.ywxt.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.ywxt.bean.YwxtYwxtCdxxb;

/****
 * ****************************************************************************
 * @Package:      [com.founder.ywxt.dao.YwxtYwxtCdxxbDao.java]  
 * @ClassName:    [YwxtYwxtCdxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午2:37:32]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午2:37:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ywxtStoreDao")
public class YwxtStoreDao extends BaseDaoImpl {

	public void storeYwxtxxb(String id) {
		insert("YwxtStore.storeYwxtxxb", id);
	}
	
	public void storeCyryxxb(String id) {
		insert("YwxtStore.storeCyryxxb", id);
	}
	
	public void physicalDeleteYwxtxxb(String id){
		delete("YwxtStore.physicalDeleteYwxtxxb", id);
	}
	
	public void physicalDeleteCyryxxb(String id){
		delete("YwxtStore.physicalDeleteCyryxxb", id);
	}

}
