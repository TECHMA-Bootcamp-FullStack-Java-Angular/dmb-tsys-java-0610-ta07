package com.tmbs.ta07_03;

import java.util.ArrayList;
import java.util.Hashtable;
import utils.Utils;

// Mock datos + CRUD 
public class AlmacenServices {
	
	public Hashtable<String, ArticuloAlmacenado> stock = new Hashtable<>();

	public AlmacenServices() {

		// Mock datos Alamacen
		ArticuloAlmacenado KIWI = new ArticuloAlmacenado("KIWI", 1.2, 21, 200);
		ArticuloAlmacenado MIEL = new ArticuloAlmacenado("MIEL", 4.99, 21, 100);
		ArticuloAlmacenado VINO = new ArticuloAlmacenado("VINO", 3.85, 21, 450);
		ArticuloAlmacenado PERA = new ArticuloAlmacenado("PERA", 1.25, 21, 400);
		ArticuloAlmacenado AJO = new ArticuloAlmacenado("AJO", 0.60, 21, 200);
		ArticuloAlmacenado ARROZ = new ArticuloAlmacenado("ARROZ", 0.80, 04, 1500);
		ArticuloAlmacenado CAFE = new ArticuloAlmacenado("CAFE", 1.85, 21, 550);
		ArticuloAlmacenado PAN = new ArticuloAlmacenado("PAN", 0.85, 04, 52);
		ArticuloAlmacenado ATUN = new ArticuloAlmacenado("ATUN", 1.10, 21, 1080);
		ArticuloAlmacenado SAL = new ArticuloAlmacenado("SAL", 2.15, 21, 2300);
		ArticuloAlmacenado LECHE = new ArticuloAlmacenado("LECHE", 1.55, 4, 125);

		this.stock.put(KIWI.getNombre(), KIWI);
		this.stock.put(MIEL.getNombre(), MIEL);
		this.stock.put(VINO.getNombre(), VINO);
		this.stock.put(PERA.getNombre(), PERA);
		this.stock.put(AJO.getNombre(), AJO);
		this.stock.put(ARROZ.getNombre(), ARROZ);
		this.stock.put(CAFE.getNombre(), CAFE);
		this.stock.put(PAN.getNombre(), PAN);
		this.stock.put(ATUN.getNombre(), ATUN);
		this.stock.put(SAL.getNombre(), SAL);
		this.stock.put(LECHE.getNombre(), LECHE);

	}


	public Hashtable<String, ArticuloAlmacenado> getStock() {
		return stock;
	}

	public void setStock(Hashtable<String, ArticuloAlmacenado> stock) {
		this.stock = stock;
	}
	
	
	/**Borra un producto
	 * @return {String} estado de la solucitud*/
	public String deleteProduct(String n) {
		n = n.toUpperCase();
		if (this.getStock().get(n) != null) {
			this.getStock().remove(n);
			return  Utils.green(n +" eliminado del almacen");

		} else {
			return Utils.green("No exite el producto que desaea eliminar; " + n);
		}
	}
	
	/**Actualiza un producto
	 * @return {String} estado de la solucitud*/
	public String updateProducts(String n, ArticuloAlmacenado p) {
		n = n.toUpperCase();
		
		if (this.getStock().get(n) != null) {
			this.getStock().replace(n, p);
			return Utils.green("Procucto actualizado");
		} else {
			return Utils.green("No exite el producto que desaea actualizar: " + n);
		}
	}
	
	/**Añade un producto
	 * @return {String} estado de la solucitud*/
	public String addProducts(String n, ArticuloAlmacenado p) {
		n = n.toUpperCase();
		this.getStock().put(n, p);
	    return  Utils.green("Procucto agregado");	
	}

	/** Da una lista de productos
	 * @return ArrayList {String}*/
	public ArrayList<String> getAllProducts() {
		
		ArrayList<String> listaProductos = new ArrayList<String>();
		
		stock.forEach(( key , v ) -> listaProductos.add("\t" + key + "\t\t" + v.getPrecioNeto() + " euros \t\t" + v.getCantidad() + " Ud."));
			
		return listaProductos;
	}

	/**Busca un producto
	 * @return {String} con el producto*/
	public String findProduct(String n) {	
		n = n.toUpperCase();
		
		if (this.getStock().get(n) == null) {
			return Utils.green("No hay existencias del producto " + n.toUpperCase());
		} else {
			return "DISPONIBLE: " + this.getStock().get(n);
		}
	}

}
