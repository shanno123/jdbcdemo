package project;

import java.sql.*;
import java.util.Scanner;

//Employee class implement thread operations
public class Employee {

	static Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    int count;
    Scanner sc=new Scanner(System.in);
   
    public Connection getConnection() throws Exception
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin");
		return con;
    }
  
    public void insertEmployee(String fname,String lname, String city, String contact) throws Exception
    {
        System.out.println("**************** Insert new Employee*****************");
        
        con=getConnection();
        ps=con.prepareStatement("insert into employee(first_name,last_name,city,contact) values(?,?,?,?)");
        fname=sc.next();
        lname=sc.next();
        city=sc.next();
        contact=sc.next();
        
        ps.setString(1,fname);
        ps.setString(2,lname);
        ps.setString(3,city);
        ps.setString(4,contact);
        
        count=ps.executeUpdate();
        if(count>0)
        {
        	System.out.println(count+" Record inserted successfully.");
        }
        
    }
    
    public void displayEmployee() throws Exception
    {
     System.out.println("****************Employees List*****************");
     
     con=getConnection();
     st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=st.executeQuery("select * from employee");
     
     while(rs.next())
     {
    	 System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getString(4)+"\t "+rs.getString(5));
     }
     
    /* rs.afterLast();
     while(rs.previous())
     {
    	 System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getString(4)+"\t "+rs.getString(5));
     }*/
    }
    
    public void updateEmployee(int eid,String city) throws Exception
    {
        System.out.println("**************** Update Employees*****************");
        
        con=getConnection();
        ps=con.prepareStatement("update employee set city=? where emp_id=?");
        eid=sc.nextInt();
        System.out.println("Enter the new city name");
        city=sc.next();
        
        ps.setString(1,city);
        ps.setInt(2,eid);
        
        count=ps.executeUpdate();
        System.out.println(String.format("Rows affected :%d",count));
    }
   
    public void deleteEmployee(int eid) throws Exception
    {
    	con=getConnection();
        System.out.println("**************** Delete Employees*****************");
        ps=con.prepareStatement("delete from employee where emp_id=?");
        eid=sc.nextInt();
        
        ps.setInt(1,eid);
        
        count=ps.executeUpdate();
        System.out.println(String.format("Rows affected :%d",count));
        
    }
}
