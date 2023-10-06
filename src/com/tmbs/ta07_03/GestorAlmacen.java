package com.tmbs.ta07_03;

import java.util.Arrays;
import java.util.Scanner;

import utils.Utils;

/**
 * Esta clase contiene la lógica de negocio del nuestra App sen según las directrices del Ejercicio
 */
public class GestorAlmacen {

	static Scanner sc = new Scanner(System.in);

	public static void run() {
	
		AlmacenServices almacen = new AlmacenServices();

		System.out.println(Utils.hr());
		System.out.println(Utils.orange("\t\t\t\tGESTOR ALMACEN"));
		System.out.println(Utils.hr());

		String[] optionsMenu = { " 1.- Ver stock de productos", " 2.- Buscar producto", " 3.- Agregar producto",
				" 4.- Eliminar producto", " 5.- Salir" };

		String exit = "";

		while (!exit.equals("5")) {

			Arrays.asList(optionsMenu).forEach(System.out::println);

			System.out.print("\nELIJA UNA OPCION [1|2|3|4|5]: ");
			exit = sc.next();

			switch (exit) {

			case "1": {
				System.out.println(Utils.hr());
				System.out.println(Utils.cian("\t\t\tLISTA DE PRODUCTOS"));
				System.out.println(Utils.hr());
				
				almacen.getAllProducts().stream().sorted().forEach(System.out::println);
				System.out.println(Utils.hr());

				break;

			}
			case "2": {

				System.out.println(Utils.hr());
				System.out.println(Utils.cian("\t\t\tBUCADOR DE PRODUCTOS"));
				System.out.println(Utils.hr());
	
				String nombre = aksValue("Nombre del producto: ");
				System.out.println(almacen.findProduct(nombre));
				System.out.println(Utils.hr());

				break;

			}
			case "3": {

				System.out.println(Utils.hr());
				System.out.println(Utils.cian("\t\t\tAGRAGAR PROCUTO"));
				System.out.println(Utils.hr());
	
				ArticuloAlmacenado procduto = pedirProducto();
				System.out.println(almacen.addProducts(procduto.getNombre(), procduto));
				System.out.println(Utils.hr());

				break;
			}
			case "4": {
				System.out.println(Utils.hr());
				System.out.println(Utils.cian("\t\t\tELINAR UN PROCUTO"));
				System.out.println(Utils.hr());

				String nombre = aksValue("\nNombre del producto: ");
				System.out.println(almacen.deleteProduct(nombre));
				System.out.println(Utils.hr());

				break;
			}
			case "5": {

				System.out.println("EXIT GESTION DE ALMACEN");

				break;
			}
			default:

				System.out.println(Utils.cian("DEBE ELEGIR UNA DE LAS OPCION"));

				break;
			}

		}

	}

	public static String aksValue(String txt) {

		System.out.print(txt);
		return sc.next().toUpperCase();
	}

	public static ArticuloAlmacenado pedirProducto() {

		String nombre = aksValue("\nNombre del producto: ");
		String precio = aksValue("Precio Neto de producto: ");
		String cantidad = aksValue("Cantidad almacenada: ");
		String iva = aksValue("El producto tiene iva reducido? (s/n):");

		ArticuloAlmacenado producto = (iva.toUpperCase().equals("S"))
				? new ArticuloAlmacenado(nombre, Double.valueOf(precio), 4, Integer.valueOf(cantidad))
				: new ArticuloAlmacenado(nombre, Double.valueOf(precio), 21, Integer.valueOf(cantidad));

		return producto;

	}

}
