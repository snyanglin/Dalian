package com.founder.service.attachment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.bean.ZpfjFjxzjlb;

@Repository("zpfjFjxxbDao")
public class ZpfjFjxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZpfjFjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setWjmc(StringUtils.getSqlExpression(entity.getWjmc()));
		map.put("zpfjFjxxb", entity);
		page.setTotal((Integer) queryForObject("ZpfjFjxxb.queryCount", map));
		page.setRows(queryForList("ZpfjFjxxb.queryList", map));
		return page;
	}

	/**
	 * 根据id查询附件<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjFjxxb queryZpfjFjxxbById(String id) {
		return (ZpfjFjxxb) queryForObject("ZpfjFjxxb.queryZpfjFjxxbById", id);
	}

	/**
	 * 新增附件<br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public void saveZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean) {
		insert("ZpfjFjxxb.saveZpfjFjxxb", entity);
	}

	/**
	 * 查询附件ID，唯一附件更新时用 <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public String queryZpfjFjxxbId(String lybm, String lyid) {
		String returnValue = "";
		if (!StringUtils.isBlank(lybm) && !StringUtils.isBlank(lyid)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("lybm", lybm);
			map.put("lyid", lyid);
			returnValue = (String) queryForObject("ZpfjFjxxb.queryZpfjId", map);
		}
		return returnValue;
	}

	/**
	 * 更新附件<br>
	 * 
	 * @param entity
	 */
	public void updateZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean) {
		update("ZpfjFjxxb.updateZpfjFjxxb", entity);
	}

	/**
	 * 注销附件<br>
	 * 
	 * @param entity
	 */
	public void deleteZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean) {
		update("ZpfjFjxxb.deleteZpfjFjxxb", entity);
	}

	/**
	 * 增加下载次数<br>
	 * 
	 * @param entity
	 * @return
	 */
	public void addDownLoadTimes(String id) {
		update("ZpfjFjxxb.addDownLoadTimes", id);
	}

	/**
	 * 新增下载记录 <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public void saveZpfjFjxzjlb(ZpfjFjxzjlb entity, SessionBean sessionBean) {
		insert("ZpfjFjxxb.saveZpfjFjxzjlb", entity);
	}

	/**
	 * 查询附件ID列表，多个时用（如多张图片时控制上一张、下一张显示） <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public String queryZpfjIdList(String lybm, String lyid) {
		String returnValue = "";
		if (!StringUtils.isBlank(lybm) && !StringUtils.isBlank(lyid)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("lybm", lybm);
			map.put("lyid", lyid);
			List<String> list = queryForList("ZpfjFjxxb.queryZpfjIdList", map);
			if (list != null && list.size() > 0) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
					if (i < list.size() - 1) {
						sb.append(",");
					}
				}
				returnValue = sb.toString();
			}
		}
		return returnValue;
	}

	public ZpfjFjxxb queryZpByLyid(String lyid) {
		return (ZpfjFjxxb) queryForObject("ZpfjFjxxb.queryZpByLyid", lyid);
	}
	
	/**
	 * 
	 * @Title: queryListByLybmAndId
	 * @Description: TODO(根据类别和id查询附件列表)
	 * @param @param lybm
	 * @param @param lyid
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throw
	 */
	public List<ZpfjFjxxb> queryListByLybmAndId(String lybm,String lyid){
		Map map=new HashMap();
		map.put("lybm",lybm);
		map.put("id",lyid);
		return queryForList("ZpfjFjxxb.fjxx_query", map);
	}

}
