package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.ExamScheduleDao;
import com.fidel.sms.model.ExamSchedule;

@Repository
public class ExamScheduleDaoImpl implements ExamScheduleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ExamScheduleDaoImpl(){}
	
	public ExamScheduleDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ExamSchedule> getExamScheduleByCl_idAt_idAcademic_year(int cl_id, int at_id, int academic_year) {

		final String hql = "SELECT a.es_id, a.et_id, a.cl_id, a.es_ethio_date, a.es_greg_date, e.at_name, a.es_status, b.class_name, c.et_name, d.sub_id, d.sub_name, a.time_from, a.time_to " +
				"FROM exam_schedule a, class_list b, exams_type c, subject_list d, annual_terms e " +
				"where a.cl_id = b.cl_id and a.et_id = c.et_id and a.sub_id = d.sub_id and a.cl_id = :cl_id and a.at_id = e.at_id and a.es_fiscalyear = :academic_year and a.at_id = :at_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year);
		
		return (List<ExamSchedule>)query.list();
	}

}
