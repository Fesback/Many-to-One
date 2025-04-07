# 📚 Proyecto Hibernate Many-to-One

> Este proyecto demuestra la implementación de una relación Many-to-One entre entidades Producto, Categoria y TipoCategoria usando Java, Hibernate ORM, y MySQL. Cada producto pertenece a una categoría, y cada categoría tiene un tipo asociado.

---

## ⚙️ Tecnologías Utilizadas

- ☕ Java 22
- 🧱 Hibernate ORM 
- 🐬 MySQL 
- 💼 Maven
- 🧠 Lombok
- 🧰 MySQL Workbench

---

## 🧠 Descripción

Este proyecto modela una relación muchos a uno donde un producto puede pertenecer a una única categoría, y cada categoría tiene un tipo determinado (TipoCategoria). Se usa Hibernate ORM para gestionar la persistencia de datos, y JPA para mapear las relaciones entre las entidades. El proyecto utiliza MySQL como base de datos para almacenar las categorías, productos y tipos de categoría.

---

## 🗂️ Estructura del Proyecto

```
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┣ 📂com.fescode.model     → Entidades: Categoria, Producto, TipoCategoria
 ┃ ┃ ┣ 📂com.fescode.service   → Lógica del servicio (CategoriaService)
 ┃ ┃ ┗ 📜MainApp.java          → Clase principal
 ┃ ┗ 📂resources
 ┃   ┗ 📜META-INF/persistence.xml
 ┗ 📜pom.xm
```
## 🧪 Base de Datos

Ejecutar en la base de Datos lo siguiente

```
CREATE DATABASE IF NOT EXISTS bd_many_to_one;

use bd_many_to_one;

-- crear table categoria
CREATE TABLE categoria(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo varchar(50) NOT NULL
);

-- crear table producto
CREATE TABLE producto(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    categoria_id BIGINT,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- INSERTANTO CATEGORIAS
INSERT INTO categoria (tipo) VALUES
('ELECTRONICA'),
('ROPA'),
('HOGAR'),
('DEPORTE'),
('LIBROS'),
('ALIMENTOS'),
('JUGUETES'),
('COSMETICOS'),
('AUTOMOVILES'),
('OTROS');

-- INSERTANDO PRODUCTOS
INSERT INTO producto (nombre, categoria_id) VALUES
('PRODUCTO 1', 1),
('PRODUCTO 2', 1),
('PRODUCTO 3', 2),
('PRODUCTO 4', 2),
('PRODUCTO 5', 3),
('PRODUCTO 6', 4),
('PRODUCTO 7', 5),
('PRODUCTO 8', 6),
('PRODUCTO 9', 8);

```
