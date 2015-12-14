package com.founder.gzjk.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.founder.gzjk.event.SyrkModifyEvent;
import com.founder.gzjk.event.entity.EventObject;
import com.founder.gzjk.romcache.RamCache;

/**
 * 实有人口统计监听器
 * @author Administrator
 *
 */
@Component
public class UpdateStatisiticListener implements ApplicationListener<SyrkModifyEvent> {
	
	@Autowired
	private RamCache ramCache;

	@Async
	@Override
	public void onApplicationEvent(final SyrkModifyEvent event) {
		EventObject obj = (EventObject) event.getSource();
		ramCache.addGzjkList(obj.getRyid(),obj.getType(),obj.getOrgCode());
	}

}
