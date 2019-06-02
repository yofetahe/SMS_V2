package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.BehaviouralEvaluationDao;
import com.fidel.sms.model.BEvaluationStudentResult;
import com.fidel.sms.model.BEvaluationTraits;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Repository
public class BehaviouralEvaluationDaoImpl implements BehaviouralEvaluationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BehaviouralEvaluationDaoImpl(){}
	
	public BehaviouralEvaluationDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<BEvaluationStudentResult> getStudentEvaluationResultBySi_idCl_id(int si_id, int cl_id, int at_id, int academic_year) {

		final String hql = "SELECT a.bsr_id, a.bt_id, b.bt_title, a.bg_id, d.bg_name, a.academic_year, a.qr_id, c.at_name, a.bsr_status "
			+ "FROM beval_stud_result a, beval_traits b, beval_grade d, annual_terms c "
			+ "WHERE a.bt_id = b.bt_id and a.qr_id = c.at_id and a.bg_id = d.bg_id and a.bsr_status != 'I' and "
			+ "a.cl_id = :cl_id and a.si_id = :si_id and a.academic_year = :academic_year and a.qr_id = :at_id "
			+ "ORDER BY a.bt_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("si_id", si_id)
				.setParameter("cl_id", cl_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year);
		
		return (List<BEvaluationStudentResult>)query.list();
	}

	@Override
	public List<BEvaluationTraits> getBehavioralEvalTraints(int si_id, int cl_id, int at_id) {
		
		final String hql = "SELECT a.bt_id, b.bt_title " +
				"FROM btraits_class_rel a, beval_traits b " +
				"WHERE a.bt_id = b.bt_id and a.cl_id = :cl_id and a.bt_id not in (SELECT bt_id FROM beval_stud_result WHERE cl_id = :cl_id and si_id = :si_id and academic_year = :academic_year and qr_id = :at_id )";
		
		final String hql2 = "SELECT a.bt_id, b.bt_title, group_concat(d.bg_id), group_concat(d.bg_name) "
				+ "FROM btraits_class_rel a, beval_traits b, btraits_bgrades_rel c, beval_grade d "
				+ "WHERE a.bt_id = b.bt_id and b.bt_id = c.bt_id and c.bg_id = d.bg_id and a.cl_id = :cl_id and "
				+ "a.bt_id not in (SELECT bt_id FROM beval_stud_result WHERE cl_id = :cl_id and si_id = :si_id and academic_year = :academic_year and qr_id = :at_id) "
				+ "GROUP By bt_id "
				+ "ORDER BY b.bt_id, d.bg_name;";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql2)
				.setParameter("si_id", si_id)
				.setParameter("cl_id", cl_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		return (List<BEvaluationTraits>)query.list();
	}

}
