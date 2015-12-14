/*!
 * 滚动条组件类
 * http://jquery.com/
 * znjg - v1.0.0 (2014-04-22 17:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 滚动条组件类
 * @author gb
 */

SysTool.loadComponentsFile("scrollBarTool", "scrollBarTool", ".css");


var doc = document;
var _wheelData = -1;
var className = "scroll_div";

var ScrollBarTool = {
		
		/**
		 * 初始化
		 * @param mainBox
		 * @param contentBox
		 * @param topHeightPx
		 * @param isResize
		 */
		init : function(mainBoxId, contentBoxId, topHeightPx, isResize) {
			$("#"+mainBoxId).addClass("scroll_main");
			$("#"+contentBoxId).addClass("scroll_content");
			var mainBox = doc.getElementById(mainBoxId);
			var contentBox = doc.getElementById(contentBoxId);
			var scrollDiv = this._createScroll(mainBox, className);
			var isHaveScroll = this._resizeScorll(scrollDiv, mainBox, contentBox, topHeightPx, isResize);
			this._tragScroll(scrollDiv, mainBox, contentBox);
			this._wheelChange(scrollDiv, mainBox, contentBox);
			this._clickScroll(scrollDiv, mainBox, contentBox);
			this._initBindEvent(mainBox, isHaveScroll);
		},
		
		/**
		 * 绑定事件
		 * @param obj
		 * @param type
		 * @param handler
		 */
		bind : function(obj, type, handler) {
			var node = typeof obj == "string" ? $(obj) : obj;
			if (node.addEventListener) {
				node.addEventListener(type, handler, false);
			} else if (node.attachEvent) {
				node.attachEvent('on' + type, handler);
			} else {
				node['on' + type] = handler;
			}
		},
		
		/**
		 * 鼠标滚轮事件
		 * @param obj
		 * @param handler
		 */
		mouseWheel : function(obj, handler) {
			var node = typeof obj == "string" ? $(obj) : obj;
			/**
			 * IE
			 */
			this.bind(node, 'mousewheel', function(event) {
				var data = -getWheelData(event);
				handler(data);
				if (document.all) {
					window.event.returnValue = false;
				} else {
					event.preventDefault();
				}
			});
			/**
			 * FireFox
			 */
			this.bind(node, 'DOMMouseScroll', function(event) {
				var data = getWheelData(event);
				handler(data);
				event.preventDefault();
			});
			function getWheelData(event) {
				var e = event || window.event;
				return e.wheelDelta ? e.wheelDelta : e.detail * 40;
			}
		},
		
		/**
		 * 创建滚动条 
		 * @param mainBox
		 * @param className
		 * @returns {____scroll0}
		 */
		_createScroll : function(mainBox, className) {
			$("#scrollBox_"+mainBox.id).remove();
			var _scrollBox = doc.createElement('div');
			_scrollBox.setAttribute("id", "scrollBox_"+mainBox.id);
			var _scroll = doc.createElement('div');
			_scroll.setAttribute("id", "scroll_s_"+mainBox.id);
			var span = doc.createElement('span');
			_scrollBox.appendChild(_scroll);
			_scroll.appendChild(span);
			_scroll.className = className;
			mainBox.appendChild(_scrollBox);
			return _scroll;
		},
		
		/**
		 * 调整滚动条 
		 * @param element
		 * @param mainBox
		 * @param contentBox
		 * @param topHeightPx
		 * @param isResize
		 */
		_resizeScorll : function(element, mainBox, contentBox, topHeightPx, isResize) {
			var isHaveScroll = true;
			var p = element.parentNode;
			var conHeight = $("#"+contentBox.id).height();
			var _width = $("#"+mainBox.id).width();
			if("undefined" == typeof topHeightPx || topHeightPx==null || topHeightPx==""){
				topHeightPx = 0;
			}
			
			var docHeight =  $(document).height();
			var mainBoxHeight =  $("#"+mainBox.id).height();
			//alert(conHeight+"|"+docHeight+"|"+mainBoxHeight);
			//alert(mainBoxHeight);
			var _height = docHeight;
			
			if(docHeight != mainBoxHeight) {
				_height = mainBoxHeight;
			} else {
				_height = mainBoxHeight - topHeightPx;
			}
			
			if(isResize) {
				_height = docHeight - topHeightPx;
			}
			
			mainBox.style.height = _height;
			var _scrollWidth = $("#"+element.id).width();
			var _left = _width - _scrollWidth;
			p.style.width = _scrollWidth + "px";
			p.style.height = _height + "px";
			p.style.left = _left + "px";
			p.style.position = "absolute";
			p.style.background = "#b5cbde";
			contentBox.style.width = ($("#"+mainBox.id).width() - _scrollWidth)
					+ "px";
			if(conHeight < _height) {
				conHeight = _height;
			}
			var _scrollHeight = parseInt(_height * (_height / conHeight));
			//alert(conHeight+"===="+_height+ "====" +_scrollHeight);
			if (_scrollHeight >= _height) {
				$("#scrollBox_"+mainBox.id).hide();
				contentBox.style.width = $("#"+mainBox.id).width() + "px";
				isHaveScroll = false;
				//恢复滚动条至top0
				this.setScrollTop0(mainBox.id,contentBox.id);
			} else {
				$("#scrollBox_"+mainBox.id).show();
				element.style.height = _scrollHeight + "px";
				isHaveScroll = true;
			}
			return isHaveScroll;
		},
		
		/**
		 * 拖动滚动条
		 * @param element
		 * @param mainBox
		 * @param contentBox
		 */
		_tragScroll : function(element, mainBox, contentBox) {
			var mainHeight = mainBox.clientHeight;
			element.onmousedown = function(event) {
				var _this = this;
				var _scrollTop = element.offsetTop;
				var e = event || window.event;
				var top = e.clientY;
				//this.onmousemove=scrollGo; 
				document.onmousemove = scrollGo;
				document.onmouseup = function(event) {
					this.onmousemove = null;
				};
				function scrollGo(event) {
					var e = event || window.event;
					var _top = e.clientY;
					var _t = _top - top + _scrollTop;
					if (_t > (mainHeight - element.offsetHeight)) {
						_t = mainHeight - element.offsetHeight;
					}
					if (_t <= 0) {
						_t = 0;
					}
					
					var contentBoxTop = -_t * (contentBox.offsetHeight / mainBox.offsetHeight);
					if(!ScrollBarTool.judgeIsOver(mainBox.id, contentBox.id, contentBoxTop)){
						element.style.top = _t + "px";
						contentBox.style.top = contentBoxTop + "px";
						_wheelData = _t;
					}
				}
			};
			element.onmouseover = function() {
				this.style.background = "#4b8ebb";
			};
			element.onmouseout = function() {
				this.style.background = "#87b3d2";
			};
		},
		
		/**
		 * 鼠标滚轮滚动，滚动条滚动 
		 * @param element
		 * @param mainBox
		 * @param contentBox
		 */
		_wheelChange : function(element, mainBox, contentBox) {
			var node = typeof mainBox == "string" ? $(mainBox) : mainBox;
			var flag = 0, rate = 0, wheelFlag = 0;
			if (node) {
				this.mouseWheel(
						node,
						function(data) {
							wheelFlag += data;
							if (_wheelData >= 0) {
								flag = _wheelData;
								element.style.top = flag + "px";
								wheelFlag = _wheelData * 12;
								_wheelData = -1;
							} else {
								flag = wheelFlag / 12;
							}
							if (flag <= 0) {
								flag = 0;
								wheelFlag = 0;
							}
							if (flag >= (mainBox.offsetHeight - element.offsetHeight)) {
								flag = (mainBox.clientHeight - element.offsetHeight);
								wheelFlag = (mainBox.clientHeight - element.offsetHeight) * 12;
							}
							
							var contentBoxTop = -flag * (contentBox.offsetHeight / mainBox.offsetHeight);
							
							if(!ScrollBarTool.judgeIsOver(mainBox.id, contentBox.id, contentBoxTop)){
								element.style.top = flag + "px";
								contentBox.style.top = contentBoxTop + "px";
							}
						});
			}
		},
		
		/**
		 * 单击滚动条
		 * @param element
		 * @param mainBox
		 * @param contentBox
		 */
		_clickScroll : function(element, mainBox, contentBox) {
			var p = element.parentNode;
			p.onclick = function(event) {
				var e = event || window.event;
				var t = e.target || e.srcElement;
				var sTop = document.documentElement.scrollTop > 0 ? document.documentElement.scrollTop
						: document.body.scrollTop;
				var top = mainBox.offsetTop;
				var _top = e.clientY + sTop - top - element.offsetHeight
						/ 2;
				if (_top <= 0) {
					_top = 0;
				}
				if (_top >= (mainBox.clientHeight - element.offsetHeight)) {
					_top = mainBox.clientHeight - element.offsetHeight;
				}
				if (t != element) {
					element.style.top = _top + "px";
					contentBox.style.top = -_top
							* (contentBox.offsetHeight / mainBox.offsetHeight)
							+ "px";
					_wheelData = _top;
				}
			};
		},
		
		/**
		 * 内容选择事件是否禁用设置
		 * @param isCanSelect
		 */
		_contextSelect : function(isCanSelect) {
			$(document.body)[0].onselectstart=function() {
   				return isCanSelect;
			};
		},
		
		/**
		 * 初始事件绑定
		 * @param mainBox
		 * @param isHaveScroll
		 */
		_initBindEvent : function(mainBox, isHaveScroll) {
			$("#scrollBox_"+mainBox.id).hide();
			if(isHaveScroll) {
				$("#"+mainBox.id).bind({
					mouseover:function() {
						$("#scrollBox_"+mainBox.id).show();
					},
					mouseout:function() {
						$("#scrollBox_"+mainBox.id).hide();
					}
				});
			} else {
				$("#"+mainBox.id).unbind();
			}
			$('.scroll_div').mousedown(function(){
				  ScrollBarTool._contextSelect(false);
              }).mouseup(function(){
            	  ScrollBarTool._contextSelect(true);
              });
		},
		
		/**
		 * 设置指定滚动条top为0
		 * @param mainBoxId
		 * @param contentBoxId
		 */
		setScrollTop0 : function(mainBoxId, contentBoxId) {
			$("#scroll_s_"+mainBoxId).css("top","0px");
			$("#"+contentBoxId).css("top","0px");
			_wheelData = -1;
		},
		
		/**
		 * 判断是否滚动条超出范围
		 * @param mainBoxId
		 * @param contentBoxId
		 * @param contentBoxTop
		 * @returns {Boolean}
		 */
		judgeIsOver : function(mainBoxId, contentBoxId, contentBoxTop) {
			var isOver = false;
			var mainBoxHeight = $("#"+mainBoxId).height();
			var contentBoxHeight = $("#"+contentBoxId).height();
			var top = contentBoxHeight - mainBoxHeight;
			if(-contentBoxTop >= top + 10) {
				isOver = true;
			}
			return isOver;
		},
		
		debounce : function(callback, delay, context){  
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
		
};

