package com.founder.syrkgl.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.misc.BASE64Decoder;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.dao.ZpfjPtryzpDao;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import com.founder.syrkgl.dao.RyRylxfsxxbDao;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.vo.SyrkZtxx;

/******************************************************************************
 * @Package: [com.founder.syrkgl.service.impl.RyRyjbxxbServiceImpl.java]
 * @ClassName: [RyRyjbxxbServiceImpl]
 * @Description: [人员基本信息表接口实现]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午4:53:09]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午4:53:09，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("ryRyjbxxbService")
@Transactional
public class RyRyjbxxbServiceImpl implements RyRyjbxxbService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;

	@Resource(name = "ryRylxfsxxbDao")
	private RyRylxfsxxbDao ryRylxfsxxbDao;

	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;

	@Resource(name = "zpfjPtryzpDao")
	private ZpfjPtryzpDao zpfjPtryzpDao;

	/**
	 * @Title: queryList
	 * @Description: TODO(查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, RyRyjbxxb entity) {
		return ryRyjbxxbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb queryById(String id) {
		return ryRyjbxxbDao.queryById(id);
	}

	/**
	 * @Title: queryByCyzjdmZjhm
	 * @Description: 查询单条（根据证件种类和证件号码）
	 * @param @param cyzjdm
	 * @param @param zjhm
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb queryByCyzjdmZjhm(String cyzjdm, String zjhm) {
		return ryRyjbxxbDao.queryByCyzjdmZjhm(cyzjdm, zjhm);
	}

	/**
	 * @Title: save
	 * @Description: TODO(新增或更新，自动判断是否存在数据)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveOrUpdate(RyRyjbxxb entity, SessionBean sessionBean)
			throws Exception {
		if (entity != null) {
			entity.setSyrkbz("1"); // 设置实有人口标识
			String id = entity.getId();
			String cyzjdm = entity.getCyzjdm();
			String zjhm = entity.getZjhm();
			if (StringUtils.isBlank(id)) { // id为空
				if (StringUtils.isBlank(cyzjdm) || StringUtils.isBlank(zjhm)) { // 证件种类或证件号码为空
					throw new Exception("人员基本信息保存错误：证件种类或证件号码为空！");
				} else {
					RyRyjbxxb entityDb = ryRyjbxxbDao.queryByCyzjdmZjhm(cyzjdm,
							zjhm);
					if (entityDb == null) {
						entity.setId(UUID.create()); // 生成主键
						BaseService.setSaveProperties(entity, sessionBean);
						ryRyjbxxbDao.save(entity, sessionBean);
					} else {
						BeanUtils.mergeObjectProperties(entity, entityDb);
						entity.setId(entityDb.getId());
						BaseService.setUpdateProperties(entityDb, sessionBean);
						ryRyjbxxbDao.update(entityDb, sessionBean);
					}
				}
			} else { // 更新
				BaseService.setUpdateProperties(entity, sessionBean);
				ryRyjbxxbDao.update(entity, sessionBean);
			}
		}
	}

	/**
	 * @Title: delete
	 * @Description: TODO(注销)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(RyRyjbxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRyjbxxbDao.delete(entity, sessionBean);
	}

	private String convertXbdmFromPukangdi(String xb) {
		if (xb.equals("未知的性别")) {
			return "0";
		} else if (xb.equals("男")) {
			return "1";
		} else if (xb.equals("女")) {
			return "2";

		} else if (xb.equals("女性改（变）为男性")) {
			return "3";

		} else if (xb.equals("男性改（变）为女性")) {
			return "4";

		} else {
			return "9";
		}
	}

	@Override
	public long bcRyJbxx(SessionBean sessionBean) {

		// 内存溢出，分页查询，
		int page = 1;// 当前页数
		int rowNumber = 100;// 每页条数
		String begin = "0";
		int end = page * rowNumber;
		int rysum = ryRyjbxxbDao.queryAllCount();
		// 统计一共补回了多少条
		long sum = 0;
		String url = "http://10.78.17.238:9999/lbs";
		String urlParameter = "operation=GetPersonInfoByID&content=";

		while (rysum > end) {
			end = page * rowNumber;
			List<RyRyjbxxb> list = this.ryRyjbxxbDao.queryAllByPage(begin,
					String.valueOf(end));
			for (RyRyjbxxb ryRyjbxxb : list) {
				boolean isUpdated = false;
				String zjhm = ryRyjbxxb.getZjhm();
				String content = "{\"data\":[{\"czrkgmsfhm\":\"" + zjhm
						+ "\"}]}";

				try {
					content = urlParameter
							+ java.net.URLEncoder.encode(content, "UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				PostMethod postMethod = new PostMethod(url);
				byte[] b;
				try {
					b = content.getBytes("utf-8");

					InputStream is = new ByteArrayInputStream(b, 0, b.length);
					RequestEntity re = new InputStreamRequestEntity(is,
							b.length, "application/soap+xml; charset=utf-8");
					postMethod.setRequestEntity(re);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				HttpClient httpClient = new HttpClient();
				HttpConnectionManagerParams managerParams = httpClient
						.getHttpConnectionManager().getParams();
				managerParams.setConnectionTimeout(50000);

				int statusCode = 0;
				try {
					statusCode = httpClient.executeMethod(postMethod);
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (statusCode == 200) {
					logger.debug("调用成功！");
					String soapResponseData = "";
					try {
						soapResponseData = postMethod.getResponseBodyAsString();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JSONObject jb = JSONObject.fromObject(soapResponseData);
					if ((Integer) jb.get("datalen") > 0) {
						JSONObject jo = jb.getJSONArray("data")
								.getJSONObject(0);
						if (StringUtils.isBlank(ryRyjbxxb.getXm())) {
							ryRyjbxxb.setXm(jo.getString("czrkxm"));
							isUpdated = true;
						}
						if (StringUtils.isBlank(ryRyjbxxb.getXbdm())) {
							ryRyjbxxb.setXbdm(this.convertXbdmFromPukangdi(jo
									.getString("czrkxb")));
							isUpdated = true;

						}
						if (StringUtils.isBlank(ryRyjbxxb.getCsrq())) {
							StringBuilder csrq = new StringBuilder(
									zjhm.substring(6, 14));
							csrq.insert(4, "-");
							csrq.insert(7, "-");
							ryRyjbxxb.setCsrq(csrq.toString());
							isUpdated = true;

						}
						if (StringUtils.isBlank(ryRyjbxxb.getMzdm())) {
							ryRyjbxxb.setMzdm(jo.getString("czrkmz"));
							isUpdated = true;

						}
						if (StringUtils.isBlank(ryRyjbxxb.getHjd_xzqhdm())) {
							ryRyjbxxb.setHjd_xzqhdm(jo.getString("dzqh"));
							isUpdated = true;

						}
						if (StringUtils.isBlank(ryRyjbxxb.getHjd_dzms())) {
							ryRyjbxxb.setHjd_dzms(jo.getString("czrkzz"));
							isUpdated = true;

						}
						if (StringUtils.isBlank(ryRyjbxxb.getBz())) {
							ryRyjbxxb.setBz("全国请求服务平台");
						}
						if (isUpdated) {
							BaseService.setSaveProperties(ryRyjbxxb,
									sessionBean);
							ryRyjbxxbDao.update(ryRyjbxxb, sessionBean);
							sum++;
						}
					}
				} else {
					logger.debug("调用全国常住人口失败！错误码：" + statusCode);
				}

			}
			begin = String.valueOf(end - 1);
			page++;
		}
		return sum;
	}

	/**
	 * @Title: dataApply
	 * @Description: TODO(人员基本信息数据复用，自动请求全国库，无照片的自动补)
	 * @param @param cyzjdm
	 * @param @param zjhm
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb dataApply(String cyzjdm, String zjhm,
			SessionBean sessionBean) {
		RyRyjbxxb ryRyjbxxb = null;
		if (!StringUtils.isBlank(zjhm)) {
			ryRyjbxxb = ryRyjbxxbDao.queryByCyzjdmZjhm(cyzjdm, zjhm);
			boolean invokeRequestService = false;
			boolean insertRyJbxx = false;
			boolean insertPicture = false;
			if ("111".equals(cyzjdm) || "112".equals(cyzjdm)
					|| "335".equals(cyzjdm)) { // 身份证类型、临时身份证、机动车驾驶证
				if (ryRyjbxxb == null) {
					insertRyJbxx = true;
					invokeRequestService = true;
					insertPicture = true;
				} else {
					ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
					zpfjPtryzpglb.setRyid(ryRyjbxxb.getId());
					long pictureCount = zpfjPtryzpDao
							.queryPtryzpCount(zpfjPtryzpglb);
					if (pictureCount == 0) {
						invokeRequestService = true;
						insertPicture = true;
					}
				}
				if (invokeRequestService) {
					String url = "http://10.78.17.238:9999/lbs";
					String urlParameter = "operation=GetPersonInfoByID&content=";
					String content = "{\"data\":[{\"czrkgmsfhm\":\"" + zjhm
							+ "\"}]}";
					try {

						content = urlParameter
								+ java.net.URLEncoder.encode(content, "UTF-8");
						PostMethod postMethod = new PostMethod(url);
						byte[] b = content.getBytes("utf-8");
						InputStream is = new ByteArrayInputStream(b, 0,
								b.length);
						RequestEntity re = new InputStreamRequestEntity(is,
								b.length, "application/soap+xml; charset=utf-8");
						postMethod.setRequestEntity(re);
						HttpClient httpClient = new HttpClient();
						HttpConnectionManagerParams managerParams = httpClient
								.getHttpConnectionManager().getParams();
						managerParams.setConnectionTimeout(50000);
						int statusCode = httpClient.executeMethod(postMethod);
						if (statusCode == 200) {
							logger.debug("调用成功！");
							String soapResponseData = postMethod
									.getResponseBodyAsString();
							JSONObject jb = JSONObject
									.fromObject(soapResponseData);
							if ((Integer) jb.get("datalen") > 0) {
								JSONObject jo = jb.getJSONArray("data")
										.getJSONObject(0);
								if (insertRyJbxx) { // 写入人员基本信息
									ryRyjbxxb = new RyRyjbxxb();
									ryRyjbxxb.setId(UUID.create());
									ryRyjbxxb.setSyrkbz("0");
									ryRyjbxxb.setCyzjdm(cyzjdm);
									ryRyjbxxb.setZjhm(zjhm);
									ryRyjbxxb.setXm(jo.getString("czrkxm"));
									ryRyjbxxb.setXbdm(this
											.convertXbdmFromPukangdi(jo
													.getString("czrkxb")));
									// 根据身份证号获取出生日期
									StringBuilder csrq = new StringBuilder(
											zjhm.substring(6, 14));
									csrq.insert(4, "-");
									csrq.insert(7, "-");
									ryRyjbxxb.setCsrq(csrq.toString());
									ryRyjbxxb.setMzdm(jo.getString("czrkmz"));
									ryRyjbxxb.setCsdgjhdqdm("156");
									ryRyjbxxb.setGjdm("156");
									ryRyjbxxb.setJggjdqdm("156");
									ryRyjbxxb.setHjd_xzqhdm(jo
											.getString("dzqh"));
									ryRyjbxxb.setHjd_dzms(jo
											.getString("czrkzz"));
									ryRyjbxxb.setBz("全国请求服务平台");
									BaseService.setSaveProperties(ryRyjbxxb,
											sessionBean);
									ryRyjbxxbDao.save(ryRyjbxxb, sessionBean);
								}

							}
						} else {
							logger.debug("调用全国常住人口失败！错误码：" + statusCode);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (insertPicture) {
						String zpParameter = "operation=GetPersonPhotoByID&content=";
						String zpContent = "{\"data\":[{\"rybh\":\"" + zjhm
								+ "\"}]}";
						try {

							zpContent = zpParameter
									+ java.net.URLEncoder.encode(zpContent,
											"UTF-8");
							PostMethod postMethod = new PostMethod(url);
							byte[] b = zpContent.getBytes("utf-8");
							InputStream is = new ByteArrayInputStream(b, 0,
									b.length);
							RequestEntity re = new InputStreamRequestEntity(is,
									b.length,
									"application/soap+xml; charset=utf-8");
							postMethod.setRequestEntity(re);
							HttpClient httpClient = new HttpClient();
							HttpConnectionManagerParams managerParams = httpClient
									.getHttpConnectionManager().getParams();
							managerParams.setConnectionTimeout(50000);
							int statusCode = httpClient
									.executeMethod(postMethod);
							if (statusCode == 200) {
								logger.debug("调用成功！");
								String soapResponseData = postMethod
										.getResponseBodyAsString();
								JSONObject jb = JSONObject
										.fromObject(soapResponseData);
								if ((Integer) jb.get("datalen") > 0) {
									JSONObject jo = jb.getJSONArray("data")
											.getJSONObject(0);
									byte[] pictureByte = null;
									try {
										pictureByte = new BASE64Decoder()
												.decodeBuffer(jo
														.getString("photo"));
									} catch (Exception ex) {
									}
									if (pictureByte != null) {
										ZpfjPtryzpxxb zpfjPtryzpxxb = new ZpfjPtryzpxxb();
										zpfjPtryzpxxb.setId(UUID.create());
										zpfjPtryzpxxb.setZp(pictureByte);
										zpfjPtryzpxxb.setZpslt(pictureByte);
										BaseService.setSaveProperties(
												zpfjPtryzpxxb, sessionBean);
										zpfjPtryzpDao.savePtryzpxxb(
												zpfjPtryzpxxb, null);
										ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
										zpfjPtryzpglb.setId(UUID.create());
										zpfjPtryzpglb
												.setRyid(ryRyjbxxb.getId());
										zpfjPtryzpglb.setZpid(zpfjPtryzpxxb
												.getId());
										zpfjPtryzpglb.setLyms("人员基本信息表");
										zpfjPtryzpglb
												.setLyid(ryRyjbxxb.getId());
										zpfjPtryzpglb.setLybm("RY_RYJBXXB");
										BaseService.setSaveProperties(
												zpfjPtryzpglb, sessionBean);
										zpfjPtryzpDao.savePtryzpglb(
												zpfjPtryzpglb, null);
									}

								} else {
									System.out.println("调用照片失败！错误码："
											+ statusCode);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
			}
		}
		if (ryRyjbxxb != null) {
			SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbDao
					.queryCzrkByRyid(ryRyjbxxb.getId());
			if (syrkSyrkxxzb != null) { // 户籍地强制取实有人口总表中常住人口的户籍地
				ryRyjbxxb.setHjd_dzid(syrkSyrkxxzb.getHjd_dzid());
				ryRyjbxxb.setHjd_dzxz(syrkSyrkxxzb.getHjd_dzxz());
				ryRyjbxxb.setHjd_mlpdm(syrkSyrkxxzb.getHjd_mlpdm());
				ryRyjbxxb.setHjd_mlpxz(syrkSyrkxxzb.getHjd_mlpxz());
				ryRyjbxxb.setHjd_xzqhdm(syrkSyrkxxzb.getHjd_xzqhdm());
			}
			String lxdh = ryRylxfsxxbDao.queryLastLxfs(ryRyjbxxb.getId()); // 查询最新的联系电话
			ryRyjbxxb.setLxdh(lxdh);
		}

		return ryRyjbxxb;
	}

	@Override
	public long bcPhoto(SessionBean sessionBean) {

		// 内存溢出，分页查询，
		int page = 1;// 当前页数
		int rowNumber = 100;// 每页条数
		String begin = "0";
		int end = page * rowNumber;
		int rysum = ryRyjbxxbDao.queryNotHavePhotoCount();
		long count = 0;
		while (rysum > end) {
			end = page * rowNumber;
			List<RyRyjbxxb> list = this.ryRyjbxxbDao.queryNotHavePhoto(begin,
					String.valueOf(end));
			for (RyRyjbxxb jbxx : list) {
				String url = "http://10.78.17.238:9999/lbs";
				String zpParameter = "operation=GetPersonPhotoByID&content=";
				String zpContent = "{\"data\":[{\"rybh\":\"" + jbxx.getZjhm()
						+ "\"}]}";
				try {

					zpContent = zpParameter
							+ java.net.URLEncoder.encode(zpContent, "UTF-8");
					PostMethod postMethod = new PostMethod(url);
					byte[] b = zpContent.getBytes("utf-8");
					InputStream is = new ByteArrayInputStream(b, 0, b.length);
					RequestEntity re = new InputStreamRequestEntity(is,
							b.length, "application/soap+xml; charset=utf-8");
					postMethod.setRequestEntity(re);
					HttpClient httpClient = new HttpClient();
					HttpConnectionManagerParams managerParams = httpClient
							.getHttpConnectionManager().getParams();
					managerParams.setConnectionTimeout(50000);
					int statusCode = httpClient.executeMethod(postMethod);
					if (statusCode == 200) {
						logger.debug("调用成功！");
						String soapResponseData = postMethod
								.getResponseBodyAsString();
						JSONObject jb = JSONObject.fromObject(soapResponseData);
						if ((Integer) jb.get("datalen") > 0) {
							JSONObject jo = jb.getJSONArray("data")
									.getJSONObject(0);
							byte[] pictureByte = null;
							try {
								pictureByte = new BASE64Decoder()
										.decodeBuffer(jo.getString("photo"));
							} catch (Exception ex) {
							}
							if (pictureByte != null) {
								ZpfjPtryzpxxb zpfjPtryzpxxb = new ZpfjPtryzpxxb();
								zpfjPtryzpxxb.setId(UUID.create());
								zpfjPtryzpxxb.setZp(pictureByte);
								zpfjPtryzpxxb.setZpslt(pictureByte);
								BaseService.setSaveProperties(zpfjPtryzpxxb,
										sessionBean);
								zpfjPtryzpDao
										.savePtryzpxxb(zpfjPtryzpxxb, null);
								ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
								zpfjPtryzpglb.setId(UUID.create());
								zpfjPtryzpglb.setRyid(jbxx.getId());
								zpfjPtryzpglb.setZpid(zpfjPtryzpxxb.getId());
								zpfjPtryzpglb.setLyms("人员基本信息表");
								zpfjPtryzpglb.setLyid(jbxx.getId());
								zpfjPtryzpglb.setLybm("RY_RYJBXXB");
								BaseService.setSaveProperties(zpfjPtryzpglb,
										sessionBean);
								zpfjPtryzpDao
										.savePtryzpglb(zpfjPtryzpglb, null);
								count++;
							}

						} else {
							System.out.println("调用照片失败！错误码：" + statusCode);
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			begin = String.valueOf(end - 1);
			page++;
		}
		return count;
	}

	@Override
	public void synchronizeRyjbxxb(SyrkCzrkxxb entity, SessionBean sessionBean) {
		RyRyjbxxb jbxx = new RyRyjbxxb();
		jbxx.setId(entity.getRyid());
		// jbxx.setHjd_dzid(entity.getHjd_dzid());
		// jbxx.setHjd_dzxz(entity.getHjd_dzxz());
		// jbxx.setHjd_mlpdm(entity.getHjd_mlpdm());
		// jbxx.setHjd_mlpxz(entity.getHjd_mlpxz());
		// jbxx.setHjd_xzqhdm(entity.getHjd_xzqhdm());
		// jbxx.setHjd_pcsdm(sessionBean.getUserOrgCode());
		jbxx.setJzd_dzid(entity.getJzd_dzid());
		jbxx.setJzd_dzxz(entity.getJzd_dzxz());
		jbxx.setJzd_mlpdm(entity.getJzd_mlpdm());
		jbxx.setJzd_mlpxz(entity.getJzd_mlpxz());
		jbxx.setJzd_xzqhdm(entity.getJzd_xzqhdm());
		jbxx.setXm(entity.getXm());
		jbxx.setXbdm(entity.getXbdm());
		jbxx.setMzdm(entity.getMzdm());
		jbxx.setCsrq(entity.getCsrq());
		jbxx.setCsdgjhdqdm(entity.getCsdgjhdqdm());
		jbxx.setCsdssxdm(entity.getCsdssxdm());
		jbxx.setJggjdqdm(entity.getJggjdqdm());
		jbxx.setJgssxdm(entity.getJgssxdm());
		jbxx.setXldm(entity.getXldm());
		jbxx.setHyzkdm(entity.getHyzkdm());
		jbxx.setZzmmdm(entity.getZzmmdm());
		jbxx.setZjxydm(entity.getZjxydm());
		jbxx.setByzkdm(entity.getByzkdm());
		jbxx.setXxdm(entity.getXxdm());
		jbxx.setZy(entity.getZy());
		jbxx.setZylbdm(entity.getZjxydm());
		jbxx.setLxdh(entity.getLxdh());

		BaseService.setSaveProperties(jbxx, sessionBean);
		ryRyjbxxbDao.update(jbxx, sessionBean);
	}

	@Override
	public void synchronizeRyjbxxb(SyrkJzrkxxb entity, SessionBean sessionBean) {
		RyRyjbxxb jbxx = new RyRyjbxxb();
		jbxx.setId(entity.getRyid());
		jbxx.setXm(entity.getXm());
		jbxx.setXbdm(entity.getXbdm());
		jbxx.setMzdm(entity.getMzdm());
		jbxx.setCsrq(entity.getCsrq());
		jbxx.setLxdh(entity.getLxdh());
		jbxx.setZy(entity.getZy());
		jbxx.setZylbdm(entity.getZylbdm());
		jbxx.setJzd_dzid(entity.getJzd_dzid());
		jbxx.setJzd_dzxz(entity.getJzd_dzxz());
		jbxx.setJzd_mlpdm(entity.getJzd_mlpdm());
		jbxx.setJzd_mlpxz(entity.getJzd_mlpxz());
		jbxx.setJzd_xzqhdm(entity.getJzd_xzqhdm());
		BaseService.setSaveProperties(jbxx, sessionBean);
		ryRyjbxxbDao.update(jbxx, sessionBean);
	}

	@Override
	public void synchronizeRyjbxxb(SyrkLdrkxxb entity, SessionBean sessionBean) {
		RyRyjbxxb jbxx = new RyRyjbxxb();
		jbxx.setId(entity.getRyid());
		jbxx.setXm(entity.getXm());
		jbxx.setCym(entity.getCym());
		jbxx.setXbdm(entity.getXbdm());
		jbxx.setMzdm(entity.getMzdm());
		jbxx.setCsrq(entity.getCsrq());
		jbxx.setLxdh(entity.getLxdh());
		jbxx.setHyzkdm(entity.getHyzkdm());
		jbxx.setZzmmdm(entity.getZzmmdm());
		jbxx.setZy(entity.getZy());
		jbxx.setZylbdm(entity.getZylbdm());
		jbxx.setJzd_dzid(entity.getJzd_dzid());
		jbxx.setJzd_dzxz(entity.getJzd_dzxz());
		jbxx.setJzd_mlpdm(entity.getJzd_mlpdm());
		jbxx.setJzd_mlpxz(entity.getJzd_mlpxz());
		jbxx.setJzd_xzqhdm(entity.getJzd_xzqhdm());
		// jbxx.setHjd_xzqhdm(entity.getHjd_xzqhdm());
		// jbxx.setHjd_mlpdm(entity.getHjd_mlpdm());
		// jbxx.setHjd_mlpxz(entity.getHjd_mlpxz());
		// jbxx.setHjd_dzid(entity.getHjd_dzid());
		// jbxx.setHjd_dzxz(entity.getHjd_dzxz());
		BaseService.setSaveProperties(jbxx, sessionBean);
		ryRyjbxxbDao.update(jbxx, sessionBean);
	}

	@Override
	public void synchronizeRyjbxxb(SyrkJwryxxb entity, SessionBean sessionBean) {
		RyRyjbxxb jbxx = new RyRyjbxxb();
		jbxx.setId(entity.getRyid());
		jbxx.setXm(entity.getXm());
		jbxx.setWwx(entity.getWwx());
		jbxx.setWwm(entity.getWwm());
		jbxx.setGjdm(entity.getGjdm());
		jbxx.setCsrq(entity.getCsrq());
		jbxx.setXbdm(entity.getXbdm());
		jbxx.setLxdh(entity.getLxdh());
		jbxx.setJzd_dzid(entity.getJzd_dzid());
		jbxx.setJzd_dzxz(entity.getJzd_dzxz());
		jbxx.setJzd_mlpdm(entity.getJzd_mlpdm());
		jbxx.setJzd_mlpxz(entity.getJzd_mlpxz());
		jbxx.setJzd_xzqhdm(entity.getJzd_xzqhdm());
		BaseService.setSaveProperties(jbxx, sessionBean);
		ryRyjbxxbDao.update(jbxx, sessionBean);
	}

	@Override
	public void synchronizeRyjbxxb(SyrkWlhryxxb entity, SessionBean sessionBean) {
		RyRyjbxxb jbxx = new RyRyjbxxb();
		jbxx.setId(entity.getRyid());
		jbxx.setXm(entity.getXm());
		jbxx.setCym(entity.getCym());
		jbxx.setXbdm(entity.getXbdm());
		jbxx.setMzdm(entity.getMzdm());
		jbxx.setCsrq(entity.getCsrq());
		jbxx.setLxdh(entity.getLxdh());
		jbxx.setXldm(entity.getXldm());
		jbxx.setHyzkdm(entity.getHyzkdm());
		jbxx.setZzmmdm(entity.getZzmmdm());
		jbxx.setZjxydm(entity.getZjxydm());
		jbxx.setByzkdm(entity.getByzkdm());
		jbxx.setXxdm(entity.getXxdm());
		jbxx.setCsdgjhdqdm(entity.getCsdgjhdqdm());
		jbxx.setCsdssxdm(entity.getCsdssxdm());
		jbxx.setZy(entity.getZy());
		jbxx.setZylbdm(entity.getZylbdm());
		jbxx.setJzd_dzid(entity.getJzd_dzid());
		jbxx.setJzd_dzxz(entity.getJzd_dzxz());
		jbxx.setJzd_mlpdm(entity.getJzd_mlpdm());
		jbxx.setJzd_mlpxz(entity.getJzd_mlpxz());
		jbxx.setJzd_xzqhdm(entity.getJzd_xzqhdm());
		BaseService.setSaveProperties(jbxx, sessionBean);
		ryRyjbxxbDao.update(jbxx, sessionBean);
	}

	/**
	 * @Title: update
	 * @描述: 更新【人员基本信息表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 下午9:25:50
	 * @throws
	 */
	public void update(RyRyjbxxb entity, SessionBean sessionBean) {
		ryRyjbxxbDao.update(entity, sessionBean);
	}

	@Override
	public SyrkZtxx getZtxx(String ztrysfzh) {

		SyrkZtxx ztxx = new SyrkZtxx();

		String url = "http://10.78.17.238:9999/lbs";
		String urlParameter = "operation=GetEscapedCriminalByID&content=";
		String content = "{\"data\":[{\"ztrysfzh\":\"" + ztrysfzh + "\"}]}";
		try {

			content = urlParameter
					+ java.net.URLEncoder.encode(content, "UTF-8");
			PostMethod postMethod = new PostMethod(url);
			byte[] b = content.getBytes("utf-8");
			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity re = new InputStreamRequestEntity(is, b.length,
					"application/soap+xml; charset=utf-8");
			postMethod.setRequestEntity(re);
			HttpClient httpClient = new HttpClient();
			HttpConnectionManagerParams managerParams = httpClient
					.getHttpConnectionManager().getParams();
			managerParams.setConnectionTimeout(50000);
			int statusCode = httpClient.executeMethod(postMethod);

			if (statusCode == 200) {
				logger.debug("调用成功！");
				String soapResponseData = postMethod.getResponseBodyAsString();
				JSONObject jb = JSONObject.fromObject(soapResponseData);
				if ((Integer) jb.get("datalen") > 0) {
					JSONObject jo = jb.getJSONArray("data").getJSONObject(0);
					ztxx.setAjlbname(jo.getString("ajlbname"));
					ztxx.setCsrqq(jo.getString("csrqq"));
					ztxx.setCsrqz(jo.getString("csrqz"));
					ztxx.setMz_dm(jo.getString("mz_dm"));
					ztxx.setTprq(jo.getString("tprq"));
					ztxx.setZtryajbh(jo.getString("ztryajbh"));
					ztxx.setZtrybh(jo.getString("ztrybh"));
					ztxx.setZtryhjxz(jo.getString("ztryhjxz"));
					ztxx.setZtryladw(jo.getString("ztryladw"));
					ztxx.setZtryladwname(jo.getString("ztryladwname"));
					ztxx.setZtrylxfs(jo.getString("ztrylxfs"));
					ztxx.setZtrysfzh(jo.getString("ztrysfzh"));
					ztxx.setZtrysg(jo.getString("ztrysg"));
					ztxx.setZtryxb(jo.getString("ztryxb"));
					ztxx.setZtryxbname(jo.getString("ztryxbname"));
					ztxx.setZtryxm(jo.getString("ztryxm"));
					ztxx.setZtryxzxz(jo.getString("ztryxzxz"));
					ztxx.setZtryzbr(jo.getString("ztryzbr"));
					ztxx.setZtryzd18(jo.getString("ztryzd18"));
				}

			} else {
				logger.debug("调用省厅在逃人员服务失败！错误码：" + statusCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ztxx;

	}

}
