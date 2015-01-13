package es.uji.ei1038.ujinformatica.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;
import es.uji.ei1038.ujinformatica.dominio.DiscoDuro;
import es.uji.ei1038.ujinformatica.dominio.Monitor;
import es.uji.ei1038.ujinformatica.dominio.Ordenador;
import es.uji.ei1038.ujinformatica.dominio.Otros;
import es.uji.ei1038.ujinformatica.dominio.PlacaBase;
import es.uji.ei1038.ujinformatica.dominio.Procesador;
import es.uji.ei1038.ujinformatica.dominio.Ram;
import es.uji.ei1038.ujinformatica.dominio.TarjetaGrafica;
import es.uji.ei1038.ujinformatica.dominio.UnidadDVD;


@Controller
@RequestMapping("/simulador")
public class SimuladorControlador {

	private DiscoDuroDao discoDuroDao;
	private MonitorDao monitorDao;
	private OrdenadorDao ordenadorDao;
	private OtrosDao otrosDao;
	private PlacaBaseDao placaBaseDao;
	private ProcesadorDao procesadorDao;
	private RamDao ramDao;
	private TarjetaGraficaDao tarjetaGraficaDao;
	private UnidadDVDDAO dvdDao;
	//private UsuarioDao usuarioDao;


	@Autowired
	public void setComponentesDao(DiscoDuroDao discoDuroDao, MonitorDao monitorDao, OtrosDao otrosDao, 
			RamDao ramDao, PlacaBaseDao placaBaseDao, ProcesadorDao procesadorDao,
			TarjetaGraficaDao tarjetaGraficaDao, UnidadDVDDAO dvdDao, UsuarioDao usuarioDao, 
			OrdenadorDao ordenadorDao){
		this.discoDuroDao = discoDuroDao;
		this.monitorDao = monitorDao;
		this.otrosDao = otrosDao;
		this.ramDao = ramDao;
		this.placaBaseDao = placaBaseDao;
		this.procesadorDao = procesadorDao;
		this.tarjetaGraficaDao = tarjetaGraficaDao;
		this.dvdDao = dvdDao;
		this.ordenadorDao = ordenadorDao;
		//this.usuarioDao = usuarioDao;
	}

	// validador que comprueba si el nombre que se intenta dar al pc ya existe
	class validadorNombrePc implements Validator{		
		@Override
		public boolean supports(Class<?> cls) {
			return validadorNombrePc.class.equals(cls);
		}

		@Override
		public void validate(Object obj, Errors errors) {
			Ordenador ordenador = (Ordenador) obj;
			// si existe un ordenador con ese nombre en el historico de ese usuario devuelve true
			// en caso contrario false
			boolean ordenadorRecuperado = ordenadorDao.getOrdenadorUsuarioNombre(ordenador.getNickname(), ordenador.getNombre());
			if( ordenadorRecuperado ){
				errors.rejectValue("nombre", "Nombre repetido", "Ya has guardado un pc con ese nombre");		
			}
		}
	}


	// validador que comprueba si se ha seleccionado una pieza de cada sección
	class validadorTodasPiezas implements Validator{		
		@Override
		public boolean supports(Class<?> cls) {
			return validadorTodasPiezas.class.equals(cls);
		}

