package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Municipio;

public interface MunicipioRepo extends JpaRepository<Municipio, Integer> {
	
	@Query(nativeQuery = true, value = "select * from public.Municipio")
	public List<Municipio>mostrarTodos() throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select * from public.Municipio where fkdepartamento = ?1")
	public List<Municipio>findD(Integer departamento) throws DataAccessException;
}
