package com.founder.framework.dictionary.service;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.bean.SysDict;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.TreeDataBuilder;
import com.founder.framework.utils.TreeNode;

public class DictTree_BD_D_ZDRYLBDM extends DictTreeCreator {

	private String treeName = "重点人员类别";

	public DictTree_BD_D_ZDRYLBDM() {
	}

	public boolean isAutoCreateJS() {
		return false;
	}

	public void createTreeJS(String zdbh, String zdbhMc) throws Exception {
		List<SysDict> dictList = super.getSysDictDao().queryListByZdbh(zdbh);
		
		String JSPath = SystemConfig.getString("webRootPath") + "/common/dict/";
		String tableNameUpper = zdbh.toUpperCase();

		if (dictList != null && dictList.size() > 0) { // 有数据
			String dm,mc, py, xt_zxbz;
			
			//================生成下拉列表开始============================
		    StringBuffer sb = new StringBuffer();
			sb.append("[" + StringUtils.enterNewline);
			int countAdd = 0;
			int count = dictList.size();
			boolean firstOption = true;
			for (int i = 0; i < dictList.size(); i++) {
				if (dictList.get(i).getDm().length() == 2) {
					SysDict entity = (SysDict) dictList.get(i);
					countAdd++;
					dm = entity.getDm();

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
					sb.append(StringUtils.enterNewline);
				}

			}
			sb.append("]" + StringUtils.enterNewline);

			Writer fileWriterList3 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper
							+ "LIST_MUNICIPAL.js"), "UTF8");
			fileWriterList3.write(sb.toString());
			fileWriterList3.flush();
			fileWriterList3.close();
			System.out.println("文件 ：" + tableNameUpper
					+ "LIST_MUNICIPAL.js 创建成功！");

			
			
			//================生成下拉列表结束============================
			
			List<TreeNode> nodeList1 = new ArrayList<TreeNode>();
			for (int i1 = 0; i1 < dictList.size(); i1++) {
				String dm1 = dictList.get(i1).getDm();
				dm1 = StringUtils.nullToStr(dm1);
				if (dm1.length() == 2) { // 第1级判断条件
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
								&& dm2.length() == 4) { // 第2级判断条件
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
										&& dm3.startsWith(dm2Matching)&& dm3.length() == 6) { // 第3级判断条件
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
									
									// 获取第4级结点开始
									List<TreeNode> nodeList4= new ArrayList<TreeNode>();
									String dm3Matching = dm3.substring(0, 6); // 下一级为前4位相同
									for (int i4 = 0; i4 < dictList.size(); i4++) {
										
										String dm4 = dictList.get(i4).getDm();
										dm4 = StringUtils.nullToStr(dm4);
										if (!dm4.equals(dm3)
												&& dm4.startsWith(dm3Matching)&& dm4.length() == 8) { // 第4级判断条件
											TreeNode treeNode4= new TreeNode();
											mc = dictList.get(i4).getCt();
											xt_zxbz = StringUtils.nullToStr(dictList
													.get(i4).getXt_zxbz());
											if ("1".equals(xt_zxbz)) {
												mc += "（已注销）";
											}
											py = dictList.get(i4).getPy();
											treeNode4.setId(dm4);
											treeNode4.setText(mc);
											treeNode4.setPy(py);
											nodeList4.add(treeNode4);
											if(nodeList4.size()>0){
												treeNode3.setState("closed");
												treeNode3.setChildren(nodeList4);
											}
											
											//nodeList3.add(treeNode3);
										}
									}
									
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
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write("[{\"id\":\"ROOT\",\"text\":\"" + zdbhMc
					+ "\",\"iconCls\":\"icon-treeroot1\",\"children\":"
					+ StringUtils.enterNewline + StringUtils.enterNewline);
			fileWriter.write(TreeDataBuilder.getTreeData(nodeList1));
			fileWriter.write(StringUtils.enterNewline + "}]");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");

			
		} else {
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write("[]");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("字典： " + treeName + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		}
	}

}
