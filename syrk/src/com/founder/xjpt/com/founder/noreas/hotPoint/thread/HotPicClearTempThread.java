package com.founder.xjpt.com.founder.noreas.hotPoint.thread;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.founder.xjpt.com.founder.noreas.xmlOpe.XMLOpeUtils;

public class HotPicClearTempThread extends Thread{
	public void run(){
		while(true){
			try {
				Thread.sleep(1000*60*60);//1小时执行一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//每天1点清空temp文件夹下文件
			try{
				if("02".equals(new SimpleDateFormat("HH").format(new Date()))){
					String path=XMLOpeUtils.getAppointPathFile("temp");
//					System.out.println(path);
					File file=new File(path);
					String[] tmpList=file.list();
					File temp=null;
					for(int i=0;i<tmpList.length;i++){
						temp=new File(path+File.separator+tmpList[i]);
						if(temp.isFile()){
							temp.delete();
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
