package com.founder.ldym.service;

import java.util.Hashtable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.ldym.dao.SysDictDao;
import com.founder.ldym.pojo.SysDict;
import com.founder.ldym.util.StringUtil;
import com.founder.ldym.util.SystemConfig;


/**
 * 
 * <p>
 * 标题：字典业务逻辑层
 * </p>
 * <p>
 * 描述：
 * </p>
 * <p>
 * Copyright：Copyright(c) 2014 founder
 * </p>
 * <p>
 * 日期：2014-3-12
 * </p>
 * 
 * @author yi_chu
 */
@Service(value="dictService")
@Transactional
public class SysDictService {

	/**
	 * SysDictDao自动装配
	 */
	@Resource(name="dictDao")
	private SysDictDao sysDictDao;
	
	/**
	 * 
	 * <p>
	 * 说明：获取列表
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:23:38
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @return String
	 */
	public List<SysDict> getDictList(String zdbh) {
		List<SysDict> list = sysDictDao.findAllList(zdbh);
		return list;
	}

	/**
	 * <p>
	 * 说明： 根据sql查询字典数据
	 * </p>
	 * <p>
	 * 时间：2014-8-4 上午11:03:03
	 * </p>
	 * 
	 * @param sql
	 *            查询sql完整语句
	 * @return objectArray 传入的参数
	 */
	public List<SysDict> findAllListBySql(String sql, Object[] objectArray) {
		return sysDictDao.findAllListBySql(sql, objectArray);
	}

	/**
	 * 
	 * <p>
	 * 说明：获取列表（自定义排序）
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:23:38
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param orderBy
	 *            排序语句
	 * @return String
	 */
	public List<SysDict> getDictListOrderBy(String zdbh, String orderBy) {
		List<SysDict> list = sysDictDao.findAllList(zdbh, orderBy);
		return list;
	}

	/**
	 * <p>
	 * 说明：获取警情类别列表
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:23:38
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zddm
	 *            字典代码
	 * @param count
	 *            标记
	 * @return String 查询结果
	 */
	public List<SysDict> getDictList(String zdbh, String zddm, int count) {
		List<SysDict> list = sysDictDao.findAllList(zdbh, zddm, count);
		return list;
	}

	/**
	 * 
	 * <p>
	 * 说明：获取列表
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:23:38
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param xzqh
	 *            行政区划
	 * @return String
	 */
	public List<SysDict> getDlDictList(String zdbh, String xzqh) {
		List<SysDict> list = sysDictDao.findAllDlList(zdbh, xzqh,
				SystemConfig.getString("GIS_DB_USER"));

		return list;
	}

	/**
	 * 
	 * <p>
	 * 说明：获取列表
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:23:38
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param dldm
	 *            道路代码
	 * @return String
	 */
	public List<SysDict> getLdDictList(String zdbh, String dldm) {
		List<SysDict> list = sysDictDao.findAllLdList(zdbh, dldm,
				SystemConfig.getString("GIS_DB_USER"));
		return list;
	}
	
	/**
	 * 获取GPS重点监控车辆类型
	 * @param zdbh 字典编号
	 * @returnList<SysDict>
	 */
	public List<SysDict> getGpsCarTypeDictList(String zdbh){
		return sysDictDao.getGpsCarTypeDictList(zdbh);
	}

	/**
	 * <p>
	 * 说明：获取路信息
	 * </p>
	 * <p>
	 * 时间：2014-4-10 下午5:37:22
	 * </p>
	 * 
	 * @param zdbh
	 *            字典代码
	 * @param xzqh
	 *            行政区划
	 * @return 路段信息
	 */
	public List<SysDict> getLdByXzqh(String zdbh, String xzqh) {
		List<SysDict> list = sysDictDao.findLdByXzqh(zdbh, xzqh,
				SystemConfig.getString("GIS_DB_USER"));
		return list;
	}

