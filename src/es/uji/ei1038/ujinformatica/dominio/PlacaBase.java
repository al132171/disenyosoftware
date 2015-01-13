package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class PlacaBase extends ComponenteDecorador{
	
	private int id;
	private String socketProcesador;
	private String interfazDiscoDuro;
	private String tipoRam;
	private String interfazDvd;
	private String busTj; //bus tarjeta gráfica
	private String modelo;
	private double precio;
	private OrdenadorDecorator ordenador;
	
	
	
	public PlacaBase() {
		this.id = 0;
		this.socketProcesador = "";
		this.interfazDiscoDuro = "";
		this.tipoRam = "";
		this.interfazDvd = "";
		this.busTj = "";
		this.modelo = "";
		this.precio = 0.0f;
	}
	public PlacaBase(int id, String socketProcesador, String interfazDiscoDuro,
			String tipoRam, String interfazDvd, String busTj, String modelo,
			double precio) {
		this.id = id;
		this.socketProcesador = socketProcesador;
		this.interfazDiscoDuro = interfazDiscoDuro;
		this.tipoRam = tipoRam;
		this.interfazDvd = interfazDvd;
		this.busTj = busTj;
		this.modelo = modelo;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSocketProcesador() {
		return socketProcesador;
	}
	public void setSocketProcesador(String socketProcesador) {
		this.socketProcesador = socketProcesador;
	}
	public String getInterfazDiscoDuro() {
		return interfazDiscoDuro;
	}
	public void setInterfazDiscoDuro(String interfazDiscoDuro) {
		this.interfazDiscoDuro = interfazDiscoDuro;
	}
	public String getTipoRam() {
		return tipoRam;
	}
	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}
	public String getInterfazDvd() {
		return interfazDvd;
	}
	public void setInterfazDvd(String interfazDvd) {
		this.interfazDvd = interfazDvd;
	}
	public String getBusTj() {
		return busTj;
	}
	public void setBusTj(String busTj) {
		this.busTj = busTj;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
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
		return ordenador.getDescripcion() + "Placa base - Socket procesador: "+this.socketProcesador
				+" , Tipo ram: "+this.tipoRam
				+" , Interfaz grabadora dvd: "+this.interfazDvd
				+" , Bus tarjeta gráfica: "+this.busTj
				+" , Modelo: "+this.modelo
				+" , Precio: "+this.precio;
	}
	@Override
	public String getDescripcionPieza() {
		return "Placa base - Socket procesador: "+this.socketProcesador
				+" , Tipo ram: "+this.tipoRam
				+" , Interfaz grabadora dvd: "+this.interfazDvd
				+" , Bus tarjeta gráfica: "+this.busTj
				+" , Modelo: "+this.modelo
				+" , Precio: "+this.precio;
	}
	
	
}
