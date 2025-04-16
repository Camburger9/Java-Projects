import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Color;

public class ArrayPractice extends Frame implements ActionListener
{
	Font title = new Font("sanserif",Font.BOLD,16);
	Font text = new Font("sanserif",Font.BOLD,12);
	//  Objects
	String command = "";
	// problem 1
	double[] scores = {82.25, 34,55, 64.25, 76.22, 89.45, 96.77,91.33,
			           56.55, 12.75, 82.75, 92.12, 45.14, 65.55, 81.0};
	double result1 = 0.0;
	// problem 2
	int[] numbers = {0, 2, 4, 6, 8, 7, 9, 0, 2, 5, 7, 9, 1, 2, 4, 6, 8, 9, 
			         7, 4, 3, 5, 7, 9, 0, 1, 3, 2, 5, 4, 6, 7, 8, 9, 3};
	int[] result2 = new int[10];
	// problem 3
	int[][] nxn = { {4,6,1,7,2},
			      {8,7,5,3,4},
			      {3,0,5,7,1},
			      {4,2,1,6,9},
			      {5,6,2,3,1}};
	int result3;
	// problem 4 
	int[][] p = { {0,1,2,4,5,8,7},
			      {0,0,2,1,5,6,7},
			      {0,1,0,3,5,8,9},
			      {0,2,4,0,5,5,6},
			      {2,3,5,1,4,8,4},
			      {2,2,2,2,5,7,5},
			      {2,4,4,4,4,8,2}};
	boolean result4;
	
	//homework1
	double[][] nxn1 = { {4.1,6.3,1,7,2},
		      		 {8.9,7,5,3.2,4},
		      		 {5,6.7,2,3.5,1}};
	double resultH1;
	
	//homework2
	int[] frd = {0,1,2,3,4,5,6,7,8,9};
	int[] rev = new int[10];
	
	//homework3
	int [][] a = {{4,6,1},
		      	  {8,7,5},
		          {3,0,5}};
	int[] b = new int[a.length * a[0].length];
	
	//homework4
	int [][] c = {{1,1,1},
	      	  	  {2,2,2},
	              {3,3,3}};
	
	int [][] d = {{4,4,4},
				  {5,5,5},
				  {7,7,7}};
	
	int [][] resultH4 = new int[d.length][d[0].length];
	
	//homework5
	
	int [][] c2 = {{1,1,1},
    	  	  	  {2,2,2}};

	int [][] d2 = {{4,4},
			  	   {5,5},
			  	   {7,7}};
	
	int[][] resultH5 = new int[c2.length][d2[0].length];
	
	
	
	public static void main(String[] args)
	{
		Frame frame = new ArrayPractice();	
		frame.setResizable(true);
		frame.setSize(1000,840);
		frame.setVisible(true);
		
	}
	
