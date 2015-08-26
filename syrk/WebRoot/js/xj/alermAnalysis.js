var alermAnalysis_legendFunc=null;

var alermAnalysis_getHotPic=function(){
	var str = basePath+"alermAnalyse_getHotPic?BBOX=EZBOX&WIDTH=EZWIDTH&ALPHA=40&MINS=0.0000019073486328125";
	if (alermAnalysis_legendFunc != null) {
		alermAnalysis_legendFunc.close();
	}
	alermAnalysis_legendFunc = new LegendFunc();
	alermAnalysis_legendFunc.format = str;
	alermAnalysis_legendFunc.open();
};

var alermAnalysis_close=function(){
	if (alermAnalysis_legendFunc != null) {
		alermAnalysis_legendFunc.close();
		alermAnalysis_legendFunc=null;
	}
};

var alermAnalysis_ajaxLoading=function(){
	$('<div class="datagrid-mask"></div>').css({
		display:'block',
		width:'100%',
		zIndex:50,
		height:'100%'
	}).appendTo('body');
	$('<div class="datagrid-mask-msg"></div>').html('正在处理，请稍候...').appendTo('body').css({
		display:'block',
		left:($(document.body).outerWidth(true)-190)/2,
		top:($('.datagrid-mask').height()-45)/2
	});
};

var alermAnalysis_ajaxLoadEnd=function(){
	$('.datagrid-mask').remove();
	$('.datagrid-mask-msg').remove();
};