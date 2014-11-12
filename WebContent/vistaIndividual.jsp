<%@page import="es.concesionario.modelo.Coche"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<meta http-equiv=Content Type content="text/html;charset=ISO 8859-1">
<title>vistaIndividual</title>
</head>
</body>
<%Coche coche=(Coche)request.getAttribute("coche"); %>
<table>
<tr>
<th>Id</th>
<th>Matricula</th>
<th>Modelo</th>
<th>Marca</th>
<th>Color</th>
<th>NumeroCaballos</th>
<th>Marchas</th>
</tr>
<tr>
<td><%=coche.getId()%></td>
<td><%=coche.getMatricula()%></td>
<td><%=coche.getModelo()%></td>
<td><%=coche.getMarca()%></td>
<td><%=coche.getColor()%></td>
<td><%=coche.getNumerocaballos()%></td>
<td><%=coche.isMarchas()%></td>
</tr>
</tr>
 <td><input type="text" name="id" value="<%=coche.getId()%>" readonly="readonly"/></td>
 <td><input type="text" name="matricula" value="<%=coche.getMatricula()%>"/></td>
 <td><input type="text" name="modelo" value="<%=coche.getModelo()%>"/></td>
 <td><input type="text" name="marca" value="<%=coche.getMarca()%>"/></td>
 <td><input type="text" name="color" value="<%=coche.getColor()%>"/></td>
 <td><input type="text" name="numeroCaballos" value="<%=coche.getNumerocaballos()%>"/></td>
 <td><input type="text" name="marchas" value="<%=coche.isMarchas()%>"/></td> 
  </tr>
</table>
 <input type="submit" value="Borrar" id="borrar"/>
</form>
</body>
</html>
