package com.founder.qbld.service.impl;

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
	
	public YjTjVo queryYjtj(YjTjVo entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjxxb", entity);
		//分别将预警的4个视图进行查询统计，最后将结果皆对应放到一个bean返回 
		YjTjVo cktj = ckyjDao.query_v_qbld_ckyjtj(map);
		YjTjVo ckzltj = ckyjDao.query_v_qbld_ckzlyjtj(map);
		YjTjVo lktj = ckyjDao.query_v_qbld_lkyjtj(map);
		YjTjVo lkzltj = ckyjDao.query_v_qbld_lkyjzltj(map);
		//组装统计数据返回
		YjTjVo yjtj = new YjTjVo();
		if(cktj!=null){
			yjtj.setCkyjDq(cktj.getCkyjDq());
			yjtj.setCkyjDf(cktj.getCkyjDf());
		}
		if(ckzltj!=null){
			yjtj.setYjzlDq(ckzltj.getYjzlDq());
			yjtj.setYjzlDf(ckzltj.getYjzlDf());
		}
		if(lktj!=null){
			yjtj.setLkyjDq(lktj.getLkyjDq());
			yjtj.setLkyjDf(lktj.getLkyjDf());
		}
		if(lkzltj!=null){
			yjtj.setLkyjzlDq(lkzltj.getLkyjzlDq());
			yjtj.setLkyjzlDf(lkzltj.getLkyjzlDf());
		}
		return yjtj;
	}
	
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
		} else {
			// 实有人口没有数据，则查询全国库查询
			String url = "http://10.78.17.238:9999/lbs";
			String urlParameter = "operation=GetPersonInfoByID&content=";
			String content = "{\"data\":[{\"czrkgmsfhm\":\"" + ckyjBean.getSfzh() + "\"}]}";
			JSONObject json = QbldUtil.getService(url, urlParameter, content);
			ckyjBean.setXbdm(this.convertXbdmFromPukangdi(json.getString("czrkxb")));
			ckyjBean.setMzdm(json.getString("czrkmz"));
			ckyjBean.setHjd_dzxz(json.getString("czrkzz"));
			ckyjBean.setJzd_dzxz(json.getString("czrkzz"));
		}
		return ckyjBean;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			String url = "http://10.78.17.238:9999/lbs";
			String zpParameter = "operation=GetPersonPhotoByID&content=";
			String zpContent =  "{\"data\":[{\"rybh\":\""+ entity.getSfzh() +"\"}]}";
			JSONObject jsonZp = QbldUtil.getService(url, zpParameter, zpContent);
			zpString = jsonZp.getString("photo");
			try {
				pictureByte = new BASE64Decoder().decodeBuffer(zpString);
			} catch (Exception ex) {
			}
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(pictureByte.length);
		return new HttpEntity(pictureByte, headers);
	}
	
	@Override
	public CkyjczFkb queryCkyjFkb(CkyjczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjFkxxb", entity);
		return ckyjDao.queryCkyjFkb(entity, map);
	}
	
	@Override
	public List<Map<String, String>> cyryxxb_query_export(Ckyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjxxb", entity);
		List<Map<String, String>> list = ckyjDao.cyryxxb_query_export(map);
		//转义字段
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> maps = list.get(i);
			String qsfkzt = maps.get("QSFKZT");
			if ("1".equals(qsfkzt)) {
				qsfkzt = "已签收";
			} else if("2".equals(qsfkzt)) {
				qsfkzt = "已反馈";
			} else {
				qsfkzt = "未签收";
			}
			maps.put("QSFKZT", qsfkzt);
		}
		return list;
	}

	@Override
	public int updateCkyjxxb(String qsfkzt, Ckyjxxb entity) {
		entity.setQsfkzt(qsfkzt);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setXgsj(now);
		return ckyjDao.updateCkyjxxb(entity);
	}

	@Override
	public String saveCkyjqs(CkyjxxQsb entity, SessionBean session) {
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
		return ckyjDao.saveckyjQs(entity);
	}
	
	@Override
	public String saveCkyjfk(CkyjczFkb entity, SessionBean session) {
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
		return ckyjDao.saveckyjFk(entity);
	}

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

	@Override
	public String updateCkyjczFkb(CkyjczFkb entity) {
		return ckyjDao.updateCkyjczFkb(entity);
	}
	
}
