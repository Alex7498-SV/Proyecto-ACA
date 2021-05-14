package com.capas.uca.parcial3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.parcial3.domain.*;
import com.capas.uca.parcial3.service.MunicipioService;
import com.capas.uca.parcial3.service.UsuarioService;

@Controller
public class MainController {

	@Autowired
	private MunicipioService MunicipioService;
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/index")
	public ModelAndView index(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Usuario user = null;
		if (request.getAttribute("user") != null) {
			user = (Usuario) request.getAttribute("user");
			if (user.getTipoUsuario() == false) {
				mav.setViewName("redirect:/tablaUsuario");
			} else {
				mav.setViewName("redirect:/busquedaAlumno");
			}
		} else {
			mav.setViewName("/index");
		}
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Usuario user = null;
		try {
			user = (Usuario) request.getAttribute("user");
			user.setSesion(false);
			usuarioService.insertAndUpdate(user);
			request.removeAttribute("user");
			mav.setViewName("redirect:/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/iniciarSesion")
	public ModelAndView iniciarSesion(@Valid @ModelAttribute Usuario usuario, BindingResult result,
			HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Usuario user = null;
		try {
			user = usuarioService.login(usuario.getNombreUser(), usuario.getContrasenia());
			if (user == null) {
				mav.setViewName("index");
				mav.addObject("mensaje", "Su usuario y/o contraseña son incorrectos!");
			} else {
				if (user.getEstado() == true) {
					if (user.getSesion() == false) {
						if (user.getTipoUsuario() == false) {
							mav.setViewName("redirect:/tablaUsuario");
						} else {
							mav.setViewName("redirect:/busquedaAlumno");
						}
						user.setSesion(true);
						usuarioService.insertAndUpdate(user);
						request.setAttribute("user", user);
						request.setMaxInactiveInterval(-1);
					} else {
						mav.setViewName("index");
						mav.addObject("mensaje", "Su sesión ya esta activa!");
					}
				} else {
					mav.setViewName("index");
					mav.addObject("mensaje", "Su cuenta no ha sido activada!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/cargarMunicipios")
	public @ResponseBody List<String[]> cargarMunicipios(@RequestParam Integer draw) {
		List<Municipio> municipio = null;
		try {
			municipio = MunicipioService.findDepartamento(draw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String[]> data = new ArrayList<>();

		for (Municipio u : municipio) {
			data.add(new String[] { u.getIdMunicipio().toString(), u.getNombreMunicipio() });
		}
		return data;
	}
	
	public ModelAndView sesionAdmin(HttpSession request, ModelAndView mav) {
		Usuario user = null;
		user = (Usuario) request.getAttribute("user");
		if (user != null) {
			if (user.getTipoUsuario() == true) {
				mav.clear();
				mav.setViewName("redirect:/busquedaAlumno");
			}
		} else {
			mav.clear();
			mav.setViewName("redirect:/index");
		}
		return mav;
	}

	public ModelAndView sesionCoordinador(HttpSession request, ModelAndView mav) {
		Usuario user = null;
		user = (Usuario) request.getAttribute("user");
		if (user != null) {
			if (user.getTipoUsuario() == false) {
				mav.clear();
				mav.setViewName("redirect:/tablaUsuario");
			}
		} else {
			mav.clear();
			mav.setViewName("redirect:/index");
		}
		return mav;
	}
}