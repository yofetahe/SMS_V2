package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.SystemURL;

public interface SystemURLService {
	
	public List<SystemURL> getRelatedModule(int m_id, int ur_id);
	
	public List<SystemURL> getUnrelatedModule(int m_id, int ur_id);
	
	public List<SystemURL> getAuthenticatedURL(String user_name);
	
	public List<SystemURL> getAllURL();

}
