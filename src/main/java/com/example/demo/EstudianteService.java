package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService implements serviceEstudiante {
	@Autowired
	private EstudianteDaoImp dao = new EstudianteDaoImp();

	@Override
	public List<Estudiante> getEstudiantes() {
		return dao.findAll();
	}
	@Transactional
	@Override
	public boolean insertEstudiante(Estudiante est) {
		
		return dao.insertEstudent(est);
	}
	
	@Transactional
	@Override
	public boolean deleteEstudiante(int id) {
		
		return dao.deleteEstudiante(id);
	}
	@Transactional
	@Override
	public boolean update(Estudiante est) {
		// TODO Auto-generated method stub
		return dao.updateEstudiante(est);
	}

}
