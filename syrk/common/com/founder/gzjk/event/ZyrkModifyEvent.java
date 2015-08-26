package com.founder.gzjk.event;

import org.springframework.context.ApplicationEvent;

import com.founder.gzjk.event.entity.EventObject;

/**
 * 实有人口修改 事件
 * @author Administrator
 *
 */
public class ZyrkModifyEvent extends ApplicationEvent{

	private static final long serialVersionUID = -1164574564914565991L;

	public ZyrkModifyEvent(EventObject obj) {
		super(obj);
	}

}
