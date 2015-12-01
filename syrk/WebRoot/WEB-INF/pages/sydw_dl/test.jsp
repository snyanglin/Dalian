<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>实有单位测试</title>
</head>
<body>  
	<br>

    <input type="button" id="btn1" value="从业人员" onclick="cyryxxb()" />
    <input type="button" id="btn1" value="法人\负责人\联络员" onclick="dwfrfzrllyxxb()" />

  	<br><br/>
  	<input type="button" id="btn1" value="剧毒化学品资质信息" onclick="infoOpen('/jdhxpzzxxb/edit?id=&dwid=000000','剧毒化学品资质信息',{dwmc:'单位名称'})" />

  	<input type="button" id="btn2" value="金融单位" onclick="infoOpen('/jrdwxxb/edit?id=140e59a78b754d24b9e3ccbce58be6d3&dwid=000000','金融单位信息',{dwmc:'单位名称'})"/> 
  	<input type="button" id="btn3" value="旧货收购信息" onclick="infoOpen('/jhsgxxb/edit?id=a3f7617c1c0545e38872235556c795c2&dwid=000000','旧货收购信息',{dwmc:'单位名称'})"/>
  <br/><br/>

 	<input type="button" id="btn1" value="机动车修理信息" onclick="infoOpen('/jdcxlxxb/edit?id=&dwid=000000','机动车修理信息',{dwmc:'单位名称'})" />
 	 <br/><br/>

   <input type="button" id="btn1" value="重要部位" onclick="dwzybw()" /><br/><br/>
   <input type="button" id="btn1" value="单位检查" onclick="dwjc()" /><br/><br/>
   <br/><br/>
   <input type="button" id="btn1" value="办事处或分公司" onclick="bsc()" /><br/><br/>
   <input type="button" id="btn1" value="银行分理处" onclick="flc()" />
   <br>
  	<input type="button" id="btn1" value="文化单位" onclick="infoOpen('/whdwxxb/edit?id=cddbfb522def4e93bf8fc4db19fc7b0a','文化单位',{dwmc:'单位名称',dwid:'869087eb72634dfea4251c3d1dfe6c72'})" />
  	<input type="button" id="btn1" value="单位基站" onclick="infoOpen('/dwjzxxb/edit?id=94022bdd233c4f09b56a59b9ba2e7ff8','单位基站',{dwmc:'单位名称',dwid:'869087eb72634dfea4251c3d1dfe6c72'})" />
  	<input type="button" id="btn1" value="营业设备" onclick="infoOpen('/yyssxxb/edit?id=ccdbd80a691f43339e732c8ef0c488a9','营业设备',{dwmc:'单位名称',dwid:'869087eb72634dfea4251c3d1dfe6c72'})" />
  	<input type="button" id="btn1" value="银行ATM机" onclick="infoOpen('/yhatmjxxb/edit?id=af1f02c00eec42dfaffc8ab79b140be8','银行ATM机',{dwmc:'单位名称',dwid:'869087eb72634dfea4251c3d1dfe6c72'})" />
  	<input type="button" id="btn1" value="单位仓储" onclick="infoOpen('/dwccxxb/edit?id=ac10cb8d32434544a91cd1b4d011926a','单位仓储',{dwmc:'单位名称',dwid:'869087eb72634dfea4251c3d1dfe6c72'})" />
  	<input type="button" id="btn1" value="单位处罚" onclick="infoOpen('/dwcfxxb/edit?id=01edc989c5e945a4be89bfba74f698261','单位处罚',{dwmc:'单位名称',dwid:'869087eb72634dfea4251c3d1dfe6c72'})"" />
  	<br>
  	<input type="button" id="btnLdxxbAdd" value="添加旅馆信息" onclick="infoOpen('/ldxxb/addLdxxb','旅馆信息',{dwmc:'旅馆信息',dwid:'000000'})" />
  	<input type="button" id="btnLdxxbSave" value="修改旅馆信息" onclick="infoOpen('/ldxxb/addLdxxb?id=3f41b28552144231943ef01f579c4ab8','旅馆信息',{dwmc:'旅馆信息',dwid:'000000'})" />
  	<br>
  	<input type="button" id="btnDdxxbAdd" value="添加典当业信息" onclick="infoOpen('/ddxxb_dl/addDdxxb','典当业信息',{dwmc:'典当业信息',dwid:'000000'})" />
  	<input type="button" id="btnDdxxbSave" value="修改典当业信息" onclick="infoOpen('/ddxxb_dl/addDdxxb?id=932fc100dede4af2a827094eeb36bbc2','典当业信息',{dwmc:'典当业信息',dwid:'000000'})" />
	<br>
	<input type="button" id="btnCzfwzbSave" value="出租房屋信息" onclick="infoOpen('/czfwzb/addCzfwzb?fwid=1407116980217&fwdzid=1846096','出租房屋信息',{fwmc:'测试房屋',fwid:'1A0E6A9344C247F495873AE99E0DA1B6'})"/>
