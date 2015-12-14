/**********************************************************************   
 * <p>文件名：DxqzxhdSplJbxxbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午4:05:56 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.*;
import com.founder.zafffwqz.dao.*;
import com.founder.zafffwqz.service.DxqzxhdSplJbxxbService;
import com.founder.zafffwqz.vo.DxqzxhdSplVo;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.DxqzxhdSplJbxxbServiceImpl.java]  
 * @ClassName:    [DxqzxhdSplJbxxbServiceImpl]   
 * @Description:  [大型活动审批服务接口实现类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午4:05:56]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午4:05:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Service("dxqzxhdSplJbxxbService")
@Transactional
public class DxqzxhdSplJbxxbServiceImpl extends BaseService implements DxqzxhdSplJbxxbService {
	
	@Resource(name = "dxqzxhdSplJbxxbDao")
	private DxqzxhdSplJbxxbDao jbxxDao;
	
	@Resource(name = "dxqzxhdSplZbCbfxxbDao")
	private DxqzxhdSplZbCbfxxbDao cbfDao;
	
	@Resource(name = "dxqzxhdSplZbSycsxxbDao")
	private DxqzxhdSplZbSycsxxbDao sycsDao;
	
	@Resource(name = "dxqzxhdSplZbXclsssjzwdjxxbDao")
	private DxqzxhdSplZbXclsssjzwdjxxbDao lsdjDao;
	
	@Resource(name = "dxqzxhdSplZbAbzrdwxxbDao")
	private DxqzxhdSplZbAbzrdwxxbDao abdwDao;
	
	@Resource(name = "dxqzxhdSplZbHdjabxxbDao")
	private DxqzxhdSplZbHdjabxxbDao hdabDao;
	
	/*
	 * (非 Javadoc)
	 * <p>Title: queryList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param entity
	 * @return
	 * @see com.founder.zafffwqz.service.DxqzxhdSplJbxxbService#queryList(com.founder.framework.utils.EasyUIPage, com.founder.zafffwqz.bean.DxqzxhdSplJbxxb)
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page,DxqzxhdSplJbxxb entity) {
		return jbxxDao.query(page, entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryById</p>
	 * <p>Description: </p>
	 * @param hdid
	 * @return
	 * @see com.founder.zafffwqz.service.DxqzxhdSplJbxxbService#queryById(java.lang.String)
	 */
	@Override
	public DxqzxhdSplVo queryById(String hdid) {
		DxqzxhdSplVo vo=new DxqzxhdSplVo();
		vo.setHdid(hdid);
		boolean f=jbxxDao.isExist(hdid);
		if(f){
			vo.setJbxx(jbxxDao.query(hdid));
			vo.setAbdw(abdwDao.query(hdid));
			vo.setCbf(cbfDao.query(hdid));
			vo.setHdab(hdabDao.query(hdid));
			vo.setLsjz(lsdjDao.query(hdid));
			vo.setSycs(sycsDao.query(hdid));
		}
		return vo;
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: save</p>
	 * <p>Description: </p>
	 * @param vo
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.DxqzxhdSplJbxxbService#save(com.founder.zafffwqz.vo.DxqzxhdSplVo, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveDxhdSpl(DxqzxhdSplVo vo, SessionBean sessionBean) {
		String hdid=vo.getHdid();
		
		DxqzxhdSplJbxxb jbxx=vo.getJbxx();
		jbxx.setHdid(hdid);
		setSaveProperties(jbxx, sessionBean);
		jbxxDao.saveJbxx(jbxx);
		
		DxqzxhdSplZbAbzrdwxxb abdw=vo.getAbdw();
		abdw.setHdid(hdid);
		setSaveProperties(abdw, sessionBean);
		abdwDao.saveAbdw(abdw);
		dealAbxq(abdw);
		
		
		DxqzxhdSplZbCbfxxb cbf=vo.getCbf();
		cbf.setHdid(hdid);
		setSaveProperties(cbf, sessionBean);
		cbfDao.saveCbf(cbf);
		
		DxqzxhdSplZbHdjabxxb hdab=vo.getHdab();
		hdab.setHdid(hdid);
		setSaveProperties(hdab, sessionBean);
		hdabDao.saveHdab(hdab);
		
		DxqzxhdSplZbXclsssjzwdjxxb lsjz=vo.getLsjz();
		lsjz.setHdid(hdid);
		setSaveProperties(lsjz, sessionBean);
		lsdjDao.saveLsjz(lsjz);
		
		DxqzxhdSplZbSycsxxb sycs=vo.getSycs();
		sycs.setHdid(hdid);
		setSaveProperties(sycs, sessionBean);
		sycsDao.saveSycs(sycs);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: modify</p>
	 * <p>Description: </p>
	 * @param vo
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.DxqzxhdSplJbxxbService#modify(com.founder.zafffwqz.vo.DxqzxhdSplVo, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateDxhdSpl(DxqzxhdSplVo vo, SessionBean sessionBean) {
		String hdid=vo.getHdid();
		
		DxqzxhdSplJbxxb jbxx=vo.getJbxx();
		jbxx.setHdid(hdid);
		setUpdateProperties(jbxx, sessionBean);
		jbxxDao.updateJbxx(jbxx);
		
		DxqzxhdSplZbAbzrdwxxb abdw=vo.getAbdw();
		abdw.setHdid(hdid);
		setUpdateProperties(abdw, sessionBean);
		abdwDao.updateAbdw(abdw);
		dealAbxq(abdw);
		
		DxqzxhdSplZbCbfxxb cbf=vo.getCbf();
		cbf.setHdid(hdid);
		setUpdateProperties(cbf, sessionBean);
		cbfDao.updateCbf(cbf);
		
		DxqzxhdSplZbHdjabxxb hdab=vo.getHdab();
		hdab.setHdid(hdid);
		setUpdateProperties(hdab, sessionBean);
		hdabDao.updateHdab(hdab);
		
		DxqzxhdSplZbXclsssjzwdjxxb lsjz=vo.getLsjz();
		lsjz.setHdid(hdid);
		setUpdateProperties(lsjz, sessionBean);
		lsdjDao.updateLsjz(lsjz);
		
		DxqzxhdSplZbSycsxxb sycs=vo.getSycs();
		sycs.setHdid(hdid);
		setUpdateProperties(sycs, sessionBean);
		sycsDao.updateSycs(sycs);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param hdid
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.DxqzxhdSplJbxxbService#delete(java.lang.String, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void deleteDxhdSpl(String hdid, SessionBean sessionBean) {
		DxqzxhdSplJbxxb jbxx=new DxqzxhdSplJbxxb();
		jbxx.setHdid(hdid);
		setUpdateProperties(jbxx, sessionBean);
		jbxxDao.deleteJbxx(jbxx);
		
		DxqzxhdSplZbAbzrdwxxb abdw=new DxqzxhdSplZbAbzrdwxxb();
		abdw.setHdid(hdid);
		setCrossoutProperties(abdw, sessionBean);
		setUpdateProperties(abdw, sessionBean);
		abdwDao.deleteAbdw(abdw);
		
		DxqzxhdSplZbCbfxxb cbf=new DxqzxhdSplZbCbfxxb();
		cbf.setHdid(hdid);
		setUpdateProperties(cbf, sessionBean);
		cbfDao.deleteCbf(cbf);
		
		DxqzxhdSplZbHdjabxxb hdab=new DxqzxhdSplZbHdjabxxb();
		hdab.setHdid(hdid);
		setUpdateProperties(hdab, sessionBean);
		hdabDao.deleteHdab(hdab);
		
		DxqzxhdSplZbXclsssjzwdjxxb lsjz=new DxqzxhdSplZbXclsssjzwdjxxb();
		lsjz.setHdid(hdid);
		setUpdateProperties(lsjz, sessionBean);
		lsdjDao.deleteLsjz(lsjz);
		
		DxqzxhdSplZbSycsxxb sycs=new DxqzxhdSplZbSycsxxb();
		sycs.setHdid(hdid);
		setUpdateProperties(sycs, sessionBean);
		sycsDao.deleteSycs(sycs);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: isExist</p>
	 * <p>Description: </p>
	 * @param hdid
	 * @return
	 * @see com.founder.zafffwqz.service.DxqzxhdSplJbxxbService#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String hdid) {
		return jbxxDao.isExist(hdid);
	}
	
	/*
	 * 处理安保详情数据
	 */
	private void dealAbxq(DxqzxhdSplZbAbzrdwxxb abdw){
		String abxq=abdw.getAbxq();
		if(!StringUtils.isBlank(abxq)){
			abdwDao.deleteAbxq(abdw.getHdid());
			String[] a=abxq.split(",");
			for(String s:a){
				String[] b=s.split("|");
				if(b.length==3){
					DxqzxhdSplZbAbzlxqxxb xq=new DxqzxhdSplZbAbzlxqxxb();
					xq.setHdid(abdw.getHdid());
					xq.setAbzldm(b[0]);
					xq.setAbzltxt(b[1]);
					xq.setAbzlnum(Long.parseLong(b[2]));
					abdwDao.saveAbxq(xq);
				}
			}
		}
	}
}
