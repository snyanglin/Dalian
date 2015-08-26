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

public class DictTree_D_BZ_GJDQ extends DictTreeCreator {

	private String treeName = "国家和地区";

	public DictTree_D_BZ_GJDQ() {
	}

	public void createTreeJS(String zdbh, String zdbhMc) throws Exception {
		List<SysDict> dictList = super.getSysDictDao().queryListByZdbh(zdbh);
		String JSPath = SystemConfig.getString("webRootPath") + "/common/dict/";
		String tableNameUpper = zdbh.toUpperCase();
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

			List<TreeNode> nodeList1 = new ArrayList<TreeNode>();
			for (int i1 = 0; i1 < dictList.size(); i1++) {
				String dm1 = dictList.get(i1).getDm();
				dm1 = StringUtils.nullToStr(dm1);
				TreeNode treeNode1 = new TreeNode();
				mc = dictList.get(i1).getCt();
				xt_zxbz = StringUtils.nullToStr(dictList.get(i1).getXt_zxbz());
				if ("1".equals(xt_zxbz)) {
					mc += "（已注销）";
				}
				py = dictList.get(i1).getPy();
				treeNode1.setId(dm1);
				treeNode1.setText(mc);
				treeNode1.setPy(py);
				nodeList1.add(treeNode1);
			}
			Writer fileWriter2 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter2.write("[{\"id\":\"ROOT\",\"text\":\"" + zdbhMc
					+ "\",\"iconCls\":\"icon-treeroot1\",\"children\":"
					+ StringUtils.enterNewline + StringUtils.enterNewline);
			fileWriter2.write(TreeDataBuilder.getTreeData(nodeList1));
			fileWriter2.write(StringUtils.enterNewline + "}]");
			fileWriter2.flush();
			fileWriter2.close();
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		} else {
			Writer fileWriterList1 = new OutputStreamWriter(
					new FileOutputStream(JSPath + tableNameUpper + "LIST.js"),
					"UTF8");
			fileWriterList1.write("[]");
			fileWriterList1.flush();
			fileWriterList1.close();
			System.out.println("字典： " + treeName + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + "LIST.js 创建成功！");

			Writer fileWriter2 = new OutputStreamWriter(new FileOutputStream(
					JSPath + tableNameUpper + ".js"), "UTF8");
			fileWriter2.write("[]");
			fileWriter2.flush();
			fileWriter2.close();
			System.out.println("字典： " + treeName + " 无数据， 创建空文件成功！");
			System.out.println("文件 ：" + tableNameUpper + ".js 创建成功！");
		}
	}

}
