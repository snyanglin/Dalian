<!--  
	@updateAuthor: [xu_haibo@founder.com]
	@updateDate:   [2015-7-3 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>技防检查模板</title>
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
	<table style="width:633px;border:  1px solid #95B8E7;" cellpadding="0" cellspacing="0">
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" >
				检查项目
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				检查内容
			</td>
			<td style="text-align: center;font-size: 13px;height: 40px;line-height: 2em;" class="tdbr">
				检查判据
			</td>
			<td style="text-align: center;font-size: 13px;height: 40px;line-height: 2em;" class="tdb">
				存在问题
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="5">
				安全技术防范系统档案
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				值机人员档案
				<input type="hidden" id="type_cc6d7282d1d14a8dba84bf3bdd070b12" value="cc6d7282d1d14a8dba84bf3bdd070b12" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有档案；档案有人员培训和上、离岗日期
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_cc6d7282d1d14a8dba84bf3bdd070b12" value="c7339d02f9464ca1af226f12d559f036" />
				无档案<input id="ch_c7339d02f9464ca1af226f12d559f036" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cc6d7282d1d14a8dba84bf3bdd070b12" value="5debfcf3daa842f99f421af750eb2379" />
				无人员培训记录<input id="ch_5debfcf3daa842f99f421af750eb2379" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cc6d7282d1d14a8dba84bf3bdd070b12" value="ac73eefe345d4b73bc7a21d5b85b9575" />
				无上、离岗日期<input id="ch_ac73eefe345d4b73bc7a21d5b85b9575" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				工程档案
				<input type="hidden" id="type_adedbadf6e884f27b3cf88b1e09ae6ca" value="adedbadf6e884f27b3cf88b1e09ae6ca" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有档案；档案中有方案论证、工程检验报告、竣工验收文件
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_adedbadf6e884f27b3cf88b1e09ae6ca" value="7443b55ee58d441ab69619d91cb6b340" />
				无档案<input id="ch_7443b55ee58d441ab69619d91cb6b340" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_adedbadf6e884f27b3cf88b1e09ae6ca" value="a6203d0ec6904c5c9f5eba9ceb627948" />
				档案中无方案论证、工程检验报告、竣工验收文件<input id="ch_a6203d0ec6904c5c9f5eba9ceb627948" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				巡检档案
				<input type="hidden" id="type_04121251d9a84d0fb461a7a655bc6910" value="04121251d9a84d0fb461a7a655bc6910" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有档案；档案中有巡检时间，巡检单位及人员
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_04121251d9a84d0fb461a7a655bc6910" value="51a6946eb45c4f75a6d1c0d89fdbb3c9" />
				无<input id="ch_51a6946eb45c4f75a6d1c0d89fdbb3c9" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_04121251d9a84d0fb461a7a655bc6910" value="63c78c6c058c4804ac63e15ea96d06b7" />
				无时间<input id="ch_63c78c6c058c4804ac63e15ea96d06b7" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_04121251d9a84d0fb461a7a655bc6910" value="27d76ac63c84410c8890fbbe182aec80" />
				无巡检单位及人员<input id="ch_27d76ac63c84410c8890fbbe182aec80" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				监控值班记录
				<input type="hidden" id="type_cf9b5e874d2e4b03935f4fe2bc762cd4" value="cf9b5e874d2e4b03935f4fe2bc762cd4" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有记录；记录不缺页项；不涂改；有签字
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_cf9b5e874d2e4b03935f4fe2bc762cd4" value="de3caeb9702a45f0b9483e73c192196a" />
				无记录<input id="ch_de3caeb9702a45f0b9483e73c192196a" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cf9b5e874d2e4b03935f4fe2bc762cd4" value="363e888b3eda4b3e8ba1f3731ff16e21" />
				记录缺页项<input id="ch_363e888b3eda4b3e8ba1f3731ff16e21" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cf9b5e874d2e4b03935f4fe2bc762cd4" value="cf649ac81d10402dac3d6e3d3be1e75f" />
				有涂改<input id="ch_cf649ac81d10402dac3d6e3d3be1e75f" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cf9b5e874d2e4b03935f4fe2bc762cd4" value="24e5f52ed68848269f632d439f2d6ff3" />
				无签字<input id="ch_24e5f52ed68848269f632d439f2d6ff3" type="checkbox" value="1" />
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				安全检查记录
				<input type="hidden" id="type_694303c1513942ba8e5048e2a1802b92" value="694303c1513942ba8e5048e2a1802b92" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有记录；记录中签字齐全
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_694303c1513942ba8e5048e2a1802b92" value="7a0fa7646141460b9efae5c996338542" />
				无记录<input id="ch_7a0fa7646141460b9efae5c996338542" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_694303c1513942ba8e5048e2a1802b92" value="9c35401e97dd41c18205f2ce615710fb" />
				记录中无签字<input id="ch_9c35401e97dd41c18205f2ce615710fb" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr">
				突发事件处置预案
				<input type="hidden" id="type_5f7b5029cfe44f279dc3dd8394cef863" value="5f7b5029cfe44f279dc3dd8394cef863" />
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				发生抢劫、盗窃、一般治安事件、系统故障等的处置预案
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有前述四种处置预案
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_5f7b5029cfe44f279dc3dd8394cef863" value="410c74b747ce4627be99d5c58628d34a" />
				无预案<input id="ch_410c74b747ce4627be99d5c58628d34a" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_5f7b5029cfe44f279dc3dd8394cef863" value="ffc7f8d74fe44a9eaf90d1aae56fc305" />
				预案不全<input id="ch_ffc7f8d74fe44a9eaf90d1aae56fc305" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="5">
				监控值班记录
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				交接班记录
				<input type="hidden" id="type_cdb65fa789244da2aebd1b7521616473" value="cdb65fa789244da2aebd1b7521616473" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有记录；有签字
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_cdb65fa789244da2aebd1b7521616473" value="1da8b2eba652462980b152e0ffd4e404" />
				无记录<input id="ch_1da8b2eba652462980b152e0ffd4e404" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cdb65fa789244da2aebd1b7521616473" value="9d1fe8a102224b5da37a9c78964f5b16" />
				无签字<input id="ch_9d1fe8a102224b5da37a9c78964f5b16" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				系统布、撤防记录
				<input type="hidden" id="type_3f9a18118ad344a68dd6f1e3330ace8b" value="3f9a18118ad344a68dd6f1e3330ace8b" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有布、撤时间记录
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_3f9a18118ad344a68dd6f1e3330ace8b" value="3463b339accf425dbbcbe323a939c017" />
				无记录<input id="ch_3463b339accf425dbbcbe323a939c017" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_3f9a18118ad344a68dd6f1e3330ace8b" value="3f42787323f34e4680f2eec39f7a7024" />
				记录不全<input id="ch_3f42787323f34e4680f2eec39f7a7024" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				报警记录
				<input type="hidden" id="type_8993064396fa4137a92e15f85d5a1c93" value="8993064396fa4137a92e15f85d5a1c93" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有报警时间、性质；有处置结果记录
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_8993064396fa4137a92e15f85d5a1c93" value="b4cab48c627e4476a41453938071ddf4" />
				无报警时间<input id="ch_b4cab48c627e4476a41453938071ddf4" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_8993064396fa4137a92e15f85d5a1c93" value="020a92816c6348da83852e27925c9fe6" />
				无报警性质<input id="ch_020a92816c6348da83852e27925c9fe6" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_8993064396fa4137a92e15f85d5a1c93" value="d97e223f309b4a309d6571d21967fae0" />
				无处置结果记录<input id="ch_d97e223f309b4a309d6571d21967fae0" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				故障记录
				<input type="hidden" id="type_cea662aebe1b4044b7e102b9aa40a504" value="cea662aebe1b4044b7e102b9aa40a504" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有故障时间；现象记录；维修时间；恢复使用时间的记录
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_cea662aebe1b4044b7e102b9aa40a504" value="edcee831b2b048ff977e74c328742c89" />
				无故障时间<input id="ch_edcee831b2b048ff977e74c328742c89" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cea662aebe1b4044b7e102b9aa40a504" value="fae61ca6917348468908687be7da0edf" />
				无故障现象<input id="ch_fae61ca6917348468908687be7da0edf" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cea662aebe1b4044b7e102b9aa40a504" value="066a4a68673343f98d207327449a4247" />
				无维修时间<input id="ch_066a4a68673343f98d207327449a4247" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_cea662aebe1b4044b7e102b9aa40a504" value="77ebae82d25f457bae4473fb465c45ec" />
				无恢复时间<input id="ch_77ebae82d25f457bae4473fb465c45ec" type="checkbox" value="1" />
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				演练记录
				<input type="hidden" id="type_c8198ae17ddb441f83158620a07c3bd1" value="c8198ae17ddb441f83158620a07c3bd1" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				有记录；有人防力量处置时间和效果
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_c8198ae17ddb441f83158620a07c3bd1" value="e02d8f87b43f4e49aed2e8dbc701aaf8" />
				无记录<input id="ch_e02d8f87b43f4e49aed2e8dbc701aaf8" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_c8198ae17ddb441f83158620a07c3bd1" value="fa6da6f2c92f45edbada876b852530fc" />
				记录中无处置时间<input id="ch_fa6da6f2c92f45edbada876b852530fc" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_c8198ae17ddb441f83158620a07c3bd1" value="f9472e6a1d644d1ba6690c786befb8f9" />
				记录中无处置效果<input id="ch_f9472e6a1d644d1ba6690c786befb8f9" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="2">
				重点要害部位
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				探测器防范效果
				<input type="hidden" id="type_5acaafaf38b64feb918278949683fc23" value="5acaafaf38b64feb918278949683fc23" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				探测器探测灵敏；探测器满足覆盖要求
			</td>
			<td style="text-align: left;font-size: 13px;height: 60px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_5acaafaf38b64feb918278949683fc23" value="57c676bac1f24b7687f77ca9ac85fdb0" />
				探测器不灵敏<input id="ch_57c676bac1f24b7687f77ca9ac85fdb0" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_5acaafaf38b64feb918278949683fc23" value="6fc47ae09f9a4d45887ade829c3559d4" />
				探测器不满足覆盖要求<input id="ch_6fc47ae09f9a4d45887ade829c3559d4" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				摄像机监控效果
				<input type="hidden" id="type_f104734f12004fba83c4338597ad3ebc" value="f104734f12004fba83c4338597ad3ebc" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				摄像机布设满足防范要求；图像清晰可辨
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_f104734f12004fba83c4338597ad3ebc" value="e763ea4b020b42c28331fd75db7a8770" />
				摄像机布设不满足防范要求<input id="ch_e763ea4b020b42c28331fd75db7a8770" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_f104734f12004fba83c4338597ad3ebc" value="117262e0e02e47e2bd35e44ee0e449e3" />
				图像不清晰<input id="ch_117262e0e02e47e2bd35e44ee0e449e3" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="3">
				主要通道
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				探测器防范效果
				<input type="hidden" id="type_e568f4db51864285b2d98bb030cdc4c6" value="e568f4db51864285b2d98bb030cdc4c6" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				探测器探测灵敏；探测器满足覆盖要求
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_e568f4db51864285b2d98bb030cdc4c6" value="3643780cb70e4a5095ec949704c579aa" />
				探测器不灵敏<input id="ch_3643780cb70e4a5095ec949704c579aa" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_e568f4db51864285b2d98bb030cdc4c6" value="b2d9c86c0ff045bf9a4de5a843501133" />
				探测器不满足覆盖要求<input id="ch_b2d9c86c0ff045bf9a4de5a843501133" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				出入口控制
				<input type="hidden" id="type_3ed72292c397489b98396ec46000f0c4" value="3ed72292c397489b98396ec46000f0c4" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				满足设防要求
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_3ed72292c397489b98396ec46000f0c4" value="66f8c70449d24fe4a0b49e1221812726" />
				不满足设防要求<input id="ch_66f8c70449d24fe4a0b49e1221812726" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				摄像机监控效果
				<input type="hidden" id="type_baa2a84fc45d48849518bfc4696f4edc" value="baa2a84fc45d48849518bfc4696f4edc" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				摄像机布设满足防范要求；图像清晰可辨
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_baa2a84fc45d48849518bfc4696f4edc" value="5e841c3aa6364fe1b54958a581be968e" />
				摄像机布设不满足防范要求<input id="ch_5e841c3aa6364fe1b54958a581be968e" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_baa2a84fc45d48849518bfc4696f4edc" value="43f0e331e51b4d56ac7eec002511dc02" />
				图像不清晰<input id="ch_43f0e331e51b4d56ac7eec002511dc02" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="3">
				周界
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				探测器防范效果
				<input type="hidden" id="type_42a534fccdb440a2937fea59f1b552af" value="42a534fccdb440a2937fea59f1b552af" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				探测器探测灵敏；探测器满足覆盖要求
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_42a534fccdb440a2937fea59f1b552af" value="d7b9b1d010344a6c9e09c299db024fea" />
				探测器不灵敏<input id="ch_d7b9b1d010344a6c9e09c299db024fea" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_42a534fccdb440a2937fea59f1b552af" value="c08e64888a384e54ae9783927c9d896b" />
				探测器不满足覆盖要求<input id="ch_c08e64888a384e54ae9783927c9d896b" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				出入口控制
				<input type="hidden" id="type_331789d060a14fe5bb7cca255882d089" value="331789d060a14fe5bb7cca255882d089" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				满足设防要求
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_331789d060a14fe5bb7cca255882d089" value="73d6ae1812164d61a7d986043ab886e7" />
				不满足设防要求<input id="ch_73d6ae1812164d61a7d986043ab886e7" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				摄像机监控效果
				<input type="hidden" id="type_22b83441e49e4485be4a78d987cda8ce" value="22b83441e49e4485be4a78d987cda8ce" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				摄像机布设满足防范要求；图像清晰可辨
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_22b83441e49e4485be4a78d987cda8ce" value="b7b91b09018049de8234533b62c56489" />
				摄像机布设不满足防范要求<input id="ch_b7b91b09018049de8234533b62c56489" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_22b83441e49e4485be4a78d987cda8ce" value="dfdb9eaec70d4759ace07d8491738636" />
				图像不清晰<input id="ch_dfdb9eaec70d4759ace07d8491738636" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="3">
				报警监控存储
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr"rowspan="2">
				报警、视频监控资料记录、存储效果
				<input type="hidden" id="type_b7ad5d44c70348a79073edb7e08e4800" value="b7ad5d44c70348a79073edb7e08e4800" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				记录时间准确，误差在60秒内
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_b7ad5d44c70348a79073edb7e08e4800" value="673e63fecdbf4f8c9cd59afce72b2c32" />
				不准确<input id="ch_673e63fecdbf4f8c9cd59afce72b2c32" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				记录的图像满足公安侦查取证要求
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_b7ad5d44c70348a79073edb7e08e4800" value="4a0920b2f5c548b5a7a063149cd8aeb6" />
				不满足公安侦查取证要求<input id="ch_4a0920b2f5c548b5a7a063149cd8aeb6" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				图像存储容量
				<input type="hidden" id="type_121629ed26f84412a80bab92e18335a4" value="121629ed26f84412a80bab92e18335a4" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				图像存储时间满足规定的期限要求
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_121629ed26f84412a80bab92e18335a4" value="228ecaf2580b42b6acb9b85e1fc75cd3" />
				不满足规定的存储期限要求<input id="ch_228ecaf2580b42b6acb9b85e1fc75cd3" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" >
				监控室
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				报警通信手段和实体防护措施
				<input type="hidden" id="type_e517a2b4a3c9437d9644e9f3c4036b86" value="e517a2b4a3c9437d9644e9f3c4036b86" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				两种报警手段；门、窗实体防护
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_e517a2b4a3c9437d9644e9f3c4036b86" value="6d3ed23d969e4da7a2f56674a54cb410" />
				没有两种报警手段<input id="ch_6d3ed23d969e4da7a2f56674a54cb410" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_e517a2b4a3c9437d9644e9f3c4036b86" value="86ce0b80be9b428fba15e545d596da79" />
				没有实体防护<input id="ch_86ce0b80be9b428fba15e545d596da79" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="2">
				操作使用熟练程度
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				布、撤防操作
				<input type="hidden" id="type_29db76608e9a4c85b9384a921cca3373" value="29db76608e9a4c85b9384a921cca3373" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				掌握操作程序；熟练完成布、撤防操作任务
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_29db76608e9a4c85b9384a921cca3373" value="338f58035347404daa9d7ab32f2628fd" />
				不掌握操作程序<input id="ch_338f58035347404daa9d7ab32f2628fd" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_29db76608e9a4c85b9384a921cca3373" value="4123e4e0e5544065a1e254808ab182e9" />
				布、撤防不熟练<input id="ch_4123e4e0e5544065a1e254808ab182e9" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				突发事件处置能力
				<input type="hidden" id="type_16abfef3ee974d18a562689f655870c3" value="16abfef3ee974d18a562689f655870c3" />
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
				熟练叙述处置流程；熟记报警电话号码
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<input type="hidden" id="data_16abfef3ee974d18a562689f655870c3" value="d8d8632b8f9b4ac0a53a968193ada1cd" />
				不能熟练叙述<input id="ch_d8d8632b8f9b4ac0a53a968193ada1cd" type="checkbox" value="1" /></br>
				<input type="hidden" id="data_16abfef3ee974d18a562689f655870c3" value="794cf21151994e92a2cf9ea69b58bd4b" />
				不能熟记报警电话<input id="ch_794cf21151994e92a2cf9ea69b58bd4b" type="checkbox" value="1" /></br>
			</td>
		</tr>
		<tr>
			<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" >
				检查结果
			</td>
			<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
				<input type="hidden" id="type_595584c1285745d1bf41501ae6e48df0" value="595584c1285745d1bf41501ae6e48df0" />
				<input type="hidden" id="data_595584c1285745d1bf41501ae6e48df0" value="ddc442bde6e14a55838408a281dcb31e" />
				<input id="ch_ddc442bde6e14a55838408a281dcb31e" type="checkbox" checked value="1" />合格　
				<input id="ch_ddc442bde6e14a55838408a281dcb31e" type="checkbox" value="0"/>不合格 　　　　　　　　
				<span style="border-left: 1px solid #95B8E7;line-height: 30px;"></span>
			</td>
			<td style="text-align: center;font-size: 13px;line-height: 2em;" class="tdbr">
				检查状态
			</td>
			<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
				<span id="zgfs"><input class='easyui-combobox' type='text' id='zt' name='zt' value="${entity.zt}" style="width:200px;"
   	        			data-options="url: contextPath + '/common/dict/BD_D_DWZAJCZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true"/></span>
			</td>
		</tr>
	</table>