</body>

<script type="text/javascript">
function infoOpen(editUrl,title,paramArray){
	var editUrl = contextPath + editUrl;
   	openWindowWithSave(false, null,this.Window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height:600
   		}, 
   		null, null
   	);
}
//从业人员
function cyryxxb(){ 
	var editUrl = contextPath + '/cyryxxb/createPage?id=c72ffa28274d446696e85a1986336a52&dwid=aaa&dwmc=单位名称';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	
	var paramArray = [];
	paramArray["dwid"] = "";//单位ID
	paramArray["dwmc"] = "";//单位名称
	
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '从业人员',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存？', null
   	);
}
function dwzybw(){
	var title="单位重要部位信息";
	var paramArray =null;
	var editUrl = contextPath + "/forward/sydw|dwzybwxxbAdd";
   	openWindowWithSave(false, null,this.Window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height:600
   		}, 
   		null, null
   	);
}
function dwjc(){
	var title="单位检查信息";
	var paramArray =null;
	var editUrl = contextPath + "/forward/sydw|dwjcAdd";
   	openWindowWithSave(false, null,this.Window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height:600
   		}, 
   		null, null
   	);
}
   	function dwcf(){
   		var title="单位处罚信息";
   		var paramArray =null;
   		var editUrl = contextPath + "/forward/sydw|dwcfAdd";
   	   	openWindowWithSave(false, null,this.Window, 
   	   		paramArray, 
   	   		{
   	   		title: title,
   	   		url: editUrl,
   	   		maximizable: false,
   	   		width: 850,
   	   		height:600
   	   		}, 
   	   		null, null
   	   	);
   	}
   	
   	function bsc(){
   		var title="办事处或分公司";
   		var paramArray =null;
   		var editUrl = contextPath + "/forward/sydw|dwbschfgsAdd";
   	   	openWindowWithSave(false, null,this.Window, 
   	   		paramArray, 
   	   		{
   	   		title: title,
   	   		url: editUrl,
   	   		maximizable: false,
   	   		width: 850,
   	   		height:600
   	   		}, 
   	   		null, null
   	   	);
   		
   	}
	function flc(){
   		var title="银行分理处";
   		var paramArray =null;
   		var editUrl = contextPath + "/forward/sydw|dwyhflcAdd";
   	   	openWindowWithSave(false, null,this.Window, 
   	   		paramArray, 
   	   		{
   	   		title: title,
   	   		url: editUrl,
   	   		maximizable: false,
   	   		width: 850,
   	   		height:600
   	   		}, 
   	   		null, null
   	   	);
   		
   	}
	//法人\负责人\联络员ID
	function dwfrfzrllyxxb(){ 
		var editUrl = contextPath + '/dwfrfzrllyxxb/createPage?id=cbae74514b4649dea678ab079d93d3a0&dwid=aaa&dwmc=单位名称';
		var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		
		var paramArray = [];
		paramArray["dwid"] = "";//单位ID
		paramArray["dwmc"] = "";//单位名称
		
	   	openWindowWithSave(false, null, this.Window, 
	   		paramArray, 
	   		{
	   		title: '法人\负责人\联络员ID',
	   		url: editUrl,
	   		maximizable: false,
	   		width: 850,
	   		height: 620
	   		}, 
	   		'您是否要保存？', null
	   	);
	}
</script>
</html>