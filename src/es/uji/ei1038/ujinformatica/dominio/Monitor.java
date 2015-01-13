package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class Monitor extends ComponenteDecorador{

	private int id;
	private String pantalla; //tipo de la pantalla
	private String tamanyo;
	private String resolucion;
	private double precio;
	private OrdenadorDecorator ordenador;
	
	
	
	public Monitor() {
		this.id = 0;
		this.pantalla = "";
		this.tamanyo = "";
		this.resolucion = "";
		this.precio = 0;
	}
	public Monitor(int id, String pantalla, String tamanyo,
			String relacionAspecto, String resolucion, double precio) {
		this.id = id;
		this.pantalla = pantalla;
		this.tamanyo = tamanyo;
		this.resolucion = resolucion;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPantalla() {
		return pantalla;
	}
	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	public String getTamanyo() {
		return tamanyo;
	}
	public void setTamanyo(String tamanyo) {
		this.tamanyo = tamanyo;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
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
		return ordenador.getDescripcion() + "<br> Monitor - Pantalla: "+this.pantalla
				+ ", Tamaño: "+this.tamanyo+", Resolución: "+this.resolucion
				+ ", Precio: "+this.precio;
	}
	@Override
	public String getDescripcionPieza() {
		return " Monitor - Pantalla: "+this.pantalla
				+ ", Tamaño: "+this.tamanyo+", Resolución: "+this.resolucion
				+ ", Precio: "+this.precio;
	}
	
	
}
