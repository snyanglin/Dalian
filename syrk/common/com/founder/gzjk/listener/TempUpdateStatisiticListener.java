package com.founder.gzjk.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.founder.gzjk.event.TempModifyEvent;
import com.founder.gzjk.event.entity.EventObjectTemp;
import com.founder.gzjk.service.TempService;

/**
 * Temp统计监听器
 * @author Administrator
 *
 */
@Component
public class TempUpdateStatisiticListener implements ApplicationListener<TempModifyEvent> {
	
	@Autowired
	private TempService tempService;

	@Async
	@Override
	public void onApplicationEvent(final TempModifyEvent event) {
		EventObjectTemp obj = (EventObjectTemp) event.getSource();
		tempService.updateGzjl(obj.getId(),obj.getType(), obj.getBusinessType(), obj.getSessionBean());
	}

}
