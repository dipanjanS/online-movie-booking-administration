package com.admin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.action.SeatMapOperations;



public class SeatMapDbControl {
	
	static Logger log4j = Logger.getLogger(SeatMapDbControl.class.getName());
	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";
	
public static int addNewSeatMap(Connection con, SeatMapOperations smOp){
		
		int res = 0;
		log4j.debug("=============INSERT NEW SCREEN SEAT NUMBER OP==============");
		log4j.debug("===========Currently in addNewSeatMap (DB) method===========");
		
		int screenId = smOp.getScreenID();
		String seatClass = smOp.getSeatClass();
		String seatNum = smOp.getSeatNum();

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "insert into seatmap(screenID, seatClass, seatNum) values(?,?,?);";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, screenId);
			statement.setString(2, seatClass);
			statement.setString(3, seatNum);

			res = statement.executeUpdate(); 	

		} catch( Exception e){
			log4j.debug("Failed to execute insert");
			e.printStackTrace();
		}

		log4j.debug("insert statement execution success, rows affected: "+res);	
		return res;
	}

	
	public static ArrayList<SeatMapOperations> getSeatMaps(Connection con){

		ArrayList<SeatMapOperations> seats = new ArrayList<SeatMapOperations>();
		log4j.debug("=============GET ALL SCREEN SEAT NUMBER MAPS DB OP==============");
		log4j.debug("===========Currently in getSeatMaps (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select sm.seatMapID, s.cinemaID, sm.screenID, c.cinemaName, s.screenNum, sm.seatClass, sm.seatNum from seatmap sm, screen s, cinema c where sm.screenID = s.screenID and s.cinemaID = c.cinemaID";
			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();

			while(rs.next()){
				SeatMapOperations smOp = new SeatMapOperations();
				smOp.setSeatMapID(rs.getInt(1));
				smOp.setCinemaID(rs.getInt(2));
				smOp.setScreenID(rs.getInt(3));
				smOp.setCinemaName(rs.getString(4));
				smOp.setScreenNum(rs.getInt(5));
				smOp.setSeatClass(rs.getString(6));
				smOp.setSeatNum(rs.getString(7));
				seats.add(smOp);
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select");
			e.printStackTrace();
		}

		log4j.debug("select statement execution success");	
		return seats;
	}
	
}
