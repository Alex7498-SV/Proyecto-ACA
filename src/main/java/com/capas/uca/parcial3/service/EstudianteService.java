package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capas.uca.parcial3.domain.Estudiante;
import com.capas.uca.parcial3.domain.Materia;

public interface EstudianteService {
	
	public List<Estudiante> findAll() throws DataAccessException;
	public List<Estudiante> findByApel(String cadena) throws DataAccessException;
	public List<Estudiante> findByName(String cadena) throws DataAccessException;
	public List<Estudiante> findByNameAndApel(String cadena, String cadena2) throws DataAccessException;

	public Estudiante findOne(Integer code) throws DataAccessException;

	public void insertAndUpdate(Estudiante estudiante) throws DataAccessException;
	
	public Page<Estudiante> findAll(Pageable page) throws DataAccessException;
	
	public Long countAll();
	
	public Estudiante findByName2(Integer id) throws DataAccessException;
	
	public Integer countAlumno(String cadena, String cadena2) throws DataAccessException;
}
