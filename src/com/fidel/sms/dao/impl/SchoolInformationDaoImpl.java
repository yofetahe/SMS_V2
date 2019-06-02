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

import com.fidel.sms.dao.SchoolInformationDao;
import com.fidel.sms.model.SchoolInformation;
import com.fidel.sms.model.StudentPhotoInformation;

@Repository
public class SchoolInformationDaoImpl implements SchoolInformationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SchoolInformationDaoImpl(){}
	
	public SchoolInformationDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SchoolInformation getSchoolInformation() {

		Query query = sessionFactory.openSession().createQuery("FROM SchoolInformation");
		
		List<SchoolInformation> schoolInfo = (List<SchoolInformation>)query.list();
		
		SchoolInformation sinfo = new SchoolInformation();
		
		for(int i = 0; i < schoolInfo.size(); i++){
			
			sinfo.setSch_inf_id(schoolInfo.get(i).getSch_inf_id());
			sinfo.setSchool_name(schoolInfo.get(i).getSchool_name());
			sinfo.setSlogan(schoolInfo.get(i).getSlogan());
			sinfo.setTin_num(schoolInfo.get(i).getTin_num());
			sinfo.setTelephone(schoolInfo.get(i).getTelephone());
			sinfo.setFax(schoolInfo.get(i).getFax());
			sinfo.setWeb(schoolInfo.get(i).getWeb());
			sinfo.setEmail(schoolInfo.get(i).getEmail());
			sinfo.setPobox(schoolInfo.get(i).getPobox());
			sinfo.setFiscal_machine_no(schoolInfo.get(i).getFiscal_machine_no());
			sinfo.setSch_inf_status(schoolInfo.get(i).getSch_inf_status());
		}
		
		return sinfo;
	}

	@Override
	public byte[] getOrganizationLogoById(int sch_inf_id) {

		final String getSchoolLogo = "FROM SchoolInformation WHERE sch_inf_id = :sch_inf_id";
		
		Query query = sessionFactory.openSession().createQuery(getSchoolLogo).setParameter("sch_inf_id", sch_inf_id);
		
		List<SchoolInformation> schoolLogo = (List<SchoolInformation>)query.list();
		
		byte[] rslt = null;
		
		if(schoolLogo.size() > 0){

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			byte[] buf = new byte[1024];
			
			byte[] logo = schoolLogo.get(0).getSchool_logo();
			
			InputStream in;
			
			try {
				
				Blob b = new SerialBlob(logo);
				
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

}
