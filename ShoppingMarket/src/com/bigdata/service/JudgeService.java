package com.bigdata.service;

import java.util.List;

import com.bigdata.dao.JudgeDao;
import com.bigdata.vo.JudgeModel;

public class JudgeService {

	public void insertJudge(JudgeModel judgeModel) {
		JudgeDao judgeDao = new JudgeDao();
		judgeDao.insertJudge(judgeModel);
	}

	public List queryJudgeList(int stockID) {
		JudgeDao judgeDao = new JudgeDao();
		return judgeDao.queryJudgeList(stockID);
	}

	public void deleteJudge(int judgeID) {
		JudgeDao judgeDao = new JudgeDao();
		judgeDao.deleteJudge(judgeID);
	}

}
