package com.proteccion.pruebatecnica.fibonacci.repository;

import com.proteccion.pruebatecnica.fibonacci.entity.FibonacciSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FibonacciSerieRepository extends JpaRepository<FibonacciSerie, Long> {
}
