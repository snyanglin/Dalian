package com.founder.zafffwqz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.zafffwqz.bean.Bazzb;
import com.founder.zafffwqz.bean.Bazzryxxb;
import com.founder.zafffwqz.bean.Sqjbxxb;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqmjxxb;
import com.founder.zafffwqz.bean.Sqwyhcyb;
import com.founder.zafffwqz.bean.Sqzbhb;
import com.founder.zafffwqz.bean.Sqzdbwb;
import com.founder.zafffwqz.bean.Zazzryxxb;
import com.founder.zafffwqz.dao.ZaffEditDao;
import com.founder.zafffwqz.service.ZaffEditService;
import com.founder.zafffwqz.vo.ZaffgnVO;
import com.founder.zafffwqz.vo.ZaffxxzsVO;

@Service("zaffEditService")
@Transactional
public class ZaffEditServiceImpl extends BaseService implements ZaffEditService {
	
	@Resource(name="zaffEditDao")
	private ZaffEditDao zaffEditDao;

	@Override
	public void delete_xxzsnrb(Map<String, Object> map) {
		zaffEditDao.delete_xxzsnrb(map);
	}

	@Override
	public List<ZaffgnVO> queryYwglgn(Map<String, Object> map) {
		return zaffEditDao.queryYwglgn(map);
	}

	@Override
	public List<ZaffxxzsVO> queryJwszsxx(Map<String, Object> map) {
		map.put("xxdxlxdm","1");
		List<ZaffxxzsVO> infoList = zaffEditDao.queryJwszsxx(map);
		if(infoList != null && !infoList.isEmpty()){
			map.put("xxdxlxdm","2");
			for (int i = 0; i < infoList.size(); i++) {
				map.put("dlbh",infoList.get(i).getXxbh().substring(0, 2));
				infoList.get(i).setList(zaffEditDao.queryJwszsxx(map));
			}
		}
		return infoList;
	}

	@Override
	public Sqjwsxxb querySqjwsxxbById(String id) {
		return zaffEditDao.querySqjwsxxbById(id);
	}

	@Override
	public Sqjbxxb sqjbxxb_query(Map<String, Object> map) {
		return zaffEditDao.sqjbxxb_query(map);
	}

	@Override
	public List<Sqwyhcyb> sqwyhcyb_query(Map<String, Object> map) {
		return zaffEditDao.sqwyhcyb_query(map);
	}

	@Override
	public List<Sqzdbwb> sqzdbwb_query(Map<String, Object> map) {
		return zaffEditDao.sqzdbwb_query(map);
	}

	@Override
	public List<Zazzryxxb> zazzryxxb_query(Map<String, Object> map) {
		return zaffEditDao.zazzryxxb_query(map);
	}
	
	@Override
	public List<Bazzryxxb> bazzryxxb_query(Map<String, Object> map) {
		return zaffEditDao.bazzryxxb_query(map);
	}

	@Override
	public Bazzb bazzb_query(Map<String, Object> map) {
		return zaffEditDao.bazzb_query(map);
	}

	@Override
	public Sqjwsxxb sqjwsxxb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return zaffEditDao.sqjwsxxb_query(map);
	}

	@Override
	public Sqmjxxb sqmjxxb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return zaffEditDao.sqmjxxb_query(map);
	}

	@Override
	public List<Sqzbhb> sqzbhb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return zaffEditDao.sqzbhb_query(map);
	}

}
