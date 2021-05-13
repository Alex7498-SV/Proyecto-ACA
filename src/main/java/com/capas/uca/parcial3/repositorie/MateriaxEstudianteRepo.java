package com.capas.uca.parcial3.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.MateriaXestudiante;

public interface MateriaxEstudianteRepo extends JpaRepository<MateriaXestudiante, Integer> {
	

@Query(nativeQuery = true, value = "select * from public.MateriaxEstudiante")
	public List<MateriaXestudiante> mostrarTodos() throws DataAccessException;
	
	@Query(nativeQuery=true,value="select *  from public.materiaXestudiante mat, public.estudiante es, public.materia mate" + 
			" where mat.fkestudiante = es.idestudiante and mat.fkmateria = mate.idmateria and mat.fkestudiante = ?1")
	public List<MateriaXestudiante> mostrarUno(Integer code) throws DataAccessException;
	
	@Query(nativeQuery = true, 
			value = " select m.idmateriaxestudiante, m.fkestudiante, m.fkmateria ,ma.nombre, m.ciclo, m.anio, m.nota  from public.materiaxestudiante m, materia ma, estudiante e  "
					+ " where m.fkmateria = ma.idmateria and e.idestudiante = m.fkestudiante and  "
					+ " fkestudiante = ?1 ")
	public List<Object[]> nombreMateria(Integer code,Pageable page) throws DataAccessException;
	
	@Query(nativeQuery = true, 
			value = " select COUNT(m.fkestudiante) from public.materiaxestudiante m, materia ma, estudiante e  "
					+ " where m.fkmateria = ma.idmateria and e.idestudiante = m.fkestudiante and  "
					+ " fkestudiante = ?1 ")
	public Integer countMateria(Integer code) throws DataAccessException;
}
