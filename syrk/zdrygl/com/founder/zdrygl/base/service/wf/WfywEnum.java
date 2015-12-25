package com.founder.zdrygl.base.service.wf;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.WfywEnum.java]  
 * @ClassName:    [WfywEnum]   
 * @Description:  [与流程相关的业务名称]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月18日 下午4:08:15]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月18日 下午4:08:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public enum WfywEnum {
	ZALCG("1", "zalcg"), 
	ZD("2", "zd"), 
	JGDXQJ("3", "jgdxqj"),  
	ZDRYHS("4", "zdryhs"), 
	ZL("5", "zl");
	
    private String name;
    private String value;

    private WfywEnum(String name, String value) {
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
