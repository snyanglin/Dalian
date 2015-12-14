package com.founder.zttheme.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.menu.bean.OrgMenu;
import com.founder.framework.organization.right.service.OrgRightPublic;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.zttheme.bean.OrgUserMenuBean;
import com.founder.zttheme.vo.ZtysVo;

@Repository("ztThemeDao")
public class ZtThemeDao extends BaseDaoImpl {

	/**
	 * 主题样式<br>
	 * 
	 * @param userid
	 * @return
	 */
	public List queryByZtZj(Map<String, String> map, SessionBean sessionBean) {
		List<ZtysVo> list = new ArrayList<ZtysVo>();
		List<ZtysVo> list2 = new ArrayList<ZtysVo>();
		List<ZtysVo> list3= new ArrayList<ZtysVo>();
		
		String usertype = map.get("usertype");
		if ("1".equals(usertype)) {
			list2 = queryForList("ZtTheme.queryByDhGLY", map);// 管理人员
		} else {

			List<OrgMenu> list1 = new ArrayList<OrgMenu>();
			OrgRightPublic orgRight = new OrgRightPublic();
			list1 = orgRight.queryUserApplyMenuList(sessionBean, "dhxt");
			list = queryForList("ZtTheme.queryByDhYf", map);// 普通人员
			if (list != null && list1 != null) {
				for (int i = 0; i < list.size(); i++) {
					String ztys = "";
					ztys = list.get(i).getId();
					labela: {
						for (int a = 0; a < list1.size(); a++) {
							String orgmenu = "";
							orgmenu = list1.get(a).getId().toString();
							if (ztys.equals(orgmenu)) {
								ZtysVo zv = (ZtysVo) list.get(i);
								list2.add(zv);
								break labela;
							}
						}

					}
				}
			}

		}
		if (list2.size() > 9) {
			for (int i = 0; i < 9; i++) {
				ZtysVo a = list2.get(i);
				list3.add(a);
			}
		}else{
			list3 = list2;
		}
		return list3;
	}

	/**
	 * 导航菜单配置左边菜单
	 * 
	 * @param map
	 * @return
	 */
	public List queryByDh(Map<String, String> map) {
		return (List<ZtysVo>) queryForList("ZtTheme.queryByDhLeft", map);
	}

	/**
	 * 导航菜单展示
	 * 
	 * @param map
	 * @return
	 */
	public List queryByDhZs(Map<String, String> map,SessionBean sessionBean) {
		List<ZtysVo> list = new ArrayList<ZtysVo>();
		List<ZtysVo> list2 = new ArrayList<ZtysVo>();
		String usertype = map.get("usertype");
		if ("1".equals(usertype)) {
			list2 = queryForList("ZtTheme.queryByDhGLY", map);// 管理人员
		} else {

			List<OrgMenu> list1 = new ArrayList<OrgMenu>();
			OrgRightPublic orgRight = new OrgRightPublic();
			list1 = orgRight.queryUserApplyMenuList(sessionBean, "dhxt");
			list = queryForList("ZtTheme.queryByDhYf", map);// 普通人员
			if (list != null && list1 != null) {
				for (int i = 0; i < list.size(); i++) {
					String ztys = "";
					ztys = list.get(i).getId();
					labela: {
						for (int a = 0; a < list1.size(); a++) {
							String orgmenu = "";
							orgmenu = list1.get(a).getId().toString();
							if (ztys.equals(orgmenu)) {
								ZtysVo zv = (ZtysVo) list.get(i);
								list2.add(zv);
								break labela;
							}
						}

					}
				}
			}

		
		}
		return list2;
	}

	/**
	 * 顶部图标
	 * 
	 * @param map
	 * @return
	 */
	public List queryByTopZs(Map<String, String> map, SessionBean sessionBean) {
		List<ZtysVo> list = new ArrayList<ZtysVo>();
		List<ZtysVo> list2 = new ArrayList<ZtysVo>();
		String usertype = map.get("usertype");
		if ("1".equals(usertype)) {
			list2 = queryForList("ZtTheme.queryByDhGLYTop", map);// 管理人员
		} else {
			List<OrgMenu> list1 = new ArrayList<OrgMenu>();
			OrgRightPublic orgRight = new OrgRightPublic();
			list1 = orgRight.queryUserApplyMenuList(sessionBean, "dhxt");
			list = queryForList("ZtTheme.queryByDhYfTop", map);// 普通人员
			if (list != null && list1 != null) {
				for (int i = 0; i < list.size(); i++) {
					String ztys = "";
					ztys = list.get(i).getId();
					labela: {
						for (int a = 0; a < list1.size(); a++) {
							String orgmenu = "";
							orgmenu = list1.get(a).getId().toString();
							if (ztys.equals(orgmenu)) {
								ZtysVo zv = (ZtysVo) list.get(i);
								list2.add(zv);
								break labela;
							}
						}

					}
				}
			}

		}
		return list2;
	}

	/**
	 * 配置个人权限功能菜单
	 * 
	 * @param
	 */
	public void saveMenuConfig(List menuList) {

		if (null != menuList && menuList.size() > 0) {
			for (int i = 0; i < menuList.size(); i++) {
				OrgUserMenuBean orgUserMenu = (OrgUserMenuBean) menuList.get(i);
				insert("ZtTheme.insertMunePz", orgUserMenu);
			}
		}
	};

	/**
	 * 删除个人权限功能菜单
	 * 
	 * @param
	 */
	public void delMenuConfig(Long userid) {
		delete("ZtTheme.deleteMunePz", userid);
	};

	/**
	 * 查询个人功能菜单
	 * 
	 * @param orgUser
	 * @return
	 */
	public List<OrgMenu> selectMenu(OrgUser orgUser) {
		List<OrgMenu> list = new ArrayList<OrgMenu>();
		if (orgUser != null) {
			list = queryForList("ZtTheme.selectMenuPz", orgUser);
		}
		return list;
	}

	/**
	 * 个人配置功能菜单
	 * 
	 * @param orgUser
	 * @return
	 */
	public List<OrgMenu> selectUserMenu(OrgUser orgUser, SessionBean sessionBean) {
		List<OrgMenu> list = new ArrayList<OrgMenu>();
		List<OrgMenu> list2 = new ArrayList<OrgMenu>();
		if (orgUser != null) {
			list = queryForList("ZtTheme.selectUserMenu", orgUser);

			List<OrgMenu> list1 = new ArrayList<OrgMenu>();
			OrgRightPublic orgRight = new OrgRightPublic();
			list1 = orgRight.queryUserApplyMenuList(sessionBean, "dhxt");
			list = queryForList("ZtTheme.selectUserMenu", orgUser);
			if (list != null && list1 != null) {
				for (int i = 0; i < list.size(); i++) {
					String ztys = "";
					ztys = list.get(i).getId().toString();
					labela: {
						for (int a = 0; a < list1.size(); a++) {
							String orgmenu = "";
							orgmenu = list1.get(a).getId().toString();
							if (ztys.equals(orgmenu)) {
								OrgMenu zv = (OrgMenu) list.get(i);
								list2.add(zv);
								break labela;
							}
						}

					}
				}
			}
			
		}
		return list2;
	}

}
