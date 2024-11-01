package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;

public interface OrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {

    @Query(value = "SELECT * FROM ordenesdecompra", nativeQuery = true)
    Collection<OrdenDeCompra> findAllOrdenesCompra();

    @Query(value = "SELECT * FROM ordenesdecompra WHERE codigo = :codigo", nativeQuery = true)
    Optional<OrdenDeCompra> findOrdenCompraByCodigo(@Param("codigo") int codigo);

    // @Query(value = "SELECT estado FROM ordenesdecompra WHERE codigo = :codigo", nativeQuery = true)
    // Optional<OrdenDeCompra> findEstadoByCodigo(@Param("codigo") int codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenesdecompra (codigo, fecha_creacion, fecha_entrega, estado, proveedor_nit, sucursal_nombre) VALUES (:codigo, SYSDATE, :fechaEntrega, 'VIGENTE', :proveedor_nit, :sucursal_nombre)", nativeQuery = true)
    void insertOrdenCompra(@Param("codigo") int codigo, @Param("fechaEntrega") Date fechaEntrega, @Param ("proveedor_nit") Integer proveedor_nit, @Param ("sucursal_nombre") String sucursal_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenesdecompra SET estado = 'ANULADA' WHERE codigo = :codigo", nativeQuery = true)
    void updateEstadoOrdenCompra(@Param("codigo") int codigo);

}