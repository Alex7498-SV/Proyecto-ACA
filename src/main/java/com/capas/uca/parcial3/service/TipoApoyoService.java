package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.uca.parcial3.domain.TipoApoyo;

public interface TipoApoyoService {
	public List<TipoApoyo> findAll() throws DataAccessException;
}
