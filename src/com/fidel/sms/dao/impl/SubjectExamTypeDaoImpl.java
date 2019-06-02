package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.SubjectExamTypeDao;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Repository
public class SubjectExamTypeDaoImpl implements SubjectExamTypeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SubjectExamTypeDaoImpl(){}
	
	public SubjectExamTypeDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<SubjectType> getAllSubjectType() {
		
		Query query = sessionFactory.openSession().createQuery("FROM SubjectType");
		
		return (List<SubjectType>)query.list();
	}

	@Override
	public List<ExamsType> getAllExamType() {
		
		Query query = sessionFactory.openSession().createQuery("FROM ExamsType");
		
		return (List<ExamsType>)query.list();
	}

	@Override
	public List<ExamsType> getActiveExamType() {

		Query query = sessionFactory.openSession().createQuery("FROM ExamsType WHERE et_status = 'A'");
		
		return (List<ExamsType>)query.list();
	}

	@Override
	public List<SubjectType> getSubjectListWithPeriodAllotmentByCl_id(int cl_id) {
		
		final String hql = "SELECT a.sub_id, a.sub_name, a.sub_status, b.subcl_id, c.period_per_week "
				+ "FROM subject_list a, subject_class_rel b LEFT JOIN class_sched_subject_period_rel c ON b.sub_id = c.sub_id and b.cl_id = c.cl_id and c.academic_year = :academic_year "
				+ "WHERE a.sub_id = b.sub_id and b.cl_id = :cl_id and (a.sub_status = 'A' and b.rel_status = 'A')";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		return (List<SubjectType>)query.list();
	}

	@Override
	public List<ExamGrade> getExamGradingList() {
		
		Query query = sessionFactory.openSession().createQuery("FROM ExamGrade");
		
		return (List<ExamGrade>)query.list();
	}

	@Override
	public List<SubjectType> getSubjectTypeListByCl_id(int cl_id) {
		
		final String hql = "SELECT a.subcl_id, b.sub_id, b.sub_name "
				+ "FROM subject_list b, subject_class_rel a "
				+ "WHERE a.sub_id = b.sub_id and a.cl_id = :cl_id and rel_status = 'A'";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql).setParameter("cl_id", cl_id);
		
		return (List<SubjectType>)query.list();
	}

	@Override
	public List<ExamsType> getScheduledExamTypesBySubCl_idAcademic_yearAt_idCl_id(int academic_year, int at_id,
			int cl_id, int subcl_id) {

		final String hql = "SELECT c.es_id, a.et_id, a.et_name, a.et_status, b.total_mark, b.pass_mark, b.exsub_id " +
				 "FROM exams_type a, exam_sub_rel b, exam_schedule c " +
				 "WHERE b.subcl_id = :subcl_id and a.et_id = b.et_id and a.et_id = c.et_id and c.at_id = :at_id and "
				 + "c.es_fiscalyear = :academic_year and c.cl_id = :cl_id and c.sub_id = (select sub_id from subject_class_rel where subcl_id = :subcl_id) and "
				 + "b.rel_status = 'A' and c.es_status = 'A' and et_status = 'A'";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("subcl_id", subcl_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year)
				.setParameter("cl_id", cl_id);
		
		return (List<ExamsType>)query.list();
	}

}
