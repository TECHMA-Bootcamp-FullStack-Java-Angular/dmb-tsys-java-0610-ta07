package com.tmbs.ta07_01;

import java.util.Hashtable;

import com.tmbs.ta07_02.Producto;
/**
 * Clase que representa un Alumno
 *
 * <li>private String nombre;
 * <li>private Hashtable <String, Integer> asignaturas;
 * <li>private Double notaPromedioCurso;
 * 
 * <ul> @param ArrayList {@link Producto } el carrito seran llena nuestas ventas.
 */
public class Alumno {

	private String nombre;
	private Hashtable<String, Integer> asignaturas = new Hashtable<>();
	private Double notaPromedioCurso;

	public Alumno(String nombre, Hashtable<String, Integer> asignaturas) {

		this.nombre = nombre;
		this.asignaturas = asignaturas;
		this.setNotaPromedioCurso();
	}

	public String getNombre() {
		return nombre;
	}

	public Hashtable<String, Integer> getAsignaturas() {
		return asignaturas;
	}

	private double avgQualification() {
		return this.asignaturas.values().stream().mapToInt(nota -> nota.intValue()).average().getAsDouble();
	}

	public Double getNotaPromedioCurso() {
		return notaPromedioCurso;
	}

	private void setNotaPromedioCurso() {
		this.notaPromedioCurso = avgQualification();

	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Asignaturas: " + asignaturas + ", Nota Media: " + notaPromedioCurso;
	}

}
