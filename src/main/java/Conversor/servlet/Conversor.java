package Conversor.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/Conversor")
public class Conversor extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");



        try{
            String precioUsd = request.getParameter("usd");
            String precioEur = request.getParameter("eur");
            String cantidadMoneda = request.getParameter("cantidadMoneda");
            String opcion = request.getParameter("tipoCambio");

            if (cantidadMoneda == null || cantidadMoneda.isEmpty()) {
                request.setAttribute("error", "Inserte cantida a convertir.");
                EnvioError(request, response);
                return;
            }
            double cantidad = Double.parseDouble(cantidadMoneda);
            if (cantidad < 0) {
                request.setAttribute("error", "Valor incompatible, por favor " +
                        "indique cantidad a convertir.");
                EnvioError(request, response);
                return;
            }
            double resultado = 0;

        if(opcion.equals("USD")){

            if (precioUsd == null || precioUsd.isEmpty()) {
                request.setAttribute("error", "El precio DOLLAR es obligatorio.");
                EnvioError(request, response);
                return;
            }
            double usd = Double.parseDouble(precioUsd);

            resultado = usd * cantidad;


        } else if(opcion.equals("EUR")){

            if (precioEur == null || precioEur.isEmpty()) {
                request.setAttribute("error", "El precio EURO es obligatorio.");
                EnvioError(request, response);
                return;
            }

            double eur = Double.parseDouble(precioEur);
            resultado = eur * cantidad;

        }

            String conversion = resultado + " ";
            request.setAttribute("conversion", conversion);

        RequestDispatcher destino = request.getRequestDispatcher("conversor.jsp");
        destino.forward(request, response);

    } catch (NumberFormatException e) {
            request.setAttribute("error", "Formato de número inválido.");
            EnvioError(request, response);
        }
        catch (Exception e) {
            request.setAttribute("error", "Ha ocurrido un error inesperado.");
            EnvioError(request, response);
        }

}
    private void EnvioError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher error = request.getRequestDispatcher("ErrorPage");
        error.forward(request, response);
    }

}



