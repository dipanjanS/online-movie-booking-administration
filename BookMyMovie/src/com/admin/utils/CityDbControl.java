package com.admin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.admin.action.CityOperations;

import org.apache.log4j.*;

public class CityDbControl {
	
	static Logger log4j = Logger.getLogger(CityDbControl.class.getName());
	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";
	
	public static int addNewCity(Connection con, String city){
		
		int res = 0;
		log4j.debug("=============INSERT NEW CITY DB OP==============");
		log4j.debug("===========Currently in addNewCity (DB) method===========");
		try{
			
			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();
			
			sqlQuery = "insert into city(cityName) values(?);";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, city);
			res = statement.executeUpdate(); 	
			
		} catch( Exception e){
			log4j.debug("Failed to execute insert");
			e.printStackTrace();
		}
		
		log4j.debug("insert statement execution success, rows affected: "+res);	
		return res;
	}
	
	public static ArrayList<CityOperations> getCities(Connection con){
		
		ArrayList<CityOperations> cities = new ArrayList<CityOperations>();
		log4j.debug("=============GET ALL CITIES CITY DB OP==============");
		log4j.debug("===========Currently in getCities (DB) method===========");
		
		try{
			
			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();
			
			sqlQuery = "select * from city;";
			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();
			
			while(rs.next()){
				CityOperations cityOp = new CityOperations();
				cityOp.setCityID(rs.getInt(1));
				cityOp.setCityName(rs.getString(2));
				cities.add(cityOp);
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select");
			e.printStackTrace();
		}
		
		log4j.debug("select statement execution success");	
		return cities;
	}
	
	
	public static CityOperations getCityRecord(Connection con, int cityID){
		
		CityOperations city = new CityOperations();
		log4j.debug("=============GET SPECIFIC CITY RECORD DB OP==============");
		log4j.debug("===========Currently in getCityRecord (DB) method===========");
		
		try{
			
			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();
			
			sqlQuery = "select * from city where cityID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cityID);
			rs=statement.executeQuery();
			
			while(rs.next()){
				city.setCityID(rs.getInt(1));
				city.setCityName(rs.getString(2));
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select with where clause");
			e.printStackTrace();
		}
		
		log4j.debug("select with where clause statement execution success");	
		return city;
		
	}
	
public static int setCityRecord(Connection con, CityOperations cityOp){
		
		log4j.debug("=============SET SPECIFIC CITY RECORD DB OP==============");
		log4j.debug("===========Currently in setCityRecord (DB) method===========");
		int id = cityOp.getCityID();
		String city = cityOp.getCityName();
		int result = 0;
		
		try{
			
			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();
			
			sqlQuery = "update city set cityName = ? where cityID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, city);
			statement.setInt(2, id);
			result=statement.executeUpdate();
			
			
		}
		catch (Exception e) {
			log4j.debug("Failed to execute update");
			e.printStackTrace();
		}
		
		log4j.debug("update statement execution success, rows affected: "+result);	
		return result;
		
	}
	
	public static int deleteCity(Connection con, int cityId){
		
		int res = 0;
		log4j.debug("=============DELETE SPECIFIC CITY RECORD DB OP==============");
		log4j.debug("===========Currently in deleteCity (DB) method===========");
		try{
			
			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();
			
			sqlQuery = "delete from city where cityID = ?";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cityId);
			res = statement.executeUpdate(); 
					
		} catch( Exception e){
			log4j.debug("Failed to execute delete");
			e.printStackTrace();
		}
		
		log4j.debug("delete statement execution success, rows affected: "+res);	
		return res;
	}

}
