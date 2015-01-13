package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class Ram extends ComponenteDecorador{
	
	private int id;
	private String modelo;
	private String tipo;
	private int capacidad;
	private double precio;
	private OrdenadorDecorator ordenador;
	
	
	
	public Ram() {
		this.id = 0;
		this.modelo = "";
		this.tipo = "";
		this.capacidad = 0;
		this.precio = 0.0f;
	}
	public Ram(int id, String modelo, String tipo, int capacidad,
			double precio) {
		this.id = id;
		this.modelo = modelo;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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
		return ordenador.getDescripcion() + "<br> Ram - Modelo: "+this.modelo
				+" , Tipo: "+this.tipo
				+" , Capacidad: "+this.capacidad
				+" , Precio: "+this.precio;
	}
	@Override
	public String getDescripcionPieza() {
		return "Ram - Modelo: "+this.modelo
				+" , Tipo: "+this.tipo
				+" , Capacidad: "+this.capacidad
				+" , Precio: "+this.precio;
	}
	
}
