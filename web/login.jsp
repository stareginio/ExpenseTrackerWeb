<%-- 
    Document   : errorLogin
    Created on : 02 27, 22, 7:09:43 PM
    Author     : star
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <p><% out.print(getServletContext().getInitParameter("header")); %></p>
        </header>
        
        <h1>Incorrect Username/Password</h1>
        
        <p>Login failed! Please try again :)</p>
        
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
