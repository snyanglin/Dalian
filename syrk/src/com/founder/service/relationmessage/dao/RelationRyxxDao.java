package com.founder.service.relationmessage.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.service.relationmessage.bean.RelationRyxxResult;
import com.founder.service.relationmessage.bean.RelationRyxxTitle;
import com.founder.service.requestservice.JdcRequestService;
import com.founder.service.requestservice.JdcResult;

@Repository("relationRyxxDao")
public class RelationRyxxDao extends BaseDaoImpl {

	public List<RelationRyxxResult> queryRelationMessage(String sfzh) {
		String querySqlString = "";
		List<RelationRyxxResult> returnList = new ArrayList();
		List<RelationRyxxTitle> list = null;

		JdcRequestService service = new JdcRequestService();
		JdcResult result = service.selectJdc(sfzh);
		if (result != null) {
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("机动车信息");
			List<RelationRyxxTitle> listJdc = new ArrayList();
			RelationRyxxTitle relationRyxxTitle = new RelationRyxxTitle();
			relationRyxxTitle.setId("");
			relationRyxxTitle.setTitle(result.getCLPP1() + "("
					+ result.getHPHM() + ")");
			listJdc.add(relationRyxxTitle);
			entity.setList(listJdc);
			returnList.add(entity);
		}

		String DBUser = "zhzy."; // 综合资源数据库用户名

		querySqlString = "SELECT to_char(TB_XLBH) as ID,(DWMC||DECODE(TO_CHAR(SGRQ,'YYYY-MM-DD'),NULL,'','  '|| TO_CHAR(SGRQ,'YYYY-MM-DD')||'至'||DECODE(TO_CHAR(LGRQ,'YYYY-MM-DD'),NULL,'今',TO_CHAR(LGRQ,'YYYY-MM-DD')))) as TITLE FROM "
				+ DBUser
				+ "ZHK_CYRY WHERE GMSFZHM='"
				+ sfzh
				+ "' and rownum <= 3";
		list = queryForList("relationRyxx.queryRelationRyxxTitle",
				querySqlString);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list
						.get(i);
				relationRyxxTitle
						.setTitle("<a href='http://10.80.5.222:7007/mosty/contextsearch_queryDetail.action?templateID=58985200&PKValue="
								+ relationRyxxTitle.getId()
								+ "' target='_blank'>"
								+ relationRyxxTitle.getTitle() + "</a>");
			}
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("从业经历");
			entity.setList(list);
			returnList.add(entity);
		}

		querySqlString = "SELECT to_char(TB_XLBH) as ID,(GJSCUNIT || GJSCSERVICETYPE) as TITLE FROM "
				+ DBUser
				+ "ZHK_GJJSYXX WHERE GJSCSFZH='"
				+ sfzh
				+ "' and rownum <= 3";
		list = queryForList("relationRyxx.queryRelationRyxxTitle",
				querySqlString);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list
						.get(i);
				relationRyxxTitle
						.setTitle("<a href='http://10.80.5.222:7007/mosty/contextsearch_queryDetail.action?templateID=58983499&PKValue="
								+ relationRyxxTitle.getId()
								+ "' target='_blank'>"
								+ relationRyxxTitle.getTitle() + "</a>");
			}
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("公交车驾驶员");
			entity.setList(list);
			returnList.add(entity);
		}

		querySqlString = "SELECT to_char(TB_XLBH) as ID,('特种作业公司:'||DWMC||'(证号:'||ZSHM||')') as TITLE FROM "
				+ DBUser
				+ "ZHK_TZZYBZQK WHERE SFZH='"
				+ sfzh
				+ "' and rownum <= 3";
		list = queryForList("relationRyxx.queryRelationRyxxTitle",
				querySqlString);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list
						.get(i);
				relationRyxxTitle
						.setTitle("<a href='http://10.80.5.222:7007/mosty/contextsearch_queryDetail.action?templateID=58983428&PKValue="
								+ relationRyxxTitle.getId()
								+ "' target='_blank'>"
								+ relationRyxxTitle.getTitle() + "</a>");
			}
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("特种作业办证情况");
			entity.setList(list);
			returnList.add(entity);
		}

		querySqlString = "SELECT to_char(TB_XLBH) as ID,('平安保单:'||SUBSTR(QTXX,1,7)) as TITLE FROM "
				+ DBUser
				+ "ZHK_PABXXX WHERE SFZ='"
				+ sfzh
				+ "' and rownum <= 3";
		list = queryForList("relationRyxx.queryRelationRyxxTitle",
				querySqlString);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list
						.get(i);
				relationRyxxTitle
						.setTitle("<a href='http://10.80.5.222:7007/mosty/contextsearch_queryDetail.action?templateID=58983312&PKValue="
								+ relationRyxxTitle.getId()
								+ "' target='_blank'>"
								+ relationRyxxTitle.getTitle() + "</a>");
			}
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("平安保险保单");
			entity.setList(list);
			returnList.add(entity);
		}

		querySqlString = "SELECT to_char(TB_XLBH) as ID,('辽渔公司'||SSDW||BMMC||'工作') as TITLE FROM "
				+ DBUser
				+ "ZHK_LYZGXX WHERE SFZH='"
				+ sfzh
				+ "' and rownum <= 3";
		list = queryForList("relationRyxx.queryRelationRyxxTitle",
				querySqlString);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list
						.get(i);
				relationRyxxTitle
						.setTitle("<a href='http://10.80.5.222:7007/mosty/contextsearch_queryDetail.action?templateID=58983312&PKValue="
								+ relationRyxxTitle.getId()
								+ "' target='_blank'>"
								+ relationRyxxTitle.getTitle() + "</a>");
			}
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("辽渔职工");
			entity.setList(list);
			returnList.add(entity);
		}

		querySqlString = "SELECT to_char(TB_XLBH) as ID,('供暖用户') as TITLE FROM "
				+ DBUser + "ZHK_GNYH WHERE SFZH='" + sfzh + "' and rownum <= 3";
		list = queryForList("relationRyxx.queryRelationRyxxTitle",
				querySqlString);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list
						.get(i);
				relationRyxxTitle
						.setTitle("<a href='http://10.80.5.222:7007/mosty/contextsearch_queryDetail.action?templateID=58984232&PKValue="
								+ relationRyxxTitle.getId()
								+ "' target='_blank'>"
								+ relationRyxxTitle.getTitle() + "</a>");
			}
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("供暖用户");
			entity.setList(list);
			returnList.add(entity);
		}
		
		
		list = queryForList("relationRyxx.queryFrfzr", sfzh);
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				RelationRyxxTitle relationRyxxTitle = (RelationRyxxTitle) list.get(i);
				RelationRyxxResult entity = new RelationRyxxResult();
				entity.setTypeName(relationRyxxTitle.getId());
				List<RelationRyxxTitle> listJdc = new ArrayList();
				listJdc.add(relationRyxxTitle);
				entity.setList(listJdc);
				returnList.add(entity);
			}
		}
		
		
		list = queryForList("relationRyxx.queryCyry", sfzh);
		if (list != null && !list.isEmpty()) {
			RelationRyxxResult entity = new RelationRyxxResult();
			entity.setTypeName("从业人员");
			entity.setList(list);
			returnList.add(entity);
		}
		
		return returnList;
	}

}
