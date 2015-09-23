package com.founder.zdrygl.base.message;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.base.dict.MessageDict;
import com.founder.zdrygl.core.inteface.SendMessageService;
import com.founder.zdrygl.core.model.SysMessage;

@Service
public class SendMessageServiceImpl implements SendMessageService {
	@SuppressWarnings("unchecked")
	@Override
	public void sendMessage(SysMessage sysMessage, String jslx,Object jsdx) {
		if(sysMessage==null){
			throw new BussinessException("sysMessage Object must not be null");
		}
		if(jslx==null){
			throw new BussinessException("jslx String must not be null");
		}
		
		if(jsdx==null){
			throw new BussinessException("jsdx Object must not be null");
		}
		
		
		if(MessageDict.JSLX_TO_USER.equals(jslx)){//发送给个人
			if(jsdx instanceof String){
				this.sendMessageToUser(sysMessage,jsdx.toString());
			}else{
				throw new BussinessException("jsdx(jsrUserCode) Object must not be String");
			}
		}
		if(MessageDict.JSLX_TO_USERLIST.equals(jslx)){//发送给多个人员
			if(jsdx instanceof List){
				this.sendMessageToUserList(sysMessage, (List<String>) jsdx);
			}else{
				throw new BussinessException("jsdx(jsrUserCode) Object must not be List");
			}
					
		}
		if(MessageDict.JSLX_TO_ORG.equals(jslx)){//发送给部门
			if(jsdx instanceof Map){
				Map<String,Object> map=(Map<String,Object>) jsdx;
				Object jrsOrgCode= map.get("jrsOrgCode");
				Object inculdeSubOrg=map.get("inculdeSubOrg");
				Object noRepeatUser=map.get("noRepeatUser");
				if(jrsOrgCode==null){
					throw new BussinessException("jsdx.jrsOrgCode must not be null");
				}
					
				if(!(jrsOrgCode instanceof String)){
					throw new BussinessException("jsdx.jrsOrgCode must be String");
				}
				
				if(inculdeSubOrg==null){
					throw new BussinessException("jsdx.inculdeSubOrg must not be null");
				}
					
				if(!(inculdeSubOrg instanceof Boolean)){
					throw new BussinessException("jsdx.inculdeSubOrg must be Boolean");
				}
				
				if(noRepeatUser==null){
					throw new BussinessException("jsdx.noRepeatUser must not be null");
				}
					
				if(!(noRepeatUser instanceof Boolean)){
					throw new BussinessException("jsdx.noRepeatUser must be Boolean");
				}
				
				
				this.sendMessageToOrg(sysMessage, jrsOrgCode.toString(), (boolean)inculdeSubOrg, (boolean)noRepeatUser);
			}else{
				throw new BussinessException("jsdx(jsrOrg) Object must not be Map");
			}
			
		}
		if(MessageDict.JSLX_TO_ORGANDPOS.equals(jslx)){//发送给部门下的某个岗位
			if(jsdx instanceof Map){
				Map<String,Object> map=(Map<String,Object>) jsdx;
				Object jrsOrgCode= map.get("jrsOrgCode");
				Object position=map.get("position");
				
				if(jrsOrgCode==null){
					throw new BussinessException("jsdx.jrsOrgCode must not be null");
				}
					
				if(!(jrsOrgCode instanceof String)){
					throw new BussinessException("jsdx.jrsOrgCode must be String");
				}
				
				if(position==null){
					throw new BussinessException("jsdx.position must not be null");
				}
					
				if(!(position instanceof String)){
					throw new BussinessException("jsdx.position must be Boolean");
				}												
				
				this.sendMessageToOrgAndPosition(sysMessage, (String)jrsOrgCode, (String)position);
			}else{
				throw new BussinessException("jsdx(jsrOrgPos) Object must not be Map");
			}
			
		}
	}

	/**
	 * 
	 * @Title: sendMessageToUser
	 * @Description: TODO(发送给个人)
	 * @param @param sysMessage 消息对象
	 * @param @param userCode  接收人代码
	 * @return void    返回类型
	 * @throw
	 */
	private void sendMessageToUser(SysMessage sysMessage, String userCode) {
		sysMessage.setJslx("0");//0 按人  1 按部门
		System.out.println("发送给个人:"+userCode);
		System.out.println(sysMessage.getXxnr());
	}

	/**
	 * 
	 * @Title: sendMessageToUserList
	 * @Description: TODO(发送给多个人员)
	 * @param @param sysMessage 消息对象
	 * @param @param userCodes  接收人LIST
	 * @return void    返回类型
	 * @throw
	 */
	private void sendMessageToUserList(SysMessage sysMessage, List<String> userCodes) {		
		for(int i=0;i<userCodes.size();i++){
			this.sendMessageToUser(sysMessage, userCodes.get(i));
		}

	}

	/**
	 * 
	 * @Title: sendMessageToOrg
	 * @Description: TODO(发送给部门所有人)
	 * @param @param sysMessage 消息对象
	 * @param @param jrsOrgCode 部门代码
	 * @param @param inculdeSubOrg 是否包括下级部门
	 * @param @param noRepeatUser  是否重复发人员
	 * @return void    返回类型
	 * @throw
	 */
	private void sendMessageToOrg(SysMessage sysMessage, String jrsOrgCode, boolean inculdeSubOrg, boolean noRepeatUser) {
		sysMessage.setJslx("1");//0 按人  1 按部门
		System.out.println("发送给部门:"+jrsOrgCode);
		System.out.println(sysMessage.getXxnr());
	}

	
	/**
	 * 
	 * @Title: sendMessageToOrgAndPosition
	 * @Description: TODO(发送给部门下的岗位)
	 * @param @param sysMessage 消息对象
	 * @param @param jrsOrgCode    部门代码
	 * @param @param position   岗位代码
	 * @return void    返回类型
	 * @throw
	 */
	private void sendMessageToOrgAndPosition(SysMessage sysMessage, String jrsOrgCode, String position) {
		sysMessage.setJslx("1");//0 按人  1 按部门
		System.out.println("发送给部门:"+jrsOrgCode+"岗位："+position);
		System.out.println(sysMessage.getXxnr());

	}

	

}
