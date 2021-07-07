package com.capas.uca.parcial3.service;

import org.springframework.dao.DataAccessException;
import java.util.List;

import com.capas.uca.parcial3.domain.EquipoXEscuela;

public interface EquipoXEscuelaService {
	public List<EquipoXEscuela> findOne(Integer code) throws DataAccessException;
}
