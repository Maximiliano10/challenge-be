# Challenge-BE

# 📚README 
Este es un proyecto de una API REST en Spring Boot utilizando Java 17, con la finalidad de sumar dos números y aplicarle un porcentaje adquirido de un servicio externo, siguiendo los requerimientos establecidos.

# 🌟Funcionalidades
- Servicio que recibe dos números, los suma y aplica un porcentaje adquirido de un servicio externo.
- Historial de todos los llamados a todos los endpoints junto con la respuesta en caso de haber sido exitoso.
- Límite de 3 RPM (Request / minuto) soportado.
- Guardado del historial de llamadas en una base de datos PostgreSQL.
- Inclusión de errores HTTP y mensajes adecuados para la serie 4XX.
- Tests unitarios incluidos.
# 🚀Tecnologías utilizadas
- Spring Cloud Gateway
- Spring Data JPA
- Eureka Server
- Java 17
- PostgreSQL 15
- Docker y Docker Compose
- Arquitectura de microservicios
- JUnit
- REST Service
- Spring Cloud Gateway con configuración de límite de peticiones y reintentos.
# Instrucciones de instalación y ejecución
# Requisitos previos
- Tener instalado Docker desktop.
# Pasos a seguir
- Clonar el repositorio Challenge BE.
- Ejecutar el comando de creación de imagen, por cada microservicio, ubicándose en el directorio correspondiente donde se encuentre el DockerFile, estos son los comandos a correr:
```docker
docker build -t apicalculate .
docker build -t apiexterna .
docker build -t eureka .
docker build -t gateway . 
```
- Luego de haber generado las imágenes, correr el comando: 
```docker
docker-compose up -d
```
ubicándose sobre el directorio donde se encuentra el archivo docker-compose.yml.
Una vez estén corriendo las imágenes, se podrá probar desde Postman, con la colección "Challenge BE.postman_collection.json" provista.