	/**
	 * 
	 * <p>
	 * 说明：创建列表JS
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:23:38
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @return String
	 */
	public String createListJS(String zdbh, String zdbhMc) {
		List<SysDict> list = sysDictDao.findAllList(zdbh);
		if (list != null && list.size() > 0) {
			String dm, mc, py, wb, xtZxbz;
			long dmMaxLength = 0;
			long mcMaxLength = 0;
			long count = list.size();
			long tempLength;

			for (int i = 0; i < list.size(); i++) {
				SysDict entity = list.get(i);
				dm = StringUtil.nullToStr(entity.getDm());
				tempLength = StringUtil.getStringLength(dm);
				if (tempLength > dmMaxLength) {
					dmMaxLength = tempLength;
				}
				mc = StringUtil.nullToStr(entity.getCt());
				tempLength = StringUtil.getStringLength(mc);
				if (tempLength > mcMaxLength) {
					mcMaxLength = tempLength;
				}
			}

			// 字体大小为12px,滚动条加30px
			long listWidth = (dmMaxLength + mcMaxLength + 3) * 6 + 30;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();
			StringBuffer sb = new StringBuffer();
			long countAdd = 0;
			for (int i = 0; i < list.size(); i++) {
				SysDict entity = (SysDict) list.get(i);
				countAdd++;
				xtZxbz = StringUtil.nullToStr(entity.getXt_zxbz());
				if ("".equals(xtZxbz)) {
					xtZxbz = "0";
				}
				dm = StringUtil.nullToStr(entity.getDm());
				mc = StringUtil.nullToStr(entity.getCt());
				py = StringUtil.nullToStr(entity.getPy());
				wb = StringUtil.nullToStr(entity.getWb());
				dm = dm.replaceAll("\n", "");
				mc = mc.replaceAll("\n", "");
				py = py.replaceAll("\n", "");
				wb = wb.replaceAll("\n", "");
				sb.append("[" + xtZxbz + ",'" + dm + "','");
				sb.append(mc + "','" + py + "','" + wb + "','");
				String optionText = StringUtil.getRepeatString("\\xA0",
						dmMaxLength - dm.length());
				sb.append(dm + optionText + "\\xA0|\\xA0']");
				if (countAdd == count) {
					sb.append(StringUtil.enterNewline);
				} else {
					sb.append("," + StringUtil.enterNewline);
				}
			}
			StringBuffer sbJs = new StringBuffer();
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			if (zdbhMc == null) {
				sbJs.append("this.listName = '';" + StringUtil.enterNewline);
			} else {
				sbJs.append("this.listName = '" + zdbhMc + "';"
						+ StringUtil.enterNewline);
			}
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(sb.toString());
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);
			return sbJs.toString();
		} else {
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();
			long count = 0;
			long listWidth = 180;
			StringBuffer sbJs = new StringBuffer();
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			if (zdbhMc == null) {
				sbJs.append("this.listName = '';" + StringUtil.enterNewline);
			} else {
				sbJs.append("this.listName = '" + zdbhMc + "';"
						+ StringUtil.enterNewline);
			}
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);
			return sbJs.toString();
		}
	}

	/**
	 * 
	 * <p>
	 * 说明：创建列表JS
	 * </p>
	 * <p>
	 * 时间：2014-3-28下午16:59:59
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @param xzqh
	 *            行政区划
	 * @param dldm
	 *            道路代码
	 * @return String
	 */
	public String createListJS(String zdbh, String zdbhMc, String xzqh,
			String dldm) {
		List<SysDict> list = null;
		if (SystemConfig.getString("JT_ROADITEM").equals(zdbh.toUpperCase())) {// GIS用户下的表封装字典
			list = sysDictDao.findAllList(zdbh,
					SystemConfig.getString("GIS_DB_USER"), xzqh, dldm);
		} else if (SystemConfig.getString("JT_ROADSEGITEM").equals(
				zdbh.toUpperCase())) {// GIS用户下的表封装字典
			list = sysDictDao.findAllList(zdbh,
					SystemConfig.getString("GIS_DB_USER"), xzqh, dldm);
		} else {
			list = sysDictDao.findAllList(zdbh);
		}
		if (list != null && list.size() > 0) {
			String dm, mc, py, wb, xtZxbz;
			long dmMaxLength = 0;
			long mcMaxLength = 0;
			long count = list.size();
			long tempLength;

			for (int i = 0; i < list.size(); i++) {
				SysDict entity = list.get(i);
				dm = StringUtil.nullToStr(entity.getDm());
				tempLength = StringUtil.getStringLength(dm);
				if (tempLength > dmMaxLength) {
					dmMaxLength = tempLength;
				}
				mc = StringUtil.nullToStr(entity.getCt());
				tempLength = StringUtil.getStringLength(mc);
				if (tempLength > mcMaxLength) {
					mcMaxLength = tempLength;
				}
			}

			// 字体大小为12px,滚动条加30px
			long listWidth = (dmMaxLength + mcMaxLength + 3) * 6 + 30;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();
			StringBuffer sb = new StringBuffer();
			long countAdd = 0;
			for (int i = 0; i < list.size(); i++) {
				SysDict entity = (SysDict) list.get(i);
				countAdd++;
				xtZxbz = StringUtil.nullToStr(entity.getXt_zxbz());
				if ("".equals(xtZxbz)) {
					xtZxbz = "0";
				}
				dm = StringUtil.nullToStr(entity.getDm());
				mc = StringUtil.nullToStr(entity.getCt());
				py = StringUtil.nullToStr(entity.getPy());
				wb = StringUtil.nullToStr(entity.getWb());
				dm = dm.replaceAll("\n", "");
				mc = mc.replaceAll("\n", "");
				py = py.replaceAll("\n", "");
				wb = wb.replaceAll("\n", "");
				sb.append("[" + xtZxbz + ",'" + dm + "','");
				sb.append(mc + "','" + py + "','" + wb + "','");
				String optionText = StringUtil.getRepeatString("\\xA0",
						dmMaxLength - dm.length());
				sb.append(dm + optionText + "\\xA0|\\xA0']");
				if (countAdd == count) {
					sb.append(StringUtil.enterNewline);
				} else {
					sb.append("," + StringUtil.enterNewline);
				}
			}
			StringBuffer sbJs = new StringBuffer();
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			if (zdbhMc == null) {
				sbJs.append("this.listName = '';" + StringUtil.enterNewline);
			} else {
				sbJs.append("this.listName = '" + zdbhMc + "';"
						+ StringUtil.enterNewline);
			}
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(sb.toString());
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);
			return sbJs.toString();
		} else {
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();
			long count = 0;
			long listWidth = 180;
			StringBuffer sbJs = new StringBuffer();
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			if (zdbhMc == null) {
				sbJs.append("this.listName = '';" + StringUtil.enterNewline);
			} else {
				sbJs.append("this.listName = '" + zdbhMc + "';"
						+ StringUtil.enterNewline);
			}
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);
			return sbJs.toString();
		}
	}

	/**
	 * 
	 * <p>
	 * 说明：创建树形JS
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:58:21
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @return String
	 */
	public String createTreeJS(String zdbh, String zdbhMc) {
		String querySql = "select * from T_SYS_DICT where ZDBH='" + zdbh
				+ "' and XT_ZXBZ='0' order by DM";
		List<SysDict> list = sysDictDao.findDictForCustomize(querySql);
		String treeName = zdbhMc;// 字典名称
		int nameMaxLength = 23;// 最大树形选择框宽度（汉字个数）
		if (list != null && list.size() > 0) {// 有数据
			long count = list.size();
			String dm, mc, py, wb, ztbs;
			String prevDm = "";
			String treeID = "";
			String treeParentID = "";
			int isLeaf = 0;
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			long countAdd = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer();// list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			int maxLengthInt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCt().length() > maxLengthInt) {
					maxLengthInt = list.get(i).getCt().length();
				}
			}
			if (maxLengthInt > nameMaxLength) {
				maxLengthInt = nameMaxLength;
			}
			int listWidth = maxLengthInt * 12;
			listWidth += 8 * 12 + 30; // 多加8个汉字
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			StringBuffer sbJsTree = new StringBuffer();// list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			for (int i = 0; i < list.size(); i++) {
				countAdd++;
				StringBuffer sbJsOption = new StringBuffer();// list文件中的option
				ztbs = list.get(i).getXt_zxbz();
				if ("".equals(ztbs)) {
					ztbs = "0";
				}
				dm = StringUtil.nullToStr(list.get(i).getDm());
				mc = StringUtil.nullToStr(list.get(i).getCt());
				py = StringUtil.nullToStr(list.get(i).getPy());
				wb = StringUtil.nullToStr(list.get(i).getWb());
				dm = dm.replaceAll("\n", "");
				mc = mc.replaceAll("\n", "");
				py = py.replaceAll("\n", "");
				wb = wb.replaceAll("\n", "");
				sbJsOption.append("[" + ztbs + ",'" + dm + "','");
				sbJsOption.append(mc + "','" + py + "','" + wb + "',");
				treeParentID = "";
				if (dm.endsWith("000")) {
					prevDm = "";
					treeID = dm;
					treeParentID = "";
					// long subCount = 0;
					querySql = "select count(*) from T_SYS_DICT where ZDBH='"
							+ zdbh + "' and DM<>'" + treeID + "' and DM like '"
							+ dm.substring(0, 14) + "%' and DM like '%"
							+ dm.substring(15, dm.length()) + "'";
					if (sysDictDao.isExistDictForCustomize(querySql)) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				} else if (dm.endsWith("00")
						&& !"0".equals(String.valueOf(dm.charAt(dm.length() - 3)))) {
					prevDm = dm.substring(0, 14) + "000";
					treeID = dm;
					treeParentID = "";
					// long subCount = 0;
					querySql = "select count(*) from T_SYS_DICT where ZDBH='"
							+ zdbh + "' and DM<>'" + treeID + "' and DM like '"
							+ dm.substring(0, 15) + "%'";
					if (sysDictDao.isExistDictForCustomize(querySql)) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				} else {
					isLeaf = 1;
					prevDm = dm.substring(0, 15) + "00";
					String elementPrev = hashTable.get(prevDm);// String
																// elementPrev =
																// (String)
																// hashTable.get(prevDm);
					if (elementPrev != null) {
						treeID = elementPrev + "_" + dm;
						treeParentID = elementPrev;
					} else {
						prevDm = "";
						treeID = dm;
						treeParentID = "";
					}
				}
				if ("".equals(treeParentID)) {
					sbJsOption.append(isLeaf + ",'RO']");
				} else {
					sbJsOption.append(isLeaf + ",'RO_" + treeParentID + "']");
				}
				if (countAdd == count) {
					sbJsOption.append(StringUtil.enterNewline);
				} else {
					sbJsOption.append("," + StringUtil.enterNewline);
				}
				sbJs.append(sbJsOption.toString());

				if ("0".equals(ztbs)) {
					if ("".equals(prevDm)) {
						sbJsTree.append("data['RO_" + dm + "']='text:" + mc
								+ ";';" + StringUtil.enterNewline);
					} else {
						sbJsTree.append("data['" + prevDm + "_" + dm
								+ "']='text:" + mc + ";';"
								+ StringUtil.enterNewline);
					}
				}
			}
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		} else {
			long count = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer(); // list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			StringBuffer sbJsTree = new StringBuffer(); // list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		}
	}

	/**
	 * 
	 * <p>
	 * 说明：创建组织机构树形JS
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:58:21
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @param zzjgdm
	 *            组织机构代码
	 * @param auth
	 *            权限
	 * @param userId
	 *            用户登录ID
	 * @return String  v3222
	 */
	public String createOrganizationTreeJS(String zdbh, String zdbhMc,
			String zzjgdm, String auth, String userId) {
		List<SysDict> list = sysDictDao.findOrganizationDictForCustomize(
				zzjgdm, auth, userId);
		return constructTreeString(zdbh, zdbhMc, list);
	}
	
	
	public String createLocalOrganizationTreeJS(String zdbh, String zdbhMc,
			String zzjgdm, String auth, String userId) {
		List<SysDict> list = sysDictDao.findLocalOrganizationDictForCustomize(
				zzjgdm, auth, userId);
		return constructTreeString(zdbh, zdbhMc, list);
	}
	

	private String constructTreeString(String zdbh, String zdbhMc,
			List<SysDict> list) {
		String treeName = zdbhMc;// 字典名称
		int nameMaxLength = 23;// 最大树形选择框宽度（汉字个数）
		if (list != null && list.size() > 0) {// 有数据
			long count = list.size();
			String dm, mc, py, wb, ztbs;
			String prevDm = "";
			String treeID = "";
			String treeParentID = "";
			int isLeaf = 0;
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			long countAdd = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer();// list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			int maxLengthInt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCt().length() > maxLengthInt) {
					maxLengthInt = list.get(i).getCt().length();
				}
			}
			if (maxLengthInt > nameMaxLength) {
				maxLengthInt = nameMaxLength;
			}
			int listWidth = maxLengthInt * 12;
			listWidth += 8 * 12 + 30; // 多加8个汉字
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			StringBuffer sbJsTree = new StringBuffer();// list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			for (int i = 0; i < list.size(); i++) {
				countAdd++;
				StringBuffer sbJsOption = new StringBuffer();// list文件中的option
				ztbs = list.get(i).getXt_zxbz();
				if (StringUtil.isEmpty(ztbs)) {
					ztbs = "0";
				}
				dm = StringUtil.nullToStr(list.get(i).getDm());
				mc = StringUtil.nullToStr(list.get(i).getCt());
				py = StringUtil.nullToStr(list.get(i).getPy());
				wb = StringUtil.nullToStr(list.get(i).getWb());
				dm = dm.replaceAll("\n", "");
				mc = mc.replaceAll("\n", "");
				py = py.replaceAll("\n", "");
				wb = wb.replaceAll("\n", "");
				sbJsOption.append("[" + ztbs + ",'" + dm + "','");
				sbJsOption.append(mc + "','" + py + "','" + wb + "',");
				treeParentID = "";
				if ("1".equals(list.get(i).getTreeLevel())) {// 第一级节点
					prevDm = "";
					treeID = dm;
					treeParentID = "";
					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				} else {
					prevDm = StringUtil.nullToStr(list.get(i).getParentDm());
					String elementPrev = hashTable.get(prevDm);
					if (elementPrev != null) {
						treeID = elementPrev + "_" + dm;
						treeParentID = elementPrev;
					} else {
						prevDm = "";
						treeID = dm;
						treeParentID = "";
					}
					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				}
				if ("".equals(treeParentID)) {
					sbJsOption.append(isLeaf + ",'RO']");
				} else {
					sbJsOption.append(isLeaf + ",'RO_" + treeParentID + "']");
				}
				if (countAdd == count) {
					sbJsOption.append(StringUtil.enterNewline);
				} else {
					sbJsOption.append("," + StringUtil.enterNewline);
				}
				sbJs.append(sbJsOption.toString());

				if ("0".equals(ztbs)) {
					if ("".equals(prevDm)) {
						sbJsTree.append("data['RO_" + dm + "']='text:" + mc
								+ ";';" + StringUtil.enterNewline);
					} else {
						sbJsTree.append("data['" + prevDm + "_" + dm
								+ "']='text:" + mc + ";';"
								+ StringUtil.enterNewline);
					}
				}
			}
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		} else {
			long count = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer(); // list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			StringBuffer sbJsTree = new StringBuffer(); // list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		}
	}

	/**
	 * 
	 * <p>
	 * 说明：创建gps分组树形JS
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:58:21
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @param zzjgdm
	 *            组织机构代码
	 * @return String
	 */
	public String createGpsTreeJS(String zdbh, String zdbhMc, String zzjgdm) {
		List<SysDict> list = sysDictDao.findGpsDictForCustomize(zzjgdm);
		String treeName = zdbhMc;// 字典名称
		int nameMaxLength = 23;// 最大树形选择框宽度（汉字个数）
		if (list != null && list.size() > 0) {// 有数据
			long count = list.size();
			String dm, mc, py, wb, ztbs, bz;
			String prevDm = "";
			String treeID = "";
			String treeParentID = "";
			int isLeaf = 0;
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			long countAdd = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer();// list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			int maxLengthInt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCt().length() > maxLengthInt) {
					maxLengthInt = list.get(i).getCt().length();
				}
			}
			if (maxLengthInt > nameMaxLength) {
				maxLengthInt = nameMaxLength;
			}
			int listWidth = maxLengthInt * 12;
			listWidth += 8 * 12 + 30; // 多加8个汉字
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			StringBuffer sbJsTree = new StringBuffer();// list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			for (int i = 0; i < list.size(); i++) {
				countAdd++;
				StringBuffer sbJsOption = new StringBuffer();// list文件中的option
				ztbs = list.get(i).getXt_zxbz();
				if (StringUtil.isEmpty(ztbs)) {
					ztbs = "0";
				}
				dm = StringUtil.nullToStr(list.get(i).getDm());
				mc = StringUtil.nullToStr(list.get(i).getCt());
				py = StringUtil.nullToStr(list.get(i).getPy());
				wb = StringUtil.nullToStr(list.get(i).getWb());
				dm = dm.replaceAll("\n", "");
				mc = mc.replaceAll("\n", "");
				py = py.replaceAll("\n", "");
				wb = wb.replaceAll("\n", "");
				bz = StringUtil.nullToStr(list.get(i).getBz());
				sbJsOption.append("[" + ztbs + ",'" + dm + "','");
				sbJsOption.append(mc + "','" + py + "','" + wb + "',");
				treeParentID = "";
				if ("1".equals(list.get(i).getTreeLevel())) {// 第一级节点
					prevDm = "";
					treeID = dm;
					treeParentID = "";
					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				} else {
					prevDm = StringUtil.nullToStr(list.get(i).getParentDm());
					String elementPrev = hashTable.get(prevDm);
					if (elementPrev != null) {
						treeID = elementPrev + "_" + dm;
						treeParentID = elementPrev;
					} else {
						prevDm = "";
						treeID = dm;
						treeParentID = "";
					}
					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				}
				if ("".equals(treeParentID)) {
					sbJsOption.append(isLeaf + ",'RO'");
				} else {
					sbJsOption.append(isLeaf + ",'RO_" + treeParentID + "'");
				}
				sbJsOption.append(",'" + bz + "']");
				if (countAdd == count) {
					sbJsOption.append(StringUtil.enterNewline);
				} else {
					sbJsOption.append("," + StringUtil.enterNewline);
				}
				
				sbJs.append(sbJsOption.toString());
			
				if ("0".equals(ztbs)) {
					if ("".equals(prevDm)) {
						sbJsTree.append("data['RO_" + dm + "']='text:" + mc
								+ ";';" + StringUtil.enterNewline);
					} else {
						sbJsTree.append("data['" + prevDm + "_" + dm
								+ "']='text:" + mc + ";';"
								+ StringUtil.enterNewline);
					}
				}
			}
		
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		} else {
			long count = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer(); // list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			StringBuffer sbJsTree = new StringBuffer(); // list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		}
	}

	/**
	 * 
	 * <p>
	 * 说明：创建带有权限的组织机构树形JS
	 * </p>
	 * <p>
	 * 时间：2014-3-12 下午1:58:21
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @param zzjgdm
	 *            组织机构代码
	 * @return String
	 */
