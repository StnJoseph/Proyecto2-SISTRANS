package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    //Atributos
    @Id
    private String codigo_de_barras;
    private String nombre;
    private Double costo_en_bodega;
    private Double precio_unitario;
    private String presentacion;
    private Integer cantidad_presentacion;
    private String unidad_de_medida;
    private Double volumen;
    private Double peso;

    @ManyToOne
    @JoinColumn(name="categoria_codigo", referencedColumnName="codigo")
    private Categoria categoria_codigo;

    //Constructor
    public Producto(String codigo_de_barras, String nombre, Double costo_en_bodega, Double precio_unitario, String presentacion, Integer cantidad_presentacion, String unidad_de_medida, Double peso, Double volumen, Categoria categoria_codigo) {
        this.codigo_de_barras = codigo_de_barras;
        this.nombre = nombre;
        this.costo_en_bodega = costo_en_bodega;
        this.precio_unitario = precio_unitario;
        this.presentacion = presentacion;
        this.cantidad_presentacion = cantidad_presentacion;
        this.unidad_de_medida = unidad_de_medida;
        this.volumen = volumen;
        this.peso = peso;
        this.categoria_codigo = categoria_codigo;
    }

    //Constructor vacio
    public Producto() {;}

    //GETTERS
    public String getCodigoDeBarras() {
        return codigo_de_barras;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCostoEnBodega() {
        return costo_en_bodega;
    }

    public Double getPrecioUnitario() {
        return precio_unitario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public Integer getCantidadPresentacion() {
        return cantidad_presentacion;
    }

    public String getUnidadDeMedida() {
        return unidad_de_medida;
    }

    public Double getVolumen() {
        return volumen;
    }

    public Double getPeso() {
        return peso;
    }

    public Categoria getCategoria_codigo() {
        return categoria_codigo;
    }

    //SETTERS
    public void setCodigoDeBarras(String codigo_de_barras) {
        this.codigo_de_barras = codigo_de_barras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoEnBodega(Double costo_en_bodega) {
        this.costo_en_bodega = costo_en_bodega;
    }

    public void setPrecioUnitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setCantidadPresentacion(Integer cantidad_presentacion) {
        this.cantidad_presentacion = cantidad_presentacion;
    }

    public void setUnidadDeMedida(String unidad_de_medida) {
        this.unidad_de_medida = unidad_de_medida;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setCategoria_codigo(Categoria categoria_codigo) {
        this.categoria_codigo = categoria_codigo;
    }
}