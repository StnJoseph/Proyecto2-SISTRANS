package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/producto/new/save")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try {
            productoRepository.insertProducto(producto.getCodigoDeBarras(), producto.getNombre(), producto.getCostoEnBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadDeMedida(), producto.getVolumen(), producto.getPeso(), producto.getCategoria_codigo().getCodigo());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear Producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PostMapping("/producto/{id}/edit/save")
    // public ResponseEntity<?> productoEditarGuardar(@PathVariable("id") String id, @RequestBody Producto producto) {
    //     try {

    //         Producto existingProducto = productoRepository.findById(id).orElse(null);
    //         if (existingProducto == null) {
    //             return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
    //         }

    //         productoRepository.updateProducto(
    //             id,
    //             producto.getNombreProducto(),
    //             producto.getCostoEnBodega(),
    //             producto.getPrecioUnitario(),
    //             producto.getPresentacion(),
    //             producto.getCantidadPresentacion(),
    //             producto.getUnidadDeMedida(),
    //             producto.getVolumen(),
    //             producto.getPeso(),
    //             producto.getCategoria().getCodigoCategoria()
    //         );

    //         return ResponseEntity.ok("Producto actualizado exitosamente");
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Error al editar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("/producto/{id}")
    // public ResponseEntity<Producto> darProducto(@PathVariable("id") String id) {
    //     try {
    //         Producto producto = productoRepository.findProductoByCodigoDeBarras(id);
    //         return ResponseEntity.ok(producto);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // } 
}