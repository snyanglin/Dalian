var ip=SysConfig.VIDEO_IP;
var port=SysConfig.VIDEO_PORT;
//var cameraID="0000000000200000000000002710229:0000000000200000000000002550088:10.1.18.149:028001";       //老平台ID
//var cameraID="0000000000200000000000000590279:0000000000200000000000000590086:10.1.18.155:010001";
var startTime="2011-11-01 17:13:00";
var endTime="2011-11-01 17:14:00";
var savePath="";
//时实
         function video_start(cameraID){
	         MegaWebPlayer.SourceAddr ="<SourceAddr><IP>"+ip+"</IP><Port>"+port+"</Port><CameraID>"+cameraID+"</CameraID><SessionID>111</SessionID></SourceAddr>";
          }
         
//历史
		 function video_start_history()
				{
			 MegaWebPlayer.SourceAddr=
                     "<SourceAddr><IP>"+ip+"</IP><Port>"+port+"</Port><CameraID>"+cameraID+"</CameraID><TimeBegin>"+startTime+"</TimeBegin><TimeEnd>"+endTime+"</TimeEnd><SessionID></SessionID></SourceAddr>";
				}
//获取保存路径
		function video_selectpath()
{
	  savePath=null;
    var SelectedPath=MegaWebPlayer.SelectPath;    
    if(SelectedPath.length!=0){
    	savePath = SelectedPath;
    	}    
}

///抓图
function video_cap(){	
    video_selectpath();
    if(savePath){
    	var newDate = new Date();
	year = newDate.getYear();
	month = newDate.getMonth()+1;
	day = (newDate.getDate()>10)?newDate.getDate():"0"+newDate.getDate();
	hours = (newDate.getHours()>10)?newDate.getHours():"0"+newDate.getHours();
	minutes = (newDate.getMinutes()>10)?newDate.getMinutes():"0"+newDate.getMinutes();
	seconds = (newDate.getSeconds()>10)?newDate.getSeconds():"0"+newDate.getSeconds();
	var dateStr = ""+year+month+day+hours+minutes+seconds;//以当前时间命名 例如：2009102216721.jpg
    MegaWebPlayer.Action = "CaptureImage:"+savePath+"\\"+dateStr+".jpg";
	alert("抓图成功，图片保存为："+savePath+"\\"+dateStr+".jpg");
    	}
	
}
//关闭单个视频
function video_stop(){
	try{
		MegaWebPlayer.Action="Stop";	
	}catch(e){}
}

//关闭所有视频	
function stopPlayVideo() {		
	try{
	  MegaWebPlayer.Action="StopAll";		 
	}catch(e){}
}
//关闭视频播放界面		
  function closeWindow(){
  	stopPlayVideo();
  }
//切屏  
function video_switchscreen()
{
    MegaWebPlayer.Action = "Switch";
}
//暂停
function video_pause()
{
    MegaWebPlayer.Action = "Pause";
}
//快播
function video_fast()
{
	MegaWebPlayer.playSpeed=4;
}
//慢放
function video_slow()
{
	MegaWebPlayer.playSpeed=-4;
}


  /**
   云台操作：
**/	
//界面时实播放按扭
function button_liveLive(){
	var cid=document.getElementById("video_win_cid").value;
	video_start(cid);
	} 

	
  function OnStop(){MegaWebPlayer.Action = "Ptz:stop";} //停止方法                                    
  function OnUp()  {MegaWebPlayer.Action = "Ptz:up";   setTimeout("OnStop()",100);}  //  上移     
  function OnLeft(){MegaWebPlayer.Action = "Ptz:left";setTimeout("OnStop()",100);}     //    左移动 
  function OnDown(){MegaWebPlayer.Action = "Ptz:down"; setTimeout("OnStop()",100);}      //   下移动
  function OnRight(){MegaWebPlayer.Action = "Ptz:right"; setTimeout("OnStop()",100);}      // 右移动
  function OnNear(){MegaWebPlayer.Action = "Ptz:near";   setTimeout("OnStop()",100);}       //  移近
  function OnFar() {MegaWebPlayer.Action = "Ptz:far"; setTimeout("OnStop()",100);}          //移远
  
  /**
	* @desc 给视频播放增加键盘控制   		    					 
	* @author lizhitao               		    					 
	* @date 2010年12月24日           		    					 
**/                               		    					 
	   //键盘事件控制                		    					 
       document.onkeydown = keyDown;  
       function keyDown()
       {
       	//if(document.getElementById("movediv").style.display=="block")
         { 
          if(event.keyCode == 65 || event.keyCode == 37) 
          {
          	 //键盘事件-左移动 a
          	 OnLeft();
          	}
          if(event.keyCode == 68 || event.keyCode == 39)
          {
          	  //键盘事件-右移动 d
          	  OnRight();
          	}
          if(event.keyCode == 87 || event.keyCode == 38)
          {
          	  //键盘事件-上移动 w
          	  OnUp();
          	  
          	}	
          	if(event.keyCode == 83 || event.keyCode == 40)
          	{
          		 //键盘事件-下移动 s
          		 OnDown();
          		}
          		if(event.keyCode == 45)
          	{
          		 //键盘事件-移近-对应Insert
          		 OnNear();
          		}
          		if(event.keyCode == 46)
          	{
          		 //键盘事件--移远-对应Delete
          		 OnFar();
          		}
          	}
//          	else
//          		{
//                   return;
//          			}
          }