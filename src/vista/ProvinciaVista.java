package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import clases.Alumno;
import clases.Provincia;
import modelo.AlumnoModelo;
import modelo.ProvinciaModelo;

public class ProvinciaVista {
	public void menuProvincia(){
		final int MOSTRAR_ALUMNOS=1;
		final int SALIR=0;
		Scanner lector=new Scanner(System.in);
		int opcion;
		do{
			System.out.println("________MENU PROVINCIAS_______");
			System.out.println(MOSTRAR_ALUMNOS+"- Mostrar alumnos de cada provincia");
			System.out.println(SALIR+"- Salir");
			opcion=Integer.parseInt(lector.nextLine());
			switch(opcion){
			case MOSTRAR_ALUMNOS:
				ProvinciaModelo provinciaModelo=new ProvinciaModelo();
				ArrayList<Provincia> provincias=provinciaModelo.selectAllConAlumnos();
				mostrarProvinciasAlumnos(provincias);
				break;
			case SALIR:
				break;
			default:
				System.out.println("No existe esa opcion");
			}
		}while(opcion!=SALIR);
	}

	private void mostrarProvinciasAlumnos(ArrayList<Provincia> provincias) {
		// TODO Auto-generated method stub
		Iterator<Provincia> i=provincias.iterator();
		while(i.hasNext()){
			mostrarProvinciaAlumnos(i.next());
		}
		
	}
	
	private void mostrarProvinciaAlumnos(Provincia provincia) {
		// TODO Auto-generated method stub
		AlumnoVista alumnoVista=new AlumnoVista();
		System.out.println(provincia.getNombre());
		Iterator<Alumno> i=provincia.getAlumnos().iterator();
		while (i.hasNext()){
			System.out.print("---------");
			alumnoVista.mostrarAlumno(i.next());
			
		}
	}
}
