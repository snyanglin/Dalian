package com.founder.qbld.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Clxxb;
import com.founder.qbld.bean.Saxxb;
import com.founder.qbld.bean.Shgxrb;
import com.founder.qbld.bean.Zdjlb;
import com.founder.qbld.bean.ZdryGxbg;
import com.founder.qbld.bean.ZdrySdFd;
import com.founder.qbld.bean.ZdrySdXd;
import com.founder.qbld.bean.ZdrySdZd;
import com.founder.qbld.bean.ZdrySf;
import com.founder.qbld.bean.ZdrySw;
import com.founder.qbld.bean.ZdryZdxsfzqk;
import com.founder.qbld.bean.ZdryZszhjsb;
import com.founder.qbld.bean.ZdryZt;
import com.founder.qbld.bean.Zdryb;
import com.founder.qbld.bean.Zsjlb;

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
@TypeAnnotation("重点人员")
public interface ZdryService {

	/**
	 * @Title: queryZdryList
	 * @Description: TODO(重点人员列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdryList(EasyUIPage page, Zdryb entity);
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(重点人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Zdryb queryZdryb(Zdryb entity);
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(重点人员 - 保存重点人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryb(Zdryb entity);
	
	/**
	 * @Title: updateZdryxxb
	 * @Description: TODO(更新重点人员)
	 * @param @param qsfkzt
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateZdryxxb(String sfzh);
	
	/**
	 * @Title: queryZdryZtList
	 * @Description: TODO(重点人员在逃列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdryZtList(EasyUIPage page, ZdryZt entity);
	
	/**
	 * @Title: queryZdryZtb
	 * @Description: TODO(重点人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdryZt    返回类型
	 * @throws
	 */
	public ZdryZt queryZdryZtb(ZdryZt entity);
	
	/**
	 * @Title: saveZdryZtb
	 * @Description: TODO(重点人员 - 保存在逃人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryZtb(ZdryZt entity);
	
	/**
	 * @Title: queryZdrySwList
	 * @Description: TODO(重点人员涉稳列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdrySwList(EasyUIPage page, ZdrySw entity);
	
	/**
	 * @Title: queryZdrySwb
	 * @Description: TODO(重点涉稳人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySw    返回类型
	 * @throws
	 */
	public ZdrySw queryZdrySwb(ZdrySw entity);
	
	/**
	 * @Title: saveZdrySwb
	 * @Description: TODO(重点人员 - 保存涉稳人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySwb(ZdrySw entity);
	
	/**
	 * @Title: queryZdryZszhjsbList
	 * @Description: TODO(肇事肇祸精神病表列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdryZszhjsbList(EasyUIPage page, ZdryZszhjsb entity);
	
	/**
	 * @Title: queryZdryZszhjsbb
	 * @Description: TODO(肇事肇祸精神病表详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdryZszhjsb    返回类型
	 * @throws
	 */
	public ZdryZszhjsb queryZdryZszhjsb(ZdryZszhjsb entity);
	
	/**
	 * @Title: saveZdryZszhjsbb
	 * @Description: TODO(重点人员 - 保存肇事肇祸精神病人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryZszhjsb(ZdryZszhjsb entity);
	
	/**
	 * @Title: queryZdryZdxsfzqkList
	 * @Description: TODO(重大刑事犯罪前科查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdryZdxsfzqkList(EasyUIPage page, ZdryZdxsfzqk entity);
	
	/**
	 * @Title: queryZdryZdxsfzqkb
	 * @Description: TODO(重大刑事犯罪前科详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdryZdxsfzqk    返回类型
	 * @throws
	 */
	public ZdryZdxsfzqk queryZdryZdxsfzqk(ZdryZdxsfzqk entity);
	
	/**
	 * @Title: saveZdryZdxsfzqkb
	 * @Description: TODO(重点人员 - 保存重大刑事犯罪前科)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryZdxsfzqk(ZdryZdxsfzqk entity);
	
	/**
	 * @Title: queryZdrySfList
	 * @Description: TODO(涉访查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdrySfList(EasyUIPage page, ZdrySf entity);
	
	/**
	 * @Title: queryZdrySfb
	 * @Description: TODO(涉访详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySf    返回类型
	 * @throws
	 */
	public ZdrySf queryZdrySf(ZdrySf entity);
	
