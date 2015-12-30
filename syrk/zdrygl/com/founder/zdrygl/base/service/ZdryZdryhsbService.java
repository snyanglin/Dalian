
package com.founder.zdrygl.base.service;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.MessageDict;
import com.founder.framework.message.service.JwzhMessageService;
import com.founder.framework.organization.assign.dao.OrgAssignPublicDao;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.dao.ZdryZdryhsbDao;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.ZdryZdryhsb;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.base.vo.ZdryZdryhsbVO;
import com.founder.zdrygl.base.vo.ZdryZdryzbVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.utils.ZdryConstant;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Autowired
    private OrgOrganizationService orgOrganizationService;
    @Autowired
    private OrgAssignPublicDao orgAssignPublic;

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
        String filterylgStr = "";
        StringBuffer ylgStr = new StringBuffer();
        for (int i = 0; i < list.size(); ++i) {
            ZdryZdryzbVO zdryZdryzbVO = list.get(i);
            if (zdryZdryzbVO.getZdrygllxdm().equals("01")) {
                filterStr = "01";
            }
            if (ylgStr.indexOf(zdryZdryzbVO.getZdrygllxdm()) < 0) {
                ylgStr.append(zdryZdryzbVO.getZdrygllxdm()).append(",");
            }
            if (zdryZdryzbVO.getSyrkid().equals(syrkid)) {
                displayStr = displayStr + ((Map) dictMap).get(zdryZdryzbVO.getZdrygllxdm());
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
        if (ylgStr.length() > 0) {
            filterylgStr = ylgStr.substring(0, ylgStr.length() - 1);
        }
        returnMap.put("displayStr", displayStr);
        returnMap.put("filterStr", filterStr);
        returnMap.put("filterZdStr", filterZdStr);
        returnMap.put("filterylgStr", filterylgStr);
        try {
            returnMap.put("filterklgStr", zdryRuleService.getKcglx(filterylgStr));
        } catch (Exception e) {
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
        ZdryService zdryService = zdryFactory.createZdryService(zdrygllxdm, zdryZdryzb, zdryVO.getZdrylbdx());
        ZOBean entity = new ZOBean(zdryZdryzb, zdryVO.getZdrylbdx());
        zdryService.lg(sessionBean, entity);
        zdryZdryzb.setGlzt("2");
        zdryZdryZbDao.update(zdryZdryzb);

        Map returnMap = null;
        try {
            returnMap = saveLczywb(zdryZdryzb, sessionBean);
        } catch (BussinessException e) {
            e.printStackTrace();
        }
        return returnMap;
    }


    /**
     * 核实列管 发送消息
     *
     * @param zdryZdyzb
     * @param sessionBean
     * @return
     * @throws BussinessException
     */
    public Map<String, String> saveLczywb(ZdryZb zdryZdyzb, SessionBean sessionBean) throws BussinessException {
        HashMap returnMap = new HashMap();
        Map<String, Object> paraObj = new HashMap<>();
        paraObj.put("result", "lgSuccess");
        paraObj.put("zdryId", zdryZdyzb.getId());
        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("fsrOrgCode", sessionBean.getUserOrgCode());//发送人机构代码
        paraObj.put("zdryName", zdryZdyzb.getXm());
        paraObj.put("zdryGllxdm", zdryZdyzb.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(zdryZdyzb.getZdrygllxdm()));
        String  jsr = getSzIdBy(sessionBean.getUserOrgCode());
        if (!StringUtils.isBlank(jsr)){
            jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDRYHS, paraObj,MessageDict.JSLX_TO_USER,jsr);
        }
        returnMap.put("zdryZbId", zdryZdyzb.getId());
        return returnMap;
    }


    /**
     * 核实撤管申请审批
     *
     * @param zdryHsb
     * @param sqyj
     * @param sessionBean
     */
    public void saveHsCg(ZdryZdryhsb zdryHsb, String sqyj, SessionBean sessionBean) {
        zdryHsb.setHszt("4");//核实撤管申请
        BaseService.setUpdateProperties(zdryHsb, sessionBean);
        zdryZdryhsbDao.update(zdryHsb);

        ZdryVO zdryVO = new ZdryVO();
        zdryVO.setXm(zdryHsb.getXm());
        zdryVO.setYwsqyy(StringUtils.isBlank(sqyj) ? "重点人员核实撤管" : sqyj);
        zdryVO.setZjhm(zdryHsb.getZjhm());
        zdryVO.setZdryHsbId(zdryHsb.getId());
        zdryVO.setCglxdm(zdryHsb.getZdrygllxdm());
        WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant, zdryQueryService);
        StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean, zdryVO, LcgFlagEnum.HSCG);
        spi.getVariables().put("sqrOrgCode", sessionBean.getUserOrgCode());

        if (spi != null && StringUtils.isBlank(spi.getProcessKey())) {
            throw new BussinessException("缺少流程启动参数！");
        } else {
            processDefinitionService.startProcessInstance(spi.getApplyUserId(), spi.getProcessKey(), spi.getBusinessKey(), spi.getVariables());
        }

        Map<String, Object> paraObj = new HashMap<>();

        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserOrgCode());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("fsrOrgCode", sessionBean.getUserOrgCode());//发送人机构代码
        paraObj.put("zdryName", zdryHsb.getXm());
        paraObj.put("zdryGllxdm", zdryHsb.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(zdryHsb.getZdrygllxdm()));
        String jsr;//接收人
        if ("04".equals(zdryHsb.getZdrygllxdm()) || "06".equals(zdryHsb.getZdrygllxdm())) {
            jsr = getZazdCodeBy();
        } else {
            jsr = getSzIdBy(sessionBean.getUserOrgCode());
        }
        if (!StringUtils.isBlank(jsr)) {
            try {
                jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDHSSPSQ, paraObj, MessageDict.JSLX_TO_USER, jsr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 保存审批结果
     * @param spjg
     * @param spyj
     * @param zdryHsbId
     * @param sessionBean
     */
    public void saveApproval(String spjg, String spyj, String zdryHsbId, SessionBean sessionBean) {
        Map<String, Object> paraObj = new HashMap<>();
        ZdryZdryhsb zdryHsb = zdryZdryhsbDao.queryById(zdryHsbId);
        if ("1".equals(spjg)) {
            paraObj.put("result", "hsSuccess");
            paraObj.put("suggestion", zdryConstant.getValueOfZdryDict(zdryHsb.getZdrygllxdm()));
            zdryHsb.setHszt("2");
        } else {
            paraObj.put("result", "hsFail");
            zdryHsb.setHszt("3");//撤管审批不通过
        }

        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("fsrOrgCode", sessionBean.getUserOrgCode());//发送人机构代码
        paraObj.put("zdryName", zdryHsb.getXm());
        paraObj.put("zdryGllxdm", StringUtils.isBlank(zdryHsb.getZdrygllxdm()) ? "01" : zdryHsb.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(StringUtils.isBlank(zdryHsb.getZdrygllxdm()) ? "01" : zdryHsb.getZdrygllxdm()));
        paraObj.put("suggestion", spyj);
        paraObj.put("jslx", "0");

        try {
            jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDHSSPJG, paraObj, MessageDict.JSLX_TO_USER, zdryHsb.getXt_zhxgrid());
        } catch (Exception e) {
            e.printStackTrace();
        }

        BaseService.setUpdateProperties(zdryHsb, sessionBean);
        zdryZdryhsbDao.update(zdryHsb);
    }

    /**
     * 核实转递
     * @param entity
     * @param sessionBean
     */
    public void saveHszd(ZdryZdryhsb entity, SessionBean sessionBean) {
        BaseService.setUpdateProperties(entity, sessionBean);
        entity.setHszt("0");
        zdryZdryhsbDao.update(entity);
        Map<String, Object> paraObj = new HashMap<>();
        paraObj.put("result", "zdSuccess");

        paraObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paraObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码
        paraObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paraObj.put("fsrOrgCode", sessionBean.getUserOrgCode());//发送人机构代码
        paraObj.put("zdryName", entity.getXm());
        paraObj.put("zdryGllxdm", entity.getZdrygllxdm());
        paraObj.put("zdrylxName", zdryConstant.getValueOfZdryDict(entity.getZdrygllxdm()));
        paraObj.put("jrsOrgCode", entity.getSspcs());
        Map<String, Object> jsdx = new HashMap<>();
        jsdx.put("jrsOrgCode", entity.getSspcs());
        jsdx.put("inculdeSubOrg", false);
        jsdx.put("noRepeatUser", false);
        try {
            jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDRYDHS,paraObj,MessageDict.JSLX_TO_ORG,jsdx);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取 所长id
     * @param orgCode
     * @return
     */
    public String getSzIdBy(String orgCode) {
        OrgOrganization obj = orgOrganizationService.queryUpOrgByLevel(orgCode, "32");
        if (obj == null)
            return null;
        String szOrgCode = obj.getOrgcode();//派出所
        List<OrgUserInfo> list = orgAssignPublic.queryUserByOrgAndPos(szOrgCode, "SZ");
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0).getUserid();
    }

    /**
     * 获取治安支队大队长ID
     * @return
     */
    public String getZazdCodeBy() {
        String orgName = "治安管理支队派出所工作大队";
        String systemXzqh = com.founder.ldym.util.SystemConfig.getString("systemXzqh") == null ? "210000" : com.founder.ldym.util.SystemConfig.getString("systemXzqh");
        List<OrgOrganization> orgLst = orgOrganizationService.queryList(orgName, "30", systemXzqh);
        List<OrgUserInfo> list;
        if (orgLst.size() > 0 && orgLst.size() == 1) {
            list = orgAssignPublic.queryUserByOrgAndPos(orgLst.get(0).getOrgcode(), "DDZ");
        } else {
            return null;
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0).getUserid();

    }
}