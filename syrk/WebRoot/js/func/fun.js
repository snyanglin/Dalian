$(function() {
			$("#sort1").addClass("clonesortable1");
			$("#sort2").addClass("clonesortable2");
			
			$(".clonesortable1,.clonesortable2").tree({
				onLoadSuccess:function(node, data){
					for(var i=0;i<data.length;i++){
						$("#"+data[i].domId).attr("attrID",(data[i].attributes.ID));
					}
				}
			});
			
			function getAttrID(selector){
				var txt = "";
				$(selector).find(".tree-node[attrID]").each(function(){
					if(txt!="")txt += ",";
					txt += $(this).attr("attrID");
				});
				if(txt == "")return null;
				return txt;
			}
			var inputID = "#opsIds";
			
			var sourceAble2 = null;		//上一次手动的右边元素的集合
			var flag = false;
			/*创建sortable*/
			$( ".clonesortable2" ).sortable({
				cursor: "move",
				delay:100,
				distance:10,
				connectWith: ".clonesortable1",
				items: ">li",
				opacity: 0.5,
				revert: 100,
				receive:function(){		//接受到值时
					$(inputID).val(getAttrID(".clonesortable2"));
				},
				stop:function(event, ui){		//从sortabl2中移到sortable1中时，删除该对象
					flag = false;
					if(ui.item.parents(".clonesortable1")[0]!=null){
						ui.item.remove();
					}
					$(inputID).val(getAttrID(".clonesortable2"));
	            },
	            over:function(event,ui){		//当该sortable接收到连接sortable对象传过来的值时删除该sortable中存在的项
	            	var txt = ui.item.children("div").children(".tree-title").text();
	            		for(var i=0;i<sourceAble2.length;i++){
	            			var cutxt = $(sourceAble2[i]).children("div").children(".tree-title").text();
	            			if(cutxt == txt){
	            				$(sourceAble2[i]).remove();
	            			}
	            			
	            		}
	           },
	           sort:function(event,ui){
	        	   $(inputID).val(getAttrID(".clonesortable2"));
	        	   if(flag){
					   $('.clonesortable1 .ui-sortable-placeholder').addClass("none");
					}
	           }
			}).disableSelection();
			

			var before = null;
			var next = null;
			var parent = null;
			$(".clonesortable1").sortable({
				cursor: "move",
				connectWith: ".clonesortable2",
				delay:100,
				distance:10,
				helper: "clone",
				items: ">li",
				opacity: 0.5,
				revert: 100,
				sort: function(event, ui) {
				  $(ui.item).show();
	              before = ui.item.prev()[0];
	              if(before==null){
	            	  next = ui.item.next().next()[0];
	              }else if(next==null){
	            	  parent = ui.item.parent()[0];
	              }
	              var sortBox2 = $(".clonesortable2")[0];
	              sourceAble2 = $(sortBox2).children("li");
	            },
	            stop:function(event, ui){
	            	var clone = ui.item.clone();
	            	var sortBox1 = ui.item.parents(".clonesortable1")[0];
	            	if(sortBox1!=null){
	            		return;
	            	}
	            	if(before!=null){
		            	  $(before).after(clone);
		             }else if(next!=null){
		            	 $(next).before(clone);
		             }else if(parent!=null){
		            	 $(parent).before(clone);
		             }
	            	
				},
				over:function(event,ui){
					flag = true;
				}
			}).disableSelection();
			
			
			//重新排序(规则：在原有的基础上，将选中项前置)
			 sortItem('.clonesortable1,.clonesortable2');

	});
	
	