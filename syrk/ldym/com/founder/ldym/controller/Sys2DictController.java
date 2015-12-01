package com.founder.ldym.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.ldym.pojo.SysDict;
import com.founder.ldym.service.SysDictService;
import com.founder.ldym.util.StringUtil;

/**
 * 
 * <p>标题：字典控制层</p>
 * <p>描述：对字典进行查询和维护</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-3-12</p>
 * @author	yi_chu
 */
@Controller
@RequestMapping(value="/dictionary")
public class Sys2DictController extends BaseController {

	/**
	 * SysDictService自动装配
	 */
	@Resource(name="dictService")
	private SysDictService sysDictService;

	/**
	 * <p>说明：获取列表JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param xzqh 行政区划
	 * @param dldm 道路代码
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDictListJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getDictListJSON(@ModelAttribute SysDict entity, String xzqh, String dldm) {
//		String returnJSStr = null;
//		if (SystemConfig.getString("JT_ROADITEM").equals(entity.getZdbh().toUpperCase()) || SystemConfig.getString("JT_ROADSEGITEM").equals(entity.getZdbh().toUpperCase())) {// GIS用户下的表封装字典
//			returnJSStr = sysDictService.createListJS(entity.getZdbh(), entity.getZdmc(), xzqh, dldm);
//		} else {
//			returnJSStr = sysDictService.createListJS(entity.getZdbh(), entity.getZdmc());
//		}
//		
//		returnJSStr = "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr + "</script>";
//		Map<String, String> model = new HashMap<String, String>();
//		model.put(entity.getZdbh(), returnJSStr);
//		return toJSONResponse(model);
//	}
	
	/**
	 * 
	 * <p>说明：获取列表JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDictionaryListJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getDictListJSON(@ModelAttribute SysDict entity) {
//		List<SysDict> list = sysDictService.getDictList(entity.getZdbh());
//		
//		return toJSONResponseRoadInfo(list);
//	}
	/**
	 * 
	 * <p>说明：获取列表JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getXzmc.f")
//	@ResponseBody
//	public ResponseEntity<String> getXzmc(@ModelAttribute SysDict entity) {
//		List<SysDict> list = sysDictService.getXzmc(entity.getZdbh(),this.getUser());
//		return toJSONResponseRoadInfo(list);
//	}
	/**
	 * 
	 * @param entity
	 * @return
	 */
//	@RequestMapping("/getBjlx.f")
//	@ResponseBody
//	public ResponseEntity<String> getBjlx(@ModelAttribute SysDict entity) {
//		List<SysDict> list = sysDictService.getBjlx();
//		return toJSONResponseRoadInfo(list);
//	}
	/**
	 * 
	 * <p>说明：获取列表JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param sql 查询的完整sql语句
	 * @param attribute 查询传入的参数，多个以逗号隔开
	 * @param attributeType 传入参数的类型，多个以逗号隔开，位置与参数对应(String和integer类型)
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDictListJSONBySql.f")
//	@ResponseBody
//	public ResponseEntity<String> getDictListJSONBySql(String sql, String attribute, String attributeType) {
//		Object[] objectArray = null;
//		if (null == attribute || "".equals(attribute))
//		{
//			attribute = "";
//		}
//		else 
//		{
//			String[] attributeArray = attribute.split(",");
//			String[] attributeTypeArray = attributeType.split(",");
//			objectArray = new Object[attributeArray.length];
//			for (int i = 0; i < attributeTypeArray.length; i++)
//			{
//				if ("integer".equals(attributeTypeArray[i]))
//				{
//					objectArray[i] = Integer.parseInt(attributeArray[i]);
//				}
//				objectArray[i] = attributeArray[i];
//			}
//		}
//		List<SysDict> list = sysDictService.findAllListBySql(sql,objectArray);
//		
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * 检查字典查询sql语句合法性
	 * @param sql  sql语句
	 * @return ResponseEntity<String>
	 */
//	@RequestMapping("/checkSql.f")
//	@ResponseBody
//	public ResponseEntity<String> checkSql(String sql){
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("result", "success");
//		try
//		{
//			sysDictService.checkSql(sql);
//		}
//		catch(Exception e)
//		{
//			map.put("result", "error");
//		}
//		return super.toJSONResponse(map);
//	}
	
