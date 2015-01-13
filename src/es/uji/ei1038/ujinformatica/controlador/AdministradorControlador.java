package es.uji.ei1038.ujinformatica.controlador;

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

import es.uji.ei1038.ujinformatica.daos.DiscoDuroDao;
import es.uji.ei1038.ujinformatica.daos.MonitorDao;
import es.uji.ei1038.ujinformatica.daos.OrdenadorDao;
import es.uji.ei1038.ujinformatica.daos.OtrosDao;
import es.uji.ei1038.ujinformatica.daos.PlacaBaseDao;
import es.uji.ei1038.ujinformatica.daos.ProcesadorDao;
import es.uji.ei1038.ujinformatica.daos.RamDao;
import es.uji.ei1038.ujinformatica.daos.TarjetaGraficaDao;
import es.uji.ei1038.ujinformatica.daos.UnidadDVDDAO;
import es.uji.ei1038.ujinformatica.daos.UsuarioDao;
import es.uji.ei1038.ujinformatica.dominio.DiscoDuro;
import es.uji.ei1038.ujinformatica.dominio.Monitor;
import es.uji.ei1038.ujinformatica.dominio.Otros;
import es.uji.ei1038.ujinformatica.dominio.PlacaBase;
import es.uji.ei1038.ujinformatica.dominio.Procesador;
import es.uji.ei1038.ujinformatica.dominio.Ram;
import es.uji.ei1038.ujinformatica.dominio.TarjetaGrafica;
import es.uji.ei1038.ujinformatica.dominio.UnidadDVD;
import es.uji.ei1038.ujinformatica.dominio.Usuario;
import es.uji.ei1039.ujinformatica.factory.SimpleComponenteFactory;

@Controller
@RequestMapping("/administracion")
public class AdministradorControlador {

	@Autowired
	private UsuarioDao usuarioDao;
	private OrdenadorDao ordenadorDao;
	private DiscoDuroDao discoDuroDao;
	private MonitorDao monitorDao;
	//private OrdenadorDao ordenadorDao;
	private OtrosDao otrosDao;
	private PlacaBaseDao placaBaseDao;
	private ProcesadorDao procesadorDao;
	private RamDao ramDao;
	private TarjetaGraficaDao tarjetaGraficaDao;
	private UnidadDVDDAO dvdDao;
	private SimpleComponenteFactory factory;

	@Autowired
	public void setUsuario(DiscoDuroDao discoDuroDao, MonitorDao monitorDao, OtrosDao otrosDao, 
			RamDao ramDao, PlacaBaseDao placaBaseDao, ProcesadorDao procesadorDao,
			TarjetaGraficaDao tarjetaGraficaDao, UnidadDVDDAO dvdDao, UsuarioDao usuarioDao, OrdenadorDao ordenadorDao, SimpleComponenteFactory factory){
		this.usuarioDao = usuarioDao;
		this.ordenadorDao = ordenadorDao;
		this.discoDuroDao = discoDuroDao;
		this.monitorDao = monitorDao;
		this.otrosDao = otrosDao;
		this.ramDao = ramDao;
		this.placaBaseDao = placaBaseDao;
		this.procesadorDao = procesadorDao;
		this.tarjetaGraficaDao = tarjetaGraficaDao;
		this.dvdDao = dvdDao;
		this.factory = factory;
	}

	/** Validadores **/


