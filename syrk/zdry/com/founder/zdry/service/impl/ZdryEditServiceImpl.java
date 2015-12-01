package com.founder.zdry.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.zdry.bean.ZdryDtgljsxxb;
import com.founder.zdry.bean.ZdryFzcsfryxxb;
import com.founder.zdry.bean.ZdryJgdxqxjdjb;
import com.founder.zdry.bean.ZdryJgdxxxb;
import com.founder.zdry.bean.ZdryJkbjllxxb;
import com.founder.zdry.bean.ZdryNrsxdxxxb;
import com.founder.zdry.bean.ZdryPsjdb;
import com.founder.zdry.bean.ZdryShbzdryxxb;
import com.founder.zdry.bean.ZdrySqsbzdryxxb;
import com.founder.zdry.bean.ZdryWffzjlxxb;
import com.founder.zdry.bean.ZdryXdrynjxxb;
import com.founder.zdry.bean.ZdryXdryxxb;
import com.founder.zdry.bean.ZdryZagltdxxb;
import com.founder.zdry.bean.ZdryZdrkxxb;
import com.founder.zdry.bean.ZdryZdrykcxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;
import com.founder.zdry.dao.ZdryDtgljsxxbDao;
import com.founder.zdry.dao.ZdryEditDao;
import com.founder.zdry.dao.ZdryFzcsfryxxbDao;
import com.founder.zdry.dao.ZdryJgdxqxjdjbDao;
import com.founder.zdry.dao.ZdryJgdxxxbDao;
import com.founder.zdry.dao.ZdryJkbjllxxbDao;
import com.founder.zdry.dao.ZdryNrsxdxxxbDao;
import com.founder.zdry.dao.ZdryPsjdbDao;
import com.founder.zdry.dao.ZdryShbzdryxxbDao;
import com.founder.zdry.dao.ZdrySqsbzdryxxbDao;
import com.founder.zdry.dao.ZdryWffzjlxxbDao;
import com.founder.zdry.dao.ZdryXdrynjxxbDao;
import com.founder.zdry.dao.ZdryXdryxxbDao;
import com.founder.zdry.dao.ZdryZagltdxxbDao;
import com.founder.zdry.dao.ZdryZdrkxxbDao;
import com.founder.zdry.dao.ZdryZdrykcxxbDao;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdry.service.ZdryEditService;
import com.founder.zdry.vo.ZdrygnVO;
import com.founder.zdry.vo.ZdrylgxxVO;
import com.founder.zdry.vo.ZdryxxzsVO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.service.impl.ZdryEditServiceImpl.java]  
 * @ClassName:    [ZdryEditServiceImpl]   
 * @Description:  [重点人员编辑服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午6:20:34]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午6:20:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryEditService")
@Transactional
public class ZdryEditServiceImpl extends BaseService implements ZdryEditService {
	
