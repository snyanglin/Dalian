package com.founder.bzdz.service;
import java.util.List;
import java.util.Map;

import com.founder.bzdz.bean.DzContextCombo;
import com.founder.bzdz.bean.DzContextCondition;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.bzdz.vo.DzBuildingVO;
import com.founder.bzdz.vo.DzTjVO;
import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
/**
 * @类名: DzService 
 * @描述: 地址管理Service 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-19 下午3:24:28 
 */
@TypeAnnotation("地址管理")
public interface DzService {
	/**
	 * @Title: queryDzList 
	 * @描述: 查询地址列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-25 下午2:47:58 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDzList(EasyUIPage page, BzdzxxbVO entity);
	/**
	 * @Title: queryMldzPd 
	 * @描述: 判断门楼地址是否存在
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-1-8 下午4:36:43 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	public List<BzdzxxbVO> queryMldzPd(BzdzxxbVO entity);
	/**
	 * @Title: saveDz 
	 * @描述: 保存地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-1-8 下午6:48:00 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDz(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: saveChDz 
	 * @描述: 保存层户地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-7 下午2:30:40 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveChDz(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: crossOutDspAndTh
	 * @描述:  注销待审批或被回退地址数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-4 下午6:14:49 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void crossOutDspAndTh(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: queryShDzList 
	 * @描述: 查询地址审核列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-5 下午2:35:49 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryShDzList(EasyUIPage page, BzdzxxbVO entity);
	/**
	 * @Title: queryShDzCount 
	 * @描述: 查询地址审核列表总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-5 下午2:39:54 
	 * @返回值: long    返回类型 
	 * @throws
	 */
	public long queryShDzCount(BzdzxxbVO entity);
	/**
	 * @Title: queryZzjg 
	 * @描述: 查询组织机构信息（主要查询边界坐标，无公共方法）
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-6 上午10:13:11 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	public List<BzdzxxbVO> queryZzjg(String zzjgdm);
	/**
	 * @Title: queryMldzShXx
	 * @描述: 查询单条门楼审核地址详情数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-6 下午3:23:40 
	 * @返回值: BzdzxxbVO    返回类型 
	 * @throws
	 */
	public BzdzxxbVO queryMldzShXx(String mldzid);
	/**
	 * @Title: queryDzbm 
	 * @描述: 获取地址别名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-7 下午12:47:00 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	public List<BzdzxxbVO> queryDzbm(String mldzid);
	/**
	 * @Title: updateSh 
	 * @描述: 更新审核地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-7 下午1:50:09 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateSh(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: queryJzwChjg 
	 * @描述: 获取建筑物层户机构_【建筑物层户结构表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-7 下午5:41:16 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	public List<BzdzxxbVO> queryJzwChjg(BzdzxxbVO entity);
	/**
	 * @Title: queryChShdz 
	 * @描述: 获取层户地址_【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 上午11:24:41 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	public List<BzdzxxbVO> queryChShdz(BzdzxxbVO entity);
    /**
     * @Title: queryChdzdxb 
     * @描述: 获取层户地址_【层户地址对象表】
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-3-3 下午2:09:51 
     * @返回值: List<BzdzxxbVO>    返回类型 
     * @throws
     */
	public List<BzdzxxbVO> queryChdzdxb(BzdzxxbVO entity);
	/**
	 * @Title: doDeleteYqy 
	 * @描述: 已启用地址注销【有业务数据处理】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 下午6:59:09 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void doDeleteYqy(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: queryMldzDx 
	 * @描述: 查询单条门楼对象地址详情数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 下午7:52:50 
	 * @返回值: BzdzxxbVO    返回类型 
	 * @throws
	 */
	public BzdzxxbVO queryMldzDx(String mldzid);
	/**
	 * @Title: updateMldz 
	 * @描述: 更新维护门楼地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-10 下午4:17:10 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateMldz(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: updateDymc 
	 * @描述: 修改单元名称
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、NEWDYH【新单元号】、DYHLX【单元号类型】
	 * @日期： 2015-3-3 上午10:39:56 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDymc(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: updateDycs 
	 * @描述: 修改单元层数_层户地址对象表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【旧楼层数】、NEWLCH【新楼层数】、DYHLX【单元号类型】
	 * @日期： 2015-3-4 上午9:46:35 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDycs(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: updateDyhs 
	 * @描述: 修改单元户数_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、ZDLCS【最大层数】、NEWHS【新户数】、DYHLX【单元号类型】
	 * @日期： 2015-3-4 下午4:35:57 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDyhs(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: updateDyLchs
	 * @描述: 修改楼层户数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、ZDHS【最大户数】、NEWHS【新户数】、DYHLX【单元号类型】
	 * @日期： 2015-3-5 上午10:16:49 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDyLchs(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: updateDyLchs 
	 * @描述: 修改房间名称
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、SH【室号】、NEWSH【新室号】、DYHLX【单元号类型】 
	 * @日期： 2015-3-5 下午2:56:17 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDyfjmc(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: queryHjdKgJt 
	 * @描述: 查询户籍地空挂地址集体
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: zrqdm 责任区代码
	 * @日期： 2015-4-3 上午11:16:08 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public DzXxbVO queryHjdKgJt(String zrqdm);
	/**
	 * @Title: queryHjdKgJm 
	 * @描述: 查询户籍地空挂地址居民 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: zrqdm 责任区代码
	 * @日期： 2015-4-3 上午11:24:11 
	 * @返回值: DzXxbVO    返回类型 
	 * @throws
	 */
	public DzXxbVO queryHjdKgJm(String zrqdm);
	/**
	 * @Title: updateDmmc 
	 * @描述: 地名维护【更新服务】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: dmdm 地名代码、dmmc 地名名称、olddmmc 旧地名名称
	 * @日期： 2015-4-9 下午3:18:19 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDmmc(String dmdm,String dmmc,String olddmmc,SessionBean sessionBean);
	/**
	 * @Title: updateHouseHb 
	 * @描述: 合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-10 下午3:54:01 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateHouseHb(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: updateHouseQxHb 
	 * @描述: 取消合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-11 下午5:03:23 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateHouseQxHb(BzdzxxbVO entity,SessionBean sessionBean);
	/**
	 * @Title: searchAddressMlph 
	 * @描述: 【门楼地址】全文检索
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-13 上午10:10:28 
	 * @返回值: List<DzContextCombo>    返回类型 
	 * @throws
	 */
	public List<DzContextCombo> searchAddressMlph(DzContextCondition condition);
	/**
	 * @Title: searchAddressMlphXz 
	 * @描述:【层户地址】全文检索
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-13 上午10:28:57 
	 * @返回值: List<DzContextCombo>    返回类型 
	 * @throws
	 */
	public List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition);
	/**
	 * @Title: queryChdzdxbShow 
	 * @描述: 获取层户地址信息展现内容【此方法有统计_人口、单位信息】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid 【门楼地址ID】
	 * @日期： 2015-5-7 下午2:48:57 
	 * @返回值: List<DzBuildingVO>    返回类型 
	 * @throws
	 */
	public List<DzBuildingVO> queryChdzdxbShow(String mldzid);
	/**
	 * @Title: queryDzTjList 
	 * @描述: 标准地址统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-12 下午4:11:21 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDzTjList(EasyUIPage page, DzTjVO entity);
	/**
	 * @Title: queryDzTjList_export 
	 * @描述: 标准地址统计_导出 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-17 下午5:13:23 
	 * @返回值: List<Map<String,String>>    返回类型 
	 * @throws
	 */
	public List<Map<String, String>> queryDzTjList_export(DzTjVO entity);
}