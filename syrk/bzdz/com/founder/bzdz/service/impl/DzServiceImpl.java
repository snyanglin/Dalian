package com.founder.bzdz.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.bzdz.bean.DzContextCombo;
import com.founder.bzdz.bean.DzContextCondition;
import com.founder.bzdz.dao.DzDao;
import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.bzdz.vo.DzBuildingVO;
import com.founder.bzdz.vo.DzTjVO;
import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ContextSearchUtils;
import com.founder.framework.utils.DateTimeHelper;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.gis.service.GisService;
import com.founder.utils.DateTimeUtils;
/**
 * @类名: DzServiceImpl 
 * @描述: 地址管理ServiceImpl
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-19 下午3:26:20 
 */
@Service("dzService")
@Transactional
public class DzServiceImpl extends BaseService implements DzService {
	@Resource(name = "dzDao")
	private DzDao dzDao;
	@Resource(name = "gisService")
	private GisService gisService;
    /**
     * @Title: queryDzList 
     * @描述: 查询地址列表
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2014-12-25 下午2:48:35 
     * @throws
     */
	public EasyUIPage queryDzList(EasyUIPage page, BzdzxxbVO entity) {
		return dzDao.queryDzList(page,entity);
	}
	/**
	 * @Title: queryMldzPd 
	 * @描述: 判断门楼地址是否存在
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-1-8 下午4:37:29 
	 * @throws
	 */
	public List<BzdzxxbVO> queryMldzPd(BzdzxxbVO entity) {
		return dzDao.queryMldzPd(entity);
	}
	/**
	 * @Title: saveDz 
	 * @描述: 保存地址_审核表或对象表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用 
	 * @日期： 2015-1-8 下午6:48:29 
	 * @throws
	 */
	public void saveDz(BzdzxxbVO entity, SessionBean sessionBean) {
		//地址是否进行审核状态【系统配置】
		String bzdzSh = SystemConfig.getString("bzdzSh");
		//门楼地址表
		entity.setMldzid(UUID.create());
		String zrqdm = sessionBean.getUserOrgCode();
		String pcsdm = (String)sessionBean.getExtendMap().get("ssPcsCode");
		String fxjdm = (String)sessionBean.getExtendMap().get("ssFsxCode");
		entity.setZrqdm(zrqdm);
		entity.setPcsdm(pcsdm);
		entity.setFxjdm(fxjdm);
		String dzmc = entity.getXzqhmc()+entity.getMlphqc();
		entity.setDzmc(dzmc);
		entity.setDzmcpy(dzDao.queryPy(dzmc));
		entity.setDzmcpwd(ContextSearchUtils.getPasswordString(dzmc));
		entity.setDzmcpypwd(ContextSearchUtils.getPasswordString(entity.getDzmcpy()));
		setSaveProperties(entity,sessionBean);
		if("1".equals(bzdzSh)){
			entity.setShztdm("01");
			entity.setShbhgyy("");
			entity.setBz("审核中");
			dzDao.saveDzShb(entity);
		}else{
			dzDao.saveDzDxb(entity);
			//同时插入到BZDZ_ADD_MLDZDXB_PT空间表
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("entity", entity);
			params.put("srid", gisService.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));
			params.put("objectid", gisService.getSdeSeqValue("BZDZ_ADD_MLDZDXB_PT"));
			dzDao.saveDzDxbPT(params);
		}
		//地址别名表
		BzdzxxbVO[] dzBmArray = entity.getDzBmArray();
		if(dzBmArray!=null){
			for(int i=0;i<dzBmArray.length;i++){
				if(!"".equals(dzBmArray[i].getDzbm())&&dzBmArray[i].getDzbm()!=null){
					 entity.setDzbmid(UUID.create());
					 entity.setDzbm(dzBmArray[i].getDzbm());
					 entity.setBmly("警务综合平台_地址管理【新增】");
					 dzDao.saveBm(entity);
				}
			}
		}
		//建筑物信息表
		entity.setJzwid(UUID.create());
		dzDao.saveJzw(entity);
		//建筑物关联表
		entity.setGlid(UUID.create());
		dzDao.saveJzwglb(entity);
		//保存地上基本信息
		saveDsChdzdxb(entity,bzdzSh);
		//保存地下基本信息
		saveDxChdzdxb(entity,bzdzSh);
	}
	/**
	 * @Title: saveChDz 
	 * @描述: 保存层户地址【注销重建】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用，dzChb 0为对象表（默认）、1为审核表
	 * @日期： 2015-4-7 下午2:31:51 
	 * @throws
	 */
	public void saveChDz(BzdzxxbVO entity, SessionBean sessionBean) {
		//地址是否进行审核状态【系统配置】
		String bzdzSh = SystemConfig.getString("bzdzSh");
		if("1".equals(bzdzSh)){
			//更新门楼地址对象表 修改备注字段进入已启用（维护中）状态
		    setUpdateProperties(entity,sessionBean);
		    if(!"1".equals(entity.getDzChb())){
				entity.setBz("维护中");
				dzDao.updateDzMldz(entity);
			}
			List<BzdzxxbVO> volist = dzDao.queryMldzShb(entity.getMldzid());
			if(volist.size()==0){
				//将对象表数据插入到审核表中
				dzDao.insertMldzShb(entity);
			}
			entity.setShztdm("01");
			entity.setShbhgyy("");
			dzDao.updateMldzShb(entity);
			setSaveProperties(entity,sessionBean);
			//建筑物信息表
			entity.setJzwid(UUID.create());
			entity.setBz("维护中");
			dzDao.saveJzw(entity);
			//建筑物关联表
			entity.setGlid(UUID.create());
			dzDao.saveJzwglb(entity);
			//删除地址审核表数据
			dzDao.deleteChdzShb(entity.getMldzid());
		}else{
			//先注销之前层户地址信息
			setCrossoutProperties(entity,sessionBean);
			entity.setXt_zxyy("警务综合平台_地址管理_地址维护_层户结构注销重建【注销】");
			//查询门楼地址关联的JZWID
			List<BzdzxxbVO> jzwlist = dzDao.queryJzwid(entity);
			for(int i=0;i<jzwlist.size();i++){
				String jzwid = jzwlist.get(i).getJzwid();
				entity.setJzwid(jzwid);
				//注销关联建筑物ID的数据
				dzDao.crossOutJzwXx(entity);
			}
			//注销已启用地址数据_【层户地址对象表】
			dzDao.crossOutChdzdxb(entity);
			//保存新建的层户地址信息
			setSaveProperties(entity,sessionBean);
			entity.setXt_zxyy("");
			//建筑物信息表
			entity.setJzwid(UUID.create());
			entity.setBz("");
			dzDao.saveJzw(entity);
			//建筑物关联表
			entity.setGlid(UUID.create());
			dzDao.saveJzwglb(entity);
		}
		//保存地上基本信息
		saveDsChdzdxb(entity,bzdzSh);
	    //保存地下基本信息
		saveDxChdzdxb(entity,bzdzSh);
	}
	/**
	 * @Title: saveDsChdzdxb
	 * @描述: 保存地上基本信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用 
	 * @日期： 2015-1-30 上午11:02:20 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDsChdzdxb(BzdzxxbVO entity,String bzdzSh){
		if(entity.getDsdyjbxx()!=null&&!"".equals(entity.getDsdyjbxx())&&entity.getDsdys()!=null){
			//保存地上单元地址信息
			String dsdyjbxx[] = entity.getDsdyjbxx();
			for(int j=0;j<dsdyjbxx.length;j++){
				String dyh[] = dsdyjbxx[j].split("-");
				entity.setChdzid(UUID.create());
				entity.setDyh(dyh[0]);
				entity.setDyhlx("1");
				entity.setLch("");
				entity.setSh("");
				entity.setShmc("");
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+entity.getDyh();
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("2");
				//保存单元地址信息
				if("1".equals(bzdzSh)){
					dzDao.saveChdz(entity);
				}else{
					dzDao.saveChdzDxb(entity);
				}
				//保存建筑物层户结构表
				entity.setJzwchid(UUID.create());
				entity.setZdlcs(dyh[1]);
				entity.setZdhs(dyh[2]);
				entity.setDydzbs(entity.getMldzid());
				dzDao.saveJzwChjgb(entity);
			}
			//保存地上楼层地址信息
			String dslcjbxx[] = entity.getDslcjbxx();
			for(int m=0;m<dslcjbxx.length;m++){
				String lc[] = dslcjbxx[m].split("-");
				entity.setChdzid(UUID.create());
				entity.setDyh(lc[0]);
				entity.setDyhlx("1");
				entity.setLch(lc[1]);
				entity.setSh("");
				entity.setShmc("");
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+dslcjbxx[m];
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("3");
				//保存楼层地址信息
				if("1".equals(bzdzSh)){
					dzDao.saveChdz(entity);
				}else{
					dzDao.saveChdzDxb(entity);
				}
			}
			//保存地上户室地址信息
			String dsfjjbxx[] = entity.getDsfjjbxx();
			for(int n=0;n<dsfjjbxx.length;n++){
				String hs[] = dsfjjbxx[n].split("-");
				entity.setChdzid(UUID.create());
				entity.setDyh(hs[0]);
				entity.setDyhlx("1");
				entity.setLch(hs[1]);
				entity.setSh(hs[2]);
				entity.setShmc(hs[1]+"-"+hs[2]);
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+dsfjjbxx[n];
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("4");
				//保存楼层地址信息
				if("1".equals(bzdzSh)){
					dzDao.saveChdz(entity);
				}else{
					dzDao.saveChdzDxb(entity);
				}
			}
		}
	}
	/**
	 * @Title: saveDxChdzdxb 
	 * @描述: 保存地下基本信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用  
	 * @日期： 2015-2-4 上午11:00:16 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDxChdzdxb(BzdzxxbVO entity,String bzdzSh){
		if(entity.getDxdyjbxx()!=null&&!"".equals(entity.getDxdyjbxx())&&entity.getDxdys()!=null){
			//保存地下单元地址信息
			String dxdyjbxx[] = entity.getDxdyjbxx();
			for(int j=0;j<dxdyjbxx.length;j++){
				String dyh[] = dxdyjbxx[j].split("-");
				entity.setChdzid(UUID.create());
				entity.setDyh(dyh[0]);
				entity.setDyhlx("0");
				entity.setLch("");
				entity.setSh("");
				entity.setShmc("");
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+entity.getDyh();
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("2");
				//保存单元地址信息
				if("1".equals(bzdzSh)){
					dzDao.saveChdz(entity);
				}else{
					dzDao.saveChdzDxb(entity);
				}
				//保存建筑物层户结构表
				entity.setJzwchid(UUID.create());
				entity.setZdlcs(dyh[1]);
				entity.setZdhs(dyh[2]);
				entity.setDydzbs(entity.getMldzid());
				dzDao.saveJzwChjgb(entity);
			}
			//保存地下楼层地址信息
			String dxlcjbxx[] = entity.getDxlcjbxx();
			for(int m=0;m<dxlcjbxx.length;m++){
				String lc[] = dxlcjbxx[m].split("-");
				entity.setChdzid(UUID.create());
				entity.setDyh(lc[0]);
				entity.setDyhlx("0");
				entity.setLch(lc[1]);
				entity.setSh("");
				entity.setShmc("");
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+entity.getDyh()+"-B"+lc[1];
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("3");
				//保存楼层地址信息
				if("1".equals(bzdzSh)){
					dzDao.saveChdz(entity);
				}else{
					dzDao.saveChdzDxb(entity);
				}
			}
			//保存地下户室地址信息
			String dxfjjbxx[] = entity.getDxfjjbxx();
			for(int n=0;n<dxfjjbxx.length;n++){
				String hs[] = dxfjjbxx[n].split("-");
				entity.setChdzid(UUID.create());
				entity.setDyh(hs[0]);
				entity.setDyhlx("0");
				entity.setLch(hs[1]);
				entity.setSh(hs[2]);
				entity.setShmc("B"+hs[1]+"-"+hs[2]);
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+entity.getDyh()+"-"+entity.getShmc();
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("4");
				//保存楼层地址信息
				if("1".equals(bzdzSh)){
					dzDao.saveChdz(entity);
				}else{
					dzDao.saveChdzDxb(entity);
				}
			}
		}
	}
	/**
	 * @Title: crossOutDspAndTh
	 * @描述:  注销待审批或被回退地址数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-4 下午6:15:21 
	 * @throws
	 */
	public void crossOutDspAndTh(BzdzxxbVO entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		if("".equals(entity.getXt_zxbz())){
			if("2".equals(entity.getShztdm())){
				entity.setXt_zxyy("警务综合平台_地址管理_待审批地址【注销】");
			}else if("3".equals(entity.getShztdm())){
				entity.setXt_zxyy("警务综合平台_地址管理_被退回地址【注销】");
			}
		}
		//查询门楼地址关联的JZWID
		List<BzdzxxbVO> jzwlist = dzDao.queryJzwid(entity);
		for(int i=0;i<jzwlist.size();i++){
			String jzwid = jzwlist.get(i).getJzwid();
			entity.setJzwid(jzwid);
			//注销关联建筑物ID的数据
			dzDao.crossOutJzwXx(entity);
		}
		//注销关联门楼地址ID的数据
		dzDao.crossOutDsp(entity);
	}
	/**
	 * @Title: queryShDzList 
	 * @描述: 查询地址审核列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-5 下午2:36:34 
	 * @throws
	 */
	public EasyUIPage queryShDzList(EasyUIPage page, BzdzxxbVO entity) {
		return dzDao.queryShDzList(page,entity);
	}
	/**
	 * @Title: queryShDzCount 
	 * @描述: 查询地址审核列表总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-5 下午2:40:12 
	 * @throws
	 */
	public long queryShDzCount(BzdzxxbVO entity) {
		return dzDao.queryShDzCount(entity);
	}
	/**
	 * @Title: queryZzjg 
	 * @描述: 查询组织机构信息（主要查询边界坐标，无公共方法）
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-6 上午10:13:45 
	 * @throws
	 */
	public List<BzdzxxbVO> queryZzjg(String zzjgdm){
		return dzDao.queryZzjg(zzjgdm);
	}
	/**
	 * @Title: queryMldzShXx 
	 * @描述: 查询单条门楼审核地址详情数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-6 下午3:30:09 
	 * @throws
	 */
	public BzdzxxbVO queryMldzShXx(String mldzid){
		return dzDao.queryMldzShXx(mldzid);
	}
    /**
     * @Title: queryDzbm 
     * @描述: 获取地址别名
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-2-7 下午12:47:46 
     * @throws
     */
	public List<BzdzxxbVO> queryDzbm(String mldzid) {
		return dzDao.queryDzbm(mldzid);
	}
	/**
	 * @Title: updateSh 
	 * @描述: 更新审核地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-7 下午2:25:16 
	 * @throws
	 */
	public void updateSh(BzdzxxbVO entity, SessionBean sessionBean){
		setUpdateProperties(entity,sessionBean);
		entity.setShrxm(entity.getXt_zhxgrxm());
		entity.setShrid(entity.getXt_zhxgrid());
		entity.setShsj(entity.getXt_zhxgsj());
		entity.setShdwmc(entity.getXt_zhxgrbm());
		entity.setShdwdm(entity.getXt_zhxgrbmid());
		dzDao.updateSh(entity);
		//如果审核通过将数据插入到门楼地址、层户地址对象表里
		if("02".equals(entity.getShztdm())&&"审核中".equals(entity.getBz())){
			dzDao.insertDzDxb(entity);//审核通过将数据插入到门楼地址、层户地址对象表里
			BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
			//同时插入到BZDZ_ADD_MLDZDXB_PT空间表
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("entity", mldz);
			params.put("srid", gisService.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));
			params.put("objectid", gisService.getSdeSeqValue("BZDZ_ADD_MLDZDXB_PT"));
			dzDao.saveDzDxbPT(params);
			//查询门楼地址关联的JZWID
			List<BzdzxxbVO> jzwlist = dzDao.queryJzwid(entity);
			for(int i=0;i<jzwlist.size();i++){
				String jzwid = jzwlist.get(i).getJzwid();
				entity.setJzwid(jzwid);
				setCrossoutProperties(entity,sessionBean);
				dzDao.updateDzJzw(entity);//更新建筑物
			}
		}else if("02".equals(entity.getShztdm())&&"维护中".equals(entity.getBz())){
			//查询门楼地址关联的JZWID
			List<BzdzxxbVO> jzwlist1 = dzDao.queryJzwid(entity);
			if(jzwlist1.size()!=0){
				//查询门楼地址关联的JZWID
				List<BzdzxxbVO> jzwlist = dzDao.queryJzwidBz(entity);
				for(int i=0;i<jzwlist.size();i++){
					String jzwid = jzwlist.get(i).getJzwid();
					entity.setJzwid(jzwid);
					setCrossoutProperties(entity,sessionBean);
					entity.setXt_zxyy("警务综合平台_地址管理_层户结构注销重建【注销】");
					dzDao.crossOutJzwXx(entity);//维护建筑物信息【正常数据注销】
				}
			}
			for(int i=0;i<jzwlist1.size();i++){
				String jzwid = jzwlist1.get(i).getJzwid();
				entity.setJzwid(jzwid);
				dzDao.updateDzJzw(entity);//更新建筑物
			}
			dzDao.updateDzDxb(entity);//维护审核
		}else if("03".equals(entity.getShztdm())&&"维护中".equals(entity.getBz())){
			BzdzxxbVO dzxxvo = new BzdzxxbVO();
			dzxxvo.setMldzid(entity.getMldzid());
			dzxxvo.setBz("");
			setUpdateProperties(dzxxvo,sessionBean);
			dzDao.updateDzMldz(dzxxvo);//不合格退回对象表
		}
	}
	/**
	 * @Title: queryJzwChjg 
	 * @描述: 获取建筑物层户机构_【建筑物层户结构表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-7 下午5:43:04 
	 * @throws
	 */
	public List<BzdzxxbVO> queryJzwChjg(BzdzxxbVO entity){
		return dzDao.queryJzwChjg(entity);
	}
    /**
     * @Title: queryChShdz 
     * @描述: 获取层户地址_【层户地址审核表】
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-2-9 上午11:26:58 
     * @throws
     */
	public List<BzdzxxbVO> queryChShdz(BzdzxxbVO entity){
		return dzDao.queryChShdz(entity);
	}
	/**
	 * @Title: queryChdzdxb 
	 * @描述: 获取层户地址_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-3 下午2:10:42 
	 * @throws
	 */
	public List<BzdzxxbVO> queryChdzdxb(BzdzxxbVO entity){
		return dzDao.queryChdzdxb(entity);
	}
	/**
	 * @Title: doDeleteYqy 
	 * @描述: 已启用地址注销【有业务数据处理】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 下午7:01:09 
	 * @throws
	 */
	public void doDeleteYqy(BzdzxxbVO entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		if("".equals(entity.getXt_zxyy())){
			entity.setXt_zxyy("警务综合平台_地址管理_已启用地址【注销】");
		}
		//查询门楼地址关联的JZWID
		List<BzdzxxbVO> jzwlist = dzDao.queryJzwid(entity);
		for(int i=0;i<jzwlist.size();i++){
			String jzwid = jzwlist.get(i).getJzwid();
			entity.setJzwid(jzwid);
			//注销关联建筑物ID的数据
			dzDao.crossOutJzwXx(entity);
		}
		//注销关联门楼地址ID的数据【对象表】
		dzDao.crossOutYqy(entity);
	}
	/**
	 * @Title: queryMldzDx 
	 * @描述: 查询单条门楼对象地址详情数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 下午7:53:32 
	 * @throws
	 */
	public BzdzxxbVO queryMldzDx(String mldzid) {
		return dzDao.queryMldzDx(mldzid);
	}
	/**
	 * @Title: updateMldz 
	 * @描述: 更新维护门楼地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用   
	 * @日期： 2015-2-10 下午4:17:32 
	 * @throws
	 */
	public void updateMldz(BzdzxxbVO entity, SessionBean sessionBean) {
		//地址是否进行审核状态【系统配置】
		String bzdzSh = SystemConfig.getString("bzdzSh");
		//更新门楼地址对象表 修改备注字段进入已启用（维护中）状态
		setUpdateProperties(entity,sessionBean);
		if("1".equals(bzdzSh)){
			entity.setBz("维护中");
			dzDao.updateDzMldz(entity);
			List<BzdzxxbVO> volist = dzDao.queryMldzShb(entity.getMldzid());
			if(volist.size()==0){
				//将对象表数据插入到审核表中
				dzDao.insertMldzShb(entity);
			}
			//查询单条门楼对象地址详情数据_【门楼地址对象表】
			BzdzxxbVO mldz = new BzdzxxbVO();
			if("1".equals(entity.getDzChb())){
				mldz = dzDao.queryMldzShXx(entity.getMldzid());
			}else{
				mldz = dzDao.queryMldzDx(entity.getMldzid());
			}
			entity.setChdzmc(mldz.getDzmc());
			entity.setChdzmcpy(mldz.getDzmcpy());
			entity.setChdzmcpwd(mldz.getDzmcpwd());
			entity.setChdzmcpypwd(mldz.getDzmcpypwd());
			//门楼地址审核表
			String dzmc = entity.getXzqhmc()+entity.getMlphqc();
			entity.setDzmc(dzmc);
			entity.setDzmcpy(dzDao.queryPy(dzmc));
			entity.setDzmcpwd(ContextSearchUtils.getPasswordString(dzmc));
			entity.setDzmcpypwd(ContextSearchUtils.getPasswordString(entity.getDzmcpy()));
			entity.setShztdm("01");
			entity.setShbhgyy("");
			dzDao.updateMldzShb(entity);
			//层户地址审核表
			if(!"1".equals(entity.getDzChb())){
				dzDao.deleteChdzShb(entity.getMldzid());
				//将层户地址对象表的数据插入到层户地址审核表里
				dzDao.insertChdzShb(entity);
			}
			//更新层户地址审核表
			dzDao.updateDzChShdz(entity);
		}else{
			//查询单条门楼对象地址详情数据_【门楼地址对象表】
			BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
			entity.setChdzmc(mldz.getDzmc());
			entity.setChdzmcpy(mldz.getDzmcpy());
			entity.setChdzmcpwd(mldz.getDzmcpwd());
			entity.setChdzmcpypwd(mldz.getDzmcpypwd());
			//门楼地址对象表
			String dzmc = entity.getXzqhmc()+entity.getMlphqc();
			entity.setDzmc(dzmc);
			entity.setDzmcpy(dzDao.queryPy(dzmc));
			entity.setDzmcpwd(ContextSearchUtils.getPasswordString(dzmc));
			entity.setDzmcpypwd(ContextSearchUtils.getPasswordString(entity.getDzmcpy()));
			dzDao.updateMldz(entity);
		    //先删除BZDZ_ADD_MLDZDXB_PT空间表数据
			dzDao.crossOutMldzdxbPT(entity);
			//再插入到BZDZ_ADD_MLDZDXB_PT空间表
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("entity", entity);
			params.put("srid", gisService.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));
			params.put("objectid", gisService.getSdeSeqValue("BZDZ_ADD_MLDZDXB_PT"));
			dzDao.saveDzDxbPT(params);
			//更新层户地址对象表
			dzDao.updateDxChdz(entity);
		}
		//删除地址别名
		dzDao.deleteBm(entity.getMldzid());
		//地址别名表
		BzdzxxbVO[] dzBmArray = entity.getDzBmArray();
		if(dzBmArray!=null){
			setSaveProperties(entity,sessionBean);
			for(int i=0;i<dzBmArray.length;i++){
				if(!"".equals(dzBmArray[i].getDzbm())&&dzBmArray[i].getDzbm()!=null){
					 entity.setDzbmid(UUID.create());
					 entity.setDzbm(dzBmArray[i].getDzbm());
					 entity.setBmly("警务综合平台_地址管理【维护】");
					 dzDao.saveBm(entity);
				}
			}
		}
	}
	/**
	 * @Title: updateDymc 
	 * @描述: 修改单元名称
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【旧单元号】、NEWDYH【新单元号】、DYHLX【单元号类型】
	 * @日期： 2015-3-3 上午10:39:56 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDymc(BzdzxxbVO entity, SessionBean sessionBean) {
		//更新层户地址对象表
		setUpdateProperties(entity,sessionBean);
		//获取对应门楼地址对象数据
		BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
		entity.setDzmc(mldz.getDzmc());
		//获取某一单元层户地址_【层户地址对象表】
		List<BzdzxxbVO> chdzlist = dzDao.queryDyChdz(entity);
		for(int i=0;i<chdzlist.size();i++){
			entity.setChdzid(chdzlist.get(i).getChdzid());
			String dzmc = "";
			if("2".equals(chdzlist.get(i).getDzjb())){
				dzmc = entity.getDzmc()+entity.getNewdyh();
			}else if("3".equals(chdzlist.get(i).getDzjb())){
				if("1".equals(entity.getDyhlx())){
					dzmc = entity.getDzmc()+entity.getNewdyh()+"-"+chdzlist.get(i).getLch();
				}else{
					dzmc = entity.getDzmc()+entity.getNewdyh()+"-B"+chdzlist.get(i).getLch();
				}
			}else if("4".equals(chdzlist.get(i).getDzjb())){
				dzmc = entity.getDzmc()+entity.getNewdyh()+"-"+chdzlist.get(i).getShmc();
			}
			entity.setChdzmc(dzmc);
			entity.setChdzmcpy(dzDao.queryPy(dzmc));
			entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(dzmc));
			entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
			//更新单元名称
			dzDao.updateDymc(entity);
		}
		//更新建筑物层户结构表
		dzDao.updateJzwchjgb(entity);
	}
	/**
	 * @Title: updateDycs 
	 * @描述: 修改单元层数_层户地址对象表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【旧楼层数】、NEWLCH【新楼层数】、DYHLX【单元号类型】
	 * @日期： 2015-3-4 上午9:59:46 
	 * @throws
	 */
	public void updateDycs(BzdzxxbVO entity, SessionBean sessionBean) {
		//获取对应门楼地址对象数据
		BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
		entity.setDzmc(mldz.getDzmc());
		entity.setZbx(mldz.getZbx());
		entity.setZby(mldz.getZby());
		int zdlch = Integer.parseInt(entity.getZdlcs());
		int newlcs = Integer.parseInt(entity.getNewlcs());
		if(newlcs>zdlch){
			//新增楼层
			setSaveProperties(entity,sessionBean);
			//保存楼层地址信息
			for(int m=zdlch+1;m<=newlcs;m++){
				entity.setChdzid(UUID.create());
				entity.setLch(String.valueOf(m));
				entity.setSh("");
				entity.setShmc("");
				entity.setShbs("");
				String chdzmc = "";
				if("1".equals(entity.getDyhlx())){
					chdzmc = entity.getDzmc()+entity.getDyh()+"-"+entity.getLch();
				}else{
					chdzmc = entity.getDzmc()+entity.getDyh()+"-B"+entity.getLch();
				}
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("3");
				//保存楼层地址信息
				dzDao.saveChdzDxb(entity);
				//保存户室地址信息
				int zdhs = Integer.parseInt(entity.getZdhs());
				for(int n=1;n<=zdhs;n++){
					entity.setChdzid(UUID.create());
					entity.setSh(String.valueOf(n));
					if("1".equals(entity.getDyhlx())){
						entity.setShmc(entity.getLch()+"-"+entity.getSh());
					}else{
						entity.setShmc("B"+entity.getLch()+"-"+entity.getSh());
					}
					entity.setShbs("");
					String hsdzmc = entity.getDzmc()+entity.getDyh()+"-"+entity.getShmc();
					entity.setChdzmc(hsdzmc);
					entity.setChdzmcpy(dzDao.queryPy(hsdzmc));
					entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(hsdzmc));
					entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
					entity.setDzjb("4");
					//保存楼层地址信息
					dzDao.saveChdzDxb(entity);
				}
			}
		}else{
			//修改单元层数注销楼层数_【层户地址对象表】
			setCrossoutProperties(entity,sessionBean);
			entity.setXt_zxyy("警务综合平台_地址管理_地址维护_层户结构维护_修改单元层数【注销】");
			dzDao.crossChdxbLcs(entity);
		}
		//更新建筑物层户结构表
		setUpdateProperties(entity,sessionBean);
		dzDao.updateJzwchjgb(entity);
	}
	/**
	 * @Title: updateDyhs 
	 * @描述: 修改单元户数_【层户地址对象表】 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、ZDLCS【最大层数】、NEWHS【新户数】、DYHLX【单元号类型】
	 * @日期： 2015-3-4 下午4:41:44 
	 * @throws
	 */
	public void updateDyhs(BzdzxxbVO entity, SessionBean sessionBean) {
		//获取对应门楼地址对象数据
		BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
		entity.setDzmc(mldz.getDzmc());
		entity.setZbx(mldz.getZbx());
		entity.setZby(mldz.getZby());
		int zdlcs = Integer.parseInt(entity.getZdlcs());
		int newhs = Integer.parseInt(entity.getNewhs());
		//修改单元户数注销楼户数_【层户地址对象表】
		setCrossoutProperties(entity,sessionBean);
		entity.setXt_zxyy("警务综合平台_地址管理_地址维护_层户结构维护_修改单元户数【注销】");
		dzDao.crossChdxbhs(entity);
		//新增户数
		setSaveProperties(entity,sessionBean);
		//保存楼层地址信息
		for(int m=1;m<=zdlcs;m++){
			entity.setLch(String.valueOf(m));
			//获取层户地址楼层户数
			String lchs = dzDao.queryChdzLcHs(entity);
			for(int n=1;n<=newhs;n++){
				if(lchs.indexOf(","+n+",") == -1){
					entity.setChdzid(UUID.create());
					entity.setSh(String.valueOf(n));
					if("1".equals(entity.getDyhlx())){
						entity.setShmc(entity.getLch()+"-"+entity.getSh());
					}else{
						entity.setShmc("B"+entity.getLch()+"-"+entity.getSh());
					}
					entity.setShbs("");
					String chdzmc = entity.getDzmc()+entity.getDyh()+"-"+entity.getShmc();
					entity.setChdzmc(chdzmc);
					entity.setChdzmcpy(dzDao.queryPy(chdzmc));
					entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
					entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
					entity.setDzjb("4");
					//保存楼层地址信息
					dzDao.saveChdzDxb(entity);
				}
			}
		}
		//更新建筑物层户结构表
		setUpdateProperties(entity,sessionBean);
		dzDao.updateJzwchjgb(entity);
	}
	/**
	 * @Title: updateDyLchs 
	 * @描述: 修改楼层户数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、ZDHS【最大户数】、NEWHS【新户数】、DYHLX【单元号类型】
	 * @日期： 2015-3-5 上午10:17:35 
	 * @throws
	 */
	public void updateDyLchs(BzdzxxbVO entity, SessionBean sessionBean) {
		//获取对应门楼地址对象数据
		BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
		entity.setDzmc(mldz.getDzmc());
		entity.setZbx(mldz.getZbx());
		entity.setZby(mldz.getZby());
		//查询单层最大户数
		int dyzdhs = Integer.parseInt(entity.getZdhs());
		int newhs = Integer.parseInt(entity.getNewhs());
		//修改楼层户数注销楼户数_【层户地址对象表】
		setCrossoutProperties(entity,sessionBean);
		entity.setXt_zxyy("警务综合平台_地址管理_地址维护_层户结构维护_修改楼层户数【注销】");
		dzDao.crossChdxbhs(entity);
		//获取层户地址楼层户数
		String lchs = dzDao.queryChdzLcHs(entity);
		//新增户数
		setSaveProperties(entity,sessionBean);
		for(int n=1;n<=newhs;n++){
			if(lchs.indexOf(","+n+",") == -1){
				entity.setChdzid(UUID.create());
				entity.setSh(String.valueOf(n));
				if("1".equals(entity.getDyhlx())){
					entity.setShmc(entity.getLch()+"-"+entity.getSh());
				}else{
					entity.setShmc("B"+entity.getLch()+"-"+entity.getSh());
				}
				entity.setShbs("");
				String chdzmc = entity.getDzmc()+entity.getDyh()+"-"+entity.getShmc();
				entity.setChdzmc(chdzmc);
				entity.setChdzmcpy(dzDao.queryPy(chdzmc));
				entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
				entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
				entity.setDzjb("4");
				//保存楼层地址信息
				dzDao.saveChdzDxb(entity);
			}
		}
		if(newhs>dyzdhs){
			//更新建筑物层户结构表
			setUpdateProperties(entity,sessionBean);
			dzDao.updateJzwchjgb(entity);
		}
	}
    /**
     * @Title: updateDyfjmc 
     * @描述: 修改房间名称
     * @作者: zhang_guoliang@founder.com 
     * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、SH【室号】、NEWSH【新室号】、DYHLX【单元号类型】
     * @日期： 2015-3-5 下午2:57:33 
     * @throws
     */
	public void updateDyfjmc(BzdzxxbVO entity, SessionBean sessionBean) {
		//获取对应门楼地址对象数据
		BzdzxxbVO mldz = dzDao.queryMldzDx(entity.getMldzid());
		entity.setDzmc(mldz.getDzmc());
		setUpdateProperties(entity,sessionBean);
		if("1".equals(entity.getDyhlx())){
			entity.setShmc(entity.getLch()+"-"+entity.getNewsh());
		}else{
			entity.setShmc("B"+entity.getLch()+"-"+entity.getNewsh());
		}
		String chdzmc = entity.getDzmc()+entity.getDyh()+"-"+entity.getShmc();
		entity.setChdzmc(chdzmc);
		entity.setChdzmcpy(dzDao.queryPy(chdzmc));
		entity.setChdzmcpwd(ContextSearchUtils.getPasswordString(chdzmc));
		entity.setChdzmcpypwd(ContextSearchUtils.getPasswordString(entity.getChdzmcpy()));
		dzDao.updateDyfjmc(entity);
	}
	/**
	 * @Title: queryHjdKgJt 
	 * @描述: 查询户籍地空挂地址集体
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-3 上午11:23:44 
	 * @throws
	 */
	public DzXxbVO queryHjdKgJt(String zrqdm) {
		return dzDao.queryHjdKgJt(zrqdm);
	}
	/**
	 * @Title: queryHjdKgJm 
	 * @描述: 查询户籍地空挂地址居民 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-3 上午11:24:33 
	 * @throws
	 */
	public DzXxbVO queryHjdKgJm(String zrqdm) {
		return dzDao.queryHjdKgJm(zrqdm);
	}
	/**
	 * @Title: updateDmmc 
	 * @描述: 地名维护【更新服务】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: dmdm 地名代码、dmmc 地名名称 
	 * @日期： 2015-4-9 下午3:19:50 
	 * @throws
	 */
	public void updateDmmc(String dmdm, String dmmc,String olddmmc,SessionBean sessionBean) {
		BzdzxxbVO entity = new BzdzxxbVO();
		entity.setDmdm(dmdm);
		entity.setDmmc(dmmc);
		entity.setOlddmmc(olddmmc);
		setUpdateProperties(entity, sessionBean);
		//更新地址对象表地址、地名名称
		dzDao.updateDxbDmmc(entity);
		//更新地址审核表地址、地名名称
		dzDao.updateShbDmmc(entity);
	}
	/**
	 * @Title: updateHouseHb 
	 * @描述: 合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-10 下午3:55:01 
	 * @throws
	 */
	public void updateHouseHb(BzdzxxbVO entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		String chdz[] = entity.getChdzid().toString().split(",");
		String fjhbbz = getRandColorCode();
		entity.setShbs(fjhbbz);
		for(int i=0;i<chdz.length;i++){
			entity.setChdzid(chdz[i]);
			//更新地址审核表地址、地名名称
			dzDao.updateHouseHb(entity);
		}
	}
	/**
	 * @Title: getRandColorCode 
	 * @描述: 获取十六进制的颜色代码.例如  "#6E36B4" , For HTML , 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-10 下午3:57:20 
	 * @返回值: String    返回类型 
	 * @throws
	 */
	public static String getRandColorCode(){
		String r,g,b;
		Random random = new Random();
		r = Integer.toHexString(random.nextInt(256)).toUpperCase();
		g = Integer.toHexString(random.nextInt(256)).toUpperCase();
		b = Integer.toHexString(random.nextInt(256)).toUpperCase();  
		r = r.length()==1 ? "0" + r : r ;  
		g = g.length()==1 ? "0" + g : g ;  
		b = b.length()==1 ? "0" + b : b ;  
		return r+g+b;
	}
	/**
	 * @Title: updateHouseQxHb 
	 * @描述: 取消合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-11 下午5:04:17 
	 * @throws
	 */
	public void updateHouseQxHb(BzdzxxbVO entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dzDao.updateHouseQxHb(entity);
	}
	/**
	 * @Title: searchAddressMlph 
	 * @描述:【门楼地址】全文检索
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-13 上午10:11:13 
	 * @throws
	 */
	public List<DzContextCombo> searchAddressMlph(DzContextCondition condition) {
		return dzDao.searchAddressMlph(condition);
	}
	/**
	 * @Title: searchAddressMlphXz 
	 * @描述:【层户地址】全文检索
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-13 上午10:29:37 
	 * @throws
	 */
	public List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition) {
		return dzDao.searchAddressMlphXz(condition);
	}
	/**
	 * @Title: queryChdzdxbShow 
	 * @描述: 获取层户地址信息展现内容【此方法有统计_人口、单位信息】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid 【门楼地址ID】
	 * @日期： 2015-5-7 下午2:49:16 
	 * @throws
	 */
	public List<DzBuildingVO> queryChdzdxbShow(String mldzid) {
		return dzDao.queryChdzdxbShow(mldzid);
	}
	/**
	 * @Title: queryDzTjList 
	 * @描述: 标准地址统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-12 下午4:13:18 
	 * @throws
	 */
	public EasyUIPage queryDzTjList(EasyUIPage page, DzTjVO entity) {
		queryTj(entity);
		return dzDao.queryDzTjList(page,entity);
	}
	/**
	 * @Title: queryTj 
	 * @描述: 地址统计查询条件
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-17 下午5:14:06 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void queryTj(DzTjVO entity){
		if(!StringUtils.isBlank(entity.getGxzrq())){
			entity.setOrglevel("50");
			entity.setOrgcode(entity.getGxzrq());
		}else if(!StringUtils.isBlank(entity.getGxpcs())){
			entity.setOrglevel("32");
			entity.setOrgcode(entity.getGxpcs());
			entity.setGxpcs(entity.getGxpcs().substring(0, 8));
		}else if(!StringUtils.isBlank(entity.getGxsxj())){
			entity.setOrglevel("21");
			entity.setOrgcode(entity.getGxsxj());
			entity.setGxsxj(entity.getGxsxj().substring(0, 6));
		}else if(!StringUtils.isBlank(entity.getOrgcode())){
			if("32".equals(entity.getOrglevel())){
				entity.setGxpcs(entity.getOrgcode().substring(0, 8));
			}else if("21".equals(entity.getOrglevel())){
				entity.setGxsxj(entity.getOrgcode().substring(0, 6));
			}
		}else{
			entity.setOrglevel("10");
		}
		if(!StringUtils.isBlank(entity.getRedio())){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if("0".equals(entity.getRedio())){
				entity.setKssj(formatter.format(DateTimeUtils.getTimesmorning()));
				entity.setJssj(formatter.format(DateTimeUtils.getTimesnight()));
			}else if("1".equals(entity.getRedio())){
				entity.setKssj(formatter.format(DateTimeUtils.getTimesWeekmorning()));
				entity.setJssj(formatter.format(DateTimeUtils.getTimesWeeknight()));
			}else if("2".equals(entity.getRedio())){
				entity.setKssj(formatter.format(DateTimeUtils.getTimesMonthmorning()));
				entity.setJssj(formatter.format(DateTimeUtils.getTimesMonthnight()));
			}else if("3".equals(entity.getRedio())){
				entity.setKssj(formatter.format(DateTimeUtils.getTimesQuartermorning()));
				entity.setJssj(formatter.format(DateTimeUtils.getTimesQuarternight()));
			}else if("4".equals(entity.getRedio())){
				entity.setKssj(formatter.format(DateTimeUtils.getTimesYearmorning()));
				entity.setJssj(formatter.format(DateTimeUtils.getTimesYearnight()));
			}else if("5".equals(entity.getRedio())){
				try {
					entity.setJssj(formatter.format(DateTimeHelper.addDays(formatter.parse(entity.getJssj()), 1)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		if("10".equals(entity.getOrglevel())){
			entity.setOrder("FXJDM");
		}else if("21".equals(entity.getOrglevel())){
			entity.setOrder("PCSDM");
		}else{
			entity.setOrder("ZRQDM");
		}
	}
    /**
     * @Title: queryDzTjList_export 
     * @描述: 标准地址统计_导出 
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-5-17 下午5:13:44 
     * @throws
     */
	public List<Map<String, String>> queryDzTjList_export(DzTjVO entity) {
		queryTj(entity);
		return dzDao.queryDzTjList_export(entity);
	}
}