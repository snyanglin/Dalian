package com.founder.service.relationmessage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.utils.StringUtils;
import com.founder.service.relationmessage.bean.RelationRyxxResult;
import com.founder.service.relationmessage.dao.RelationRyxxDao;

@Service("relationRyxxService")
@Transactional
public class RelationRyxxServiceImpl implements RelationRyxxService {

	@Resource(name = "relationRyxxDao")
	private RelationRyxxDao relationRyxxDao;

	public List<RelationRyxxResult> queryRelationMessage(String sfzh) {
		List<RelationRyxxResult> list = null;
		if (!StringUtils.isBlank(sfzh)) {
			list = relationRyxxDao.queryRelationMessage(sfzh);
		}
		return list;
	}
}
