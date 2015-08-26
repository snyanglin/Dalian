package com.founder.zdrygl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.workflow.service.inteface.JProcessManageService;

@Controller
@RequestMapping("diagram")
public class DiagramController extends BaseController{
	
	@Autowired
	private JProcessManageService processManageService;
	
	@RequestMapping("")
	public String main(){
		return "redirect:modeler.jsp";
	}

	@RequestMapping("/deploy/{name}")
	@RestfulAnnotation(serverId="12")
	public @ResponseBody String deploy(@PathVariable String name){
		String id = processManageService.deploymentByClasspathResource(name+".bpmn").getId();
		return "发布成功，版本号为："+id ;
	}
	
	@RequestMapping("/destroy/{name}")
	@RestfulAnnotation(serverId="12")
	public @ResponseBody String destroy(@PathVariable String name){
		processManageService.deleteDeployment(name);
		return "ok";
	}
	
	@RequestMapping("index")
	public String mains(){
		return "redirect:index.jsp";
	} 
}
