import javax.swing.JOptionPane;

public class Cylinder 
{
	// data members
	private int xCenter;
	private int yCenter;
	private int height;
	private int radius;
	// constructors
	public Cylinder() // no-arg constructor
	{
		xCenter = 0;
		yCenter = 0;
		height = 10;
		radius = 10;
	}
	public Cylinder(int x,int y,int a, int b) //argument constructor
	{
		xCenter = x;
		yCenter = y;
		height = a;
		radius = b;
	}
	// accessors
	public int getX() {return xCenter;}
	public int getY() {return yCenter;}
	public int getHeight() {return height;}
	public int getRadius() {return radius;}
	//calculate secondary attributes
	public void getAttributes()
		{
			String input;
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"X Center of Base",
					JOptionPane.QUESTION_MESSAGE);
			xCenter = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Y Center of Base",
					JOptionPane.QUESTION_MESSAGE);
			yCenter = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Radius of Cylinder",
					JOptionPane.QUESTION_MESSAGE);
			radius = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Height of The Cylinder",
					JOptionPane.QUESTION_MESSAGE);
			height = Integer.parseInt(input);
		}
	public double getSurfaceArea()
	{
		return 2*((Math.PI)*(radius)*(height))+(2*((Math.PI)*(Math.pow(radius,2))));
	}
	public double getVolume()
	{
		return ((Math.PI)*(Math.pow(radius,2))*height);
	}
	public String toString()
	{
	return "			Cylinder Properties"+"\n"+
	   "________________________________"+"\n"+
	   "		 Center Base Point = (" +xCenter+","+yCenter+")"+"\n"+
	   "	                      Radius = " +radius+"\n"+
	   "                       Height = "+ height +"\n"+
	   "          Surface Area = "+ getSurfaceArea() +"\n"+
	   "                    Volume = "+ getVolume()+ "\n"+
	   "________________________________";
	}
}