	/**
	 * 
	 * <p>说明：获取列表JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param sql 查询的完整sql语句
	 * @param attribute 查询传入的参数，多个以逗号隔开
	 * @param attributeType 传入参数的类型，多个以逗号隔开，位置与参数对应(String和integer类型)
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDistinctDictListJSONBySql.f")
//	@ResponseBody
//	public ResponseEntity<String> getDistinctDictListJSONBySql(String sql, String attribute, String attributeType) {
//		Object[] objectArray = null;
//		if (null == attribute || "".equals(attribute))
//		{
//			attribute = "";
//		}
//		else 
//		{
//			String[] attributeArray = attribute.split(",");
//			String[] attributeTypeArray = attributeType.split(",");
//			objectArray = new Object[attributeArray.length];
//			for (int i = 0; i < attributeTypeArray.length; i++)
//			{
//				if ("integer".equals(attributeTypeArray[i]))
//				{
//					objectArray[i] = Integer.parseInt(attributeArray[i]);
//				}
//				objectArray[i] = attributeArray[i];
//			}
//		}
//		List<SysDict> list = sysDictService.findAllListBySql(sql,objectArray);
//		List<SysDict> list1 = new ArrayList<SysDict>();
//		String dm = "";
//		for (SysDict sysDict : list)
//		{
//			if (!dm.equals(sysDict.getDm()))
//			{
//				list1.add(sysDict);
//				dm = sysDict.getDm();
//			}
//		}
//		return toJSONResponseRoadInfo(list1);
//	}
	
	/**
	 * 
	 * <p>说明：获取列表JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDictListJSONOrderBy.f")
//	@ResponseBody
//	public ResponseEntity<String> getDictListJSONOrderBy(@ModelAttribute SysDict entity) {
//		List<SysDict> list = sysDictService.getDictListOrderBy(entity.getZdbh(), entity.getBz());
//		
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * 
	 * <p>说明：获取列表JS</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param xzqh 行政区划
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDlDictionaryListJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getDlDictListJSON(@ModelAttribute SysDict entity, String xzqh) {
//		List<SysDict> list = sysDictService.getDlDictList(entity.getZdbh(), xzqh);
//		
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * 
	 * <p>说明：获取列表JS</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param dldm 道路代码
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getLdDictionaryListJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getLdDictListJSON(@ModelAttribute SysDict entity, String dldm) {
//		List<SysDict> list = sysDictService.getLdDictList(entity.getZdbh(), dldm);
//		
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * 
	 * <p>说明：获取列表JS</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param dldm 道路代码
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getGpsCarTypeDictListJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getGpsCarTypeDictListJSON(@ModelAttribute SysDict entity) {
//		List<SysDict> list = sysDictService.getGpsCarTypeDictList(entity.getZdbh());
//		
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * <p>说明：根据行政区划获取路段信息</p>
	 * <p>时间：2014-4-10 下午5:43:29</p>
	 * @param zdbh 路段字典
	 * @param xzqh 行政区划
	 * @return 路段信息
	 */
//	@RequestMapping("/getLdDictJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getLdDictJSON(String zdbh, String xzqh) {
//		List<SysDict> list = sysDictService.getLdByXzqh(zdbh, xzqh);
//		return toJSONResponseRoadInfo(list);
//	}

	/**
	 * <p>说明：响应道路信息</p>
	 * <p>时间：2014-4-10 下午5:44:47</p>
	 * @param list 道路数据列表
	 * @return 响应JSON
	 */
//	private ResponseEntity<String> toJSONResponseRoadInfo(List<SysDict> list) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("list", list);
//		return toJSONResponse(model);
//	}
	
