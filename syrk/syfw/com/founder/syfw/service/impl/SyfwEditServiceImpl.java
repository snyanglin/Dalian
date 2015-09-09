package com.founder.syfw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syfw.dao.SyfwEditDao;
import com.founder.syfw.service.SyfwEditService;
import com.founder.syfw.vo.SyfwgnVO;
import com.founder.syfw.vo.SyfwxxzsVO;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;

@Service("syfwEditService")
@Transactional
public class SyfwEditServiceImpl extends BaseService implements SyfwEditService {

	@Resource(name="syfwEditDao")
	private SyfwEditDao syfwEditdao;
	
	@Resource(name="syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	
	@Override
	public Fwjbxxb queryFwjbxxbById(String id) {
		return syfwEditdao.queryFwjbxxbById(id);
	}

	//gem
	public Fwjbxxb queryFwxx(String fwdz_dzid){
		return syfwEditdao.queryFwxx(fwdz_dzid);
	}
	
	@Override
	public List<SyfwxxzsVO> queryFwzsxx(Map<String, Object> map) {
		map.put("xxdxlxdm","1");
		List<SyfwxxzsVO> infoList = syfwEditdao.queryFwzsxx(map);
		if(infoList != null && !infoList.isEmpty()){
			map.put("xxdxlxdm","2");
			for (int i = 0; i < infoList.size(); i++) {
				map.put("dlbh",infoList.get(i).getXxbh().substring(0, 2));
				infoList.get(i).setList(syfwEditdao.queryFwzsxx(map));
			}
		}
		return infoList;
	}

	@Override
	public List<SyfwgnVO> queryYwglgn(Map<String, Object> map) {
		return syfwEditdao.queryYwglgn(map);
	}

	@Override
	public void delete_xxzsnrb(Map<String, Object> map) {
		syfwEditdao.delete_xxzsnrb(map);
	}

	@Override
	public void insertFwjbxxb(Fwjbxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		syfwEditdao.insertFwjbxxb(entity);
	}

	@Override
	public void updateFwjbxxb(Fwjbxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		syfwEditdao.updateFwjbxxb(entity);
	}
	
	@Override
	public Czfwxxb czfwzb_query(Map<String, Object> map) {
		return syfwEditdao.czfwzb_query(map);
	}

	@Override
	public int getJzrs(Map<String, Object> map) {
		return syfwEditdao.getJzrs(map);
	}

	@Override
	public void insertCzfwxxb(Czfwxxb czfwxxb,SessionBean sessionBean) {
		czfwxxb.setId(UUID.create());
		setSaveProperties(czfwxxb, sessionBean);
		syfwEditdao.insertCzfwxxb(czfwxxb);
	}

	@Override
	public void updateCzfwxxb(Czfwxxb czfwxxb, SessionBean sessionBean) {
		setUpdateProperties(czfwxxb, sessionBean);
		syfwEditdao.updateCzfwxxb(czfwxxb);
	}

	@Override
	public boolean checkDz(String dzdm) {
		return syfwEditdao.checkDz(dzdm) > 0 ?true:false ;
	}

	@Override
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map) {
		return syfwEditdao.fjxx_query(map);
	}
	
	
	//重构
	//查询单个出租房屋检查信息
	@Override
	public Czfwjcxxb queryCzfwjcxxb(Czfwjcxxb entity) {
		return syfwEditdao.queryCzfwjcxxById(entity);
	}
	//保存单个出租房屋检查信息
	@Override
	public void saveCzfwjcxxb(Czfwjcxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		syfwEditdao.saveCzfwjcxx(entity);
		
	}
	//修改单个出租房屋检查信息
	@Override
	public void updateCzfwjcxxb(Czfwjcxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		syfwEditdao.updateCzfwjcxx(entity);
	}
	//查询出租房屋检查信息
	@Override
	public List<Czfwjcxxb> czfjcxx_query(Map<String, Object> map) {
		String fwid=(String) map.get("fwid");
		List<Czfwjcxxb> list = null;
		if(fwid !=null && !"".equals(fwid)){
			Czfwxxb czfw = new Czfwxxb();
			czfw.setFwid(fwid);
			czfw =czfw_query(czfw);
			if(czfw !=null){
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("czfwid", czfw.getId());
				list = syfwEditdao.czfwjcxx_query(map1);
			}
			
		}
		return list;
	}
    //通过房屋ID查询出租房屋
	@Override
	public Czfwxxb czfw_query(Czfwxxb fwCzfwxxb) {
		return syfwEditdao.queryCzfw(fwCzfwxxb);
	}

	@Override
	public FwCzqkdjxxb queryCzqkdjxx(FwCzqkdjxxb fwCzqkdjxxb) {
		return syfwEditdao.queryCzqk(fwCzqkdjxxb);
	}

	@Override
	public void saveCzqkdjxx(FwCzqkdjxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		syfwEditdao.saveCzqkdjxx(entity);
		
	}

	@Override
	public void updateCzqkdjxx(FwCzqkdjxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		syfwEditdao.updateCzqkdjxx(entity);
		
	}

	@Override
	public List<FwCzqkdjxxb> czqkdjxx_query(Map<String, Object> map) {
		String fwid=(String) map.get("fwid");
		List<FwCzqkdjxxb> list = null;
		if(fwid !=null && !"".equals(fwid)){
			Czfwxxb czfw = new Czfwxxb();
			czfw.setFwid(fwid);
			czfw =czfw_query(czfw);
			if(czfw !=null){
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("czfwid", czfw.getId());
				list = syfwEditdao.czqkdjxx_query(map1);
			}
			
		}
		return list;
	}

	@Override
	public int getCountRkjzdzzb(String ryid, String sszrqdm) {
		int i = 0;
		List<SyrkSyrkxxzb> rkList = syrkSyrkxxzbDao.queryListByRyid(ryid);
		for (SyrkSyrkxxzb syrkSyrkxxzb : rkList) {
			if(syrkSyrkxxzb.getGxzrqdm().equals(sszrqdm)){
				i = 1;
				return i;
			}
		}
		return i;
	}

	@Override
	public List<String> zpxx_query(Map<String, Object> map) {
		return syfwEditdao.zpxx_query(map);
	}

	@Override
	public boolean checkCzrjzdz(String fwdz_dzid, String czr_ryid,
			String gxzrqdm) {
		List<String> list = syfwEditdao.queryJzdzidByRyidAndZrqdm(czr_ryid,gxzrqdm);
		if(!list.isEmpty()){
			for (int i = 0; i < list.size(); i++) {
				if(fwdz_dzid.equals(list.get(i)))
					return true;
			}
		}
		return false;
	}
	
}
