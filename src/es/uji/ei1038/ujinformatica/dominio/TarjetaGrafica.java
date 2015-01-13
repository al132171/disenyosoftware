package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class TarjetaGrafica extends ComponenteDecorador{

	private int id;
	private String chipset;
	private String memoria;
	private String tipoMemoria;
	private String bus;
	private double precio;
	private OrdenadorDecorator ordenador;

	
	
	public TarjetaGrafica() {
		this.id = 0;
		this.chipset = "";
		this.memoria = "";
		this.tipoMemoria = "";
		this.bus = "";
		this.precio = 0.0f;
	}
	
	public TarjetaGrafica(int id, String chipset, String memoria,
			String tipoMemoria, String bus, double precio) {
		this.id = id;
		this.chipset = chipset;
		this.memoria = memoria;
		this.tipoMemoria = tipoMemoria;
		this.bus = bus;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
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
		return ordenador.getDescripcion() + "<br> Tarjeta gráfica - Chipset: "+this.chipset
				+" , Memoria: "+this.memoria
				+" , Bus: "+this.bus
				+" , Precio: "+this.precio;
	}

	@Override
	public String getDescripcionPieza() {
		return "Tarjeta gráfica - Chipset: "+this.chipset
				+" , Memoria: "+this.memoria
				+" , Bus: "+this.bus
				+" , Precio: "+this.precio;
	}

}
