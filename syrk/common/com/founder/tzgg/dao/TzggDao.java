package com.founder.tzgg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.bean.Sys_Tzggb;

@Repository("tzggDao")
public class TzggDao extends BaseDaoImpl{

	
	public EasyUIPage queryList(EasyUIPage page, Sys_Tzggb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setGgbt(StringUtils.getSqlExpression(entity.getGgbt()));
		entity.setGgnr(StringUtils.getSqlExpression(entity.getGgnr()));
		map.put("tzgg", entity);
		
		page.setTotal((Integer) queryForObject("sys_tzgg.queryCountList", map));
		page.setRows(queryForList("sys_tzgg.queryList", map));
		return page;
	}
	 
	public Sys_Tzggb queryById(Sys_Tzggb entity){
		return (Sys_Tzggb)queryForObject("sys_tzgg.queryById", entity);
	}
	
	public void save(Sys_Tzggb entity) {
		insert("sys_tzgg.save", entity);
	}
	
	public void update(Sys_Tzggb entity) {
		update("sys_tzgg.update", entity);
	}
	public void delete(Sys_Tzggb entity) {
		update("sys_tzgg.delete", entity);
	}
	public void saveBm(Sys_Tzggb entity) {
		insert("sys_tzgg.saveBm", entity);
	}
	public void updateBm(Sys_Tzggb entity) {
		update("sys_tzgg.updateBm", entity);
	}
	public void deleteBm(Sys_Tzggb entity) {
		update("sys_tzgg.deleteBm", entity);
	}
	public List<Sys_Tzggb> queryByTzggId(Sys_Tzggb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tzgg", entity);
		return queryForList("sys_tzgg.queryByTzggId", map);
	}
	
	/**
	 * 保存发消息
	 * @param entity
	 * @param fsbmid
	 */
	public void insertMessage(SysMessage entity,String fsbmid){
		Map<String, Object> map = new HashMap<String, Object>();
		//entity.setId(getSequence(""));
		String fsbmidStr = "";
		if(fsbmid.indexOf(",")>0){
			String[] str = fsbmid.split(",");
			for(int i=0;i<str.length;i++){
				fsbmidStr+= "'"+str[i]+"'"+",";
			}
			fsbmidStr = fsbmidStr.substring(0, fsbmidStr.length()-1);
		}else{
			fsbmidStr = "'"+fsbmid+"'";
		}
		
		map.put("sysMessage", entity);
		map.put("fsbmid", fsbmidStr);
		
		insert("sys_tzgg.insertMessage", map);
	}
	public List<Org_Organization> queryOrg(Org_Organization organization){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organization", organization);
		return queryForList("org_organization.queryOrg", map);
	}
	
	public List<ZpfjFjxxb> queryFj(ZpfjFjxxb zpfjFjxxb){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zpfjFjxxb", zpfjFjxxb);
		return queryForList("sys_tzgg.queryFj", map);
	}
	
	/**
	 * 按照截取的组织机构代码来将数据保存;
	 * @param entity
	 * @param orgCode
	 */
	public void insertMessage2(SysMessage entity,String orgCode){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sysMessage", entity);
		int len = orgCode.length();
		int countZero = lengthNum(orgCode);
		int CountNum  = len-countZero;
		if(countZero>0){
			if(countZero%2==0){
				orgCode = orgCode.substring(0, CountNum);
				map.put("fsbmid", orgCode);
				insert("sys_tzgg.insertMessage", map);
			}
		}else{
			Pattern pattern  =Pattern.compile("[0-9]*");
			if(pattern.matcher(orgCode).matches()){
				map.put("fsbmid", orgCode);
				insert("sys_tzgg.insertMessage", map);
			}
		}
	}
	
	public static int lengthNum(String s){
		Pattern pattern  =Pattern.compile("[0-9]*");
		int i=0;
		if(pattern.matcher(s).matches()){
			Long num = Long.parseLong(s);
			while(num%10==0){
				num = num/10;
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args){
		
		String orgCode ="210203000000";
		int len = orgCode.length();
		int zeroStart = orgCode.lastIndexOf("^[1-9]d*$");
		int countZero = len-zeroStart;
		if(countZero%2==0){
		orgCode = orgCode.substring(0, zeroStart);
		System.out.println(orgCode);
		}
	}
	
}
