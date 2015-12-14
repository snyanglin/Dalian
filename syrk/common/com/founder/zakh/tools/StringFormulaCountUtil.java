/**********************************************************************   
 * <p>文件名：StringFormulaCountUtil.java </p>
 * <p>文件描述：计算字符串数学公式
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-21 上午9:27:59 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.tools;

/******************************************************************************
 * @Package:      [com.founder.zakh.tools.StringFormulaCountUtil.java]  
 * @ClassName:    [StringFormulaCountUtil]   
 * @Description:  [计算字符串数学公式]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-21 上午9:27:59]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-21 上午9:27:59，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class StringFormulaCountUtil {
	private static final String[] operators={"+","-","*","/","%"};
	//计算结果为带小数的数字
	public static String countStringFormulaForDouble(String formula){
		while(formula.indexOf("(")!=-1){
			int begin=formula.indexOf("(");
			int end=formula.indexOf(")");
			formula=formula.substring(0, begin)+countStringFormula(formula.substring(begin+1, end))+formula.substring(end+1, formula.length());
		}
		for(int i=0;i<operators.length;i++){
			int opeIndex=formula.indexOf(operators[i]);
			String[] subFormula=new String[2];
			int limit=1;
			if(opeIndex!=-1){
				subFormula[0]=formula.substring(0,opeIndex);
				subFormula[1]=formula.substring(opeIndex+1,formula.length());
				limit=2;
			}
			Double result=0d;
			if(limit>1){
				switch(i){
					case 0:
						result=Double.parseDouble(countStringFormula(subFormula[0]))+Double.parseDouble(countStringFormula(subFormula[1]));
						break;
					case 1:
						result=Double.parseDouble(countStringFormula(subFormula[0]))-Double.parseDouble(countStringFormula(subFormula[1]));
						break;
					case 2:
						result=Double.parseDouble(countStringFormula(subFormula[0]))*Double.parseDouble(countStringFormula(subFormula[1]));
						break;
					case 3:
						result=Double.parseDouble(countStringFormula(subFormula[0]))/Double.parseDouble(countStringFormula(subFormula[1]));
						break;
					case 4:
						result=Double.parseDouble(countStringFormula(subFormula[0]))%Double.parseDouble(countStringFormula(subFormula[1]));
						break;
				}
				return String.valueOf(result);
			}
			if(formula.matches("^[0-9.]+$")){
				return formula;
			}
		}
		return "no result";
	}
	
	//计算结果为整数
	public static String countStringFormula(String formula){
		return countStringFormulaForDouble(formula).split("\\.")[0];
	}
	
	public static void main(String[] args) {
		System.out.println(StringFormulaCountUtil.countStringFormula("5.0+3.0-4.0"));
	}
	
}
