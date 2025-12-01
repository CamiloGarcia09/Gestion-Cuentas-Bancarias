# 🏦 Microservicio: Gestión de Cuentas Bancarias

Microservicio para la **gestión de cuentas bancarias**, desarrollado con:

- Java 21+
- Spring Boot 4
- Arquitectura Limpia + Hexagonal
- JPA / Hibernate
- MapStruct
- JUnit 5/6, Mockito
- Testcontainers

---

## 📘 Descripción General

Este microservicio expone una API REST para:

- Crear cuentas bancarias.
- Consultar el saldo de una cuenta.
- Registrar transacciones (DEPÓSITOS y RETIROS).
- Aplicar reglas de negocio sobre las transacciones.
- Consultar el historial de transacciones de una cuenta.

Todo siguiendo un enfoque de **Arquitectura Limpia / Hexagonal**, desacoplando el dominio de los frameworks y detalles de infraestructura.

---

## 🧱 Arquitectura (Arquitectura Limpia + Hexagonal)

Estructura lógica del proyecto:

```text
ms-gestion-cuentas/
 ├── application/
 │    ├── primaryports/
 |    ├───── dto/
 |    ├───── interactor/
 |    ├─────  mapper/
 │    ├── secondaryports/
 |    ├───── entity/
 |    ├───── mapper/
 |    ├───── repository/
 |    ├───── service/
 │    ├── usecase/
 |    ├───── crearcuenta/
 |    ├───── creartransaccion/
 |    ├───── historialtransaccion/
 |    └───── consultarsaldocuenta/
 ├── crosscutting/
 |    ├── exceptions/
 |    ├── helpers/
 ├── domain/
 │    ├── cuenta/
 │    ├── transaccion/
 │    └── event/         
 ├── infrastructure/
 │    ├── primaryadapters/
 |    ├───── controller/
 |    ├──────── response/
 |    ├──────── rest/
 │    ├── secondaryadapters/ 
 │    └───── events/       
 └── initializer/

```
---
## 🧱 Capas principales

### Domain
La capa de dominio contiene las reglas del negocio y los modelos puros: `CuentaDomain`, `TransaccionDomain`, el enum `TipoTransaccion` y los eventos de dominio como `TransaccionCreadaEvent`. Esta capa no depende de Spring ni de ninguna infraestructura externa; es completamente aislada y representa el corazón de la lógica del negocio.

### Application
La capa de aplicación orquesta el flujo de ejecución. Aquí se ubican los casos de uso como `CrearCuenta`, `ConsultarSaldoCuenta`, `CrearTransaccion` y `HistorialTransaccion`.  
Además, esta capa define los **Primary Ports**, que son los interactors encargados de recibir los DTOs provenientes de los controladores, y los **Secondary Ports**, que son las interfaces de repositorio utilizadas por los casos de uso (`CuentaRepository`, `TransaccionRepository`). Esta capa coordina la comunicación entre el dominio y la infraestructura sin depender de implementaciones concretas.

### Infrastructure
La capa de infraestructura contiene todos los detalles técnicos específicos del framework. Incluye los **Primary Adapters**, es decir, los controladores REST como `CrearCuentaController` y `CrearTransaccionController`, que exponen la API.  
Finalmente, esta capa incorpora el `GlobalExceptionHandler`, responsable del manejo centralizado de errores y excepciones.

---
# 🚀 Endpoints REST

A continuación se describen los endpoints principales expuestos por la API para la gestión de cuentas y transacciones bancarias.


## 🟪 1. Crear Cuenta  
**POST** `/api/v1/cuentas`

### 📥 Request body
```json
{
  "numeroCuenta": "12345",
  "nombreTitular": "Juan",
  "saldoInicial": 100000
}
```
## 🟪 2. Consultar Saldo de una Cuenta  
**GET** `/api/v1/cuentas/{id}/saldo`

### 🔑 Path variable
- **id**: UUID de la cuenta.

### 📤 Respuesta (ejemplo)
```json
{
  "datos": [
    {
      "nombreTitular": "Juan",
      "saldo": 100000
    }
  ],
  "mensajes": [
    "Consulta de saldo realizada correctamente."
  ]
}
```

## 🟪 3. Crear Transacción  
**POST** `/api/v1/transacciones`

### 📥 Request body
```json
{
  "cuentaId": "uuid-de-la-cuenta",
  "tipo": "DEPOSITO",
  "monto": 50000,
  "descripcion": "Recarga"
}

```

## 🟪 4. Consultar Historial de Transacciones  
**GET** `/api/v1/cuentas/{id}/transacciones`

### 🔑 Path variable
- **id**: UUID de la cuenta.

### 📥 Respuesta (ejemplo)
```json
{
  "datos": [
    {
      "tipoTransaccion": "DEPOSITO",
      "descripcion": "Recarga",
      "monto": 50000,
      "fecha": "2025-11-30T18:40:00"
    },
    {
      "tipoTransaccion": "RETIRO",
      "descripcion": "Compra en línea",
      "monto": 20000,
      "fecha": "2025-11-30T19:10:00"
    }
  ],
  "mensajes": [
    "Historial de transacciones consultado correctamente."
  ]
}

```

---

## 👨‍💻 Autor

**Juan Camilo García Aguirre**  
Talento B - Backend  


