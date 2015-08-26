<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [jhyxswDetail.jsp]   
 * @Description:  [集会游行示威详情显示页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 
  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
  样式未对齐
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>文书详情</title>
  	<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
	  <style>
	  @media print{
	  .noprint{display:none;color:green}
	  }
	  table.all{
	  font-size:16px;
	  
	  }
	  table.all td{
	  font-size:16px;
	  }
	  
	  .mainTable td{
	  	border:black 1px solid;
	  }
	  </style>
 	 <script type="text/javascript">
		//打印
		$('#printButton').click(function(){
			window.print();
		});

	</script>
  	</head>  
  <body>
   <table class="font" width="100%" border="0" cellpadding="2" cellspacing="0">
		 <tr>
		  <td width="100%">
		  <div align="center" style="width: 100%;padding: 15px 0 15px 0"><span style="font-size: 26px">集会游行示威申请登记表</span></div>
			<table style="border:black 2px solid;" class="mainTable" cellpadding="0" cellspacing="0" align="center" class="all">
		  <tr style="text-align:center; font-size:20px">
		    <td colspan="2" height="40" >递交申请时间</td>
		    <td colspan="3" align="left" style="padding-left: 10px">${entity.sqsj}</td>
			<td colspan="2">活动方式</td>
			<td colspan="4" align="left" style="padding-left: 10px"><script type="text/javascript">document.write(getDictName(basePath + 'common/dict/D_AQFF_HDFS.js', "${entity.hdfsdm}"));</script></td>
			</tr>
		  <tr style="text-align:center">
		    <td rowspan="4" width="30px"><p>申</p>
		    <p>请</p>
		    <p>人</p>
		    <p>基</p>
		    <p>本</p>
		    <p>情</p>
		    <p>况</p></td>
		    <td width="60px" height="60">姓名</td>
		    <td width="100px" align="left" style="padding-left: 10px">${entity.xm}</td>
		    <td width="60px"><p>性</p><p>别</p></td>
		    <td width="85px" align="left" style="padding-left: 10px"><script type="text/javascript">document.write(getDictName(basePath + 'common/dict/D_BZ_XB.js', "${entity.xbdm}"));</script></td>
		    <td width="60px"><p>年</p><p>龄</p></td>
		    <td width="85px" align="left" style="padding-left: 10px">${entity.nl}</td>
		    <td width="60px" ><p>民</p><p>族</p></td>
		    <td width="85px" align="left" style="padding-left: 10px"><script type="text/javascript">document.write(getDictName(basePath + 'common/dict/GB_D_MZDM.js', "${entity.mzdm}"));</script></td>
		    <td width="60px"><p>职</p><p>业</p></td>
		    <td width="85px" align="left" style="padding-left: 10px">${entity.zy}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td height="49">工作单位</td>
		    <td colspan="9" align="left" style="padding-left: 10px">${entity.gzdw}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td height="53">家庭住址</td>
		    <td colspan="9" align="left" style="padding-left: 10px">${entity.dz_jzdzxz}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td height="53">联系电话</td>
		    <td align="left" style="padding-left: 10px">${entity.lxdh}</td>
		    <td colspan="3">身份证号码</td>
		    <td colspan="5" align="left" style="padding-left: 10px">${entity.gmsfhm}</td>
		  </tr>
		  <tr align=“left” valign="top">
		    <td height="100" colspan="11" align=“left” valign="top" style="padding-top: 5px">&nbsp;目的:${entity.md}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="2" height="42">参加人数</td>
		    <td colspan="2" align="left" style="padding-left: 10px">${entity.cjrs}</td>
		    <td colspan="3">维持秩序人数</td>
		    <td colspan="4" align="left" style="padding-left: 10px">${entity.wczxrs}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="2" height="43">起止时间</td>
		    <td colspan="9" align="left" style="padding-left: 10px">${entity.kssj}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${entity.jssj}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="2" height="48">使用音响</td>
		    <td colspan="9" align="left" style="padding-left: 10px">${entity.syyx}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="2" height="46">使用车辆</td>
		    <td colspan="9" align="left" style="padding-left: 10px">${entity.sycl}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="2" height="47">集合地</td>
		    <td colspan="2" align="left" style="padding-left: 10px">${entity.jhd}</td>
		    <td colspan="2">解散地</td>
		    <td colspan="5" align="left" style="padding-left: 10px">${entity.jsd}</td>
		  </tr>
		  <tr>
		    <td height="100" colspan="11" align=“left” valign="top" style="padding-top: 5px">&nbsp;游行、示威路线:${entity.yxswlx}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="3" height="60">集会、示威场所</td>
		    <td colspan="8" align="left" style="padding-left: 10px">${entity.jhswcs}</td>
		  </tr>
		  <tr>
		    <td height="100" colspan="11" align=“left” valign="top" style="padding-top: 5px">&nbsp;使用标语、口号内容: ${entity.bykh}</td>
		  </tr>
		  <tr style="text-align:center">
		    <td colspan="2" height="100" >备&nbsp;注</td>
		    <td colspan="9"  align="left" style="padding-left: 10px">${entity.bz}</td>
		  </tr>
		</table>
		<table width="76%" height="47" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>填表人：${entity.xt_lrrxm}</td>
				<td align="right">填表时间 ${entity.xt_cjsj}</td>
			</tr>
			<tr>
				<td  class="noprint" align="right" colspan="2">
					<a id="printButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">文书打印</span>
						<span class="l-btn-icon icon-save"> </span>
					</span>
					</a>
				</td>
			</tr>
		</table>
		</td>
		</tr>
	</table>
 </body>
</html>
