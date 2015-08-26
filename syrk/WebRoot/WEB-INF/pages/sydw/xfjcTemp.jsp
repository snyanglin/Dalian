<!--  
	@updateAuthor: [yuguangli@founder.com]
	@updateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>消防检查模板</title>
<style>
.thhead {
	text-align: center;
	background: #e1e1e1;
	border: 1px solid #cccccc;
}

.tdbr {
	border-right: 1px solid #95B8E7;;
	border-bottom: 1px solid #95B8E7;;
}

.tdb {
	border-bottom: 1px solid #95B8E7;
}
.tdr {
	border-right: 1px solid #95B8E7;
}
</style>
<input type="hidden" id="jcxmx" name="jcxmx"/>
<table style="width:650px;border:  1px solid #95B8E7;" cellpadding="0" cellspacing="0">
	<tr>
		<td style="width: 35px;text-align: center;font-size: 13px;" class="tdbr" rowspan="5">
			单位履行消防安全职责情况
		</td>
		<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
			合法性
			<input type="hidden" id="type_5ff54d9af8e9481483fb07b66606377b" value="5ff54d9af8e9481483fb07b66606377b" />
		</td>
		<td style="text-align: left;font-size: 13px;height: 80px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="56784bd8dc33452299a60cadfe2e93fb" />
			被查建筑物名称：<textarea id="bz_56784bd8dc33452299a60cadfe2e93fb" type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 250px;border-color: #333333;overflow: hidden;"></textarea></br>
			<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="ea7bc44ea01c4ab7b75d4d70e39b58fa" />
			<input id="ch_ea7bc44ea01c4ab7b75d4d70e39b58fa" type="checkbox" value="1" />1998年9月1日之前竣工建筑且此后未改建(含装修、用途变更)</br>
			<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="c95600c912c84addb921be14e77f8852" />
			<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="b7b3051f227f4ca4b30a20c6e778fc22" />
			<input id="ch_c95600c912c84addb921be14e77f8852" type="checkbox" value="1" />依法通过消防验收　 <input id="ch_b7b3051f227f4ca4b30a20c6e778fc22" type="checkbox" value="1" />依法进行竣工验收消防备案</br>
			<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="3c28069c21f14949858d0fa579b0ae1b" />
			<span style="height: 40px;">　其他情况：</span><textarea id="bz_3c28069c21f14949858d0fa579b0ae1b" class="easyui-validatebox" style="width:507px;height: 40px;">${dwjcdata.bz}</textarea>
										<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="6298f8f73ef74df7943ad3f3499b3861" />
										<input id="ch_6298f8f73ef74df7943ad3f3499b3861" type="checkbox" value="1" />是 <input id="ch_6298f8f73ef74df7943ad3f3499b3861" type="checkbox" value="0" />否   公众聚集场所</br>
										<input type="hidden" id="data_5ff54d9af8e9481483fb07b66606377b" value="45673780c11d4236b3c4689da4aa63d7" />
