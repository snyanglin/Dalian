
var zdryid="";
var zdryZjhm="";  
$(document).ready(function(){
	 zdryid=$("#zdryid").val();
	 zdryZjhm=$("#zdry_zjhm").val();  
});

//以下是写实基本信息js方法
function xsjbxxAdd() {
	var url=contextPath+'/dtjsMore/addDtjsXsjbxx?zdryZjhm='+zdryZjhm;
	window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
			{title: '写实基本信息新增',url: url,width: 880,inline:true,height:500}, 
		   		null, "xsjbxxquery",null
		   	);
	
	
};

function xsjbxxquery(){
	$('#xsjbxx').datagrid('load',{    
		
	});
};

function xsjbxxFormater(val,row,index){
	 var html="";
	 if(row.gxdwdm==userOrgCode && getPageEditAble()){
		 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="xsjbxxedit(this, '+index+')">编辑</a>&nbsp;'
		 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="xsjbxxDelete(this, '+index+')">删除</a>&nbsp;'	 
	 }else {		 
		 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="xsjbxxview(this, '+index+')">查看</a>&nbsp;'
	 }	
	return html ;
};

function xsjbxxedit(linkObject, index){

	cancelBubble();
	var rows = $('#xsjbxx').datagrid('getData');
	var rowData = rows.rows[index];
	var url=contextPath+'/dtjsMore/editDtjsXsjbxx?id='+rowData.id +"&type=edit";
	window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
			{title: '写实基本信息编辑',url: url,width: 880,inline:true,height:500}, 
		   		null, "xsjbxxquery",null
		   	);
	
};
function xsjbxxview(linkObject, index){

	cancelBubble();
	var rows = $('#xsjbxx').datagrid('getData');
	var rowData = rows.rows[index];
	var url=contextPath+'/dtjsMore/editDtjsXsjbxx?id='+rowData.id +"&type=view";

	openWindow(false,null,url,null,{title:'写实基本信息查看',width:880,height:500});

	
};

function xsjbxxDelete(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dtjsMore/deleteDtjsXsjbxx';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:rowData.id}
			}).done(function(result) {
				query();
			});
		}
	})
};
	//以下是维稳信息js方法
	function swxxFormater(val,row,index){
		 var html="";
		 if(row.xt_lrrbmid==userOrgCode  && getPageEditAble()){
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="swxxedit(this, '+index+')">编辑</a>&nbsp;'
			 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="swxxDelete(this, '+index+')">删除</a>&nbsp;'	 
		 }else{		 
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="swxxview(this, '+index+')">查看</a>&nbsp;'
		 }	
		return html ;
	}
	function swxxAdd() {

		var url=contextPath+'/dtjsMore/addDtjsSwxx?zdryZjhm='+zdryZjhm+'&zdryid='+zdryid;
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '维稳信息新增',url: url,width: 880,inline:true,height:500}, 
			   		null, "swxxquery",null);
		
		
	}

	function swxxedit(linkObject, index){

		cancelBubble();
		var rows = $('#swxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsSwxx?id='+rowData.id +"&type=edit";
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '维稳信息编辑',url: url,width: 880,inline:true,height:500}, 
			   		null, "swxxquery",null
			   	);
		
	}
	function swxxview(linkObject, index){

		cancelBubble();
		var rows = $('#swxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsSwxx?id='+rowData.id +"&type=view";

		openWindow(false,null,url,null,{title:'维稳信息查看',width:880,height:500});

		
	}

	function swxxDelete(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/dtjsMore/deleteDtjsSwxx';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {id:rowData.id}
				}).done(function(result) {
					swxxquery();
				});
			}
		});
	}
	function swxxquery(){
		$('#swxxtable').datagrid('load',{    
			
		});
	}
