package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.RecepcionDeProducto;

public interface RecepcionDeProductoRepository extends JpaRepository<RecepcionDeProducto, Integer> {

    @Query(value = "SELECT * FROM recepciondeproductos", nativeQuery = true)
    Collection<RecepcionDeProducto> findAllRecepcionesDeProducto();

    @Query(value = "SELECT * FROM recepciondeproductos WHERE idrecepcion = :idrecepcion", nativeQuery = true)
    RecepcionDeProducto findRecepcionesDeProductoById(@Param("idrecepcion") int idrecepcion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recepciondeproductos (idrecepcion, fecha_ingreso, bodega_nombre, ordendecompra_codigo) VALUES (:idrecepcion, SYSDATE, :bodega_nombre, :ordendecompra_codigo)", nativeQuery = true)
    void insertRecepcionDeProducto(@Param("idrecepcion") int idrecepcion, @Param("bodega_nombre") String bodega_nombre, @Param("ordendecompra_codigo") Integer ordendecompra_codigo);

}