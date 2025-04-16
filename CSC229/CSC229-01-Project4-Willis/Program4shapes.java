import javax.swing.JOptionPane;

public class Program4shapes 
{
	public static void main(String[] args)
	{
		menu();
	}
	public static void menu()
		{
				JOptionPane.showMessageDialog(null,
				"                 Geometric shapes"+"\n"+
				"________________________________________"+"\n"+
				"  This allows the user to select"+"\n"+
				"  one of the six shapes and enter the primary"+"\n"+
				"  attributes of the shape, it then calculates"+"\n"+
				"  the secondary attributes of the shape and " +"\n"+
				"              reports all attributes"+"\n"+
				"________________________________________"+"\n"+
				"           Two Dimensional Shapes"+"\n"+
				"________________________________________"+"\n"+
				"			  1) Line"+"\n"+
				" 			 2) Rectangle"+"\n"+
				"			  3) Parallelogram "+"\n"+
				"			  4) Elipse"+"\n"+
				"________________________________________"+"\n"+
				"            Three-Dimensional Shapes"+"\n"+
				"________________________________________"+"\n"+
				"			  5) Cube"+"\n"+
				"  6) Cylinder"+"\n"
				,"CSC 229 Project 04 -  Shapes",
				JOptionPane.INFORMATION_MESSAGE);
		int response = 1;
		while( response != 7)
			{
				String input = JOptionPane.showInputDialog(null,
				"                 Geometric shapes"+"\n"+
				"________________________________________"+"\n"+
				"          Select a Shape By Entering"+"\n"+
				"       the Number Associated with Shape"+"\n"+
				"          Press 7 to Exit the Program"+"\n"+
				"________________________________________"+"\n"+
				"           Two Dimensional Shapes"+"\n"+
				"________________________________________"+"\n"+
				"			  1) Line"+"\n"+
				" 			 2) Rectangle"+"\n"+
				"			  3) Parallelogram "+"\n"+
				"			  4) Elipse"+"\n"+
				"________________________________________"+"\n"+
				"            Three-Dimensional Shapes"+"\n"+
				"________________________________________"+"\n"+
				"			  5) Cube"+"\n"+
				"  6) Cylinder"+"\n"+
				"________________________________________"+"\n"+
				"			  7) EXIT"+"\n"
				,"CSC 229 Project 04 -  Shapes",
				JOptionPane.QUESTION_MESSAGE);
				response = Integer.parseInt(input);
				switch(response)
					{
					case 1:				
					{
						Line r = new Line();
						r.getAttributes();
						displayResult(response,r);
						
						break;
					}
					case 2:				//Rectangle
					{
						Rectangle r = new Rectangle();
						r.getAttributes();
						displayResult(response,r);
						
						break;
					}
					case 3:				// 7+49+343+...7^N
					{
						Parallelogram r = new Parallelogram();
						r.getAttributes();
						displayResult(response,r);
						
						break;
					}
					case 4:				// 1x2x3x....... N
					{
						Elipse r = new Elipse();
						r.getAttributes();
						displayResult(response,r);
					
						break;
					}
					case 5:				// Cube
					{
						Cube r = new Cube();
						r.getAttributes();
						displayResult(response,r);
						
						break;
					}
					case 6:
					{
						Cylinder r = new Cylinder();
						r.getAttributes();
						displayResult(response,r);
						
						break;		
					}
					case 7:
					{
						JOptionPane.showMessageDialog(null,
								"			Good Bye",
								"Thank You For Using Math Series",
								JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					default:     // response is out of range
					{
						JOptionPane.showMessageDialog(null,
						"Plese Enter a Number Between 1 and 7",
						"Incorrect Selection",
						JOptionPane.ERROR_MESSAGE);
						break;
					}
				}
			}
		}
	public static void displayResult(int response,Object o)
		{
	
		switch(response)
		{
		case 1:
		{
			Line temp = (Line)o;
			JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
			JOptionPane.INFORMATION_MESSAGE);
			
			break;
		}
		case 2:
		{
			Rectangle temp = (Rectangle)o;
			JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
			JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		case 3:
		{
			Parallelogram temp = (Parallelogram)o;
			JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
			JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		case 4:
		{
			Elipse temp = (Elipse)o;
			JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
			JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		case 5:
		{
			Cube temp = (Cube)o;
			JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
			JOptionPane.INFORMATION_MESSAGE);
			
			break;
		}
		case 6:
		{
			Cylinder temp = (Cylinder)o;
			JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
			JOptionPane.INFORMATION_MESSAGE);
			
			break;
		}
		case 7:
		{
			JOptionPane.showMessageDialog(null,
					"			Good Bye",
					"Thank You For Using Math Series",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			break;
		}
		}
	}
}
