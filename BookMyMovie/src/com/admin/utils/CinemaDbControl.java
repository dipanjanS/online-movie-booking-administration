package com.admin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.action.CinemaOperations;

public class CinemaDbControl {

	static Logger log4j = Logger.getLogger(CinemaDbControl.class.getName());
	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";

	public static int addNewCinema(Connection con, CinemaOperations cinOp ){

		int res = 0;
		log4j.debug("=============INSERT NEW CINEMA DB OP==============");
		log4j.debug("===========Currently in addNewCinema (DB) method===========");

		String cinName = cinOp.getCinemaName();
		String addr = cinOp.getAddress();
		int cityId = cinOp.getCityID();
		int rating = cinOp.getRating();
		int screens = cinOp.getNumOfScreens();
		int capacity = cinOp.getCapacity();

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "insert into cinema(cinemaName, address, cityID, rating, numOfScreens, capacity) values(?,?,?,?,?,?);";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, cinName);
			statement.setString(2, addr);
			statement.setInt(3, cityId);
			statement.setInt(4, rating);
			statement.setInt(5, screens);
			statement.setInt(6, capacity);
			res = statement.executeUpdate(); 	

		} catch( Exception e){
			log4j.debug("Failed to execute insert");
			e.printStackTrace();
		}

		log4j.debug("insert statement execution success, rows affected: "+res);	
		return res;

	}


	public static ArrayList<CinemaOperations> getCinemaTheatres(Connection con){

		ArrayList<CinemaOperations> cinemas = new ArrayList<CinemaOperations>();
		log4j.debug("=============GET ALL CINEMA THEATRES DB OP==============");
		log4j.debug("===========Currently in getCinemaTheatres (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select * from cinema;";
			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();

			while(rs.next()){
				CinemaOperations cinOp = new CinemaOperations();
				cinOp.setCinemaID(rs.getInt(1));
				cinOp.setCinemaName(rs.getString(2));
				cinOp.setAddress(rs.getString(3));
				cinOp.setCityID(rs.getInt(4));
				cinOp.setRating(rs.getInt(5));
				cinOp.setNumOfScreens(rs.getInt(6));
				cinOp.setCapacity(rs.getInt(7));
				cinemas.add(cinOp);
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select");
			e.printStackTrace();
		}

		log4j.debug("select statement execution success");	
		return cinemas;
	}

	public static CinemaOperations getCinemaRecord(Connection con, int cinemaID){

		CinemaOperations cinema = new CinemaOperations();
		log4j.debug("=============GET SPECIFIC CINEMA RECORD DB OP==============");
		log4j.debug("===========Currently in getCinemaRecord (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select * from cinema where cinemaID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cinemaID);
			rs=statement.executeQuery();

			while(rs.next()){
				cinema.setCinemaID(rs.getInt(1));
				cinema.setCinemaName(rs.getString(2));
				cinema.setAddress(rs.getString(3));
				cinema.setCityID(rs.getInt(4));
				cinema.setRating(rs.getInt(5));
				cinema.setNumOfScreens(rs.getInt(6));
				cinema.setCapacity(rs.getInt(7));

			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select with where clause");
			e.printStackTrace();
		}

		log4j.debug("select with where clause statement execution success");	
		return cinema;

	}

	public static int setCinemaRecord(Connection con, CinemaOperations cinOp){

		log4j.debug("=============SET SPECIFIC CINEMA RECORD DB OP==============");
		log4j.debug("===========Currently in setCinemaRecord (DB) method===========");

		int id = cinOp.getCinemaID();
		String cinema = cinOp.getCinemaName();
		String address = cinOp.getAddress();
		int cityId = cinOp.getCityID();
		int rating = cinOp.getRating();
		int screens = cinOp.getNumOfScreens();
		int capacity = cinOp.getCapacity();
		int result = 0;

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "update cinema set cinemaName = ?, address = ?, cityID = ?, rating = ?, numOfScreens = ?, capacity = ? where cinemaID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, cinema);
			statement.setString(2, address);
			statement.setInt(3, cityId);
			statement.setInt(4, rating);
			statement.setInt(5, screens);
			statement.setInt(6, capacity);
			statement.setInt(7, id);
			result=statement.executeUpdate();

		}
		catch (Exception e) {
			log4j.debug("Failed to execute update");
			e.printStackTrace();
		}

		log4j.debug("update statement execution success, rows affected: "+result);	
		return result;

	}

	public static int deleteCinema(Connection con, int cinemaId){

		int res = 0;
		log4j.debug("=============DELETE SPECIFIC CINEMA RECORD DB OP==============");
		log4j.debug("===========Currently in deleteCinema (DB) method===========");
		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "delete from cinema where cinemaID = ?";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cinemaId);
			res = statement.executeUpdate(); 

		} catch( Exception e){
			log4j.debug("Failed to execute delete");
			e.printStackTrace();
		}

		log4j.debug("delete statement execution success, rows affected: "+res);	
		return res;
	}


}
