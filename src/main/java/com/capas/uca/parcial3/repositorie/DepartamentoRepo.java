package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Departamento;

public interface DepartamentoRepo extends JpaRepository<Departamento, Integer> {
	
	@Query(nativeQuery = true, value = "select * from public.Departamento")
	public List<Departamento>mostrarTodos() throws DataAccessException;
}
