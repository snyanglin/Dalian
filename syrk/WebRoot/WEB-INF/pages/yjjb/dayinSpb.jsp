<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印奖励审批表</title>
<style>
body{margin:0px;padding:0px;border:0px;text-align:center;}
img{border:0px;}
h1{font-size:28px;border-bottom:#000 6px double;font-family:'黑体'; margin:20px auto;width:499px; text-align:center;display:block;height:38px;}
.wrapper{width:660px;height:auto;overflow:hidden;margin:0 auto;}
.ajbh_Wrap{width:250px; line-height:25px;font-size:12px;float:right;text-align:right;}
.ajTable{width:658px;margin:0 auto; background-color:#000;border-collapse:collapse;}
.ajTable tr{background-color:#ffffff; height:40px;}
.ajTable th{text-align:center; color:#000;font-size:16px; width:170px; border:1px solid #000;}
.ajTable td{text-align:left;text-indent:8px; font-size:16px;  border:1px solid #000;}
.ajTable td.text{width:168px;}
.ajTable td label{font-size:14px;margin:0px 20px;}
.ajTable td.font_14{font-size:14px; line-height:18px;}
.ajTable td.font_12{font-size:12px;line-height:18px;}
.xzfs_check{width:10px;height:10px;border:1px solid #000; display:inline-block; float:left;}
.text1{width:auto; float:left; font-size:14px;}
.jianyao{width:490px; line-height:18px; float:left;text-indent:0px;margin-left:10px;font-size:14px;height:90px; overflow:hidden;}
.chulijieguo{width:490px; line-height:18px; float:left;text-indent:0px;margin-left:10px;font-size:14px;height:35px;overflow:hidden;position:absolute;z-index:100;top:0px;left:0px;}
.gzWrap{width:490px; height:120px; float:left; position:relative ;z-index:9; }
.gzWrap2{width:490px; height:160px; float:left; position:relative ;z-index:9; }
.gzWrap3{width:490px; height:80px; float:left; position:relative ;z-index:9; }
.gzImages{width:160px;height:160px; position:absolute;z-index:99;top:-20px;left:30px;}
.gzImages1{width:160px;height:160px; position:absolute;z-index:99;top:-20px;left:230px;}
.gzText{width:80px; line-height:30px;text-align:center; font-size:16px;position:absolute;z-index:100;top:40px;left:250px;}
.leader_wrap{width:400px; line-height:26px; font-size:16px;position:absolute;z-index:100;top:65px;left:100px; text-align:right;}
.leader_wrap2{width:400px; line-height:26px; font-size:16px;position:absolute;z-index:100;top:105px;left:100px; text-align:right;}
.leader_wrap3{width:400px; line-height:26px; font-size:16px;position:absolute;z-index:100;top:25px;left:100px; text-align:right;}
.signText{width:70px; height:50px;}
</style>
</head>
<body>
<h1>客运出租从业人员协助破案奖励审批表</h1>
<div class="wrapper">
<div class="ajbh_Wrap">
 案件编号：${ajxxb.ajbh }
</div>
<div style="width:660px;height:auto;overflow:hidden;border:#000 1px solid;">
<table cellpadding="0" cellspacing="0" class="ajTable">
 <tr>
   <th >受理时间</th>
   <td class="text">${xsjbxxb.ccsj }</td>
   <th>受理单位（人）</th>
   <td class="text">${xsjbxxb.slfzdm }</td>
 </tr>
 <tr>
   <th>出租从业人员姓名</th>
   <td class="text">${xsjbxxb.jbrxm }</td>
   <th>联系方式</th>
   <td class="font_12 text">${xsjbxxb.jbrmobile }</td>
 </tr>
 <tr>
   <th>客运出租从业人员<br/>工号或出租车牌证</th>
   <td class="text">${xsjbxxb.czzcp }</td>
   <th>客运出租从业人员<br/>单位或住址</th>
   <td class="font_12 text">${xsjbxxb.jbrdw }</td>
 </tr>
 <tr>
   <th>协助方式<br/><span style="font-size:12px;">（选择其一）</span></th>
   <td colspan="3" >
   	<label><c:choose>
   		<c:when test="${jbjlxxb.xzfs == '0'}">■</c:when>
   		<c:otherwise>□</c:otherwise>
   	</c:choose> 提供线索 </label>
   	<label><c:choose>
   		<c:when test="${jbjlxxb.xzfs == '1'}">■</c:when>
   		<c:otherwise>□</c:otherwise>
   	</c:choose> 抓获现行 </label>
   	<label><c:choose>
   		<c:when test="${jbjlxxb.xzfs == '2'}">■</c:when>
   		<c:otherwise>□</c:otherwise>
   	</c:choose> 抓获逃犯 </label>
   	<label><c:choose>
   		<c:when test="${jbjlxxb.xzfs == '3'}">■</c:when>
   		<c:otherwise>□</c:otherwise>
   	</c:choose> 其他 </label>
   </td>
 </tr>
 <tr>
   <th>简要内容</th>
   <td class="font_14" colspan="3" ><div class="jianyao">${jlxxb.bz}</div></td>
 </tr>
 <tr>
   <th>办案单位</th>
   <td class="font_14">${ajxxb.xt_lrrbm }</td>
   <th>办案民警</th>
   <td class="font_14">${ajxxb.xt_lrrxm }</td>
 </tr>
 <tr>
   <th>查证处理结果</th>
   <td class="font_14" colspan="3" >
   <div class="gzWrap">
      <div class="chulijieguo">${jlxxb.slfzcljg}</div>
     <div class="gzImages"><img src="../images/pcsz.gif" width="159" heigh="155"/></div>
     <div class="gzText">（公章）</div>
     <div class="leader_wrap">
                 办案单位领导签字
        <span class="signText"><img src="../images/sign.gif" width="60" height="50"/></span>
       ${jlxxb.slfzspsj }    
     </div>
   </div>
   </td>
 </tr>
 <tr>
   <th>受理站审核<br/><span class="font_12" style="font-weight:normal">（警种、分局）</span></th>
   <td class="font_14" colspan="3" >
   <div class="gzWrap">
     <div class="chulijieguo">${jlxxb.slzcljg }</div>
     <div class="gzImages1"><img src="../images/sjz.gif" width="160" heigh="160"/></div>
      <div class="gzText">（公章）</div>
     <div class="leader_wrap">
                 领导签字
        <span class="signText"><img src="../images/sign.gif" width="60" height="50"/></span>
       ${jlxxb.slfzspsj }    
     </div>
   </div>
   </td>
 </tr>
 <tr>
   <th>受理中心意见</th>
   <td class="font_14" colspan="3" >
   <div class="gzWrap">
      <div class="chulijieguo"></div>
      <div class="leader_wrap">
                 领导签字
        <span class="signText"></span>
       &nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日   
     </div>
   </div>
   </td>
 </tr>
  <tr>
   <th>市局领导批示</th>
   <td class="font_14" colspan="3" >
   <div class="gzWrap2">
      <div class="chulijieguo"></div>
      <div class="leader_wrap2">
                 领导签字
        <span class="signText"></span>
       年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日   
     </div>
   </div>
   </td>
 </tr>
<tr>
   <th>分管财务<br/>领导审核</th>
   <td class="font_14" colspan="3" >
   <div class="gzWrap3">
      <div class="chulijieguo"></div>
      <div class="leader_wrap3">
                 领导签字
        <span class="signText"></span>
                  年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日   
     </div>
   </div>
   </td>
 </tr>
</table>
</div>
</div>	
<script type="text/javascript">

	$('.print-page').jqprint();

</script>

</body>
</html>