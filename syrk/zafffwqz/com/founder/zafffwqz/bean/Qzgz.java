/**********************************************************************   
 * <p>文件名：Qzgz.java </p>
 * <p>文件描述：犬只规则BEAN 
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-5-11 上午13:59:20 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.Qzgz.java]  
 * @ClassName:    [Qzgz]   
 * @Description:  [犬只规则BEAN]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-5-11 上午9:59:20]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-11 上午9:59:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "FWQZ_QZGZ" , pk = "ID")
public class Qzgz extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("犬只规则ID")
	private String id;
	@FieldDesc("名称")
	private String mc;
	@FieldDesc("别名")
	private String bm;
	@FieldDesc("英文名")
	private String ywm;
	@FieldDesc("原产地")
	private String ycd;
	@FieldDesc("体型")
	private String tx;
	@FieldDesc("体重")
	private String tz;
	@FieldDesc("类别")
	private String lb;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	public String getYcd() {
		return ycd;
	}

	public void setYcd(String ycd) {
		this.ycd = ycd;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getLb() {
		return lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

}
