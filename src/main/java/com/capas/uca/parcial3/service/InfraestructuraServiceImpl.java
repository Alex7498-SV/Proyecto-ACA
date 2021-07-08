package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Infraestructura;
import com.capas.uca.parcial3.domain.Necesidades;
import com.capas.uca.parcial3.repositorie.InfraestructuraRepo;

@Service
public class InfraestructuraServiceImpl implements InfraestructuraService{

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Autowired
	InfraestructuraRepo Repo;
	
	@Override
	public Infraestructura findOneS(Integer id) throws DataAccessException {
		return Repo.findI(id);
	}
	
}
