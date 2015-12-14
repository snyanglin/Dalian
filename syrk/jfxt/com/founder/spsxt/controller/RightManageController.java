package com.founder.spsxt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.right.service.OrgRightPublic;
import com.founder.framework.organization.right.vo.OrgMenuInfo;
import com.founder.framework.organization.right.vo.OrgMenuSystemInfo;
import com.founder.spsxt.vo.TreeJson;


@Controller
@RequestMapping(value = "/JfxtRight")
public class RightManageController  extends BaseController {

	//获得权限菜单
	@RequestMapping(value = "/getRightMenu")
	public ModelAndView getRightMenu(){
		List<OrgMenuInfo> spxtMenuList = null;
		String forwardPage = "";
		SessionBean sessionBean=getSessionBean();
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		List<OrgMenuSystemInfo> rightMenuList = orgRightPublic.getUserMenu(sessionBean, "jfxt");//获得权限菜单列表
		if(rightMenuList!= null && rightMenuList.size()>0) {
			OrgMenuSystemInfo orgMenuSystemInfo = rightMenuList.get(0);//公安视频/社会视频
			List<OrgMenuInfo> menuList = orgMenuSystemInfo.getMenuList();
			if(menuList!= null && menuList.size()>0) {
				OrgMenuInfo orgMenuInfo = menuList.get(0);
				forwardPage = orgMenuInfo.getBz();//导航菜单生成页面
				spxtMenuList = orgMenuInfo.getMenuList();
			}
		}
		//System.out.println("rightMenuList.size="+rightMenuList.size());
		//OrgMenuSystemInfo menu=rightMenuList.get(0);
		//menu.getSystemname(),menu.getSystemcontexturl(),menu.getMenuList();
		//ModelAndView mv=new ModelAndView("jfxt/" + forwardPage);
		ModelAndView mv=new ModelAndView(forwardPage);//到菜单页面

		mv.addObject("rightMenuList",spxtMenuList);
		return mv;//跳转到目标页面
	}
	/*
	private List<TreeJson> testManyList(){
		List<TreeJson> list=new ArrayList<TreeJson>();
		
		TreeJson tree=new TreeJson("001","text001");
		list.add(tree);//item1
		//为第一个项添加一个列表
		TreeJson tree1=new TreeJson("0011","text0011");
		tree.getChildren().add(tree1);
		tree1=new TreeJson("0012","text0012");
		tree.getChildren().add(tree1);
		
		
		tree=new TreeJson("002","text002");
		list.add(tree);//item2
		//为第二个项添加一个列表
		TreeJson tree2=new TreeJson("0021","text0021");
		tree.getChildren().add(tree2);
		tree2=new TreeJson("0022","text0022");
		tree.getChildren().add(tree2);
		
		return list;
	}
	*/
}
