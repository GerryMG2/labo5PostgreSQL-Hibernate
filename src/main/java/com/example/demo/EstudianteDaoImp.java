package com.example.demo;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class EstudianteDaoImp implements EstudianteDao {
	
	@PersistenceContext(unitName = "capas")
	private EntityManager entity;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		List<Estudiante> lis = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from estudiante;");
			Query qr = entity.createNativeQuery(sb.toString(), Estudiante.class);
			
			 lis = qr.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return lis;
	}
	
	

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		
		Estudiante est = entity.find(Estudiante.class, code);
		return est;
	}
	@Transactional
	@Override
	public boolean insertEstudent(Estudiante es) {
		System.out.println("entro a insertar");
		
		try {
			entity.persist(es);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	
	@Transactional
	@Override
	public boolean deleteEstudiante(int id) {

		try {
			System.out.println("id: " + id);
			entity.createNativeQuery("delete from estudiante where c_usuario = :id").setParameter("id", id).executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
