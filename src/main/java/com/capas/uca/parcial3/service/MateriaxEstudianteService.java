package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capas.uca.parcial3.domain.MateriaXestudiante;
import com.capas.uca.parcial3.dto.CursadasDTO;
import com.capas.uca.parcial3.dto.ResutDTO;

public interface MateriaxEstudianteService {

	public List<MateriaXestudiante> findAll() throws DataAccessException;
	public List<MateriaXestudiante> findcode(Integer code) throws DataAccessException;
	Page<ResutDTO> dtoPrueba(String nombre, String apellido, Pageable page) throws DataAccessException;
	Page<CursadasDTO> dtoCursadas(Integer code,Pageable page) throws DataAccessException;
	 
	public void insertAndUpdate(MateriaXestudiante materiaAlumno) throws DataAccessException;
	
	public MateriaXestudiante findOne(Integer id) throws DataAccessException;
	
	public Integer countMateriaAlumno(Integer id) throws DataAccessException;
}
