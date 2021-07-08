package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Apoyoxescuela;

public interface ApoyoxescuelaRepo extends JpaRepository<Apoyoxescuela, Integer>{
	@Query(nativeQuery = true, value = "Select * from APOYOXESCUELA where fktipoapoyo = ?1 and fkcentroescolar = ?2")
	public List<Apoyoxescuela>findTE(Integer tipoApoyo, Integer centroEscolar) throws DataAccessException;
}
