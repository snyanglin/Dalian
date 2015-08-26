package com.founder.zdrygl.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.founder.framework.base.entity.SessionBean;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.zdrygl.bean.ZdryFzcsfryxxb;
import com.founder.zdrygl.bean.ZdryJgdxxxb;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.bean.ZdrySqjzryxxb;
import com.founder.zdrygl.bean.ZdrySqsbzdryxxb;
import com.founder.zdrygl.bean.ZdryZdrkxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.ZdryZszhjsbrxxb;
import com.founder.zdrygl.vo.ZdryVO;
import com.founder.zdrygl.vo.ZdrygnVO;
import com.founder.zdrygl.vo.ZdrylgxxVO;
import com.founder.zdrygl.vo.ZdryxxzsVO;

public interface ZdryEditService {

	public List<ZdryZdryzb> queryZdryByRyid(String ryid);

	public List<ZdrygnVO> queryYwglgn(String gllxdm);

	public List<ZdryxxzsVO> queryRyzsxx(Map<String, Object> map);

	public void delete_xxzsnrb(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: jgdxxxb_query
	 * @Description: TODO(监管对象)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryJgdxxxb>    返回类型
	 * @throws
	 */
	public  ZdryJgdxxxb  jgdxxxb_query(Map<String, Object> map);
	
	
	/**
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(附件)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throws
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String,Object> map);
	

	
	public ZdryZdrkxxb zdrkxxb_query (Map<String,Object> map);
	
	public ZdryZszhjsbrxxb zszhjsbrxxb_query(Map<String,Object> map);
	/**
	 * 
	 * @Title: lgxx_query
	 * @Description: TODO(列管信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdrylgxxVO>    返回类型
	 * @throws
	 */
	public List<ZdrylgxxVO> lgxx_query(Map<String,Object> map);
	/**
	 * 
	 * @Title: shbzdry_query
	 * @Description: TODO(涉环保重点人员)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdrylgxxVO>    返回类型
	 * @throws
	 */
	public ZdryShbzdryxxb shbzdry_query (Map<String,Object> map);
	
	
	/**
	 * 涉公安访重点人员查询
	 * @param map
	 * @return
	 */
	public ZdrySgafzdryxxb sgafzdryxxb_query(Map<String,Object> map);

	
	/**
	 * 
	 * @Title: queryByZdryFz
	 * @Description: TODO(查询重点人员 大小类 综合信息)
	 * @param @param zdryid
	 * @param @return    设定文件
	 * @return ZdryVO    返回类型
	 * @throws
	 */
	public ZdryVO queryZdryAllInfo(String zdryid);

	/**
	 * 
	 * @Title: updateByZdryFz
	 * @Description: TODO(更新重点人员 大小类 综合信息)
	 * @param @param zdryVO
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateZdryAllInfo(ZdryVO zdryVO,SessionBean sessionBean,CommonsMultipartFile[] uploadFile) ;

	public ZdrySqjzryxxb sqjz_query(Map<String, Object> map);

	public ZdrySqsbzdryxxb sqsbzdry_query(Map<String, Object> map);

	public ZdryFzcsfryxxb fzcfryxxb_query(Map<String, Object> map);

	/**
	 * 
	 * @Title: zdryZl
	 * @Description: TODO(重点人员转类)
	 * @param @param zdryVO
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void zdryZl(ZdryVO zdryVO, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryIsZL
	 * @Description: TODO(查询是否可转类)
	 * @param @param zdrylx
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean queryIsZL(String zdrylx);
	
}
