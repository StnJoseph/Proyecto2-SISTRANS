package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> findAllProductos();

    @Query(value = "SELECT * FROM productos WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    Producto findProductoByCodigoDeBarras(@Param("codigo_de_barras") String codigo_de_barras);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) VALUES (:codigo_de_barras, :nombre, :costoEnBodega, :precioUnitario, :presentacion, :cantidadPresentacion, :unidadDeMedida, :volumen, :peso, :categoria_codigo)", nativeQuery = true)
    void insertProducto(@Param("codigo_de_barras") String codigo_de_barras, 
                        @Param("nombre") String nombre, 
                        @Param("costoEnBodega") Double costoEnBodega, 
                        @Param("precioUnitario") Double precioUnitario, 
                        @Param("presentacion") String presentacion,
                        @Param("cantidadPresentacion") Integer cantidadPresentacion, 
                        @Param("unidadDeMedida") String unidadDeMedida,
                        @Param("volumen") Double volumen, 
                        @Param("peso") Double peso,
                        @Param("categoria_codigo") Integer categoria_codigo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, costo_en_bodega = :costoEnBodega, precio_unitario = :precioUnitario, presentacion = :presentacion, cantidad_presentacion = :cantidadPresentacion, unidad_de_medida = :unidadDeMedida, volumen = :volumen, peso = :peso, categoria_codigo = :categoria_codigo WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    void updateProducto(@Param("codigo_de_barras") String codigo_de_barras, 
                        @Param("nombre") String nombre, 
                        @Param("costoEnBodega") Double costoEnBodega, 
                        @Param("precioUnitario") Double precioUnitario, 
                        @Param("presentacion") String presentacion,
                        @Param("cantidadPresentacion") Integer cantidadPresentacion, 
                        @Param("unidadDeMedida") String unidadDeMedida,
                        @Param("volumen") Double volumen, 
                        @Param("peso") Double peso,
                        @Param("categoria_codigo") Integer categoria_codigo);

    //RFC 2
    @Query(value = "SELECT * FROM productos p INNNER JOIN CATEGORIA c WHERE precio BETWEEN :precio_min AND :precio_max AND XS AND sucursal = :sucursal AND categoria = :categoria", nativeQuery = true)
    Collection<Producto> findProductosCaracteristicas();
    
}