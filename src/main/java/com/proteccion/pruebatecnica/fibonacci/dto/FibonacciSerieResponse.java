package com.proteccion.pruebatecnica.fibonacci.dto;

import java.util.List;

public class FibonacciSerieResponse {
    private Long id;
    private String executionTime;
    private List<Integer> series;


    public FibonacciSerieResponse() {
    }

    public FibonacciSerieResponse(Long id, String executionTime, List<Integer> series) {
        this.id = id;
        this.executionTime = executionTime;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }



}
