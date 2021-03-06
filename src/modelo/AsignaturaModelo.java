package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import clases.Alumno;
import clases.Asignatura;
import clases.Matricula;

public class AsignaturaModelo extends Conector{
	public ArrayList<Asignatura> selectAll(){
		ArrayList<Asignatura> asignaturas=new ArrayList<Asignatura>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs=st.executeQuery("select * from asignaturas");
			while (rs.next()){
				Asignatura a=new Asignatura();
				a.setId(rs.getInt("id"));
				a.setNombre(rs.getString("nombre"));
				a.setHoras(rs.getInt("horas"));
				asignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asignaturas;
	}
	
	public void insertar(Asignatura asignatura){
		try{
			PreparedStatement pst =super.conexion.prepareStatement("INSERT INTO asignaturas(nombre,horas) VALUES(?,?)");
			pst.setString(1, asignatura.getNombre());
			pst.setInt(2, asignatura.getHoras());
			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Asignatura asignatura){
		try{
			PreparedStatement pst =super.conexion.prepareStatement("UPDATE asignaturas SET nombre=?,horas=? WHERE id=?");
			pst.setString(1, asignatura.getNombre());
			pst.setInt(2, asignatura.getHoras());
			pst.setInt(3, asignatura.getId());
			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id){
		try{
			PreparedStatement pst =super.conexion.prepareStatement("DELETE FROM asignaturas WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Asignatura selectPorId(int id) {
		// TODO Auto-generated method stub
		Asignatura asignatura=null;
		try {
			Statement st= super.conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from asignaturas where id="+id);
			while(rs.next()){
				asignatura=new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asignatura;
	}
	
	

	public int sumarHoras(ArrayList<Matricula> matriculas) {
		// TODO Auto-generated method stub
		Iterator<Matricula> i=matriculas.iterator();
		int suma=0;
		while (i.hasNext()){
			suma=suma+i.next().getAsignatura().getHoras();
			
		}
		return suma;
	}

	public ArrayList<Asignatura> selectAllConMatriculas() {
		// TODO Auto-generated method stub
		MatriculaModelo matriculaModelo=new MatriculaModelo();
		ArrayList<Asignatura> asignaturas=new ArrayList<>();
		try {
			PreparedStatement pst=this.conexion.prepareStatement("Select * from asignaturas");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Asignatura asignatura=new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				
				ArrayList<Matricula> matriculas=matriculaModelo.selectPorIdAsignatura(rs.getInt("id"));
				asignatura.setMatriculas(matriculas);
				
				asignaturas.add(asignatura);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asignaturas;
	}
}
