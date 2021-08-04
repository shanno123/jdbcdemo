package oopsdemo4;

//Rectangle class is implementing shape Interface
public class Rectangle implements Shape{
	
	private double width;
	private double height;
	
	

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {

		System.out.println("Drawing Rectangle---");
		
	}

	@Override
	public double getArea() {
		return this.height*this.width;
	}

	
}
