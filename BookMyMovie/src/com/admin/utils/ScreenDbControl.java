package com.admin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.admin.action.ScreenOperations;
import com.admin.action.SeatMapOperations;

public class ScreenDbControl {

	static Logger log4j = Logger.getLogger(CityDbControl.class.getName());
	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";


	public static int addNewScreen(Connection con, ScreenOperations scrOp){
		
		int res = 0;
		int screenID = 0;
		log4j.debug("=============INSERT NEW SCREEN DB OP==============");
		log4j.debug("===========Currently in addNewScreen (DB) method===========");
		
		int cinId = scrOp.getCinemaID();
		int scrNum = scrOp.getScreenNum();
		int genCapacity = scrOp.getGenCapacity();
		int silverCapacity = scrOp.getSilverCapacity();
		int goldCapacity = scrOp.getGoldCapacity();
		int totalCapacity = scrOp.getTotalCapacity();

		
		
		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "insert into screen(cinemaID, screenNum, genCapacity, silverCapacity, goldCapacity, totalCapacity) values(?,?,?,?,?,?);";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cinId);
			statement.setInt(2, scrNum);
			statement.setInt(3, genCapacity);
			statement.setInt(4, silverCapacity);
			statement.setInt(5, goldCapacity);
			statement.setInt(6, totalCapacity);

			res = statement.executeUpdate(); 	
			
			sqlQuery = "select screenID from screen where cinemaID = ? and screenNum = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cinId);
			statement.setInt(2, scrNum);
			rs=statement.executeQuery();
			
			while(rs.next()){
				screenID = rs.getInt(1);
			}	
			String classPrefix="N";
			for(int i = 1; i <= genCapacity; i++){
				SeatMapOperations smOp = new SeatMapOperations();
				smOp.setScreenID(screenID);
				smOp.setSeatClass("GEN");
				String seatNum = classPrefix+i;
				smOp.setSeatNum(seatNum);
				
				SeatMapDbControl.addNewSeatMap(con, smOp);
			}
			
			classPrefix="S";
			for(int i = 1; i <= silverCapacity; i++){
				SeatMapOperations smOp = new SeatMapOperations();
				smOp.setScreenID(screenID);
				smOp.setSeatClass("SILVER");
				String seatNum = classPrefix+i;
				smOp.setSeatNum(seatNum);
				
				SeatMapDbControl.addNewSeatMap(con, smOp);
			}
			
			classPrefix="G";
			for(int i = 1; i <= goldCapacity; i++){
				SeatMapOperations smOp = new SeatMapOperations();
				smOp.setScreenID(screenID);
				smOp.setSeatClass("GOLD");
				String seatNum = classPrefix+i;
				smOp.setSeatNum(seatNum);
				
				SeatMapDbControl.addNewSeatMap(con, smOp);
			}

		} catch( Exception e){
			log4j.debug("Failed to execute insert");
			e.printStackTrace();
		}

		log4j.debug("insert statement execution success, rows affected: "+res);	
		return res;
	}

	
	public static ArrayList<ScreenOperations> getScreens(Connection con){

		ArrayList<ScreenOperations> screens = new ArrayList<ScreenOperations>();
		log4j.debug("=============GET ALL SCREENS DB OP==============");
		log4j.debug("===========Currently in getScreens (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select s.screenID, s.cinemaID, c.cinemaName, s.screenNum, s.genCapacity, s.silverCapacity, s.goldCapacity, s.totalCapacity from screen s, cinema c where s.cinemaID=c.cinemaID;";
			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();

			while(rs.next()){
				ScreenOperations scrOp = new ScreenOperations();
				scrOp.setScreenID(rs.getInt(1));
				scrOp.setCinemaID(rs.getInt(2));
				scrOp.setCinemaName(rs.getString(3));
				scrOp.setScreenNum(rs.getInt(4));
				scrOp.setGenCapacity(rs.getInt(5));
				scrOp.setSilverCapacity(rs.getInt(6));
				scrOp.setGoldCapacity(rs.getInt(7));
				scrOp.setTotalCapacity(rs.getInt(8));

				screens.add(scrOp);
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select");
			e.printStackTrace();
		}

		log4j.debug("select statement execution success");	
		return screens;
	}
	
	public static ScreenOperations getScreenRecord(Connection con, int screenID){

		ScreenOperations scrOp = new ScreenOperations();
		log4j.debug("=============GET SPECIFIC SCREEN RECORD DB OP==============");
		log4j.debug("===========Currently in getScreenRecord (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select * from screen where screenID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, screenID);
			rs=statement.executeQuery();

			while(rs.next()){
				scrOp.setScreenID(rs.getInt(1));
				scrOp.setCinemaID(rs.getInt(2));
				scrOp.setScreenNum(rs.getInt(3));
				scrOp.setGenCapacity(rs.getInt(4));
				scrOp.setSilverCapacity(rs.getInt(5));
				scrOp.setGoldCapacity(rs.getInt(6));
				scrOp.setTotalCapacity(rs.getInt(7));

			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select with where clause");
			e.printStackTrace();
		}

		log4j.debug("select with where clause statement execution success");	
		return scrOp;

	}
	
	public static int setScreenRecord(Connection con, ScreenOperations scrOp){

		log4j.debug("=============SET SPECIFIC SCREEN RECORD DB OP==============");
		log4j.debug("===========Currently in setScreenRecord (DB) method===========");

		int scrId = scrOp.getScreenID();
		int cinId = scrOp.getCinemaID();
		int scrNum = scrOp.getScreenNum();
		int genCapacity = scrOp.getGenCapacity();
		int silverCapacity = scrOp.getSilverCapacity();
		int goldCapacity = scrOp.getGoldCapacity();
		int totalCapacity = scrOp.getTotalCapacity();

		int result = 0;

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "update screen set cinemaID = ?, screenNum = ?, genCapacity = ?, silverCapacity = ?, goldCapacity = ?, totalCapacity = ? where screenID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, cinId);
			statement.setInt(2, scrNum);
			statement.setInt(3, genCapacity);
			statement.setInt(4, silverCapacity);
			statement.setInt(5, goldCapacity);
			statement.setInt(6, totalCapacity);
			statement.setInt(7, scrId);
			result=statement.executeUpdate();

		}
		catch (Exception e) {
			log4j.debug("Failed to execute update");
			e.printStackTrace();
		}

		log4j.debug("update statement execution success, rows affected: "+result);	
		return result;

	}
	
	public static int deleteScreen(Connection con, int screenId){

		int res = 0;
		log4j.debug("=============DELETE SPECIFIC SCREEN RECORD DB OP==============");
		log4j.debug("===========Currently in deleteCinema (DB) method===========");
		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "delete from screen where screenID = ?";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, screenId);
			res = statement.executeUpdate(); 

		} catch( Exception e){
			log4j.debug("Failed to execute delete");
			e.printStackTrace();
		}

		log4j.debug("delete statement execution success, rows affected: "+res);	
		return res;
	}


}
