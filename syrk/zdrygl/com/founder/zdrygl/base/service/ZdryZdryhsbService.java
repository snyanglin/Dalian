
package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.MessageDict;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.service.JwzhMessageService;
import com.founder.framework.utils.*;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.RyRylxfsxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.dao.*;
import com.founder.zdrygl.base.model.*;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.base.vo.ZdryZdryzbVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.base.vo.ZdryZdryhsbVO;
import org.springframework.util.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdryhsb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate: 2015-12-15 04:46:24
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-15 04:46:24，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Service
@Transactional
public class ZdryZdryhsbService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ZdryZdryhsbDao zdryZdryhsbDao;
    @Resource
    private SysDictGlService sysDictGlService;
    @Resource
    private SyrkSyrkxxzbService syrkSyrkxxzbService;
    @Resource
    private RyRyjbxxbService ryRyjbxxbService;
    @Resource
    private ZdryZdryZbDao zdryZdryZbDao;
    @Resource
    private JwzhMessageService jwzhMessageService;
    @Autowired
    public ZdryAbstractFactory zdryFactory;

    @Resource(name = "zdryQueryService")
    private ZdryInfoQueryService zdryQueryService;
    @Autowired
    private ZdryConstant zdryConstant;
    @Autowired
    private JProcessDefinitionService processDefinitionService;
    @Autowired
    private ZdryRuleService zdryRuleService;

    /**
     * 新增<br>
     *
     * @param entity
     */

    public void save(ZdryZdryhsb entity, SessionBean sessionBean) {
        entity.setId(UUID.create());
        BaseService.setSaveProperties(entity, sessionBean);
        zdryZdryhsbDao.save(entity);
    }


    public void delete(ZdryZdryhsb entity, SessionBean sessionBean) {
        BaseService.setCrossoutProperties(entity, sessionBean);
        zdryZdryhsbDao.delete(entity);
    }

    /**
     * 更新<br>
     *
     * @param entity
     */
    @MethodAnnotation(value = "更新", type = MethodAnnotation.logType.update)

    public void update(ZdryZdryhsb entity, SessionBean sessionBean) {
        BaseService.setUpdateProperties(entity, sessionBean);
        zdryZdryhsbDao.update(entity);
    }

    /**
     * @param @param  id
     * @param @return 设定文件
     * @return ZdryZdryhsb 返回类型
     * @throws
     * @Title: queryById
     * @Description: TODO(根据ID查询单条记录)
     */

    public ZdryZdryhsb queryById(String id) {
        return zdryZdryhsbDao.queryById(id);
    }

    /**
     * 查询列表<br>
     *
     * @param page
     * @param entity
     * @return
     */

    public EasyUIPage queryList(EasyUIPage page, ZdryZdryhsbVO entity) {
        entity.setXt_zxbz("0");
        return zdryZdryhsbDao.queryList(page, entity);
    }


    public Map<String, String> getZdryGlLxByList(List<ZdryZdryzbVO> list, String syrkid) {
        HashMap returnMap = new HashMap();
        Object dictMap = new HashMap();

        try {
            dictMap = this.sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        String displayStr = "";
        String filterStr = "";
        String filterZdStr = "";
        String filterylgStr="";
        StringBuffer ylgStr=new StringBuffer();
        for (int i = 0; i < list.size(); ++i) {
            ZdryZdryzbVO zdryZdryzbVO =  list.get(i);
            if (zdryZdryzbVO.getZdrygllxdm().equals("01")) {
                filterStr = "01";
            }
            if (ylgStr.indexOf(zdryZdryzbVO.getZdrygllxdm())<0){
                ylgStr.append(zdryZdryzbVO.getZdrygllxdm()).append(",");
            }
            if (zdryZdryzbVO.getSyrkid().equals(syrkid)) {
                displayStr = displayStr +  ((Map) dictMap).get(zdryZdryzbVO.getZdrygllxdm());
                if (!StringUtils.isBlank(zdryZdryzbVO.getJgbmmc()) && "1".equals(zdryZdryzbVO.getSfsjsp())) {
                    displayStr = displayStr + "(" + zdryZdryzbVO.getJgbmmc() + ")";
                }

                if ("1".equals(zdryZdryzbVO.getGlzt())) {
                    displayStr = displayStr + "(列管中),";
                } else if ("3".equals(zdryZdryzbVO.getGlzt())) {
                    displayStr = displayStr + "(撤管中),";
                } else if ("5".equals(zdryZdryzbVO.getGlzt())) {
                    displayStr = displayStr + "(转递中),";
                } else {
                    displayStr = displayStr + ",";
                    if (StringUtils.isBlank(filterZdStr)) {
                        filterZdStr = zdryZdryzbVO.getZdrygllxdm();
                    } else {
                        filterZdStr = filterZdStr + "|" + zdryZdryzbVO.getZdrygllxdm();
                    }
                }

                if (StringUtils.isBlank(filterStr)) {
                    filterStr = zdryZdryzbVO.getZdrygllxdm();
                } else {
                    filterStr = filterStr + "|" + zdryZdryzbVO.getZdrygllxdm();
                }
            }
        }

        if (StringUtils.isBlank(filterZdStr)) {
            filterZdStr = "9999";
        }

        if (!StringUtils.isBlank(displayStr)) {
            displayStr = displayStr.substring(0, displayStr.length() - 1);
        }
        if (ylgStr.length()>0){
            filterylgStr=ylgStr.substring(0,ylgStr.length()-1);
        }
        returnMap.put("displayStr", displayStr);
        returnMap.put("filterStr", filterStr);
        returnMap.put("filterZdStr", filterZdStr);
        returnMap.put("filterylgStr", filterylgStr);
        try {
            returnMap.put("filterklgStr", zdryRuleService.getKcglx(filterylgStr));
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }


    public Map<String, String> saveLg(ZdryVO zdryVO, SessionBean sessionBean) throws BussinessException {
        if (StringUtils.isBlank(zdryVO)) {
            throw new BussinessException("zdryVO is not exist");
        }
        ZdryZb zdryZdryzb = zdryVO.getZdryZdryzb();
        if (StringUtils.isBlank(zdryZdryzb)) {
            throw new BussinessException("zdryVO.zdryZdyzb is not exist");
        }
        SyrkSyrkxxzb SyrkSyrkxxzb = this.syrkSyrkxxzbService.queryById(zdryZdryzb.getSyrkid());
        if (StringUtils.isBlank(SyrkSyrkxxzb)) {
            throw new BussinessException("zdryVO.zdryZdyzb.Syrkid matching Syrkzb is not exist");
        }
        RyRyjbxxb ryjbxxb = this.ryRyjbxxbService.queryById(SyrkSyrkxxzb.getRyid());
        if (StringUtils.isBlank(SyrkSyrkxxzb)) {
            throw new BussinessException("zdryVO.zdryZdyzb.ryid matching RyRyjbxxb is not exist");
        }
        try {
            BeanUtils.copyObjectSameProperties(ryjbxxb, zdryZdryzb);
            BeanUtils.copyObjectSameProperties(SyrkSyrkxxzb, zdryZdryzb);
        } catch (Exception var12) {
            var12.printStackTrace();
        }
        zdryZdryzb.setGlbm(sessionBean.getUserOrgCode());
        zdryZdryzb.setGxzrqdm(sessionBean.getUserOrgCode());
        String zdrygllxdm = zdryVO.getZdryZdryzb().getZdrygllxdm();// 重点人员类型
        ZdryService zdryService = zdryFactory.createZdryService(zdrygllxdm,zdryZdryzb,zdryVO.getZdrylbdx());
        ZOBean entity = new ZOBean(zdryZdryzb, zdryVO.getZdrylbdx());
        zdryService.lg(sessionBean, entity);
        zdryZdryzb.setGlzt("2");
        zdryZdryZbDao.update(zdryZdryzb);

        Map returnMap = saveLczywb(zdryZdryzb, sessionBean);
        return returnMap;
    }



    public Map<String, String> saveLczywb(ZdryZb zdryZdyzb, SessionBean sessionBean) throws BussinessException {
        HashMap returnMap = new HashMap();
        Map<String,Object> paraObj = new HashMap<>();
        paraObj.put("result", "lgSuccess");
        paraObj.put("zdryId", zdryZdyzb.getId());
        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("zdryName", zdryZdyzb.getXm());
        paraObj.put("zdryGllxdm", zdryZdyzb.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(zdryZdyzb.getZdrygllxdm()));
//        jwzhMessageService.sendMessage(MessageDict.ZDRYGL.LGSPJG,paraObj);
        returnMap.put("zdryZbId", zdryZdyzb.getId());
        return returnMap;
    }

    public void saveHsCg(ZdryZdryhsb zdryHsb,String sqyj,SessionBean sessionBean) {
        zdryHsb.setHszt("4");
        BaseService.setUpdateProperties(zdryHsb, sessionBean);
        zdryZdryhsbDao.update(zdryHsb);

        ZdryVO zdryVO=new ZdryVO();
        zdryVO.setXm(zdryHsb.getXm());
        zdryVO.setYwsqyy(StringUtils.isBlank(sqyj)?"重点人员核实撤管":sqyj);
        zdryVO.setZjhm(zdryHsb.getZjhm());
        zdryVO.setZdryHsbId(zdryHsb.getId());
        zdryVO.setCglxdm(zdryHsb.getZdrygllxdm());
        WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant,zdryQueryService);
        StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean,zdryVO,LcgFlagEnum.HSCG);
        spi.getVariables().put("sqrOrgCode",sessionBean.getUserOrgCode());

        if(spi != null && org.springframework.util.StringUtils.isEmpty(spi.getProcessKey())){
            throw new BussinessException("缺少流程启动参数！");
        }else{
            processDefinitionService.startProcessInstance(spi.getApplyUserId(),spi.getProcessKey(), spi.getBusinessKey(), spi.getVariables());
        }

//        Map<String,Object> paraObj = new HashMap<>();
//        paraObj.put("result", "cgFail");
//        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
//        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
//        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
//        paraObj.put("zdryName", zdryHsb.getXm());
//        paraObj.put("zdryGllxdm", zdryHsb.getZdrygllxdm());
//        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(zdryHsb.getZdrygllxdm()));
//        jwzhMessageService.sendMessage(MessageDict.ZDRYGL.CGSQ,paraObj);

    }


    public void saveApproval(String spjg,String spyj,String  zdryHsbId,SessionBean sessionBean) {
//        Map<String,Object> map=new HashMap<>();
        Map<String,Object> paraObj = new HashMap<>();
//        map.put("key","id");
//        map.put("id",messageid);
//        jwzhMessageService.doneMessage(map);
        ZdryZdryhsb zdryHsb = zdryZdryhsbDao.queryById(zdryHsbId);
        if("1".equals(spjg)) {
            paraObj.put("result", "hsSuccess");
            paraObj.put("suggestion", zdryConstant.getValueOfZdryDict(zdryHsb.getZdrygllxdm()));
            zdryHsb.setHszt("2");
        } else {
            paraObj.put("result", "hsFail");
            zdryHsb.setHszt("0");
        }

        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("zdryName", zdryHsb.getXm());
        paraObj.put("zdryGllxdm", StringUtils.isBlank(zdryHsb.getZdrygllxdm())?"01":zdryHsb.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(StringUtils.isBlank(zdryHsb.getZdrygllxdm())?"01":zdryHsb.getZdrygllxdm()));
        paraObj.put("suggestion", spyj);
        paraObj.put("jslx", "0");
        jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDHSSPJG,paraObj,"0",zdryHsb.getXt_zhxgrid());
        BaseService.setUpdateProperties(zdryHsb, sessionBean);
        zdryZdryhsbDao.update(zdryHsb);
    }


    public void saveHszd(ZdryZdryhsb entity, SessionBean sessionBean) {
        BaseService.setUpdateProperties(entity,sessionBean);
        entity.setHszt("0");
        zdryZdryhsbDao.update(entity);
        Map<String,Object> paraObj = new HashMap<>();
        paraObj.put("result", "zdSuccess");

        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("zdryName", entity.getXm());
        paraObj.put("zdryGllxdm", entity.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(entity.getZdrygllxdm()));
        Map<String,Object> jsdx=new HashMap<>();
        jsdx.put("jrsOrgCode",entity.getSspcs());
        jsdx.put("inculdeSubOrg",false);
//        jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDSPJG,paraObj,MessageDict.JSLX_TO_ORG,jsdx);

    }
}