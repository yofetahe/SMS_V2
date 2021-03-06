package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.ExamDefaultComment;

public interface ExamDefaultCommentDao {

	public List<ExamDefaultComment> getAllDefaultComment();
	
	public List<ExamDefaultComment> getActiveDefaultComment();
	
	public ExamDefaultComment getDefaultCommentByEdc_id(int edc_id);
	
	public boolean saveDefaultComment(ExamDefaultComment defaultComment);
	
	public boolean updateDefaultComment(ExamDefaultComment defaultComment);
	
	
	
	public ExamDefaultComment getDefaultCommentPerRank(Double average_quarter_mark);
}
