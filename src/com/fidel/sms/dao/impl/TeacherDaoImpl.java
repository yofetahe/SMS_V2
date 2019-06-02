package com.fidel.sms.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.TeacherDao;
import com.fidel.sms.model.StudentPhotoInformation;
import com.fidel.sms.model.TeacherAssignment;
import com.fidel.sms.model.TeacherCurrentAddress;
import com.fidel.sms.model.TeacherDisciplinaryAction;
import com.fidel.sms.model.TeacherEducationBackground;
import com.fidel.sms.model.TeacherEmergencyContact;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.model.TeacherPhotoInformation;
import com.fidel.sms.model.TeacherReward;
import com.fidel.sms.model.TeacherWorkExperience;

@Repository
public class TeacherDaoImpl implements TeacherDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TeacherInformation> getActiveTeacherList() {

		final String hql = "FROM TeacherInformation WHERE ti_status = 'A'";
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		return (List<TeacherInformation>)query.list();
	}

	@Override
	public List<TeacherInformation> getInactiveTeacherList() {

		final String hql = "FROM TeacherInformation WHERE ti_status = 'I'";
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		return (List<TeacherInformation>)query.list();
	}

	@Override
	public TeacherInformation getTeacherInformationByTi_id(int ti_id) {

		final String hql = "FROM TeacherInformation WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		List<TeacherInformation> teacher = (List<TeacherInformation>)query.list();
		
		TeacherInformation teach = new TeacherInformation();
		
		for(int i = 0; i < teacher.size(); i++){
			
			teach.setTi_id(teacher.get(i).getTi_id());
			teach.setFname(teacher.get(i).getFname());
			teach.setMname(teacher.get(i).getMname());
			teach.setGname(teacher.get(i).getGname());
			teach.setSex(teacher.get(i).getSex());
			teach.setDob(teacher.get(i).getDob());
			teach.setPob(teacher.get(i).getPob());
			teach.setId_no(teacher.get(i).getId_no());
			teach.setTi_status(teacher.get(i).getTi_status());
		}
		
		return teach;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public byte[] getTeacherPhotoByTiid(int ti_id) {

		final String getStudentPhoto = "FROM TeacherPhotoInformation WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(getStudentPhoto).setParameter("ti_id", ti_id);
		
		List<TeacherPhotoInformation> teacherPhoto = (List<TeacherPhotoInformation>)query.list();
		
		byte[] rslt = null;
		
		if(teacherPhoto.size() > 0){

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			byte[] buf = new byte[1024];
			
			byte[] pic = teacherPhoto.get(0).getTeacher_photo();
			
			InputStream in;
			
			try {
				
				Blob b = new SerialBlob(pic);
				
				in = b.getBinaryStream();
			
				int n = 0;
				
				while((n = in.read(buf)) >= 0){
					
					baos.write(buf, 0, n);
				}
				
				in.close();
				
				rslt = baos.toByteArray();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return rslt;
	}

	@Override
	public List<TeacherEducationBackground> getTeacherEducationalBackgroundByTi_id(int ti_id) {

		final String hql = "FROM TeacherEducationBackground WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		return (List<TeacherEducationBackground>)query.list();
	}

	
	
	
	
	
	
	
	@Override
	public List<TeacherWorkExperience> getTeacherWorkExperienceByTi_id(int ti_id) {

		final String hql = "FROM TeacherWorkExperience WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		return (List<TeacherWorkExperience>)query.list();
	}

	
	
	
	
	
	
	@Override
	public TeacherCurrentAddress getTeacherCurrentAddressByTi_id(int ti_id) {

		final String hql = "FROM TeacherCurrentAddress WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		List<TeacherCurrentAddress> current_address = (List<TeacherCurrentAddress>)query.list();
		
		TeacherCurrentAddress currentAddress = new TeacherCurrentAddress();
		
		for(int i = 0; i < current_address.size(); i++){
			
			currentAddress.setTca_id(current_address.get(i).getTca_id());
			currentAddress.setEmail(current_address.get(i).getEmail());
			currentAddress.setHouse_no(current_address.get(i).getHouse_no());
			currentAddress.setHouse_phone_no(current_address.get(i).getHouse_phone_no());
			currentAddress.setKebele(current_address.get(i).getKebele());
			currentAddress.setMobile_no(current_address.get(i).getMobile_no());
			currentAddress.setSub_city(current_address.get(i).getSub_city());
			currentAddress.setTca_status(current_address.get(i).getTca_status());
			currentAddress.setTi_id(current_address.get(i).getTi_id());
		}
		
		return currentAddress;
	}
	
	
	
	

	@Override
	public TeacherEmergencyContact getTeacherEmergencyContactByTi_id(int ti_id) {

		final String hql = "FROM TeacherEmergencyContact WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		List<TeacherEmergencyContact> emergency_contact = (List<TeacherEmergencyContact>)query.list();
		
		TeacherEmergencyContact emergencyContact = new TeacherEmergencyContact();
		
		for(int i = 0; i < emergency_contact.size(); i++){
			
			emergencyContact.setCont_name(emergency_contact.get(i).getCont_name());
			emergencyContact.setRelationship(emergency_contact.get(i).getRelationship());
			emergencyContact.setHome_phone_no(emergency_contact.get(i).getHome_phone_no());
			emergencyContact.setMobile_no(emergency_contact.get(i).getMobile_no());
			emergencyContact.setOffice_phone_no(emergency_contact.get(i).getOffice_phone_no());
			emergencyContact.setTec_id(emergency_contact.get(i).getTec_id());
		}
		
		return emergencyContact;
	}
	
	
	
	

	@Override
	public List<TeacherReward> getTeacherRewardListByTi_id(int ti_id) {

		final String hql = "FROM TeacherReward WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		return (List<TeacherReward>)query.list();
	}

	@Override
	public List<TeacherDisciplinaryAction> getTeacherDisciplinaryActionByTi_id(int ti_id) {

		final String hql = "FROM TeacherDisciplinaryAction WHERE ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("ti_id", ti_id);
		
		return (List<TeacherDisciplinaryAction>)query.list();
	}

	
	
	
	@Override
	public List<TeacherAssignment> getTeacherClassSubjectAssignmentByTi_id(int ti_id) {
		
		final String hql = "SELECT a.ta_id, a.sub_id, b.SUB_NAME, a.cl_id, c.CLASS_NAME, a.year, a.ta_status "
						+ "FROM tech_assignment a, subject_list b, class_list c "
						+ "WHERE a.sub_id = b.SUB_ID and a.cl_id = c.CL_ID and a.ti_id = :ti_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql).setParameter("ti_id", ti_id);
		
		return (List<TeacherAssignment>)query.list();
	}

	@Override
	public List<TeacherHomeRoomAssignment> getAssignedHomeRoomTeacherListByAcademic_year(int academic_year) {
		
		final String hql = "SELECT a.thra_id, a.ti_id, concat(b.fname, ' ', b.mname, ' ', b.gname), a.cl_id, c.class_name, a.cd_id, d.cd_name, a.thra_status " +
				"FROM tech_hroom_assignment a, teacher_information b, class_list c, class_detail d " +
				"WHERE a.academic_year = :academic_year and a.ti_id = b.ti_id and a.cl_id = c.cl_id and a.cd_id = d.cd_id "
				+ "ORDER BY cl_id, cd_id";

		Query query = sessionFactory.openSession().createSQLQuery(hql).setParameter("academic_year", 2009);
		
		return (List<TeacherHomeRoomAssignment>)query.list();
	}

}
