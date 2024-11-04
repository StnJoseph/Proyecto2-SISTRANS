package uniandes.edu.co.proyecto.controller;

import java.util.Optional;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository.ProductoInventarioDeProductos;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository.ProductoReorden;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public ResponseEntity<Collection<Producto>> daProducto() {
        try {
            Collection<Producto> productos = productoRepository.findAllProductos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

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
    public ResponseEntity<?> actualizarProducto(@PathVariable("codigo_de_barras") String codigo_de_barras, @RequestBody Producto producto) {
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

    // RFC2
    @GetMapping("/productos/{post}/{precio_min}/{precio_max}/{fecha}/{sucursal}/{categoria}")
    public ResponseEntity<?> getProductosConCaracteristicas(@PathVariable("precio_max") float precio_max, @PathVariable("precio_min") float precio_min, @PathVariable("post") Integer post, @PathVariable("fecha") String fecha, @PathVariable("sucursal") String sucursal, @PathVariable("categoria") Integer categoria ){
        try {
            if (post == 1){
                Optional<Collection<Producto>> productos = productoRepository.findProductosCaracteristicasInferior(precio_min, precio_max, fecha, categoria, sucursal);
                return new ResponseEntity<>(productos, HttpStatus.OK);
            }
            else{
                Optional<Collection<Producto>> productos = productoRepository.findProductosCaracteristicasPosterior(precio_min, precio_max, fecha, categoria, sucursal);
                return new ResponseEntity<>(productos, HttpStatus.OK);
            }
            } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // RFC3
    @GetMapping("/productos/{idSucursal}/{idBodega}")
    public ResponseEntity<?> getAllProductosSucursalBodega(@PathVariable("idSucursal") String nombreSucursal, @PathVariable("idBodega") String nombreBodega) {
        try {
            Optional<Collection<ProductoInventarioDeProductos>> productos = productoRepository.findAllProductosSucursalBodega(nombreSucursal, nombreBodega);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // RFC5
    @GetMapping("/productos/reorden")
    public ResponseEntity<?> darProductosReorden() {
        try {
            Optional<Collection<ProductoReorden>> productos = productoRepository.findProductosReorden();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}