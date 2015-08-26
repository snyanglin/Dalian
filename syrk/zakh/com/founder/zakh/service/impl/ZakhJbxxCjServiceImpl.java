/**********************************************************************   
 * <p>文件名：ZakhJbxxCjServiceImpl.java </p>
 * <p>文件描述：治安考核-基本信息采集服务实现类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午9:45:07 
 * @history
 * @department：研发部
 *
 */
package com.founder.zakh.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.UUID;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.gzjk.dao.GzltjbDao;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.dao.TzggDao;
import com.founder.zakh.bean.Khfstjb;
import com.founder.zakh.bean.ZakhCjclBean;
import com.founder.zakh.bean.ZakhJbxxCjBean;
import com.founder.zakh.bean.ZakhZzjgBean;
import com.founder.zakh.dao.KhfstjbDao;
import com.founder.zakh.dao.ZakhCjclDao;
import com.founder.zakh.dao.ZakhJbxxCjDao;
import com.founder.zakh.dao.ZakhZzgjDao;
import com.founder.zakh.service.ZakhJbxxCjService;
import com.founder.zakh.tools.Dateutil;
import com.founder.zakh.tools.StringFormulaCountUtil;
import com.founder.zakh.vo.KhfstjVO;

/******************************************************************************
 * @Package: [com.founder.zakh.service.impl.ZakhJbxxCjServiceImpl.java]
 * @ClassName: [ZakhJbxxCjServiceImpl]
 * @Description: [治安考核-基本信息采集服务实现类]
 * @Author: [wu.w@founder.com.cn]
 * @CreateDate: [2015-4-17 上午9:45:07]
 * @UpdateUser: [Way(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-17 上午9:45:07，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Service("zakhJbxxCjService")
@Transactional
public class ZakhJbxxCjServiceImpl implements ZakhJbxxCjService {

	@Resource(name = "zakhJbxxCjDao")
	private ZakhJbxxCjDao cjDao;

	@Resource(name = "zakhCjclDao")
	private ZakhCjclDao clDao;

	@Resource(name = "zakhZzgjDao")
	private ZakhZzgjDao jgDao;
	@Resource(name = "gzltjbDao")
	private GzltjbDao gzltjbDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "khfstjbDao")
	private KhfstjbDao khfstjbDao;
	@Resource
	private TzggDao tzggDao;
	@Resource
	private ZakhCjclDao zakhCjclDao;

	/*
	 * (非 Javadoc) <p>Title: save</p> <p>Description: </p>
	 * 
	 * @param entity
	 * 
	 * @see
	 * com.founder.zakh.service.ZakhJbxxCjService#save(com.founder.zakh.bean.ZakhJbxxCjBean
	 * )
	 */
	@Override
	public void save(ZakhJbxxCjBean entity) {
		entity.setId(UUID.create());

	}
	/*
	 * (非 Javadoc) <p>Title: update</p> <p>Description: </p>
	 * 
	 * @param entitey
	 * 
	 * @return
	 * 
	 * @see
	 * com.founder.zakh.service.ZakhJbxxCjService#update(com.founder.zakh.bean.ZakhJbxxCjBean
	 * )
	 */
	@Override
	public int update(ZakhJbxxCjBean entitey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> queryKhtj(Map<String, String> map) {

		Map<String, Object> resMap = new HashMap<String, Object>();// 返回结果
		List<KhfstjVO> resList = new ArrayList<KhfstjVO>();
		List<Khfstjb> list = khfstjbDao.queryKhtjb(map);
		int i = 1;
		for (Khfstjb khfstjb : list) {

			KhfstjVO jcxxVo = new KhfstjVO();
			jcxxVo.setZakh_dwjg(khfstjb.getZzjgname());
			jcxxVo.setZakh_zzjgid(khfstjb.getZzjgdm());
			jcxxVo.setZakh_kfs(String.valueOf(khfstjb.getJcxxkf()));
			jcxxVo.setZakh_dfs(String.valueOf(khfstjb.getJcxxkhdf()));
			jcxxVo.setZakh_ljkfs(String.valueOf(khfstjb.getJcxxkfhj()));
			jcxxVo.setZakh_khx("基础信息采集");
			jcxxVo.setZakh_pm(String.valueOf(i));
			jcxxVo.setZakh_zfs(String.valueOf(khfstjb.getJcxxkhzf()));
			resList.add(jcxxVo);
			i++;

			KhfstjVO zdryVo = new KhfstjVO();
			zdryVo.setZakh_khx("重点人员管理");
			resList.add(zdryVo);
			KhfstjVO zaffVo = new KhfstjVO();
			zaffVo.setZakh_khx("治安防范控制");
			resList.add(zaffVo);

		}
		resMap.put("rows", resList);
		resMap.put("total", resList.size());

		return resMap;
	}

	@Override
	public Map<String, Object> queryXXByGzltj(Map<String, String> paramMap) {
		Gzltjb gzltjb = gzltjbDao.queryGzltjForKh(paramMap);

		Long clCount = this.clDao.querySumCl(paramMap);
		if(clCount==null){
			clCount=0L;
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 采集总数
		long cjzs = (gzltjb.getRhyz_add() == null ? 0 : gzltjb.getRhyz_add())
				+ (gzltjb.getRhfl_add() == null ? 0 : gzltjb.getRhfl_add())
				+ (gzltjb.getJzrk_add() == null ? 0 : gzltjb.getJzrk_add())
				+ (gzltjb.getLdrk_add() == null ? 0 : gzltjb.getLdrk_add())
				+ (gzltjb.getJwry_add() == null ? 0 : gzltjb.getJwry_add())
				+ (gzltjb.getWlhry_add() == null ? 0 : gzltjb.getWlhry_add())
				+ (gzltjb.getCzfw_add() == null ? 0 : gzltjb.getCzfw_add())
				+ (gzltjb.getCzr_add() == null ? 0 : gzltjb.getCzr_add())
				+ (gzltjb.getDw_add() == null ? 0 : gzltjb.getDw_add())
				+ (gzltjb.getCyry_add() == null ? 0 : gzltjb.getCyry_add())
				-((gzltjb.getRhyz_delete() == null ? 0 : gzltjb.getRhyz_delete())
						+ (gzltjb.getRhfl_delete() == null ? 0 : gzltjb.getRhfl_delete())
						+ (gzltjb.getJzrk_delete() == null ? 0 : gzltjb.getJzrk_delete())
						+ (gzltjb.getLdrk_delete() == null ? 0 : gzltjb.getLdrk_delete())
						+ (gzltjb.getJwry_delete() == null ? 0 : gzltjb.getJwry_delete())
						+ (gzltjb.getWlhry_delete() == null ? 0 : gzltjb.getWlhry_delete())
						+ (gzltjb.getCzfw_delete() == null ? 0 : gzltjb.getCzfw_delete())
						+ (gzltjb.getCzr_delete() == null ? 0 : gzltjb.getCzr_delete())
						+ (gzltjb.getDw_delete() == null ? 0 : gzltjb.getDw_delete())
						+ (gzltjb.getCyry_delete() == null ? 0 : gzltjb.getCyry_delete()));
        if(cjzs<0){
        	cjzs=0;
        }
		Map<String, String> rhyzMap = new HashMap<String, String>();
		rhyzMap.put("zakh_xq_khx", "基础信息采集");
		rhyzMap.put("zakh_xq_khxx", "实有人口信息");
		rhyzMap.put("zakh_xq_khxl", "人户一致人口");
		rhyzMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		rhyzMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getRhyz_add() == null ? 0 : gzltjb
						.getRhyz_add()));
		rhyzMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getRhyz_delete() == null ? 0 : gzltjb
						.getRhyz_delete()));
		rhyzMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(rhyzMap);

		Map<String, String> rhflMap = new HashMap<String, String>();
		rhflMap.put("zakh_xq_khx", "基础信息采集");
		rhflMap.put("zakh_xq_khxx", "实有人口信息");
		rhflMap.put("zakh_xq_khxl", "人户分离人口");
		rhflMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		rhflMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getRhfl_add() == null ? 0 : gzltjb
						.getRhfl_add()));
		rhflMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getRhfl_delete() == null ? 0 : gzltjb
						.getRhfl_delete()));
		rhflMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(rhflMap);

		Map<String, String> jzrkMap = new HashMap<String, String>();
		jzrkMap.put("zakh_xq_khx", "基础信息采集");
		jzrkMap.put("zakh_xq_khxx", "实有人口信息");
		jzrkMap.put("zakh_xq_khxl", "寄住人口");
		jzrkMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		jzrkMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getJzrk_add() == null ? 0 : gzltjb
						.getJzrk_add()));
		jzrkMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getJzrk_delete() == null ? 0 : gzltjb
						.getJzrk_delete()));
		jzrkMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(jzrkMap);

		Map<String, String> ldrkMap = new HashMap<String, String>();
		ldrkMap.put("zakh_xq_khx", "基础信息采集");
		ldrkMap.put("zakh_xq_khxx", "实有人口信息");
		ldrkMap.put("zakh_xq_khxl", "流动人口");
		ldrkMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		ldrkMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getLdrk_add() == null ? 0 : gzltjb
						.getLdrk_add()));
		ldrkMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getLdrk_delete() == null ? 0 : gzltjb
						.getLdrk_delete()));
		ldrkMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(ldrkMap);

		Map<String, String> jwryMap = new HashMap<String, String>();
		jwryMap.put("zakh_xq_khx", "基础信息采集");
		jwryMap.put("zakh_xq_khxx", "实有人口信息");
		jwryMap.put("zakh_xq_khxl", "境外人员");
		jwryMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		jwryMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getJwry_add() == null ? 0 : gzltjb
						.getJwry_add()));
		jwryMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getJwry_delete() == null ? 0 : gzltjb
						.getJwry_delete()));
		jwryMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(jwryMap);

		Map<String, String> wlhryMap = new HashMap<String, String>();
		wlhryMap.put("zakh_xq_khx", "基础信息采集");
		wlhryMap.put("zakh_xq_khxx", "实有人口信息");
		wlhryMap.put("zakh_xq_khxl", "未落户人员");
		wlhryMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		wlhryMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getWlhry_add() == null ? 0 : gzltjb
						.getWlhry_add()));
		wlhryMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getWlhry_delete() == null ? 0 : gzltjb
						.getWlhry_delete()));
		wlhryMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(wlhryMap);

		Map<String, String> czfwMap = new HashMap<String, String>();
		czfwMap.put("zakh_xq_khx", "基础信息采集");
		czfwMap.put("zakh_xq_khxx", "实有房屋信息");
		czfwMap.put("zakh_xq_khxl", "出租房屋");
		czfwMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		czfwMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getCzfw_add() == null ? 0 : gzltjb
						.getCzfw_add()));
		czfwMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getCzfw_delete() == null ? 0 : gzltjb
						.getCzfw_delete()));
		czfwMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(czfwMap);

		Map<String, String> czrMap = new HashMap<String, String>();
		czrMap.put("zakh_xq_khx", "基础信息采集");
		czrMap.put("zakh_xq_khxx", "实有房屋信息");
		czrMap.put("zakh_xq_khxl", "承租人");
		czrMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		czrMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getCzr_add() == null ? 0 : gzltjb
						.getCzr_add()));
		czrMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getCzr_delete() == null ? 0 : gzltjb
						.getCzr_delete()));
		czrMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(czrMap);

		Map<String, String> dwjbxxMap = new HashMap<String, String>();
		dwjbxxMap.put("zakh_xq_khx", "基础信息采集");
		dwjbxxMap.put("zakh_xq_khxx", "实有单位信息");
		dwjbxxMap.put("zakh_xq_khxl", "单位基本信息");
		dwjbxxMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		dwjbxxMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getDw_add() == null ? 0 : gzltjb
						.getDw_add()));
		dwjbxxMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getDw_delete() == null ? 0 : gzltjb
						.getDw_delete()));
		dwjbxxMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(dwjbxxMap);

		Map<String, String> cyryMap = new HashMap<String, String>();
		cyryMap.put("zakh_xq_khx", "基础信息采集");
		cyryMap.put("zakh_xq_khxx", "实有单位信息");
		cyryMap.put("zakh_xq_khxl", "从业人员");
		cyryMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		cyryMap.put("zakh_xq_ycjs",
				String.valueOf(gzltjb.getCyry_add() == null ? 0 : gzltjb
						.getCyry_add()));
		cyryMap.put("zakh_xq_kfz",
				String.valueOf(gzltjb.getCyry_delete() == null ? 0 : gzltjb
						.getCyry_delete()));
		cyryMap.put("zakh_xq_cjzs", String.valueOf(cjzs));
		list.add(cyryMap);

		Map<String, String> hjMap = new HashMap<String, String>();
		hjMap.put("zakh_xq_khx", "基础信息采集");
		hjMap.put("zakh_xq_khxx", "合计");
		hjMap.put("zakh_xq_khxl", "");
		hjMap.put("zakh_xq_cls", (String.valueOf(clCount)));
		hjMap.put("zakh_xq_ycjs",
				String.valueOf((gzltjb.getCyry_add() == null ? 0 : gzltjb.getCyry_add())
						     + (gzltjb.getDw_add() == null ? 0 : gzltjb.getDw_add()
							 + (gzltjb.getCzr_add() == null ? 0 : gzltjb.getCzr_add())
							 + (gzltjb.getCzfw_add() == null ? 0: gzltjb.getCzfw_add())
							 + (gzltjb.getWlhry_add() == null ? 0: gzltjb.getWlhry_add())
							  +(gzltjb.getJwry_add() == null ? 0 : gzltjb.getJwry_add())
						     +(gzltjb.getLdrk_add() == null ? 0 : gzltjb.getLdrk_add())
						     +(gzltjb.getJzrk_add() == null ? 0 : gzltjb
										.getJzrk_add())
						     +(gzltjb.getRhfl_add() == null ? 0 : gzltjb.getRhfl_add())
						     +(gzltjb.getRhyz_add() == null ? 0 : gzltjb
										.getRhyz_add()))));
		hjMap.put("zakh_xq_kfz",
				String.valueOf((gzltjb.getCyry_delete() == null ? 0 : gzltjb.getCyry_delete())
					     + (gzltjb.getDw_delete() == null ? 0 : gzltjb.getDw_delete())
						 + (gzltjb.getCzr_delete() == null ? 0 : gzltjb.getCzr_delete())
						 + (gzltjb.getCzfw_delete() == null ? 0: gzltjb.getCzfw_delete())
						 + (gzltjb.getWlhry_delete() == null ? 0: gzltjb.getWlhry_delete())
						  +(gzltjb.getJwry_delete() == null ? 0 : gzltjb.getJwry_delete())
					     +(gzltjb.getLdrk_delete() == null ? 0 : gzltjb.getLdrk_delete())
					     +(gzltjb.getJzrk_delete() == null ? 0 : gzltjb
									.getJzrk_delete())
					     +(gzltjb.getRhfl_delete() == null ? 0 : gzltjb.getRhfl_delete())
					     +(gzltjb.getRhyz_delete() == null ? 0 : gzltjb
									.getRhyz_delete())));
		hjMap.put("zakh_xq_cjzs",String.valueOf(cjzs));
		list.add(hjMap);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("total", list.size());
		resMap.put("rows", list);
		return resMap;
	}

	@Override
	public void exportExcel(List<KhfstjVO> list,
			ServletOutputStream outputStream) {
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("治安考核信息表");
			XSSFRow head = sheet.createRow(0);
			XSSFCell cell = null;

			XSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

			cell = head.createCell(0);
			cell.setCellStyle(style);
			cell.setCellValue("排名");

			cell = head.createCell(1);
			cell.setCellValue("单位机构");
			cell.setCellStyle(style);

			cell = head.createCell(2);
			cell.setCellValue("考核项目");
			cell.setCellStyle(style);

			cell = head.createCell(3);
			cell.setCellValue("本周扣分");
			cell.setCellStyle(style);

			cell = head.createCell(4);
			cell.setCellValue("累计扣分");
			cell.setCellStyle(style);

			cell = head.createCell(5);
			cell.setCellValue("考核得分");
			cell.setCellStyle(style);

			cell = head.createCell(6);
			cell.setCellValue("总分");
			cell.setCellStyle(style);

			for (int i = 0; i < list.size(); i++) {

				if (i % 3 == 0) {
					// 基础信息行
					XSSFRow rowJcxx = sheet.createRow(i + 1);
					// 排名列
					cell = rowJcxx.createCell(0);
					cell.setCellStyle(style);
					cell.setCellValue(i);
					// 单位机构
					cell = rowJcxx.createCell(1);
					cell.setCellStyle(style);
					cell.setCellValue(list.get(i).getZakh_dwjg());
					// 考核项目
					cell = rowJcxx.createCell(2);
					cell.setCellStyle(style);
					cell.setCellValue("基础信息采集");

					// 基础信息扣分
					cell = rowJcxx.createCell(3);
					cell.setCellStyle(style);
					cell.setCellValue(list.get(i).getZakh_kfs());

					// 基础信息累计扣分
					cell = rowJcxx.createCell(4);
					cell.setCellStyle(style);
					cell.setCellValue(list.get(i).getZakh_ljkfs());

					// 考核得分
					cell = rowJcxx.createCell(5);
					cell.setCellStyle(style);
					cell.setCellValue(list.get(i).getZakh_dfs());

					// 总分数
					cell = rowJcxx.createCell(6);
					cell.setCellStyle(style);
					cell.setCellValue(list.get(i).getZakh_zfs());

					CellRangeAddress rangePm = new CellRangeAddress(i + 1,
							i + 3, 0, 0);
					cell = rowJcxx.createCell(0);
					cell.setCellStyle(style);
					cell.setCellValue(i / 3 + 1);
					sheet.addMergedRegion(rangePm);

					CellRangeAddress rangeDwjg = new CellRangeAddress(i + 1,
							i + 3, 1, 1);
					cell = rowJcxx.createCell(1);
					cell.setCellStyle(style);
					cell.setCellValue(list.get(i).getZakh_dwjg());
					sheet.addMergedRegion(rangeDwjg);
				} else if (i % 3 == 1) {
					// 重点人员行
					XSSFRow rowZdry = sheet.createRow(i + 1);
					// 排名列
					cell = rowZdry.createCell(0);
					cell.setCellStyle(style);
					// 单位机构
					cell = rowZdry.createCell(1);
					cell.setCellStyle(style);

					// 考核项目
					cell = rowZdry.createCell(2);
					cell.setCellStyle(style);
					cell.setCellValue("重点人员管理");

					// 基础信息扣分
					cell = rowZdry.createCell(3);
					cell.setCellStyle(style);
					cell.setCellValue(0);

					// 基础信息累计扣分
					cell = rowZdry.createCell(4);
					cell.setCellStyle(style);
					cell.setCellValue(0);

					// 考核得分
					cell = rowZdry.createCell(5);
					cell.setCellStyle(style);
					cell.setCellValue(0);

					// 总分数
					cell = rowZdry.createCell(6);
					cell.setCellStyle(style);
					cell.setCellValue(0);

				} else if (i % 3 == 2) {
					// 治安防范控制行
					XSSFRow rowZaff = sheet.createRow(i + 1);
					// 排名列
					cell = rowZaff.createCell(0);
					cell.setCellStyle(style);
					// 单位机构
					cell = rowZaff.createCell(1);
					cell.setCellStyle(style);

					// 考核项目
					cell = rowZaff.createCell(2);
					cell.setCellStyle(style);
					cell.setCellValue("治安防范控制");

					// 基础信息扣分
					cell = rowZaff.createCell(3);
					cell.setCellStyle(style);
					cell.setCellValue(0);

					// 基础信息累计扣分
					cell = rowZaff.createCell(4);
					cell.setCellStyle(style);
					cell.setCellValue(0);

					// 考核得分
					cell = rowZaff.createCell(5);
					cell.setCellStyle(style);
					cell.setCellValue(0);

					// 总分数
					cell = rowZaff.createCell(6);
					cell.setCellStyle(style);
					cell.setCellValue(0);
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
	public void bckhfstj(String dateString) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(dateString);
			Dateutil dt = new Dateutil();
			int week = dt.getWeekOfYear(date);
			int year = Integer.valueOf(dateString.substring(0, 4));
			Date startDate = dt.getFirstDayOfWeek(year, week);
			Date endDate = dt.getLastDayOfWeek(year, week);

			Date date1225 = sdf.parse(year + "-12-25");
			Date date1226 = sdf.parse(year + "-12-26");

			int week1225 = dt.getWeekOfYear(date1225);
			int week1226 = dt.getWeekOfYear(date1226);
			if (week == week1225 && week1225 == week1226) {
				// 需要执行两个周期内的 假如 周期是12-23到12月29 则 需要执行一次12-23到12-25一次 和
				// 12-26到12-29一次

				// 判断这周是否执行过，防止集群重复执行
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("year", String.valueOf(year));
				paramMap.put("week", String.valueOf(week));
				List<Khfstjb> list = this.khfstjbDao.queryKhtjb(paramMap);
				if (null != list && list.size() > 0) {
					throw new BussinessException("此周期的数据已存在");
				}

				Date startDate1 = startDate;
				Date endDate1 = date1225;
				Date startDate2 = date1226;
				Date endDate2 = endDate;
				this.tjZrq(year, week, startDate1, endDate1);
				this.tjPcs(year, week, startDate1, endDate1);
				this.tjFj(year, week, startDate1, endDate1);

				this.tjZrq(year, week, startDate2, endDate2);
				this.tjPcs(year, week, startDate2, endDate2);
				this.tjFj(year, week, startDate2, endDate2);
			} else {
				// 判断这周是否执行过，防止集群重复执行
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("year", String.valueOf(year));
				paramMap.put("week", String.valueOf(week));
				List<Khfstjb> list = this.khfstjbDao.queryKhtjb(paramMap);
				if (null != list && list.size() > 0) {
					throw new BussinessException("此周期的数据已存在");
				}

				this.tjZrq(year, week, startDate, endDate);
				this.tjPcs(year, week, startDate, endDate);
				this.tjFj(year, week, startDate, endDate);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void tjFj(int tjYear, int tjWeek, Date startDate, Date endDate) {
		Org_Organization org = new Org_Organization();
		// 查询分局sql语句
		org.setOrglevel("21");
		org.setOrgbiztype("01");
		List<Org_Organization> fjOrgs = tzggDao.queryOrg(org);

		createData(tjYear, tjWeek, startDate, endDate, fjOrgs, "fj");
	}

	public void tjPcs(int tjYear, int tjWeek, Date startDate, Date endDate) {
		Org_Organization org = new Org_Organization();
		// 查询派出所sql语句
		org.setOrglevel("32");
		org.setOrgbiztype("01");
		List<Org_Organization> pcsOrgs = tzggDao.queryOrg(org);
		this.createData(tjYear, tjWeek, startDate, endDate, pcsOrgs, "pcs");

	}

	public void tjZrq(int tjYear, int tjWeek, Date startDate, Date endDate) {
		Org_Organization org = new Org_Organization();
		// 查询责任区sql语句
		org.setOrglevel("50");
		org.setOrgbiztype("04");
		List<Org_Organization> zrqOrgs = tzggDao.queryOrg(org);
		this.createData(tjYear, tjWeek, startDate, endDate, zrqOrgs, "zrq");
	}

	private void createData(int tjYear, int tjWeek, Date startDate,
			Date endDate, List<Org_Organization> orgs, String zzjgdj) {
		List<Khfstjb> list = new ArrayList<Khfstjb>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (Org_Organization org : orgs) {
			Map<String, String> clParamMap = new HashMap<String, String>();
			clParamMap.put("orgCode", org.getOrgcode());
			Long cl = this.zakhCjclDao.querySumCl(clParamMap);
			if(cl==null){
				cl=0L;
			}
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("startDate", sdf.format(startDate));
			paramMap.put("endDate", sdf.format(endDate));
			paramMap.put("orgCode", org.getOrgcode());
			Gzltjb gzltj = gzltjbDao.queryGzltjForKh(paramMap);
			// 新增数
			long sumAdd = (gzltj.getRhfl_add() != null ? gzltj.getRhfl_add()
					: 0)
					+ (gzltj.getRhyz_add() != null ? gzltj.getRhyz_add() : 0)
					+ (gzltj.getJzrk_add() != null ? gzltj.getJzrk_add() : 0)
					+ (gzltj.getLdrk_add() != null ? gzltj.getLdrk_add() : 0)
					+ (gzltj.getJwry_add() != null ? gzltj.getJwry_add() : 0)
					+ (gzltj.getWlhry_add() != null ? gzltj.getWlhry_add() : 0)
					+ (gzltj.getCzfw_add() != null ? gzltj.getCzfw_add() : 0)
					+ (gzltj.getCzr_add() != null ? gzltj.getCzr_add() : 0)
					+ (gzltj.getDw_add() != null ? gzltj.getDw_add() : 0)
					+ (gzltj.getCyry_add() != null ? gzltj.getCyry_add() : 0);
			// 注销数
			long sumDelete = (gzltj.getRhfl_delete() != null ? gzltj
					.getRhfl_delete() : 0)
					+ (gzltj.getRhyz_delete() != null ? gzltj.getRhyz_delete()
							: 0)
					+ (gzltj.getJzrk_delete() != null ? gzltj.getJzrk_delete()
							: 0)
					+ (gzltj.getLdrk_delete() != null ? gzltj.getLdrk_delete()
							: 0)
					+ (gzltj.getJwry_delete() != null ? gzltj.getJwry_delete()
							: 0)
					+ (gzltj.getWlhry_delete() != null ? gzltj
							.getWlhry_delete() : 0)
					+ (gzltj.getCzfw_delete() != null ? gzltj.getCzfw_delete()
							: 0)
					+ (gzltj.getCzr_delete() != null ? gzltj.getCzr_delete()
							: 0)
					+ (gzltj.getDw_delete() != null ? gzltj.getDw_delete() : 0)
					+ (gzltj.getCyry_delete() != null ? gzltj.getCyry_delete()
							: 0);
			// 考核数
			long khs = sumAdd - sumDelete > 0 ? sumAdd - sumDelete : 0;
			// 总分
			BigDecimal totalScore = new BigDecimal("100");
			// TODO 需要查数据库查当年上周的考核数据（12月26号开始算下一年的） 上周数据
			Map<String, String> szsjMap = new HashMap<String, String>();
			szsjMap.put("orgCode", org.getOrgcode());

			Date weekStartDate = null;
			Date weekEndDate = null;
			try {
				weekStartDate = sdf.parse((tjYear - 1) + "-12-26");
				weekEndDate = sdf.parse(tjYear + "-12-26");

			} catch (ParseException e) {
				e.printStackTrace();
			}
			szsjMap.put("weekStartDate", sdf.format(weekStartDate));
			szsjMap.put("weekEndDate", sdf.format(weekEndDate));
			Khfstjb szsj = this.khfstjbDao.querySzkhtj(szsjMap);
			BigDecimal nowScore = new BigDecimal("100");

			// 责任区周考核数据
			Khfstjb tj = new Khfstjb();
			if (khs >= cl) {
				tj.setJcxxkf(0d);
				tj.setJcxxkfhj(szsj.getJcxxkfhj() == null ? 0d : szsj.getJcxxkfhj());
				tj.setJcxxkhdf(szsj.getJcxxkhdf() == null ? 100d : szsj.getJcxxkhdf());
			} else {
				BigDecimal lessPercent = new BigDecimal(cl - khs).divide(
						new BigDecimal(cl), 5, RoundingMode.HALF_UP).multiply(
						new BigDecimal(100));
				lessPercent = lessPercent.setScale(2, BigDecimal.ROUND_HALF_UP);
				tj.setJcxxkf(lessPercent.doubleValue());
				BigDecimal kfhj = null;
				if (szsj.getJcxxkfhj() == null) {
					kfhj = lessPercent;
				} else {
					kfhj = new BigDecimal(szsj.getJcxxkfhj()).add(lessPercent);
					// 如果扣分合计大于100 则等于100
					if (kfhj.compareTo(new BigDecimal(100)) == 1) {
						kfhj = new BigDecimal(100);
					}

				}
				tj.setJcxxkfhj(kfhj.doubleValue());

				BigDecimal khdf = null;
				if (szsj.getJcxxkhdf() == null) {
					khdf = nowScore.subtract(lessPercent);
				} else {
					khdf = new BigDecimal(szsj.getJcxxkhdf())
							.subtract(lessPercent);
					if (khdf.compareTo(new BigDecimal(0)) == -1) {
						khdf = new BigDecimal(0);
					}
				}

				tj.setJcxxkhdf(khdf.doubleValue());
			}
			tj.setJcxxkhzf(totalScore.doubleValue());
			tj.setYear(String.valueOf(tjYear));
			tj.setWeek(String.valueOf(tjWeek));
			tj.setWeekStartDate(sdf.format(startDate));
			tj.setWeekEndDate(sdf.format(endDate));
			tj.setZzjgdm(org.getOrgcode());
			tj.setZzjgname(org.getOrgname());
			tj.setZzjgdj(zzjgdj);
			list.add(tj);
		}

		for (Khfstjb tj : list) {
			tj.setId(UUID.create());
			this.khfstjbDao.save(tj);
		}
	}

}
