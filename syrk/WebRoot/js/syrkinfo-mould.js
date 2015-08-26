var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";
/************************************select t.*, t.rowid from SYS_XXZSNRB t;********************/



/****************************************************01-常住人口信息******************************************************************************************/
//常住信息
function info_czrkxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul><li><span class='spantitle'>是否人户一致：</span><span name='sfrhyzdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>籍贯国家：</span><span name='jggjdqdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>籍贯：</span><span name='jgssxdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生地国家：</span><span name='csdgjhdqdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生地：</span><span name='csdssxdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户口性质：</span><span name='hkxzfldm' dict='/common/dict/ZA_D_HKXZFLDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户号：</span><span name='hh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>与户主关系：</span><span name='yhzgxdm' dict='/common/dict/GB_D_JTGXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户籍地：</span><span name='hjd_dzxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住地：</span><span name='jzd_dzxz'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学历：</span><span name='xldm' dict='/common/dict/GB_D_XLDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>婚姻状况：</span><span name='hyzkdm' dict='/common/dict/GB_D_HYZKDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/GB_D_ZZMMDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>宗教信仰：</span><span name='zjxydm' dict='/common/dict/ZA_D_ZJXYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>兵役状况：</span><span name='byzkdm' dict='/common/dict/ZA_D_BYQKDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>血型：</span><span name='xxdm' dict='/common/dict/ZA_D_XXDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业：</span><span name='zy'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位：</span><span name='gzdw'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>迁入日期：</span><span name='lbsqk_qlrrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>迁入原因：</span><span name='lbsqk_qyldyydm' dict='/common/dict/ZA_D_RKQYYYDM'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>来自地：</span><span name='lbsqk_lzd_dzxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>来自地国家：</span><span name='lbsqk_lzd_gjhdqdm'  dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='czrkxxb' /><input type='hidden' name='editUrl' value='/syrkCzrkxxb/{id}' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};



/****************************************************02-寄住人口信息******************************************************************************************/
//寄住人口
function info_jzrkxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul><li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户籍地：</span><span name='hjd_dzxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住地：</span><span name='jzd_dzxz'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>寄住类别：</span><span name='jzlbdm' dict='/common/dict/BD_D_JZLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>寄住原因：</span><span name='jzyydm' dict='/common/dict/BD_D_JZYYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>寄住开始日期：</span><span name='jz_ksrq01' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>预计离开日期：</span><span name='yj_lksj'  class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业：</span><span name='zy'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位：</span><span name='gzdw'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住处所：</span><span name='zjzcsfldm'  dict='/common/dict/ZA_D_JZCSFLYDM'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房屋承租情况：</span><span name='fwczqkdm' dict='/common/dict/ZA_D_FWCZQKDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>与房主关系：</span><span name='chzr_yfzgx_rygxdm' dict='/common/dict/XZ_D_RYGXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件种类：</span><span name='fz_cyzjdm' dict='/common/dict/KX_D_CYZJDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件号码：</span><span name='fz_zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主姓名：</span><span name='fz_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主联系电话：</span><span name='fz_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主居住地址：</span><span name='fz_jzd_dzxz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jzrkxxb' /><input type='hidden' name='editUrl' value='/syrkJzrkxxb/{id}' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};



