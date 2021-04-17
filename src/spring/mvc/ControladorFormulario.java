//Este controlador sera el encargado de generar tanto el formulario .jsp donde se le pedira al usuario que introduzca su nombre, como de registrar ese valor y brindarle al usuario otra pagina .jsp de respuesta donde se le muestre que se ha registrado con exito y se muestre su nombre por pantalla

package spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorFormulario {				//Controlador principal sin etiqueta RequestMapping
	
	@RequestMapping									//anotacion que le indica a eclipse cual es el controlador principal.
	public String muestraPagina(){
		return "paginaBienvenida";
	}
	
	//metodo que sirva para pedir el formulario al servidor para que podamos rellenarlo
	@RequestMapping("/generaFormReg")				//mediante esta instruccion le decimos a Spring que este va a ser el metodo que se encargara de pedir el formulario via URL. Esta URL es la que el usuario tendra que utilizar para que el servidor le devuelva el formulario
	public String generaFormReg(){					//Es buena practica darle a la anotacion el mismo nombre del metodo
		
		return "formRegInServer";					//se retorna el nombre que tendra la pagina jsp que genere el formulario
		
	}
	
	//metodo que permita procesar la informacion que el usuario haya introducido en el formulario.
	@RequestMapping("/generaPaginaResp")			//hay que especificar una URL donde se muestre el formulario procesado, o sea la URL de la respuesta. 
	public String generaPaginaResp(){				//Es buena practica darle a la anotacion el mismo nombre del metodo.
		
		return "pagRespFromServer";					//se retorna el nombre que tendra la pagina jsp que genere la respuesta del servidor 
	
	}
	
	
	//Metodo que se encarga de procesar el formulario, o sea adquiere info del formulario y guarda lo introducido en el Modelo, o sea en el contenedor de datos, y luego genera la vista, o sea la pagina de respuesta
	//Este metodo sustituye al metodo de arriba generaPaginaResp(), ya que ahce eso mismo pero ademas adquiere el dato ingresado por el usuario en el cuadro de texto y le añade contenido, agregandole contenido al modelo.
	@RequestMapping("/procesaFormulario")												//hay que especificar una URL donde se muestre el formulario procesado, o sea la URL de la respuesta. 
	public String procesaFormulario(HttpServletRequest request, Model modelo){
		
		//Capturar la informacion que viene del cuadro de texto
		String nombreAlumno=request.getParameter("nombreAlumno");						//adquiero el contenido de la propiedad "nombreAlumno"
		
		String apellidoAlumno=request.getParameter("apellidoAlumno");
		
		nombreAlumno+=" ";
		
		nombreAlumno+=apellidoAlumno;
		
		String mensajeFinal="quien es el mejor alumno? " + nombreAlumno+" es el mejor alumno";
		
		//Agregando informacion al modelo utilizando el metodo addAttribute() de la interface Model
		modelo.addAttribute("mensaje", mensajeFinal);									//se pasa esta info al modelo utilizando su metodo addAttribute(), el contenido del mensaje estara en mensajeFinal, pero estara mapeado a la propiedad "mensaje", para ser referenciado desde la pagina jsp pagRespFromServer por este nombre 
		
		//Tambien se puede incluir informacion al modelo usando el metodo setAttribute() de la interface HttpServletRequest
		request.setAttribute("apellido", apellidoAlumno);
		
		return "pagRespFromServer";		
	}
	
	//Alternativa al metodo procesaFormulario utilizando la anotacion @RequestParam
	@RequestMapping("/procesaFormulario2")
	public String procesaFormulario2(@RequestParam("nombreAlumno") String nombreAlumno, @RequestParam("apellidoAlumno") String apellidoAlumno, Model modelo,HttpServletRequest request){
		
		nombreAlumno+=" ";
		
		nombreAlumno+=apellidoAlumno;
		
		String mensajeFinal="quien es el mejor alumno? " + nombreAlumno+" es el mejor alumno";
		
		//Agregando informacion al modelo utilizando el metodo addAttribute() de la interface Model
		modelo.addAttribute("mensaje", mensajeFinal);									//se pasa esta info al modelo utilizando su metodo addAttribute(), el contenido del mensaje estara en mensajeFinal, pero estara mapeado a la propiedad "mensaje", para ser referenciado desde la pagina jsp pagRespFromServer por este nombre 
		
		//Tambien se puede incluir informacion al modelo usando el metodo setAttribute() de la interface HttpServletRequest
		request.setAttribute("apellido", apellidoAlumno);
		
		return "pagRespFromServer";		
	}
	
	
	
}
