package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.ClassTypeDao;
import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;

@Repository
public class ClassTypeDaoImpl implements ClassTypeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ClassTypeDaoImpl(){}
	
	public ClassTypeDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ClassType> getActiveClassList() {

		Query query = sessionFactory.openSession().createQuery("FROM ClassType WHERE class_status = 'Active'");
		
		return (List<ClassType>)query.list();
	}

	@Override
	public List<ClassType> getAllClassList() {

		Query query = sessionFactory.openSession().createQuery("FROM ClassType");
		
		return (List<ClassType>)query.list();
	}
	
	@Override
	public ClassType getClassTypeByCl_id(int cl_id) {

		Query query = sessionFactory.openSession().createQuery("FROM ClassType WHERE cl_id = :cl_id").setParameter("cl_id", cl_id);
		
		List<ClassType> classType = (List<ClassType>)query.list();
		
		ClassType ctype = new ClassType();
		
		for(ClassType ct : classType){
			
			ctype.setClass_name(ct.getClass_name());
			
			ctype.setCl_id(ct.getCl_id());
		}
		
		return ctype;
	}
	
	@Override
	public List<ClassDetail> getNotFilteredClassDetailPerSelectedClass(int cl_id) {
		
		final String classDetailList = "SELECT a.cd_id, a.cd_name, b.class_name " +
				"FROM class_detail a, class_list b, clist_cdetail_rel c " +
				"WHERE a.cd_id = c.cd_id and b.cl_id = c.cl_id and b.cl_id = :cl_id and c.rel_status = 'Active' ";
		
		Query query = sessionFactory.openSession().createSQLQuery(classDetailList).setParameter("cl_id", cl_id);
		
		return (List<ClassDetail>)query.list();
	}

	@Override
	public List<ClassDetail> getFilteredClassDetailUnderSelectedClass(int cl_id, int cd_id) {
		
		final String classDetailList = "FROM ClassDetail a WHERE a.cd_id in (select c.cd_id from ClassTypeClassDetailRelation c where c.cl_id = :cl_id and c.cd_id <> :cd_id and c.rel_status = 'Active') ";
		
		Query query = sessionFactory.openSession().createQuery(classDetailList)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id);
		
		return (List<ClassDetail>)query.list();
	}

	@Override
	public List<ClassType> getClassListOtherThanCurrentClass(int cl_id) {
		
		Query query = sessionFactory.openSession().createQuery("FROM ClassType WHERE class_status = 'Active' and cl_id <> :cl_id")
				.setParameter("cl_id", cl_id);
		
		return (List<ClassType>)query.list();
	}

	@Override
	public List<ClassDetail> getClassDetailListByCl_id(int cl_id) {
		System.out.println(cl_id);
		final String classDetailList = "FROM ClassDetail a WHERE a.cd_id in (select c.cd_id from ClassTypeClassDetailRelation c where c.cl_id = :cl_id and c.rel_status = 'Active') ";
		
		Query query = sessionFactory.openSession().createQuery(classDetailList)
				.setParameter("cl_id", cl_id);
		
		return (List<ClassDetail>)query.list();
	}

	@Override
	public List<ClassDetail> getAllClassDetail() {

		Query query = sessionFactory.openSession().createQuery("FROM ClassDetail");
		
		return (List<ClassDetail>)query.list();
	}

	@Override
	public List<ClassDetail> getRelatedClassDetailByCl_id(int cl_id) {

		final String hql = "SELECT a.clcd_id, b.cd_name, a.cl_capacity, a.rel_status "
						+ "FROM clist_cdetail_rel a, class_detail b "
						+ "WHERE a.cd_id = b.cd_id and a.cl_id = :cl_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id);
		
		return (List<ClassDetail>)query.list();
	}

	@Override
	public List<SubjectType> getRelatedSubjectByCl_id(int cl_id) {

		final String hql = "SELECT a.subcl_id, b.sub_name, a.add_status, a.convert_to_grade, a.sub_id, a.cl_id, a.rel_status "
				+ "FROM subject_class_rel a, subject_list b "
				+ "WHERE a.sub_id = b.sub_id and cl_id = :cl_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id);
		
		return (List<SubjectType>)query.list();
	}

	@Override
	public List<SubjectType> getUnrelatedSubjectByCl_id(int cl_id) {

		final String hql = "SELECT sub_id, sub_name "
				+ "FROM subject_list "
				+ "WHERE sub_id not in (SELECT b.sub_id FROM subject_list b, subject_class_rel a WHERE a.sub_id = b.sub_id and a.cl_id = :cl_id and a.rel_status = 'A') and sub_status = 'A'";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id);
		
		return (List<SubjectType>)query.list();
	}

	@Override
	public List<ExamsType> getRelatedExamTypeBySubCl_id(int subcl_id) {

		final String hql = "SELECT b.exsub_id, a.et_id, a.et_name, a.et_status, b.total_mark, b.pass_mark, b.rel_status " +
				"FROM exams_type a, exam_sub_rel b " +
				"WHERE b.subcl_id = :subcl_id and a.et_id = b.et_id and a.et_status = 'A'";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("subcl_id", subcl_id);
		
		return (List<ExamsType>)query.list();
	}

	@Override
	public List<ExamGrade> getRelatedExamGradingBySubCl_id(int subcl_id) {
		
		final String hql = "SELECT a.escg_id, a.subcl_id, a.eg_id, b.eg_value, a.grade_from, a.grade_to, a.escg_status "
				+ "FROM exam_subcl_grade_rel a, exam_grade b "
				+ "WHERE subcl_id = :subcl_id and a.eg_id = b.eg_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("subcl_id", subcl_id);
		
		return (List<ExamGrade>)query.list();
	}

	@Override
	public ClassDetail getClassDetailByCd_id(int cd_id) {

		Query query = sessionFactory.openSession().createQuery("FROM ClassDetail WHERE cd_id = :cd_id").setParameter("cd_id", cd_id);
		
		List<ClassDetail> classDetail = (List<ClassDetail>)query.list();
		
		ClassDetail cdetail = new ClassDetail();
		
		for(ClassDetail ct : classDetail){
			
			cdetail.setCd_id(ct.getCd_id());
			
			cdetail.setCd_name(ct.getCd_name());
		}
		
		return cdetail;
	}

}
