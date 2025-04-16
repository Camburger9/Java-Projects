import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;


public class Project06 extends Frame implements ActionListener
{
		
	String command = "";
	int key;
	int n;
	int colWidth = 35;
	boolean found;
	Font text = new Font("SansSerif",Font.BOLD,12);
	Font heading = new Font("SansSerif",Font.BOLD,16);
	Font f2 = new Font("SanSerif",Font.BOLD,30);
	
	Matrix originalArray;
	Matrix secondArray;
	Matrix result ;
	public static void main(String[] args)
	{
		Frame frame = new Project06();	
		frame.setResizable(true);
		frame.setSize(1700,1200);
		frame.setVisible(true);
	}
	
	public Project06()
	{
		setTitle("CSC 229 - Project 6 - Matrix");
		
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
		
		Menu actionMenu = new Menu("Two Dimensional Array");
		mb.add(actionMenu);
		
		Menu mCreate = new Menu("Create Array");
		actionMenu.add(mCreate);
		
		MenuItem miRandom = new MenuItem("Randomly");
		miRandom.addActionListener(this);
		mCreate.add(miRandom);
		
		MenuItem miFile = new MenuItem("From File");
		miFile.addActionListener(this);
		mCreate.add(miFile);
		
		Menu statsMenu = new Menu("Statistics");
		actionMenu.add(statsMenu);
		
		MenuItem miMinimum = new MenuItem("Minimum");
		miMinimum.addActionListener(this);
		statsMenu.add(miMinimum);
		
		MenuItem miMaximum = new MenuItem("Maximum");
		miMaximum.addActionListener(this);
		statsMenu.add(miMaximum);
		
		MenuItem miAverage = new MenuItem("Average");
		miAverage.addActionListener(this);
		statsMenu.add(miAverage);
		
		MenuItem miSTD = new MenuItem("Standard Deviation");
		miSTD.addActionListener(this);
		statsMenu.add(miSTD);
		
		MenuItem miRCstat = new MenuItem("Row & Column Stats");
		miRCstat.addActionListener(this);
		statsMenu.add(miRCstat);
		
		MenuItem miSearch = new MenuItem("Search");
		miSearch.addActionListener(this);
		actionMenu.add(miSearch);
		
		// array operations
		Menu opsMenu = new Menu("Operations");
		
		actionMenu.add(opsMenu);
		
		MenuItem miAdd = new MenuItem("Add");
		miAdd.addActionListener(this);
		opsMenu.add(miAdd);
		
		MenuItem miSubtract = new MenuItem("Subtract");
		miSubtract.addActionListener(this);
		opsMenu.add(miSubtract);
		
		MenuItem miMultiply = new MenuItem("Multiply");
		miMultiply.addActionListener(this);
		opsMenu.add(miMultiply);
		// End program when window is closed
		
		WindowListener l = new WindowAdapter()
		{
						
			// window closed - exit program						
						public void windowClosing(WindowEvent ev)
						{
							System.exit(0);
						}
						// menu option selected - go to redraw and display method
						public void listener(WindowEvent ev)
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
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
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
		switch(command)
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
			case "Randomly":
			{
				originalArray = new Matrix();
				originalArray.createRandomly();
				secondArray = null;
				result = null;
				repaint();
				break;
			}
			case "From File":
			{
				originalArray = new Matrix();
				originalArray.createFromFile();
				secondArray = null;
				result = null;
				repaint();
				break;
			}
			case "Minimum":
				{	
					repaint();
					break;
				}
			case "Maximum":		    
				{
					repaint();
					break;
				}
			case "Average":
				{	
					double avg = originalArray.getAverage();
					repaint();
					break;
				}
			case "Standard Deviation":
				{	
					repaint();
					break;
				}
			case "Row & Column Stats":
			{
				repaint();
				break;
			}
			case "Search":
			{
				
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
						"Search Key",JOptionPane.QUESTION_MESSAGE);
			    key = Integer.parseInt(input);
			    found = originalArray.search(key);
				repaint();
				break;
			}
			case "Add":
			{
				if (originalArray == null)
				{
					originalArray = new Matrix();
					originalArray.createRandomly();
				}
				if(secondArray == null)
				{
					secondArray = new Matrix();
					secondArray.createRandomly();
				}
				result = originalArray.add(secondArray);
				repaint();
				break;
			}
			case "Subtract":
			{
				if (originalArray == null)
				{
					originalArray = new Matrix();
					originalArray.createRandomly();
				}
				if(secondArray == null)
				{
					secondArray = new Matrix();
					secondArray.createRandomly();
				}
				result = originalArray.subtract(secondArray);
				repaint();
				break;
			}
			case "Multiply":
			{
				if (originalArray == null)
				{
					originalArray = new Matrix();
					originalArray.createRandomly();
				}
				if(secondArray == null)
				{
					secondArray = new Matrix();
					secondArray.createRandomly();
				}
				
				result = originalArray.multiply(secondArray);
				repaint();
				break;
//				boolean comp = false;
//				while (!comp)
//				{
//					switch(command)
//					{
//					case "Add":
//					case "Subtract":
//					{
//						// complete
//						break;	
//					}
//					case "Multiply":
//					{
//						// complete
//						break;	
//					}
//					}
//				}
//				if(command.equals("Add"))
//					result = originalArray.add(secondArray);
//				if(command.equals("Subtract"))
//					result = originalArray.subtract(secondArray);
//				if(command.equals("Multiply"))
//					result = originalArray.multiply(secondArray);
//				
//				repaint();
//				break;
			}
			
		}// switch
	
	}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
			// Check Command issued, take action accordingly
			int ww = this.getWidth();
			g.setFont(text);
		switch(command)
		{
			case "Randomly":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
					colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/2;
				System.out.println(" ww = "+ww+" colWidth = "+colWidth+"x = "+x);
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				
				break;
			}
			case "From File":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/2;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				break;
			}
			case "Minimum":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww-colWidth*t[0].length)/2;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				
				g.drawString("Minimum = "+originalArray.getMinimum(),
							x + 100, currentY);
				break;
			}
			case "Maximum":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww-colWidth*t[0].length)/2;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				
				g.drawString("Maximum = "+originalArray.getMaximum(),
							x + 100, currentY);
				break;
			}
			case "Average":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww-colWidth*t[0].length)/2;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				System.out.println(originalArray.getAverage());
				g.drawString("Average = "+ originalArray.getAverage(),
							x + 100, currentY);
				break;
			}
			case "Standard Deviation":
			{
				
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww-colWidth*t[0].length)/2;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				System.out.println(originalArray.getAverage());
				g.drawString("Standard Deviation = "+ originalArray.getSTD(),
							x + 100, currentY);
				break;
				
