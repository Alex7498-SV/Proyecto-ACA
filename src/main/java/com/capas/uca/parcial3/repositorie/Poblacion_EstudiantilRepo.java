package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.Poblacion_Estudiantil;

public interface Poblacion_EstudiantilRepo extends JpaRepository<Poblacion_Estudiantil, Integer>{
	
	@Query(nativeQuery = true, value = "select * from public.poblacion_estudiantil")
	public List<Poblacion_Estudiantil> MostrarPoblacion() throws DataAccessException;
}