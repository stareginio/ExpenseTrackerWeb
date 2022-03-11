<%-- 
    Document   : index
    Created on : 02 27, 22, 4:34:37 PM
    Author     : star
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <p><% out.print(getServletContext().getInitParameter("navbar")); %></p>
        </header>
        
        <%  
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");    // HTTP 1.1
            response.setHeader("Pragma", "no-cache");    // HTTP 1.0
            response.setHeader("Expires", "0");    //prevents caching at the proxy server
        %>
        
        <h1>Login</h1>
        
        <form name="LoginForm" method="post" action="Expenses">
            <input name="loginUsername" type="text" id="login" size="40" placeholder="Username"/>
            <input name="loginPassword" type="password" id="login" size="40" placeholder="Password"/>
            <input name="action" type="submit" id="submit-btn" value="Login"/>
        </form>
        
        <footer>
            <p><% out.print(getServletContext().getInitParameter("footer")); %></p>
        </footer>
    </body>
</html>