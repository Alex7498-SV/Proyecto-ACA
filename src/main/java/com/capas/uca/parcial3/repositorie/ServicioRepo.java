package com.capas.uca.parcial3.repositorie;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Servicio;

public interface ServicioRepo extends JpaRepository<Servicio, Integer> {
	@Query(nativeQuery = true, value = "select * from SERVICIOS_ESCUELA WHERE fkcentroescolar = ?1")
	public Servicio findS(Integer centroEscolar) throws DataAccessException;
}
