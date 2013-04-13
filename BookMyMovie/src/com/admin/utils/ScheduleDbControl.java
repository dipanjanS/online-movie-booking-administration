package com.admin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.action.ScheduleOperations;

public class ScheduleDbControl {
	
	static Logger log4j = Logger.getLogger(ScheduleDbControl.class.getName());
	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";
	
	public static int addNewSchedule(Connection con, ScheduleOperations schOp ){

		int res = 0;
		log4j.debug("=============INSERT NEW SCHEDULE DB OP==============");
		log4j.debug("===========Currently in addNewSchedule (DB) method===========");

		String showDate = schOp.getShowDate();
		String showtime = schOp.getShowtime();
		int screenId = schOp.getScreenID();
		int movieId = schOp.getMovieID();
		int genClass = schOp.getGenClass();
		int silverClass = schOp.getSilverClass();
		int goldClass = schOp.getGoldClass();

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "insert into schedule(showDate, showtime, screenID, movieID, genClass, silverClass, goldClass) values(?,?,?,?,?,?,?);";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, showDate);
			statement.setString(2, showtime);
			statement.setInt(3, screenId);
			statement.setInt(4, movieId);
			statement.setInt(5, genClass);
			statement.setInt(6, silverClass);
			statement.setInt(7, goldClass);
			res = statement.executeUpdate(); 	

		} catch( Exception e){
			log4j.debug("Failed to execute insert");
			e.printStackTrace();
		}

		log4j.debug("insert statement execution success, rows affected: "+res);	
		return res;

	}


	public static ArrayList<ScheduleOperations> getSchedules(Connection con){

		ArrayList<ScheduleOperations> schedules = new ArrayList<ScheduleOperations>();
		log4j.debug("=============GET ALL SCHEDULES DB OP==============");
		log4j.debug("===========Currently in getSchedules (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select sch.scheduleID, sch. screenID, sch.movieID, c.cinemaName, scr.screenNum, m.movieName, " +
					"sch.showDate, sch.showtime, sch.genClass, sch.silverClass,sch.goldClass from schedule sch, screen scr," +
					"movie m, cinema c where sch.screenID=scr.screenID and scr.cinemaID=c.cinemaID and sch.movieID = m.movieID;";
			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();

			while(rs.next()){
				ScheduleOperations schOp = new ScheduleOperations();
				schOp.setScheduleID(rs.getInt(1));
				schOp.setScreenID(rs.getInt(2));
				schOp.setMovieID(rs.getInt(3));
				schOp.setCinemaName(rs.getString(4));
				schOp.setScreenNum(rs.getInt(5));
				schOp.setMovieName(rs.getString(6));
				schOp.setShowDate(rs.getString(7));
				schOp.setShowtime(rs.getString(8));
				schOp.setGenClass(rs.getInt(9));
				schOp.setSilverClass(rs.getInt(10));
				schOp.setGoldClass(rs.getInt(11));
				schedules.add(schOp);
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select");
			e.printStackTrace();
		}

		log4j.debug("select statement execution success");	
		return schedules;
	}

	public static ScheduleOperations getScheduleRecord(Connection con, int scheduleID){

		ScheduleOperations schOp = new ScheduleOperations();
		log4j.debug("=============GET SPECIFIC SCHEDULE RECORD DB OP==============");
		log4j.debug("===========Currently in getScheduleRecord (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select * from schedule where scheduleID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, scheduleID);
			rs=statement.executeQuery();

			while(rs.next()){
				schOp.setScheduleID(rs.getInt(1));
				schOp.setShowDate(rs.getString(2));
				schOp.setShowtime(rs.getString(3));
				schOp.setScreenID(rs.getInt(4));
				schOp.setMovieID(rs.getInt(5));
				schOp.setGenClass(rs.getInt(6));
				schOp.setSilverClass(rs.getInt(7));
				schOp.setGoldClass(rs.getInt(8));

			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select with where clause");
			e.printStackTrace();
		}

		log4j.debug("select with where clause statement execution success");	
		return schOp;

	}

	public static int setScheduleRecord(Connection con, ScheduleOperations schOp){

		log4j.debug("=============SET SPECIFIC SCHEDULE RECORD DB OP==============");
		log4j.debug("===========Currently in setScheduleRecord (DB) method===========");

		int schId = schOp.getScheduleID();
		String showDate = schOp.getShowDate();
		String showtime = schOp.getShowtime();
		int screenId = schOp.getScreenID();
		int movieId = schOp.getMovieID();
		int genClass = schOp.getGenClass();
		int silverClass = schOp.getSilverClass();
		int goldClass = schOp.getGoldClass();
		int result = 0;

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "update schedule set showDate = ?, showtime = ?, screenID = ?, movieID = ?, genClass = ?, silverClass = ?, goldClass = ? where scheduleID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, showDate);
			statement.setString(2, showtime);
			statement.setInt(3, screenId);
			statement.setInt(4, movieId);
			statement.setInt(5, genClass);
			statement.setInt(6, silverClass);
			statement.setInt(7, goldClass);
			statement.setInt(8, schId);
			result=statement.executeUpdate();

		}
		catch (Exception e) {
			log4j.debug("Failed to execute update");
			e.printStackTrace();
		}

		log4j.debug("update statement execution success, rows affected: "+result);	
		return result;

	}

	public static int deleteSchedule(Connection con, int scheduleId){

		int res = 0;
		log4j.debug("=============DELETE SPECIFIC SCHEDULE RECORD DB OP==============");
		log4j.debug("===========Currently in deleteSchedule (DB) method===========");
		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "delete from schedule where scheduleID = ?";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, scheduleId);
			res = statement.executeUpdate(); 

		} catch( Exception e){
			log4j.debug("Failed to execute delete");
			e.printStackTrace();
		}

		log4j.debug("delete statement execution success, rows affected: "+res);	
		return res;
	}

}
