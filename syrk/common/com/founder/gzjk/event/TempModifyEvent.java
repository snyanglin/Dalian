package com.founder.gzjk.event;

import org.springframework.context.ApplicationEvent;

import com.founder.gzjk.event.entity.EventObjectTemp;

/**
 * Temp修改 事件
 * @author Administrator
 *
 */
public class TempModifyEvent extends ApplicationEvent{

	private static final long serialVersionUID = -1164574564914565991L;

	public TempModifyEvent(EventObjectTemp obj) {
		super(obj);
	}

}
