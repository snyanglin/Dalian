//@updateAuthor: [star]

var paramArrays="";
var windowID = "";
var treeObject = null;
var selectedUserNode = "";
var bsf="";
var addNodesArray = [];
var select_validObj = null;
var selectedIDString = ",";
var initNodeArray = null;
var initCheckedTarget = [];
var selectedUserNodename="";
function doInit(paramArray) {
    xfOnchange($("#jgdwlb").val(), "");//初始化判断是否重点单位
    paramArrays=paramArray;
    if (selectedUserNodes != "") {    //如果数据库中组织机构数组不为空，为之前数据库存储的图层。空为默认
	var bsf_xf_= bsf_xf;            
	document.getElementById("xfidk"+bsf_xf_).checked=true;
	showxfzzjg(bsf_xf_);              //显示图层
	}else{
    showxfzzjg(1);
    }
    $("#xfaqglrsfzh").validatebox({validType:['sfzh'],charSet:'halfUpper'});
    $("#xfaqzrrsfzh").validatebox({validType:['sfzh'],charSet:'halfUpper'});
}

//重点单位与否
function xfOnchange(newVal, oldVal) {

    if(newVal==1){
      document.getElementById("panel_center").style.display="block";
      }
      else{
      document.getElementById("panel_center").style.display="none";
      document.getElementById("zddwzzjgdm").value ="";
	  document.getElementById("zddwzzjgname").value = "";
	  document.getElementById("zddwrdsj").value = "";
      }
  
    }
 //显示图层   
function showxfzzjg(s){
var urs= xfcheck(s);  //根据不同选择返回不同URL
windowID = paramArrays["windowID"];
  	select_validObj = document.getElementById("select_valid");
  	if (IE && IE_VERSION <= 9) {
		select_validObj.style.height = "280px";
	}
	treeObject = $('#treeSelect');
	button4_onclick();
	$('#treeSelect').tree({

		url:urs ,

		onClick: function(node) { // 点击结点事件
			var nodeType = node['nodeType'];
			if (node.children) { // 点击中间结点自动展开与折叠当前结点
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				}
				else {
					$(this).tree('collapse', node.target);
				}
			}
		},
		
		onDblClick: function(node) { // 在双击一个节点的时候执行
			var nodeType = node['py'];
			if (nodeType != "top") {
				$(this).tree('check',  node.target);
				addOptions(node['id'], node['text']);
				showcheckednr+="node['id']";
			}
		},
		onLoadSuccess: function(node, data) { //显示左面树状结构
	
			setTimeout("setSelectedOptions()", 1000); 
				
		}

		
	});	
	


}
//显示左面树状结构
function setSelectedOptions() {

 var str=document.getElementsByName("xfid");   //单选框选择
	for (i=0;i<str.length;i++){
	if(str[i].checked){
       if(str[i].value==bsf_xf){          //比对，如果单选框选择与数据库中一致。默认勾选的结果。反之清空
       selectedUserNode=selectedUserNodes;
        }else{
        selectedUserNode="";
        }
    }
}
	if (selectedUserNode != "") {
		addNodesArray = [];
		initCheckedTarget = [];
		initNodeArray = selectedUserNode.split(",");
		for (var i = 0; i < initNodeArray.length-1; i++) {
			var node = treeObject.tree('find',initNodeArray[i]);  //数据库中组织机构生成tree
		
			if (node != null) {
				initCheckedTarget.push(node.target);
				var optionArray = [];
				optionArray['id'] = node['id'];
				optionArray['text'] = node['text'];
				addNodesArray.push(optionArray);
			}
		}
		initNodeArray = [];

		if (addNodesArray.length > 0) {

			addOptionsBatch(addNodesArray); 
			setTimeout("initChecked()", 0); 
		}
		//selectedUserNode="";
	}
}

function initChecked() {
	for (var i = 0; i < initCheckedTarget.length; i++) { // 设置初始选中
		treeObject.tree('expandTo', initCheckedTarget[i]);
		treeObject.tree('check', initCheckedTarget[i]);
	}
	initCheckedTarget = [];
}

//批量增加到列表
function addOptionsBatch() {

	var addHTML = [];

	for (var i = 0; i < addNodesArray.length; i++) {
		var node = addNodesArray[i];
		if (selectedIDString.indexOf(',' + node['id'] + ',') == -1) { 
			selectedIDString += node['id'] + ",";
			addHTML.push(getOptionString(node['id'], node['text']));
		}		
	}
	if (addHTML.length > 0) {
	$('#select_valid').append(addHTML.join(''));

	}
}


function addOptions(optionValue, optionText) {
	if (selectedIDString.indexOf(',' + optionValue + ',') == -1) {
		selectedIDString += optionValue + ",";
		$('#select_valid').append(getOptionString(optionValue, optionText));
	}
}

