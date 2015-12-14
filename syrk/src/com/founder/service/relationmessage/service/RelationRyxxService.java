package com.founder.service.relationmessage.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.service.relationmessage.bean.RelationRyxxResult;

@TypeAnnotation("人员关联信息")
public interface RelationRyxxService {

	public List<RelationRyxxResult> queryRelationMessage(String sfzh);

}
