package project;

import java.util.*;
public class EmployeeCRUD {

	public static void main(String[] args) throws Exception {
		Employee e=new Employee();
		String city=null,first_name=null,last_name=null,contact=null;
		int eid=0;;
		
		System.out.println("************** Global Tech Solutions **************");
		System.out.println("----------- Employee Management System ----------");
		while(true)
		{
		System.out.println();
		System.out.println("Press 1 for New Employee \t Press 2 to Display Employees");
		System.out.println("Press 3 for Update Employee \t Press 4 to Delete Employee");
		System.out.println("Press 5 for Exit"); 
			
		Scanner s=new Scanner(System.in);
		int option=s.nextInt();
		System.out.println();
		try
		{
		switch(option)
		{
		case 1: System.out.println("Enter Customer First_name,Last_name, City & Contact no :");
				// input 
				e.insertEmployee(first_name,last_name,city,contact);
				break;
				
		case 2: e.displayEmployee();
				break;
				
		case 3: System.out.println("Enter Employee Id & City to be Updated:");
				//input
				e.updateEmployee(eid,city);
				break;
				
		case 4: System.out.println("Enter Employee Id  to be Deleted:");
				//input
				e.deleteEmployee(eid);
				break;
		case 5: System.out.println("Application Terminated.");
 				System.exit(0);

		default: System.out.println("Invalid Selection.");
          break;
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Employee.con.close();

	}
}

}
