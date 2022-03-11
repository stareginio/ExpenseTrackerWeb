<%-- 
    Document   : errorPage
    Created on : 03 10, 22, 3:55:01 PM
    Author     : star
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <header>
            <p><% out.print(getServletContext().getInitParameter("header")); %></p>
        </header>
        
        <h1>Page Unavailable</h1>
        
        <!--image-->
        
        <p>Sorry for the inconvenience, but the page you're looking for isn't available.</p>
        
        <footer>
            <p><% out.print(getServletContext().getInitParameter("footer")); %></p>
        </footer>
    </body>
</html>