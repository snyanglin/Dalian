package com.founder.bzdz.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.bzdz.dao.DmDao;
import com.founder.bzdz.service.DmService;
import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.DmxxbVO;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
/**
 * @类名: DmServiceImpl 
 * @描述: 地名管理ServiceImpl
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-10 下午3:46:51 
 */
@Service("dmService")
@Transactional
public class DmServiceImpl extends BaseService implements DmService {
	@Resource(name = "dmDao")
	private DmDao dmDao;
	@Resource(name = "dzService")
	private DzService dzService;
	/**
	 * @Title: queryDmList 
	 * @描述: 查询地名列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-10 下午3:47:52 
	 * @throws
	 */
	public EasyUIPage queryDmList(EasyUIPage page, DmxxbVO entity) {
		return dmDao.queryDmList(page,entity);
	}
	/**
	 * @Title: queryDmCount 
	 * @描述: 查询地名列表总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-10 下午4:03:03 
	 * @throws
	 */
	public long queryDmCount(DmxxbVO entity) {
		return dmDao.queryDmCount(entity);
	}
	/**
	 * @Title: queryDm 
	 * @描述: 获取地名信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午3:52:04 
	 * @throws
	 */
	public DmxxbVO queryDm(DmxxbVO entity) {
		return dmDao.queryDm(entity);
	}
	/**
	 * @Title: queryXzqh 
	 * @描述: 获取单位的行政区划
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午4:20:46 
	 * @throws
	 */
	public List<DmxxbVO> queryXzqh(DmxxbVO entity) {
		return dmDao.queryXzqh(entity);
	}
	/**
	 * @Title: queryGxdw 
	 * @描述: 获取单位的管辖单位
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午4:20:50 
	 * @throws
	 */
	public List<DmxxbVO> queryGxdw(DmxxbVO entity) {
		return dmDao.queryGxdw(entity);
	}
	/**
	 * @Title: saveDm 
	 * @描述: 保存地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午2:28:38 
	 * @throws
	 */
	public void saveDm(DmxxbVO entity, SessionBean sessionBean) {
		DmxxbVO [] zxqhArry = entity.getDmxzqhbArray();
		DmxxbVO [] zzjgArry = entity.getDmzzjgbArray();
		if(zxqhArry!=null&&zzjgArry!=null){
			entity.setDmid(UUID.create());
			String xzqhdm = zxqhArry[0].getXzqhdm();
			String dmdm = dmDao.queryDmdm(xzqhdm);
			entity.setDmdm(dmdm);
			setSaveProperties(entity,sessionBean);
			dmDao.saveDm(entity);
			//保存到所属行政区划表
			for(int i=0;i<zxqhArry.length;i++){
				if(!"".equals(zxqhArry[i].getXzqhdm())&&zxqhArry[i].getXzqhdm()!=null){
					entity.setDmxzqhid(UUID.create());
					entity.setXzqhdm(zxqhArry[i].getXzqhdm());
					dmDao.saveXzqh(entity);
				}
			}
			//保存到所属管辖单位表
            for(int i=0;i<zzjgArry.length;i++){
            	if(!"".equals(zzjgArry[i].getPcsdm())&&zzjgArry[i].getPcsdm()!=null){
            		entity.setDmzzjgid(UUID.create());
                	entity.setZrqdm(zzjgArry[i].getZrqdm());
                	entity.setPcsdm(zzjgArry[i].getPcsdm());
                	entity.setFxjdm(zzjgArry[i].getFxjdm());
    				dmDao.saveZzjg(entity);
            	}
			}
		}
	}
	/**
	 * @Title: editDm 
	 * @描述: 地名维护
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-9 下午2:58:14 
	 * @throws
	 */
	public void editDm(DmxxbVO entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dmDao.updateDm(entity);
		//修改地址地名【更新服务】
		dzService.updateDmmc(entity.getDmdm(), entity.getDmmc(),entity.getOlddmmc(),sessionBean);
	}
	/**
	 * @Title: queryDmPd 
	 * @描述: 判断地名是否重复
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午2:46:28 
	 * @throws
	 */
	public List<DmxxbVO> queryDmPd(DmxxbVO entity) {
		return dmDao.queryDmPd(entity);
	}
	/**
	 * @Title: crossouDm 
	 * @描述: 注销地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-17 下午6:57:16 
	 * @throws
	 */
	public void crossouDm(DmxxbVO entity, SessionBean sessionBean) {
		setCrossoutProperties(entity,sessionBean);
		dmDao.crossouDm(entity);
	}
	/**
	 * @Title: quertDlst 
	 * @描述: 查询地图图层
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-18 下午3:00:38 
	 * @throws
	 */
	public List<DmxxbVO> quertDlst(DmxxbVO entity) {
		List<DmxxbVO> line = dmDao.queryMapLine(entity);
		if (line != null && line.size() > 0) {
			for (DmxxbVO o : line) {
				String coords = o.getCoords();
				if (coords.endsWith(")")) {
					coords = coords.substring(coords.indexOf("(") + 2,
							coords.indexOf(")"));
					coords = coords.replaceAll(" ", ",").replaceAll(",,", ",");
					o.setCoords(coords);
				}
			}
		}
		return line;
	}
	/**
	 * @Title: queryMldzPd 
	 * @描述: 判断门楼地址是否存在
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-18 下午5:29:45 
	 * @throws
	 */
	public boolean queryMldzPd(DmxxbVO entity){
		return dmDao.queryMldzPd(entity);
	}
	/**
	 * @Title: queryDictDm 
	 * @描述: 获取地名下拉框字典
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 上午10:59:13 
	 * @throws
	 */
	public List<ComboBox> queryDictDm(Map<String,String> map) {
		return dmDao.queryDictDm(map);
	}
	/**
	 * @Title: queryDictSq 
	 * @描述: 获取社区下拉框字典
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 下午4:00:19 
	 * @throws
	 */
	public List<ComboBox> queryDictSq(String pcsdm) {
		return dmDao.queryDictSq(pcsdm);
	}
}