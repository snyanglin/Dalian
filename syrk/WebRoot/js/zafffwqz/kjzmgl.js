/**
 * @Author:       [wu.w@founder.com.cn]
 * @CreateDate:   [2015-5-15 上午8:51:54]
  * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
/*
 * execute when page load success 
 */
$(document).ready(function(){
	$("#sfzh").focus();
});

/*
 * query person info by sfz  in zyks
 */
function query(){
	if (!$("#sfzh").validatebox("isValid")) {
		$("#sfzh").focus();
		return;
	}
	var sfz=$("#sfzh").val();
	var zyks="";
	$("input[name='zyk']:checked").each(function(i,e){
		zyks+=e.value+'#';
	});
	if(zyks==""){
		alert("请至少选择一个资源库！");
		return;
	}else{
		zyks=zyks.substring(0, zyks.length-1);
	}
	$('#resTB').hide();
	$('#querying').show();
	$.ajax({
		url:basePath+'fwqzkjzmgl/bdcx',
		type:'post',
		dataType:'json',
		data:{
			'sfz':sfz,
			'zyks':zyks
		},
		success:function(res){
			for(var i=1;i<5;i++){
				$('#zykRes'+i).html("");
			}
			$('#resSfz').text(sfz);
			for(var i=0,zyk=zyks.split("#");i<zyk.length;i++){
				$('#zykRes'+zyk[i]).html(getZykRes(zyk[i],res[zyk[i]],sfz));
			}
			$('#querying').hide();
			$('#resTB').show();
		}
	});
}

/*
 * zyk constant array
 */
var ZYK_NAME_CONSTANT=["","全国违法犯罪人员库","吸毒人员库","重点人员库","全国在逃人员库"];
		
/*
 * 处理查询结果
 * zyk  zykIndex
 * res[] index: 0:0 fail/1 success;1:name;2:hjd
 * sfz  sfz
 * return result context
 */
function getZykRes(zyk,res,sfz){
	var html="";
	var name=ZYK_NAME_CONSTANT[parseInt(zyk)];
	html+="<table style='width: 600px;'><tr style='height: 20px;background-color: #eeffee'><td colspan='4'>"+name+"：</td></tr>";
	if(res[0]=="0"){
		html+="<tr><td colspan='4'>无</td></tr>";
	}else{
		html+="<tr style='height: 20px;background-color: #eeffee'>";
		html+="<td align='center'>姓名</td><td align='center'>身份证号</td><td align='center'>户籍地</td><td></td></tr>";
		html+="<tr><td align='center'>"+res[1];
		html+="</td><td align='center'><a onclick='openSyrkXq(\""+sfz+"\")' style='cursor:hand'>"+sfz+"</a>";
		html+="</td><td align='center'>"+res[2];
		html+="</td><td align='center'><a onclick='openSyrkXq(\""+sfz+"\")' style='cursor:hand'>更多详情</a></td></tr>";
	}
	html+="</table>";
	return html;
}

/*
 * 根据身份证查询实有人口信息
 * sfz sfz
 * open syrk win
 */
function openSyrkXq(sfz){
	$.ajax({
		url:basePath+'fwqzkjzmgl/queryRyBySfz',
		type:'post',
		dataType:'json',
		data:{'sfz':sfz},
		success:function(res){
			if(res.exist=='1'){
			    cancelBubble(); 
				var editUrl = "/syrkEdit/"+res.ryid+"/"+res.syrkid+"/view?mode=view";
				menu_open("详细信息",editUrl);
				
			}else{
				alert("无相关信息！");
			}
		}
	});
};