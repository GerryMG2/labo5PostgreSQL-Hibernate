package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(schema = "public",name = "estudiante")
public class Estudiante {
	
	@Id
	@Column(name = "c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	



	@Column(name = "nombre")
	@NotEmpty(message = "NO puede estar vacio")

	private String Nombre;
	
	
	@Column(name = "apellido")
	@NotEmpty(message = "NO puede estar vacio")

	private String Apellido;
	
	@Column(name = "carne")

	@NotEmpty(message = "NO puede estar vacio")

	private String carne;
	
	@Column(name = "carrera")
	@NotEmpty(message = "NO puede estar vacio")

	private String carrera;
	
	
	
	
	public Estudiante() {
		
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
	
	
	
	public Integer getCodigo() {
		return codigo;
	}









	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	

}
