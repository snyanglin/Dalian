	function beforeCheck_ComboTree_JS(node,checked){
			//alert(node.text+","+checked);
			var t = $('#yysx_xs').combotree('tree');	// 获取树对象
			//var n = t.tree('getSelected');

			var rootNode=t.tree('getRoot');//根节点
			var parentNode=t.tree('getParent',node.target);
			if(parentNode==null)
				return false;
			if(parentNode==rootNode)
				return true;
			var childrenNode=t.tree('getChildren',parentNode.target);
			var childCount=childrenNode.length;//儿子数
			//alert(parentNode.text+",children:"+childCount);
			//alert("childCount:"+childrenNode.length);
			for(var i=0;i<childCount;i++){
				var currentNode=childrenNode[i];
				if(currentNode!=node){
					//currentNode.checked='checked';
					//取消选中状态					
					t.tree('update', {
						target: currentNode.target,
						checked: false
					});
				}//end if
			}//end for
	}					

var propertyArray=[
['1001'],
['1401'],
['2301'],
['2201','2202','2203'],
['1604'],
['2901'],
['1801','1802','1803'],
['2403'],
['2101','2102'],
['2302'],
['00000'],
['00000']
];

//根据选择的应用属性组合为省厅要求的应用属性
function combo_Property_JS(selectedAttr){
	var result="";
	for(var i=0;i<propertyArray.length;i++){
		var bFound=false;
		for(var j=0;j<propertyArray[i].length;j++){
			var theItem=propertyArray[i][j];
			if(selectedAttr.indexOf(theItem)>-1){
				bFound=true;
				break;
			}
		}//end for(j)
		result+=bFound?'1':'0';
	}//end for(i)
	return result;
}

	//获得下拉tree中检取的所有值
	function get_ComboTreeValue_JS(inputID){
		var selectedValue = $('#'+ inputID).combotree('getValues');
		var result=selectedValue.join(',');
		//alert("selectedValue="+result);
		return 	result;
			
	}
	