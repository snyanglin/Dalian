package com.founder.bzdz.service;
import java.util.List;
import com.founder.bzdz.vo.DmxxbVO;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
/**
 * @类名: DmService 
 * @描述: 地名管理Service
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-10 下午3:44:31 
 */
@TypeAnnotation("地名管理")
public interface DmService {
	/**
	 * @Title: queryDmList 
	 * @描述: 查询地名列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-10 下午3:45:55 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDmList(EasyUIPage page, DmxxbVO entity);
	/**
	 * @Title: queryDmCount 
	 * @描述: 查询地名列表总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-10 下午4:02:35 
	 * @返回值: long    返回类型 
	 * @throws
	 */
	public long queryDmCount(DmxxbVO entity);
	/**
	 * @Title: queryDm 
	 * @描述: 获取地名信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午3:51:17 
	 * @返回值: DmxxbVO    返回类型 
	 * @throws
	 */
	public DmxxbVO queryDm(DmxxbVO entity);
	/**
	 * @Title: queryXzqh 
	 * @描述: 获取单位的行政区划
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午4:19:52 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	public List<DmxxbVO> queryXzqh(DmxxbVO entity);
	/**
	 * @Title: queryGxdw 
	 * @描述: 获取单位的管辖单位
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午4:19:55 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	public List<DmxxbVO> queryGxdw(DmxxbVO entity);
	/**
	 * @Title: saveDm 
	 * @描述: 保存地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午2:27:51 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDm(DmxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: editDm 
	 * @描述: 维护地名 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-9 下午2:57:40 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void editDm(DmxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: queryDmPd 
	 * @描述: 判断地名是否重复
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午2:45:23 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	public List<DmxxbVO> queryDmPd(DmxxbVO entity);
	/**
	 * @Title: crossouDm 
	 * @描述: 注销地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-17 下午6:56:09 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void crossouDm(DmxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: quertDlst 
	 * @描述: 查询地图图层
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-18 下午3:00:01 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public List<DmxxbVO> quertDlst(DmxxbVO entity);
	/**
	 * @Title: queryMldzPd 
	 * @描述: 判断门楼地址是否存在
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-18 下午5:28:21 
	 * @返回值: boolean    返回类型 
	 * @throws
	 */
	public boolean queryMldzPd(DmxxbVO entity);
	/**
	 * @Title: queryDictDm 
	 * @描述: 获取地名下拉框字典
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 上午10:35:29 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	public List<ComboBox> queryDictDm(String pcsdm);
	/**
	 * @Title: queryDictSq 
	 * @描述: 获取社区下拉框字典
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 下午3:59:43 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	public List<ComboBox> queryDictSq(String pcsdm);
}