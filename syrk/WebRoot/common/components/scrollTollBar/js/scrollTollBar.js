/*!
 * 滑动工具条
 * 
 * znjg - v1.0.0 (2014-03-18 11:30)
 * Copyright(c) 2014 founder
 */
/*
 * 以下为加载使用方法滑动条$(id).jscrollbar({})可配置的参数
 * @param {Object} [options] 配置参数
 * @param {String} [options._color='black'] 滚动条的颜色
 * @param {Number} [options.width=12] 滚动条的宽度
 * @param {Number} [options.opacity=0.6] 滚动条的透明度(0~1)
 * @param {Number} [options.borderRadius=6] 滚动条圆角大小
 * @param {String} [options.position='outer'] 滚动条显示位置outer/inner
 * @param {String} [options.showXBar=true] 是否显示水平滚动条
 * @param {String} [options.showYBar=true] 是否显示垂直滚动条
 * @param {String} [options.keyControl=true] 是否接受键盘按键(上下左右键)控制
 * @param {String} [options.keyMoveAmount=30] 键盘控制每次移动的距离(单位:px)
 * @param {String} [options.mouseScrollDirection='vertical'] 鼠标滚动时控制的滚动方向(上下滚动或者左右滚动)'vertical'上下滚动 | 'horizontal'左右滚动
 * @param {String} [options.mouseMoveAmount=30] 鼠标滚动时每次移动的距离(单位:px)
 */

//加载滑动条相关JS
SysTool.loadComponentsFile("scrollTollBar", ["jquery.mousewheel.min","jquery.jscrollbar-1.0.2.src","jquery.jqdrag-1.0.min"], ".js");

/**
 * @classDescription 全局配置信息
 * @author yangyongfei
 */
var ScrollTollBar = {
		
		/**
		 * 加载使用滑动条,默认滑动条
		 * @param id 需要使用滑动条的元素的id
		 */
		addScrollBarDefault : function(id)
		 {
			$('#'+id).jscrollbar({});
		 },
		 
		 /**
		  * 加载使用滑动条,自定义样式
		  * @param id 需要使用滑动条的元素的id
		  * @param color 颜色
		  * @param width 宽度
		  * @param opacity 透明度
		  * @param position 滑动条显示位置。outer、inner
		  */
		 addScrollBarDustom1 : function(id, color, width, opacity, position)
		 {
			 $('#'+id).jscrollbar({
				 width : width,
				 color : color,
				 opacity : opacity,
				 position : position
			 });
		 },
		 
		 /**
		  * 加载使用滑动条,自定义样式
		  * @param id 需要使用滑动条的元素的id
		  * @param color 颜色
		  * @param width 宽度
		  */
		 addScrollBarDustom2 : function(id, color, width)
		 {
			 $('#'+id).jscrollbar({
				 width : width,
				 color : color,
				 opacity : 0.7,
				 position : 'inner'
			 });
		 }
};
