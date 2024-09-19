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
		System.out.println("1. Alta");
		System.out.println("2. Baja");
		System.out.println("3. Modificación");
		System.out.println("4. Consulta");
		String opc = null;
		Alumno a = new Alumno();
		try {
			opc = br.readLine();

			if (opc.equals("1")) {
				System.out.println("Dar de alta a un alumno/a");
				
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
				System.out.println("Se ha añadido correctamente");
				
			} else if (opc.equals("2")) {
				System.out.println("Dar de baja a un alumno/a");
				System.out.println("DNI:");
				String dni = br.readLine();
				a.setDni(dni);
				servicio.baja(a);
				System.out.println("Se ha eliminado correctamente");
				System.out.println("");
			} else if (opc.equals("3")) {
				System.out.println("Modificar datos de un alumno/a");
				System.out.println("Escribe el número de DNI: ");
				String oldDni = br.readLine();
				System.out.println("Escribe el nuevo número de DNI: ");
				String Ndni = br.readLine();
;				a.setDni(Ndni);
				servicio.Modicar(oldDni, a);
			} else if (opc.equals("4")) {
				System.out.println("Has escogido Consulta");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
