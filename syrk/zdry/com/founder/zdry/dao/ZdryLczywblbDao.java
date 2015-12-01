package com.founder.zdry.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryYwspb;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.dao.LczywblbDao.java]  
 * @ClassName:    [LczywblbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午7:27:10]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午7:27:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryLczywblbDao")
public class ZdryLczywblbDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(新增)
	 * @param @param ZdryLczywblb    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdryLczywblb ZdryLczywblb){
		super.insertForObject("ZdryLczywblb.save", ZdryLczywblb);
	}
	 
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryLczywblb    返回类型
	 * @throws
	 */
	public ZdryLczywblb queryById(String id){
		return (ZdryLczywblb) queryForObject("ZdryLczywblb.queryById", id);
	}
	
	/***
	 * 
	 * @Title: update
	 * @Description: TODO(更新)
	 * @param @param ZdryLczywblb    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(ZdryLczywblb ZdryLczywblb){
		super.update("ZdryLczywblb.updateZdryLczywblb", ZdryLczywblb);
	}
	
	/***
	 * 
	 * @Title: query
	 * @Description: TODO(通用查找)
	 * @param @param ZdryLczywblb
	 * @param @return    设定文件
	 * @return List<ZdryYwspb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZdryLczywblb> query(ZdryLczywblb ZdryLczywblb){
		return super.queryForList("ZdryLczywblb.query", ZdryLczywblb);
	}
	
}
