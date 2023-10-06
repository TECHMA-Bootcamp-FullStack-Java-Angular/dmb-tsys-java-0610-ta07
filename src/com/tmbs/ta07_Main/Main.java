package com.tmbs.ta07_Main;

import javax.swing.JOptionPane;

import com.tmbs.ta07_01.GestorAlumnos;
import com.tmbs.ta07_02.GestorCompras;
import com.tmbs.ta07_03.GestorAlmacen;
import com.tmbs.ta07_04.IntegralManagement;

public class Main {

	public static void main(String[] args) {

		String[] options = { " Alumnos", " Compras", " Almacen", " Sistema de Integral", "Salir" };

		int i = JOptionPane.showOptionDialog(null, "Seleccione una las opciones", "Unidad C TA 7",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[3]);

		if (i == JOptionPane.CLOSED_OPTION)
			i = 4; // Controlando el cierre JOPane

		switch (i) {
		case 0:
			JOptionPane.showMessageDialog(null, "El Gestor Alumnos se mostrará por la consola");
			GestorAlumnos.run();
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "El Gestor Compras se mostrará por la consola");
			GestorCompras.run();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "El Gestor Almacen se mostrará por la consola");
			GestorAlmacen.run();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "El Gestor Integral se mostrará por la consola");
			IntegralManagement.run();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "EXIT APP");
			break;
		}

	}
}
