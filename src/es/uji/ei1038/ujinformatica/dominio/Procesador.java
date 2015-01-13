package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class Procesador extends ComponenteDecorador{
	
	private int id;
	private String modelo;
	private int nucleos;
	private String frecuencia;
	private String marca;
	private String socket;
	private double precio;
	private OrdenadorDecorator ordenador;
	
	
	
	public Procesador() {
		this.id = 0;
		this.modelo = "";
		this.nucleos = 0;
		this.frecuencia = "";
		this.marca = "";
		this.socket = "";
		this.precio = 0.0f;
	}
	public Procesador(int id, String modelo, int nucleos, String frecuencia,
			String marca, String socket, int precio) {
		this.id = id;
		this.modelo = modelo;
		this.nucleos = nucleos;
		this.frecuencia = frecuencia;
		this.marca = marca;
		this.socket = socket;
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
	public int getNucleos() {
		return nucleos;
	}
	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Procesador [id=" + id + ", modelo=" + modelo + ", nucleos="
				+ nucleos + ", frecuencia=" + frecuencia + ", marca=" + marca
				+ ", socket=" + socket + ", precio=" + precio + "]";
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
		return ordenador.getDescripcion() + "<br> Procesador - Modelo: "+this.modelo
				+" , Núcleos: "+this.nucleos
				+" , Frecuencia: "+this.frecuencia
				+" , Marca: "+this.marca
				+" , Socket: "+this.socket
				+" , Precio: "+this.precio;
	}
	@Override
	public String getDescripcionPieza() {
		return "Procesador - Modelo: "+this.modelo
				+" , Núcleos: "+this.nucleos
				+" , Frecuencia: "+this.frecuencia
				+" , Marca: "+this.marca
				+" , Socket: "+this.socket
				+" , Precio: "+this.precio;
	}
	
	
}
