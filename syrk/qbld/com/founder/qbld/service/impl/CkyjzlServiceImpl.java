package com.founder.qbld.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.xml.namespace.QName;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.CkyjzlczFkb;
import com.founder.qbld.bean.CkyjzlQsb;
import com.founder.qbld.bean.Ckyjzlb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.CkyjzlDao;
import com.founder.qbld.service.CkyjzlService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.CkyjzlServiceImpl.java]  
 * @ClassName:    [CkyjzlServiceImpl]   
 * @Description:  [常控预警指令服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ckyjzlService")
@Transactional
public class CkyjzlServiceImpl extends BaseService implements CkyjzlService {
	
	@Resource(name = "ckyjzlDao")
	private CkyjzlDao ckyjzlDao;
	
	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;

	/**
	 * @Title: queryCkyjzlList
	 * @Description: TODO(常控预警指令信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryCkyjzlList(EasyUIPage page, Ckyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "fbsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("ckyjzlb", entity);
		List<?> list = ckyjzlDao.queryCkyjzlList(page, map);
		int count = (int) ckyjzlDao.queryCkyjzlCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	/**
	 * @Title: queryCkyjzl
	 * @Description: TODO(根据id获取常控预警指令详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ckyjzlb    返回类型
	 * @throws
	 */
	@Override
	public Ckyjzlb queryCkyjzl(Ckyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjzlb", entity);
		return ckyjzlDao.queryCkyjzl(map);
	}

	/**
	 * @Title: queryCkyjzlFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询常控预警指令反馈表详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return CkyjzlczFkb    返回类型
	 * @throws
	 */
	@Override
	public CkyjzlczFkb queryCkyjzlFkb(CkyjzlczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjzlfkb", entity);
		return ckyjzlDao.queryCkyjzlFkb(map);
	}

	/**
	 * @Title: updateCkyjzlb
	 * @Description: TODO(修改常控预警指令表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	@Override
	public int updateCkyjzlb(String qsfkzt, Ckyjzlb entity, SessionBean session) {
		entity.setQsfkzt(qsfkzt);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setQssj(now);
		//更新常控预警指令表状态等信息
		return ckyjzlDao.updateCkyjzlb(entity);
	}

	/**
	 * @Title: sendQS
	 * @Description: TODO(发送签收数据)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendQS(CkyjzlQsb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<YJZLBH>" + StringUtils.nullToStr(entity.getYjzlbh()) + "</YJZLBH>" +
				"<QSSJ>" + StringUtils.nullToStr(entity.getQssj()) + "</QSSJ>" +
				"<QSRSFZH>" + StringUtils.nullToStr(entity.getQsrsfzh()) + "</QSRSFZH>" +
				"<QSRXM>" + StringUtils.nullToStr(entity.getQsrxm()) + "</QSRXM>" +
				"<QSDW_MC>" + StringUtils.nullToStr(entity.getQsdw_mc()) + "</QSDW_MC>" +
				"<QSDW_DM>" + StringUtils.nullToStr(entity.getQsdw_dm()) + "</QSDW_DM>" +
				"<SFSBST>" + StringUtils.nullToStr(entity.getQsdw_dm()) + "</SFSBST>" +
				"</ROW>" +
				"</DATAINFO>";
			String url = QbldUtil.WSURL + "/lnga_service/service/IRecvYjzlQsFkFromJZService";
			try{
				RPCServiceClient client=new RPCServiceClient();
				Options option=client.getOptions();
				option.setTransportInProtocol("SOAP");
				EndpointReference targetRPR=new EndpointReference(url);
				option.setTo(targetRPR);
				QName ope1=new QName("sendYjzlControlSignMsg");
				Object[] args1=new Object[]{parms};
				Class[] classes1=new Class[]{String.class};
				String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
				if (!"T".equals(statusCode)) {
					//调用程序失败
					entity.setCode(""+statusCode);
					entity.setFszt(QbldUtil.FSCG);
					ckyjzlDao.updateCkzlyjqsb(entity);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	/**
	 * @Title: sendFk
	 * @Description: TODO(发送反馈记录)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendFk(CkyjzlczFkb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<YJZLBH>" + StringUtils.nullToStr(entity.getYjzlbh()) + "</YJZLBH>" +
				"<FKSJ>" + StringUtils.nullToStr(entity.getFksj()) + "</FKSJ>" +
				"<FKRSFZH>" + StringUtils.nullToStr(entity.getFkrsfzh()) + "</FKRSFZH>" +
				"<FKRXM>" + StringUtils.nullToStr(entity.getFkrxm()) + "</FKRXM>" +
				"<FKDW>" + StringUtils.nullToStr(entity.getFkdw()) + "</FKDW>" +
				"<FKDWJGDM>" + StringUtils.nullToStr(entity.getFkdwjgdm()) + "</FKDWJGDM>" +
				"<DTXXLB>" + StringUtils.nullToStr(entity.getDtxxlb()) + "</DTXXLB>" +
				"<HDFSSJ>" + StringUtils.nullToStr(entity.getHdfssj()) + "</HDFSSJ>" +
				"<HDFSDDQH>" + StringUtils.nullToStr(entity.getHdfsddqh()) + "</HDFSDDQH>" +
				"<HDFSDDXZ>" + StringUtils.nullToStr(entity.getHdfsddxz()) + "</HDFSDDXZ>" +
				"<HDFSDDSSSHCS>" + StringUtils.nullToStr(entity.getHdfsddssshcs()) + "</HDFSDDSSSHCS>" +
				"<HDFSDDSSSHCSDM>" + StringUtils.nullToStr(entity.getHdfsddssshcsdm()) + "</HDFSDDSSSHCSDM>" +
				"<FXHDXGXX>" + StringUtils.nullToStr(entity.getFxhdxgxx()) + "</FXHDXGXX>" +
				"<MBFXZT>" + StringUtils.nullToStr(entity.getMbfxzt()) + "</MBFXZT>" +
				"<FXMBZRMJSFZH>" + StringUtils.nullToStr(entity.getFxmbzrmjsfzh()) + "</FXMBZRMJSFZH>" +
				"<FXMBZRMJXM>" + StringUtils.nullToStr(entity.getFxmbzrmjxm()) + "</FXMBZRMJXM>" +
				"<FXMBZRDW>" + StringUtils.nullToStr(entity.getFxmbzrdw()) + "</FXMBZRDW>" +
				"<FXMBZRDWJGDM>" + StringUtils.nullToStr(entity.getFxmbzrdwjgdm()) + "</FXMBZRDWJGDM>" +
				"<CQCZCS>" + StringUtils.nullToStr(entity.getCqczcs()) + "</CQCZCS>" +
				"<GKCS>" + StringUtils.nullToStr(entity.getGkcs()) + "</GKCS>" +
				"<CZSJ>" + StringUtils.nullToStr(entity.getCzsj()) + "</CZSJ>" +
				"<CZDDQH>" + StringUtils.nullToStr(entity.getCzddqh()) + "</CZDDQH>" +
				"<CZDDXZ>" + StringUtils.nullToStr(entity.getCzddxz()) + "</CZDDXZ>" +
				"<CZZRMJSFZH>" + StringUtils.nullToStr(entity.getCzzrmjsfzh()) + "</CZZRMJSFZH>" +
				"<CZZRMJXM>" + StringUtils.nullToStr(entity.getCzzrmjxm()) + "</CZZRMJXM>" +
				"<CZZRDW>" + StringUtils.nullToStr(entity.getCzzrdw()) + "</CZZRDW>" +
				"<CZZRDWJGDM>" + StringUtils.nullToStr(entity.getCzzrdwjgdm()) + "</CZZRDWJGDM>" +
				"<CZJGMS>" + StringUtils.nullToStr(entity.getCzjgms()) + "</CZJGMS>" +
				"<CZJG>" + StringUtils.nullToStr(entity.getCzjg()) + "</CZJG>" +
				"<SSDQID>" + StringUtils.nullToStr(entity.getSsdqid()) + "</SSDQID>" +
				"<SFSB>" + StringUtils.nullToStr(entity.getSfsb()) + "</SFSB>" +
				"<B_SFSBST>" + StringUtils.nullToStr(entity.getB_sfsbst()) + "</B_SFSBST>" +
				"<B_GKLX>" + StringUtils.nullToStr(entity.getB_gklx()) + "</B_GKLX>" +
				"<B_ZDRYJB>" + StringUtils.nullToStr(entity.getB_zdryjb()) + "</B_ZDRYJB>" +
				"<XDCHNJXX>" + StringUtils.nullToStr(entity.getXdchnjxx()) + "</XDCHNJXX>" +
				"<XCCHWPXX>" + StringUtils.nullToStr(entity.getXcchwpxx()) + "</XCCHWPXX>" +
				"<LXZCGZPG>" + StringUtils.nullToStr(entity.getLxzcgzpg()) + "</LXZCGZPG>" +
				"<LXZCGZPGYJ>" + StringUtils.nullToStr(entity.getLxzcgzpgyj()) + "</LXZCGZPGYJ>" +
				"<MBCSZYLX>" + StringUtils.nullToStr(entity.getMbcszylx()) + "</MBCSZYLX>" +
				"<CZFKBCXX>" + StringUtils.nullToStr(entity.getCzfkbcxx()) + "</CZFKBCXX>" +
				"<ZBXL>" + StringUtils.nullToStr(entity.getZbxl()) + "</ZBXL>" +
				"<JYXL>" + StringUtils.nullToStr(entity.getJyxl()) + "</JYXL>" +
				"<YJCSYY>" + StringUtils.nullToStr(entity.getYjcsyy()) + "</YJCSYY>" +
				"<WZHYY>" + StringUtils.nullToStr(entity.getWzhyy()) + "</WZHYY>" +
				"<XCXXCJ>" + StringUtils.nullToStr(entity.getXcxxcj()) + "</XCXXCJ>" +
				"<TXFS>" + StringUtils.nullToStr(entity.getTxfs()) + "</TXFS>" +
				"<SSWP>" + StringUtils.nullToStr(entity.getSswp()) + "</SSWP>" +
				"<JTGJ>" + StringUtils.nullToStr(entity.getJtgj()) + "</JTGJ>" +
				"<TXRYQK>" + StringUtils.nullToStr(entity.getTxryqk()) + "</TXRYQK>" +
				"<QTYY>" + StringUtils.nullToStr(entity.getQtyy()) + "</QTYY>" +
				"<HDMD>" + StringUtils.nullToStr(entity.getHdmd()) + "</HDMD>" +
				"<TXFS_SF>" + StringUtils.nullToStr(entity.getTxfs_sf()) + "</TXFS_SF>" +
				"<SSWP_SF>" + StringUtils.nullToStr(entity.getSswp_sf()) + "</SSWP_SF>" +
				"<JTGJ_SF>" + StringUtils.nullToStr(entity.getJtgj_sf()) + "</JTGJ_SF>" +
				"<TXRYQK_SF>" + StringUtils.nullToStr(entity.getTxryqk_sf()) + "</TXRYQK_SF>" +
				"</ROW>" +
				"</DATAINFO>";
		String url = QbldUtil.WSURL + "/lnga_service/service/IRecvYjzlQsFkFromJZService";
		try{
			RPCServiceClient client=new RPCServiceClient();
			Options option=client.getOptions();
			option.setTransportInProtocol("SOAP");
			EndpointReference targetRPR=new EndpointReference(url);
			option.setTo(targetRPR);
			QName ope1=new QName("sendYjzlFeedbackMsg");
			Object[] args1=new Object[]{parms};
			Class[] classes1=new Class[]{String.class};
			String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
			if (!"T".equals(statusCode)) {
				//调用程序失败
				entity.setFszt(QbldUtil.FSCG);
				entity.setCode(""+statusCode);
				ckyjzlDao.updateCkyjzlczFkb(entity);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: saveCkyjzlQsb
	 * @Description: TODO(新增常控预警指令签收信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveCkyjzlQsb(final CkyjzlQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setQssj(nowStr);
		entity.setQsrxm(session.getUserName());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsdw_dm(session.getUserOrgCode());
		entity.setQsdw_mc(session.getUserOrgNameQc());
		//插入预警签收表数据
		String result = ckyjzlDao.saveCkyjzlQs(entity);
		//ws异步发送数据
		new Thread(new Runnable()
	    {
			public void run() {
				sendQS(entity);
	        }
	    }).start();
		return result;
		
	}
	
	/**
	 * @Title: saveCkyjzlFkb
	 * @Description: TODO(新增常控预警指令反馈信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveCkyjzlFkb(final CkyjzlczFkb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatShort = new SimpleDateFormat("yyMMdd"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setFksj(nowStr);
		entity.setFkdwjgdm(session.getUserOrgCode());
		entity.setFkdw(session.getUserOrgNameQc());
		entity.setFkrxm(session.getUserName());
		entity.setFkrsfzh(session.getUserId());
		//yjxxbh为组织结构前6位+日期YYMMDD+0000000001序列
		String orgcode = session.getUserOrgCode();
		String yymmdd = formatShort.format(cal.getTime());
		//map放入seqName、position配置序列取值和返回样式
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqName", "SEQ_YJ");
		map.put("position", "10");
		String seq = ckyjDao.queryYjSeq(map);
		String czfkxxbh = orgcode.substring(0, 6) + yymmdd + seq;
		entity.setCzfkxxbh(czfkxxbh);
		//ws异步发送数据
		new Thread(new Runnable()
	    {
			public void run() {
				sendFk(entity);
	        }
	    }).start();
		//插入常控预警指令反馈表数据
		return ckyjzlDao.saveCkyjzlFk(entity);
	}
	
	/**
	 * @Title: updateCkyjxxbAndSaveFkb
	 * @Description: TODO(反馈：修改常控预警指令表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String updateCkyjzlbAndSaveFkb(Ckyjzlb entity, SessionBean session) {
		entity.setQsfkzt("2");
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		//更新常控预警指令表状态等信息
		int id = ckyjzlDao.updateCkyjzlb(entity);
		String restStr = "";
		if(id > 0){
			CkyjzlczFkb fkb = new CkyjzlczFkb();
			fkb.setYjzlbh(entity.getYjzlbh());
			fkb.setFksj(nowStr);
			fkb.setFkrxm(session.getUserName());
			fkb.setFkrsfzh(session.getUserId());
			//插入常控预警指令反馈表数据
			restStr = ckyjzlDao.saveCkyjzlFk(fkb);
		}
		return restStr;
	}
	
	/**
	 * @Title: queryCkyjzlFkList
	 * @Description: TODO(常控预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryCkyjzlFkList(EasyUIPage page, CkyjzlczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "fksj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("ckyjzlczFkb", entity);
		List<?> list = ckyjzlDao.queryCkyjzlFkList(page, map);
		int count = (int) ckyjzlDao.queryCkyjzlFkCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}
	
	/**
	 * @Title: queryCkyjzlFkList
	 * @Description: TODO(常控预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public String updateCkyjzlczFkb(CkyjzlczFkb entity) {
		return ckyjzlDao.updateCkyjzlczFkb(entity);
	}
	
	/**
	 * @Title: ckjqxxb_export
	 * @Description: TODO(根据id查询常控预警指令表数据)
	 * @param @param jqid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@Override
	public List<Map<String, String>> ckyjzlxxb_query_export(Ckyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjzlb", entity);
		List<Map<String, String>> list = ckyjzlDao.ckyjzlb_query_export(map);
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> maps = list.get(i);
			String qsfkzt = maps.get("QSFKZT");
			if (QbldUtil.QS.equals(qsfkzt)) {
				qsfkzt = "已签收";
			} else if(QbldUtil.FK.equals(qsfkzt)) {
				qsfkzt = "已反馈";
			} else {
				qsfkzt = "未签收";
			}
			maps.put("QSFKZT", qsfkzt);
		}
		return list;
	}
	
}
