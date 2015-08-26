Index = {};
/**
 * 初始化导航菜单状态
 * index：当前选中模块序号
 */
var menuindex = 0;
Index.setMenuIndex = function(index){
		menuindex=index;
}
/**
 * @method:openPage
 * @package:syrk/js/qbld	
 * @description:根据模块id进行页面跳转
 * @param name
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午11:26:37
 */
Index.openPage = function(name){
	switch(name){
	case 1: $("#modulePageIframe").attr("src",basePath+"forward/qbld|yjxx");break;
	case 2: $("#modulePageIframe").attr("src",basePath+"forward/qbld|lksq");break;
	case 3: $("#modulePageIframe").attr("src",basePath+"forward/qbld|xscj");break;
	case 4: $("#modulePageIframe").attr("src",basePath+"forward/qbld|zdrxs");break;
	default:alert("功能地址配置错误,请联系系统管理员！");
	}
};