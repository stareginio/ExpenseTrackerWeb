<%-- 
    Document   : displayresult
    Created on : 02 27, 22, 7:11:19 PM
    Author     : star
--%>

<%@page import="model.ExpenseManager"%>
<%@page import="model.User"%>
<%@page import="model.Expense"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Expenses</title>
    </head>
    <body>
        <header>
            <p><% out.print(getServletContext().getInitParameter("navbar")); %></p>
            
            <form name="LogoutForm" method="post" action="Logout">
                <input name="action" type="submit" value="Logout">
            </form>
        </header>
        
        <%           
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");    // HTTP 1.1
            response.setHeader("Pragma", "no-cache");    // HTTP 1.0
            response.setHeader("Expires", "0");    //prevents caching at the proxy server
            
            User account = (User) session.getAttribute("account");  
            
            // check if user logged out
            if(account == null) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");

            }
            
            ExpenseManager em = new ExpenseManager();
            List<Expense> result = (ArrayList) request.getAttribute("results");
        %>
        
        <h1 align="center">Hello, <% out.print(account.getNickname()); %></h1>
        
        <table border="1" align="center" id="compute-table">
            <tr>
                <th>Income</th>
                <th>Expenses</th>
                <th>Balance</th>
            </tr>
 
            <tr>
                <td><%= em.computeIncome(result) %></td>
                <td><%= em.computeExpenses(result) %></td>
                <td><%= em.computeBalance() %></td>
            </tr>
 
        </table>
        
        <table border="1" align="center" id="records-table">    
            <tr>
                <th>Date</th>
                <th>Income/Expense</th>
                <th>Amount</th>
                <th>Category</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            
            <%                
                for (Expense e : result) {
            %>
                    <tr>
                        <td><%= em.printDate(e.getDate()) %></td>
                        <td><%= e.getInex() %></td>
                        <td><%= em.printAmount(e.getAmount()) %></td>
                        <td><%= e.getCategory() %></td>
                        <td><%= e.getDescription() %></td>
                        <td>
                            <form name="UpdateButton" method="post" id="update" action="Expenses">
                                <input name="action" type="submit" value="Update">                 
                                <!--references for updating the record-->
                                <input name="updateDate" type="hidden" value="<%= e.getDate() %>"/>
                                <input name="updateDescr" type="hidden" value="<%= e.getDescription() %>"/>
                            </form>

                            <form name="DeleteButton" method="post" id="delete" action="Expenses">
                                <input name="action" type="submit" value="Delete">
                                <input name="date" type="hidden" value="<%=e.getDate()%>">
                                <input name="descr" type="hidden" value="<%=e.getDescription()%>">
                            </form>
                        </td>
                    </tr>
            <%
                }
            %>
        </table>
        
        <form name="AddRecord" method="post" action="Expenses">
            <input name="action" type="submit" value="Add an Entry"/>
        </form>
        
        <footer>
            <p><% out.print(getServletContext().getInitParameter("footer")); %></p>
        </footer>
    </body>
</html>
