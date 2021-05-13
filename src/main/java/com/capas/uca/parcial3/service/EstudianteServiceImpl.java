package com.capas.uca.parcial3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capas.uca.parcial3.domain.Estudiante;
import com.capas.uca.parcial3.repositorie.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	EstudianteRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos();
	}


	@Override
	public List<Estudiante> findByApel(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findByApellidoStartingWith(cadena);
	}

	@Override
	public List<Estudiante> findByNameAndApel(String cadena, String cadena2) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findByNombreAndApellido(cadena, cadena2);
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	@Transactional
	public void insertAndUpdate(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(estudiante);
		
	}

	@Override
	public List<Estudiante> findByName(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findByNombreStartingWith(cadena);
	}


	@Override
	public Page<Estudiante> findAll(Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findAll(page);
	}


	@Override
	public Long countAll() {
		// TODO Auto-generated method stub
		return Repo.count();
	}


	@Override
	public Estudiante findByName2(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(id);
	}


	@Override
	public Integer countAlumno(String cadena, String cadena2) throws DataAccessException {
		return Repo.counAlumno(cadena, cadena2); 
	}

	


}