/****************************************************03-流动人口信息******************************************************************************************/
//流动人口信息
function info_ldrkxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul><li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>曾用名：</span><span name='cym' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户籍地：</span><span name='hjd_dzxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住地：</span><span name='jzd_dzxz'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学历：</span><span name='xldm' dict='/common/dict/GB_D_XLDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>婚姻状况：</span><span name='hyzkdm' dict='/common/dict/GB_D_HYZKDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/GB_D_ZZMMDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户口所在地类型：</span><span name='hkszdlxdm' dict='/common/dict/ZA_D_DYCXSXDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住处所：</span><span name='zjzcsfldm' dict='/common/dict/ZA_D_JZCSFLYDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住事由：</span><span name='zjzsydm' dict='/common/dict/ZA_D_RKQYYYDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>迁入日期：</span><span name='lbsqk_qlrrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>迁入原因：</span><span name='lbsqk_qyldyydm' dict='/common/dict/ZA_D_RKQYYYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>来自国家：</span><span name='lzd_gjhdqdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>来自地：</span><span name='lzd_dzxz'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>区域范围：</span><span name='qyfwdm' dict='/common/dict/KX_ZA_RKQYQYFWDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位：</span><span name='gzdw' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业：</span><span name='zy'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房屋承租情况：</span><span name='fwczqkdm'  dict='/common/dict/ZA_D_FWCZQKDM'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>与房主关系：</span><span name='chzr_yfzgx_rygxdm'   dict='/common/dict/XZ_D_RYGXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件种类：</span><span name='fz_cyzjdm'  dict='/common/dict/KX_D_CYZJDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件号码：</span><span name='fz_zjhm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主姓名：</span><span name='fz_xm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主联系电话：</span><span name='fz_lxdh' class='edit_word input_w1'></span></li>");
	//sb.append("<li><span class='spantitle'>房主外文姓：</span><span name='fz_wwx' class='edit_word input_w1'></span></li>");
	//sb.append("<li><span class='spantitle'>房主外文名：</span><span name='fz_wwm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主居住地：</span><span name='fz_jzd_dzxz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='ldrkxxb' /><input type='hidden' name='editUrl' value='/syrkLdrkxxb/{id}' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jzzblxxb' level='2'><li class='uline' ><span>居住证信息</span> <a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jzzblxxb' /><input type='hidden' name='openUrl' value='/jzzblxxb/add' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};



/****************************************************04-境外人员******************************************************************************************/
//境外人员信息
function info_jwryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>住房种类：</span><span name='zjzcsfldm' dict='/common/dict/ZA_D_JZCSFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>身份证号码：</span><span name='qt_sfzhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>入宿日期：</span><span name='rjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>拟离开日期：</span><span name='qztjl_jzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主身份类别：</span><span name='fz_sflb' dict='/common/dict/D_JWRY_FZSFLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件种类：</span><span name='fz_cyzjdm'  dict='/common/dict/KX_D_CYZJDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件号码：</span><span name='fz_zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主姓名：</span><span name='fz_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主联系电话：</span><span name='fz_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主国籍：</span><span name='fz_gjdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主性别：</span><span name='fz_xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主出生日期：</span><span name='fz_csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主外文姓：</span><span name='fz_wwx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主外文名：</span><span name='fz_wwm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>留宿单位：</span><span name='lsdw_dwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>接待单位：</span><span name='jddw_dwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>留宿单位联系电话：</span><span name='lsdw_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>接待单位联系电话：</span><span name='jddw_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>紧急情况联系人：</span><span name='lxr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>紧急情况联系电话：</span><span name='lxr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w2'></span></li>");
	/*sb.append("<li><span class='spantitle'>居住地：</span><span name='jzd_dzxz'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件截止日期：</span><span name='zj_jzrq'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>签证签发机关：</span><span name='qzjlxkqfjgmc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>签证截止日期：</span><span name='qzjlxk_jzrq'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住事由：</span><span name='zjzsydm'  dict='/common/dict/ZA_D_RKQYYYDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住处所：</span><span name='zjzcsfldm' dict='/common/dict/ZA_D_JZCSFLYDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>住宿日期：</span><span name='zsrq'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否常住：</span><span name='jwryczbs' dict='/common/dict/BD_D_SFDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>入境口岸：</span><span name='rjkadm' dict='/common/dict/CRJ_D_RCJKADM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>拟离开日期：</span><span name='nlkrq'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>来自国家：</span><span name='lzgjdqdm' dict='/common/dict/GB_D_GJHDQDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>外国人居留事由：</span><span name='wgrjlsydm'   dict='/common/dict/CRJ_D_WGRJLSYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>境外人员入境事由：</span><span name='jwryrjsydm'  dict='/common/dict/CRJ_D_JWRYRJSYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>入境登记身份：</span><span name='jwryrjdjsfdm'  dict='/common/dict/CRJ_D_JWRYRJDJSFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作许可登记：</span><span name='gzxkdj'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位：</span><span name='gzdw_dwmc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位联系电话：</span><span name='gzdw_lxdh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>留宿单位：</span><span name='lsdw_dwmc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>留宿单位联系电话：</span><span name='lsdw_lxdh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>接待单位：</span><span name='jddw_dwmc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>接待单位联系电话：</span><span name='jddw_lxdh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否非法入境：</span><span name='sfffrjdm' dict='/common/dict/BD_D_SFDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否非法居留：</span><span name='sfffjldm' dict='/common/dict/BD_D_SFDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否非法就业：</span><span name='sfffjy' dict='/common/dict/BD_D_SFDM'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房屋承租情况：</span><span name='fwczqkdm'  dict='/common/dict/ZA_D_FWCZQKDM'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>与房主关系：</span><span name='chzr_yfzgx_rygxdm'   dict='/common/dict/XZ_D_RYGXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件种类：</span><span name='fz_cyzjdm'  dict='/common/dict/KX_D_CYZJDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件号码：</span><span name='fz_zjhm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主姓名：</span><span name='fz_xm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主联系电话：</span><span name='fz_lxdh' class='edit_word input_w1'></span></li>");
	//sb.append("<li><span class='spantitle'>房主外文姓：</span><span name='fz_wwx' class='edit_word input_w1'></span></li>");
	//sb.append("<li><span class='spantitle'>房主外文名：</span><span name='fz_wwm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主居住地：</span><span name='fz_jzd_dzxz' class='edit_word input_w1'></span></li>");*/
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jwryxxb' /><input type='hidden' name='editUrl' value='/syrkJwryxxb/{id}' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

