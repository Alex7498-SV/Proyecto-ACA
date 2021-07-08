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
			+ " WHERE SE.instalacion_electrica=?1 AND "
			+ "funciona_instalacion_electrica = ?2 AND "
			+ "servicios_sanitarios = ?3 AND "
			+ "computadoras_estudiante = ?4 AND "
			+ "servicio_internet = ?5 AND "
			+ "biblioteca = ?6 AND "
			+ "centro_computo = ?7 AND "
			+ "laboratorio_ciencia = ?8 AND "
			+ "aula_apoyo_educativo = ?9 AND "
			+ "cancha_futbol  = ?10 AND "
			+ "cancha_basquetbol = ?11 AND "
			+ "laboratorio_ingles = ?12 AND "
			+ "granja_agricola = ?13 AND "
			+ "area_administrativa  = ?14 AND "
			+ "sala_profesores   = ?15 AND "
			+ "clinica_para_estudiantes = ?16 AND "
			+ "talleres_bachillerato_industrial = ?17 AND "
			+ "clinica_bachillerato_en_salud = ?18 AND "
			+ "salon_usos_multiples  = ?19 AND "
			+ "espacio_recreativo = ?20 AND "
			+ "comedor = ?21 AND "
			+ "bodega = ?22 AND "
			+ "cocina = ?23 AND "
			+ "cocina_bodigo = ?24 AND "
			+ "pasamanos = ?25 AND "
			+ "sanitariosespeciales = ?26 AND "
			+ "noposee = ?27 "
			+ " LIMIT 300 "
			
			)
	public List<CentroEscolar>filter(
			boolean arr1,boolean arr2,boolean arr3,boolean arr4,boolean arr5,
			boolean arr6,boolean arr7,boolean arr8,boolean arr9,boolean arr10,boolean arr11,
			boolean arr12,boolean arr13,boolean arr14,boolean arr15,boolean arr16,boolean arr17,
			boolean arr18,boolean arr19,boolean arr20,boolean arr21,boolean arr22,boolean arr23,
			boolean arr24,boolean arr25,boolean arr26,boolean arr27,boolean arr28
			) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select * from public.CENTRO_ESCOLAR where fkmunicipio = ?1")
	public List<CentroEscolar>findD(Integer centro) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select COUNT(*) from public.CENTRO_ESCOLAR where LOWER(nombre_escuela) like ?1%")
	public Integer countCE(String search) throws DataAccessException;
	

	
	
}
