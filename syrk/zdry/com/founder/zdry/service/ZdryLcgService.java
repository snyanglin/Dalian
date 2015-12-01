package com.founder.zdry.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.Zdrylxylbdyb;
import com.founder.zdry.vo.ZdryVO;
import com.founder.zdry.vo.ZdryZdryzbVO;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.service.LcgService.java]
 * @ClassName: [LcgService]
 * @Description: [列撤管业务处理接口]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午7:26:13]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午7:26:13，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@TypeAnnotation("列撤管业务处理")
public interface ZdryLcgService {
	/**
	 * @throws BussinessException
	 *             *
	 * 
	 * @Title: saveLg
	 * @Description: TODO(列管保存逻辑)
	 * @param @param zdryVO
	 * @param @param lgType
	 *        列管类型，用于区别是正常列管需要审批，或者是核实列管/上级指定列管不用审批,type分类为ZdryLczywblb
	 *        .NORMALTYPE / ZdryLczywblb.NOAPPROVALTYPE
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "添加列管业务", type = logType.insert)
	public Map<String, String> saveLg(ZdryVO zdryVO, String lcgtype,
			SessionBean sessionBean) throws BussinessException;

	/***
	 * 
	 * @Title: saveCg
	 * @Description: TODO(撤管保存逻辑)
	 * @param @param zdryZbId
	 * @param @param lgType
	 *        列管类型，用于区别是正常列管需要审批，或者是核实列管/上级指定列管不用审批,type分类为ZdryLczywblb
	 *        .NORMALTYPE / ZdryLczywblb.NOAPPROVALTYPE
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "添加撤管业务", type = logType.insert)
	public Map<String, String> saveCg(ZdryVO zdryVO, String lcgtype,
			SessionBean sessionBean,String cglxdm) throws BussinessException;

	/***
	 * 
	 * @Title: saveLczywb
	 * @Description: TODO(保存业务表)
	 * @param @param zdryZdyzb
	 * @param @param zdryLczywblb
	 * @param @param ywlx
	 * @param @param sessionBean
	 * @param @param lcgtype
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	public Map<String, String> saveLczywb(ZdryZdryzb zdryZdyzb,
			ZdryLczywblb zdryLczywblb, String ywlx, SessionBean sessionBean,
			String lcgtype) throws BussinessException;

	/***
	 * 
	 * @Title: sendApproval
	 * @Description: TODO(审批信息发送，如果postion为null，则发送至部门。针对某条业务表信息发送审批任务)
	 * @param @param orgcode 部门
	 * @param @param position 岗位
	 * @param @param lczywbId 业务信息ID
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String sendApproval(String orgcode, String position, String lczywbId,SessionBean sessionBean)
			throws BussinessException;
	
	/***
	 * 
	 * @Title: sendMessageByLczywb
	 * @Description: TODO(业务处理完毕,发送反馈消息给相关业务申请人,告知业务结果)
	 * @param @param lczywbId
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendMessageByLczywb(String lczywbId,SessionBean sessionBean);
	/***
	 * 
	 * @Title: getZdryGlLxByList
	 * @Description: 根据查询结果处理要显示的STR和撤管可选择的过滤条件
	 * @param @param list
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	public Map<String,String> getZdryGlLxByList(List<ZdryZdryzbVO> list,String syrkid);
	
	/***
	 * 
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 根据大类取小类,去掉已列管在
	 * 这里为降低时间复杂度,把2个list<object>转为list<String>,时间复制度由M*N降为M+M+N
	 * @author wu_chunhui@founder.com.cn
	 * @param zdrylxdm    大类代码
	 * @param zdryid    重点人员ID
	 * @return String    过来字符串,直接传入setDataFilter方法就可以
	 * @throws
	 */
	public List<String> getZdrylbdmExceptYlg( List<Zdrylxylbdyb> zdrylbdmList,String zdryid);
	
	
	/**
	 * 重点人员被列管的类别代码
	 * @Title: getYlgZdrylb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param zdryid
	 * @param @return    设定文件
	 * @return List<String>    返回类型
	 * @throws
	 */
	public List<String> getYlgZdrylb(String zdryid);

	
	/***
	 * 
	 * @Title: queryQxyw
	 * @Description: 私有方法,根据业务ID取得后续业务对象,多用于撤管业务后取得列管内容
	 * @param @param zdryLczywblbId
	 * @param @return 设定文件
	 * @return ZdryLczywblb 返回类型
	 * @throws
	 */
	public ZdryLczywblb queryQxyw(String zdryLczywblbId);
	
	/***
	 * 
	 * @Title: getALLZdrylb
	 * @Description: TODO(根据重点人员ID取得所有类别小类)
	 * @param @param zdryid
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getALLZdrylb(String zdryid);
	
	/***
	 * 
	 * @Title: queryByZdrylx
	 * @Description: TODO(根据重点人员类型，查询VO对象并跳转页面)
	 * @param @param zdryVO
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	public ZdryVO queryByZdrylx(String zdryid);
	/***
	 * 
	 * @Title: updateByZdrylx
	 * @Description: TODO(根据重点人员类型，修改VO对象并跳转页面)
	 * @param @param zdryVO    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateByZdrylx(ZdryVO zdryVO,SessionBean sessionBean);
}
