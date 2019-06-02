package com.fidel.sms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fidel.sms.utils.db_connection;

public class SystemValidator {
	
	public static String MACADD = "";
	
	public static boolean systemValidation(){
		
		//------- initial system validation ---------//
		boolean text_val = systemUniquenessValidation();
		
		
		//------- second system validation ---------//
		boolean rslt = false;
		
		//String mac_add = MacAddressGenerator.getMacAddress();
		
		List<String> macList = MacAddressGenerator.getMacAddressesList();
		
		try{
			
			File myDir = new File(SysConstant.SECURITY_FILE_PATH);
			myDir.getParentFile().mkdir();
			
			File file = new File(myDir, "smsPerformancePin.txt");
			
//			FileWriter fw = new FileWriter(file);
//			PrintWriter pw = new PrintWriter(fw);
//			pw.println(PasswordEncription.encrypt(macList.get(0))); 
//			pw.flush(); 
//			pw.close();
			
			if(!file.exists()){
				return rslt;
			}
			
			FileReader fr = new FileReader(file); 
			BufferedReader br = new BufferedReader(fr);
			MACADD = br.readLine();
			br.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		boolean physicalAddress_1 = false, physicalAddress_2 = false;
		
		String dec_macadd = "";
		
		try {
			dec_macadd = PasswordEncription.decrypt(MACADD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < macList.size(); i++){
			if(macList.get(i).equals(dec_macadd)){
				physicalAddress_1 = true;
			}
			if(SysConstant.MACADD_CONSTANT.equals(macList.get(i)) || SysConstant.MACADD_CONSTANT_2.equals(macList.get(i)) || SysConstant.MACADD_CONSTANT_3.equals(macList.get(i))  || SysConstant.MACADD_CONSTANT_4.equals(macList.get(i))){
				physicalAddress_2 = true;
			}
		}
		
		if(text_val && physicalAddress_1 && physicalAddress_2){
			rslt = true;
		}
		
		return rslt;
	}
	
	/*
	 * text file generator
	 * the file writer will be generated at the beginning of system installation only.
	 */
	public static boolean systemUniquenessValidation(){
		
		boolean rslt = false;
		
		StringBuilder organizationCode = encodeOrganizationName(SysConstant.ORGANIZATION_NAME);
		
		try{
			
			File myDir = new File(SysConstant.SECURITY_FILE_PATH);
			myDir.getParentFile().mkdir();
			
			File file = new File(myDir, "smsPerformanceChecker.txt");
			
//			if(!file.exists()){
//				
//				myDir.mkdir();
//				
//				FileWriter fw = new FileWriter(file);
//				PrintWriter pw = new PrintWriter(fw);
//				pw.println(PasswordEncription.encrypt(organizationCode.toString())); 
//				pw.flush(); 
//				pw.close();
//			}
			
			if(!file.exists()){
				return rslt;
			}
			
			FileReader fr = new FileReader(file); 
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			br.close();
			
			if(line.equals(PasswordEncription.encrypt(organizationCode.toString()))){
				rslt = true;
			}			
			
		} catch(Exception ex){
			ex.printStackTrace();
		} 
		
		return rslt;
	}
	
	/*
	 * Generate textual computer code
	 */
	public static StringBuilder encodeOrganizationName(String name){
		
		String nameGiven = name.toLowerCase().trim();
		
		StringBuilder encodeName = new StringBuilder();
		
		char[] alph = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		
		for(int i = 0; i < name.length(); i++){
			for(int j = 0; j < 26; j++){
				if(nameGiven.charAt(i) == alph[j] && j%2 == 0){
					encodeName.append(j + "-");
				} else if(nameGiven.charAt(i) == alph[j] && j%2 != 0){
					encodeName.append(i+j);
				}
			}
		}
		
		return encodeName;
	}
	
	/*
	 * Generate the table list exist on the database. 
	 */
	public static void datebaseSecurity(){
		
		DatabaseBackup.backupDataWithDatabase(SysConstant.DUMP_EXE_PATH, SysConstant.HOST, SysConstant.PORT, SysConstant.DATABASE_USERNAME, SysConstant.DATABASE_PASSWORD, SysConstant.SYS_NAME, SysConstant.DATABASE_BACKUP_FOLDER);
		
		try {
			
			Connection c = db_connection.getConnection();
			
			DatabaseMetaData md = c.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while(rs.next()){
				//System.out.println(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean fromUrlDatabaseBackup(){
		
		boolean rslt = DatabaseBackup.backupDataWithDatabase(SysConstant.DUMP_EXE_PATH, SysConstant.HOST, SysConstant.PORT, SysConstant.DATABASE_USERNAME, SysConstant.DATABASE_PASSWORD, SysConstant.DATABASE_NAME, SysConstant.DATABASE_BACKUP_FOLDER);
		return rslt;
	}
}