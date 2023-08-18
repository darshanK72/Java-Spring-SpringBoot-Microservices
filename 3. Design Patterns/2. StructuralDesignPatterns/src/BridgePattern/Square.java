package BridgePattern;

public class Square extends Shape{
	
	
	public Square(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		System.out.println("This is Square of " + this.color.getColor() + " color !");
	}
}