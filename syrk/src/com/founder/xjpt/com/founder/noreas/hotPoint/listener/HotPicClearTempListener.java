package com.founder.xjpt.com.founder.noreas.hotPoint.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.founder.xjpt.com.founder.noreas.hotPoint.thread.HotPicClearTempThread;

public class HotPicClearTempListener implements ServletContextListener{
	
	private HotPicClearTempThread dealThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if(dealThread!=null&&dealThread.isInterrupted()){
			dealThread.interrupt();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if(dealThread==null){
			dealThread=new HotPicClearTempThread();
			dealThread.start();
		}
	}

}