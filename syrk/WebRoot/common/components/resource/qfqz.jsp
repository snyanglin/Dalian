<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html >
	<head>
		<base href="<%=basePath%>">
		<title>辖区概况</title>

		<style type="text/css">
			.searchText {
			   font-size: 13px;
			   font-color: #222222;
			   height: 32px;
			   border: 1px solid #95B8E7;
			   line-height：32px;
			   padding-left: 5px;
			   padding-top: 8px;
			   width:200px;
			}
			.searchIcon {
				width:28px;
				height:28px;
		   		background: url('<%=path%>/images/search_btn_sousuo_01.png') no-repeat center;
		   		cursor: pointer;
			}
			.imgStyle{
				height:19px;
				width:19px;
			}
			.datagrid-header {
				position:absolute;
				visibility:hidden;
			}
		</style>
		
	</head>

	<body>
	
		<div id="scroll_main_gps">
			<div id="scroll_content_gps">
				<div class="rtcontpadding">
					<div id="reason" >
						<div class="input_selectbg" id="ssjl_zzjg">
							<input type="hidden" id="ssjl_gpszzjg_dm" />
							<input type="text" id="ssjl_gpszzjg_mc"
								class="zzjg_slect input_select" style="width: 225px;" onExit="selectedChange($('#ssjl_gpszzjg_dm').val())"/>
							<div class="clear" id="ssjl_gpszzjg_data_Div"></div>
						</div>
					
						<div id="bbtjgrid" class="easyui-datagrid" style="height:auto;z-index: 1" ></div>
					
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			var orgCode = "${userSession.userOrgCode}";
		
			qfqz.init(orgCode);
			
			$(document).ready(function() {
			
				ScrollBarTool.init("scroll_main_gps", "scroll_content_gps", 0,
						true);
				$(window).resize(
						ScrollBarTool.debounce(function() {
							ScrollBarTool.init("scroll_main_gps",
									"scroll_content_gps", 0, true);
						}, 500));
				
				var tableHeight = $(window).height() - $("#ssjl_zzjg").height() - 15;
				$("#bbtjgrid").css({height:tableHeight});
				
				var rowView = $.extend({},$.fn.datagrid.defaults.view,{
					renderRow:function(target,fields,frozen,rowIndex,rowData){
						var imgSrc = qfqz.qfqz_img[rowIndex];
						var cc = [];
						cc.push('<td colspan=' + fields.length + ' style="width:220px;padding:5px;border:0;">');
						if(!frozen){
							var ffzzxsdm = getDictName(path+'/common/dict/D_ZAFF_ZZXS.js',rowData.ffzzxsdm);
							var zzlbdm = getDictName(path+'/common/dict/BD_D_ZZLB.js',rowData.zzlbdm);
							
							cc.push('<div style="float:left;height:auto"> <img src="'+imgSrc+'"> </div>');
							cc.push('<div style="float:left;height:auto;"> ');
							cc.push('<span style="font-size: 16px;">'+rowData.zzmc+'</span>');
							cc.push('<br><span>类型：'+zzlbdm+'</span>');
							cc.push('<br><span>组织形式：'+ffzzxsdm+'</span>');
							cc.push('<br><span>联系方式：'+rowData.zzlxfs+'</span>');
							cc.push(' </div>');
							cc.push('<div style="float:right;height:auto;> ');
							cc.push(' <a href="#" onclick="showRfxx('+rowIndex+')" style="color:blue;text-decoration:underline">详情</a>');
							cc.push(' </div>');
						}
						cc.push(' </td>');
						return cc.join('');
					}
				});
				
				$('#bbtjgrid').datagrid({
					fit: false, 
					singleSelect : true,
					rownumbers : false,
					fitColumns : true,
					nowrap : true,
					border : false,
					idField:'id',
					showFooter:true,
					pageSize:6,
					pageList:[6],
					pagination : true,
					remoteSort:true,
					queryParams : {rows:6,lrrbmid:orgCode},
					url : '/syrk/rfxxb/getQfqz',
					columns : [ [ 
					{
						field : 'zzmc',
						title : '组织名称',
						width : 100,
						sortable : true,
						align : 'center' 
					}, {
						field : 'zzlbdm',
						title : '组织类别代码',
						width : 100,
						align: 'left',
						halign:'center'
					}, {
						field : 'zzlxfs',
						title : '联系方式',
						width : 100,
						align: 'left',
						halign:'center'
					} , {
						field : 'ffzzxsdm',
						title : '组织防范形式',
						width : 100,
						align: 'left',
						halign:'center',
						formatter:dictFormatter,
						dictName:path+'/common/dict/D_ZAFF_ZZXS.js'
					} ] ],
					onLoadSuccess:function(data){
						if(!data.rows){
							return;
						}
						qfqz.loadXlqy(data.rows);
					},
					view:rowView,
					onClickRow:onClickRow
				});
				
				function getDictName(dictPath,value){
					return window.top.getDictName(dictPath, value);
				}
				
				function onClickRow(rowIndex, data){
					try {
						qfqz.centerToXlqy(data.xlqy);
					} catch (e) {}
				}
				
			});
			
			function showRfxx(rowIndex){
				var rowData = $('#bbtjgrid').datagrid('getData').rows[rowIndex];
				var editUrl = "/rfxxb/queryRfxxInfo?id="+rowData.id;
				menu_open("人防信息查看",editUrl);
			}
			
			function selectedChange(value){
				//缓存组织机构信息
				qfqz.setChageOrgCode(value);
				//将地图对正到所选区域的中心
				qfqz.centerToXq(value);
				//读取列表数据
				$('#bbtjgrid').datagrid('load', {    
				    rows:3,lrrbmid: value
				});  
			}
		</script>
		
	</body>
	
	
</html>
