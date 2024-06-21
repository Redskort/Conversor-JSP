<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversor de Moneda</title>
    <link rel="stylesheet" href="css/conversor.css">
</head>
<body>


    <div class="app">
        <label for="boton" id="consulta">Consultar precio de divisa &#160</label>
    <a href="https://www.eleconomista.es/cruce/EURUSD" target="_blank" id="busqueda">
        <button id="boton">Consultar</button>
    </a> <br><br>

        <form id="formulario" action="/Conversor" method="post" >
            <input type="text" id="precioUSD" name="usd" placeholder="Precio USD" autocomplete="off"><br><br>
            <input type="text" id="precioEUR" name="eur" placeholder="Precio EUR" autocomplete="off"><br><br>
            <input type="text" id="cantidadMoneda" name="cantidadMoneda" placeholder="Cantidad a Convertir" autocomplete="off" required><br><br>
            <select name="tipoCambio" id="tipoCambio" required>
                <option value="USD">USD => EUR</option>
                <option value="EUR">EUR => USD</option>
            </select><br><br>
            <input type="submit" value="Convertir" id="convertir"><br><br>
            <label for="pantalla">Conversion:</label><br><br>
            <input type="text" id="pantalla" name="box" value= <% out.println(resultado); %> readonly>
        </form>

    </div>

</body>
</html>