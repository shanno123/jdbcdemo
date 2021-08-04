package mapdemo;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<String,Double> hm=new HashMap<String, Double>();
		
		hm.put("John", 5000.50);
		hm.put("Jim", 4200.22);
		hm.put("Daisy", 6700.50);
		hm.put("Jack", 140.01);
		hm.put("Mike", 10000.90);
		
	    System.out.println("Dispay Customers & Balance Amount :");
	    for(String k:hm.keySet())// here string is key
	    {
	    	System.out.println(k+"-->"+hm.get(k));
	    }
	    
	    //deposit 1000 to Jim's Account
	    double bal=hm.get("Jim");
	    System.out.println("Jim's old Balance is :"+bal);
	    hm.put("Jim", bal+1000);
	    System.out.println("Jim's new Balance is :"+hm.get("Jim"));
	    
	    //if data is absent we can insert too
	    hm.putIfAbsent("Raj", 500.00);
	    System.out.println(hm);
	    
	    //In real time
	    Scanner s=new Scanner(System.in);
	    System.out.println("Enter Customer name for his balance");
	    String name=s.next();
	    System.out.println("The Balance of "+name+" is :"+hm.get(name));
	}

}
