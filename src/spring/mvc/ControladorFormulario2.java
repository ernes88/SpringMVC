//Este es un controlador de pruebas para demostrar como se pueden usar las direcciones relativas dentro de anoatciones RequestMapping() a nivel de clase Controlador. Se cambia el metodo procesaFormulario2 para que diga que el nombre de usuario tecleado es el peor estudiante.

package spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secundario")					//Ruta relativa establecida para este controlador, de modo que si queremos que se llame al metodo de esta clase tendremos que direccionarlo correctamente desde formRegInServer.jsp, o sea usar la ruta relativa "secundario/procesaFormulario2" desde el action del formulario en formRegInServer
public class ControladorFormulario2 {
	
	//Si acá utilizo la misma anotación que utilice en el metodo que se llama igual a este en la clase COntroladorFormulario, el programa cae, debido a que se da un error de ambiguedad, ya que Spring no puede mappear correctamente nuestros metodos, ya que se encuentra dos metodos asociados a dos anotaciones iguales
	//Solución 1. Renombrar la anotación para este método, de modo que de inicio si hacemos esto solamente no se ejecutara nunca, pues habria que direccionarlo desde el formRegInServer.jsp, o sea poner en el action procesaFormulario3. 
	//Solucion 2. Utilizar rutas relativas para ambos controladores, y llamar a los metodos gemelos procesaFormulario2, desde formRegInServer.jsp utilizando las direcciones relativas.
	
	@RequestMapping("/procesaFormulario2")
	public String procesaFormulario2(@RequestParam("nombreAlumno") String nombreAlumno, @RequestParam("apellidoAlumno") String apellidoAlumno, Model modelo,HttpServletRequest request){
		
		nombreAlumno+=" ";
		
		nombreAlumno+=apellidoAlumno;
		
		String mensajeFinal="quien es el peor alumno? " + nombreAlumno+" es el peor alumno";
		
		//Agregando informacion al modelo utilizando el metodo addAttribute() de la interface Model
		modelo.addAttribute("mensaje", mensajeFinal);									//se pasa esta info al modelo utilizando su metodo addAttribute(), el contenido del mensaje estara en mensajeFinal, pero estara mapeado a la propiedad "mensaje", para ser referenciado desde la pagina jsp pagRespFromServer por este nombre 
		
		//Tambien se puede incluir informacion al modelo usando el metodo setAttribute() de la interface HttpServletRequest
		request.setAttribute("apellido", apellidoAlumno);
		
		return "pagRespFromServer";		
	}
}
