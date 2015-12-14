package com.founder.syrkgl.service;

import java.util.List;
import java.util.Map;

import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syrkgl.bean.Jzzblxxb;
import com.founder.syrkgl.bean.RyRybmchxxb;
import com.founder.syrkgl.bean.RyRyhykxxb;
import com.founder.syrkgl.bean.RyRyjlxxb;
import com.founder.syrkgl.bean.RyRyjtcyxxb;
import com.founder.syrkgl.bean.RyRylxfsxxb;
import com.founder.syrkgl.bean.RyRytbtsbjxxb;
import com.founder.syrkgl.bean.RyRytbtstzxxb;
import com.founder.syrkgl.bean.RyRytmtzxxb;
import com.founder.syrkgl.bean.RyRyxnsfxxb;
import com.founder.syrkgl.bean.RyRyzjxxb;
import com.founder.syrkgl.bean.RyZyjwryxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.vo.SyrkgnVo;
import com.founder.syrkgl.vo.SyrkxxzsVo;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.service.SyrkEditService.java]
 * @ClassName: [SyrkEditService]
 * @Description: [实有人口编辑页面]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-4-3 上午10:43:09]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 上午10:43:09，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public interface SyrkEditService {
	
	/***
	 * 
	 * @Title: queryYwglgn
	 * @Description: TODO(根据类型查询功能)
	 * @param @param syrklx
	 * @param @return    设定文件
	 * @return List<SyrkgnVo>    返回类型
	 * @throws
	 */
	public List<SyrkgnVo> queryYwglgn(String gnlxdm,String syrklx);

	/***
	 * 
	 * @Title: queryRyzsxx
	 * @Description: TODO(根据类型查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<SyrkxxzsVo>    返回类型
	 * @throws
	 */
	public List<SyrkxxzsVo> queryRyzsxx(Map<String, Object> map);

	/***
	 * 
	 * @Title: delete_xxzsnrb
	 * @Description: TODO(通用删除)
	 * @param @param map    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete_xxzsnrb(Map<String, Object> map);
	/***
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(照片查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throws
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: czrkxxb_query
	 * @Description: TODO(常住人口信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return SyrkCzrkxxb    返回类型
	 * @throws
	 */
	public SyrkCzrkxxb czrkxxb_query(Map<String, Object> map);
	/**
	 * 
	 * @Title: jzrkxxb_query
	 * @Description: TODO(寄主人口信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return SyrkCzrkxxb    返回类型
	 * @throws
	 */
	public SyrkJzrkxxb jzrkxxb_query(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: ldrkxxb_query
	 * @Description: TODO(流动人口信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return SyrkCzrkxxb    返回类型
	 * @throws
	 */
	public SyrkLdrkxxb ldrkxxb_query(Map<String, Object> map);
	/**
	 * 
	 * @Title: jwryxxb_query
	 * @Description: TODO(境外人员信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return SyrkCzrkxxb    返回类型
	 * @throws
	 */
	public SyrkJwryxxb jwryxxb_query(Map<String, Object> map);
	/**
	 * 
	 * @Title: jwryxxb_query
	 * @Description: TODO(境外人员信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return SyrkCzrkxxb    返回类型
	 * @throws
	 */
	public SyrkWlhryxxb wlhryxxb_query(Map<String, Object> map);
	//人员相关信息小项查询
	/***
	 * 
	 * @Title: ryzjxxzb_query
	 * @Description: TODO(人员证件)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRyzjxxb    返回类型
	 * @throws
	 */
	public List<RyRyzjxxb> ryzjxxzb_query(Map<String, Object> map);
	
	/***
	 * 
	 * @Title: rylxfsxxb_query
	 * @Description: TODO(人员联系方式)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRylxfsxxb    返回类型
	 * @throws
	 */
	public List<RyRylxfsxxb> rylxfsxxb_query(Map<String, Object> map);
	/***
	 * 
	 * @Title: rybmchxxb_query
	 * @Description: TODO(人员别名绰号)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRybmchxxb    返回类型
	 * @throws
	 */
	public List<RyRybmchxxb> rybmchxxb_query(Map<String, Object> map);
	
	/***
	 * 
	 * @Title: ryjlxxb_query
	 * @Description: TODO(人员经历信息 )
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRybmchxxb    返回类型
	 * @throws
	 */
	public List<RyRyjlxxb> ryjlxxb_query(Map<String, Object> map);
	/***
	 * 
	 * @Title: ryhykxxb_query
	 * @Description: TODO(会员卡信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRyhykxxb    返回类型
	 * @throws
	 */
	public List<RyRyhykxxb> ryhykxxb_query(Map<String, Object> map);
	/***
	 * 
	 * @Title: ryxysfxxb_query
	 * @Description: TODO(虚拟身份信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRyxnsfxxb    返回类型
	 * @throws
	 */
	public List<RyRyxnsfxxb> ryxysfxxb_query(Map<String, Object> map);
	/***
	 * 
	 * @Title: ryjtcyxxb_query
	 * @Description: TODO(家庭成员信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRyjtcyxxb    返回类型
	 * @throws
	 */
	public List<RyRyjtcyxxb> ryjtcyxxb_query(Map<String, Object> map);
	
	/***
	 * 
	 * @Title: rytmtzxxb_query
	 * @Description: TODO(体貌特征)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRytmtzxxb    返回类型
	 * @throws
	 */
	public RyRytmtzxxb rytmtzxxb_query(Map<String, Object> map);
	
	public List<RyZyjwryxxb> ryzyjwryxxb_query(Map<String, Object> map);
	
	/***
	 * 
	 * @Title: rytbtstzxxb_query
	 * @Description: TODO(体表特殊特)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRytbtstzxxb    返回类型
	 * @throws
	 */
	public List<RyRytbtstzxxb> rytbtstzxxb_query(Map<String, Object> map);
	/***
	 * 
	 * @Title: tbtsbjxxb_query
	 * @Description: TODO(特殊标记)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRytbtsbjxxb    返回类型
	 * @throws
	 */
	public List<RyRytbtsbjxxb> tbtsbjxxb_query(Map<String, Object> map);
	
	
	/**
	 * 
	 * @Title: jzzblxxb_query
	 * @Description: TODO(居住证办理)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Jzzblxxb>    返回类型
	 * @throws
	 */
	public List<Jzzblxxb> jzzblxxb_query(Map<String, Object> map);
	
	/**
	 * 附件信息
	 * @param map
	 * @return
	 */
	
}
