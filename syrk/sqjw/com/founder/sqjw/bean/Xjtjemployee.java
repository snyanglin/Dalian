package com.founder.sqjw.bean;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @类名: LogInfo 
 * @描述:(类描述) 
 * @日期: 2014-12-9 下午10:57:56 
 */
public class Xjtjemployee extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String userid;
	private String score;
	private String rankings1; //市排名
	private String rankings2; //局排名
	private String totalType; //统计类型
	private String evalDate; //统计日期
	private String userName;
	private String rankings3; //派出所排名
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRankings3() {
		return rankings3;
	}
	public void setRankings3(String rankings3) {
		this.rankings3 = rankings3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRankings1() {
		return rankings1;
	}
	public void setRankings1(String rankings1) {
		this.rankings1 = rankings1;
	}
	public String getRankings2() {
		return rankings2;
	}
	public void setRankings2(String rankings2) {
		this.rankings2 = rankings2;
	}
	public String getTotalType() {
		return totalType;
	}
	public void setTotalType(String totalType) {
		this.totalType = totalType;
	}
	public String getEvalDate() {
		return evalDate;
	}
	public void setEvalDate(String evalDate) {
		this.evalDate = evalDate;
	}
	
	
	
}