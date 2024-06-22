<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error de Conversión</title>
    <link rel="stylesheet" href="css/error.css">
</head>
<body>

    <div class="app">
        <h1>Error</h1>
        <p><%= request.getAttribute("error") %></p>
        <a href="conversor.jsp">
        <button id="boton">Volver</button>
        </a>
    </div>

</body>
</html>