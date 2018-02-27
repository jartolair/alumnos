package vista;

import java.util.Scanner;

import modelo.MatriculaModelo;

public class EscuelaVista {
	public void menuEscuela(){
		final int MATRICULA=1;
		final int ALUMNO=2;
		final int ASIGNATURA=3;
		final int PROVINCIA=4;
		final int SALIR=0;
		
		Scanner lector=new Scanner(System.in);
		int opcion;
		do{
			System.out.println("MENU ESCUELA");
			System.out.println(MATRICULA+"- Menu de matriculas");
			System.out.println(ALUMNO+"- Menu de alumnos");
			System.out.println(ASIGNATURA+"- Menu de asignaturas");
			System.out.println(PROVINCIA+"- Menu de provincias");
			System.out.println(SALIR+"- Salir");
			
			opcion=Integer.parseInt(lector.nextLine());
			switch(opcion){
			case MATRICULA:
				MatriculaVista matriculaVista=new MatriculaVista();
				matriculaVista.menuMatricula();
			break;
			case ALUMNO:
				AlumnoVista alumnoVista=new AlumnoVista();
				alumnoVista.menuAlumno();
			break;
			case ASIGNATURA:
				AsignaturaVista asignaturaVista=new AsignaturaVista();
				asignaturaVista.menuAsignatura();
			break;
			case PROVINCIA:
				ProvinciaVista provinciaVista=new ProvinciaVista();
				provinciaVista.menuProvincia();
			break;
			case SALIR:
				System.out.println("Programa terminado");
				break;
			default:
				System.out.println("No existe esa opcion");
			}
		}while(opcion!=SALIR);
	}
}
