if(typeof ZdryAdd == "undefined" || !ZdryAdd){
	var ZdryAdd = {};
};
ZdryAdd = function(){
	this.pk = Math.random();
};

/**
 * @title: subjzddzxz
 * @description:居住地址截取
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 15:08:32
 */	
ZdryAdd.subjzddzxz = function(val, row, index){
  	var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',row.jzd_xzqhdm);
	return val.replace(xzqhmc, "");
};

/**
 * @title:onClickRow
 * @description:点击列表时间
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:06:43
 */
ZdryAdd.onClickRow = function(rowIndex,rowData){
	
};


//保存按钮
function saveForm(bottonObject){
	var formObject = $("#dataFormZdry");	
	if (formObject.form('validate')) {
		if($("#xm").val()=="" || $("#zjdm").val()==""){
			topMessager.alert("","请查询并选择实有人口");
			return false;
		}		
		if(confirm("您是否要保存当前的数据？")){
			//防止重复提交		
			if (buttonDisabled(bottonObject) == false) {
				return false;
			}
			
			$("#dataFormZdry").form("submit",{
				url:document.dataFormZdry.action,
				dataType : "json",
				onSubmit: function() {},
				success: function(result) {
					buttonEnabled(bottonObject);//可再提交
					result = parseReturn(result);
					if (result.status == "success") { // 返回成功后执行的方法
						alert("列管成功，请填写实有人口的体貌特征、体表特殊标记");
						closeWindow();
					}
					else {
						topMessager.alert(MESSAGER_TITLE, result.message, "error");
					}
				}
			});		
		}
				
	}else{
		return false;
	}
		
}