package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class DiscoDuro extends ComponenteDecorador{
	
	private OrdenadorDecorator ordenador;
	private int id;
	private String interfaz;
	private String capacidad;
	private String cache; 
	private String rpm;
	private double precio;
	
	
	
	public DiscoDuro() {
		this.id = 0;
		this.interfaz = "";
		this.capacidad = "";
		this.cache = "";
		this.rpm = "";
		this.precio = 0.0f;
	}
	
	public DiscoDuro(int id, String interfaz, String capacidad, String cache,
			String rpm, double precio) {
		this.id = id;
		this.interfaz = interfaz;
		this.capacidad = capacidad;
		this.cache = cache;
		this.rpm = rpm;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInterfaz() {
		return interfaz;
	}
	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getCache() {
		return cache;
	}
	public void setCache(String cache) {
		this.cache = cache;
	}
	public String getRpm() {
		return rpm;
	}
	public void setRpm(String rpm) {
		this.rpm = rpm;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setOrdenador(OrdenadorDecorator ordenadorDecorator){
		this.ordenador = ordenadorDecorator;
	}
	
	@Override
	public double coste() {
		return this.precio + ordenador.coste();
	}
	
	@Override
	public String getDescripcion() {
		return ordenador.getDescripcion() + "<br> Disco duro - Interfaz: "+this.interfaz 
				+ ", Capacidad: "+this.capacidad 
				+ ", Caché: "+this.cache 
				+ ", Rpm :"+this.rpm
				+ ", Precio: "+this.precio;
	}

	@Override
	public String getDescripcionPieza() {
		return "Disco duro - Interfaz: "+this.interfaz 
			+ ", Capacidad: "+this.capacidad 
			+ ", Caché: "+this.cache 
			+ ", Rpm :"+this.rpm
			+ ", Precio: "+this.precio;
	}
	
}
