package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.ExamDefaultCommentDao;
import com.fidel.sms.model.ExamDefaultComment;

@Repository
public class ExamDefaultCommentDaoImpl implements ExamDefaultCommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ExamDefaultCommentDaoImpl(){}
	
	public ExamDefaultCommentDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<ExamDefaultComment> getAllDefaultComment() {
		
		Query query = sessionFactory.openSession().createQuery("FROM ExamDefaultComment");
		
		return (List<ExamDefaultComment>)query.list();
	}

	@Override
	public List<ExamDefaultComment> getActiveDefaultComment() {

		Query query = sessionFactory.openSession().createQuery("FROM ExamDefaultComment WHERE edc_status = 'Active'");
		
		return (List<ExamDefaultComment>)query.list();
	}

	@Override
	public ExamDefaultComment getDefaultCommentByEdc_id(int edc_id) {

		Query query = sessionFactory.openSession().createQuery("FROM ExamDefaultComment WHERE edc_id = :edc_id");
		
		List<ExamDefaultComment> rslt = (List<ExamDefaultComment>)query.list();
		
		ExamDefaultComment edc = new ExamDefaultComment();
		
		for(int i = 0; i < rslt.size(); i++){
			
			edc.setEdc_id(rslt.get(i).getEdc_id());
			edc.setEdc_content(rslt.get(i).getEdc_content());
			edc.setRank_from(rslt.get(i).getRank_from());
			edc.setRank_to(rslt.get(i).getRank_to());
			edc.setEdc_status(rslt.get(i).getEdc_status());
		}
		
		return edc;
	}

	@Override
	public boolean saveDefaultComment(ExamDefaultComment defaultComment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDefaultComment(ExamDefaultComment defaultComment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExamDefaultComment getDefaultCommentPerRank(Double average_quarter_mark) {
		// TODO Auto-generated method stub
		return null;
	}

}
