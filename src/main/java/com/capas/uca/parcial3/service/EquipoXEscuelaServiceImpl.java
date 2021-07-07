package com.capas.uca.parcial3.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.EquipoXEscuela;
import com.capas.uca.parcial3.repositorie.EquipoXEscuelaRepo;

public class EquipoXEscuelaServiceImpl implements EquipoXEscuelaService {

	@Autowired
	EquipoXEscuelaRepo repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Override
	public EquipoXEscuela findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return repo.getOne(code);
	}

}
