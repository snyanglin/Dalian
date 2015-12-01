/**********************************************************************   
 * <p>文件名：SjzdlcgServiceImpl.java </p>
 * <p>文件描述：上级指定列撤管
 * @project_name：syrk_1
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-1-28 上午10:06:49 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.organization.assign.service.OrgAssignPublic;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdry.bean.Sjzdlcg;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.dao.ZdrySjzdlcgDao;
import com.founder.zdry.service.ZdrySjzdlcgService;
import com.founder.syrkgl.dao.RyRyjbxxbDao;

/******************************************************************************
 * @Package:      [com.founder.syrk.service.impl.SjzdlcgServiceImpl.java]  
 * @ClassName:    [SjzdlcgServiceImpl]   
 * @Description:  上级指定列撤管  
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-1-28 上午10:06:49]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-1-28 上午10:06:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("zdrySjzdlcgService")
@Transactional
public class ZdrySjzdlcgServiceImpl extends BaseService implements ZdrySjzdlcgService {
	
	@Resource(name = "zdrySjzdlcgDao")
	private ZdrySjzdlcgDao zdrySjzdlcgDao;
	
	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;

	@Override
	public EasyUIPage queryLgZdryzdlb(EasyUIPage page, RyRyjbxxb entity) {
		return zdrySjzdlcgDao.queryLgZdryzdlb(page, entity);
	}

	public List<ZdryZdryzb> querySubList(ZdryZdryzb entity) {
		return zdrySjzdlcgDao.querySubList(entity);
	}

	@Override
	public RyRyjbxxb queryRyjbxxbById(String ryid) {
		return ryRyjbxxbDao.queryById(ryid);
	}

	@Override
	public List<Map<String, String>> getJzdzJsonList(String ryid) {
		List<Map<String, String>> dzList = zdrySjzdlcgDao.queryJzdzByRyid(ryid);
		OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
		for(Map<String, String> dz : dzList){
			List<OrgUserInfo> orgUserList = orgAssignPublic.queryUserByOrgAndPos(dz.get("zrqdm"), null);
			if(orgUserList != null){
				if(orgUserList.size() > 0){
					OrgUserInfo orgUser = orgUserList.get(0);
					dz.put("gxmj", orgUser.getUsername());
					dz.put("gxmjlxdh", orgUser.getMobile());
				}
			}
		}
		return dzList;
	}
	
	@Override
	public Map<String, String> getHjdzJson(String ryid){
		Map<String, String> hjdz = zdrySjzdlcgDao.queryHjdzByRyid(ryid);
		OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
		if(hjdz != null){
			List<OrgUserInfo> orgUserList = orgAssignPublic.queryUserByOrgAndPos(hjdz.get("ZRQDM"), null);
			if(orgUserList != null){
				if(orgUserList.size() > 0){
					OrgUserInfo orgUser = orgUserList.get(0);
//					hjdz.setGxmj(orgUser.getUsername());
//					hjdz.setGxmjlxdh(orgUser.getMobile());
					hjdz.put("gxmj", orgUser.getUsername());
					hjdz.put("gxmjlxdh", orgUser.getMobile());
				}
			}
		}
		return hjdz;
	}

	@Override
	public String queryZdrylbLg(String ryid) {
		return zdrySjzdlcgDao.queryZdrylb(ryid);
	}

	
	@Override
	public EasyUIPage queryCgZdryzdlb(EasyUIPage page, ZdryZdryzb entity) {
		return zdrySjzdlcgDao.queryCgZdryzdlb(page, entity);
	}

	@Override
	public Map<String, String> getCgDzJson(String syrkid) {
		Map<String, String> dz = zdrySjzdlcgDao.queryCgDzBySyrkid(syrkid);
		OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
		List<OrgUserInfo> orgUserList = orgAssignPublic.queryUserByOrgAndPos(dz.get("ZRQDM"), null);
		if(orgUserList != null){
			if(orgUserList.size() > 0){
				OrgUserInfo orgUser = orgUserList.get(0);
				dz.put("gxmj", orgUser.getUsername());
				dz.put("gxmjlxdh", orgUser.getMobile());
			}
		}
		return dz;
	}

	@Override
	public String queryLcgidForCg(Sjzdlcg entity) {
		return zdrySjzdlcgDao.queryLcgidForCg(entity);
	}

	@Override
	public String queryZdrylxdmByZdrylbdm(String zdrylbdm) {
		return zdrySjzdlcgDao.queryZdrylxdmByZdrylbdm(zdrylbdm);
	}
	
}
