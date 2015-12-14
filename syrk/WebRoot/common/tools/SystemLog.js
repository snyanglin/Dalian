/*!
 * 系统操作服务
 * znjg - v1.0.0 (2014-03-12 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 系统操作服务
 * @author yangyongfei
 */
var SystemLog = {
		
		/**
		 * 添加系统日志
		 * @param {String} functionName 功能名称
		 *  @param {String} optionType 操作类型
		 *  @param {String} optionData 操作描述
		 */
		addSystemLog : function(functionName, optionType, optionData)
		{
			var data = {'functionName':functionName,'optionType':optionType,'optionData':optionData};
			var param = {'url':'systemController.f','data':data};
			SysTool.ajax(param, null);
		},

	/**
	 * @classDescription 系统操作类别
	 * @author yangyongfei
	 */
	 optionType : {
			LOAD : 0,//登录
			EXIT : 1,//退出系统
			ADD  : 2,//添加
			DELETE : 3,//删除
			UPDATE : 4,//修改
			QUERY  : 5,//查询
			LOCATION : 6,//地图定位
			OTHER : 9//其他
	}
};

