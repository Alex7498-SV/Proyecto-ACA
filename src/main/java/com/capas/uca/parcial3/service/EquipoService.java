package com.capas.uca.parcial3.service;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Equipo;

public interface EquipoService{
	
	public Equipo findOne(Integer id) throws DataAccessException;
}