package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteDao = new EstudianteService();
	
	@GetMapping(path = "/inicio")
	public ModelAndView index(Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		return mav;
	}
	
	@PostMapping(path = "/editarr")
	public ModelAndView editar(idcodigo id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> ests = estudianteDao.getEstudiantes();
		System.out.println("codigo:"+id.getId());
		for(Estudiante es: ests) {
			if(es.getCodigo().equals(id.getId())) {
				System.out.println(es.getNombre());
				mav.addObject("estudiante",es);
			}
		}
		mav.setViewName("editar");
		
		return mav;
	}
	
	@GetMapping(path = "/delete")
	public ModelAndView index(deleteObject del) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("delete");
		
		return mav;
	}
	
	@PostMapping(path = "/delete")
	public ModelAndView borrar(@ModelAttribute deleteObject id, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("delete");
		}else {
			Boolean resolve = estudianteDao.deleteEstudiante(id.getId());
			if(resolve) {
				mav.setViewName("delete");
				mav.addObject("msg", "Se elimino con exito!");
			}else {
				mav.setViewName("delete");
				mav.addObject("msg", "hubo un problema al eliminar");
			}
		}
		
		
		return mav;
	}
	
	@PostMapping(path = "/editar")
	public ModelAndView editarr(@ModelAttribute Estudiante est, BindingResult result) {
		System.out.println(est.getCodigo());
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
		}else {
			Boolean resolve = estudianteDao.update(est);
			if(resolve) {
				mav.setViewName("ok");
				mav.addObject("msg", "Se guardo con exito!");
			}else {
				mav.setViewName("ok");
				mav.addObject("msg", "hubo un problema al guardar");
			}
		}
		
		
		return mav;
	}
	
	
	
	@PostMapping(path = "/registro")
	public ModelAndView registrar(@ModelAttribute Estudiante est, BindingResult result) {
		System.out.println(est.getNombre());
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
		}else {
			Boolean resolve = estudianteDao.insertEstudiante(est);
			if(resolve) {
				mav.setViewName("index");
				mav.addObject("msg", "Se guardo con exito!");
			}else {
				mav.setViewName("index");
				mav.addObject("msg", "hubo un problema al guardar");
			}
		}
		
		
		return mav;
	}
	
	
	@GetMapping(path = "/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		try {
			System.out.println("entra al try");
			List<Estudiante> ests = estudianteDao.getEstudiantes();
			System.out.println(ests.size());
			mav.addObject("estudiantes", ests);
			idcodigo id = new idcodigo();
			mav.addObject("idcode", id );
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return mav;
	}
	
	
	
	

}
