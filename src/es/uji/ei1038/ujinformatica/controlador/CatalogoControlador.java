package es.uji.ei1038.ujinformatica.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uji.ei1038.ujinformatica.daos.DiscoDuroDao;
import es.uji.ei1038.ujinformatica.daos.MonitorDao;
import es.uji.ei1038.ujinformatica.daos.OtrosDao;
import es.uji.ei1038.ujinformatica.daos.PlacaBaseDao;
import es.uji.ei1038.ujinformatica.daos.ProcesadorDao;
import es.uji.ei1038.ujinformatica.daos.RamDao;
import es.uji.ei1038.ujinformatica.daos.TarjetaGraficaDao;
import es.uji.ei1038.ujinformatica.daos.UnidadDVDDAO;
import es.uji.ei1038.ujinformatica.daos.UsuarioDao;

@Controller
@RequestMapping("/catalogo")
public class CatalogoControlador {
		
	private DiscoDuroDao discoDuroDao;
	private MonitorDao monitorDao;
	//private OrdenadorDao ordenadorDao;
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
			TarjetaGraficaDao tarjetaGraficaDao, UnidadDVDDAO dvdDao, UsuarioDao usuarioDao){
		this.discoDuroDao = discoDuroDao;
		this.monitorDao = monitorDao;
		this.otrosDao = otrosDao;
		this.ramDao = ramDao;
		this.placaBaseDao = placaBaseDao;
		this.procesadorDao = procesadorDao;
		this.tarjetaGraficaDao = tarjetaGraficaDao;
		this.dvdDao = dvdDao;
		//this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping("/listDiscoDuro")
	public ModelAndView getDiscoDuro(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listDiscoDuro", "discoDuro", discoDuroDao.getDiscosDuros());
		return model;
	}
	
	@RequestMapping("/listMonitor")
	public ModelAndView getMonitor(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listMonitor", "monitor", monitorDao.getMonitores());
		return model;
	}	
	
	@RequestMapping("/listOtros")
	public ModelAndView getOtros(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listOtros", "otros", otrosDao.getOtros());
		return model;
	}
	
	@RequestMapping("/listPlacasBase")
	public ModelAndView getPlacasBase(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listPlacasBase", "placas", placaBaseDao.getPlacasBase());
		return model;
	}
	
	@RequestMapping("/listProcesador")
	public ModelAndView getProcesador(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listProcesador", "procesador", procesadorDao.getProcesadores());
		return model;
	}
	
	@RequestMapping("/listRam")
	public ModelAndView getRam(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listRam", "ram", ramDao.getRams());
		return model;
	}
	
	@RequestMapping("/listTarjetaGrafica")
	public ModelAndView getTarjetaGrafica(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listTarjetaGrafica", "tarjetaGrafica", tarjetaGraficaDao.getTarjetasGraficas());
		return model;
	}
	
	@RequestMapping("/listDvd")
	public ModelAndView getDvd(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/listDvd", "dvd", dvdDao.getDvds());
		return model;
	}
	
	@RequestMapping("/productos")
	public ModelAndView productos(HttpSession session) {
		ModelAndView model = new ModelAndView("catalogo/productos");
		return model;
	}
}
