package apliacion.servicios;

public class ImplMenu implements InterfazMenu {

	public void mostrarMenu() {
		System.out.println("\n\t\t----Menú----");
		System.out.println("\n\t\t1. Registro empleado");
		System.out.println("\n\t\t2. Modificación empleado");
		System.out.println("\n\t\t3. Exportar a fichero");
		System.out.println("\n\t\t0. Cerrar app");

	}
}
