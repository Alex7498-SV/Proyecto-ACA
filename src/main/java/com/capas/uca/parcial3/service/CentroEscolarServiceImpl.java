package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.repositorie.CentroEscolarRepo;

@Service
public class CentroEscolarServiceImpl implements CentroEscolarService{
	
	@Autowired
	CentroEscolarRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findAll();
	}

	@Override
	public CentroEscolar findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public void insertAndUpdate(CentroEscolar centroEscolar) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(centroEscolar);
	}

	@Override
	public Page<CentroEscolar> findAll(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos(search, page);
	}

	@Override
	public List<CentroEscolar> findCentroEscolar(Integer centro) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findD(centro);
	}

	@Override
	public Integer countCE(String search) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countCE(search);
	}
}
