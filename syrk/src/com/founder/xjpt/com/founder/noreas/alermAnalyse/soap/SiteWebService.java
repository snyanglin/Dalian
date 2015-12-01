package com.founder.xjpt.com.founder.noreas.alermAnalyse.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "WmkjWebService", targetNamespace = "http://www.wmkj.com.cn")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SiteWebService {

	@WebMethod(operationName = "getXLJHXX", action = "")
	@WebResult(name = "return", targetNamespace = "http://www.wmkj.com.cn")
	public String getXLJHXX(
			@WebParam(name = "arg0", targetNamespace = "http://www.wmkj.com.cn") String arg0,
			@WebParam(name = "arg1", targetNamespace = "http://www.wmkj.com.cn") String arg1,
			@WebParam(name = "arg2", targetNamespace = "http://www.wmkj.com.cn") String arg2,
			@WebParam(name = "arg3", targetNamespace = "http://www.wmkj.com.cn") String arg3);


	@WebMethod(operationName = "getXLJHTJ", action = "")
	@WebResult(name = "return", targetNamespace = "http://www.wmkj.com.cn")
	public String getXLJHTJ(
			@WebParam(name = "arg0", targetNamespace = "http://www.wmkj.com.cn") String arg0,
			@WebParam(name = "arg1", targetNamespace = "http://www.wmkj.com.cn") String arg1,
			@WebParam(name = "arg2", targetNamespace = "http://www.wmkj.com.cn") String arg2);

}
