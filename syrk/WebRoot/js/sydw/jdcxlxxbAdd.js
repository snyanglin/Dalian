//@updateAuthor: [star]
var _p;
function doInit(paramArray) {
	document.getElementById("dwmc").value = paramArray["dwmc"];
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		$("#sflsddm").combobox("setValue","0");
	}else {
		var ba=$("#sfbadm").combobox("getText");
		if(ba=="是"){
			setInputReadonly('ba_dwmc',false);
		}else {
			setInputReadonly('ba_dwmc',true);
			$("#ba_dwmc").val("");
		}
	}
	
	_p = paramArray["_p"];
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}

	$(_p).find("input[name='id']").val($("#pk").val());
	setFormDataToSpan($("body"),_p);
}
//是否备案
function sfba(){
	var ba=$("#sfbadm").combobox("getText");
	if(ba=="是"){
		setInputReadonly("ba_dwmc",false);
	}else {
		setInputReadonly("ba_dwmc",true);
		$("#ba_dwmc").val("");
	}
}
//刷新主页面显示内容
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