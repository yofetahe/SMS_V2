package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.AnnualTermsDao;
import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.service.AnnualTermsService;

@Service
public class AnnualTermsServiceImpl implements AnnualTermsService {
	
	@Autowired
	AnnualTermsDao annualTermDao;

	@Override
	public List<AnnualTerms> getAllAnnualTermsList() {
		
		return annualTermDao.getAllAnnualTermsList();
	}

	@Override
	public List<AnnualTerms> getActiveAnnualTermsList() {
		
		return annualTermDao.getActiveAnnualTermsList();
	}

	@Override
	public AnnualTerms getAnnualTermsByAt_id(int at_id) {
		
		return annualTermDao.getAnnualTermsByAt_id(at_id);
	}

	@Override
	public boolean saveAnnualTerms(AnnualTerms annualTerms) {
		
		return annualTermDao.saveAnnualTerms(annualTerms);
	}

	@Override
	public boolean updateAnnualTerms(AnnualTerms annualTerms) {
		
		return annualTermDao.updateAnnualTerms(annualTerms);
	}

}
