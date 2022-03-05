/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.RoundingMode;
import java.sql.*;
import java.text.*;

/**
 *
 * @author star
 */
public class Expense {
    
    private Date date;
    private String inex;  // income/expense
    private double amount;
    private String category;
    private String descr;
    
    // constructor
    public Expense() { }
    
    // returns the amount as either a whole number or not
    public String printAmount() {
        String strAmount = "";
        
        // checks if whole number
        if (amount - (int)amount == 0) {
            int i = (int) amount;
            strAmount = Integer.toString(i);
        }
        
        else {
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.DOWN);
            
            strAmount = df.format(amount);
        }
        
        return strAmount;
    }
    
    // returns the date in the MM/dd/yy format
    public String printDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        String strDate = df.format(date);
        
        return strDate;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInex() {
        return inex;
    }

    public void setInex(String ie) {
        this.inex = ie;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(String s) {
        Double amount = Double.parseDouble(s);
        
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return descr;
    }

    public void setDescription(String descr) {
        this.descr = descr;
    }
}

//References:
//https://stackoverflow.com/questions/23019520/formating-a-number-to-two-decimals-without-rounding-up-and-converting-to-double