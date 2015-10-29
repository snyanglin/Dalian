package com.founder.service.activitytrace.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.utils.StringUtils;
import com.founder.service.activitytrace.bean.RkRyhdgjb;
import com.founder.service.activitytrace.dao.RkRyhdgjbDao;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;
import com.founder.service.provinceservice.service.ServiceHttpClient;

@Service("rkRyhdgjbService")
@Transactional
public class RkRyhdgjbServiceImpl implements RkRyhdgjbService {

	@Resource(name = "rkRyhdgjbDao")
	private RkRyhdgjbDao rkRyhdgjbDao;

	/**
	 * 查询人员轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjb(String zjhm) {
//		List<RkRyhdgjb> list = new ArrayList<RkRyhdgjb>();
//		ServiceHttpClient client = new ServiceHttpClient();
//		List<ServiceLkxxBean> serviceList = client.QueryLkxxBysfzh(zjhm); // 调用省厅服务
//		if (serviceList != null && serviceList.size() > 0) {
//			for (int i = 0; i < serviceList.size(); i++) {
//				ServiceLkxxBean serviceLkxxBean = serviceList.get(i);
//				String qydzxz = StringUtils.nullToStr(
//						serviceLkxxBean.getQydzxz()).trim();
//				String qyjbqymc = StringUtils.nullToStr(
//						serviceLkxxBean.getQyjbqymc()).trim();
//				String lkdjrzfh = StringUtils.nullToStr(
//						serviceLkxxBean.getLkdjrzfh()).trim();
//				String lkdjrzsj = StringUtils.nullToStr(
//						serviceLkxxBean.getLkdjrzsj()).trim();
//				String lkdjtfsj = StringUtils.nullToStr(
//						serviceLkxxBean.getLkdjtfsj()).trim();
//				RkRyhdgjb rkRyhdgjb = new RkRyhdgjb();
//				if (lkdjrzsj.length() > 8) {
//					lkdjrzsj = lkdjrzsj.substring(0, 8);
//				}
//				rkRyhdgjb.setGjkssj(lkdjrzsj);
//				rkRyhdgjb.setGjdd(qydzxz);
//				String gjsm = "入住旅店：" + qyjbqymc + "，房号：" + lkdjrzfh;
//				if (!StringUtils.isBlank(lkdjtfsj)) {
//					gjsm += "，退房时间：" + lkdjtfsj;
//				}
//				rkRyhdgjb.setGjsm(gjsm);
//				list.add(rkRyhdgjb);
//			}
//		}
		// List<RkRyhdgjb> list = rkRyhdgjbDao.queryRkRyhdgjb(zjhm);
		return null;
	}

	/**
	 * 查询人员轨迹（返回所有数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjbAll(String zjhm) {
		return rkRyhdgjbDao.queryRkRyhdgjbAll(zjhm);
	}

}
