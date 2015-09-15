package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.bean.ZdryZdrylxylbdyb;
import com.founder.zdrygl.bean.Zdrylxylbdyb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdrylxylbdybDao.java]  
 * @ClassName:    [ZdrylxylbdybDao]   
 * @Description:  [重点人员类型DAO，新的重点人员类型由于添加了区域划分，所以不再使用字典，并且由于不同区域重点人员类型代码不同，因此采用分组来区分大类属于什么类型，存什么表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月20日 上午9:58:43]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月20日 上午9:58:43，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdrylxylbdybDao")
public class ZdrylxylbdybDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: query
	 * @Description: TODO(查询具体的类型对象)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdrylxylbdyb    返回类型
	 * @throws
	 */
	public Zdrylxylbdyb query(Zdrylxylbdyb entity) {
		return (Zdrylxylbdyb) super.queryForObject("Zdrylxylbdyb.query", entity);
	}		
	public Zdrylxylbdyb query(String lbdm,String qydm) {
		Zdrylxylbdyb entity=new Zdrylxylbdyb();
		entity.setLbdm(lbdm);
		entity.setQydm(qydm);
		return (Zdrylxylbdyb) super.queryForObject("Zdrylxylbdyb.query", entity);
	}
	
	
	
	/**
	 * 
	 * @Title: queryListByQydm
	 * @Description: 查询当前区域下的可列管一级类型
	 * @param @param qydm
	 * @param @return    设定文件
	 * @return List<ZdryZdrylxylbdyb>    返回类型
	 * @throws
	 */
	public List<ZdryZdrylxylbdyb> queryListByQydm(String qydm){
		return queryForList("Zdrylxylbdyb.queryListByQydm", qydm);
	}
	
	/**
	 * 
	 * @Title: queryChildByQydm
	 * @Description: 查询当前区域下的子类型列表
	 * @param @param qydm
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	public List queryChildByQydm(String qydm,String lbdm_p){
		Map map=new HashMap();
		map.put("QYDM", qydm);
		map.put("LBDM_P", lbdm_p);
		return queryForList("Zdrylxylbdyb.queryChildByQydm", map);
	}

}

