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

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.dto.TablaDTO;
import com.capas.uca.parcial3.service.CentroEscolarService;
import com.capas.uca.parcial3.service.MunicipioService;

@Controller
public class CentroEscolarController {

	@Autowired
	private CentroEscolarService CentroEscolarService;
	@Autowired
	private MunicipioService MunicipioService;
	@Autowired
	private MainController maincontroller;

	/*--------------------------------------------------------------Vistas------------------------------------------------------------*/

	@RequestMapping("/tablaCentroEscolar")
	public ModelAndView tablaCentroEscolar(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tablaCentroEscolar");
		request.setMaxInactiveInterval(0);
		maincontroller.sesionAdmin(request, mav);
		return mav;
	}

	@RequestMapping("/editarCentroEscolar")
	public ModelAndView editarCentroEscolar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		List<Municipio> municipioLista = null;
		try {
			municipioLista = MunicipioService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		CentroEscolar c = CentroEscolarService.findOne(id);
		mav.addObject("centroEscolar", c);
		mav.addObject("municipioLista", municipioLista);
		mav.setViewName("registroCentroEscolar");
		return mav;
	}

	@RequestMapping("/registroCentroEscolar")
	public ModelAndView registroCentroEscolar(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		List<Municipio> municipioLista = null;
		try {
			municipioLista = MunicipioService.findAll();
			// usuarioLista = usuarioService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("centroEscolar", new CentroEscolar());
		mav.addObject("municipioLista", municipioLista);
		mav.setViewName("registroCentroEscolar");
		request.setMaxInactiveInterval(0);
		maincontroller.sesionAdmin(request, mav);
		return mav;
	}

	/*--------------------------------------------------------------Cargar Tabla------------------------------------------------------------*/

	@RequestMapping("/cargarCentrosEscolares")
	public @ResponseBody TablaDTO cargar(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value = "search[value]", required = false) String search) {
		Page<CentroEscolar> centroEscolar = CentroEscolarService.findAll(search.toLowerCase(),
				PageRequest.of(start / length, length, Sort.by(Direction.ASC, "idCentroEscolar")));

		List<String[]> data = new ArrayList<>();

		for (CentroEscolar u : centroEscolar) {
			data.add(new String[] { u.getIdCentroEscolar().toString(), u.getIdCentroEscolar().toString(), u.getNombre(),
					u.getMunicipio().getNombreMunicipio(), u.getDescripcion(), u.getDelegateEstado() });
		}
		System.out.print(data);
		TablaDTO dto = new TablaDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(CentroEscolarService.countCE(search.toLowerCase()).intValue());
		dto.setRecordsTotal(CentroEscolarService.countCE(search.toLowerCase()).intValue());

		return dto;
	}

	/*--------------------------------------------------------------Funciones------------------------------------------------------------*/

	@RequestMapping("/registroCentroEscolarProcesar")
	public ModelAndView insertarCentroEscolar(@Valid @ModelAttribute CentroEscolar centroEscolar,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Municipio> municipioLista = null;
		mav.setViewName("registroCentroEscolar");
		if (!result.hasErrors() && centroEscolar.getMunicipio() != null) {
			mav.addObject("centroEscolar", new CentroEscolar());
			try {
				CentroEscolarService.insertAndUpdate(centroEscolar);
				mav.setViewName("redirect:/tablaCentroEscolar");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(centroEscolar.getMunicipio());
			if (centroEscolar.getMunicipio() == null) {
				mav.addObject("resultado", 1);
			}
			mav.addObject("centroEscolar", centroEscolar);
		}
		try {
			municipioLista = MunicipioService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("municipioLista", municipioLista);
		return mav;
	}

}
