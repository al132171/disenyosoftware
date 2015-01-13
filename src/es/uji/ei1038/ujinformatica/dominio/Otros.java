package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class Otros extends ComponenteDecorador{

	private int id;
	private String nombre;
	private String datos;
	private double precio;
	private OrdenadorDecorator ordenador = new Ordenador();
	
	public Otros() {
		this.id = 0;
		this.nombre = "";
		this.datos= "";
		this.precio = 0.0f;
	}
	public Otros(int id, String nombre, String datos, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.datos = datos;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
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
		return ordenador.getDescripcion() + "<br> Periférico - Nombre: "+this.nombre
				+ ", Descripción: "+this.datos + ", Precio: "+this.precio;
	}
	@Override
	public String getDescripcionPieza() {
		return "Periférico - Nombre: "+this.nombre
				+ ", Descripción: "+this.datos + ", Precio: "+this.precio;
	}
	
	
}
