<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 上午8:51:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-4 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位编辑</title>
<script type="text/javascript" src="<%=contextPath%>/js/sydwinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/sydw/sydwEdit.css"></link>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydwEdit.js"></script>
</head>
<body class="bodybg">
	<div class="head">
		<div class="logo"></div>
	</div>
	<div class="bodydiv">
		<div class="bodyer">
			<div class="lf">
				<!--框-->
				<div class="lf_conta">
					<div class="lf_contb">
						<div class="lf_contc">
							<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
								<tr>
									<td colspan="2" align="center" style="border-bottom:dashed 1px #e2e2e2;">
										<strong><span id="dwmc_dw">${dw.dwmc }</span><span></span>
										</strong>
									</td>
								</tr>
								<tr>
									<td style="vertical-align: top;">
									<div class="pinfo1" style="margin:0; width:500px;">
										<ul><li style="padding:0px;">
											<table border='0' cellpadding="0" cellspacing="0" class="nameTable">
												<tr>
									    	        <th align="right" width="110">单位名称：</th>
											    	<td width="150">${dw.dwmc}</td>
										    	  	<th align="right" width="110">单位编码：</th>
											    	<td width="110"> ${dw.zagldwbm}</td>
										    	 </tr>
												 <tr>
									    	        <th align="right" width="110">单位类型：</th>
											    	<td width="150"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_DWLXDM.js', "${dw.dwlbdm}"));</script></td>
										    	  	<th align="right" width="110">联系电话：</th>
											    	<td width="80"> ${dw.lxdh}</td>
										    	 </tr>
										    	 <tr >
									    	        <th align="right" width="110">单位地址：</th>
									    	         <c:choose>
									    	            <c:when test="${dw.dz_dwdzxz !=null}">
									    	                 <td  colspan="3">${dw.dz_dwdzxz }</td>	
									    	            </c:when>
									    	            <c:otherwise>
									    	                 <td  colspan="3" >${dw.dzms_dwdzmlpxz}${dw.dzms_chdz}</td>	
									    	            </c:otherwise>
									    	         </c:choose>
										    	 </tr>
										    	 <tr>
									    	        <th  align="right" width="110">单位状态：</th>
											    	<td><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_DW_DWZTDM.js', "${dw.dwztdm}"));</script></td>
										    	  	<th  align="right" width="110">开业日期：</th>
											    	<td>${dw.kyrq}</td>
										    	 </tr>
										    	 <tr>
									    	        <th  align="right" width="110">经营面积(平方米)：</th>
											    	<td>${dw.jymj_mjpfm}</td>
										    	  	<th  align="right"  width="110">营业时间：</th>
											    	<td>${dw.yysj}</td>
										    	 </tr>
										    	 <tr >
									    	        <th  align="right" width="110">经营范围（主营）：</th>
											    	<td>${dw.jyfwzy }</td>
											    	<th  align="right"  width="110">核定容纳人数：</th>
											    	<td>${dw.hdrnrs}</td>
										    	  </tr>
										    	 <tr >
									    	        <th  align="right" width="110">经营范围（兼营）：</th>
											    	<td  colspan="3" >${dw.jyfwjy }</td>
										    	 </tr>
										    	 <tr >
										    	  	<th  align="right" width="110">是否重点单位：</th>
											    	<td><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.zddwbs}"));</script></td>
											    	<th  align="right" width="110">是否办理营业执照：</th>
											    	<td><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfblyyzzdm}"));</script></td>
										      	 </tr>
									    	  	 <tr>
									    	        <th  align="right" width="110">是否外资单位：</th>
											    	<td  class=""><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfwzdwdm}"));</script></td>
										    	    <th   align="right" width="110">是否涉外单位：</th>
											    	<td ><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfswdwdm}"));</script></td>
									    	  	 </tr>
