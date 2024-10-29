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

    @Query(value = "SELECT * FROM productos WHERE codigo_de_barras = :codigoDeBarras", nativeQuery = true)
    Producto findProductoByCodigoDeBarras(@Param("codigoDeBarras") String codigoDeBarras);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso, categoria_codigo) VALUES (:codigoDeBarras, :nombre, :costoEnBodega, :precioUnitario, :presentacion, :cantidadPresentacion, :unidadDeMedida, :volumen, :peso, :categoria_codigo)", nativeQuery = true)
    void insertProducto(@Param("codigoDeBarras") String codigoDeBarras, 
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
    @Query(value = "UPDATE productos SET nombre = :nombre, costo_en_bodega = :costoEnBodega, precio_unitario = :precioUnitario, presentacion = :presentacion, cantidad_presentacion = :cantidadPresentacion, unidad_de_medida = :unidadDeMedida, volumen = :volumen, peso = :peso, categoria_codigo = :categoria_codigo WHERE codigo_de_barras = :codigoDeBarras", nativeQuery = true)
    void updateProducto(@Param("codigoDeBarras") String codigoDeBarras, 
                        @Param("nombre") String nombre, 
                        @Param("costoEnBodega") Double costoEnBodega, 
                        @Param("precioUnitario") Double precioUnitario, 
                        @Param("presentacion") String presentacion,
                        @Param("cantidadPresentacion") Integer cantidadPresentacion, 
                        @Param("unidadDeMedida") String unidadDeMedida,
                        @Param("volumen") Double volumen, 
                        @Param("peso") Double peso,
                        @Param("categoria_codigo") Integer categoria_codigo);
}