package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

    // Interfaces
    public interface ProductoInventarioDeProductos {
        String getCodigoDeBarras();
        String getNombre();
        Double getCostoEnBodega();
        Double getPrecioUnitario();
        String getPresentacion();
        Integer getCantidadPresentacion();
        String getUnidadDeMedida();
        Double getVolumen();
        Double getPeso();
        Integer getCategoriaCodigo();
        Integer getCantidad();
        Integer getNivelMinimoReorden();
        Double getCostoPromedio();
    }

    public interface ProductoReorden {
        String getNombre();
        String getProductoCodigoDeBarras();
        String getBodegaNombre();
        String getSucursalNombre();
        String getProveedorNit();
        Integer getCantidad();
    }

    // RF
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> findAllProductos();

    @Query(value = "SELECT * FROM productos WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    Optional<Producto> findProductoByCodigoDeBarras(@Param("codigo_de_barras") String codigo_de_barras);

    @Query(value = "SELECT * FROM productos WHERE nombre = :nombre", nativeQuery = true)
    Optional<Producto> findProductoByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) VALUES (:codigo_de_barras, :nombre, :costo_en_bodega, :precio_unitario, :presentacion, :cantidad_presentacion, :unidad_de_medida, :volumen, :peso, :categoria_codigo)", nativeQuery = true)
    void insertProducto(@Param("codigo_de_barras") String codigo_de_barras, 
                        @Param("nombre") String nombre, 
                        @Param("costo_en_bodega") Double costo_en_bodega, 
                        @Param("precio_unitario") Double precio_unitario, 
                        @Param("presentacion") String presentacion,
                        @Param("cantidad_presentacion") Integer cantidad_presentacion, 
                        @Param("unidad_de_medida") String unidad_de_medida,
                        @Param("volumen") Double volumen, 
                        @Param("peso") Double peso,
                        @Param("categoria_codigo") Integer categoria_codigo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, costo_en_bodega = :costo_en_bodega, precio_unitario = :precio_unitario, presentacion = :presentacion, cantidad_presentacion = :cantidad_presentacion, unidad_de_medida = :unidad_de_medida, volumen = :volumen, peso = :peso, categoria_codigo = :categoria_codigo WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    void updateProducto(@Param("codigo_de_barras") String codigo_de_barras, 
                        @Param("nombre") String nombre, 
                        @Param("costo_en_bodega") Double costo_en_bodega, 
                        @Param("precio_unitario") Double precio_unitario, 
                        @Param("presentacion") String presentacion,
                        @Param("cantidad_presentacion") Integer cantidad_presentacion, 
                        @Param("unidad_de_medida") String unidad_de_medida,
                        @Param("volumen") Double volumen, 
                        @Param("peso") Double peso,
                        @Param("categoria_codigo") Integer categoria_codigo);

    // RFC2
    @Query(value = "SELECT p.codigo_de_barras, p.nombre, p.costo_en_bodega, p.precio_unitario, p.presentacion, p.cantidad_presentacion, p.unidad_de_medida, p.volumen, p.peso, p.categoria_codigo FROM productos p INNER JOIN categorias c ON p.categoria_codigo = c.codigo INNER JOIN inventariodeproductos i ON p.codigo_de_barras = i.producto_codigodebarras INNER JOIN bodegas b ON b.nombre = i.bodega_nombre INNER JOIN sucursales s ON s.nombre = b.nombre_sucursal INNER JOIN perecederos pc ON pc.codigocategoria = p.categoria_codigo WHERE p.precio_unitario BETWEEN :precio_min AND :precio_max AND pc.fechaexpiracion > TO_DATE(:fecha, 'YYYY-MM-DD') AND p.categoria_codigo = :categoria AND s.nombre = :sucursal", nativeQuery = true)
    Optional<Collection<Producto>> findProductosCaracteristicasPosterior(@Param("precio_min") float precio_min, @Param("precio_max") float precio_max, @Param("fecha") String fecha, @Param("categoria") Integer categoria, @Param("sucursal") String sucursal);

    @Query(value = "SELECT p.codigo_de_barras, p.nombre, p.costo_en_bodega, p.precio_unitario, p.presentacion, p.cantidad_presentacion, p.unidad_de_medida, p.volumen, p.peso, p.categoria_codigo FROM productos p INNER JOIN categorias c ON p.categoria_codigo = c.codigo INNER JOIN inventariodeproductos i ON p.codigo_de_barras = i.producto_codigodebarras INNER JOIN bodegas b ON b.nombre = i.bodega_nombre INNER JOIN sucursales s ON s.nombre = b.nombre_sucursal INNER JOIN perecederos pc ON pc.codigocategoria = p.categoria_codigo WHERE p.precio_unitario BETWEEN :precio_min AND :precio_max AND pc.fechaexpiracion < TO_DATE(:fecha, 'YYYY-MM-DD') AND p.categoria_codigo = :categoria AND s.nombre = :sucursal", nativeQuery = true)
    Optional<Collection<Producto>> findProductosCaracteristicasInferior(@Param("precio_min") float precio_min, @Param("precio_max") float precio_max, @Param("fecha") String fecha, @Param("categoria") Integer categoria, @Param("sucursal") String sucursal);
    
    // RFC3
    @Query(value = "SELECT p.codigo_de_barras, p.nombre, p.costo_en_bodega, p.precio_unitario, p.presentacion, p.cantidad_presentacion, p.unidad_de_medida, p.volumen, p.peso, p.categoria_codigo, i.cantidad, i.nivelminimoreorden, i.costo_promedio FROM inventariodeproductos i INNER JOIN bodegas b ON b.nombre = i.bodega_nombre INNER JOIN sucursales s ON s.nombre = b.nombre_sucursal INNER JOIN productos p ON p.codigo_de_barras = i.producto_codigodebarras WHERE b.nombre = :nombrebodega AND s.nombre = :nombresucursal", nativeQuery = true)
    Optional<Collection<ProductoInventarioDeProductos>> findAllProductosSucursalBodega(@Param("nombresucursal") String nombresucursal, @Param("nombrebodega") String nombrebodega ); 

    // RFC5
    @Query(value = "SELECT p.nombre, i.producto_codigodebarras, i.bodega_nombre, s.nombre, prov.nit, i.cantidad FROM inventariodeproductos i INNER JOIN productos p ON p.codigo_de_barras = i.producto_codigodebarras INNER JOIN bodegas b ON b.nombre = i.bodega_nombre INNER JOIN sucursales s ON s.nombre = b.nombre_sucursal INNER JOIN recepciondeproductos r ON r.bodega_nombre = b.nombre INNER JOIN ordenesdecompra o ON o.codigo = r.ordendecompra_codigo INNER JOIN proveedores prov ON prov.nit = o.proveedor_nit WHERE i.cantidad < i.nivelminimoreorden", nativeQuery = true)
    Optional<Collection<ProductoReorden>> findProductosReorden();
    
}