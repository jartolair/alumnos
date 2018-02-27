package comparador;
import java.util.Comparator;

import clases.Alumno;

public class AlumnoNombreComparator implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a0, Alumno a1) {
		// TODO Auto-generated method stub
		
		return (a0.getNombre().compareToIgnoreCase(a1.getNombre()));
	}

}
