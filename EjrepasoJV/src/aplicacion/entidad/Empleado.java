package aplicacion.entidad;

public class Empleado {

	// Atributos
	String nombre, apellido, dNI, titulacion;
	int dia, mes, anyo, nSS, nCuenta, nEmpleado, id;
	
	//Constructor vacio
	public Empleado() {
		super();
	}
	//Constructor
	public Empleado(String nombre, String apellido, String dNI, String titulacion, int dia, int mes, int anyo, int nSS,
			int nCuenta, int nEmpleado, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dNI = dNI;
		this.titulacion = titulacion;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.nSS = nSS;
		this.nCuenta = nCuenta;
		this.nEmpleado = nEmpleado;
		this.id = id;
	}

	

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getnSS() {
		return nSS;
	}

	public void setnSS(int nSS) {
		this.nSS = nSS;
	}

	public int getnCuenta() {
		return nCuenta;
	}

	public void setnCuenta(int nCuenta) {
		this.nCuenta = nCuenta;
	}

	public int getnEmpleado() {
		return nEmpleado;
	}

	public void setnEmpleado(int nEmpleado) {
		this.nEmpleado = nEmpleado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
