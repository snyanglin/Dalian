package com.founder.zdrygl.core.utils;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.TreeDataBuilder;
import com.founder.framework.utils.TreeNode;
import com.founder.zdrygl.core.dao.ZdryInitializeDao;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.utils.ZdryConstant.java]  
 * @ClassName:    [ZdryConstant]   
 * @Description:  [重点人员管理常量，包含管理状态，重点人员类别字典]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年8月31日 下午11:01:15]   
 * @UpdateUser:   [lenovo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月31日 下午11:01:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class ZdryConstant {
	
	@Autowired
	private  ZdryInitializeDao zdryInitializeDao;
	
	private static Map<String,String> zdryServiceMap = new HashMap<String,String>();
	private static Map<String,String> zdryDict = new HashMap<String,String>();
	/**管理状态*/
	private static Map<String,String> glztStrMap = new HashMap<String,String>();
	
	public static final String LGSQ = "1";
	public static final String YLG = "2";
	public static final String CGSQ = "3";
	public static final String YCG = "4";
	public static final String ZDSQ = "5";
	public static final String XF = "6";
	public static final String ZLSQ = "7";
		
	/**
	 * 动态读取数据库配置数据
	 */
	static {
		zdryServiceMap.put("00", "com.founder.zdrygl.base.service.ZdryzbService");
		glztStrMap.put(LGSQ, "列管申请中");
		glztStrMap.put(YLG, "已列管");
		glztStrMap.put(CGSQ, "撤管申请中");
		glztStrMap.put(YCG, "已撤管");
		glztStrMap.put(ZDSQ, "转递申请中");
		glztStrMap.put(XF, "下发中");
		glztStrMap.put(ZLSQ, "转类申请中");
	}
	
	/**
	 *  TODO(总表service配置待改造)
	 */
	
	public Map<String,String> zdryServiceMap(){
		if(zdryServiceMap.size() == 1)
			zdryServiceMap.putAll(zdryInitializeDao.queryZdrylxMap(SystemConfig.getString(AppConst.XZQH)==""?"210000":SystemConfig.getString(AppConst.XZQH)));
		return zdryServiceMap;
	}
	
	public String getValueOfZdryServiceMap(String zdrylxdm){
		if(zdryServiceMap.size() == 1)
			zdryServiceMap.putAll(zdryInitializeDao.queryZdrylxMap(SystemConfig.getString(AppConst.XZQH)==""?"210000":SystemConfig.getString(AppConst.XZQH)));
		return zdryServiceMap.get(zdrylxdm);
	}
	
	public Map<String,String> zdryDict(){
		
		if(zdryDict.isEmpty())
			zdryDict.putAll(zdryInitializeDao.queryZdryDict(SystemConfig.getString(AppConst.XZQH)==""?"210000":SystemConfig.getString(AppConst.XZQH)));
		return zdryDict;
	}
	
	public String getValueOfZdryDict(String zdrylxdm){
		if(zdryDict.isEmpty())
			zdryDict.putAll(zdryInitializeDao.queryZdryDict(SystemConfig.getString(AppConst.XZQH)==""?"210000":SystemConfig.getString(AppConst.XZQH)));
		return zdryDict.get(zdrylxdm);
	}
	
	public List<?> queryChildByQydm(String qydm,String lbdm_p){
		return zdryInitializeDao.getChildList(lbdm_p,qydm);
	}
	
	/**
	 * 
	 * @Title: getGlztStr
	 * @Description: (获取管理状态中文)
	 * @param @param glzt 管理状态
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String getGlztStr(String glzt){
		
		return glztStrMap.get(glzt);
	}
	
	public void createTreeJS(){
		String JSPath = SystemConfig.getString("webRootPath") + "/common/dict/";	
		String tableNameUpper = "BD_D_ZDRYGLLX";
		try{		
		//生成管理类型字典js		
		List<TreeNode> gllxNodeList = this.queryChildNodeList(null);	
		
		if (gllxNodeList != null && gllxNodeList.size() > 0) { // 有数据			
			
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write(TreeDataBuilder.getTreeData(gllxNodeList));			
			fileWriter.flush();
			fileWriter.close();
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		} else {			
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write("[]");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("字典： " + tableNameUpper + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		} 

		//查询所有重点人员类型，包含小类
		tableNameUpper="BD_D_ZDRYLB";	
		TreeNode treeNode;
		if (gllxNodeList != null && gllxNodeList.size() > 0) { // 有数据			
			for (int i = 0; i < gllxNodeList.size(); i++) {
				treeNode = (TreeNode) gllxNodeList.get(i);						
				treeNode.setChildren(queryChildNodeList(treeNode));				
			}			
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write(TreeDataBuilder.getTreeData(gllxNodeList));			
			fileWriter.flush();
			fileWriter.close();
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		} else {			
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write("[]");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("字典： " + tableNameUpper + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		}		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<TreeNode> queryChildNodeList(TreeNode parrentNode){
		String qydm = SystemConfig.getString(AppConst.XZQH);
		String lbdm_p = "999999";
		if(parrentNode!=null) lbdm_p = parrentNode.getId();
		
		List dictList = zdryInitializeDao.getChildList(lbdm_p,org.springframework.util.StringUtils.isEmpty(qydm)?"210000":qydm);
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		if (dictList != null && dictList.size() > 0) { // 有数据
			Map<String,String> dictMap;			
			for (int i = 0; i < dictList.size(); i++) {
				dictMap = (Map) dictList.get(i);
				TreeNode treeNode = new TreeNode();
				treeNode.setId((String)dictMap.get("key"));
				treeNode.setText((String)dictMap.get("value"));	
				if(!"999999".equals(lbdm_p)){//需要查询子列表
					treeNode.setChildren(queryChildNodeList(treeNode));
				}
				nodeList.add(treeNode);
			}
		}			
		
		return nodeList;
	}	
}
