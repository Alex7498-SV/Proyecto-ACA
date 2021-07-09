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

public final class CentroEscolarSpec {

    private CentroEscolarSpec() {
    }

    public static Specification<CentroEscolar> filterCE() {
    	/*
        if (CollectionUtils.isEmpty(categories)) {
            return null;
        }
        */
        return (root, query, builder) -> {
        	
        	
            Join<CentroEscolar,Infraestructura> CentroInfraJoin = root.join("infraestructura");
            Join<CentroEscolar, Servicio> CentroServicioInfJoin = root.join("servicio");
            Join<CentroEscolar, Necesidades> CentroNecesidades = root.join("necesidades");
            //   Join<CentroEscolar, Necesidades> CentroNecesiSIJoin.join(Infraestructura_.FK_CENTRO_ESCOLAR);
            
            List<Predicate> list = new ArrayList<Predicate>();
           
            
            //servicio filters
            if(true) {
         	  list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.INSTALACION_ELECTRICA),false ));	
         	}
            if(true) {
           	  list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.FUNCIONA_INSTALACION_ELECTRICA),false ));	
           	}
            if(true) {
           	  list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.SERVICIOS_SANITARIOS),false ));	
           	}
            if(true) {
           	  list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.COMPUTADORAS_ESTUDIANTE),false ));	
           	}
            if(true) {
           	  list.add(builder.equal(CentroServicioInfJoin.get(Servicio_.SERVICIO_INTERNET),false ));	
           	}
            
            
            
            if(true) {
           	  list.add(builder.equal(CentroNecesidades.get(Necesidades_.RAMPA),false ));	
           	}
              if(true) {
             	  list.add(builder.equal(CentroNecesidades.get(Necesidades_.PASAMANOS),false ));	
             	}
              if(true) {
             	  list.add(builder.equal(CentroNecesidades.get(Necesidades_.SANITARIOS_ESPECIALES),false ));	
             	}
              if(true) {
             	  list.add(builder.equal(CentroNecesidades.get(Necesidades_.NO_POSEE),false ));	
             	}

            
            if(true) {
            	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.BIBLIOTECA),true ));	
            	}
            
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CENTRO_COMPUTO),false ));	
         	}
            
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.LABORATORIO_CIENCIA),false ));	
         	}
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.AULA_APOYO_EDUCATIVO),false ));	
         	}
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CANCHA_FUTBOL),false ));	
         	}
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CANCHA_BASQUETBOL),false ));	
         	}
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.LABORATORIO_INGLES),false ));	
         	}
            if(true) {
         	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.GRANJA_AGRICOLA),false ));	
         	}
            if(true) {
          	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.AREA_ADMINISTRATIVA),false ));	
          	}
            if(true) {
           	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.SALA_PROFESORES),false ));	
           	}
            if(true) {
           	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CLINICA_PARA_ESTUDIANTES),false ));	
           	}
            if(true) {
           	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.TALLERES_BACHILLERATO_INDUSTRIAL),false ));	
           	}
            if(true) {
           	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.CLINICA_BACHILLERATO_EN_SALUD),false ));	
           	}
            if(true) {
           	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.SALON_USOS_MULTIPLES),false ));	
           	}
            if(true) {
           	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.ESPACIO_RECREATIVO),false ));	
           	}
            if(true) {
            	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.COMEDOR),false ));	
            	}
            if(true) {
            	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.BODEGA),false ));	
            	}

            if(true) {
            	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.COCINA),false ));	
            	}  
            
            if(true) {
            	   list.add(builder.equal(CentroInfraJoin.get(Infraestructura_.COCINA_BODIGO),false ));	
            	}
            
            
         
           
            
            
       //     list.add( );
          //  list.push(   );
          
            //builder.equal(CentroServicioJoin.get(Infraestructura_.BODEGA),true );
            Predicate[] p = new Predicate[list.size()];
           // return buil
            return builder.and(list.toArray(p));
        };
    }
}