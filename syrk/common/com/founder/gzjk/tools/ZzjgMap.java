package com.founder.gzjk.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.founder.framework.utils.StringUtils;
import com.founder.gzjk.dao.GzjkDao;

/**
 * ****************************************************************************
 * @Package:      [com.founder.gzjk.tools.ZzjgMap.java]  
 * @ClassName:    [ZzjgMap]   
 * @Description:  [单位与下一级单位 map 查询工具]   
 * @Author:       [weiwen]   
 * @CreateDate:   [2014-11-1 下午3:37:23]   
 * @UpdateUser:   [weiwen(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-1 下午3:37:23，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class ZzjgMap {


	@Resource(name = "gzjkDao")
	private GzjkDao gzjkDao;
	
	private Map<String,String> primary = new HashMap<String,String>();
	
	/**
	 * 
	 * @Title: getZzjgMap
	 * @Description: TODO(查询出所有组织机构，每个单位的代码为KEY，下一级单位代码的数组为VALUE)
	 * @param @return    设定文件
	 * @return Map<String,String[]>    返回类型
	 * @throws
	 */
	public Map<String,String[]> getZzjgMap(){
		gzjkDao.deleteGztslsb();
		primary = gzjkDao.queryZzjgMapForGzjk();
		Map<String,String[]> result = new HashMap<String,String[]>();
		for(String key: primary.keySet()){
			result.put(key, getChildZzjg(key));
		}
		return result;
	}
	
	private String[] getChildZzjg(String pid){
		String temp = "";
		for(Entry<String,String> entry: primary.entrySet()){
			if(!StringUtils.isBlank(entry.getValue()) && entry.getValue().equals(pid))
				temp+= (entry.getKey()+",");
		}
		return temp.split(",");
	}
}
