package com.tmbs.ta07_02;

/**
 * Clase que representa un producto.
 *
 * <li>private String nombre;
 * <li>private Double precioNeto;
 * <li>private int iva;
 * <li>private Double precioConIva;
 *
 * <h4>Constructores</h4>
 * <ol>
 * 
 * @param nombre El nombre del producto.
 * @param precio El precio neto del producto.
 * <hr>
 *
 * <ol>
 * @param nombre El nombre del producto.
 * @param precio El precio neto del producto.
 * @param iva    El porcentaje del IVA a aplicar al producto.
 * 
 */
public class Producto {

	private String nombre;
	private Double precioNeto;
	private int iva;
	private Double precioConIva;

	private final int IVA21 = 21;

	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precioNeto = precio;
		this.iva = IVA21;
		this.setPrecioConIva(precio + (precio * this.iva / 100));
	}

	public Producto(String nombre, Double precio, int iva) {
		this.nombre = nombre;
		this.precioNeto = precio;
		this.iva = iva;
		this.setPrecioConIva(precio + (precio * this.iva / 100));
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecioNeto() {
		return precioNeto;
	}

	public int getIva() {
		return iva;
	}

	public Double getPrecioConIva() {
		return precioConIva;
	}

	public void setPrecioConIva(Double precioConIva) {
		this.precioConIva = precioConIva;
	}

}