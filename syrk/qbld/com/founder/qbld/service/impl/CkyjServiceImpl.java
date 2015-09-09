package com.founder.qbld.service.impl;


import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.CkyjczFkb;
import com.founder.qbld.bean.CkyjxxQsb;
import com.founder.qbld.bean.Ckyjxxb;
import com.founder.qbld.bean.ZdryZp;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.service.CkyjService;
import com.founder.qbld.utils.QbldUtil;
import com.founder.qbld.vo.YjTjVo;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.CkyjServiceImpl.java]  
 * @ClassName:    [CkyjServiceImpl]   
 * @Description:  [常控预警信息实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午9:59:37]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午9:59:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ckyjService")
@Transactional
public class CkyjServiceImpl extends BaseService implements CkyjService {
	
	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;
	
	/**
	 * @Title: queryYjtj
	 * @Description: TODO(返回常控预警、预警指令、临空预警的待签、待返数量)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return YjTjVo    返回类型
	 * @throws
	 */
	public YjTjVo queryYjtj(YjTjVo entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjxxb", entity);
		//分别将预警的4个视图进行查询统计，最后将结果皆对应放到一个bean返回 
		YjTjVo cktj = ckyjDao.query_v_qbld_ckyjtj(map);
		YjTjVo ckzltj = ckyjDao.query_v_qbld_ckzlyjtj(map);
		YjTjVo lktj = ckyjDao.query_v_qbld_lkyjtj(map);
		YjTjVo lkzltj = ckyjDao.query_v_qbld_lkyjzltj(map);
		YjTjVo yjtj = new YjTjVo();
		//组装统计数据返回
		if (cktj != null) {
			yjtj.setCkyjDq(cktj.getCkyjDq());
			yjtj.setCkyjDf(cktj.getCkyjDf());
		}
		if (ckzltj != null) {
			yjtj.setYjzlDq(ckzltj.getYjzlDq());
			yjtj.setYjzlDf(ckzltj.getYjzlDf());
		}
		if (lktj != null) {
			yjtj.setLkyjDq(lktj.getLkyjDq());
			yjtj.setLkyjDf(lktj.getLkyjDf());
		}
		if (lkzltj != null) {
			yjtj.setLkyjzlDq(lkzltj.getLkyjzlDq());
			yjtj.setLkyjzlDf(lkzltj.getLkyjzlDf());
		}
		return yjtj;
	}
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(常控预警信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryCkyjList(EasyUIPage page, Ckyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		// 默认排序
		if (StringUtils.isBlank(sort)) { 
			sort = "yjfbsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("ckyjxxb", entity);
		List<?> list = ckyjDao.queryCkyjList(page, map);
		int count = (int) ckyjDao.queryCkyjCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: convertXbdmFromPukangdi
	 * @Description: TODO(性别数据字典转换)
	 * @param @param xb
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String convertXbdmFromPukangdi(String xb) {
		if (xb.equals("未知的性别")) {
			return "0";
		} else if (xb.equals("男")) {
			return "1";
		} else if (xb.equals("女")) {
			return "2";

		} else if (xb.equals("女性改（变）为男性")) {
			return "3";

		} else if (xb.equals("男性改（变）为女性")) {
			return "4";

		} else {
			return "9";
		}
	}
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(根据id查询常控预警详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ckyjxxb    返回类型
	 * @throws
	 */
	@Override
	public Ckyjxxb queryCkyj(Ckyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjxxb", entity);
		Ckyjxxb ckyjBean = ckyjDao.queryCkyj(entity, map);
		//根据常控预警返回bean中的身份证号查询人员基本信息(实有人口总表最新一条)
		Ckyjxxb syryBean = ckyjDao.queryJbxx(ckyjBean);
		//若实有人口表中有数据，则组装常控信息bean返回前台
		if (syryBean != null) {
			ckyjBean.setMzdm(StringUtils.nullToStr(syryBean.getMzdm()));
			ckyjBean.setXbdm(StringUtils.nullToStr(syryBean.getXbdm()));
			ckyjBean.setJgssxdm(StringUtils.nullToStr(syryBean.getJgssxdm()));
			ckyjBean.setHjd_dzxz(StringUtils.nullToStr(syryBean.getHjd_dzxz()));
			ckyjBean.setJzd_dzxz(StringUtils.nullToStr(syryBean.getJzd_dzxz()));
			ckyjBean.setGxfjdm(StringUtils.nullToStr(syryBean.getGxfjdm()));
			ckyjBean.setGxpcsdm(StringUtils.nullToStr(syryBean.getGxpcsdm()));
			ckyjBean.setGxzrqdm(StringUtils.nullToStr(syryBean.getGxzrqdm()));
			ckyjBean.setZdlgbmmc(StringUtils.nullToStr(syryBean.getZdlgbmmc()));
			ckyjBean.setSjly("人员基本信息总表");
			ckyjBean.setLgdw("列管单位");
		} else {
			// 实有人口没有数据，则查询全国库查询
			String urlParameter = "operation=GetPersonInfoByID&content=";
			String content = "{\"data\":[{\"czrkgmsfhm\":\"" + ckyjBean.getSfzh() + "\"}]}";
			JSONObject json = null;
			try {
				json = QbldUtil.getService(urlParameter, content);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (json != null) {
				ckyjBean.setXbdm(this.convertXbdmFromPukangdi(json.getString("czrkxb")));
				ckyjBean.setMzdm(json.getString("czrkmz"));
				ckyjBean.setHjd_dzxz(json.getString("czrkzz"));
				ckyjBean.setJzd_dzxz(json.getString("czrkzz"));
				ckyjBean.setSjly("全国库");
				ckyjBean.setLgdw("列管单位");
			}
		}
		return ckyjBean;
	}
	
	/**
	 * @Title: queryQbldZpSingle
	 * @Description: TODO(获取全国库信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return HttpEntity<byte[]>    返回类型
	 * @throws
	 */
	@Override
	public HttpEntity<byte[]> queryQbldZpSingle(Ckyjxxb entity) {
		byte[] pictureByte = null;
		String zpString = "";
		//查询photo表
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zp", entity);
		ZdryZp zpBean = ckyjDao.queryZp(map);
		if (zpBean != null) {
			pictureByte = zpBean.getContent();
		} else {
			//调用全国库照片信息
			String zpParameter = "operation=GetPersonPhotoByID&content=";
			String zpContent =  "{\"data\":[{\"rybh\":\""+ entity.getSfzh() +"\"}]}";
			JSONObject jsonZp = QbldUtil.getService(zpParameter, zpContent);
			try {
				zpString = jsonZp.getString("photo");
				pictureByte = new BASE64Decoder().decodeBuffer(zpString);
			} catch (Exception ex) {
			}
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(pictureByte.length);
		return new HttpEntity<byte[]>(pictureByte, headers);
	}
	
	/**
	 * @Title: queryCkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询常控预警反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return CkyjczFkb    返回类型
	 * @throws
	 */
	@Override
	public CkyjczFkb queryCkyjFkb(CkyjczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjFkxxb", entity);
		return ckyjDao.queryCkyjFkb(entity, map);
	}
	
	/**
	 * @Title: cyryxxb_query_export
	 * @Description: TODO(根据id查询常控警情数据用于excle导出)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@Override
	public List<Map<String, String>> cyryxxb_query_export(Ckyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjxxb", entity);
		List<Map<String, String>> list = ckyjDao.cyryxxb_query_export(map);
		//转义字段
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

	/**
	 * @Title: updateCkjqxxb
	 * @Description: TODO(签收：修改常控预警表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	@Override
	public int updateCkyjxxb(String qsfkzt, Ckyjxxb entity) {
		entity.setQsfkzt(qsfkzt);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setXgsj(now);
		return ckyjDao.updateCkyjxxb(entity);
	}

	/**
	 * @Title: sendQS
	 * @Description: TODO(发送签收数据)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendQS(CkyjxxQsb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<LDXXBH>" + StringUtils.nullToStr(entity.getLdxxbh()) + "</LDXXBH>" +
				"<YJXXBH>" + StringUtils.nullToStr(entity.getYjxxbh()) + "</YJXXBH>" +
				"<QSSJ>" + StringUtils.nullToStr(entity.getQssj()) + "</QSSJ>" +
				"<QSRSFZH>" + StringUtils.nullToStr(entity.getQsrsfzh()) + "</QSRSFZH>" +
				"<QSRXM>" + StringUtils.nullToStr(entity.getQsrxm()) + "</QSRXM>" +
				"<QSDW>" + StringUtils.nullToStr(entity.getQsdw()) + "</QSDW>" +
				"<QSDWJGDM>" + StringUtils.nullToStr(entity.getQsdwjgdm()) + "</QSDWJGDM>" +
				"</ROW>" +
				"</DATAINFO>";
			String url = QbldUtil.WSURL + "/lnga_service/service/IRecvYJXXCZJGFromJZService";
			try{
				RPCServiceClient client=new RPCServiceClient();
				Options option=client.getOptions();
				option.setTransportInProtocol("SOAP");
				EndpointReference targetRPR=new EndpointReference(url);
				option.setTo(targetRPR);
				QName ope1=new QName("sendConventionalControlSignMsg");
				Object[] args1=new Object[]{parms};
				Class[] classes1=new Class[]{String.class};
				String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
				if (!"T".equals(statusCode)) {
					//调用程序失败
					entity.setCode(""+statusCode);
					entity.setFszt(QbldUtil.FSCG);
					ckyjDao.updateCkyjqsb(entity);
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
	public void sendFk(CkyjczFkb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<CCFMsg>" + 
				"<DATAINFO>" +
				"<ROW>" +
				"<YJXXBH>" + StringUtils.nullToStr(entity.getYjxxbh()) + "</YJXXBH>" +
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
				"<LDXXBH>" + StringUtils.nullToStr(entity.getLdxxbh()) + "</LDXXBH>" +
				"<CZFKXXBH>" + StringUtils.nullToStr(entity.getCzfkxxbh()) + "</CZFKXXBH>" +
				"<SJYJJB>" + StringUtils.nullToStr(entity.getSjyjjb()) + "</SJYJJB>" +
				"<CZCSXL>" + StringUtils.nullToStr(entity.getCzcsxl()) + "</CZCSXL>" +
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
				"</ROW>" +
				"</DATAINFO>" +
				"</CCFMsg>" ;
		String url = QbldUtil.WSURL + "/lnga_service/service/IRecvYJXXCZJGFromJZService";
		try{
			RPCServiceClient client=new RPCServiceClient();
			Options option=client.getOptions();
			option.setTransportInProtocol("SOAP");
			EndpointReference targetRPR=new EndpointReference(url);
			option.setTo(targetRPR);
			QName ope1=new QName("sendConventionalControlFeedbackMsg");
			Object[] args1=new Object[]{parms};
			Class[] classes1=new Class[]{String.class};
			String statusCode = (String) client.invokeBlocking(ope1,args1,classes1)[0];
			if (!"T".equals(statusCode)) {
				//调用程序失败
				entity.setCode(""+statusCode);
				entity.setFszt(QbldUtil.FSCG);
				ckyjDao.updateCkyjczFkb(entity);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: saveCkyjqs
	 * @Description: TODO(保存常控预警签收表)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveCkyjqs(final CkyjxxQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		String now = formatDate.format(cal.getTime());
		entity.setRksj(now);
		entity.setJkfksj(now);
		entity.setQssj(nowStr);
		entity.setQsrxm(session.getUserName());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsdwjgdm(session.getUserOrgCode());
		entity.setQsdw(session.getUserOrgNameQc());
		String result = ckyjDao.saveckyjQs(entity);
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
	 * @Title: saveCkyjfk
	 * @Description: TODO(保存常控预警信息反馈表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveCkyjfk(final CkyjczFkb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatShort = new SimpleDateFormat("yyMMdd"); 
		Calendar cal = Calendar.getInstance();
		String now = formatStr.format(cal.getTime());
		entity.setFksj(now);
		entity.setFkdwjgdm(session.getUserOrgCode());
		entity.setFkdw(session.getUserOrgNameQc());
		//yjxxbh为组织结构前6位+日期YYMMDD+0000000001序列，序列每日重置
		String orgcode = session.getUserOrgCode();
		String yymmdd = formatShort.format(cal.getTime());
		//map放入seqName、position配置序列取值和返回样式
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqName", "SEQ_YJ");
		map.put("position", "10");
		String seq = ckyjDao.queryYjSeq(map);
		String czfkxxbh = orgcode.substring(0, 6) + yymmdd + seq;
		entity.setCzfkxxbh(czfkxxbh);
		entity.setFkrxm(session.getUserName());
		entity.setFkrsfzh(session.getUserId());
		entity.setFkdwjgdm(orgcode);
		//插入预警反馈表数据
		String result = ckyjDao.saveckyjFk(entity);
		//ws异步发送数据
		new Thread(new Runnable()
	    {
			public void run() {
				sendFk(entity);
	        }
	    }).start();
//		ws 发送数据 end
		return result;
	}

	/**
	 * @Title: queryCkyjFkList
	 * @Description: TODO(常控预警反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryCkyjFkList(EasyUIPage page, CkyjczFkb entity) {
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
		map.put("ckyjczfkb", entity);
		List<?> list = ckyjDao.queryCkyjFkList(page, map);
		int count = (int) ckyjDao.queryCkyjFkCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: updateCkyjczFkb
	 * @Description: TODO(尿检物品修改功能)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String updateCkyjczFkb(CkyjczFkb entity) {
		return ckyjDao.updateCkyjczFkb(entity);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<YJXXBH>" + "1" + "</YJXXBH>" +
				"<FKSJ>" + "2015-01-01" + "</FKSJ>" +
				"<FKRSFZH>" + "1" + "</FKRSFZH>" +
				"<FKRXM>" + "1" + "</FKRXM>" +
				"<FKDW>" + "1" + "</FKDW>" +
				"<FKDWJGDM>" + "1" + "</FKDWJGDM>" +
				"<DTXXLB>" + "1" + "</DTXXLB>" +
				"<HDFSSJ>" + "1" + "</HDFSSJ>" +
				"<HDFSDDQH>" + "1" + "</HDFSDDQH>" +
				"<HDFSDDXZ>" + "1" + "</HDFSDDXZ>" +
				"<HDFSDDSSSHCS>" + "1" + "</HDFSDDSSSHCS>" +
				"<HDFSDDSSSHCSDM>" + "1" + "</HDFSDDSSSHCSDM>" +
				"<FXHDXGXX>" + "1" + "</FXHDXGXX>" +
				"<MBFXZT>" + "1" + "</MBFXZT>" +
				"<FXMBZRMJSFZH>" + "1" + "</FXMBZRMJSFZH>" +
				"<FXMBZRMJXM>" + "1" + "</FXMBZRMJXM>" +
				"<FXMBZRDW>" + "1" + "</FXMBZRDW>" +
				"<FXMBZRDWJGDM>" + "1" + "</FXMBZRDWJGDM>" +
				"<CQCZCS>" + "1" + "</CQCZCS>" +
				"<GKCS>" + "1" + "</GKCS>" +
				"<CZSJ>" + "1" + "</CZSJ>" +
				"<CZDDQH>" + "1" + "</CZDDQH>" +
				"<CZDDXZ>" + "1" + "</CZDDXZ>" +
				"<CZZRMJSFZH>" + "1" + "</CZZRMJSFZH>" +
				"<CZZRMJXM>" + "1" + "</CZZRMJXM>" +
				"<CZZRDW>" + "1" + "</CZZRDW>" +
				"<CZZRDWJGDM>" + "1" + "</CZZRDWJGDM>" +
				"<CZJGMS>" + "1" + "</CZJGMS>" +
				"<CZJG>" + "1" + "</CZJG>" +
				"<SSDQID>" + "1" + "</SSDQID>" +
				"<SFSB>" + "1" + "</SFSB>" +
				"<B_SFSBST>" + "1" + "</B_SFSBST>" +
				"<B_GKLX>" + "1" + "</B_GKLX>" +
				"<B_ZDRYJB>" + "1" + "</B_ZDRYJB>" +
				"<LDXXBH>" + "1" + "</LDXXBH>" +
				"<CZFKXXBH>" + "1" + "</CZFKXXBH>" +
				"<SJYJJB>" + "1" + "</SJYJJB>" +
				"<CZCSXL>" + "1" + "</CZCSXL>" +
				"<XCCHWPXX>" + "1" + "</XCCHWPXX>" +
				"<LXZCGZPG>" + "1" + "</LXZCGZPG>" +
				"<LXZCGZPGYJ>" + "1" + "</LXZCGZPGYJ>" +
				"<MBCSZYLX>" + "1" + "</MBCSZYLX>" +
				"<CZFKBCXX>" + "1" + "</CZFKBCXX>" +
				"<ZBXL>" + "1" + "</ZBXL>" +
				"<JYXL>" + "1" + "</JYXL>" +
				"<YJCSYY>" + "1" + "</YJCSYY>" +
				"<WZHYY>" + "1" + "</WZHYY>" +
				"<XCXXCJ>" + "1" + "</XCXXCJ>" +
				"<TXFS>" + "1" + "</TXFS>" +
				"<SSWP>" + "1" + "</SSWP>" +
				"<JTGJ>" + "1" + "</JTGJ>" +
				"<TXRYQK>" + "1" + "</TXRYQK>" +
				"<QTYY>" + "1" + "</QTYY>" +
				"<HDMD>" + "1" + "</HDMD>" +
				"<TXFS_SF>" + "1" + "</TXFS_SF>" +
				"<SSWP_SF>" + "1" + "</SSWP_SF>" +
				"</ROW>" +
				"</DATAINFO>";
		String url="http://10.78.100.70:8088/wsProject/service/webService";
		try{
			RPCServiceClient client=new RPCServiceClient();
			Options option=client.getOptions();
			option.setTransportInProtocol("SOAP");
			EndpointReference targetRPR=new EndpointReference(url);
			option.setTo(targetRPR);
			QName ope1=new QName("sendConventionalControlMsg ");
			Object[] args1=new Object[]{parms};
			Class[] classes1=new Class[]{String.class};
			System.out.println(client.invokeBlocking(ope1,args1,classes1)[0]);
		}catch(AxisFault a){
			a.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
}
