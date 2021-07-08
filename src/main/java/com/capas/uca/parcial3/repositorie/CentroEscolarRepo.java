package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Municipio;

public interface CentroEscolarRepo extends JpaRepository<CentroEscolar, Integer> {
	
	@Query(nativeQuery = true, value = "select * from public.CENTRO_ESCOLAR where LOWER(nombre_escuela) like ?1%")
	public Page<CentroEscolar>mostrarTodos(String search, Pageable page) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select * from public.CENTRO_ESCOLAR where fkmunicipio = ?1")
	public List<CentroEscolar>findD(Integer centro) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select COUNT(*) from public.CENTRO_ESCOLAR where LOWER(nombre_escuela) like ?1%")
	public Integer countCE(String search) throws DataAccessException;
	
}
