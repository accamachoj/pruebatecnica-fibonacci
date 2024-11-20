package com.proteccion.pruebatecnica.fibonacci.service;


import com.proteccion.pruebatecnica.fibonacci.dto.FibonacciSerieResponse;

import java.util.List;

public interface FibonacciService {

    public List<Integer> generateFibonacci(String time);

    public List<Integer> generateFibonacciCurrentTime();

    public List<FibonacciSerieResponse> getAllRecords();
}
