package com.founder.syfw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.MapUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.gis.service.GisService;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.dao.CzfwzbDao;
import com.founder.syfw.dao.SyfwQueryDao;
import com.founder.syfw.service.SyfwQueryService;
import com.founder.syfw.vo.SyfwListVo;

@Service("syfwQueryService")
@Transactional
public class SyfwQueryServiceImpl extends BaseService implements SyfwQueryService{

	@Resource(name = "syfwQueryDao")
	private SyfwQueryDao syfwQueryDao;
	
	@Resource(name = "czfwzbDao")
	private CzfwzbDao czfwzbDao;
	
	@Resource(name = "gisService")
	private GisService gisService;

	/**
	 * 删除人员居住地址子表信息
	 * @return
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(SyfwListVo entity, SessionBean sessionBean){
		BaseService.setCrossoutProperties(entity, sessionBean);
		syfwQueryDao.delete(entity);
		
		Czfwxxb czfwxxb = czfwzbDao.queryCzfwxxbByFwid(entity.getId());
		
		if(czfwxxb!=null){
			BaseService.setCrossoutProperties(czfwxxb, sessionBean);
			czfwxxb.setXt_zxyy("所关联实有房屋已注销");
			czfwzbDao.deleteCzfwxxb(czfwxxb);
			
			FwCzqkdjxxb fwCzqkdjxxb = new FwCzqkdjxxb();
			BaseService.setCrossoutProperties(fwCzqkdjxxb, sessionBean);
			fwCzqkdjxxb.setXt_zxyy("所关联实有房屋已注销");
			fwCzqkdjxxb.setCzfwid(czfwxxb.getId());
			czfwzbDao.deleteCzqkdjxxb(fwCzqkdjxxb);
	
			Czfwjcxxb czfwjcxxb = new Czfwjcxxb();
			BaseService.setCrossoutProperties(czfwjcxxb, sessionBean);
			czfwjcxxb.setXt_zxyy("所关联实有房屋已注销");
			czfwjcxxb.setCzfwid(czfwxxb.getId());
			czfwzbDao.deleteCzfwjcxxb(czfwjcxxb);
		}
	};

	@Override
	public EasyUIPage queryFw(EasyUIPage page, SyfwListVo entity) {
		return syfwQueryDao.queryFw(page, entity);
	}
	@Override
	public long queryCountFw(SyfwListVo entity) {
		return syfwQueryDao.queryCountFw(entity);
	}

	@Override
	public EasyUIPage querySyfw( SyfwListVo entity ,EasyUIPage page) {
			if (!StringUtils.isBlank(entity.getDrawType())
					&& !StringUtils.isBlank(entity.getDrawZbz())) {
				entity.setDrawSrid(gisService.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));// 获取地图图层SRID，为公共方法查询
																	// 不止一个空间表名。
				if (!"drawRect".equals(entity.getDrawType())) {
					entity.setDrawZbz(MapUtils.getSdeZbz(entity.getDrawZbz()));
				}
			}
			return syfwQueryDao.querySyfw(entity, page);
	}

	@Override
	public long querySyfwCount(SyfwListVo entity) {
		if (!StringUtils.isBlank(entity.getDrawType())
				&& !StringUtils.isBlank(entity.getDrawZbz())) {
			entity.setDrawSrid(gisService.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));// 获取地图图层SRID，为公共方法查询
																// 不止一个空间表名。
			if (!"drawRect".equals(entity.getDrawType())) {
				entity.setDrawZbz(MapUtils.getSdeZbz(entity.getDrawZbz()));
			}
		}
		return syfwQueryDao.querySyfwCount(entity);
	}

}
