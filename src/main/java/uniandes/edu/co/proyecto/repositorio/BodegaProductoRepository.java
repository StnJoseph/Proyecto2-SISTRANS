package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaProductoRepository extends JpaRepository<Bodega, String> {

    @Query(value = "SELECT s.nombre AS nombreSucursal, " +
                   "b.nombre AS nombreBodega, " +
                   "p.nombre AS nombreProveedor, " +
                   "o.codigo AS numeroDocumento, " +
                   "o.fecha_creacion AS fechaDocumento " +
                   "FROM sucursales s " +
                   "JOIN bodegas b ON b.nombre_sucursal = s.nombre " +
                   "JOIN recepciondeproductos rp ON rp.bodega_nombre = b.nombre " +
                   "JOIN ordenesdecompra o ON o.codigo = rp.ordendecompra_codigo " +
                   "JOIN proveedores p ON p.nit = o.proveedor_nit " +
                   "WHERE UPPER(s.nombre) = UPPER(:nombreSucursal) " +
                   "AND UPPER(b.nombre) = UPPER(:nombreBodega) " +
                   "AND o.fecha_creacion >= SYSDATE - 30", 
           nativeQuery = true)
    List<Object[]> findDocumentosIngresoBodega(
            @Param("nombreSucursal") String nombreSucursal, 
            @Param("nombreBodega") String nombreBodega
    );

    @Query(value = "SELECT s.nombre AS nombreSucursal, " +
                   "b.nombre AS nombreBodega, " +
                   "p.nombre AS nombreProveedor, " +
                   "o.codigo AS numeroDocumento, " +
                   "o.fecha_creacion AS fechaDocumento " +
                   "FROM sucursales s " +
                   "JOIN bodegas b ON b.nombre_sucursal = s.nombre " +
                   "JOIN recepciondeproductos rp ON rp.bodega_nombre = b.nombre " +
                   "JOIN ordenesdecompra o ON o.codigo = rp.ordendecompra_codigo " +
                   "JOIN proveedores p ON p.nit = o.proveedor_nit " +
                   "WHERE s.nombre = 'Sucursal Norte' " +
                   "AND b.nombre = 'Bodega Central' " +
                   "AND o.fecha_creacion >= SYSDATE - 30", 
           nativeQuery = true)
    List<Object[]> findDocumentosIngresoBodegaHardcoded();
}








                                                        

        
        

