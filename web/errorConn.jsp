<%-- 
    Document   : error
    Created on : 02 27, 22, 4:43:02 PM
    Author     : star
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Connection Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%@include file='header.jsp'%>
        
        <main>
            <h1>Connection Error</h1>

            <p>Sorry for the inconvenience. The web app was unable to
                establish a database connection :(</p>
        </main>
            
        <%@include file='footer.jsp'%>
    </body>
</html>
