package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Item;
import uniandes.edu.co.proyecto.repositorio.ItemRepository;


@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    
    @PostMapping("/items/new/save")
    public ResponseEntity<String> crearUnItem(@RequestBody Item item) {
        try {
            itemRepository.insertItem(item.getCantidad(), item.getPrecio(), item.getPk().getOrdendecompra_codigo().getCodigo(), item.getPk().getProducto_codigodebarras().getCodigoDeBarras());
            return new ResponseEntity<>("Item creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el Item", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/items/{codigo}/new/save")
    public ResponseEntity<String> crearItemsOrdenDeCompra(@PathVariable("codigo") Integer codigo, @RequestBody List<Item> items) {
        try {
            for (Item item : items) {
                itemRepository.insertItem(item.getCantidad(), item.getPrecio(), codigo, item.getPk().getProducto_codigodebarras().getCodigoDeBarras());
            }
            return new ResponseEntity<>("Items creados exitosamente para la Orden de Compra", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear los Items para la Orden de Compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/items")
    public ResponseEntity<Collection<Item>> darItems() {
        try {
            Collection<Item> items = itemRepository.findAllItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
