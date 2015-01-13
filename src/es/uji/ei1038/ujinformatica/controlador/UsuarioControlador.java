package es.uji.ei1038.ujinformatica.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uji.ei1038.ujinformatica.daos.OrdenadorDao;
import es.uji.ei1038.ujinformatica.daos.UsuarioDao;
import es.uji.ei1038.ujinformatica.dominio.Ordenador;
import es.uji.ei1038.ujinformatica.dominio.Procesador;
import es.uji.ei1038.ujinformatica.dominio.Usuario;


@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioDao usuarioDao;
	private OrdenadorDao ordenadorDao;

	@Autowired
	public void setUsuario(UsuarioDao usuarioDao, OrdenadorDao ordenadorDao){
		this.usuarioDao = usuarioDao;
		this.ordenadorDao = ordenadorDao;
	}



	class UsuarioValidadorRegistro implements Validator{		
		@Override
		public boolean supports(Class<?> cls) {
			return UsuarioValidadorRegistro.class.equals(cls);
		}

		@Override
		public void validate(Object obj, Errors errors) {
			Usuario usuario = (Usuario) obj;
			List<Usuario> usuarios = usuarioDao.getUsuarios();
			boolean encontrado = false;
			for (Usuario user: usuarios){
				if (!encontrado){
					if(usuario.getEmail().equals(user.getEmail()) && !encontrado){
						errors.rejectValue("email", "Email repetido", "Email ya registrado");		
						encontrado = true;
					}else if(!usuario.getContrasenya().equals(usuario.getContrasenyaRepetida()) && !encontrado){
						errors.rejectValue("contrasenya", "Contrasenya no coincide", "La contraseña no coincide");	
						encontrado = true;
					}else if(usuario.getNickname().equals(user.getNickname()) && !encontrado){
						errors.rejectValue("nickname", "Nickname repetido", "Nickname en uso");	
						encontrado = true;
					}
				}
			}
		}
		
		public void validateModificar(Object obj, Errors errors){
			Usuario usuario = (Usuario) obj;
			 if(!usuario.getContrasenya().equals(usuario.getContrasenyaRepetida())){
					errors.rejectValue("contrasenya", "Contrasenya no coincide", "La contraseña no coincide");	
		}
		}
	}



	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("usuario/login", "usuario", new Usuario());
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "usuario/login";
		}

		// Comprova que el login siga correcte 
		// intentant carregar les dades de l’usuari 
		Usuario buscaUsuario = usuarioDao.getUsuario(usuario.getNickname(), usuario.getContrasenya()); 

		if (buscaUsuario == null) {
			bindingResult.rejectValue("contrasenya", "badpw", "Contraseña y/o identificador incorrectos"); 
			return "usuario/login";
		}

		// Autenticats correctament. 
		//Guardem les dades de l’usuari autenticat a la sessió

		session.setAttribute("identificador", usuario.getNickname()); 
		session.setAttribute("puesto", buscaUsuario.getTipo());


		//			System.out.println(buscaUsuario.getTipo());
		switch (buscaUsuario.getTipo()) {
		case "U":
			return "redirect:../index.jsp";

		case "A":
			return "redirect:/administracion/index.html";

		default:
			break;
		}
		return "redirect:../index.jsp";
	}

	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:../index.jsp";
	}

	@RequestMapping("/registro") 
	public ModelAndView registro(HttpSession session) {
		return new ModelAndView("usuario/registro", "usuario", new Usuario());
	}

	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String registrarUsuario(@ModelAttribute Usuario usuario, BindingResult bindingResult, HttpSession session) {

		
		UsuarioValidadorRegistro validator = new UsuarioValidadorRegistro();
		validator.validate(usuario, bindingResult); 

		if (bindingResult.hasErrors()) {
			return "usuario/registro";
		}
		
		usuario.setTipo("U");
//		usuario.setTipo("A");

		this.usuarioDao.addUsuario(usuario);
		
		session.setAttribute("identificador", usuario.getNickname()); 
		session.setAttribute("puesto", usuario.getTipo()); 


		switch (usuario.getTipo()) {
		case "U":
			return "redirect:../index.jsp";

		case "A":
			return "redirect:../administracion/admin.html";

		default:
			break;
		}
		return "redirect:../index.jsp";
	}

	
	@RequestMapping("/perfil") 
	public ModelAndView muestraPerfil(HttpSession session) {
		if(session.getAttribute("identificador")==null || session.getAttribute("puesto").equals("U") == false){
			return new ModelAndView("usuario/login", "usuario", new Usuario());
		} else {
			Usuario usuario = usuarioDao.getUsuarioPorNickname((String) session.getAttribute("identificador"));
			usuario.setContrasenya(null);
			session.setAttribute("usuarioOriginal", usuario);
			return new ModelAndView("usuario/perfil", "usuario", usuario);
		}
	}
	
	@RequestMapping(value="/perfil", method=RequestMethod.POST) 
	public String actualizaPerfil(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult,HttpSession session) {
		
		usuario.setNickname((String)session.getAttribute("identificador"));
		
		if(usuario.getSuscritoNovedades() == null)
			usuario.setSuscritoNovedades("N");
		
		UsuarioValidadorRegistro validator = new UsuarioValidadorRegistro();
		validator.validateModificar(usuario, bindingResult); 
		
		if (bindingResult.hasErrors()) {
			return "usuario/perfil";
		}
		

		if (usuario.getContrasenya() != null && usuario.getContrasenyaRepetida() != null)
			usuarioDao.updateUsuario(usuario);
		
		usuarioDao.updateUsuarioSinContrasenya(usuario);
		session.setAttribute("usuarioOriginal", usuario);
		return "redirect:perfil.html";
	}
	
	@RequestMapping("/historico") 
	public ModelAndView muestraHistorico(HttpSession session) {

		if(session.getAttribute("identificador")==null || session.getAttribute("puesto").equals("U") == false){
			return new ModelAndView("usuario/historico");
		} else {

			List<Ordenador> ordenadores = this.ordenadorDao.getOrdenadores((String)session.getAttribute("identificador"));
			return new ModelAndView("usuario/historico", "ordenadores", ordenadores);

		}
	}
	
	@RequestMapping(value="/eliminaOrdenador/{nombre}") 
	public String deleteOrdenador(@PathVariable String nombre) {
		this.ordenadorDao.deleteOrdenador(nombre);
		return "redirect:../historico.html"; 
	}
}