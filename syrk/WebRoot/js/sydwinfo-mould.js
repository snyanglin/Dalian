var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";
//单位人员信息
function info_dwryxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwfrfzrllyxxb' level='2'><li class='uline' ><span>法人/负责人/联络员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwfrfzrllyxxb' /><input type='hidden' name='openUrl' value='/dwfrfzrllyxxb/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};
//从业人员（dg 大类）
function info_cyryxxb_(){
	var sb = new StringBuffer();
	sb.append("<div style='height:290px;width:718px;'>");
	sb.append("<ul><input type='hidden' name='callback' value='info_cyryxxb_back' /><input type='hidden' name='dg' value='true' /></ul>");
	sb.append("<table id='cyry_datagrid'   border='0' style='height:200px;'>");
	sb.append("</table>");
	sb.append("<div id='cyry_datagrid_toolbar' style='padding:2px;height:40px'>");
	sb.append("<table border='0' cellpadding='0' cellspacing='10' width='100%'	align='center'>");
	sb.append("<tr>");
	sb.append("<td align='right'>");
	sb.append("<a id='addCyryBtn' href='javascript:void(0)' style='display:none'    onclick='add_cyryxxb();'>新增</a>&nbsp;");
	sb.append("<a id='exportCyryBtn' href='javascript:void(0)'  onclick='export_cyryxxb();'>导出</a>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("</div>");
	sb.append("<div style='height:20px;'>");
	sb.append("<table border='0' cellpadding='0' cellspacing='5' width='100%'	align='center'>");
	sb.append("<tr>");
	sb.append("<td align='right'>");
	sb.append("<a href='javascript:void(0)' style='height:25px;matop:5px' onclick='show_more_cyry();'>更多...</a>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</div>");
	return sb.toString();
};

function info_cyryxxb_back(){
	$('#addCyryBtn').linkbutton({iconCls:"icon-add"}); 
	$('#exportCyryBtn').linkbutton();
	$('#cyry_datagrid').datagrid({
		toolbar:'#cyry_datagrid_toolbar',
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		url:contextPath+"/sydwgl/cyryxxb_query_new?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'姓名',field:'xm',width:60,align:'center',fixed:true},
	    {title:'身份证号码',field:'zjhm',width:120,align:'center',fixed:true},
	    {title:'性别',field:'xbdm',width:40,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'},
	    {title:'出生时间',field:'csrq',width:70,align:'center',fixed:true},
	    {title:'入职时间',field:'pyrq',width:70,align:'center',fixed:true},
	    {title:'居住地',field:'dz_xzzxz',width:230,align:'center'},
	    {field:'dz_xzzdm',hidden:true},
	    {title:'操作',field:'process',width:150,align:'center',fixed:true,formatter:datagridProcessFormater}
		]]
	});
};

