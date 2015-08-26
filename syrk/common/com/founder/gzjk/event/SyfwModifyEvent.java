package com.founder.gzjk.event;

import org.springframework.context.ApplicationEvent;

import com.founder.gzjk.event.entity.EventObject;

/**
 * 实有房屋修改 事件
 * @author Administrator
 *
 */
public class SyfwModifyEvent extends ApplicationEvent{

	private static final long serialVersionUID = -1164574564914565991L;

	public SyfwModifyEvent(EventObject obj) {
		super(obj);
	}

}
