package apliacion.servicios;
/*
 * Implementacion de la clase empleado
author:ivan vazquez
*/
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import aplicacion.entidad.Empleado;

public class ImplEmpleado implements InterfazEmpleado {

	//Metodo que usamos para registrar el usuario
	@Override
	public List<Empleado> registroEmpleado(List<Empleado> listE) {
		// TODO Auto-generated method stub
		Empleado e = new Empleado();

		Scanner scanner = new Scanner(System.in);

		// Pido todos los datos que necesito
		System.out.print("\n\tIntroduzca el nombre del empleado: ");
		e.setNombre(scanner.nextLine());
		System.out.print("\n\tIntroduzca los apellidos del empleado: ");
		e.setApellido(scanner.nextLine());
		System.out.print("\n\tIntroduzca el DNI del empleado: ");
		e.setdNI(scanner.nextLine());
		e.setAnyo(CapturaEntero("\n\tIntroduzca el año de nacimiento del empleado", 1940, 2023));
		e.setMes(CapturaEntero("\n\tIntroduzca el mes de nacimiento del empleado", 1, 12));
		if (e.getMes() == 4 || e.getMes() == 6 || e.getMes() == 9 || e.getMes() == 11)
			e.setDia(CapturaEntero("\n\tIntroduzca el dia de nacimiento del empleado", 1, 30));
		else if (e.getMes() == 2)
			e.setDia(CapturaEntero("\n\tIntroduzca el dia de nacimiento del empleado", 1, 28));
		else
			e.setDia(CapturaEntero("\n\tIntroduzca el dia de nacimiento del empleado", 1, 31));
		System.out.print("\n\tIntroduzca la titulacion del empleado: ");
		e.setTitulacion(scanner.nextLine());
		e.setnSS(CapturaEntero("\n\tIntroduzca el numero de seguridad social del empleado", 1, 10000000));
		e.setnCuenta(CapturaEntero("\n\tIntroduzca el numero de cuenta del empleado", 1, 1000000));

		// Genero el id aleatorio
		e.setId(generarId());

		// Añado el empleado a la lista
		listE.add(e);

		System.out.println("\n\tEmpleado registrado con exito su nº identificatorio es: " + e.getId());
		return listE;
	}

