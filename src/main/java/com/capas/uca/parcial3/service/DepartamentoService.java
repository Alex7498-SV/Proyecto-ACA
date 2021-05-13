package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> findAll() throws DataAccessException;
	public Departamento findOne(Integer code) throws DataAccessException;

	public void insertAndUpdate(Departamento departamento) throws DataAccessException;
}
