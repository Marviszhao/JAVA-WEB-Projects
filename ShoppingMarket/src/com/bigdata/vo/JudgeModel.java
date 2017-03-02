package com.bigdata.vo;

public class JudgeModel {
	private int id;
	private String judge_content;
	private int judge_star;
	private int stock_id;
	private int user_id;
	private int judge_secret;
	@Override
	public String toString() {
		return "JudgeModel [id=" + id + ", judge_content=" + judge_content
				+ ", judge_star=" + judge_star + ", stock_id=" + stock_id
				+ ", user_id=" + user_id + ", judge_secret=" + judge_secret
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJudge_content() {
		return judge_content;
	}
	public void setJudge_content(String judge_content) {
		this.judge_content = judge_content;
	}
	public int getJudge_star() {
		return judge_star;
	}
	public void setJudge_star(int judge_star) {
		this.judge_star = judge_star;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getJudge_secret() {
		return judge_secret;
	}
	public void setJudge_secret(int judge_secret) {
		this.judge_secret = judge_secret;
	}
	
}
