package com.founder.gzjk.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.founder.gzjk.event.SyfwModifyEvent;
import com.founder.gzjk.event.entity.EventObject;
import com.founder.gzjk.romcache.SyfwRamCache;

/**
 * 实有房屋统计监听器
 * @author Administrator
 *
 */
@Component
public class SyfwUpdateStatisiticListener implements ApplicationListener<SyfwModifyEvent> {
	
	@Autowired
	private SyfwRamCache syfwRamCache;

	@Async
	@Override
	public void onApplicationEvent(final SyfwModifyEvent event) {
		EventObject obj = (EventObject) event.getSource();
		syfwRamCache.addGzjkList(obj.getRyid(),obj.getType());
	}

}
