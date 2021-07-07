package com.capas.uca.parcial3.service;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.EquipoXEscuela;
import com.capas.uca.parcial3.repositorie.EquipoXEscuelaRepo;

@Service
public class EquipoXEscuelaServiceImpl implements EquipoXEscuelaService {

	@Autowired
	EquipoXEscuelaRepo repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;
	
	@Override
	public List<EquipoXEscuela> findOne(Integer code) throws DataAccessException {
		return repo.mostrarTodos(code);
	}

}
