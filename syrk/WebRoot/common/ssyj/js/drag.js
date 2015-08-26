/*-------------------------- +
  获取id, class, tagName
 +-------------------------- */
var dragDivGet = {
	byId: function(id) {
		return typeof id === "string" ? document.getElementById(id) : id;
	},
	byClass: function(sClass, oParent) {
		var aClass = [];
		var reClass = new RegExp("(^| )" + sClass + "( |$)");
		var aElem = this.byTagName("*", oParent);
		for (var i = 0; i < aElem.length; i++) reClass.test(aElem[i].className) && aClass.push(aElem[i]);
		return aClass;
	},
	byTagName: function(elem, obj) {
		return (obj || document).getElementsByTagName(elem);
	}
};
var dragMinWidth = 600;
var dragMinHeight = 450;
/*-------------------------- +
  拖拽函数
 +-------------------------- */
function drag(oDrag, handle)
{ 
	var disX = dixY = 0;
	var oMin = dragDivGet.byClass("min", oDrag)[0];
	var oMax = dragDivGet.byClass("max", oDrag)[0];
	var oRevert = dragDivGet.byClass("revert", oDrag)[0];
	var oClose = dragDivGet.byClass("close", oDrag)[0];
	var oA = dragDivGet.byClass("open", oDrag)[0];
	document.body.appendChild(oA);
	handle = handle || oDrag;
	handle.style.cursor = "move";
	handle.onmousedown = function (event)
	{
		var event = event || window.event;
		disX = event.clientX - oDrag.offsetLeft;
		disY = event.clientY - oDrag.offsetTop;
		
		handle.onmousemove = function (event)
		{
			var event = event || window.event;
			var iL = event.clientX - disX;
			var iT = event.clientY - disY;
			var maxL = document.body.offsetWidth - oDrag.offsetWidth;
			var maxT = document.body.offsetHeight - oDrag.offsetHeight;
			
			iL <= 0 && (iL = 0);
			iT <= 0 && (iT = 0);
			iL >= maxL && (iL = maxL);
			iT >= maxT && (iT = maxT);
			
			oDrag.style.left = iL + "px";
			oDrag.style.top = iT + "px";
			
			return false
		};
		
		handle.onmouseup = function ()
		{
			handle.onmousemove = null;
			handle.onmouseup = null;
			this.releaseCapture && this.releaseCapture()
		};
		this.setCapture && this.setCapture();
		return false
	};	
	//最大化按钮
	oMax.onclick = function ()
	{
		oDrag.style.top = oDrag.style.left = 0;
		oDrag.style.width = document.body.offsetWidth - 2 + "px";
		oDrag.style.height = document.body.offsetHeight - 2 + "px";
		this.style.display = "none";
		oRevert.style.display = "block";
	};
	//还原按钮
	oRevert.onclick = function ()
	{		
		oDrag.style.width = dragMinWidth + "px";
		oDrag.style.height = dragMinHeight + "px";
		oDrag.style.left = (document.body.offsetWidth - oDrag.offsetWidth) / 2 + "px";
		oDrag.style.top = (document.body.offsetHeight - oDrag.offsetHeight) / 2 + "px";
		this.style.display = "none";
		oMax.style.display = "block";
	};
	//最小化按钮
	oMin.onclick = function (){
		oDrag.style.display = "none";
		oA.style.display = "block";
		oA.style.top=oDrag.offsetTop;
		oA.style.left=oDrag.offsetLeft;
		oA.onclick = function ()
		{
			oDrag.style.display = "block";
			oA.style.display = "none";
			this.onclick = null;
		};
	};
		
	oClose.onclick = function (){
		oDrag.style.display = "none";
		oA.style.display = "none";
	};
	//阻止冒泡
	oMin.onmousedown = oMax.onmousedown = oClose.onmousedown = function (event){
		this.onfocus = function () {this.blur();};
		(event || window.event).cancelBubble = true;
	};
}
/*-------------------------- +
  改变大小函数
 +-------------------------- */
