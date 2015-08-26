package com.founder.gzjk.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.founder.gzjk.event.SydwModifyEvent;
import com.founder.gzjk.event.entity.EventObject;
import com.founder.gzjk.romcache.SydwRamCache;

/**
 * 实有单位统计监听器
 * @author Administrator
 *
 */
@Component
public class SydwUpdateStatisiticListener implements ApplicationListener<SydwModifyEvent> {
	
	@Autowired
	private SydwRamCache sydwRamCache;

	@Async
	@Override
	public void onApplicationEvent(final SydwModifyEvent event) {
		EventObject obj = (EventObject) event.getSource();
		sydwRamCache.addGzjkList(obj.getRyid(),obj.getType());
	}

}
