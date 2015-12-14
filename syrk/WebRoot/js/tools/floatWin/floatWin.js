/*
 * @title: FrameTools.FloatWin.js 
 * @package：sm/frame/js/tools/FrameTools.FloatWin 
 * @description:浮动窗口
 * @author: Li_Zhenzhong@founder.com
 * @date: 2012-11-22 上午10:59:22 
 * @version：V1.0
 */
if(typeof FrameTools == "undefined" || !FrameTools){
	 FrameTools = {};
};
var $jquery=$jquery==null?$:$jquery;
/**
 * @title: FrameTools.FloatWin 
 * @description:初始化浮动框属性并创建
 * @author: Li_Zhenzhong@founder.com 
 * @param title  标题
 * @param containerName  活动容器id
 * @param maxWidth 最大显示宽度
 * @param maxHeight 最大显示高度
 * @param top 初始显示顶部位置
 * @param left 初始显示左侧位置
 * @param mixWidth 最小显示宽度
 * @param opacity 透明度 范围1~0,1为不透明 0为全透明
 * @param close是否带关闭按钮
 * @date：2012-11-22下午1:07:53
 */
FrameTools.FloatWin = function(title,containerName,maxWidth,maxHeight,maxTop,maxLeft,minTop,minLeft,mixWidth,opacity,close){
	this.id = ++FrameTools.FloatWin.id;
	this.winId = "Float_Win_"+this.id; //浮动框ID
	this.opDivId = "Float_Opdiv_"+this.id; //浮动框操作窗口ID
	this.title = title;				//浮动框标题
	this.container = containerName;//浮动框活动范围容器
	this.maxWidth = maxWidth==null?400:maxWidth ;	//浮动框最大化宽度
	this.maxHeight = maxHeight==null?250:maxHeight ;//浮动框最大化高度
	this.minWidth = mixWidth==null?150:mixWidth; //浮动框最小化宽度
	this.minHeight = 50;//浮动框最小化高度
	this.maxTop = maxTop==null?($jquery("#"+this.container).height() - this.maxHeight)/2:maxTop ;	//浮动框显示顶部位置
	this.maxLeft = maxLeft==null?($jquery("#"+this.container).width() - this.maxWidth)/2:maxLeft ; //浮动框显示左侧距离
	this.minTop =  minTop==null?30:minTop;   //最小化顶部距离
	this.minLeft =  minLeft==null?($jquery("#"+this.container).width()-this.minWidth-10):minLeft;   //最小化左侧距离
	this.opacity = opacity==null?0.9:opacity;//浮动框透明度
	if(close==null||close==""){
		this.creatDiv(this.id);
	}else{
		this.creatDivClose(this.id);
	}
	this.setFloatWinPosition(this.maxTop, this.maxLeft);
	FrameTools.FloatWin.prototype.addWinList(this.id,this);
};
FrameTools.FloatWin.id = 0;//浮动窗口Id
FrameTools.FloatWin.winList = new Array();//浮动窗口集合
var contextPath = contextPath==null?("/"+document.location.pathname.split("/")[1]):contextPath;
FrameTools.FloatWin.basePath = contextPath + "/js/tools/floatWin/images/";//浮动框图片存放位置

/**
 * @title: creatDiv 
 * @description:创建浮动窗口contextPath
 * @date：2012-11-22下午12:40:18
 */
