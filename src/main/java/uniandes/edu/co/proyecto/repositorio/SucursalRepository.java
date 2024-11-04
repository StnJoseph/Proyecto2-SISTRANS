package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, String> {

    @Query(value = "SELECT * FROM sucursales", nativeQuery = true)
    Collection<Sucursal> findAllSucursales();   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) VALUES (:nombre, :tamanio, :direccion, :telefono, :codigo_ciudad)", nativeQuery = true)
    void insertSucursal(@Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("direccion") String direccion, @Param("telefono") Integer telefono, @Param("codigo_ciudad") Integer codigo_ciudad);

    // RFC4
    @Query(value = "SELECT s.nombre, s.tamanio, s.direccion, s.telefono, s.codigo_ciudad FROM sucursales s INNER JOIN bodegas b ON s.nombre = b.nombre_sucursal INNER JOIN inventariodeproductos i ON b.nombre = i.bodega_nombre INNER JOIN productos p ON p.codigo_de_barras = i.producto_codigodebarras WHERE p.codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    Collection<Sucursal> findAllSucursalesconProducto(@Param("codigo_de_barras") String codigo_de_barras);
}