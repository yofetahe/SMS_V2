package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.ExamDefaultCommentDao;
import com.fidel.sms.model.ExamDefaultComment;
import com.fidel.sms.service.ExamDefaultCommentService;

@Service
public class ExamDefaultCommentServiceImpl implements ExamDefaultCommentService {

	@Autowired
	ExamDefaultCommentDao examDefaultCommentDao;
	
	@Override
	public List<ExamDefaultComment> getAllDefaultComment() {
		
		return examDefaultCommentDao.getAllDefaultComment();
	}

	@Override
	public List<ExamDefaultComment> getActiveDefaultComment() {
		
		return examDefaultCommentDao.getActiveDefaultComment();
	}

	@Override
	public ExamDefaultComment getDefaultCommentByEdc_id(int edc_id) {
		
		return examDefaultCommentDao.getDefaultCommentByEdc_id(edc_id);
	}

	@Override
	public boolean saveDefaultComment(ExamDefaultComment defaultComment) {
		
		return examDefaultCommentDao.saveDefaultComment(defaultComment);
	}

	@Override
	public boolean updateDefaultComment(ExamDefaultComment defaultComment) {
		
		return examDefaultCommentDao.updateDefaultComment(defaultComment);
	}

	@Override
	public ExamDefaultComment getDefaultCommentPerRank(Double average_quarter_mark) {
		
		return examDefaultCommentDao.getDefaultCommentPerRank(average_quarter_mark);
	}

}
