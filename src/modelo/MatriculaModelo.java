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
		ArrayList<Matricula> matriculas=new ArrayList<Matricula>();
		try {
			Statement st=super.conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM matriculas");
			while (rs.next()){
				Matricula m=new Matricula();
				m.setId_alumno(rs.getInt("id_alumno"));
				m.setId_asignatura(rs.getInt("id_asignatura"));
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
			
			pst.setInt(1, matricula.getId_alumno());
			pst.setInt(2, matricula.getId_asignatura());
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
			
			pst.setInt(1, matricula.getId_alumno());
			pst.setInt(2, matricula.getId_asignatura());
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
}
