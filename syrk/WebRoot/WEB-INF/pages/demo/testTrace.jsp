<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JeasyUI测试</title>
		<link rel="stylesheet" type="text/css"
			href="<%=contextPath%>/css/trace.css"></link>
	</head>

	<body>


		<li>
			<a class="rtul_title" href="javascript:void(0);">活动轨迹</a>
			<div class="rtshow">

				<div class="timelinebody">
					<div class="timeliall">

						<!-- 
						<div class="timelicont">
							<div class="timelidiv">
								<div class="timedate">
									<span>2014-07-11 11:11:16</span>
								</div>
								<div class="timeicon"></div>
								<div class="timesjx"></div>
								<a class="timetitle" onfocus="undefined">人民路258号</a>
								<div class="jqsjmsinfo">
									<div>
										<span>测试号新增警情（警情类型：道路交通事故）</span>
									</div>
								</div>
							</div>
						</div>

						<div class="timelicont">
							<div class="timelidiv">
								<div class="timedate">
									<span>2014-07-11 11:11:16</span>
								</div>
								<div class="timeicon"></div>
								<div class="timesjx"></div>
								<a class="timetitle" onfocus="undefined">中山广场</a>
								<div class="jqsjmsinfo">
									<div>
										<span>测试号反馈警情已处置完成，协商未到达：人员已救治，现场交通以恢复</span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="timelicont">
							<div class="timelidiv">
								<div class="timedate">
									<span>2014-07-11 11:11:16</span>
								</div>
								<div class="timeicon"></div>
								<div class="timesjx"></div>
								<a class="timetitle" onfocus="undefined">美丽巷</a>
								<div class="jqsjmsinfo">
									<div>
										<span>有受害人报警，请尽快出警</span>
									</div>
								</div>
							</div>
						</div>
 						
 						-->

					</div>
				</div>
			</div>
		</li>




<script type="text/javascript">

// 活动轨迹
$.ajax({
	type: 'POST',
	url: contextPath + '/rkRyhdgjb/queryList',
	data: {zjhm: '210202199011161744'},
	success: function(data) {
		var dataJson = $.parseJSON(data);
		if (dataJson.length > 0) {
			var sb = new StringBuffer();
			for (var i = 0; i < dataJson.length; i++) {
				var dataObject = dataJson[i];
				var gjkssj = dataObject['gjkssj'];
				var gjdd = dataObject['gjdd'];
				var gjsm = dataObject['gjsm'];
				sb.append('<div class="timelicont"><div class="timelidiv"><div class="timedate"><span>' + gjkssj + '</span></div>');
				sb.append('<div class="timeicon"></div><div class="timesjx"></div>');
				sb.append('<a class="timetitle">'+ gjdd +'</a>');
				sb.append('<div class="jqsjmsinfo"><div><span>' + gjsm + '</span></div></div>');
				sb.append('</div></div>');
			}
			$('.timeliall').append(sb.toString());
		}
	},
	error: function() {
	}
});


// 人员关系
$.ajax({
	type: 'POST',
	url: contextPath + '/relationRyxx/queryList',
	data: {sfzh: '210204197001010508'},
	success: function(data) {
		var dataJson = $.parseJSON(data);
		if (dataJson.length > 0) {
			var sb = new StringBuffer();
			for (var i = 0; i < dataJson.length; i++) {
				var dataObject = dataJson[i];
				var typeName = dataObject['typeName'];
				sb.append('<div>' + typeName + '</div>');
				var listArray = dataObject['list'];
				for (var j = 0; j < listArray.length; j++) {
					sb.append('<div>' + listArray[j].title + '</div>');
				}
			}
			$('body').append(sb.toString());
		}
	},
	error: function() {
	}
});

</script>

</body>
</html>