function resize(oParent, handle, isLeft, isTop, lockX, lockY)
{
	handle.onmousedown = function (event)
	{
		var event = event || window.event;
		var disX = event.clientX - handle.offsetLeft;
		var disY = event.clientY - handle.offsetTop;	
		var iParentTop = oParent.offsetTop;
		var iParentLeft = oParent.offsetLeft;
		var iParentWidth = oParent.offsetWidth;
		var iParentHeight = oParent.offsetHeight;
		
		document.onmousemove = function (event)
		{
			var event = event || window.event;
			
			var iL = event.clientX - disX;
			var iT = event.clientY - disY;
			var maxW = document.body.offsetWidth - oParent.offsetLeft - 2;
			var maxH = document.body.offsetHeight - oParent.offsetTop - 2;			
			var iW = isLeft ? iParentWidth - iL : handle.offsetWidth + iL;
			var iH = isTop ? iParentHeight - iT : handle.offsetHeight + iT;
			
			isLeft && (oParent.style.left = iParentLeft + iL + "px");
			isTop && (oParent.style.top = iParentTop + iT + "px");
			
			iW < dragMinWidth && (iW = dragMinWidth);
			iW > maxW && (iW = maxW);
			lockX || (oParent.style.width = iW + "px");
			
			iH < dragMinHeight && (iH = dragMinHeight);
			iH > maxH && (iH = maxH);
			lockY || (oParent.style.height = iH + "px");
			
			if((isLeft && iW == dragMinWidth) || (isTop && iH == dragMinHeight)) document.onmousemove = null;
			
			return false;	
		};
		document.onmouseup = function ()
		{
			document.onmousemove = null;
			document.onmouseup = null;
		};
		return false;
	}
};

var init_drag_obj=function(name){
	var oDrag = $("#"+name)[0];
	var oTitle = dragDivGet.byClass("title", oDrag)[0];
	var oL = dragDivGet.byClass("resizeL", oDrag)[0];
	var oT = dragDivGet.byClass("resizeT", oDrag)[0];
	var oR = dragDivGet.byClass("resizeR", oDrag)[0];
	var oB = dragDivGet.byClass("resizeB", oDrag)[0];
	var oLT = dragDivGet.byClass("resizeLT", oDrag)[0];
	var oTR = dragDivGet.byClass("resizeTR", oDrag)[0];
	var oBR = dragDivGet.byClass("resizeBR", oDrag)[0];
	var oLB = dragDivGet.byClass("resizeLB", oDrag)[0];
	
	drag(oDrag, oTitle);
	//四角
	resize(oDrag, oLT, true, true, false, false);
	resize(oDrag, oTR, false, true, false, false);
	resize(oDrag, oBR, false, false, false, false);
	resize(oDrag, oLB, true, false, false, false);
	//四边
	resize(oDrag, oL, true, false, false, true);
	resize(oDrag, oT, false, true, true, false);
	resize(oDrag, oR, false, false, false, true);
	resize(oDrag, oB, false, false, true, false);
	
	oDrag.style.left = (document.body.offsetWidth - oDrag.offsetWidth) / 2 + "px";
	oDrag.style.top = (document.body.offsetHeight - oDrag.offsetHeight) / 2 + "px";
	dragDivGet.byClass("close", oDrag)[0].click();
};

	
	/*
	$.ajax({
		url:"page/toolsDemo/index.jsp",
		type:"post",
		dataType:"html",
		success:function(html){
			$("#drag_div").html(html);
			//init colorpick start
			var colorpick=$("#color-hidden-input");
			colorpick.minicolors({
				control: colorpick.attr('data-control') || 'hue',
				defaultValue: colorpick.attr('data-defaultValue') || '',
				inline: colorpick.attr('data-inline') === 'true',
				letterCase: colorpick.attr('data-letterCase') || 'lowercase',
				opacity: colorpick.attr('data-opacity'),
				position: colorpick.attr('data-position') || 'bottom left',
				change: function(hex, opacity) {
					colorpick[0].style.background=hex;
					colorpick.html(colorpick[0].style.background);
				}
//				theme: 'bootstrap'
			});
			//init colorpick end
		}
	});*/
	
