package uniandes.edu.co.proyecto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.repositorio.BodegaProductoRepository;

@Service
public class BodegaProductoService {

    @Autowired
    private BodegaProductoRepository bodegaProductoRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public List<Map<String, Object>> obtenerDocumentosIngreso(String nombreSucursal, String nombreBodega) throws InterruptedException {
        Thread.sleep(100);  
        List<Object[]> resultados = bodegaProductoRepository.findDocumentosIngresoBodega(nombreSucursal, nombreBodega);
        return procesarResultados(resultados);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<Map<String, Object>> obtenerDocumentosIngresoReadCommitted(String nombreSucursal, String nombreBodega) throws InterruptedException {
        Thread.sleep(100);  
        List<Object[]> resultados = bodegaProductoRepository.findDocumentosIngresoBodega(nombreSucursal, nombreBodega);
        return procesarResultados(resultados);
    }

    
    private List<Map<String, Object>> procesarResultados(List<Object[]> resultados) {
        List<Map<String, Object>> documentos = new ArrayList<>();
        for (Object[] fila : resultados) {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("nombreSucursal", fila[0]);
            mapa.put("nombreBodega", fila[1]);
            mapa.put("nombreProveedor", fila[2]);
            mapa.put("numeroDocumento", fila[3]);
            mapa.put("fechaDocumento", fila[4]);
            documentos.add(mapa);
        }
        return documentos;
    }
}