//校园安全信息
function info_xyaqxxb_(){
	var sb = new StringBuffer();
	sb.append("<div style='height:350px;width:718px;'>");
	sb.append("<ul class='003A' level='2' sfdt='2'><li class='uline' ><span>校园安全信息</span>");
	sb.append("<input type='hidden' name='method' value='dwxyaqxxb' read='true'/><input type='hidden' name='callback' value='info_xyaqxxb_back' />");
	sb.append("<div style='margin-top:-10px;'>");
	sb.append("<dl>");
	sb.append("<dt style='background:#fff;'><div class='dllf' style='display:none;'>校园安全信息</div>");
	sb.append("<a  href='javascript:void(0);' class='info_editbtn' style='float:left;height:24px;line-height:24px; padding:0 20px 0 25px;margin:0 auto; background:url(../images/edit/edit_add.png) left center no-repeat;'></a>");//<a class='info_savebtn' href='javascript:void(0);'>保存</a>
	sb.append("</dt><dd>");
	sb.append("<ul><li><input type='text' name='id' /><input type='hidden' name='openUrl' value='/dwxyaqxxb/createPage' /></li></ul>");
	sb.append("</dd></dl></div>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>学校类别：</span><span name='xxlbdm' dict='/common/dict/D_DW_XXLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学校隶属关系：</span><span name='xxlsgxdm' dict='/common/dict/D_DW_XXLSGX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>办公电话：</span><span name='bbdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校门数量：</span><span name='xmsl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学校人数：</span><span name='xxrs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校车接送学生数量：</span><span name='xcjsxssl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安保负责人证件种类：</span><span name='xxabfzrzjlx' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>安保负责人证件号码：</span><span name='xxabfzrzjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>学校安保负责人姓名：</span><span name='xxabfzrxm'  class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>学校安保负责人电话：</span><span name='xxabfzrdh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长证件种类：</span><span name='fzfxzzjlx' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长证件号码：</span><span name='fzfxzzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长姓名：</span><span name='fzfxzxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长电话：</span><span name='fzfxzdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校园警务室民警姓名：</span><span name='xyjwsmjxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校园警务室民警电话：</span><span name='xyjwsmjdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>宿舍情况：</span><span name='ssqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>安全等级：</span><span name='aqdj' dict='/common/dict/D_DW_AQDJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无许可：</span><span name='ywxkdm' dict='/common/dict/D_BZ_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否签订安全责任状：</span><span name='sfqdaqzrzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w1'></span></li>");
	sb.append("</ul>");
	sb.append("<ul level='2' sfdt='2' url='info_xyaqxxbHxd'><li class='uline' ><span>护校队信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append("</li>");
	sb.append("<input type='hidden' name='openUrl' value='/xyaqxxbHxd/addXyaqxxbHxd' /></ul>");
	sb.append("<div style='height:200px;width:648px;'>");
	sb.append("<table id='hxdxxb_datagrid'   border='1' style='height:200px;width:640px;'>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul level='2' sfdt='2' url='info_xyaqxxbXc'><li class='uline' ><span>校车信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append("</li>");
	sb.append("<input type='hidden' name='openUrl' value='/xyaqxxbXc/addXyaqxxbXc' /></ul>");
	sb.append("<div style='height:200px;width:648px;'>");
	sb.append("<table id='xcxxb_datagrid'   border='1' style='height:200px;width:640px;'>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("</div>");
	return sb.toString();
};

function info_xyaqxxb_back(){
	$('#hxdxxb_datagrid').datagrid({
		pagination:true,
		fitColumns:true,
		singleSelect:true,
		border:true,
		pageSize:getAutoPageSize(300),
		pageList:[getAutoPageSize(300),getAutoPageSize(300) * 2],
		url:contextPath+"/sydwgl/hxd_query_all?dwid="+$("#dwid").val(),
		columns:[[
	  	    {title:'证件种类',field:'zjlxdm',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_CYZJ.js',width:100,align:'center',fixed:true},
		    {title:'证件号码',field:'zjhm',width:140,align:'center',fixed:true},
		    {title:'姓名',field:'xm',width:70,align:'center',fixed:true},
		    {title:'性别',field:'xbdm',width:120,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'},
		    {title:'联系电话',field:'lxdh',width:100,align:'center',fixed:true},
		    {title:'操作',field:'process',width:100,align:'center',fixed:true,formatter:hxddatagridProcessFormater}
		 ]]
	});
	$('#xcxxb_datagrid').datagrid({
		pagination:true,
		fitColumns:true,
		singleSelect:true,
		border:true,
		pageSize:getAutoPageSize(300),
		pageList:[getAutoPageSize(300),getAutoPageSize(300) * 2],
		url:contextPath+"/sydwgl/xc_query_all?dwid="+$("#dwid").val(),
		columns:[[
		    {title:'校车号牌',field:'xcjdchphm',width:100,align:'center',fixed:true},
		    {title:'自有或租赁',field:'zyhzl',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_ZYHZL.js',width:140,align:'center',fixed:true},
		    {title:'专用标志编号',field:'zybzbh',width:90,align:'center',fixed:true},
		    {title:'驾驶人姓名',field:'jsrxm',width:100,align:'center',fixed:true},
		    {title:'驾驶人证件号码',field:'jsrzjhm',width:100,align:'center',fixed:true},
		    {title:'操作',field:'process',width:100,align:'center',fixed:true,formatter:xcdatagridProcessFormater}
		]]
	});
};

//护校队
function info_xyaqxxbHxd_(){
	return "";
}

//校车
function info_xyaqxxbXc_(){
	return "";
}

//保安員
function info_xyaqxxbBay_(){
	return "";
}

//保安员信息 
function info_bayxxb_(){
	$("#baywlx").show();
	var sb = new StringBuffer();
	sb.append("<div id='badwxx' style='height:350px;width:718px;'>");
	sb.append("<ul>");
	sb.append("<li><span class='spantitleb'>保安主管部门名称：</span><span name='bazgbmmc' class='edit_word input_w1'></span></li>"); 
	sb.append("<li><span class='spantitleb'>保安负责人姓名：</span><span name='bafzrxm' class='edit_word input_w2b'></span></li>"); 
	sb.append("<li><span class='spantitleb'>保安负责人公民身份号码：</span><span name='bafzrsfzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>保安负责人职务：</span><span name='bafzrzw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>保安负责人联系电话：</span><span name='bafzrlxdm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>服务区域名称：</span><span name='fwqymc'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>服务区域省市县（区）：</span><span name='fwqyssx' dict='/common/dict/D_BZ_XZQHLIST_MUNICIPAL' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>服务区域详址：</span><span name='fwqyxz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>保安服务类型：</span><span name='bafwlxdm' dict='/common/dict/GA_D_BAFWLXDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>服务区域负责人姓名：</span><span name='fwqyfzrxm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>区域负责人公民身份号码：</span><span name='fwqyfzrsfzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>服务区域负责人职务：</span><span name='fwqyfzrzw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>服务区域负责人联系电话：</span><span name='fwqyfzrlxdm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>受理备案公安机关：</span><span name='slbagajg' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>备案日期：</span><span name='barq' class='edit_word input_w2b'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='badwxxb' /><input type='hidden' name='callback' value='info_bayxxb_back' /><input type='hidden' name='openUrl' value='/dwbadwxxb/edit' />");
	sb.append("</ul>");
	sb.append("<div style='height:290px;width:718px;'>");
	sb.append("<ul><input type='hidden' name='callback' value='info_bayxxb_back' /><input type='hidden' name='dg' value='true' /></ul>");
	sb.append("<table id='bary_datagrid'   border='0' style='height:200px;'>");
	sb.append("</table>");
	sb.append("<table id='bary_datagrid_toolbar' border='0' cellpadding='0' cellspacing='0' width='100%'	align='center'>");
	sb.append("<tr>");
	sb.append("<td>");
	sb.append("<div class='dllf info_ck'>保安员信息</div><span style='width:450px;'>&nbsp;</span>");
	sb.append("<a id='addBaryBtn' href='javascript:void(0)' style='display:none;margin-top:8px'    onclick='add_baryxxb();'>新增</a>&nbsp;");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<div style='height:20px;'>");
	sb.append("<table border='0' cellpadding='0' cellspacing='5' width='100%'	align='center'>");
	sb.append("<tr>");
	sb.append("<td align='right'>");
	sb.append("<a href='javascript:void(0)' style='height:25px;matop:5px' onclick='show_more_bary();'>更多...</a>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("</div>");
	return sb.toString();
};

function info_bayxxb_back(){
	if($("#mode_").val()=='view'&&$("#partview_").val()=="true"){
		$("#badwxx").parents("dl").find("a.info_editbtn").show();
		$('#addBaryBtn').show();
	}
	$('#addBaryBtn').linkbutton({iconCls:"icon-add"});
	$('#bary_datagrid').datagrid({
		toolbar:'#bary_datagrid_toolbar',
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		url:contextPath+"/sydwgl/baryxxb_query_new?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'姓名',field:'xm',width:120,align:'center',fixed:true},
	    {title:'身份证号码',field:'zjhm',width:140,align:'center',fixed:true},
	    {title:'性别',field:'xbdm',width:80,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'},
	    {title:'联系电话',field:'lxdh',width:140,align:'center',fixed:true},
	    {title:'操作',field:'process',width:150,align:'center',fixed:true,formatter:barydatagridProcessFormater}
		]]
	});
}
//法定代表人\负责人\联络人
function info_dwfrfzrllyxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件种类：</span><span name='cyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/D_BZ_MZ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>国籍：</span><span name='gjdm' dict='/common/dict/D_BZ_SJGGHDQMCDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户籍地址：</span><span name='dz_hjdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>居住地址：</span><span name='dz_xjzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>单位人员类型：</span><span name='dwrylxdm' dict='/common/dict/D_DW_DWRYLXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职务：</span><span name='zw' dict='/common/dict/D_RK_ZW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否在公司任职：</span><span name='sfzgsrzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//行业场所分类信息
function info_dwflxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_zzyhjzzsbb' level='2'><li class='uline' ><span>自助银行及自助设备</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zzyhjzzsbb' /><input type='hidden' name='openUrl' value='/zzyhjzzsbb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//银行信息(原金融单位)
function info_yhxxb_(){
	var sb = new StringBuffer();
	sb.append("<div style='height:400px;width:718px;'>");
	sb.append("<ul  class='003A' level='2' sfdt='2'><li class='uline' ><span>银行信息</span>");
	sb.append("<input type='hidden' name='method' value='yhxxb' read='true'/><input type='hidden' name='callback' value='info_yhxxb_back' />");
	sb.append("<div style='margin-top:-10px;'>");
	sb.append("<dl>");
	sb.append("<dt style='background:#fff;'><div class='dllf' style='display:none;'>银行信息</div>");
	sb.append("<a  href='javascript:void(0);' class='info_editbtn' style='float:left;height:24px;line-height:24px; padding:0 20px 0 25px;margin:0 auto; background:url(../images/edit/edit_add.png) left center no-repeat;'></a>");//<a class='info_savebtn' href='javascript:void(0);'>保存</a>
	sb.append("</dt><dd>");
	sb.append("<ul><li><input type='text' name='id' /><input type='hidden' name='openUrl' value='/yhxxb/edit' /></li></ul>");
	sb.append("</dd></dl></div>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>银行类别：</span><span name='yhlbdm' dict='/common/dict/D_DW_YHLB' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>银行级别：</span><span name='yhjbdm' dict='/common/dict/D_DW_YHJB' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>银行所有制：</span><span name='yhsyz' dict='/common/dict/BD_D_YHSYZDM' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>是否有金库：</span><span name='sfyjkdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>金库分类：</span><span name='jkfldm' dict='/common/dict/D_BZ_JRZABWGLXXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>风险等级：</span><span name='fxdj' dict='/common/dict/BD_D_YHFXDJ'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>枪支数量：</span><span name='qzsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安全防范合格证编号：</span><span name='aqffhgzbh' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("</ul>");
	sb.append("<ul level='2' sfdt='2' url='info_zzyhjzzsbb'><li class='uline' ><span>自助银行及自助设备</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append("</li>");
	sb.append("<input type='hidden' name='openUrl' value='/zzyhjzzsbb/edit' /></ul>");
	sb.append("<div style='height:150px;width:648px;' id='12345'>");
	sb.append("<table id='zzyhjzzsbb_datagrid'   border='1' style='height:200px;width:640px;'>");
	sb.append("</table>");
	sb.append("<div class='clear'></div>");
	sb.append("</div>");
	sb.append("</div>");
	return sb.toString();
}


function info_yhxxb_back(){
	$('#zzyhjzzsbb_datagrid').datagrid({
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		border:true,
		url:contextPath+"/zzyhjzzsbb/zzyhjzzsbb_query?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'自助设备类别',field:'zzsblbdm',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_ZZYHLB.js',width:100,align:'center',fixed:true},
	    {title:'安装地点',field:'azdd',width:140,align:'center',fixed:true},
	    {title:'责任人姓名',field:'zrr_xm',width:70,align:'center',fixed:true},
	    {title:'责任人证件号码',field:'zrr_zjhm',width:120,align:'center',fixed:true},
	    {title:'责任人联系电话',field:'zrr_lxdh',width:100,align:'center',fixed:true},
	    {title:'操作',field:'process',width:90,align:'center',fixed:true,formatter:zzyhdatagridProcessFormater}
		]]
	});
};


//自助银行及自助设备表
function info_zzyhjzzsbb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>自助设备类别：</span><span name='zzsblbdm' dict='/common/dict/D_DW_ZZYHLB' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>安装日期：</span><span name='az_rq' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>安装地点：</span><span name='azdd' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>监控情况：</span><span name='jkqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>责任人常用证件：</span><span name='zrr_cyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人证件号码：</span><span name='zrr_zjhm'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人姓名：</span><span name='zrr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人联系电话：</span><span name='zrr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人职务：</span><span name='zrr_zwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return "";
}

//高校信息表
function info_gxxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>高校学生人数：</span><span name='gxxs_rs' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>教师人数：</span><span name='js_rs' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>外籍学生人数：</span><span name='wjxs_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>外籍教师人数：</span><span name='wjjs_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>少数民族学生人数：</span><span name='ssmzxs_rs' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>化学实验室数量：</span><span name='hxsyssl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无化学危险品：</span><span name='ywhxwxpdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>化学危险品责任人：</span><span name='glhxwxpzrr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人联系电话：</span><span name='zrr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>化学危险品种类数量：</span><span name='hxwxpzljslqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='gxxxb' /><input type='hidden' name='openUrl' value='/gxxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
}

//机动车休息信息
function info_jdcxlxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否专修店：</span><span name='sfzxddm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否连锁店：</span><span name='sflsddm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否备案：</span><span name='sfbadm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备案单位：</span><span name='ba_dwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>修理范围：</span><span name='xlfw' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jdcxlxxb' /><input type='hidden' name='openUrl' value='/jdcxlxxb/edit ' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//旧货收购信息
function info_jhsgxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>申请报告号：</span><span name='sqbgh' class='edit_word input_w1'></span></li>"); 
	sb.append("<li><span class='spantitle'>资信证明：</span><span name='zxzm' class='edit_word input_w1'></span></li>"); 
	sb.append("<li><span class='spantitle'>经营使用证明：</span><span name='jycssyzm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jhsgxxb' /><input type='hidden' name='openUrl' value='/jhsgxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//上下级单位信息
function info_sxjdwxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwbschfgsxxb' level='2'><li class='uline' ><span>办事处或分公司信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwbschfgsxxb' /><input type='hidden' name='openUrl' value='/dwbschfgs/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yhflcxxb' level='2'><li class='uline' ><span>银行分理处信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yhflcxxb' /><input type='hidden' name='openUrl' value='/dwyhflcxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yhatmjxxb' level='2'><li class='uline' ><span>银行自助设备</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yhatmjxxb' /><input type='hidden' name='openUrl' value='/yhatmjxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_sjdwhjmgsxxb' level='2'><li class='uline' ><span>上级或加盟单位信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='sjdwhjmgsxxb' /><input type='hidden' name='openUrl' value='/sjdwhjmgsxxb/addSjdwhjmgsxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//上级或加盟单位信息
function info_sjdwhjmgsxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否办理执照：</span><span name='sfblyyzzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>营业执照代码：</span><span name='yyzzdm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>执照起始日期：</span><span name='yyzzqsrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>执照截止日期：</span><span name='yyzzjzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营方式：</span><span name='jyfsdm' dict='/common/dict/D_DW_JYFSDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营性质：</span><span name='jyxzdm' dict='/common/dict/D_DW_JYXZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否重点单位：</span><span name='sfzddwdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>单位状态：</span><span name='dwztdm' dict='/common/dict/D_DW_DWZTDM' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//分公司或办事处信息
function info_dwbschfgsxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>分公司名称：</span><span name='fgshbscmc' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//银行分理处信息
function info_yhflcxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>分理处名称：</span><span name='flcmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营地址：</span><span name='dz_jydzxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>主营：</span><span name='zy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>副营：</span><span name='fy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='flclxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件种类：</span><span name='fzrcyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='fzrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='fzr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人职务：</span><span name='fzrzw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系电话：</span><span name='fzrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yhflcxxb' /><input type='hidden' name='openUrl' value='/dwyhflcxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
	
}
//银行ＡＴＭ安装信息
function info_yhatmjxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>安装地点：</span><span name='azdd' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安装时间：</span><span name='azsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>监控情况：</span><span name='jkqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>责任人证件种类：</span><span name='zrrcyzjdm' dict='/common/dict/D_BZ_CYZJ'class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人证件号码：</span><span name='zrrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人姓名：</span><span name='zrr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人职务：</span><span name='zrrzw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人联系电话：</span><span name='zrrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yhatmjxxb' /><input type='hidden' name='openUrl' value='/yhatmjxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
}



//旅店信息
function info_ldxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitle'>旅馆编码：</span><span name='lgbm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>星级：</span><span name='xj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>栋数：</span><span name='ds'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>楼层数：</span><span name='lcs'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>客房数：</span><span name='kefs'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>床位数：</span><span name='cws'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否涉外：</span><span name='sfswdm' class='edit_word input_w2' dict='/common/dict/D_GG_SF'></span></li>");
	sb.append("<li><span class='spantitle'>更值人数：</span><span name='gz_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无电子监控：</span><span name='ywdzjksbdm' class='edit_word input_w2' dict='/common/dict/D_BZ_YW'></span></li>");
	sb.append("<li><span class='spantitle'>有无闭路电视监控：</span><span name='ywbldsjksb' class='edit_word input_w2' dict='/common/dict/D_BZ_YW'></span></li>");
	sb.append("<li><span class='spantitle'>附属娱乐项目：</span><span name='fsylxm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>附属服务项目：</span><span name='fsfwxm' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='ldxxb' /><input type='hidden' name='openUrl' value='/ldxxb/addLdxxb' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}
//单位其他信息
function info_dwqtxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwzjxxzb' level='2'><li class='uline' ><span>单位证件信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwzjxxzb' /><input type='hidden' name='openUrl' value='/dwzjxxb/addZjxx' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yyssxxb' level='2'><li class='uline' ><span>营业设施信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yyssxxb' /><input type='hidden' name='openUrl' value='/yyssxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwccxxb' level='2'><li class='uline' ><span>仓储信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwccxxb' /><input type='hidden' name='openUrl' value='/dwccxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_rfxxb' level='2'><li class='uline' ><span>人防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rfxxb' /><input type='hidden' name='openUrl' menu='人防信息新增/修改' value='/rfxx/addRfxx' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wfxxb' level='2'><li class='uline' ><span>物防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wfxxb' /><input type='hidden' name='openUrl' menu='物防信息新增/修改' value='/wfxxb/addWfxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jfxxb' level='2'><li class='uline' ><span>技防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jfxxb' /><input type='hidden' name='openUrl' menu='技防信息新增/修改' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwzybwxxb' level='2'><li class='uline' ><span>重要部位信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwzybwxxb' /><input type='hidden' name='openUrl' value='/dwzybw/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}




//剧毒化学品资质信息
function info_jdhxpzzxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>安全责任人姓名：</span><span name='anquanzerenren' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>安全责任人联系电话：</span><span name='anquanzerenren_dhhm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>库房安防等级：</span><span name='anfangdengji' dict='/common/dict/BD_D_KFAFDJDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>从业人员总数：</span><span name='congyerenshu' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>上级机关（公安）名称：</span><span name='shangjijiguan' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitleb'>组织机构代码证：</span><span name='jgdmz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>组织机构代码证有效期：</span><span name='jgdmz_yxq' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>安监颁发证件号：</span><span name='ajz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>安监颁发证件有效期：</span><span name='ajz_yxq' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>环保资质号：</span><span name='hbzz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>环保资质有效期：</span><span name='hbzz_yxq' class='edit_word input_w2b'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jdhxpzzxxb' /><input type='hidden' name='openUrl' value='/jdhxpzzxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
}
//单位证件信息
function info_dwzjxxzb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件种类：</span><span name='dwzjzldm' class='edit_word input_w2' dict='/common/dict/D_DW_DWZJZL'></span></li>");
	sb.append("<li><span class='spantitle'>证件编号：</span><span name='dwzjbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>签发日期：</span><span name='qfrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>截止日期：</span><span name='jzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件审批机关：</span><span name='zjspjg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件年检机关：</span><span name='zjnjjg' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}


//单位设施部位信息
function info_dwssbwxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwzybwxxb' level='2'><li class='uline' ><span>重要部位信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwzybwxxb' /><input type='hidden' name='openUrl' value='/dwzybw/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yyssxxb' level='2'><li class='uline' ><span>营业设施信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yyssxxb' /><input type='hidden' name='openUrl' value='/yyssxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwccxxb' level='2'><li class='uline' ><span>仓储信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwccxxb' /><input type='hidden' name='openUrl' value='/dwccxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_rfxxb' level='2'><li class='uline' ><span>人防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rfxxb' /><input type='hidden' name='openUrl' menu='人防信息新增/修改' value='/rfxx/addRfxx' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wfxxb' level='2'><li class='uline' ><span>物防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wfxxb' /><input type='hidden' name='openUrl' menu='物防信息新增/修改' value='/wfxxb/addWfxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jfxxb' level='2'><li class='uline' ><span>技防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jfxxb' /><input type='hidden' name='openUrl' menu='技防信息新增/修改' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	
	return sb.toString();
}

//重要部位信息
function info_dwzybwxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重要部位名称：</span><span name='zybwmc' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>重要部位位置：</span><span name='zybwwz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>确定时间：</span><span name='qdsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>确定理由依据：</span><span name='qdlyyj' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>重要部位描述：</span><span name='zybwms' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件种类：</span><span name='fzr_cyzjdm'  dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='fzr_zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='fzr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人性别：</span><span name='fzr_xbdm' dict='/common/dict/D_BZ_XB'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系电话：</span><span name='fzr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人职务：</span><span name='fzr_zwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}


//营业设施信息
function info_yyssxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>设备名称：</span><span name='sbmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设备数量：</span><span name='sbsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>购买时间：</span><span name='sbgm_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设备状态：</span><span name='sbzt' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设备用途：</span><span name='sbyt' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}
//典当业信息
function info_ddxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>经营许可证：</span><span name='jyxkzh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设立申请书编号：</span><span name='slsqsbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>资信证明号：</span><span name='zxzmh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无分支机构：</span><span name='ywfzjgdm' dict='/common/dict/D_BZ_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无收当国家统收：</span><span name='ywsdgjtsdm' dict='/common/dict/D_BZ_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>典当建筑物结构：</span><span name='dd_jzwjglxdm' dict='/common/dict/D_BZ_JZWJGLXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>专营：</span><span name='zy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>专卖物品权：</span><span name='zmwpq' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='ddxxb' /><input type='hidden' name='openUrl' value='/ddxxb/addDdxxb' />");
	sb.append("</ul>");
	return sb.toString();
}

