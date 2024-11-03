package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.BodegaProductoRepository;

@RestController
public class BodegaProductoController {

    @Autowired
    private BodegaProductoRepository bodegaProductoRepository;

    @GetMapping("/consulta_documentos_serializable")
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public List<BodegaProductoRepository.DocumentoIngreso> consultarDocumentosSerializable(
        @RequestParam String nombreSucursal, 
        @RequestParam String nombreBodega
    ) {

        System.out.println("Sucursal: " + nombreSucursal);
        System.out.println("Bodega: " + nombreBodega);

        try {
            
            Thread.sleep(100);

            // Llama directamente al repository
            List<BodegaProductoRepository.DocumentoIngreso> documentos = 
                bodegaProductoRepository.findDocumentosIngresoBodega(nombreSucursal, nombreBodega);

            if (documentos.isEmpty()) {
                System.out.println("no funciona mi bro skill issue");
            } else {
                System.out.println("Documentos encontrados: " + documentos.size());
            }

            return documentos;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consulta interrumpida: " + e.getMessage());
            return List.of();

        } catch (Exception e) {
            System.err.println("Error en consulta SERIALIZABLE: " + e.getMessage());
            return List.of();
        }
    }
}