		@Override
		public void validate(Object obj, Errors errors) {

			Ordenador ordenador = (Ordenador) obj;
			// si existe una pieza con id=0 es erroneo, no se ha seleccionado una pieza en esa sección
			if( ordenador.getIdPlacaBase() == 0 ){
				errors.rejectValue("idPlacaBase", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdDiscoDuro() == 0 ){
				errors.rejectValue("idDiscoDuro", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdMonitor() == 0 ){
				errors.rejectValue("idMonitor", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdOtros() == 0 ){
				errors.rejectValue("idOtros", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdProcesador() == 0 ){
				errors.rejectValue("idProcesador", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdRAM() == 0 ){
				errors.rejectValue("idRAM", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdTarjetaGrafica() == 0 ){
				errors.rejectValue("idTarjetaGrafica", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}

			if( ordenador.getIdUnidadDVD() == 0 ){
				errors.rejectValue("idUnidadDVD", "Pieza no seleccionada", "Debes seleccionar una pieza");		
			}
		}
	}


	@RequestMapping("../index")
	public ModelAndView indice() {
		return new ModelAndView("../index");
	}

	@RequestMapping("/simulador")
	public ModelAndView mostrarComponentes(HttpSession session) {
		ModelAndView model = new ModelAndView("simulador/simulador");
		List<DiscoDuro> discoDuro = this.discoDuroDao.getDiscosDuros();
		List<Procesador> procesador = this.procesadorDao.getProcesadores();
		List<Monitor> monitor = this.monitorDao.getMonitores();
		List<Otros> otros = this.otrosDao.getOtros();
		List<Ram> ram = this.ramDao.getRams();
		List<PlacaBase> placasBase = this.placaBaseDao.getPlacasBase();
		List<TarjetaGrafica> tarjetaGrafica = this.tarjetaGraficaDao.getTarjetasGraficas();
		List<UnidadDVD> dvd = this.dvdDao.getDvds();

		session.setAttribute("discoDuro", discoDuro);
		model.addObject("discoDuro", discoDuro);
		
		session.setAttribute("procesador", procesador);
		model.addObject("procesador", procesador);
		
		session.setAttribute("monitor", monitor);
		model.addObject("monitor", monitor);
		
		session.setAttribute("otros", otros);
		model.addObject("otros", otros);
		
		session.setAttribute("ram", ram);
		model.addObject("ram", ram);
		
		session.setAttribute("placasBase", placasBase);
		model.addObject("placasBase", placasBase);
		
		session.setAttribute("tarjetaGrafica", tarjetaGrafica);
		model.addObject("tarjetaGrafica", tarjetaGrafica);
		
		session.setAttribute("dvd", dvd);
		model.addObject("dvd", dvd);		
		return model.addObject("ordenador", new Ordenador());
	}


	@RequestMapping(value="/simulador", method=RequestMethod.POST)
	public String mostrarDescripcion(@ModelAttribute("ordenador") Ordenador ordenador, BindingResult bindingResult, HttpSession session) {


		// TODO VALIDADOR todas las piezas id > 0
		validadorTodasPiezas validador = new validadorTodasPiezas();
		validador.validate(ordenador, bindingResult);
		
		if( bindingResult.hasErrors() ){
			return "simulador/simulador";
		}

		OrdenadorDecorator ordenadorDecorator = ordenador; 
		PlacaBase pb = this.placaBaseDao.getPlacaBase(ordenador.getIdPlacaBase());
		pb.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = pb;

		Procesador pr = this.procesadorDao.getProcesador(ordenador.getIdProcesador());
		pr.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = pr;

		Ram ram = this.ramDao.getRam(ordenador.getIdRAM());
		ram.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = ram;

		DiscoDuro dd = this.discoDuroDao.getDiscoDuro(ordenador.getIdDiscoDuro());
		dd.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = dd;

		TarjetaGrafica tj = this.tarjetaGraficaDao.getTarjetaGrafica(ordenador.getIdTarjetaGrafica());
		tj.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = tj;


		Monitor m = this.monitorDao.getMonitor(ordenador.getIdMonitor());
		m.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = m;

		UnidadDVD dvd = this.dvdDao.getUnidadDVD(ordenador.getIdUnidadDVD());
		dvd.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = dvd;

		Otros o = this.otrosDao.getOtros(ordenador.getIdOtros());
		o.setOrdenador(ordenadorDecorator);
		ordenadorDecorator = o;


		ModelAndView modelo = new ModelAndView();
		modelo.addObject("ordenador", ordenador);
		modelo.addObject("descripcion", ordenadorDecorator.getDescripcion());
		modelo.addObject("precio", Math.round(ordenadorDecorator.coste()));
		modelo.setViewName("redirect:/simulador/resultado.html");
		session.setAttribute("ordenador", ordenador);
		session.setAttribute("descripcion", ordenadorDecorator.getDescripcion());
		session.setAttribute("precio", ordenadorDecorator.coste());
		return "redirect:/simulador/resultado.html";
	}

	//TODO:revisar lo del ordenador, porque sus atributos se ponen 0.
	@RequestMapping(value="/resultado")
	public ModelAndView mostrarResultado(@ModelAttribute("ordenador") Ordenador ordenador, HttpSession session) {
		ModelAndView modelo = new ModelAndView("simulador/resultado", "ordenador", session.getAttribute("ordenador"));
		return modelo;
	}

	@RequestMapping(value="/resultado", method=RequestMethod.POST)
	public String mostrarHistorico(@ModelAttribute("ordenador") Ordenador ordenador, BindingResult bindingResult, HttpSession session) {
		System.out.println(ordenador.getPrecio() + ordenador.getDescripcion());
		Ordenador ordenadorCreado = (Ordenador)session.getAttribute("ordenador");
		ordenadorCreado.setNombre(ordenador.getNombre());
		ordenadorCreado.setNickname((String) session.getAttribute("identificador"));
		ordenadorCreado.setPrecio((double) session.getAttribute("precio"));
		ordenadorCreado.setDescripcion((String)session.getAttribute("descripcion")); 

		// validador nombre de pc

		validadorNombrePc validador = new validadorNombrePc();
		validador.validate(ordenadorCreado, bindingResult);

		if (bindingResult.hasErrors()){
			return "simulador/resultado";
		}

		this.ordenadorDao.addOrdenador(ordenadorCreado);
		return "redirect:/usuario/historico.html";
	}





}
