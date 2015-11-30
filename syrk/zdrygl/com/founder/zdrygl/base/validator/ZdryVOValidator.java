package com.founder.zdrygl.base.validator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.drools.core.model.HttpRequestBean;
import com.founder.drools.core.model.RuleBean;
import com.founder.framework.base.validator.BaseValidator;
import com.founder.framework.config.SystemConfig;
import com.founder.zdrygl.base.vo.ZdryVO;

@Component
public class ZdryVOValidator extends BaseValidator{
	@Autowired
	private ZdryRuleService zdryRuleService;

	@Override
	public boolean supports(Class<?> paramClass) {		
		return ZdryVO.class.equals(paramClass);
	}

	@Override
	public void validatePre(Object paramObject, Errors paramErrors) {
		
		super.validatePre(paramObject, paramErrors);
	}

	@Override
	public void execute(Object paramObject, Errors paramErrors) {		
		try{
			
			//String ruleService=SystemConfig.getString("RuleService2");
			//HttpRequestBean httpRequestBean = new HttpRequestBean(ruleService);
			RuleBean ruleBean = new RuleBean();
			//ruleBean.setRuleFileName("ZDRY_VALIDATE");
			ruleBean.setRuleName("ZdryVO");
			ruleBean.setParamObj(paramObject);
			
			//Map resMap=httpRequestBean.doHttpPost(ruleBean);			
			Map resMap = zdryRuleService.validateZdryVO(ruleBean);
			Object ruleStatus = resMap.get("ruleStatus");
			Object ruleResponse = resMap.get("ruleResponse");
			if(!"0".equals(ruleStatus.toString())){
				paramErrors.reject("验证失败，失败原因："+ruleResponse.toString());//此错误保存在getGlobalError中				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			paramErrors.reject("验证失败");//此错误保存在getGlobalError中
			paramErrors.rejectValue("zdryZdryzb", e.toString());//	此错误保存在getFieldError()中
		}
		
				
	}

	@Override
	public void afterValidate(Object paramObject, Errors paramErrors) {
		
		super.afterValidate(paramObject, paramErrors);
	}

}
