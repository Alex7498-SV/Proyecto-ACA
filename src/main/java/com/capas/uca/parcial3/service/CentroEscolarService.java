package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Estudiante;
import com.capas.uca.parcial3.domain.Materia;


public interface CentroEscolarService {
	
	public List<CentroEscolar> findAll() throws DataAccessException;
	List<CentroEscolar> findCentroEscolar(Integer centro) throws DataAccessException;
	public Page<CentroEscolar> findAll(String search, Pageable page) throws DataAccessException;
	
	public CentroEscolar findOne(Integer code) throws DataAccessException;
	
	public void insertAndUpdate(CentroEscolar centroEscolar) throws DataAccessException;
	
	public Integer countCE(String search) throws DataAccessException;

}