////重要部位信息
//function info_dwzybwxxb_(){
//	var sb = new StringBuffer();
//	sb.append("<ul>");
//	sb.append("<li><span class='spantitle'>部位名称：</span><span name='bwmc' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>部位位置：</span><span name='bwwz' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>确定时间：</span><span name='qdsj' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>责任人姓名：</span><span name='fzrxm' class='edit_word input_w2'></span></li>");
//	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
//	sb.append("<input type='hidden' name='id' />");
//	sb.append("</ul>");
//	return sb.toString();
//}
//仓储信息
function info_dwccxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>仓储名称：</span><span name='ccmc' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>仓储地址：</span><span name='dz_ccdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>占地面积：</span><span name='zdmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>建筑面积：</span><span name='jzmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否独立仓储：</span><span name='sfdlccdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>起用时间：</span><span name='qysj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>使用期限：</span><span name='ysqx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储面积：</span><span name='ccmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储容积：</span><span name='ccrj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储物品：</span><span name='ccwp' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>仓储数量：</span><span name='ccsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>数量单位：</span><span name='sldw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>消防设备情况：</span><span name='xfsbqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>值更人员信息：</span><span name='zgryxx' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>仓储值班室电话：</span><span name='cczbsdh' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>库管人员信息：</span><span name='kgryxx' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>证件种类：</span><span name='ccfzrcyzjdm' dict='/common/dict/D_BZ_CYZJ'class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人号码：</span><span name='ccfzrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储负责人姓名：</span><span name='ccfzr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储负责人职务：</span><span name='ccfzrzw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人电话：</span><span name='ccfzrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//单位业务办理
function info_dwywbl_(){
//	var sb = new StringBuffer();
//	sb.append("<ul url='info_dwjcxxb' level='2'><li class='uline' ><span>单位检查信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
//	sb.append(refresh+"</li>");
//	sb.append("<input type='hidden' name='method2' value='dwjcxxb' /><input type='hidden' name='openUrl' value='/dwjcxxb/add' /></ul>");
//	sb.append("<div class='clear'></div>");
//	sb.append("<ul url='info_dwcfxxb' level='2'><li class='uline' ><span>单位处罚信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
//	sb.append(refresh+"</li>");
//	sb.append("<input type='hidden' name='method2' value='dwcfxxb' /><input type='hidden' name='openUrl' value='/dwcfxxb/edit' /></ul>");
//	sb.append("<div class='clear'></div>");
//	return sb.toString();
	var mainTabID = getMainTabID()
	var sb = new StringBuffer();
	sb.append("<div style='background:#F4F4F4;'>");
	sb.append("<ul class='003A' level='2' sfdt='2' url='info_dwjcxxb' style='padding:5px 20px 5px 15px;'><li class='lititle' ><span style='font-size:14px'>单位检查信息</span>");
	sb.append("<input type='hidden' name='method' value='dwxyaqxxb' read='true'/><input type='hidden' name='callback' value='info_dwywbl_back' />");
	sb.append("</li>");
	sb.append("<input type='hidden' name='openUrl' value='/dwjcxxb/selCheckTemp?dwlbdm="+dwlbdm+"&mainTabID="+mainTabID+"' /></ul>");
	sb.append("<div style='height:200px;width:718px;border-top:solid 1px #dddddd;border-bottom:solid 1px #dddddd;'>");
	sb.append("<table id='dwjcxxb_datagrid'   border='1' style='height:200px;'>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<ul level='2' sfdt='2' url='info_dwcfxxb' style='padding:5px 20px 5px 15px;'><li class='lititle' ><span style='font-size:14px'>单位处罚信息</span>");
	sb.append("</li></ul>");
	sb.append("<div style='height:200px;width:718px;border-top:solid 1px #dddddd;border-bottom:solid 1px #dddddd;'>");
	sb.append("<table id='dwcfxxb_datagrid'   border='1' style='height:200px;'>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<div class='clear'></div>");
	sb.append("</div>");
	return sb.toString();
};

