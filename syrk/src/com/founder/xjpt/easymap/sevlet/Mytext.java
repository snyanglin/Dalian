package com.founder.xjpt.easymap.sevlet;


import java.util.ArrayList;
import java.util.List;
import com.founder.xjpt.easymap.sevlet.fzQueryServlet;

import com.founder.xjpt.easymap.Dao.SsyjSqlJava;
import com.founder.xjpt.easymap.bean.SsyjBean;


public class Mytext {
	
	
	public static String getZmonth(String year,String moth){

		String Zmonth;

  	if(Integer.parseInt(moth)-1==0)
  	{

  		Zmonth=year+"-01-25";
  	}else{

  		Zmonth=year+"-"+moth+"-25";
  	}

    
		
		return Zmonth;
	}
	public static String getQmonth(String year,String moth){
	String Qmonth;

	if(Integer.parseInt(moth)-1==0)
  	{
  		Qmonth=	String.valueOf(Integer.parseInt(year)-1)+"-12-26";
  		
  	}else{
  		Qmonth=year+"-"+String.valueOf(Integer.parseInt(moth)-1)+"-26";
  		
  	}
  	 

		
		return Qmonth;
	}
	
	//阀值
	
	
	

	public static void main(String[] args) {

    String zzjg = "210212000000";//旅顺口分局
    String year = "2013";
    String type="2";
    List arrfz=new ArrayList();
    for(int i=1;i<=12;i++){
    String Qweak=getQmonth(year,String.valueOf(i));
    String Zweak=getZmonth(year,String.valueOf(i));
  //  String fz=fzQueryServlet.getFzFun("2",zzjg,Qweak,Zweak);
   // arrfz.add(fz);
    }
    String aaa="";
    List<SsyjBean>  list=SsyjSqlJava.getJKWeakSql(zzjg,year,type);
    for (int w = 0; w < list.size(); w++) {
    	System.out.println("+++"+arrfz.get(w).toString());
    	String ysz=fzQueryServlet.returnColor(list.get(w).getSumu(),arrfz.get(w).toString());
    	aaa+=ysz;
    	
    }
    System.out.println(aaa);
	}
}
