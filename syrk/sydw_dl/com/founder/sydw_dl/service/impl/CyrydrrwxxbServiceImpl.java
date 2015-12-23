/**********************************************************************   
 * <p>文件名：CyrydrrwxxbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-26 下午3:51:53 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.service.impl;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi3.hssf.usermodel.HSSFCell;
import org.apache.poi3.hssf.usermodel.HSSFDateUtil;
import org.apache.poi3.hssf.usermodel.HSSFWorkbook;
import org.apache.poi3.ss.usermodel.Cell;
import org.apache.poi3.ss.usermodel.Row;
import org.apache.poi3.ss.usermodel.Sheet;
import org.apache.poi3.ss.usermodel.Workbook;
import org.apache.poi3.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.service.requestservice.AddressRequestService;
import com.founder.sydw_dl.bean.Address;
import com.founder.sydw_dl.bean.AddressResultBean;
import com.founder.sydw_dl.bean.Cyrydrrwmxb;
import com.founder.sydw_dl.bean.Cyrydrrwxxb;
import com.founder.sydw_dl.bean.Cyryxxb;
import com.founder.sydw_dl.dao.CyrydrrwxxbDao;
import com.founder.sydw_dl.service.CyrydrrwmxbService;
import com.founder.sydw_dl.service.CyrydrrwxxbService;
import com.founder.sydw_dl.service.CyryxxbService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.service.impl.CyrydrrwxxbService.java]  
 * @ClassName:    [CyrydrrwxxbService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-26 下午3:51:53]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-26 下午3:51:53，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("cyrydrrwxxbService")
@Transactional
public  class CyrydrrwxxbServiceImpl  extends BaseService implements CyrydrrwxxbService {
	@Resource(name = "cyrydrrwxxbDao")
	private  CyrydrrwxxbDao cyrydrrwxxbDao;
	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	@Resource(name = "cyryxxbService")
	private CyryxxbService cyryxxbService;
	@Resource(name = "cyrydrrwmxbService")
	private CyrydrrwmxbService cyrydrrwmxbService;
	@Resource(name = "cyrydrrwxxbService")
	private CyrydrrwxxbService cyrydrrwxxbService;
	@Resource
	private SysMessageDao sysMessageDao;
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	/* (非 Javadoc)
	 * <p>Title: queryById</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 * @see com.founder.sydw_dl.service.CyrydrrwxxbService#queryById(java.util.Map)
	 */
	@Override
	
	public EasyUIPage  queryByDwId(SessionBean sessionBean,String dwid,EasyUIPage page) {
		Map map = new HashMap();
		map.put("lrrid", sessionBean.getUserId());
		map.put("dwid", dwid);
		return cyrydrrwxxbDao.query(page, map);
	}
	
	
	public Cyrydrrwxxb queryByRwid(String rwid){
		return cyrydrrwxxbDao.queryByRwid(rwid);
	}

	/* (非 Javadoc)
	 * <p>Title: saveEntity</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.founder.sydw_dl.service.CyrydrrwxxbService#saveEntity(com.founder.sydw_dl.bean.Cyrydrrwxxb)
	 */
	@Override
	public void saveEntity(Cyrydrrwxxb entity,SessionBean sessionBean) {
		entity.setId(UUID.create());
		//entity.setRwmc(new Date().getTime());
		entity.setDrrbmdm(sessionBean.getUserManageOrgCode());
		entity.setDrrmc(sessionBean.getUserManageOrgName());
		entity.setRwzt("0");
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setDrsj(entity.getXt_lrsj());
		//保存任务
		cyrydrrwxxbDao.saveEntity(entity);
	}
	
	@Override
	public void updateEntity(Cyrydrrwxxb entity,SessionBean sessionBean){
		
		BaseService.setSaveProperties(entity, sessionBean);
		//保存任务
		cyrydrrwxxbDao.updateEntity(entity);
		
	}
	
	public void importToCyry(InputStream in,SessionBean sessionBean,String rwid,String fileType){
		try{
			//创建excel
			Workbook exc=null;
			Sheet sheet=null;
			Row row =null;
			if(fileType.equals(".xls")){
				  exc = new HSSFWorkbook(in);
				 sheet = exc.getSheetAt(0);
			}else{
				 exc = new XSSFWorkbook(in);
				 sheet = exc.getSheetAt(0);
			}
		
			//取得字典遍历，把key变成中文方便后面转换
			Map dictMapOld = sysDictGlService.getDictMap("D_BZ_XB");
			Map dictMap = new HashMap();
			Iterator iterator = dictMapOld.keySet().iterator();
			
			while(iterator.hasNext()){
				String key = (String)iterator.next();
				dictMap.put(dictMapOld.get(key), key);
			}
			//遍历所有行
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Cyrydrrwmxb cyrydrrwmxb = new Cyrydrrwmxb();//任务明细反馈明细表
				Cyryxxb cyryxxb = new Cyryxxb();//从业人员信息表保存
				String mxmx="";
				//去掉表头第1行
				if(i==0) continue;
				//取得内容进行处理
				row=sheet.getRow(i);
				//列为固定格式所以不用循环
				String sfz = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(0));
				String xm = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(1));
				String xb = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(2));
				String csrq = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(3));
				String jzdz = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(4));
				String lxdh = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(5));
				String gzbm = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(6));
				String gz = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(7));
				String jgssj = CyrydrrwxxbServiceImpl.getCellValue(row.getCell(8));
				//信息复用到任务反馈明细表
				cyrydrrwmxb.setDrrwid(rwid);
				cyrydrrwmxb.setXm(xm);
				cyrydrrwmxb.setLxdh(lxdh);
				cyrydrrwmxb.setZjhm(sfz);
				cyrydrrwmxb.setPysj(jgssj);
				cyrydrrwmxb.setZy(gz);
				cyrydrrwmxb.setSzbmmc(gzbm);
				cyrydrrwmxb.setDrjg("0");
				cyrydrrwmxb.setSfzt("0");
				try{
				DateUtils.stringToDate(csrq, "yyyy-dd-MM");
				cyrydrrwmxb.setCsrq(csrq);
				}catch (Exception e) {
					cyrydrrwmxb.setCsrq("");
					mxmx+="[日期格式错误]";
					cyrydrrwmxb.setDrjg("2");
				}
				if(dictMap.get(xb)!=null){
				cyrydrrwmxb.setXbdm(String.valueOf(dictMap.get(xb)));
				}
				else{
					cyrydrrwmxb.setXbdm("9");//未说明性别
				}
				// 身份证复用信息
				RyRyjbxxb ryjbxxb =ryRyjbxxbService.queryByCyzjdmZjhm(sfz, "111");// 111为身份证类型
				if (ryjbxxb == null) {// 全国库查询不到人口,不存库
					mxmx+="[人员验证失败,全国库查询不到人口]";
					
				} else {
					String zdrylbdm = "";
					cyrydrrwmxb.setRyid(ryjbxxb.getId());
					if(zdrylbdm.indexOf("0109")==-1){//检查是否为在逃人员
						if(xm.replaceAll("\\s*", "").equals(ryjbxxb.getXm())){//匹配姓名
							BeanUtils.copyObjectSameProperties(ryjbxxb, cyryxxb);
							// 地址匹配
							AddressResultBean addressResultBean = AddressRequestService
									.getAddressIdByGeocode(jzdz);
							if (addressResultBean!=null&&addressResultBean.getSuccess()) {//地址复用是否成功
								java.util.List<Address> addArray = addressResultBean
										.getContent();
								if(addArray.size()!=0){//是否取到对于的标准地址
								Address address = addArray.get(0);
								cyryxxb.setDz_xzzdm(address.getId());
								//Bzdzxxb bzdzxxb=bzdzService.queryById(address.getId());【已经换新的标准地址zhang_guoliang 20150506注释】
								//BeanUtils.copyObjectSameProperties(bzdzxxb, cyryxxb);
								cyrydrrwmxb.setDrjg("1");//完全正确结果保存为1
								cyrydrrwmxb.setDz_xzzxz(address.getAddress());
								}
								else{
									mxmx+="[居住地址匹配失败]";
									cyrydrrwmxb.setDrjg("2");
									cyryxxb.setDz_xzzxz(jzdz);
								}
							
								
							}
							Cyrydrrwxxb cyrydrrwxxb=cyrydrrwxxbService.queryByRwid(rwid);
							BeanUtils.copyObjectSameProperties(cyrydrrwxxb, cyryxxb);//添加单位信息到从业人员表
							cyryxxbService.add(cyryxxb, sessionBean);//保存从业人员
							cyrydrrwmxb.setDrjg("2");
							mxmx="[导入成功]";
							cyrydrrwmxb.setCyrwid(cyryxxb.getId());
							
						}else{
							mxmx+="[人员姓名有误]";
						}
					}
					else{
						mxmx+="[在逃人员]";
						cyrydrrwmxb.setSfzt("1");
					}
				}
				
				cyrydrrwmxb.setMxms(mxmx);
				cyrydrrwmxbService.saveEntity(cyrydrrwmxb, sessionBean);
				
			}
			//上传完毕更改任务状态
			Cyrydrrwxxb cyrydrrwxxb = queryByRwid(rwid);
			cyrydrrwxxb.setRwzt("1");
			updateEntity(cyrydrrwxxb, sessionBean);
			/*
			 * message添加
			 */
			SysMessage message = new SysMessage();
			message.setXxnr("您上传的批量导入已经解析完成，请您查看！");
			message.setXxlb("5");
			message.setYwurl("/cyrydrrwmxb_dl/createPage?rwid="+cyrydrrwxxb.getId());
			message.setFsr(sessionBean.getUserName());
			message.setFsrdm(sessionBean.getUserId());
			message.setFsrssdw(sessionBean.getUserOrgName());
			message.setFsrssdwdm(sessionBean.getUserOrgCode());
			message.setFssj(DateUtils.getSystemDateTimeString());
			message.setXxbt("从业人员批量导入结果");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	//判断从Excel文件中解析出来数据的格式  
    @SuppressWarnings("unused")
	private static String getCellValue(Cell cell){  
        String value = "";  
       
        //简单的查检列类型  
        switch(cell.getCellType())  
        {  
            case HSSFCell.CELL_TYPE_STRING://字符串  
              value = cell.getRichStringCellValue().getString();  
               break;  
            case HSSFCell.CELL_TYPE_NUMERIC://数字  
            	 if(HSSFDateUtil.isCellDateFormatted(cell)){
                 	Date date = cell.getDateCellValue();
                 	value= DateUtils.getFullString(date);
                 }else{
                	 long dd = (long)cell.getNumericCellValue();  
                	 DecimalFormat df= new DecimalFormat("0");
                	 value = df.format(cell.getNumericCellValue());
                 }
                break;  
            case HSSFCell.CELL_TYPE_BLANK:  
                value = "";  
                break;     
            case HSSFCell.CELL_TYPE_FORMULA:  
                value = String.valueOf(cell.getCellFormula());  
                break;  
            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值  
                value = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_ERROR:  
                value = String.valueOf(cell.getErrorCellValue());  
                break;  
            default:  
                break;  
        }  
        return value;  
    }  
    
    

}
