package com.founder.zdrygl.base.service.wf;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.wf.SysXzqhEnum.java]  
 * @ClassName:    [SysXzqhEnum]   
 * @Description:  [区域和对应处理类]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月9日 上午10:31:28]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月9日 上午10:31:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public enum SysXzqhEnum {
	DALIAN("210200", "com.founder.zdrygl.base.service.wf.DlParamsInitializer"),  
	LIAONING("210000", "com.founder.zdrygl.base.service.wf.LnParamsInitializer");
    private String name;
    private String value;

    private SysXzqhEnum(String name, String value) {
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
