import javax.swing.JOptionPane;

public class Cube 
{
	// data members
	private int xTopLeft;
	private int yTopLeft;
	private int height;
	private int width;
	private int depth;
	// constructors
	public Cube() // no-arg constructor
	{
		xTopLeft=0;
		yTopLeft=0;
		height = 10;
		width = 10;
		depth = 10;
	}
	public Cube(int x,int y,int a, int b, int c) //argument constructor
	{
		xTopLeft = x;
		yTopLeft = y;
		height = a;
		width = b;
		depth = c;
	}
	// accessors
	public int getxTopLeft() {return xTopLeft;}
	public int getyTopLeft() {return yTopLeft;}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public int getDepth() {return depth;}
	//calculate secondary attributes
	public void getAttributes()
		{
			String input;
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Top Left X Corner of Cube",
					JOptionPane.QUESTION_MESSAGE);
			xTopLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Top Left Y Corner of Cube",
					JOptionPane.QUESTION_MESSAGE);
			yTopLeft = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Width of Cube",
					JOptionPane.QUESTION_MESSAGE);
			width = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Height of Cube",
					JOptionPane.QUESTION_MESSAGE);
			height = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Depth of Cube",
					JOptionPane.QUESTION_MESSAGE);
			depth = Integer.parseInt(input);
		}
	public double getSurfaceArea()
	{
		return 2*(width*depth+height*depth+height*width);
	}
	public double getVolume()
	{
		return width*height*depth;
	}
	public String toString()
	{
		return "			Cube Properties"+"\n"+
			   "________________________________"+"\n"+
			   "TopLeft Corner = (" +xTopLeft+","+yTopLeft+")"+"\n"+
			   "                 Width = "+width+"\n"+
			   "                Hieght = "+height+"\n"+
			   "                 Depth = "+depth+"\n"+
			   "   Surface Area = "+getSurfaceArea()+"\n"+
			   "              Volume = "+getVolume()+"\n"+
			   "________________________________";
	}
}
