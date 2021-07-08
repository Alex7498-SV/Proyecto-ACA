package com.capas.uca.parcial3.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capas.uca.parcial3.domain.CentroEscolar;


public interface CentroEscolarService {
	
	public List<CentroEscolar> findAll() throws DataAccessException;
	List<CentroEscolar> findCentroEscolar(Integer centro) throws DataAccessException;
	public Page<CentroEscolar> findAll(String search, Pageable page) throws DataAccessException;
	
	public CentroEscolar findOne(Integer code) throws DataAccessException;
	
	public void insertAndUpdate(CentroEscolar centroEscolar) throws DataAccessException;
	
	public Integer countCE(String search) throws DataAccessException;
	
	//public List<CentroEscolar> filter(String search) throws DataAccessException;
	
	public List<CentroEscolar>filter(
			boolean arr1,boolean arr2,boolean arr3,boolean arr4,boolean arr5,
			boolean arr6,boolean arr7,boolean arr8,boolean arr9,boolean arr10,boolean arr11,
			boolean arr12,boolean arr13,boolean arr14,boolean arr15,boolean arr16,boolean arr17,
			boolean arr18,boolean arr19,boolean arr20,boolean arr21,boolean arr22,boolean arr23,
			boolean arr24,boolean arr25,boolean arr26,boolean arr27,boolean arr28
			) throws DataAccessException;

}
