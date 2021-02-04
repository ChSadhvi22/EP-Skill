package com.klu.main;


import java.sql.SQLException;
import java.util.Scanner;
import com.klu.CRUD.DAO;
import com.klu.DBUtil.DBUtil;
import com.klu.Bean.Bean;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Scanner sc=new Scanner(System.in);
		Bean b=new Bean();
		DAO d=new DAO();
		while(true) {
		System.out.println("1.Insert");
		System.out.println("2.Display");
		System.out.println("3.TotalCost");
		System.out.println("Enter your option");
		int option=sc.nextInt();
		switch (option) {
		case 1:
			
		try {
			int i = 0;
			
			    System.out.println("Enter values to be inserted");
			    System.out.println("Enter itemid");
			    int id=sc.nextInt();
			    System.out.println("Enter itemname");
			    String name=sc.next();
			    System.out.println("Enter itemcost");
			    int cost=sc.nextInt();
			    b.setItemid(id);
			    b.setItemname(name);
			    b.setCostofitems(cost);
			    i=d.Insert(b);
			    
	    if(i>0)
	    {
	    	System.out.println("Insertion is successful");
	    }
	    else
	    {
	    	System.out.println("Insertion is not successful");
	    }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		case 2:
			d.Display(b);
			break;
		case 3:
			d.totalSum();
			break;
		}
		}
	}

}
