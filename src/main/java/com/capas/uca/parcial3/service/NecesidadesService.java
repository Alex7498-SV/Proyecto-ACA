package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Necesidades;

public interface NecesidadesService {
	public Necesidades findOneN(Integer id) throws DataAccessException;
}
