package com.capas.uca.parcial3.controller;

import java.awt.SystemTray;
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

import com.capas.uca.parcial3.domain.Apoyo;
import com.capas.uca.parcial3.domain.Apoyoxescuela;
import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.domain.TipoApoyo;
import com.capas.uca.parcial3.dto.TablaDTO;
import com.capas.uca.parcial3.service.ApoyoService;
import com.capas.uca.parcial3.service.ApoyoxescuelaService;
import com.capas.uca.parcial3.service.CentroEscolarService;
import com.capas.uca.parcial3.service.MunicipioService;
import com.capas.uca.parcial3.service.TipoApoyoService;

@Controller
public class CentroEscolarController {

	@Autowired
	private CentroEscolarService CentroEscolarService;
	@Autowired
	private MunicipioService MunicipioService;
	@Autowired
	private MainController maincontroller;
	@Autowired
	private ApoyoService ApoyoService;
	@Autowired
	private TipoApoyoService TipoApoyoService;
	@Autowired
	private ApoyoxescuelaService ApoyoxescuelaService;
	

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
		
		String zona = "Rural";
		if(c.getZona() == true) {
			zona = "Urbano";
		}
		
		String sector = "Privado";
		if(c.getSector() == true) {
			sector = "Publico";
		}
		
		mav.addObject("centroEscolar", c);
		mav.addObject("zona", zona);
		mav.addObject("sector", sector);
		mav.setViewName("registroCentroEscolar");
		return mav;
	}
	
	@RequestMapping("/apoyo")
	public ModelAndView apoyo(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		CentroEscolar c = CentroEscolarService.findOne(id);
		
		List<Apoyoxescuela> apoyoxescuela = ApoyoxescuelaService.buscarTipoApoyo(1, id);
		List<Apoyoxescuela> apoyoxescuela2 = ApoyoxescuelaService.buscarTipoApoyo(2, id);
		List<Apoyoxescuela> apoyoxescuela3 = ApoyoxescuelaService.buscarTipoApoyo(3, id);
		List<Apoyoxescuela> apoyoxescuela4 = ApoyoxescuelaService.buscarTipoApoyo(4, id);
		List<Apoyoxescuela> apoyoxescuela5 = ApoyoxescuelaService.buscarTipoApoyo(5, id);
		List<Apoyoxescuela> apoyoxescuela6 = ApoyoxescuelaService.buscarTipoApoyo(6, id);
		List<Apoyoxescuela> apoyoxescuela7 = ApoyoxescuelaService.buscarTipoApoyo(7, id);
		List<Apoyoxescuela> apoyoxescuela8 = ApoyoxescuelaService.buscarTipoApoyo(8, id);
		
		mav.addObject("centroEscolar", c);
		mav.addObject("apoyo1", apoyoxescuela);
		mav.addObject("apoyo2", apoyoxescuela2);
		mav.addObject("apoyo3", apoyoxescuela3);
		mav.addObject("apoyo4", apoyoxescuela4);
		mav.addObject("apoyo5", apoyoxescuela5);
		mav.addObject("apoyo6", apoyoxescuela6);
		mav.addObject("apoyo7", apoyoxescuela7);
		mav.addObject("apoyo8", apoyoxescuela8);
		mav.setViewName("apoyo");
		return mav;
	}
	
	@RequestMapping("/necesidades")
	public ModelAndView necesidades(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		CentroEscolar c = CentroEscolarService.findOne(id);		
		
		mav.addObject("centroEscolar", c);
		mav.setViewName("necesidades");
		return mav;
	}
	
	@RequestMapping("/servicios")
	public ModelAndView servicios(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		CentroEscolar c = CentroEscolarService.findOne(id);
		
		mav.addObject("centroEscolar", c);
		mav.setViewName("servicios");
		return mav;
	}
	
	@RequestMapping("/poblacion")
	public ModelAndView poblacion(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		CentroEscolar c = CentroEscolarService.findOne(id);
		
		mav.addObject("centroEscolar", c);
		mav.setViewName("poblacion");
		return mav;
	}
	
	@RequestMapping("/equipos")
	public ModelAndView equipos(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		CentroEscolar c = CentroEscolarService.findOne(id);
		
		mav.addObject("centroEscolar", c);
		mav.setViewName("equipos");
		return mav;
	}
	
	@RequestMapping("/infraestructura")
	public ModelAndView infraestructura(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		CentroEscolar c = CentroEscolarService.findOne(id);
		
		mav.addObject("centroEscolar", c);
		mav.setViewName("infraestructura");
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
					u.getMunicipio().getNombreMunicipio(), u.getDireccion(), u.getNip() });
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
