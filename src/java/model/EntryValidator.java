/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.*;

/**
 *
 * @author star
 */
public class EntryValidator {
    // methods return true if input is valid
    
    public boolean checkDate(String str) {
        
        try {
            // check the length
            if (str.length() == 10){
                String[] split = str.split("/");
                
                int month = Integer.parseInt(split[0]);
                int day = Integer.parseInt(split[1]);
                int year = Integer.parseInt(split[2]);

                // throws a DTE if an invalid date value is passed to it
                LocalDate ld = LocalDate.of(year, month, day);
                
                System.out.println("checkDate is true!");
                System.out.println("date1: " + str);
                System.out.println("date2: " + ld);
                
                return true;
            }
        }
        
        catch (DateTimeException dte) {
            dte.printStackTrace();
        }
        
        catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        
        System.out.println("checkDate is false :(");
        return false;
    }
    
    public boolean checkAmount(String amount) {
        try {
            // checks if the amount has 1-20 digits
            if (amount.length() <= 20 && amount.length() >= 1) {
                
                // throws NFE if invalid
                double d = Double.valueOf(amount);

                // check if negative value or 0
                if (d > 0) {
                    System.out.println("checkAmount is true!");
                    return true;
                }
            }
        }
        
        catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        
        System.out.println("checkAmount is false :(");
        return false;
    }
    
    public boolean checkCategory(String str) {
        return str.length() <= 15;
    }
    
    public boolean checkDescr(String str) {
        return str.length() <= 20;
    }
}

// reference:
// date splitting: https://stackoverflow.com/questions/36290467/how-to-get-day-month-year-from-string-date