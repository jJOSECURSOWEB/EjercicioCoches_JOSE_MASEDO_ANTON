package es.concesionario.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Coche;


/**
 * Servlet implementation class ConsultarNombreServlet
 * @param <Negocio>
 */
@WebServlet("/ConsultarMatricula")
public class ConsultarMatriculaServlet<Negocio> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarMatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String matricula= request.getParameter("matricula");
	    
	    
	    Negocio negocio= (Negocio) new es.concesionario.modelo.Negocio();  
	    
	    
	    ArrayList<Coche> coches= ((es.concesionario.modelo.Negocio) negocio).consultarMatricula(matricula);
	   
        //meter el arraylist en el request....
        request.setAttribute("listado", coches);
        RequestDispatcher rd;
        rd=request.getRequestDispatcher("mostrarTodos.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
