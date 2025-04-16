import javax.swing.JOptionPane;

public class Parallelogram 
{
	// data members
	private int xTopLeft;
	private int yTopLeft;
	private int xBottomLeft;
	private int yBottomLeft;
	private int width;
	// constructors
	public Parallelogram() // no-arg constructor
	{
		xTopLeft = 0;
		yTopLeft = 0;
		xBottomLeft = 1;
		yBottomLeft = 1;
		width = 1;
	}
	public Parallelogram(int x,int y,int z,int d,int e) //argument constructor
	{
		yTopLeft = x;
		yTopLeft = y;
		xBottomLeft = z;
		yBottomLeft = d;
		width = e;
	}
	// accessors
	public int getX() {return xTopLeft;}
	public int getY() {return yTopLeft;}
	public int getX2() {return xBottomLeft;}
	public int getY2() {return yBottomLeft;}
	public int getwidth() {return width;}
	//calculate secondary attributes
	public void getAttributes()
		{
			String input;
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Top Left x Corner of Parallelogram",
					JOptionPane.QUESTION_MESSAGE);
			xTopLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Top Left Y Corner of Parallelogram",
					JOptionPane.QUESTION_MESSAGE);
			yTopLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Bottom Left X Corner of Parallelogram",
					JOptionPane.QUESTION_MESSAGE);
			xBottomLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Bottom Left Y Corner of Parallelogram",
					JOptionPane.QUESTION_MESSAGE);
			yBottomLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Width of Rectangle",
					JOptionPane.QUESTION_MESSAGE);
			width = Integer.parseInt(input);
		}
	public double getArea()
	{
		int height = yTopLeft-yBottomLeft;
		double roundedValue = ((int)((Math.abs(height)*width) * 100)) / 100.0;
		return roundedValue;
	}
	
	public double getPerimeter()
	{
		double a = Math.sqrt(Math.pow(yBottomLeft-yTopLeft,2) + Math.pow(yBottomLeft-yTopLeft,2));
		double roundedValue = ((int)(((a+width)*2) * 100)) / 100.0;
		return roundedValue;
	}
	public String toString()
	{
	return "			Parallelogram Properties"+"\n"+
	   "________________________________"+"\n"+
	   "		       Top Left Corner = (" +xTopLeft+","+yTopLeft+")"+"\n"+
	   "		Bottom Left Corner = (" +xBottomLeft+","+yBottomLeft+")"+"\n"+
	   "	                         Width = " +width+"\n"+
	   "                Perimeter = "+ getPerimeter() +"\n"+
	   "                          Area = "+ getArea() +"\n"+
	   "________________________________";
	}
}
