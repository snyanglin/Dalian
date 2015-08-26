/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	//设置默认语言
	config.language = 'zh-cn';
	config.defaultLanguage = 'zh-cn';
	//设置编辑器宽和高
	config.width = 'auto';
	config.height = '200';
	//设置编辑器的样式：'kama'（默认）、'office2003'、'v2'
	config.skin = 'moono';
	//工具栏是否可以被收缩
	config.toolbarCanCollapse = true;
	//工具栏的位置，可选：bottom
	config.toolbarLocation = 'top';
	//设置我的工具栏
	config.toolbar_full = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source', '-', 'Save', 'NewPage', 'Preview', 'Print', '-', 'Templates' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
		{ name: 'forms', items: [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl', 'Language' ] },
		{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
		{ name: 'insert', items: [ 'Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak', 'Iframe' ] },
		'/',
		{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		{ name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] },
		{ name: 'others', items: [ '-' ] },
		{ name: 'about', items: [ 'About' ] }
	];

	config.toolbar = 'mytoolbar';
	config.toolbar_mytoolbar = [
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
		{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
		{ name: 'insert', items: [ 'Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak', 'Iframe' ] },
		{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		{ name: 'tools', items: [ 'Maximize', 'Source', 'Preview', 'Print' ] }
	];

	config.toolbar_basic = [
		['Source', 'Maximize', 'Undo','Redo','-'],
		['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		['Link','Unlink'],
		['Image'],
		['Format','Font','FontSize']
	];


	//设置字体栏可选择的字体
	config.font_names = 'Arial;Times New Roman;Verdana;YaHei Consolas Hybird;Courier New;宋体;黑体;微软雅黑';
	//设置默认的字体
	config.font_defaultLabel ='宋体';
	//设置字体大小栏可显示的大小
	config.fontSize_sizes = '10/10px;12/12px;14/14px;16/16px;18/18px;20/20px;24/24px;28/28px';
	//设置默认的字体大小
	config.fontSize_defaultLabel = '14px';
	//设置按回车键时插入什么标签，有CKEDITOR.ENTER_BR、CKEDITOR.ENTER_DIV、CKEDITOR.ENTER_P
	//推荐是P，不推荐BR，config.shiftEnterMode默认是BR
	//config.enterMode = CKEDITOR.ENTER_BR;
	//是否要将编辑器中的内容作为一个完整的HTML页面输出，即自动添加<html>，<head>和<body>标记，默认为false
	//config.fullPage =true;
	//设置缩进风格，默认是px
	config.indentUnit ='em';
	//设置缩进的步长，默认是40，
	config.indentOffset = 2;
	//设置编辑器启动时的编辑模式， "wysiwyg"或者"source"，默认是wysiwyg
	//config.startupMode ='source';
	//设置每个Tab键的空格数，默认为0，即不是插入空格，而是在各功能间切换
	config.tabSpaces = 4;
	//是否强制复制来的内容去除格式 plugins/pastetext/plugin.js
	//config.forcePasteAsPlainText =false
};