/****************************************************05-未落户人员******************************************************************************************/
//未落常住人口信息
function info_wlczrkxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>曾用名：</span><span name='cym' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学历：</span><span name='xldm' dict='/common/dict/GB_D_XLDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>婚姻状况：</span><span name='hyzkdm' dict='/common/dict/GB_D_HYZKDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/GB_D_ZZMMDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>宗教信仰：</span><span name='zjxydm' dict='/common/dict/ZA_D_ZJXYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>兵役状况：</span><span name='byzkdm' dict='/common/dict/ZA_D_BYQKDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>血型：</span><span name='xxdm' dict='/common/dict/ZA_D_XXDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位：</span><span name='gzdw' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业：</span><span name='zy'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生地国家：</span><span name='csdgjhdqdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生地：</span><span name='csdssxdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住地：</span><span name='jzd_dzxz'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>未落户原因：</span><span name='wlhyydm'  dict='/common/dict/ZA_D_WLHYYDM'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住处所：</span><span name='zjzcsfldm'  dict='/common/dict/ZA_D_JZCSFLYDM'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房屋承租情况：</span><span name='fwczqkdm'  dict='/common/dict/ZA_D_FWCZQKDM'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>与房主关系：</span><span name='chzr_yfzgx_rygxdm'   dict='/common/dict/XZ_D_RYGXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件种类：</span><span name='fz_cyzjdm'  dict='/common/dict/KX_D_CYZJDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房主证件号码：</span><span name='fz_zjhm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主姓名：</span><span name='fz_xm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主联系电话：</span><span name='fz_lxdh' class='edit_word input_w1'></span></li>");
	//sb.append("<li><span class='spantitle'>房主外文姓：</span><span name='fz_wwx' class='edit_word input_w1'></span></li>");
	//sb.append("<li><span class='spantitle'>房主外文名：</span><span name='fz_wwm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>房主居住地：</span><span name='fz_jzd_dzxz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='wlhryxxb' /><input type='hidden' name='editUrl' value='/syrkWlhryxxb/{id}' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

/****************************************************人员相关信息******************************************************************************************/

