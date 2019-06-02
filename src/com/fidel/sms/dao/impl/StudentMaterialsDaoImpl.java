package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.StudentMaterialsDao;
import com.fidel.sms.model.PaymentMaterialClassRelation;
import com.fidel.sms.model.PaymentTypeMaterialList;
import com.fidel.sms.model.StudentMaterials;

@Repository
public class StudentMaterialsDaoImpl implements StudentMaterialsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public StudentMaterialsDaoImpl(){}
	
	public StudentMaterialsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<PaymentTypeMaterialList> getAllStudentMaterialList() {

		Query query = sessionFactory.openSession().createQuery("FROM PaymentTypeMaterialList");
		
		return (List<PaymentTypeMaterialList>)query.list();
	}

	@Override
	public List<PaymentMaterialClassRelation> getAllClassMaterialRelationList() {

		final String hql = "SELECT  b.cl_id, b.class_name, c.ptm_id, c.ptm_name, a.pmc_id, a.pmc_status, a.pay_amount " +
				"FROM payment_material_class_rel a, class_list b, payment_type_material_list c " +
				"WHERE a.cl_id = b.cl_id and c.ptm_id = a.ptm_id " +
				"ORDER BY b.cl_id";

		Query query = sessionFactory.openSession().createSQLQuery(hql);
		
		return (List<PaymentMaterialClassRelation>)query.list();		
	}

}
