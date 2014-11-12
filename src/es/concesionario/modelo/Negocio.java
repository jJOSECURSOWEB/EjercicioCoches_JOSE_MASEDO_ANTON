package es.concesionario.modelo;

import java.util.ArrayList;

import es.concesionario.integracion.CocheDAO;





public class Negocio {
	     
	 private CocheDAO cochedao = new CocheDAO();
	 
	
    
      public int darAlta(String matricula, String marca, String modelo, String color, Boolean marchas, int numeroCaballos) {
       // validar los coches...
        // mandar un correo al alguna institucion
        Coche coche= new Coche(matricula,marca,modelo,color,marchas,numeroCaballos);
        int id =cochedao.darAlta(coche);
      return  id;
    }

    public Coche consultarUno(int id) {
       // validar si el q solicita la consulta tiene autorizacion
        Coche coche =cochedao.consultarUno(id);
      
        return coche;
    }

    public ArrayList<Coche> consultarTodos() {
       String matricula = null;
	//reglas...
        //-....
       ArrayList<Coche> coches=cochedao.consultarMatricula(matricula);
       
      return coches;
      
      
    }

    public ArrayList<Coche> consultarMatricula(String matricula) {
        ArrayList<Coche> coches=cochedao.consultarMatricula(matricula);
        
        return coches;
    }

    public String borrar(int id) {
        String msg;
        // verificar si el coche tiene deudas pendiente
        //mandar un correo al administrador..
        int cochesBorrados= cochedao.borrar(id);
        if(cochesBorrados>=1) {
            msg="Se han borrado" +cochesBorrados +" coches";
        }
        else {
              msg="No se ha podido borrar";
        }
       return msg;
    }

	public int darAlta(String matricula, String marca, String modelo,
			String color, String marchas, int numeroCaballos) {
		// TODO Auto-generated method stub
		return 0;
	}


}
