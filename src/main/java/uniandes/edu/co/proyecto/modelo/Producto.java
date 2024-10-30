package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoDeBarras;
    private String nombre;
    private Double costoEnBodega;
    private Double precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadDeMedida;
    private Double volumen;
    private Double peso;

    @ManyToOne
    @JoinColumn(name="categoria_codigo", referencedColumnName="codigo")
    private Categoria categoria_codigo;

    //Constructor
    public Producto(String codigoDeBarras, String nombre, Double costoEnBodega, Double precioUnitario, String presentacion, Integer cantidadPresentacion, String unidadDeMedida, Double peso, Double volumen, Categoria categoria_codigo) {
        this.codigoDeBarras = codigoDeBarras;
        this.nombre = nombre;
        this.costoEnBodega = costoEnBodega;
        this.precioUnitario = precioUnitario;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadDeMedida = unidadDeMedida;
        this.peso = peso;
        this.volumen = volumen;
        this.categoria_codigo = categoria_codigo;
    }

    //Constructor vacio
    public Producto() {;}

    //GETTERS
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCostoEnBodega() {
        return costoEnBodega;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public Integer getCantidadPresentacion() {
        return cantidadPresentacion;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
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
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoEnBodega(Double costoEnBodega) {
        this.costoEnBodega = costoEnBodega;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
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