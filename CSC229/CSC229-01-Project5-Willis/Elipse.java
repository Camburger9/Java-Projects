import javax.swing.JOptionPane;

public class Elipse {
	//Data members
	private int xTopLeft;
	private int yTopLeft;
	private int width;
	private int height;
	//Constructors
	
	public Elipse()
	{
		xTopLeft = 0;
		yTopLeft = 0;
		width = 2;
		height = 1;
	}
	public Elipse(int a,int b,int c,int d)
	{
		xTopLeft = a;
		yTopLeft = b;
		width = c;
		height = d;
	}
	
	// accesors
	public int getX() {return xTopLeft;}
	public int getY() {return yTopLeft;}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	//calculate secondary attributes
	public void getAttributes()
	{
		String input;
		input = JOptionPane.showInputDialog(null,
				"Please Enter an Integer",
				"Top Left X Corner of Elipse",
				JOptionPane.QUESTION_MESSAGE);
		xTopLeft = Integer.parseInt(input);
		input = JOptionPane.showInputDialog(null,
				"Please Enter an Integer",
				"Top Left Y Corner of Elipse",
				JOptionPane.QUESTION_MESSAGE);
		yTopLeft = Integer.parseInt(input);
		input = JOptionPane.showInputDialog(null,
				"Please Enter an Integer",
				"Width of Elipse",
				JOptionPane.QUESTION_MESSAGE);
		width = Integer.parseInt(input);
		input = JOptionPane.showInputDialog(null,
				"Please Enter an Integer",
				"Height of Eclipse",
				JOptionPane.QUESTION_MESSAGE);
		height = Integer.parseInt(input);
		
	}
	public double getPerimeter()
	{
		double h = Math.pow(((0.5*width)-(0.5*height)), 2) / Math.pow(((0.5*width) + (0.5*height)), 2);
        double perimeter = Math.PI * ((0.5*width) + (0.5*height)) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
		return perimeter;
	}

	public double getArea()
	{
		return (Math.PI*(0.5*height)*(0.5*width));
	}
	public String toString()
	{
		return "			Elipse Properties"+"\n"+
			   "________________________________"+"\n"+
			   "		TopLeft Corner = (" +xTopLeft+","+yTopLeft+")"+"\n"+
			   "                 Width = "+width+"\n"+
			   "                Hieght = "+height+"\n"+
			   "         Perimeter = "+getPerimeter()+"\n"+
			   "                   Area = "+getArea()+"\n"+
			   "________________________________";
	}

}
