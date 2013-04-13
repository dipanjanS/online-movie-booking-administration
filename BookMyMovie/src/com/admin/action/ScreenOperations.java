package com.admin.action;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.utils.DBManager;
import com.admin.utils.ScreenDbControl;

public class ScreenOperations {
	
	static Logger log4j = Logger.getLogger(ScreenOperations.class.getName());
	private int screenID;
	private int cinemaID;
	private int screenNum;
	private int genCapacity;
	private int silverCapacity;
	private int goldCapacity;
	private int totalCapacity;
	private String cinemaName;
	private ArrayList<ScreenOperations> screens;

	public int getScreenID() {
		return screenID;
	}

	public void setScreenID(int screenID) {
		this.screenID = screenID;
	}

	public int getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public int getScreenNum() {
		return screenNum;
	}

	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
	}

	public int getGenCapacity() {
		return genCapacity;
	}

	public void setGenCapacity(int genCapacity) {
		this.genCapacity = genCapacity;
	}

	public int getSilverCapacity() {
		return silverCapacity;
	}

	public void setSilverCapacity(int silverCapacity) {
		this.silverCapacity = silverCapacity;
	}

	public int getGoldCapacity() {
		return goldCapacity;
	}

	public void setGoldCapacity(int goldCapacity) {
		this.goldCapacity = goldCapacity;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public ArrayList<ScreenOperations> getScreens() {
		return screens;
	}

	public void setScreens(ArrayList<ScreenOperations> screens) {
		this.screens = screens;
	}
	
	public String screenOpPanel(){
		log4j.info("=============LOADING ADD SCREEN BODY============");
		log4j.debug("===========Currently in screenOpPanel method===========");
		return "success";
	}
	
	public String addNewScreen(){
		
		log4j.info("=============CURRENTLY IN ADD SCREEN BODY============");
		log4j.debug("===========Currently in addNewScreen method===========");
		
		int result = 0;
		ScreenOperations scrOp = new ScreenOperations();
		
		scrOp.setScreenID(getScreenID());
		scrOp.setCinemaID(getCinemaID());
		scrOp.setScreenNum(getScreenNum());
		scrOp.setGenCapacity(getGenCapacity());
		scrOp.setSilverCapacity(getSilverCapacity());
		scrOp.setGoldCapacity(getGoldCapacity());
		scrOp.setTotalCapacity(getTotalCapacity());
		
		try{
			Connection con=DBManager.getConnection();
			result = ScreenDbControl.addNewScreen(con, scrOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Screen add failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Add new screen failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Add new screen success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
	}
	
	public String displayScreens(){
		
		log4j.info("=============CURRENTLY IN VIEW CINEMA SCREENS BODY============");
		log4j.debug("===========Currently in displayScreens method===========");		
		
		screens= new ArrayList<ScreenOperations>();
		
		try{
			Connection con=DBManager.getConnection();
			screens=ScreenDbControl.getScreens(con);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Screen view failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (screens==null){
			log4j.info("-----------View screens error---------");
			return "error";
		}
		else{
			log4j.info("--------View screens success---------");
			return "success";
		}
		
	}
	
	public String getScreenToModify(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED SCREEN BODY============");
		log4j.debug("===========Currently in getScreenToModify method===========");	
		
		ScreenOperations scrOp = new ScreenOperations();
		int id = getScreenID();
		log4j.info("Screen ID value: "+id);		
		try{
			Connection con=DBManager.getConnection();
			scrOp = ScreenDbControl.getScreenRecord(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (scrOp==null){
			log4j.info("-----------get screen record error---------");
			return "error";
		}
		else{
			
			setScreenID(scrOp.getScreenID());
			setCinemaID(scrOp.getCinemaID());
			setScreenNum(scrOp.getScreenNum());
			setGenCapacity(scrOp.getGenCapacity());
			setSilverCapacity(scrOp.getSilverCapacity());
			setGoldCapacity(scrOp.getGoldCapacity());
			setTotalCapacity(scrOp.getTotalCapacity());
			
			log4j.info("setting Screen ID value as "+getScreenID());
			log4j.info("setting Cinema ID value as "+getCinemaID());
			log4j.info("setting Screen Number value as "+getScreenNum());
			log4j.info("setting general class capacity value as "+getGenCapacity());
			log4j.info("setting silver class capacity value as "+getSilverCapacity());
			log4j.info("setting gold class capacity value as "+getGoldCapacity());
			log4j.info("setting total class capacity value as "+getTotalCapacity());
			log4j.info("--------get screen record success---------");
			return "success";
		}
	}
	
	public String updateModifiedScreen(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED SCREEN BODY============");
		log4j.debug("===========Currently in updateModifiedScreen method===========");			
		
		ScreenOperations scrOp = new ScreenOperations();
		
		int scrId = getScreenID();
		int cityId = getCinemaID();
		int screenNum = getScreenNum();
		int genCap = getGenCapacity();
		int silCap = getSilverCapacity();
		int goldCap = getGoldCapacity();
		int totalCap = getTotalCapacity();
		
		scrOp.setScreenID(scrId);
		scrOp.setCinemaID(cityId);
		scrOp.setScreenNum(screenNum);
		scrOp.setGenCapacity(genCap);
		scrOp.setSilverCapacity(silCap);
		scrOp.setGoldCapacity(goldCap);
		scrOp.setTotalCapacity(totalCap);
		
		log4j.info("retrieved Screen ID value as "+scrOp.getScreenID());
		log4j.info("updating Cinema ID value as "+scrOp.getCinemaID());
		log4j.info("updating Screen Number value as "+scrOp.getScreenNum());
		log4j.info("updating general capacity value as "+scrOp.getGenCapacity());
		log4j.info("updating silver capacity value as "+scrOp.getSilverCapacity());
		log4j.info("updating gold capacity value as "+scrOp.getGoldCapacity());
		log4j.info("updating total capacity value as "+scrOp.getTotalCapacity());

		int result = 0;
		try{
			Connection con=DBManager.getConnection();
			result = ScreenDbControl.setScreenRecord(con, scrOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Update modified screen failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Update modified screen success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
			
	}
	
	public String deleteScreen(){
		
		log4j.info("=============CURRENTLY IN VIEW CINEMA SCREENS BODY============");
		log4j.debug("===========Currently in deleteScreen method===========");
		
		int result = 0;
		int id = getScreenID();
		log4j.info("Screen ID to be deleted is: "+id);
		
		try{
			Connection con=DBManager.getConnection();
			result = ScreenDbControl.deleteScreen(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Delete screen failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Delete screen success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
		
	}
	

}
