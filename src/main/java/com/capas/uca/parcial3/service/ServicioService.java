package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Necesidades;
import com.capas.uca.parcial3.domain.Servicio;

public interface ServicioService {
	public Servicio findOneS(Integer id) throws DataAccessException;
}
