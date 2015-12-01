package com.founder.syrkgl.service.impl;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi3.hssf.util.CellRangeAddress;
import org.apache.poi3.xssf.usermodel.XSSFCell;
import org.apache.poi3.xssf.usermodel.XSSFCellStyle;
import org.apache.poi3.xssf.usermodel.XSSFRow;
import org.apache.poi3.xssf.usermodel.XSSFSheet;
import org.apache.poi3.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.dao.ZpfjPtryzpDao;
import com.founder.syrkgl.bean.Jzzblxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.dao.JzzblxxbDao;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import com.founder.syrkgl.dao.SyrkLdrkxxbDao;
import com.founder.syrkgl.service.JzzblBhSequenceService;
import com.founder.syrkgl.service.JzzblxxbService;
import com.founder.utils.FileUtils;

@Service("jzzblxxbService")
@Transactional
public class JzzblxxbServiceImpl extends BaseService implements JzzblxxbService {
    
	
	@Resource(name = "jzzblxxbDao")
	private JzzblxxbDao jzzblxxbDao;

	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	
	@Resource(name = "syrkLdrkxxbDao")
	private SyrkLdrkxxbDao syrkLdrkxxbDao;
	
	@Resource(name = "zpfjPtryzpDao")
	private ZpfjPtryzpDao zpfjPtryzpDao;
	
	@Resource(name="jzzblBhSequenceService")
	private JzzblBhSequenceService jzzblBhSequenceService;
	@Resource
	private OrgOrganizationService orgOrganizationService;
	
	@Resource
	private SysMessageDao sysMessageDao;
	
	@Override
	public SyrkLdrkxxb queryLdrk(String id) {
		return syrkLdrkxxbDao.queryById(id);
	}
	@Override
	public void saveJzzblxx(Jzzblxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		
		String zrqCode=sessionBean.getUserOrgCode();
		
		//打印编号生成规则：分局2 + 位派出所2位 + 8位流水
		Long sequences = new Long(1);
		String dyBhCode = zrqCode.substring(4, 8);
		sequences = this.jzzblBhSequenceService.getBhSequence(sessionBean, dyBhCode);
		if(sequences == null){
			throw new BussinessException();
		}
		entity.setDy_bh(dyBhCode+String.format("%08d", sequences));
		
		//居住证编号生成规则：组织机构12位 + 4位年 + 6位流水
		sequences = new Long(1);
		String jzzBhCode = zrqCode+DateUtils.getSystemYearString();
		sequences = this.jzzblBhSequenceService.getBhSequence(sessionBean, jzzBhCode);
		if(sequences == null){
			throw new BussinessException();
		}
		entity.setJzz_bh(jzzBhCode+String.format("%06d", sequences));
		entity.setJzz_qfrq(DateUtils.getSystemDateString());
		
		try {
			jzzblxxbDao.saveJzzblxx(entity);
		} catch (Exception e) {
			// 保存时发生的异常，很可能是业务系统数据处理错误。导致了，编码重复。
			//所以，引起了表的字段唯一性约束。异常不能直接暴露给用户
			//此处抛出业务异常
			throw new BussinessException();
		}
		
	}




//	@Override
//	public List<Jzzblxxb> jzzblxxb_query(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		String ryid=(String) map.get("ryid");
//		List<Jzzblxxb> list = null;
//		if(!StringUtils.isBlank(ryid)){
//			list= jzzblxxbDao.queryJzzblxxList(ryid);
//		}
//		return list;
//	}




	@Override
	public EasyUIPage queryJzzblList(EasyUIPage page, Jzzblxxb entity) {
		return jzzblxxbDao.queryJzzblList(page, entity);
	}

	@Override
	public void exportExcel(Jzzblxxb entity,ServletOutputStream outputStream) {
		List<Jzzblxxb> list=jzzblxxbDao.queryJzzblList(entity);

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("居住证");
		sheet.setColumnWidth(1, 5000);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 10000);
		sheet.setColumnWidth(6, 10000);
		sheet.setColumnWidth(7, 10000);
		XSSFRow head = sheet.createRow(0);
		XSSFCell cell = null;

		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

		cell = head.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("序号");

		cell = head.createCell(1);
		cell.setCellValue("身份证号");
		cell.setCellStyle(style);