FrameTools.FloatWin.prototype.creatDiv = function(id){
	var divHtml ='<div style="width:'+this.maxWidth+'px; height:'+this.maxHeight+'px; filter:alpha(opacity='+(this.opacity*100)+');opacity: '+this.opacity+';   position:absolute; " '
					+'data-options="onDrag:function(e){FrameTools.FloatWin.onDrag(e,\''+this.winId+'\',\''+this.container+'\')},onStopDrag:function(e){FrameTools.FloatWin.onStopDrag(e,\''+this.winId+'\',\''+this.container+'\')} ,handle:\'#title\'" id="'+this.winId+'" >'
			    		+  '<table  id="floatTable" style="width:100%;height:100% " cellspacing="0" cellpadding="0" border=0 >'
			    		+	'<tr style=" width:100%;height:28px;" >'
				    	+	  '			<td id="title" valign=top style="padding-top:5px;background-image:url('+FrameTools.FloatWin.basePath+'copy1.png);width:'+(parseInt((this.maxWidth-35)/this.maxWidth*100))+'%;"><span style="padding-left:10px;color:#fff;font-size: 16px;font-weight: bold;">'+this.title+'</sapn></td>'
				    	+	  '			<td align="right" style="padding-right:8px;background-image:url('+FrameTools.FloatWin.basePath+'copy1.png);width:15px">'
				    	+		'			<img id="floatWin_zoom'+id+'" alt="放大" style="cursor:hand;display:none;" src="'+FrameTools.FloatWin.basePath+'bt2-1.png" onmouseover="FrameTools.FloatWin.onMouseMove(this,\'bt2-1.png\')" onmouseout="FrameTools.FloatWin.onMouseMove(this,\'bt2-2.png\')" onclick="FrameTools.FloatWin.zoomFloatWin('+id+')" />'
				    	+		'			<img id="floatWin_zoomOut'+id+'" alt="缩小" style="cursor:hand;" src="'+FrameTools.FloatWin.basePath+'bt4-1.png" onmouseover="FrameTools.FloatWin.onMouseMove(this,\'bt4-1.png\')" onmouseout="FrameTools.FloatWin.onMouseMove(this,\'bt4-2.png\')" onclick="FrameTools.FloatWin.zoomOutFloatWin('+id+')" />'
				    	+				'</td>'
				    	+ '				<td style="width:10px;" >'
				    	+ '					<table width="10" height="100%" border="0" cellspacing="0" cellpadding="0">'
				    	+ '					</table>'
				    	+ '				</td>'
				    	+	'</tr>'
				    	+	'<tr>'
				    	+	'	<td colspan=2>'
				    	+	'			<div id="'+this.opDivId+'" style="width:'+this.maxWidth+'px;height:'+(this.maxHeight-33)+'px;overflow:auto;  background:#FFF;">'
						+  '			</div>'
				    	+	'	</td>'
				    	+ '		<td style="width:10px;" >'
				    	+ '			<table width="10" height="100%" border="0" cellspacing="0" cellpadding="0">'
				    	+ '				<td></td>'
				    	+ '				</tr>'
				    	+ '			</table>'
				    	+ '		</td>'
				    	+	'</tr>'
				    	+ '		<tr style="width:100%;height:10px;">'
				    	+	'		<td colspan=3>'
				    	+ '				<table height="10px" width="100%" border="0" cellspacing="0" cellpadding="0">'
				    	+ '				</table>'
				    	+ '			</td>'
				    	+ '		</tr>'
			    	 	+ ' </table>'
						+ ' </div>' ;
	$jquery("#"+this.container).append(divHtml);
	//$jquery("#"+this.winId).draggable();
};
/**
 * @title: creatDivClocs带关闭按钮的 
 * @description:创建浮动窗口contextPath
 * @date：2014-10-26下午17:49:23
 */
