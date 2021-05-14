package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capas.uca.parcial3.domain.Usuario;

public interface UsuarioService {

	public Usuario findOne(Integer code) throws DataAccessException;

	public void insertAndUpdate(Usuario usuario) throws DataAccessException;

	Usuario login(String user, String pass) throws DataAccessException;

	Page<Usuario> findAll(org.springframework.data.domain.Pageable page) throws DataAccessException;
	
	public Integer countUser(String search) throws DataAccessException;
	
	public Page<Usuario> mostrarTodo(String search, Pageable page) throws DataAccessException;
	
	public Usuario obtenerOne(Integer id) throws DataAccessException;

	Integer userExiste(String id) throws DataAccessException;
	
}
