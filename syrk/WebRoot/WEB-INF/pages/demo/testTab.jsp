<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>左右布局滑动切换Tab选项卡</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/tabstyle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/tabChart/event.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/tabChart/tween.js"></script>
  </head>
  <body>
    <div class="tabmain">
		<div id="outerWrap">
			<div id="sliderParent"></div>
			<div class="blueline" id="blueline" style="top: 0px; "></div>
			<ul class="tabGroup" style="margin: 0;padding: 0;">
				 <li class="tabOption selectedTab">实有人口</li>
				 <li class="tabOption">建筑物统计</li>
				 <li class="tabOption">标准地址统计</li>
				 <li class="tabOption">流动人口统计</li>
			</ul>
			<div id="container">
                 <div id="content">
                    <div class="tabContent selectedContent">
                       <h3>实有人口</h3>
                       <div id="falseCharDiv"></div>
                    </div>
                    <div class="tabContent">
                       <h3>建筑物统计</h3>
                       <!-- 显示的内容 -->
                    </div>
                    <div class="tabContent">
                       <h3>标准地址统计</h3>
                       <!-- 显示的内容 -->
                    </div>
                    <div class="tabContent">
                       <h3>流动人口统计</h3>
                       <!-- 显示的内容 -->
                    </div>
                 </div>
	         </div>
		 </div>
	</div>
	<script type="text/javascript">
	var container = document.getElementById('container');
	var content = document.getElementById('content');
	var oDivs = DOM.children(content, "div");
	oDivs[0].st = 0;
	for (var i = 1; i < oDivs.length; i++) {
	    oDivs[i].st = oDivs[i].offsetTop;
	}
	var oLis = DOM.getElesByClass("tabOption");
	var flag = 0;
	var upFlag = oLis.length;; (function() {
	    function fn(e) {
	        e = e || window.event;
	        if (e.wheelDelta) {
	            var n = e.wheelDelta;
	        } else if (e.detail) {
	            var n = e.detail * -1;
	        }
	        if (n > 0) {
	            container.scrollTop -= 12;
	        } else if (n < 0) {
	            container.scrollTop += 12;
	        }
	        slider.style.top = container.scrollTop * container.offsetHeight / content.offsetHeight + "px";
	        slider.offsetTop * (content.offsetHeight / container.offsetHeight);
	        var st = container.scrollTop;
	        if (st > this.preSt) {
	            for (var j = 0; j < oLis.length; j++) {
	                if (st < oDivs[j].st) break;
	            }
	            if (oLis[j - 2] && this.preLi !== j) {
	                if ((j) > (flag + 1)) {
	                    DOM.removeClass(oLis[j - 2], "selectedTab");
	                    DOM.addClass(oLis[j - 1], "selectedTab");
	                    animate(blueline, {
	                        top: (j - 1) * 48
	                    },
	                    500, 2);
	                }
	            }
	            flag = j - 1;
	        } else if (st < this.preSt) {
	            for (var j = oLis.length - 1; j >= 0; j--) {
	                if (st > oDivs[j].st) break;
	            }
	            if (oLis[j + 2] && this.preLi !== j) {
	                if (flag === undefined) return;
	                if ((j) < (flag)) {
	                    for (var k = 0; k < oLis.length; k++) {
	                        DOM.removeClass(oLis[k], "selectedTab");
	                    };
	                    DOM.addClass(oLis[j + 1], "selectedTab");
	                    animate(blueline, {
	                        top: (j + 1) * 48
	                    },
	                    500, 2);
	                    upFlag = j + 1;
	                }
	            }
	        }
	        this.preSt = st;
	        if (e.preventDefault) e.preventDefault();
	        return false;
	    }
	    container.onmousewheel = fn;
	    if (container.addEventListener) container.addEventListener("DOMMouseScroll", fn, false);
	    slider = document.createElement('span');
	    slider.id = "slider";
	    slider.style.height = container.offsetHeight * (container.offsetHeight / content.offsetHeight) + "px";
	    sliderParent.appendChild(slider);
	    on(slider, "mousedown", down);
	    var blueline = document.getElementById("blueline");
	    function changeTab() {
	        var index = DOM.getIndex(this);
	        for (var i = 0; i < oLis.length; i++) {
	            DOM.removeClass(oLis[i], "selectedTab");
	        }
	        DOM.addClass(this, "selectedTab");
	        animate(container, {
	            scrollTop: oDivs[index].st
	        },
	        500, 1);
	        var t = oDivs[index].st * container.offsetHeight / content.offsetHeight;
	        animate(slider, {
	            top: t
	        },
	        500);
	        animate(blueline, {
	            top: index * 48
	        },
	        500, 2);
	    }
	    var tabPannel1 = document.getElementById("outerWrap");
	    var oLis = DOM.children(DOM.children(tabPannel1, "ul")[0], "li");
	    for (var i = 0; i < oLis.length; i++) {
	        oLis[i].onclick = changeTab;
	    };
	})();
	</script>
  </body>
</html>