package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Infraestructura;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Infraestructura.class)
public abstract class Infraestructura_ {

	public static volatile SingularAttribute<Infraestructura, Boolean> aula_apoyo_educativo;
	public static volatile SingularAttribute<Infraestructura, Boolean> cancha_basquetbol;
	public static volatile SingularAttribute<Infraestructura, Boolean> comedor;
	public static volatile SingularAttribute<Infraestructura, Boolean> centro_computo;
	public static volatile SingularAttribute<Infraestructura, CentroEscolar> fkCentroEscolar;
	public static volatile SingularAttribute<Infraestructura, Boolean> biblioteca;
	public static volatile SingularAttribute<Infraestructura, Boolean> laboratorio_ciencia;
	public static volatile SingularAttribute<Infraestructura, Boolean> talleres_bachillerato_industrial;
	public static volatile SingularAttribute<Infraestructura, Boolean> clinica_bachillerato_en_salud;
	public static volatile SingularAttribute<Infraestructura, Boolean> cancha_futbol;
	public static volatile SingularAttribute<Infraestructura, Boolean> cocina_bodigo;
	public static volatile SingularAttribute<Infraestructura, Boolean> area_administrativa;
	public static volatile SingularAttribute<Infraestructura, Boolean> clinica_para_estudiantes;
	public static volatile SingularAttribute<Infraestructura, Integer> idInfraestructura;
	public static volatile SingularAttribute<Infraestructura, Boolean> granja_agricola;
	public static volatile SingularAttribute<Infraestructura, Boolean> bodega;
	public static volatile SingularAttribute<Infraestructura, Boolean> salon_usos_multiples;
	public static volatile SingularAttribute<Infraestructura, Boolean> espacio_recreativo;
	public static volatile SingularAttribute<Infraestructura, Boolean> laboratorio_ingles;
	public static volatile SingularAttribute<Infraestructura, Boolean> sala_profesores;
	public static volatile SingularAttribute<Infraestructura, Boolean> cocina;

	public static final String AULA_APOYO_EDUCATIVO = "aula_apoyo_educativo";
	public static final String CANCHA_BASQUETBOL = "cancha_basquetbol";
	public static final String COMEDOR = "comedor";
	public static final String CENTRO_COMPUTO = "centro_computo";
	public static final String FK_CENTRO_ESCOLAR = "fkCentroEscolar";
	public static final String BIBLIOTECA = "biblioteca";
	public static final String LABORATORIO_CIENCIA = "laboratorio_ciencia";
	public static final String TALLERES_BACHILLERATO_INDUSTRIAL = "talleres_bachillerato_industrial";
	public static final String CLINICA_BACHILLERATO_EN_SALUD = "clinica_bachillerato_en_salud";
	public static final String CANCHA_FUTBOL = "cancha_futbol";
	public static final String COCINA_BODIGO = "cocina_bodigo";
	public static final String AREA_ADMINISTRATIVA = "area_administrativa";
	public static final String CLINICA_PARA_ESTUDIANTES = "clinica_para_estudiantes";
	public static final String ID_INFRAESTRUCTURA = "idInfraestructura";
	public static final String GRANJA_AGRICOLA = "granja_agricola";
	public static final String BODEGA = "bodega";
	public static final String SALON_USOS_MULTIPLES = "salon_usos_multiples";
	public static final String ESPACIO_RECREATIVO = "espacio_recreativo";
	public static final String LABORATORIO_INGLES = "laboratorio_ingles";
	public static final String SALA_PROFESORES = "sala_profesores";
	public static final String COCINA = "cocina";

}

