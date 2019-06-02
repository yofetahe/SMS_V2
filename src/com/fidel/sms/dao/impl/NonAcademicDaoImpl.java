package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.NonAcademicDao;
import com.fidel.sms.model.NonAcadmicEmployeeInformation;

@Service
public class NonAcademicDaoImpl implements NonAcademicDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<NonAcadmicEmployeeInformation> getNonAcadmicStuffList() {
		
		Query query = sessionFactory.openSession().createQuery("FROM NonAcadmicEmployeeInformation");
		
		return (List<NonAcadmicEmployeeInformation>)query.list();
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public NonAcadmicEmployeeInformation getNonAcadmicStuffInfoByNti_id(int nti_id) {

		Query query = sessionFactory.openSession().createQuery("FROM NonAcadmicEmployeeInformation WHERE nti_id = :nti_id").setParameter("nti_id", nti_id);
		
		List<NonAcadmicEmployeeInformation> nonAcademicStuff = (List<NonAcadmicEmployeeInformation>)query.list();
		
		NonAcadmicEmployeeInformation nonAcaStuff = new NonAcadmicEmployeeInformation();
		
		for(int i = 0; i < nonAcademicStuff.size(); i++){
			
			nonAcaStuff.setNti_id(nonAcademicStuff.get(i).getNti_id());
			nonAcaStuff.setNti_fname(nonAcademicStuff.get(i).getNti_fname());
			nonAcaStuff.setNti_mname(nonAcademicStuff.get(i).getNti_mname());
			nonAcaStuff.setNti_gname(nonAcademicStuff.get(i).getNti_gname());
			nonAcaStuff.setNti_sex(nonAcademicStuff.get(i).getNti_sex());
			nonAcaStuff.setNti_email(nonAcademicStuff.get(i).getNti_email());
			nonAcaStuff.setNti_position(nonAcademicStuff.get(i).getNti_position());
			nonAcaStuff.setNti_id_no(nonAcademicStuff.get(i).getNti_id_no());
			nonAcaStuff.setNti_status(nonAcademicStuff.get(i).getNti_status());
		}
		
		return nonAcaStuff;
	}

}
