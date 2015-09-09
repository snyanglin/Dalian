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
import com.founder.qbld.bean.LkyjxxQsb;
import com.founder.qbld.bean.LkyjczFkb;
import com.founder.qbld.bean.Lkyjxxb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.LkyjDao;
import com.founder.qbld.service.LkyjService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LkyjServiceImpl.java]  
 * @ClassName:    [LkyjServiceImpl]   
 * @Description:  [临控预警服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:59:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:59:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("lkyjService")
@Transactional
public class LkyjServiceImpl extends BaseService implements LkyjService {
	
	@Resource(name = "lkyjDao")
	private LkyjDao lkyjDao;

	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;
	
	/**
	 * @Title: queryLkyjList
	 * @Description: TODO(临控预警信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryLkyjList(EasyUIPage page, Lkyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "zlfbsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("lkyjxxb", entity);
		List<?> list = lkyjDao.queryLkyjList(page, map);
		int count = (int) lkyjDao.queryLkyjCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: queryYjzl
	 * @Description: TODO(临控预警详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjxxb    返回类型
	 * @throws
	 */
	@Override
	public Lkyjxxb queryLkyj(Lkyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjxxb", entity);
		return lkyjDao.queryLkyj(map);
	}

	/**
	 * @Title: queryLkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警反馈表详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjczfkb    返回类型
	 * @throws
	 */
	@Override
	public LkyjczFkb queryLkyjFkb(LkyjczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjczfkb", entity);
		return lkyjDao.queryLkyjFkb(map);
	}

	/**
	 * @Title: updateLkyjxxb
	 * @Description: TODO(签收：修改常控预警表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	@Override
	public int updateLkyjxxb(String qsfkzt, Lkyjxxb entity, SessionBean session) {
		entity.setQsfkzt(qsfkzt);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setXgsj(now);
		//更新临控预警表状态等信息
		return lkyjDao.updateLkyjxxb(entity);
	}

	/**
	 * @Title: sendQS
	 * @Description: TODO(发送签收数据)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendQS(LkyjxxQsb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<LDXXBH>" + StringUtils.nullToStr(entity.getLdxxbh()) + "</LDXXBH>" +
				"<LKZLLX>" + StringUtils.nullToStr(entity.getLkzllx()) + "</LKZLLX>" +
				"<LKZLBH>" + StringUtils.nullToStr(entity.getLkzlbh()) + "</LKZLBH>" +
				"<QSSJ>" + StringUtils.nullToStr(entity.getQssj()) + "</QSSJ>" +
				"<QSRSFZH>" + StringUtils.nullToStr(entity.getQsrsfzh()) + "</QSRSFZH>" +
				"<QSRXM>" + StringUtils.nullToStr(entity.getQsrxm()) + "</QSRXM>" +
				"<QSDW>" + StringUtils.nullToStr(entity.getQsdw()) + "</QSDW>" +
				"<QSDWJGDM>" + StringUtils.nullToStr(entity.getQsdwjgdm()) + "</QSDWJGDM>" +
				"</ROW>" +
				"</DATAINFO>";
			String url = QbldUtil.WSURL + "/lnga_service/service/IRecvLkzlyjczxxFromJzService";
			try{
				RPCServiceClient client=new RPCServiceClient();
				Options option=client.getOptions();
				option.setTransportInProtocol("SOAP");
				EndpointReference targetRPR=new EndpointReference(url);
				option.setTo(targetRPR);
				QName ope1=new QName("sendLkyjxxQs");
				Object[] args1=new Object[]{parms};
				Class[] classes1=new Class[]{String.class};
				String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
				if (!"T".equals(statusCode)) {
					//调用程序失败
					entity.setCode(""+statusCode);
					entity.setFszt(QbldUtil.FSCG);
					lkyjDao.updateLkyjqsb(entity);
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
	public void sendFk(LkyjczFkb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<LDXXBH>" + StringUtils.nullToStr(entity.getLdxxbh()) + "</LDXXBH>" +
				"<LKZLLX>" + StringUtils.nullToStr(entity.getLkzllx()) + "</LKZLLX>" +
				"<LKZLBH>" + StringUtils.nullToStr(entity.getLkzlbh()) + "</LKZLBH>" +
				"<FKSJ>" + StringUtils.nullToStr(entity.getFksj()) + "</FKSJ>" +
				"<FKRSFZH>" + StringUtils.nullToStr(entity.getFkrsfzh()) + "</FKRSFZH>" +
				"<FKRXM>" + StringUtils.nullToStr(entity.getFkrxm()) + "</FKRXM>" +
				"<FKDW>" + StringUtils.nullToStr(entity.getFkdw()) + "</FKDW>" +
				"<FKDWJGDM>" + StringUtils.nullToStr(entity.getFkdwjgdm()) + "</FKDWJGDM>" +
				"<MBFXZT>" + StringUtils.nullToStr(entity.getMbfxzt()) + "</MBFXZT>" +
				"<FXMBHDLB>" + StringUtils.nullToStr(entity.getFxmbhdlb()) + "</FXMBHDLB>" +
				"<HDFXSJ>" + StringUtils.nullToStr(entity.getHdfxsj()) + "</HDFXSJ>" +
				"<HDFXDDQH>" + StringUtils.nullToStr(entity.getHdfxddqh()) + "</HDFXDDQH>" +
				"<HDFXDDXZ>" + StringUtils.nullToStr(entity.getHdfxddxz()) + "</HDFXDDXZ>" +
				"<HDFXDDSSSHCS>" + StringUtils.nullToStr(entity.getHdfxddssshcs()) + "</HDFXDDSSSHCS>" +
				"<HDFXDDSSSHCSDM>" + StringUtils.nullToStr(entity.getHdfxddssshcsdm()) + "</HDFXDDSSSHCSDM>" +
				"<FXHDXGXX>" + StringUtils.nullToStr(entity.getFxhdxgxx()) + "</FXHDXGXX>" +
				"<FXMBZRMJSFZH>" + StringUtils.nullToStr(entity.getFxmbzrmjsfzh()) + "</FXMBZRMJSFZH>" +
				"<FXMBZRMJXM>" + StringUtils.nullToStr(entity.getFxmbzrmjxm()) + "</FXMBZRMJXM>" +
				"<FXMBZRDW>" + StringUtils.nullToStr(entity.getFxmbzrdw()) + "</FXMBZRDW>" +
				"<FXMBZRDWJGDM>" + StringUtils.nullToStr(entity.getFxmbzrdwjgdm()) + "</FXMBZRDWJGDM>" +
				"<CQCZCS>" + StringUtils.nullToStr(entity.getCqczcs()) + "</CQCZCS>" +
				"<CZSJ>" + StringUtils.nullToStr(entity.getCzsj()) + "</CZSJ>" +
				"<CZDDQH>" + StringUtils.nullToStr(entity.getCzddqh()) + "</CZDDQH>" +
				"<CZDDXZ>" + StringUtils.nullToStr(entity.getCzddxz()) + "</CZDDXZ>" +
				"<CZZRMJSFZH>" + StringUtils.nullToStr(entity.getCzzrmjsfzh()) + "</CZZRMJSFZH>" +
				"<CZZRMJXM>" + StringUtils.nullToStr(entity.getCzzrmjxm()) + "</CZZRMJXM>" +
				"<CZZRDW>" + StringUtils.nullToStr(entity.getCzzrdw()) + "</CZZRDW>" +
				"<CZZRDWJGDM>" + StringUtils.nullToStr(entity.getCzzrdwjgdm()) + "</CZZRDWJGDM>" +
				"<CZJGMS>" + StringUtils.nullToStr(entity.getCzjgms()) + "</CZJGMS>" +
				"<CZJG>" + StringUtils.nullToStr(entity.getCzjg()) + "</CZJG>" +
				"</ROW>" +
				"</DATAINFO>";
			String url = QbldUtil.WSURL + "/lnga_service/service/IRecvLkzlyjczxxFromJzService";
			try{
				RPCServiceClient client=new RPCServiceClient();
				Options option=client.getOptions();
				option.setTransportInProtocol("SOAP");
				EndpointReference targetRPR=new EndpointReference(url);
				option.setTo(targetRPR);
				QName ope1=new QName("sendLkyjFk");
				Object[] args1=new Object[]{parms};
				Class[] classes1=new Class[]{String.class};
				String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
				if (!"T".equals(statusCode)) {
					//调用程序失败
					entity.setFszt(QbldUtil.FSCG);
					entity.setCode(""+statusCode);
					lkyjDao.updateLkyjczFkb(entity);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	/**
	 * @Title: saveLkyjzlQsb
	 * @Description: TODO(新增常控预警签收信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveLkyjzlQsb(final LkyjxxQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setQssj(nowStr);
		entity.setQsdwjgdm(session.getUserOrgCode());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsrxm(session.getUserName());
		entity.setQsdw(session.getUserOrgNameQc());
		//插入预警签收表数据
		String result = lkyjDao.saveLkyjQs(entity);
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
	 * @Title: saveLkyjzlFkb
	 * @Description: TODO(反馈：新增常控预警反馈信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveLkyjzlFkb(final LkyjczFkb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatShort = new SimpleDateFormat("yyMMdd"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setFksj(nowStr);
		entity.setFkrxm(session.getUserName());
		entity.setFkrsfzh(session.getUserId());
		entity.setFkdwjgdm(session.getUserOrgCode());
		entity.setFkdw(session.getUserOrgNameQc());
		//yjxxbh为组织结构前6位+日期YYMMDD+0000000001序列
		String orgcode = session.getUserOrgCode();
		String yymmdd = formatShort.format(cal.getTime());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqName", "SEQ_YJ");
		map.put("position", "10");
		String seq = ckyjDao.queryYjSeq(map);
		String czfkxxbh = orgcode.substring(0, 6) + yymmdd + seq;
		entity.setCzfkxxbh(czfkxxbh);
		String result = lkyjDao.saveLkyjFk(entity);
		//ws异步发送数据
		new Thread(new Runnable()
	    {
			public void run() {
				sendFk(entity);
	        }
	    }).start();
		return result;
	}
	
	/**
	 * @Title: queryLkyjFkList
	 * @Description: TODO(临控预警反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryLkyjFkList(EasyUIPage page, LkyjczFkb entity) {
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
		map.put("lkyjczfkb", entity);
		List<?> list = lkyjDao.queryLkyjFkList(page, map);
		int count = (int) lkyjDao.queryLkyjFkCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: lkyjxxb_query_export
	 * @Description: TODO(根据预警编号查询临控预警表数据)
	 * @param @param jqid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@Override
	public List<Map<String, String>> lkyjxxb_query_export(Lkyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjxxb", entity);
		List<Map<String, String>> list = lkyjDao.lkyjxxb_query_export(map);
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
