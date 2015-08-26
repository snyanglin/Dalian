package com.founder.jcj.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.jcj.bean.JcjCjxxb;
import com.founder.jcj.bean.JcjCshpz;
import com.founder.jcj.bean.JcjFkxxb;
import com.founder.jcj.bean.JcjJjxxb;
import com.founder.jcj.bean.jcjSaveVo;
import com.founder.jcj.vo.JcjgnVO;
import com.founder.jcj.vo.JcjxxzsVO;

@TypeAnnotation("接处警服务")
public interface JcjEditService {

	public List<JcjxxzsVO> queryZsxx(Map<String, Object> map);

	public List<JcjgnVO> queryYwglgn(Map<String, Object> map);

	public void delete_xxzsnrb(Map<String, Object> map);

	public JcjJjxxb queryJcjJjxxb(String id);

	public EasyUIPage queryJcjNoPt(EasyUIPage page, JcjJjxxb entity);

	public JcjCjxxb queryJcjxxbById(String id);

	public void insertCjxxb(JcjCjxxb entity, SessionBean sessionBean);

	public void insertJjxxb(JcjJjxxb entity, SessionBean sessionBean);

	public void updateCjxxb(JcjCjxxb entity, SessionBean sessionBean);

	public JcjFkxxb queryFkxxbById(String id);

	public void insertFkxxb(JcjFkxxb entity, SessionBean sessionBean);

	public void updateFkxxb(JcjFkxxb entity, SessionBean sessionBean);

	public List<JcjFkxxb> fankuixx_query(Map<String, Object> map);

	public void insertCshpzb(JcjCshpz entity, SessionBean sessionBean);

	public void updateCshpzb(JcjCshpz entity, SessionBean sessionBean);

	public JcjCshpz queryCshpzByXzqh(String district);

	public JcjJjxxb queryJcjjjxxbByJJXBH(String jjbh);

	public void sqveZjjxx(jcjSaveVo entity, SessionBean sessionBean);


	/**
	 * 
	 * @Title: queryJcjjjxxb
	 * @Description: TODO(查询接警信息表列表)
	 * @param @param JcjJjxxb
	 * @param @return 设定文件
	 * @return List<JcjJjxxb> 返回类型
	 * @throws
	 */
	public List<JcjJjxxb> queryJcjjjxxb(JcjJjxxb JcjJjxxb);

}
