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
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.dto.filtroDTO;
import com.capas.uca.parcial3.service.CentroEscolarService;
import com.capas.uca.parcial3.service.UsuarioService;

@Controller
public class MapaController {
	
	@Autowired
	private MainController maincontroller;
	
	@Autowired
	private CentroEscolarService centroEscolarService;
	
	@RequestMapping("/mapa")
	public ModelAndView filterTest(HttpSession request, @ModelAttribute filtroDTO filtrado, BindingResult result) {
		List<CentroEscolar> centroEscolar = centroEscolarService.filterCE(filtrado);
		ModelAndView mav = new ModelAndView();
		mav.addObject("escuelas", centroEscolar);
		mav.setViewName("mapa");
		
		
		
		request.setMaxInactiveInterval(0);
		maincontroller.sesionAdmin(request, mav);
		return mav;
	}
	
	@RequestMapping("/cargarCentrosEscolaresMapa")
	public @ResponseBody List<String[]> cargarCentrosEscolaresMapa(@RequestParam List<CentroEscolar> centroescolar) {
		
		/*
		try {
			centroescolar = centroEscolarService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		List<String[]> data = new ArrayList<>();

		for (CentroEscolar u : centroescolar) {
			data.add(new String[] {Double.toString(u.getLatitud()), Double.toString(u.getLongitud()), u.getNombre()});
		}
		System.out.println(data.get(0).toString());
		
		return data;
	}
	
}