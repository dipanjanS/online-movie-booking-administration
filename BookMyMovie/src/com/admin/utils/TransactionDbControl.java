package com.admin.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class TransactionDbControl {
	int transactionNum;
	String movieName; 
	String showDate;
	String showTime;
	int totalSeats, amount, bookingId, custID;
	String userName;
	static String day;
	static String month;
	static String year;
	static String sendDate=null;
	static ArrayList<TransactionDbControl>returnTransactionList=new ArrayList<TransactionDbControl>();

	static PreparedStatement statement=null;
	static ResultSet rs=null;
	static String sqlQuery="";
	
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTransactionNum() {
		return transactionNum;
	}
	public void setTransactionNum(int transactionNum) {
		this.transactionNum = transactionNum;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public static String getDay() {
		return day;
	}
	public static void setDay(String day) {
		TransactionDbControl.day = day;
	}
	public static String getMonth() {
		return month;
	}
	public static void setMonth(String month) {
		TransactionDbControl.month = month;
	}
	public static String getYear() {
		return year;
	}
	public static void setYear(String year) {
		TransactionDbControl.year = year;
	}
	public static String getSendDate() {
		return sendDate;
	}
	public static void setSendDate(String sendDate) {
		TransactionDbControl.sendDate = sendDate;
	}
	public static ArrayList<TransactionDbControl> getReturnTransactionList() {
		return returnTransactionList;
	}
	public static void setReturnTransactionList(
			ArrayList<TransactionDbControl> returnTransactionList) {
		TransactionDbControl.returnTransactionList = returnTransactionList;
	}
	public static ArrayList<TransactionDbControl> returnAllTransactions(){
		returnTransactionList.clear();

		try{
			java.sql.Connection con=DBManager.getConnection();
			DBManager.useDataBase(con);
			sqlQuery = 
					"SELECT transactionNum, movieName, showDate, showTime, totalSeats, amount, transaction.bookingID, " +
					"bookinginfo.customerID,customer.userName FROM movie, transaction, bookinginfo, schedule, customer " +
					"WHERE movie.movieID=schedule.movieID AND bookinginfo.scheduleID=schedule.scheduleID AND " +
					"transaction.bookingID=bookinginfo.bookingID AND bookinginfo.customerID=customer.customerID;";

			statement=con.prepareStatement(sqlQuery);
			rs=statement.executeQuery();

			while(rs.next()){

				TransactionDbControl tb = new TransactionDbControl();

				tb.setTransactionNum(rs.getInt(1));
				tb.setMovieName(rs.getString(2));
				tb.setShowDate(rs.getDate(3).toString());
				tb.setShowDate(reverseString(tb.getShowDate()));
				tb.setShowTime(rs.getTime(4).toString());
				tb.setTotalSeats(rs.getInt(5));
				tb.setAmount(rs.getInt(6));
				tb.setBookingId(rs.getInt(7));
				tb.setCustID(rs.getInt(8));
				tb.setUserName(rs.getString(9));
				returnTransactionList.add(tb);
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}

		return returnTransactionList;
	}
	public static String reverseString(String returnDate){
		StringTokenizer st=new StringTokenizer(returnDate, "-");
		while(st.hasMoreTokens()){
			day=st.nextToken();
			month=st.nextToken();
			year=st.nextToken();
		}
		sendDate=year+"-"+month+"-"+day;
		return sendDate;
	}

}
