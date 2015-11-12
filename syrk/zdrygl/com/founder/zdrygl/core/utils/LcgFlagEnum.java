package com.founder.zdrygl.core.utils;

public enum LcgFlagEnum {
	 LG("列管", "01"),  
	 CG("撤管", "02");
     private String name;
     private String value;

     private LcgFlagEnum(String name, String value) {
         this.name = name;
         this.value = value;
     }

     @Override
     public String toString() {
         return this.value + "_" + this.name;
     }
     public String getValue(){
    	 return this.value;
     }
}
