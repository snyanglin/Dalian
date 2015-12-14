function dictTranslate(value, row, index){
	var options=$(this);
	var theDictName=options[0].dictName;
	//var result=getMeaningByCode(theDictName,value);
	var result=getMeaningByCode2(theDictName,value);
	return result;//'汉族';
	
}

/////////////////

//代码翻译
function getMeaningByCode2(dictUrl,code) {
	//alert(dictUrl+","+code);
	var meaning="ABC";

    $.ajax({
        url:dictUrl,        
        cache : false, 
        async : false,//异步
        type : "GET",
        dataType : 'json',
        success : function(data){
           	//alert(data.length);
			for(var i=0;i<data.length;i++){
				var item=data[i];
				if(item.id==code){
					meaning=item.text;
					//alert(item.id+"==>"+item.text);
					break;
				}
				else if (item.children) {//有子节点
					meaning=searchChildren(item.children,code);
					if(meaning!=""){
						break;
					}
				}				
			}//end for
        }
    });
	
	return meaning;

}


function searchChildren(node, searchID) {
	var meaning="";
	for (var i = 0; i < node.length; i++) {
		if (node[i].id == searchID) {
			meaning=node[i].text;
			break ;
		}
		else if (node[i].children) {
			if((result=searchChildren(node[i].children, searchID))!="")
				break;
		}
	}//end for
	return meaning;
}
//同步请求并返回一个String对象
function getResponseByParameter(urlRequest,params) {
	var meaning="999";
    $.ajax({
        url:urlRequest, 
        data:params,
        cache : false, 
        async : false,//异步
        type : "POST",
        dataType : 'json',
        success : function(data){
           	//alert(data);
        	meaning=data;
        },
        error:function(e){
        	alert(urlRequest);;
        }
    });
	
	return meaning;

}