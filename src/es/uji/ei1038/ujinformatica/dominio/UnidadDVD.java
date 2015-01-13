package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class UnidadDVD extends ComponenteDecorador{
	private int id;
	private String tipo; //cd, dvd, blue-ray
	private String interfaz;
	private String velocidadEscritura;
	private double precio;
	private OrdenadorDecorator ordenador;
	
	
	
	public UnidadDVD() {
		this.id = 0;
		this.tipo = "";
		this.interfaz = "";
		this.velocidadEscritura = "";
		this.precio = 0.0f;
	}
	
	public UnidadDVD(int id, String tipo, String interfaz, String velocidadEscritura, double precio) {
		this.id = id;
		this.tipo = tipo;
		this.interfaz = interfaz;
		this.velocidadEscritura = velocidadEscritura;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getInterfaz() {
		return interfaz;
	}
	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}
	public String getVelocidadEscritura() {
		return velocidadEscritura;
	}
	public void setVelocidadEscritura(String velocidadEscritura) {
		this.velocidadEscritura = velocidadEscritura;
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
		return ordenador.getDescripcion() +"<br> Unidad grabadora DVD - Tipo: "+this.tipo
				+" , Interfaz: "+this.interfaz
				+" , Velocidad de escritura: "+this.velocidadEscritura
				+" , Precio: "+this.precio;
	}

	@Override
	public String getDescripcionPieza() {
		return "Unidad grabadora DVD - Tipo: "+this.tipo
				+" , Interfaz: "+this.interfaz
				+" , Velocidad de escritura: "+this.velocidadEscritura
				+" , Precio: "+this.precio;
	}

	
	
}
