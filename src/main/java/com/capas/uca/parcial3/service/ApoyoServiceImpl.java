package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Apoyo;
import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.repositorie.ApoyoRepo;

@Service
public class ApoyoServiceImpl implements ApoyoService{

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Autowired
	ApoyoRepo Repo;
	
	@Override
	public List<Apoyo> findAll() throws DataAccessException {
		return Repo.findAll();
	}

}
