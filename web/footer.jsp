<%-- 
    Document   : footer
    Created on : 03 14, 22, 10:40:55 PM
    Author     : star
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<footer class="py-3 flex-shrink-0 border-top bg-light text-muted"
        style="height: 4em; font-size: 14px">
    <div class="container">
        <span>
            <% out.print(getServletContext().getInitParameter("footer")); %>
        </span>
    </div>
</footer>
