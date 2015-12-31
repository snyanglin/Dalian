package com.founder.zdrygl.workflow;

public enum ZdMsgType{
	/*WF_SP_MJTZ("1", "通知民警审批"), 
	WF_SP_JDMJTZ("2", "通知监督民警审批"), 
	WF_JG_JDBMTZ("3", "通知监督部门"),  //民警接收
	WF_JG_YXQTZ("4", "通知原辖区民警及所长"), 
	WF_JG_SFXQTZ("5", "通知双方辖区民警及所长");*/
	JSSUCCESS("1", "jsSuccess"), //民警接收
	ZDSUCCESS("2", "zdSuccess"),  //裁决
	ZDFAIL("3", "zdFail");
	
    private String name;
    private String value;

    private ZdMsgType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
    public String getValue(){
   	 return this.value;
    }
    public String getName(){
    	return this.name;
    }
}