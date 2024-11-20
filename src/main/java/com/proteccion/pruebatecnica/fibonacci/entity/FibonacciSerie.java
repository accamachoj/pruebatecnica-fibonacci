package com.proteccion.pruebatecnica.fibonacci.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FibonacciSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String executionTime;

    @ElementCollection
    private List<Integer> series;

    // Getters y setters
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

