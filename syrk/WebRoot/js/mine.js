// JavaScript Document


function setTab(name,cursel,n){   
   for(i=1;i<=n;i++){   
   var menu=document.getElementById(name+i);   
   var con=document.getElementById("con_"+name+"_"+i);   
    menu.className=i==cursel?"hover":"";   
     con.style.display=i==cursel?"block":"none";   
   }
  }  
  
  $(function(){
  var iframeHeight =function(){
  var _height=$(window).height()-72;
  var _width = $(window).width();
    $(".Content").height(_height);
	if(_width<=1250){
			$('.Content,.header_other,.login_nr_other').css({'width':1230+'px'});
			$('.login_nr_other').css({'margin-left':-615+'px'});
			}
			else{	
			$('.Content,.header_other,.login_nr_other').css({'width':100%+'px'});
			$('.login_nr_other').css({'margin-left':-(_width/2)+'px'});
			}
   	if(_height<=700){
			$('.Content').css({'height':700+'px'});
		    }
			else{	
			$('.Content').css({'height':_height+'px'});
		   }		
	}	
 
 window.onresize = iframeHeight;
	$(function(){
    iframeHeight();
	});
	$(".navi_nr a img").click(function(){
	$(".navi_nr").hide();
      })
	})