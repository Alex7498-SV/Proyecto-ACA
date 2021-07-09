package com.capas.uca.parcial3.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Infraestructura;
import com.capas.uca.parcial3.domain.Necesidades;
import com.capas.uca.parcial3.domain.Servicio;
import com.capas.uca.parcial3.domain.meta.CentroEscolar_;
import com.capas.uca.parcial3.domain.meta.Infraestructura_;
import com.capas.uca.parcial3.domain.meta.Necesidades_;
import com.capas.uca.parcial3.domain.meta.Servicio_;
import com.capas.uca.parcial3.dto.filtroDTO;

public final class CentroEscolarSpec {

	private CentroEscolarSpec() {
	}

	public static Specification<CentroEscolar> filterCE(filtroDTO filtro) {
		/*
		 * if (CollectionUtils.isEmpty(categories)) { return null; }
		 */
		return (root, query, builder) -> {

			Join<CentroEscolar, Infraestructura> CentroInfraJoin = root.join("infraestructura");
			Join<CentroEscolar, Servicio> CentroServicioInfJoin = root.join("servicio");
			Join<CentroEscolar, Necesidades> CentroNecesidades = root.join("necesidades");
			// Join<CentroEscolar, Necesidades>
			// CentroNecesiSIJoin.join(Infraestructura_.FK_CENTRO_ESCOLAR);

			List<Predicate> list = new ArrayList<Predicate>();

			Boolean filter = null;

			// servicio filters
			if (!(filtro.getFil1() == null)) {
				list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.INSTALACION_ELECTRICA),
						filtro.toBool(filtro.getFil1())));
			}
			/*
			 * if(true) { list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.
			 * FUNCIONA_INSTALACION_ELECTRICA),false )); }
			 */
			if (!(filtro.getFil2() == null)) {
				list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.SERVICIOS_SANITARIOS),
						filtro.toBool(filtro.getFil2())));
			}
			if (!(filtro.getFil3() == null)) {
				list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.COMPUTADORAS_ESTUDIANTE),
						filtro.toBool(filtro.getFil3())));
			}
			if (!(filtro.getFil4() == null)) {
				list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.SERVICIO_INTERNET),
						filtro.toBool(filtro.getFil4())));
			}

			// Necesidades filters
			if (!(filtro.getFil5() == null)) {
				list.add(builder.equal(CentroNecesidades.get(Necesidades_.RAMPA), filtro.toBool(filtro.getFil5())));
			}
			if (!(filtro.getFil6() == null)) {
				list.add(builder.equal(CentroNecesidades.get(Necesidades_.PASAMANOS), filtro.toBool(filtro.getFil6())));
			}
			if (!(filtro.getFil7() == null)) {
				list.add(builder.equal(CentroNecesidades.get(Necesidades_.SANITARIOS_ESPECIALES),
						filtro.toBool(filtro.getFil7())));
			}
			if (!(filtro.getFil8() == null)) {
				list.add(builder.equal(CentroNecesidades.get(Necesidades_.NO_POSEE), filtro.toBool(filtro.getFil8())));
			}

			// infraestructura filters
			if (!(filtro.getFil9() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.BIBLIOTECA),
						filtro.toBool(filtro.getFil9())));
			}

			if (!(filtro.getFil10() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CENTRO_COMPUTO),
						filtro.toBool(filtro.getFil10())));
			}

			if (!(filtro.getFil11() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.LABORATORIO_CIENCIA),
						filtro.toBool(filtro.getFil11())));
			}
			if (!(filtro.getFil12() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.AULA_APOYO_EDUCATIVO),
						filtro.toBool(filtro.getFil12())));
			}
			if (!(filtro.getFil13() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CANCHA_FUTBOL),
						filtro.toBool(filtro.getFil13())));
			}
			if (!(filtro.getFil14() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CANCHA_BASQUETBOL),
						filtro.toBool(filtro.getFil14())));
			}
			if (!(filtro.getFil15() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.LABORATORIO_INGLES),
						filtro.toBool(filtro.getFil15())));
			}
			if (!(filtro.getFil16() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.GRANJA_AGRICOLA),
						filtro.toBool(filtro.getFil16())));
			}
			if (!(filtro.getFil17() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.AREA_ADMINISTRATIVA),
						filtro.toBool(filtro.getFil17())));
			}
			if (!(filtro.getFil18() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.SALA_PROFESORES),
						filtro.toBool(filtro.getFil18())));
			}
			if (!(filtro.getFil19() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CLINICA_PARA_ESTUDIANTES),
						filtro.toBool(filtro.getFil19())));
			}
			if (!(filtro.getFil20() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.TALLERES_BACHILLERATO_INDUSTRIAL),
						filtro.toBool(filtro.getFil20())));
			}
			if (!(filtro.getFil21() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CLINICA_BACHILLERATO_EN_SALUD),
						filtro.toBool(filtro.getFil21())));
			}
			if (!(filtro.getFil22() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.SALON_USOS_MULTIPLES),
						filtro.toBool(filtro.getFil22())));
			}
			if (!(filtro.getFil23() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.ESPACIO_RECREATIVO),
						filtro.toBool(filtro.getFil23())));
			}
			if (!(filtro.getFil24() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.COMEDOR), filtro.toBool(filtro.getFil24())));
			}
			if (!(filtro.getFil25() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.BODEGA), filtro.toBool(filtro.getFil25())));
			}

			if (!(filtro.getFil26() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.COCINA), filtro.toBool(filtro.getFil26())));
			}

			if (!(filtro.getFil27() == null)) {
				list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.COCINA_BODIGO),
						filtro.toBool(filtro.getFil27())));
			}

			Predicate[] p = new Predicate[list.size()];

			return builder.and(list.toArray(p));
		};
	}
}