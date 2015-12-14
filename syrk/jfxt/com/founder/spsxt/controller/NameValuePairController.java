package com.founder.spsxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.service.NameValuePairService;

@Controller
@RequestMapping("/idName")
public class NameValuePairController extends BaseController { //

	private Logger logger = Logger.getLogger(this.getClass());
	//编码不规范的派出所
	private String[] exceptPcs={"210251080000","210261060000","210261070000","210261080000","210271070000","210271080000",
	"210271090000","210271100000","210271110000","210271120000","210271130000","210271140000","210271150000","210271160000",
	"210271170000","210279060000","210279070000","210280070000","210280080000","210280090000","210280100000","210280110000",
	"210280120000","210280130000","210280140000","210280150000","210280160000",
	//内保XX大队
	"210200360500","210200360800","210200364200","210200360800","210200364100","210200364700","210200360600","210200360800","210200360800","210200360800","210200364800","210200360800","210200364600","210200360800",
	"210200360800","210200360800","210200360800","210200360800","210200360600","210200360600","210200365100","210200360600","210200364500","210200360800","210200360800","210200364900","210200360400","210200364400","210200365000"
	};
	@Resource(name = "nameValuePairService")
	private NameValuePairService nameValuePairService;

	//组织机构列表。 根据id/拼音模糊查询.参数q为easyui-combobox传递的参数名称
	@RequestMapping(value = "/getOrgCodeNameByCondition")
	public @ResponseBody List getOrgCodeNameByCondition(String q) {
		List idNameList = null;
		Map<String, String> paramMap=getConditionMap(q);
		try {
			idNameList = nameValuePairService.getOrgCodeNameByCondition(paramMap);
			System.out.println(q + "," + idNameList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 从服务层获得列表信息
	
		return idNameList; // 返回一个List

	}
	//获得参数映射
	private Map<String, String> getConditionMap(String inputVal){
		Map<String, String> paramMap = new HashMap<String, String>();
		if (inputVal!=null) {
			inputVal = inputVal.toUpperCase();// 转换为大写
			// 参数paramMap中可以是多个条件			
			paramMap.put("maxRows", "21");// 21表示没有任何输入时，最多返回的行数
			if (inputVal.matches("^\\d+")) {// 数字开头
				paramMap.put("id", inputVal);// 输入值为id
			} else {
				paramMap.put("py", inputVal);// 输入值为py
			}
			System.out.println("inputVal：" + inputVal);
		}
		return paramMap;
		
	}
	//视频单位id,dwmc列表，供视频监控系统选择
	@RequestMapping(value = "/getSpdwIdNameByCondition")
	public @ResponseBody List getSpdwIdNameByCondition(String q) {
		List idNameList = null;
		Map<String, String> paramMap=getConditionMap(q);
		try {
			idNameList = nameValuePairService.getSpdwIdNameByCondition(paramMap);
			System.out.println(q + "," + idNameList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 从服务层获得列表信息
	
		return idNameList; // 返回一个List

	}
	
	
	
	//通用方法
	//根据id/拼音模糊查询.参数q为easyui-combobox传递的参数名称
    @RequestMapping(value = "/getIdNameByCondition")
	public 	@ResponseBody List getMzListByPy(String q,String name) { 
    	String inputVal=q;
    	if(inputVal==null){
    		return null;
    	}
    	System.out.println("table alias="+name);
    	inputVal=inputVal.toUpperCase();//转换为大写
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("maxRows","21");//21表示没有任何输入时，最多返回的行数
		paramMap.put("name",name);//表别名
		if(inputVal.matches("^\\d+")){//数字开头
			paramMap.put("id",inputVal);//输入值为id
		}
		else{
			paramMap.put("py",inputVal);//输入值为py
		}
		System.out.println("inputVal："+inputVal);
    	List idNameList=null;
		try {
			idNameList = nameValuePairService.getNameValueByCondition(paramMap);
			
			System.out.println(inputVal+","+idNameList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//从服务层获得列表信息
        
    	return idNameList; //返回一个List	
	}
    /**************返回过滤组织机构**************************/   

   	//查找pcs是否在列表中
   	private boolean  findPcs(String pcs){
   		boolean bFound=false;
   		for(int i=0;i<exceptPcs.length;i++){
   			if(pcs.equals(exceptPcs[i])){
   				bFound=true;
   				break;
   			}
   		}
   		return bFound;
   	}    
   	
   	@RequestMapping(value = "/getFilterOrgCode")
       public 	@ResponseBody String getFilterOrgCode(){
       	
       	SessionBean userInfo = getSessionBean();
       	String userOrgCode=userInfo.getUserOrgCode();
       	String userOrgIDPath=userInfo.getUserOrgIDPath();
       	System.out.println(userOrgCode+"/"+userOrgIDPath);
       	String[] ids=userOrgIDPath.split(",");

       	String filterOrgCode="";//过滤机构代码
       	String parentOrgCode="210204410000";//ids[ids.length-2];//后台计算
       	parentOrgCode=userInfo.getExtendValue("parentOrgCode");//上级代码
       	int level=ids.length;//层次
       	System.out.println("level==@"+level+",userOrgCode="+userOrgCode);
       	if(level<=3){//
       		filterOrgCode=parentOrgCode;//上级代码
       		//System.out.println("substring(0,8)--@"+userOrgCode.substring(0,8));
       		//edited by yanpeidan  if(userOrgCode.startsWith("21020021")){//交警支队 substring(0,8).equals("21020021")
       		if(userOrgCode.startsWith("210200")){
       			filterOrgCode="210200000000";//全市
       			//System.out.println("level==@"+level+",filterOrgCode="+filterOrgCode);
       		}
       		else if((userOrgCode.substring(6,8).compareTo("41")>=0) || findPcs(userOrgCode)){//派出所
       			filterOrgCode=userOrgCode;
       			System.out.println("level==》"+level+",filterOrgCode="+filterOrgCode);
       		}
       		else{
       			filterOrgCode=parentOrgCode;//取父级?
       		}
       	}
       	else{
       		if(level==4){//责任区
       			if(userInfo.getUserOrgName().indexOf("责任区")>=0){
       				filterOrgCode=parentOrgCode;			
       			}
       			else{
       				filterOrgCode=userOrgCode;//第四层为其本身
       			}
       		}
       		if(level==5){//中队下面的社区/责任区
       			filterOrgCode=parentOrgCode;	
       		}

       	}
       	System.out.println("level=="+level+",filterOrgCode="+filterOrgCode);
       	return filterOrgCode;
       }
   	
   	
	//根据机构代码查找其所在的2级部门(大连市公安局为第1级),返回值为空，说明本级为大连市公安局，否则为orgCode所在的2级部门
    @RequestMapping(value = "/get2LevelDepartByOrgCode")
	public String get2LevelDepartByOrgCode() {
		// TODO Auto-generated method stub
       	SessionBean userInfo = getSessionBean();
       	String userOrgCode=userInfo.getUserOrgCode();

		return nameValuePairService.get2LevelDepartByOrgCode(userOrgCode);
	}

	//根据2级机构获得平台名称	
	@RequestMapping(value = "/getPlatformByOrgCode")
	public @ResponseBody List getPlatformByOrgCode() {		
       	SessionBean userInfo = getSessionBean();
       	String userOrgCode=userInfo.getUserOrgCode();
     	
		String twoLevelOrgCode=nameValuePairService.get2LevelDepartByOrgCode(userOrgCode);
       	//可以在此返回210200000000以便处理市局共享平台。例如科技处的人员
		/* 2014.12.16.16:17
       	if(twoLevelOrgCode.equals("210200150000")){
       		twoLevelOrgCode="210200000000";
       	} 
       	*/
		System.out.println("userOrgCode="+userOrgCode+",twoLevelOrgCode:"+twoLevelOrgCode);
		return nameValuePairService.getPlatformByOrgCode(twoLevelOrgCode); // 返回一个List

	}
	
	//根据2级机构获得其边界坐标串	2014.12.19
	@RequestMapping(value = "/getBjzbzByOrgCode")
	public @ResponseBody String getBjzbzByOrgCode() {		
       	SessionBean userInfo = getSessionBean();
       	String userOrgCode=userInfo.getUserOrgCode();
     	
		String twoLevelOrgCode=nameValuePairService.get2LevelDepartByOrgCode(userOrgCode);
		String bjzbz=nameValuePairService.getBjzbzByOrgCode(twoLevelOrgCode); // 返回一个String
		System.out.println("userOrgCode="+userOrgCode+",twoLevelOrgCode:"+twoLevelOrgCode+",bjzbz:"+bjzbz);
		return bjzbz;

	}
	//获得摄像头统计值
	@RequestMapping(value = "/getSxtStatistic")
	public @ResponseBody List getSxtStatistic(HttpSession session) {
		String owner=(String)session.getAttribute("owner");
		if(owner==null)owner="";//测试用
		int sfgazj=owner.equalsIgnoreCase("noPolice")? 0:1;
		
		Map<String,Integer> paramMap=new HashMap<String,Integer>();
		paramMap.put("sfgazj", sfgazj);
		return nameValuePairService.getSxtStatistic(paramMap);
	}
	
	//测试获得机构(分局)当前计数值
	@RequestMapping(value = "/getCurrentCounterValue")
	public @ResponseBody int getCurrentCounterValue(){
		SessionBean sessionBean = getSessionBean();	
		String userOrgCode=sessionBean.getUserOrgCode();				
		String fjCode=nameValuePairService.get2LevelDepartByOrgCode(userOrgCode);//    userOrgCode.substring(0,6)+"000000";
		//fjCode="210212460007";
		System.out.println("userOrgCode="+userOrgCode+",fjCode="+fjCode);
		int currentValue=nameValuePairService.getCurrentCounterValue(fjCode);
		return currentValue;//
	}
}
