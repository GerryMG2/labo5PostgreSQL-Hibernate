package com.example.demo;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface EstudianteDao {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public boolean insertEstudent(Estudiante es);
	
	public boolean deleteEstudiante(int id);
	
	public boolean updateEstudiante(Estudiante es);
}
