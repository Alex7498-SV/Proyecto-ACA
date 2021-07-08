package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Apoyoxescuela;

public interface ApoyoxescuelaService {
	public List<Apoyoxescuela> findAll() throws DataAccessException;
	
	public List<Apoyoxescuela> buscarTipoApoyo(Integer tipoApoyo, Integer centroEscolar) throws DataAccessException;
}