FrameTools.FloatWin.prototype.creatDivClose = function(id){
	var divHtml ='<div style="width:'+this.maxWidth+'px; height:'+this.maxHeight+'px; filter:alpha(opacity='+(this.opacity*100)+');opacity: '+this.opacity+';   position:absolute; " '
					+'data-options="onDrag:function(e){FrameTools.FloatWin.onDrag(e,\''+this.winId+'\',\''+this.container+'\')},onStopDrag:function(e){FrameTools.FloatWin.onStopDrag(e,\''+this.winId+'\',\''+this.container+'\')} ,handle:\'#title\'" id="'+this.winId+'" >'
			    		+  '<table  id="floatTable" style="width:100%;height:100% " cellspacing="0" cellpadding="0" border=0 >'
			    		+	'<tr style=" width:100%;height:28px;" >'
				    	+	  '			<td id="title" valign=top style="padding-top:5px;background-image:url('+FrameTools.FloatWin.basePath+'copy1.png);width:'+(parseInt((this.maxWidth-35)/this.maxWidth*100))+'%;"><span style="padding-left:10px;color:#fff;font-size: 16px;font-weight: bold;">'+this.title+'</sapn></td>'
				    	+	  '			<td align="right" style="padding-right:8px;background-image:url('+FrameTools.FloatWin.basePath+'copy1.png);width:15px">'
				    	+		'			<img id="floatWin_zoomClose'+id+'" alt="关闭" style="cursor:hand;" src="'+FrameTools.FloatWin.basePath+'bt3-1.png" onclick="FrameTools.FloatWin.closeBut('+id+')" />'
				    	+				'</td>'
				    	+ '				<td style="width:10px;" >'
				    	+ '					<table width="10" height="100%" border="0" cellspacing="0" cellpadding="0">'
				    	+ '					</table>'
				    	+ '				</td>'
				    	+	'</tr>'
				    	+	'<tr>'
				    	+	'	<td colspan=2>'
				    	+	'			<div id="'+this.opDivId+'" style="width:'+this.maxWidth+'px;height:'+(this.maxHeight-33)+'px;overflow:auto;  background:#FFF;">'
						+  '			</div>'
				    	+	'	</td>'
				    	+ '		<td style="width:10px;" >'
				    	+ '			<table width="10" height="100%" border="0" cellspacing="0" cellpadding="0">'
				    	+ '				<td></td>'
				    	+ '				</tr>'
				    	+ '			</table>'
				    	+ '		</td>'
				    	+	'</tr>'
				    	+ '		<tr style="width:100%;height:10px;">'
				    	+	'		<td colspan=3>'
				    	+ '				<table height="10px" width="100%" border="0" cellspacing="0" cellpadding="0">'
				    	+ '				</table>'
				    	+ '			</td>'
				    	+ '		</tr>'
			    	 	+ ' </table>'
						+ ' </div>' ;
	$jquery("#"+this.container).append(divHtml);
	$jquery("#"+this.winId).draggable();
};
/**
 * @title: addWinList 
 * @description:将浮动框增加到浮动序列中
 * @author: Li_Zhenzhong@founder.com 
 * @param id
 * @param floatWin 
 * @date：2012-11-22下午12:39:20
 */
FrameTools.FloatWin.prototype.addWinList = function(id,floatWin){
	FrameTools.FloatWin.winList[id] = floatWin;
};

/**
 * @title: setFloatWinPosition 
 * @description:设置浮动框初始化位置
 * @author: Li_Zhenzhong@founder.com 
 * @param top
 * @param left 
 * @date：2012-11-22下午12:38:03
 */
FrameTools.FloatWin.prototype.setFloatWinPosition= function(top,left){
	$jquery("#"+this.winId).css("top",top);
	$jquery("#"+this.winId).css("left",left);
};
/**
 * @title: onMouseMove 
 * @description:切换图片
 * @author: Li_Zhenzhong@founder.com 
 * @param imgObj
 * @param imgName 
 * @date：2012-11-22下午2:55:01
 */
FrameTools.FloatWin.onMouseMove = function(imgObj,imgName){
		imgObj.src = FrameTools.FloatWin.basePath+imgName;
};
/**
 * @title: setOpHtml 
 * @description:设置浮动框操作框显示内容
 * @author: Li_Zhenzhong@founder.com 
 * @param html 
 * @date：2012-11-22下午2:44:47
 */
FrameTools.FloatWin.prototype.setOpHtml = function(html){
	$jquery("#"+this.opDivId).html(html);
};
/**
 * @title: onDrag 
 * @description:浮动框拖动时执行，限制拖出容器范围
 * @author: Li_Zhenzhong@founder.com 
 * @param e
 * @param winId
 * @param container 
 * @date：2012-11-22下午12:37:00
 */	
