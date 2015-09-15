package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.Zdrylbb.java]  
 * @ClassName:    [Zdrylbb]   
 * @Description:  [重点人员类型与类别对应表]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午5:53:27]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午5:53:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYLXYLBDYB", pk = "id")
public class ZdryZdrylxylbdyb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@FieldDesc("主键")
	private String id;
	@FieldDesc("重点人口总表ID")
	private String zdryid;
	@FieldDesc("重点人员类别代码")
	private String zdrylbdm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getZdrylbdm() {
		return zdrylbdm;
	}

	public void setZdrylbdm(String zdrylbdm) {
		this.zdrylbdm = zdrylbdm;
	}

}
