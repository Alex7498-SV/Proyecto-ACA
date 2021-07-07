package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.Apoyo;

public interface ApoyoService {
	public List<Apoyo> findAll() throws DataAccessException;
}
