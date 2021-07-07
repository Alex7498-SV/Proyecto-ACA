package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Necesidades;
import com.capas.uca.parcial3.repositorie.NecesidadesRepo;

@Service
public class NecesidadesServiceImpl implements NecesidadesService{

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Autowired
	NecesidadesRepo Repo;
	
	@Override
	public Necesidades findOneN(Integer id) throws DataAccessException {
		return Repo.findN(id);
	}
	
}
