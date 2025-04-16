import javax.swing.*;
public class csc229
//This is less than pretty but its functional with an inaccuracy of up to cent
{
	public static void main(String[] args)
	{
		// define data items
		String firstName;
		String lastName;
		String input;
		String input2;
		String input3;
		String input4;
		String input5;
		String address;
		String city;
		String state;
		String zipCode;
		String propName = "";
		double score = 0;
		double creditScore;
		double income;
		double propertyType;
		double principal;
		double interest;
		double years;
		double k;
		double a;
		double m;
		double payment;
		double roundedPayment;
		double points;
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
		          "Enter Credit Score",
		          "CreditScore",
		          JOptionPane.QUESTION_MESSAGE);
		input3 = JOptionPane.showInputDialog(null, 
		          "Enter Income",
		          "Income",
		          JOptionPane.QUESTION_MESSAGE);
		input4 = JOptionPane.showInputDialog(null, 
		          "Enter Property Type,\n 1 for single family home,\n 2 for comercial, 3 for condos,\n 4 for land, or 5 for other:",
		          "Property Type",
		          JOptionPane.QUESTION_MESSAGE);
		input5 = JOptionPane.showInputDialog(null, 
		          "Enter the length of your loan in years",
		          "Years",
		          JOptionPane.QUESTION_MESSAGE);
        principal = Double.parseDouble(input);
        creditScore = Double.parseDouble(input2);
        income = Double.parseDouble(input3);
        propertyType = Double.parseDouble(input4);
        years = Double.parseDouble(input5);
        int x = 0;
        int y = 0;
        int z = 0;
        
        //calculations
        if(creditScore >= 800){
        	x = 10;}
        else if(creditScore < 800){
        	if(creditScore > 750){
        		x = 8;}  
        	else if(creditScore < 750){
        		if(creditScore > 700){
        			x = 6;} 
            	else if(creditScore < 700){
            		if(creditScore > 650){
            			x = 4;} 
                	else if(creditScore < 650){
                		if(creditScore > 600){
                			x = 2;} 
                    	else if(creditScore < 600) {
                    		x = 0;}
                	}
            	}
        	}
        }
        
        if(propertyType == 1){ //Single Family Home
        	z = 10;
        	propName = "Single Family Home";}
        else if(propertyType == 2){ // Commercial 
        	z = 8;
        	propName = "Commercial";}  
        else if(propertyType == 3){ // Condos
        	z = 5;
        	propName = "Condos";} 
        else if(propertyType == 4){ // land
            z = 2;
            propName = "Land";} 
        else if(propertyType == 5){ // Other
            z = 0;
            propName = "Other";} 

        if(income >= 300000){
        	y = 10;}
        else if(income < 300000){
        	if(income > 200000){
        		y = 7;}  
        	else if(income < 200000) {
        		if(income > 100000) {
        			y = 5;} 
            	else if(income < 100000) {
            		if(income > 80000) {
            			y = 3;} 
                	else if(income < 80000) {
                		if(income > 60000) {
                			y = 1;} 
                    	else if(income < 60000) {
                    		y = 0;}
                	}
            	}
        	}

        }
        points = x+y+z;// need this here for my final comparison
        interest = 4.5;
        
        if(points >= 26){
        	score = interest - 1;}
        else if(points < 26){
        	if(points >= 22){
        		score = interest -.5;}  
        	else if(points < 22) {
        		if(points >= 20) {
        			score = interest - 0;} 
            	else if(points < 20) {
            		if(points >= 15) {
            			score = interest +.5;} 
                	else if(points < 15) {
                		if(points >= 12) {
                			score = interest + 1;} 
                		else if(points < 12) {
                    		if(points >= 10) {
                    			score = interest + 2;}
                    	else if(points < 10) {
                    		score = interest + 5;}
                		}
                	}
            	}
        	}

        }
        	
        k = score/12/100;
        m = years*12;
        payment = (principal*(k*(Math.pow(1+k, m))))/(Math.pow(1+k, m)-1);
        roundedPayment = ((int) (payment * 100)) / 100.00;
        // opening the final menu//
		JOptionPane.showMessageDialog(null,
		"         Mortgage Loan Calculator     "   +"\n"+	                
		" _____________________________________"   +"\n"+ 
		"           Personal Information       "   +"\n"+
		"______________________________________"   +"\n"+
		"  First Name      : " +firstName         +"\n"+
		"  Last Name       : " +lastName		   +"\n"+
		"  Address         : " +address            +"\n"+
		"  City, State, Zip: " +city+", "+state+", "+zipCode +"\n"+
		"  Credit Score    : " +creditScore        +"\n"+
		"  Income          : " +income             +"\n"+
		" _____________________________________"   +"\n"+
		"				Loan Terms             "   +"\n"+
		" _____________________________________"   +"\n"+
		" Property Type  : " +propName             +"\n"+
		" Principal      : " +principal            +"\n"+
		" Interest       : " +score+ "%"           +"\n"+
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

