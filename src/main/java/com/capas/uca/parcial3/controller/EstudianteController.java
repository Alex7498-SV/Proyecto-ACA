package com.capas.uca.parcial3.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Estudiante;
import com.capas.uca.parcial3.domain.Materia;
import com.capas.uca.parcial3.domain.MateriaXestudiante;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.dto.CursadasDTO;
import com.capas.uca.parcial3.dto.ResutDTO;
import com.capas.uca.parcial3.dto.TablaDTO;
import com.capas.uca.parcial3.service.CentroEscolarService;
import com.capas.uca.parcial3.service.DepartamentoService;
import com.capas.uca.parcial3.service.EstudianteService;
import com.capas.uca.parcial3.service.MateriaService;
import com.capas.uca.parcial3.service.MateriaxEstudianteService;
import com.capas.uca.parcial3.service.MunicipioService;

@Controller
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private MunicipioService MunicipioService;
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private MateriaxEstudianteService materiaxEstudianteService;
	@Autowired
	private CentroEscolarService CentroEscolarService;
	@Autowired
	private MateriaService MateriaService;
	@Autowired
	private MainController maincontroller;

	/*--------------------------------------------------------------Vistas------------------------------------------------------------*/

	@RequestMapping("/editarEstudiante")
	public ModelAndView buscarEstudiante(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Estudiante c = estudianteService.findOne(id);
		List<Departamento> d = departamentoService.findAll();
		List<Municipio> m = MunicipioService.findDepartamento(c.getDepartamento().getIdDepartamento());
		List<CentroEscolar> ce = CentroEscolarService.findCentroEscolar(c.getCentroEscolar().getMunicipio().getIdMunicipio());
		List<Municipio> m2 = MunicipioService.findDepartamento(c.getCentroEscolar().getMunicipio().getDepartamento().getIdDepartamento());
		mav.addObject("departamentoLista", d);
		mav.addObject("municipioLista", m);
		mav.addObject("municipioListTodo", m2);
		mav.addObject("centro", ce);
		mav.addObject("estudiante", c);
		mav.addObject("departamentoListTodo", d);
		mav.setViewName("registroAlumno");
		return mav;
	}

	@RequestMapping("/busquedaAlumno")
	public ModelAndView busquedaAlumno(HttpSession request, @RequestParam(required = false) Integer msg) {
		ModelAndView mav = new ModelAndView();
		if(msg != null) {
			if(msg == 1) {
				mav.addObject("agrego", 1);
			} else if(msg == 2) {
				mav.addObject("modifico", 1);
			}
		}
		mav.setViewName("busquedaAlumno");
		maincontroller.sesionCoordinador(request, mav);
		return mav;
	}

	@RequestMapping("/tablaExpediente2")
	public ModelAndView tablaExpediente(@RequestParam String busqueda, @RequestParam String criterio,
			HttpSession request) {
		ModelAndView mav = new ModelAndView();
		if (busqueda.equals("")) {
			mav.addObject("mensaje2", 1);
			mav.setViewName("busquedaAlumno");
		}
		if (criterio.equals("")) {
			mav.addObject("mensaje1", 1);
			mav.setViewName("busquedaAlumno");
		}
		if (!criterio.equals("") && !busqueda.equals("")) {
			mav.addObject("busqueda", busqueda);
			mav.addObject("busqueda2", criterio);
			request.setAttribute("busqueda", busqueda);
			request.setAttribute("criterio", criterio);
			mav.setViewName("tablaExpediente");
		}
		maincontroller.sesionCoordinador(request, mav);
		return mav;
	}

	@RequestMapping("/RegresarTablaExpediente")
	public ModelAndView regresar(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		String criterio = (String) request.getAttribute("criterio");
		String busqueda = (String) request.getAttribute("busqueda");
		mav.setViewName("redirect:/tablaExpediente2?criterio=" + criterio + "&busqueda=" + busqueda);
		maincontroller.sesionCoordinador(request, mav);
		return mav;
	}

	@RequestMapping("/registroAlumno")
	public ModelAndView registroAlumno(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentoLista = null;
		try {
			departamentoLista = departamentoService.findAll();
			mav.addObject("departamentoLista", departamentoLista);
			mav.addObject("departamentoListTodo", departamentoLista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("registroAlumno");
		maincontroller.sesionCoordinador(request, mav);
		return mav;
	}

	@RequestMapping("/materiasCursadas")
	public ModelAndView materiasCursadasTable(@RequestParam Integer id, HttpSession request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("tablaMateriasCursadas");
		maincontroller.sesionCoordinador(request, mav);
		return mav;
	}

	@RequestMapping("/registrarMateriaCursada")
	public ModelAndView registrarMateriaAlumnos(@RequestParam Integer id, HttpSession request) {
		ModelAndView mav = new ModelAndView();

		List<Materia> materiaLista = null;
		Estudiante estu = null;
		try {

			materiaLista = MateriaService.showSubjects();
			estu = estudianteService.findByName2(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estu", estu);
		mav.addObject("materiaLista", materiaLista);
		mav.addObject("materiaAlumno", new MateriaXestudiante());
		mav.setViewName("registrarMateriaCursada");
		maincontroller.sesionCoordinador(request, mav);
		return mav;
	}

	@RequestMapping("/editarMateriaAlumno")
	public ModelAndView buscarMateriaAlumno(@RequestParam Integer id, @RequestParam Integer id2) {
		ModelAndView mav = new ModelAndView();

		List<Materia> materiaLista = null;
		Estudiante estu = null;
		MateriaXestudiante materiaAlumno = null;
		try {

			materiaLista = MateriaService.showSubjects();
			estu = estudianteService.findByName2(id);
			materiaAlumno = materiaxEstudianteService.findOne(id2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estu", estu);
		mav.addObject("id2", id2);
		mav.addObject("materiaLista", materiaLista);
		mav.addObject("materiaAlumno", materiaAlumno);
		mav.setViewName("registrarMateriaCursada");
		return mav;
	}

	/*-----------------------------------------------------------Cargar Tablas o select------------------------------------------------------------*/

	@RequestMapping("/cargarEstudiantes")
	public @ResponseBody TablaDTO cargarEstudiante(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value = "search[value]", required = false) String search,
			@RequestParam String variable, @RequestParam String criterio) {

		String val1 = "", val2 = "";

		if (criterio.equals("1")) {
			val1 = variable.toLowerCase();
		} else {
			val2 = variable.toLowerCase();
		}

		Page<ResutDTO> materia = materiaxEstudianteService.dtoPrueba(val1, val2,
				PageRequest.of(start / length, length, Sort.by(Direction.ASC, "idestudiante")));

		List<String[]> data = new ArrayList<>();

		for (ResutDTO u : materia) {
			data.add(new String[] { u.getId().toString(), u.getNombre().toString(), u.getApellido().toString(),
					u.getAprobadas().toString(), u.getReprobadas().toString(), String.valueOf(u.getProm()) });
		}
		TablaDTO dto = new TablaDTO();

		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(estudianteService.countAlumno(val1, val2));
		dto.setRecordsTotal(estudianteService.countAlumno(val1, val2));

		return dto;
	}

	@RequestMapping("/cargarMateriasCursadas")
	public @ResponseBody TablaDTO cargartablaMateriasCursadas(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value = "search[value]", required = false) String search,
			@RequestParam Integer id) {

		Page<CursadasDTO> materia = materiaxEstudianteService.dtoCursadas(id,
				PageRequest.of(start / length, length, Sort.by(Direction.ASC, "idMateriaXestudiante")));

		List<String[]> data = new ArrayList<>();

		for (CursadasDTO u : materia) {
			data.add(new String[] { u.getIdMateriaXestudiante().toString(), u.getNombremateria().toString(),
					u.getAnio().toString(), u.getCiclo().toString(), String.valueOf(u.getNota()), u.getDelegateNota(),
					u.getIdestudiante().toString() });
		}
		TablaDTO dto = new TablaDTO();

		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiaxEstudianteService.countMateriaAlumno(id));
		dto.setRecordsTotal(materiaxEstudianteService.countMateriaAlumno(id));

		return dto;
	}

	@RequestMapping("/cargarCentroEscolar")
	public @ResponseBody List<String[]> cargarCentroEscolar(@RequestParam Integer draw) {
		List<CentroEscolar> centro = null;
		try {
			centro = CentroEscolarService.findCentroEscolar(draw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String[]> data = new ArrayList<>();

		for (CentroEscolar u : centro) {
			data.add(new String[] { u.getIdCentroEscolar().toString(), u.getNombre() });
		}
		return data;
	}

	/*--------------------------------------------------------------Funciones------------------------------------------------------------*/

	@RequestMapping("/registroEstudiante")
	public ModelAndView alumno(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors() || estudiante.getMunicipio() == null || estudiante.getDepartamento() == null
				|| estudiante.getFechaNac() == null || estudiante.getCentroEscolar().getMunicipio().getDepartamento() == null
				|| estudiante.getCentroEscolar().getMunicipio().getIdMunicipio() == null || estudiante.getCentroEscolar().getIdCentroEscolar() == null) {
			erroraxo(estudiante, mav);
			mostrarComboBoxRegistro(mav, estudiante);
		} else {
			try {
				if(estudiante.getIdEstudiante() == null) {
					mav.setViewName("redirect:/busquedaAlumno?msg=1");
				} else {
					mav.setViewName("redirect:/busquedaAlumno?msg=2");
				}
				estudianteService.insertAndUpdate(estudiante);
				mav.addObject("estudiante", estudiante);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

	public void erroraxo(@ModelAttribute Estudiante estudiante, ModelAndView mav) {
		if (estudiante.getDepartamento() == null) {
			mav.addObject("resultado", 1);
		}
		if (estudiante.getMunicipio() == null) {
			mav.addObject("resultado1", 1);
		}
		if (estudiante.getCentroEscolar().getIdCentroEscolar() == null) {
			mav.addObject("resultado2", 1);

		}
		if (estudiante.getFechaNac() == null) {
			mav.addObject("resultado3", 1);
		}
	}

	public void mostrarComboBoxRegistro(ModelAndView mav, Estudiante estudiante) {
		List<Departamento> departamentoLista = null;
		List<Municipio> municipioLista = null;
		List<Municipio> municipioListaTodo = null;
		List<CentroEscolar> centroescolar = null;

		try {
			departamentoLista = departamentoService.findAll();
			if (estudiante.getDepartamento() != null) {
				municipioLista = MunicipioService.findDepartamento(estudiante.getDepartamento().getIdDepartamento());
			}
			if(estudiante.getCentroEscolar().getMunicipio().getDepartamento() != null) {
				municipioListaTodo = MunicipioService.findDepartamento(estudiante.getCentroEscolar().getMunicipio().getDepartamento().getIdDepartamento());
				if (estudiante.getCentroEscolar().getMunicipio().getIdMunicipio() != null) {
					centroescolar = CentroEscolarService.findCentroEscolar(estudiante.getCentroEscolar().getMunicipio().getIdMunicipio());
				}
			}
			
			mav.addObject("centro", centroescolar);
			mav.addObject("departamentoLista", departamentoLista);
			mav.addObject("departamentoListTodo", departamentoLista);
			mav.addObject("municipioLista", municipioLista);
			mav.addObject("municipioListTodo", municipioListaTodo);

			mav.setViewName("registroAlumno");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/insertarMateriaAlumno")
	public ModelAndView insertarMateriaAlumno(@Valid @ModelAttribute MateriaXestudiante materiaAlumno,
			BindingResult result, @RequestParam Integer id2, @RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();

		List<Materia> materiaLista = null;
		Estudiante estu = null;
		estu = estudianteService.findOne(id2);
		materiaLista = MateriaService.showSubjects();
		int bandera = 0;
		int bandera2 = 0;
		if(materiaAlumno.getNota() == null) {
			bandera = 1;
		} else {
			if(materiaAlumno.getNota() > 10 || materiaAlumno.getNota() < 0) {
				mav.addObject("resultado4", 1);
			}
		}
		if(materiaAlumno.getAnio() == null) {
			bandera2 = 1;
		} else {
			Calendar cal= Calendar.getInstance();
			if(materiaAlumno.getAnio() < 2005 || materiaAlumno.getAnio() > cal.get(Calendar.YEAR)) {
				bandera2=1;
			}
		}
		if (result.hasErrors() || materiaAlumno.getMateria() == null || materiaAlumno.getCiclo() == 0 || bandera2 == 1
				|| bandera == 1) {
			if (materiaAlumno.getMateria() == null) {
				mav.addObject("resultado", 1);
			}
			if(materiaAlumno.getCiclo() == 0) {
				mav.addObject("resultado3", 1);
			}
			if(bandera2 == 1) {
				mav.addObject("resultado2", 1);
			}
			if(bandera == 1) {
				mav.addObject("resultado4", 1);
			}
			mav.addObject("estu", estu);
			mav.setViewName("registrarMateriaCursada");
		} else {
			try {
				materiaAlumno.setEstudiante(estu);
				materiaxEstudianteService.insertAndUpdate(materiaAlumno);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("redirect:/materiasCursadas?id="+id2);
		}
		materiaLista = MateriaService.showSubjects();
		mav.addObject("estu", estu);
		mav.addObject("id2", id);
		mav.addObject("materiaLista", materiaLista);
		mav.addObject("materiaAlumno", materiaAlumno);
		return mav;
	}
}
