package com.founder.gzjk.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi3.hssf.util.CellRangeAddress;
import org.apache.poi3.xssf.usermodel.XSSFCell;
import org.apache.poi3.xssf.usermodel.XSSFCellStyle;
import org.apache.poi3.xssf.usermodel.XSSFRow;
import org.apache.poi3.xssf.usermodel.XSSFSheet;
import org.apache.poi3.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.UUID;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.gzjk.dao.GzltjbDao;
import com.founder.gzjk.service.GzltjService;
import com.founder.gzjk.vo.GzltjVo;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.dao.TzggDao;

@Service("gzltjService")
@Transactional
public class GzltjServiceImpl implements GzltjService {

	@Resource(name = "gzltjbDao")
	private GzltjbDao gzltjbDao;
	@Resource(name = "tzggDao")
	private TzggDao tzggDao;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Override
	public List<Gzltjb> queryGzltj(Map<String, String> map) {
		List<Gzltjb> list=gzltjbDao.queryGzltj(map);
		Gzltjb sumGzltjb=new Gzltjb();
		sumGzltjb.setGxzrqdm("合计");
		sumGzltjb.setGxzrqname("合计");
		sumGzltjb.setGxpcsdm("合计");
		sumGzltjb.setGxpcsname("合计");
		sumGzltjb.setGxfjdm("合计");
		sumGzltjb.setGxfjname("合计");
		for(Gzltjb gzltj:list){
	
			sumGzltjb.setRhfl_add((sumGzltjb.getRhfl_add()==null?0:sumGzltjb.getRhfl_add())+(gzltj.getRhfl_add()==null?0:gzltj.getRhfl_add()));
			sumGzltjb.setRhfl_delete((sumGzltjb.getRhfl_delete()==null?0:sumGzltjb.getRhfl_delete())+(gzltj.getRhfl_delete()==null?0:gzltj.getRhfl_delete()));
			sumGzltjb.setRhfl_update((sumGzltjb.getRhfl_update()==null?0:sumGzltjb.getRhfl_update())+(gzltj.getRhfl_update()==null?0:gzltj.getRhfl_update()));
			
			sumGzltjb.setRhyz_add((sumGzltjb.getRhyz_add()==null?0:sumGzltjb.getRhyz_add())+(gzltj.getRhyz_add()==null?0:gzltj.getRhyz_add()));
			sumGzltjb.setRhyz_delete((sumGzltjb.getRhyz_delete()==null?0:sumGzltjb.getRhyz_delete())+(gzltj.getRhyz_delete()==null?0:gzltj.getRhyz_delete()));
			sumGzltjb.setRhyz_update((sumGzltjb.getRhyz_update()==null?0:sumGzltjb.getRhyz_update())+(gzltj.getRhyz_update()==null?0:gzltj.getRhyz_update()));
			
			sumGzltjb.setJzrk_add((sumGzltjb.getJzrk_add()==null?0:sumGzltjb.getJzrk_add())+(gzltj.getJzrk_add()==null?0:gzltj.getJzrk_add()));
			sumGzltjb.setJzrk_delete((sumGzltjb.getJzrk_delete()==null?0:sumGzltjb.getJzrk_delete())+(gzltj.getJzrk_delete()==null?0:gzltj.getJzrk_delete()));
			sumGzltjb.setJzrk_update((sumGzltjb.getJzrk_update()==null?0:sumGzltjb.getJzrk_update())+(gzltj.getJzrk_update()==null?0:gzltj.getJzrk_update()));
			
			sumGzltjb.setJwry_add((sumGzltjb.getJwry_add()==null?0:sumGzltjb.getJwry_add())+(gzltj.getJwry_add()==null?0:gzltj.getJwry_add()));
			sumGzltjb.setJwry_delete((sumGzltjb.getJwry_delete()==null?0:sumGzltjb.getJwry_delete())+(gzltj.getJwry_delete()==null?0:gzltj.getJwry_delete()));
			sumGzltjb.setJwry_update((sumGzltjb.getJwry_update()==null?0:sumGzltjb.getJwry_update())+(gzltj.getJwry_update()==null?0:gzltj.getJwry_update()));
			
			sumGzltjb.setLdrk_add((sumGzltjb.getLdrk_add()==null?0:sumGzltjb.getLdrk_add())+(gzltj.getLdrk_add()==null?0:gzltj.getLdrk_add()));
			sumGzltjb.setLdrk_delete((sumGzltjb.getLdrk_delete()==null?0:sumGzltjb.getLdrk_delete())+(gzltj.getLdrk_delete()==null?0:gzltj.getLdrk_delete()));
			sumGzltjb.setLdrk_update((sumGzltjb.getLdrk_update()==null?0:sumGzltjb.getLdrk_update())+(gzltj.getLdrk_update()==null?0:gzltj.getLdrk_update()));
			
			sumGzltjb.setWlhry_add((sumGzltjb.getWlhry_add()==null?0:sumGzltjb.getWlhry_add())+(gzltj.getWlhry_add()==null?0:gzltj.getWlhry_add()));
			sumGzltjb.setWlhry_delete((sumGzltjb.getWlhry_delete()==null?0:sumGzltjb.getWlhry_delete())+(gzltj.getWlhry_delete()==null?0:gzltj.getWlhry_delete()));
			sumGzltjb.setWlhry_update((sumGzltjb.getWlhry_update()==null?0:sumGzltjb.getWlhry_update())+(gzltj.getWlhry_update()==null?0:gzltj.getWlhry_update()));
			
			sumGzltjb.setCzfw_add((sumGzltjb.getCzfw_add()==null?0:sumGzltjb.getCzfw_add())+(gzltj.getCzfw_add()==null?0:gzltj.getCzfw_add()));
			sumGzltjb.setCzfw_delete((sumGzltjb.getCzfw_delete()==null?0:sumGzltjb.getCzfw_delete())+(gzltj.getCzfw_delete()==null?0:gzltj.getCzfw_delete()));
			sumGzltjb.setCzfw_update((sumGzltjb.getCzfw_update()==null?0:sumGzltjb.getCzfw_update())+(gzltj.getCzfw_update()==null?0:gzltj.getCzfw_update()));
			
			sumGzltjb.setCzr_add((sumGzltjb.getCzr_add()==null?0:sumGzltjb.getCzr_add())+(gzltj.getCzr_add()==null?0:gzltj.getCzr_add()));
			sumGzltjb.setCzr_delete((sumGzltjb.getCzr_delete()==null?0:sumGzltjb.getCzr_delete())+(gzltj.getCzr_delete()==null?0:gzltj.getCzr_delete()));
			sumGzltjb.setCzr_update((sumGzltjb.getCzr_update()==null?0:sumGzltjb.getCzr_update())+(gzltj.getCzr_update()==null?0:gzltj.getCzr_update()));
			
			
			sumGzltjb.setDw_add((sumGzltjb.getDw_add()==null?0:sumGzltjb.getDw_add())+(gzltj.getDw_add()==null?0:gzltj.getDw_add()));
			sumGzltjb.setDw_delete((sumGzltjb.getDw_delete()==null?0:sumGzltjb.getDw_delete())+(gzltj.getDw_delete()==null?0:gzltj.getDw_delete()));
			sumGzltjb.setDw_update((sumGzltjb.getDw_update()==null?0:sumGzltjb.getDw_update())+(gzltj.getDw_update()==null?0:gzltj.getDw_update()));
			
			sumGzltjb.setCyry_add((sumGzltjb.getCyry_add()==null?0:sumGzltjb.getCyry_add())+(gzltj.getCyry_add()==null?0:gzltj.getCyry_add()));
			sumGzltjb.setCyry_delete((sumGzltjb.getCyry_delete()==null?0:sumGzltjb.getCyry_delete())+(gzltj.getCyry_delete()==null?0:gzltj.getCyry_delete()));
			sumGzltjb.setCyry_update((sumGzltjb.getCyry_update()==null?0:sumGzltjb.getCyry_update())+(gzltj.getCyry_update()==null?0:gzltj.getCyry_update()));
		}
		list.add(sumGzltjb);
		return  list;
	}

