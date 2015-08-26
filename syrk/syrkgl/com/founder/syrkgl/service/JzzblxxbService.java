package com.founder.syrkgl.service;


import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.Jzzblxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;

@TypeAnnotation("居住证办理")
public interface JzzblxxbService {
	/**
	 * 
	 * @Title: queryLdrk
	 * @Description: TODO(通过流动人口表主键查询对象)
	 * @param @return    设定文件
	 * @return Ldrkxxb    返回类型
	 * @throws
	 */
     public SyrkLdrkxxb queryLdrk(String id);
     
     /**
      * 
      * @Title: saveJzzblxx
      * @Description: TODO(保存居住证办理信息)
      * @param @param entity    设定文件
      * @return void    返回类型
      * @throws
      */
     public void saveJzzblxx(Jzzblxxb entity,SessionBean sessionBean);
     
     /**
      * 
      * @Title: jzzblxxb
      * @Description: TODO(居住证通过ID查询单条)
      * @param @param map
      * @param @return    设定文件
      * @return Jzzblxxb    返回类型
      * @throws
      */
     public List<Jzzblxxb>  jzzblxxb_query(Map<String,Object> map);
     
     /**
      * 
      * @Title: queryJcjNoPt
      * @Description: TODO(居住证办理列表查询)
      * @param @param page
      * @param @param entity
      * @param @return    设定文件
      * @return EasyUIPage    返回类型
      * @throws
      */
     public EasyUIPage queryJzzblList(EasyUIPage page, Jzzblxxb entity);
     /**
      * 
      * @Title: queryJzzblxxb
      * @Description: TODO(查询居住证办理信息单条)
      * @param @param id
      * @param @return    设定文件
      * @return Jzzblxxb    返回类型
      * @throws
      */
     public Jzzblxxb queryJzzblxxb(String  id);
     /**
      * 
      * @Title: updateJzzblxxb
      * @Description: TODO(修改居住证信息)
      * @param @param entity
      * @param @param sessionBean    设定文件
      * @return void    返回类型
      * @throws
      */
     public void updateJzzblxxb(Jzzblxxb entity,SessionBean sessionBean);
     
     /***
      * 
      * @Title: jzzbl_export
      * @Description: TODO(居住证带照片批量导出)
      * @param @param exportIds
      * @param @param response
      * @param @return    设定文件
      * @return boolean    返回类型
      * @throws
      */
     public File jzzbl_export(String exportIds, HttpServletResponse response,HttpServletRequest request,SessionBean sessionBean);
     
     /***
      * 
      * @Title: jzzView
      * @Description: TODO(保存打印时候的添加数据)
      * @author wuchunhui
      * @param @param id
      * @param @return    设定文件
      * @return Jzzblxxb    返回类型
      * @throws
      */
     public Jzzblxxb jzzView(String id,SessionBean sessionBean);
     
     /**
      * 
      * @Title: checkRyJzz
      * @Description: TODO(验证居住证重复申请逻辑)
      * @param @param ryid
      * @param @return    设定文件
      * @return Integer    返回类型
      * @throws
      */
     public Jzzblxxb checkRyJzz(String ryid);
     /***
      * 
      * @Title: queryIdsForPrint
      * @Description: TODO(根据打印需求取得所有ID)
      * @param @param entity
      * @param @return    设定文件
      * @return Jzzblxxb    返回类型
      * @throws
      */
     public List<Jzzblxxb> queryIdsForPrint(Jzzblxxb entity);
     
}
