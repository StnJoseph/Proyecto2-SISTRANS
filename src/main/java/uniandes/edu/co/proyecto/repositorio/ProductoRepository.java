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
}