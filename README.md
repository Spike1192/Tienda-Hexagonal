# Proyecto Arquitectura Hexagonal

Este proyecto es una implementación de Arquitectura Hexagonal usando Spring Boot, enfocada en la separación de responsabilidades y testabilidad.



## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Gradle
* JUnit 5
* Mockito
* Lombok


## Requisitos 


**Java 21**,
**MySQL**,
**Gradle**


### Verificar instalaciones

```bash
java -version
```

```bash
gradle -v
```

```bash
mysql --version
```



## Funcionalidades

* Crear producto
* Actualizar producto
* Eliminar producto
* Obtener producto por ID
* Listar todos los productos


## Configuración

### Base de datos

Configura el archivo:

```
src/main/resources/application.yaml
```


## Ejecución del proyecto


```bash
gradlew bootRun
```

---

## Ejecutar pruebas

```bash
/gradlew test
```

---

## Testing

Se implementan pruebas unitarias usando:

* **JUnit 5**
* **Mockito**

### Cobertura de pruebas

* Validaciones de dominio
* Casos exitosos
* Manejo de errores
* Verificación de interacción con puertos
* Aislamiento del dominio

Ejemplos de validaciones:

* Nombre obligatorio
* Precio mayor a cero
* Cantidad no negativa
* ID requerido en actualizaciones

## Autores

* Jaider Andres Lopez Angarita
* Jorge Luis Soto Torrado
* Ricardo Yecid Arias Martinez
* Edgar Lopez Gualdron


