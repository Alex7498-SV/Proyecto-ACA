package com.capas.uca.parcial3.service;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Poblacion_Estudiantil;
import com.capas.uca.parcial3.repositorie.Poblacion_EstudiantilRepo;

public interface PoblacionEstudiantilService {
	
	public Poblacion_Estudiantil findOne(Integer id) throws DataAccessException;
}