//	public String createAuthorityOrganizationTreeJS(String zdbh, String zdbhMc,
//			String zzjgdm, String id) {
//		List<String> zzjgdmArray = SystemUtil.getPropertyByid(id);
//		List<SysDict> list = sysDictDao
//				.findAuthorityOrganizationDictForCustomize(zzjgdm, zzjgdmArray);
//		String treeName = zdbhMc;// 字典名称
//		int nameMaxLength = 23;// 最大树形选择框宽度（汉字个数）
//		if (list != null && list.size() > 0) {// 有数据
//			long count = list.size();
//			String dm, mc, py, wb, ztbs;
//			String prevDm = "";
//			String treeID = "";
//			String treeParentID = "";
//			int isLeaf = 0;
//			Hashtable<String, String> hashTable = new Hashtable<String, String>();
//			long countAdd = 0;
//			String tableNameUpper = zdbh.toUpperCase();
//			String tableNameLower = zdbh.toLowerCase();
//
//			StringBuffer sbJs = new StringBuffer();// list文件
//			sbJs.append("function " + tableNameLower + "() {"
//					+ StringUtil.enterNewline);
//			sbJs.append("this.listName = '" + treeName + "';"
//					+ StringUtil.enterNewline);
//			sbJs.append("this.realSize = " + count + ";"
//					+ StringUtil.enterNewline);
//			int maxLengthInt = 0;
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i).getCt().length() > maxLengthInt) {
//					maxLengthInt = list.get(i).getCt().length();
//				}
//			}
//			if (maxLengthInt > nameMaxLength) {
//				maxLengthInt = nameMaxLength;
//			}
//			int listWidth = maxLengthInt * 12;
//			listWidth += 8 * 12 + 30; // 多加8个汉字
//			sbJs.append("this.listWidth = " + listWidth + ";"
//					+ StringUtil.enterNewline);
//			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
//			StringBuffer sbJsTree = new StringBuffer();// list_tree文件
//			sbJsTree.append("var data = {};" + StringUtil.enterNewline);
//
//			for (int i = 0; i < list.size(); i++) {
//				countAdd++;
//				StringBuffer sbJsOption = new StringBuffer();// list文件中的option
//				ztbs = list.get(i).getXt_zxbz();
//				if (StringUtil.isEmpty(ztbs)) {
//					ztbs = "0";
//				}
//				dm = StringUtil.nullToStr(list.get(i).getDm());
//				mc = StringUtil.nullToStr(list.get(i).getCt());
//				py = StringUtil.nullToStr(list.get(i).getPy());
//				wb = StringUtil.nullToStr(list.get(i).getWb());
//				dm = dm.replaceAll("\n", "");
//				mc = mc.replaceAll("\n", "");
//				py = py.replaceAll("\n", "");
//				wb = wb.replaceAll("\n", "");
//				sbJsOption.append("[" + ztbs + ",'" + dm + "','");
//				sbJsOption.append(mc + "','" + py + "','" + wb + "',");
//				treeParentID = "";
//				if ("1".equals(list.get(i).getTreeLevel())) {// 第一级节点
//					prevDm = "";
//					treeID = dm;
//					treeParentID = "";
//					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
//						isLeaf = 0;
//						hashTable.put(dm, treeID);
//					} else {
//						isLeaf = 1;
//					}
//				} else {
//					prevDm = StringUtil.nullToStr(list.get(i).getParentDm());
//					String elementPrev = hashTable.get(prevDm);
//					if (elementPrev != null) {
//						treeID = elementPrev + "_" + dm;
//						treeParentID = elementPrev;
//					} else {
//						prevDm = "";
//						treeID = dm;
//						treeParentID = "";
//					}
//					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
//						isLeaf = 0;
//						hashTable.put(dm, treeID);
//					} else {
//						isLeaf = 1;
//					}
//				}
//				if ("".equals(treeParentID)) {
//					sbJsOption.append(isLeaf + ",'RO']");
//				} else {
//					sbJsOption.append(isLeaf + ",'RO_" + treeParentID + "']");
//				}
//				if (countAdd == count) {
//					sbJsOption.append(StringUtil.enterNewline);
//				} else {
//					sbJsOption.append("," + StringUtil.enterNewline);
//				}
//				sbJs.append(sbJsOption.toString());
//
//				if ("0".equals(ztbs)) {
//					if ("".equals(prevDm)) {
//						sbJsTree.append("data['RO_" + dm + "']='text:" + mc
//								+ ";';" + StringUtil.enterNewline);
//					} else {
//						sbJsTree.append("data['" + prevDm + "_" + dm
//								+ "']='text:" + mc + ";';"
//								+ StringUtil.enterNewline);
//					}
//				}
//			}
//			sbJs.append(");" + StringUtil.enterNewline);
//			sbJs.append("}" + StringUtil.enterNewline);
//			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
//					+ "();" + StringUtil.enterNewline);
//
//			return sbJs.toString() + sbJsTree.toString() + "■"
//					+ sbJsTree.toString();
//		} else {
//			long count = 0;
//			String tableNameUpper = zdbh.toUpperCase();
//			String tableNameLower = zdbh.toLowerCase();
//
//			StringBuffer sbJs = new StringBuffer(); // list文件
//			sbJs.append("function " + tableNameLower + "() {"
//					+ StringUtil.enterNewline);
//			sbJs.append("this.listName = '" + treeName + "';"
//					+ StringUtil.enterNewline);
//			sbJs.append("this.realSize = " + count + ";"
//					+ StringUtil.enterNewline);
//			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
//			sbJs.append(");" + StringUtil.enterNewline);
//			sbJs.append("}" + StringUtil.enterNewline);
//			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
//					+ "();" + StringUtil.enterNewline);
//
//			StringBuffer sbJsTree = new StringBuffer(); // list_tree文件
//			sbJsTree.append("var data = {};" + StringUtil.enterNewline);
//
//			return sbJs.toString() + sbJsTree.toString() + "■"
//					+ sbJsTree.toString();
//		}
//	}

	/**
	 * <p>
	 * 说明：获得组织结构字典
	 * </p>
	 * <p>
	 * 时间：2014-4-3 下午7:21:49
	 * </p>
	 * 
	 * @param zzjglx
	 *            组织机构类型
	 * @return List<SysDict>
	 */
	public List<SysDict> getSysDictListByZzjglx(String zzjglx) {
		// String dbuser = SystemConfig.getString("EZMANAGER_DB_USERNAME");
		StringBuffer sb = new StringBuffer();
		sb.append("select zzjgdm as dm,zzjgmc as ct from ")
		// .append(dbuser).append(".t_zzjg  ");
				.append("t_zzjg  ");
		sb.append("where zzjglx='").append(zzjglx).append("' and sfyx = 1");
		return sysDictDao.findDictForCustomize(sb.toString());
	}

	/**
	 * <p>
	 * 说明：获得组织结构字典
	 * </p>
	 * <p>
	 * 时间：2014-4-3 下午7:21:49
	 * </p>
	 * 
	 * @param zzjgdm
	 *            组织机构代码
	 * @return List<SysDict>
	 */
	public List<SysDict> getSysDictListByZzjgdm(String zzjgdm) {
		// String dbuser = SystemConfig.getString("EZMANAGER_DB_USERNAME");
		StringBuffer sb = new StringBuffer();
		sb.append("select zzjgdm as dm,zzjgmc as ct from ")
		// .append(dbuser).append(".t_zzjg  ");
				.append("t_zzjg  ");
		sb.append("where ssjgdm='").append(zzjgdm).append("' and sfyx = 1");
		return sysDictDao.findDictForCustomize(sb.toString());
	}

	/**
	 * <p>
	 * 说明： 获得设备类型字典
	 * </p>
	 * <p>
	 * 时间：2014-4-3 下午7:21:49
	 * </p>
	 * 
	 * @param zdmc
	 *            设备类型
	 * @return List<SysDict>
	 */
	public List<SysDict> getSysDictListByGpssbdm(String zdbh) {
		// String dbuser = SystemConfig.getString("EZMANAGER_DB_USERNAME");
		StringBuffer sb = new StringBuffer();
		if ("JCLX".equals(zdbh)) {
			sb.append("SELECT T.POLICETYPEID  AS p_id,  '").append(zdbh)
					.append("'  AS zdbh,").append(" '警种类型 ' AS zdmc,");
			sb.append("T.POLICETYPENAME  AS ct, T.POLICETYPEID AS dm,F_GETPYSZM(T.POLICETYPENAME) AS py,F_GETWBSZM(T.POLICETYPENAME) AS wb");
			sb.append(" from  T_GPS_POLICETYPE  T");
		}
		if ("JRLX".equals(zdbh)) {
			sb.append("SELECT T.GPSSTYLEID  AS p_id,  '").append(zdbh)
					.append("'  AS zdbh,").append(" '接入类型 ' AS zdmc,");
			sb.append("T.TYPENAME  AS ct, T.GPSSTYLEID AS dm,F_GETPYSZM(T.TYPENAME) AS py,F_GETWBSZM(T.TYPENAME) AS wb");
			sb.append(" from  T_GPS_STYLE  T");
		}
		if ("DWLX".equals(zdbh)) {
			sb.append("SELECT T.LOCALTYPEID  AS p_id,  '").append(zdbh)
					.append("'  AS zdbh,").append(" '定位类型' AS zdmc,");
			sb.append("T.LOCALTYPENAME  AS ct, T.LOCALTYPEID AS dm,F_GETPYSZM(T.LOCALTYPENAME) AS py,F_GETWBSZM(T.LOCALTYPENAME) AS wb");
			sb.append(" from  T_GPS_LOCALTYPE  T");
		}
		if ("TPLX".equals(zdbh)) {
			sb.append("SELECT T.ORDERINDEX  AS p_id,  '").append(zdbh)
					.append("'  AS zdbh,").append(" '图片类型' AS zdmc,");
			sb.append("T.PICTURETYPE  AS ct, T.ORDERINDEX AS dm,F_GETPYSZM(T.PICTURETYPE) AS py,F_GETWBSZM(T.PICTURETYPE) AS wb");
			sb.append(" from  T_GPS_PICTURETYPE  T");
		}
//		//System.out.print(sb.toString());
		return sysDictDao.findDictForCustomize(sb.toString());
	}

	/**
	 * 
	 * <p>
	 * 说明：创建基础资源树形JS
	 * </p>
	 * <p>
	 * 时间：2014-8-12 下午1:58:21
	 * </p>
	 * 
	 * @param zdbh
	 *            字典编号（字典表名）
	 * @param zdbhMc
	 *            字典名称
	 * @param zzjgdm
	 *            code代码
	 * @return String
	 */
	public String createJczyTreeJS(String zdbh, String zdbhMc, String zzjgdm) {

		String layerType = "";
		if ("资源专题树".equals(zdbhMc)) {
			layerType = "PT";
		}
		List<SysDict> list = sysDictDao.findZyglDictForCustomize(zzjgdm,layerType);
		String treeName = zdbhMc;// 字典名称
		int nameMaxLength = 23;// 最大树形选择框宽度（汉字个数）
		if (list != null && list.size() > 0) {// 有数据
			long count = list.size();
			String dm, mc, py, wb, ztbs, bz,icon;
			String prevDm = "";
			String treeID = "";
			String treeParentID = "";
			int isLeaf = 0;
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			long countAdd = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer();// list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			int maxLengthInt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCt().length() > maxLengthInt) {
					maxLengthInt = list.get(i).getCt().length();
				}
			}
			if (maxLengthInt > nameMaxLength) {
				maxLengthInt = nameMaxLength;
			}
			int listWidth = maxLengthInt * 12;
			listWidth += 8 * 12 + 30; // 多加8个汉字
			sbJs.append("this.listWidth = " + listWidth + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			StringBuffer sbJsTree = new StringBuffer();// list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			for (int i = 0; i < list.size(); i++) {
				countAdd++;
				StringBuffer sbJsOption = new StringBuffer();// list文件中的option
				ztbs = list.get(i).getXt_zxbz();
				if (StringUtil.isEmpty(ztbs)) {
					ztbs = "0";
				}
				dm = StringUtil.nullToStr(list.get(i).getDm());
				mc = StringUtil.nullToStr(list.get(i).getCt());
				py = StringUtil.nullToStr(list.get(i).getPy());
				wb = StringUtil.nullToStr(list.get(i).getWb());
				dm = dm.replaceAll("\n", "");
				mc = mc.replaceAll("\n", "");
				py = py.replaceAll("\n", "");
				wb = wb.replaceAll("\n", "");
				bz = StringUtil.nullToStr(list.get(i).getBz());
				icon=bz.split(";")[2];
				if ("UnKnown".equals(icon)){
					icon="";
				}
				
				sbJsOption.append("[" + ztbs + ",'" + dm + "','");
				sbJsOption.append(mc + "','" + py + "','" + wb + "',");
				treeParentID = "";
				if ("1".equals(list.get(i).getTreeLevel())) {// 第一级节点
					prevDm = "";
					treeID = dm;
					treeParentID = "";
					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				} else {
					prevDm = StringUtil.nullToStr(list.get(i).getParentDm());
					String elementPrev = hashTable.get(prevDm);
					if (elementPrev != null) {
						treeID = elementPrev + "_" + dm;
						treeParentID = elementPrev;
					} else {
						prevDm = "";
						treeID = dm;
						treeParentID = "";
					}
					if (list.get(i).getIsTreeLeaf().intValue() == 0) {
						isLeaf = 0;
						hashTable.put(dm, treeID);
					} else {
						isLeaf = 1;
					}
				}
				if ("".equals(treeParentID)) {
					sbJsOption.append(isLeaf + ",'RO'");
				} else {
					sbJsOption.append(isLeaf + ",'RO_" + treeParentID + "'");
				}
				sbJsOption.append(",'" + bz + "']");
				if (countAdd == count) {
					sbJsOption.append(StringUtil.enterNewline);
				} else {
					sbJsOption.append("," + StringUtil.enterNewline);
				}

				sbJs.append(sbJsOption.toString());

				if ("0".equals(ztbs)) {
					if ("".equals(prevDm)) {
						sbJsTree.append("data['RO_" + dm + "']='text:" + mc
								+ ";';" + StringUtil.enterNewline);
//						sbJsTree.append("data['RO_" + dm + "']='text:" + mc
//								+ ";icon:" + icon+ ";';"+StringUtil.enterNewline);

					} else {
//						sbJsTree.append("data['" + prevDm + "_" + dm
//								+ "']='text:" + mc + ";';"+StringUtil.enterNewline);
						sbJsTree.append("data['" + prevDm + "_" + dm
								+ "']='text:" + mc 	+ ";icon:" + icon+ ";';"
								+ StringUtil.enterNewline);
					}
				}
			}
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		} else {
			long count = 0;
			String tableNameUpper = zdbh.toUpperCase();
			String tableNameLower = zdbh.toLowerCase();

			StringBuffer sbJs = new StringBuffer(); // list文件
			sbJs.append("function " + tableNameLower + "() {"
					+ StringUtil.enterNewline);
			sbJs.append("this.listName = '" + treeName + "';"
					+ StringUtil.enterNewline);
			sbJs.append("this.realSize = " + count + ";"
					+ StringUtil.enterNewline);
			sbJs.append("this.dictArray = new Array(" + StringUtil.enterNewline);
			sbJs.append(");" + StringUtil.enterNewline);
			sbJs.append("}" + StringUtil.enterNewline);
			sbJs.append("var " + tableNameUpper + " = new " + tableNameLower
					+ "();" + StringUtil.enterNewline);

			StringBuffer sbJsTree = new StringBuffer(); // list_tree文件
			sbJsTree.append("var data = {};" + StringUtil.enterNewline);

			return sbJs.toString() + sbJsTree.toString() + "■"
					+ sbJsTree.toString();
		}
	}
	
	/**
	 * 获得勤务排班班次
	 * @param dwdm 单位代码
	 * @return List<SysDict>
	 */
	public List<SysDict> getQwglBcDict(String dwdm){
		StringBuilder sb = new StringBuilder();
		sb.append("select bcid dm,bcname ct from t_qwgl_pzgl_bc where orgid in (");
		sb.append("select zzjgdm from t_zzjg connect by  zzjgdm =  prior ssjgdm start with zzjgdm = '");
		sb.append(dwdm).append("') order by orgid asc,bcid asc");
		return sysDictDao.findDictForCustomize(sb.toString());
	}
	
	/**
	 * 获得表字段的字典对象
	 * @param table 表
	 * @return List<SysDict>
	 */
	public List<SysDict> getTableColumnSysDict(String table){
		return sysDictDao.getTableColumnSysDict(table);
	}
	
	/**
	 * 智能交管用户下所有表的字典
	 * @return List<SysDict>
	 */
	public List<SysDict> getTableNameFromOwner(){
		return sysDictDao.getTableNameFromOwner();
	}
	
	/**
	 * 智能交管用户下所有表的字典
	 * @return List<SysDict>
	 */
	public List<SysDict> getViewNameFromOwner(){
		return sysDictDao.getViewNameFromOwner();
	}
	
	/**
	 * 检查字典查询sql语句合法性
	 * @param sql  sql语句
	 * @return ResponseEntity<String>
	 */
	public void checkSql(String sql){
		sysDictDao.checkSql(sql);
	}
	/**
	 * 
	 * @param zdbh
	 * @return
	 */
//	public List<SysDict> getXzmc(String zdbh,User user) {
//		return sysDictDao.getXzmc(zdbh,user);
//	}
	/**
	 * 
	 * @return
	 */
//	public  List<SysDict> getBjlx() {
//		return sysDictDao.getBjlx();
//	}
}