package com.proteccion.pruebatecnica.fibonacci.service.impl;


import com.proteccion.pruebatecnica.fibonacci.service.SendGridService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SendGridServiceImpl implements SendGridService {

    @Value("${sendgrid.api.key}")
    private String SENDGRID_API_KEY; // Reemplaza con tu API Key
    private static final String FROM_EMAIL = "accamachoj@outlook.es"; // Dirección de correo del remitente
    private static final String TO_EMAIL = "andreaccamachoj@gmail.com"; // Dirección de correo del destinatario

    public void enviarCorreo(List<Integer> reversedSeries, String time) {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();

        // Configura el correo
        try {
            // Define los parámetros del correo
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(
                    "{" +
                            "\"personalizations\":[{" +
                            "\"to\":[{\"email\":\"" + TO_EMAIL + "\"}]}]," +
                            "\"from\":{\"email\":\"" + FROM_EMAIL + "\"}," +
                            "\"subject\":\"Prueba Técnica – ANDREA CAROLINA CAMACHO JULIO\"," +
                            "\"content\":[{" +
                            "\"type\":\"text/plain\"," +
                            "\"value\":\"Buenos días,\\n\\n" +
                            "Este es el resultado de la serie fibonacci generada:\\n\\n" +
                            reversedSeries + " \\n\\n" +
                            "Esta es la hora de ejecucion:\\n\\n" +
                            time + " \\n\\n" +
                            "Gracias por su atención.\\n\"}" +
                            "]}");
            // Enviar el correo
            Response response = sg.api(request);
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Body: " + response.getBody());
            System.out.println("Headers: " + response.getHeaders());
        } catch (IOException ex) {
            System.err.println("Error sending email: " + ex.getMessage());
        }
    }
}

