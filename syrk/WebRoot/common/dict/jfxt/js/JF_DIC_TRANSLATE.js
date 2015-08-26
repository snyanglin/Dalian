//技防系统代码翻译,可用于简单字典的页面翻译
var JFXT={
		//获得应用属性(多值)
		getAppProperty:function (code){			
			var codeArray=code.split(',');
			var meaningString="";
			for(var i=0;i<codeArray.length;i++){
				meaningString+=AppProperty[codeArray[i]]+",";		
			}	
			return meaningString.substring(0,meaningString.length-1);
		},//获得点位区域
		getArea:function (code){			
			return Area[code];
		},//获得行业类别
		getIndustry:function (code){			
			return Industry[code];
		},
		getResolution:function (code){
			////获得分别率
			return Resolution[code];
		},//获得是否夜视
		getSight:function (code){
			return Sight[code];
		},//简单代码
		getSimpleDictionary:function (code){
			return SimpleDictionary[code];
		}		
};








