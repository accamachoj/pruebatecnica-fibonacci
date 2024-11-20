package com.proteccion.pruebatecnica.fibonacci.controller;

import com.proteccion.pruebatecnica.fibonacci.service.FibonacciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fibonacci")
@CrossOrigin("*")
public class FibonacciController {

    @Autowired
    FibonacciService fibonacciService;

    @PostMapping("/generate")
    @Operation(summary = "Genera la serie Fibonacci", description = "Genera la serie Fibonacci basada en la hora proporcionada")
    public ResponseEntity<?> generateFibonacci(@RequestBody
                                                           @Parameter(description = "Hora en formato HH:mm:ss")
                                                           String time) {

        try {
            List<Integer> series = fibonacciService.generateFibonacci(time);
            return ResponseEntity.ok(series);
        } catch (RuntimeException ex) {
            String errorMessage = ex.getMessage();
            String example = "Ejemplo de entrada válida: '12:23:04' (Semillas: 2 y 3, Números a generar: 4)";
            return ResponseEntity.badRequest().body(Map.of(
                    "error", errorMessage,
                    "example", example
            ));
        }
    }
    @GetMapping("/")
    public ResponseEntity<?> generateFibonacciCurrentTime() {
        return new ResponseEntity<>(fibonacciService.generateFibonacciCurrentTime(), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Obtener todas las series Fibonacci generadas", description = "Devuelve todas las series Fibonacci almacenadas")
    public ResponseEntity<?> getAllRecords() {
        return ResponseEntity.ok(fibonacciService.getAllRecords());
    }
}

