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

public class DictTree_GB_D_XLDM extends DictTreeCreator {

	private String treeName = "学历代码";

	public DictTree_GB_D_XLDM() {
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
				if (dm1.endsWith("0")) { // 第1级判断条件
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
					String dm1Matching = dm1.substring(0, 1); // 下一级为前1位相同
					for (int i2 = 0; i2 < dictList.size(); i2++) {
						String dm2 = dictList.get(i2).getDm();
						dm2 = StringUtils.nullToStr(dm2);
						if (!dm2.equals(dm1) && dm2.startsWith(dm1Matching)) { // 第2级判断条件
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
			fileWriter.write("[{\"id\":\"ROOT\",\"text\":\"" + zdbhMc
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
