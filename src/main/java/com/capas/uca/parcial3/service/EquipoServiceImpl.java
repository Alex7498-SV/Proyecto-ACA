package com.capas.uca.parcial3.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Equipo;
import com.capas.uca.parcial3.repositorie.EquipoRepo;

public class EquipoServiceImpl implements EquipoService{
	
	@Autowired
	EquipoRepo Erepo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public Equipo findOne(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return Erepo.getOne(id);
	}
	
}