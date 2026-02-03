# E commerce Backend Service

Backend REST desarrollado para la gestión y administración de E commerce. Fundamentos sólidos de backend: arquitectura en capas, persistencia de datos, uso de variables de entorno y ejecución mediante Docker.

---

## 🧱 Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Jwt
* MySQL
* Maven
* Git
* Docker
* Docker Compose

---

## 🏗️ Arquitectura del proyecto

El proyecto sigue una **arquitectura en capas**, separando responsabilidades:

* **Controller**: expone los endpoints REST
* **Service**: contiene la lógica de negocio
* **Repository**: acceso a datos mediante Spring Data JPA
* **DTOs**: objetos para requests y responses, evitando exponer directamente las entidades
* **Security**: seguridad de usuarios y roles
* **Config**: configuración de accesibilidad y seguridad

Esta separación permite un código más mantenible, claro y escalable.

---

## 📦 Persistencia de datos

* Base de datos: **MySQL**
* ORM: **JPA / Hibernate**
* Las entidades se mapean automáticamente a tablas de la base de datos
* Se realizan operaciones CRUD completas sobre la entidad `Miembro`

---

## 🔐 Configuración y seguridad básica

Las credenciales y datos sensibles **no están hardcodeados** en el proyecto.

Se utilizan **variables de entorno** para la configuración de la base de datos:

* `DB_URL`
* `DB_USERNAME`
* `DB_PASSWORD`

Estas variables son consumidas desde `application.properties`, lo que permite ejecutar el proyecto en distintos entornos sin modificar el código.

---

## 🐳 Ejecución con Docker

El proyecto puede ejecutarse completamente mediante **Docker y Docker Compose**, levantando tanto el backend como la base de datos MySQL.

### ▶️ Pasos para ejecutar el proyecto

1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/EcommerceAdministrador.git
cd EcommerceAdministrador
```

2. Levantar los contenedores

```bash
docker compose up --build
```

3. Servicios disponibles:

* Backend: `http://localhost:8080`
* MySQL: `localhost:3307`

Docker se encarga de:

* Construir la imagen del backend
* Levantar la base de datos MySQL
* Conectar ambos servicios mediante red interna

---

## 🔌 Endpoints 

Las pruebas de los endpoints se realizaron utilizando **Postman**.

---

## 🎯 Objetivo del proyecto

* Creación de APIs REST con Spring Boot
* Uso de JPA para persistencia
* Separación de capas
* Seguridad en Endpoints e información
* Manejo de configuración por variables de entorno
* Ejecución del proyecto mediante Docker
