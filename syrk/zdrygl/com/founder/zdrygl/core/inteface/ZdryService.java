package com.founder.zdrygl.core.inteface;

import com.founder.framework.base.entity.SessionBean;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.inteface.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员业务接口]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月14日 下午9:01:02]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月14日 下午9:01:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryService {

	public void lg(SessionBean sessionBean);

	public void lgSuccess(SessionBean sessionBean);
	
	public void lgFail(SessionBean sessionBean);

	public void cg(SessionBean sessionBean);
	
	public void cgSuccess(SessionBean sessionBean);
	
	public void cgFail(SessionBean sessionBean);
	
	public void zl(SessionBean sessionBean);
	
	public void zlSuccess(SessionBean sessionBean);
	
	public void zlFail(SessionBean sessionBean);
	
	public void zd(SessionBean sessionBean);
	
	public void zdSuccess(SessionBean sessionBean);
	
	public void zdFail(SessionBean sessionBean);
		
	public void update(SessionBean sessionBean);
	
	public void setZdry(Zdry entity);
	
	public Zdry getZdry();
	
	public String getZdryId();
	
	public void queryZdryAllInfo(String zdryid, ZdryVO zdryVO);
	
}
