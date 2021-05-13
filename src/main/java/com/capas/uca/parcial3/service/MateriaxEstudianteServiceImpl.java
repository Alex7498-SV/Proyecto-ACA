package com.capas.uca.parcial3.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capas.uca.parcial3.domain.Estudiante;
import com.capas.uca.parcial3.domain.MateriaXestudiante;
import com.capas.uca.parcial3.dto.CursadasDTO;
import com.capas.uca.parcial3.dto.ResutDTO;
import com.capas.uca.parcial3.repositorie.EstudianteRepo;
import com.capas.uca.parcial3.repositorie.MateriaxEstudianteRepo;

@Service
public class MateriaxEstudianteServiceImpl implements MateriaxEstudianteService {

	@Autowired
	MateriaxEstudianteRepo Repo;
	@Autowired
	EstudianteRepo Repo2;

	@Autowired
	EstudianteRepo RepoE;

	@PersistenceContext(unitName = "capas2")
	EntityManager entityManager;

	@Override
	public List<MateriaXestudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodos();
	}

	@Override
	public List<MateriaXestudiante> findcode(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarUno(code);
	}

	@Override
	public Page<ResutDTO> dtoPrueba(String nombre, String apellido, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		List<ResutDTO> estudiantes = Repo2.pruebaDTO(nombre, apellido, page).stream().map(obj -> {
			ResutDTO e = new ResutDTO();
			List<MateriaXestudiante> k = null;
			k= Repo.mostrarUno(Integer.parseInt(obj[0].toString()));
			Integer reprobado =0, aprobado =0;
			float promedio=0;
			for(int i =0; i < k.size();i++) {
				if(k.get(i).getNota()>=6) {
					aprobado++;
				}
				else {
					reprobado++;
				}
				promedio += k.get(i).getNota();
			}
			float total = 0;
			if((aprobado+reprobado) != 0) {
				total = promedio/(aprobado+reprobado);
			}
			e.setId(Integer.parseInt(obj[0].toString()));
			e.setNombre(obj[1].toString());
			e.setApellido(obj[2].toString());
			e.setAprobadas(aprobado);
			e.setReprobadas(reprobado);
			e.setProm(total);
			return e;
		}).collect(Collectors.toList());
		Page<ResutDTO> page2 = new PageImpl<>(estudiantes);
		return page2; 
	}
	
	@Override
	public Page<CursadasDTO> dtoCursadas(Integer code,Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		List<CursadasDTO> cursadas = Repo.nombreMateria(code, page).stream().map(obj -> {
			CursadasDTO e = new CursadasDTO();
			List<MateriaXestudiante> k = null;
			k= Repo.mostrarUno(Integer.parseInt(obj[0].toString()));
			
			e.setIdMateriaXestudiante(Integer.parseInt(obj[0].toString()));
			e.setIdestudiante(Integer.parseInt(obj[1].toString()));
			e.setIdmateria(Integer.parseInt(obj[2].toString()));
			e.setNombremateria(obj[3].toString());
			e.setCiclo(Integer.parseInt(obj[4].toString()));
			e.setAnio(Integer.parseInt(obj[5].toString()));
			e.setNota(Float.parseFloat(obj[6].toString()));
			return e;
		}).collect(Collectors.toList());
		Page<CursadasDTO> page2 = new PageImpl<>(cursadas);
		return page2;
	}
	
	@Override
	public void insertAndUpdate(MateriaXestudiante materiaAlumno) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(materiaAlumno);
		
	}

	@Override
	public MateriaXestudiante findOne(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(id);
	}

	@Override
	public Integer countMateriaAlumno(Integer id) throws DataAccessException {
		return Repo.countMateria(id);
	} 

}
