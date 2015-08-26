/**********************************************************************   
 * <p>文件名：DictTree_BD_D_MDWLXDM.java </p>
 * <p>文件描述 复合党委类型代码
 * @project_name：sydw
 * @author yu_guangli@founder.com
 * @date 2015-06-6
 * @history
 * @department：研发部
 *
*/
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

public class DictTree_BD_D_MDWLXDM extends DictTreeCreator {


	public DictTree_BD_D_MDWLXDM() {
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
				String bz1 = dictList.get(i1).getBz();
				if (dm1.length()==2) { // 第1级判断条件
					TreeNode treeNode1 = new TreeNode();
					mc = dictList.get(i1).getCt();
					xt_zxbz = StringUtils.nullToStr(dictList.get(i1).getXt_zxbz());
					if ("1".equals(xt_zxbz)) {
						mc += "（已注销）";
					}
					py = dictList.get(i1).getPy();
					treeNode1.setId(dm1+"_"+bz1);
					treeNode1.setText(mc);
					treeNode1.setPy(bz1);
					treeNode1.setIconCls("icon-treeroot1");
					List<TreeNode> nodeList2 = new ArrayList<TreeNode>();
					for (int i2 = 0; i2 < dictList.size(); i2++) {
						String dm2 = dictList.get(i2).getDm();
						dm2 = StringUtils.nullToStr(dm2);
						String bz2 = dictList.get(i2).getBz();
						if (dm2.endsWith("0000")&&dm1.equals(bz2)) { // 第2级判断条件
							TreeNode treeNode2 = new TreeNode();
							mc = dictList.get(i2).getCt();
							xt_zxbz = StringUtils.nullToStr(dictList.get(i2).getXt_zxbz());
							if ("1".equals(xt_zxbz)) {
								mc += "（已注销）";
							}
							py = dictList.get(i2).getPy();
							treeNode2.setId(dm2+"_"+bz2);
							treeNode2.setText(mc);
							treeNode2.setPy(bz2);
							// 获取第2级结点开始
							List<TreeNode> nodeList3 = new ArrayList<TreeNode>();
							String dm1Matching = dm2.substring(0, 2); // 下一级为前2位相同
							for (int i3 = 0; i3 < dictList.size(); i3++) {
								String dm3 = dictList.get(i3).getDm();
								dm3 = StringUtils.nullToStr(dm3);
								String bz3 = dictList.get(i3).getBz();
								if (!dm3.equals(dm2) && dm3.startsWith(dm1Matching)&& dm3.endsWith("00")&&dm1.equals(bz3)) { // 第2级判断条件
									TreeNode treeNode3 = new TreeNode();
									mc = dictList.get(i3).getCt();
									xt_zxbz = StringUtils.nullToStr(dictList.get(i3).getXt_zxbz());
									if ("1".equals(xt_zxbz)) {
										mc += "（已注销）";
									}
									py = dictList.get(i3).getPy();
									treeNode3.setId(dm3+"_"+bz3);
									treeNode3.setText(mc);
									treeNode3.setPy(bz3);
									// 获取第3级结点开始
									List<TreeNode> nodeList4 = new ArrayList<TreeNode>();
									String dm2Matching = dm3.substring(0, 4); // 下一级为前4位相同
									for (int i4 = 0; i4 < dictList.size(); i4++) {
										String dm4 = dictList.get(i4).getDm();
										dm4 = StringUtils.nullToStr(dm4);
										String bz4 = dictList.get(i4).getBz();
										if (!dm4.equals(dm3)&& dm4.startsWith(dm2Matching)&&dm1.equals(bz4)) { // 第3级判断条件
											TreeNode treeNode4 = new TreeNode();
											mc = dictList.get(i4).getCt();
											xt_zxbz = StringUtils.nullToStr(dictList.get(i4).getXt_zxbz());
											if ("1".equals(xt_zxbz)) {
												mc += "（已注销）";
											}
											py = dictList.get(i4).getPy();
											treeNode4.setId(dm4+"_"+bz4);
											treeNode4.setText(mc);
											treeNode4.setPy(bz4);
											nodeList4.add(treeNode4);
										}
									}
									if (nodeList4.size() > 0) {
										treeNode3.setState("closed");
										treeNode3.setChildren(nodeList4);
									}
									// 获取第3级结点结束
									nodeList3.add(treeNode3);
								}
							}
							if (nodeList3.size() > 0) {
								treeNode2.setState("closed");
								treeNode2.setChildren(nodeList3);
							}
							// 获取第2级结点结束
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
			Writer fileWriter = new OutputStreamWriter(new FileOutputStream(JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter.write(TreeDataBuilder.getTreeData(nodeList1));
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
		}
	}

}
