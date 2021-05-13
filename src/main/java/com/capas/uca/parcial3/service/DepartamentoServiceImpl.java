package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.repositorie.DepartamentoRepo;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	DepartamentoRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public List<Departamento> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos();
	}

	@Override
	public Departamento findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public void insertAndUpdate(Departamento departamento) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(departamento);
	}
}
