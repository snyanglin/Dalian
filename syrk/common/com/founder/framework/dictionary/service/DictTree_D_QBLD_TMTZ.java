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

public class DictTree_D_QBLD_TMTZ extends DictTreeCreator {

	private String treeName = "重要的科研单位";

	public DictTree_D_QBLD_TMTZ() {
	}

	public boolean isAutoCreateJS() {
		return false;
	}

	public void createTreeJS(String zdbh, String zdbhMc) throws Exception {
		List<SysDict> dictList = super.getSysDictDao().queryListByZdbh(zdbh);
		String JSPath = SystemConfig.getString("webRootPath") + "/common/dict/";
		if (dictList != null && dictList.size() > 0) { // 有数据
			String mc, py, xt_zxbz;
			List<TreeNode> nodeList1 = new ArrayList<TreeNode>();
			for (int i1 = 0; i1 < dictList.size(); i1++) {
				String dm1 = dictList.get(i1).getDm();
				dm1 = StringUtils.nullToStr(dm1);
				if (dm1.endsWith("01/59")) { // 第1级判断条件
					TreeNode treeNode1 = new TreeNode();
					mc = dictList.get(i1).getCt();
					xt_zxbz = StringUtils.nullToStr(dictList.get(i1)
							.getXt_zxbz());
					if ("1".equals(xt_zxbz)) {
						mc += "（已注销）";
					}
				
					treeNode1.setId(dm1);
					treeNode1.setText(mc);
					treeNode1.setPy(dictList.get(i1).getBz());

					// 获取第2级结点开始
					List<TreeNode> nodeList2 = new ArrayList<TreeNode>();
					String dm1Matching = dm1.substring(0, 2); // 下一级为前2位相同
					for (int i2 = 0; i2 < dictList.size(); i2++) {
						String dm2 = dictList.get(i2).getDm();
						dm2 = StringUtils.nullToStr(dm2);
						if (dm2.endsWith("00")) { // 第2级判断条件
							TreeNode treeNode2 = new TreeNode();
							mc = dictList.get(i2).getCt();
							xt_zxbz = StringUtils.nullToStr(dictList.get(i2)
									.getXt_zxbz());
							if ("1".equals(xt_zxbz)) {
								mc += "（已注销）";
							}
							
							treeNode2.setId(dm2);
							treeNode2.setText(mc);
							treeNode2.setPy(dictList.get(i2).getBz());
						
							// 获取第3级结点开始
							List<TreeNode> nodeList3 = new ArrayList<TreeNode>();
							String dm2Matching = dm2.substring(0, 2); // 下一级为前4位相同
							for (int i3 = 0; i3 < dictList.size(); i3++) {
								String dm3 = dictList.get(i3).getDm();
								dm3 = StringUtils.nullToStr(dm3);
								if (!dm3.equals("01/59")&&!dm3.equals(dm2)
										&& dm3.startsWith(dm2Matching)) { // 第3级判断条件
									TreeNode treeNode3 = new TreeNode();
									mc = dictList.get(i3).getCt();
									xt_zxbz = StringUtils.nullToStr(dictList
											.get(i3).getXt_zxbz());
									if ("1".equals(xt_zxbz)) {
										mc += "（已注销）";
									}
				;
									treeNode3.setId(dm3);
									treeNode3.setText(mc);
									treeNode3.setPy(dictList.get(i3).getBz());
						
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
			String tableNameUpper = zdbh.toUpperCase();
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write("[{\"id\":\"ROOT\",\"py\":\"top\",\"text\":\"" + zdbhMc
					+ "\",\"iconCls\":\"icon-treeroot1\",\"children\":"
					+ StringUtils.enterNewline + StringUtils.enterNewline);
			fileWriter.write(TreeDataBuilder.getTreeData(nodeList1));
			fileWriter.write(StringUtils.enterNewline + "}]");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		} else {
			String tableNameUpper = zdbh.toUpperCase();
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