		cell = head.createCell(2);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);

		cell = head.createCell(3);
		cell.setCellValue("收件人姓名");
		cell.setCellStyle(style);

		cell = head.createCell(4);
		cell.setCellValue("收件人电话");
		cell.setCellStyle(style);

		cell = head.createCell(5);
		cell.setCellValue("收件地址");
		cell.setCellStyle(style);

		cell = head.createCell(6);
		cell.setCellValue("所属派出所");
		cell.setCellStyle(style);
		
		cell = head.createCell(7);
		cell.setCellValue("所属责任区");
		cell.setCellStyle(style);
		for (int i = 0; i < list.size(); i++) {

				XSSFRow rowJcxx = sheet.createRow(i + 1);
				// 序号
				cell = rowJcxx.createCell(0);
				cell.setCellStyle(style);
				cell.setCellValue(i+1);
				// 身份证号
				cell = rowJcxx.createCell(1);
				cell.setCellStyle(style);
				cell.setCellValue(list.get(i).getZjhm());
				// 姓名
				cell = rowJcxx.createCell(2);
				cell.setCellStyle(style);
				cell.setCellValue(list.get(i).getXm());

				// 收件人姓名
				cell = rowJcxx.createCell(3);
				cell.setCellStyle(style);
				cell.setCellValue(list.get(i).getJzz_kdsjr());

				// 收件人电话
				cell = rowJcxx.createCell(4);
				cell.setCellStyle(style);
				cell.setCellValue(list.get(i).getJzz_kdlxdh());

				// 收件地址
				cell = rowJcxx.createCell(5);
				cell.setCellStyle(style);
				cell.setCellValue(list.get(i).getJzz_kddz());

				// 所属派出所
				cell = rowJcxx.createCell(6);
				cell.setCellStyle(style);
				OrgOrganization pcs=this.orgOrganizationService.queryByOrgcode(list.get(i).getBl_pcsdm());
				cell.setCellValue(pcs.getOrgname());

				// 所属责任区
				cell = rowJcxx.createCell(7);
				cell.setCellStyle(style);
				OrgOrganization zrq=this.orgOrganizationService.queryByOrgcode(list.get(i).getBl_zrqdm());
				cell.setCellValue(zrq.getOrgname());
		}
		try {
			wb.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
	}


	@Override
	public Jzzblxxb queryJzzblxxb(String id) {
		return jzzblxxbDao.queryJzzblxxb(id);
	}




	@Override
	public void updateJzzblxxb(Jzzblxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		jzzblxxbDao.updateJzzblxxb(entity);
		
	}
	  /***
     * 
     * @Title: jzzView
     * @Description: TODO(保存打印时候的添加数据)
     * @author wuchunhui
     * @param @param id
     * @param @return    设定文件
     * @return Jzzblxxb    返回类型
     * @throws
     */
	@Override
	 public Jzzblxxb jzzView(String id,SessionBean sessionBean){
		Jzzblxxb entity = null;
		if(!StringUtils.isBlank(id)){
			entity =jzzblxxbDao.queryJzzblxxb(id);
			if(!StringUtils.isBlank(entity.getJzz_yxqdm())&&StringUtils.isBlank(entity.getYxq_jzrq())){
				int yxq =Integer.valueOf(entity.getJzz_yxqdm());
				SimpleDateFormat dateFormatter01 = new SimpleDateFormat(
						"yyyy-MM-dd");
				Date qfrq;
				try {
					qfrq = dateFormatter01.parse(entity.getJzz_qfrq());
					Date jzrq=DateUtils.getNextDate(qfrq, "Y",yxq);
					jzrq=DateUtils.getNextDate(jzrq, "D",-1);
					entity.setYxq_jzrq(dateFormatter01.format(jzrq));
					entity.setJzz_blztdm("2");
					entity.setZzr_id(sessionBean.getUserId());
					entity.setZzr_xm(sessionBean.getUserName());
					setUpdateProperties(entity, sessionBean);
					jzzblxxbDao.updateJzzblxxb(entity);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return entity;
	 }

	public Jzzblxxb checkRyJzz(String ryid){
		Jzzblxxb countJzz = jzzblxxbDao.checkRyJzz(ryid);
		return countJzz;
	}
	
	@Override
	public  List<Jzzblxxb> queryIdsForPrint(Jzzblxxb entity){
		 List<Jzzblxxb> list =jzzblxxbDao.queryIdsForPrint(entity);
		 return list;
	}
	@Override
	public Jzzblxxb queryLastYblJzz(String ryid) {
		return this.jzzblxxbDao.queryLastYblJzzblxxByRyid(ryid);
	}
	
	@Override
	public void noticeLastYblPcs(Jzzblxxb lastYblJzzblxxb, Jzzblxxb beSavedJzzblxxb, SessionBean sessionBean) {
		
		// 根据业务表数据,构造代办消息
		SysMessage message = new SysMessage();
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		
		message.setXxbt("居住证再次办理提醒");//消息标题
		
		String orgName = "";
		if(org.apache.commons.lang.StringUtils.isNotBlank(beSavedJzzblxxb.getBl_zrqmc())){
			orgName = beSavedJzzblxxb.getBl_zrqmc();
		}else if(org.apache.commons.lang.StringUtils.isNotBlank(beSavedJzzblxxb.getBl_pcsmc())){
			orgName = beSavedJzzblxxb.getBl_pcsmc();
		}else{
			orgName = beSavedJzzblxxb.getBl_fjmc();
		}
		
		String sendToOrgCode = "";
		if(org.apache.commons.lang.StringUtils.isNotBlank(lastYblJzzblxxb.getBl_zrqdm())){
			sendToOrgCode = lastYblJzzblxxb.getBl_zrqdm();
		}else if(org.apache.commons.lang.StringUtils.isNotBlank(lastYblJzzblxxb.getBl_pcsdm())){
			sendToOrgCode = lastYblJzzblxxb.getBl_pcsdm();
		}else{
			sendToOrgCode = lastYblJzzblxxb.getBl_fjdm();
		}
		
		message.setXxnr(orgName + "民警【"+beSavedJzzblxxb.getBlr_xm()+"】，于 "+lastYblJzzblxxb.getJzzblrq()+" 申请办理你辖区实有人口"+lastYblJzzblxxb.getXm()+"【"+lastYblJzzblxxb.getZjhm()+"】的居住证");
		message.setXxlb("1");
		
		sysMessageDao.saveMessageByOrg(message, sendToOrgCode, false, false);
		
	}
	
	@Override
	public Jzzblxxb queryJzzblxxbIgnoreXt_zxbz(String id) {
		return this.jzzblxxbDao.queryJzzblxxbIgnoreXt_zxbz(id);
	}
	@Override
	public Jzzblxxb queryJzzblxxbByJzd_dzxzAndSyrkid(String jzd_dzxz, String syrkid) {
		return this.jzzblxxbDao.queryJzzblxxbByJzd_dzxzAndSyrkid(jzd_dzxz, syrkid);
	}

	
}