//单位业务办理_回调
function info_dwywbl_back(){
	$('#dwjcxxb_datagrid').datagrid({
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		url:contextPath+"/dwjcxxb/dwjcxxb_query?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'检查时间',field:'jcsj',width:80,align:'center',fixed:true},
	    {title:'检查单位',field:'jcdw',width:120,align:'center',fixed:true},
	    {title:'整改或处罚意见',field:'zghcfyj',width:120,align:'center',fixed:true},
	    {title:'检查结果',field:'jcjg',width:130,align:'center',fixed:true},
	    {title:'检查人',field:'jcry',width:90,align:'center',fixed:true},
	    {title:'操作',field:'process',width:120,align:'center',fixed:true,formatter:dwjcprocessFormater}
		]]
	});
	$('#dwcfxxb_datagrid').datagrid({
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		url:contextPath+"/dwcfxxb/dwcfxxb_query?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'案件编号',field:'ajbh',width:80,align:'center',fixed:true},
	    {title:'经办单位',field:'jbdw',width:120,align:'center',fixed:true},
	    {title:'处罚类型',field:'cflxdm',width:120,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_CFLX.js'},
	    {title:'处罚情况',field:'cfqk',width:170,align:'center',fixed:true},
	    {title:'处罚日期',field:'cfrq',width:90,align:'center',fixed:true},
	    {title:'操作',field:'process',width:80,align:'center',fixed:true,formatter:dwcfprocessFormater}
		]]
	});
}

