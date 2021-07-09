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
																	    //1   2		3		4	5		6	7		8	9		10	11		12	13		14	15		16	17		18	19		20	21		22	23		24	25		26	27		28
		//List<CentroEscolar> centroEscolar = CentroEscolarService.filter(filtrado.getFil1(), filtrado.getFil2(), filtrado.getFil3(), filtrado.getFil4(), filtrado.getFil4(), filtrado.getFil6(), filtrado.getFil7(), filtrado.getFil8(), filtrado.getFil9(), filtrado.getFil10(), filtrado.getFil11(), filtrado.getFil12(), filtrado.getFil13(), filtrado.getFil14(), filtrado.getFil15(), filtrado.getFil16(), filtrado.getFil17(), filtrado.getFil18(), filtrado.getFil19(), filtrado.getFil20(), filtrado.getFil21(), filtrado.getFil22(), filtrado.getFil23(), filtrado.getFil24(), filtrado.getFil25(), filtrado.getFil26(), filtrado.getFil27());
		//List<CentroEscolar> c = CentroEscolarService.filter("sdfsd");
		List<CentroEscolar> centroEscolar = centroEscolarService.filterCE(filtrado);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("escuelas", centroEscolar);
	//	mav.addObject("equipos", equipos);
		mav.setViewName("mapa");
		
		
		
		request.setMaxInactiveInterval(0);
		maincontroller.sesionAdmin(request, mav);
		return mav;
	}
	
	@RequestMapping("/cargarCentrosEscolaresMapa")
	public @ResponseBody List<String[]> cargarCentrosEscolaresMapa() {
		List<CentroEscolar> centroescolar = null;
		try {
			centroescolar = centroEscolarService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String[]> data = new ArrayList<>();

		for (CentroEscolar u : centroescolar) {
			data.add(new String[] {Double.toString(u.getLatitud()), Double.toString(u.getLongitud()), u.getNombre()});
		}
		return data;
	}
	
}