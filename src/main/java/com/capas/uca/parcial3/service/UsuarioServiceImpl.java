package com.capas.uca.parcial3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Usuario;
import com.capas.uca.parcial3.repositorie.UsuarioRepo;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public Page<Usuario> findAll(Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findAll(page); 
	}

	@Override
	public Usuario findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public void insertAndUpdate(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(usuario);
	}
	
	@Override
	public Usuario login(String user, String pass) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.login(user, pass);
	}

	@Override
	public Integer countUser(String search) throws DataAccessException {
		return Repo.countUser(search);
	}

	@Override
	public Page<Usuario> mostrarTodo(String search, Pageable page) throws DataAccessException {
		return Repo.mostrarTodo(search, page);
	}

	@Override
	public Usuario obtenerOne(Integer id) throws DataAccessException {
		return Repo.getOne(id);
	}
	
	@Override
	public Integer userExiste(String id) throws DataAccessException {
		return Repo.userExiste(id);
	}
	
}
