package uniandes.edu.co.proyecto.controller;

import java.util.Optional;
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

    @PostMapping("/productos/new/save")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try {
            productoRepository.insertProducto(producto.getCodigoDeBarras(), producto.getNombre(), producto.getCostoEnBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadDeMedida(), producto.getVolumen(), producto.getPeso(), producto.getCategoria_codigo().getCodigo());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear Producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/productos/{codigo_de_barras}/edit/save")
    public ResponseEntity<?> productoEditarGuardar(@PathVariable("codigo_de_barras") String codigo_de_barras, @RequestBody Producto producto) {
        try {

            Producto existingProducto = productoRepository.findById(codigo_de_barras).orElse(null);
            if (existingProducto == null) {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
            else {
                productoRepository.updateProducto(
                    codigo_de_barras,
                    producto.getNombre(),
                    producto.getCostoEnBodega(),
                    producto.getPrecioUnitario(),
                    producto.getPresentacion(),
                    producto.getCantidadPresentacion(),
                    producto.getUnidadDeMedida(),
                    producto.getVolumen(),
                    producto.getPeso(),
                    producto.getCategoria_codigo().getCodigo()
                );
                return ResponseEntity.ok("Producto actualizado exitosamente");
            } 
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/codigo/{codigo_de_barras}")
    public ResponseEntity<Producto> darProducto(@PathVariable String codigo_de_barras) {
        try {
            Optional<Producto> producto = productoRepository.findProductoByCodigoDeBarras(codigo_de_barras);
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } 

    @GetMapping("/productos/nombre/{nombre}")
    public ResponseEntity<?> darProductoPorNombre(@PathVariable String nombre) {
        try {
            Optional<Producto> producto = productoRepository.findProductoByNombre(nombre);
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al leer el producto: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}