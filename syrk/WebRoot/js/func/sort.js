jQuery.fn.extend({
	kpdragsort : function(options) {
		var defaults = {
			item:null,
			trash:null,
			clone:false,
			repeat:true,
			accepter:null,
			mouseToContainer:function(){},
			mouseOutContainer:function(){}
		};
		var opts = $.extend({},defaults,options);
		
		var sortContainer = this;
		opts.accepter = opts.accepter?opts.accepter.split(","):null;
		if(opts.item=="" || opts.item == null){		//item参数必须存在	
			console.log("param item is null");
		}
		opts.trash = opts.trash==""?null:opts.trash;
		opts.clone = opts.clone?true:false;
		opts.repeat = opts.repeat?true:false;
		
		$(sortContainer).addClass("kpsort");
		var container = $(sortContainer);
		
		$(opts.item).off("mousedown").live("mousedown",function(e){
			if(e.which != 1 || $(e.target).is("input, textarea") || window.kp_only) return; // 排除非左击和表单元素
			e.preventDefault(); // 阻止选中文本
			var x = e.pageX;
			var y = e.pageY;
			var _cloneThis = $(this).clone(true).addClass("cloneItem");
			var _this = $(this);
			var w = _this.width();
			var h = _this.height();
			var w2 = w/2;
			var h2 = h/2;
			var p = _this.offset();
			var left = p.left;
			var top = p.top;
			var ml = 0;
			var mt = 0;
			window.kp_only = true;
			// 添加虚线框
			_this.before('<div id="kp_widget_holder"></div>');
			var wid = $("#kp_widget_holder");
			wid.css({"border":"2px dashed #ccc", "height":_this.outerHeight(true)-1});

			// 保持原来的宽高
			_this.css({"width":w, "height":h, "position":"absolute", opacity: 0.8, "z-index": 999, "left":left, "top":top});
			
			//----滚动方法
			function _scrollContainer(){
				var container = wid.parents(".sortItemContainer");
				var cT = container.offset().top;
				var wT = wid.offset().top;
				var t1 = wid.height()+wT;
				if(t1>(cT+container.height()-40)){		//向下滚
					container.scrollTop(container.scrollTop()+wid.height());
				}else if(wT<(cT+40)){					//向上滚
					container.scrollTop(container.scrollTop()-wid.height());
				}
			}
			
			// 绑定mousemove事件
			$(document).mousemove(function(e) {
				e.preventDefault();
				// 移动选中块
				var l = left + e.pageX - x;
				var t = top + e.pageY - y;
				_this.css({"left":l, "top":t});

				// 选中块的中心坐标
				ml = l+w2;
				mt = t+h2-5;
				
				//移出本容器，并且具有clone属性,则,在原来位置生成一个clone对象
				if(opts.clone){
					var poffset = container.offset();
					var b1 = poffset.top;
					var b2 = poffset.left;
					var b3 = container.width() + b2;
					var b4 = container.height() +b1;
					if((ml<b2 || ml>b3 || mt <b1 || mt>b4) && container.find(".cloneItem").length==0){
						wid.replaceWith(_cloneThis);
					}else if(ml>b2 && ml<b3 && mt>b1 && mt<b4){
						_cloneThis.replaceWith(wid);
					}
				}
				
				// 遍历所有块的坐标
				$('.kpsort').each(function(){
					var _container = $(this);
					var $children = $(this).children();
					var poffset = $(this).offset();
					var b1 = poffset.top;
					var b2 = poffset.left;
					var b3 = $(this).width() + b2;
					var b4 = $(this).height() +b1;
					
					
					
					if(ml>b2 && ml<b3 && mt>b1 && mt<b4){		//进入窗口区域
						
						//判断当前容器是否允许接受该值
						var ishave = false;
						for(var i=0;opts.accepter!=null && i<opts.accepter.length;i++){
							if(_container[0] == $(opts.accepter[i])[0]){		//未使用hasClass，是因为可以接受的容器不一定是class标记，并且hasClass中也不要"."
								ishave = true;
							}
						}
						if(ishave)
						//容器中没有子项，直接添加
						if($children.length==0){
							wid.appendTo(this);
						}else{
							$children.not(_this).not(wid).each(function(i) {
								var obj = $(this);
								var p = obj.offset();
								var a1 = p.left;
								var a2 = p.left + obj.width();
								var a3 = p.top;
								var a4 = p.top + obj.height();
			
								// 移动虚线框
								if(a1 < ml && ml < a2 && a3 < mt && mt < a4) {
									if(obj.next("#kp_widget_holder").length!=0) {
										wid.insertAfter(this);
									}else{
										wid.insertBefore(this);
									}
									_scrollContainer();		//滚动滚动条
									return;
								}
							});
						}
					}
				});
			});

			// 绑定mouseup事件
			$(document).mouseup(function(e) {
				$(document).off('mouseup').off('mousemove');
				//检查是否有垃圾箱，以及在垃圾箱内
				if((ml!=0 || mt!=0) && opts.trash!=null){	//当子元素发生拖动时
					var $trash = $(opts.trash);
					var poffset = $trash.offset();
					var b1 = poffset.top;
					var b2 = poffset.left;
					var b3 = $trash.width() + b2;
					var b4 = $trash.height() +b1;
					if(ml>b2 && ml<b3 && mt>b1 && mt<b4){		//进入回收站区域，删除元素
						_this.remove();
						wid.remove();
						window.kp_only = null;
						return;
					}
				}
				//拖拽回位的位置
				var p = null;
				//是否允许重复，该功能，使用于clone时
				if(!opts.repeat){		//如果不允许重复
					if($("#kp_widget_holder").length!=0){
						$.each($("#kp_widget_holder").parent().children().not(_this),function(){
							if($(this).text() == _this.text()){
								$(this).remove();
							}
						});
					}
					console.log(container.find(".cloneItem").length);
					if($("#kp_widget_holder").length!=0 && container.find(".cloneItem").length!=0){
					}else{
						_cloneThis.parent().find(".tree-node-selected").removeClass("tree-node-selected");
						_this.children("div").addClass("tree-node-selected");
						_cloneThis.replaceWith(_this);
						p = _this.offset();
					}
				}
				
				// 拖拽回位，并删除虚线框
				if(p==null)p = wid.offset();
				_this.animate({"left":p.left, "top":p.top}, 100, function() {
					_this.removeAttr("style");
					wid.parent().find(".tree-node-selected").removeClass("tree-node-selected");
					_this.children("div").addClass("tree-node-selected");
					$(".cloneItem").removeClass("cloneItem");
					wid.replaceWith(_this);
					window.kp_only = null;
				});
				
			});
		});
		
		
	}
});