	//Metodo para modificar a los empleados
	@Override
	public List<Empleado> modificarEmpleado(List<Empleado> listE) {
		// TODO Auto-generated method stub
		Empleado e = new Empleado();
		// Mostrar empleados
		mostrarEmpleados(listE);
		// Preguntar si se desea modificar algún empleado
		boolean p = PreguntaSiNo("\tDesea modificar algun empleado");
		//Seleccionamos el empleado y modificamos el dato que desea el usuario
		while (p) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("\n\t¿Qué empleado desea modificar? Seleccione por ID: ");
			int id = scanner.nextInt();
			boolean existe = false;
			for (int i = 0; i < listE.size(); i++) {
				if (id == listE.get(i).getId()) {
					System.out.println("\t1Has seleccionado el empleado: " + listE.get(i).getNombre());
					mostrarOpciones();
					int opcion = CapturaEntero("\n\n\t¿Qué dato desea cambiar?", 0, 9);

					switch (opcion) {
					case 1:
						System.out.print("\n\tIntroduzca nuevo nombre: ");
						listE.get(i).setNombre(scanner.next());
						break;
					case 2:
						System.out.print("\n\tIntroduzca nuevos apellidos: ");
						listE.get(i).setApellido(scanner.next());
						break;
					case 3:
						System.out.print("\n\tIntroduzca nuevo DNI: ");
						listE.get(i).setdNI(scanner.next());
						break;
					case 4:
						listE.get(i).setAnyo(CapturaEntero("\n\tIntroduzca nuevo año: ", 1940, 2023));
						break;
					case 5:
						listE.get(i).setMes(CapturaEntero("\n\tIntroduzca nuevo mes: ", 1, 12));
						break;
					case 6:
						if (listE.get(i).getMes() == 4 || listE.get(i).getMes() == 6 || listE.get(i).getMes() == 9
								|| listE.get(i).getMes() == 11)
							listE.get(i).setDia(CapturaEntero("\n\tIntroduzca nuevo dia: ", 1, 30));
						else if (listE.get(i).getMes() == 2)
							listE.get(i).setDia(CapturaEntero("\n\tIntroduzca nuevo dia: ", 1, 28));
						else
							listE.get(i).setDia(CapturaEntero("\n\tIntroduzca nuevo dia: ", 1, 31));
						break;
					case 7:
						System.out.print("\n\tIntroduzca nueva titulación: ");
						listE.get(i).setTitulacion(scanner.next());
						break;
					case 8:
						listE.get(i).setnSS(CapturaEntero("\n\tIntroduzca nuevo nº ss: ", 1, 10000000));
						break;
					case 9:
						listE.get(i).setnCuenta(CapturaEntero("\n\tIntroduzca nuevo nº de cuenta: ", 1, 1000000));
						break;
					case 0:
						break;
					}
					existe = true;
					break;
				}
			}
			//Si no existe el empleado damos el mensaje de error
			if (!existe)
				System.out.println("\n\t**Empleado no existe**");
			p = PreguntaSiNo("\t¿Desea modificar algun dato?");
		}
		return listE;
	}
	//Metodo de exportar los datos a fichero
	@Override
	public void exportarFich(List<Empleado> listE) {
		// TODO Auto-generated method stub
		int opcion = CapturaEntero("Desea exportar un empleado (Opción 1) o todos los empleados (Opción 2)", 1, 2);

		switch (opcion) {

		case 1:
			// Abrimos fichero
			FileWriter fichero = null;
			PrintWriter pw = null;
			// mostramos los empleadps
			mostrarEmpleados(listE);
			// seleccionamos que empleado quiere exportar
			System.out.print("\n\t¿Qué empleado desea exportar al fichero? Seleccione por ID: ");
			Scanner scanner = new Scanner(System.in);
			int id = scanner.nextInt();
			boolean existe = false;
			for (int j = 0; j < listE.size(); j++) {
				if (id == listE.get(j).getId()) {

					try {
						fichero = new FileWriter("C:\\zDatosPruebas\\empleadosJava.txt");
						pw = new PrintWriter(fichero);
						pw.println(
								"\n\t\t Id empleado || Nombre  ||  Apellidos  ||    DNI    || Fecha nacimiento  || Titulación ");

						pw.printf("\n\t\t %6d  %15s  %10s     %10s      %02d/%02d/%04d     %16s  ", listE.get(j).getId(), listE.get(j).getNombre(),
								listE.get(j).getApellido(), listE.get(j).getdNI(), listE.get(j).getDia(),
								listE.get(j).getMes(), listE.get(j).getAnyo(), listE.get(j).getTitulacion());

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {

							// Asegurar que se cierra el fichero.
							if (null != fichero)
								fichero.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					System.out.println("\tEmpleado " + listE.get(j).getNombre() + " exportado correctamente.");
					existe = true;
					break;
				}

			}
			if (!existe)
				System.out.println("\n\t**Empleado no existe**");
			break;

		case 2:
			// lo mismo pero si escoge todos los usuarios
			FileWriter f = null;
			PrintWriter pw1 = null;

			try {
				f = new FileWriter("C:\\zDatosPruebas\\empleadosJava.txt");
				pw1 = new PrintWriter(f);
				pw1.println("\n\t\t Id empleado ||  Nombre  ||  Apellidos  ||    DNI    || Fecha nacimiento  || Titulación  ");
				for (int k = 0; k < listE.size(); k++) {
					pw1.printf("\n\t\t %6d  %15s  %10s     %10s      %02d/%02d/%04d     %16s  ", listE.get(k).getId(), listE.get(k).getNombre(),
							listE.get(k).getApellido(), listE.get(k).getdNI(), listE.get(k).getDia(),
							listE.get(k).getMes(), listE.get(k).getAnyo(), listE.get(k).getTitulacion());
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {

					// Asegurar que se cierra el fichero.
					if (null != f)
						f.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			System.out.println("Todos los empleados exportados correctamente.");
			break;
		}

	}
	//metodo captura entero para los errores al captar numeros
	public int CapturaEntero(String mensaje, int min, int max) {
		Scanner sc = new Scanner(System.in);

		System.out.print(mensaje + " (" + min + ".." + max + "): ");
		int opcion = sc.nextInt();

		while (opcion < min || opcion > max) {
			System.out.println("\tNo has introducido una opción válida.");
			System.out.print("\tVuelve a introducir una opción" + " (" + min + ".." + max + "): ");
			opcion = sc.nextInt();
		}
		return opcion;

	}
	//metodo para preguntar si queiere editar algun dato
	public boolean PreguntaSiNo(String p) {
		boolean respuesta = false;
		char tecla;
		boolean error = false;
		Scanner scanner = new Scanner(System.in);

		do {
			error = false;
			System.out.print("\n\n" + p + " (s=Sí; n=No): ");
			// Capturamos la respuesta (una pulsación)
			tecla = scanner.nextLine().charAt(0);
			if (tecla == 's' || tecla == 'S') {
				respuesta = true;
			} else if (tecla == 'n' || tecla == 'N') {
				respuesta = false;
			} else {
				System.out.println("\n\n\t** Error: por favor, responde s o n **");
				error = true;
			}
		} while (error);

		return respuesta;
	}

	// Generar id aleatorio
	public int generarId() {
		// Crear una instancia de la clase Random
		Random random = new Random();

		// Generar un número aleatorio como ID
		int id = random.nextInt(100) + 1; // Esto generará un número entre 1 y 100

		return id;
	}

	// Menu de opciones a cambiar
	public void mostrarOpciones() {
		System.out.println("\n\t\t1. Nombre.");
		System.out.println("\n\t\t2. Apellidos.");
		System.out.println("\n\t\t3. DNI.");
		System.out.println("\n\t\t4. Dia nacimiento.");
		System.out.println("\n\t\t5. Mes nacimiento.");
		System.out.println("\n\t\t6. Año nacimiento.");
		System.out.println("\n\t\t7. Titulación .");
		System.out.println("\n\t\t8. Número SS.");
		System.out.println("\n\t\t9. Número de cuenta.");
		System.out.println("\n\t\t0. Salir.");
	}
	//metodo de mostrar empleados
	public static void mostrarEmpleados(List<Empleado> listE) {
		System.out.println(
				"\n\t\t Id empleado || Nombre  ||  Apellidos  ||    DNI    || Fecha nacimiento  || Titulación  ||  Nº Seg Social  || Nº Cuenta  ");
		for (Empleado empleado : listE) {
			System.out.printf("\n\t %12d %15s  %13s    %11s      %02d/%02d/%04d   %16s  %14d  %14d",
					empleado.getId(), empleado.getNombre(), empleado.getApellido(), empleado.getdNI(),
					empleado.getDia(), empleado.getMes(), empleado.getAnyo(), empleado.getTitulacion(),
					empleado.getnSS(), empleado.getnCuenta());
		}
	}

	

}
