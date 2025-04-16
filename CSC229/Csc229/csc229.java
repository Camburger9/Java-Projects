import javax.swing.*;
public class csc229
{
	public static void main(String[] args)
	{
		// define data items
		String firstName;
		String lastName;
		String input;
		String input2;
		String input3;
		String address;
		String city;
		String state;
		String zipCode;
		double principal;
		double interest;
		double years;
		double k;
		double a;
		double m;
		double payment;
		double roundedPayment;
		//prompt user for values
		firstName = JOptionPane.showInputDialog(null, 
				  "Enter Your First Name",
				  "First Name",
				  JOptionPane.QUESTION_MESSAGE);
		lastName = JOptionPane.showInputDialog(null, 
				  "Enter Your Last Name",
				  "Last Name",
				  JOptionPane.QUESTION_MESSAGE);
		address = JOptionPane.showInputDialog(null, 
				  "Enter Your Address",
				  "Address",
				  JOptionPane.QUESTION_MESSAGE);
		city = JOptionPane.showInputDialog(null, 
				  "Enter Your City",
				  "City",
				  JOptionPane.QUESTION_MESSAGE);
		state = JOptionPane.showInputDialog(null, 
				  "Enter Your state",
				  "State",
				  JOptionPane.QUESTION_MESSAGE);
		zipCode = JOptionPane.showInputDialog(null, 
				  "Enter Your Zip Code",
				  "Zip Code",
				  JOptionPane.QUESTION_MESSAGE);
		input = JOptionPane.showInputDialog(null, 
		          "Enter Loan Amount",
		          "Principal",
		          JOptionPane.QUESTION_MESSAGE);
		input2 = JOptionPane.showInputDialog(null, 
		          "Enter Intrest Rate",
		          "Intereest",
		          JOptionPane.QUESTION_MESSAGE);
		input3 = JOptionPane.showInputDialog(null, 
		          "Enter The Length of The Loan in Years",
		          "Years",
		          JOptionPane.QUESTION_MESSAGE);
        principal = Double.parseDouble(input);
        interest = Double.parseDouble(input2);
        years = Double.parseDouble(input3);
        //calculations
        k = interest/12/100;
        m = years*12;
        payment = (principal*(k*(Math.pow(1+k, m))))/(Math.pow(1+k, m)-1);
        roundedPayment = ((int) (payment * 100)) / 100.0;
        // opening the final menu//
		JOptionPane.showMessageDialog(null,
		"         Mortgage Loan Calculator     "   +"\n"+	                
		" _____________________________________"   +"\n"+ 
		"           Personal Information       "   +"\n"+
		"______________________________________"   +"\n"+
		"  First Name   : " + firstName            +"\n"+
		"  Last Name    : " + lastName			   +"\n"+
		"  Address      : " +address               +"\n"+
		"               : " +city+", "+state+", "+zipCode +"\n"+
		" _____________________________________"   +"\n"+
		"				Loan Terms             "   +"\n"+
		" _____________________________________"   +"\n"+
		" Principal      : " +principal            +"\n"+
		" Interest       : " +interest+ "%"        +"\n"+
		" Loan Length    : " +years                +"\n"+
		" _____________________________________"   +"\n"+ 
		"             Monthly Payment          "   +"\n"+
		" _____________________________________"   +"\n"+
		" Monthly payment: " +roundedPayment       +"\n"
		,"Project 1 - Mortgage Calculator",+
		JOptionPane.INFORMATION_MESSAGE);
		//The program examples listed where rounded to the nearest dollar, My programs calculations are down to cents.
	}
	
}

