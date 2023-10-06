package com.tmbs.ta07_03;

import com.tmbs.ta07_02.Producto;

// Esta clase extiende de producto y añade propiedad cantidad para ser almacenable
public class ArticuloAlmacenado  extends Producto {

	private int cantidad;
	
	public ArticuloAlmacenado(String nombre, Double precio, int iva, int cantidad) {
		super(nombre, precio, iva);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return  this.getNombre()  + "\nUd.:" + cantidad + "  PVP.Neto:" + this.getPrecioNeto() + "  IVA:" + this.getIva() +"%  PVP.IVA Incl.:"
				+ String.format("%.2f", this.getPrecioConIva()) + "";

	}
	
}