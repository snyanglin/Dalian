package com.founder.framework.dictionary.service;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.bean.SysDict;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.TreeDataBuilder;
import com.founder.framework.utils.TreeNode;

public class DictOther_GB_D_XZQHDM extends DictOtherCreator {

	private String treeName = "行政区划"; // 字典名称
	private String provincialCode = ""; // 省代码（如：510000）
	private String localProvincialCode = ""; // 本省代码（如：51）
	private String localMunicipalCode = ""; // 本地区（市）代码（如：5101）
	private String systemXzqh = SystemConfig.getString("systemXzqh"); // 系统参数配置的行政区划

	public DictOther_GB_D_XZQHDM() {
		if (systemXzqh.length() == 6) {
			provincialCode = systemXzqh.substring(0, 2) + "0000";
			localProvincialCode = systemXzqh.substring(0, 2);
			localMunicipalCode = systemXzqh.substring(0, 4);
		}
	}

	public void createOtherJS(String zdbh, String zdbhMc) throws Exception {
		String JSPath = SystemConfig.getString("webRootPath") + "/common/dict/";
		String tableNameUpper = zdbh.toUpperCase();
		String querySql = "select DM,CT,PY,XT_ZXBZ,decode(DM,'"
				+ this.provincialCode
				+ "','1','2') as PROVINCIAL ,decode(substr(DM,1,2),'"
				+ this.localProvincialCode
				+ "','1','2') as LOCALPROVINCIAL,decode(substr(DM,1,4),'"
				+ this.localMunicipalCode
				+ "','1','2') as LOCALMUNICIPAL from SYS_DICT2 where ZDBH='"
				+ zdbh
				+ "' order by XT_ZXBZ,PROVINCIAL,LOCALMUNICIPAL,LOCALPROVINCIAL,DM";
		List<SysDict> dictList = super.getSysDictDao().queryDictForCustomize(
				querySql);
		if (dictList != null && dictList.size() > 0) { // 有数据
			String dm, mc, py, xt_zxbz;

			StringBuffer sb = new StringBuffer();
			sb.append("[" + StringUtils.enterNewline);
			long countAdd = 0;
			long count = dictList.size();
			for (int i = 0; i < dictList.size(); i++) {
				SysDict entity = (SysDict) dictList.get(i);
				countAdd++;
				dm = entity.getDm();
				mc = entity.getCt();
				py = entity.getPy();
				xt_zxbz = entity.getXt_zxbz();
				if ("1".equals(xt_zxbz)) {
					mc += "（已注销）";
				}
				String optionString = "\"id\":\"" + dm + "\",\"text\":\"" + mc
						+ "\",\"py\":\"" + py + "\"";
				sb.append("{" + optionString + "}");
				if (countAdd < count) {
					sb.append(",");
				}
				sb.append(StringUtils.enterNewline);
			}
			sb.append("]" + StringUtils.enterNewline);
			Writer fileWriterList1 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper + "LIST.js"),
					"UTF8");
			fileWriterList1.write(sb.toString());
			fileWriterList1.flush();
			fileWriterList1.close();
			System.out.println("文件 ：" + tableNameUpper + "LIST.js 创建成功！");