//人员相关信息 
function info_xgxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_rylxfsxxb' level='2'><li class='uline' ><span>联系方式</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rylxfsxxb' /><input type='hidden' name='openUrl' value='/ryRylxfsxxb/add' /><input type='hidden' name='editUrl' value='/ryRylxfsxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_rybmchxxb' level='2'><li class='uline' ><span>人员别名绰号</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rybmchxxb' /><input type='hidden' name='openUrl' value='/ryRybmchxxb/add' /><input type='hidden' name='editUrl' value='/ryRybmchxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_ryzjxxb' level='2'><li class='uline' ><span>证件信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ryzjxxzb' /><input type='hidden' name='openUrl' value='/ryRyzjxxb/add' /><input type='hidden' name='editUrl' value='/ryRyzjxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_ryxysfxxb' level='2'><li class='uline' ><span>虚拟身份</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ryxysfxxb' /><input type='hidden' name='openUrl' value='/ryRyxnsfxxb/add' /><input type='hidden' name='editUrl' value='/ryRyxnsfxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_ryjlxxb' level='2'><li class='uline' ><span>主要经历</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ryjlxxb' /><input type='hidden' name='openUrl' value='/ryRyjlxxb/add' /><input type='hidden' name='editUrl' value='/ryRyjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_ryhykxxb' level='2'><li class='uline' ><span>会员卡</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ryhykxxb' /><input type='hidden' name='openUrl' value='/ryRyhykxxb/add' /><input type='hidden' name='editUrl' value='/ryRyhykxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	

	return sb.toString();
}
//居住证办理信息
function info_jzzblxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>办理人：</span><span name='blr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>办理日期：</span><span name='jzzblrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>签发日期：</span><span name='jzz_qfrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有效期截止日期：</span><span name='yxq_jzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>办理状态：</span><span name='jzz_blztdm'  dict='/common/dict/BD_D_JZZBLZTDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>领取方式：</span><span name='jzz_lqfsdm' dict='/common/dict/BD_D_JZZLQFSDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>领取日期：</span><span name='jzz_lqrq'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>快递公司：</span><span name='jzz_kdgs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>快递收件人：</span><span name='jzz_kdsjr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>快递联系电话：</span><span name='jzz_kdlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>快递地址：</span><span name='jzz_kddz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>快递单号：</span><span name='jzz_kddh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>制证人：</span><span name='zzr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}


//人员证件信息
function info_ryzjxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul><li><span class='spantitle'>证件种类：</span><span name='cyzjdm' dict='/common/dict/KX_D_CYZJDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件取得时间：</span><span name='zjqdsj'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件有效期：</span><span name='zjyxq'  class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//人员联系方式
function info_rylxfsxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>联系方式类型：</span><span name='lxfslxdm' dict='/common/dict/BD_D_LXFSLXDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>联系方式：</span><span name='lxfs' class='edit_word input_w2'></span></li>"); 
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//人员别名绰号
function info_rybmchxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>别名绰号类型：</span><span name='bmchlxdm' dict='/common/dict/BD_D_BMCHLXDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>别名绰号：</span><span name='bmch' class='edit_word input_w2'></span></li>"); 
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//人员经历信息 
function info_ryjlxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>经历类型：</span><span name='jllxdm' dict='/common/dict/BD_D_JLLXDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>所在单位：</span><span name='dwmc' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>开始时间：</span><span name='kssj' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>结束时间：</span><span name='jssj' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>职业：</span><span name='zwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经历情况：</span><span name='jlqk' class='edit_word input_w1'></span></li>"); 
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//会员卡信息
function info_ryhykxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>发卡单位：</span><span name='fkdwmc' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>会员卡号：</span><span name='hyk_kh' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>会员卡获取时间：</span><span name='hyk_hqsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有效期日期：</span><span name='hyk_yxqjzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>会员卡消费方式：</span><span name='hyk_xffsdm' dict='/common/dict/BD_D_HYKXFFSDM'    class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>会员卡原价：</span><span name='hyk_yjz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>会员卡现价：</span><span name='hyk_xjz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>会员卡注册人：</span><span name='hyk_zcr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否实名：</span><span name='sfsmdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//主要交往人员信息
function info_ryzyjwryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件种类：</span><span name='cyzjdm'  dict='/common/dict/KX_D_CYZJDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>籍贯国家：</span><span name='jggjdqdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>籍贯：</span><span name='jgssxdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住地址：</span><span name='jzd_dzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>工作单位：</span><span name='gzdw' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业：</span><span name='zy' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>人员关系：</span><span name='rygxdm' dict='/common/dict/XZ_D_RYGXDM'class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
};


//虚拟身份信息
function info_ryxysfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>账户类型：</span><span name='zhlxdm' dict='/common/dict/BD_ZHLXDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>账户号码：</span><span name='zhhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>账户名称：</span><span name='zhmc' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>账户开户单位：</span><span name='zhdwmc' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>账户注册日期：</span><span name='zhzcrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>账户有效日期：</span><span name='zhyxrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>账户注册人：</span><span name='zhzcr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否实名：</span><span name='sfsmdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
};