//===============以下是上访信息js方法
	function sfxxFormater(val,row,index){
		 var html="";
		 if(row.xt_lrrbmid==userOrgCode && getPageEditAble()){
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="sfxxedit(this, '+index+')">编辑</a>&nbsp;'
			 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="sfxxDelete(this, '+index+')">删除</a>&nbsp;'	 
		 }else{		 
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="sfxxview(this, '+index+')">查看</a>&nbsp;'
		 }	
		return html ;
	}
	function sfxxAdd() {

		var url=contextPath+'/dtjsMore/addDtjsSfxx?zdryZjhm='+zdryZjhm+'&zdryid='+zdryid;
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '上访信息新增',url: url,width: 880,inline:true,height:500}, 
			   		null, "sfxxquery",null);
		
		
	}

	function sfxxedit(linkObject, index){
        
		cancelBubble();
		var rows = $('#sfxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsSfxx?id='+rowData.id +"&type=edit";
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '上访信息编辑',url: url,width: 880,inline:true,height:500}, 
			   		null, "sfxxquery",null
			   	);
		
	}
	function sfxxview(linkObject, index){

		cancelBubble();
		var rows = $('#sfxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsSfxx?id='+rowData.id +"&type=view";

		openWindow(false,null,url,null,{title:'上访信息查看',width:880,height:500});

		
	}

	function sfxxDelete(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/dtjsMore/deleteDtjsSfxx';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {id:rowData.id}
				}).done(function(result) {
					sfxxquery();
				});
			}
		});
	}
	function sfxxquery(){
		$('#sfxxtable').datagrid('load');
	}

	//===============以下是刑事犯罪前科信息js方法
	function zdxsfzqkxxbFormater(val,row,index){
		 var html="";
		 if(row.xt_lrrbmid==userOrgCode && getPageEditAble()){
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zdxsfzqkxxbedit(this, '+index+')">编辑</a>&nbsp;'
			 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="zdxsfzqkxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
		 }else{		 
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zdxsfzqkxxbview(this, '+index+')">查看</a>&nbsp;'
		 }	
		return html ;
	}
	function zdxsfzqkxxbAdd() {
		
		var url=contextPath+'/dtjsMore/addDtjsZdxsfzqkxxb?zdryZjhm='+zdryZjhm+'&zdryid='+zdryid;
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '刑事犯罪前科信息新增',url: url,width: 880,inline:true,height:500}, 
			   		null, "zdxsfzqkxxbquery",null);
		
		
	}

	function zdxsfzqkxxbedit(linkObject, index){

		cancelBubble();
		var rows = $('#zdxsfzqkxxbtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsZdxsfzqkxxb?id='+rowData.id +"&type=edit";
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '刑事犯罪前科信息编辑',url: url,width: 880,inline:true,height:500}, 
			   		null, "zdxsfzqkxxbquery",null
			   	);
		
	}
	function zdxsfzqkxxbview(linkObject, index){

		cancelBubble();
		var rows = $('#zdxsfzqkxxbtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsZdxsfzqkxxb?id='+rowData.id +"&type=view";

		openWindow(false,null,url,null,{title:'刑事犯罪前科信息查看',width:880,height:500});

		
	}

	function zdxsfzqkxxbDelete(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/dtjsMore/deleteDtjsZdxsfzqkxxb';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {id:rowData.id}
				}).done(function(result) {
					zdxsfzqkxxbquery();
				});
			}
		});
	}
	function zdxsfzqkxxbquery(){
		$('#zdxsfzqkxxbtable').datagrid('load',{    
			
		});
	}
//=====社会关系人js方法
	function shgxrxxbFormater(val,row,index){
		 var html="";
		 if(row.xt_lrrbmid==userOrgCode && getPageEditAble()){
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="shgxrxxbedit(this, '+index+')">编辑</a>&nbsp;'
			 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="shgxrxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
		 }else{		 
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="shgxrxxbview(this, '+index+')">查看</a>&nbsp;'
		 }	
		return html ;
	}
	function shgxrxxbAdd() {
		var url=contextPath+'/dtjsMore/addDtjsShgxrxxb?zdryZjhm='+zdryZjhm+'&zdryid='+zdryid;
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '社会关系人信息新增',url: url,width: 880,inline:true,height:600}, 
			   		null, "shgxrxxbquery",null);
		
		
	}

	function shgxrxxbedit(linkObject, index){

		cancelBubble();
		var rows = $('#shgxrxxbtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsShgxrxxb?id='+rowData.id +"&type=edit";
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '社会关系人信息编辑',url: url,width: 880,inline:true,height:600}, 
			   		null, "shgxrxxbquery",null
			   	);
		
	}
	function shgxrxxbview(linkObject, index){

		cancelBubble();
		var rows = $('#shgxrxxbtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsShgxrxxb?id='+rowData.id +"&type=view";

		openWindow(false,null,url,null,{title:'社会关系人信息查看',width:880,height:500});

		
	}

	function shgxrxxbDelete(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/dtjsMore/deleteDtjsShgxrxxb';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {id:rowData.id}
				}).done(function(result) {
					shgxrxxbquery();
				});
			}
		});
	}
	function shgxrxxbquery(){
		$('#shgxrxxbtable').datagrid('load',{    
			
		});
	}
	
	//=====车辆信息js方法
	function clxxFormater(val,row,index){
		 var html="";
		 if(row.xt_lrrbmid==userOrgCode && getPageEditAble()){
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="clxxedit(this, '+index+')">编辑</a>&nbsp;'
			 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="clxxDelete(this, '+index+')">删除</a>&nbsp;'	 
		 }else{		 
			 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="clxxview(this, '+index+')">查看</a>&nbsp;'
		 }	
		return html ;
	}
	function clxxAdd() {
		var url=contextPath+'/dtjsMore/addDtjsClxx?zdryZjhm='+zdryZjhm+'&zdryid='+zdryid;
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '车辆信息新增',url: url,width: 810,inline:true,height:400}, 
			   		null, "clxxquery",null);
		
		
	}

	function clxxedit(linkObject, index){

		cancelBubble();
		var rows = $('#clxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsClxx?id='+rowData.id +"&type=edit";
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '车辆信息编辑',url: url,width: 780,inline:true,height:400}, 
			   		null, "clxxquery",null
			   	);
		
	}
	function clxxview(linkObject, index){

		cancelBubble();
		var rows = $('#clxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsClxx?id='+rowData.id +"&type=view";

		openWindow(false,null,url,null,{title:'车辆信息查看',width:880,height:500});

		
	}

	function clxxDelete(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/dtjsMore/deleteDtjsClxx';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {id:rowData.id}
				}).done(function(result) {
					clxxquery();
				});
			}
		});
	}
	function clxxquery(){
		$('#clxxtable').datagrid('load',{    
			
		});
	}
	
	
	//=====涉毒吸毒js方法
	
	//=====涉毒贩毒js方法
	
	//=====涉毒制毒js方法
	