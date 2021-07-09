package com.capas.uca.parcial3.repositorie;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Municipio;

public interface CentroEscolarRepo extends JpaRepository<CentroEscolar, Integer> {
	
	@Query(nativeQuery = true, value = "select * from public.CENTRO_ESCOLAR where LOWER(nombre_escuela) like ?1%")
	public Page<CentroEscolar>mostrarTodos(String search, Pageable page) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select CE.* from public.CENTRO_ESCOLAR CE JOIN servicios_escuela SE on CE.idcentroescolar = SE.fkcentroescolar "
			+ " JOIN infraestructura I on CE.idcentroescolar = I.fkcentroescolar JOIN necesidades_especiales NE on CE.idcentroescolar = NE.fkcentroescolar "
			+ " WHERE SE.instalacion_electrica=?1 OR "
			+ "servicios_sanitarios = ?2 OR "
			+ "computadoras_estudiante = ?3 OR "
			+ "servicio_internet = ?4 OR "
			+ "biblioteca = ?5 OR "
			+ "centro_computo = ?6 OR "
			+ "laboratorio_ciencia = ?7 OR "
			+ "aula_apoyo_educativo = ?8 OR "
			+ "cancha_futbol  = ?9 OR "
			+ "cancha_basquetbol = ?10 OR "
			+ "laboratorio_ingles = ?11 OR "
			+ "granja_agricola = ?12 OR "
			+ "area_administrativa  = ?13 OR "
			+ "sala_profesores   = ?14 OR "
			+ "clinica_para_estudiantes = ?15 OR "
			+ "talleres_bachillerato_industrial = ?16 OR "
			+ "clinica_bachillerato_en_salud = ?17 OR "
			+ "salon_usos_multiples  = ?18 OR "
			+ "espacio_recreativo = ?19 OR "
			+ "comedor = ?20 OR "
			+ "bodega = ?21 OR "
			+ "cocina = ?22 OR "
			+ "cocina_bodigo = ?23 OR "
			+ "pasamanos = ?24 OR "
			+ "sanitariosespeciales = ?25 OR "
			+ "rampa = ?26 OR "
			+ "noposee = ?27 "
			+ " LIMIT 300 "
			
			)
	public List<CentroEscolar>filter(
			boolean arr1,boolean arr2,boolean arr3,boolean arr4,boolean arr5,
			boolean arr6,boolean arr7,boolean arr8,boolean arr9,boolean arr10,boolean arr11,
			boolean arr12,boolean arr13,boolean arr14,boolean arr15,boolean arr16,boolean arr17,
			boolean arr18,boolean arr19,boolean arr20,boolean arr21,boolean arr22,boolean arr23,
			boolean arr24,boolean arr25,boolean arr26,boolean arr27
			) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select * from public.CENTRO_ESCOLAR where fkmunicipio = ?1")
	public List<CentroEscolar>findD(Integer centro) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select COUNT(*) from public.CENTRO_ESCOLAR where LOWER(nombre_escuela) like ?1%")
	public Integer countCE(String search) throws DataAccessException;
	

	
	
}
