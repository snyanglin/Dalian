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
import com.founder.qbld.bean.LkyjzlQsb;
import com.founder.qbld.bean.LkyjzlczFkb;
import com.founder.qbld.bean.Lkyjzlb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.LkyjzlDao;
import com.founder.qbld.service.LkyjzlService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LkyjzlServiceImpl.java]  
 * @ClassName:    [LkyjzlServiceImpl]   
 * @Description:  [临控预警指令服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("lkyjzlService")
@Transactional
public class LkyjzlServiceImpl extends BaseService implements LkyjzlService {
	
	@Resource(name = "lkyjzlDao")
	private LkyjzlDao lkyjzlDao;

	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;
	
	/**
	 * @Title: queryLkyjzlList
	 * @Description: TODO(临控预警指令信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryLkyjzlList(EasyUIPage page, Lkyjzlb entity) {
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
		map.put("lkyjzlb", entity);
		List<?> list = lkyjzlDao.queryLkyjzlList(page, map);
		int count = (int) lkyjzlDao.queryLkyjzlCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	/**
	 * @Title: queryLkyjzl
	 * @Description: TODO(根据id获取临控预警指令详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	@Override
	public Lkyjzlb queryLkyjzl(Lkyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjzlb", entity);
		return lkyjzlDao.queryLkyjzl(map);
	}

	/**
	 * @Title: queryLkyjzlFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警指令反馈表详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	@Override
	public LkyjzlczFkb queryLkyjzlFkb(LkyjzlczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjzlfkb", entity);
		return lkyjzlDao.queryLkyjzlFkb(map);
	}

	/**
	 * @Title: updateCkjqxxb
	 * @Description: TODO(签收：修改临控预警指令表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	@Override
	public int updateLkyjzlb(String qsfkzt, Lkyjzlb entity, SessionBean session) {
		entity.setQsfkzt(qsfkzt);
		//更新临控预警指令表状态等信息
		return lkyjzlDao.updateLkyjzlb(entity);
	}

	/**
	 * @Title: sendQS
	 * @Description: TODO(发送签收数据)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendQS(LkyjzlQsb entity){
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
				QName ope1=new QName("sendTemporaryControlSignMsg");
				Object[] args1=new Object[]{parms};
				Class[] classes1=new Class[]{String.class};
				String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
				if (!"T".equals(statusCode)) {
					//调用程序失败
					entity.setCode(""+statusCode);
					entity.setFszt(QbldUtil.FSCG);
					lkyjzlDao.updateLkyjzlqsb(entity);
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
	public void sendFk(LkyjzlczFkb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<LKZLBH>" + StringUtils.nullToStr(entity.getLkzlbh()) + "</LKZLBH>" +
				"<FKSJ>" + StringUtils.nullToStr(entity.getFksj()) + "</FKSJ>" +
				"<FKRSFZH>" + StringUtils.nullToStr(entity.getFkrsfzh()) + "</FKRSFZH>" +
				"<FKRXM>" + StringUtils.nullToStr(entity.getFkrxm()) + "</FKRXM>" +
				"<FKDW>" + StringUtils.nullToStr(entity.getFkdw()) + "</FKDW>" +
				"<FKDWJGDM>" + StringUtils.nullToStr(entity.getFkdwjgdm()) + "</FKDWJGDM>" +
				"<FXHDXGXX>" + StringUtils.nullToStr(entity.getFxhdxgxx()) + "</FXHDXGXX>" +
				"<MBFXZT>" + StringUtils.nullToStr(entity.getMbfxzt()) + "</MBFXZT>" +
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
				"<LDXXBH>" + StringUtils.nullToStr(entity.getLdxxbh()) + "</LDXXBH>" +
				"<CZFKXXBH>" + StringUtils.nullToStr(entity.getCzfkxxbh()) + "</CZFKXXBH>" +
				"<CZCSXL>" + StringUtils.nullToStr(entity.getCzcsxl()) + "</CZCSXL>" +
				"</ROW>" +
				"</DATAINFO>";
			String url = QbldUtil.WSURL + "/lnga_service/service/IRecvLkzlyjczxxFromJzService";
			try{
				RPCServiceClient client=new RPCServiceClient();
				Options option=client.getOptions();
				option.setTransportInProtocol("SOAP");
				EndpointReference targetRPR=new EndpointReference(url);
				option.setTo(targetRPR);
				QName ope1=new QName("sendTemporaryControlFeedbackMsg");
				Object[] args1=new Object[]{parms};
				Class[] classes1=new Class[]{String.class};
				String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
				if (!"T".equals(statusCode)) {
					//调用程序失败
					entity.setFszt(QbldUtil.FSCG);
					entity.setCode(""+statusCode);
					lkyjzlDao.updateLkyjzlczFkb(entity);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	/**
	 * @Title: saveLkyjzlqs
	 * @Description: TODO(签收：新增临控预警指令签收信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveLkyjzlqs(final LkyjzlQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setQssj(nowStr);
		entity.setQsrxm(session.getUserName());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsdw(session.getUserOrgNameQc());
		entity.setQsdwjgdm(session.getUserOrgCode());
		//插入预警签收表数据
		String result = lkyjzlDao.saveLkyjzlQs(entity);
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
	 * @Title: saveLkyjzlfk
	 * @Description: TODO(反馈：新增临控预警指令反馈信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveLkyjzlfk(final LkyjzlczFkb entity, SessionBean session) {
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
		//map放入seqName、position配置序列取值和返回样式
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqName", "SEQ_YJ");
		map.put("position", "10");
		String seq = ckyjDao.queryYjSeq(map);
		String czfkxxbh = orgcode.substring(0, 6) + yymmdd + seq;
		entity.setCzfkxxbh(czfkxxbh);
		//插入临控预警指令反馈表数据
		String result = lkyjzlDao.saveLkyjzlFk(entity);
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
	 * @Title: queryLkyjzlFkList
	 * @Description: TODO(临控预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryLkyjzlFkList(EasyUIPage page, LkyjzlczFkb entity) {
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
		map.put("lkyjzlczFkb", entity);
		List<?> list = lkyjzlDao.queryLkyjzlFkList(page, map);
		int count = (int) lkyjzlDao.queryLkyjzlFkCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	/**
	 * @Title: lkyjzlb_query_export
	 * @Description: TODO(根据预警编号查询临控预警指令表数据)
	 * @param @param jqid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@Override
	public List<Map<String, String>> lkyjzlb_query_export(Lkyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjzlb", entity);
		List<Map<String, String>> list = lkyjzlDao.lkyjzlb_query_export(map);
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
