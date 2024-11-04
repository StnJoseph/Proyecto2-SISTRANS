package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.RecepcionDeProducto;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;
import uniandes.edu.co.proyecto.repositorio.RecepcionDeProductoRepository;

@RestController
public class RecepcionDeProductoController {

    @Autowired
    private RecepcionDeProductoRepository recepcionDeProductoRepository;

    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;
    
    @PostMapping("/recepciondeproductos/{codigo}/new/save")
    public ResponseEntity<String> crearRecepcionDeProductos(@PathVariable("codigo") Integer codigo, @RequestBody RecepcionDeProducto recepcionDeProducto) {
        try {
            String estadoActual = ordenDeCompraRepository.findEstadoByCodigo(codigo);

            if ("ANULADA".equals(estadoActual)) {
                return new ResponseEntity<>("La orden de compra fue anulada, no puede registrarse", HttpStatus.BAD_REQUEST);
            }
            else if ("ENTREGADA".equals(estadoActual)){
                return new ResponseEntity<>("La orden de compra ya ha sido entregada", HttpStatus.BAD_REQUEST);
            }
            else {
                recepcionDeProductoRepository.insertRecepcionDeProducto(recepcionDeProducto.getIdrecepcion(), recepcionDeProducto.getBodega_nombre().getNombre(), codigo);
                ordenDeCompraRepository.updateEstadoOrdenCompraEntregada(codigo);
                return new ResponseEntity<>("Recepcion de productos registrada exitosamente", HttpStatus.CREATED);
            }
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar la recepcion de productos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/recepciondeproductos")
    public ResponseEntity<Collection<RecepcionDeProducto>> darRecepcionesDeProducto() {
        try {
            Collection<RecepcionDeProducto> recepciones = recepcionDeProductoRepository.findAllRecepcionesDeProducto();
            return ResponseEntity.ok(recepciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
