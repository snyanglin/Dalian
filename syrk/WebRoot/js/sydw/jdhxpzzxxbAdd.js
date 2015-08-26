var _p ;
function doInit(paramArray) {
	_p = paramArray["_p"];
}
function beforeSubmit() {
	var ifExist = false;
	var flag =document.getElementById("flag").value;
	if(flag=="add"){
	$.ajax({
		type:"POST",
		url:contextPath+"/sydwgl/checkIfExistByCol",
		async:false,
		dataType:"json",
		data:{colMap:'{\'tableName\':\'dw_jdhxpzzb\',\'colList\':[{\'colName\':\'ajz\',\'colValue\':\''+$('#ajz').val()+'\'},{\'colName\':\'xt_zxbz\',\'colValue\':\'0\'}]}'},
		success:function(data){
			if (data && data.count > 0) {
				$.messager.alert("提示","安监颁发证件号已存在,请重新输入","",
				function(){
					$('#ajz').val('');
					$('#ajz').focus();
				});
				ifExist = true;
			}
		}
	});
	}else {
		
	}
	if(ifExist){
		return false;
	}else {
		return true;
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	$(_p).find("input[name='id']").val($("#pk").val());
	setFormDataToSpan($("body"),_p);
	window.parent.location.reload();
}


function setFormDataToSpan(containObject,_p) {
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text(comboText);
			}
		}
	});
	var textareaSelector = containObject.find('textarea');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = $(_p).find("span[name='"+_name+"']");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}