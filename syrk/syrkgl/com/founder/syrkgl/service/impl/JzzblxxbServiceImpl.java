package com.founder.syrkgl.service.impl;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
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




	@Override
	public List<Jzzblxxb> jzzblxxb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String ryid=(String) map.get("ryid");
		List<Jzzblxxb> list = null;
		if(!StringUtils.isBlank(ryid)){
			list= jzzblxxbDao.queryJzzblxxList(ryid);
		}
		return list;
	}




	@Override
	public EasyUIPage queryJzzblList(EasyUIPage page, Jzzblxxb entity) {
		// TODO Auto-generated method stub
		return jzzblxxbDao.queryJzzblList(page, entity);
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
	
	@Override
	public File jzzbl_export(String exportIds, HttpServletResponse response,HttpServletRequest request,SessionBean sessionBean){
		List<Jzzblxxb> jzzbList = jzzblxxbDao.queryJzzblxxbByIds(exportIds);
		List<String> dataList=new ArrayList<String>();
		dataList.add("姓名,性别,民族,出生年月,户籍地址1,户籍地址2,户籍地址3,居住地址1,居住地址2,居住地址3,身份证号码,序号,有效期限");
		//添加性别转换
		Map<String, String> xbdmDictMap=new HashMap<String, String> ();
		Map<String,String> mzdmDictMap=new HashMap<String, String> ();
		try {
			xbdmDictMap = sysDictGlService.getDictMap("GB_D_XBDM");
			mzdmDictMap = sysDictGlService.getDictMap("GB_D_MZDM");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String path =request.getSession().getServletContext().getRealPath("/")+"/temp";
		List<File> srcfileList = new ArrayList<File>();
		//民族转换
		String hjz1="",hjz2="",hjz3="",jzd1="",jzd2="",jzd3="";
		for (Jzzblxxb jzzblxxb : jzzbList) {
			//地址123，每个字符只能有12个（因为打印控件只支持一行12个字符，它不会自己换行。最多支持36个字)截取好输出，做打印的公司是SB,做打印的公司是SB
			String hjd_dzxz =jzzblxxb.getHjd_dzxz();
			String jzd_dzxz =jzzblxxb.getJzd_dzxz();
			if(!StringUtils.isBlank(hjd_dzxz)&&hjd_dzxz.length()>12){
				hjz1=hjd_dzxz.substring(0,11);
				if(hjd_dzxz.length()>24)
				hjz2=hjd_dzxz.substring(12,23);
				else
				hjz2=hjd_dzxz.substring(12,hjd_dzxz.length());	
			}
			if(!StringUtils.isBlank(hjd_dzxz)&&hjd_dzxz.length()>23){
				hjz3=hjd_dzxz.substring(24,hjd_dzxz.length());
			}
			if(!StringUtils.isBlank(jzd_dzxz)&&jzd_dzxz.length()>12){
				jzd1=jzd_dzxz.substring(0,11);
				if(jzd_dzxz.length()>24)
				jzd2=jzd_dzxz.substring(12,23);
				else
				jzd2=jzd_dzxz.substring(12,jzd_dzxz.length());
			}
			if(!StringUtils.isBlank(jzd_dzxz)&&jzd_dzxz.length()>23){
				jzd3=jzd_dzxz.substring(24,jzd_dzxz.length());
			}
			jzzblxxb=jzzView(jzzblxxb.getId(), sessionBean);
			dataList.add(jzzblxxb.getXm()+","+xbdmDictMap.get(jzzblxxb.getXbdm())+","+mzdmDictMap.get(jzzblxxb.getMzdm())+","+jzzblxxb.getCsrq()+","+
					hjz1+","+hjz2+","+hjz3+","+jzd1+","+jzd2+","+jzd3+","+jzzblxxb.getZjhm()+","+jzzblxxb.getDy_bh()+","+jzzblxxb.getYxq_jzrq());
			ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
			zpfjPtryzpglb.setRyid(jzzblxxb.getRyid());
			ZpfjPtryzpxxb zpfjPtryzpxxb =zpfjPtryzpDao.queryPtryzpSingle(zpfjPtryzpglb);
			FileUtils.exportImageFromStream(zpfjPtryzpxxb.getZp(), new File(path+"/"+jzzblxxb.getZjhm()+".jpg"));
			//去掉重复文件名，以免压缩报错
			if(!srcfileList.contains(new File(path+"/"+jzzblxxb.getZjhm()+".jpg"))){
				srcfileList.add(new File(path+"/"+jzzblxxb.getZjhm()+".jpg"));
			}
		}
		//导出的文件保存在本地,后续压缩使用
		FileUtils.exportCsv(new File(path+"/SJ.csv"), dataList);
		srcfileList.add(new File(path+"/SJ.csv"));
		//压缩文件
		FileUtils.zipFiles(srcfileList, new File(path+"/"+"居住证导出.zip"));
		return new File(path+"/"+"居住证导出.zip");
	
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
}