	@Override
	public void bcgzltjsj(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date startTime = sdf.parse(startDate);
			Date endTime = sdf.parse(endDate);
			List<String> dates = new ArrayList<String>();

			Calendar calStart = Calendar.getInstance();
			calStart.setTime(startTime);
			Calendar calEnd = Calendar.getInstance();
			calEnd.setTime(endTime);

			dates.add(startDate);
			while (calEnd.after(calStart)) {
				calStart.add(Calendar.DAY_OF_MONTH, 1);
				dates.add(sdf.format(calStart.getTime()));
			}

			Org_Organization org = new Org_Organization();
			// 查询责任区sql语句
			org.setOrglevel("50");
			org.setOrgbiztype("04");
			List<Org_Organization> orgs = tzggDao.queryOrg(org);
			

			// 每个责任区每天一条统计数据
			List<Gzltjb> list = new ArrayList<Gzltjb>();
			// 循环补充数据
			for (Org_Organization organization : orgs) {
				OrgOrganization pcs = orgOrganizationService
						.queryParentOrgByOrgcode(organization.getOrgcode());
				String pcsName = pcs.getOrgname();
				String pcsCode = pcs.getOrgcode();
				OrgOrganization fxj = orgOrganizationService
						.queryParentOrgByOrgcode(pcsCode);
				String fxjName = fxj.getOrgname();
				String fxjCode = fxj.getOrgcode();
				for (String tjrq : dates) {

					Map<String, String> dateMap = new HashMap<String, String>();
					dateMap.put("tjrq", tjrq);
					// 查看当天是否执行过（适用于集群）
					long count = gzltjbDao.queryCount(dateMap);
					if (count > 0) {
						continue;
					}
					Gzltjb gzltj = new Gzltjb();
					gzltj.setGxzrqdm(organization.getOrgcode());
					gzltj.setGxzrqname(organization.getOrgname());
					gzltj.setGxpcsdm(pcsCode);
					gzltj.setGxpcsname(pcsName);
					gzltj.setGxfjdm(fxjCode);
					gzltj.setGxfjname(fxjName);
					gzltj.setTjrq(tjrq);
					list.add(gzltj);

					this.rhyzTj(list, tjrq);
					this.rhflTj(list, tjrq);
					this.jzrkTj(list, tjrq);
					this.ldrkTj(list, tjrq);
					this.jwryTj(list, tjrq);
					this.wlhryTj(list, tjrq);
					this.czfwTj(list, tjrq);
					this.czrTj(list, tjrq);
					this.sydwTj(list, tjrq);
					this.cyryTj(list, tjrq);

					
				}

			}
			for (Gzltjb entity : list) {
				entity.setId(UUID.create());

				this.gzltjbDao.save(entity);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 人户一致统计
	 * 
	 * @param list
	 * @return
	 */
	private void rhyzTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sfrhyzdm", "1");
		map.put("date", date);
		List<GzltjVo> rhyzGzltjList = gzltjbDao.czrkTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : rhyzGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setRhyz_add(vo.getXz());
					list.get(i).setRhyz_update(vo.getXg());
					list.get(i).setRhyz_delete(vo.getZx());
					break;
				}
			}
		}

	}

	/**
	 * 人户分离统计
	 * 
	 * @param list
	 * @return
	 */
	private void rhflTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sfrhyzdm", "0");
		map.put("date", date);
		List<GzltjVo> rhflGzltjList = gzltjbDao.czrkTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : rhflGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setRhfl_add(vo.getXz());
					list.get(i).setRhfl_update(vo.getXg());
					list.get(i).setRhfl_delete(vo.getZx());
					break;
				}
			}
		}

	}

	/**
	 * 寄住人口统计
	 * 
	 * @param list
	 * @return
	 */
	private void jzrkTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("syrkywlxdm", "2");
		map.put("date", date);
		List<GzltjVo> jzrkGzltjList = gzltjbDao.syrkTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : jzrkGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setJzrk_add(vo.getXz());
					list.get(i).setJzrk_update(vo.getXg());
					list.get(i).setJzrk_delete(vo.getZx());

					break;
				}
			}
		}

	}

	/**
	 * 流动人口统计
	 * 
	 * @param list
	 * @return
	 */
	private void ldrkTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("syrkywlxdm", "3");
		map.put("date", date);
		List<GzltjVo> ldrkGzltjList = gzltjbDao.syrkTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : ldrkGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setLdrk_add(vo.getXz());
					list.get(i).setLdrk_update(vo.getXg());
					list.get(i).setLdrk_delete(vo.getZx());

					break;
				}
			}
		}

	}

	/**
	 * 境外人员
	 * 
	 * @param list
	 * @return
	 */
	private void jwryTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("syrkywlxdm", "4");
		map.put("date", date);
		List<GzltjVo> jwryGzltjList = gzltjbDao.syrkTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : jwryGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setJwry_add(vo.getXz());
					list.get(i).setJwry_update(vo.getXg());
					list.get(i).setJwry_delete(vo.getZx());

					break;
				}
			}
		}
	}

	/**
	 * 未落户人员
	 * 
	 * @param list
	 * @return
	 */
	private void wlhryTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("syrkywlxdm", "5");
		map.put("date", date);
		List<GzltjVo> wlhryGzltjList = gzltjbDao.syrkTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : wlhryGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setWlhry_add(vo.getXz());
					list.get(i).setWlhry_update(vo.getXg());
					list.get(i).setWlhry_delete(vo.getZx());

					break;
				}
			}
		}
	}

	/**
	 * 出租房屋统计
	 * 
	 * @param list
	 * @return
	 */
	private void czfwTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("syrkywlxdm", "5");
		map.put("date", date);
		List<GzltjVo> czfwGzltjList = gzltjbDao.czfwTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : czfwGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setCzfw_add(vo.getXz());
					list.get(i).setCzfw_update(vo.getXg());
					list.get(i).setCzfw_delete(vo.getZx());

					break;
				}
			}
		}

	}

	/**
	 * 承租人统计
	 * 
	 * @param list
	 * @return
	 */
	private void czrTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		List<GzltjVo> czrGzltjList = gzltjbDao.czrTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : czrGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setCzr_add(vo.getXz());
					list.get(i).setCzr_update(vo.getXg());
					list.get(i).setCzr_delete(vo.getZx());

					break;
				}
			}
		}

	}

	/**
	 * 实有单位统计
	 * 
	 * @param list
	 * @return
	 */
	private void sydwTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		List<GzltjVo> dwGzltjList = gzltjbDao.sydwTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : dwGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setDw_add(vo.getXz());
					list.get(i).setDw_update(vo.getXg());
					list.get(i).setDw_delete(vo.getZx());

					break;
				}
			}
		}
	}

	/**
	 * 从业人员统计
	 * 
	 * @param list
	 * @return
	 */
	private void cyryTj(List<Gzltjb> list, String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		List<GzltjVo> cyryGzltjList = gzltjbDao.cyryTj(map);
		for (int i = 0; i < list.size(); i++) {
			for (GzltjVo vo : cyryGzltjList) {
				if (list.get(i).getGxzrqdm().equals(vo.getGxzrqdm())) {
					list.get(i).setCyry_add(vo.getXz());
					list.get(i).setCyry_update(vo.getXg());
					list.get(i).setCyry_delete(vo.getZx());

					break;
				}
			}
		}
	}

	@Override
	public void exportGzltjb(String level,
			List<Gzltjb>  list, ServletOutputStream outputStream) {

		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("工作量统计表");
			XSSFRow head = sheet.createRow(0);
			XSSFCell cell = null;
			//第一行
			XSSFRow row1 = sheet.createRow(1);
			//第二行
			XSSFRow row2 = sheet.createRow(2);
			
			XSSFCellStyle style=wb.createCellStyle();
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);			
			
			
		    CellRangeAddress rangeDw=new CellRangeAddress(0, 2, 0, 0);		    
		    cell=head.createCell(0);
		    cell.setCellStyle(style);
		    cell.setCellValue("单位");
		    sheet.addMergedRegion(rangeDw);
		    
		    cell=head.createCell(1);
		    cell.setCellValue("实有人口");
		    cell.setCellStyle(style);
		    CellRangeAddress rangeSyrk=new CellRangeAddress(0, 0, 1, 18);	
		    sheet.addMergedRegion(rangeSyrk);

		    
		    cell=row1.createCell(1);
		    cell.setCellValue("人户一致");		   
		    cell.setCellStyle(style);
		    CellRangeAddress rangeRhyz=new CellRangeAddress(1, 1, 1, 3);
		    sheet.addMergedRegion(rangeRhyz);

		    cell=row1.createCell(4);
		    cell.setCellValue("人户分离");
		    cell.setCellStyle(style);
		    CellRangeAddress rangeRhfl=new CellRangeAddress(1, 1, 4, 6);	
		    sheet.addMergedRegion(rangeRhfl);

		    cell=row1.createCell(7);
		    cell.setCellValue("寄住人口");
		    cell.setCellStyle(style);
		    CellRangeAddress rangeJzrk=new CellRangeAddress(1, 1, 7, 9);	
		    sheet.addMergedRegion(rangeJzrk);

		    cell=row1.createCell(10);
		    cell.setCellStyle(style);
		    cell.setCellValue("流动人口");
		    CellRangeAddress rangeLdrk=new CellRangeAddress(1, 1, 10, 12);	
		    sheet.addMergedRegion(rangeLdrk);

		    cell=row1.createCell(13);
		    cell.setCellStyle(style);
		    cell.setCellValue("境外人员");
		    CellRangeAddress rangeJwry=new CellRangeAddress(1, 1, 13, 15);	
		    sheet.addMergedRegion(rangeJwry);

		    cell=row1.createCell(16);
		    cell.setCellStyle(style);
		    cell.setCellValue("未落户人员");
		    CellRangeAddress rangeWlhrk=new CellRangeAddress(1, 1, 16, 18);	
		    sheet.addMergedRegion(rangeWlhrk);

		    cell=row2.createCell(1);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(2);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(3);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(4);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(5);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(6);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(7);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(8);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(9);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(10);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(11);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(12);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(13);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(14);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(15);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(16);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(17);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(18);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    	    

		    cell=head.createCell(19);
		    cell.setCellStyle(style);
		    cell.setCellValue("实有房屋");
		    CellRangeAddress rangeSyfw=new CellRangeAddress(0, 0,19, 24);		    
		    sheet.addMergedRegion(rangeSyfw);
		    
		    cell=row1.createCell(19);
		    cell.setCellStyle(style);
		    cell.setCellValue("出租房屋");
		    CellRangeAddress rangeCzfw=new CellRangeAddress(1, 1,19, 21);		    
		    sheet.addMergedRegion(rangeCzfw);
		    
		    cell=row1.createCell(22);
		    cell.setCellStyle(style);
		    cell.setCellValue("承租人");
		    CellRangeAddress rangeCzr=new CellRangeAddress(1, 1,22, 24);		    
		    sheet.addMergedRegion(rangeCzr);
		    
		    cell=row2.createCell(19);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(20);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(21);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(22);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(23);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(24);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    
		    
		    cell=head.createCell(25);
		    cell.setCellStyle(style);
		    cell.setCellValue("实有单位");
		    CellRangeAddress rangeSydw=new CellRangeAddress(0, 0, 25, 30);		    
		    sheet.addMergedRegion(rangeSydw);
		    
		    cell=row1.createCell(25);
		    cell.setCellStyle(style);
		    cell.setCellValue("单位基本信息");
		    CellRangeAddress rangeDwjbxx=new CellRangeAddress(1, 1, 25, 27);		    
		    sheet.addMergedRegion(rangeDwjbxx);
		    
		    cell=row1.createCell(28);
		    cell.setCellStyle(style);
		    cell.setCellValue("从业人员");
		    CellRangeAddress rangeCyry=new CellRangeAddress(1, 1, 28, 30);		    
		    sheet.addMergedRegion(rangeCyry);
		    
		    cell=row2.createCell(25);
		    cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(26);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(27);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    cell=row2.createCell(28);
		 	cell.setCellStyle(style);
		    cell.setCellValue("新增");
		    cell=row2.createCell(29);
		    cell.setCellStyle(style);
		    cell.setCellValue("修改");
		    cell=row2.createCell(30);
		    cell.setCellStyle(style);
		    cell.setCellValue("注销");
		    
		    
			for(int i = 0; i < list.size(); i ++){
				XSSFRow row = sheet.createRow(i + 3);

				
				
			        cell = row.createCell(0);
			        if("1".endsWith(level)){
				        cell.setCellValue(list.get(i).getGxfjname());			
			        }else if("2".endsWith(level)){
				        cell.setCellValue(list.get(i).getGxpcsname());			

			        }else if("3".endsWith(level)){
				        cell.setCellValue(list.get(i).getGxzrqname());			
			        }
				
				    cell = row.createCell(1);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getRhyz_add()==null?0:list.get(i).getRhyz_add());				
				    cell = row.createCell(2);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getRhyz_update()==null?0:list.get(i).getRhyz_update());
				    cell = row.createCell(3);	
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getRhyz_delete()==null?0:list.get(i).getRhyz_delete());
				    
				    cell = row.createCell(4);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getRhfl_add()==null?0:list.get(i).getRhfl_add());
				    cell = row.createCell(5);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getRhfl_update()==null?0:list.get(i).getRhfl_update());
				    cell = row.createCell(6);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getRhfl_delete()==null?0:list.get(i).getRhfl_delete());
				    
				    cell = row.createCell(7);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getJzrk_add()==null?0:list.get(i).getJzrk_add());
				    cell = row.createCell(8);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getJzrk_update()==null?0:list.get(i).getJzrk_update());
				    cell = row.createCell(9);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getJzrk_delete()==null?0:list.get(i).getJzrk_delete());
				    
				    cell = row.createCell(10);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getLdrk_add()==null?0:list.get(i).getLdrk_add());
				    cell = row.createCell(11);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getLdrk_update()==null?0:list.get(i).getLdrk_update());
				    cell = row.createCell(12);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getLdrk_delete()==null?0:list.get(i).getLdrk_delete());
				    
				    cell = row.createCell(13);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getJwry_add()==null?0:list.get(i).getJwry_add());
				    cell = row.createCell(14);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getJwry_update()==null?0:list.get(i).getJwry_update());
				    cell = row.createCell(15);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getJwry_delete()==null?0:list.get(i).getJwry_delete());
				    
				    cell = row.createCell(16);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getWlhry_add()==null?0:list.get(i).getWlhry_add());
				    cell = row.createCell(17);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getWlhry_update()==null?0:list.get(i).getWlhry_update());
				    cell = row.createCell(18);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getWlhry_delete()==null?0:list.get(i).getWlhry_delete());
				    
				    cell = row.createCell(19);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCzfw_add()==null?0:list.get(i).getCzfw_add());
				    cell = row.createCell(20);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCzfw_update()==null?0:list.get(i).getCzfw_update());
				    cell = row.createCell(21);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCzfw_delete()==null?0:list.get(i).getCzfw_delete());
				    
				    
				    cell = row.createCell(22);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCzr_add()==null?0:list.get(i).getCzr_add());
				    cell = row.createCell(23);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCzr_update()==null?0:list.get(i).getCzr_update());
				    cell = row.createCell(24);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCzr_delete()==null?0:list.get(i).getCzr_delete());
				    
				    cell = row.createCell(25);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getDw_add()==null?0:list.get(i).getDw_add());
				    cell = row.createCell(26);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getDw_update()==null?0:list.get(i).getDw_update());
				    cell = row.createCell(27);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getDw_delete()==null?0:list.get(i).getDw_delete());
				    
				    cell = row.createCell(28);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCyry_add()==null?0:list.get(i).getCyry_add());
				    cell = row.createCell(29);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCyry_update()==null?0:list.get(i).getCyry_update());
				    cell = row.createCell(30);
				    cell.setCellStyle(style);
				    cell.setCellValue(list.get(i).getCyry_delete()==null?0:list.get(i).getCyry_delete());
	
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

}
