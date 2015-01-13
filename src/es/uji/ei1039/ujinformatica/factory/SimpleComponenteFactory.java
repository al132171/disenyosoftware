package es.uji.ei1039.ujinformatica.factory;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.dominio.DiscoDuro;
import es.uji.ei1038.ujinformatica.dominio.Monitor;
import es.uji.ei1038.ujinformatica.dominio.Otros;
import es.uji.ei1038.ujinformatica.dominio.PlacaBase;
import es.uji.ei1038.ujinformatica.dominio.Procesador;
import es.uji.ei1038.ujinformatica.dominio.Ram;
import es.uji.ei1038.ujinformatica.dominio.TarjetaGrafica;
import es.uji.ei1038.ujinformatica.dominio.UnidadDVD;

public class SimpleComponenteFactory {
	public ComponenteDecorador createComponente (String type) {
		ComponenteDecorador componente = null;
		
		if (type.equals("discoDuro")) {
			componente = new DiscoDuro();			
		} else if (type.equals("monitor")){
			componente = new Monitor();
		} else if (type.equals("otros")) {
			componente = new Otros();
		} else if (type.equals("placaBase")) {
			componente = new PlacaBase();
		} else if (type.equals("procesador")) {
			componente = new Procesador();
		} else if (type.equals("ram")) {
			componente = new Ram();
		} else if (type.equals("tarjetaGrafica")) {
			componente = new TarjetaGrafica();
		} else if (type.equals("unidadDVD")) {
			componente = new UnidadDVD();
		}
		return componente;
	}

}
