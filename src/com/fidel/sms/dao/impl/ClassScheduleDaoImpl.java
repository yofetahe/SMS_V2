package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.ClassScheduleDao;
import com.fidel.sms.model.ClassScheduleSubjectPeriodRelation;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Repository
public class ClassScheduleDaoImpl implements ClassScheduleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ClassScheduleDaoImpl(){}
	
	public ClassScheduleDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ClassScheduleSubjectPeriodRelation> getGeneralPeriodAssignmentByAcademicYear(int academic_year) {
		
		final String hql = "SELECT a.csp_id, b.class_name, c.sub_name, a.period_per_week, a.academic_year "
				+ "FROM class_sched_subject_period_rel a, class_list b, subject_list c "
				+ "WHERE a.cl_id = b.cl_id and a.sub_id = c.sub_id and a.academic_year = :academic_year "
				+ "ORDER BY academic_year desc";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("academic_year", academic_year);
		
		return (List<ClassScheduleSubjectPeriodRelation>)query.list();
	}

	@Override
	public boolean saveClassPeriodAllotment(ClassScheduleSubjectPeriodRelation subjectAllotment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClassScheduleSubjectPeriodRelation getClassPeriodAllotmentByCsp_id(int csp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateClassPeriodAllotment(ClassScheduleSubjectPeriodRelation subjectAllotment) {
		// TODO Auto-generated method stub
		return false;
	}

}
