package clases;

import java.util.Date;

public class Matricula {
	private int id_alumno;
	private int id_asignatura;
	private Date fecha;
	/**
	 * @return the id_alumno
	 */
	public int getId_alumno() {
		return id_alumno;
	}
	/**
	 * @param id_alumno the id_alumno to set
	 */
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	/**
	 * @return the id_asignatura
	 */
	public int getId_asignatura() {
		return id_asignatura;
	}
	/**
	 * @param id_asignatura the id_asignatura to set
	 */
	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
