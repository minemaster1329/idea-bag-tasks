package com.changereturnprogram;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String cost_str, paid_str;
        Scanner sc = new  Scanner(System.in);
        System.out.print("Enter item cost: ");
	    cost_str = sc.next();
	    System.out.print("Enter amount paid for item: ");
	    paid_str = sc.next();
	    sc.close();

	    if (canParse(cost_str) && canParse(paid_str)){
	        float cost = Float.parseFloat(cost_str.replace(',', '.'));
	        float paid = Float.parseFloat(paid_str.replace(',', '.'));
	        if (nonpositiveNumbersGiven(cost, paid)) System.out.println("Amount paid and cost must be greater than 0");
	        else if (cost > paid) System.out.println("Cost must be lower or equal to amount paid for item.");
	        else {
	            paid -= cost;
	            paid *= 100;
	            int paid_int = (int) paid;
	            int[] nominals = {50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1};
	            for (int i = 0; i < 9; i++){
	                int nomCount = (paid_int / nominals[i]);
                    printOutAllData((nominals[i] / 100), " zl: ", nomCount);
                    paid_int -= nominals[i] * nomCount;
	            }

                for (int i = 9; i < 15; i++){
                    int nomCount = (paid_int / nominals[i]);
                    printOutAllData((nominals[i]), " gr: ", nomCount);
                    paid_int -= nominals[i] * nomCount;
                }
            }
        }
	    else System.out.println("Invalid input args.");
    }

    static boolean canParse(String input){
        try {
            float num = Float.parseFloat(input.replace(',', '.'));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    static boolean nonpositiveNumbersGiven(float ... args){
        for (float num: args) if (num <= 0) return true;
        return false;
    }

    static void printOutAllData(Object ... args){
        for (Object a: args) {
            System.out.print(a.toString());
        }
        System.out.print('\n');
    }
}
