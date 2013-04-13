package com.admin.action;

import java.util.ArrayList;

import com.admin.utils.TransactionDbControl;


public class AllTransactions{
	ArrayList<TransactionDbControl>transaction=new ArrayList<TransactionDbControl>();
	
	public ArrayList<TransactionDbControl> getTransaction() {
		return transaction;
	}

	public void setTransaction(ArrayList<TransactionDbControl> transaction) {
		this.transaction = transaction;
	}

	public String execute(){
		System.out.println("in view transactions.....");
		transaction=TransactionDbControl.returnAllTransactions();
		return "success";
	}
}