	// Validador DiscoDuro
	// Se podría hacer un validador más exhaustivo
	//	class DiscoDuroValidator implements Validator {
	//
	//		@Override
	//		public boolean supports(Class<?> cls) {
	//			return DiscoDuro.class.equals(cls);
	//		}
	//
	//		@Override
	//		public void validate(Object obj, Errors errors) {
	//			DiscoDuro discoDuro = (DiscoDuro) obj;
	//			int capacidad = 0, cache = 0, rpm = 0;
	//
	//			try {
	//				capacidad = Integer.parseInt(discoDuro.getCapacidad());
	//				if(capacidad <= 0){
	//					errors.rejectValue("capacidad", "menor que 0", "La capacidad debe ser mayor que 0");
	//				}
	//			} catch (NumberFormatException e) {
	//				errors.rejectValue("capacidad", "no numero", "La capacidad debe ser un número mayor que 0");
	//			}
	//
	//			try {
	//				cache = Integer.parseInt(discoDuro.getCache());
	//				if(cache <= 0){
	//					errors.rejectValue("cache", "menor que 0", "La caché debe ser mayor que 0");
	//				}
	//			} catch (NumberFormatException e) {
	//				errors.rejectValue("cache", "no numero", "La caché debe ser un número mayor que 0");
	//			}
	//
	//			try {
	//				rpm = Integer.parseInt(discoDuro.getRpm());
	//				if(rpm <= 0){
	//					errors.rejectValue("rpm", "menor que 0", "La velocidad debe ser superior a 0");
	//				}
	//			} catch (NumberFormatException e) {
	//				errors.rejectValue("rpm", "no numero", "La velocidad debe ser un número mayor que 0");
	//
	//			} 
	//
	//			try {
	//				double precio = Double.parseDouble(String.valueOf(discoDuro.getPrecio()));
	//				if( precio <= 0){
	//					errors.rejectValue("precio", "menor que 0", "El precio debe ser superior a 0");
	//				}
	//			} catch (NumberFormatException e) {
	//				errors.rejectValue("precio", "menor que 0", "El precio debe ser un número mayor que 0");
	//			}
	//
	//		}
	//	}


	// Validador Monitor
	// Se podría hacer un validador más exhaustivo
	class MonitorValidator implements Validator {

		@Override
		public boolean supports(Class<?> cls) {
			return Monitor.class.equals(cls);
		}

		@Override
		public void validate(Object obj, Errors errors) {
			Monitor monitor = (Monitor) obj;

			try {
				if(monitor.getPrecio() <= 0){
					errors.rejectValue("precio", "menor que 0", "El precio debe ser superior a 0");
				}
			} catch (NumberFormatException e) {
				errors.rejectValue("precio", "menor que 0", "El precio debe ser un número mayor que 0");
			}
		}
	}


	@RequestMapping("/index") 
	public ModelAndView muestraAdministracion(HttpSession session) {
		return new ModelAndView("administracion/index");
	}


	/** controladores de listado de componentes **/

	@RequestMapping("/listar")
	public ModelAndView listarProductos(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listar");
		return model;
	}

	@RequestMapping("/listDiscoDuro")
	public ModelAndView getDiscoDuro(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listDiscoDuro", "discoDuro", discoDuroDao.getDiscosDuros());
		return model;
	}

	@RequestMapping("/listDvd")
	public ModelAndView getDvd(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listDvd", "dvd", dvdDao.getDvds());
		return model;
	}

	@RequestMapping("/listMonitor")
	public ModelAndView getMonitor(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listMonitor", "monitor", monitorDao.getMonitores());
		return model;
	}

	@RequestMapping("/listOtros")
	public ModelAndView getOtros(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listOtros", "otros", otrosDao.getOtros());
		return model;
	}

	@RequestMapping("/listPlacasBase")
	public ModelAndView getPlacasBase(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listPlacasBase", "placas", placaBaseDao.getPlacasBase());
		return model;
	}

	@RequestMapping("/listProcesador")
	public ModelAndView getProcesadores(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listProcesador", "procesador", procesadorDao.getProcesadores());
		return model;
	}

	@RequestMapping("/listRam")
	public ModelAndView getRam(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listRam", "ram", ramDao.getRams());
		return model;
	}

	@RequestMapping("/listTarjetaGrafica")
	public ModelAndView getTarjetaGrafica(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/listTarjetaGrafica", "tarjetaGrafica", tarjetaGraficaDao.getTarjetasGraficas());
		return model;
	}	


