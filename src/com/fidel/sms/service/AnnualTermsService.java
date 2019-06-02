package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.AnnualTerms;

public interface AnnualTermsService {

	public List<AnnualTerms> getAllAnnualTermsList();
	
	public List<AnnualTerms> getActiveAnnualTermsList();
	
	public AnnualTerms getAnnualTermsByAt_id(int at_id);
	
	public boolean saveAnnualTerms(AnnualTerms annualTerms);
	
	public boolean updateAnnualTerms(AnnualTerms annualTerms);
}