	public ArrayPractice()
	{
		setTitle("Homework 3 & Practice");
		
		// Create Menu
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		// 2D Shapes menu
		
		Menu twoDMenu = new Menu("Practice");
		mb.add(twoDMenu);
		
		MenuItem miP1 = new MenuItem("Problem 1");
		miP1.addActionListener(this);
		twoDMenu.add(miP1);
	
		MenuItem miP2 = new MenuItem("Problem 2");
		miP2.addActionListener(this);
		twoDMenu.add(miP2);
		
		MenuItem miP3 = new MenuItem("Problem 3");
		miP3.addActionListener(this);
		twoDMenu.add(miP3);
		
		MenuItem miP4 = new MenuItem("Problem 4");
		miP4.addActionListener(this);
		twoDMenu.add(miP4);
		
		Menu threeDMenu = new Menu("Homework");
		mb.add(threeDMenu);
		
		MenuItem miH1 = new MenuItem("Homework 1");
		miH1.addActionListener(this);
		threeDMenu.add(miH1);
		
		MenuItem miH2 = new MenuItem("Homework 2");
		miH2.addActionListener(this);
		threeDMenu.add(miH2);
		
		MenuItem miH3 = new MenuItem("Homework 3");
		miH3.addActionListener(this);
		threeDMenu.add(miH3);
		
		MenuItem miH4 = new MenuItem("Homework 4");
		miH4.addActionListener(this);
		threeDMenu.add(miH4);
		
		MenuItem miH5 = new MenuItem("Homework 5");
		miH5.addActionListener(this);
		threeDMenu.add(miH5);
		
		
		// End program when window is closed
		
		WindowListener l = new WindowAdapter()
		{
						
			// window closed - exit program						
						public void windowClosing(WindowEvent ev)
						{
							System.exit(0);
						}
						// menu option selected - go to redraw and display method
						public void windowActivated(WindowEvent EV)
						{
							repaint();
						}
						// window resized or refocused - redraw
						public void windowStateChanged(WindowEvent ev)
						{
							repaint();
						}
						
		};
		
		ComponentListener k = new ComponentAdapter()
		{
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

public void actionPerformed (ActionEvent ev)
	{
	// figure out which command was issued
	
	command = ev.getActionCommand();
	
	// take action accordingly
	switch (command)
	{
	case "About":
	{
		repaint();
		break;
	}
	case "Exit":
	{
		System.exit(0);
	}
	case "Problem 1":
	{
		result1 = problem1(scores);
		repaint();
		break;
	}
	case "Problem 2":
	{
		result2 = problem2(numbers);
		repaint();
		break;
	}
	case "Problem 3":
	{
		result3 = problem3(nxn);
		repaint();
		break;
	}
	case "Problem 4":
	{
		result4 = problem4(p);
		repaint();
		break;
	}
	case "Homework 1":
	{
		resultH1 = matrixSTD(nxn1);
		repaint();
		break;
	}
	case "Homework 2":
	{
		rev = reverse(frd);
		repaint();
		break;
	}
	case "Homework 3":
	{
		b = linearize(a);
		repaint();
		break;
	}
	case "Homework 4":
	{
		resultH4 = add(c,d);
		repaint();
		break;
		
	}
	case "Homework 5":
	{
		resultH5 = multiply(c2,d2);
		repaint();
		break;
	}
	}
}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
public void paint(Graphics g)
{
	int ww = this.getWidth();
	// Check Command issued, take action accordingly
	switch(command)
	{
	case "About":
	{
		
		break;
	}
	case "Problem 1":
	{	
		g.drawString( " Number of scores Below Average = "+result1, 300, 200);
		break;	
	}
	case "Problem 2":
	{
		// display array 
		g.setColor(Color.RED);
		g.setFont(title);
		g.drawString("Original Array",ww/2-30,200);
		g.setColor(Color.BLACK);
		g.setFont(text);
		// display Original ARRAY 
		int x = 50;
		int y = 240;
		for(int i=0; i < numbers.length; i++)
		{
			g.drawString(" "+numbers[i],x,y);
			x =x + 35;
			if(x > ww-50)
			{
				x = 50;
				y= y+25;
			
		  }
		
		}
		// display the counts
		g.setColor(Color.RED);
		g.setFont(title);
		y = y +50;
		g.drawString("Frequency of Digits",ww/2-60,y);
		g.setColor(Color.BLACK);
		g.setFont(text);
		y = y + 35;
		x = 50; 
		for ( int i=0; i< result2.length; i++)
		{
			g.drawString(" " + i, x, y - 20);
			g.drawString("____" , x, y - 15);
			g.drawString(" "+result2[i],x,y);
			x =x + 35;
			if(x > ww-50)
			{
				x = 50;
				y = y+25;
			}
		}
			break;
	  }
	  case "Problem 3":
	  {
		  g.setColor(Color.RED);
			g.setFont(title);
			g.drawString("Original Array",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int xs = (ww-nxn[0].length*35)/2;
			int x = xs;
			int y = 240;
			for(int i=0; i < nxn.length; i++)
			{
				for(int j=0;j < nxn[1].length; j++)
				{
			
				g.drawString(" "+nxn[i][j],x,y);
				x =x + 35;
				
				}
				x = xs;
				y = y +25;
			 }
			
			g.drawString("Sum = " + result3, x, y + 25);
			
			break;
	  }
	  case "Problem 4":
	  {
		    g.setColor(Color.RED);
		    g.setFont(title);
			g.drawString("Original Array",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int x = 50;
			int y = 240;
			for(int i=0; i < p.length; i++)
			{
				for(int j = 0; j < p[i].length; j++)
				{
					g.drawString(" "+p[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			
			g.drawString("Result = " + result4, x, y + 25);
	  
			break;

	
	  }
	  case "Homework 1":
	  {
		  g.setColor(Color.RED);
		    g.setFont(title);
			g.drawString("Original Array",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int x = 50;
			int y = 240;
			for(int i=0; i < nxn1.length; i++)
			{
				for(int j = 0; j < nxn1[i].length; j++)
				{
					g.drawString(" "+nxn1[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			g.drawString("Standard Deviation = " + resultH1, x, y+25);
			
			break;
	  }
	  case "Homework 2":
	  {
		    g.setColor(Color.RED);
			g.setFont(title);
			g.drawString("Original Array",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int x = 50;
			int y = 240;
			for(int i=0; i < frd.length; i++)
			{
				g.drawString(" "+frd[i],x,y);
				x =x + 35;
				if(x > ww-50)
				{
					x = 50;
					y= y+25;
			    }
			}
			
			g.setColor(Color.RED);
			g.setFont(title);
			y = y +50;
			g.drawString("Reversed",ww/2-30,y);
			g.setColor(Color.BLACK);
			g.setFont(text);
			y = y + 35;
			x = 50; 
			for ( int i=0; i< rev.length; i++)
			{
				g.drawString(" "+rev[i],x,y);
				x =x + 35;
				if(x > ww-50)
				{
					x = 50;
					y = y+25;
				}
			}
				break;
			
	  }
	  case "Homework 3":
	  {
		  g.setColor(Color.RED);
			g.setFont(title);
			g.drawString("Original Array",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int x = 50;
			int y = 240;
			for(int i=0; i < a.length; i++)
			{
				for(int j = 0; j < a[i].length; j++)
				{
					g.drawString(" "+a[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			
			g.setColor(Color.RED);
			g.setFont(title);
			y = y +50;
			g.drawString("Linear",ww/2-30,y);
			g.setColor(Color.BLACK);
			g.setFont(text);
			y = y + 35;
			x = 50; 
			for ( int i=0; i< b.length; i++)
			{
				g.drawString(" "+b[i],x,y);
				x =x + 35;
				if(x > ww-50)
				{
					x = 50;
					y = y+25;
				}
			}
				break;
	  }
	  case "Homework 4":
	  {
		    g.setColor(Color.RED);
			g.setFont(title);
			g.drawString("Original Arrays",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int x = 50;
			int y = 240;
			for(int i=0; i < c.length; i++)
			{
				for(int j = 0; j < c[i].length; j++)
				{
					g.drawString(" "+c[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			
			g.drawLine(50, y-15, 200, y-15);
			
			for(int i=0; i < d.length; i++)
			{
				for(int j = 0; j < d[i].length; j++)
				{
					g.drawString(" "+d[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			
			g.setColor(Color.RED);
			g.setFont(title);
			y = y +50;
			g.drawString("Added together(-1 means not compatible arrays)",ww/2-30,y);
			g.setColor(Color.BLACK);
			g.setFont(text);
			y = y + 35;
			x = 50; 
			for ( int k=0; k< resultH4.length; k++)
			{
				for(int l = 0; l < resultH4[0].length;l++ )
				{
					g.drawString(" "+resultH4[k][l],x,y);
					x =x + 35;
				
				}
				x = 50;
				y = y+25;
				
			}
				break;
	  }
	  case "Homework 5":
	  {
		  g.setColor(Color.RED);
			g.setFont(title);
			g.drawString("Original Arrays",ww/2-30,200);
			g.setColor(Color.BLACK);
			g.setFont(text);
			// display Original ARRAY 
			int x = 50;
			int y = 240;
			for(int i=0; i < c2.length; i++)
			{
				for(int j = 0; j < c2[i].length; j++)
				{
					g.drawString(" "+c2[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			
			g.drawLine(50, y-15, 200, y-15);
			
			for(int i=0; i < d2.length; i++)
			{
				for(int j = 0; j < d2[i].length; j++)
				{
					g.drawString(" "+d2[i][j],x,y);
					x =x + 35;
				}
				
					x = 50;
					y= y+25;
					
			}
			
			g.setColor(Color.RED);
			g.setFont(title);
			y = y +50;
			g.drawString("Multiplied(-1 means not compatible arrays)",ww/2-30,y);
			g.setColor(Color.BLACK);
			g.setFont(text);
			y = y + 35;
			x = 50; 
			for ( int k=0; k< resultH5.length; k++)
			{
				for(int l = 0; l < resultH5[0].length;l++ )
				{
					g.drawString(" "+resultH5[k][l],x,y);
					x =x + 35;
				
				}
				x = 50;
				y = y+25;
				
			}
				break;
	  }
	 }
	}
public double problem1(double[] a)
{
	double average  = 0.0;
	for(int i =0;i< a.length; i++)
	{
		average = average + a[i];
	}
	average = average/a.length; 
	System.out.println(" average = " +average);
	// count how many smaller than average 
	double count = 0;
	for(int i =0;i< a.length; i++)
	{
		if(a[i] < average)
			count = count +1;
	}
	System.out.println("Count ="+count);
	return count;
}
public int[] problem2(int[] a)
{
	int[] count = new int[10];
	java.util.Arrays.fill(count,0);
	for(int i=0; i<a.length; i++)
	{
		count[a[i]]++;
	}
	return count;
}
public int problem3(int[][] a)
{	

	int k = a.length;
	int sum = 0;
	System.out.println( " k = "+k);
	for(int i = 0; i<k; i++)
	{
		sum = sum + a[i][i];
	}
	System.out.println( " sum = "+sum);
	return sum;
}


public boolean problem4(int[][] a)
{
	for(int row = 0; row < a.length; row++)
	{
		for(int col = 0; col < a[row].length; col++)
		{
			int x = a[row][col];
			
			for(int n = 0; n < 4;n++)
			{
				if(col < a[row].length - 3)
				{
					if(x == a[row][col] && x == a[row][col+1] 
					&& x == a[row][col+2] && x == a[row][col+3])
					{
						return true;
					}
				}
				if(row < a.length - 3)
				{
					if(x == a[row][col] && x == a[row+1][col] 
					&& x == a[row+2][col] && x == a[row+3][col])
					{
						return true;
					}
				}
				if(col < a[row].length - 3 && row < a.length - 3)
				{
					if(x == a[row][col] && x == a[row+1][col+1] 
					&& x == a[row+2][col+2] && x == a[row+3][col+3])
					{
						return true;
					}
				}
				
			}
			
		}
		
	}
	return false;
}

public double matrixSTD(double[][] a)
{
	double avg;
	double sum = 0.0;
	double top = 0.0;
	int count = 0;
	
	for(int i = 0; i < a.length; i++)
	{
		for(int j = 0; j < a[i].length; j ++)
		{
			sum += a[i][j];
			count ++;
		}
	}
	
	avg = sum/count;
	
	for(int i = 0; i < a.length; i++)
	{
		for(int j = 0; j < a[i].length; j ++)
		{
			top += Math.pow(a[i][j] - avg, 2);			
		}
	}
	
	return Math.sqrt(top/count);
}

public int[] reverse(int[] a)
{
	int[] b = new int[a.length];
	int j = a.length -1;
	
	for(int i = 0; i < a.length;i++)
	{
		b[i] = a[j];
		j--;
	}
	
	return b;
}

public int[] linearize(int[][] a)
{
	int[] b = new int[a.length * a[0].length];
	int bCount = 0;
	
	for(int i = 0; i < a.length;i++)
	{
		for(int j = 0; j < a[i].length;j++)
		{
			b[bCount] = a[i][j];
			bCount++;
		}
	}
	
	return b;
}

public int[][] add(int[][] a, int [][]b)
{
	int aRow = a.length;
	int aCol = a[0].length;
	int bRow = b.length;
	int bCol = b[0].length;
	int [][] invalid = {{ -1,-1},
						{ -1, -1}};
	
	
	if(aRow == bRow && aCol == bCol)
	{
		int[][] c = new int[aRow][aCol];
		
		for(int i = 0; i < aRow; i++)
		{
			for(int j = 0; j < aCol; j++)
			{
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		
		return c;
		
	}
	else
	{
		return invalid;
	}
	
}

public int[][] multiply(int[][] a, int[][] b)
{
	int aRow = a.length;
	int aCol = a[0].length;
	int bRow = b.length;
	int bCol = b[0].length;
	
	int [][] invalid = {{ -1,-1},
						{ -1, -1}};
	if(aCol == bRow)
	{
		int[][] c = new int[aRow][bCol];
		
		for(int i = 0; i < aRow; i++)
		{
			for(int j = 0; j < bCol; j++)
			{
				for(int k = 0; k < bRow ; k++)
				{
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
		
	}
	else
	{
		return invalid;
	}
}

}
