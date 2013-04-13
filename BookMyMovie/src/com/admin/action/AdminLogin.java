package com.admin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.*;

public class AdminLogin extends ActionSupport{
	static Logger log4j = Logger.getLogger(AdminLogin.class.getName());
	private String username;
	private String password;
		
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() {
		
		log4j.info("=============CURRENTLY IN ADMIN LOGIN PAGE============");
		log4j.debug("===========Currently in execute method===========");
		if (this.username.equals("Admin") && this.password.equals("secret")) {
			log4j.debug("---------username and passwords matched------------");
            return "success";
        } else {
        	log4j.debug("---------mismatch of username and password------------");
            addActionError("\nSorry, wrong credentials have been provided.\n");
            return "error";
        }
    }
	
	
}