<!-- 									    	  	 <tr> -->
<!-- 									    	        <th  align="left" colspan="2">是否安装治安管理信息系统：<script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfazzaglxxxt}"));</script></td> -->
<!-- 										    	    <th   align="left" colspan="2">是否经消防安全验收合格：<script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfyxfjddm}"));</script></td> -->
<!-- 									    	  	 </tr> -->
									    	  	 <tr>
									    	  	 	<th  align="right" width="110">管理类型：</th>
									    	  	 	<td><span style="color:red;">治安</span><span id="jfywlx" style="color:red;display: none;">&nbsp;技防</span><span id="hbywlx" style="color:red;display: none;">&nbsp;环保</span><span id="xfywlx" style="color:red;display: none;">&nbsp;消防</span><span id="baywlx" style="color:red;display: none;">&nbsp;保安</span></td>
								    	  	 		<th align="right" width="110">组织机构：</th>
											    	<td width="110"> ${dw.zzjgmc}</td>
									    	  	 </tr>
											 </table>
										</li></ul> 														
									</div>
									</td>
									<td style="vertical-align: top;">
										<div class="pphoto_1" style="margin:0;">
											<div>
												<img  id="topPhotoid" width="210" style="border:solid 2px #e2e2e2;" height="260" alt="" />
											</div>
											<c:if test="${mode != 'view'}">
											    <a href="javascript:void(0);" info="dwid,DW_DWJBXXB,单位基本信息表" class="addphoto"></a>
											</c:if>
										</div>
									</td>
								</tr>
							</table>
												
							<input type="hidden" id="dwlbdm2"  value="${dw.dwlbdm}"/>
							<input type="hidden" id="formPara" value='"dwmc":"${dw.dwmc}","dwlbdm":"${dw.dwlbdm}"' /><!-- 表单提交附加参数 json-->
							<input type="hidden" id="serverPara" value="dwid=${dw.id }&dwmc=${dw.dwmc}&dwlbdm=${dw.dwlbdm}" /><!-- 业务办理附加参数-->
							<input type="hidden" id="queryPara" value="dwid=${dw.id }" /><!-- 表单查询附加参数 -->
							<input type="hidden" id="mode_"	 value="${mode}" />
							<input type="hidden" id="partview_"	 value="${partview}" />
							<div class="clear"></div>
							<div class="editdiv">
								<a href="javascript:void(0);" class="savebtn">档案编辑完成</a>
								<a href="javascript:void(0);" class="editbtn" style="display:none">编辑档案信息</a>
							</div>
						</div>
					</div>
				</div>
				<!--/框-->
				
				<!--基础信息-->
				<div class="lf_conta cont_edit">
					<div class="lf_contb">
						<div class="lf_contc">
							<dl class="infodl">
								<dt>
									<div class="dllf info_jbxx">基本信息补充</div>
									<a class="up_btn down_btn" href="javascript:void(0);"></a>
									<a class="info_editbtn" href="javascript:void(0);">编辑</a>
									<a class="info_savebtn" href="javascript:void(0);">保存</a>
								</dt>
								<dd class="infoshow">
									<ul>
										<li>
											<input type="hidden" name="id" id="dwid" value="${dw.id }" />
											<input type='hidden' name='openUrl' value='/dwjbxxb/create' />
										</li>
									</ul>
									<table border="0" class="jbxxTable">
										<tr>
											<th align="right" width="110">单位别名：</th>
											<td width="550" colspan="5">${dw.dwbm}</td>
										</tr>
										<tr>
											<th align="right" width="110">单位英文名称：</th>
											<td width="110">${dw.dwywmc}</td>
											<th align="right" width="110">单位英文缩写：</th>
											<td width="110">${dw.dwywsx}</td>
										</tr>
										<tr>
											<th align="right" width="110">行业类别：</th>
											<td width="110"><span name="hylbdm" dict="/common/dict/D_DW_HYLB" class="edit_word">${dw.hylbdm}</span></td>
											<th align="right" width="110">营业执照号：</th>
											<td width="110">${dw.yyzzh}</td>
											<th align="right" width="110">营业执照发证机关：</th>
											<td width="110">${dw.yyzzfzjg}</td>
										</tr>
										<tr>
											<th align="right" width="110">营业执照起始日期：</th>
											<td width="110">${dw.yyzzyxq_qsrq}</td>
											<th align="right" width="110">营业执照截止日期：</th>
											<td width="110">${dw.yyzzyxq_jzrq}</td>
											<th align="right" width="110">注册资本：</th>
											<td width="110">${dw.zczb}</td>
										</tr>
										<tr>
											<th align="right" width="110">税务登记证号：</th>
											<td width="110">${dw.swdjhm}</td>
											<th align="right" width="110">经营方式：</th>
											<td width="110"><span name="jyfsdm" dict="/common/dict/D_DW_JYFSDM" class="edit_word">${dw.jyfsdm}</span></td>
											<th align="right" width="110">经营性质：</th>
											<td width="110"><span name="jjlxdm" dict="/common/dict/D_BZ_JYXZDM" class="edit_word">${dw.jjlxdm}</span></td>
										</tr>
										<tr>
											<th align="right" width="110">是否周期性营业：</th>
											<td width="110"><span name="sfzqxyydm" dict="/common/dict/D_GG_SF" class="edit_word">${dw.sfzqxyydm}</span></td>
											<th align="right" width="110">周期性营业规律：</th>
											<td width="110">${dw.zqxyygl}</td>
											<th align="right" width="110">停业日期：</th>
											<td width="110">${dw.tyrq01}</td>
										</tr>
										<tr>
											<th align="right" width="110">传真号码：</th>
											<td width="110">${dw.czhm}</td>
											<th align="right" width="110">网址：</th>
											<td width="330" colspan="3">${dw.wz}</td>
										</tr>
										<tr>
											<th align="right" width="110">备注：</th>
											<td width="550" colspan="5">${dw.bz}</td>
										</tr>
									</table>
									<div class="clear"></div>
								</dd>
							</dl>
						</div>
					</div>
				</div>
				<!--/基础信息-->
			</div>
			<div class="rt" style="display:none;">
				<!--右侧框-->
				<div class="rt_conta">
					<div class="rt_contb">
						<div class="rt_contc">
							<div class="rt_server">
								<div class="rttitle" id="server_Menu">业务办理</div>
								<ul class="rtul" id="serverMenu"></ul>
								<c:if test="${jqdtjl!=null && fn:length(jqdtjl)!=0 }">
									<div class="rttitle" >近期动态</div>
									<div class="rtshow">
										<div class="timelinebody">
											<div class="timeliall">
												<c:forEach var="dwjqdtjlb" items="${jqdtjl}">
													<div class="timelicont">
														<div class="timelidiv">
															<a class="timetitle">${dwjqdtjlb.jlsm}</a>
															<div class="jqsjmsinfo" style="display: none;">
																<div>
																	<span></span>
																</div>
															</div>
															<div class="timedate">
																<span>${dwjqdtjlb.jlsj}</span>
															</div>
															<div class="timeicon"></div>
															<div class="timesjx"></div>
														</div>
													</div>
												</c:forEach>
											</div>
										</div>
										<div class="clear"></div>
									</div>
								</c:if>
							</div>
							<div class="rt_view">
								<div class="rttitle" >可增加信息</div>
								<ul class="rtul" id="serverAddInfo"></ul>
							</div>
						</div>
					</div>
				</div>
				<!--/右侧框-->
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    	<input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
	<iframe name="submitFrame" id="submitFrame" src="" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" width="0" height="0" style="z_index: 60; display:none;"></iframe>