//单位检查信息
function info_dwjcxxb_(){
	$("#dwjcxxb_datagrid").datagrid("reload");
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>检查结果：</span><span name='jcjg' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//单位处罚信息
function info_dwcfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>处罚情况：</span><span name='cfqk' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//实有单位附件
function info_sydwfj_(){
	var sb = new StringBuffer();
	sb.append("<div style='height:290px;width:718px;'>");
	sb.append("<ul url='info_sydwfj' level='1'><input type='hidden' name='callback' value='info_sydwfj_back' /><input type='hidden' name='method' /><input type='hidden' name='openUrl' value='/sydwfj/edit' /></ul>");
	sb.append("<table id='fjxx_datagrid' class='easyui-datagrid'  border='1' style='height:200px;'>");
	sb.append("</table>");
	sb.append("</div>");
	return sb.toString();
}

function info_sydwfj_back(){
	$('#fjxx_datagrid').datagrid({
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		idField:'id',
		url:contextPath+"/sydwfj/query?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'附件类型',field:'wjhzlx',width:80,align:'center',fixed:true},
	    {title:'附件名称',field:'wjmc',width:180,align:'center',fixed:true},
	    {title:'附件字节',field:'wjdx',width:90,align:'center',fixed:true},
	    {title:'附件大小',field:'wjdxsm',width:90,align:'center',fixed:true},
	    {title:'下载次数',field:'wjxzcs',width:70,align:'center',fixed:true},
	    {title:'下载',field:'process',width:150,align:'center',fixed:true,formatter:fjxxprocessFormater}
		]]
	});
}

//人防
function info_rfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>防范组织形式：</span><span name='ffzzxsdm' dict='/common/dict/D_ZAFF_ZZXS' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人常用证件：</span><span name='ffzrrcyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='ffzrrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='ffzrrxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系电话：</span><span name='ffzrrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人居住地址：</span><span name='dz_ffzrrjzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人所属单位：</span><span name='fffzrssdwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人传真号码：</span><span name='ffzrrczhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>所属单位地址：</span><span name='dz_ffzrrssdwdzxz' class='edit_word input_w1'></span></li>");
	
	sb.append("<li><span class='spantitle'>组织名称：</span><span name='ffzzmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织类别：</span><span name='ffzzlb' dict='/common/dict/D_ORG_ORGTYPE' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织联系电话：</span><span name='ffzzlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织传真号码：</span><span name='ffzzczhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织地址：</span><span name='dz_ffzzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>组建日期：</span><span name='zjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否治安承包：</span><span name='sfzacbdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否定时巡逻：</span><span name='sfdsxldm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>巡逻类型：</span><span name='xllxdm' dict='/common/dict/D_ZAFF_XLLX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>巡逻路线：</span><span name='xllx' class='edit_word input_w2'></span></li>");
	
	sb.append("<li><span class='spantitle'>防范方式：</span><span name='fffsdm' dict='/common/dict/D_ZAFF_FFFS' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>防范部位：</span><span name='ffbw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>携带装备：</span><span name='xdsb' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>装备配置情况：</span><span name='zbpzqk' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任范围：</span><span name='zrfw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>地区类别：</span><span name='dylbdm' dict='/common/dict/D_ZAFF_DYLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>隶属关系：</span><span name='lsgxdm' dict='/common/dict/D_ZAFF_LSGX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经费来源：</span><span name='jfly' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作用情况：</span><span name='zyqk' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//物防
function info_wfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>物防种类：</span><span name='wfzl' dict='/common/dict/D_ZAFF_WFZL' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>数量：</span><span name='sl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安装日期：</span><span name='azrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>描述：</span><span name='ms' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>物防地址：</span><span name='dz_wfdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>坐标X：</span><span name='zbx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>坐标Y：</span><span name='zby' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//技防
function info_jfxxb_(){
	
}

//单位保卫信息
function info_dwbwxx_(){
	var sb = new StringBuffer();
/**	sb.append("<ul url='info_jdhxpzzxxb' level='2'><li class='uline' ><span>剧毒化学品资质信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jdhxpzzxxb' /><input type='hidden' name='openUrl' value='/jdhxpzzxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");**/
	return sb.toString();
}

//歌舞娱乐场所信息
function info_gwxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitle'>包厢数量(间)：</span><span name='bxsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>核定消费者数(人)：</span><span name='hdxfzs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>舞池数(个)：</span><span name='wcs'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出口数量(个)：</span><span name='cksl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>摄像头数量(支)：</span><span name='sxtsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>舞池面积(平方米)：</span><span name='wcmj' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='gwylcs' /><input type='hidden' name='openUrl' value='/dwownsydw/editGwylcs' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}

//按摩场所信息
function info_amxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitleb'>按摩服务场所经营许可证：</span><span name='amcsjyxkz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>按摩服务场所卫生许可证：</span><span name='amcsfwxkz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>按摩室数量：</span><span name='amrsl'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>按摩床(椅)数量：</span><span name='amcsl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>按摩师数量：</span><span name='amssl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>出口数量：</span><span name='cksl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>休闲大厅面积(平方米)：</span><span name='xxdtmj' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='amfwcs' /><input type='hidden' name='openUrl' value='/dwownsydw/editAmfwcs' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}

//游戏游艺场所信息
function info_yxyyxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitle'>游戏游艺机机型：</span><span name='yxyyjlx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>游戏游艺机数：</span><span name='yxyyjs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出口数量：</span><span name='cksl' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yycs' /><input type='hidden' name='openUrl' value='/dwownsydw/editYxyycs' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}

