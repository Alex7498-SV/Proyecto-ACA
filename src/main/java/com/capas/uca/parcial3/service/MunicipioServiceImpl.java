package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.repositorie.MunicipioRepo;

@Service
public class MunicipioServiceImpl implements MunicipioService {
	
	@Autowired
	MunicipioRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public List<Municipio> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos();
	}

	@Override
	public Municipio findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public void insertAndUpdate(Municipio municipio) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(municipio);
	}
	
	@Override
	public List<Municipio> findDepartamento(Integer depa) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findD(depa);
	}
}