　										依法通过投入使用、营业前消防安全检查　 <input id="ch_45673780c11d4236b3c4689da4aa63d7" type="checkbox" value="1" />是<input id="ch_45673780c11d4236b3c4689da4aa63d7" type="checkbox" value="0" />否
									</td>
								</tr>
								<tr>
									<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
			消防安全管理
			<input type="hidden" id="type_845cc292f0bf4189926f996c9045ab07" value="845cc292f0bf4189926f996c9045ab07" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_845cc292f0bf4189926f996c9045ab07" value="ea14bed8d32d4a0b9bc8cb8e5aa82160" />
			1.消防安全制度　　　　　 <input id="ch_ea14bed8d32d4a0b9bc8cb8e5aa82160" type="checkbox" value="1" />有　 <input id="ch_ea14bed8d32d4a0b9bc8cb8e5aa82160" type="checkbox" value="0" />无</br>
			<input type="hidden" id="data_845cc292f0bf4189926f996c9045ab07" value="94d1e33e18714478a96e05fe07224d5c" />
			2.员工消防安全教育培训　 <input id="ch_94d1e33e18714478a96e05fe07224d5c" type="checkbox" value="1" />组织开展  <input id="ch_94d1e33e18714478a96e05fe07224d5c" type="checkbox" value="0" />未组织开展</br>
			<input type="hidden" id="data_845cc292f0bf4189926f996c9045ab07" value="bd057cd9d1634c16bf5ebd8c5250eeca" />
			3.防火检查　　　　　　　 <input id="ch_bd057cd9d1634c16bf5ebd8c5250eeca" type="checkbox" value="1" />组织开展  <input id="ch_bd057cd9d1634c16bf5ebd8c5250eeca" type="checkbox" value="0" />未组织开展</br>
			<input type="hidden" id="data_845cc292f0bf4189926f996c9045ab07" value="716893bf3d654167bcfa7043466a3260" />
			4.灭火和应急疏散预案　　 <input id="ch_716893bf3d654167bcfa7043466a3260" type="checkbox" value="1" />有　  <input id="ch_716893bf3d654167bcfa7043466a3260" type="checkbox" value="0" />无</br>
			<input type="hidden" id="data_845cc292f0bf4189926f996c9045ab07" value="002f029ee6a04576b650edf0582c8e2b" />
			5.消防演练　　　　　　　 <input id="ch_002f029ee6a04576b650edf0582c8e2b" type="checkbox" value="1" />组织  <input id="ch_002f029ee6a04576b650edf0582c8e2b" type="checkbox" value="0" />未组织</br>
			<input type="hidden" id="data_845cc292f0bf4189926f996c9045ab07" value="ff4967922aac47b4ab0291fbf60efb23" />
			<span style="height: 40px;">6.其他情况：</span><textarea id="bz_ff4967922aac47b4ab0291fbf60efb23" class="easyui-validatebox" style="width:507px;height: 40px;">${dwjcdata.bz}</textarea>
		</td>
	</tr>
	<tr>
		<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
			建筑防火
			<input type="hidden" id="type_584ce5cf24cf49f78e47512ba8bf0166" value="584ce5cf24cf49f78e47512ba8bf0166" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="e6f437b4713047558366d6ab63347a93" />
			1.消防车通道　　<input id="ch_e6f437b4713047558366d6ab63347a93" type="checkbox" value="0" />畅通　     <input id="ch_e6f437b4713047558366d6ab63347a93" type="checkbox" value="1" />被堵塞、占用　 <input id="ch_e6f437b4713047558366d6ab63347a93" type="checkbox" value="2" />无</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="55bed85cbfbf41b6a76d29eb98e70e93" />
			2.疏散通道　　　<input id="ch_55bed85cbfbf41b6a76d29eb98e70e93" type="checkbox" value="0" />畅通　     <input id="ch_55bed85cbfbf41b6a76d29eb98e70e93" type="checkbox" value="1" />堵塞　               <input id="ch_55bed85cbfbf41b6a76d29eb98e70e93" type="checkbox" value="2" />锁闭</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="ffc99ace66144c7a8ce042d1eb7785f5" />
			3.安全出口　　　<input id="ch_ffc99ace66144c7a8ce042d1eb7785f5" type="checkbox" value="0" />畅通　     <input id="ch_ffc99ace66144c7a8ce042d1eb7785f5" type="checkbox" value="1" />堵塞　                <input id="ch_ffc99ace66144c7a8ce042d1eb7785f5" type="checkbox" value="2" />锁闭 <input id="ch_ffc99ace66144c7a8ce042d1eb7785f5" type="checkbox" value="3" />缺少</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="fee4141522ef4336a6d7e8dfa3d0f2a3" />
			4.防火门　　       　        <input id="ch_fee4141522ef4336a6d7e8dfa3d0f2a3" type="checkbox" value="0" />完好有效 <input id="ch_fee4141522ef4336a6d7e8dfa3d0f2a3" type="checkbox" value="1" />常闭式防火门常开  <input id="ch_fee4141522ef4336a6d7e8dfa3d0f2a3" type="checkbox" value="2" />损坏　<input id="ch_fee4141522ef4336a6d7e8dfa3d0f2a3" type="checkbox" value="3" />不涉及</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="0dc03a8c1cc7476798333d72cafb1b21" />
			5.疏散指示标志　<input id="ch_0dc03a8c1cc7476798333d72cafb1b21" type="checkbox" value="0" />完好有效 <input id="ch_0dc03a8c1cc7476798333d72cafb1b21" type="checkbox" value="1" />损坏                    <input id="ch_0dc03a8c1cc7476798333d72cafb1b21" type="checkbox" value="2" />缺少 <input id="ch_0dc03a8c1cc7476798333d72cafb1b21" type="checkbox" value="3" />无</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="faadd2a7e10e4d1593a5b30556a1924f" />
			6.应急照明　　　<input id="ch_faadd2a7e10e4d1593a5b30556a1924f" type="checkbox" value="0" />完好有效 <input id="ch_faadd2a7e10e4d1593a5b30556a1924f" type="checkbox" value="1" />损坏                    <input id="ch_faadd2a7e10e4d1593a5b30556a1924f" type="checkbox" value="2" />缺少 <input id="ch_faadd2a7e10e4d1593a5b30556a1924f" type="checkbox" value="3" />无</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="81867f2e540f45049b64e7dd71e4861c" />
			7.人员密集场所外墙门窗上是否设置影响逃生、灭火救援的障碍物　　<input id="ch_81867f2e540f45049b64e7dd71e4861c" type="checkbox" value="0" />否 <input id="ch_81867f2e540f45049b64e7dd71e4861c" type="checkbox" value="1" />是<input id="ch_81867f2e540f45049b64e7dd71e4861c" type="checkbox" value="2" />不涉及</br>
			<input type="hidden" id="data_584ce5cf24cf49f78e47512ba8bf0166" value="ab1319c54cd74c93aee5fe4756506864" />
			<span style="height: 40px;">8.其他情况：</span><textarea id="bz_ab1319c54cd74c93aee5fe4756506864" class="easyui-validatebox" style="width:507px;height: 40px;">${dwjcdata.bz}</textarea>
		</td>
	</tr>
	<tr>
		<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
			消防设施
			<input type="hidden" id="type_cdb5e896fa6d42c8a845516998c93461" value="cdb5e896fa6d42c8a845516998c93461" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_cdb5e896fa6d42c8a845516998c93461" value="a0799162f5fc409996899d98c68f9ed6" />
			1.室内消火栓　　<input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="0" />未设置 <input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="1" />完好有效 <input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="2" />损坏 <input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="3" />无水</br>
			　　　　　　　　<input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="4" />配件不齐 <input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="5" />被遮挡、圈占<input id="ch_a0799162f5fc409996899d98c68f9ed6" type="checkbox" value="6" />不涉及</br>
			<input type="hidden" id="data_cdb5e896fa6d42c8a845516998c93461" value="7b89487253aa490eaf48069004e68f3e" />
			2.灭火器　　　　<input id="ch_7b89487253aa490eaf48069004e68f3e" type="checkbox" value="0" />未配置 <input id="ch_7b89487253aa490eaf48069004e68f3e" type="checkbox" value="1" />完好有效 <input id="ch_7b89487253aa490eaf48069004e68f3e" type="checkbox" value="2" />失效 <input id="ch_7b89487253aa490eaf48069004e68f3e" type="checkbox" value="3" />缺少<input id="ch_7b89487253aa490eaf48069004e68f3e" type="checkbox" value="4" />配置类型错误 <input id="ch_7b89487253aa490eaf48069004e68f3e" type="checkbox" value="5" />设置地点不当</br>
			<input type="hidden" id="data_cdb5e896fa6d42c8a845516998c93461" value="cfb57068dde842f28de4b96dd81364de" />
			3.建筑消防设施　<input id="ch_cfb57068dde842f28de4b96dd81364de" type="checkbox" value="0" />定期维修保养并记录 <input id="ch_cfb57068dde842f28de4b96dd81364de" type="checkbox" value="0" />无记录<input id="ch_cfb57068dde842f28de4b96dd81364de" type="checkbox" value="1" />未定期维修保养　　 <input id="ch_cfb57068dde842f28de4b96dd81364de" type="checkbox" value="2" />不涉及</br>
			<input type="hidden" id="data_cdb5e896fa6d42c8a845516998c93461" value="c2505c8a7edd4e938efa30b47951c160" />
			4.物业服务企业对管理区域内共用消防设施是否维护管理　<input id="ch_c2505c8a7edd4e938efa30b47951c160" type="checkbox" value="1" />是　 <input id="ch_c2505c8a7edd4e938efa30b47951c160" type="checkbox" value="0" />否　 <input id="ch_c2505c8a7edd4e938efa30b47951c160" type="checkbox" value="2" />不涉及
		</td>
	</tr>
	<tr>
		<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
			危险品管理
			<input type="hidden" id="type_3d2696726e10433996d8c605972f39f8" value="3d2696726e10433996d8c605972f39f8" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_3d2696726e10433996d8c605972f39f8" value="1efee3622dd7410281b2a32bb5ee2e6a" />
			1.是否存在违反规定使用明火作业或在具有火灾、爆炸危险的场所吸烟、使用明火</br>
			　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<input id="ch_1efee3622dd7410281b2a32bb5ee2e6a" type="checkbox" value="0" />否 <input id="ch_1efee3622dd7410281b2a32bb5ee2e6a" type="checkbox" value="1" />是 <input id="ch_1efee3622dd7410281b2a32bb5ee2e6a" type="checkbox" value="2" />不涉及</br>
			<input type="hidden" id="data_3d2696726e10433996d8c605972f39f8" value="99189cd79a924ae08157f18aa52bca7b" />
			2.是否存在违反消防安全规定进入生产、储存易燃易爆危险品场所　　　　<input id="ch_99189cd79a924ae08157f18aa52bca7b" type="checkbox" value="0" />否 <input id="ch_99189cd79a924ae08157f18aa52bca7b" type="checkbox" value="1" />是 <input id="ch_99189cd79a924ae08157f18aa52bca7b" type="checkbox" value="2" />不涉及</br>
			<input type="hidden" id="data_3d2696726e10433996d8c605972f39f8" value="cbce9c5f8dcb4da69c84df9ca1d35db3" />
			3.生产、储存、经营易燃易爆危险品的场所是否与居住场所设置在同一建筑物内</br>
			　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<input id="ch_cbce9c5f8dcb4da69c84df9ca1d35db3" type="checkbox" value="0" />否 <input id="ch_cbce9c5f8dcb4da69c84df9ca1d35db3" type="checkbox" value="1" />是 <input id="ch_cbce9c5f8dcb4da69c84df9ca1d35db3" type="checkbox" value="2" />不涉及</br>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
			村(居)民委 员 会履行消防安全职责情况
			<input type="hidden" id="type_bd42e43bfabc490c925aa94df8427ca9" value="bd42e43bfabc490c925aa94df8427ca9" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="d47e6ecf99ed4f62b1f895992200f21d" />
			1.消防安全管理人　　　<input id="ch_d47e6ecf99ed4f62b1f895992200f21d" type="checkbox" value="0" />确定 <input id="ch_d47e6ecf99ed4f62b1f895992200f21d" type="checkbox" value="1" />未确定</br>
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="759f8aa89b1240b987b34bdf39bb9c13" />
			2.消防安全工作制度　　<input id="ch_759f8aa89b1240b987b34bdf39bb9c13" type="checkbox" value="0" />有　 <input id="ch_759f8aa89b1240b987b34bdf39bb9c13" type="checkbox" value="1" />无</br>
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="c53a792f12664b0b8dbc7c642b3477ba" />
			3.防火安全公约　　　　<input id="ch_c53a792f12664b0b8dbc7c642b3477ba" type="checkbox" value="0" />有　 <input id="ch_c53a792f12664b0b8dbc7c642b3477ba" type="checkbox" value="1" />无</br>
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="03ec57b2b4fe4be6970a0343c62620d1" />
			4.消防宣传教育　　　　<input id="ch_03ec57b2b4fe4be6970a0343c62620d1" type="checkbox" value="0" />开展 <input id="ch_03ec57b2b4fe4be6970a0343c62620d1" type="checkbox" value="1" />未开展</br>
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="25b358db9b4a43ad8860b223a0c77608" />
			5.防火安全检查　　　　<input id="ch_25b358db9b4a43ad8860b223a0c77608" type="checkbox" value="0" />开展 <input id="ch_25b358db9b4a43ad8860b223a0c77608" type="checkbox" value="1" />未开展</br>
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="b728f383f35d426dab630388ddedbd20" />
			6.消防水源、消防车通道、消防器材　　　　<input id="ch_b728f383f35d426dab630388ddedbd20" type="checkbox" value="0" />维护管理 <input id="ch_b728f383f35d426dab630388ddedbd20" type="checkbox" value="1" />未维护管理</br>
			<input type="hidden" id="data_bd42e43bfabc490c925aa94df8427ca9" value="02400b1743834733b777eaac4edbe181" />
			7.多种形式消防组织　　<input id="ch_02400b1743834733b777eaac4edbe181" type="checkbox" value="0" />建立 <input id="ch_02400b1743834733b777eaac4edbe181" type="checkbox" value="1" />未建立</br>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
			责令改正情况
			<input type="hidden" id="type_844d4547ef24499da73f609d400a2624" value="844d4547ef24499da73f609d400a2624" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_844d4547ef24499da73f609d400a2624" value="5fea6576d29d425b9b3f71de1b41403f" />
			制发的法律文书名称和编号：<textarea type="text" id="bz_5fea6576d29d425b9b3f71de1b41403f" class="easyui-validatebox" style="line-height: 23px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 160px;border-color: #333333;overflow: hidden;"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
			移送公安消防机构处理的内容
			<input type="hidden" id="type_aff88a7914b14979970d66096f31f1e5" value="aff88a7914b14979970d66096f31f1e5" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_aff88a7914b14979970d66096f31f1e5" value="5535c752fb2e47fbb732c661b31f03c4" />
			发现的下列第<input type="text"  id="fxdxld" class="easyui-validatebox" style="text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 40px;border-color: #333333;line-height: 22px;" readOnly="readonly"/>项消防安全违法行为，移送<textarea   class="easyui-validatebox" id="bz_5535c752fb2e47fbb732c661b31f03c4" style="text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;line-height: 24px;"></textarea>依法处理：</br>
			<input type="hidden" id="data_aff88a7914b14979970d66096f31f1e5" value="cfbb02a6fe8c424f8502fb1c7cbb8e62" />
			<input id="ch_cfbb02a6fe8c424f8502fb1c7cbb8e62" type="checkbox" value="0" />1.建筑物未依法通过公安机关消防机构消防验收，擅自投入使用；</br>
			<input id="ch_cfbb02a6fe8c424f8502fb1c7cbb8e62" type="checkbox" value="1" />2.建筑物未依法进行竣工验收消防备案；</br>
			<input id="ch_cfbb02a6fe8c424f8502fb1c7cbb8e62" type="checkbox" value="2" />3.公众聚集场所未依法通过使用、营业前消防安全检查，擅自投入使用、营业。</br>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
			建筑、单位、场所类型
			<input type="hidden" id="type_2fa7857f842947d0a53bacb8b14eee4d" value="2fa7857f842947d0a53bacb8b14eee4d" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
			<input type="hidden" id="data_2fa7857f842947d0a53bacb8b14eee4d" value="c4fd6dcde38d4a1f95b68c5fa29110f5" />
			<input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="0" />人员密集场所　　  <input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="1" />高层公共建筑　　  　　<input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="2" />高层居住建筑 <input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="3" />地下建筑</br>
			<input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="4" />在建工程施工工地 <input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="5" />节能综合工程施工现场                    <input id="ch_c4fd6dcde38d4a1f95b68c5fa29110f5" type="checkbox" value="6" />消防控制室 </br>
			注：该选项用于查询统计模块中大排查、大整治统计计算 
		</td>
	</tr>
	<tr>
		<td colspan="2" style="width: 60px;height:30px;text-align: center;font-size: 13px;" class="tdr">
			检查结果
			<input type="hidden" id="type_e669031c589a44cb970fcb2cecee6025" value="e669031c589a44cb970fcb2cecee6025" />
		</td>
		<td style="text-align: left;font-size: 13px;line-height: 2em;">
			<input type="hidden" id="data_e669031c589a44cb970fcb2cecee6025" value="a446ffe0b10c494db6b2b12b832fc8ca" />
			<input id="ch_a446ffe0b10c494db6b2b12b832fc8ca" type="checkbox" checked value="1" />合格　<input id="ch_a446ffe0b10c494db6b2b12b832fc8ca" type="checkbox" value="0"/>不合格 　　　　　　　　
			<span style="border-left: 1px solid #95B8E7;height: 30px;line-height: 30px;"></span><span id="zgfs">　检查状态 <input class='easyui-combobox' type='text' id='zt' name='zt' value="${entity.zt}" style="width:200px;"
  	        			data-options="url: contextPath + '/common/dict/BD_D_ZGFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true"/></span>
		</td>
	</tr>
</table>