//				int y = 100;
//				long[][] t = originalArray.getArray();
//				colWidth = digits(originalArray);
//				int x = (ww-colWidth*t[0].length);
//				int currentY = displayArray(g,t,x,y,ww,"Original Array");
//				switch(command)
//				{
//				case"maximum":
//				{
//					g.drawString("Maximum = "+originalArray.getMaximum(),
//							x + 100, currentY);
//					break;
//				}
//				}
				// complete

			}
			case "Row & Column Stats":
			{
				// display Original Array
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/4;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
	
				
				
				// display row stats
				
				int y2 = 200;
				long[][] t2 = originalArray.getRowStat();
				colWidth = digits(originalArray);
				int x2 = (ww - colWidth*t[0].length)/4;
				int currentY2 = displayArray(g,t2,x2,y2,ww,"rowStat");
				
				
				// display column stats
				
				int y3 = 300;
				long[][] t3 = originalArray.getColStat();
				colWidth = digits(originalArray);
				int x3 = (ww - colWidth*t[0].length)/4;
				int currentY3 = displayArray(g,t3,x3,y3,ww,"colStat");
				
				
				break;
				
			}
			case "Search":
			{
				String searchResult = " ";
				int y = 100;
				int currentY;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/4;
				if(found)
				{
					searchResult = "Found";
					currentY = displayArraySearch(g,t,x,y,ww,"Original Array",key);
				}
				else
				{
					searchResult = " Not Found";
					currentY = displayArray(g,t,x,y,ww,"Original Array");
				}
				g.setColor(Color.RED);
				g.drawString("Search Key --->" + key + "<---" + searchResult, x, currentY + 100);
				
				//complete
				break;
			}
			case "Add":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/4;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				
				int y2 = 100;
				long[][] t2 = secondArray.getArray();
				colWidth = digits(secondArray);
				int x2 = (ww - colWidth*t2[0].length)/2;
				int currentY2 = displayArray(g,t2,x2,y2,ww,"Second Array");
				
				int y3 = 300;
				long[][] t3 = result.getArray();
				colWidth = digits(result);
				int x3 = (ww - colWidth*t3[0].length)/3;
				int currentY3 = displayArray(g,t3,x3,y3,ww,"Result");
				break;
				
			}
			case "Subtract":
			{
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/4;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				
				int y2 = 100;
				long[][] t2 = secondArray.getArray();
				colWidth = digits(secondArray);
				int x2 = (ww - colWidth*t2[0].length)/2;
				int currentY2 = displayArray(g,t2,x2,y2,ww,"Second Array");
				
				int y3 = 300;
				long[][] t3 = result.getArray();
				colWidth = digits(result);
				int x3 = (ww - colWidth*t3[0].length)/3;
				int currentY3 = displayArray(g,t3,x3,y3,ww,"Result");
				break;
			}
			case "Multiply":
			{
				
//				long[][] a,b,c;
//				
//				 a = originalArray.getArray();
//				 b = secondArray.getArray();
//				 c = result.getArray();
//// determine the column width for A
//				 colWidth = digits(originalArray);
//// determine the column width for B
//// determine the column width for C
				int y = 100;
				long[][] t = originalArray.getArray();
				colWidth = digits(originalArray);
				int x = (ww - colWidth*t[0].length)/4;
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				
				int y2 = 100;
				long[][] t2 = secondArray.getArray();
				colWidth = digits(secondArray);
				int x2 = (ww - colWidth*t2[0].length)/2;
				int currentY2 = displayArray(g,t2,x2,y2,ww,"Second Array");
				
				int y3 = 300;
				long[][] t3 = result.getArray();
				colWidth = digits(result);
				int x3 = (ww - colWidth*t3[0].length)/3;
				int currentY3 = displayArray(g,t3,x3,y3,ww,"Result");
				break;
				
				
			}
	
		}
			
		}
		public int displayArray(Graphics g, long[][] a, int x, int y, int ww, String title)
		{
			g.setFont(heading);
			g.setColor(Color.RED);
			g.drawString(title, x+100, y);
			g.setFont(text);
			g.setColor(Color.BLACK);
			y = y + 35;
			int xs = x;
			for (int row=0; row<a.length; row++)
			{
				for (int col = 0; col < a[row].length; col++)
				{
					g.drawString(""+a[row][col],x,y);
					x = x+colWidth;
				}
				x = xs;
				y = y+20;
			}
			return y+20;
		}
		
		public int displayArraySearch(Graphics g, long[][] a, int x, int y, int ww, String title,int key)
		{
			g.setFont(heading);
			g.setColor(Color.RED);
			g.drawString(title, x+100, y);
			g.setFont(text);
			g.setColor(Color.BLACK);
			y = y + 35;
			int xs = x;
			for (int row=0; row<a.length; row++)
			{
				for (int col = 0; col < a[row].length; col++)
				{
					if(a[row][col] == key)
					{
						g.setColor(Color.RED);
						g.drawString(""+a[row][col],x,y);
						x = x+colWidth;
						g.setColor(Color.BLACK);
					}
					else
					{
						g.drawString(""+a[row][col],x,y);
						x = x+colWidth;
					}
					
				}
				x = xs;
				y = y+20;
			}
			return y+20;
		}
		public void drawGrid(Graphics g,int x, int y, int r, int c)
		{
			// draw horizontal lines
			
			// draw vertical lines
			
		}
		public int digits(Matrix a)
		{
			// given a matrix returns the number of pixels needed to display an element
			int s = 1;
			long max = a.getMaximum();
			long min = a.getMinimum();
			if(max<0|| min<0)
			{
				max = Math.max(Math.abs(max), Math.abs(min));
				s = 2;
			}
			
			while(max/s > 0)
			{	
				max = max/10;
				s ++;
			}
			System.out.println(" s = "+s);
			return 10*s+5;	
		}
	}