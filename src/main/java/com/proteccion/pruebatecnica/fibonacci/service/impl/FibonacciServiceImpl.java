package com.proteccion.pruebatecnica.fibonacci.service.impl;

import com.proteccion.pruebatecnica.fibonacci.dto.FibonacciSerieResponse;
import com.proteccion.pruebatecnica.fibonacci.entity.FibonacciSerie;
import com.proteccion.pruebatecnica.fibonacci.exception.NoDataFoundException;
import com.proteccion.pruebatecnica.fibonacci.mapper.FibonacciSerieMapper;
import com.proteccion.pruebatecnica.fibonacci.repository.FibonacciSerieRepository;
import com.proteccion.pruebatecnica.fibonacci.service.FibonacciService;
import com.proteccion.pruebatecnica.fibonacci.exception.BadRequestException;
import com.proteccion.pruebatecnica.fibonacci.service.SendGridService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Autowired
    FibonacciSerieRepository fibonacciSerieRepository;

    @Autowired
    SendGridService sendGridService;

    FibonacciSerieMapper fibonacciSerieMapper = Mappers.getMapper(FibonacciSerieMapper.class);


    @Override
    public List<Integer> generateFibonacci(String time) {
        return calculateFibonacci(time);
    }

    @Override
    public List<Integer> generateFibonacciCurrentTime() {
        ZoneId colombiaZone = ZoneId.of("America/Bogota");

        ZonedDateTime colombiaTime = ZonedDateTime.now(colombiaZone);

        LocalTime localTime = colombiaTime.toLocalTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = localTime.format(formatter);
        return calculateFibonacci(formattedTime);
    }

    @Override
    public List<FibonacciSerieResponse> getAllRecords() {
        List<FibonacciSerieResponse> serieFibonacciResponseList = fibonacciSerieMapper.toFibonacciSerieResponse(fibonacciSerieRepository.findAll());
        if(serieFibonacciResponseList.isEmpty()) throw new NoDataFoundException("msg_logger_No_FibonacciSerie_Found");
        return serieFibonacciResponseList;
    }

    public List<Integer> calculateFibonacci(String time){

        LocalTime localTime;
        if (time == null || time.isEmpty()) {
            throw new BadRequestException("msg_logger_invalid_time_format");
        }

        try {
            localTime = LocalTime.parse(time);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("msg_logger_invalid_time_format");
        }
        String[] parts = time.split(":");

        int seed1 = Integer.parseInt(parts[1].substring(0, 1));

        int seed2 = Integer.parseInt(parts[1].substring(1, 2));

        int count = Integer.parseInt(parts[2]);

        if (count <= 0) {
            return Collections.emptyList();
        }


        List<Integer> series = new ArrayList<>();
        series.add(seed1);
        series.add(seed2);

        for (int i = 2; i < count + 2; i++) {
            series.add(series.get(i - 1) + series.get(i - 2));
        }

        Collections.reverse(series);

        saveFibonacci(time, series);

        sendGridService.enviarCorreo(series, time);

        return series;

    }

    public FibonacciSerie saveFibonacci(String time, List<Integer> series) {
        FibonacciSerie record = new FibonacciSerie();
        record.setExecutionTime(time);
        record.setSeries(series);
        return fibonacciSerieRepository.save(record);
    }

}
