package com.example.demo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public class estu {
	
	private Integer codigo;
	
	





	private String Nombre;
	
	


	private String Apellido;
	

	private String carne;
	


	private String carrera;
	
	public estu() {
		
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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



	public String getCarne() {
		return carne;
	}



	public void setCarne(String carne) {
		this.carne = carne;
	}



	public String getCarrera() {
		return carrera;
	}



	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
}