//印章业信息
function info_yzxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitle'>治安主管单位：</span><span name='zazgdw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>特行备案编号：</span><span name='tybabh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>特行备案机构：</span><span name='tebajg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>行业许可证号：</span><span name='hyxkz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>员工从业人数：</span><span name='ygcyrs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>企业经营状况：</span><span name='qyjyzk' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='seal' /><input type='hidden' name='openUrl' value='/dwownsydw/editYz' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}

//民爆单位信息
function info_mbxxb_(){
	var sb = new StringBuffer();
	sb.append("<div style='height:550px;width:718px;'>");
	sb.append("<ul  class='003A' level='2' sfdt='2'><li class='uline' ><span>民爆单位信息</span>");
	sb.append("<input type='hidden' name='method' value='mb' read='true'/><input type='hidden' name='callback' value='info_mbxxb_back' /><input type='hidden' name='dg' value='true' />");
	sb.append("<div style='margin-top:-10px;'>");
	sb.append("<dl>");
	sb.append("<dt style='background:#fff;'><div class='dllf' style='display:none;'>民爆单位信息</div>");
	sb.append("<a  href='javascript:void(0);' class='info_editbtn' style='float:left;height:24px;line-height:24px; padding:0 20px 0 25px;margin:0 auto; background:url(../images/edit/edit_add.png) left center no-repeat;'></a>");//<a class='info_savebtn' href='javascript:void(0);'>保存</a>
	sb.append("</dt><dd>");
	sb.append("<ul><li><input type='text' name='id' /><input type='hidden' name='openUrl' value='/dwownsydw/editbMb' /></li></ul>");
	sb.append("</dd></dl></div>");
	
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>爆破作业单位许可证类型：</span><span name='bpzydwxkzlxdm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>企业代号：</span><span name='qydh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>作业地点：</span><span name='zydd' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>技术负责人姓名：</span><span name='jsfzrxm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>技术负责人公民身份号码：</span><span name='jsfzrgmsfzhm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>技术负责人联系电话：</span><span name='jsfzrlxdh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>治安保卫负责人姓名：</span><span name='zabwfzrxm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>治安负责人公民身份号码：</span><span name='zabwfzrgmsfzhm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>治安负责人联系电话：</span><span name='zabwfzrlxdh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>净资产：</span><span name='jzc' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>专用设备净值（万元）：</span><span name='zysbjz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>银行账号：</span><span name='yhzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>申请资质等级：</span><span name='sqzzdj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>申请从业范围：</span><span name='sqcyfw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>申请日期：</span><span name='sqrq' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>证件签发日期：</span><span name='zjqfrq' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>采矿许可证编号：</span><span name='ckxkzbh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>采矿许可证有效期：</span><span name='ckxkzyxq' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>煤炭生产许可证编号：</span><span name='mtscxkzbh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>煤炭生产许可证有效期：</span><span name='mtscxkzyxq' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>安全生产许可证编号：</span><span name='aqscxkzbh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>安全生产许可证有效期：</span><span name='aqscxkzyxq' class='edit_word input_w2b'></span></li>");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul level='2' sfdt='2' url='info_mbxxb_ssxmyj'><li class='uline' ><span>实施项目业绩</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append("</li>");
	sb.append("<input type='hidden' name='openUrl' value='/dwownsydw/editbMbxmyj' /></ul>");
	sb.append("<div style='height:200px;width:648px;'>");
	sb.append("<table id='ssxmyj_datagrid'   border='1' style='height:200px;width:620px;'>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<div style='height:20px;'>");
	sb.append("<table border='0' cellpadding='0' cellspacing='5' width='90%'	align='center'>");
	sb.append("<tr>");
	sb.append("<td align='right'>");
	sb.append("<a href='javascript:void(0)' style='height:25px;matop:5px' onclick='show_more_mbsxm();'>更多...</a>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("</div>");
	return sb.toString();
};


//民爆单位信息_回调
function info_mbxxb_back(){
	$('#ssxmyj_datagrid').datagrid({
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		border:true,
		url:contextPath+"/sydwgl/mbsgxm_query_new?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'项目级别',field:'xmjb',width:120,align:'center',fixed:true},
	    {title:'项目名称',field:'xmmc',width:120,align:'center',fixed:true},
	    {title:'爆破施工日期',field:'bpsgrq',width:100,align:'center',fixed:true},
	    {title:'第一设计人',field:'dysjr',width:100,align:'center',fixed:true},
	    {title:'操作',field:'process',width:150,align:'center',fixed:true,formatter:mbdatagridProcessFormater}
		]]
	});
};

function info_mbxxb_ssxmyj_(){
	return "";
};

