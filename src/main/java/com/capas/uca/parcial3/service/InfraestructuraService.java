package com.capas.uca.parcial3.service;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Infraestructura;

public interface InfraestructuraService {
	public Infraestructura findOneS(Integer id) throws DataAccessException;
}
