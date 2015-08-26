package com.founder.zttheme.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.menu.bean.OrgMenu;
import com.founder.framework.organization.right.service.OrgRightPublic;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.zttheme.bean.OrgUserMenuBean;
import com.founder.zttheme.service.ZtThemeService;
import com.founder.zttheme.vo.ZtysVo;

@Controller
@RequestMapping(value = "ztTheme")
public class ZtThemeController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ztThemeService")
	private ZtThemeService ztThemeService;

	/**
	 * 主题展示
	 * 
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addZtTheme")
	public ModelAndView addZtTheme() {
		ModelAndView mv = new ModelAndView("organization/menu/index_2");
		Map<String, Object> map1 = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String userId = sessionBean.getUserPk().toString();
		List<ZtysVo> list = null;
		String systemid = "100";
		list = ztThemeService.zhonghe(systemid, userId,
				sessionBean.getUserType(), sessionBean);
		mv.addObject("userId", userId);
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 导航菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/DhMenu")
	public ModelAndView DhMenu() {
		ModelAndView mv = new ModelAndView("organization/menu/navigator");
		Map<String, String> map = new HashMap<String, String>();
		OrgUser orgUser = new OrgUser();
		SessionBean sessionBean = getSessionBean();
		Long userId = sessionBean.getUserPk();
		String userId1 = sessionBean.getUserId();
		map.put("systemid", "100");
		map.put("userid", userId.toString());
		map.put("usertype", sessionBean.getUserType());
		List<ZtysVo> list = ztThemeService.queryByDhZs(map, sessionBean);
		mv.addObject("list", list);
		mv.addObject("userId", userId);
		mv.addObject("userId1", userId1);
		return mv;
	}

	/**
	 * 导航配置
	 * 
	 * @return
	 */
	@RequestMapping(value = "/DhPz")
	public ModelAndView DhPz() {
		ModelAndView mv = new ModelAndView("organization/menu/navigatorConfig");
		OrgUser orgUser = new OrgUser();
		SessionBean sessionBean = getSessionBean();
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		String menuJson = orgRightPublic.getUserMenuJson(sessionBean, "dhxt",
				false);
		Long userId = sessionBean.getUserPk();
		orgUser.setId(userId);
		List<OrgMenu> rightlist = ztThemeService.selectUserMenu(orgUser,
				sessionBean);
		StringBuffer sb = new StringBuffer();
		if (rightlist != null && rightlist.size() > 0) {
			for (int i = 0; i < rightlist.size(); i++) {
				sb.append(rightlist.get(i).getId());
				if (i < rightlist.size() - 1) {
					sb.append(",");
				}
			}
		}
		mv.addObject("menuJson", menuJson);
		mv.addObject("selectNodeID", sb.toString());
		mv.addObject("rightlist", rightlist);
		return mv;
	}

	/**
	 * 保存用户配置菜单
	 * 
	 * @param userid用户ID
	 * @param menuids菜单Id
	 * @return
	 */
	@RequestMapping(value = "/saveMenuPz", method = RequestMethod.POST)
	public @ResponseBody
	String saveMenuPz(String userid, String menuids) {
		String returnValue = "";
		List<OrgUserMenuBean> menuList = new ArrayList<OrgUserMenuBean>();
		String sysTime = DateUtils.getSystemDateTimeString();
		if (!StringUtils.isBlank(userid)) {
			if (!StringUtils.isBlank(menuids)) {
				String[] menuArray = menuids.split(",");
				for (int i = 0; i < menuArray.length; i++) {
					OrgUserMenuBean orgUserMenu = new OrgUserMenuBean();
					orgUserMenu.setUserid(Long.valueOf(userid));
					String menuid = menuArray[i];
					if (!StringUtils.isBlank(menuid)) {
						orgUserMenu.setMenuid(Long.valueOf(menuid));
					}
					orgUserMenu.setOrderno(new Long(i + 1));
					orgUserMenu.setXt_zhxgsj(sysTime);
					menuList.add(orgUserMenu);
				}
				ztThemeService.saveMenuConfig(menuList, Long.valueOf(userid));
			} else {
				ztThemeService.deleteMenuConfig(Long.valueOf(userid));
			}

		}
		returnValue = "配置成功！";
		return returnValue;
	}

	/**
	 * 顶部图标
	 * 
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/topZtTheme")
	public ModelAndView topZtTheme() {
		ModelAndView mv = new ModelAndView("main/main_top");
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<ZtysVo> list = new ArrayList<ZtysVo>();
		OrgUser orgUser = new OrgUser();
		SessionBean sessionBean = getSessionBean();
		Long userId = sessionBean.getUserPk();
		String userId1 = sessionBean.getUserId();
		map1.put("systemid", "100");
		map1.put("userid", userId.toString());
		map1.put("usertype", sessionBean.getUserType());
		list = ztThemeService.queryByTopZs(map1, sessionBean);
		if (list.size() > 0 && list != null) {
			mv.addObject("list", list);
		}
		return mv;
	}
}