	/**
	 * 
	 * <p>说明：获取树形JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getDictTreeJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getDictTreeJSON(@ModelAttribute SysDict entity) {
//		String returnJSStr = sysDictService.createTreeJS(entity.getZdbh(), entity.getZdmc());
//		Map<String, String> model = new HashMap<String, String>();
//		model.put(entity.getZdbh(), "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr.split("■")[0] + "</script>");
//		//model.put(entity.getZdbh() + "_DATA", returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, ""));
//		//model.put(entity.getZdbh() + "_DATA", "<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text: "+ entity.getZdmc() + "';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>");
//		//model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text: "+ entity.getZdmc() + "';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
//		model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text:';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
//		
//		return toJSONResponse(model);
//	}
	
	/**
	 * 
	 * <p>说明：获取组织机构树形JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param request 请求对象
	 * @param entity POJO对象
	 * @param zzjgdm 组织机构代码
	 * @param auth 权限 v322
	 * @return  ResponseEntity<String>
	 */
	@RequestMapping(value = "/getOrganizationDictTreeJSON" , method =RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getOrganizationDictTreeJSON(HttpServletRequest request, @ModelAttribute SysDict entity, String zzjgdm, String auth) {
		String userId = null;
		if ("1".equals(auth) || "11".equals(auth)) {
			SessionBean sb = getSessionBean();
			userId = (sb == null ? "" : sb.getUserId());
		}
		
		String returnJSStr = sysDictService.createOrganizationTreeJS(entity.getZdbh(), entity.getZdmc(), zzjgdm, auth, userId);
		Map<String, String> model = new HashMap<String, String>();
		model.put(entity.getZdbh(), "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr.split("■")[0] + "</script>");
		//model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text: "+ entity.getZdmc() + "';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
		model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text:';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
		
		return model;
	}
	
	@RequestMapping(value = "/getLocalOrganizationDictTreeJSON" , method =RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getLocalOrganizationDictTreeJSON(HttpServletRequest request, @ModelAttribute SysDict entity, String zzjgdm, String auth) {
		String userId = null;
		if ("1".equals(auth) || "11".equals(auth)) {
			SessionBean sb = getSessionBean();
			userId = (sb == null ? "" : sb.getUserId());
		}
		
		String returnJSStr = sysDictService.createLocalOrganizationTreeJS(entity.getZdbh(), entity.getZdmc(), zzjgdm, auth, userId);
		Map<String, String> model = new HashMap<String, String>();
		model.put(entity.getZdbh(), "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr.split("■")[0] + "</script>");
		//model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text: "+ entity.getZdmc() + "';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
		model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text:';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
		
		return model;
	}
	/**
	 * 
	 * <p>说明：获取gps分组树形JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param zzjgdm 组织机构代码
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getGpsDictTreeJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getGpsDictTreeJSON(@ModelAttribute SysDict entity, String zzjgdm) {
//		String returnJSStr = sysDictService.createGpsTreeJS(entity.getZdbh(), entity.getZdmc(), zzjgdm);
//		Map<String, String> model = new HashMap<String, String>();
//		model.put(entity.getZdbh(), "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr.split("■")[0] + "</script>");
//		//model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text: "+ entity.getZdmc() + "';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
//		model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text:';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
////		//System.out.print(model);
//		return toJSONResponse(model);
//	}
	
	/**
	 * 
	 * <p>说明：获取带有权限的组织机构树形JSON</p>
	 * <p>时间：2014-3-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param zzjgdm 组织机构代码
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getAuthorityOrganizationDictTreeJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getAuthorityOrganizationDictTreeJSON(@ModelAttribute SysDict entity, String zzjgdm) {
//		String userId=super.getUser().getUserId();
//		String returnJSStr = sysDictService.createAuthorityOrganizationTreeJS(entity.getZdbh(), entity.getZdmc(), zzjgdm,userId);
//		Map<String, String> model = new HashMap<String, String>();
//		model.put(entity.getZdbh(), "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr.split("■")[0] + "</script>");
//		model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text:';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
//		
//		return toJSONResponse(model);
//	}
	
	/**
	 * <p>说明：获取警情类别级联</p>
	 * <p>时间：2014-4-1 下午17:19:15</p>
	 * @param zddm   字典代码
	 * @param count  后缀长度
	 * @return 级联json
	 */
//	@RequestMapping("/jqlbDict.f")
//	public ResponseEntity<String> getDictJqlbJSON(String zdbh, String zddm, int count){
//		List<SysDict> list = sysDictService.getDictList(zdbh, zddm, count);
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * <p>说明：获得组织机构字典（大队、中队）</p>
	 * <p>时间：2014-4-3 下午6:40:07</p>
	 * @param zzjgdm 大队
	 * @param zzjglx 中队
	 * @return ResponseEntity<String>
	 */
//	@RequestMapping("/zzjgDict.f")
//	public ResponseEntity<String> getZzjgDict(String zzjgdm, String zzjglx){
//		List<SysDict> list = null;
//		if (null == zzjgdm)
//		{
//			list = sysDictService.getSysDictListByZzjglx(zzjglx);
//		}
//		else if (null == zzjglx)
//		{
//			list = sysDictService.getSysDictListByZzjgdm(zzjgdm);
//		}
//		return toJSONResponseRoadInfo(list);
//	}
	
	
	/**
	 * <p>说明：获得定位设备类型字典</p>
	 * <p>时间：2014-7-31 下午6:40:07</p>
	 * @param zdbh 字典编号
	 * @return ResponseEntity<String>
	 */
//	@RequestMapping("/sblxDict.f")
//	public ResponseEntity<String> getSblxDict(String zdbh){
//		List<SysDict> list = null;
//	    list = sysDictService.getSysDictListByGpssbdm(zdbh);
//		return toJSONResponseRoadInfo(list);
//	}
	
	
	/**
	 * 
	 * <p>说明：获取基础资源分组树形JSON</p>
	 * <p>时间：2014-8-12 下午4:42:48</p>
	 * @param entity POJO对象
	 * @param zzjgdm 代码
	 * @return  ResponseEntity<String>
	 */
//	@RequestMapping("/getZyglDictTreeJSON.f")
//	@ResponseBody
//	public ResponseEntity<String> getJczyDictTreeJSON(@ModelAttribute SysDict entity, String zzjgdm) {
//		String returnJSStr = sysDictService.createJczyTreeJS(entity.getZdbh(), entity.getZdmc(), zzjgdm);
//		Map<String, String> model = new HashMap<String, String>();
//		model.put(entity.getZdbh(), "<script type='text/javascript'>" + StringUtil.enterNewline + returnJSStr.split("■")[0] + "</script>");
//		//model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text: "+ entity.getZdmc() + "';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
//		model.put(entity.getZdbh() + "_DATA", ("<script type='text/javascript'>" + StringUtil.enterNewline + "var data = {};" + StringUtil.enterNewline + "data['-1_RO'] = 'text:';" + StringUtil.enterNewline + returnJSStr.split("■")[1].replace("var data = {};" + StringUtil.enterNewline, "") + "</script>").replaceAll("data", "data_" + entity.getZdbh()));
////    	//System.out.print(model);
//		return toJSONResponse(model);
//	}
	
	/**
	 * 获得表字段的字典对象
	 * @param table 表
	 * @return ResponseEntity<String>
	 */
//	@RequestMapping("/getTableColumnSysDict.f")
//	@ResponseBody
//	public ResponseEntity<String> getTableColumnSysDict(String table){
//		List<SysDict> list = sysDictService.getTableColumnSysDict(table);
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * 智能交管用户下表的字典
	 * @return ResponseEntity<String>
	 */
//	@RequestMapping("/getTableNameFromOwner.f")
//	@ResponseBody
//	public ResponseEntity<String> getTableNameFromOwner(){
//		List<SysDict> list = sysDictService.getTableNameFromOwner();
//		List<SysDict> list1 = sysDictService.getViewNameFromOwner();
//		list.addAll(list1);
//		return toJSONResponseRoadInfo(list);
//	}
	
	/**
	 * 获得勤务排班班次字典
	 * @param dwdm 单位代码
	 * @return ResponseEntity<String>
	 */
//	@RequestMapping("/getQwglBcDict.f")
//	@ResponseBody
//	public ResponseEntity<String> getQwglBcDict(String dwdm){
//		List<SysDict> list = sysDictService.getQwglBcDict(dwdm);
//		return toJSONResponseRoadInfo(list);
//	}
	
}