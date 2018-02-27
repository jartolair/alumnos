package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Alumno;

public class AlumnoModelo extends Conector{
	public ArrayList<Alumno> selectAll(){
		MatriculaModelo matriculaModelo=new MatriculaModelo();
		ProvinciaModelo provinciaModelo=new ProvinciaModelo();
		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
		try {
			Statement st=super.conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from alumnos");
			while(rs.next()){
				Alumno a=new Alumno();
				a.setId(rs.getInt("id"));
				a.setDni(rs.getString("dni"));
				a.setNombre(rs.getString("nombre"));
				a.setEmail(rs.getString("email"));
				
				a.setProvincia(provinciaModelo.selectPorId(rs.getInt("id_provincia")));
				alumnos.add(a);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
		
	}
	
	public ArrayList<Alumno> selectAllConMatriculas(){
		MatriculaModelo matriculaModelo=new MatriculaModelo();
		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
		ProvinciaModelo provinciaModelo=new ProvinciaModelo();
		try {
			Statement st=super.conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from alumnos");
			while(rs.next()){
				Alumno a=new Alumno();
				a.setId(rs.getInt("id"));
				a.setDni(rs.getString("dni"));
				a.setNombre(rs.getString("nombre"));
				a.setEmail(rs.getString("email"));
				
				a.setMatriculas(matriculaModelo.selectPorIdAlumno(a.getId()));

				a.setProvincia(provinciaModelo.selectPorId(rs.getInt("id_provincia")));
				alumnos.add(a);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
		
	}
	
	
	public void insert(Alumno alumno){
		try {
			PreparedStatement pst=this.conexion.prepareStatement("INSERT INTO alumnos(dni,nombre,email) values(?,?,?)");
			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getEmail());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(Alumno alumno){
		try {
			PreparedStatement pst=this.conexion.prepareStatement("UPDATE alumnos SET dni=?, nombre=?, email=? WHERE id=?");
			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getEmail());
			pst.setInt(4, alumno.getId());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM alumnos WHERE id=?");
			pst.setInt(1, id);
			pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Alumno selectPorId(int id) {
		// TODO Auto-generated method stub
		Alumno alumno=new Alumno();
		ProvinciaModelo provinciaModelo=new ProvinciaModelo();
		try {
			Statement st= super.conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from alumnos where id="+id);
			while(rs.next()){
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));
				
				alumno.setProvincia(provinciaModelo.selectPorId(rs.getInt("id_provincia")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumno;
	}

	public ArrayList<Alumno> selectPorProvincia(int id) {
		// TODO Auto-generated method stub
		ArrayList<Alumno> alumnos=new ArrayList<>();
		try {
			Statement st= super.conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from alumnos where id_provincia="+id);
			while(rs.next()){
				Alumno alumno=new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}
	

}
