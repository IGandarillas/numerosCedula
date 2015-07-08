package botNumeroCedula;

public class Persona {
	private String fechaIngreso;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String departamento;
	private String municipio;
	private String nombrePuesto;
	private String direccionPuesto;
	
public Persona(){	
}

public String getFechaIngreso() {
	return fechaIngreso;
}

public void setFechaIngreso(String fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
}

public String getCedula() {
	return cedula;
}

public void setCedula(String cedula) {
	this.cedula = cedula;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getDepartamento() {
	return departamento;
}

public void setDepartamento(String departamento) {
	this.departamento = departamento;
}

public String getMunicipio() {
	return municipio;
}

public void setMunicipio(String municipio) {
	this.municipio = municipio;
}

public String getNombrePuesto() {
	return nombrePuesto;
}

public void setNombrePuesto(String nombrePuesto) {
	this.nombrePuesto = nombrePuesto;
}

public String getDireccionPuesto() {
	return direccionPuesto;
}

public void setDireccionPuesto(String direccionPuesto) {
	this.direccionPuesto = direccionPuesto;
}
}