//民枪单位信息
function info_mqxxb_(){
	var sb = new StringBuffer();
	sb.append("<div style='height:350px;width:718px;'>");
	sb.append("<ul level='2' sfdt='2'><li class='uline' ><span>民枪单位信息</span>");
	sb.append("<input type='hidden' name='method' value='mq' read='true'/><input type='hidden' name='callback' value='info_mqxxb_back' /><input type='hidden' name='dg' value='true' />");
	sb.append("<div style='margin-top:-10px;'>");
	sb.append("<dl>");
	sb.append("<dt style='background:#fff;'><div class='dllf' style='display:none;'>民枪单位信息</div>");
	sb.append("<a  href='javascript:void(0);' class='info_editbtn' style='float:left;height:24px;line-height:24px; padding:0 20px 0 25px;margin:0 auto; background:url(../images/edit/edit_add.png) left center no-repeat;'></a>");//<a class='info_savebtn' href='javascript:void(0);'>保存</a>
	sb.append("</dt><dd>");
	sb.append("<ul><li><input type='text' name='id' /><input type='hidden' name='openUrl' value='/dwownsydw/editmMq' /></li></ul>");
	sb.append("</dd></dl></div>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>仓库情况：</span><span name='ckqk' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安全设施：</span><span name='aqss' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批机关：</span><span name='spjg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批人：</span><span name='spr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批日期：</span><span name='sprq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>持枪类型：</span><span name='cqlx' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='method2' value='dwjcxxb' /><input type='hidden' name='openUrl' value='/dwjcxxb/add' /></ul>");
	sb.append("<ul level='2' sfdt='2' url='info_mqxxb_zgry'><li class='uline' ><span>民枪专管人员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append("</li>");
	sb.append("<input type='hidden' name='method2' value='dwcfxxb' /><input type='hidden' name='openUrl' value='/dwownsydw/editbMqzgry' /></ul>");
	sb.append("<div style='height:200px;width:648px;'>");
	sb.append("<table id='mqzgry_datagrid'   border='1' style='height:200px;width:620px;'>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<div style='height:20px;'>");
	sb.append("<table border='0' cellpadding='0' cellspacing='5' width='90%'	align='center'>");
	sb.append("<tr>");
	sb.append("<td align='right'>");
	sb.append("<a href='javascript:void(0)' style='height:25px;matop:5px' onclick='show_more_mqzgry();'>更多...</a>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("</div>");
	return sb.toString();
};

function info_mqxxb_zgry_(){
	return "";
};

//民枪单位信息_回调
function info_mqxxb_back(){
	$('#mqzgry_datagrid').datagrid({
		pagination:false,
		fitColumns:true,
		singleSelect:true,
		border:true,
		url:contextPath+"/sydwgl/mqzgry_query_new?dwid="+$("#dwid").val(),
		columns:[[
	    {title:'姓名',field:'xm',width:100,align:'center',fixed:true},
	    {title:'性别',field:'xb',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js',width:80,align:'center',fixed:true},
	    {title:'证件号码',field:'zjhm',width:120,align:'center',fixed:true},
	    {title:'联系电话',field:'lxdh',width:120,align:'center',fixed:true},
	    {title:'职责',field:'zz',width:120,align:'center',fixed:true},
	    {title:'操作',field:'process',width:100,align:'center',fixed:true,formatter:mqdatagridProcessFormater}
		]]
	});
};

//烟花单位信息
function info_dwyhxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul level='2' sfdt='2'><li class='uline' ><span>烟花营业单位基本信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>备案机关：</span><span name='bajg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否配送：</span><span name='sfps' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作业人数：</span><span name='zyry' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>产品质量检验信息：</span><span name='cpzljyxx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yh' /><input type='hidden' name='openUrl' value='/dwownsydw/editmYh' /></ul>");
	sb.append("<ul><li class='uline' ><span>许可证信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>燃放规模等级：</span><span name='yfgmdjdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>许可证类型：</span><span name='xkzlx' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>许可证编号：</span><span name='xkzbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>发证机关：</span><span name='fzjg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>发证日期：</span><span name='fzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有效截止日期：</span><span name='yxjzrq' class='edit_word input_w2'></span></li>");
	sb.append("</ul>");
	sb.append("<ul level='2' sfdt='2'><li class='uline' ><span>库房信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>库房名称：</span><span name='kfmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>库房类别：</span><span name='kflb' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>危险等级：</span><span name='wxdj' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>总建筑面积：</span><span name='zjzmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>回收间建筑面积：</span><span name='hsjjzmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>生产区建筑面积：</span><span name='scqjzmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营面积：</span><span name='jymj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>涉药库房面积：</span><span name='sykfmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>核定库存量：</span><span name='hdkcl' class='edit_word input_w2'></span></li>");
	sb.append("</ul>");
	return sb.toString();
};

//单位环保信息
function info_dwhbxxb_(){
	$("#hbywlx").show();
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>主要污染物：</span><span name='zywrw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>在册职工数：</span><span name='zczgs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>环保主管负责人姓名：</span><span name='hbzgfzrxm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>环保主管负责人身份证号：</span><span name='hbzgfzrsfzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>环保主管负责人职务：</span><span name='hbzgfzrzw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>环保主管负责人联系方式：</span><span name='hbzgfzrlxdm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>污染物状态：</span><span name='wrwztdm' dict='/common/dict/BD_D_WRWZTDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>污染物类型：</span><span name='wrwlxdm' dict='/common/dict/BD_D_WRWLXDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>排放污染物信息：</span><span name='pfwrwxx' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>污染物名称：</span><span name='hbzz' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='dwhbxxb' /><input type='hidden' name='openUrl' value='/dwhbxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
};

function info_jfdwxxb_(){
	$("#jfywlx").show();
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>有无监控：</span><span name='spjk_ywjkdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监控范围：</span><span name='spjk_jkfwdm' dict='/common/dict/BD_D_BFFWDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>摄像头分类：</span><span name='spjk_sxtfldm' dict='/common/dict/BD_D_SXTFLDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>点位数量：</span><span name='spjk_dwsl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>有无监控室：</span><span name='spjk_ywjksdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>存储时间：</span><span name='spjk_cxsj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人姓名：</span><span name='spjk_lxrxm' dict='/common/dict/BD_D_WRWZTDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人联系方式：</span><span name='spjk_lxrlxfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>有无 入侵报警：</span><span name='rqbj_ywrqbjdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>布防范围：</span><span name='rqbj_bffwdm' dict='/common/dict/BD_D_BFFWDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>入侵检测方式：</span><span name='rqbj_rqjcfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>数量：</span><span name='rqbj_sl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人姓名：</span><span name='rqbj_lxrxm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人联系方式：</span><span name='rqbj_lxrlxfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>是否与公安机关联网：</span><span name='rqbj_sfygajglwdm' dict='/common/dict/D_GG_SF' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitleb'>有无出入口：</span><span name='crkkz_ywcrkdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>布防范围：</span><span name='crkkz_bffwdm' dict='/common/dict/BD_D_BFFWDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>控制方式：</span><span name='crkkz_kzfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>数量：</span><span name='crkkz_sl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人 姓名：</span><span name='crkkz_lxrxm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人联系方式：</span><span name='crkkz_lxrlxfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>存储时间：</span><span name='crkkz_cxsj' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jfdwxxb' /><input type='hidden' name='openUrl' value='/dwjfdwxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
}


function info_jfdw_bxxb_(){
	$("#jfywlx").show();
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>有无监控：</span><span name='spjk_ywjkdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监控范围：</span><span name='spjk_jkfwdm' dict='/common/dict/BD_D_BFFWDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>摄像头分类：</span><span name='spjk_sxtfldm' dict='/common/dict/BD_D_SXTFLDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>点位数量：</span><span name='spjk_dwsl' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>有无监控室：</span><span name='spjk_ywjksdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>存储时间：</span><span name='spjk_cxsj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人姓名：</span><span name='spjk_lxrxm' dict='/common/dict/BD_D_WRWZTDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>联系人联系方式：</span><span name='spjk_lxrlxfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>有无 入侵报警：</span><span name='rqbj_ywrqbjdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>布防范围：</span><span name='rqbj_bffwdm' dict='/common/dict/BD_D_BFFWDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>入侵检测方式：</span><span name='rqbj_rqjcfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>有无出入口：</span><span name='crkkz_ywcrkdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>布防范围：</span><span name='crkkz_bffwdm' dict='/common/dict/BD_D_BFFWDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>控制方式：</span><span name='crkkz_kzfs' class='edit_word input_w2b'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jfdwxxb' /><input type='hidden' name='openUrl' value='/dwjfdwxxb/edit_jfb' />");
	sb.append("</ul>");
	return sb.toString();
}


//通用注销 dwid 单位id datagrid是表格id url对应数据库配置的表名
function cancel(dwid,datagrid,url){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sydwgl/calcle_xxzsnrb';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:dwid,url:url}
			}).done(function(result) {
				$('#'+datagrid).datagrid('reload');
			});
		}
	});
};

