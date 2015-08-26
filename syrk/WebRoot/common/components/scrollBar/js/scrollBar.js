/*!
 * 滚动条组件
 * znjg - v1.0.0 (2014-04-15 16:30)
 * Copyright(c) 2014 founder
 */
/**
 * @classDescription 滚动条
 * @author jb
 */
var ScrollBar = {
		
		/**
		 * 初始化 滚动条
		 * @param {Object} param JSON对象
		 * @param {Function} func 回调函数
		 */
		init : function(param, callbackFunc) {
				ScrollBar.initResize(param);
				if(typeof(param.resize) !== 'undefined'){
					$('#'+param.id).mCustomScrollbar({
						scrollButtons:{
							enable:true
						}
					});
					$(".mCustomScrollBox").width($(".mCustomScrollbar").width());
					$('#'+param.id).live('resize',function(){
						ScrollBar.initResize(param);
					});
					/*$('div').resize(function(){
						alert(1);
						ScrollBar.initResize(param);
						return false;
					});*/
					/*$('div').scroll(function(){
						ScrollBar.initResize(param);
					});*/
					//限制div自由缩放次数
					 function debounce(callback, delay, context){  
						    if (typeof(callback) !== "function") {  
						        return;  
						    }  
						    delay = delay || 150;  
						    context = context || null;  
						    var timeout;  
						    var runIt = function(){  
						            callback.apply(context);  
						        };  
						    return (function(){  
						        window.clearTimeout(timeout);  
						        timeout = window.setTimeout(runIt, delay);  
						    });  
						}  
						var winResizeHandler = function(event){
							ScrollBar.initResize(param);
							var lfdl=$("#contentDivId").find("dl:last").index();
							if(lfdl>10){
								lfdl=lfdl-10;
							}else{
								lfdl=0;
							}
							$("#contentDivId").mCustomScrollbar("scrollTo","dl:eq("+lfdl+")",{scrollInertia:2500,scrollEasing:"easeInOutQuad"}); //判断滚动条滚动位置
						};  
						$('div').resize(debounce(winResizeHandler, 300)); 
			}
			
		},
		initResize : function(param){
			var id = param.id;
			var topheight = param.topheight;
				$('#'+param.id).mCustomScrollbar("update");
				var idparenth=$('#'+id).parent().height()-topheight;
				$('#'+id).height(idparenth);

				$(".mCSB_scrollTools .mCSB_buttonDown").each(function(){
					var thistop=$(this).parent().height()-40;
					$(this).css({top:thistop});
				});
		},
		disable: function(param, callbackFunc){
			$('#'+param.id).mCustomScrollbar("disable");
		}
}