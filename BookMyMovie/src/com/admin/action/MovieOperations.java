package com.admin.action;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.admin.utils.DBManager;
import com.admin.utils.MovieDbControl;

public class MovieOperations {
	
	static Logger log4j = Logger.getLogger(MovieOperations.class.getName());
	private int movieID;
	private String movieName;
	private String storyLine;
	private String imageURL;
	private int rating;
	private String trailer;
	private String category;
	private String cast;
	
	private ArrayList<MovieOperations> movies;

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getStoryLine() {
		return storyLine;
	}

	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public ArrayList<MovieOperations> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<MovieOperations> movies) {
		this.movies = movies;
	}
	
	public String movieOpPanel(){
		log4j.info("=============LOADING ADD MOVIE BODY============");
		log4j.debug("===========Currently in movieOpPanel method===========");
		return "success";
	}
	
	public String addNewMovie(){
		
		log4j.info("=============CURRENTLY IN ADD MOVIE BODY============");
		log4j.debug("===========Currently in addNewMovie method===========");
		
		int result = 0;
		MovieOperations movOp = new MovieOperations();
		movOp.setMovieID(getMovieID());
		movOp.setMovieName(getMovieName());
		movOp.setStoryLine(getStoryLine());
		movOp.setImageURL(getImageURL());
		movOp.setRating(getRating());
		movOp.setTrailer(getTrailer());
		movOp.setCategory(getCategory());
		movOp.setCast(getCast());
		
		try{
			Connection con=DBManager.getConnection();
			result = MovieDbControl.addNewMovie(con, movOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Movie add failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Add new movie failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Add new movie success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
	}
	
	public String displayMovies(){
		
		log4j.info("=============CURRENTLY IN VIEW MOVIES BODY============");
		log4j.debug("===========Currently in displayMovies method===========");		
		movies= new ArrayList<MovieOperations>();
		
		try{
			Connection con=DBManager.getConnection();
			movies = MovieDbControl.getMovies(con);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Movie view failed some exception occurred---------");
			e.printStackTrace();
		}
		
		if (movies==null){
			log4j.info("-----------View movies error---------");
			return "error";
		}
		else{
			log4j.info("--------View movies success---------");
			return "success";
		}
		
	}
	
	public String getMovieToModify(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED MOVIE BODY============");
		log4j.debug("===========Currently in getMovieToModify method===========");	
		MovieOperations movOp = new MovieOperations();
		int id = getMovieID();
		log4j.info("Movie ID value: "+id);		
		try{
			Connection con=DBManager.getConnection();
			movOp = MovieDbControl.getMovieRecord(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (movOp==null){
			log4j.info("-----------get movie record error---------");
			return "error";
		}
		else{
			
			setMovieID(movOp.getMovieID());
			setMovieName(movOp.getMovieName());
			setStoryLine(movOp.getStoryLine());
			setImageURL(movOp.getImageURL());
			setRating(movOp.getRating());
			setTrailer(movOp.getTrailer());
			setCategory(movOp.getCategory());
			setCast(movOp.getCast());
			
			log4j.info("setting Movie ID value as "+getMovieID());
			log4j.info("setting Movie Name value as "+getMovieName());
			log4j.info("setting Storyline value as "+getStoryLine());
			log4j.info("setting Image Url value as "+getImageURL());
			log4j.info("setting rating value as "+getRating());
			log4j.info("setting trailer value as "+getTrailer());
			log4j.info("setting category value as "+getCategory());
			log4j.info("setting cast value as "+getCast());
			log4j.info("--------get movie record success---------");
			return "success";
		}
	}
	
	public String updateModifiedMovie(){
		
		log4j.info("=============CURRENTLY IN MODIFY SELECTED MOVIE BODY============");
		log4j.debug("===========Currently in updateModifiedMovie method===========");			
		
		MovieOperations movOp = new MovieOperations();
		
		int movId = getMovieID();
		String movName = getMovieName();
		String story = getStoryLine();
		String imgUrl = getImageURL();
		int rating = getRating();
		String trailer = getTrailer();
		String category = getCategory();
		String cast = getCast();
		
		movOp.setMovieID(movId);
		movOp.setMovieName(movName);
		movOp.setStoryLine(story);
		movOp.setImageURL(imgUrl);
		movOp.setRating(rating);
		movOp.setTrailer(trailer);
		movOp.setCategory(category);
		movOp.setCast(cast);
		
		log4j.info("retrieved Movie ID value as "+movOp.getMovieID());
		log4j.info("updating Movie Name value as "+movOp.getMovieName());
		log4j.info("updating Storyline value as "+movOp.getStoryLine());
		log4j.info("updating Image Url value as "+movOp.getImageURL());
		log4j.info("updating rating value as "+movOp.getRating());
		log4j.info("updating trailer value as "+movOp.getTrailer());
		log4j.info("updating category value as "+movOp.getCategory());
		log4j.info("updating cast value as "+movOp.getCast());
		
		int result = 0;
		try{
			Connection con=DBManager.getConnection();
			result = MovieDbControl.setMovieRecord(con, movOp);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Update modified movie failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Update modified movie success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
			
	}
	
	public String deleteMovie(){
		
		log4j.info("=============CURRENTLY IN VIEW MOVIES BODY============");
		log4j.debug("===========Currently in deleteMovie method===========");
		
		int result = 0;
		int id = getMovieID();
		log4j.info("Movie ID to be deleted is: "+id);
		
		try{
			Connection con=DBManager.getConnection();
			result = MovieDbControl.deleteMovie(con, id);
			con.close();
		}
		catch(Exception e){
			log4j.warn("--------Failure some exception occurred---------");
			e.printStackTrace();
		}
		
		if (result==0){
			log4j.info("-----------Delete movie failure---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "error";
		}
		else{
			log4j.info("-----------Delete movie success---------");
			log4j.debug("------Numbers of rows affected: "+result+"--------");
			return "success";
		}
		
	}

}
