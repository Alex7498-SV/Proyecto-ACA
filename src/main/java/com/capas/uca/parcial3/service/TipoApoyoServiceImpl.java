package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.TipoApoyo;
import com.capas.uca.parcial3.repositorie.TipoApoyoRepo;

@Service
public class TipoApoyoServiceImpl implements TipoApoyoService {

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Autowired
	TipoApoyoRepo Repo;
	
	@Override
	public List<TipoApoyo> findAll() throws DataAccessException {
		return Repo.findAll();
	}

}
