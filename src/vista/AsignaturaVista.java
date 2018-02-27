package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import clases.Asignatura;
import clases.Matricula;
import modelo.AlumnoModelo;
import modelo.AsignaturaModelo;

public class AsignaturaVista {
	
	public void menuAsignatura(){
		final int MOSTRAR_ALUMNOS=1;
		final int SALIR=0;
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		Scanner lector=new Scanner(System.in);
		int opcion;
		do{
			System.out.println("___________MENU ASIGNATURAS__________");
			System.out.println(MOSTRAR_ALUMNOS+"- mostrar alumnos de cada asignatura");
			System.out.println(SALIR+"- Salir");
			
			opcion=Integer.parseInt(lector.nextLine());
			switch (opcion) {
			case MOSTRAR_ALUMNOS:
				ArrayList<Asignatura> asignaturas=asignaturaModelo.selectAllConMatriculas();
				mostrarAsignaturasAlumnos(asignaturas);
				break;

			default:
				break;
			}
		}while(opcion!=SALIR);
	}
	
	
	
	
	
	
	
	private void mostrarAsignaturasAlumnos(ArrayList<Asignatura> asignaturas) {
		// TODO Auto-generated method stub
		Iterator<Asignatura> i=asignaturas.iterator();
		while (i.hasNext()){
			mostrarAsignaturaAlumnos(i.next());
		}
	}







	private void mostrarAsignaturaAlumnos(Asignatura asignatura) {
		// TODO Auto-generated method stub
		mostrarAsignatura(asignatura);
		Iterator<Matricula> i=asignatura.getMatriculas().iterator();
		while(i.hasNext()){
			AlumnoVista alumnoVista=new AlumnoVista();
			System.out.print("-------");
			alumnoVista.mostrarAlumnoProvincia(i.next().getAlumno());
		}
	}







	public void mostrarAsignatura(Asignatura asignatura) {
		System.out.println(asignatura.getNombre()+": "+asignatura.getHoras()+" horas");
		
		
	}

}
