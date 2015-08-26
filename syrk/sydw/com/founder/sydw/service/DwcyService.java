package com.founder.sydw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.Dwcyxxb;
import com.founder.sydw.bean.Xfdwcccsxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.DwcyService.java]  
 * @ClassName:    [DwcyService]   
 * @Description:  单次抽样
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-7-8 上午9:25:55]   
 * @UpdateUser:   [xu_haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-8 上午9:25:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("单次抽样")
public interface DwcyService {
	
	/**
	 * 
	 * @Title: saveXfdwcyxxb
	 * @Description: 保存消防单位单次抽样信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: modifyXfdwcyxxb
	 * @Description: 修改消防单位单次抽样信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void modifyXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: deleteXfdwcyxxb
	 * @Description: 删除消防单位单次抽样信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void deleteXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryXfdwcyxxbForPage
	 * @Description: 分页查询消防单位单次抽样信息
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryXfdwcyxxbForPage(EasyUIPage page,Dwcyxxb entity);
	
	/**
	 * 
	 * @Title: queryXfdwcyxxb
	 * @Description: 查询多条消防单位单次抽样信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Dwcyxxb    返回类型
	 * @throws
	 */
	public Dwcyxxb queryXfdwcyxxb(Dwcyxxb entity);
	/**
	 * 
	 * @Title: querycccs
	 * @Description: TODO(查询抽查次数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public String querycccs(Dwcyxxb entity);
	
	/**
	 * 
	 * @Title: queryXfdwcyxxbList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Dwcyxxb>    返回类型
	 * @throws
	 */
	public List<Dwcyxxb> queryXfdwcyxxbList(Dwcyxxb entity);
	/**
	 * 
	 * @Title: querysydw
	 * @Description: TODO(查询 所有单位)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<DwOwnXFBean>    返回类型
	 * @throws
	 */
	public List<DwOwnXFBean> querysydw(Dwcyxxb entity);
	/**
	 * 
	 * @Title: queryycdw
	 * @Description: TODO(查询已抽单位)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<DwOwnXFBean>    返回类型
	 * @throws
	 */
	public List<DwOwnXFBean> queryycdw(Dwcyxxb entity);
	/**
	 * 
	 * @Title: querywcdw
	 * @Description: TODO(查询未抽单位)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<DwOwnXFBean>    返回类型
	 * @throws
	 */
	public List<DwOwnXFBean> querywcdw(Dwcyxxb entity);
}
