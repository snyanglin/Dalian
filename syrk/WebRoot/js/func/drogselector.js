/*
	 * 判断选择器是否为空param:selector
	 */
	function isNull(text){
		if(text==null||$.trim(text)==""){
			return false;
		}
		return true;
	}
	

	
	/**
	 * 获取指定树的数据，数据放在attributes中的nodeDate
	 * param:select
	 * return null/datas
	 */
	
	function getData(selector){
		if(!isNull(selector))return;
		
		 var roots = $(selector).tree("getRoots");
		 var datas = new Array(0);
		 for(var i=0;i<roots.length;i++){
			 
			try{
				datas.push(roots[i].attributes.ID);
			}catch (e) {
				console.log("'nodeData' attributes not define");
			}
		 }
		 if(datas.length==0)return null;
		 return datas;
	}
	

	
	/*
	 * 对指定选择器的子元素进行排序，排序规则为在原有的基础上，选中的前置param:select
	 */
	function sortItem(select){
		if(!isNull(select))return;
		
		$.each($(select),function(){
			var $currSort = $(this);
			var node = $(this).tree("getChecked");
			var firstNode = $(this).tree("getRoots")[0];
			if(!firstNode)return;
			
			//过滤子节点，过滤子级目录
			node = $.grep(node, function(n,i){
				var flag = false;
				$.each($currSort.tree("getRoots"),function(index,obj){
					if(n.target==obj.target){
						flag=true;
						return;
					}
				});
				return flag;
			});
			
			for(var i=node.length-1;i>=0;i--){
				$(this).prepend($(node[i].target).parent());
			}
			
		});
	}
	