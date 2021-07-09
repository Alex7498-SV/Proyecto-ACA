package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Servicio;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Servicio.class)
public abstract class Servicio_ {

	public static volatile SingularAttribute<Servicio, Integer> idApoyo;
	public static volatile SingularAttribute<Servicio, CentroEscolar> fkCentroEscolar;
	public static volatile SingularAttribute<Servicio, Boolean> servicios_sanitarios;
	public static volatile SingularAttribute<Servicio, Boolean> instalacion_electrica;
	public static volatile SingularAttribute<Servicio, Boolean> servicio_internet;
	public static volatile SingularAttribute<Servicio, Boolean> funciona_instalacion_electrica;
	public static volatile SingularAttribute<Servicio, Boolean> computadoras_estudiante;

	public static final String ID_APOYO = "idApoyo";
	public static final String FK_CENTRO_ESCOLAR = "fkCentroEscolar";
	public static final String SERVICIOS_SANITARIOS = "servicios_sanitarios";
	public static final String INSTALACION_ELECTRICA = "instalacion_electrica";
	public static final String SERVICIO_INTERNET = "servicio_internet";
	public static final String FUNCIONA_INSTALACION_ELECTRICA = "funciona_instalacion_electrica";
	public static final String COMPUTADORAS_ESTUDIANTE = "computadoras_estudiante";

}

