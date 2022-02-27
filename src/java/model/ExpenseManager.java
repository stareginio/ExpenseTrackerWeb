/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author star
 */
public class ExpenseManager {
    // create resultset
    
    private Connection conn;
    private ConnectionManager cm;
    
    public ResultSet getExpenses() {
        
        ResultSet rs = null;
        conn = cm.getConn();
        
        try {
            String query = "SELECT * FROM expense ORDER BY date";
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        }
        
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return rs;
    }
}
