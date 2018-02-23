package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import clases.Alumno;
import clases.Asignatura;
import clases.Matricula;
import modelo.AlumnoModelo;
import modelo.AsignaturaModelo;
import modelo.MatriculaModelo;

public class MatriculaVista {

	public void mostarTodasLasMatriculas(){
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		MatriculaModelo matriculaModelo=new MatriculaModelo();
		ArrayList<Matricula> matriculas=matriculaModelo.selectAll();
		System.out.println("Nombre - DNI - Asignatura - Horas - Fecha de matricula\n");
		
		Iterator<Matricula> i=matriculas.iterator();
		while(i.hasNext()){
			Matricula matricula =i.next();
			Alumno alumno=alumnoModelo.selectPorId(matricula.getId_alumno());
			Asignatura asignatura=asignaturaModelo.selectPorId(matricula.getId_asignatura());
			
			
			mostrarMatriculaAlumnoAsignatura(matricula,alumno,asignatura);
			
		}
	}
	
	public void mostarMatriculas(ArrayList<Matricula> matriculas){
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		AlumnoModelo alumnoModelo=new AlumnoModelo();

		System.out.println("Nombre - DNI - Asignatura - Horas - Fecha de matricula\n");
		
		Iterator<Matricula> i=matriculas.iterator();
		while(i.hasNext()){
			Matricula matricula =i.next();
			Alumno alumno=alumnoModelo.selectPorId(matricula.getId_alumno());
			Asignatura asignatura=asignaturaModelo.selectPorId(matricula.getId_asignatura());
			
			
			mostrarMatriculaAlumnoAsignatura(matricula,alumno,asignatura);
			
		}
	}
	private static void mostrarMatriculaAlumnoAsignatura(Matricula matricula, Alumno alumno, Asignatura asignatura) {
		// TODO Auto-generated method stub
		
		System.out.print(alumno.getNombre()+" - ");
		System.out.print(alumno.getDni()+" - ");
		System.out.print(asignatura.getNombre()+" - ");
		System.out.print(asignatura.getHoras()+" - ");
		System.out.println(matricula.getFecha());
		
	}
}
