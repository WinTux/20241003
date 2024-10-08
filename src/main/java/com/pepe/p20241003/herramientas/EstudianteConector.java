package com.pepe.p20241003.herramientas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.pepe.p20241003.Modelos.Estudiante;

public class EstudianteConector {
	private String url = "jdbc:mysql://192.168.1.254/UniversidadEducomser";
	private String usuario = "root";
	private String password = "123456Ax+";
	private Connection con = null;
	public EstudianteConector() {
		super();
		// Inscribir la clase Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, password);
		}catch(Exception e) {
			System.out.println("Error al establecer conexión a la DDBB: "+ e.getMessage());
		}
	}
	// GET
	public List<Estudiante> getEstudiantes(){
		List<Estudiante> lista = new LinkedList<>();
		String query = "SELECT * FROM Estudiante WHERE Estado = 1";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Estudiante est = new Estudiante();
				est.setMatricula(rs.getInt(1));
				est.setNombre(rs.getString(2));
				est.setApellido(rs.getString(3));
				est.setFechaNacimiento(rs.getDate(4));
				est.setCarreraID(rs.getInt(5));
				est.setPasswrod(rs.getString(6));
				est.setEmail(rs.getString(7));
				lista.add(est);
			}
		}catch(Exception e) {
			System.out.println("Error al enviar consulta a la DDBB: "+ e.getMessage());
		}
		return lista;
	}
	public Estudiante getEstudiante(int mat) {
		Estudiante est = new Estudiante();
		String query = "SELECT * FROM Estudiante WHERE Estado = 1 AND Matricula = " + mat;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				est.setMatricula(rs.getInt(1));
				est.setNombre(rs.getString(2));
				est.setApellido(rs.getString(3));
				est.setFechaNacimiento(rs.getDate(4));
				est.setCarreraID(rs.getInt(5));
				est.setPasswrod(rs.getString(6));
				est.setEmail(rs.getString(7));
			}
		}catch(Exception e) {
			System.out.println("Error al enviar consulta a la DDBB: "+ e.getMessage());
		}
		return est;
	}
	
	public void crearEstudiante(Estudiante est) {
		String sql ="INSERT INTO Estudiante VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, est.getMatricula());
			pst.setString(2, est.getNombre());
			pst.setString(3, est.getApellido());
			pst.setDate(4, (Date) est.getFechaNacimiento());
			pst.setInt(5,est.getCarreraID());
			pst.setString(6, est.getPasswrod());
			pst.setString(7,est.getEmail());
			pst.setBoolean(8, true);
			int n = pst.executeUpdate();
		}catch(Exception e) {}
	}
	public void actualizarEstudiante(Estudiante est) {
		String sql = "UPDATE Estudiante SET Nombre=?, Apellido=?, FechaNacimiento=?, CarreraID=?, Password=?,Email=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, est.getNombre());
			pst.setString(2, est.getApellido());
			pst.setDate(3, (Date) est.getFechaNacimiento());
			pst.setInt(4,est.getCarreraID());
			pst.setString(5, est.getPasswrod());
			pst.setString(6,est.getEmail());
			pst.executeUpdate();
		}catch(Exception e) {}
	}
	public void eliminarEstudiante(int mat) {
		String sql = "DELETE FROM Estudiante WHERE Matricula = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, mat);
			pst.executeUpdate();
		}catch(Exception e) {}
	}
}
