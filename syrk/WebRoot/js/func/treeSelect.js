$(function(){
	

	//console.log($("#sort1").length()+"###");
			$("#sort1").addClass("clonesortable1");
			$("#sort2").addClass("clonesortable2");
			var data=[{text:'Item1',state:'closed',attributes:{'nodeData':'那是一个秋天1'},children:[{text:'Item11'},{text:'Item12'}]},{checked:true,text:'Item2',attributes:{nodeData:'那是一个秋天2'}},{text:'Item3',state:'closed',checked:true,children:[{text:'Item31'},{text:'Item32'}]},{checked:true,text:'aaaa',attributes:{nodeData:'那是一个秋天4'}}];var data1=[{text:'bbbb',state:'closed',attributes:{'nodeData':'1'},children:[{text:'Item111'},{text:'Item121'}]},{checked:true,text:'ccc',attributes:{nodeData:'2'}},{text:'ddddd',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{checked:true,text:'eeee',attributes:{nodeData:'3'}},{text:'ffff',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{checked:true,text:'gggg',attributes:{nodeData:'4'}},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{text:'Item31',state:'closed',checked:true,children:[{text:'Item311'},{text:'Item321'}]},{checked:true,text:'hhhh',attributes:{nodeData:'5'}}];
			//alert(324);
			//更新指定tree树的数据
			/*$('.clonesortable1').tree({
				url:'', 	//数据源
				data:data,
				checkbox:true,
				onlyLeafCheck:false,
				animate:true
			});*/
			$(".clonesortable1").tree({
				//url:"http://localhost:8080/CCSBaseFrame/OpsController/findOpsTreeList",
				checkbox:true,
				onlyLeafCheck:false,
				animate:true,
				method:"get",
				onLoadSuccess:function(){
					$(".clonesortable1").kpdragsort({
						item:".clonesortable1>li",
						clone:true,				//移出本容器，产生克隆对象
						repeat:false,
						accepter:".clonesortable1,.clonesortable2"
					});
				}
			});/*
			$('.clonesortable2').tree({
				url:'',		//数据源
				data:data1,
				checkbox:true,
				onlyLeafCheck:false,
				animate:true
			});*/
			
			/**********************************/
			
			
			//----
			$(".clonesortable2").kpdragsort({
				item:".clonesortable2>li",		//操作的子项，必须
				trash:".clonesortable1",		//垃圾回收站
				accepter:".clonesortable2",		//允许接受者
				repeat:false
			});
			
			/***********************************/
			
			
			//重新排序(规则：在原有的基础上，将选中项前置)
			 //sortItem('.clonesortable1,.clonesortable2');


});	