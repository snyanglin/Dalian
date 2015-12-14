/*!
 * 系统权限工具类
 * http://jquery.com/
 * znjg - v1.0.0 (2014-04-10 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 系统权限工具类
 * @author gb
 */
var SysPrivilege = {
		
		/**
		 * 模块
		 */
		ModuleArray : new Array(),
		
		/**
		 * 功能
		 */
		FunctionArray :  new Array(),
		
		/**
		 * 初始化权限
		 * @param funcJson
		 * @param callback
		 */
		init : function(funcJson,callback) {
			this.ModuleArray =  new Array();
			this.FunctionArray =  new Array();
			for(var i = 0; i < funcJson.length; i++) {
				var moduleName=funcJson[i]["moduleName"];
				var functionName=funcJson[i]["function"]["name"];
				this.FunctionArray[i] =functionName;
				var isExistModule = false;
				for(var j = 0; j < this.ModuleArray.length; j++) {
					if(this.ModuleArray[j] == moduleName) {
						isExistModule = true;
						break;
					}
				}
				if(!isExistModule) {
					this.ModuleArray[this.ModuleArray.length] = moduleName;
				}
			}
			callback();
			//this.dealWithModule();
			//this.dealWithFunction();
		},
		
		/**
		 * 检查是否具有某模块权限
		 * @param moduleName 模块名称
		 * @returns {Boolean}
		 */
		isHaveModule : function(moduleName) {
			var isHave = false;
			for(var i = 0; i< this.ModuleArray.length; i++) {
				if(this.ModuleArray[i] == moduleName) {
					isHave = true;
					break;
				}
			}
			return isHave;
		},
		
		/**
		 * 检查是否具有某功能权限
		 * @param functionName 功能名称
		 * @returns {Boolean}
		 */
		isHaveFunction : function(functionName) {
			var isHave = false;
			for(var i = 0; i< this.FunctionArray.length; i++) {
				if(this.FunctionArray[i] == functionName) {
					isHave = true;
					break;
				}
			}
			return isHave;
		},
		
		/**
		 * 处理模块权限
		 */
		dealWithModule : function() {
			$("[id^='module']").each(function(){
				var id = $(this).attr('id');
				var idArray = id.split("_");
				if(SysPrivilege.isHaveModule(idArray[1])) {
					$("#"+id).css("display","block");
				}
			});
		},
		
		/**
		 * 处理功能权限
		 */
		dealWithFunction : function() {
			$("[id^='function']").each(function(){
				var id = $(this).attr('id');
				var idArray = id.split("_");
				if(SysPrivilege.isHaveFunction(idArray[1])) {
					$("#"+id).css("display","block");
				}
			});
		}
		
};