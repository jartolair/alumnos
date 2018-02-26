package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Alumno;
import clases.Asignatura;
import clases.Matricula;

public class MatriculaModelo extends Conector{
	public ArrayList<Matricula> selectAll(){
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		ArrayList<Matricula> matriculas=new ArrayList<Matricula>();
		try {
			Statement st=super.conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM matriculas");
			while (rs.next()){
				Matricula m=new Matricula();
				m.setAlumno(alumnoModelo.selectPorId(rs.getInt("id_alumno")));
				m.setAsignatura(asignaturaModelo.selectPorId(rs.getInt("id_asignatura")));
				m.setFecha(rs.getDate("fecha"));
				matriculas.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matriculas;
	}
	

	
	public void insertar(Matricula matricula){
		try {
			PreparedStatement pst=super.conexion.prepareStatement("INSERT INTO matriculas(id_alumno,id_asignatura,fecha) VALUES(?,?,?)");
			
			pst.setInt(1, matricula.getAlumno().getId());
			pst.setInt(2, matricula.getAsignatura().getId());
			Date fecha=cambiarUtilSql(matricula.getFecha());
			pst.setDate(3, fecha);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete(Matricula matricula){
		try {
			PreparedStatement pst=super.conexion.prepareStatement("DELETE FROM matriculas WHERE id_alumno=? and id_asignatura=? and fecha=? ");
			
			pst.setInt(1, matricula.getAlumno().getId());
			pst.setInt(2, matricula.getAsignatura().getId());
			Date fecha=cambiarUtilSql(matricula.getFecha());
			pst.setDate(3, fecha);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	private Date cambiarUtilSql(java.util.Date utilDate) {
		// TODO Auto-generated method stub
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}



	public ArrayList<Matricula> selectPorIdAlumno(int id) {
		// TODO Auto-generated method stub
		ArrayList<Matricula> matriculas=new ArrayList<>();
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		try {
			PreparedStatement pst= super.conexion.prepareStatement("Select * from matriculas where id_alumno=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Matricula m=new Matricula();
				m.setAlumno(alumnoModelo.selectPorId(rs.getInt("id_alumno")));
				m.setAsignatura(asignaturaModelo.selectPorId(rs.getInt("id_asignatura")));
				m.setFecha(rs.getDate("fecha"));
				matriculas.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return matriculas;
	}



	public ArrayList<Matricula> selectPorIdAsignatura(int id) {
		// TODO Auto-generated method stub
		ArrayList<Matricula> matriculas=new ArrayList<>();
		AsignaturaModelo asignaturaModelo=new AsignaturaModelo();
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		try {
			PreparedStatement pst=this.conexion.prepareStatement("Select * from matriculas where id_asignatura=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Matricula matricula=new Matricula();
				matricula.setAlumno(alumnoModelo.selectPorId(rs.getInt("id_alumno")));
				matricula.setAsignatura(asignaturaModelo.selectPorId(rs.getInt("id_asignatura")));
				matricula.setFecha(rs.getDate("fecha"));
				
				matriculas.add(matricula);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matriculas;
		
	}
}
