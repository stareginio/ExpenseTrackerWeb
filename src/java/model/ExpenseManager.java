/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author star
 */
public class ExpenseManager {
    
    private double income;
    private double expenses;
    
    public List<Expense> getExpenses(Connection conn, String action, String date, String descr,
                                        String inex, String amount, String category,
                                        String updateDate, String updateDescr) {
        
        List<Expense> list = new ArrayList<>();
        
        try {
            String query = "";
            
            if (!action.equals("Login")) {
                
                // modify the database
                switch (action) {
                    case "Delete":
                        {
                            query = "DELETE FROM expensedb.expense WHERE date = ? AND description = ?";
                            PreparedStatement ps = conn.prepareStatement(query);
                            
                            ps.setString(1, date);
                            ps.setString(2, descr);
                            ps.executeUpdate();
                            
                            System.out.println("record deleted!");
                            break;
                        }
                    case "Add Entry":
                        {
                            query = "INSERT INTO expensedb.expense VALUES(?,?,?,?,?)";
                            PreparedStatement ps = conn.prepareStatement(query);
                            
                            System.out.println("date: " + date);
                            
                            // reformat the input date for MySQL
                            SimpleDateFormat sdfParse = new SimpleDateFormat("MM/dd/yyyy");
                            SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date parsedDate = sdfParse.parse(date);
                            
                            ps.setString(1, sdfFormat.format(parsedDate));
                            ps.setString(2, inex);
                            ps.setString(3, amount);
                            ps.setString(4, category);
                            ps.setString(5, descr);
                            ps.executeUpdate();
                            
                            System.out.println("record added!");
                            break;
                        }
                    case "Update Entry":
                        {
                            query = "UPDATE expensedb.expense SET date=?, income_expense=?, " +
                                    "amount=?, category=?, description=? " +
                                    "WHERE (date=? AND description=?)";
                            PreparedStatement ps = conn.prepareStatement(query);

                            // reformat the input date for MySQL
                            SimpleDateFormat sdfParse = new SimpleDateFormat("MM/dd/yyyy");
                            SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date parsedDate = sdfParse.parse(date);

                            ps.setString(1, sdfFormat.format(parsedDate));
                            ps.setString(2, inex);
                            ps.setString(3, amount);
                            ps.setString(4, category);
                            ps.setString(5, descr);
                            ps.setString(6, updateDate);
                            ps.setString(7, updateDescr);
                            ps.executeUpdate();

                            System.out.println("record updated!");
                            break;
                        }
                    default:
                        break;
                }
            }
            
            // retrieve the list of expenses
            switch (action) {
                case "Update":
                    {
                        query = "SELECT * FROM expensedb.expense WHERE date = ? AND description = ?";
                        PreparedStatement ps = conn.prepareStatement(query);                        
                        
                        ps.setString(1, updateDate);
                        ps.setString(2, updateDescr);
                        ResultSet rs = ps.executeQuery();
                        
                        System.out.println("rs is: " + rs);

                        while(rs.next()) {
                            System.out.println("in the while loop...");
                            Expense e = new Expense();

                            e.setDate(rs.getDate("date"));
                            e.setInex(rs.getString("income_expense"));
                            e.setAmount(rs.getString("amount"));
                            e.setCategory(rs.getString("category"));
                            e.setDescription(rs.getString("description"));
                            list.add(e);
                        }

                        System.out.println("record retrieved for updating!");
                        break;
                    }
                default:
                    {
                        query = "SELECT * FROM expensedb.expense ORDER BY date";
                        PreparedStatement ps = conn.prepareStatement(query);

                        ResultSet rs = ps.executeQuery();

                        while(rs.next()) {
                            Expense e = new Expense();

                            e.setDate(rs.getDate("date"));
                            e.setInex(rs.getString("income_expense"));
                            e.setAmount(rs.getString("amount"));
                            e.setCategory(rs.getString("category"));
                            e.setDescription(rs.getString("description"));
                            list.add(e);
                        }
                        break;
                    }
            }
        }
        
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        
        return list;
    }
    
    // computes & displays the total income
    public String computeIncome(List<Expense> list) {
        income = 0.00;

        for (Expense e : list) {
            if (e.getInex().equals("Income")) {
                income = income + e.getAmount();
            }
        }
        
        System.out.println("income: " + income);
        return printAmount(income);
    }
    
    // computes & displays the total expenses
    public String computeExpenses(List<Expense> list) {
        expenses = 0.00;
        
        for (Expense e : list) {
            if (e.getInex().equals("Expense")) {
                expenses = expenses + e.getAmount();
            }
        }
        
        System.out.println("expenses: " + expenses);
        
        return printAmount(expenses);
    }
    
    // computes & displays the remaining balance (income - expenses)
    public String computeBalance() {
        Double balance = income - expenses;
        
        System.out.println("balance: " + balance);
        
        return printAmount(balance);
    }
    
    // returns the amount as either a whole number or not
    public String printAmount(double amount) {
        String strAmount = "";
        
        // removes decimal places if whole number
        if (amount - (int)amount == 0) {
            int i = (int) amount;
            strAmount = Integer.toString(i);
        }
        
        // show only 2 decimal places
        else {
            strAmount = String.format("%.02f", amount);
        }
        
        return strAmount;
    }
    
    // returns the date in the MM/dd/yy format
    public String printDate(Date date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        String strDate = df.format(date);
        
        return strDate;
    }
}

// reference:
// parsing & formatting date: https://stackoverflow.com/questions/15546128/how-to-parse-string-06-24-1989-into-date-06-24-1989-format-using-simpledatefor