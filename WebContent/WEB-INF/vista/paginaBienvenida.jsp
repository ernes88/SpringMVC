<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web de estudiantes</title>
</head>
<body>
	
	<h1>Academia virtual de Spring</h1>
	
	<a href="generaFormReg">Enlace al formulario de registro</a> 		<!-- aca deberemos crear un enlace a la URL del formulario de registro, o sea a generaFormReg. -->
</body>
</html>


<!-- Nota. Flujo de la aplicacion.
0.El programa comenzara por el controlador, que es la clase que tiene encima la anotacion @COntroller, luego cuando entra a esta 
  clase, se ejecutara primero el metodo que tenga la etiqueta RequestMapping sin parentesis.Se ejecuta entonces muestraPagina(), 
  que retorna una String que coincide con el titulo de la pagina jsp de la pagina de bienvenida. Salta el flujo a esta pagina.  
1.Esta pagina de bienvenida sera lo primero que vera el usuario, cuando pinche el link se guarda "generaFormReg" y el flujo salta 
  al controlador de vuelta, y se busca un metodo dentro del controlador que tenga una anotacion que coincida con "generaFormReg",
  encontrandose para el metodo generaFormReg(), el cual se ejecuta y devuelve una String "formRegInServer", transfiriendose el control
  a la pagina jsp con este nombre.
2.Luego se entra en el codigo de formRegInServer.jsp, con lo cual se genera el formulario y se le presenta al usuario.
3.Este teclea su nombre en el campo de texto y al tocar el boton Registrar su nombre viaja de nuevo al controlador, especificamente
  a procesaFormulario2, donde se puede recepcionar debido a la etiqueta @RequestMapping("/procesaFormulario2").
4.Luego se llama al metodo asociado que traslada el flujo de programa a la otra pagina JSP pagRespFromServer, con lo cual se ejecuta
  el codigo dentro de la misma
5.En esta pagina se recepciona el nombre del usuario utilizando el nombre de la etiqueta donde esta la info en el formulario,
  o sea nombreAlumno. Luego se muestra por pantalla dicho nombre -->