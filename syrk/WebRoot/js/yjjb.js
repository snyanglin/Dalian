function NSopenWindow(isCache, windowID, parentWindow, paramArray, dataOptions, submitConfirm, onSubmitSuccess, oldPageObject) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	if (!dataOptions.title) {
		dataOptions.title = '';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		var myTime = (new Date()).getTime();
		windowID = "win_" + myTime;
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	dataOptions.buttons = [
		{
			text: '保存',
			iconCls: 'icon-save',
			handler: function() {
				var bottonObject = this;
				if (buttonDisabled(bottonObject) == false) {
					return false;
				}
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form').first();
				if (formObject) {
					checkComboIsClosed(iframeObject, formObject); // 提交之前强行校验下拉框的是否关闭
					if (formObject.form('validate')) { // 表单的验证
						if (iframeObject.beforeSubmit && typeof(iframeObject.beforeSubmit) == 'function') { // 执行自定义方法beforeSubmit
							if (iframeObject.beforeSubmit() == false) {
								buttonEnabled(bottonObject);
								return false;
							}
							else {
								if (submitConfirm) {
									topMessager.confirm('', submitConfirm, function(r) {
										if (r) {
											var submitData = iframeObject.getFormData(formObject[0]);
											try {
												var parentWinObject = parentWindow;
												if (parentWinObject.contentWindow) {
													parentWinObject = parentWinObject.contentWindow;
												}
												eval("parentWinObject." + onSubmitSuccess + "(oldPageObject, submitData)");
												buttonEnabled(bottonObject);
												topMessagerShow(null,"保存成功");
												$('#' + windowID).dialog('close');
											}
											catch (err) {
												$.messager.alert('页面错误', "执行事件 "+ onSubmitSuccess + " 有错误发生：<br/><br/>错误名称: " + err.name + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误行号:" + (err.number & 0xFFFF ) + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误信息:" + err.message, 'error'); 
											}
										}
										else {
											buttonEnabled(bottonObject);
										}
									}); 
								}
								else {
									formObject.form('submit',{
										dataType : 'json',
										onSubmit: function() {
										},
										success: function(result) {
											buttonEnabled(bottonObject);
											if (result && result.indexOf('serverError="500"') != -1) { // 服务端跳转到500页面
												if (iframeObject.isUploadFilePage && iframeObject.isUploadFilePage == "1") {
													$.messager.alert('系统信息', '上传文件失败！<br/><br/>可能超过最大上传文件大小限制！', 'error');
												}
												else {
													$.messager.alert('系统信息', '保存数据失败！<br/><br/>服务端出现致命错误！', 'error');
												}
												return;
											}
											result = parseReturn(result);
											var isDoSubmitResult = true;
											if (result.status == 'success') { // 返回成功后执行的方法
												if (iframeObject.afterSubmit && typeof(iframeObject.afterSubmit) == 'function') { // 执行自定义方法afterSubmit
													iframeObject.afterSubmit(result);
												}
												if (onSubmitSuccess != null && onSubmitSuccess != "") {
													var submitData = iframeObject.getFormData(formObject[0]);
													for (var item in result) {
														submitData[item] = result[item];
													}
													try {
														var parentWinObject = parentWindow;
														if (parentWinObject.contentWindow) {
															parentWinObject = parentWinObject.contentWindow;
														}
														eval("parentWinObject." + onSubmitSuccess + "(oldPageObject, submitData)");
													}
													catch (err) {
														$.messager.alert('页面错误', "执行事件 "+ onSubmitSuccess + " 有错误发生：<br/><br/>错误名称: " + err.name + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误行号:" + (err.number & 0xFFFF ) + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误信息:" + err.message, 'error'); 
													}
												}
												if (iframeObject.successCloseWindow && typeof(iframeObject.successCloseWindow) == 'function') { // 执行自定义方法successCloseWindow，返回true关闭窗口
													if (!iframeObject.successCloseWindow(result)) {
														doSubmitResult(result, null, null);
														return;
													}
												}
											}
											if (isDoSubmitResult) {
												doSubmitResult(result, windowID, null);
											}
										}
									});
								}
							}
						}	
					}
					else {
						buttonEnabled(bottonObject);
						if (iframeObject.validateError && typeof(iframeObject.validateError) == 'function') { // 执行自定义方法validateError，验校错误时执行
							iframeObject.validateError();
						}
					}
				}
			}
		},
		{
			text: '关闭',
			iconCls: 'icon-cancel',
			handler: function() {
				$('#' + windowID).dialog('close');
			}
		}
	];
	openWindow(isCache, windowID, dataOptions.url, paramArray, dataOptions);
}