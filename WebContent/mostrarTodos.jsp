<%@page import="java.util.ArrayList"%>
<%@page import="es.concesionario.modelo.Coche"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Coche> coches = (ArrayList<Coche> )request.getAttribute("listado");
%>
<table>
    <tr>
      <th>Id</th>
      <th>Matricula</th>
      <th>Marca</th> 
      <th>Modelo</th>
      <th>color</th>
      <th>numeroCaballos</th>
      <th>Marchas</th>    
    </tr>
 
  
	  <% for(Coche coche: coches){ %>  
   <tr>
      
      <td><%=coche.getId() %></td>
      <td><%=coche.getMatricula() %></td>
      <td><%=coche.getMarca() %></td>
      <td><%=coche.getModelo() %></td>
      <td><%=coche.getColor() %></td>
      <td><%=coche.getNumerocaballos() %></td>
      <td><%=coche.isMarchas() %></td>

  </tr>
  <%}// del for %>
</table>
</body>
</html>