	/** controladores de actualización de componentes **/

	@RequestMapping(value="/editaDiscoDuro/{id}", method = RequestMethod.GET)
	public ModelAndView updateDiscoDuro(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaDiscoDuro","discoDuro", discoDuroDao.getDiscoDuro(id));
	}

	@RequestMapping(value="/editaDiscoDuro/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitDiscoDuro(@PathVariable Integer id, @ModelAttribute("discoDuro") DiscoDuro discoDuro, BindingResult bindingResult, HttpSession session) {
		//		DiscoDuroValidator discoDuroValidator = new DiscoDuroValidator();
		discoDuro.setId(id);
		//		discoDuroValidator.validate(discoDuro, bindingResult);
		//		if (bindingResult.hasErrors()){
		//			return "administracion/editaDiscoDuro";
		//		}

		discoDuroDao.updateDiscoDuro(discoDuro);
		//session.setAttribute("accion", "update");
		return "redirect:../listDiscoDuro.html"; 
	}

	@RequestMapping(value="/editaMonitor/{id}", method = RequestMethod.GET)
	public ModelAndView updateMonitor(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaMonitor","monitor", monitorDao.getMonitor(id));
	}

	@RequestMapping(value="/editaMonitor/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitDiscoDuro(@PathVariable Integer id, @ModelAttribute("monitor") Monitor monitor, BindingResult bindingResult, HttpSession session) {
		//		MonitorValidator monitorValidator = new MonitorValidator();
		monitor.setId(id);
		//		monitorValidator.validate(monitor, bindingResult);
		//		if (bindingResult.hasErrors()){
		//			return "administracion/editaMonitor";
		//		}

		monitorDao.updateMonitor(monitor);
		//session.setAttribute("accion", "update");
		return "redirect:../listMonitor.html"; 
	}


	@RequestMapping(value="/editaOtros/{id}", method = RequestMethod.GET)
	public ModelAndView updateOtros(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaOtros","otros", otrosDao.getOtros(id));
	}

	@RequestMapping(value="/editaOtros/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitOtros(@PathVariable Integer id, @ModelAttribute("otros") Otros otros, BindingResult bindingResult, HttpSession session) {
		otros.setId(id);
		otrosDao.updateOtros(otros);
		//session.setAttribute("accion", "update");
		return "redirect:../listOtros.html"; 
	}


	@RequestMapping(value="/editaPlacasBase/{id}", method = RequestMethod.GET)
	public ModelAndView updatePlacasBase(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaPlacasBase","placaBase", placaBaseDao.getPlacaBase(id));
	}

	@RequestMapping(value="/editaPlacasBase/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitPlacasBase(@PathVariable Integer id, @ModelAttribute("placaBase") PlacaBase placaBase, BindingResult bindingResult, HttpSession session) {
		placaBase.setId(id);
		placaBaseDao.updatePlacaBase(placaBase);
		//session.setAttribute("accion", "update");
		return "redirect:../listPlacasBase.html"; 
	}


	@RequestMapping(value="/editaProcesador/{id}", method = RequestMethod.GET)
	public ModelAndView updateProcesador(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaProcesador","procesador", procesadorDao.getProcesador(id));
	}

	@RequestMapping(value="/editaProcesador/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitProcesador(@PathVariable Integer id, @ModelAttribute("procesador") Procesador procesador, BindingResult bindingResult, HttpSession session) {
		procesador.setId(id);
		procesadorDao.updateProcesador(procesador);
		//session.setAttribute("accion", "update");
		return "redirect:../listProcesador.html"; 
	}

	@RequestMapping(value="/editaRam/{id}", method = RequestMethod.GET)
	public ModelAndView updateRam(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaRam","ram", ramDao.getRam(id));
	}

