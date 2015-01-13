package es.uji.ei1039.ujinformatica.observer;

import java.util.List;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.dominio.Usuario;

public interface ComponenteSubject {

	public void setObservers(List<Usuario> observadores);
	public void notifyObservers(ComponenteDecorador componente); 
	
}