</body>
<script type="text/javascript">
var pcsdm = "${pcsdm}";
var pcsmc = "${pcsmc}";
var fsxdm = "${fsxdm}";
var fsxmc = "${fsxmc}";
var dsjdm = "${dsjdm}";
var dsjmc = "${dsjmc}";
var dwid="${dw.id}";
var dwlbdm="${dw.dwlbdm}";
var infoPara = {
		mainUrl:"/sydwgl/queryDwzsxx",
		mainPara:"sydwlx="+$("#dwlbdm2").val(),		
		queryUrl:"/sydwgl/service/",
		queryPara:$("#queryPara").val(), //dwid 单位ID		
		serverMenuUrl:"/sydwgl/queryYwglgn",
		serverMenuPara:"sydwlx="+$("#dwlbdm2").val(), //实有单位类型		
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",		
		editPara:"dwid="+$("#dwid").val(), //编辑参数
		editIframePara:'{'+$("#formPara").val()+'}', 		
		serverPara:$("#serverPara").val(),  //业务办理参数        id 单位ID， dwmc 单位名称
		serverIframePara:'{'+$("#formPara").val()+'}',		
		add_childInfo_para: $("#serverPara").val(),
		add_childInfo_iframePara:'{'+$("#formPara").val()+'}',		
		edit_childInfo_para:$("#serverPara").val(),
		edit_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		del_childInfo:"/sydwgl/delete_xxzsnrb"
	};
</script>
</html>
    