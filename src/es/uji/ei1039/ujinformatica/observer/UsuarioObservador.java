package es.uji.ei1039.ujinformatica.observer;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;

public interface UsuarioObservador {

	public void update(UsuarioObservador usuarioObservador, ComponenteDecorador componente);

}
