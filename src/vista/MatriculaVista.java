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

	public void menuMatricula(){
		final int MOSTRAR=1;
		final int SALIR=0;
		Scanner lector=new Scanner(System.in);
		int opcion;
		do{
			System.out.println("___________MENU MATRICULAS__________");
			System.out.println(MOSTRAR+"- Mostrar matriculas");
			System.out.println(SALIR+"- salir");
			
			opcion=Integer.parseInt(lector.nextLine());
			switch(opcion){
			case MOSTRAR:
				MatriculaModelo matriculaModelo=new MatriculaModelo();
				ArrayList<Matricula> matriculas=matriculaModelo.selectAll();
				mostarMatriculas(matriculas);
				
				break;
			
			}
			
		}while(opcion!=SALIR);
	}
	
	
	public void mostarTodasLasMatriculas(){
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		MatriculaModelo matriculaModelo=new MatriculaModelo();
		ArrayList<Matricula> matriculas=matriculaModelo.selectAll();
		System.out.println("Nombre - DNI - Asignatura - Horas - Fecha de matricula\n");
		
		Iterator<Matricula> i=matriculas.iterator();
		while(i.hasNext()){
			Matricula matricula =i.next();
			Alumno alumno=alumnoModelo.selectPorId(matricula.getAlumno().getId());
			Asignatura asignatura=asignaturaModelo.selectPorId(matricula.getAsignatura().getId());
			
			
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
			Alumno alumno=alumnoModelo.selectPorId(matricula.getAlumno().getId());
			Asignatura asignatura=asignaturaModelo.selectPorId(matricula.getAsignatura().getId());
			
			
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
