package com.founder.service.biJieBaoBiao;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import bios.report.api.factory.IToolbarFactory;
import bios.report.api.usermodel.ReportMark;
import bios.report.api.usermodel.ToolbarInfo;
import bios.report.api.utils.ReportToolkits;
/**
 * @类名: MyToolbarFactory 
 * @描述: 自定义工具条工厂类[统计报表] 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-7-27 下午3:17:31 
 */
public class BijieToolbarFactory implements IToolbarFactory {
	@SuppressWarnings("rawtypes")
	public String buildToolbarHtml(HttpServletRequest request, ReportMark rptMark, ToolbarInfo toolbarInfo) {
		String rptName = rptMark.getRpt();   //请求中的rpt参数
		String params = rptMark.getParams(); //请求中的params参数
		String vars = rptMark.getVars();     //请求中的vars参数
		
		StringBuffer toolbarBuf = new StringBuffer(500);
		
		toolbarBuf.append("<div class='grid-bottombar'>");
		toolbarBuf.append("<div class='toolbar'>");
		toolbarBuf.append("<table cellspacing='0'><tr>");
		
		toolbarBuf.append("<form id='tbForm' action='").append(request.getRequestURI()).append("' method='post'>");
		toolbarBuf.append("<script language='javascript'>");
		toolbarBuf.append("function getPage(page){");
		toolbarBuf.append("document.all['page'].value=page;");
		toolbarBuf.append("document.all['tbForm'].submit();");
		toolbarBuf.append("}");
		toolbarBuf.append("function openEmitter(url){");
		toolbarBuf.append("window.open(url,'_self');");
		toolbarBuf.append("}</script>");
		
		toolbarBuf.append("<input type='hidden' name='rpt' value='").append(rptName).append("'/>");
		if (params != null && params.indexOf("'") > 0) {
			toolbarBuf.append("<input type=\"hidden\" name=\"params\" value=\"").append(params).append("\"/>");
		}else{
			toolbarBuf.append("<input type='hidden' name='params' value='").append(params).append("'/>");
		}
		if (vars != null && vars.indexOf("'") > 0) {
			toolbarBuf.append("<input type=\"hidden\" name=\"vars\" value=\"").append(vars).append("\"/>");
		}else{
			toolbarBuf.append("<input type='hidden' name='vars' value='").append(vars).append("'/>");
		}
		if(toolbarInfo.getOtherParams() != null){
			Iterator<Entry<String, String>> iter = toolbarInfo.getOtherParams().entrySet().iterator();
			Map.Entry entry;
			while(iter.hasNext()){
				 entry = (Map.Entry)iter.next();
				 toolbarBuf.append("<input type='hidden' name='").append(entry.getKey()).append("' value='").append(entry.getValue()).append("'/>");
			}
		}
		toolbarBuf.append("\n");
		
		if(toolbarInfo.getPageCount()>1){
			if(toolbarInfo.getPageIndex() == 1){
				toolbarBuf.append("<td class='disabled'>");
				toolbarBuf.append("<table class='btn-icon page-first'><tr><td class='btn-center'><button type='button' class='btn-text'></button></td></tr></table>");
				toolbarBuf.append("</td>");
				toolbarBuf.append("<td class='disabled'>");
				toolbarBuf.append("<table class='btn-icon page-prev'><tr><td class='btn-center'><button type='button' class='btn-text'></button></td></tr></table>");
				toolbarBuf.append("</td>");
			}else{
				toolbarBuf.append("<td class='enabled'>");
				toolbarBuf.append("<table class='btn-icon page-first'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='getPage(1)'></button></td></tr></table>");
				toolbarBuf.append("</td>");
				toolbarBuf.append("<td class='enabled'>");
				toolbarBuf.append("<table class='btn-icon page-prev'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='getPage(").append(toolbarInfo.getPageIndex() - 1).append(")'></button></td></tr></table>");
				toolbarBuf.append("</td>");
			}
			toolbarBuf.append("\n");
			toolbarBuf.append("<td>第<input type='text' name='page' value='").append(toolbarInfo.getPageIndex()).append("' size='3' style='height: 18px;'/>页</td>");
			if(toolbarInfo.getPageIndex() == toolbarInfo.getPageCount()){
				toolbarBuf.append("<td class='disabled'>");
				toolbarBuf.append("<table class='btn-icon page-next'><tr><td class='btn-center'><button type='button' class='btn-text'></button></td></tr></table>");
				toolbarBuf.append("</td>");
				toolbarBuf.append("<td class='disabled'>");
				toolbarBuf.append("<table class='btn-icon page-last'><tr><td class='btn-center'><button type='button' class='btn-text'></button></td></tr></table>");
				toolbarBuf.append("</td>");
			}else{
				toolbarBuf.append("<td class='enabled'>");
				toolbarBuf.append("<table class='btn-icon page-next'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='getPage(").append(toolbarInfo.getPageIndex() + 1).append(")'></button></td></tr></table>");
				toolbarBuf.append("</td>");
				toolbarBuf.append("<td class='enabled'>");
				toolbarBuf.append("<table class='btn-icon page-last'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='getPage(").append(toolbarInfo.getPageCount()).append(")'></button></td></tr></table>");
				toolbarBuf.append("</td>");
			}
		}
		toolbarBuf.append("\n");
		toolbarBuf.append("</form>");
		
		String fileName2 = ReportToolkits.encodeUrl(rptName);
		String params2 = ReportToolkits.encodeUrl(params);
		String vars2 = ReportToolkits.encodeUrl(vars);
		
		//添加整页excel导出
		toolbarBuf.append("<td><span class='btn-sep'/></td>");
		toolbarBuf.append("<td>");
		toolbarBuf.append("<table cellspacing='0' cellpadding='0' title='导出' onclick=");
		toolbarBuf.append("openEmitter(\"").append(request.getContextPath()).append("/ReportEmitter?rpt=").append(fileName2).append("&emitter=toxls&params=").append(params2).append("&vars=").append(vars2).append("\")");
		toolbarBuf.append("><tr>");
		toolbarBuf.append("<td class='button-img btn-excel'></td>"); //按钮图片
		toolbarBuf.append("<td class='button-text' id='be_0'>导出</td>"); //按钮文字，id设置为be_n，可支持工具条长度不足时，自动隐藏文字
		toolbarBuf.append("</tr></table>");
		toolbarBuf.append("</td>");
		//添加返回按钮
		if(!"".equals(params2)&&params2!=null){
			if(params2.indexOf("zzjglx%3D12")!=-1||params2.indexOf("zzjglx%3D13")!=-1||params2.indexOf("zzjglx%3D14")!=-1||params2.indexOf("zzjglx%3D15")!=-1){
				if(params2.indexOf("zzjglx%3D12")!=-1&&params2.indexOf("dw%3D2")!=-1){
					toolbarBuf.append("<td><span class='btn-sep'/></td>");
					toolbarBuf.append("<td>");
					toolbarBuf.append("<table cellspacing='0' cellpadding='0' border='0' class='btn-text-icon btn-fh'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='javascript:window.history.go(-1)' ");
					toolbarBuf.append(">返回</button></td></tr></table>");
					toolbarBuf.append("</td>");
				}else if(params2.indexOf("zzjglx%3D13")!=-1&&params2.indexOf("dw%3D2")!=-1){
					toolbarBuf.append("<td><span class='btn-sep'/></td>");
					toolbarBuf.append("<td>");
					toolbarBuf.append("<table cellspacing='0' cellpadding='0' border='0' class='btn-text-icon btn-fh'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='javascript:window.history.go(-1)' ");
					toolbarBuf.append(">返回</button></td></tr></table>");
					toolbarBuf.append("</td>");
				}else if(params2.indexOf("zzjglx%3D14")!=-1&&params2.indexOf("dw%3D2")!=-1){
					toolbarBuf.append("<td><span class='btn-sep'/></td>");
					toolbarBuf.append("<td>");
					toolbarBuf.append("<table cellspacing='0' cellpadding='0' border='0' class='btn-text-icon btn-fh'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='javascript:window.history.go(-1)' ");
					toolbarBuf.append(">返回</button></td></tr></table>");
					toolbarBuf.append("</td>");
				}else if(params2.indexOf("zzjglx%3D15")!=-1&&params2.indexOf("dw%3D2")!=-1){
					toolbarBuf.append("<td><span class='btn-sep'/></td>");
					toolbarBuf.append("<td>");
					toolbarBuf.append("<table cellspacing='0' cellpadding='0' border='0' class='btn-text-icon btn-fh'><tr><td class='btn-center'><button type='button' class='btn-text' onclick='javascript:window.history.go(-1)' ");
					toolbarBuf.append(">返回</button></td></tr></table>");
					toolbarBuf.append("</td>");
				}
			}
		}
		toolbarBuf.append("</tr></table>");
		toolbarBuf.append("</div>");
		if(toolbarInfo.getPageCount()>1){
			toolbarBuf.append("<div class='paging-info'>共").append(toolbarInfo.getPageCount()).append("页</div>");
		}
		toolbarBuf.append("</div>");
		
		return toolbarBuf.toString();
	}
}