	@Resource(name="zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	
	@Resource(name="zdryEditDao")
	private ZdryEditDao zdryEditDao;
	
	@Resource(name="zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;
	@Resource(name="zdryJgdxxxbDao")
	private ZdryJgdxxxbDao zdryJgdxxxbDao;
	@Resource(name="zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;
	@Resource(name="zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;
	@Resource
	private ZdryXdryxxbDao zdryXdryxxbDao;
	@Resource
	private ZdryXdrynjxxbDao zdryXdrynjxxbDao;
	@Resource(name="zdryDtgljsxxbDao")
	private ZdryDtgljsxxbDao zdryDtgljsxxbDao;
	
	
	@Resource(name="zdryJgdxqxjdjbDao")
	private ZdryJgdxqxjdjbDao zdryJgdxqxjdjbDao;
	
	@Resource(name="zdryJkbjllxxbDao")
	private ZdryJkbjllxxbDao zdryJkbjllxxbDao;
	
	@Resource(name="zdryPsjdbDao")
	private ZdryPsjdbDao zdryPsjdbDao;
	
	@Resource(name="zdryZdrykcxxbDao")
	private ZdryZdrykcxxbDao zdryZdrykcxxbDao;
	@Resource(name="zdryNrsxdxxxbDao")
	private ZdryNrsxdxxxbDao zdryNrsxdxxxbDao;
	
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	
	@Resource(name="zdryZagltdxxbDao")
	private ZdryZagltdxxbDao zdryZagltdxxbDao;
	
	@Resource(name="zdryWffzjlxxbDao")
	private ZdryWffzjlxxbDao zdryWffzjlxxbDao;
	
	@Resource(name="zdrySqsbzdryxxbDao")
	private ZdrySqsbzdryxxbDao zdrySqsbzdryxxbDao;

	@Override
	public List<ZdryZdryzb> queryZdryByRyid(String ryid) {
		return zdryZdryzbDao.queryZdryByRyid(ryid);
	}

	@Override
	public List<ZdrygnVO> queryYwglgn(String gnlxdm) {
		return zdryEditDao.queryYwglgn(gnlxdm);
	}

	@Override
	public List<ZdryxxzsVO> queryRyzsxx(Map<String, Object> map) {
		List<Map<String,String>> list = new Gson().fromJson((String)map.get("zdrylxJson"), new TypeToken<List<Map<String,String>>>() {}.getType());
		map.remove("zdrylxJson");
		List<ZdryxxzsVO> infoList = new ArrayList<ZdryxxzsVO>();
		List<ZdryxxzsVO> temp = null;
		//循环查询重点人口信息，不去重复
		for (Map<String,String> zdrkMap : list) {
			map.remove("dlbh");
			map.put("zdryid",zdrkMap.get("zdryid"));
			map.put("isEdit",zdrkMap.get("isEdit"));
			map.put("zdrylx",zdrkMap.get("zdrylx"));
			map.put("gxzrq",zdrkMap.get("GXZRQ"));
			map.put("xxdxlxdm","1");
			if("1".equals(zdrkMap.get("isEdit").toString())){
				
			}
			temp = zdryEditDao.queryRyzsxx(map);
			if(temp != null && !temp.isEmpty()){
				map.put("xxdxlxdm","2");
				for (int i = 0; i < temp.size(); i++) {
					temp.get(i).setZdrylxdm(zdrkMap.get("zdrylx"));
					if("1".equals(zdrkMap.get("isEdit").toString())){
						temp.get(i).setPx(0);
					}
					map.put("dlbh",temp.get(i).getXxbh().substring(0, 2));
					temp.get(i).setList( zdryEditDao.queryRyzsxx(map));
				}
				infoList.addAll(temp);
			}
		}
		//实现排序接口
		Comparator<Object> c = new Comparator<Object>(){
			public int compare( Object a, Object b ){
				 int one =((ZdryxxzsVO)a).getPx();
				 int two =((ZdryxxzsVO)b).getPx();
				return one-two;
			}
		};
		Collections.sort(infoList,c);
		return infoList;
	}

	@Override
	public void delete_xxzsnrb(Map<String, Object> map) {
		zdryEditDao.delete_xxzsnrb(map);
	}

	@Override
	public List<ZdryPsjdb> psjdb_query(Map<String, Object> map) {
		return zdryPsjdbDao.queryViewList(map);
	}

	@Override
	public List<ZdryDtgljsxxb> dtgljsb_query(Map<String, Object> map) {
		return zdryDtgljsxxbDao.queryViewList(map);
	}

	@Override
	public List<ZdryJgdxqxjdjb> qxjdjb_query(Map<String, Object> map) {
		return zdryJgdxqxjdjbDao.queryViewList(map);
	}

	@Override
	public List<ZdryZagltdxxb> zagltdb_query(Map<String, Object> map) {
		return zdryZagltdxxbDao.queryViewList(map);
	}

	@Override
	public List<ZdryWffzjlxxb> wffzjlb_query(Map<String, Object> map) {
		return zdryWffzjlxxbDao.queryViewList(map);
	}

	@Override
	public List<ZdryJkbjllxxb> jkbjryxxb_query(Map<String, Object> map) {
		return zdryJkbjllxxbDao.queryViewList(map);
	}

	@Override
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map) {
		return zdryZdryzbDao.fjxx_query(map);
	}

	@Override
	public List<ZdryZdrykcxxb> zdrykcb_query(Map<String, Object> map) {
		return zdryZdrykcxxbDao.queryViewList(map);
	}

	@Override
	public ZdryZdrkxxb zdrkxxb_query(Map<String, Object> map) {
		return zdryZdrkxxbDao.queryZsxxById((String) map.get("zdryid"));
	}

	@Override
	public ZdryZszhjsbrxxb zszhjsbrxxb_query(Map<String, Object> map) {
		return zdryZszhjsbrxxbDao.queryZsxxById((String) map.get("zdryid"));
	}

	@Override
	public ZdryJgdxxxb jgdxxxb_query(Map<String, Object> map) {
		return zdryJgdxxxbDao.queryZsxxById((String) map.get("zdryid"));
	}

	@Override
	public ZdryFzcsfryxxb fzcfryxxb_query(Map<String, Object> map) {
		 ZdryFzcsfryxxb xxb =zdryFzcsfryxxbDao.queryZsxxById((String) map.get("zdryid"));
		 return xxb;
	}

	@Override
	public List<ZdrylgxxVO> lgxx_query(Map<String, Object> map) {
		return zdryZdryzbDao.queryLgxxByZdryid(map);
	}

	
	public ZdryShbzdryxxb shbzdry_query (Map<String,Object> map){
		return zdryShbzdryxxbDao.queryZsxxById((String) map.get("zdryid"));
	}

	@Override
	public List<ZdryXdryxxb> zdryXdryxxb_query(Map<String, Object> map) {
		List<ZdryXdryxxb> list=zdryXdryxxbDao.queryList((String) map.get("zdryid"));

		return list;
	}

	@Override
	public List<ZdryXdrynjxxb> zdryXdrynjxx_query(Map<String, Object> map) {
		
		return (List<ZdryXdrynjxxb>)zdryXdrynjxxbDao.queryList((String) map.get("zdryid"));
	}

	@Override
	public ZdrySqsbzdryxxb sqsbxxb_query(Map<String, Object> map) {
		
		return zdrySqsbzdryxxbDao.queryZsxxById(map.get("zdryid").toString());
	}

	@Override
	public ZdryNrsxdxxxb nrsxdxxxb_query(Map<String, Object> map) {
		ZdryNrsxdxxxb xxb =zdryNrsxdxxxbDao.queryZsxxById((String) map.get("zdryid"));
		 return xxb;
	}

}
