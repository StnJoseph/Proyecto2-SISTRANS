package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;

@RestController
public class OrdenCompraController {

    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;
    
    @PostMapping("/ordenesdecompra/new/save")
    public ResponseEntity<String> crearOrdenCompra(@RequestBody OrdenDeCompra ordenDeCompra) {
        try {
            ordenDeCompraRepository.insertOrdenCompra(ordenDeCompra.getCodigo(), ordenDeCompra.getFechaEntrega(), ordenDeCompra.getProveedor_nit().getNit(), ordenDeCompra.getSucursal_nombre().getNombre());
            return new ResponseEntity<>("Orden de Compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la Orden de Compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordenesdecompra/{codigo}")
    public ResponseEntity<OrdenDeCompra> darProducto(@PathVariable Integer codigo) {
        try {
            Optional<OrdenDeCompra> ordendecompra = ordenDeCompraRepository.findOrdenCompraByCodigo(codigo);
            return new ResponseEntity<>(ordendecompra.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } 
    
    @PostMapping("/ordenesdecompra/{codigo}/anular")
    public ResponseEntity<?> anularOrdenCompra(@PathVariable("codigo") Integer numero) {
        try {
            String estadoActual = ordenDeCompraRepository.findEstadoByCodigo(numero);
            if (estadoActual == "ANULADA") {
                return new ResponseEntity<>("La orden de compra ya ha sido entregada y no puede ser anulada", HttpStatus.BAD_REQUEST);
            }
            else {
                ordenDeCompraRepository.updateEstadoOrdenCompra(numero);
            }
            return ResponseEntity.ok("Orden de compra anulada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al anular la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordenesdecompra")
    public ResponseEntity<Collection<OrdenDeCompra>> darOrdenesDeCompra() {
        try {
            Collection<OrdenDeCompra> ordenDeCompra = ordenDeCompraRepository.findAllOrdenesCompra();
            return ResponseEntity.ok(ordenDeCompra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
