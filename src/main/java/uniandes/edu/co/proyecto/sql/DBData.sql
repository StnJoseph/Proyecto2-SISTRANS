-- Datos Nuevos --

INSERT INTO ciudades (codigo, nombre) 
VALUES (1, 'Bogotá');

INSERT INTO ciudades (codigo, nombre) 
VALUES (2, 'Medellín');

INSERT INTO ciudades (codigo, nombre) 
VALUES (3, 'Barranquilla');

INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) 
VALUES ('Sucursal A', 1000.0, 'Calle 123', 1234567, 1);

INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) 
VALUES ('Sucursal B', 1500.0, 'Carrera 45', 7654321, 2);

INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) 
VALUES ('Sucursal C', 4500.0, 'Carrera 15', 1234567, 3);

INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) 
VALUES ('Bodega X', 5000.0, 'Sucursal A');

INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) 
VALUES ('Bodega Y', 3000.0, 'Sucursal B');

INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) 
VALUES ('Bodega Z', 4500.0, 'Sucursal C');

INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) 
VALUES (123456789, 'Proveedor Uno', 'Avenida 1', 'Augusto', 300123456);

INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) 
VALUES (987654321, 'Proveedor Dos', 'Calle 10', 'Samuel', 310765432);

INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) 
VALUES (138765892, 'Proveedor Tres', 'Carrera 72', 'Joseph', 320482783);

INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) 
VALUES (893749208, 'Proveedor Cuatro', 'Av 130', 'Sergio', 312947900);

INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) 
VALUES (1, 'Perecederos', 'Productos que caducan', 'Refrigeración');

INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) 
VALUES (2, 'No Perecederos', 'Productos de larga duración', 'Almacenamiento en seco');

INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) 
VALUES (3, 'No Perecederos', 'Producto electronico', 'Mlantener fuera del alcance de los niños');

INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) 
VALUES ('0000000001', 'Producto A', 1000.0, 1200.0, 'Caja', 10, 'gr', 0.5, 1.0, 1);

INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) 
VALUES ('0000000002', 'Producto B', 1500.0, 1800.0, 'Bolsa', 5, 'ml', 1.5, 2.0, 2);

INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) 
VALUES ('0000000003', 'Producto C', 4500.0, 2000.0, 'Ziplock', 4, 'ml', 4.5, 8.0, 2);

INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) 
VALUES (1, TO_DATE('2024-01-01', 'YYYY-MM-DD'), TO_DATE('2024-01-10', 'YYYY-MM-DD'), 'Pendiente', 123456789, 'Sucursal A');

INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) 
VALUES (2, TO_DATE('2024-02-01', 'YYYY-MM-DD'), TO_DATE('2024-02-15', 'YYYY-MM-DD'), 'Entregado', 987654321, 'Sucursal B');

INSERT INTO items (cantidad, precio, ordendecompra_codigo, producto_codigodebarras) 
VALUES (10, 1200, 1, '0000000001');

INSERT INTO items (cantidad, precio, ordendecompra_codigo, producto_codigodebarras) 
VALUES (5, 1800, 2, '0000000002');

INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) 
VALUES (1000, 50, 500, 10, '0000000001', 'Bodega X');

INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) 
VALUES (1500, 30, 300, 5, '0000000002', 'Bodega Y');

INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) 
VALUES (2000, 20, 200, 8, '0000000003', 'Bodega Z');


-- Datos Viejos --



INSERT INTO perecederos (codigocategoria, fechaexpiracion) 
VALUES (1, TO_DATE('2024-12-31', 'YYYY-MM-DD'));

INSERT INTO noperecederos (codigocategoria) 
VALUES (2);

INSERT INTO recepciondeproductos (idrecepcion, bodega_nombre, ordendecompra_codigo) 
VALUES (1, 'Bodega Central', 1);

INSERT INTO recepciondeproductos (idrecepcion, bodega_nombre, ordendecompra_codigo) 
VALUES (2, 'Bodega Norte', 2);

INSERT INTO ofrecen (proveedor_nit, producto_codigodebarras) 
VALUES ('123456789', '0000000001');

INSERT INTO ofrecen (proveedor_nit, producto_codigodebarras) 
VALUES ('987654321', '0000000002');


