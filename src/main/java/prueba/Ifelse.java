package prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ifelse {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Servicio servicio = new Servicio();

		System.out.println("¿Que opción deseas?");
		System.out.println("Alta");
		System.out.println("Baja");
		System.out.println("Modificación");
		System.out.println("Consulta");
		String opc = null;
		try {
			opc = br.readLine();

			if (opc.equals("Alta")) {
				System.out.println("Has escogido alta");
				Alumno a = new Alumno();
				System.out.println("Nombre: ");
				String nombre;
				nombre = br.readLine();

				a.setNombre(nombre);
				System.out.println("DNI:");
				String dni = br.readLine();
				a.setDni(dni);
				System.out.println("Edad");
				int edad = Integer.parseInt(br.readLine());
				a.setEdat(edad);
				servicio.alta(a);
			} else if (opc.equals("Baja")) {
				System.out.println("Has escogido baja");
			} else if (opc.equals("Edad")) {
				System.out.println("Has escogido Modificación");
			} else if (opc.equals("Nombre")) {
				System.out.println("Has escogido Consulta");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
