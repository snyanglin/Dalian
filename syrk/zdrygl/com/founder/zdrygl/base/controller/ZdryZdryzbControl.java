package com.founder.zdrygl.base.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.exception.RestException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycx;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.validator.ZdryVOValidator;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.base.controller.ZdryZdryzbControl.java]
 * @ClassName: [ZdryZdryzbControl]
 * @Description: [重点人员总表控制器]
 * @Author: [wei.wen@founder.com.cn]
 * @CreateDate: [2015年9月18日 下午3:20:01]
 * @UpdateUser: [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年9月18日 下午3:20:01，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("/zdryzb")
public class ZdryZdryzbControl extends BaseController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public ZdryAbstractFactory zdryFactory;

    @Resource(name = "zdryQueryService")
    private ZdryInfoQueryService zdryQueryService;

    @Autowired
    private ZdryConstant zdryConstant;

    @Autowired
    private ZdryRuleService zdryRuleService;

    @Autowired
    private ZdryVOValidator zdryVOValidator;

    @Resource(name = "syrkSyrkxxzbService")
    private SyrkSyrkxxzbService syrkSyrkxxzbService;
    @Resource
    private OrgOrganizationService orgOrganizationService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        Object target = binder.getTarget();
        if (target != null && target.getClass().equals(ZdryVO.class))
            binder.setValidator(zdryVOValidator);
        else {
            //多个验证器的时候使用
        }
    }

    /**
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @Title: manage
     * @Description: (打开重点人员管理列表)
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manage() {
        zdryConstant.createTreeJS();
        return "zdrygl/zdryManage";
    }

    /**
     * @param @param  page
     * @param @param  rows
     * @param @param  entity
     * @param @param  sessionBean
     * @param @return 设定文件
     * @return EasyUIPage 返回类型
     * @throws
     * @Title: getManageList
     * @Description: (重点人员管理列表 查询)
     */
    @RestfulAnnotation(serverId = "3")
    @RequestMapping(value = "/getManageList", method = RequestMethod.POST)
    public
    @ResponseBody
    EasyUIPage getManageList(EasyUIPage page,
                             @RequestParam(value = "rows", required = false) Integer rows,
                             ZdryZb entity, SessionBean sessionBean) {
        page.setPagePara(rows);
        entity.setGlbm(getSessionBean(sessionBean).getUserOrgCode());
        return zdryQueryService.queryList(page, entity);
    }

    /**
     * @param @param  page
     * @param @param  rows
     * @param @param  entity
     * @param @return 设定文件
     * @return EasyUIPage 返回类型
     * @Title: queryZdryOnPT
     * @Description: (重点人员查询 列表)
     * @throw
     */
    @RequestMapping(value = "/getQeryList", method = RequestMethod.POST)
    public
    @ResponseBody
    EasyUIPage getQeryList(EasyUIPage page,
                           @RequestParam(value = "rows") Integer rows, ZdryZb entity,
                           SessionBean sessionBean) {
        page.setPagePara(rows);
        if (entity.getGlbm() == null)
            entity.setGlbm(getSessionBean(sessionBean).getUserOrgCode());
        return zdryQueryService.getQueryList(page, entity);
    }

    /**
     * @param @param  lbdm_p 上级类型
     * @param @return 设定文件
     * @return List 返回类型
     * @throws
     * @Title: queryZdryChildLbList
     * @Description: 查询当前区域下的子类别列表
     */
    @RequestMapping(value = "/queryZdryChildLbList", method = RequestMethod.GET)
    public
    @ResponseBody
    List<?> queryZdryChildLbList(String lbdm_p) {
        return zdryQueryService.getChildList(lbdm_p);
    }

    /**
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @Title: zdryAddPre
     * @Description: (打开重点人员新增页面)
     */
    @RequestMapping(value = "/zdryAddPre", method = RequestMethod.GET)
    public ModelAndView zdryAddPre(String syrkid, SessionBean sessionBean) {
        ModelAndView mv = new ModelAndView("zdrygl/add/zdryAddPre");
        sessionBean = getSessionBean(sessionBean);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        mv.addObject("applyUser", sessionBean.getUserName());
        mv.addObject("applyDate", formatter.format(new Date()));

        SyrkSyrkxxzb syrkxxb = syrkSyrkxxzbService.queryById(syrkid);
        mv.addObject("syrkxxb", syrkxxb);

        if ("210200".equals(SystemConfig.getString(AppConst.XZQH))) {//大连，列管是从实有人口来的
            if (syrkxxb == null) throw new RuntimeException("can not find syrk");
        }
        return mv;
    }

    /**
     * @param @param  zdryVO
     * @param @param  uploadFile
     * @param @param  sessionBean
     * @param @return 设定文件
     * @return ModelAndView 返回类型
     * @throws RestException
     * @Title: saveLg
     * @Description: TODO(保存列管)
     * @throw
     */
    @RequestMapping(value = "/saveLg", method = RequestMethod.POST)
    public ModelAndView saveLg(@Valid ZdryVO zdryVO, BindingResult result, SessionBean sessionBean) throws RestException {
        ModelAndView mv = new ModelAndView(getViewName(sessionBean));
        ZdryService zdryService = null;
        /*if(!super.validateResult(mv, result)){
            return mv;
		}
		}*/
        Map<String, Object> model = new HashMap<String, Object>();
        sessionBean = getSessionBean(sessionBean);
        try {
            String zdrygllxdm = zdryVO.getZdryZdryzb().getZdrygllxdm();// 重点人员类型
            zdryService = zdryFactory.createZdryService(zdrygllxdm);
            ZOBean entity = new ZOBean(zdryVO.getZdryZdryzb(), zdryVO.getZdrylbdx());
            // start process
            WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant, zdryQueryService);
            StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean, zdryVO, LcgFlagEnum.LG);
            entity.setStartProcessInstance(spi);
