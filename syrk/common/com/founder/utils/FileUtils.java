package com.founder.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;

import org.apache.poi3.xssf.usermodel.XSSFCell;
import org.apache.poi3.xssf.usermodel.XSSFRow;
import org.apache.poi3.xssf.usermodel.XSSFSheet;
import org.apache.poi3.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
/***
 * ****************************************************************************
 * @Package:      [com.founder.utils.CSVUtils.java]  
 * @ClassName:    [CSVUtils]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-4-22 下午2:39:20]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 下午2:39:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class FileUtils {
	/***
	 * 
	 * @Title: exportImageFromStream
	 * @Description: TODO(重数据库导出的2进制保存到本地)
	 * @param @param data
	 * @param @param file
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public static boolean exportImageFromStream(byte[] data ,File file){
		 boolean isSucess=false;
	        FileOutputStream out=null;
	        try {
	            out = new FileOutputStream(file);
	            out.write(data);
	            isSucess=true;
	        } catch (Exception e) {
	            isSucess=false;
	        }finally{
	            if(out!=null){
	                try {
	                    out.close();
	                    out=null;
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } 
	            }
	        }
	        return isSucess;
	}
	/**
	 * @throws IOException 
	 * 
	 * @Title: exportCsv
	 * @Description: TODO(导出CVS)
	 * @param @param file
	 * @param @param dataList
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public static boolean exportCsv(File file, List<String> dataList){
        boolean isSucess=false;
        
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
        
        return isSucess;
    }
    /**
     * 
     * @Title: importCsv
     * @Description: TODO(导入CVS)
     * @param @param file
     * @param @return    设定文件
     * @return List<String>    返回类型
     * @throws
     */
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
    /***
     * 
     * @Title: zipFiles
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param srcfile
     * @param @param zipfile    设定文件
     * @return void    返回类型
     * @throws
     */
    public static void zipFiles(List<File> srcfile, File zipfile) {  
        byte[] buf = new byte[1024];  
        try {  
            // Create the ZIP file  
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));  
            // Compress the files  
            for (int i = 0; i < srcfile.size(); i++) {  
                File file = srcfile.get(i);  
                FileInputStream in = new FileInputStream(file);  
                // Add ZIP entry to output stream.  
                out.putNextEntry(new ZipEntry(file.getName()));  
                // Transfer bytes from the file to the ZIP file  
                int len;  
                while ((len = in.read(buf)) > 0) {  
                    out.write(buf, 0, len);  
                }  
                // Complete the entry  
                out.closeEntry();  
                in.close();  
            }  
            // Complete the ZIP file  
            out.close();  
        } catch (IOException e) { 
        	 e.printStackTrace();
        }  
    }
    /**
     * @Title: dateGridExportExcel 
     * @描述: 导出Excel公共方法
     * @作者: zhang_guoliang@founder.com 
     * @参数: sheetName 导出文件名称
     * @参数: title 文件标题
     * @参数: field 显示字段
     * @参数: rows  行数据
     * @参数: outputStream ServletOutputStream对象
     * @日期： 2015-5-14 下午5:42:59 
     * @返回值: void    返回类型 
     * @throws
     */
    public static void dateGridExportExcel(String sheetName, String title, String field, String rows, ServletOutputStream outputStream){
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName);
			XSSFRow head = sheet.createRow(0);
			XSSFCell cell = null;
			//标题
			JSONArray jsonTitle = new JSONArray(title);
			JSONArray titleArray = (JSONArray) jsonTitle.get(0);
			//字段
			JSONArray jsonField = new JSONArray(field);
			//数据
			JSONArray jsonRows = new JSONArray(rows);
			//加载表头信息
	    	for(int i=0;i<jsonField.length();i++){
	    		cell = head.createCell(i);
	    		JSONObject titleDdate = titleArray.getJSONObject(i);
	    		cell.setCellValue(titleDdate.getString("title"));
	    	}
	    	//加载数据信息
	    	for(int j=0;j<jsonRows.length();j++){
	    		XSSFRow row = sheet.createRow(j+1);
	    		
	    		JSONObject rowsDate = jsonRows.getJSONObject(j);
	    		for(int m=0;m<jsonField.length();m++){
	    			cell = row.createCell(m);
	    			sheet.setColumnWidth(m,256*17);
	    			String fieldStr = (String) jsonField.get(m);
	    			cell.setCellValue(rowsDate.getString(fieldStr));
	    		}
	    	}
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}	
	}
}