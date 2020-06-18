package com.example.demo;

import java.util.List;

public interface serviceEstudiante {
	public List<Estudiante> getEstudiantes();
	
	public boolean insertEstudiante(Estudiante est);
	
	public boolean deleteEstudiante(int id);
	
	public boolean update(Estudiante est);

}
