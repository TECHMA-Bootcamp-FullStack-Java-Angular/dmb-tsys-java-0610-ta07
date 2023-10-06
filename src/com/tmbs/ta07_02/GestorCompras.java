package com.tmbs.ta07_02;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Utils;

/**
 * Esta clase contiene la lógica de negocio del nuestra App según las directrices del Ejercicio
 */
public class GestorCompras {

	// Declaramos Un ArrayList "Carrito" de productos donde añadiremos los Productos comprados
	static ArrayList<Producto> carrito = new ArrayList<Producto>();

	static Scanner sc = new Scanner(System.in);

	public static void run() {

		String seguir = "S";

		System.out.println("****************** APP CAJA REGISTRADORA ******************");

		while (!seguir.equals("N")) {

			pedirDatosCompra();
			seguir = consoleImput("\nDesea seguir Comprando? (s/n): ").toUpperCase();

		}

		// Instaciamos una CajaRegistradora y le pasamos el carrito de la compra
		CajaRegistradora cajareg = new CajaRegistradora(carrito);

		cajareg.generaResumenCompra().forEach(System.out::println);

		String abono;

		do {

			abono = consoleImput("Introduzca la cantidad que el cliente abona: ");

		} while (cajareg.getTotalPagar() > Double.valueOf(abono));

		cajareg.setImportePagado(Double.valueOf(abono));

		// Imprimos tiket de compra
		cajareg.generarTiket().forEach(System.out::println);

		sc.close();
	}

	/**
	 * Método para pedir los datos de una compra al usuario. El método solicita el
	 * nombre del producto, el precio del producto y si el producto tiene IVA
	 * reducido o no.
	 * <p>
	 * Si el producto no tiene IVA reducido, se crea un objeto de tipo Producto con
	 * el nombre y el precio ingresados y se agrega a la lista carrito.
	 * <p>
	 * Si el producto tiene IVA reducido, se crea un objeto de tipo Producto con el
	 * nombre, el precio ingresado y el valor del IVA reducido (4). Finalmente, el
	 * producto se agrega a la lista carrito.
	 **/
	public static void pedirDatosCompra() {

		String nombre = consoleImput("\nNombre del producto: ");
		String precio = consoleImput("Precio del producto: ");
		String iva = consoleImput("El producto tiene iva reducido? (s/n):");

		Producto producto = (!iva.toUpperCase().equals("S")) ? new Producto(nombre, Double.valueOf(precio))
				: new Producto(nombre, Double.valueOf(precio), 4);

		carrito.add(producto);

	}

	/**
	 * Método que muestra un texto en la consola y espera a recibir una entrada del
	 * usuario.
	 * 
	 * @param {@text String} el texto que se mostrará en la consola.
	 * @return String la entrada del usuario.
	 **/
	public static String consoleImput(String text) {
		System.out.print(text);
		return sc.next();

	}

}
