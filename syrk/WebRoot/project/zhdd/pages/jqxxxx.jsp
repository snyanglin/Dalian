<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}" />
<title>警情详细信息</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
</head>
<body>
	
	<div class="tips_ct_cz">
		<%-- 框内容 --%>
		<div class="tips_show_1">
			<dl class="tips_showdl">
				<dt><span>报警</span></dt>
				<dd>
 					<label>人员：<input id="jqxxxx_bjrxm" class="inputtext" type="text" style="width:53px"  readOnly="true"/></label>
					<label>电话：<input id="jqxxxx_bjdh" class="inputtext" type="text" style="width:77px" readOnly="true"/></label>
					<label>时间：<input id="jqxxxx_bjsj" class="inputtext" type="text" style="width:112px" readOnly="true"/></label>
				</dd>
			</dl>
			<dl class="tips_showdl" >
				<dt><span>接警</span></dt>
				<dd>
 					<label>人员：<input id="jqxxxx_jjrxm" class="inputtext" type="text" style="width:53px" readOnly="true"/></label>
					<!-- <label>&nbsp;台服：<input id="jqxxxx_jjtfh" class="inputtext" type="text" style="width:77px" /></label> -->
					<label>时间：<input id="jqxxxx_jjsj" class="inputtext" type="text" style="width:112px" readOnly="true"/></label>
					<label>方式：<input id="jqxxxx_bjfsmc" class="inputtext" type="text" style="width:77px" readOnly="true"/></label>
				</dd>
			</dl>
			<dl class="tips_showdl">
				<dt><span>警情</span></dt>
				<dd><div>
					<label>类别：
	        			<input type="text" id="jqxxxx_jqssdldm" name="jqssdldm" class="inputtext" style="width: 80px;" readOnly="true"/>
	          		</label>
	          		<label>
	        			<input type="text" id="jqxxxx_jqsszldm" name="jqssdldm" class="inputtext" style="width: 120px;" readOnly="true"/>
	          		</label>
	          		<label>
	        			<input type="text" id="jqxxxx_jqssxldm" name="jqssdldm" class="inputtext" style="width: 103px;" readOnly="true"/>
	          		</label>
					<br /> 
					</div>
					<!-- <label><span class="redcolor">*</span>地址：<textarea id="jqxxxx_jqafdd" class="jqxxxx_jqafdd"></textarea></label> -->
					<label>地址：<input type="text" id="jqxxxx_jqafdd" class="inputtext" style=" width:340px;" readOnly="true" /></label><br/>
					<label>信息：<textarea id="jqxxxx_jqxx" style=" width:336px;" readOnly="true"></textarea></label><br /> 
					<div>
					<label>
						<div class="tips_check">
							<input type="checkbox" id="jqxxxx_ywty" disabled="disabled"/><a href="javascript:void(0);" >逃逸</a>
							<input type="checkbox" id="jqxxxx_sfsjtsgdsr" disabled="disabled"/><a href="javascript:void(0);" >事故当事人</a>
							<input type="checkbox" id="jqxxxx_ywrysw" disabled="disabled"/><a href="javascript:void(0);">人员伤亡</a>
							<input type="checkbox" id="jqxxxx_sfswhcl" disabled="disabled"/><a href="javascript:void(0);" >危化车辆</a>
						</div>
					</label><br /> 
			
					</div>		
				</dd>
			</dl>
			<dl class="tips_showdl">
				<dd>
					<label class="tips_lx">
					<div class="lf"><span>类型：</span>
						<input type="text" id="jqxxxx_jqlxdm" name="jqlxdm" class="inputtext" style="width: 135px;" readOnly="true"/>
					</div>	
					</label>
				</dd>
			</dl>
			<dl class="tips_showdl" style="padding:0;">
				<dd>
				</dd>
			</dl>
			<div class="clear"></div>
		</div>
	</div>
	<%--/弹出框--%>
</body>
</html>