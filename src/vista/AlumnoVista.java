package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import clases.Alumno;
import clases.Matricula;
import modelo.AlumnoModelo;
import modelo.AsignaturaModelo;

public class AlumnoVista {
	public void menuAlumno(){
		
		final int MOSTRAR_ASIGNATURAS=1;
		final int MOSTRAR_HORAS=2;
		final int MOSTRAR_N_ASIGN=3;
		
		final int SALIR=0;
		Scanner lector=new Scanner(System.in);
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		int opcion;
		do{
			System.out.println("___________MENU ALUMNOS__________");
			System.out.println(MOSTRAR_ASIGNATURAS+"- Mostrar alumnos con su asignatura");
			System.out.println(MOSTRAR_HORAS+"- Mostrar las horas de cada alumno");
			System.out.println(MOSTRAR_N_ASIGN+"- Mostrar el numero de asignaturas que tiene cada alumno");
			System.out.println(SALIR+"- salir");
			
			opcion=Integer.parseInt(lector.nextLine());
			switch(opcion){
			case MOSTRAR_ASIGNATURAS:
				ArrayList<Alumno> alumnos=alumnoModelo.selectAllConMatriculas();
				mostrarAlumnosAsignaturas(alumnos);
				break;
				
			case MOSTRAR_HORAS:
				ArrayList<Alumno> alumnos2=alumnoModelo.selectAllConMatriculas();
				mostrarAlumnosHoras(alumnos2);
				break;
			case MOSTRAR_N_ASIGN:
				ArrayList<Alumno> alumnos3=alumnoModelo.selectAllConMatriculas();
				mostrarAlumnosNumAsign(alumnos3);
			case SALIR:
				break;
			default:
				System.out.println("No existe esa opcion");
			}
			
		}while(opcion!=SALIR);
	}
	
	
	private void mostrarAlumnosNumAsign(ArrayList<Alumno> alumnos) {
		// TODO Auto-generated method stub
		Iterator<Alumno> i =alumnos.iterator();
		while(i.hasNext()){
			Alumno alumno=i.next();
			int asignaturas=alumno.getMatriculas().size();
			mostrarAlumnoNumAsign(alumno,asignaturas);
		}
	}


	private void mostrarAlumnoNumAsign(Alumno alumno, int asignaturas) {
		// TODO Auto-generated method stub
		System.out.println(alumno.getDni()+" - "+alumno.getNombre()+"("+alumno.getProvincia().getNombre()+"): "+asignaturas+" asignaturas");
	}


	private void mostrarAlumnosHoras(ArrayList<Alumno> alumnos) {
		// TODO Auto-generated method stub
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		Iterator<Alumno> i =alumnos.iterator();
		while (i.hasNext()){
			Alumno alumno=i.next();
			int horas=asignaturaModelo.sumarHoras(alumno.getMatriculas());
			mostrarAlumnoHoras(alumno,horas);
					
		}
	}





	private void mostrarAlumnoHoras(Alumno alumno, int horas) {
		// TODO Auto-generated method stub
		System.out.println(alumno.getDni()+" - "+alumno.getNombre()+"("+alumno.getProvincia().getNombre()+"): "+horas+" horas");
	}
	
	public void mostrarAlumnoProvincia(Alumno alumno) {
		// TODO Auto-generated method stub
		System.out.println(alumno.getDni()+" - "+alumno.getNombre()+" - "+alumno.getProvincia().getNombre());
	}
	
	public void mostrarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		System.out.println(alumno.getDni()+" - "+alumno.getNombre());
	}


	public void mostrarAlumnosAsignaturas(ArrayList<Alumno> alumnos){
		Iterator<Alumno> i=alumnos.iterator();
		while(i.hasNext()){
			mostrarAlumnoAsignatura(i.next());
		}

	}


	private void mostrarAlumnoAsignatura(Alumno alumno) {
		// TODO Auto-generated method stub
		AsignaturaVista asignaturaVista=new AsignaturaVista();
		mostrarAlumnoProvincia(alumno);
		Iterator<Matricula> i=alumno.getMatriculas().iterator();
		
		while(i.hasNext()){
			
			System.out.print("-------");
			asignaturaVista.mostrarAsignatura(i.next().getAsignatura());
		}
	}
}
