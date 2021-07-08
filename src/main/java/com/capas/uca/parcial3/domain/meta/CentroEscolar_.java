package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Municipio;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CentroEscolar.class)
public abstract class CentroEscolar_ {

	public static volatile SingularAttribute<CentroEscolar, Double> latitud;
	public static volatile SingularAttribute<CentroEscolar, String> nombre_escolar;
	public static volatile SingularAttribute<CentroEscolar, String> correo_electronico;
	public static volatile SingularAttribute<CentroEscolar, String> numero_fax;
	public static volatile SingularAttribute<CentroEscolar, Municipio> municipio;
	public static volatile SingularAttribute<CentroEscolar, Integer> numero_aula_total;
	public static volatile SingularAttribute<CentroEscolar, Integer> numero_otros_espacios_total;
	public static volatile SingularAttribute<CentroEscolar, Boolean> zona;
	public static volatile SingularAttribute<CentroEscolar, Double> longitud;
	public static volatile SingularAttribute<CentroEscolar, String> nip;
	public static volatile SingularAttribute<CentroEscolar, String> numero_telefonico;
	public static volatile SingularAttribute<CentroEscolar, String> Direccion;
	public static volatile SingularAttribute<CentroEscolar, Boolean> sector;
	public static volatile SingularAttribute<CentroEscolar, Integer> idCentroEscolar;

	public static final String LATITUD = "latitud";
	public static final String NOMBRE_ESCOLAR = "nombre_escolar";
	public static final String CORREO_ELECTRONICO = "correo_electronico";
	public static final String NUMERO_FAX = "numero_fax";
	public static final String MUNICIPIO = "municipio";
	public static final String NUMERO_AULA_TOTAL = "numero_aula_total";
	public static final String NUMERO_OTROS_ESPACIOS_TOTAL = "numero_otros_espacios_total";
	public static final String ZONA = "zona";
	public static final String LONGITUD = "longitud";
	public static final String NIP = "nip";
	public static final String NUMERO_TELEFONICO = "numero_telefonico";
	public static final String DIRECCION = "Direccion";
	public static final String SECTOR = "sector";
	public static final String ID_CENTRO_ESCOLAR = "idCentroEscolar";

}

