package com.founder.zdrygl.base.service.wf;

public enum LcgFlagEnum {
	 LG("列管", "01"),  
	 CG("撤管", "02"),
	 ZD("转递", "03"), 
	 ZL("转类", "04"),
	 QXJ("请销假","05"),
	 HSCG("核实撤管","06");
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
