package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Apoyoxescuela;
import com.capas.uca.parcial3.repositorie.ApoyoxescuelaRepo;

@Service
public class ApoyoxescuelaServiceImpl implements ApoyoxescuelaService{

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Autowired
	ApoyoxescuelaRepo Repo;
	
	@Override
	public List<Apoyoxescuela> findAll() throws DataAccessException {


	    
		return Repo.findAll();
	}

	@Override
	public List<Apoyoxescuela> buscarTipoApoyo(Integer tipoApoyo, Integer centroEscolar) throws DataAccessException {
		return Repo.findTE(tipoApoyo, centroEscolar); 
	}
	
}
