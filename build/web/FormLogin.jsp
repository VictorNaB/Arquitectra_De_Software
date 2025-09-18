<%-- 
    Document   : FormLogin
    Created on : 17/09/2025, 10:30:21 p. m.
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Iniciar Sesión</h2>

        <!-- El action debe apuntar al Servlet -->
        <form action="Login" method="post">
            <label for="correo">Correo:</label>
            <input type="email" id="correo" name="correo" required>
            <br><br>

            <label for="contraseña">Contraseña:</label>
            <input type="password" id="contraseña" name="contraseña" required>
            <br><br>

            <button type="submit">Ingresar</button>
        </form>

    </body>
</html>
