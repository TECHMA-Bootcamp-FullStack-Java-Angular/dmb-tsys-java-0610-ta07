package com.tmbs.ta07_04;

import java.util.ArrayList;
import com.tmbs.ta07_02.CajaRegistradora;
import com.tmbs.ta07_03.ArticuloAlmacenado;

import utils.Utils;


// Extendemos la CajaRegistradora y adaptamos a para que cuente y elimine los productos del almacen 
public class CajaRegAdapter extends CajaRegistradora{
	
	ArrayList<Double> totalPorProducto = new ArrayList<Double>();
	ArrayList<ArticuloAlmacenado> ventas = new ArrayList<ArticuloAlmacenado>();	
	
	public CajaRegAdapter(ArrayList<ArticuloAlmacenado> ventas ) {
		
		this.ventas = ventas;
				
		ventas.forEach(( venta  -> totalPorProducto.add( venta.getPrecioConIva() + venta.getCantidad())));
		
		totalPorProducto.forEach(( e ->  this.setTotalPagar( this.getTotalPagar() + e)));
		
		this.setTotalNumCompras(ventas.size());
			
	}

	
	@ Override
	public ArrayList<String> generaResumenCompra (){
		
		ArrayList<String> resumenCompra = new ArrayList<String>();	
		
		// header 
		resumenCompra.add(Utils.hr());
		resumenCompra.add("\t\tRESUMEN CESTA DE LA COMPRA");
		
		// body
		resumenCompra.add("\tArt:" + this.getTotalNumCompras()
		+ "\t Total:" + String.format("%.2f", this.getTotalPagar() )
		+ " euros");
		
		resumenCompra.add(Utils.hr());
		
		return resumenCompra;
	}


	@ Override
	public ArrayList<String> generarTiket() {
		 
		 ArrayList<String> tiket = new ArrayList<String>();
		 		
		     // header tiket
		     tiket.add(Utils.hr());
		     tiket.add("\t\t\tSU TIKET DE COMPRA");
		     tiket.add(Utils.hr());
	
		     // body tiket
		     ventas.forEach((e) -> {
		    	 
		    	    String nombre = e.getNombre().toUpperCase();
					Double precioNeto = e.getPrecioNeto();
					int iva = e.getIva();
					Double precioConIva = e.getPrecioConIva();
					int cantidad = e.getCantidad();
					Double precioTotalxProducto = precioConIva * cantidad;
		    	 
					tiket.add(" " + nombre + "\n  Precio: " + precioNeto + " euro \t IVA " + iva
							+ " % \t PVP: " + String.format("%.2f", precioConIva) + "\nUd.:" 
							+ cantidad + "\t TOTAL:"+ String.format("%.2f", precioTotalxProducto));
		    	 
		     });
			
		    // footer tiket
			tiket.add(Utils.hr());
			tiket.add("\n TOTAL A PAGAR: " + String.format("%.2f", this.getTotalPagar()) 
			+ "\t ABONO: " + String.format("%.2f",this.getImportePagado())
			+ "\t CAMBIO: " +  String.format("%.2f",this.getDevolicion()));	
			tiket.add(Utils.hr());
			
			return tiket;
		}

	
	public ArrayList<Double>  getTotalPorProducto() {
		return this.totalPorProducto;
	}
	
	public ArrayList<ArticuloAlmacenado> getVentasAlamacen() {
		return ventas;	
	}
	
	
	public ArrayList<Double>  setTotalPorProducto( ArrayList<Double> totalPorProducto) {
		return this.totalPorProducto;
	}
	
	public void setVentasAlamcen(ArrayList<ArticuloAlmacenado> ventas) {
		this.ventas = ventas;
	}
	
} 