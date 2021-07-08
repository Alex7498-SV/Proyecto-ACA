package com.capas.uca.parcial3.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Servicio;
import com.capas.uca.parcial3.repositorie.CentroEscolarRepo;

@Service
public class CentroEscolarServiceImpl implements CentroEscolarService{
	
	@Autowired
	CentroEscolarRepo Repo;
	
	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
	    
		
		return Repo.findAll();
	}

	@Override
	public CentroEscolar findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public void insertAndUpdate(CentroEscolar centroEscolar) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(centroEscolar);
	}

	@Override
	public Page<CentroEscolar> findAll(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos(search, page);
	}

	@Override
	public List<CentroEscolar> findCentroEscolar(Integer centro) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findD(centro);
	}

	@Override
	public Integer countCE(String search) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countCE(search);
	}
	/*
	@Override
	public List<CentroEscolar> filter(String search) throws DataAccessException {
		// TODO Auto-generated method stub
		
		 List<Predicate> list = new ArrayList<Predicate>();
		 
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		
		 CriteriaQuery<Servicio> criteriaQuery = criteriaBuilder.createQuery(Servicio.class);
		 Root<Servicio> itemRoot = criteriaQuery.from(Servicio.class);

		// servicios_sanitarios
		 list.add(criteriaBuilder.equal(itemRoot.get("instalacion_electrica"), "false"));
		 list.add(criteriaBuilder.equal(itemRoot.get("servicios_sanitarios"), "true"));
		 
		 Predicate[] p = new Predicate[list.size()];
		 Predicate finalPredicate = criteriaBuilder.and(list.toArray(p));
		 


		// Predicate finalPredicate
		 //  = criteriaBuilder.and(predicateForBlueColorAndGradeA, predicateForRedColorAndGradeB);
		 
		 criteriaQuery.where(finalPredicate);
		// criteriaBuilder.que
		 
	//	criteriaQuery.select(itemRoot.get("fkCentroEscolar"));

		    // Select * from A where aid not in ()
		    CriteriaQuery<CentroEscolar> aQuery = criteriaBuilder.createQuery(CentroEscolar.class);
		    Root<CentroEscolar> aRoot = aQuery.from(CentroEscolar.class);
		    
		    
		   // aQuery.where((aRoot.<Integer>get("idCentroEscolar").in(criteriaQuery)));

		    TypedQuery<CentroEscolar> query = entityManager.createQuery(aQuery);
		    List<CentroEscolar> result = query.getResultList();
	    
		return result;
	}
	*/

	@Override
	public List<CentroEscolar> filter(boolean arr1, boolean arr2, boolean arr3, boolean arr4, boolean arr5,
			boolean arr6, boolean arr7, boolean arr8, boolean arr9, boolean arr10, boolean arr11, boolean arr12,
			boolean arr13, boolean arr14, boolean arr15, boolean arr16, boolean arr17, boolean arr18, boolean arr19,
			boolean arr20, boolean arr21, boolean arr22, boolean arr23, boolean arr24, boolean arr25, boolean arr26,
			boolean arr27, boolean arr28) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.filter(arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21, arr22, arr23, arr24, arr25, arr26, arr27, arr28);
	}
}
