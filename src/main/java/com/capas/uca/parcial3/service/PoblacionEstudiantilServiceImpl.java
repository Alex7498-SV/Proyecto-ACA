package com.capas.uca.parcial3.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Poblacion_Estudiantil;
import com.capas.uca.parcial3.repositorie.Poblacion_EstudiantilRepo;

public class PoblacionEstudiantilServiceImpl implements PoblacionEstudiantilService{
	
	@Autowired
	Poblacion_EstudiantilRepo repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public Poblacion_Estudiantil findOne(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}
}