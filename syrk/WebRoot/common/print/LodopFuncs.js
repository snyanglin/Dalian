document.write('<div style="display:none;">');
document.write('<OBJECT id="LODOP_OB" type="application/x-oleobject" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"> width="0" height="0"');
document.write('<embed id="LODOP_EM" type="application/x-print-lodop" width="0" height="0" pluginspage="install_lodop.exe"></embed>');
document.write('</OBJECT>');
document.write('</div>');

/************************************************************************
  本函数根据浏览器类型决定采用哪个对象作为控件实例：
  IE系列、IE内核系列的浏览器采用oOBJECT，
  其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED。
*************************************************************************/
function getLodop(oOBJECT, oEMBED){
   var LODOP = null;		
   try {		     
      if (navigator.appVersion.indexOf("MSIE")>=0) {
         LODOP = oOBJECT;
      }
      else {
    	 LODOP = oEMBED;
      }
   }
   catch (err) {}
   return LODOP; 
}

/************************************************************************
  检测打印控件是否安装，未安装则弹出窗口提供下载
*************************************************************************/
function checkLodopInstall() {	
   try {
      var LODOP = getLodop(document.getElementById("LODOP_OB"), document.getElementById("LODOP_EM"));
      if (LODOP != null && (typeof(LODOP.VERSION) != "undefined")) { // 已安装
    	 //alert("本机已成功安装过Lodop控件!\n  版本号:" + LODOP.VERSION);
    	 return true;
      }
      else {
         var strFeatures = "dialogWidth=400px;dialogHeight=180px;center=yes;help=no;status=no;";
    	 var arReturn = window.showModalDialog(contextPath + "/printmanager/lodopDownload.jsp", null, strFeatures);
    	 return false;
      }
   }
   catch (err) {}
   return false;
}
