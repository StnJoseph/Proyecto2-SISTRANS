package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.RecepcionDeProducto;

public interface RecepcionDeProductoRepository extends JpaRepository<RecepcionDeProducto, Integer> {

    @Query(value = "SELECT * FROM recepcion_de_producto", nativeQuery = true)
    Collection<RecepcionDeProducto> findAllRecepciones();

    @Query(value = "SELECT * FROM recepcion_de_producto WHERE id = :id", nativeQuery = true)
    RecepcionDeProducto findRecepcionById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recepcion_de_producto (id, fecha, cantidad, calidad) VALUES (:id, :fecha, :cantidad, :calidad)", nativeQuery = true)
    void insertRecepcion(@Param("id") int id, @Param("fecha") String fecha, @Param("cantidad") Integer cantidad, @Param("calidad") String calidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE recepcion_de_producto SET fecha = :fecha, cantidad = :cantidad, calidad = :calidad WHERE id = :id", nativeQuery = true)
    void updateRecepcion(@Param("id") int id, @Param("fecha") String fecha, @Param("cantidad") Integer cantidad, @Param("calidad") String calidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recepcion_de_producto WHERE id = :id", nativeQuery = true)
    void deleteRecepcion(@Param("id") int id);
}
