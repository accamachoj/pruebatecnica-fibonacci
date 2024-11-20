package com.proteccion.pruebatecnica.fibonacci.mapper;

import com.proteccion.pruebatecnica.fibonacci.dto.FibonacciSerieResponse;
import com.proteccion.pruebatecnica.fibonacci.entity.FibonacciSerie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FibonacciSerieMapper {

    public List<FibonacciSerieResponse> toFibonacciSerieResponse(List<FibonacciSerie> source);
}
