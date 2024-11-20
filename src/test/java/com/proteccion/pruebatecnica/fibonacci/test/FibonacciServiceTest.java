package com.proteccion.pruebatecnica.fibonacci.test;
import com.proteccion.pruebatecnica.fibonacci.dto.FibonacciSerieResponse;
import com.proteccion.pruebatecnica.fibonacci.entity.FibonacciSerie;
import com.proteccion.pruebatecnica.fibonacci.mapper.FibonacciSerieMapper;
import com.proteccion.pruebatecnica.fibonacci.repository.FibonacciSerieRepository;
import com.proteccion.pruebatecnica.fibonacci.service.impl.FibonacciServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FibonacciServiceTest {

    @Mock
    private FibonacciSerieRepository repository;

//    @Mock
//    private SendGridService sendGridService;

    @Mock
    private FibonacciSerieMapper fibonacciSerieMapper;

    @InjectMocks
    private FibonacciServiceImpl fibonacciService;

    @BeforeEach
    void setUp() {
        FibonacciSerie fibonacciSerie = new FibonacciSerie();
        MockitoAnnotations.openMocks(this);
//        doNothing().when(sendGridService).enviarCorreo(any());
        Mockito.when(repository.save(any(FibonacciSerie.class))).thenReturn(fibonacciSerie);
    }

    @Test
    void generateFibonacci_ShouldGenerateAndReverseFibonacciSeries() {
        // Arrange
        String time = "12:23:04";
        List<Integer> expectedSeries = Arrays.asList(21,13,8,5,3,2);

        // Act
        List<Integer> result = fibonacciService.generateFibonacci(time);

        // Assert
        assertEquals(expectedSeries, result);
//        verify(sendGridService, times(1)).enviarCorreo(expectedSeries);
        verify(repository, times(1)).save(any(FibonacciSerie.class));

    }

    @Test
    void getAllRecords_ShouldReturnMappedResponse() {
        // Arrange
        FibonacciSerie fibonacciSerie = new FibonacciSerie();
        fibonacciSerie.setExecutionTime("12:34:05");
        fibonacciSerie.setSeries(Arrays.asList(1, 1, 2, 3));

        when(repository.findAll()).thenReturn(Collections.singletonList(fibonacciSerie));
        FibonacciSerieResponse response = new FibonacciSerieResponse();
        when(fibonacciSerieMapper.toFibonacciSerieResponse(anyList()))
                .thenReturn(Collections.singletonList(response));

        // Act
        List<FibonacciSerieResponse> result = fibonacciService.getAllRecords();

        // Assert
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
//		verify(fibonacciSerieMapper, times(1)).toFibonacciSerieResponse(anyList());
    }

    @Test
    void saveFibonacci_ShouldSaveRecord() {
        // Arrange
        String time = "12:34:05";
        List<Integer> series = Arrays.asList(1, 1, 2, 3);
        FibonacciSerie fibonacciSerie = new FibonacciSerie();
        fibonacciSerie.setExecutionTime(time);
        fibonacciSerie.setSeries(series);

        when(repository.save(any(FibonacciSerie.class))).thenReturn(fibonacciSerie);

        // Act
        FibonacciSerie result = fibonacciService.saveFibonacci(time, series);

        // Assert
        assertEquals(time, result.getExecutionTime());
        assertEquals(series, result.getSeries());
        verify(repository, times(1)).save(any(FibonacciSerie.class));
    }
}