---Datos Sergio--

-- Ciudades
INSERT INTO ciudades (codigo, nombre) VALUES (1, 'Bogotá');
INSERT INTO ciudades (codigo, nombre) VALUES (2, 'Medellín');

-- Sucursales
INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) VALUES ('Sucursal Norte', 500, 'Calle 123 #45-67', 1234567, 1);
INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) VALUES ('Sucursal Sur', 300, 'Carrera 98 #45-12', 7654321, 1);

-- Bodegas
INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) VALUES ('Bodega Central', 1000, 'Sucursal Norte');
INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) VALUES ('Bodega Sur', 800, 'Sucursal Sur');

-- Proveedores
INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) VALUES (900100200, 'Proveedor A', 'Calle 10 #20-30', 'Juan Pérez', 1234567);
INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) VALUES (900300400, 'Proveedor B', 'Carrera 11 #15-20', 'María López', 7654321);

-- Categorías
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (1, 'Lácteos', 'Productos lácteos', 'Refrigeración');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (2, 'Carnes', 'Productos cárnicos', 'Congelación');

-- Productos
INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) VALUES ('001', 'Leche', 2000, 2500, 'Botella', 1, 'Litro', 1.0, 1.2, 1);
INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) VALUES ('002', 'Carne de Res', 5000, 7500, 'Paquete', 1, 'Kilogramo', 0.8, 1.5, 2);

-- Inventario de Productos
INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) VALUES (2100, 100, 500, 50, '001', 'Bodega Central');
INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) VALUES (5300, 30, 200, 20, '002', 'Bodega Sur');

-- Órdenes de Compra
INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) VALUES (1, TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-10', 'YYYY-MM-DD'), 'Pendiente', 900100200, 'Sucursal Norte');

-- Items
INSERT INTO items (cantidad, precio, ordendecompra_codigo, producto_codigodebarras) VALUES (50, 2500, 1, '001');

-- Recepción de Productos
INSERT INTO recepciondeproductos (idrecepcion, bodega_nombre, ordendecompra_codigo) VALUES (1, 'Bodega Central', 1);

-- No Perecederos
INSERT INTO noperecederos (codigocategoria) VALUES (1);

-- Perecederos
INSERT INTO perecederos (codigocategoria, fechaexpiracion) VALUES (2, TO_DATE('2024-12-31', 'YYYY-MM-DD'));

-- Ofrecen
INSERT INTO ofrecen (proveedor_nit, producto_codigodebarras) VALUES (900100200, '001');
INSERT INTO ofrecen (proveedor_nit, producto_codigodebarras) VALUES (900300400, '002');




--datos samuel --- 


INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) 
VALUES (3, TO_DATE('2024-10-15', 'YYYY-MM-DD'), TO_DATE('2024-10-20', 'YYYY-MM-DD'), 'Entregado', 900100200, 'Sucursal Norte');

INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) 
VALUES (4, TO_DATE('2024-10-18', 'YYYY-MM-DD'), TO_DATE('2024-10-25', 'YYYY-MM-DD'), 'Pendiente', 900300400, 'Sucursal Sur');


INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) 
VALUES (3000, 40, 500, 15, '001', 'Bodega Central');

INSERT INTO inventariodeproductos (costo_promedio, cantidad, capacidad, nivelminimoreorden, producto_codigodebarras, bodega_nombre) 
VALUES (5500, 60, 300, 10, '002', 'Bodega Sur');


INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) 
VALUES (900500600, 'Proveedor C', 'Avenida 50 #70-10', 'Luis Martinez', 315123456);


INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) 
VALUES ('Sucursal Este', 4000, 'Calle 50 #10-25', 321654987, 2);

INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) 
VALUES ('Bodega Este', 2000, 'Sucursal Este');

INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) 
VALUES (5, TO_DATE('2024-10-05', 'YYYY-MM-DD'), TO_DATE('2024-10-15', 'YYYY-MM-DD'), 'Entregado', 900500600, 'Sucursal Este');

INSERT INTO recepciondeproductos (idrecepcion, bodega_nombre, ordendecompra_codigo) 
VALUES (5, 'Bodega Este', 5);
