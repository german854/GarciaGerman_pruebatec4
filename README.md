# # API de Gestión de Reservas de Agencia de Turismo

Este proyecto es una API REST desarrollada en Spring Boot que permite gestionar reservas de hoteles y vuelos para una agencia de turismo. Utiliza una base de datos MySQL para almacenar la información de los hoteles, habitaciones, vuelos y reservas.

## Funcionalidades

La API proporciona las siguientes funcionalidades:

- Consulta de hoteles y habitaciones disponibles.
- Consulta de vuelos disponibles.
- Realización de reservas de hoteles y habitaciones.
- Realización de reservas de vuelos.
- Gestión de operaciones CRUD para hoteles, habitaciones, vuelos y reservas.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security
- JWT (JSON Web Tokens)
- MySQL

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalado lo siguiente:

- Java Development Kit (JDK) 11 o superior
- MySQL Server

## Configuración de la Base de Datos

1. Crea una base de datos MySQL llamada `agencia`.
2. Actualiza las credenciales de acceso a la base de datos en el archivo `application.properties`.
  spring.datasource.url=jdbc:mysql://localhost:3306/agencia
  spring.datasource.username=usuario
  spring.datasource.password=contraseña


## Ejecución del Proyecto

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE favorito.
3. Ejecuta la clase principal `AgenciaApplication.java`.
4. La aplicación se ejecutará en `http://localhost:8080`.

## Documentación de la API

Puedes encontrar la documentación detallada de la API en [Swagger UI](http://localhost:8080/swagger-ui.html) después de iniciar la aplicación.

## Endpoints Disponibles

### Hoteles

- GET `/agency/hotels`: Obtener todos los hoteles registrados.
- GET `/agency/hotels/{id}`: Obtener un hotel por su ID.
- POST `/agency/hotels`: Crear un nuevo hotel.
- PUT `/agency/hotels/{id}`: Actualizar un hotel existente.
- DELETE `/agency/hotels/{id}`: Eliminar un hotel.

### Habitaciones

- GET `/agency/rooms`: Obtener todas las habitaciones disponibles.
- POST `/agency/room-booking/new`: Realizar una reserva de habitación.

### Vuelos

- GET `/agency/flights`: Obtener todos los vuelos registrados.
- GET `/agency/flights/{id}`: Obtener un vuelo por su ID.
- POST `/agency/flights/new`: Crear un nuevo vuelo.
- PUT `/agency/flights/{id}`: Actualizar un vuelo existente.
- DELETE `/agency/flights/{id}`: Eliminar un vuelo.



## Autor

Germán García Sánchez - ggarcia854@gmail.com


