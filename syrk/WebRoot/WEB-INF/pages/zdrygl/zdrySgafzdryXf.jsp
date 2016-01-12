<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String orglevel = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel = userInfo.getUserOrgLevel();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>涉公安访人员下发</title>
    <script type="text/javascript">
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=orglevel%>";

		$(function(){
			initXiaFaForm();
			initCombobox();
			initOrgUserSelect();
		});

		function initXiaFaForm(){
			$("#xiaFaForm").form({
			    url:basePath+'zdrySgafzdryGl/zdryXiaFa',
			    onSubmit: function(){
			    	if($("#xiaFaForm").form("validate")){
			    		return true;
			    	}else{
			    		return false;
			    	}
			    },
			    success:function(data){
			    	var returnData = jQuery.parseJSON(data);
			    	if(returnData.status == "error"){
			    		$.messager.alert('下发失败',returnData.message);
			    	}else{
			    		executeTabPageMethod($("#tabid").val(), "SgafzdryGl.loadGrid");
			    	}
			    }
			});
		}

		function onOrgUserSelect(orgLevel,inputId,title){
			var orgCode = '';
			var textInputId = 'text_'+inputId;
			//var valueInputId = 'value_'+inputId;
			if(orgLevel == '10'){
				orgCode = $('#orgList11').val();
				if(!orgCode || orgCode == ''){
					alert("请先选择所属市局");
					return;
				}
			}else if(orgLevel == '21'){
				orgCode = $('#orgList21').val();
				if(!orgCode || orgCode == ''){
					alert("请先选择所属分局");
					return;
				}
			}else if(orgLevel == '32'){
				orgCode = $('#orgList22').val();
				if(!orgCode || orgCode == ''){
					alert("请先选择所属派出所");
					return;
				}
			}else {
				orgCode = $('#orgList23').val();
				if(!orgCode || orgCode == ''){
					alert("请先选择所属责任区");
					return;
				}
			}

			public_singleSelectOrgUser(orgCode, null, orgLevel, null      , null         , orgCode, null         , textInputId    , null              , null          , null          , null        , false  , ''      , window      , ''        , title);
		//  public_singleSelectOrgUser(null   , '01', orgLevel, orgBizType, userPositions, orgCode, userIDInputID, userNameInputID, userTableIDInputID, orgCodeInputID, orgNameInputID, orgIDInputID, isCache, windowID, parentWindow, onOkMethod, dialogTitle);
		}

		function initCombobox(){
			orgList11_onChange(); // 二级级联选择例子初始化
			orgList21_onChange(); // 三级级联选择例子初始化
			orgList22_onChange(); // 三级级联选择例子初始化

			if(orglevel=="10"){//市局
				unuseCombobox("orgList11");
				unuseCombobox("orgList22");
				unuseCombobox("orgList23");
			}else if(orglevel=="21"){//分县局
				unuseCombobox("orgList11");
				unuseCombobox("orgList21");
				unuseCombobox("orgList23");
			}else if(orglevel=="32"){//派出所
				unuseCombobox("orgList11");
				unuseCombobox("orgList21");
				unuseCombobox("orgList22");
			}
		}

		function initOrgUserSelect(){
			if(orglevel=="10"){//市局
				unuseOrgUserSelect("sjzrld");
				unuseOrgUserSelect("pcszrld");
				unuseOrgUserSelect("zrqmj");
			}else if(orglevel=="21"){//分县局
				unuseOrgUserSelect("sjzrld");
				unuseOrgUserSelect("fjszrld");
				unuseOrgUserSelect("zrqmj");
			}else if(orglevel=="32"){//派出所
				unuseOrgUserSelect("sjzrld");
				unuseOrgUserSelect("fjszrld");
				unuseOrgUserSelect("pcszrld");
			}
		}

		function unuseOrgUserSelect(inputId){
			//text只读
			setInputReadonly("text_"+inputId, true);
			//选择按钮disable
			$("#userSelect_"+inputId).hide();

		}

		//禁用下拉列表
		function unuseCombobox(boxId){
			setInputReadonly(boxId, true);
			$('#'+ boxId).combobox({required:false,editable:false});
		}

		//市局下拉列表
		function orgList11_onChange(newValue, oldValue) {
			var parentOrgCode = $('#orgList11').combobox('getValue');
			if (parentOrgCode == "") {
				$('#orgList21').combobox('loadData', []);
			}
			else {
				var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21&parentOrgCode=' + parentOrgCode;
			    $('#orgList21').combobox('reload', url);
			}
		}

		//分局下拉列表
		function orgList21_onChange(newValue, oldValue) {
			var parentOrgCode = $('#orgList21').combobox('getValue');
			if (parentOrgCode == "") {
				$('#orgList22').combobox('loadData', []);
				$('#orgList23').combobox('loadData', []);
			}
			else {
				var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;
			    $('#orgList22').combobox('reload', url);
			}
		}

		//派出所下拉列表
		function orgList22_onChange(newValue, oldValue) {
			var parentOrgCode = $('#orgList22').combobox('getValue');
			if (parentOrgCode == "") {
				$('#orgList23').combobox('loadData', []);
			}
			else {
				var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&parentOrgCode=' + parentOrgCode;
			    $('#orgList23').combobox('reload', url);
			}
		}

		function afterSubmit(){
    		executeTabPageMethod($("#tabid").val(), "SgafzdryGl.loadGrid");
		}

	</script>
  </head>

  <body class="easyui-layout" data-options="fit:true">
  	<form action="" id="xiaFaForm" method="post">
  		<input type="hidden" id="tabid" name="tabid" value="${tabid}"/>
  		<input type="hidden" name="id" value="${zdrySgafzdryxxb.id}"/>
  		<table id="xiafaTable" border="0" cellpadding="0" cellspacing="10" width="auto" height="auto" align="center" delayParse="true">
	        <tr class="dialogTr">
		    	<td  class="dialogTd">姓名：</td>
		    	<td class="dialogTd" >
		    		${zdrySgafzdryxxb.xm}
		    	</td>
		    	<td class="dialogTd">身份证：</td>
		    	<td colspan="3" class="dialogTd">
		    		${zdrySgafzdryxxb.gmsfhm}
		    	</td>
	    	</tr>
	    	 <tr class="dialogTr">
		    	<td class="dialogTd">市局：</td>
		    	<td class="dialogTd">
					<input type="text" name="sssj" id="orgList11" value="${zdrySgafzdryxxb.sssj}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=10',required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList11_onChange">
		    	</td>
		    	<td class="dialogTd">市局领导：</td>
		    	<td colspan="3" class="dialogTd">
		    		<input type="text" id="text_sjzrld"  value ="${zdrySgafzdryxxb.sjzrld}" name="sjzrld" class="easyui-validatebox" data-options="required:false" style="width: 200px" />
		    		<%-- <input type="hidden" name="sjzrld" id="value_sjzrld" value ="${zdrySgafzdryxxb.sjzrld}"> --%>
		    		<a id="userSelect_sjzrld" href="#" class="easyui-linkbutton" onclick="onOrgUserSelect('10','sjzrld','市局责任领导')" style="width: 50px;height: 20px">选择</a>  

		    	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
		    	<td class="dialogTd">分市县局：</td>
		    	<td class="dialogTd">
					<input type="text" name="ssfj" id="orgList21" value="${zdrySgafzdryxxb.ssfj}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList21_onChange">
		    	</td>
		    	<td class="dialogTd">分市县局领导：</td>
		    	<td colspan="3" class="dialogTd">
			    	<input type="text" id="text_fjzrld" name="fjzrld" value ="${zdrySgafzdryxxb.fjzrld}" class="easyui-validatebox" data-options="required:false" style="width: 200px" />
		    		<%-- <input type="hidden" name="fjzrld" id="value_fjzrld" value ="${zdrySgafzdryxxb.fjzrld}"> --%>
			     <input type="button" id="userSelect_fjzrld" value="选择" onclick="onOrgUserSelect('21','fjzrld','分县局责任领导')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />

			    </td>
		    </tr>
			<tr class="dialogTr">
		    	<td class="dialogTd">所属派出所：</td>
		    	<td  class="dialogTd">
					<input type="text" name="sspcs" id="orgList22" value="${zdrySgafzdryxxb.sspcs}" class="easyui-combobox" style="width:200px;" 
						data-options="required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList22_onChange">
		    	</td>
		    	<td class="dialogTd">派出所领导：</td>
		    	<td colspan="3" class="dialogTd">
		    		<input type="text" id="text_pcszrld" name="pcszrld" value ="${zdrySgafzdryxxb.pcszrld}" class="easyui-validatebox" data-options="required:false" style="width: 200px" />
		    		<%-- <input type="hidden" name="pcszrld" id="value_pcszrld" value ="${zdrySgafzdryxxb.pcszrld}"> --%>
		    		<input type="button" id="userSelect_pcszrld" value="选择" onclick="onOrgUserSelect('32','pcszrld','派出所责任领导')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />

		    	</td>
		    </tr>
			<tr class="dialogTr">
		    	<td class="dialogTd">所属责任区：</td>
		    	<td  class="dialogTd">
					<input type="text" name="sszrq" id="orgList23" value="${zdrySgafzdryxxb.sszrq}" class="easyui-combobox" style="width:200px;" 
						data-options="required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
		    	</td>
		    	<td class="dialogTd">责任区民警：</td>
		    	<td colspan="3" class="dialogTd">
		    		<input type="text" id="text_zrqmj" name="zrqmj" value ="${zdrySgafzdryxxb.zrqmj}" class="easyui-validatebox" data-options="required:false" style="width: 200px" />
		    		<%-- <input type="hidden" name="zrqmj" id="value_zrqmj" value ="${zdrySgafzdryxxb.zrqmj}"> --%>
		    	    <input type="button" id="userSelect_zrqmj" value="选择" onclick="onOrgUserSelect('50','zrqmj','责任区民警')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
		    	</td>
		    </tr>
         </table>
         <div id="winOrgUser"></div>
  	</form>
  </body>
</html>