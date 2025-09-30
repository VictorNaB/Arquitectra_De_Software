<%-- 
    Document   : FormUsuario
    Created on : 17/09/2025, 10:50:01 a. m.
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario - Adulto Mayor</title>
</head>
<body>
    <h2>Registrar Usuario (Adulto Mayor)</h2>
    <form action="Usuarios" method="POST">

        <select name="tipodocumento" required>
            <option value="">Seleccione tipo documento</option>
            <option value="1">Cédula de Ciudadanía</option>
            <option value="4">Cédula de Extranjería</option>
            <option value="2">Pasaporte</option>
            <option value="5">NIT</option>
        </select><br><br>

        Documento: <input type="text" name="documento" required><br><br>
        Nombre: <input type="text" name="nombre" required><br><br>
        Apellidos: <input type="text" name="apellidos" required><br><br>
        Genero: <input type="text" name="genero" required><br><br>
        idRol:<input type="hidden" name="idRol" value="3">
        Fecha Nacimiento: <input type="date" name="fecha_nacimiento" required><br><br>

        <select name="idtipotelefono" required>
            <option value="">Seleccione tipo telefono</option>
            <option value="1">Fijo</option>
            <option value="2">Celular</option>
        </select><br><br>

        Telefono: <input type="text" name="telefono" required><br><br>
        Correo: <input type="text" name="correo" required><br><br>
        Contraseña: <input type="password" name="contraseña" required><br><br>

      

        <input type="submit" value="Registrar">
    </form>
</body>
</html>
