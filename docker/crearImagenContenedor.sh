#!/bin/bash

# Valores por defecto
app="fibonacci_app"
version="1.0.0"

# Construir la imagen Docker
docker build \
    -t "${app}:${version}" \
    -f Dockerfile ..

# Levantar el contenedor usando Docker Compose
docker-compose -f compose.yml -p "${app}" up -d
