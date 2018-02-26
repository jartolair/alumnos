package clases;

import java.util.ArrayList;

public class Asignatura {
	private int id;
	private String nombre;
	private int horas;
	private ArrayList<Matricula> matriculas;
	/**
	 * @return the matriculas
	 */
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}
	/**
	 * @param matriculas the matriculas to set
	 */
	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
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
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
}
