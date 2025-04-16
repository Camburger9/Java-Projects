import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class Matrix 
{
	private long[][] array;
	private long low;
	private long high;
	
public Matrix(int r, int c, int l, int h)
{
	array = new long[r][c];
	for (int i=0; i<r; i++)
		for (int j=0; j<c; j++)
    	array[i][j] = l + (int)((h-l+1)*Math.random());
}
public Matrix()
{
	low = 1;
	high = 100;
	array = new long[10][10];
	for (int i=0; i<10; i++)
		for (int j=0; j<10; j++)
    	array[i][j] = low + (int)((high-low+1)*Math.random());
}
public long[][] getArray() { return array;}
public long getLow() { return low;}
public long getHigh() { return high;}
public void createRandomly()
{
	String input = JOptionPane.showInputDialog(null,"Please enter an integer < 50:",
			"# Rows of Two-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    int r =Integer.parseInt(input);
    
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 50:",
			"# Colums of Two-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    int c =Integer.parseInt(input);
    
    array = new long[r][c];
    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
			"Lowest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    low = Integer.parseInt(input);
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000,000:",
			"Highest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    high = Integer.parseInt(input);
    for (int i=0; i<array.length; i++)
    	for (int j=0; j<array[i].length; j++)
    	array[i][j] = low + (long)((high-low+1)*Math.random());
}
public void createFromFile()
{
	String dataFilePath = null;
	String dataFileName = null;
	JFileChooser chooser= new JFileChooser();
	chooser.setDialogType(JFileChooser.OPEN_DIALOG);
	chooser.setDialogTitle("Open Text File");
	int returnVal = chooser.showOpenDialog(null);
	if( returnVal == JFileChooser.APPROVE_OPTION) 
	{
		dataFilePath = chooser.getSelectedFile().getPath();
		dataFileName = chooser.getSelectedFile().getName();
	}
	try
	{
		readFileIntoArray(dataFilePath);
	}
	catch (IOException ioe)
	{
		System.exit(0); 
	}
}
public void readFileIntoArray(String dataFilePath) throws IOException
{
	if (dataFilePath != null)
	{
		Scanner integerTextFile = new Scanner(new File(dataFilePath));
		
		int rows = integerTextFile.nextInt();
		int cols = integerTextFile.nextInt();
		array = new long[rows][cols];
		
		while (integerTextFile.hasNextInt())
		{
			for (int i = 0; i <rows; i++)
			for (int j=0; j < cols; j++)
				array[i][j] = integerTextFile.nextInt();
		}
		low = this.getMinimum();
		high = this.getMaximum();
		//  end of file detected
		integerTextFile.close();
	}
}
public long getMaximum()
{
	long max = Long.MIN_VALUE;
	// complete
	for (int row=0; row<array.length; row++)
	{
		for (int col = 0;col <array[0].length; col++)
		{
			if(array[row] [col] > max)
				max = array[row][col];
		}
	}
	return max;
}
public long getMinimum()
{
	long min = Integer.MAX_VALUE;
	// complete
	return min;
}
public double getAverage()
{
	double average = 0;
	//complete
	return average;
}
public double getSTD()
{
	double std = 0;
	
	// complete
	return std;
}
public boolean search(int key)
{
	//complete
	return false;
}
public long[][] getRowStat() 
{ 
	long rowMin, rowMax, rowSum;
	long[][] rowStat = new long[array.length][3];
	// complete
	return rowStat;
}
public long[][] getColStat() 
{ 
	long colMin, colMax, colSum;
	long[][] colStat = new long[3][array[0].length];
	//calculate column statistics

	return colStat;
}

public Matrix add(Matrix x)
{
	Matrix r = null;
	long[][] a = this.getArray();
	long[][] b = x.getArray();
	// check compatibility -- # rows & # col are the same
	if(a.length == b.length && a[0].length == b[0].length)
	{
		long[][] c = new long[a.length][a[0].length];
		for(int row = 0; row<a.length; row++)
			for(int col = 0; col < a[row].length; col++)
			{
				c[row][col] = a[row][col] + b[row][col];
			}
	}
		// find the minimum and maximum of the array
		
	else
		return null;
	//complete logic
	return r;
}
public Matrix subtract(Matrix x)
{
	Matrix r = null;
	long[][] a = this.getArray();
	long[][] b = x.getArray();
	// check compatibility
	// complete logic
	return r;
}
public Matrix multiply(Matrix x)
{
	Matrix r = null;
	long[][] a = this.getArray();
	long[][] b = x.getArray();
	// check compatibility
	//complete logic
	return r;
}

}