	@RequestMapping(value="/editaRam/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitRam(@PathVariable Integer id, @ModelAttribute("ram") Ram ram, BindingResult bindingResult, HttpSession session) {
		ram.setId(id);
		ramDao.updateRam(ram);
		//session.setAttribute("accion", "update");
		return "redirect:../listRam.html"; 
	}


	@RequestMapping(value="/editaTarjetaGrafica/{id}", method = RequestMethod.GET)
	public ModelAndView updateTarjetaGrafica(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaTarjetaGrafica","tarjetaGrafica", tarjetaGraficaDao.getTarjetaGrafica(id));
	}

	@RequestMapping(value="/editaTarjetaGrafica/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitTarjetaGrafica(@PathVariable Integer id, @ModelAttribute("tarjetaGrafica") TarjetaGrafica tarjetaGrafica, BindingResult bindingResult, HttpSession session) {
		tarjetaGrafica.setId(id);
		tarjetaGraficaDao.updateTarjetaGrafica(tarjetaGrafica);
		//session.setAttribute("accion", "update");
		return "redirect:../listTarjetaGrafica.html"; 
	}

	@RequestMapping(value="/editaUnidadDVD/{id}", method = RequestMethod.GET)
	public ModelAndView updateUnidadDVD(@PathVariable Integer id, HttpSession session) { 
		return new ModelAndView("administracion/editaUnidadDVD","unidadDVD", dvdDao.getUnidadDVD(id));
	}

	@RequestMapping(value="/editaUnidadDVD/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmitUnidadDVD(@PathVariable Integer id, @ModelAttribute("unidadDVD") UnidadDVD unidadDVD, BindingResult bindingResult, HttpSession session) {
		unidadDVD.setId(id);
		dvdDao.updateUnidadDVD(unidadDVD);
		//session.setAttribute("accion", "update");
		return "redirect:../listDvd.html"; 
	}


	/** Controladores añadir componentes **/

	@RequestMapping("/anyadir")
	public ModelAndView anyadirProductos(HttpSession session) {
		ModelAndView model = new ModelAndView("administracion/anyadir");
		return model;
	}


	@RequestMapping(value="/anyadirDiscoDuro") 
	public ModelAndView addDiscoDuro(HttpSession session) {		
		return new ModelAndView("administracion/anyadirDiscoDuro", "discoDuro", factory.createComponente("discoDuro"));

	}

	@RequestMapping(value="/anyadirDiscoDuro", method=RequestMethod.POST)
	public String processAddSubmitDiscoDuro(@ModelAttribute("discoDuro") DiscoDuro discoDuro, BindingResult bindingResult, HttpSession session) {

		discoDuroDao.addDiscoDuro(discoDuro);
		discoDuro.setObservers(usuarioDao.getObservers());
		discoDuro.notifyObservers(discoDuro);

		return "redirect:./listDiscoDuro.html";
	}

	@RequestMapping(value="/anyadirMonitor") 
	public ModelAndView addMonitor(HttpSession session) {		
		return new ModelAndView("administracion/anyadirMonitor", "monitor", factory.createComponente("monitor"));
	}

	@RequestMapping(value="/anyadirMonitor", method=RequestMethod.POST)
	public String processAddSubmitMonitor(@ModelAttribute("monitor") Monitor monitor, BindingResult bindingResult, HttpSession session) {

		monitorDao.addMonitor(monitor);
		monitor.setObservers(usuarioDao.getObservers());
		monitor.notifyObservers(monitor);

		return "redirect:./listMonitor.html";
	}


	@RequestMapping(value="/anyadirOtros") 
	public ModelAndView addOtros(HttpSession session) {		
		return new ModelAndView("administracion/anyadirOtros", "otros", factory.createComponente("otros"));
	}

