# 💻 IMPLEMENTACIÓN DE SISTEMAS DE INFORMACIÓN y REGISTRO DE COMPUTADORES (EVA3)

Este proyecto es una aplicación de escritorio desarrollada en **Java Swing** como parte de la evaluación del curso. Permite realizar la gestión y el mantenimiento de computadores (`computador`) categorizados por tipos o categorías (`tipocomputador`), conectándose a una base de datos relacional **MySQL**.

---

## 🚀 Características Principales

- **Interfaz Gráfica (GUI):** Desarrollada con **Java Swing** e interactiva para el registro y gestión de equipos.
- **Base de Datos Relacional:** Implementada en **MySQL** (`redsocial`), estructurada con llaves foráneas (`FK`) para relacionar las tablas `computador` y `tipocomputador`.
- **Carga Dinámica de Datos:** Los tipos de computador se cargan dinámicamente desde la base de datos a un `JComboBox`.
- **Validaciones en Formulario:** Control de campos obligatorios vacíos y validación de precios válidos antes del registro.
- **Patrón DAO / Model:** Separación clara entre la capa de presentación (`vista`), entidades (`entity`), modelos de datos (`model`) y conexión (`util`).
- **Script SQL Incluido:** Incluye el script de creación de tablas y datos iniciales dentro del proyecto (`/sql/basedatos.sql`).

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 17 / JavaSE-25)
- **Framework GUI:** Java Swing (WindowBuilder)
- **Gestor de Proyectos:** Maven
- **Base de Datos:** MySQL (MySQL Workbench 8.0)
- **Conector JDBC:** MySQL Connector/J
- **Librerías Adicionales:** [Lombok](https://projectlombok.org/) (para optimización de getters y setters)
- **IDE:** Eclipse IDE

---

## 📋 Estructura de la Base de Datos

La base de datos utilizada se llama `redsocial` y cuenta con la siguiente relación:

### Tabla `tipocomputador`
- `idtipocomputador` (INT, PK, AUTO_INCREMENT)
- `nombre` (VARCHAR)
- `descripcion` (VARCHAR)

### Tabla `computador`
- `idcomputador` (INT, PK, AUTO_INCREMENT)
- `idtipocomputador` (INT, FK -> `tipocomputador.idtipocomputador`)
- `codigo` (VARCHAR)
- `marca` (VARCHAR)
- `modelo` (VARCHAR)
- `procesador` (VARCHAR)
- `ram` (VARCHAR)
- `disco_duro` (VARCHAR)
- `precio` (DECIMAL)
- `estado` (VARCHAR)

---

## 📂 Estructura del Proyecto

```text
EVA3_Computador/
├── src/
│   ├── entity/
│   │   ├── Computador.java
│   │   └── Tipocomputador.java
│   ├── model/
│   │   ├── ComputadorModel.java
│   │   └── TipoComputadorModel.java
│   ├── util/
│   │   └── MySqlDBConexion.java
│   └── vista/
│       └── FrmRegistraComputador.java
├── sql/
│   └── basedatos.sql
├── pom.xml
└── README.md

👤 Autor
Juan Daniel Roncano Córdova - Desarrollador - JuanDRC25
