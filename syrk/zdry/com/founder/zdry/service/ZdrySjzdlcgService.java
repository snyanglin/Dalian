/**********************************************************************   
 * <p>文件名：SjzdlcgService.java </p>
 * <p>文件描述：上级指定列撤管
 * @project_name：syrk_1
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-1-28 上午10:00:07 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.Sjzdlcg;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdry.bean.ZdryZdryzb;

/******************************************************************************
 * @Package:      [com.founder.syrk.service.SjzdlcgService.java]  
 * @ClassName:    [SjzdlcgService]   
 * @Description:  上级指定列撤管
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-1-28 上午10:00:07]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-1-28 上午10:00:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("上级指定列撤管")
public interface ZdrySjzdlcgService {

	public EasyUIPage queryLgZdryzdlb(EasyUIPage page, RyRyjbxxb entity);
	
	public EasyUIPage queryCgZdryzdlb(EasyUIPage page, ZdryZdryzb entity);
	
	public List<ZdryZdryzb> querySubList(ZdryZdryzb entity);
	
	public RyRyjbxxb queryRyjbxxbById(String ryid);
	
	public List<Map<String, String>> getJzdzJsonList(String ryid);
	
	public Map<String, String> getHjdzJson(String ryid);
	
	public String queryZdrylbLg(String ryid);
	
	public Map<String, String> getCgDzJson(String syrkid);
	
	public String queryLcgidForCg(Sjzdlcg entity);
	
	public String queryZdrylxdmByZdrylbdm(String zdrylbdm);
	
}
