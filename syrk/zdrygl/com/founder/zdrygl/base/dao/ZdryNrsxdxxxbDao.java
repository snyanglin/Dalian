package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryNrsxdxxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryNrsxdxxxbDao.java]  
 * @ClassName:    [ZdryNrsxdxxxbDao]   
 * @Description:  [纳入视线对象DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月9日 下午4:36:11]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月9日 下午4:36:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryNrsxdxxxbDao")
public class ZdryNrsxdxxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdryNrsxdxxxb sqsb = (ZdryNrsxdxxxb)zdry;
		super.insert("ZdryNrsxdxxxb.save", sqsb);
	}

	@Override
	public void update(Zdry zdry) {
		ZdryNrsxdxxxb sqsb = (ZdryNrsxdxxxb)zdry;
		super.insert("ZdryNrsxdxxxb.update", sqsb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdryNrsxdxxxb sqsb = (ZdryNrsxdxxxb)zdry;
		super.insert("ZdryNrsxdxxxb.delete", sqsb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdryNrsxdxxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdryNrsxdxxxb.queryViewByMap", queryMap);
	}
	
	/**
	 * 
	 * @Title: queryViewList
	 * @Description: TODO(查询最近的 maxNum 条数据用于显示)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryNrsxdxxxb>    返回类型
	 * @throw
	 */
	public List<ZdryNrsxdxxxb> queryViewList(Map<String, Object> map) {
		List<ZdryNrsxdxxxb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryPsjdb.queryViewList", map);
			}
		}
		return list;
	}

}
