package com.capas.uca.parcial3.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.parcial3.domain.Apoyo;
import com.capas.uca.parcial3.domain.CentroEscolar;

public interface ApoyoRepo extends JpaRepository<Apoyo, Integer> {
	
}