//			zdryService.setStartProcessInstance(spi.getProcessKey(), spi.getApplyUserId(),spi.getVariables());
//			zdryService.lg(sessionBean);
            zdryService.lg(sessionBean, entity);

            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGES, getAddSuccess());
        } catch (BussinessException e) {
            logger.error(e.getLocalizedMessage(), e);
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGES, e.getLocalizedMessage());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGES, getAddFail());
        }

        mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
        return mv;

    }

    /**
     * @param @param  mode 编辑模式
     * @param @param  mainTabID
     * @param @param  id 重点人员ID
     * @param @return
     * @param @throws BussinessException 设定文件
     * @return ModelAndView 返回类型
     * @Title: view
     * @Description: TODO(打开重点人员编辑查看页面)
     * @throw
     */
    @RequestMapping(value = "/{ryid}/{id}/view", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView view(
            @PathVariable(value = "ryid") String ryid,
            @RequestParam(value = "mode", defaultValue = "edit") String mode,
            String mainTabID, @PathVariable(value = "id") String id)
            throws BussinessException {
        ModelAndView mv = new ModelAndView("zdrygl/edit/zdryEdit");

        ZdryZb zdryZb = new ZdryZb();
        // ryid可能为空
        if (ryid != null && ryid.length() > 0) {
            zdryZb.setRyid(ryid);
        } else {
            zdryZb.setId(id);
        }
        List<?> zdryList = zdryQueryService.queryListByEntity(zdryZb);
        if (zdryList.isEmpty())
            throw new BussinessException("Zdry not Exist");

        ZdryZb temp = null;
        List<Map<String, String>> zdrylxList = new ArrayList<Map<String, String>>();
        String zdrygllxmc;
        StringBuffer zdrylxBuffer = new StringBuffer();// 已列管类型名字

        for (int i = 0; i < zdryList.size(); i++) {
            temp = (ZdryZb) zdryList.get(i);

            // 只取当前重点人员id的重点人员类型
            if (temp.getId().equals(id)) {
                mv.addObject("zdry", temp);
                Map<String, String> map = new HashMap<String, String>();
                map.put("zdryid", temp.getId());
                map.put("zdrylx", temp.getZdrygllxdm());
                zdrylxList.add(map);
            }

            // 已列管 重点人员 类型
            zdrygllxmc = zdryConstant.zdryDict().get(temp.getZdrygllxdm());
            if (zdrygllxmc != null && zdrygllxmc.length() > 0
                    && !"4".equals(temp.getGlzt())) {
                if (zdrylxBuffer.length() > 0)
                    zdrylxBuffer.append(" ");
                zdrylxBuffer.append(zdrygllxmc);
            }

        }

        String zdrylxStr = zdrylxBuffer.toString();
        if (zdrylxStr.length() > 17) {
            mv.addObject("zdrylxMore", zdrylxBuffer.toString());// 全部的已列管类型
            zdrylxStr = zdrylxStr.subSequence(0, 17) + "……";
        }
        mv.addObject("zdrylx", zdrylxStr);// 简化的已列管类型
        mv.addObject("zdrylxList", zdrylxList);
        mv.addObject("zdrylxJson", new Gson().toJson(zdrylxList));
        mv.addObject("mainTabID", mainTabID);
        mv.addObject("mode", mode);

        return mv;
    }

    /**
     * @param @param  ryid
     * @param @param  syrkid
     * @param @return
     * @param @throws BussinessException 设定文件
     * @return String 返回类型
     * @throws
     * @Title: queryYlglx
     * @Description: TODO(根据人员ID查询已列管的类型)
     */
    @RequestMapping(value = "/queryYlglx", method = RequestMethod.POST)
    public
    @ResponseBody
    String queryYlglx(String ryid, String syrkid) {
        if (ryid == null || syrkid == null)
            return "";
        SessionBean sessionBean = getSessionBean();
        List<?> zdryList = zdryQueryService.queryListByRyid(ryid);

        if (zdryList.isEmpty())
            return "";

        ZdryZb temp = null;
        StringBuffer resStrBuffer = new StringBuffer("");
        StringBuffer klgStrBuffer = new StringBuffer("");
        for (int i = 0; i < zdryList.size(); i++) {
            temp = (ZdryZb) zdryList.get(i);
            boolean isSameGlbm = sessionBean.getUserOrgCode().equals(temp.getGlbm());//是否同一辖区列管的。
            String orgName = "";
            if (!isSameGlbm) {
                orgName = orgOrganizationService.queryOrgNameByOrgcodes(temp.getGlbm()) + ":";
                logger.debug("其他已列管辖区名称为：" + orgName);
            }

            resStrBuffer.append(resStrBuffer.length() > 0 ? "，" : "");// 中文符号，显示页面用
            klgStrBuffer.append(klgStrBuffer.length() > 0 ? "," : "");// 英文符号，后续查询用

            resStrBuffer.append(orgName).append(zdryConstant.zdryDict().get(
                    temp.getZdrygllxdm()));
            if (isSameGlbm) {
                klgStrBuffer.append(temp.getZdrygllxdm());//本辖区已列管类型
            }
        }
//        if (resStrBuffer.length() == 0 || klgStrBuffer.length() == 0) {
//            return "";
//        }
        return resStrBuffer.append("/").append(klgStrBuffer).toString();
    }

    /**
     * @param @param  ylglxStr
     * @param @return 设定文件
     * @return String 返回类型
     * @Title: queryklglx
     * @Description: TODO(查询可同时列管的类型)
     * @throw
     */
    @RequestMapping(value = "/queryklglx", method = RequestMethod.POST)
    public
    @ResponseBody
    String queryklglx(String ylglxStr, String syrkid) {

        String klgStr;
        try {
            if (ylglxStr == "" || ylglxStr == null) {
                Map ins=zdryConstant.zdryServiceMap();
                ins.remove("00");
                klgStr = ins.keySet().toString();
                klgStr = klgStr.replaceAll(",", "|");
                klgStr = klgStr.replaceAll(" ", "");
                klgStr = klgStr.substring(1, klgStr.length() - 1);
            } else {
                klgStr = zdryRuleService.getKlglx(ylglxStr);
            }
            if ("".equals(klgStr)) {// 没有可列管的类型，不能返回“”，此时应该没有匹配的选项
                klgStr = "999999";
            } else {//有可同时列管的类型
				/*大连需求：同一辖区内同一个监督部门管理的重点人员管理类型间不允许重复列管*/
                if ("210200".equals(SystemConfig.getString(AppConst.XZQH))) {//大连
                    SessionBean sessionBean = getSessionBean();
                    SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbService.queryById(syrkid);
                    boolean hasOtherlg = false;//是否有其他辖区
                    if (syrkSyrkxxzb != null) {
                        List<ZdryZb> list = (List<ZdryZb>) zdryQueryService.queryListByRyid(syrkSyrkxxzb.getRyid());
                        for (ZdryZb zb : list) {
                            if (!sessionBean.getUserOrgCode().equals(zb.getGlbm())){
                                hasOtherlg=true;
                            }
                            if (!sessionBean.getUserOrgCode().equals(zb.getGlbm()) && "01".equals(zb.getZdrygllxdm())) {
                                logger.debug("其他辖区已列管监管对象，本辖区不能再列管其他类型");
                                return "999999";
                            }

                        }
                    }
                    List zdryList = zdryQueryService.queryListBySyrkId(syrkid);
                    ZdryZb zdryzb;
                    Map jgbmMap = null;//所有的重点人员监管部门对应Map
                    Map ylgJjgbmMap = null;//已列管类型的监管部门
//					SessionBean sessionBean = getSessionBean();
                    String glbm = sessionBean.getUserOrgCode();
                    for (int i = 0; i < zdryList.size(); i++) {//循环获取已列管的类型所在的监管部门Map
                        zdryzb = (ZdryZb) zdryList.get(i);
                        if (glbm.equals(zdryzb.getGlbm())) {//同一辖区内
                            if (jgbmMap == null)
                                jgbmMap = zdryRuleService.getZdryLxJgbmMap();
                            if (jgbmMap == null) {
                                throw new RuntimeException("获取重点人员监管部门失败，请检查规则平台");
                            }
                            if (ylgJjgbmMap == null) ylgJjgbmMap = new HashMap();
                            ylgJjgbmMap.put(jgbmMap.get(zdryzb.getZdrygllxdm()), true);//已列管的监管部门
                        }
                    }

                    if (ylgJjgbmMap != null) {//有已列管类型的监管部门
                        String klgAry[] = klgStr.split("\\|");
                        for (int index = 0; index < klgAry.length; index++) {//循环可列管的类型
                            if (ylgJjgbmMap.get(jgbmMap.get(klgAry[index])) != null) {//已列管的有这个部门，可列管的也有这个部门，此时应该删除这个克列管的类型
                                klgStr = klgStr.replace(klgAry[index], "999999");
                            }

                        }
                    }
                    if (hasOtherlg){
                        String klgAry[] = klgStr.split("\\|");
                        for (int index = 0; index < klgAry.length; index++) {
                            if ("#02#04#06#07#".indexOf(klgAry[index]) < 0){
                                logger.debug("其他辖区已列管，本辖区不能再列管本类型：" + klgAry[index]);
                                klgStr = klgStr.replace(klgAry[index], "999999");
                            }
                        }
                    }

                }
            }
            return klgStr;
        } catch (Exception e) {
            logger.error("同时列管的类型出错！", e);
        }

        return "999999";
    }

    /**
     * @param @param  id 重点人员ID
     * @param @return 设定文件
     * @return ModelAndView 返回类型
     * @Title: zdryDelPre
     * @Description: TODO(打开重点人员撤管页面)
     * @throw
     */
    @RequestMapping(value = "/zdryDelPre", method = RequestMethod.GET)
    public ModelAndView zdryDelPre(String id) {
        ModelAndView mv = new ModelAndView("zdrygl/add/zdryDelPre");
        SessionBean sessionBean = getSessionBean();
        Zdry zdry = zdryQueryService.queryById(id);
        if (zdry == null)
            throw new BussinessException("zdry.notExist");
        String zdrygllxdm = ((ZdryZb) zdry).getZdrygllxdm();
        String zdrygllxmc = zdryConstant.zdryDict().get(zdrygllxdm);
        // 可撤管类型
        String kcgStr = null;
        try {
            kcgStr = zdryRuleService.getKcglx(zdrygllxdm);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kcgStr == null || kcgStr.length() == 0)
            kcgStr = "999999";

        mv.addObject("userName", sessionBean.getUserName());
        mv.addObject("blrq", DateUtils.getSystemDateString());
        mv.addObject("zdry", zdry);
        mv.addObject("zdrylxmc", zdrygllxmc);
        mv.addObject("kcgStr", kcgStr);
        return mv;
    }

    /**
     * @param @param  zdryVO
     * @param @param  sessionBean
     * @param @return 设定文件
     * @return ModelAndView 返回类型
     * @Title: saveCg
     * @Description: TODO(撤管保存)
     * @throw
     */
    @RequestMapping(value = "/saveCg", method = RequestMethod.POST)
    public ModelAndView saveCg(ZdryVO zdryVO, SessionBean sessionBean) {
        ModelAndView mv = new ModelAndView(getViewName(sessionBean));
        Map<String, Object> model = new HashMap<String, Object>();
        sessionBean = getSessionBean(sessionBean);

        try {
            ZdryZb zb_new = zdryVO.getZdryZdryzb();

            // 查询撤管前的重点人员信息
            ZdryZb zb_old = (ZdryZb) zdryQueryService.queryById(zb_new.getId());
            if (zb_old == null) {
                throw new BussinessException("未查询到该重点人员的信息");
            }
            // 验证状态是否正确
            if (!ZdryConstant.YLG.equals(zb_old.getGlzt())) {
                throw new BussinessException("该重点人员正在【"
                        + zdryConstant.getGlztStr(zb_old.getGlzt())
                        + "】，不能办理其他业务");
            }
            zdryVO.setCglxdm(zb_old.getZdrygllxdm());//撤管类型代码
            Zdrycx zdrycg = new Zdrycx();
            BeanUtils.copyProperties(zb_old, zdrycg);

            zdrycg.setZdryid_old(zb_old.getId());
            zdrycg.setZdrygllxdm_old(zb_old.getZdrygllxdm());
            zdrycg.setZdrygllxdm(zb_new.getZdrygllxdm());
            zdrycg.setZdrylb(zb_new.getZdrylb());
            // 撤管重点人员
//			ZdryService zdryService = zdryFactory.createZdryService(
//					zb_new.getZdrygllxdm(), zdrycg, zdryVO.getZdrylbdx());

            ZdryService zdryService = zdryFactory.createZdryService(zb_new.getZdrygllxdm());
            // start process
            WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant, zdryQueryService);
            StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean, zdryVO, LcgFlagEnum.CG);
//			zdryService.setStartProcessInstance(spi.getProcessKey(), spi.getApplyUserId(), spi.getVariables());
            ZOBean entity = new ZOBean(zb_new, zdryVO.getZdrylbdx());
            entity.setZdrycx(zdrycg);
            if (!"07".equals(zb_old.getZdrygllxdm())) {
                entity.setStartProcessInstance(spi);//modify by zhoulijun 2015-12-31 纳入视线 撤管不用启动流程
            }
            zdryService.cg(sessionBean, entity);

            model.put(AppConst.STATUS, AppConst.SUCCESS);
            model.put(AppConst.MESSAGES, getAddSuccess());

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            model.put(AppConst.STATUS, AppConst.FAIL);
            model.put(AppConst.MESSAGES, e.getLocalizedMessage());
        }
        mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
        return mv;
    }

}
