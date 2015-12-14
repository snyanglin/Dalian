package com.founder.zafffwqz.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.zafffwqz.bean.Bazzb;
import com.founder.zafffwqz.bean.Bazzryxxb;
import com.founder.zafffwqz.bean.Sqjbxxb;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqmjxxb;
import com.founder.zafffwqz.bean.Sqwyhcyb;
import com.founder.zafffwqz.bean.Sqzbhb;
import com.founder.zafffwqz.bean.Sqzdbwb;
import com.founder.zafffwqz.bean.Zazzryxxb;
import com.founder.zafffwqz.vo.ZaffgnVO;
import com.founder.zafffwqz.vo.ZaffxxzsVO;

@TypeAnnotation("治安防范编辑")
public interface ZaffEditService {

	public void delete_xxzsnrb(Map<String, Object> map);

	public List<ZaffgnVO> queryYwglgn(Map<String, Object> map);

	public List<ZaffxxzsVO> queryJwszsxx(Map<String, Object> map);

	public Sqjwsxxb querySqjwsxxbById(String id);
	
	public Sqjbxxb sqjbxxb_query(Map<String, Object> map);
	
	public List<Sqwyhcyb> sqwyhcyb_query(Map<String, Object> map);
	
	public List<Sqzdbwb> sqzdbwb_query(Map<String, Object> map);
	
	public List<Zazzryxxb> zazzryxxb_query(Map<String, Object> map);
	
	public List<Bazzryxxb> bazzryxxb_query(Map<String, Object> map);
	
	public Sqjwsxxb sqjwsxxb_query(Map<String, Object> map);
	
	public Sqmjxxb sqmjxxb_query(Map<String, Object> map);
	
	public List<Sqzbhb> sqzbhb_query(Map<String, Object> map);
	
	public Bazzb bazzb_query(Map<String, Object> map);

}
