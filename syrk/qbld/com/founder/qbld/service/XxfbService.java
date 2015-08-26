package com.founder.qbld.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.XxfbArticle;
import com.founder.qbld.bean.XxfbClass;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.XxfbService.java]  
 * @ClassName:    [XxfbService]   
 * @Description:  [信息发布服务]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-26 上午9:24:44]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-26 上午9:24:44，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("信息发布")
public interface XxfbService {

	/**
	 * @Title: queryClassList
	 * @Description: TODO(信息发布类型列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryClassList(EasyUIPage page, XxfbClass entity);
	
	/**
	 * @Title: queryArticleList
	 * @Description: TODO(信息发布内容列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryArticleList(EasyUIPage page, XxfbArticle entity);
	
	/**
	 * @Title: queryArticleListFive
	 * @Description: TODO(信息发布内容列表5条查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryArticleListFive(EasyUIPage page, XxfbArticle entity);
	
	/**
	 * @Title: queryArticle
	 * @Description: TODO(信息发布内容详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return XxfbArticle    返回类型
	 * @throws
	 */
	public XxfbArticle queryArticle(XxfbArticle entity);
	
}
