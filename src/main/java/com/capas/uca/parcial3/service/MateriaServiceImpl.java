package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Materia;
import com.capas.uca.parcial3.repositorie.MateriaRepo;

@Service
public class MateriaServiceImpl implements MateriaService {
	
	@Autowired
	MateriaRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public Page<Materia> findAll(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos(search, page);
	}

	@Override
	public Materia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public void insertAndUpdate(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(materia);
	}

	@Override
	public Page<Materia> findAll(Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findAll(page);
	}

	@Override
	public Integer countAll(String search) {
		// TODO Auto-generated method stub
		return Repo.countM(search);
	}

	@Override
	public Long countAll2() {
		// TODO Auto-generated method stub
		return Repo.count();
	}

	@Override
	public List<Materia> showSubjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarMaterias();
	}
	
	
}
