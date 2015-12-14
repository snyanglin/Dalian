package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.syrkgl.bean.JzzblBhSequence;
import com.founder.syrkgl.dao.JzzblBhSequenceDao;
import com.founder.syrkgl.service.JzzblBhSequenceService;

@Service("jzzblBhSequenceService")
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class JzzblBhSequenceServiceImpl extends BaseService implements
		JzzblBhSequenceService {

	@Resource(name="jzzblBhSequenceDao")
	private JzzblBhSequenceDao jzzblBhSequenceDao;

	private final int MAX_CYRCLE_COUNT = 500;
	
	@Override
	public Long getBhSequence(SessionBean sessionBean,String code) {

		int cyrcelCount = 0;//计数器：计算循环次数
		
		boolean hasGotSeuqence = false;
		Long sequence = null;
		
		while(!hasGotSeuqence){
			
			if(cyrcelCount > MAX_CYRCLE_COUNT){
				//防止系统未知异常导致死循环
				throw new BussinessException();
			}
			
			cyrcelCount ++;
			
			//获取规则对应的序列号信息，如果没有，会向DB中初始化1条
			JzzblBhSequence bhSequence = this.getJzzblBhSequence(sessionBean, code);
			
			if(bhSequence == null){
				//防止由于另一个线程提交未结束，导致查询结果为空，强制再查询一次DB
				continue;
			}
			
			Long newSequence = bhSequence.getSequence() + 1;
			bhSequence.setSequence(newSequence);
			
			int updateResultCount = this.jzzblBhSequenceDao.updateJzzblBhSequence(bhSequence);
			
			if(updateResultCount == 1){//更新序列号信息成功，代表没有多线程并发冲突，退出循环
				sequence = newSequence;
				hasGotSeuqence = true;
			}
		}
		
		return sequence;
	}
	
	/**
	 * 获取规则对应的序列号信息，如果没有，会向DB中初始化1条
	 * @param sessionBean
	 * @param code 编号（不含流水号的部分）
	 * <br> 如查询居住编号：code = 组织机构编号12位 + 位年份4位
	 * <br> 如查询打印编号: code = 分局2位 + 位派出所2位 
	 * @return
	 */
	private JzzblBhSequence getJzzblBhSequence(SessionBean sessionBean,String code){
		JzzblBhSequence bhSequence = this.jzzblBhSequenceDao.queryBhSequenceByCode(code);
		if(bhSequence == null){
			try {
				createJzzblBhSequence(sessionBean, code);
			} catch (Exception e) {
				// 当两个人同时初始化首条序列号数据时，由于code是unique，所以会抛出异常
				//那么代表DB中已经有初始化后的数据了，再执行一次查询就可以了
				//前提：DB中当前序列表的code字段已经添加了唯一性约束
			}
		}
		return this.jzzblBhSequenceDao.queryBhSequenceByCode(code);
	}
	
	/**
	 * 创建序列号信息
	 * @param sessionBean
	 * @param code 编号（不含流水号的部分）
	 * <br> 如查询居住编号：code = 组织机构编号12位 + 位年份4位
	 * <br> 如查询打印编号: code = 分局2位 + 位派出所2位 
	 */
	private void createJzzblBhSequence(SessionBean sessionBean,String code){
		JzzblBhSequence bhSequence = new JzzblBhSequence();
		bhSequence.setCode(code);
		bhSequence.setSequence(0l);
		bhSequence.setVersion(0l);
		this.jzzblBhSequenceDao.saveJzzblBhSequence(bhSequence);
	}
	
	

}
