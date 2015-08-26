	//重置按钮
    function resetButton(){
    	$("#queryForm").form("reset");
    }

    //列表中格式化，实现签收反馈按钮
	function zlqsfk(val,row,index){
		var url = "/ywxtgzrwb/ywxtgzrwbViews?id="+row["id"];
		var id = row["id"];
		var qsfkzt = row["qsfkzt"];
		var bt = row["bt"];
		var nr = row["nr"];
		var fkjb = row["fkjb"];
		var qsr = row["qsr"];
		var qssj = row["qssj"];
		var qsdwmc = row["qsdwmc"];
		var result = '';
		if(qsfkzt == '1'){
			result = '<div id="dbrwck"><a href="javascript:void(0)" disabled="true" style="color:gray" >待签收</a>'
				+ '&nbsp;<a href="javascript:void(0)" style="color:red" '
				+ 'onclick="fkButton(\''+ id +'\', \'' + bt + '\', \'' + nr + '\', \'' + qsr + '\', \'' + qssj + '\', \'' + qsdwmc + '\', \'' + fkjb + '\')">待反馈</a></div>';
		} else if(qsfkzt == '0'){
			result = '<div id="dbrwck"><a href="javascript:void(0)" style="color:red" '
				+ 'onclick="saveButton(\''+ id +'\', \'' + bt + '\', \'' + nr + '\', \'' + fkjb + '\')">待签收</a>'
				+ '&nbsp;<a href="javascript:void(0)" disabled="true" style="color:gray">待反馈</a></div>';
		}
		return result;
	}
	
    //查询按钮
    function queryButton(){
    	var bt = document.getElementById("bt").value;
    	var fkjb = document.getElementById("fkjb").value;
    	var begin = document.getElementById("fssj").value;
    	var end = document.getElementById("jssj").value;
    	bt= $.trim(bt);
    	fkjb= $.trim(fkjb);
    	begin= $.trim(begin);
    	end= $.trim(end);
    	var reloadUrl  = basePath + "fkzl/queryZlqsfkList";
    	var opt = $('#rwlb').datagrid('options');
    	opt.url = reloadUrl;
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
			'fkjb': fkjb
	    });
    }
    
    //列表表头样式
	function dbrwStyler(value, rowData, index){
		return "<font style='font-weight:bold;'>"+value+"</font>";
	}
	
	//格式化列表日期格式
	function formatDate(value, rowData, index){
		return value.substring(0, 10);
	}
	
	//签收按钮
	function saveButton(id, bt, nr, fkjb){
		//将签收人，签收时间、签收单位等信息赋值，再打开dialog
		$("#qsr").val(username);
		$("#qsdwmc").val(userorg);
		$("#bts").val(bt);
		$("#nrs").val(nr);
		$("#fkjbs").combobox('setValue', fkjb);
		$("#id").val(id);
		$("#qsfkzt").val("1");
		$("#qsdwdm").val(orgcode);
		var date = new Date();
		var y = date.getFullYear();
		var m = date.getMonth()+1+'';
		if(m.length != 2){
			m = '0'+m;
		}
		var d = date.getDate()+'';
		if(d.length != 2){
			d = '0'+d;
		}
		var last = y + "-" + m + "-" + d;
		$("#qssj").val(last);
		$('#dd').dialog({    
		    title: '指令签收',    
		    width: 800,    
		    height: 400,    
		    closed: false,    
		    cache: false,    
		    href: '',    
		    modal: true   
		});    

	}
	
	//反馈按钮
	function fkButton(id, bt, nr, qsr, qssj, qsdwmc, fkjb){
		//将签收人，签收时间、签收单位等信息赋值，再打开dialog
		$("#fkr").val(username);
		$("#qsrss").val(qsr);
		$("#qsdwmcss").val(qsdwmc);
		$("#btss").val(bt);
		$("#nrss").val(nr);
		$("#fkjbss").combobox('setValue', fkjb);
		$("#idss").val(id);
		$("#qsfkztss").val("2");
		$("#fkdwmc").val(userorg);
		$("#fkdwdm").val(orgcode);
		$("#qssjss").val(qssj.substring(0, 10));
		var date = new Date();
		var y = date.getFullYear();
		var m = date.getMonth()+1+'';
		if(m.length != 2){
			m = '0'+m;
		}
		var d = date.getDate()+'';
		if(d.length != 2){
			d = '0'+d;
		}
		var last = y + "-" + m + "-" + d;
		$("#fksj").val(last);
		$('#dds').dialog({    
		    title: '指令反馈',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    href: '',    
		    modal: true   
		});    
	}
	
    //重置反馈
    function resetButtonss(){
		document.getElementById("fkyj").value = '';
    }

    //签收按钮
    function sendButton(){
    	if($("#dataform").form('validate')){
			topMessager.confirm('操作确认', '是否执行签收操作？',  function(r) {
				if (r) {
					$('#dataform').form("submit", {  
			    		url: basePath + "fkzl/updateZlqsfk",
			    		dataType: "json",
			    		success: function(data){
			    			var json = $.parseJSON(data);
			    			if(json.status != null && json.status == 'success'){
			    				$("#dd").dialog("close");
			    				queryButton();
			                } else {
			                	$.messager.alert("系统提示", "签收失败!");
			                }
			    		}
			    	});
				}
			})
		}
    }
    
     //反馈按钮
    function sendButtons(){
    	if($("#dataforms").form('validate')){
			topMessager.confirm('操作确认', '是否执行反馈操作？',  function(r) {
				if (r) {
					$('#dataforms').form("submit", {  
			    		url: basePath + "fkzl/updateZlqsfk",
			    		dataType: "json",
			    		success: function(data){
			    			var json = $.parseJSON(data);
			    			if(json.status != null && json.status == 'success'){
			    				resetButtonss();
			    				$("#dds").dialog("close");
			    				queryButton();
			                } else {
			                	$.messager.alert("系统提示", "反馈失败!");
			                }
			    		}
			    	});
				}
			})
		}
    }
    
    //住址机构多选框
    function onOrgUserSelected(userIDInputID) {
    	var context = document.getElementById("jsr").value;
    	var arr = new Array();
    	arr = context.split(",");
    	if(arr.length > 199){
    		$.messager.alert("系统提示", "选择发送人员不可以超过200人, 请确认！");
    		document.getElementById("jsr").value = "";
    	}
    }