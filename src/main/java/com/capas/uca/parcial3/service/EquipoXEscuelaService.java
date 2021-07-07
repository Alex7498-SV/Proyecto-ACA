package com.capas.uca.parcial3.service;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.EquipoXEscuela;

public interface EquipoXEscuelaService {
	public EquipoXEscuela findOne(Integer code) throws DataAccessException;
}
