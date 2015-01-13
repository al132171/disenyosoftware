package es.uji.ei1038.ujinformatica.dominio;

import es.uji.ei1038.ujinformatica.decorator.OrdenadorDecorator;

public class Ordenador extends OrdenadorDecorator{

	private String nombre;
	private String nickname; // clave ajena a usuario
	private int idDiscoDuro;
	private int idProcesador;
	private int idRAM;
	private int idUnidadDVD;
	private int idMonitor;
	private int idTarjetaGrafica;
	private int idPlacaBase;
	private int idOtros;
	private double precio;

	
	
	public Ordenador() {
		this.nombre = "";
		this.nickname = "";
		this.idDiscoDuro = 0;
		this.idProcesador = 0;
		this.idRAM = 0;
		this.idUnidadDVD = 0;
		this.idMonitor = 0;
		this.idTarjetaGrafica = 0;
		this.idPlacaBase = 0;
		this.idOtros = 0;
		this.precio = 0.0f;
	}

	public Ordenador(String nombre, String nickname, int idDiscoDuro,
			int idProcesador, int idRAM, int idUnidadDVD, int idMonitor,
			int idTarjetaGrafica, int idPlacaBase, int idOtros, double precio) {
		this.nombre = nombre;
		this.nickname = nickname;
		this.idDiscoDuro = idDiscoDuro;
		this.idProcesador = idProcesador;
		this.idRAM = idRAM;
		this.idUnidadDVD = idUnidadDVD;
		this.idMonitor = idMonitor;
		this.idTarjetaGrafica = idTarjetaGrafica;
		this.idPlacaBase = idPlacaBase;
		this.idOtros = idOtros;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getIdDiscoDuro() {
		return idDiscoDuro;
	}

	public void setIdDiscoDuro(int idDiscoDuro) {
		this.idDiscoDuro = idDiscoDuro;
	}

	public int getIdProcesador() {
		return idProcesador;
	}

	public void setIdProcesador(int idProcesador) {
		this.idProcesador = idProcesador;
	}

	public int getIdRAM() {
		return idRAM;
	}

	public void setIdRAM(int idRAM) {
		this.idRAM = idRAM;
	}

	public int getIdUnidadDVD() {
		return idUnidadDVD;
	}

	public void setIdUnidadDVD(int idUnidadDVD) {
		this.idUnidadDVD = idUnidadDVD;
	}

	public int getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(int idMonitor) {
		this.idMonitor = idMonitor;
	}

	public int getIdTarjetaGrafica() {
		return idTarjetaGrafica;
	}

	public void setIdTarjetaGrafica(int idTarjetaGrafica) {
		this.idTarjetaGrafica = idTarjetaGrafica;
	}

	public int getIdPlacaBase() {
		return idPlacaBase;
	}

	public void setIdPlacaBase(int idPlacaBase) {
		this.idPlacaBase = idPlacaBase;
	}

	public int getIdOtros() {
		return idOtros;
	}

	public void setIdOtros(int idOtros) {
		this.idOtros = idOtros;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public double coste() {
		return precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	

}
