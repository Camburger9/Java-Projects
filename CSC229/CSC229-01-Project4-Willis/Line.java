import javax.swing.JOptionPane;

public class Line 
{
	//data members
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	// constructors
	public Line()
	{
		x1 = 0;
		x2 = 100;
		y1 = 0;
		y2 = 100;
	}
	public Line(int x, int a, int y, int b)
	{
		x1 = x;
		y1 = y;
		x2 = a;
		y2 = b;
	}
	// accessors
	public int getX1() {return x1;}
	public int getY1() {return y1;}
	public int getX2() {return x2;}
	public int getY2() {return y2;}
	//calculate secondary attributes
	public void getAttributes() 
		{
			String input;
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"X1 (X Coordinate of First Point",
					JOptionPane.QUESTION_MESSAGE);
			   x1 = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Y1 (Y1 Coordinate of First Point",
					JOptionPane.QUESTION_MESSAGE);
			   y1 = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"X2 (X Coordinate of Second Point",
					JOptionPane.QUESTION_MESSAGE);
			   x2 = Integer.parseInt(input);
			input = JOptionPane.showInputDialog(null,
					"Please Enter an Integer",
					"Y2 (Y Coordinate of Second Point",
					JOptionPane.QUESTION_MESSAGE);
			   x2 = Integer.parseInt(input);
			
			
		}
	public double getLineLength()
	{
		double ll = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
		double roundedValue = ((int)(ll * 100)) / 100.0;
		return roundedValue;
	}
	public String toString()
	{
		return "			Line Properties"+"\n"+
			   "________________________________"+"\n"+
			   "      First Point = (" +x1+","+y1+")"+"\n"+
			   "Second Point = (" +x2+","+y1+")"+"\n"+
			   "            Length = "+ getLineLength() +"\n"+
			   "________________________________";
	}
}
