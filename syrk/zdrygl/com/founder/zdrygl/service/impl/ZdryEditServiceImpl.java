package com.founder.zdrygl.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.zdrygl.bean.ZdryFzcsfryxxb;
import com.founder.zdrygl.bean.ZdryJgdxxxb;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.bean.ZdrySqjzryxxb;
import com.founder.zdrygl.bean.ZdrySqsbzdryxxb;
import com.founder.zdrygl.bean.ZdryZdrkxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.ZdryZszhjsbrxxb;
import com.founder.zdrygl.bean.Zdrylxylbdyb;
import com.founder.zdrygl.dao.ZdryEditDao;
import com.founder.zdrygl.dao.ZdryFzcsfryxxbDao;
import com.founder.zdrygl.dao.ZdryJgdxxxbDao;
import com.founder.zdrygl.dao.ZdrySgafzdryxxbDao;
import com.founder.zdrygl.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.dao.ZdrySqjzryxxbDao;
import com.founder.zdrygl.dao.ZdrySqsbzdryxxbDao;
import com.founder.zdrygl.dao.ZdryZdrkxxbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdrygl.dao.ZdrylxylbdybDao;
import com.founder.zdrygl.service.ZdryEditService;
import com.founder.zdrygl.until.ZdryUntil;
import com.founder.zdrygl.vo.ZdryVO;
import com.founder.zdrygl.vo.ZdryZdryzbVO;
import com.founder.zdrygl.vo.ZdrygnVO;
import com.founder.zdrygl.vo.ZdrylgxxVO;
import com.founder.zdrygl.vo.ZdryxxzsVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.impl.ZdryEditServiceImpl.java]  
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
	private ZdrySgafzdryxxbDao zdrySgafzdryxxbDao;	
	@Resource(name="zdrylxylbdybDao")
	private ZdrylxylbdybDao zdrylxylbdybDao;
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Resource(name="zdrySqjzryxxbDao")
	private ZdrySqjzryxxbDao zdrySqjzryxxbDao;
	@Resource(name="zdrySqsbzdryxxbDao")
	private ZdrySqsbzdryxxbDao zdrySqsbzdryxxbDao;
	@Resource(name = "ZdryUntil")
	private ZdryUntil zdryUntil;

	
	
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
			map.put("zdrylx",zdrkMap.get("zdrylx"));//由于各个区域的重点人员类型代码不一样，所以改用分组来区分用什么界面显示
			map.put("gxzrq",zdrkMap.get("GXZRQ"));			
			map.put("xxdxlxdm","1");
			
			temp = zdryEditDao.queryRyzsxx(map);
			if(temp != null && !temp.isEmpty()){
				map.put("xxdxlxdm","2");
				for (int i = 0; i < temp.size(); i++) {
					temp.get(i).setZdrylxdm(zdrkMap.get("zdrylx"));
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
		return null;
	}

	@Override
	public void delete_xxzsnrb(Map<String, Object> map) {
		zdryEditDao.delete_xxzsnrb(map);
	}

	

	@Override
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map) {
		return zdryZdryzbDao.fjxx_query(map);
	}

	@Override
	public ZdryZdrkxxb zdrkxxb_query(Map<String, Object> map) {
		map.put("qydm", zdryUntil.querySYSConfig());
		return zdryZdrkxxbDao.queryByMap(map);
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
	public List<ZdrylgxxVO> lgxx_query(Map<String, Object> map) {
		return zdryZdryzbDao.queryLgxxByZdryid(map);
	}

	
	public ZdryShbzdryxxb shbzdry_query (Map<String,Object> map){
		return zdryShbzdryxxbDao.queryById((String) map.get("zdryid"));
	}

	@Override
	public ZdrySgafzdryxxb sgafzdryxxb_query(Map<String, Object> map) {
		ZdrySgafzdryxxb entity = zdrySgafzdryxxbDao.queryById((String) map.get("zdryid"));
		if(entity != null){
			 String lbxc = this.zdrySgafzdryxxbDao.queryZdrygllxmc(entity.getId());
			 if(StringUtils.isNotBlank(lbxc)){
				 entity.setZdrygllxmc(lbxc);
			 }
		}
		return entity;
	}
	
	@Override
	public ZdryVO queryZdryAllInfo(String zdryid) {
		ZdryVO zdryVO =new ZdryVO();
		ZdryZdryzb zdryZdryzb = (ZdryZdryzb) zdryZdryzbDao.queryById(zdryid);
		zdryVO.setZdryZdryzb(zdryZdryzb);
		
		//查询重点人员 综合信息
		ZdryZdryzbVO zdryZdryzbVO=zdryZdryzbDao.queryZdryVoByZdryid(zdryZdryzb.getId());
		Zdrylxylbdyb entity=new Zdrylxylbdyb();
		entity.setLbdm(zdryZdryzbVO.getZdrylb());
		entity.setQydm(zdryUntil.querySYSConfig());
		entity=zdrylxylbdybDao.query(entity);//查询子类的名字
		zdryZdryzbVO.setZdrylbmc(entity.getBz());
		zdryVO.setZdryZdryzbVO(zdryZdryzbVO);
		
		if(zdryZdryzb!=null){			
			String zdrylbs=zdryZdryzb.getZdrygllxdm();//重点人员大类，用以区分查什么类型
			entity=new Zdrylxylbdyb();
			entity.setLbdm(zdrylbs);
			entity.setQydm(zdryUntil.querySYSConfig());
			entity=zdrylxylbdybDao.query(entity);//主要为了查询分组，用以区分是什么类型，类型代码不同区域不同，所以不能用类型代码区分
			
			zdryVO.setZdrylbStr(entity.getFz());			
			// 取得对应信息
			if ("ZDRK".equals(entity.getFz())) {// 重口
				ZdryZdrkxxb zdryzdrkxxb = zdryZdrkxxbDao.queryById(zdryid);
				zdryVO.setZdryZdrkxxb(zdryzdrkxxb);
			} else if ("ZSZHJSBR".equals(entity.getFz())) {// 精神病人
				ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryZszhjsbrxxbDao.queryById(zdryid);
				zdryVO.setZdryZszhjsbrxxb(zdryZszhjsbrxxb);
			} else if ("FZCSF".equals(entity.getFz())) {// 非正常上访
				ZdryFzcsfryxxb zdryFzcsfryxxb = zdryFzcsfryxxbDao.queryById(zdryid);
				zdryVO.setZdryFzcsfryxxb(zdryFzcsfryxxb);
			} else if ("JGDX".equals(entity.getFz())) {// 监管对象
				ZdryJgdxxxb zdryJgdxxxb = zdryJgdxxxbDao.queryById(zdryid);
				zdryVO.setZdryJgdxxxb(zdryJgdxxxb);
			}else if ("SHB".equals(entity.getFz())) {// 涉环保
				ZdryShbzdryxxb zdryShbzdryxxb = zdryShbzdryxxbDao.queryById(zdryid);
				zdryVO.setZdryShbzdryxxb(zdryShbzdryxxb);
			}else if ("SQJZRY".equals(entity.getFz())) {// 社区矫正
				ZdrySqjzryxxb zdrySqjzryxxb = zdrySqjzryxxbDao.queryById(zdryid);
				zdryVO.setZdrySqjzryxxb(zdrySqjzryxxb);
			}else if ("SQSB".equals(entity.getFz())) {// 涉枪涉暴
				ZdrySqsbzdryxxb zdrySqsbzdryxxb = zdrySqsbzdryxxbDao.queryById(zdryid);
				zdryVO.setZdrySqsbzdryxxb(zdrySqsbzdryxxb);
			}else if ("SGAF".equals(entity.getFz())) {// 涉公安访
				ZdrySgafzdryxxb zdrySgafzdryxxb = zdrySgafzdryxxbDao.queryById(zdryid);
				zdryVO.setZdrySgafzdryxxb(zdrySgafzdryxxb);
			}
		}
		return zdryVO;
	}
	
	public void updateZdryAllInfo(ZdryVO zdryVO,SessionBean sessionBean) {
		ZdryZdryzb zdryZdryzb = zdryVO.getZdryZdryzb();
		String type=zdryZdryzb.getZdrygllxdm();//列管类型
		String strAry[]=type.split("/");
		type=strAry[0];
		zdryZdryzb.setZdrygllxdm(type);
		//具体的类型不可修改，所以总表不用修改，子表修改即可		
		if ("ZDRK".equals(type)) {// 重口
			zdryVO.getZdryZdrkxxb().setId(zdryZdryzb.getId());
			zdryZdrkxxbDao.update(zdryVO.getZdryZdrkxxb());			
		} else if ("ZSZHJSBR".equals(type)) {// 精神病人
			zdryVO.getZdryZszhjsbrxxb().setId(zdryZdryzb.getId());
			zdryZszhjsbrxxbDao.update(zdryVO.getZdryZszhjsbrxxb());			
		} else if ("FZCSF".equals(type)) {// 非正常上访
			zdryVO.getZdryFzcsfryxxb().setId(zdryZdryzb.getId());
			zdryFzcsfryxxbDao.update(zdryVO.getZdryFzcsfryxxb());
		} else if ("JGDX".equals(type)) {// 监管对象
			zdryVO.getZdryJgdxxxb().setId(zdryZdryzb.getId());
			zdryJgdxxxbDao.update(zdryVO.getZdryJgdxxxb());
		}else if ("SHB".equals(type)) {// 涉环保
			zdryVO.getZdryShbzdryxxb().setId(zdryZdryzb.getId());
			zdryShbzdryxxbDao.update(zdryVO.getZdryShbzdryxxb());
		}else if ("SQJZRY".equals(type)) {// 社区矫正
			zdryVO.getZdrySqjzryxxb().setId(zdryZdryzb.getId());
			zdrySqjzryxxbDao.update(zdryVO.getZdrySqjzryxxb());
		}else if ("SQSB".equals(type)) {// 涉枪涉暴
			zdryVO.getZdrySqsbzdryxxb().setId(zdryZdryzb.getId());
			zdrySqsbzdryxxbDao.update(zdryVO.getZdrySqsbzdryxxb());
		}else if ("SGAF".equals(type)) {// 涉公安访
			zdryVO.getZdrySgafzdryxxb().setId(zdryZdryzb.getId());
			zdrySgafzdryxxbDao.update(zdryVO.getZdrySgafzdryxxb());
		}
	}
}
