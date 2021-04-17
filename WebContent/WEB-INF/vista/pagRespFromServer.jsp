<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado del proceso de registro</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/recursos/estilos/miEstilo.css/">		<!-- Con esta etiqueta indicamos que dentro de esta pagina jsp se mostraran estilos css e indicamos la ruta de este archivo. ${pageContext.request.contextPath } es la raiz de WebContent, y luego especificamos la direccion especifica dentro de WebContent-->
											
</head>
<body>

	Hola ${param.nombreAlumno} ,usted se ha registrado con exito			<!-- Desde aca desde la pagina de respuesta del server tenemos que recoger lo que nos envia el formulario de registro (formRegInServer). nombreAlumno es una etiqueta definida en un .jsp, debido a eso se adquiere su valor con param -->
	
	<p>
		
	${mensaje}																<!-- Con esta instruccion podemos capturar el valor de la variable mensajeFinal de la clase ControladorFormulario.java ya que esta mapeada a la propiedad mensaje. mensaje es una etiqueta definida en un pagina .java por eso no hace falta param. se creo esta etiqueta con el metodo addAttribute() de la interfaz Model de Spring-->
	<br>
	Mi apellido es ${apellido}												<!-- En este caso es similar al de la etiqueta mensaje, pero esta apellido se construyo usando el metodo setAttribute() de la interface HttpServletRequest -->
	</p>
	
	<img alt="foto" src="${pageContext.request.contextPath }/recursos/imagenes/spring.png">								<!-- Con esta etiqueta indicamos que dentro de esta pagina jsp se mostrara una imagen e indicamos la ruta de la misma. ${pageContext.request.contextPath } es la raiz de WebContent, y luego especificamos la direccion especifica dentro de WebContent-->
	
</body>
</html>