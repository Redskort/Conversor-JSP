package Conversor.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Conversor")
public class Conversor extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        String precioUsd = request.getParameter("usd");
        double usd = Double.parseDouble(precioUsd);
        String precioEur = request.getParameter("eur");
        double eur = Double.parseDouble(precioEur);
        String cantidadMoneda = request.getParameter("cantidadMoneda");
        double cantidad = Double.parseDouble(cantidadMoneda);
        String opcion = request.getParameter("tipoCambio");
        double resultado ;

        if(opcion.equals("USD")){
            resultado = cantidad * usd;
        }

        if(opcion.equals("EUR")) {
            resultado = cantidad * eur;
        }


        RequestDispatcher destino = request.getRequestDispatcher("conversor.jsp");
        destino.forward(request, response);





    }




}