//------------@star开始--------
//工企文保单位信息
function info_gqwb_(){
	var sb = new StringBuffer();
	sb.append("<ul><li class='uline' ><span>工企/文保单位信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>是否军工单位：</span><span name='sfjgdw' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>重点等级：</span><span name='zddj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>军工代号：</span><span name='jgdh'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>重要部位数：</span><span name='zybws' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>在册职工数：</span><span name='zczgs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>盈亏情况：</span><span name='ykqk' class='edit_word input_w2b'></span></li></li>"); 
	sb.append("<li><span class='spantitleb'>是否平安单位：</span><span name='sfpadw' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>"); 
	sb.append("<li><span class='spantitleb'>是否建立警务工作站：</span><span name='sfjljwgzz' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>"); 
	sb.append("<li><span class='spantitleb'>固定资产（万元）：</span><span name='gdzc'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>单位主管负责人姓名：</span><span name='dwzgfzrxm'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>单位主管负责人身份证：</span><span name='dwzgfzrsfzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>单位主管负责人职务：</span><span name='dwzgfzrzw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>单位主管负责人联系方式：</span><span name='dwzgfzrlxfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监督内保部门：</span><span name='fzzdjdganbbm' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监督内保部门责任民警：</span><span name='fzzdjdganbbmzrmj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监督内保部门联系方式：</span><span name='fzzdjdganbbmlxfs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>确定重点单位理由依据：</span><span name='qdzddwyj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>本单位意见：</span><span name='bdwyj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>主管公安机关意见：</span><span name='zggajgyj' class='edit_word input_w2b'></span></li>");;
	sb.append("<li><span class='spantitleb'>上级公安机关审核意见：</span><span name='sjgajgshyj' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>是否安装红外报警：</span><span name='sfazhwbj' dict='/common/dict/D_BZ_SF' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitleb'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
    sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='gqwb' /><input type='hidden' name='openUrl' value='/dwownsydw/editmGqwb' />");
	sb.append("</ul>");
    sb.append("<div class='clear'></div>");
	sb.append("<ul><li class='uline' ><span>重要部位信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>部位编号：</span><span name='bwbh'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>部位名称：</span><span name='bwmc' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>部位位置：</span><span name='bwwz'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人：</span><span name='bwfzr'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人身份证号：</span><span name='bwfzrsfzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人职务：</span><span name='bwfzrzw' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系方式：</span><span name='bwfzrlxfs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>值班电话：</span><span name='bwzbdh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>物防设施情况：</span><span name='wfssqk' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>确定时间：</span><span name='bwqdsj'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>确定理由依据：</span><span name='bwqdlyyj'  class='edit_word input_w1'></span></li>");
	sb.append("</ul>");
	return sb.toString();
};
//证券保险业单位的行业特殊信息
function info_zjbx_(){
	var sb = new StringBuffer();
	sb.append("<ul><li class='uline' ><span>证券/保险业单位信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitleb'>所属监管机构：</span><span name='ssjgjg'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>是否独立保卫机构：</span><span name='sfdlbwjg'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>所在地派出所：</span><span name='szdpcs' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>是否治安保卫重点单位：</span><span name='sfzabwzddw' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>重要部位数：</span><span name='zybws'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>在册职工数：</span><span name='zczgs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>治安保卫重点单位级别：</span><span name='zabwzddwjb'  class='edit_word input_w2b'></span></li>"); 
	sb.append("<li><span class='spantitleb'>是否平安单位：</span><span name='sfpadw' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>是否建立警务工作站：</span><span name='sfjljwgzs' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>固定资产（万元）：</span><span name='gdzc'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>主管保卫负责人姓名：</span><span name='zgbwfzrxm'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>主管保卫负责人身份证号：</span><span name='zgbwfzrsfzh'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>主管保卫负责人职务：</span><span name='zgbwfzrzw'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>主管保卫负责人联系方式：</span><span name='zgbwfzrlxfs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监督内保部门：</span><span name='fzzdjdganbbm'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监督内保部门责任民警：</span><span name='fzzdjdganbbmzrmj'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>监督内保部门联系方式：</span><span name='fzzdjdganbbmlxfs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>是否注销：</span><span name='sfzx' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>注销日期：</span><span name='zxrq'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>注销原因：</span><span name='zxyy'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>备注：</span><span name='bz'  class='edit_word input_w2b'></span></li>");
	   sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zjbx' /><input type='hidden' name='openUrl' value='/dwownsydw/editmZjbxy' />");

	sb.append("</ul>");
    sb.append("<div class='clear'></div>");
	sb.append("<ul><li class='uline' ><span>重要部位信息</span>");
	sb.append("</li>");
	sb.append("<li><span class='spantitle'>部位编号：</span><span name='bwbh'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>部位名称：</span><span name='bwmc' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>部位位置：</span><span name='bwwz'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人：</span><span name='bwfzr'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人身份证号：</span><span name='bwfzrsfzh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系方式：</span><span name='bwfzrlxfs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>值班电话：</span><span name='bwzbdh' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>物防设施情况：</span><span name='wfssqk' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>确定时间：</span><span name='bwqdsj'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitle'>确定理由依据：</span><span name='bwqdlyyj'  class='edit_word input_w2b'></span></li>");
	
	sb.append("</ul>");
	return sb.toString();
};
//三级消防
function info_sjxf_(){
	$("#xfywlx").show();
	var sb = new StringBuffer();
	sb.append("<ul id='sjxfdwxx'>");
	sb.append("<li><span class='spantitleb'>监管单位类别：</span><span name='jgdwlb' dict='/common/dict/BD_D_DWXFLB' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>消防管辖：</span><span name='xfgx'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>单位使用名称：</span><span name='dwsymc' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>建筑管理单位：</span><span name='jzgldw' dict='/common/dict/D_BZ_SF' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>上级单位：</span><span name='sjdw'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>行政区划：</span><span name='xzqy' dict='/common/dict/D_BZ_XZQH_PROVINCE' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>分管级别：</span><span name='fgjb' dict='/common/dict/D_FW_XFGLJB' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>火灾危险性：</span><span name='hzwxx' dict='/common/dict/BD_D_DWXFHZWXJBDM' class='edit_word input_w2b'></span></span></li>");
	sb.append("<li><span class='spantitleb'>消防安全管理人姓名：</span><span name='xfaqglrxm'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>消防安全管理人身份证号：</span><span name='xfaqglrsfzh'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>消防安全管理人联系方式：</span><span name='xfaqglrlxfs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>消防安全责任人姓名：</span><span name='xfaqzrrxm'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>消防安全责任人身份证号：</span><span name='xfaqzrrsfzh'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>消防安全责任人联系方式：</span><span name='xfaqzrrlxfs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>固定资产(万元)：</span><span name='gdzc'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>在册职工数：</span><span name='zczgs'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>占地面积(平方米)：</span><span name='zdmj'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>建筑面积(平方米)：</span><span name='jzmj'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>地理情况：</span><span name='dlqk'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>自动消防情况：</span><span name='zdxfqk' dict='/common/dict/BD_D_ZDXFQKDM' class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>地理坐标X：</span><span name='dlzbx'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>地理坐标Y：</span><span name='dlzby'  class='edit_word input_w2b'></span></li>");
	sb.append("<li><span class='spantitleb'>备注：</span><span name='bz'  class='edit_word input_w1'></span></li>");
	
	sb.append("<li id='zddwzzjgname'><span class='spantitleb'>重点单位组织相关：</span><span name='zddwzzjgname'  class='edit_word input_w1'></span></li>");
	
	sb.append("<li id='zddwrdsj'><span class='spantitleb'>重点单位认定时间：</span><span name='zddwrdsj'  class='edit_word input_w1'></span></li>");

    sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='xf' /><input type='hidden' name='openUrl' value='/dwownsydw/editXf' /><input type='hidden' name='callback' value='info_sjxf_back' />");
		
	sb.append("</ul>");

	return sb.toString();
};

function info_sjxf_back(){
	if($("#mode_").val()=='view'&&$("#partview_").val()=="true"){
		$("#sjxfdwxx").parents("dl").find("a.info_editbtn").show();
	}
	if($("span[name='jgdwlb']").text()!="重点单位"){
		$("#zddwzzjgname").hide();
		$("#zddwrdsj").hide();
	}else{
		$("#zddwzzjgname").show();
		$("#zddwrdsj").show();
	}
}

//------------@star结束---------

//通用编辑
function edit(id,dwid,url, datagrid,title,callback,width,height){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var title_ = title?title:"修改";
	var width_ = width?width:880;
	var height_ = height?height:500;
	var callback_ = callback?callback:null;
	window.top.openWindowWithSave(false, null, window, 
   		{"_p":"#"+datagrid},
   		{
   		title: title_,
   		url: contextPath+url+'?dwid='+dwid+'&id='+id,
   		width: width_,
   		inline:true,
   		height:height_
   		}, 
   		null, callback_,null
   	);
};