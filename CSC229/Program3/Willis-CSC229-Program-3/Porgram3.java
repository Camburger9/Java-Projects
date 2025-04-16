import javax.swing.JOptionPane;

public class Porgram3 
{
	public static void main(String[] args)
	{
		menu();
	}
	public static void menu()
	{
		int response = 1;
		while( response != 6)
		{
			String input = JOptionPane.showInputDialog(null,
			"		CSC 229 - Project03 (Math Series)"+"\n"+
			"________________________________________"+"\n"+
			"Select a Series By Pressing Number Associated"+"\n"+
			"                         6 to exit"+"\n"+
			"________________________________________"+"\n"+
			"			 1) 1x2x3x ....... xN"+"\n"+
			" 			2) 1+16+81+.......+N^4 "+"\n"+
			"			 3) 1+3+9+27+ .......+3^N"+"\n"+
			"			 4) 1+1/3+1/5+ .......+ 1/(2N+1)]"+"\n"+
			"			 5)1/1!+1/2!+.......+1/N!"+"\n"+
			"                                   "+"\n"+
			"			 6)EXIT"+"\n"
			,"Math Series",
			JOptionPane.QUESTION_MESSAGE);
			response = Integer.parseInt(input);
			switch(response)
			{
			case 1:				// 1x2x3x....... N
			{
				int n;
				input = JOptionPane.showInputDialog(null,
						"Enter A Positive Integer Number for N",
						"1x2x3x...N",
						JOptionPane.QUESTION_MESSAGE
						);
				n = Integer.parseInt(input);
				double result = factorial(n);
				displayResult(response,n,result);
				break;
			}
			case 2:				// 1+16+81+....... N^4
			{
				int n;
				input = JOptionPane.showInputDialog(null,
						"Enter A Positive Integer Number for N",
						"1+16+81+....... N^4",
						JOptionPane.QUESTION_MESSAGE
						);
				n = Integer.parseInt(input);
				double result = fourth(n);
				displayResult(response,n,result); 
				break;
			}
			case 3:				// 7+49+343+...7^N
			{
				int n;
				input = JOptionPane.showInputDialog(null,
						"Enter A Positive Integer Number for N",
						"1+3+9+27+...3^N",
						JOptionPane.QUESTION_MESSAGE
						);
				n = Integer.parseInt(input);
				double result = series2(n);
				displayResult(response,n,result);
				break;
			}
			case 4:				// 1x2x3x....... N
			{
				int n;
				input = JOptionPane.showInputDialog(null,
						"Enter A Positive Integer Number for N",
						"1 + 1/3 + 1/5 + ... + 1 / (2N + 1) ",
						JOptionPane.QUESTION_MESSAGE
						);
				n = Integer.parseInt(input);
				double result = series1(n);
				displayResult(response,n,result);
				break;
			}
			case 5:				// 4[ 1/1 - 1/3 + 1/5 + ... + (-1)^N / (2N + 1) "
			{
				int n;
				input = JOptionPane.showInputDialog(null,
						"Enter A Positive Integer Number for N",
						"1/1! + 1/2! + 1/3! + ... + 1/N! ",
						JOptionPane.QUESTION_MESSAGE
						);
				n = Integer.parseInt(input);
				double result = onefact(n);
				displayResult(response,n,result);
				break;
			}
			case 6:
			{
				JOptionPane.showMessageDialog(null,
						"			Good Bye",
						"Thank You For Using Math Series",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			}
		}
	}
	public static double factorial(int n)
	{
		double product = 1;
		for (int i = 1; i<=n; i++)
		{
			product = product*i;
		}
		System.out.println("N = "+n+" factorial = "+product);
		return product;
	}
	public static double fourth(int n)
	{
		double product = 1;
		double sum = 0;
		for (int i = 1; i<=n; i++)
		{
			product = Math.pow(i, 4);
			sum += product;
			
		}
		System.out.println("N = "+n+"1+16+81+....... N^4 =" +sum);
		return sum;
	}
	public static double series2(int n)
	{
		double product = 1;
		double sum = 0;
		for (int i = 0; i<=n; i++)
		{
			product = Math.pow(3, i);
			sum += product;
			
		}
		System.out.println("N = "+n+"1+3+9+27+....... 3^N =" +sum);
		return sum;
	}
		public static double series1(int n)
			{
			double numerator = 1;
			double denominator = 0;
			double quotient = 0;
			double sum = 1;
			for (double i = 1; i<=n; i++)
			{
			numerator = 1;
			denominator = ((2*i)+1);
			quotient = numerator/denominator;
			sum = sum + quotient;
			}
			return sum;

	}
	public static double onefact(int n)
	{
		double product = 0;
		double sum = 0;
		for (int i = 1; i<=n; i++)
		{
			product = 1.0/factorial(i);
			sum += product;
		}
		System.out.println("1/1! + 1/2! + 1/3! + ... + 1/N!  =" +sum);
		return sum;
	}
	public static void displayResult(int response,int n,double result)
	{
	
		switch(response)
		{
		case 1:
		{
			JOptionPane.showMessageDialog(null,
				"			CSC 229 - Project03 (Math Series)"+"\n"+
				"____________________________________________"+"\n"+
				"				1 x 2 x 3 x ....... x "+n+" = "+(long)result+"\n"+
				"____________________________________________",
				"Math Series",
				JOptionPane.INFORMATION_MESSAGE
				);
			break;
		}
		case 2:
		{
			JOptionPane.showMessageDialog(null,
				"			CSC 229 - Project03 (Math Series)"+"\n"+
				"____________________________________________"+"\n"+
				"				1 + 16 + 81 + ....... + N^"+" "+n+" = "+(long)result+"\n"+
				"____________________________________________",
				"Math Series",
				JOptionPane.INFORMATION_MESSAGE
				);
			break;
		}
		case 3:
		{
			JOptionPane.showMessageDialog(null,
				"			CSC 229 - Project03 (Math Series)"+"\n"+
				"____________________________________________"+"\n"+
				"				7 + 49 + 343 + ....... + 7^"+n+" = "+(long)result+"\n"+
				"____________________________________________",
				"Math Series",
				JOptionPane.INFORMATION_MESSAGE
				);
			break;
		}
		case 4:
		{
			JOptionPane.showMessageDialog(null,
				"			CSC 229 - Project03 (Math Series)"+"\n"+
				"____________________________________________"+"\n"+
				"				1+ 1/3 + 1/5  ...+ 1/(2*"+n+"+1) = "+(double)result+"\n"+
				"____________________________________________",
				"Math Series",
				JOptionPane.INFORMATION_MESSAGE
				);
			break;
		}
		case 5:
		{
			JOptionPane.showMessageDialog(null,
				"			CSC 229 - Project03 (Math Series)"+"\n"+
				"____________________________________________"+"\n"+
				"				1/1! + 1/2! + 1/3! + ... + 1/"+n+"! = "+(double)result+"\n"+
				"____________________________________________",
				"Math Series",
				JOptionPane.INFORMATION_MESSAGE
				);
			break;
		}
		default:     // response is out of range
		{
			JOptionPane.showMessageDialog(null,
					"Please Enter Numbers Between 1 and 6",
					"Incorrect Selection",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		}
	}
}