FrameTools.FloatWin.onDrag= function(e ,winId,container){  
    var d = e.data;  
    if (d.left < 0){d.left = 0;}  ;
    if (d.top < 0){d.top = 0;}  ;
    if (d.left + $jquery("#"+winId).width() > $jquery("#"+container).width()){  
        d.left = $jquery("#"+container).width() -  $jquery("#"+winId).width()-10;  
    }  
    if (d.top +  $jquery("#"+winId).height() > $jquery("#"+container).height()){  
        d.top = $jquery("#"+container).height() -  $jquery("#"+winId).height()-10;  
    }
};
/**
 * @title: onStopDrag 
 * @description:浮动框停止时计算位置，并作出调整
 * @author: Li_Zhenzhong@founder.com 
 * @param e
 * @param winId
 * @param container 
 * @date：2012-11-22下午12:36:14
 */
FrameTools.FloatWin.onStopDrag= function(e ,winId,container){
	  var d = e.data;  
	  if (d.left < 0){
	  	d.left = 0	;
	  }  
    if (d.top < 0){
    	d.top = 0;
    }  
    if (d.left + $jquery("#"+winId).width() > $jquery("#"+container).width()){  
        d.left = $jquery("#"+container).width() -  $jquery("#"+winId).width()-10;  
    }  
    if (d.top +  $jquery("#"+winId).height() > $jquery("#"+container).height()){  
        d.top = $jquery("#"+container).height() -  $jquery("#"+winId).height()-10;   
    }  
    $jquery("#"+winId).css("left",d.left);
    $jquery("#"+winId).css("top",d.top);
};

/**
 * @title: zoomFloatWin 
 * @description:浮动框最大化到容器中间
 * @author: Li_Zhenzhong@founder.com 
 * @param floatWin 
 * @date：2012-11-22下午12:38:59
 */
FrameTools.FloatWin.zoomFloatWin = function(floatWin){
		floatWin = typeof(floatWin) == "object" ? floatWin : FrameTools.FloatWin.winList[floatWin];  
		if($jquery("#"+floatWin.winId).width()==floatWin.maxWidth){
			return;
		}
	    $jquery("#"+floatWin.winId).animate({'left':floatWin.maxLeft,'top':floatWin.maxTop,'height':floatWin.maxHeight+10,'width':floatWin.maxWidth+10},500);
	    $jquery("#"+floatWin.opDivId).css("display","block");
	    $jquery("#floatWin_zoom"+floatWin.id).css("display","none");
	    $jquery("#floatWin_zoomOut"+floatWin.id).css("display","block");
	    floatWin.openFlag = true;
};
/**
 * @title: zoomOutFloatWin 
 * @description:浮动框最小化到容器右上角
 * @author: Li_Zhenzhong@founder.com 
 * @param floatWin 
 * @date：2012-11-22下午12:38:23
 */
FrameTools.FloatWin.zoomOutFloatWin = function(floatWin){
	floatWin = typeof(floatWin) == "object" ? floatWin : FrameTools.FloatWin.winList[floatWin];   
    $jquery("#"+floatWin.winId).animate({'left':floatWin.minLeft,'top':floatWin.minTop,'height':43,'width':floatWin.minWidth+10},500);
    setTimeout(function(){$jquery("#"+floatWin.opDivId).css("display","none");},300);
    $jquery("#floatWin_zoom"+floatWin.id).css("display","block");
    $jquery("#floatWin_zoomOut"+floatWin.id).css("display","none");
    floatWin.openFlag = false;
};
/**
 * @title: closeBut
 * @description:关闭按钮
 * @author: zhang_guoliang@founder.com 
 * @param floatWin 
 * @date：2014-10-25下午14:32:21
 */
FrameTools.FloatWin.closeBut = function(id){
	var winid = "Float_Win_"+id;
	$jquery("#"+winid).remove();
};
/**
 * @title: close 
 * @description:外部调用关闭
 * @author: zhang_guoliang@founder.com 
 * @param floatWin 
 * @date：2014-10-25下午14:32:21
 */
FrameTools.FloatWin.prototype.close = function(){
	$jquery("#"+this.winId).remove();
};