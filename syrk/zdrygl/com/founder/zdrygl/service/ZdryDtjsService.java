package com.founder.zdrygl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryDtjsClxxb;
import com.founder.zdrygl.bean.ZdryDtjsGxbgxxb;
import com.founder.zdrygl.bean.ZdryDtjsSaxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdfdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdxdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdzdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSfxxb;
import com.founder.zdrygl.bean.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.bean.ZdryDtjsSwxxb;
import com.founder.zdrygl.bean.ZdryDtjsXsxxb;
import com.founder.zdrygl.bean.ZdryDtjsZdxsfzqkxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrxxb;
import com.founder.zdrygl.bean.ZdryDtjsZtxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZszhjlxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员表相关服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("重点人员动态记实服务")
public interface ZdryDtjsService {


	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryRyxsList(EasyUIPage page, ZdryDtjsXsxxb entity);	
	
	/**
	 * @Title: saveRyxsb
	 * @Description: TODO(人员写实表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveDtjs(ZdryDtjsXsxxb entity);

	public void saveSwxxb(ZdryDtjsSwxxb entity);
	
	public void saveZtxxb(ZdryDtjsZtxxb entity);
	
	public void saveSfxxb(ZdryDtjsSfxxb entity);
	
	public void saveSdxdxxb(ZdryDtjsSdxdxxb entity);
	
	public void saveSdfdxxb(ZdryDtjsSdfdxxb entity);
	
	public void saveSdzdxxb(ZdryDtjsSdzdxxb entity);
	
	public void saveZdxsfzqkxxb(ZdryDtjsZdxsfzqkxxb entity) ;
	
	public void saveZszhjsbrxxb(ZdryDtjsZszhjsbrxxb entity);
	public void saveZszhjsbrZdjlxxb(ZdryDtjsZszhjsbrZdjlxxb entity);
	public void saveZszhjsbrZszhjlxxb(ZdryDtjsZszhjsbrZszhjlxxb entity);
	
	public void updateGxbg(ZdryDtjsGxbgxxb entity);
	public String saveShgxr(ZdryDtjsShgxrxxb entity);
	public String saveSaxx(ZdryDtjsSaxxb entity);
	public String saveClxx(ZdryDtjsClxxb entity);
	
	public EasyUIPage queryDtjsZtxxList(EasyUIPage page, ZdryDtjsZtxxb entity);
	public EasyUIPage queryDtjsSwxxList(EasyUIPage page, ZdryDtjsSwxxb entity);
	public EasyUIPage queryDtjsSfxxList(EasyUIPage page, ZdryDtjsSfxxb entity);
	public EasyUIPage queryDtjsSdxdxxList(EasyUIPage page, ZdryDtjsSdxdxxb entity);
	public EasyUIPage queryDtjsSdfdxxList(EasyUIPage page, ZdryDtjsSdfdxxb entity);
	public EasyUIPage queryDtjsSdzdxxList(EasyUIPage page, ZdryDtjsSdzdxxb entity);
	public EasyUIPage queryDtjsZdxsfzqkxxList(EasyUIPage page, ZdryDtjsZdxsfzqkxxb entity);
	public EasyUIPage queryDtjsZszhjsbrxxList(EasyUIPage page, ZdryDtjsZszhjsbrxxb entity);	
	public EasyUIPage queryDtjsZszhjsbrZdjlxxList(EasyUIPage page, ZdryDtjsZszhjsbrZdjlxxb entity);
	public EasyUIPage queryDtjsZszhjsbrZszhjlxxList(EasyUIPage page,ZdryDtjsZszhjsbrZszhjlxxb entity);
	
	public EasyUIPage queryGxbgList(EasyUIPage page, ZdryDtjsGxbgxxb entity);
	public EasyUIPage queryShgxrList(EasyUIPage page, ZdryDtjsShgxrxxb entity);
	public EasyUIPage querySaxxList(EasyUIPage page, ZdryDtjsSaxxb entity);
	public EasyUIPage queryClxxList(EasyUIPage page, ZdryDtjsClxxb entity);
	
}
