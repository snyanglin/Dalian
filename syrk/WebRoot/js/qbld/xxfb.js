Xxfb = {};

Xxfb.fldm;//用于查询更多信息时的分类条件
/**
 * @method:queryXxfbLx
 * @package:syrk/js/qbld	
 * @description:查询所有需要显示的信息分类
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午10:53:06
 */

Xxfb.queryXxfbLx = function(){
	var url = contextPath+'/xxfb/queryClassList';
	var fajax = new FrameTools.Ajax(url,Xxfb.queryXxfbLx_back);
	fajax.send();
};
/**
 * @method:queryXxfbLx_back
 * @package:syrk/js/qbld	
 * @description:显示所有分类模块
 * @param rsJson
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午10:53:25
 */
Xxfb.queryXxfbLx_back = function(rsJson){
	rsJson = rsJson.rows;
	var num = rsJson.length;
	for(var i = 0 ; i < num ;i++){
		var obj = rsJson[i];
		$("#xxfbUl").append(Xxfb.createTypeLi(obj.flmc,obj.fldm));
		Xxfb.queryXxfbList(obj.fldm);
	}
};
/**
 * @method:createTypeLi
 * @package:syrk/js/qbld	
 * @description:创建分类显示模块
 * @param flmc
 * @param fldm
 * @returns
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午10:46:11
 */
Xxfb.createTypeLi = function(flmc,fldm){
	var  li = document.createElement('li');
	$(li).addClass("xxflModuleLi");
	var  div = document.createElement('div');
	$(div).addClass("flTitleDiv");
	var  div1 = document.createElement('div');
	$(div1).addClass("flDiv");
	var  tn = document.createTextNode(flmc);
	div1.appendChild(tn);
	var  div2 = document.createElement('div');
	$(div2).addClass("moreDiv");
	div2.onclick=function(){Xxfb.showMoreXxWindow(fldm,flmc)};
	var  tn1 = document.createTextNode("更多");
	$(tn1).addClass("moreText");
	div2.appendChild(tn1);
	div.appendChild(div1);
	div.appendChild(div2);
	
	var  ul = document.createElement('ul');
	$(ul).addClass("listUl");
	ul.id="ul"+fldm;
	li.appendChild(div);
	li.appendChild(ul);
    return li;
};
/**
 * @method:queryXxfbList
 * @package:syrk/js/qbld
 * @description:查询分类信息列表
 * @param fldm
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午10:50:36
 */
Xxfb.queryXxfbList = function(fldm){
	var url = contextPath+'/xxfb/queryArticleListFive';
	var fajax = new FrameTools.Ajax(url,Xxfb.queryXxfbList_back);
	fajax.send({"subject":fldm});
}
/**
 * @method:queryXxfbList_back
 * @package:syrk/js/qbld
 * @description:显示分类信息列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午10:50:19
 */
Xxfb.queryXxfbList_back = function(rsJson){
	rsJson = rsJson.rows;
	var num = rsJson.length;
	for(var i = 0 ; i < num ;i++){
		var obj = rsJson[i];
		var title=obj.title;
		/**
		 *标题长度过长截取10个字符显示
		 */
		var length=$("#ul"+obj.subject).width()/25;
		
		if(title.length>length)
			title = title.substring(0,length)+"..."
		createtime = obj.createtime.substring(0,4)+"-"+obj.createtime.substring(4,6)+"-"+obj.createtime.substring(6,8);
		$("#ul"+obj.subject).append(Xxfb.createTitleLi(title,createtime,obj.objectid));
	}
}
/**
 * @method:createTitleLi
 * @package:syrk/js/qbld
 * @description:生成单条信息列表
 * @param title
 * @param time
 * @param id
 * @returns
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午10:35:37
 */
Xxfb.createTitleLi = function(title,time,id){
	var  li = document.createElement('li');
	$(li).addClass("listLi");
	var  div1 = document.createElement('div');
	$(div1).addClass("titleDiv");
	div1.onclick=function(){Xxfb.openXxInfoWindow(id)};
	var  tn1 = document.createTextNode(title);
	div1.appendChild(tn1);
	li.appendChild(div1);
	var  div2 = document.createElement('div');
	$(div2).addClass("timeDiv");
	var  tn2 = document.createTextNode(time);
	div2.appendChild(tn2);
	li.appendChild(div2);
	
	return li;
}
/**
 * @method:openXxInfoWionw
 * @package:syrk/js/qbld	
 * @description:显示发布信息内容
 * @param id
 * @author:Li_Zhenzhong
 * @date:2015-6-25下午5:00:00
 */
Xxfb.openXxInfoWindow = function(id){
	window.open("qbld|xxfbPage?id="+id);
}
/**
 * @method:showMoreXxWindow
 * @package:syrk/js/qbld	
 * @description:显示更多分类信息查询窗口
 * @param fldm
 * @author:Li_Zhenzhong
 * @date:2015-6-26上午9:10:30
 */
Xxfb.showMoreXxWindow = function(fldm,flmc){
	Xxfb.fldm=fldm;
	$("#flmcTd").html(flmc);
	$('#win').window('open');
}
/**
 * @method:queryMoreXx
 * @package:syrk/js/qbld	
 * @description:查询更多信息
 * @author:Li_Zhenzhong
 * @date:2015-6-26上午9:10:56
 */
Xxfb.queryMoreXx = function(){
	$('#infoGrid').datagrid('load', { 
		fldm:Xxfb.fldm,
		title: $('#where_title').val(),    
	    createtimeB: $('#where_createtimeB').val(),
	    createtimeE: $('#where_createtimeE').val()
	});  
}

