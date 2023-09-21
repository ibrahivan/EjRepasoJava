package aplicacion.controlador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import apliacion.servicios.ImplEmpleado;
import apliacion.servicios.ImplMenu;
import aplicacion.entidad.Empleado;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instanciamos las diferentes clases para poder hacer uso de los metodos
		ImplEmpleado intE = new ImplEmpleado();
		ImplMenu intM = new ImplMenu();
		List<Empleado> listE = new LinkedList<Empleado>();
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			intM.mostrarMenu(); // mostramos menu
			opcion = sc.nextLine().charAt(0) - '0';
			// control de errores
			while (opcion < 0 || opcion > 3) {

				System.out.println("\n\t\t\t**ERROR**");
				System.out.print("\t\tIntroduce una opcion: ");
				opcion = sc.nextLine().charAt(0) - '0';
			}
			System.out.flush();
			switch (opcion) {

			case 1:

				System.out.println("\n\t\t----Registro empleado----");
				listE = intE.registroEmpleado(listE); // nos devuelve una lista actualizada
				break;
			case 2:
				System.out.println("\n\t\t----Modificar empleado----");
				listE = intE.modificarEmpleado(listE); // nos devuelve una lista actualizada
				break;

			case 3:
				System.out.println("\n\t\t----Exportar a fichero----");
				intE.exportarFich(listE); // exporta la lista al fichero
				break;

			}
			if (opcion != 0) {
				System.out.print("\n\n\tPulsa una tecla para volver al menú... ");
				sc.nextLine();
				System.out.flush();
			}

		} while (opcion != 0);

		System.out.println("\n\tSaliendo de la aplicacion  \n\tPulse cualquier tecla para cerrar el programa");
		sc.nextLine();
	}

}
