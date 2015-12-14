package com.founder.zttheme.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.organization.menu.bean.OrgMenu;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.zttheme.dao.ZtThemeDao;
import com.founder.zttheme.service.ZtThemeService;
import com.founder.zttheme.vo.ZtysVo;
import com.founder.zttheme.vo.pageVo;

@Service("ztThemeService")
@Transactional
public class ZtThemeServiceImpl extends BaseService implements ZtThemeService {

	@Resource(name = "ztThemeDao")
	private ZtThemeDao ztThemeDao;

	/**
	 * 传入参数主题表ID
	 */
	public List<ZtysVo> queryByZtZj(Map<String, String> map,
			SessionBean sessionBean) {
		return ztThemeDao.queryByZtZj(map, sessionBean);
	}

	@Override
	public List<ZtysVo> zhonghe(String systemid, String userid,
			String usertype, SessionBean sessionBean) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("systemid", systemid);
		map1.put("userid", userid);
		map1.put("usertype", usertype);
		return queryByZtZj(map1, sessionBean);
	}

	@Override
	public Map<String, Object> queryByDh(Map<String, String> map) {
		List<ZtysVo> list = new ArrayList<ZtysVo>();
		List<pageVo> list2 = new ArrayList<pageVo>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		list = ztThemeDao.queryByDh(map);
		String page1 = "0";
		if (list.size() > 0 && list != null) {
			int a = list.size();
			int b = a / 10;
			int c = a % 10;
			if (c > 0) {
				page1 = b + 1 + "";
			} else {
				page1 = b + "";
			}
			map1.put("list", list);
		}

		for (int i = 0; i < Long.valueOf(page1); i++) {
			pageVo n = new pageVo();
			int u = 0;
			if (i != 0) {
				u = i * 9 + 1;
			} else {
				u = i * 9;
			}

			int m = (i + 1) * 9;
			n.setBegin(u + "");
			n.setEnd(m + "");
			list2.add(n);
		}
		if (list2.size() > 0 && list2 != null) {
			map1.put("list2", list2);
		}
		return map1;
	}

	/**
	 * 配置个人权限功能菜单
	 * 
	 * @param
	 */
	@Override
	public void saveMenuConfig(List menuList, Long userid) {
		ztThemeDao.delMenuConfig(userid);
		ztThemeDao.saveMenuConfig(menuList);
	};

	/**
	 * 个人功能菜单
	 * 
	 * @param
	 */
	public List<OrgMenu> selectUserMenu(OrgUser orgUser, SessionBean sessionBean) {
		return ztThemeDao.selectUserMenu(orgUser, sessionBean);

	};

	@Override
	public List<ZtysVo> queryByDhZs(Map<String, String> map,
			SessionBean sessionBean) {
		return ztThemeDao.queryByDhZs(map, sessionBean);
	}

	@Override
	public List<ZtysVo> queryByTopZs(Map<String, String> map,
			SessionBean sessionBean) {
		return ztThemeDao.queryByTopZs(map, sessionBean);
	}

	@Override
	public void deleteMenuConfig(Long userid) {
		ztThemeDao.delMenuConfig(userid);
	}

	@Override
	public List<OrgMenu> selectMenu(OrgUser orgUser, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		return null;
	}
}
