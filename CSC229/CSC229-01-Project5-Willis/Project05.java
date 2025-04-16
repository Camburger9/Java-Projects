
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Project05 extends Frame implements ActionListener
{
	//  Objects
	Line l;
	Rectangle r;
	Parallelogram p;
	Elipse e;
	Cube c;
	Cylinder cyl;
	Cone con;
	
	String command = "";

	// Colors
	JColorChooser colorChooser = new JColorChooser();
	Color backgroundColor = new Color(0,0,0);
	Color foregroundColor = new Color(255,255,255);
		
	public static void main(String[] args)
	{
		Frame frame = new Project05();	
		frame.setResizable(true);
		frame.setSize(1000,840);
		frame.setVisible(true);
		
	}
	
	public Project05()
	{
		setTitle("Project 5 - Willis");
		
		// Create Menu
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miColor = new MenuItem("Color");
		miColor.addActionListener(this);
		fileMenu.add(miColor);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		// 2D Shapes menu
		
		Menu twoDMenu = new Menu("2D Shapes");
		mb.add(twoDMenu);
		
		MenuItem miLine = new MenuItem("Line");
		miLine.addActionListener(this);
		twoDMenu.add(miLine);
		
		MenuItem miRectangle = new MenuItem("Rectangle");
		miRectangle.addActionListener(this);
		twoDMenu.add(miRectangle);
		
		MenuItem miParalellogram = new MenuItem("Parallelogram");
		miParalellogram.addActionListener(this);
		twoDMenu.add(miParalellogram);
		
		MenuItem miElipse = new MenuItem("Elipse");
		miElipse.addActionListener(this);
		twoDMenu.add(miElipse);
	
		
		// 3D Shapes Menu
		
		Menu threeDMenu = new Menu("3D Shapes");
		mb.add(threeDMenu);
		
		MenuItem miCube = new MenuItem("Cube");
		miCube.addActionListener(this);
		threeDMenu.add(miCube);
		
		MenuItem miCylinder = new MenuItem("Cylinder");
		miCylinder.addActionListener(this);
		threeDMenu.add(miCylinder);		
		
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
	case "Color":
	{
		backgroundColor = JColorChooser.showDialog(
									                     null,
									                     "Choose Background Color",
									                     colorChooser.getBackground());

		foregroundColor = JColorChooser.showDialog(
									                     null,
									                     "Choose Drawing Color",
									                     colorChooser.getBackground());
		repaint();
		break;
	}
	case "Line":
	{
		l =  new Line();
		l.getAttributes();
		repaint();
		break;
	}
	case "Rectangle":
	{
		r =  new Rectangle();
		r.getAttributes();
		repaint();
		break;
	}
	case "Parallelogram":
	{
		p =  new Parallelogram();
		p.getAttributes();
		repaint();
		break;
	}
	case "Elipse":
	{
		e =  new Elipse();
		e.getAttributes();
		repaint();
		break;
	}
	case "Cube":
	{
		c =  new Cube();
		c.getAttributes();
		repaint();
		break;
	}
	case "Cylinder":
	{
		cyl =  new Cylinder();
		cyl.getAttributes();
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
	
	// Check Command issued, take action accordingly
	switch(command)
	{
	case "About":
	{
		g.drawString(" Geometric Shapes",400, 100);
		g.drawLine (350,120, 550,120);
		g.drawString(" This program supports the entry of values of primary attributes and calculation of secondary " , 200, 140);
		g.drawString(" attributes (sides, angels, perimeter, area, surface, volume of the following shapes: " , 200, 160);
		
		g.drawString(" 1.      Line", 400, 200);
		g.drawString(" 2.      Rectangle", 400, 220);
		g.drawString(" 3.      Elipse", 400, 240);
		g.drawString(" 4.      Parlellogram", 400, 260);
		g.drawString(" 5.      Cube", 400, 280);
		g.drawString(" 6.      Cylinder", 400, 300);
		g.drawString(" 7.      Cone", 400, 220);
		
		break;
	}
	case "Color":
	{
		this.setBackground(backgroundColor);
		this.setForeground(foregroundColor);
		break;	
	}
	case "Line":
	{
		int x1 = l.getX1();
		int y1 = l.getY1();
		int x2 = l.getX2();
		int y2 = l.getY2();
		//Draw the rectangle.
		g.drawLine(x1,y1,x2,y2);
		g.drawString("("+x1+","+y1+")",x1+15,y1);
		g.drawString("("+x2+","+y2+")",x2+15,y2);
		g.drawString(" "+Round.roundDigits(l.getLineLength(),2),(((x1+x2)/2)+15),((y1+y2)/2));

		// display attributes
		g.drawString("Line Properties",70, 90);
		g.drawLine(30,100,230,100);
		g.drawString("Point 1", 60, 120);
		g.drawString(" = "+"("+x1+","+y1+")", 140, 120);
		g.drawString("Point 2", 60, 140);
		g.drawString(" = "+"("+x2+","+y2+")", 140, 140);
		g.drawString("Line Length", 60, 160);
		g.drawString(" = "+Round.roundDigits(l.getLineLength(),2), 140, 160);
		g.drawRect(25, 70, 210, 155);
		break;
	}
	case "Rectangle":
	{
		int x = r.getxTopLeft();
		int y = r.getyTopLeft();
		int w = r.getWidth();
		int h = r.getHeight();
		//Draw the rectangle.
		g.drawRect(x,y,w,h);
		g.drawString("("+x+","+y+")",x-20,y-15);
		g.drawString(" "+w, x+w/2, y-15);
		g.drawString(" "+h, x-30, y+h/2);
		// display attributes
		g.drawString("Rectangle Properties",70, 90);
		g.drawLine(30,100,230,100);
		g.drawString("TopLeft Corner", 60, 120);
		g.drawString(" = "+"("+x+","+y+")", 140, 120);
		g.drawString("Width", 60, 140);
		g.drawString(" = "+w, 140, 140);
		g.drawString("Height", 60, 160);
		g.drawString(" = "+h, 140, 160);
		g.drawString("Perimeter", 60, 180);
		g.drawString(" = "+r.getPerimeter(), 140, 180);
		g.drawString("Area", 60, 200);
		g.drawString(" = "+r.getArea(), 140, 200);
		g.drawRect(25, 70, 210, 155);
		break;
	}
	case "Parallelogram":
	{
		int x1 = p.getX();
		int y1 = p.getY();
		int x2 = p.getX2();
		int y2 = p.getY2();
		int w  = p.getWidth();
		//Coordinates
		g.drawString("("+x1+","+y1+")",x1-20,y1-10);
		g.drawString("("+x2+","+y2+")",x2-20,y2+15);
		g.drawString(" "+w, (x1+(w/2)),y1-10);
		//Draw the Paralellogram 
		g.drawLine(x1, y1,x1+w , y1);
		g.drawLine(x2, y2,x2+w , y2);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x1+w, y1,x2+w , y2);
		// Display attributes
		g.drawString("Parallelogram Properties",70, 90);
		g.drawLine(30,100,230,100);
		g.drawString("TopLeft Corner", 50, 120);
		g.drawString(" = "+"("+x1+","+y1+")", 160, 120);
		g.drawString("Bottom Left Corner", 50, 140);
		g.drawString(" = "+"("+x2+","+y2+")", 160, 140);
		g.drawString("Width", 50, 160);
		g.drawString(" = "+w, 160, 160);
		g.drawString("Perimeter", 50, 180);
		g.drawString(" = "+Round.roundDigits(p.getPerimeter(),2) , 160, 180);
		g.drawString("Area", 50, 200);
		g.drawString(" = "+Round.roundDigits(p.getArea(), 2), 160, 200);
		g.drawRect(25, 70, 210, 155);
		break;
	}
	case "Elipse":
	{
		int x = e.getX();
		int y = e.getY();
		int h  = e.getHeight();
		int w  = e.getWidth();
		//Coordinates
		g.drawString("("+x+","+y+")",x,y);
		g.drawString(" "+h, 20+x+w/2, y+h/4);
		g.drawString(" "+w, 20+x+w/4, y+(4*h)/7);
		//Draw the Elipse 
		g.drawOval(x, y, w, h);
		g.drawLine(x+w/2,y,x+w/2,y+h);
		g.drawLine(x,y+h/2,x+w,y+h/2);
		// Display attributes
		g.drawString("Elipse Properties",70, 90);
		g.drawLine(30,100,230,100);
		g.drawString("TopLeft Corner", 50, 120);
		g.drawString(" = "+"("+x+","+y+")", 135, 120);
		g.drawString("Width", 50, 140);
		g.drawString(" = "+w, 135, 140);
		g.drawString("Height",50,160);
		g.drawString(" = "+h, 135, 160);
		g.drawString("Perimeter", 50, 180);
		g.drawString(" = "+Round.roundDigits(e.getPerimeter(),2) , 135, 180);
		g.drawString("Area", 50, 200);
		g.drawString(" = "+Round.roundDigits(e.getArea(), 2), 135, 200);
		g.drawRect(25, 70, 215, 155);
		break;
	}

	case "Cube":
	{
		int x = c.getxTopLeft();
		int y = c.getyTopLeft();
		int w = c.getWidth();
		int h = c.getHeight();
		int d = c.getDepth();
		//Draw the cube.
		g.drawRect(x,y,w,h);
		g.drawString("("+x+","+y+")",x-50,y-25);
		g.drawString(" "+w, x+w/2, y-5);
		g.drawString(" "+h, x-30, y+h/2);
		g.drawString(" "+d, x+w+15, y);
		//Draw some other lines
		g.drawLine(x, y, x+w/4, y-w/4);
		g.drawLine(x+w, y, x+w/4+w, y-w/4);
		g.drawLine(x+w/4, y-w/4, x+w/4+w, y-w/4);
		g.drawLine(w+x+w/4, h+y-w/4, x+w/4+w, y-w/4);
		g.drawLine(x+w, y+h, x+w/4+w, y-w/4+h);
		// display attributes
		g.drawString("Cube Properties",90, 90);
		g.drawLine(30,100,230,100);
		g.drawString("TopLeft Corner", 60, 120);
		g.drawString(" = "+"("+x+","+y+")", 140, 120);
		g.drawString("Width", 60, 140);
		g.drawString(" = "+w, 140, 140);
		g.drawString("Height", 60, 160);
		g.drawString(" = "+h, 140, 160);
		g.drawString("Deptth", 60, 180);
		g.drawString(" = "+d, 140, 180);
		g.drawString("Surface Area", 60, 200);
		g.drawString(" = "+c.getSurfaceArea(), 140, 200);
		g.drawString("volume", 60, 220);
		g.drawString(" = "+c.getVolume(), 140, 220);
		g.drawRect(25, 70, 210, 175);
		break;
	}
	case "Cylinder":
	{
		int x = cyl.getX();
		int y = cyl.getY();
		int h = cyl.getHeight();
		int r = cyl.getRadius();
		//Coordinates
		g.drawString("("+x+","+y+")",x+r-25,y+r/4+15);
		g.drawString(" "+h,x+r+15, y-h/2);
		g.drawString(" "+r, x+r*2-65, y+r/4-5);
		// Draw the Cylinder
		g.drawOval(x,  y, r*2, r/2);
	    g.drawOval(x, y-h, r*2, r/2);
	    g.drawLine(x, y+r/4, x, y-h+r/4);
	    g.drawLine(x+r*2, y+r/4 ,x+r*2,y-h+r/4);
	    g.drawLine(x+r, y+r/4, x+r, y-h+r/4);
	    g.drawLine(x+r, y+r/4, x+r*2, y+r/4);
	    //Display attributes
	    g.drawString("Clyinder Properties",90, 90);
		g.drawLine(30,100,230,100);
		g.drawString("Center of Base", 60, 120);
		g.drawString(" = "+"("+x+","+y+")", 140, 120);
		g.drawString("Raidius", 60, 140);
		g.drawString(" = "+r, 140, 140);
		g.drawString("Height", 60, 160);
		g.drawString(" = "+h, 140, 160);
		g.drawString("Surface Area", 60, 180);
		g.drawString(" = "+Round.roundDigits(cyl.getSurfaceArea(),2), 140, 180);
		g.drawString("volume", 60, 200);
		g.drawString(" = "+Round.roundDigits(cyl.getVolume(),2), 140, 200);
		g.drawRect(25, 70, 210, 175);
		break;
	}
	}
}
		
}

