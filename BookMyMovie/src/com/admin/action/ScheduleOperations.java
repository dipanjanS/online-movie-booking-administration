package com.admin.action;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.utils.DBManager;
import com.admin.utils.ScheduleDbControl;

public class ScheduleOperations {
	
	static Logger log4j = Logger.getLogger(ScheduleOperations.class.getName());
	
	private int scheduleID;
	private String showDate;
	private String showtime;
	private int screenID;
	private int movieID;
	private int genClass;
	private int silverClass;
	private int goldClass;
	
	private String cinemaName;
	private int screenNum;
	private String movieName;
	
	private ArrayList<ScheduleOperations> scheduleList;

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public int getScreenID() {
		return screenID;
	}

	public void setScreenID(int screenID) {
		this.screenID = screenID;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public int getGenClass() {
		return genClass;
	}

	public void setGenClass(int genClass) {
		this.genClass = genClass;
	}

	public int getSilverClass() {
		return silverClass;
	}

	public void setSilverClass(int silverClass) {
		this.silverClass = silverClass;
	}

	public int getGoldClass() {
		return goldClass;
	}

	public void setGoldClass(int goldClass) {
		this.goldClass = goldClass;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public int getScreenNum() {
		return screenNum;
	}

	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public ArrayList<ScheduleOperations> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(ArrayList<ScheduleOperations> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	public String scheduleOpPanel(){
		log4j.info("=============LOADING ADD SCHEDULE BODY============");
		log4j.debug("===========Currently in scheduleOpPanel method===========");
		return "success";
	}
	
	public String addNewSchedule(){
		
		log4j.info("=============CURRENTLY IN ADD SCHEDULE BODY============");
		log4j.debug("===========Currently in addNewSchedule method===========");
		
		int result = 0;
		ScheduleOperations schedule = new ScheduleOperations();
		schedule.setScheduleID(getScheduleID());
		schedule.setShowDate(getShowDate());
		schedule.setShowtime(getShowtime());
		schedule.setScreenID(getScreenID());
		schedule.setMovieID(getMovieID());
		schedule.setGenClass(getGenClass());
		schedule.setSilverClass(getSilverClass());
		schedule.setGoldClass(getGoldClass());
		
		try{
			Connection con=DBManager.getConnection();
			result = ScheduleDbControl.addNewSchedule(con, schedule);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Schedule add failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Add new schedule failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Add new schedule success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
	}
	
	public String displaySchedules(){
		
		log4j.info("=============CURRENTLY IN VIEW SCHEDULES BODY============");
		log4j.debug("===========Currently in displaySchedules method===========");		
		scheduleList= new ArrayList<ScheduleOperations>();
		
		try{
			Connection con=DBManager.getConnection();
			scheduleList = ScheduleDbControl.getSchedules(con);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Schedule view failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (scheduleList==null){
			log4j.info("-----------View schedules error---------");
			return "error";
		}
		else{
			log4j.info("--------View schedules success---------");
			return "success";
		}
		
	}
	
	public String getScheduleToModify(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED SCHEDULE BODY============");
		log4j.debug("===========Currently in getScheduleToModify method===========");	
		ScheduleOperations schedule = new ScheduleOperations();
		int id = getScheduleID();
		log4j.info("Schedule ID value: "+id);		
		try{
			Connection con=DBManager.getConnection();
			schedule = ScheduleDbControl.getScheduleRecord(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (schedule==null){
			log4j.info("-----------get schedule record error---------");
			return "error";
		}
		else{
			
			setScheduleID(schedule.getScheduleID());
			setShowDate(schedule.getShowDate());
			setShowtime(schedule.getShowtime());
			setScreenID(schedule.getScreenID());
			setMovieID(schedule.getMovieID());
			setGenClass(schedule.getGenClass());
			setSilverClass(schedule.getSilverClass());
			setGoldClass(schedule.getGoldClass());
			
			log4j.info("setting Schedule ID value as "+getScheduleID());
			log4j.info("setting Show Date value as "+getShowDate());
			log4j.info("setting Show time value as "+getShowtime());
			log4j.info("setting Screen ID value as "+getScreenID());
			log4j.info("setting Movie ID value as "+getMovieID());
			log4j.info("setting General Class price value as "+getGenClass());
			log4j.info("setting Silver Class price value as "+getSilverClass());
			log4j.info("setting Gold Class price value as "+getGoldClass());
			log4j.info("--------get schedule record success---------");
			return "success";
		}
	}
	
	public String updateModifiedSchedule(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED SCHEDULE BODY============");
		log4j.debug("===========Currently in updateModifiedSchedule method===========");			
		
		ScheduleOperations schedule = new ScheduleOperations();
		
		int scheduleId = getScheduleID();
		String date = getShowDate();
		String time = getShowtime();
		int screenId = getScreenID();
		int movieId = getMovieID();
		int genClass = getGenClass();
		int silvClass = getSilverClass();
		int goldClass = getGoldClass();
		
		schedule.setScheduleID(scheduleId);
		schedule.setShowDate(date);
		schedule.setShowtime(time);
		schedule.setScreenID(screenId);
		schedule.setMovieID(movieId);
		schedule.setGenClass(genClass);
		schedule.setSilverClass(silvClass);
		schedule.setGoldClass(goldClass);
		
		log4j.info("retrieved Schedule ID value as "+schedule.getScheduleID());
		log4j.info("updating Show Date value as "+schedule.getShowDate());
		log4j.info("updating Show time value as "+schedule.getShowtime());
		log4j.info("updating Screen ID value as "+schedule.getScreenID());
		log4j.info("updating Movie ID value as "+schedule.getMovieID());
		log4j.info("updating General Class price value as "+schedule.getGenClass());
		log4j.info("updating Silver Class price value as "+schedule.getSilverClass());
		log4j.info("updating Gold Class price value as "+schedule.getGoldClass());
		
		int result = 0;
		try{
			Connection con=DBManager.getConnection();
			result = ScheduleDbControl.setScheduleRecord(con, schedule);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Update modified schedule failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Update modified schedule success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
			
	}
	
	public String deleteSchedule(){
		
		log4j.info("=============CURRENTLY IN VIEW SCHEDULES BODY============");
		log4j.debug("===========Currently in deleteSchedule method===========");
		
		int result = 0;
		int id = getScheduleID();
		log4j.info("Schedule ID to be deleted is: "+id);
		
		try{
			Connection con=DBManager.getConnection();
			result = ScheduleDbControl.deleteSchedule(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Delete schedule failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Delete schedule success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
		
	}
	


}
