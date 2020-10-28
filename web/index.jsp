<%-- 
    Document   : index
    Created on : 27-10-2020, 04:20:12 PM
    Author     : Ivan Nina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Productos> lista =(ArrayList<Productos>)request.getAttribute("lista");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de contactos</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Modificar</th>
                <th>Iliminar</th>
                
            </tr>
            <c:forEach var="item" items="${lista}">
            
            <tr>
                <td>${item.id}</td>
                <td>${item.Producto}</td>
                <td>${item.Precio}</td>
                <td>${item.Cantidad}</td>
                <td>${item.Modificar}</td>
                <td>${item.Iliminar}</td>
            </tr>
            </c:forEach>
            
            
        </table>
    </body>
</html>
