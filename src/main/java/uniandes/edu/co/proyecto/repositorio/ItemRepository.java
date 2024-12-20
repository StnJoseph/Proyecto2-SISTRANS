package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Item;
import uniandes.edu.co.proyecto.modelo.ItemPK;

public interface ItemRepository extends JpaRepository<Item, ItemPK> {

    @Query(value = "SELECT * FROM items", nativeQuery = true)
    Collection<Item> findAllItems();

    // @Query(value = "SELECT * FROM items WHERE ordendecompra = :ordenId AND producto = :productoId", nativeQuery = true)
    // Item findItemById(@Param("ordenId") Long ordenId, 
    //                   @Param("productoId") Long productoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO items (cantidad, precio, ordendecompra_codigo, producto_codigodebarras) VALUES (:cantidad, :precio, :ordendecompra_codigo, :producto_codigodebarras)", nativeQuery = true)
    void insertItem(@Param("cantidad") Integer cantidad,
                    @Param("precio") Integer precio,
                    @Param("ordendecompra_codigo") Integer ordendecompra_codigo, 
                    @Param("producto_codigodebarras") String producto_codigodebarras);

    // @Modifying
    // @Transactional
    // @Query(value = "UPDATE items SET cantidad = :cantidad, precio = :precio WHERE ordendecompra = :ordenId AND producto = :productoId", nativeQuery = true)
    // void updateItem(@Param("ordenId") Long ordenId, 
    //                 @Param("productoId") Long productoId,
    //                 @Param("cantidad") Integer cantidad, 
    //                 @Param("precio") Integer precio);

    // @Modifying
    // @Transactional
    // @Query(value = "DELETE FROM items WHERE ordendecompra = :ordenId AND producto = :productoId", nativeQuery = true)
    // void deleteItem(@Param("ordenId") Long ordenId, 
    //                 @Param("productoId") Long productoId);
}
