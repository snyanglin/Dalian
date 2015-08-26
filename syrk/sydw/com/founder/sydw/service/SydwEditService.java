package com.founder.sydw.service;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.sydw.bean.Cyryxxb;
import com.founder.sydw.bean.Ddxxb;
import com.founder.sydw.bean.DwOwnAmfwcsBean;
import com.founder.sydw.bean.DwOwnGqwbBean;
import com.founder.sydw.bean.DwOwnGwylcsBean;
import com.founder.sydw.bean.DwOwnMbBean;
import com.founder.sydw.bean.DwOwnMbXmyjBean;
import com.founder.sydw.bean.DwOwnMqBean;
import com.founder.sydw.bean.DwOwnMqZgryBean;
import com.founder.sydw.bean.DwOwnSealBean;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.DwOwnYhBean;
import com.founder.sydw.bean.DwOwnYxyycsBean;
import com.founder.sydw.bean.DwOwnZjbxBean;
import com.founder.sydw.bean.Dwbadwxxb;
import com.founder.sydw.bean.Dwccxxb;
import com.founder.sydw.bean.Dwcfxxb;
import com.founder.sydw.bean.Dwhbxxb;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.Dwjfdwxxb;
import com.founder.sydw.bean.Dwjqdtjlb;
import com.founder.sydw.bean.Dwxyaqxxb;
import com.founder.sydw.bean.Dwyhflcxxb;
import com.founder.sydw.bean.Dwzjb;
import com.founder.sydw.bean.DwzybwXxb;
import com.founder.sydw.bean.Frfzrllrb;
import com.founder.sydw.bean.Gxxxb;
import com.founder.sydw.bean.Jdcxlxxb;
import com.founder.sydw.bean.Jdhxpzzxxb;
import com.founder.sydw.bean.Jhsgxxb;
import com.founder.sydw.bean.Ldxxb;
import com.founder.sydw.bean.XyaqxxbHxd;
import com.founder.sydw.bean.XyaqxxbXc;
import com.founder.sydw.bean.Yhxxb;
import com.founder.sydw.bean.Yyssxxb;
import com.founder.sydw.bean.Zzyhjzzsbb;
import com.founder.sydw.vo.SydwgnVO;
import com.founder.sydw.vo.SydwxxzsVO;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.bean.ZaffWfxx;
 
