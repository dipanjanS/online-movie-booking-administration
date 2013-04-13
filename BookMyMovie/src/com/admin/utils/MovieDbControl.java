package com.admin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.admin.action.MovieOperations;


public class MovieDbControl {
	
	static Logger log4j = Logger.getLogger(MovieDbControl.class.getName());
	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";
	
	public static int addNewMovie(Connection con, MovieOperations movOp ){

		int res = 0;
		log4j.debug("=============INSERT NEW MOVIE DB OP==============");
		log4j.debug("===========Currently in addNewMovie (DB) method===========");

		String movName = movOp.getMovieName();
		String story = movOp.getStoryLine();
		String imgUrl = movOp.getImageURL();
		int rating = movOp.getRating();
		String trailer = movOp.getTrailer();
		String category = movOp.getCategory();
		String cast = movOp.getCast();

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "insert into movie(movieName, storyLine, imageURL, rating, trailer, category, cast) values(?,?,?,?,?,?,?);";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, movName);
			statement.setString(2, story);
			statement.setString(3, imgUrl);
			statement.setInt(4, rating);
			statement.setString(5, trailer);
			statement.setString(6, category);
			statement.setString(7, cast);
			res = statement.executeUpdate(); 	

		} catch( Exception e){
			log4j.debug("Failed to execute insert");
			e.printStackTrace();
		}

		log4j.debug("insert statement execution success, rows affected: "+res);	
		return res;

	}


	public static ArrayList<MovieOperations> getMovies(Connection con){

		ArrayList<MovieOperations> Movies = new ArrayList<MovieOperations>();
		log4j.debug("=============GET ALL MOVIES DB OP==============");
		log4j.debug("===========Currently in getMovies (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select * from movie;";
			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();

			while(rs.next()){
				MovieOperations movOp = new MovieOperations();
				movOp.setMovieID(rs.getInt(1));
				movOp.setMovieName(rs.getString(2));
				movOp.setStoryLine(rs.getString(3));
				movOp.setImageURL(rs.getString(4));
				movOp.setRating(rs.getInt(5));
				movOp.setTrailer(rs.getString(6));
				movOp.setCategory(rs.getString(7));
				movOp.setCast(rs.getString(8));
				Movies.add(movOp);
			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select");
			e.printStackTrace();
		}

		log4j.debug("select statement execution success");	
		return Movies;
	}

	public static MovieOperations getMovieRecord(Connection con, int movieID){

		MovieOperations movie = new MovieOperations();
		log4j.debug("=============GET SPECIFIC MOVIE RECORD DB OP==============");
		log4j.debug("===========Currently in getMovieRecord (DB) method===========");

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "select * from movie where movieID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, movieID);
			rs=statement.executeQuery();

			while(rs.next()){
				movie.setMovieID(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setStoryLine(rs.getString(3));
				movie.setImageURL(rs.getString(4));
				movie.setRating(rs.getInt(5));
				movie.setTrailer(rs.getString(6));
				movie.setCategory(rs.getString(7));
				movie.setCast(rs.getString(8));

			}
		}
		catch (Exception e) {
			log4j.debug("Failed to execute select with where clause");
			e.printStackTrace();
		}

		log4j.debug("select with where clause statement execution success");	
		return movie;

	}

	public static int setMovieRecord(Connection con, MovieOperations movOp){

		log4j.debug("=============SET SPECIFIC MOVIE RECORD DB OP==============");
		log4j.debug("===========Currently in setMovieRecord (DB) method===========");

		int movId = movOp.getMovieID();
		String movName = movOp.getMovieName();
		String story = movOp.getStoryLine();
		String imgUrl = movOp.getImageURL();
		int rating = movOp.getRating();
		String trailer = movOp.getTrailer();
		String category = movOp.getCategory();
		String cast = movOp.getCast();
		int result = 0;

		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "update movie set movieName = ?, storyLine = ?, imageURL = ?, rating = ?, trailer = ?, category = ?, cast = ? where movieID = ?;";
			statement=con.prepareStatement(sqlQuery);
			statement.setString(1, movName);
			statement.setString(2, story);
			statement.setString(3, imgUrl);
			statement.setInt(4, rating);
			statement.setString(5, trailer);
			statement.setString(6, category);
			statement.setString(7, cast);
			statement.setInt(8, movId);
			result=statement.executeUpdate();

		}
		catch (Exception e) {
			log4j.debug("Failed to execute update");
			e.printStackTrace();
		}

		log4j.debug("update statement execution success, rows affected: "+result);	
		return result;

	}

	public static int deleteMovie(Connection con, int movieId){

		int res = 0;
		log4j.debug("=============DELETE SPECIFIC MOVIE RECORD DB OP==============");
		log4j.debug("===========Currently in deleteMovie (DB) method===========");
		try{

			sqlQuery = "use BookMyMovie;";
			statement=con.prepareStatement(sqlQuery);
			statement.execute();

			sqlQuery = "delete from movie where movieID = ?";
			statement=con.prepareStatement(sqlQuery);
			statement.setInt(1, movieId);
			res = statement.executeUpdate(); 

		} catch( Exception e){
			log4j.debug("Failed to execute delete");
			e.printStackTrace();
		}

		log4j.debug("delete statement execution success, rows affected: "+res);	
		return res;
	}

}
