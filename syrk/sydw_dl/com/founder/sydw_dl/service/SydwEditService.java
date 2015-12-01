package com.founder.sydw_dl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.sydw_dl.bean.Cyryxxb;
import com.founder.sydw_dl.bean.Ddxxb;
import com.founder.sydw_dl.bean.Dwccxxb;
import com.founder.sydw_dl.bean.Dwcfxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.bean.Dwjcxxb;
import com.founder.sydw_dl.bean.Dwjqdtjlb;
import com.founder.sydw_dl.bean.Dwxyaqxxb;
import com.founder.sydw_dl.bean.DwxyaqxxbBay;
import com.founder.sydw_dl.bean.Dwyhflcxxb;
import com.founder.sydw_dl.bean.Dwzjb;
import com.founder.sydw_dl.bean.DwzybwXxb;
import com.founder.sydw_dl.bean.Frfzrllrb;
import com.founder.sydw_dl.bean.Gxxxb;
import com.founder.sydw_dl.bean.Jdcxlxxb;
import com.founder.sydw_dl.bean.Jdhxpzzxxb;
import com.founder.sydw_dl.bean.Jhsgxxb;
import com.founder.sydw_dl.bean.Jzdwxxb;
import com.founder.sydw_dl.bean.Ldxxb;
import com.founder.sydw_dl.bean.XyaqxxbHxd;
import com.founder.sydw_dl.bean.XyaqxxbXc;
import com.founder.sydw_dl.bean.Yhxxb;
import com.founder.sydw_dl.bean.Yyssxxb;
import com.founder.sydw_dl.bean.Zzyhjzzsbb;
import com.founder.sydw_dl.vo.SydwgnVO;
import com.founder.sydw_dl.vo.SydwxxzsVO;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.bean.ZaffWfxx;

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

	public List<DwxyaqxxbBay> dwxyaqxxbBay_query(Map<String, Object> map);

	public List<Zzyhjzzsbb> zzyhjzzsbb_query(Map<String, Object> map);
	
	public Gxxxb gxxxb_query(Map<String, Object> map);
	
	
	public Jzdwxxb jzdwxxb_query(Map<String, Object> map);

}
