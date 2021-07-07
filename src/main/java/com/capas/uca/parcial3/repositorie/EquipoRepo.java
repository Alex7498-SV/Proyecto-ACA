package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Equipo;

public interface EquipoRepo extends JpaRepository<Equipo, Integer>{
	
	@Query(nativeQuery = true, value = "select * from public.Equipo")
	public List<Equipo> mostrarEquipos() throws DataAccessException;
}