/******************************************************************************
 * @Package:      [com.founder.sydw.service.SydwEditService.java]  
 * @ClassName:    [SydwEditService]   
 * @Description:  [单位编辑页面信息]   
 * @Author:       [star]  
 * @CreateDate:   [2015-6-8 下午2:59:44]   
 * @UpdateUser:   [star(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 下午2:59:44，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [新增实有单位补充信息]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("单位编辑")
public interface SydwEditService {
	
	/**
	 * 根据id查询对象
	 * @param entity
	 * @return
	 */
	public Dwjbxxb queryDwjbxxbById(String id);

	public List<Frfzrllrb> queryFrfzr(String id);

	public List<SydwxxzsVO> queryDwzsxx(Map<String,Object> map);

	public List<SydwgnVO> queryYwglgn(Map<String, Object> map);

	public int delete_xxzsnrb(Map<String, Object> map);
	
	public Jdhxpzzxxb jdhxpzzxxb_query(Map<String, Object> map);
	
	/**
	 *单位分类信息-旅馆业信息
	 */
	public Ldxxb ldxxb_query(Map<String, Object> map);
	
	/**
	 *单位分类信息-典当业信息
	 */
	public Ddxxb ddxxb_query(Map<String, Object> map);
	
	/**
	 *单位业务办理-单位检查信息
	 */
	public List<Dwjcxxb> dwjcxxb_query(Map<String, Object> map);
	
	
	/**
	 *单位业务办理-单位处罚信息
	 */
	public List<Dwcfxxb> dwcfxxb_query(Map<String, Object> map);

	/**
	 *单位分类信息-旧货收购信息
	 */
	public Jhsgxxb jhsgxxb_query(Map<String, Object> map);
	
	/**
	 *单位分类信息- 查询金融单位
	 */
	public Yhxxb yhxxb_query(Map<String, Object> map);
	
	/**
	 *上下级单位信息- 银行分理处信息
	 */
	public List<Dwyhflcxxb> yhflcxxb_query(Map<String, Object> map);
		
	/**
	 *单位设施部位信息- 单位仓储信息
	 */
	public List<Dwccxxb> dwccxxb_query(Map<String, Object> map);
	
	/**
	 * 营业设备
	 * @param map
	 * @return
	 */
	public List<Yyssxxb> yyssxxb_query(Map<String, Object> map);	
	
	/**
	 * 机动车修理信息
	 * @param map
	 * @return
	 */
	public Jdcxlxxb jdcxlxxb_query(Map<String, Object> map);
	
	
	/**
	 *法定代表人\负责人\联络人
	 */
	public List<Frfzrllrb> dwfrfzrllyxxb_query(Map<String, Object> map);
	
	/**
	 *从业人员
	 */
	public List<Cyryxxb> cyryxxb_query(Map<String, Object> map);
	
	/**
	 *重要部位
	 */
	public List<DwzybwXxb> dwzybwxxb_query(Map<String, Object> map);
	/**
	 *单位证件
	 */
	public List<Dwzjb> dwzjxxzb_query(Map<String, Object> map);
	
	/**
	 *护校队
	 */
	public List<XyaqxxbHxd> xyaqxxbHxd_query(Map<String, Object> map);
	
	/**
	 *校车
	 */
	public List<XyaqxxbXc> xyaqxxbXc_query(Map<String, Object> map);
	
	/**
	 * 附件信息
	 * @param map
	 * @return
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String,Object> map);
	
	public int getCountByCol(Map<String, Object> map);

	public List<Dwjqdtjlb> queryDwjqdtjl(String dwid);

	public List<Cyryxxb> cyryxxb_query_new(String dwid);
	
	public EasyUIPage cyryxxb_query_all(EasyUIPage page, String condition, String dwid);
	
	public long cyryxxb_query_all_count(String condition, String dwid);
	
	public List<Map<String, String>> cyryxxb_query_all_export(String dwid);
	
	public List<ZaffRfxxb> rfxxb_query(Map<String, Object> map);
	
	public List<ZaffWfxx> wfxxb_query(Map<String, Object> map);

	public void exportExcel(String[] titleArray, String[] keyArray, List<Map<String, String>> list, ServletOutputStream outputStream);

	public Dwxyaqxxb dwxyaqxxb_query(Map<String, Object> map);

	public List<DwjbxxbBay> dwxyaqxxbBay_query(Map<String, Object> map);

	public List<Zzyhjzzsbb> zzyhjzzsbb_query(Map<String, Object> map);
	
	public Gxxxb gxxxb_query(Map<String, Object> map);
	
	//@star新增开始

	/**
	 * @Title: gwylcs_query
	 * @Description: 歌舞娱乐场所信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnGwylcsBean    返回类型
	 * @throws
	 */
	public DwOwnGwylcsBean gwylcs_query(Map<String, Object> map);
	
	/**
	 * @Title: amfwcs_query
	 * @Description: 按摩服务场所信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnAmfwcsBean    返回类型
	 * @throws
	 */
	public DwOwnAmfwcsBean amfwcs_query(Map<String, Object> map);
	
	/**
	 * @Title: yycs_query
	 * @Description: 游艺场所信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnYxyycsBean    返回类型
	 * @throws
	 */
	public DwOwnYxyycsBean yycs_query(Map<String, Object> map);
	
	/**
	 * @Title: seal_query
	 * @Description: 印章基本信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnSealBean    返回类型
	 * @throws
	 */
	public DwOwnSealBean seal_query(Map<String, Object> map);
	
	/**
	 * @Title: mb_query
	 * @Description: 民爆单位基本信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnMbBean    返回类型
	 * @throws
	 */
	public DwOwnMbBean mb_query(Map<String, Object> map);

	/**
	 * @Title: mbsgxm_query_new
	 * @Description:民爆项目信息
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<DwOwnMbXmyjBean>    返回类型
	 * @throws
	 */
	public List<DwOwnMbXmyjBean> mbsgxm_query_new(String dwid);
	
	/**
	 * @Title: mbsgxm_query_all
	 * @Description: 民爆项目信息
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage mbsgxm_query_all(EasyUIPage page, String condition, String dwid);
	
	/**
	 * @Title: mbsgxm_query_all_count
	 * @Description: 民爆项目信息
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long mbsgxm_query_all_count(String condition, String dwid);

	/**
	 * @Title: mq_query
	 * @Description: 民枪配置单位信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnMqBean    返回类型
	 * @throws
	 */
	public DwOwnMqBean mq_query(Map<String, Object> map);
 
	/** 
	 * @Title: mqzgry_query_new
	 * @Description: 民枪专管人员信息
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<DwOwnMqZgryBean>    返回类型
	 * @throws
	 */
	public List<DwOwnMqZgryBean> mqzgry_query_new(String dwid);
	
	/**
	 * @Title: mqzgry_query_all
	 * @Description: 民枪专管人员信息
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage mqzgry_query_all(EasyUIPage page, String condition, String dwid);
	
	/**
	 * @Title: mqzgry_query_all_count
	 * @Description:民枪专管人员信息
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long mqzgry_query_all_count(String condition, String dwid);
	
	/**
	 * @Title: yh_query
	 * @Description: 烟花配置单位信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnYhBean    返回类型
	 * @throws
	 */
	public DwOwnYhBean yh_query(Map<String, Object> map);

	/**
	 * @Title: zzyh_query_all
	 * @Description: 自助银行
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage zzyh_query_all(EasyUIPage page, String condition, String dwid);
	
	/**
	 * @Title: zzyh_query_all_count
	 * @Description:自助银行
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long zzyh_query_all_count(String condition, String dwid);

	/**
	 * @Title: xc_query_all
	 * @Description: 校车
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage xc_query_all(EasyUIPage page, String condition, String dwid);
	
	/**
	 * @Title: xc_query_all_count
	 * @Description: 校车
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long xc_query_all_count(String condition, String dwid);
	
	/**
	 * @Title: hxd_query_all
	 * @Description:护校队
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage hxd_query_all(EasyUIPage page, String condition, String dwid);
	
	/**
	 * @Title: hxd_query_all_count
	 * @Description: 护校队
	 * @param @param condition
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long hxd_query_all_count(String condition, String dwid);
	
	/**
	 * @Title: zjbx_query
	 * @Description: 单位_证券/保险业信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnZjbxBean    返回类型
	 * @throws
	 */
	public DwOwnZjbxBean zjbx_query(Map<String, Object> map);
	
	/**
	 * @Title: gqwb_query
	 * @Description: 单位_工企/文保单位信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnGqwbBean    返回类型
	 * @throws
	 */
	public DwOwnGqwbBean gqwb_query(Map<String, Object> map);

	/**
	 * @Title: xf_query
	 * @Description: 单位_消防
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnXFBean    返回类型
	 * @throws
	 */
	public DwOwnXFBean xf_query(Map<String, Object> map);
	
	//@star新增结束
	
	/**
	 *单位环保信息表查询
	 *time:2015-5-16 
	 *author：ygl
	 */
	public Dwhbxxb dwhbxxb_query(Map<String, Object> map);
	
	/**
	 *保安单位信息表查询
	 *time:2015-5-16 
	 *author：ygl
	 */
	public Dwbadwxxb badwxxb_query(Map<String, Object> map);
	
	/**
	 *技防单位信息表查询
	 *time:2015-5-16 
	 *author：ygl
	 */
	public Dwjfdwxxb jfdwxxb_query(Map<String, Object> map);
}
