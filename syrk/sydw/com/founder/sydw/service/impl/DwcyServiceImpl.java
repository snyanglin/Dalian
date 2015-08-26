package com.founder.sydw.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.Dwcyjcrwxxb;
import com.founder.sydw.bean.Dwcyxxb;
import com.founder.sydw.dao.CyjhDao;
import com.founder.sydw.dao.DwcyDao;
import com.founder.sydw.service.DwcyService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.impl.DwcyServiceImpl.java]  
 * @ClassName:    [DwcyServiceImpl]   
 * @Description:  单次抽样
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-7-8 上午9:28:00]   
 * @UpdateUser:   [xu_haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-8 上午9:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("dwcyService")
@Transactional
public class DwcyServiceImpl extends BaseService  implements DwcyService {
	
	@Resource(name = "dwcyDao")
	private DwcyDao dwcyDao;
	
	@Resource(name = "cyjhDao")
	private CyjhDao cyjhDao;
	
	@Override
	public void saveXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean) {
		entity.setGlfxjid(sessionBean.getExtendValue("ssFsxCode"));
		entity.setGlpcsid(sessionBean.getExtendValue("ssPcsCode"));
		entity.setGlbmid(sessionBean.getUserOrgCode());
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		//1重点单位，2一般单位，3九小场所，4其他单位
		Map<String,String> map = new HashMap<String,String>();
		if("3".equals(entity.getCcfs())){
			if("0".equals(entity.getCdan())){
				map = cyjb3(entity, sessionBean);
			}else{
				map = cyjb4(entity, sessionBean);
			}
		}else{
			if("0".equals(entity.getCdan())){
				map = cyjb1(entity, sessionBean);
			}else{
				map = cyjb2(entity, sessionBean);
			}
		}
		entity.setZddwzs(map.get("zddw"));
		entity.setYbdwzs(map.get("ybdw"));
		entity.setJxcszs(map.get("jxcs"));
		entity.setQtdwzs(map.get("qtdw"));
		dwcyDao.saveXfdwcyxxb(entity, sessionBean);
	}
	//抽查方式：只在全部单位中抽||只在未抽单位中抽  &&按照单位总数 组合条件	
	public Map<String,String> cyjb1(Dwcyxxb entity, SessionBean sessionBean){
		Map<String,String> map= new HashMap<String,String>();
		int zddw =0;
		int ybdw=0;
		int jxcs=0;
		int qtdw=0;
		//计算重点单位数和非重点单位数
		Integer jia = Integer.parseInt(entity.getJia());
		double bfb  = Double.parseDouble(entity.getBfb());
		double d = (jia*bfb)/100;
		BigDecimal zddws = new BigDecimal(d).setScale(0, BigDecimal.ROUND_HALF_UP);
		entity.setZs(zddws.toString());
		entity.setJgdwlb("1");//重点单位
		entity.setJia("");
		
		Dwcyjcrwxxb dwrw = new Dwcyjcrwxxb();
		dwrw.setCcrwid(entity.getId());
		dwrw.setFpryid(sessionBean.getUserId());
		BaseService.setSaveProperties(dwrw, sessionBean);
		//重点单位总数
		List<DwOwnXFBean> zddwzs = new ArrayList<DwOwnXFBean>();
		if("1".equals(entity.getCcfs())){
			zddwzs = dwcyDao.querywcdw(entity);
		}else if("2".equals(entity.getCcfs())){
			zddwzs = dwcyDao.querysydw(entity);
		}
		if(zddwzs!=null&&zddwzs.size()>0){
			zddw = zddwzs.size();
			for(int i=0;i<zddwzs.size();i++){
				dwrw.setId(UUID.create());
				dwrw.setDwid(zddwzs.get(i).getDwid());
				cyjhDao.saveDwcyjcrwxxb(dwrw, sessionBean);
			}
		}
		//非重点单位总数
		Integer fzddws = jia-zddws.intValue();
		entity.setZs(fzddws.toString());
		entity.setFzddw("0");//非重点单位
		entity.setJgdwlb(null);//重点单位
		List<DwOwnXFBean> fzddwzs = new ArrayList<DwOwnXFBean>();
		if("1".equals(entity.getCcfs())){
			fzddwzs = dwcyDao.querywcdw(entity);
		}else if("2".equals(entity.getCcfs())){
			fzddwzs = dwcyDao.querysydw(entity);
		}
		if(fzddwzs!=null&&fzddwzs.size()>0){
			for(int i=0;i<fzddwzs.size();i++){
				dwrw.setId(UUID.create());
				dwrw.setDwid(fzddwzs.get(i).getDwid());
				if("2".equals(fzddwzs.get(i).getJgdwlb())){
					//2一般单位
					ybdw=ybdw+1;
				}else if("3".equals(fzddwzs.get(i).getJgdwlb())){
					//3九小场所
					jxcs=jxcs+1;
				}else if("4".equals(fzddwzs.get(i).getJgdwlb())){
					//4其他单位
					qtdw=qtdw+1;
				}
				cyjhDao.saveDwcyjcrwxxb(dwrw, sessionBean);
			}
		}
		map.put("zddw", String.valueOf(zddw));
		map.put("ybdw", String.valueOf(ybdw));
		map.put("jxcs", String.valueOf(jxcs));
		map.put("qtdw", String.valueOf(qtdw));
		return map;
	}
	//抽查方式：只在全部单位中抽||只在未抽单位中抽  &&关键字 组合条件	
	public Map<String,String> cyjb2(Dwcyxxb entity, SessionBean sessionBean){
		Map<String,String> map= new HashMap<String,String>();
		int zddw =0;//1重点单位
		int ybdw=0;//2一般单位
		int jxcs=0;//3九小场所
		int qtdw=0; //4其他单位
		//所有单位
		List<DwOwnXFBean> sydw = new ArrayList<DwOwnXFBean>();
		if("1".equals(entity.getCcfs())){
			sydw = dwcyDao.querywcdw(entity);
		}else if("2".equals(entity.getCcfs())){
			sydw = dwcyDao.querysydw(entity);
		}
		Dwcyjcrwxxb dwrw = new Dwcyjcrwxxb();
		dwrw.setCcrwid(entity.getId());
		dwrw.setFpryid(sessionBean.getUserId());
		BaseService.setSaveProperties(dwrw, sessionBean);
		if(sydw!=null&&sydw.size()>0){
			for(int i=0;i<sydw.size();i++){
				if("1".equals(sydw.get(i).getJgdwlb())){
					zddw=zddw+1;
				}else if("2".equals(sydw.get(i).getJgdwlb())){
					ybdw=ybdw+1;
				}else if("3".equals(sydw.get(i).getJgdwlb())){
					jxcs=jxcs+1;
				}else if("4".equals(sydw.get(i).getJgdwlb())){
					qtdw=qtdw+1;
				}
				dwrw.setId(UUID.create());
				dwrw.setDwid(sydw.get(i).getDwid());
				cyjhDao.saveDwcyjcrwxxb(dwrw, sessionBean);
			}
		}
		map.put("zddw", String.valueOf(zddw));
		map.put("ybdw", String.valueOf(ybdw));
		map.put("jxcs", String.valueOf(jxcs));
		map.put("qtdw", String.valueOf(qtdw));
		return map;
	}
	
	//抽查方式：先在未抽单位中抽，再在已抽单位中抽 &&单位总数 组合条件	
	public Map<String,String> cyjb3(Dwcyxxb entity, SessionBean sessionBean){
		Map<String,String> map= new HashMap<String,String>();
		int zddw =0;
		int ybdw=0;
		int jxcs=0;
		int qtdw=0;
		//计算重点单位数和非重点单位数
		Integer jia = Integer.parseInt(entity.getJia());
		double bfb  = Double.parseDouble(entity.getBfb());
		double d = (jia*bfb)/100;
		BigDecimal zddws = new BigDecimal(d).setScale(0, BigDecimal.ROUND_HALF_UP);
		entity.setZs(zddws.toString());
		entity.setJgdwlb("1");//重点单位
		
		Dwcyjcrwxxb dwrw = new Dwcyjcrwxxb();
		dwrw.setCcrwid(entity.getId());
		dwrw.setFpryid(sessionBean.getUserId());
		BaseService.setSaveProperties(dwrw, sessionBean);
		//重点单位总数
		List<DwOwnXFBean> zddwzs = new ArrayList<DwOwnXFBean>();
		zddwzs = dwcyDao.querywcdw(entity);
		Integer in =zddws.intValue();
		if(zddwzs!=null&&zddwzs.size()<in){
			Integer yczs = in-zddwzs.size();
			entity.setZs(String.valueOf(yczs));
			List<DwOwnXFBean> ycsydw = dwcyDao.queryycdw(entity);
			zddwzs.addAll(ycsydw);
		}
		if(zddwzs==null){
			zddwzs = new ArrayList<DwOwnXFBean>();
			Integer yczs = in;
			entity.setZs(String.valueOf(yczs));
			List<DwOwnXFBean> ycsydw = dwcyDao.queryycdw(entity);
			zddwzs.addAll(ycsydw);
		}
		
		if(zddwzs!=null&&zddwzs.size()>0){
			zddw = zddwzs.size();
			for(int i=0;i<zddwzs.size();i++){
				dwrw.setId(UUID.create());
				dwrw.setDwid(zddwzs.get(i).getDwid());
				cyjhDao.saveDwcyjcrwxxb(dwrw, sessionBean);
			}
		}
		//非重点单位总数
		Integer fzddws = jia-zddws.intValue();
		entity.setZs(fzddws.toString());
		entity.setFzddw("0");//非重点单位
		entity.setJgdwlb(null);//重点单位
		List<DwOwnXFBean> fzddwzs = new ArrayList<DwOwnXFBean>();
		fzddwzs = dwcyDao.querywcdw(entity);
		if(fzddwzs!=null&&fzddwzs.size()<fzddws){
			Integer yczs = fzddws-fzddwzs.size();
			entity.setZs(String.valueOf(yczs));
			List<DwOwnXFBean> ycsydw = dwcyDao.queryycdw(entity);
			fzddwzs.addAll(ycsydw);
		}
		if(fzddwzs==null){
			fzddwzs = new ArrayList<DwOwnXFBean>();
			Integer yczs = fzddws;
			entity.setZs(String.valueOf(yczs));
			List<DwOwnXFBean> ycsydw = dwcyDao.queryycdw(entity);
			fzddwzs.addAll(ycsydw);
		}
		if(fzddwzs!=null&&fzddwzs.size()>0){
			for(int i=0;i<fzddwzs.size();i++){
				dwrw.setId(UUID.create());
				dwrw.setDwid(fzddwzs.get(i).getDwid());
				if("2".equals(fzddwzs.get(i).getJgdwlb())){
					ybdw=ybdw+1;
				}else if("3".equals(fzddwzs.get(i).getJgdwlb())){
					jxcs=jxcs+1;
				}else if("4".equals(fzddwzs.get(i).getJgdwlb())){
					qtdw=qtdw+1;
				}
				cyjhDao.saveDwcyjcrwxxb(dwrw, sessionBean);
			}
		}
		map.put("zddw", String.valueOf(zddw));
		map.put("ybdw", String.valueOf(ybdw));
		map.put("jxcs", String.valueOf(jxcs));
		map.put("qtdw", String.valueOf(qtdw));
		return map;
	}
	
	//抽查方式：先在未抽单位中抽，再在已抽单位中抽  && 关键字 组合条件	
	public Map<String,String> cyjb4(Dwcyxxb entity, SessionBean sessionBean){
		Map<String,String> map= new HashMap<String,String>();
		int zddw =0;
		int ybdw=0;
		int jxcs=0;
		int qtdw=0;
		List<DwOwnXFBean> sydw = new ArrayList<DwOwnXFBean>();
		sydw = dwcyDao.querywcdw(entity);
		Integer zs = Integer.parseInt(entity.getZs());
		if(sydw!=null &&sydw.size()<zs){
			Integer yczs = zs-sydw.size();
			entity.setZs(String.valueOf(yczs));
			List<DwOwnXFBean> ycsydw = dwcyDao.queryycdw(entity);
			sydw.addAll(ycsydw);
		}
		
		if(sydw==null){
			sydw = new ArrayList<DwOwnXFBean>();
			Integer yczs = zs;
			entity.setZs(String.valueOf(yczs));
			List<DwOwnXFBean> ycsydw = dwcyDao.queryycdw(entity);
			sydw.addAll(ycsydw);
		}
		
		Dwcyjcrwxxb dwrw = new Dwcyjcrwxxb();
		dwrw.setCcrwid(entity.getId());
		dwrw.setFpryid(sessionBean.getUserId());
		BaseService.setSaveProperties(dwrw, sessionBean);
		if(sydw!=null&&sydw.size()>0){
			for(int i=0;i<sydw.size();i++){
				if("1".equals(sydw.get(i).getJgdwlb())){
					//1重点单位
					zddw=zddw+1;
				}else if("2".equals(sydw.get(i).getJgdwlb())){
					//2一般单位
					ybdw=ybdw+1;
				}else if("3".equals(sydw.get(i).getJgdwlb())){
					//3九小场所
					jxcs=jxcs+1;
				}else if("4".equals(sydw.get(i).getJgdwlb())){
					//4其他单位
					qtdw=qtdw+1;
				}
				dwrw.setId(UUID.create());
				dwrw.setDwid(sydw.get(i).getDwid());
				cyjhDao.saveDwcyjcrwxxb(dwrw, sessionBean);
			}
		}
		map.put("zddw", String.valueOf(zddw));
		map.put("ybdw", String.valueOf(ybdw));
		map.put("jxcs", String.valueOf(jxcs));
		map.put("qtdw", String.valueOf(qtdw));
		return map;
	}

	@Override
	public void modifyXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean) {
		BaseService.setSaveProperties(entity, sessionBean);
		dwcyDao.modifyXfdwcyxxb(entity, sessionBean);
	}

	@Override
	public void deleteXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean) {
		BaseService.setSaveProperties(entity, sessionBean);
		Dwcyjcrwxxb vo = new Dwcyjcrwxxb();
		BaseService.setSaveProperties(vo, sessionBean);
		vo.setCcrwid(entity.getId());
		vo.setXt_zxbz("1");
		cyjhDao.modifyDwcyjcrwxxb(vo, sessionBean);
		dwcyDao.deleteXfdwcyxxb(entity, sessionBean);
	}

	@Override
	public EasyUIPage queryXfdwcyxxbForPage(EasyUIPage page, Dwcyxxb entity) {
		return dwcyDao.queryXfdwcyxxbForPage(page, entity);
	}

	@Override
	public Dwcyxxb queryXfdwcyxxb(Dwcyxxb entity) {
		return dwcyDao.queryXfdwcyxxb(entity);
	}
	
	@Override
	public String querycccs(Dwcyxxb entity) {
		return dwcyDao.querycccs(entity);
	}

	@Override
	public List<Dwcyxxb> queryXfdwcyxxbList(Dwcyxxb entity) {
		return dwcyDao.queryXfdwcyxxbList(entity);
	}

	@Override
	public List<DwOwnXFBean> querysydw(Dwcyxxb entity) {
		// TODO Auto-generated method stub
		return dwcyDao.querysydw(entity);
	}

	@Override
	public List<DwOwnXFBean> queryycdw(Dwcyxxb entity) {
		// TODO Auto-generated method stub
		return dwcyDao.queryycdw(entity);
	}

	@Override
	public List<DwOwnXFBean> querywcdw(Dwcyxxb entity) {
		// TODO Auto-generated method stub
		return dwcyDao.querywcdw(entity);
	}
}
