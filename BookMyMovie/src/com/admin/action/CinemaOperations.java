package com.admin.action;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.utils.CinemaDbControl;
import com.admin.utils.DBManager;

public class CinemaOperations {
	
	static Logger log4j = Logger.getLogger(CinemaOperations.class.getName());
	private int cinemaID;
	private String cinemaName;
	private String address;
	private int cityID;
	private int rating;
	private int numOfScreens;
	private int capacity;
	
	private ArrayList<CinemaOperations> cinemaTheatres;
	

	public int getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getNumOfScreens() {
		return numOfScreens;
	}
	
	public void setNumOfScreens(int numOfScreens) {
		this.numOfScreens = numOfScreens;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<CinemaOperations> getCinemaTheatres() {
		return cinemaTheatres;
	}
 
	public void setCinemaTheatres(ArrayList<CinemaOperations> cinemaTheatres) {
		this.cinemaTheatres = cinemaTheatres;
	}

	public String cinemaOpPanel(){
		log4j.info("=============LOADING ADD CINEMA BODY============");
		log4j.debug("===========Currently in cinemaOpPanel method===========");
		return "success";
	}
	
	public String addNewCinema(){
		
		log4j.info("=============CURRENTLY IN ADD CINEMA BODY============");
		log4j.debug("===========Currently in addNewCinema method===========");
		int result = 0;
		CinemaOperations cinOp = new CinemaOperations();
		cinOp.setCinemaID(getCinemaID());
		cinOp.setCinemaName(getCinemaName());
		cinOp.setAddress(getAddress());
		cinOp.setCityID(getCityID());
		cinOp.setRating(getRating());
		cinOp.setNumOfScreens(getNumOfScreens());
		cinOp.setCapacity(getCapacity());
		
		try{
			Connection con=DBManager.getConnection();
			result = CinemaDbControl.addNewCinema(con, cinOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Cinema add failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Add new cinema failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Add new cinema success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
	}
	
	public String displayCinemaTheatres(){
		
		log4j.info("=============CURRENTLY IN VIEW CINEMA THEATRES BODY============");
		log4j.debug("===========Currently in displayCinemaTheatres method===========");		
		cinemaTheatres= new ArrayList<CinemaOperations>();
		
		try{
			Connection con=DBManager.getConnection();
			cinemaTheatres = CinemaDbControl.getCinemaTheatres(con);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Cinema view failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (cinemaTheatres==null){
			log4j.info("-----------View cinemas error---------");
			return "error";
		}
		else{
			log4j.info("--------View cinemas success---------");
			return "success";
		}
		
	}
	
	public String getCinemaToModify(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED CINEMA BODY============");
		log4j.debug("===========Currently in getCinemaToModify method===========");	
		CinemaOperations cinOp = new CinemaOperations();
		int id = getCinemaID();
		log4j.info("Cinema ID value: "+id);		
		try{
			Connection con=DBManager.getConnection();
			cinOp = CinemaDbControl.getCinemaRecord(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (cinOp==null){
			log4j.info("-----------get cinema record error---------");
			return "error";
		}
		else{
			
			setCinemaID(cinOp.getCinemaID());
			setCinemaName(cinOp.getCinemaName());
			setAddress(cinOp.getAddress());
			setCityID(cinOp.getCityID());
			setRating(cinOp.getRating());
			setNumOfScreens(cinOp.getNumOfScreens());
			setCapacity(cinOp.getCapacity());
			
			log4j.info("setting Cinema ID value as "+getCinemaID());
			log4j.info("setting Cinema Name value as "+getCinemaName());
			log4j.info("setting Cinema address value as "+getAddress());
			log4j.info("setting City ID value as "+getCityID());
			log4j.info("setting rating value as "+getRating());
			log4j.info("setting numOfScreens value as "+getNumOfScreens());
			log4j.info("setting capacity value as "+getCapacity());
			log4j.info("--------get cinema record success---------");
			return "success";
		}
	}
	
	public String updateModifiedCinema(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED CINEMA BODY============");
		log4j.debug("===========Currently in updateModifiedCinema method===========");			
		
		CinemaOperations cinOp = new CinemaOperations();
		int id = getCinemaID();
		String cinema = getCinemaName();
		String address = getAddress();
		int cityId = getCityID();
		int rating = getRating();
		int screens = getNumOfScreens();
		int capacity = getCapacity();
		
		cinOp.setCinemaID(id);
		cinOp.setCinemaName(cinema);
		cinOp.setAddress(address);
		cinOp.setCityID(cityId);
		cinOp.setRating(rating);
		cinOp.setNumOfScreens(screens);
		cinOp.setCapacity(capacity);
		
		log4j.info("retrieved Cinema ID value as "+cinOp.getCinemaID());
		log4j.info("updating Cinema Name value as "+cinOp.getCinemaName());
		log4j.info("updating Cinema address value as "+cinOp.getAddress());
		log4j.info("updating City ID value as "+cinOp.getCityID());
		log4j.info("updating rating value as "+cinOp.getRating());
		log4j.info("updating numOfScreens value as "+cinOp.getNumOfScreens());
		log4j.info("updating capacity value as "+cinOp.getCapacity());
		
		int result = 0;
		try{
			Connection con=DBManager.getConnection();
			result = CinemaDbControl.setCinemaRecord(con, cinOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Update modified cinema failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Update modified cinema success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
			
	}
	
	public String deleteCinema(){
		
		log4j.info("=============CURRENTLY IN VIEW CINEMA THEATRES BODY============");
		log4j.debug("===========Currently in deleteCinema method===========");
		
		int result = 0;
		int id = getCinemaID();
		log4j.info("Cinema ID to be deleted is: "+id);
		
		try{
			Connection con=DBManager.getConnection();
			result = CinemaDbControl.deleteCinema(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Delete cinema failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Delete cinema success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
		
	}

}
