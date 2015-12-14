var videomod = function(){
	this.maxMultiVideoCount = 1;//播放视频个数限制
	this.Screen = 1;//分屏
	
};

videomod.prototype.videoPlay = function(multiVideoInfo){
	if(multiVideoInfo=="" || typeof multiVideoInfo =="undefined"){
  		alert("视频参数缺失，无法播放！");
  		window.close();
  	}else {
	  	var mviCount = 0;
	  	var mviArr =  multiVideoInfo.split(",");
	  	mviCount = mviArr.length;
	  	if(mviCount<=this.maxMultiVideoCount){
	  		try{
	  			MegaWebPlayer.Screen= this.Screen;//分屏
	  			stopPlayVideo(); //播放之前先关闭所有事实视频；
		  		for(var i=0;i<mviCount;i++){
			  		MegaWebPlayer.FocusWindow=0+i;
			  		var video_id=mviArr[i];	
			  		video_start(video_id);	  
		  		}
	  		}catch(e){
	  			location.href="download/download.html";
	  		}
	  	}else {
	  		alert("最多可以同时打开"+this.maxMultiVideoCount+"个视频信息！");
	  	}
  	}
};