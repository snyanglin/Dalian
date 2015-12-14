package com.founder.sydw_dl.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.entity.OperationLog;
import com.founder.framework.organization.user.service.OrgUserService;
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
import com.founder.sydw_dl.dao.CyryxxbDao;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.sydw_dl.dao.DwxyaqDao;
import com.founder.sydw_dl.dao.DwxyaqxxbBayDao;
import com.founder.sydw_dl.dao.DwzjxxzbDao;
import com.founder.sydw_dl.dao.FrfzrllrbDao;
import com.founder.sydw_dl.dao.GxxxbDao;
import com.founder.sydw_dl.dao.JdcxlxxbDao;
import com.founder.sydw_dl.dao.JdhxpzzxxbDao;
import com.founder.sydw_dl.dao.JzdwxxbDao;
import com.founder.sydw_dl.dao.SydwQueryDao;
import com.founder.sydw_dl.dao.XyaqxxbHxdDao;
import com.founder.sydw_dl.dao.XyaqxxbXcDao;
import com.founder.sydw_dl.dao.YyssxxbDao;
import com.founder.sydw_dl.dao.ZzyhjzzsbbDao;
import com.founder.sydw_dl.service.DwxyaqService;
import com.founder.sydw_dl.service.SydwEditService;
import com.founder.sydw_dl.vo.SydwgnVO;
import com.founder.sydw_dl.vo.SydwxxzsVO;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.bean.ZaffWfxx;

@Service("sydwEditService")
@Transactional
public class SydwEditServiceImpl extends BaseService implements SydwEditService  {
	
	@Resource(name="dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Resource(name = "jdhxpzzxxbDao")
	private JdhxpzzxxbDao jdhxpzzxxbDao;
	
	@Resource
	private JzdwxxbDao jzdwxxbDao;
	
	
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
	
	@Autowired
	private ApplicationContext applicationContext;

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	@Resource(name = "dwxyaqService")
	private DwxyaqService dwxyaqService;
	
	@Resource(name = "zzyhjzzsbbDao")
	private ZzyhjzzsbbDao zzyhjzzsbbDao;
	
	@Resource(name = "gxxxbDao")
	private GxxxbDao gxxxbDao;
	
	@Override
	public List<DwxyaqxxbBay> dwxyaqxxbBay_query(Map<String, Object> map) {
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid((String)map.get("dwid"));
		if(dwxyaqxxb!=null){
		map.put("xyid", dwxyaqxxb.getId());
		}
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
//		int returnValue =  dwjbxxbDao.delete_xxzsnrb(map);
//		String userid = map.get("xt_zhxgrid").toString();
//		OrgUser orguser=new OrgUser();
//		orguser=orgUserService.queryByUserid(userid);
//		SessionBean sessionBean=orgUserService.initSessionUser(orguser);
//		applicationContext.publishEvent(new TempModifyEvent(new EventObjectTemp(map.get("id").toString(), "delete", "cyry", sessionBean)));
//		return returnValue;
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
	
//	public List<ZpfjFjxxb> jfxxb_query(Map<String, Object> map) {
//		return dwzjxxzbDao.fjxx_query(map);
//	}
	
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



	@Override
	public Jzdwxxb jzdwxxb_query(Map<String, Object> map) {
		
		return jzdwxxbDao.queryByDwid(map);
	}
	
}
