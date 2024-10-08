package com.pepe.p20241003.Modelos;

import java.util.Date;

public class Estudiante {
	int Matricula;
	String Nombre,Apellido;
	Date FechaNacimiento;
	int CarreraID;
	String Passwrod, Email;
	public int getMatricula() {
		return Matricula;
	}
	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public int getCarreraID() {
		return CarreraID;
	}
	public void setCarreraID(int carreraID) {
		CarreraID = carreraID;
	}
	public String getPasswrod() {
		return Passwrod;
	}
	public void setPasswrod(String passwrod) {
		Passwrod = passwrod;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
}
