package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InventarioDeProducto;
import uniandes.edu.co.proyecto.modelo.InventarioDeProductoPK;

public interface InventarioDeProductoRepository extends JpaRepository<InventarioDeProducto, InventarioDeProductoPK> {

    @Query(value = "SELECT * FROM inventario_de_producto", nativeQuery = true)
    Collection<InventarioDeProducto> findAllInventarios();

    @Query(value = "SELECT * FROM inventario_de_producto WHERE id = :id", nativeQuery = true)
    InventarioDeProducto findInventarioById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO inventario_de_producto (id, costo_promedio, cantidad, capacidad, nivel_minimo_reorden) VALUES (:id, :costoPromedio, :cantidad, :capacidad, :nivelMinimoReorden)", nativeQuery = true)
    void insertInventario(@Param("id") int id, 
                          @Param("costoPromedio") Integer costoPromedio, 
                          @Param("cantidad") Integer cantidad, 
                          @Param("capacidad") Integer capacidad, 
                          @Param("nivelMinimoReorden") Integer nivelMinimoReorden);

    @Modifying
    @Transactional
    @Query(value = "UPDATE inventario_de_producto SET costo_promedio = :costoPromedio, cantidad = :cantidad, capacidad = :capacidad, nivel_minimo_reorden = :nivelMinimoReorden WHERE id = :id", nativeQuery = true)
    void updateInventario(@Param("id") int id, 
                          @Param("costoPromedio") Integer costoPromedio, 
                          @Param("cantidad") Integer cantidad, 
                          @Param("capacidad") Integer capacidad, 
                          @Param("nivelMinimoReorden") Integer nivelMinimoReorden);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM inventario_de_producto WHERE id = :id", nativeQuery = true)
    void deleteInventario(@Param("id") int id);

    @Query(value = "SELECT p.nombre_producto, i.cantidad, i.nivel_minimo_reorden, i.costo_promedio " +
                   "FROM inventario_de_producto i " +
                   "JOIN producto p ON i.producto_codigo_de_barras = p.codigo_de_barras " +
                   "WHERE i.sucursal_id = :sucursalId AND i.bodega_id = :bodegaId", nativeQuery = true)
    Collection<Object[]> findInventarioBySucursalAndBodega(@Param("sucursalId") int sucursalId, @Param("bodegaId") int bodegaId);
}
