package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.AttendanceDao;
import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.ClassTypeClassDetailRelation;
import com.fidel.sms.model.DAAttendanceType;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AttendanceDaoImpl(){}
	
	public AttendanceDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DAAttendanceType> getActiveAttendanceTypeList() {

		Query query = sessionFactory.openSession().createQuery("FROM DAAttendanceType WHERE attype_status = 'A'");
		
		return (List<DAAttendanceType>)query.list();
	}

	@Override
	public List<AnnualTerms> getActiveAnnualQuarters() {

		Query query = sessionFactory.openSession().createQuery("FROM AnnualTerms WHERE at_status = 'A'");
		
		return (List<AnnualTerms>)query.list();
	}

	@Override
	public Integer getClassCapacity(int cl_id, int cd_id) {

		final String hql = "FROM ClassTypeClassDetailRelation WHERE cl_id = :cl_id and cd_id = :cd_id and rel_status = 'Active'";
		
		Query query = sessionFactory.openSession().createQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id);
		
		List<ClassTypeClassDetailRelation> cTypeCDetailRel = (List<ClassTypeClassDetailRelation>)query.list();
		
		if(cTypeCDetailRel.size() > 0){
			return cTypeCDetailRel.get(0).getClass_capacity();
		}
		return 0;
	}

	@Override
	public List<StudentInformation> getAbsentStudentListByCl_idCD_idDate(int cl_id, int cd_id, String attendance_date) {

		final String getAbsentStudentList = "SELECT a.att_id, a.si_id, b.fname, b.mname, b.gname, a.att_date, a.att_reason "
				+ "FROM da_attendance a, stud_information b "
				+ "WHERE a.clcd_id in (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id and cd_id = :cd_id) and a.att_date = :att_date and a.si_id = b.si_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(getAbsentStudentList)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("att_date", attendance_date);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getAggregateStudentAbsentListByCl_idCD_idAt_id(int cl_id, int cd_id, int at_id) {

		final String getAbsentStudentList = "SELECT b.SI_ID, b.FNAME, b.MNAME, b.GNAME, group_concat(att_date) attendance_date "
										+ "FROM stud_registration c, stud_information b left join da_attendance a on a.SI_ID = b.SI_ID and a.academic_year = :academic_year and a.att_status = 'A' and a.att_reason = 'N' and a.at_id = :at_id "
										+ "WHERE c.SI_ID = b.SI_ID and c.CLCD_ID in (select CLCD_ID from clist_cdetail_rel where CL_ID = :cl_id and cd_id = :cd_id) and c.ACADEMIC_YEAR = :academic_year "
										+ "group by si_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(getAbsentStudentList)
				.setParameter("at_id", at_id)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		return (List<StudentInformation>)query.list();
	}

	
	
	
	
	///*** Admin - Attendance Type ***///
	@Override
	public List<DAAttendanceType> getAllAttendanceTypeList() {

		Query query = sessionFactory.openSession().createQuery("FROM DAAttendanceType");
		
		return (List<DAAttendanceType>)query.list();
	}

}
