# Prueba Tecnica Proteccion - ANDREA CAROLINA CAMACHO JULIO

## Descripción

Proyecto que permite generar series fibonacci a partir de formato de hora HH:MM:SS


* La Api Se Desarrolló en Spring Boot 3.3.5
* Java 17
* Se crearon 3 Endpoint: 
- Primero devuelve la serie de fibonacci teniendo en cuenta la hora actual de la Zona America/Bogota
- Segundo se Ingresa la Hora de Ejecución Como Body en un Post  y devuelve La serie de Fibonacci teniendo en cuenta esa hora.
- Tercero devuelve todas las series de fibonacci guardadas.
* Se implementó una Base de Datos H2
* Se implementó Envío de Correos mediante SendGrid
* Se establecio una variable de entorno la cual almacena la ApiKey de SendGrid
* Se implementó Mapstruct para el mapeo de Entitys y dtos de response
* Se implementó OpenApi/Swagger
* Se implementó Basic Authentication
* Se Manejaron Errores con Excepciones Personalizadas y un Controller Advisor con un archivo de Mensajes Personalizados.
* Se manejan las respuestas de los controladores Con Response Dtos y Códigos de Respuesta
* Se implementó pruebas unitarias para los metodos de services


* Se Desplego la Api En Railway en la siguiente dirección :
https://pruebatecnica-fibonacci-production.up.railway.app/swagger-ui/index.html#/fibonacci-controller/generateFibonacci

Link del Codigo Fuente
https://github.com/accamachoj/pruebatecnica-fibonacci
## Instalación

### Clonar el Repositorio

```bash
git clone https://github.com/accamachoj/pruebatecnica-fibonacci.git
```

### Ejecutar
    
```bash
mvn spring-boot:run
```

### Validacion

Dirigirse a http://localhost:8080/swagger-ui/index.html# para ver los endpoints generados para esta Api

### Autenticacion

Ingresar con Basic Autentication

user: user
password: user

