package com.founder.jzym.service;
import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.jzym.bean.Jz_jqxxb;
import com.founder.jzym.vo.Sf_Organization;
import com.founder.xjpt.vo.ZzjgVo;

@TypeAnnotation("局长页面")
public interface JzService {
	
	public EasyUIPage queryJq(EasyUIPage page, Jz_jqxxb entity);
	
	public long queryCountJq(Jz_jqxxb entity);
	
	public Map<String, Object> jqChart(String zzjgdm, String kssj, String jssj, String jqlxdm, String zrq);
	
	public List<ZzjgVo> querySsyj(String zzjgdm);
	
	public List<Sf_Organization> downMap(String orgcode);
	
	public List<Sf_Organization> querySf(Sf_Organization sf);
	
	public List<Sf_Organization> queryXjZzjgxj(String zzjgdm);
	
	public Map<String, Object> ssyjChart(Sf_Organization sf);
	
	public Map<String, Object> jqdbChart(String zzjgdm, String kssj, String jssj, String jqlxdm, String zrq);
	
	public String ssyjColor(String orgcode, Sf_Organization sf);
	
}


