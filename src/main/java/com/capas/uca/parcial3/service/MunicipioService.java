package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Municipio;

public interface MunicipioService {
	
	public List<Municipio> findAll() throws DataAccessException;
	public Municipio findOne(Integer code) throws DataAccessException;

	public void insertAndUpdate(Municipio municipio) throws DataAccessException;
	List<Municipio> findDepartamento(Integer depa) throws DataAccessException; 
}
