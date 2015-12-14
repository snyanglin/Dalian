package com.founder.gzjk.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.founder.gzjk.event.ZyrkModifyEvent;
import com.founder.gzjk.event.entity.EventObject;
import com.founder.gzjk.romcache.ZdryRamCache;

/**
 * 重点人员统计监听器
 * @author Administrator
 *
 */
@Component
public class ZdryUpdateStatisiticListener implements ApplicationListener<ZyrkModifyEvent> {
	
	@Autowired
	private ZdryRamCache zdryRamCache;

	@Async
	@Override
	public void onApplicationEvent(final ZyrkModifyEvent event) {
		EventObject obj = (EventObject) event.getSource();
		zdryRamCache.addGzjkList(obj.getRyid(),obj.getType(),obj.getOrgCode());
	}

}
