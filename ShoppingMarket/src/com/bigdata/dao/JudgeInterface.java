package com.bigdata.dao;

import java.util.List;

import com.bigdata.vo.JudgeModel;

public interface JudgeInterface {
	public void insertJudge(JudgeModel judgeModel);
	
	public List queryJudgeList(int parseInt);
	
	public void deleteJudge(int judgeID);
}