	/**
	 * @Title: saveZdrySf
	 * @Description: TODO(重点人员 - 保存涉访)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySf(ZdrySf entity);
	
	/**
	 * @Title: queryZdrySdFdList
	 * @Description: TODO(贩毒查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdrySdFdList(EasyUIPage page, ZdrySdFd entity);
	
	/**
	 * @Title: queryZdrySdFdb
	 * @Description: TODO(贩毒详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySdFd    返回类型
	 * @throws
	 */
	public ZdrySdFd queryZdrySdFd(ZdrySdFd entity);
	
	/**
	 * @Title: saveZdrySdFd
	 * @Description: TODO(重点人员 - 保存贩毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySdFd(ZdrySdFd entity);
	
	/**
	 * @Title: queryZdrySdXdList
	 * @Description: TODO(吸毒查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdrySdXdList(EasyUIPage page, ZdrySdXd entity);
	
	/**
	 * @Title: queryZdrySdXd
	 * @Description: TODO(制毒情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySdXd    返回类型
	 * @throws
	 */
	public ZdrySdXd queryZdrySdXd(ZdrySdXd entity);
	
	/**
	 * @Title: saveZdrySdXdb
	 * @Description: TODO(重点人员 - 保存吸毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySdXd(ZdrySdXd entity);
	
	/**
	 * @Title: queryZdryZdxsfzqkList
	 * @Description: TODO(制毒查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdrySdZdList(EasyUIPage page, ZdrySdZd entity);
	
	/**
	 * @Title: queryZdrySdZd
	 * @Description: TODO(制毒情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySdZd    返回类型
	 * @throws
	 */
	public ZdrySdZd queryZdrySdZd(ZdrySdZd entity);
	
	/**
	 * @Title: saveZdrySdZd
	 * @Description: TODO(重点人员 - 保存制毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySdZd(ZdrySdZd entity);
	
	/**
	 * @Title: queryShgxrList
	 * @Description: TODO(社会关系人查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryShgxrList(EasyUIPage page, Shgxrb entity);
	
	/**
	 * @Title: queryShgxr
	 * @Description: TODO(社会关系人情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Shgxr    返回类型
	 * @throws
	 */
	public Shgxrb queryShgxr(Shgxrb entity);
	
	/**
	 * @Title: saveShgxr
	 * @Description: TODO(重点人员 - 保存社会关系人)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveShgxr(Shgxrb entity);
	
	/**
	 * @Title: querySaxxList
	 * @Description: TODO(涉案查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage querySaxxList(EasyUIPage page, Saxxb entity);
	
	/**
	 * @Title: querySaxx
	 * @Description: TODO(涉案情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Saxx    返回类型
	 * @throws
	 */
	public Saxxb querySaxx(Saxxb entity);
	
	/**
	 * @Title: saveSaxx
	 * @Description: TODO(重点人员 - 保存涉案)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSaxx(Saxxb entity);
	
	/**
	 * @Title: queryClxxList
	 * @Description: TODO(车辆查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryClxxList(EasyUIPage page, Clxxb entity);
	
	/**
	 * @Title: queryClxx
	 * @Description: TODO(车辆查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Clxx    返回类型
	 * @throws
	 */
	public Clxxb queryClxx(Clxxb entity);
	
	/**
	 * @Title: saveClxx
	 * @Description: TODO(重点人员 - 保存车辆)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveClxx(Clxxb entity);
	
	/**
	 * @Title: queryZdjlList
	 * @Description: TODO(诊断查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZdjlList(EasyUIPage page, Zdjlb entity);
	
	/**
	 * @Title: queryZdjl
	 * @Description: TODO(诊断情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdjl    返回类型
	 * @throws
	 */
	public Zdjlb queryZdjl(Zdjlb entity);
	
	/**
	 * @Title: saveZdjlb
	 * @Description: TODO(重点人员 - 保存诊断)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdjl(Zdjlb entity);
	
	/**
	 * @Title: queryZsjlList
	 * @Description: TODO(肇事肇祸查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryZsjlList(EasyUIPage page, Zsjlb entity);
	
	/**
	 * @Title: queryZsjl
	 * @Description: TODO(肇事肇祸查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zsjl    返回类型
	 * @throws
	 */
	public Zsjlb queryZsjl(Zsjlb entity);
	
	/**
	 * @Title: saveZsjl
	 * @Description: TODO(重点人员 - 保存肇事肇祸)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZsjl(Zsjlb entity);
	
	/**
	 * @Title: queryGxbgList
	 * @Description: TODO(重点人员管辖变更 )
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryGxbgList(EasyUIPage page, ZdryGxbg entity);
	
	/**
	 * @Title: updateGxbg
	 * @Description: TODO(变更管辖单位)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateGxbg(ZdryGxbg entity);
	
	
}
