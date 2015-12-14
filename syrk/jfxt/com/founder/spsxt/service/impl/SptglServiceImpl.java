package com.founder.spsxt.service.impl;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.spsxt.bean.Spjkxt;
import com.founder.spsxt.bean.Spjsdw;
import com.founder.spsxt.bean.Spsxt;
import com.founder.spsxt.bean.Sxtpath;
import com.founder.spsxt.dao.SpsxtDao;
import com.founder.spsxt.service.NameValuePairService;
import com.founder.spsxt.service.SptglService;

@Service("sptglService")
@Transactional
public class SptglServiceImpl  extends BaseService implements SptglService{
	@Resource(name = "spsxtDao")
	private SpsxtDao spsxtDao;

	@Resource(name = "nameValuePairService")
	private NameValuePairService nameValuePairService;

	

	@Override
	public Map<String, String> getSpsxtZB(String tm) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map = spsxtDao.getSpsxtZB(tm);
		
		return map;
	}
	@Override
	public List getSpsxtJsdw(String xt_lrrid){

		return spsxtDao.getSpsxtJsdw(xt_lrrid);
	}
	@Override
	public List getSpjkxtByDw(String dwbm){
		return spsxtDao.getSpjkxtByDw(dwbm);
	}
	@Override
	public List getSzdlqy(String xt_lrrbmid){
		return spsxtDao.getSzdlqy(xt_lrrbmid);
	}
	@Override
	public List getSzdlqyQS(){
		return spsxtDao.getSzdlqyQS();
	}
	@Override
	public void save(Spsxt entity, SessionBean sessionBean){
		
		/*
		entity.setId(UUID.create());
		//2014.12.31.修改
		doSxtbhInFj(entity,sessionBean);		
		doSxtbhInZrq(entity,sessionBean);
		
		BaseService.setSaveProperties(entity, sessionBean);
		spsxtDao.save(entity);
		*/
		saveOrUpdate(entity,sessionBean,true);
	}
	//
	@Override
	public void update(Spsxt entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		//2014.12.31.修改
		
		/*
		//修改状态下，摄像头编号为空的
		if(entity.getSxtbh()==null ||entity.getSxtbh().equals("")){
		//公安自建
			if(entity.getSfgazj().equals("1")){
				String sszrq=entity.getSszrq();
				String gldw= entity.getSxtgldw();
				String sxtbh="";
				//责任区为空，取管理单位代码后8位+3位序列号
				if(sszrq.length()==0){
					sxtbh=spsxtDao.getSxtBHByGldw(gldw);
					String gldwFirstEight=gldw.substring(4);
					if(sxtbh!=null&&sxtbh.length()==11){
						int bh=Integer.parseInt(sxtbh.substring(8))+1;
						sxtbh=gldwFirstEight+String.format("%03d", bh);
					}
					else{
						sxtbh= gldwFirstEight+"001";
					}
					
				}
				//责任区代码长度为12位，取责任区代码后8位+3位序列号
				else if(sszrq.length()==12){
					sxtbh=spsxtDao.getSxtBHBySRQ(sszrq);
					String zrqFirstEight=sszrq.substring(4);
					if(sxtbh!=null&&sxtbh.length()==11){
						
						int bh=Integer.parseInt(sxtbh.substring(8))+1;
						System.out.println("#####转换前sxtbh##"+sxtbh+"####bh#####"+bh);
						sxtbh=zrqFirstEight+String.format("%03d", bh);
						System.out.println("#####转换后sxtbh##"+sxtbh+"####bh#####"+bh);
					}
					else{
						sxtbh= zrqFirstEight+"001";
					}
				}
				//责任区代码长度小于12（地铁警务室），取管理单位代码后8位+地铁警务室代码，不够补零占位
				else{
					sxtbh=spsxtDao.getSxtBHBySRQ(sszrq);
					String dtFirstFout=gldw.substring(4,8);
					if(sxtbh!=null&&sxtbh.length()==11){
						int bh=Integer.parseInt(sxtbh.substring(8))+1;
						sxtbh=dtFirstFout+String.format("%04d", sszrq)+String.format("%03d", bh);
					}
					else{
						sxtbh= dtFirstFout+String.format("%04d", sszrq)+"001";
					}
				}
				
				entity.setSxtbh(sxtbh);
			}
		}
		*/
		/*
		doSxtbhInZrq(entity,sessionBean);
		setUpdateProperties(entity, sessionBean);
		
		spsxtDao.update(entity);
		*/
		saveOrUpdate(entity,sessionBean,false);
	}
	
	@Override
	public EasyUIPage queryList(EasyUIPage page,Map map) {
		return spsxtDao.queryList(page, map);
	}

	@Override
	public EasyUIPage queryListForSxtName(EasyUIPage page,Map map) {
		return spsxtDao.queryListForSxtName(page, map);
	}
	
	
	@Override
	public EasyUIPage queryListByBmid(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return spsxtDao.queryListByBmid(page, map);
	}
	
	@Override	
	public Spsxt queryById(String id){
		return spsxtDao.queryById(id);
	}
	@Override	
	public Integer queryByTm(String tm){
		return spsxtDao.queryByTm(tm);
	}	
	
	@Override	
	public Integer queryJsdwCount(Map map){
		return spsxtDao.querySpjsdwCount(map);
	}
	@Override	
	public Integer queryPTCount(Map map){
		return spsxtDao.queryPTCount(map);
	}
	@Override	
	public Integer querySpjkxtCount(Map map){
		return spsxtDao.querySpjkxtCount(map);		
	}
	@Override	
	public Integer queryNVRCount(Map map){
		return spsxtDao.queryNVRCount(map);		
	}
	
	
	//根据摄像头id查找建设单位
	@Override
	public Spjsdw queryJsdwBySxtId(String id){
		return spsxtDao.queryJsdwBySxtId(id);
	}
	//根据摄像头id查找监控系统
	@Override
	public Spjkxt queryJkxtBySxtId(String id){
		return spsxtDao.queryJkxtBySxtId(id);
	}
	
	
	@Override
	public int delete(String id){
		
		return spsxtDao.delete(id);
	
	}
	
	@Override
	public List querySpsxtForMap(String pcsbm,String policeId,String add) {
		// TODO Auto-generated method stub
		Map paramMap=new HashMap();
		paramMap.put("pcsbm", pcsbm);
		paramMap.put("policeId", policeId);
		if(!(add==null || add.equalsIgnoreCase(""))){//参数add有值表示通过地图获取摄像头坐标
			paramMap.put("add","add");
		}
		return spsxtDao.querySpsxtForMap(paramMap);
	}
	//根据主键修改摄像头经纬度
	@Override
	public int modifyCoordinateById(String jd, String wd, String id) {
		// TODO Auto-generated method stub
		Map paramMap=new HashMap();
		paramMap.put("jd", jd);
		paramMap.put("wd", wd);
		paramMap.put("id", id);
		return spsxtDao.modifyCoordinateByXh(paramMap);
	}
	//根据ssjgdm查找机构名称
	@Override
	public String getSsjgdmName(String ssjgdm){
		return spsxtDao.getSsjgdmName(ssjgdm);
	}
	//根据xt_lrrbmid查找派出所（分局）机构代码
	@Override
	public Map<String, String> getSsjgdm(String xt_lrrbmid){
		Map map = new HashMap();
		map = spsxtDao.getSsjgdmPCS(xt_lrrbmid);
		return map;
	}
	//判断orglevel是否为责任区级别
	@Override
	public String getOrgLevel(String xt_lrrbmid){
		return spsxtDao.getOrgLevel(xt_lrrbmid);
	}
	
	//根据用户orgCode前8位获得其所在派出所的所有责任区
	public List getSxtZrq(String orgCode8){
		return spsxtDao.getSxtZrq(orgCode8);
	}
	
	@Override	
	public Integer checkSameName(Map map){
		return spsxtDao.checkSameName(map);		
	}
	@Override	
	public Integer checkSameNameSH(Map map){
		return spsxtDao.checkSameNameSH(map);		
	}
	@Override
	public Integer getRemindInfo(String currentUser) {
		// TODO Auto-generated method stub
		return spsxtDao.getRemindInfo(currentUser);
	}
	//摄像头纠偏分页查询2014.12.20
	@Override
	public EasyUIPage querySpsxtForMap2(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return spsxtDao.querySpsxtForMap2(page, map);
	}


	//处理责任区内摄像头编号
	//--2015.04.08修改
	/*private void doSxtbhInZrq(Spsxt entity, SessionBean sessionBean){
		
		if(entity.getSfgazj().equals("1")){//公安自建
			String sszrq=entity.getSszrq();//所在责任区
			sszrq=(sszrq==null)?"":sszrq;
			String gldw= entity.getSxtgldw();
			String sxtbh="";//本次最终生成的摄像头序号
			String last8=null;
			//社区为空，取所在二级部门+GG+5位序列号
			if(sszrq.length()==0 || sszrq.length()==12){
				if(sszrq.length()==0){//没有责任区，使用管理单位
					String nextBh=null;//下一编号
					String twoLevel=sessionBean.getUserOrgCode().substring(4,8);
					System.out.println(twoLevel);
					twoLevel=twoLevel+"GG";//6位前缀					
					sxtbh=spsxtDao.getSxtBhInZd(twoLevel);
					nextBh="00000";
					if(sxtbh!=null){
						nextBh=sxtbh;
					}
					nextBh=twoLevel+String.format("%05d",Integer.parseInt(nextBh)+1);//11==6+5
					sxtbh=nextBh;
				}
				//责任区代码长度为12位，取责任区代码后8位+3位序列号
				else if(sszrq.length()==12){//选择了责任区或派出所。
					String nextBh=null;//下一编号
					if(sszrq.substring(8,12).equals("0000")){//是派出所
						System.out.println("你选择了派出所:"+sszrq);
						String pcs6=sszrq.substring(4,8)+"XX";//6位
						//派出所范围查找						
						sxtbh=spsxtDao.getSxtBhInPcs(pcs6);//5位序号
						nextBh="00000";
						if(sxtbh!=null){
							nextBh=sxtbh;
						}
						nextBh=pcs6+String.format("%05d",Integer.parseInt(nextBh)+1);//11==6+5
					}
					else{//是责任区
						System.out.println("你选择了责任区:"+sszrq);
						String zrq8=sszrq.substring(4,12);//8位						
						sxtbh=spsxtDao.getSxtBhInZrq(zrq8);//3位
						nextBh="000";
						if(sxtbh!=null){				
							nextBh=sxtbh;			
						}
						nextBh=zrq8+String.format("%03d",Integer.parseInt(nextBh)+1);//11==8+3						
					}
					System.out.println("责任区或派出所当前摄像头序号:"+sxtbh+",下一摄像头编号："+nextBh);
					sxtbh=nextBh;
				}//end if(sszrq.length()==12)
			
			}
			//责任区代码长度小于12（地铁警务室），取管理单位代码后8位+地铁警务室代码，不够补零占位
			else{
				sxtbh=spsxtDao.getSxtBHBySRQ(sszrq);
				String dtFirstFout=gldw.substring(4,8);
				if(sxtbh!=null&&sxtbh.length()==11){//公安自建视频(11位==>分局（2位）+派出所（2位）+责任区（4位）+序列号（3位）)
					int bh=Integer.parseInt(sxtbh.substring(8))+1;
					sxtbh=dtFirstFout+String.format("%04d", sszrq)+String.format("%03d", bh);
				}
				else{
					sxtbh= dtFirstFout+String.format("%04d", sszrq)+"001";
				}
			}
			
			entity.setSxtbh(sxtbh);
		}//end sfgazj='1'
		else{//社会视频
			//处理社会视频
		}

	}*/
	//处理责任区内摄像头编号
	//--2015.04.08修改
	private void doSxtbhInZrq(Spsxt entity, SessionBean sessionBean){
	
		if(entity.getSfgazj().equals("1")){//公安自建
			String sszrq=entity.getSszrq();//所在责任区
			sszrq=(sszrq==null)?"":sszrq;
			String gldw= entity.getSxtgldw();
			String sxtbh="";//本次最终生成的摄像头序号
			String last8=null;

			if(sszrq.equals("高速公路") || sszrq.length()==12){
				if(sszrq.equals("高速公路")){//没有责任区，高速公路，使用xt_lrrbmid
					String nextBh=null;//下一编号
					String twoLevel=sessionBean.getUserOrgCode().substring(4,8);
					System.out.println(twoLevel);
					twoLevel=twoLevel+"GG";//6位前缀					
					sxtbh=spsxtDao.getSxtBhInZd(twoLevel);
					nextBh="00000";
					if(sxtbh!=null){
						nextBh=sxtbh;
					}
					nextBh=twoLevel+String.format("%05d",Integer.parseInt(nextBh)+1);//11==6+5
					sxtbh=nextBh;
				}
				//责任区代码长度为12位，取责任区代码后8位+3位序列号
				else if(sszrq.length()==12){//选择了责任区
					String nextBh=null;//下一编号

					System.out.println("你选择了责任区:"+sszrq);
					String zrq8=sszrq.substring(4,12);//8位						
					sxtbh=spsxtDao.getSxtBhInZrq(zrq8);//3位
					nextBh="000";
					if(sxtbh!=null){				
						nextBh=sxtbh;			
					}
					nextBh=zrq8+String.format("%03d",Integer.parseInt(nextBh)+1);//11==8+3						

					System.out.println("责任区或派出所当前摄像头序号:"+sxtbh+",下一摄像头编号："+nextBh);
					sxtbh=nextBh;
				}//end if(sszrq.length()==12)

			}
			//责任区代码长度小于12（地铁警务室），取管理单位代码后8位+地铁警务室代码，不够补零占位
			else{
				sxtbh=spsxtDao.getSxtBHBySRQ(sszrq);
				String dtFirstFout=gldw.substring(4,8);
				if(sxtbh!=null&&sxtbh.length()==11){//公安自建视频(11位==>分局（2位）+派出所（2位）+责任区（4位）+序列号（3位）)
					int bh=Integer.parseInt(sxtbh.substring(8))+1;
					sxtbh=dtFirstFout+String.format("%04d", sszrq)+String.format("%03d", bh);
				}
				else{
					sxtbh= dtFirstFout+String.format("%04d", sszrq)+"001";
				}
			}
			
			entity.setSxtbh(sxtbh);
		}//end sfgazj='1'
		else{//社会视频
			//处理社会视频
		}

	}
	//处理分局范围内摄像头编号(以满足省厅要求)2014.12.31.
	private void doSxtbhInFj(Spsxt entity, SessionBean sessionBean){
		//获得当前用户所在的分局代码
		String userFjCode=nameValuePairService.get2LevelDepartByOrgCode(sessionBean.getUserOrgCode());	
		String userFjCode6=userFjCode.substring(0,6);//分局代码前6位
		String maxSxtBhInFj=spsxtDao.getSxtBhInFj(userFjCode6);//本分局内当前摄像头的最大编号
		int nextSxtBhInFj=0;//本分局内下一个摄像头编号
		if(maxSxtBhInFj!=null){
			nextSxtBhInFj=Integer.parseInt(maxSxtBhInFj);
		}
		nextSxtBhInFj+=1;//增加1作为下一个编号
		String formatNextSxtBhInFj=userFjCode6+String.format("%06d", nextSxtBhInFj);
		System.out.println("本分局内下一个摄像头编号："+formatNextSxtBhInFj);				
		entity.setFjNumber(formatNextSxtBhInFj);	
			
	}
	//同步处理新增和修改
	synchronized private void saveOrUpdate(Spsxt entity, SessionBean sessionBean,boolean isSave){
		if(isSave){//新增
			entity.setId(UUID.create());
			//2014.12.31.修改
			doSxtbhInFj(entity,sessionBean);		
			doSxtbhInZrq(entity,sessionBean);
			
			BaseService.setSaveProperties(entity, sessionBean);
			spsxtDao.save(entity);
		}
		else{//修改
			//2014.12.31.修改
			doSxtbhInZrq(entity,sessionBean);
			setUpdateProperties(entity, sessionBean);			
			spsxtDao.update(entity);			
		}
	}
	@Override	
	public Integer checkXTIDBM(Map map){
		return spsxtDao.checkXTIDBM(map);		
	}
	
	//2015.03.30--PDA端采集的照片
	@Override
	public Sxtpath getPDASxtPic(String sxtid){
		return spsxtDao.getPDASxtPic(sxtid);
	}
}
