package com.founder.zdrygl.base.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.drools.core.request.RuleBean;
import com.founder.framework.base.validator.BaseValidator;
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
					
			RuleBean ruleBean = zdryRuleService.validateZdryVO(paramObject);
		
			if(ruleBean.getResStatus()==1){
				paramErrors.reject("验证失败，失败原因："+ruleBean.getResponse());//此错误保存在getGlobalError中				
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
