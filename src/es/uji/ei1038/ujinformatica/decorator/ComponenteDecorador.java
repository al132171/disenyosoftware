package es.uji.ei1038.ujinformatica.decorator;

import java.util.List;

import es.uji.ei1038.ujinformatica.dominio.Usuario;
import es.uji.ei1039.ujinformatica.observer.ComponenteSubject;
import es.uji.ei1039.ujinformatica.observer.UsuarioObservador;

public abstract class ComponenteDecorador extends OrdenadorDecorator implements ComponenteSubject{

	/**
	 *  Atributos de patrón observer
	 */
	private List<Usuario> observadores;
	
	
	
	public abstract String getDescripcionPieza();
	
	/**
	 * Funcionalidad del patrón decorator
	 */
	
	public abstract String getDescripcion();
	
	
	/**
	 * Funcionalidad del patrón observer
	 */
	
	public void setObservers(List<Usuario> list){
		this.observadores = list;
	}
	
	
	public void notifyObservers(ComponenteDecorador componente){
		for (UsuarioObservador usuarioObservador : observadores) {
			usuarioObservador.update(usuarioObservador, componente);
		}
	}
	
	
}
