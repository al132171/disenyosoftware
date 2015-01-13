package es.uji.ei1038.ujinformatica.decorator;

public abstract class OrdenadorDecorator {

	//protected porque no está en el mismo paquete
	protected String descripcion = "";
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public abstract double coste();
}
