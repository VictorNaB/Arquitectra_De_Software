<%-- 
    Document   : FormCampañas
    Created on : 17/09/2025, 12:39:31 p. m.
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Campaña</title>
</head>
<body>
    <h2>Crear Nueva Campaña</h2>
    <form action="Campañas" method="POST">
        Fecha de Publicación: <input type="date" name="Fechapublicacion" required><br><br>
        Título: <input type="text" name="Titulo" required><br><br>
        Descripción: <textarea name="Descripcion" required></textarea><br><br>
        <input type="submit" value="Crear Campaña">
    </form>
</body>
</html>
