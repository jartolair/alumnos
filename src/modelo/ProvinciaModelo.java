package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Provincia;
import java.util.ArrayList;

public class ProvinciaModelo extends Conector{
	public Provincia selectPorId(int id){
		Provincia provincia=new Provincia();
		try {
			PreparedStatement pst=super.conexion.prepareStatement("select * from provincias where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				provincia.setId(rs.getInt("id"));
				provincia.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return provincia;
	}

	public ArrayList<Provincia> selectAllConAlumnos() {
		// TODO Auto-generated method stub
		ArrayList<Provincia> provincias=new ArrayList<>();
		AlumnoModelo alumnoModelo=new AlumnoModelo();
		try {
			PreparedStatement pst=super.conexion.prepareStatement("Select * from provincias");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Provincia provincia=new Provincia();
				provincia.setId(rs.getInt("id"));
				provincia.setNombre(rs.getString("nombre"));
				provincia.setAlumnos(alumnoModelo.selectPorProvincia(rs.getInt("id")));
				provincias.add(provincia);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provincias;
	}
}
