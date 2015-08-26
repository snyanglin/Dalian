var JWZH = {
	ip:'http://10.80.1.117:9998/jwzh',
	login:function(uname,upass,url){
		var param = {
		  	method:'login',
		 	username:uname,
		 	password:upass,
		 	loginStyle:'NewBlueTemplate'
		}
		$.ajax({
	  	  	url:JWZH.ip+'/login.do',
	  	  	async:false,
	  	  	type:'post',
	  	  	dataType:'jsonp',
	  	  	data:param,
	  	  	jsonp:'callback',
	  		jsonpCallback:'jsonp',
	  	  	error:function(request){
	  	  	  	if(request.statusText == 'success'){
	  	  	  	  	window.open(url)
	  	  	  	}
	  	  	}
	  	});
	},
	AJXX:function(uname,upass,ajbh){
		if(null!=uname && ''!=uname && undefined != uname){
			JWZH.login(uname,upass,JWZH.ip+'/jsp/zfba/common/spFlow/viewDetai.jsp?sjbh=&ywlx=&dah='+ajbh);
		}else{
			alert('您无法登录警综平台查看案件');
		}
	}
};
