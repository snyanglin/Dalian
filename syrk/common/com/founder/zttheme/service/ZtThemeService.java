package com.founder.zttheme.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.menu.bean.OrgMenu;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.zttheme.vo.ZtysVo;

@TypeAnnotation("主题")
public interface ZtThemeService {

	/**
	 * 
	 * @param themeid主题表ID
	 * @return
	 */
	public List<ZtysVo> queryByZtZj(Map<String, String> map,
			SessionBean sessionBean);

	/**
	 * 主题样式
	 * 
	 * @param mc主题代码
	 * @param icontype图标类型
	 * @param systemid系统ID
	 * @return
	 */
	public List<ZtysVo> zhonghe(String systemid, String userid,
			String usertype, SessionBean sessionBean);

	/**
	 * 导航菜单左边
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Object> queryByDh(Map<String, String> map);

	/**
	 * 导航菜单
	 * 
	 * @param map
	 * @return
	 */
	public List<ZtysVo> queryByDhZs(Map<String, String> map,
			SessionBean sessionBean);

	/**
	 * 配置个人权限功能菜单
	 * 
	 * @param
	 */
	public void saveMenuConfig(List menuList, Long userid);

	/**
	 * 删除个人权限菜单
	 * 
	 * @param
	 */
	public void deleteMenuConfig(Long userid);

	/**
	 * 个人功能菜单
	 * 
	 * @param
	 */
	public List<OrgMenu> selectUserMenu(OrgUser orgUser, SessionBean sessionBean);

	/**
	 * 个人所有可配置菜单
	 * 
	 * @param orgUser
	 * @return
	 */
	public List<OrgMenu> selectMenu(OrgUser orgUser, SessionBean sessionBean);

	public List<ZtysVo> queryByTopZs(Map<String, String> map,
			SessionBean sessionBean);
}
