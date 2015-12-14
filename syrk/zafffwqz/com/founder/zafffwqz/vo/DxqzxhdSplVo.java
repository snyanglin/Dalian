/**********************************************************************   
 * <p>文件名：DxqzxhdSplVo.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-18 上午9:05:00 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.vo;

import java.io.Serializable;

import com.founder.zafffwqz.bean.*;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.vo.DxqzxhdSplVo.java]  
 * @ClassName:    [DxqzxhdSplVo]   
 * @Description:  [view object]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-18 上午9:05:00]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-18 上午9:05:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class DxqzxhdSplVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String hdid;
	private DxqzxhdSplJbxxb jbxx;
	private DxqzxhdSplZbAbzrdwxxb abdw;
	private DxqzxhdSplZbCbfxxb cbf;
	private DxqzxhdSplZbHdjabxxb hdab;
	private DxqzxhdSplZbSycsxxb sycs;
	private DxqzxhdSplZbXclsssjzwdjxxb lsjz;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public DxqzxhdSplJbxxb getJbxx() {
		return jbxx;
	}
	public void setJbxx(DxqzxhdSplJbxxb jbxx) {
		this.jbxx = jbxx;
	}
	public DxqzxhdSplZbAbzrdwxxb getAbdw() {
		return abdw;
	}
	public void setAbdw(DxqzxhdSplZbAbzrdwxxb abdw) {
		this.abdw = abdw;
	}
	public DxqzxhdSplZbCbfxxb getCbf() {
		return cbf;
	}
	public void setCbf(DxqzxhdSplZbCbfxxb cbf) {
		this.cbf = cbf;
	}
	public DxqzxhdSplZbHdjabxxb getHdab() {
		return hdab;
	}
	public void setHdab(DxqzxhdSplZbHdjabxxb hdab) {
		this.hdab = hdab;
	}
	public DxqzxhdSplZbSycsxxb getSycs() {
		return sycs;
	}
	public void setSycs(DxqzxhdSplZbSycsxxb sycs) {
		this.sycs = sycs;
	}
	public DxqzxhdSplZbXclsssjzwdjxxb getLsjz() {
		return lsjz;
	}
	public void setLsjz(DxqzxhdSplZbXclsssjzwdjxxb lsjz) {
		this.lsjz = lsjz;
	}
}
