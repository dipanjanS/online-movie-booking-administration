package com.admin.action;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.utils.DBManager;
import com.admin.utils.SeatMapDbControl;

public class SeatMapOperations {

	static Logger log4j = Logger.getLogger(CinemaOperations.class.getName());
	private int seatMapID;
	private int screenID;
	private String seatClass;
	private String seatNum;

	private String cinemaName;
	private int cinemaID;
	private int screenNum;

	private ArrayList<SeatMapOperations> seats;



	public int getScreenNum() {
		return screenNum;
	}

	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public int getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public int getSeatMapID() {
		return seatMapID;
	}

	public void setSeatMapID(int seatMapID) {
		this.seatMapID = seatMapID;
	}

	public int getScreenID() {
		return screenID;
	}

	public void setScreenID(int screenID) {
		this.screenID = screenID;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public ArrayList<SeatMapOperations> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<SeatMapOperations> seats) {
		this.seats = seats;
	}


	public String displaySeatmapSeats(){

		log4j.info("=============CURRENTLY IN VIEW SEATMAP SEATS BODY============");
		log4j.debug("===========Currently in displaySeatmapSeats method===========");		

		seats= new ArrayList<SeatMapOperations>();

		try{
			Connection con=DBManager.getConnection();
			seats=SeatMapDbControl.getSeatMaps(con);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Seatmap view failed some exception occurred---------");
			e.printStackTrace();
		}

		if (seats==null){
			log4j.info("-----------View seatmap error---------");
			return "error";
		}
		else{
			log4j.info("--------View seatmap success---------");
			return "success";
		}

	}


}
