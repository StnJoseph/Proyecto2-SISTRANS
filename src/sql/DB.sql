-- Tablas Nuevas --
CREATE TABLE ciudades (
    codigo INTEGER NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE sucursales (
    nombre VARCHAR(30) NOT NULL,
    tamanio FLOAT(6) NOT NULL,
    direccion VARCHAR(40) NOT NULL,
    telefono INTEGER NOT NULL,
    codigo_ciudad INTEGER NOT NULL,
    PRIMARY KEY (nombre)
);

ALTER TABLE sucursales
    ADD CONSTRAINT sucursal_ciudad_fk FOREIGN KEY (codigo_ciudad) REFERENCES ciudades (codigo);

CREATE TABLE bodegas (
    nombre VARCHAR(30) NOT NULL,
    tamanio FLOAT(6) NOT NULL,
    nombre_sucursal VARCHAR(30) NOT NULL,
    PRIMARY KEY (nombre)
);

ALTER TABLE bodegas
    ADD CONSTRAINT bodega_sucursal_fk FOREIGN KEY (nombre_sucursal) REFERENCES sucursales (nombre);



-- Tablas Viejas --


CREATE TABLE categorias (
    codigocategoria INTEGER NOT NULL,
    nombrecategoria VARCHAR(30) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    caracteristicasalmacenamiento VARCHAR(50) NOT NULL,
    PRIMARY KEY (codigocategoria)
);

CREATE TABLE inventarioproductos (
    costopromedio FLOAT(10) NOT NULL,
    cantidad INTEGER NOT NULL,
    capacidad INTEGER NOT NULL,
    nivelminimoreorden INTEGER NOT NULL,
    producto_codigodebarras VARCHAR(10) NOT NULL,
    bodega_nombre VARCHAR2(30) NOT NULL,
    PRIMARY KEY (bodega_nombre, producto_codigodebarras)
);

CREATE TABLE items (
    cantidad INTEGER NOT NULL,
    precio INTEGER NOT NULL,
    ordendecompra_codigo INTEGER NOT NULL,
    producto_codigodebarras VARCHAR(10) NOT NULL,
    PRIMARY KEY (ordendecompra_codigo, producto_codigodebarras)
);

CREATE TABLE noperecederos (
    codigocategoria INTEGER NOT NULL,
    PRIMARY KEY (codigocategoria)
);

CREATE TABLE ordendecompras (
    codigo INTEGER NOT NULL,
    fechacreacion DATE NOT NULL,
    fechaentrega DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    proveedor_nit VARCHAR(9) NOT NULL,
    sucursal_nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE perecederos (
    codigocategoria INTEGER NOT NULL,
    fechaexpiracion DATE NOT NULL,
    PRIMARY KEY (codigocategoria)
);

CREATE TABLE productos (
    codigodebarras VARCHAR(10) NOT NULL,
    nombreproducto VARCHAR(30) NOT NULL,
    costoenbodega INTEGER NOT NULL,
    preciounitario INTEGER NOT NULL,
    presentacion VARCHAR(30) NOT NULL,
    cantidadpresentacion INTEGER NOT NULL,
    unidaddemedida VARCHAR(20) NOT NULL,
    volumen FLOAT(6) NOT NULL,
    peso FLOAT(6) NOT NULL,
    categoria_codigo INTEGER NOT NULL,
    PRIMARY KEY (codigodebarras)
);

CREATE TABLE proveedores (
    nit VARCHAR(9) NOT NULL,
    nombreproveedor VARCHAR(30) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    nombrecontacto VARCHAR(50) NOT NULL,
    telefonocontacto INTEGER NOT NULL,
    PRIMARY KEY (nit)
);

CREATE TABLE recepciondeproductos (
    idrecepcion INTEGER NOT NULL,
    bodega_nombre VARCHAR(30) NOT NULL,
    ordendecompra_codigo INTEGER NOT NULL,
    PRIMARY KEY (idrecepcion)
);

CREATE TABLE ofrecen (
    proveedor_nit VARCHAR(9) NOT NULL,
    producto_codigodebarras VARCHAR(10) NOT NULL,
    PRIMARY KEY (proveedor_nit, producto_codigodebarras)
);


ALTER TABLE inventarioproductos
    ADD CONSTRAINT inventarioproducto_bodega_fk FOREIGN KEY (bodega_nombre) REFERENCES bodegas (nombrebodega);

ALTER TABLE inventarioproductos
    ADD CONSTRAINT inventarioproducto_producto_fk FOREIGN KEY (producto_codigodebarras) REFERENCES productos (codigodebarras);

ALTER TABLE items
    ADD CONSTRAINT item_ordendecompra_fk FOREIGN KEY (ordendecompra_codigo) REFERENCES ordendecompras (codigo);

ALTER TABLE items
    ADD CONSTRAINT item_producto_fk FOREIGN KEY (producto_codigodebarras) REFERENCES productos (codigodebarras);

ALTER TABLE noperecederos
    ADD CONSTRAINT noperecederos_categoria_fk FOREIGN KEY (codigocategoria) REFERENCES categorias (codigocategoria);

ALTER TABLE ordendecompras
    ADD CONSTRAINT ordendecompra_proveedor_fk FOREIGN KEY (proveedor_nit) REFERENCES proveedores (nit);

ALTER TABLE ordendecompras
    ADD CONSTRAINT ordendecompra_sucursal_fk FOREIGN KEY (sucursal_nombre) REFERENCES sucursales (nombresucursal);

ALTER TABLE perecederos
    ADD CONSTRAINT perecederos_categoria_fk FOREIGN KEY (codigocategoria) REFERENCES categorias (codigocategoria);

ALTER TABLE productos
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY (categoria_codigo) REFERENCES categorias (codigocategoria);

ALTER TABLE recepciondeproductos
    ADD CONSTRAINT recepciondeproducto_bodega_fk FOREIGN KEY (bodega_nombre) REFERENCES bodegas (nombrebodega);

ALTER TABLE recepciondeproductos
    ADD CONSTRAINT recepciondeproducto_ordendecompra_fk FOREIGN KEY (ordendecompra_codigo) REFERENCES ordendecompras (codigo);


ALTER TABLE ofrecen
    ADD CONSTRAINT sucursal_proveedor_fk FOREIGN KEY (proveedor_nit) REFERENCES proveedores (nit);

ALTER TABLE ofrecen
    ADD CONSTRAINT sucursal_producto_fk FOREIGN KEY (producto_codigodebarras) REFERENCES productos (codigodebarras);
