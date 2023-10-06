package com.tmbs.ta07_02;

import java.util.ArrayList;

import utils.Utils;

/**
 * Clase que representa una Caja Registradora
 *
 * <li>private ArrayList<Producto> ventas;
 * <li>private Integer totalNumCompras;
 * <li>private Double totalPagar;
 * <li>private Double importePagado;
 * <li>private Double devolicion;
 *
 * <h4>Constructores</h4>
 * <ol>
 * 
 * @param ArrayList {@link Producto } el carrito seran llena nuestas ventas.
 *
 */
public class CajaRegistradora {

	private ArrayList<Producto> ventas;
	private Integer totalNumCompras;
	private Double totalPagar = 0.0;
	private Double importePagado;
	private Double devolucion = 0.0;

	public CajaRegistradora() {
	}

	public CajaRegistradora(ArrayList<Producto> carrito) {

		this.ventas = carrito;

		for (Producto venta : ventas)
			this.totalPagar += venta.getPrecioConIva();

		this.totalNumCompras = carrito.size();

	}

	// Getters
	public ArrayList<Producto> getVentas() {
		return ventas;
	}

	public Integer getTotalNumCompras() {
		return totalNumCompras;

	}

	public Double getTotalPagar() {
		return totalPagar;
	}

	public Double getImportePagado() {
		return importePagado;
	}

	public Double getDevolicion() {
		return devolucion;
	}

	// Setters
	public void setVentas(ArrayList<Producto> ventas) {
		this.ventas = ventas;

	}

	public void setTotalNumCompras(Integer totalNumCompras) {
		this.totalNumCompras = totalNumCompras;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public void setImportePagado(Double importePagado) {

		if (this.devolucion == 0.0) {
			this.devolucion = importePagado - this.totalPagar;
		}
		this.importePagado = importePagado;
	}

	public void setDevolución(Double devolicion) {
		this.devolucion = devolicion;
	}

	/**
	 * Método genera un resumen de la compra con la información del Total a pagar y
	 * las unidades adquiridas.
	 * 
	 * @return ArrayList {String} Con la información de las venta.
	 */
	public ArrayList<String> generaResumenCompra() {

		ArrayList<String> resumenCompras = new ArrayList<String>();

		// header
		resumenCompras.add(Utils.hr());
		resumenCompras.add("\t\tRESUMEN CESTA DE LA COMPRA");

		// body
		resumenCompras.add("\t\tUd:" + this.getTotalNumCompras() + "\t Total:"
				+ String.format("%.2f", this.getTotalPagar()) + "€");

		resumenCompras.add(Utils.hr());

		return resumenCompras;
	}

	/**
	 * Método genera un ticket de compra con la información de las ventas
	 * realizadas.
	 * 
	 * @return ArrayList {String} El ticket generado con la información de las
	 *         ventas.
	 */
	public ArrayList<String> generarTiket() {

		ArrayList<String> tiket = new ArrayList<String>();

		StringBuilder textBuffer;
		textBuffer = new StringBuilder();

		// header tiket
		tiket.add(Utils.orange(Utils.hr()));
		tiket.add(Utils.cian("\t\t\t\tTIKET MARKET"));
		tiket.add(Utils.orange(Utils.hr()));

		// body tiket
		ventas.forEach((Producto e) -> {

			textBuffer.append("  ")
					.append(e.getNombre().toUpperCase())
					.append("\n  Precio: ")
					.append(e.getPrecioNeto())
					.append(" € \t IVA ")
					.append(e.getIva())
					.append(" % \tTOTAL: ")
					.append(String.format("%.2f", e.getPrecioConIva()))
					.append("\n");

		});

		tiket.add(textBuffer.toString());

		// footer tiket
		String total = String.format("%.2f", this.getTotalPagar());
		String cambio = String.format("%.2f", this.devolucion);

		tiket.add(Utils.orange(Utils.hr()));
		tiket.add("\tTOTAL: " + total + "\tABONO: " + this.getImportePagado() + "\tCAMBIO: " + cambio);
		tiket.add(Utils.orange(Utils.hr()));

		return tiket;
	}
}