	@RequestMapping(value="/anyadirOtros", method=RequestMethod.POST)
	public String processAddSubmitOtros(@ModelAttribute("otros") Otros otros, BindingResult bindingResult, HttpSession session) {

		otrosDao.addOtros(otros);
		otros.setObservers(usuarioDao.getObservers());
		otros.notifyObservers(otros);

		return "redirect:./listOtros.html";
	}


	@RequestMapping(value="/anyadirPlacasBase") 
	public ModelAndView addPlacasBase(HttpSession session) {	
		return new ModelAndView("administracion/anyadirPlacasBase", "placaBase", factory.createComponente("placaBase"));
	}

	@RequestMapping(value="/anyadirPlacasBase", method=RequestMethod.POST)
	public String processAddSubmitPlacasBase(@ModelAttribute("placaBase") PlacaBase placaBase, BindingResult bindingResult, HttpSession session) {

		placaBaseDao.addPlacaBase(placaBase);
		placaBase.setObservers(usuarioDao.getObservers());
		placaBase.notifyObservers(placaBase);

		return "redirect:./listPlacasBase.html";
	}


	@RequestMapping(value="/anyadirProcesador") 
	public ModelAndView addProcesador(HttpSession session) {	
		return new ModelAndView("administracion/anyadirProcesador", "procesador", factory.createComponente("procesador"));
	}

	@RequestMapping(value="/anyadirProcesador", method=RequestMethod.POST)
	public String processAddSubmitProcesador(@ModelAttribute("procesador") Procesador procesador, BindingResult bindingResult, HttpSession session) {

		procesadorDao.addProcesador(procesador);
		procesador.setObservers(usuarioDao.getObservers());
		procesador.notifyObservers(procesador);

		return "redirect:./listProcesador.html";
	}


	@RequestMapping(value="/anyadirRam") 
	public ModelAndView addRam(HttpSession session) {		
		return new ModelAndView("administracion/anyadirRam", "ram", factory.createComponente("ram"));
	}

	@RequestMapping(value="/anyadirRam", method=RequestMethod.POST)
	public String processAddSubmitRam(@ModelAttribute("ram") Ram ram, BindingResult bindingResult, HttpSession session) {

		ramDao.addRam(ram);
		ram.setObservers(usuarioDao.getObservers());
		ram.notifyObservers(ram);

		return "redirect:./listRam.html";
	}


	@RequestMapping(value="/anyadirTarjetaGrafica") 
	public ModelAndView addTarjetaGrafica(HttpSession session) {		
		return new ModelAndView("administracion/anyadirTarjetaGrafica", "tarjetaGrafica", factory.createComponente("tarjetaGrafica"));
	}

	@RequestMapping(value="/anyadirTarjetaGrafica", method=RequestMethod.POST)
	public String processAddSubmitTarjetaGrafica(@ModelAttribute("tarjetaGrafica") TarjetaGrafica tarjetaGrafica, BindingResult bindingResult, HttpSession session) {

		tarjetaGraficaDao.addTarjetaGrafica(tarjetaGrafica);
		tarjetaGrafica.setObservers(usuarioDao.getObservers());
		tarjetaGrafica.notifyObservers(tarjetaGrafica);

		return "redirect:./listTarjetaGrafica.html";
	}


	@RequestMapping(value="/anyadirUnidadDVD") 
	public ModelAndView addUnidadDVD(HttpSession session) {		
		return new ModelAndView("administracion/anyadirUnidadDVD", "unidadDVD", factory.createComponente("uniddaDVD"));
	}

	@RequestMapping(value="/anyadirUnidadDVD", method=RequestMethod.POST)
	public String processAddSubmitUnidadDVD(@ModelAttribute("unidadDVD") UnidadDVD unidadDVD, BindingResult bindingResult, HttpSession session) {

		dvdDao.addUnidadDVD(unidadDVD);
		unidadDVD.setObservers(usuarioDao.getObservers());
		unidadDVD.notifyObservers(unidadDVD);

		return "redirect:./listDvd.html";
	}

}
