package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.EquipoXEscuela;

public interface EquipoXEscuelaRepo extends JpaRepository<EquipoXEscuela, Integer> {
	
	
	@Query(nativeQuery = true, value = "select * from EQUIPOXESCUELA where fkcentroescolar = ?1")
	public List<EquipoXEscuela>mostrarTodos(Integer centroEscolar) throws DataAccessException;
}
