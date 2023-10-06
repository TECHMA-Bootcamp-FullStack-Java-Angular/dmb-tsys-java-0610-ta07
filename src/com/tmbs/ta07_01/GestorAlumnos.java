package com.tmbs.ta07_01;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase contiene la lógica de negocio del nuestra App sen según las directrices del Ejercicio
 */
public class GestorAlumnos {

static Scanner sc = new Scanner(System.in);
	
	static List<Alumno> promocionSep2023 = new ArrayList<>();

	public static void run() {
		
		System.out.println("************* GESTOR DE ALUMNOS *************\n");
			

		do {
			
			String nombre = aksValue("Nombre del alumno: ");
			
	        // Verificar si el alumno ya existe
	        if (checkAlumno(nombre)) {
	            System.err.println("El alumno ya ha sido registrado previamente.");
	            continue; 
	        }
			
			promocionSep2023.add(new Alumno(nombre, addAsignatura()));

		} while (toContinue("Desea añadir alumno"));
		
		System.out.println(hr());
		promocionSep2023.forEach(System.out::println);
		System.out.println(hr());
		
		sc.close();
	}
	
	/**
	 * Comprueba si existe un alumno con el nombre especificado en la lista `promocionSep2023`.
	 *
	 * @param nombre El nombre del alumno a buscar.
	 * @return `true` si el alumno existe, `false` en caso contrario.
	 */
	private static boolean checkAlumno(String nombre) {
	    for (Alumno alumno : promocionSep2023) {
	        if (alumno.getNombre().equalsIgnoreCase(nombre)) {
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 * Pide al usuario asigntiras y notas para añadirlas a la tabla asignaturas
	 * 
	 * @param asignaturas {@link Hashtable}
	 * @return 
	 * @throws NumberFormatException
	 */
	private static  Hashtable<String, Integer> addAsignatura() throws NumberFormatException {
		
		Hashtable<String, Integer> asignaturas = new Hashtable<>();
		
		do {

			String asignatura = aksValue("Inserte la asignatura: ");
			String calificacion = aksValue("Inserte la Nota: ");

			asignaturas.put(asignatura, Integer.valueOf(calificacion));

		} while (toContinue("Desea añadir más asignaturas "));
		
		return asignaturas;
	}

	// Imprime y recoge el valor para retornarlo
	private static String aksValue(String txt) {
		System.out.print(txt);
		return sc.next();
	}

	// Imprime una pregunta y concatena (S|N) luego retorna un booleano segun respuesta
	private static boolean toContinue(String txt) {
		System.out.print(txt + "(S|N)?");
		return (sc.next().toUpperCase().equals("N")) ? false : true;

	}
	
	// Un poco de color que me estaba aburriendo de tanto W/B ƪ(˘⌣˘)ʃ
	public static String hr() {
		
	  return "\033[33m" +"*******************************************************************"+ "\u001B[0m";	   
	 }


}