//取提单条列表option的html字符串
function getOptionString(optionValue, optionText) {
	var optionString = '<option value="' + optionValue + '">';
	optionString += '\xA0' + optionText + '</options>';
	return optionString;
}
//选中勾选到右面框
function button2_onclick() {
	var nodes = treeObject.tree('getChecked');
	addNodesArray = [];
    selectedUserNode="";
    selectedUserNodename="";
	for (var item in nodes) {
		var node = nodes[item];
		var nodeType = node['py'];
		if (nodeType != "top") {
			var optionArray = [];
			optionArray['id'] = node['id'];
			optionArray['text'] = node['text'];
			addNodesArray.push(optionArray);
             selectedUserNode+=node['id']+",";
             selectedUserNodename+= node['text']+",";
			
		}
	}

    selectedUserNodename=selectedUserNodename.replace(/,$/gi,"");
	if (addNodesArray.length > 0) {
		addOptionsBatch(addNodesArray);
		document.getElementById("zddwzzjgdm").value =selectedUserNode;
	    document.getElementById("zddwzzjgname").value = selectedUserNodename;
	}
}
//右面框结果清除
function button3_onclick() {
	var i = select_validObj.selectedIndex;
	while (i >= 0) {
		if (i>=0) {
			select_validObj.remove(i);
		}
		i = select_validObj.selectedIndex;  
	}
	initSelectedIDString();
}
//全部清除
function button4_onclick() {

	if (select_validObj.length > 0) {
		var times = select_validObj.length - 1;
		for (var i = 0; i <= times; i++) {        
			select_validObj.remove(0);
		}
	}
	initSelectedIDString();
}
//点击清除
function right_ondblclick() {

	var cur_sele = 0;
	if (select_validObj.length > 0) {
		cur_sele = select_validObj.selectedIndex;
		if (cur_sele >= 0) {
			select_validObj.remove(cur_sele);
		}
	}
	initSelectedIDString();
}

//设置已存在列表ID串
function initSelectedIDString() {
  
	if (select_validObj.length > 0) {
   selectedUserNode="";
   selectedUserNodename="";
		var tempArray = [];
		for (var j = 0; j < select_validObj.length; j++) {        
			tempArray.push(select_validObj.options[j].value);
			selectedUserNode+=select_validObj.options[j].value+",";
		}
	
		selectedIDString = "," + tempArray.join(",") + ","; 
	   document.getElementById("zddwzzjgdm").value =selectedUserNode;
	  var  s = select_validObj.innerText.replace(/^\s+/,"").replace(/\s+$/,"").split(" ");
		for (var i = 0; i < s.length; i++) {
         selectedUserNodename += s[i]+",";
       }
        selectedUserNodename=selectedUserNodename.replace(/,$/gi,"");
        document.getElementById("zddwzzjgname").value =selectedUserNodename;
	}
	else {
		selectedIDString = ",";
	   document.getElementById("zddwzzjgdm").value ="";
       document.getElementById("zddwzzjgname").value = "";
	}
	
}

function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}


	

//单选框
function xfcheck(s){
  var ul="";
  if(s=='1'){
         bsf=1;
         ul= contextPath + "/common/dict/BD_D_DWXFRYMJCS.js";
   }else if(s=='2'){
         bsf=2;
         ul= contextPath + "/common/dict/BD_D_DWXFGJJG.js";
   }else if(s=='3'){
         bsf=3;
         ul= contextPath + "/common/dict/BD_D_DWXFGBDT.js";
   }else if(s=='4'){
         bsf=4;
         ul= contextPath + "/common/dict/BD_D_DWXFFDC.js";
   }else if(s=='5'){
         bsf=5;
         ul= contextPath + "/common/dict/BD_D_DWXFYRYBHXWP.js";
   }else if(s=='6'){
         bsf=6;
         ul= contextPath + "/common/dict/BD_D_DWXFZYKYDW.js";
   }else if(s=='7'){
         bsf=7;
         ul= contextPath + "/common/dict/BD_D_DWXFGCGGJZ.js";
   }else if(s=='8'){
         bsf=8;
         ul= contextPath + "/common/dict/BD_D_DWXFCSDXTD.js";
   }else if(s=='9'){
         bsf=9;
         ul= contextPath + "/common/dict/BD_D_DWXFLMMC.js";
   }else if(s=='10'){
         bsf=10;
         ul= contextPath + "/common/dict/BD_D_DWXFGJHSJ.js";
   }else if(s=='11'){
         bsf=11;
         ul= contextPath + "/common/dict/BD_D_DWXFQTFSHZ.js";
   }
   document.getElementById("bsf").value =bsf;
   return ul;
  
}

function afterSubmit(arr) {
	window.parent.location.reload();
}