			sb = new StringBuffer();
			sb.append("[" + StringUtils.enterNewline);
			countAdd = 0;
			count = dictList.size();
			boolean firstOption = true;
			for (int i = 0; i < dictList.size(); i++) {
				SysDict entity = (SysDict) dictList.get(i);
				countAdd++;
				dm = entity.getDm();
				if (dm.indexOf(localProvincialCode) == 0) {
					mc = entity.getCt();
					py = entity.getPy();
					xt_zxbz = entity.getXt_zxbz();
					if ("1".equals(xt_zxbz)) {
						mc += "（已注销）";
					}
					if (!firstOption) {
						sb.append(",");
						sb.append(StringUtils.enterNewline);
					} else {
						firstOption = false;
					}
					String optionString = "\"id\":\"" + dm + "\",\"text\":\""
							+ mc + "\",\"py\":\"" + py + "\"";
					sb.append("{" + optionString + "}");
				}
			}
			sb.append(StringUtils.enterNewline);
			sb.append("]" + StringUtils.enterNewline);
			Writer fileWriterList2 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper
							+ "LIST_PROVINCE.js"), "UTF8");
			fileWriterList2.write(sb.toString());
			fileWriterList2.flush();
			fileWriterList2.close();
			System.out.println("文件 ：" + tableNameUpper
					+ "LIST_PROVINCE.js 创建成功！");

			sb = new StringBuffer();
			sb.append("[" + StringUtils.enterNewline);
			countAdd = 0;
			count = dictList.size();
			firstOption = true;
			for (int i = 0; i < dictList.size(); i++) {
				SysDict entity = (SysDict) dictList.get(i);
				countAdd++;
				dm = entity.getDm();
				if ((provincialCode).equals(dm)
						|| dm.indexOf(localMunicipalCode) == 0) {
					mc = entity.getCt();
					py = entity.getPy();
					xt_zxbz = entity.getXt_zxbz();
					if ("1".equals(xt_zxbz)) {
						mc += "（已注销）";
					}
					if (!firstOption) {
						sb.append(",");
						sb.append(StringUtils.enterNewline);
					} else {
						firstOption = false;
					}
					String optionString = "\"id\":\"" + dm + "\",\"text\":\""
							+ mc + "\",\"py\":\"" + py + "\"";
					sb.append("{" + optionString + "}");
				}
			}
			sb.append(StringUtils.enterNewline);
			sb.append("]" + StringUtils.enterNewline);
			Writer fileWriterList3 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper
							+ "LIST_MUNICIPAL.js"), "UTF8");
			fileWriterList3.write(sb.toString());
			fileWriterList3.flush();
			fileWriterList3.close();
			System.out.println("文件 ：" + tableNameUpper
					+ "LIST_MUNICIPAL.js 创建成功！");

			List<TreeNode> nodeList1 = new ArrayList<TreeNode>();
			for (int i1 = 0; i1 < dictList.size(); i1++) {
				String dm1 = dictList.get(i1).getDm();
				dm1 = StringUtils.nullToStr(dm1);
				if (dm1.endsWith("0000")) { // 第1级判断条件
					TreeNode treeNode1 = new TreeNode();
					mc = dictList.get(i1).getCt();
					xt_zxbz = StringUtils.nullToStr(dictList.get(i1)
							.getXt_zxbz());
					if ("1".equals(xt_zxbz)) {
						mc += "（已注销）";
					}
					py = dictList.get(i1).getPy();
					treeNode1.setId(dm1);
					treeNode1.setText(mc);
					treeNode1.setPy(py);
					// 获取第2级结点开始
					List<TreeNode> nodeList2 = new ArrayList<TreeNode>();
					String dm1Matching = dm1.substring(0, 2); // 下一级为前2位相同
					for (int i2 = 0; i2 < dictList.size(); i2++) {
						String dm2 = dictList.get(i2).getDm();
						dm2 = StringUtils.nullToStr(dm2);
						if (!dm2.equals(dm1) && dm2.startsWith(dm1Matching)
								&& dm2.endsWith("00")) { // 第2级判断条件
							TreeNode treeNode2 = new TreeNode();
							mc = dictList.get(i2).getCt();
							xt_zxbz = StringUtils.nullToStr(dictList.get(i2)
									.getXt_zxbz());
							if ("1".equals(xt_zxbz)) {
								mc += "（已注销）";
							}
							py = dictList.get(i2).getPy();
							treeNode2.setId(dm2);
							treeNode2.setText(mc);
							treeNode2.setPy(py);
							// 获取第3级结点开始
							List<TreeNode> nodeList3 = new ArrayList<TreeNode>();
							String dm2Matching = dm2.substring(0, 4); // 下一级为前4位相同
							for (int i3 = 0; i3 < dictList.size(); i3++) {
								String dm3 = dictList.get(i3).getDm();
								dm3 = StringUtils.nullToStr(dm3);
								if (!dm3.equals(dm2)
										&& dm3.startsWith(dm2Matching)) { // 第3级判断条件
									TreeNode treeNode3 = new TreeNode();
									mc = dictList.get(i3).getCt();
									xt_zxbz = StringUtils.nullToStr(dictList
											.get(i3).getXt_zxbz());
									if ("1".equals(xt_zxbz)) {
										mc += "（已注销）";
									}
									py = dictList.get(i3).getPy();
									treeNode3.setId(dm3);
									treeNode3.setText(mc);
									treeNode3.setPy(py);
									nodeList3.add(treeNode3);
								}
							}
							if (nodeList3.size() > 0) {
								treeNode2.setState("closed");
								treeNode2.setChildren(nodeList3);
							}
							// 获取第3级结点结束
							nodeList2.add(treeNode2);
						}
					}
					if (nodeList2.size() > 0) {
						treeNode1.setState("closed");
						treeNode1.setChildren(nodeList2);
					}
					// 获取第2级结点结束
					nodeList1.add(treeNode1);
				}
			}
			Writer fileWriter1 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter1.write("[{\"id\":\"ROOT\",\"text\":\"" + zdbhMc
					+ "\",\"iconCls\":\"icon-treeroot1\",\"children\":"
					+ StringUtils.enterNewline + StringUtils.enterNewline);
			fileWriter1.write(TreeDataBuilder.getTreeData(nodeList1));
			fileWriter1.write(StringUtils.enterNewline + "}]");
			fileWriter1.flush();
			fileWriter1.close();
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");

			// 以下是创建本省与本市的行政区划JS文件
			for (int i = nodeList1.size() - 1; i >= 1; i--) {
				nodeList1.remove(i);
			}
			nodeList1.get(0).setState("");
			Writer fileWriter2 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + "_PROVINCE.js"), "UTF8");
			fileWriter2.write("[{\"id\":\"ROOT\",\"text\":\"" + zdbhMc
					+ "\",\"iconCls\":\"icon-treeroot1\",\"children\":"
					+ StringUtils.enterNewline + StringUtils.enterNewline);
			fileWriter2.write(TreeDataBuilder.getTreeData(nodeList1));
			fileWriter2.write(StringUtils.enterNewline + "}]");
			fileWriter2.flush();
			fileWriter2.close();
			System.out.println("文件 ：" + tableNameUpper + "_PROVINCE.js 创建成功！");

			List<TreeNode> tempList = nodeList1.get(0).getChildren();
			if (tempList != null && tempList.size() > 0) {
				for (int i = tempList.size() - 1; i >= 1; i--) {
					tempList.remove(i);
				}
				tempList.get(0).setState("");
			}
			Writer fileWriter3 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + "_MUNICIPAL.js"), "UTF8");
			fileWriter3.write("[{\"id\":\"ROOT\",\"text\":\"" + zdbhMc
					+ "\",\"iconCls\":\"icon-treeroot1\",\"children\":"
					+ StringUtils.enterNewline + StringUtils.enterNewline);
			fileWriter3.write(TreeDataBuilder.getTreeData(nodeList1));
			fileWriter3.write(StringUtils.enterNewline + "}]");
			fileWriter3.flush();
			fileWriter3.close();
			System.out.println("文件 ：" + tableNameUpper + "_MUNICIPAL.js 创建成功！");

		} else {
			Writer fileWriterList1 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper + "LIST.js"),
					"UTF8");
			fileWriterList1.write("[]");
			fileWriterList1.flush();
			fileWriterList1.close();
			System.out.println("字典： " + treeName + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + "LIST.js 创建成功！");

			Writer fileWriterList2 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper
							+ "LIST_PROVINCE.js"), "UTF8");
			fileWriterList2.write("[]");
			fileWriterList2.flush();
			fileWriterList2.close();
			System.out.println("字典： " + treeName + "（本省）  无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper
					+ "LIST_PROVINCE.js 创建成功！");

			Writer fileWriterList3 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper
							+ "LIST_MUNICIPAL.js"), "UTF8");
			fileWriterList3.write("[]");
			fileWriterList3.flush();
			fileWriterList3.close();
			System.out.println("字典： " + treeName + "（本市） 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper
					+ "LIST_MUNICIPAL.js 创建成功！");

			Writer fileWriter1 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter1.write("[]");
			fileWriter1.flush();
			fileWriter1.close();
			System.out.println("字典： " + treeName + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");

			Writer fileWriter2 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + "_PROVINCE.js"), "UTF8");
			fileWriter2.write("[]");
			fileWriter2.flush();
			fileWriter2.close();
			System.out.println("字典： " + treeName + "（本省） 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + "_PROVINCE.js 创建成功！");

			Writer fileWriter3 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + "_MUNICIPAL.js"), "UTF8");
			fileWriter3.write("[]");
			fileWriter3.flush();
			fileWriter3.close();
			System.out.println("字典： " + treeName + "（本市） 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + "_MUNICIPAL.js 创建成功！");

		}
	}

	public String getDictCt(String zdbh, String dm) throws Exception {
		return super.getSysDictDao().getDictCt(zdbh, dm);
	}

	public List<SysDict> getDictList(String zdbh) {
		return super.getSysDictDao().queryListByZdbh(zdbh);
	}

	public Map<String, String> getDictMap(String zdbh) {
		Map<String, String> returnMap = new HashMap<String, String>();
		List<SysDict> list = super.getSysDictDao().queryListByZdbh(zdbh);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SysDict entity = list.get(i);
				String key = StringUtils.nullToStr(entity.getDm());
				String value = StringUtils.nullToStr(entity.getCt());
				returnMap.put(key, value);
			}
		}
		return returnMap;
	}

}
