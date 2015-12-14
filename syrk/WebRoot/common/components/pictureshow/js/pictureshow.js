/*!
 * 左侧layout组件
 * znjg - v1.0.0 (2014-04-16 16:30)
 * Copyright(c) 2014 founder
 */


var PicShow = {
		
		defaulImgSrc : "common/components/pictureshow/img/notfound.png",
		
		/**
		 * 初始化
		 * @param srcStr 图片地址，多个地址以英文“;”分隔
		 * @param titleStr 图片标题，多个地址以英文“;”分隔,并与地址对应
		 */
		initFun : function(srcStr, titleStr){
			var srcArray = srcStr.split(";");
			var titleArray = null;
			if (undefined != titleStr && "" == $.trim(titleStr))
			{
				titleArray = titleStr.split(";");
			}
			var imgHtml = "";
			for (var i = 0; i < srcArray.length; i++)
			{
				var src = srcArray[i];
				if ('' != $.trim(src))
				{
					imgHtml = imgHtml
					+ '<img src="' + srcArray[i] + '" '
					+ 'title="' + (null != titleArray ? titleArray[i] : "") + '" />';
				}
			}
			$("#galleria").html(" ");
			$("#galleria").html(imgHtml);
			
		    Galleria.loadTheme('common/components/pictureshow/js/galleria.classic.min.js');

		    Galleria.run('#galleria');
		}
};