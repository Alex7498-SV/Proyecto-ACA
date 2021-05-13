package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	@Query(nativeQuery = true, value = "select * from public.Usuario where nombreUser= ?1 and contrasenia = ?2")
	public Usuario login(String user, String pass) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select * from usuario where LOWER(nombre) like ?1% OR LOWER(apellido) like ?1% OR LOWER(nombreuser) like ?1%")
	public Page<Usuario> mostrarTodo(String search, Pageable page) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select COUNT(*) from usuario where LOWER(nombre) like ?1% OR LOWER(apellido) like ?1% OR LOWER(nombreuser) like ?1%")
	public Integer countUser(String search) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select COUNT(*) from usuario where LOWER(nombreuser) = ?1")
	public Integer userExiste(String search) throws DataAccessException;
}
