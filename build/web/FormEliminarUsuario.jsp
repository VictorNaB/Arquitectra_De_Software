<%-- 
    Document   : FormEliminarUsuario
    Created on : 17/09/2025, 11:10:18 p. m.
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Cuenta</title>
</head>
<body>
    <h2>Eliminar Cuenta</h2>
    <p>⚠️ Esta acción no se puede deshacer.</p>
    <form action="EliminarUsuario" method="POST">
        <input type="submit" value="Eliminar Mi Cuenta">
    </form>

    <% if (request.getAttribute("mensaje") != null) { %>
        <p><%= request.getAttribute("mensaje") %></p>
    <% } %>
</body>
</html>