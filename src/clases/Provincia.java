package clases;

import java.util.ArrayList;

public class Provincia {
	private int id;
	private int nombre;
	private ArrayList<Alumno> alumnos;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the alumnos
	 */
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
