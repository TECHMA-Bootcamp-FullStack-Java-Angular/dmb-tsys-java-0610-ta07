package com.tmbs.ta07_04;

import java.util.ArrayList;
import java.util.Scanner;

import com.tmbs.ta07_02.GestorCompras;
import com.tmbs.ta07_03.AlmacenServices;
import com.tmbs.ta07_03.ArticuloAlmacenado;
import com.tmbs.ta07_03.GestorAlmacen;

import utils.Utils;

/**
 * Esta clase contiene la lógica de negocio del nuestra App sen según las directrices del Ejercicio
 */
public class IntegralManagement {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<ArticuloAlmacenado> carrito = new ArrayList<ArticuloAlmacenado>();

	public static void run() {

		AlmacenServices almacen = new AlmacenServices();

		System.out.println("\t\t\tGESTOR ALMACEN");

		String[] optionsMenu = 	{
				" Ver stock de productos",
				" Buscar producto",
				" Agregar producto",
				" Eliminar producto",
				" Venta de Producro ", 
				" Salir"  };

		String exit = "";

		while (!exit.equals("6")) {
			
			System.out.println(Utils.cian("\t\t\tMENU"));
			
			for (int i = 0; i < optionsMenu.length; i++) {
				System.out.println(Utils.cian( " " + (i+1)) +".- " + optionsMenu[i] );
			}
			
			System.out.print("\nELIJA UNA OPCION "+Utils.cian("[1|2|3|4|5|6]:")  );
			exit = sc.next();
			
			switch (exit) {
			
			case "1": {
					
				System.out.println("\t\t\tLISTA DE PRODUCTOS");				
				almacen.getAllProducts().stream().sorted().forEach((System.out::println)); 
				System.out.println(Utils.hr());
				
				break;
				
			}
			case "2": {
		
				System.out.println("\t\t\tBUCADOR DE PRODUCTOS");				
				String nombre = GestorAlmacen.aksValue("Nombre del producto: ");
				System.out.println(almacen.findProduct(nombre));
				System.out.println(Utils.hr());
				
				break;
				
			}
			case "3": {
			
				System.out.println("\t\t\tAGRAGAR PROCUTO");				
				ArticuloAlmacenado procduto = GestorAlmacen.pedirProducto();
				System.out.println( almacen.addProducts(procduto.getNombre(), procduto));
				System.out.println(Utils.hr());
				
				break;
			}
			case "4": {
				

				System.out.println("\t\tELINAR UN PROCUTO");				
				String nombre = GestorAlmacen.aksValue("Nombre del producto: ");
				System.out.println(almacen.deleteProduct(nombre));
				System.out.println(Utils.hr());
				
				
				break;
			}
			case "5": {
			
				System.out.println("\t\tVENTA DE PRODUCTOS");
				String exitBuy;
				
				do { // El bucle se cierra cuando el cliente no desa comprar más (exitBuy)

					String resString;
					String producto;
					
					do { //Nos aseguramos que el cliente elija un producto valido
						
						
						producto = GestorAlmacen.aksValue("Nombre del producto: ");
						resString = almacen.findProduct(producto);
						System.out.println(resString);
						
						
					} while (resString.contains("No"));
									
					int uniDiponibles;
					int uniDesadas;

					do { //Nos aseguramos que la cantidad deseada sea menor a la disponible

						uniDesadas = Integer.valueOf(GestorCompras.consoleImput("Cuantas unidades desea:"));
						uniDiponibles = almacen.getStock().get(producto.toUpperCase()).getCantidad();


					} while (uniDiponibles < uniDesadas);

					almacen.getStock().get(producto.toUpperCase()).setCantidad(uniDiponibles - uniDesadas);
					
					System.out.println("\t\tAGRAGADO AL CARRITO");
					
					// Bucamos los datos que nos faltan del producto (IVA y PRECIO) 
					Double precio = almacen.getStock().get(producto.toUpperCase()).getPrecioNeto();
					int iva = almacen.getStock().get(producto.toUpperCase()).getIva();

					// Craemos un articuloComprado con el mismo modelo del articuloAlmacenado ( nombre , precio , iva , unidades)
					ArticuloAlmacenado articuloComprado = new ArticuloAlmacenado(producto.toUpperCase(), precio, iva,
							uniDesadas);

					// Añadimos al carrito al carticulo comprado
					carrito.add(articuloComprado);

					exitBuy =  GestorAlmacen.aksValue("\nDesea seguir Comprando? (s/n): ");

				} while (exitBuy.toUpperCase().equals("S"));

				// Instaciamos una CajaRegistradora y le pasamos el carrito de la compra
				CajaRegAdapter cajareg = new CajaRegAdapter(carrito);

				cajareg.generaResumenCompra().forEach((System.out::println));
				
				String abono;

				do { // Nos aseguramos que el pago sea mayor que la cantidad total de compra

					System.out.print("Introduzca la cantidad que el cliente abona: ");
					abono = sc.next();
				

				} while (cajareg.getTotalPagar() >Double.valueOf(abono) );

					// Seteamos la debolucion y imprimimos tiket
					cajareg.setImportePagado(Double.valueOf(abono));	
					cajareg.generarTiket().forEach((System.out::println));
								
				break;
				
			}case "6": {		
					System.out.println("EXIT GESTION DE ALMACEN");					
					exit = "6";
				break;
			}
			
			default:
				System.out.println(Utils.cian("DEBE ELEGIR UNA DE LAS OPCION"));
				break;
			}
		
		}
	
	}
	
	
}
