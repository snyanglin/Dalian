package com.founder.syfw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syfw.vo.SyfwgnVO;
import com.founder.syfw.vo.SyfwxxzsVO;

@TypeAnnotation("实有房屋编辑")
public interface SyfwEditService {

	public Fwjbxxb queryFwjbxxbById(String id);

	public List<SyfwxxzsVO> queryFwzsxx(Map<String, Object> map);

	public List<SyfwgnVO> queryYwglgn(Map<String, Object> map);

	@MethodAnnotation(value = "注销子表", type = logType.delete)
	public void delete_xxzsnrb(Map<String, Object> map);

	@MethodAnnotation(value = "新增实有房屋", type = logType.insert)
	public void insertFwjbxxb(Fwjbxxb entity, SessionBean sessionBean);

	@MethodAnnotation(value = "修改实有房屋", type = logType.update)
	public void updateFwjbxxb(Fwjbxxb entity, SessionBean sessionBean);


	public boolean checkFzIsChzr(String ryid,String fw_dzid);

	/**
	 * 查询房屋里的人数
	 * 
	 * @param map
	 * @return
	 */
	public int getJzrs(Map<String, Object> map);

	/**
	 * @Title: insertCzfwxxb
	 * @Description: TODO(新增出租房屋)
	 * @param @param czfwxxb 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增出租房屋子表", type = logType.insert)
	public void insertCzfwxxb(Czfwxxb czfwxxb, SessionBean sessionBean);

	/**
	 * 
	 * @Title: czfwzb_query
	 * @Description: TODO(实有房屋出租房屋信息)
	 * @param @param map
	 * @param @return 设定文件
	 * @return Czfwxxb 返回类型
	 * @throws
	 */
	public Czfwxxb czfwzb_query(Map<String, Object> map);

	/**
	 * 
	 * @Title: updateCzfwxxb
	 * @Description: TODO(更新出租房信息)
	 * @param @param czfwxxb
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "修改出租房屋子表", type = logType.update)
	public void updateCzfwxxb(Czfwxxb czfwxxb, SessionBean sessionBean);

	/**
	 * 
	 * @Title: checkDz
	 * @Description: TODO(检查dzdm上是否已经有房屋)
	 * @param @param dzdm
	 * @param @return 设定文件
	 * @return boolean 返回类型 已经有返回TRUE
	 * @throws
	 */
	public boolean checkDz(String dzdm);

	/**
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(根据房屋ID查询其附件列表)
	 * @param @param map
	 * @param @return 设定文件
	 * @return List<ZpfjFjxxb> 返回类型
	 * @throws
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map);

	// 重构
	public Czfwjcxxb queryCzfwjcxxb(Czfwjcxxb entity);

	@MethodAnnotation(value = "新增出租房屋检查信息表", type = logType.insert)
	public void saveCzfwjcxxb(Czfwjcxxb entity, SessionBean sessionBean);

	@MethodAnnotation(value = "修改出租房屋检查信息表", type = logType.update)
	public void updateCzfwjcxxb(Czfwjcxxb entity, SessionBean sessionBean);

	public List<Czfwjcxxb> czfjcxx_query(Map<String, Object> map);
	
	public Czfwxxb czfw_query(Czfwxxb fwCzfwxxb);
	
	public List<String> zpxx_query(Map<String, Object> map);
	
	public FwCzqkdjxxb queryCzqkdjxx(FwCzqkdjxxb fwCzqkdjxxb);
	
	@MethodAnnotation(value = "新增承租情况登记信息", type = logType.insert)
	public void saveCzqkdjxx(FwCzqkdjxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改承租情况登记信息", type = logType.update)
	public void updateCzqkdjxx(FwCzqkdjxxb entity, SessionBean sessionBean);
	
	public List<FwCzqkdjxxb> czqkdjxx_query(Map<String, Object> map);
	/**
	 * 
	 * @Title: getCountRkjzdzzb
	 * @Description: TODO(通过人员ID和所属责任区代码查询本辖区这个人的数量)
	 * @param @param ryid
	 * @param @param sszrqdm
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int getCountRkjzdzzb(String ryid,String sszrqdm);
	
	

	/**
	 * 
	 * @Title: checkCzrjzdz
	 * @Description: TODO(承租人居住地址必须为当前实有房屋地址)
	 * @param @param fwdz_dzid
	 * @param @param czr_ryid
	 * @param @param gxzrqdm
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean checkCzrjzdz(String fwdz_dzid, String czr_ryid, String gxzrqdm);
}
