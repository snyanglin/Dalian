package com.founder.sydw.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import org.apache.poi3.xssf.usermodel.XSSFCell;
import org.apache.poi3.xssf.usermodel.XSSFRow;
import org.apache.poi3.xssf.usermodel.XSSFSheet;
import org.apache.poi3.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.entity.OperationLog;
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
import com.founder.sydw.dao.CyryxxbDao;
import com.founder.sydw.dao.DwBadwxxbDao;
import com.founder.sydw.dao.DwJfdwxxbDao;
import com.founder.sydw.dao.DwOwnsydwDao;
import com.founder.sydw.dao.DwhbxxbDao;
import com.founder.sydw.dao.DwjbxxbDao;
import com.founder.sydw.dao.DwxyaqDao;
import com.founder.sydw.dao.DwxyaqxxbBayDao;
import com.founder.sydw.dao.DwzjxxzbDao;
import com.founder.sydw.dao.FrfzrllrbDao;
import com.founder.sydw.dao.GxxxbDao;
import com.founder.sydw.dao.JdcxlxxbDao;
import com.founder.sydw.dao.JdhxpzzxxbDao;
import com.founder.sydw.dao.SydwQueryDao;
import com.founder.sydw.dao.XyaqxxbHxdDao;
import com.founder.sydw.dao.XyaqxxbXcDao;
import com.founder.sydw.dao.YyssxxbDao;
import com.founder.sydw.dao.ZzyhjzzsbbDao;
import com.founder.sydw.service.DwxyaqService;
import com.founder.sydw.service.SydwEditService;
import com.founder.sydw.vo.SydwgnVO;
import com.founder.sydw.vo.SydwxxzsVO;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.bean.ZaffWfxx;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.impl.SydwEditServiceImpl.java]  
 * @ClassName:    [SydwEditServiceImpl]   
 * @Description:  [单位编辑页面信息]   
 * @Author:       [star]  
 * @CreateDate:   [2015-6-8 下午3:37:24]   
 * @UpdateUser:   [star(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 下午3:37:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [新增实有单位补充信息]  
 * @Version:      [v1.0] 
 */
@Service("sydwEditService")
@Transactional
public class SydwEditServiceImpl extends BaseService implements SydwEditService  {
	
	@Resource(name="dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Resource(name = "jdhxpzzxxbDao")
	private JdhxpzzxxbDao jdhxpzzxxbDao;
    
	@Resource(name = "yyssxxbDao")
	private YyssxxbDao yyssxxbDao;
	
	@Resource(name = "jdcxlxxbDao")
	private JdcxlxxbDao jdcxlxxbDao;
	
	@Resource(name = "frfzrllrbDao")
	private FrfzrllrbDao frfzrllrbDao;
	
	@Resource(name = "cyryxxbDao")
	private CyryxxbDao cyryxxbDao;
	
	@Resource(name = "sydwQueryDao")
	private SydwQueryDao sydwQueryDao;
	
	@Resource(name = "dwzjxxzbDao")
	private DwzjxxzbDao dwzjxxzbDao;
	
	@Resource(name = "dwxyaqdao")
	private DwxyaqDao dwxyaqDao;
	
	@Resource(name = "xyaqxxbHxdDao")
	private XyaqxxbHxdDao xyaqxxbHxdDao;
	
	@Resource(name = "xyaqxxbXcDao")
	private XyaqxxbXcDao xyaqxxbXcDao;
	
	@Resource(name = "dwxyaqxxbBaydao")
	private DwxyaqxxbBayDao dwxyaqxxbBaydao;
		
	@Resource(name = "dwxyaqService")
	private DwxyaqService dwxyaqService;
	
	@Resource(name = "zzyhjzzsbbDao")
	private ZzyhjzzsbbDao zzyhjzzsbbDao;
	
	@Resource(name = "gxxxbDao")
	private GxxxbDao gxxxbDao;
	
	//@star开始
	@Resource(name = "dwOwnsydwDao")
	private DwOwnsydwDao dwOwnsydwDao;
	//@star结束
	
	@Resource(name = "dwhbxxbDao")
	private DwhbxxbDao dwhbxxbDao;
	
	@Resource(name = "dwBadwxxbDao")
	private DwBadwxxbDao dwBadwxxbDao;
	
	@Resource(name = "dwJfdwxxbDao")
	private DwJfdwxxbDao dwJfdwxxbDao;
	
	@Override
	public List<DwjbxxbBay> dwxyaqxxbBay_query(Map<String, Object> map) {
		return dwxyaqxxbBaydao.dwxyaqxxbBay(map);
	}
	
	@Override
	public Dwjbxxb queryDwjbxxbById(String id) {
		return dwjbxxbDao.queryDwjbxxbById(id);
	}

	@Override
	public List<Frfzrllrb> queryFrfzr(String id) {
		return dwjbxxbDao.queryDwfrfzrByDwid(id);
	}

	@Override
	public List<SydwxxzsVO> queryDwzsxx(Map<String,Object> map) {
		map.put("xxdxlxdm","1");
		List<SydwxxzsVO> infoList = dwjbxxbDao.queryDwzsxx(map);
		if(infoList != null && !infoList.isEmpty()){
			map.put("xxdxlxdm","2");
			for (int i = 0; i < infoList.size(); i++) {
				map.put("dlbh",infoList.get(i).getXxbh().substring(0, 2));
				infoList.get(i).setList( dwjbxxbDao.queryDwzsxx(map));
			}
		}
		return infoList;
	}

	@Override
	public List<SydwgnVO> queryYwglgn(Map<String, Object> map) {
		return dwjbxxbDao.queryYwglgn(map);
	}

	@Override
	public int delete_xxzsnrb(Map<String, Object> map) {
		return sydwQueryDao.delete_xxzsnrb(map);
	}
	
	public Jdhxpzzxxb jdhxpzzxxb_query(Map<String, Object> map){
		return (Jdhxpzzxxb)jdhxpzzxxbDao.jdhxpzzxxb_query(map);
	}

	public Jhsgxxb jhsgxxb_query(Map<String, Object> map){
		return dwjbxxbDao.jhsgxxb_query(map);
	}
	
	public Yhxxb yhxxb_query(Map<String, Object> map){
		return dwjbxxbDao.yhxxb_query(map);
	}
	
	public List<Dwyhflcxxb> yhflcxxb_query(Map<String, Object> map){
		return dwjbxxbDao.dwyhflcxxb_query(map);
	}
	
	@Override					
	public List<Dwccxxb> dwccxxb_query(Map<String, Object> map){
		return dwjbxxbDao.dwccxxb_query(map);
	}
	

	@Override
	public Ddxxb ddxxb_query(Map<String, Object> map) {
		return dwjbxxbDao.ddxxb_query(map);
	}

	@Override
	public Ldxxb ldxxb_query(Map<String, Object> map) {
		return dwjbxxbDao.ldxxb_query(map);
	}

	@Override
	public List<Dwjcxxb> dwjcxxb_query(Map<String, Object> map) {
		return dwjbxxbDao.dwjcxxb_query(map);
	}


	@Override
	public List<Dwcfxxb> dwcfxxb_query(Map<String, Object> map) {
		return dwjbxxbDao.dwcfxxb_query(map);
	}

	@Override
	public List<Yyssxxb> yyssxxb_query(Map<String, Object> map) {
		return yyssxxbDao.yyssxxb_query(map);
	}
	public Jdcxlxxb jdcxlxxb_query(Map<String, Object> map){
		return jdcxlxxbDao.jdcxlxxb_query(map);
	}

	@Override
	public List<Frfzrllrb> dwfrfzrllyxxb_query(Map<String, Object> map) {
		return frfzrllrbDao.dwfrfzrllyxxb_query(map);
	}

	@Override
	public List<Cyryxxb> cyryxxb_query(Map<String, Object> map) {
		return cyryxxbDao.cyryxxb_query(map);
	}

	@Override
	public List<DwzybwXxb> dwzybwxxb_query(Map<String, Object> map) {
		return dwjbxxbDao.dwzybwxxb_query(map);
	}

	@Override
	public int getCountByCol(Map<String, Object> map) {
		return sydwQueryDao.getCountByCol(map);
	}
	
	@Override
	public List<Dwzjb> dwzjxxzb_query(Map<String, Object> map) {
		return dwzjxxzbDao.dwzjxxzb_query(map);
	}
	
	@Override
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map) {
		return dwzjxxzbDao.fjxx_query(map);
	}
	
	@Override
	public List<XyaqxxbHxd> xyaqxxbHxd_query(Map<String, Object> map) {
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid((String)map.get("dwid"));
		if(dwxyaqxxb!=null){
			map.put("xyid", dwxyaqxxb.getId());
		}
		return xyaqxxbHxdDao.xyaqxxbHxd_query(map);
	}
	
	@Override
	public List<XyaqxxbXc> xyaqxxbXc_query(Map<String, Object> map) {
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid((String)map.get("dwid"));
		if(dwxyaqxxb!=null){
			map.put("xyid", dwxyaqxxb.getId());
		}
		return xyaqxxbXcDao.xyaqxxbXc_query(map);
	}
	
	@Override
	public List<ZaffRfxxb> rfxxb_query(Map<String, Object> map) {
		return dwzjxxzbDao.rfxxb_query(map);
	}
	
	@Override
	public List<ZaffWfxx> wfxxb_query(Map<String, Object> map) {
		return dwzjxxzbDao.wfxxb_query(map);
	}
	
	@Override
	public List<Cyryxxb> cyryxxb_query_new(String dwid) {
		return cyryxxbDao.cyryxxb_query_new(dwid);
	}

	@Override
	public EasyUIPage cyryxxb_query_all(EasyUIPage page, String condition, String dwid) {
		return cyryxxbDao.cyryxxb_query_all(page, condition, dwid);
	}
	
	@Override
	public long cyryxxb_query_all_count(String condition, String dwid){
		return cyryxxbDao.cyryxxb_query_all_count(condition, dwid);
	}

	@Override
	public List<Map<String, String>> cyryxxb_query_all_export(String dwid) {
		return cyryxxbDao.cyryxxb_query_all_export(dwid);
	}
	@Override
	public Dwxyaqxxb dwxyaqxxb_query(Map<String, Object> map) {
		
		if(map.get("dwid")!=null)
		return dwxyaqDao.queryEntityByDwid((String)map.get("dwid"));
		else
			return null;
	}
	
	@Override
	public List<Zzyhjzzsbb> zzyhjzzsbb_query(Map<String, Object> map){
		return zzyhjzzsbbDao.zzyhjzzsbb_query(map);
	}
	
	@Override
	public Gxxxb gxxxb_query(Map<String, Object> map){
		return gxxxbDao.gxxxb_query(map);
	}

	@Override
	public List<Dwjqdtjlb> queryDwjqdtjl(String dwid) {
		Map map = new HashMap();
		map.put("dwid", dwid);
		map.put("modname", "实有单位基本信息");
		map.put("funcname", "更新基本信息");
		map.put("modname1", "法人/负责人/联络员");
		map.put("funcname1", "修改");
		map.put("operate_type", "3");
		List<OperationLog> logList = dwjbxxbDao.queryDwjqdtjl(map);
		List<Dwjqdtjlb> jlList = new ArrayList<Dwjqdtjlb>();
		//循环 取得近期有内容的10条动态		
		for (OperationLog operationLog : logList) {
			if(jlList.size()<10){
				Dwjqdtjlb dwjqdtjlb = new Dwjqdtjlb();
				dwjqdtjlb.setDwid(dwid);
				dwjqdtjlb.setJlsj(operationLog.getOperation_time());
				String content = operationLog.getOperate_content();
				String jlsm=content;
				String jlbt="";
				dwjqdtjlb.setJlsm(jlsm);
				dwjqdtjlb.setJlbt(jlbt);
				jlList.add(dwjqdtjlb);
				
			}
		}
		return jlList;
	}
	
	public void exportExcel(String[] titleArray, String[] keyArray, List<Map<String, String>> list, ServletOutputStream outputStream){
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("从业人员信息表");
			XSSFRow head = sheet.createRow(0);
			XSSFCell cell = null;
			
			//表头
			for(int i = 0; i < keyArray.length; i++){
				cell = head.createCell(i);
				cell.setCellValue(titleArray[i]);
			}
			
			Map<String, String> map = new HashMap<String, String>();
			for(int i = 0; i < list.size(); i ++){
				XSSFRow row = sheet.createRow(i + 1);
				map = list.get(i);
				for(int j = 0; j < keyArray.length; j++){
					cell = row.createCell(j);
					cell.setCellValue(map.get(keyArray[j].toUpperCase()));
				}
				
			}
			
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}		
	}
	
	//@star开始
	
    /*
     * (非 Javadoc)
     * <p>Title: gwylcs_query</p>
     * <p>Description:歌舞娱乐场所信息</p>
     * @param map
     * @return
     * @see com.founder.sydw.service.SydwEditService#gwylcs_query(java.util.Map)
     */
	@Override
	public DwOwnGwylcsBean gwylcs_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnGwylcs(map);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: amfwcs_query</p>
	 * <p>Description: 按摩服务场所信息</p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#amfwcs_query(java.util.Map)
	 */
	@Override
	public DwOwnAmfwcsBean amfwcs_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnAmfwcs(map);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: yycs_query</p>
	 * <p>Description:游艺场所信息 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#yycs_query(java.util.Map)
	 */
	@Override
	public DwOwnYxyycsBean yycs_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnYxyycs(map);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: seal_query</p>
	 * <p>Description:印章信息 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#seal_query(java.util.Map)
	 */
	@Override
	public DwOwnSealBean seal_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnSeal(map);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: mb_query</p>
	 * <p>Description:民爆单位基本信息 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mb_query(java.util.Map)
	 */
	@Override
	public DwOwnMbBean mb_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnMb(map);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: mbsgxm_query_new</p>
	 * <p>Description:民爆项目信息 </p>
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mbsgxm_query_new(java.lang.String)
	 */
	@Override
	public List<DwOwnMbXmyjBean> mbsgxm_query_new(String dwid) {
		return dwOwnsydwDao.mbsgxm_query_new(dwid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: mbsgxm_query_all</p>
	 * <p>Description:民爆项目信息 </p>
	 * @param page
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mbsgxm_query_all(com.founder.framework.utils.EasyUIPage, java.lang.String, java.lang.String)
	 */
	@Override
	public EasyUIPage mbsgxm_query_all(EasyUIPage page, String condition, String dwid) {
		return dwOwnsydwDao.mbsgxm_query_all(page, condition, dwid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: mbsgxm_query_all_count</p>
	 * <p>Description:民爆项目信息 </p>
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mbsgxm_query_all_count(java.lang.String, java.lang.String)
	 */
	@Override
	public long mbsgxm_query_all_count(String condition, String dwid){
		return dwOwnsydwDao.mbsgxm_query_all_count(condition, dwid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: mq_query</p>
	 * <p>Description:民爆项目信息 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mq_query(java.util.Map)
	 */
	public DwOwnMqBean mq_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnMq(map);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: mqzgry_query_new</p>
	 * <p>Description:民枪专管人员 </p>
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mqzgry_query_new(java.lang.String)
	 */
	@Override
	public List<DwOwnMqZgryBean> mqzgry_query_new(String dwid) {
		return dwOwnsydwDao.mqzgry_query_new(dwid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: mqzgry_query_all</p>
	 * <p>Description:民枪专管人员 </p>
	 * @param page
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mqzgry_query_all(com.founder.framework.utils.EasyUIPage, java.lang.String, java.lang.String)
	 */
	@Override
	public EasyUIPage mqzgry_query_all(EasyUIPage page, String condition, String dwid) {
		return dwOwnsydwDao.mqzgry_query_all(page, condition, dwid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: mqzgry_query_all_count</p>
	 * <p>Description:民枪专管人员 </p>
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#mqzgry_query_all_count(java.lang.String, java.lang.String)
	 */
	@Override
	public long mqzgry_query_all_count(String condition, String dwid){
		return dwOwnsydwDao.mqzgry_query_all_count(condition, dwid);
	}
   
	/*
	 * (非 Javadoc)
	 * <p>Title: yh_query</p>
	 * <p>Description:烟花配置单位信息 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#yh_query(java.util.Map)
	 */
	public DwOwnYhBean yh_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnYh(map);
    }

	/*
	 * (非 Javadoc)
	 * <p>Title: zzyh_query_all</p>
	 * <p>Description:自助银行 </p>
	 * @param page
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#zzyh_query_all(com.founder.framework.utils.EasyUIPage, java.lang.String, java.lang.String)
	 */
	@Override
	public EasyUIPage zzyh_query_all(EasyUIPage page, String condition, String dwid) {
		return dwOwnsydwDao.zzyh_query_all(page, condition, dwid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: zzyh_query_all_count</p>
	 * <p>Description: 自助银行</p>
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#zzyh_query_all_count(java.lang.String, java.lang.String)
	 */
	@Override
	public long zzyh_query_all_count(String condition, String dwid){
		return dwOwnsydwDao.zzyh_query_all_count(condition, dwid);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: xc_query_all</p>
	 * <p>Description:校车 </p>
	 * @param page
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#xc_query_all(com.founder.framework.utils.EasyUIPage, java.lang.String, java.lang.String)
	 */
	@Override
	public EasyUIPage xc_query_all(EasyUIPage page, String condition, String dwid) {
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid(dwid);
		String xyid= "@";
		if(dwxyaqxxb!=null){
			xyid = dwxyaqxxb.getId(); 
		}
		return dwOwnsydwDao.xc_query_all(page, condition, xyid);
	}
	@Override
	public long xc_query_all_count(String condition, String xyid){
		return dwOwnsydwDao.xc_query_all_count(condition, xyid);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: hxd_query_all</p>
	 * <p>Description:护校队 </p>
	 * @param page
	 * @param condition
	 * @param dwid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#hxd_query_all(com.founder.framework.utils.EasyUIPage, java.lang.String, java.lang.String)
	 */
	@Override
	public EasyUIPage hxd_query_all(EasyUIPage page, String condition, String dwid) {
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid(dwid);
		String xyid= "@";
		if(dwxyaqxxb!=null){
			xyid = dwxyaqxxb.getId(); 
		}
		return dwOwnsydwDao.hxd_query_all(page, condition, xyid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: hxd_query_all_count</p>
	 * <p>Description:护校队 </p>
	 * @param condition
	 * @param xyid
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#hxd_query_all_count(java.lang.String, java.lang.String)
	 */
	@Override
	public long hxd_query_all_count(String condition, String xyid){
		return dwOwnsydwDao.hxd_query_all_count(condition, xyid);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: zjbx_query</p>
	 * <p>Description: 单位_证券/保险业信息</p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#zjbx_query(java.util.Map)
	 */
	public DwOwnZjbxBean zjbx_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnZjbx(map);
    }

	/*
	 * (非 Javadoc)
	 * <p>Title: gqwb_query</p>
	 * <p>Description:单位_工企/文保单位信息 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#gqwb_query(java.util.Map)
	 */
	public DwOwnGqwbBean gqwb_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnGqwb(map);
    }
	  
	/*
	 * (非 Javadoc)
	 * <p>Title: xf_query</p>
	 * <p>Description:单位_消防 </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw.service.SydwEditService#xf_query(java.util.Map)
	 */
	public DwOwnXFBean xf_query(Map<String, Object> map){
		return dwOwnsydwDao.queryOwnXf(map);
    }
	
	//@star结束
	
	/**
	 *单位环保信息查询
	 *time:2015-5-16 
	 *author：gyl
	 */
	@Override
	public Dwhbxxb dwhbxxb_query(Map<String, Object> map){
		return (Dwhbxxb)dwhbxxbDao.dwhbxxb_query(map);
	}
	/**
	 *保安单位信息查询
	 *time:2015-5-16 
	 *author：gyl
	 */
	@Override
	public Dwbadwxxb badwxxb_query(Map<String, Object> map){
		return (Dwbadwxxb)dwBadwxxbDao.badwxxb_query(map);
	}
	/**
	 *保安单位信息查询
	 *time:2015-5-16 
	 *author：gyl
	 */
	@Override
	public Dwjfdwxxb jfdwxxb_query(Map<String, Object> map){
		return (Dwjfdwxxb)dwJfdwxxbDao.jfdwxxb_query(map);
	}
}
