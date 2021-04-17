<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Estudiantes</title>
</head>
<body>

<h2>Hola alumno, introduce tu nombre y apellidos</h2>

<form action="procesaFormulario2" method="get">						<!-- el valor de la etiqueta action tiene que coincidir con el nombre de la anotacion que le dimos al metodo que genera la pagina de respuesta, con esto definimos que lo que el usuario teclee en el campo de texto nombreAlumno se envie a esta pagina de respuesta una vez se pulse sobre el boton enviar -->
	Nombre: <input type="text" name="nombreAlumno">

	Apellido: <input type="text" name="apellidoAlumno">
	
	<input type="submit" value="Registrar">

</form>



</body>
</html>