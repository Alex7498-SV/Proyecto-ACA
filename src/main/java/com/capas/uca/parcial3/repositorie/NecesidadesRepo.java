package com.capas.uca.parcial3.repositorie;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Necesidades;

public interface NecesidadesRepo extends JpaRepository<Necesidades, Integer> {
	@Query(nativeQuery = true, value = "select * from NECESIDADES_ESPECIALES WHERE fkcentroescolar = ?1")
	public Necesidades findN(Integer centroEscolar) throws DataAccessException;
}
