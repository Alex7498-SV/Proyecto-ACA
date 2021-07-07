package com.capas.uca.parcial3.repositorie;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Infraestructura;

public interface InfraestructuraRepo extends JpaRepository<Infraestructura, Integer> {
	@Query(nativeQuery = true, value = "select * from INFRAESTRUCTURA where fkcentroescolar = ?1")
	public Infraestructura findI(Integer centroEscolar) throws DataAccessException;
}
