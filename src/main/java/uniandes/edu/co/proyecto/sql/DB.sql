-- Tablas Nuevas --
CREATE TABLE ciudades (
    codigo INTEGER NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE sucursales (
    nombre VARCHAR(30) NOT NULL,
    tamanio INTEGER NOT NULL,
    direccion VARCHAR(40) NOT NULL,
    telefono INTEGER NOT NULL,
    codigo_ciudad INTEGER NOT NULL,
    PRIMARY KEY (nombre)
);

ALTER TABLE sucursales
    ADD CONSTRAINT sucursal_ciudad_fk FOREIGN KEY (codigo_ciudad) REFERENCES ciudades (codigo);

CREATE TABLE bodegas (
    nombre VARCHAR(30) NOT NULL,
    tamanio INTEGER NOT NULL,
    nombre_sucursal VARCHAR(30) NOT NULL,
    PRIMARY KEY (nombre)
);

ALTER TABLE bodegas
    ADD CONSTRAINT bodega_sucursal_fk FOREIGN KEY (nombre_sucursal) REFERENCES sucursales (nombre);

CREATE TABLE proveedores (
    nit INTEGER NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    nombre_contacto VARCHAR(50) NOT NULL,
    telefono_contacto INTEGER NOT NULL,
    PRIMARY KEY (nit)
);

CREATE TABLE categorias (
    codigo INTEGER NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    caracteristicas_almacenamiento VARCHAR(50) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE productos (
    codigo_de_barras VARCHAR(10) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    costo_en_bodega NUMBER NOT NULL,
    precio_unitario NUMBER NOT NULL,
    presentacion VARCHAR(30) NOT NULL,
    cantidad_presentacion INTEGER NOT NULL,
    unidad_de_medida VARCHAR(20) NOT NULL,
    volumen NUMBER NOT NULL,
    peso NUMBER NOT NULL,
    categoria_codigo INTEGER NOT NULL,
    PRIMARY KEY (codigo_de_barras)
);

ALTER TABLE productos
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY (categoria_codigo) REFERENCES categorias (codigo);

CREATE TABLE ordenesdecompra (
    codigo INTEGER NOT NULL,
    fecha_creacion DATE NOT NULL,
    fecha_entrega DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    proveedor_nit INTEGER NOT NULL,
    sucursal_nombre  VARCHAR(20) NOT NULL,
    PRIMARY KEY (codigo)
);

ALTER TABLE ordenesdecompra
    ADD CONSTRAINT ordendecompra_proveedor_fk FOREIGN KEY (proveedor_nit) REFERENCES proveedores (nit);

ALTER TABLE ordenesdecompra
    ADD CONSTRAINT ordendecompra_sucursal_fk FOREIGN KEY (sucursal_nombre) REFERENCES sucursales (nombre);

CREATE TABLE items (
    cantidad INTEGER NOT NULL,
    precio INTEGER NOT NULL,
    ordendecompra_codigo INTEGER NOT NULL,
    producto_codigodebarras VARCHAR(10) NOT NULL,
    PRIMARY KEY (ordendecompra_codigo, producto_codigodebarras)
);


CREATE TABLE recepciondeproductos (
    idrecepcion INTEGER NOT NULL,
    bodega_nombre VARCHAR(30) NOT NULL,
    ordendecompra_codigo INTEGER NOT NULL,
    PRIMARY KEY (idrecepcion)
);


-- Tablas que modifico samuel por si tienen algun error jsjsjs --

CREATE TABLE inventariodeproductos (
    costo_promedio FLOAT(10) NOT NULL,
    cantidad INTEGER NOT NULL,
    capacidad INTEGER NOT NULL,
    nivelminimoreorden INTEGER NOT NULL,
    producto_codigodebarras VARCHAR(10) NOT NULL,
    bodega_nombre VARCHAR2(30) NOT NULL,
    PRIMARY KEY (bodega_nombre, producto_codigodebarras),
    CONSTRAINT inventarioproducto_bodega_fk FOREIGN KEY (bodega_nombre) REFERENCES bodegas (nombre),
    CONSTRAINT inventarioproducto_producto_fk FOREIGN KEY (producto_codigodebarras) REFERENCES productos (codigo_de_barras)
);



-- Tablas Viejas --



CREATE TABLE noperecederos (
    codigocategoria INTEGER NOT NULL,
    PRIMARY KEY (codigocategoria),
    CONSTRAINT noperecederos_categoria_fk FOREIGN KEY (codigocategoria) REFERENCES categorias (codigocategoria)
);

CREATE TABLE perecederos (
    codigocategoria INTEGER NOT NULL,
    fechaexpiracion DATE NOT NULL,
    PRIMARY KEY (codigocategoria),
    CONSTRAINT perecederos_categoria_fk FOREIGN KEY (codigocategoria) REFERENCES categorias (codigocategoria)
);

CREATE TABLE ofrecen (
    proveedor_nit VARCHAR(9) NOT NULL,
    producto_codigodebarras VARCHAR(10) NOT NULL,
    PRIMARY KEY (proveedor_nit, producto_codigodebarras),
    CONSTRAINT sucursal_proveedor_fk FOREIGN KEY (proveedor_nit) REFERENCES proveedores (nit),
    CONSTRAINT sucursal_producto_fk FOREIGN KEY (producto_codigodebarras) REFERENCES productos (codigo_de_barras)
);
