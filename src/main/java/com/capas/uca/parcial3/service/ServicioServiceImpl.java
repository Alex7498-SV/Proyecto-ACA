package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Servicio;
import com.capas.uca.parcial3.repositorie.ServicioRepo;

@Service
public class ServicioServiceImpl implements ServicioService{

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Autowired
	ServicioRepo Repo;

	@Override
	public Servicio findOneS(Integer id) throws DataAccessException {
		return Repo.findS(id);
	}
	
}
