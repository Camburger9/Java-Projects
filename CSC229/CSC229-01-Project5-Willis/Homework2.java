
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Homework2 extends Frame implements ActionListener
{
	//  Objects
	String command = "";
	int ww = 0;
	int wh = 0;

	// Colors
	JColorChooser colorChooser = new JColorChooser();
	Color backgroundColor = new Color(0,0,0);
	Color foregroundColor = new Color(255,255,255);
		
	public static void main(String[] args)
	{
		Frame frame = new Homework2();	
		frame.setResizable(true);
		frame.setSize(1000,840);
		frame.setVisible(true);
		
	}
	
	public Homework2()
	{
		setTitle("Graphics");
		
		// Create Menu
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		// 2D Shapes menu
		
		Menu twoDMenu = new Menu("Shapes");
		mb.add(twoDMenu);
		
		MenuItem miProb1 = new MenuItem("Problem1");
		miProb1.addActionListener(this);
		twoDMenu.add(miProb1);
		
		MenuItem miProb2 = new MenuItem("Problem2");
		miProb2.addActionListener(this);
		twoDMenu.add(miProb2);
		
		MenuItem miCircle = new MenuItem("Circle");
		miCircle.addActionListener(this);
		twoDMenu.add(miCircle);
	
		
		
		
		
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

	case "Exit":
	{
		System.exit(0);
	}

	case "Problem1":
	{
		repaint();
		break;
	}
	case "Problem2":
	{
		repaint();
		break;
	}
	case "Circle":
	{
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
	ww = (int)this.getWidth();
	wh = (int)this.getHeight();
	int bar = 45;
	
	switch(command)
	{
	
	case "Problem1":
	{
		
		int x = 20;
		int y = bar + 20;
		int w = ww - 40;
		int h = wh - bar - 40;
		int xMargin = w/4;
		int yMargin = h / 4;
		
		
		g.drawRect(x, y, w, h);
		g.drawLine(x, y, x+w, y+h);
		g.drawLine(x + xMargin, y, x + 3 * xMargin, y+h);
		g.drawLine(x + 2 * xMargin, y, x + 2 * xMargin, y+h);
		g.drawLine(x + 3 * xMargin, y, x + xMargin, y+h);
		g.drawLine(x + w, y, x, y + h);
		g.drawLine(x, y + yMargin, x + w, y + 3 * yMargin);
		g.drawLine(x, y + 2 * yMargin, x + w, y + 2 * yMargin);
		g.drawLine(x, y + 3 * yMargin, x + w, y + yMargin);
		
		break;

	}
	case "Problem2":
	{
		int x = 20;
		int y = bar + 20;
		int w = ww - 40;
		int h = wh - bar - 40;
		int xMargin = w/3;
		int yMargin = h / 3;
		
		g.drawRect(x, y, w, h);
		g.drawLine(x + xMargin, y, x + xMargin, y + h);
		g.drawLine(x + xMargin * 2, y, x + xMargin * 2, y + h);
		g.drawLine(x, y + yMargin, x + w, y + yMargin);
		g.drawLine(x, y + yMargin * 2, x + w, y + yMargin * 2);
		g.drawOval(x, y, xMargin, yMargin);
		g.drawOval(x, y + yMargin * 2, xMargin, yMargin);
		g.drawOval(x + xMargin, y + yMargin, xMargin, yMargin);
		g.drawOval(x + xMargin * 2, y, xMargin, yMargin);
		g.drawOval(x + xMargin * 2, y + yMargin *2, xMargin, yMargin);
		
		break;
	}
	case "Circle":
	{
		int radius;
		int height;
		int width;
		int x = 20;
		int y = bar + 20;
		int w = ww - 40;
		int h = wh - bar - 40;
		
		for(int n = 0; n * 25 < w; n++)
		{
			height = n*20;
			width = n*20;
			radius = n*10;
			g.drawOval((w/2)- radius , (h/2) - radius  , width, height);
		
		}
		
		break;
	}
	
	}
}
		
}
