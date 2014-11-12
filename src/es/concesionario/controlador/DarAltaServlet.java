package es.concesionario.controlador;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Coche;
import es.concesionario.modelo.Negocio;





/**
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. recuperar los datos de la URL
	    // 2. Adaptarlos si es necesario al tipo de datos del
        //Modelo (convertir de String a entero x ejemplo)
	       String matricula = request.getParameter("matricula");
	       String marca = request.getParameter("marca");
	       String modelo = request.getParameter("modelo");
	       String color = request.getParameter("color");
	       int numeroCaballos = Integer.parseInt(request.getParameter("numeroCaballos"));
	      String marchas= request.getParameter("marchas");
	       
	  	  // 3. Pasarle los datos recuperados al Negocio ......
	      Negocio negocio = new Negocio();
	      
	      int id= negocio.darAlta
	    		  (matricula, marca, modelo, color, marchas, numeroCaballos);
	      
	     //.. consultar elcoche...
	      Coche c=negocio.consultarUno(id);	      
	      //meter el coche en el request... (setAttribute)
	      request.setAttribute("coches",c);
	      //redirigir a la vistaIndividual
	      RequestDispatcher rd;	     
	      
	      rd= request.getRequestDispatcher("vistaIndividual.jsp");
	      rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	}


