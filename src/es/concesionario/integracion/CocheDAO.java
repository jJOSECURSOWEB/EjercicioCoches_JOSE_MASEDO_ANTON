package es.concesionario.integracion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.concesionario.modelo.Coche;



public class CocheDAO {
     private Connection cx;
   
     private void conectar() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/MUNDO","root","root");
            cx.setAutoCommit(false);
        } catch (SQLException e) {
           
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
     private void desconectar() {
         try {
            cx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
         
     }
       public int darAlta(Coche coche) {
              int idRetornar=0;
            try {
                
                //1. conectar
                conectar();
              //2.Preparar la sql (query)
                PreparedStatement ps = 
                            cx.prepareStatement("INSERT INTO COCHE VALUES(?,?,?,?,?,?)");
                
                     // 2.1 setear los interrogantes...
                ps.setInt(1, 0);                
				ps.setString(2,coche.getMatricula());
				ps.setString(3,coche.getMarca());
				ps.setString(4,coche.getModelo());
				ps.setString(5,coche.getColor());
				ps.setLong(6,coche.getNumerocaballos());
				
                
                //3. Ejecutar la consulta
                 int filasAfectadas =ps.executeUpdate();
               
                   //4.  hacer el commit....
                 cx.commit();
                 if(filasAfectadas>=1) {
                     idRetornar= ultimoId();    
               }
                //.5.cerrar la conexión
                 desconectar();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         return idRetornar;
    }
    public Coche consultarUno(int id) {
       
       
        Coche c = new Coche(null, null, null, null, null, id);
           try {
          //1. conectar
            conectar();
          //2. preparar la consulta
            PreparedStatement ps;
            ps = cx.prepareStatement("select * from coche where id=?");
           // 2.1 setear los ?
                ps.setInt(1, id);
           // 3, ejecutar la consulta
             ResultSet rs =ps.executeQuery();  
           //4. llenar el objeto pais.. con los datos de respuesta de BBDD..
                //Nota: La respuesta viene en un objeto ResultSet
             if(rs.next()) {
                 
                 ResultSet consulta = null;
				c.setId(consulta.getInt("id"));
                 c.setMatricula(consulta.getString("Matricula"));
                 c.setMarca(consulta.getString("Marca"));
                 c.setModelo(consulta.getString("Modelo"));
                 c.setColor(consulta.getString("Color"));
                 c.setNumerocaballos(consulta.getInt("NumeroCaballos"));
                 c.setMarchas(consulta.getBoolean("marchas"));  
                 
             }
           //5.desconectar
             desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      return c;
    }
    public ArrayList<Coche> consultarTodos(ArrayList<Coche> coches) {
        ArrayList<Coche> paises= new ArrayList<Coche>();
       
        try {
            //1. conectar
            conectar();
            //2. preparar la sentencia
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM PAIS");
            //3. ejecutar la consulta
            ResultSet consulta = ps.executeQuery();
            //4. bajar el resultado de la consulta y ponerlo en el arrayList
            while(consulta.next()) {
            	Coche c = new Coche(null, null, null, null, null, 0);
                c.setId(consulta.getInt("id"));
                c.setMatricula(consulta.getString("Matricula"));
                c.setMarca(consulta.getString("Marca"));
                c.setModelo(consulta.getString("Modelo"));
                c.setColor(consulta.getString("Color"));
                c.setNumerocaballos(consulta.getInt("NumeroCaballos"));
                c.setMarchas(consulta.getBoolean("marchas"));  
                coches.add(c);
            }
            //5. desconectar
            desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return coches;
    }
  
    
    public int  ultimoId() {
        int  idM=90;
        try {
            //1. conectar
            conectar();
            //2. preparar la sentencia
            PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM COCHE");
            //3. ejecutar la consulta
            ResultSet consulta = ps.executeQuery();
            //4. bajar el resultado de la consulta y ponerlo en el arrayList
           if(consulta.next()) {
                idM=consulta.getInt("ULTIMO");
            }
            //5. desconectar
            desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          
      }
     
        return idM;
    
      
      
     
     }
    public ArrayList<Coche> consultarNombre(String matricula) {
        ArrayList<Coche> coches= new ArrayList<Coche>();
       try {
            //1. conectar
            conectar();
            //2. preparar la sentencia
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM PAIS WHERE NOMBRE LIKE ?");
            // 2.1 setear el interrogante
            //ps.setString(1, "\"" +nombre + "%" + "\"" );
            ps.setString(1, "%" +matricula+  "%");
            //3. ejecutar la consulta
            ResultSet consulta = ps.executeQuery();
            //4. bajar el resultado de la consulta y ponerlo en el arrayList
            while(consulta.next()) {
            		
            	Coche c = new Coche(matricula, matricula, matricula, matricula, null, 0);
                c.setId(consulta.getInt("id"));
                c.setMatricula(consulta.getString("Matricula"));
                c.setMarca(consulta.getString("Marca"));
                c.setModelo(consulta.getString("Modelo"));
                c.setColor(consulta.getString("Color"));               
                c.setNumerocaballos(consulta.getInt("NumeroCaballos"));
                c.setMarchas(consulta.getBoolean("marchas"));  
                coches.add(c);
            }
            //5. desconectar
            desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return coches;
    }
    public int borrar(int id) {
         int filasAfectadas=0;
         try { 
             //conectar
               conectar();
             //preparar la consulta..
               PreparedStatement ps= cx.prepareStatement("DELETE FROM PAIS WHERE ID =?");
            // setear los ?
               ps.setInt(1, id);
            // ejecutar la consulta
               filasAfectadas= ps.executeUpdate();
            // hacer el commit
               cx.commit();
           
            //cerrar la conexion
               desconectar();
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
        return filasAfectadas;
    }
	public ArrayList<Coche> consultarMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
}
    