/****************************************************家庭成员交往人员信息******************************************************************************************/
function info_ryjtcy_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_ryjtcyxxb' level='2'><li class='uline' ><span>家庭成员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ryjtcyxxb' /><input type='hidden' name='openUrl' value='/ryRyjtcyxxb/add' /><input type='hidden' name='editUrl' value='/ryRyjtcyxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_ryzyjwryxxb' level='2'><li class='uline' ><span>主要交往人员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ryzyjwryxxb' /><input type='hidden' name='openUrl' value='/ryZyjwryxxb/add' /><input type='hidden' name='editUrl' value='/ryZyjwryxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//家庭成员信息
function info_ryjtcyxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件种类：</span><span name='cyzjdm'  dict='/common/dict/KX_D_CYZJDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>籍贯国家：</span><span name='jggjdqdm' dict='/common/dict/GB_D_GJHDQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>籍贯：</span><span name='jgssxdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>居住地址：</span><span name='jzd_dzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>服务处所：</span><span name='fwcs' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>职业类别：</span><span name='zylbdm' dict='/common/dict/GB_D_ZYFLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职业：</span><span name='zy' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>人员关系：</span><span name='rygxdm' dict='/common/dict/XZ_D_RYGXDM'class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
};

/****************************************************体貌特征信息******************************************************************************************/
function info_tmtz_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>血型：</span><span name='xxdm' dict='/common/dict/BD_D_XXDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>身高：</span><span name='sg' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>体重：</span><span name='tz' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>体型：</span><span name='txdm' dict='/common/dict/BD_D_TMTZDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>脸型：</span><span name='lxdm' dict='/common/dict/BD_D_TMTZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>足长：</span><span name='zc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>鞋号：</span><span name='xh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>体貌特征描述：</span><span name='tmtzms'  class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='rytmtzxxb' /><input type='hidden' name='openUrl' value='/ryRytmtzxxb/add' /><input type='hidden' name='editUrl' value='/ryRytmtzxxb/{id}' />");
	sb.append("</ul>");
	sb.append("<ul url='info_rytbtstzxxb' level='2'><li class='uline' ><span>体表特殊特征</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rytbtstzxxb' /><input type='hidden' name='openUrl' value='/ryRytbtstzxxb/add' /><input type='hidden' name='editUrl' value='/ryRytbtstzxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_tbtsbjxxb' level='2'><li class='uline' ><span>体表特殊标记</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='tbtsbjxxb' /><input type='hidden' name='openUrl' value='/ryRytbtsbjxxb/add' /><input type='hidden' name='editUrl' value='/ryRytbtsbjxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//体表特殊特
function info_rytbtstzxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>特殊体貌特征类型：</span><span name='tstmtzlxdm' dict='/common/dict/BD_D_TMTZDM'   class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>特殊体貌特征：</span><span name='tstmtzdm'  dict='/common/dict/BD_D_TMTZDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>特殊体貌特征：</span><span name='tstzms' class='edit_word input_w2'></span></li>"); 
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
};
//特殊标记
function info_tbtsbjxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>人体部位：</span><span name='tbbj_rtbwdm' dict='/common/dict/XZ_D_RTBWMCDM'    class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>方位：</span><span name='tbbjfwdm'  dict='/common/dict/BD_D_TBBJFWDM'  class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>数量：</span><span name='tbbj_sldm' dict='/common/dict/BD_D_TBBJSLDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>体表标记：</span><span name='tbbjdm' dict='/common/dict/BD_D_TBBJDM' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>体表特殊标记描述：</span><span name='tbtsbjms'  class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
};


/****************************************************附件信息******************************************************************************************/
//附件信息
function info_syrkfj_(){
	var sb = new StringBuffer();
	sb.append("<ul level='1'>");
	sb
			.append("<input type='hidden' name='id' /><input type='hidden'  name='method' fj='true' value='fjxx' /><input type='hidden' name='openUrl' value='/syrkEdit/edit' />");
	sb.append("</ul>");
	return sb.toString();
}



