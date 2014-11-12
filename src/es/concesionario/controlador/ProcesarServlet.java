package es.concesionario.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Negocio;



/**
 * Servlet implementation class ProcesarServlet
 */
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     int id = Integer.parseInt(request.getParameter("id"));
		     String matricula = request.getParameter("matricula");
		       String marca = request.getParameter("marca");
		       String modelo = request.getParameter("modelo");
		       String color = request.getParameter("color");
		       int numeroCaballos = Integer.parseInt(request.getParameter("numeroCaballos"));
		      String marchas= request.getParameter("marchas");
		       
		     
		     String borrar= request.getParameter("borrar");
		     String actualizar=request.getParameter("actualizar");
		     Negocio negocio = new Negocio();
		     
		     String h = ""; 
		       //proceso borrar
		    
		     if(borrar!=null) {
    		     h=  negocio.borrar(id);
		      }
		     if(actualizar!=null) {
		       //  h=negocio.actualizar(id, matricula, marca.etc);
		     }
		         
    		     //meter el mensaje en el request
    		     request.setAttribute("mensaje",h);
    		     // redirigir... a  la vista mensaje
    		     RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
    		     rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
