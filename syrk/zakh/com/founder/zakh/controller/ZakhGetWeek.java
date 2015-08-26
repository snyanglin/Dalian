/**********************************************************************   
 * <p>文件名：ZakhGetWeek.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author lang_siyu@founder.com.cn 
 * @date 2015-4-21 上午8:49:41 
 * @history
 * @department：东北区研发
 *
*/
package com.founder.zakh.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.ComboBox;
import com.founder.zakh.tools.Dateutil;
/******************************************************************************
 * @Package:      [com.founder.zakh.controller.ZakhGetWeek.java]  
 * @ClassName:    [ZakhGetWeek]   
 * @Description:  [治安考核-获取当年周数]   
 * @Author:       [lang_siyu@founder.com.cn]  
 * @CreateDate:   [2015-4-21 上午8:49:41]   
 * @UpdateUser:   [langsiyu(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-21 上午8:49:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping("/zakhgetweek")
public class ZakhGetWeek extends BaseController {
	/**
	 * @Title: zakhweekList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zakhWeekJson", method = RequestMethod.GET)
	public @ResponseBody List<ComboBox> zakhWeekJson(int year) {
		List<ComboBox> res = new ArrayList<ComboBox>();
	    Dateutil dt=new Dateutil();
	    Calendar cal=Calendar.getInstance();
	    int nowYear = cal.get(Calendar.YEAR);
	    int maxWeek =0;
	    if(nowYear==year){
		     maxWeek = dt.getWeekOfYear(new Date());
	    }else{
	    	maxWeek=dt.getMaxWeekNumOfYear(year);
	    }
	    int beforeWeek=maxWeek-1;
	  //  int a = dt.getMaxWeekNumOfYear(year);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    for(int i=1;i<=beforeWeek;i++){
	    	ComboBox box = new ComboBox();
	    	box.setId(String.valueOf(i));
	    	
			box.setText("第"+i+"周  "+formatter.format(dt.getFirstDayOfWeek(year,i)).substring(5,10)+"至"+formatter.format(dt.getLastDayOfWeek(year, i)).substring(5,10)+"");
			res.add(box);
	    }
		return res;
	}
	
	/**
	 * @Title: zakhYearJson
	 * @Description: TODO(取当前年份及前两年)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zakhYearJson", method = RequestMethod.GET)
	public @ResponseBody List<ComboBox> zakhYearJson() {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		
		List<ComboBox> res = new ArrayList<ComboBox>();
	    for(int i=year-2;i<=year;i++){
	    	ComboBox box = new ComboBox();
	    	box.setId(String.valueOf(i));
			box.setText(String.valueOf(i)+"年");
			res.add(box);
	    }
		return res;
	}
}
