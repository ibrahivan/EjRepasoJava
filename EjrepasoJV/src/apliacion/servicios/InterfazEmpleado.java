package apliacion.servicios;

import java.util.List;

import aplicacion.entidad.Empleado;

public interface InterfazEmpleado {

	// metodo que registra al empleado y guarda los datos en una lista
	List<Empleado> registroEmpleado(List<Empleado> listE);

	// metodo que modifica los datos del empleado y los guarda en una lista
	List<Empleado> modificarEmpleado(List<Empleado> listE);

	// metodo que exporta los datos a un fichero
	void exportarFich(List<Empleado> listE);
}
