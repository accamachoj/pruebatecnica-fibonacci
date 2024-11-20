package com.proteccion.pruebatecnica.fibonacci.service;

import java.util.List;

public interface SendGridService {
    public void enviarCorreo(List<Integer> reversedSeries, String time);
}
