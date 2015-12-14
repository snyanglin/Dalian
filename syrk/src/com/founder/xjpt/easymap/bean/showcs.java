package com.founder.xjpt.easymap.bean;

public class showcs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String zzjgdm="210295000000";
		 String zzjglx="";

			if("000000".equals(zzjgdm.substring(6))==true)
	      { 
		    if(zzjgdm=="210200000000"){
		    zzjglx ="11";
		    }else{
		     	zzjglx ="12";
		     	}
		  }else{
			zzjglx ="13";
		  }	
		  System.out.println("++++++++++"+zzjglx);

	}

}
