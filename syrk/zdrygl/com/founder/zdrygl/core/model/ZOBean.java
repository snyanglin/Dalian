package com.founder.zdrygl.core.model;

import com.founder.workflow.bean.StartProcessInstance;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.model.ZOBean.java]  
 * @ClassName:    [ZOBean]   
 * @Description:  [重点人员业务操作对象，包含重点人员总表对象与类别对象，在例撤转时用]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年12月9日 下午8:07:01]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月9日 下午8:07:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZOBean {
	
	public ZOBean(Zdry zdryzb, Zdry zdrylbdx) {
		super();
		this.zdryzb = zdryzb;
		this.zdrylbdx = zdrylbdx;
	}

	private Zdry zdryzb;
	
	private Zdry zdrylbdx;
	
	private Zdry zdrycx;
	
	private StartProcessInstance startProcessInstance;

	public Zdry getZdryzb() {
		return zdryzb;
	}

	public void setZdryzb(Zdry zdryzb) {
		this.zdryzb = zdryzb;
	}

	public Zdry getZdrylbdx() {
		return zdrylbdx;
	}

	public void setZdrylbdx(Zdry zdrylbdx) {
		this.zdrylbdx = zdrylbdx;
	}

	public StartProcessInstance getStartProcessInstance() {
		return startProcessInstance;
	}

	public void setStartProcessInstance(StartProcessInstance startProcessInstance) {
		this.startProcessInstance = startProcessInstance;
	}
	
	public String getZdryzbId(){
		return this.zdryzb.getId();
	}
	
	public String getZdrylbdxId(){
		return this.zdrylbdx.getId();
	}
	
	public void setProcessInstanceBusinessKey(String bk){
		this.startProcessInstance.setBusinessKey(bk);
	}

	public Zdry getZdrycx() {
		return zdrycx;
	}

	public void setZdrycx(Zdry zdrycx) {
		this.zdrycx = zdrycx;
	}
}
