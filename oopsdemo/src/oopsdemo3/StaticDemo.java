package oopsdemo3;

class Count //instance class
{
	static int cnt; //static variable
	int a; //instance variable
	
	Count()
	{
		cnt+=1;
		a=100;
	}
	static void display() //static method
	{
		System.out.println("No. of objects created :"+cnt);
	}
	void print() //instance method
	{
		System.out.println("Instance method");
	}
}
public class StaticDemo {

	public static void main(String[] args) {
		Count c1=new Count();
		Count c2=new Count();
		Count c3=new Count();
		
		c1.print();
		c2.print();
		c3.print();
		
		//c1.display(); //The static method display() from the type Count should be accessed in a static way
		
		Count.display(); //invoking static method

	}

}
