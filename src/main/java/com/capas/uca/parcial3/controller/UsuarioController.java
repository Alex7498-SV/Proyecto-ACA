package com.capas.uca.parcial3.controller;

import java.util.ArrayList;
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

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.domain.Usuario;
import com.capas.uca.parcial3.dto.TablaDTO;
import com.capas.uca.parcial3.service.DepartamentoService;
import com.capas.uca.parcial3.service.MunicipioService;
import com.capas.uca.parcial3.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MunicipioService MunicipioService;
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private MainController maincontroller;
	
	/*--------------------------------------------------------------Vistas------------------------------------------------------------*/
	
	@RequestMapping("/tablaUsuario")
	public ModelAndView tablaUsuario(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		maincontroller.sesionAdmin(request, mav);
		return mav;
	}
	
	@RequestMapping("/registro")
	public ModelAndView registro(@RequestParam Integer tipo, HttpSession request) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentoLista = null;
		List<Municipio> municipioLista = null;
		Usuario usuarioLista = new Usuario();
		try {
			departamentoLista = departamentoService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("departamentoLista", departamentoLista);
		mav.addObject("municipioLista", municipioLista);
		mav.addObject("usuario", usuarioLista);
		mav.addObject("tipoF", tipo);
		mav.setViewName("registroUsuario");
		if (tipo == 1) {
			maincontroller.sesionAdmin(request, mav);
		}
		return mav;
	}

	@RequestMapping("/editarUsuario")
	public ModelAndView editarUsuario(@RequestParam Integer tipo, @RequestParam Integer id, HttpSession request) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentoLista = null;
		List<Municipio> municipioLista = null;
		Usuario usuarioLista = usuarioService.findOne(id);

		try {
			departamentoLista = departamentoService.findAll();
			municipioLista = MunicipioService.findDepartamento(usuarioLista.getDepartamento().getIdDepartamento());
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("departamentoLista", departamentoLista);
		mav.addObject("municipioLista", municipioLista);
		mav.addObject("usuario", usuarioLista);
		mav.addObject("tipoF", tipo);
		mav.addObject("id", id);
		mav.setViewName("registroUsuario");

		if (tipo == 1) {
			maincontroller.sesionAdmin(request, mav);
		}

		return mav;
	}

	/*--------------------------------------------------------------Cargar Tabla------------------------------------------------------------*/

	@RequestMapping("/cargarUsuario")
	public @ResponseBody TablaDTO cargarUsuario(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value = "search[value]", required = false) String search) {
		Page<Usuario> Usuario = usuarioService.mostrarTodo(search.toLowerCase(),
				PageRequest.of(start / length, length, Sort.by(Direction.ASC, "idUsuario")));
		List<String[]> data = new ArrayList<>();

		for (Usuario u : Usuario) {
			data.add(new String[] { u.getIdUsuario().toString(), u.getIdUsuario().toString(), u.getNombre(),
					u.getApellido(), u.getFechaNac().toString(), u.getNombreUser(), u.getDelegateEstado() });
		}
		TablaDTO dto = new TablaDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(usuarioService.countUser(search.toLowerCase()));
		dto.setRecordsTotal(usuarioService.countUser(search.toLowerCase())); 
		return dto;
	}

	/*--------------------------------------------------------------Funciones------------------------------------------------------------*/
	
	@RequestMapping("/ingresarUsuario")
	public ModelAndView ingresarUsuario(@RequestParam("pass") String pass, @Valid @ModelAttribute Usuario usuario,
			BindingResult result, @RequestParam Integer tipoF) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentoLista = null;
		List<Municipio> municipioLista = null;
		int bandera = 0;
		int bandera2 = 0;
		if (usuario.getIdUsuario() != null) {
			Usuario usuarioUno = usuarioService.findOne(usuario.getIdUsuario());
			if (!usuario.getContrasenia().equals(usuarioUno.getContrasenia())) {
				if (!usuario.getContrasenia().equals(pass)) {
					bandera = 1;
				}
			}
			if (!usuario.getNombreUser().equals(usuarioUno.getNombreUser())) {
				int verificar2 = usuarioService.userExiste(usuario.getNombreUser().toLowerCase());
				if (verificar2 > 0) {
					bandera2 = 1;
				}
			}
		} else {
			if (!usuario.getContrasenia().equals(pass)) {
				bandera = 1;
			}
		}
		int verificar = 0;
		if(usuario.getIdUsuario() == null) {
			verificar = usuarioService.userExiste(usuario.getNombreUser().toLowerCase());
		}
		if (result.hasErrors() || usuario.getDepartamento() == null || usuario.getMunicipio() == null || bandera == 1
				|| usuario.getFechaNac() == null || verificar > 0 || bandera2 == 1) {
			if (usuario.getDepartamento() == null) {
				mav.addObject("resultado", 1);
			} else {
				municipioLista = MunicipioService.findDepartamento(usuario.getDepartamento().getIdDepartamento());
			}
			if (usuario.getMunicipio() == null) {
				mav.addObject("resultado2", 1);
			}
			if (usuario.getTipoUsuario() == null) {
				mav.addObject("resultado3", 1);
			}
			if (bandera == 1) {
				mav.addObject("resultado4", 1);
			}
			if (usuario.getFechaNac() == null) {
				mav.addObject("resultado5", 1);
			}
			if(verificar > 0 || bandera2 == 1) {
				mav.addObject("resultado6", 1);
			}
			departamentoLista = departamentoService.findAll();
			mav.addObject("departamentoLista", departamentoLista);
			mav.addObject("municipioLista", municipioLista);
			mav.addObject("tipoF", tipoF);
			mav.setViewName("registroUsuario");
		} else {
			try {
				usuario.setSesion(false);
				if (usuario.getEstado() == null) {
					usuario.setEstado(false);
				}
				usuarioService.insertAndUpdate(usuario);
				mav.setViewName("redirect:/tablaUsuario");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

}
