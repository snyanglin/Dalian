package com.founder.jcj.bean;

import java.io.Serializable;

import com.founder.framework.base.entity.BaseEntity;
public class jcjSaveVo extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private JcjCjxxb jcjcjxxb;
	
	private JcjCshpz jcjcshpzb;
	
	private JcjFkxxb jcjfkxxb;
	
	private JcjJjxxb jcjjjxxb;

	public JcjCjxxb getJcjcjxxb() {
		return jcjcjxxb;
	}

	public void setJcjcjxxb(JcjCjxxb jcjcjxxb) {
		this.jcjcjxxb = jcjcjxxb;
	}

	public JcjCshpz getJcjcshpzb() {
		return jcjcshpzb;
	}

	public void setJcjcshpzb(JcjCshpz jcjcshpzb) {
		this.jcjcshpzb = jcjcshpzb;
	}

	public JcjFkxxb getJcjfkxxb() {
		return jcjfkxxb;
	}

	public void setJcjfkxxb(JcjFkxxb jcjfkxxb) {
		this.jcjfkxxb = jcjfkxxb;
	}

	public JcjJjxxb getJcjjjxxb() {
		return jcjjjxxb;
	}

	public void setJcjjjxxb(JcjJjxxb jcjjjxxb) {
		this.jcjjjxxb = jcjjjxxb;
	}
	
	
	
	
    
}
