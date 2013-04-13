package com.admin.action;

import java.sql.Connection;
import java.util.ArrayList;
import org.apache.log4j.*;

import com.admin.utils.*;

public class CityOperations {
	static Logger log4j = Logger.getLogger(CityOperations.class.getName());
	private String cityName;
	private int cityID;
	private ArrayList<CityOperations> cities;
	
	public ArrayList<CityOperations> getCities() {
		return cities;
	}

	public void setCities(ArrayList<CityOperations> cities) {
		this.cities = cities;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String cityOpPanel(){
		log4j.info("=============LOADING ADD CITY BODY============");
		log4j.debug("===========Currently in cityOpPanel method===========");
		return "success";
	}
	
	public String addNewCity(){
		log4j.info("=============CURRENTLY IN ADD CITY BODY============");
		log4j.debug("===========Currently in addNewCity method===========");
		int result = 0;
		try{
			Connection con=DBManager.getConnection();
			result = CityDbControl.addNewCity(con, cityName);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------City add failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Add new city failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Add new city success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
	}
	
	public String displayCities(){
		
		log4j.info("=============CURRENTLY IN VIEW CITIES BODY============");
		log4j.debug("===========Currently in displayCities method===========");		
		cities= new ArrayList<CityOperations>();
		try{
			Connection con=DBManager.getConnection();
			cities = CityDbControl.getCities(con);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------City view failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (cities==null){
			log4j.info("-----------View cities error---------");
			return "error";
		}
		else{
			log4j.info("--------View cities success---------");
			return "success";
		}
		
	}
	
	public String getCityToModify(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED CITY BODY============");
		log4j.debug("===========Currently in getCityToModify method===========");	
		CityOperations cityOp = new CityOperations();
		int id = getCityID();
		log4j.info("City ID value: "+id);		
		try{
			Connection con=DBManager.getConnection();
			cityOp = CityDbControl.getCityRecord(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (cityOp==null){
			log4j.info("-----------get city record error---------");
			return "error";
		}
		else{
			setCityID(cityOp.getCityID());
			setCityName(cityOp.getCityName());
			log4j.info("setting City ID value as "+getCityID());
			log4j.info("setting City Name value as "+getCityName());
			log4j.info("--------get city record success---------");
			return "success";
		}
	}
	
	public String updateModifiedCity(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED CITY BODY============");
		log4j.debug("===========Currently in updateModifiedCity method===========");			
		CityOperations cityOp = new CityOperations();
		int id = getCityID();
		String city = getCityName();
		cityOp.setCityID(id);
		cityOp.setCityName(city);
		log4j.info("retrieved City ID value is "+cityOp.getCityID());
		log4j.info("new City Name value is "+cityOp.getCityName());
		
		int result = 0;
		try{
			Connection con=DBManager.getConnection();
			result = CityDbControl.setCityRecord(con, cityOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Update modified city failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Update modified city success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
			
	}
	
	public String deleteCity(){
		
		log4j.info("=============CURRENTLY IN VIEW CITIES BODY============");
		log4j.debug("===========Currently in deleteCity method===========");		
		int result = 0;
		int id = getCityID();
		log4j.info("City ID to be deleted is: "+id);
		
		try{
			Connection con=DBManager.getConnection();
			result = CityDbControl.deleteCity(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Delete city failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Delete city success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
		
	}

}
