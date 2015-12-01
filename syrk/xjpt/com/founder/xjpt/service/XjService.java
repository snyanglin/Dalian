package com.founder.xjpt.service;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xjpt.bean.Xj_ajxxb;
import com.founder.xjpt.bean.Xj_jqxxb;
import com.founder.xjpt.bean.Xj_sjxxb;
import com.founder.xjpt.bean.Zdryjbxxb;


@TypeAnnotation("巡警")
public interface XjService {
	
	public EasyUIPage queryJq(EasyUIPage page, Xj_jqxxb entity);
	
	public long queryCountJq(Xj_jqxxb entity);
	
	public EasyUIPage queryAj(EasyUIPage page, Xj_ajxxb entity);
	
	public long queryCountAj(Xj_ajxxb entity);
	
	public EasyUIPage querySj(EasyUIPage page, Xj_sjxxb entity);
	
	public long queryCountSj(Xj_sjxxb entity);
	
	public EasyUIPage queryZdryjbxxNoPt(EasyUIPage page, Zdryjbxxb entity);
	
	public long queryCountZdryjbxxNoPt(Zdryjbxxb entity);
	
}


