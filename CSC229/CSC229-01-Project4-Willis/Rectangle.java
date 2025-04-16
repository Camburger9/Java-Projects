import javax.swing.JOptionPane;

public class Rectangle 
{
	// data members
	private int xTopLeft;
	private int yTopLeft;
	private int length;
	private int width;
	// constructors
	public Rectangle() // no-arg constructor
	{
		xTopLeft=0;
		yTopLeft=0;
		length = 10;
		width = 10;
	}
	public Rectangle(int x,int y,int a, int b) //argument constructor
	{
		xTopLeft = x;
		yTopLeft = y;
		length = a;
		width = b;
	}
	// accessors
	public int getX() {return xTopLeft;}
	public int getY() {return yTopLeft;}
	public int getLength() {return length;}
	public int getWidth() {return width;}
	//calculate secondary attributes
	public void getAttributes()
		{
			String input;
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Top Left X Corner of Rectangle",
					JOptionPane.QUESTION_MESSAGE);
			xTopLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Top Left Y Corner of Rectangle",
					JOptionPane.QUESTION_MESSAGE);
			yTopLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Width of Rectangle",
					JOptionPane.QUESTION_MESSAGE);
			width = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Length of Rectangle",
					JOptionPane.QUESTION_MESSAGE);
			length = Integer.parseInt(input);
		}
	public double getPerimeter()
	{
		return 2*(width+length);
	}
	public double  getArea()
	{
		return width*length;
	}
	public String toString()
	{
		return "			Rectangle Properties"+"\n"+
			   "________________________________"+"\n"+
			   "		TopLeft Corner = ("+xTopLeft+","+yTopLeft+")"+"\n"+
			   "                 Width = "+width+"\n"+
			   "               Length = "+length+"\n"+
			   "         Perimeter = "+getPerimeter()+"\n"+
			   "                   Area = "+getArea()+"\n"+
			   "________________________________";
	}
}
