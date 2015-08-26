	//重置查询按钮
	function resetButton(){
		$("#queryForm").form("reset");
	}
	
	//查询按钮
	function queryButton(){
		var bt = document.getElementById("bt").value;
		var fkjb = document.getElementById("fkjb").value;
		var begin = document.getElementById("fssj").value;
		var end = document.getElementById("jssj").value;
		var orgcode1 = $("#orgcode1").val();
		var orgcode2 = $("#orgcode2").val();
		var xfdwdm = orgcode1==undefined?orgcode2:orgcode1;
		bt= $.trim(bt);
		begin= $.trim(begin);
		end= $.trim(end);
		fkjb= $.trim(fkjb);
		xfdw= $.trim(xfdwdm);
		var reloadUrl  = basePath + "fkzl/queryZlxfList";
		var opt = $('#rwlb').datagrid('options');
		opt.url = reloadUrl;
		//日期判断
		if($("#fssj").val()!=null && $("#fssj").val()!='' && $("#jssj").val()!=null && $("#jssj").val()!='' && $("#fssj").val() > $("#jssj").val()){
			$.messager.alert("提示", "【结束时间】必须大于等于【开始时间】！");
			return false;
		}
		$("#rwlb").datagrid(
		'load',
		{    
			'bt': bt,   
			'xfsjB':begin,
			'xfsjE': end,
			'fkjb': fkjb,
			'xfdwdm': xfdw
	    });
	}
	
	//内容字体加粗
	function nrStyler(value, rowData, index){
		return "<font style='font-weight:bold;'>"+value+"</font>";
	}
	
	//格式化下发日期
	function formatDate(value, rowData, index){
		return value.substring(0, 10);
	}
	
	//新增下发消息
	function saveButton(){
		$('#dd').dialog({    
		    title: '指令下发',    
		    width: 800,    
		    height: 400,    
		    closed: false,    
		    cache: false,    
		    href: '',    
		    modal: true   
		});    
	}
	
	 //重置下发按钮
	function resetButtons(){
		$("#dataform").form("reset");
	}
	
	//下发按钮
	function sendButton(){
		if($("#dataform").form('validate')){
			topMessager.confirm('操作确认', '您是否发送信息？',  function(r) {
				if (r) {
					$('#dataform').form("submit", {  
			    		url: basePath + "fkzl/saveZlxf",
			    		dataType: "json",
			    		success: function(data){
			    			var json = $.parseJSON(data);
			    			if(json.status != null && json.status == 'success'){
			    				resetButtons();
			    				$("#dd").dialog("close");
			    				queryButton();
			                } else {
			                	$.messager.alert("系统提示", "指令发送失败!");
			                }
			    		}
			    	});
				}
			})
		}
	}
	
	//组织机构查询
	function onOrgUserSelected(userIDInputID) {
		var context = document.getElementById("xfdwdms").value;
		var arr = new Array();
		arr = context.split(",");
		if(arr.length > 199){
			$.messager.alert("系统提示", "选择发送人员不可以超过200人, 请确认！");
			document.getElementById("xfdwdms").value = "";
		}
	}