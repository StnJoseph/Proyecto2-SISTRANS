package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="reuniones")

public class reuniones extends servicios {

    // Atributos
    private Integer capacidad;
    private Integer costoadicional;
    private Date fecha;
    private Time hora;
    private Integer duracion;


    // Constructor
    public reuniones(Integer capacidad, Integer costoadicional, Date fecha, Time hora, Integer duracion, Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, Integer idservicio, reserva reserva)
    {
        super();
        this.capacidad = capacidad;
        this.costoadicional = costoadicional;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }


    public reuniones(){;}


    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCostoadicional() {
        return costoadicional;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public Integer getDuracion() {
        return duracion;
    }


    // Setters
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCostoadicional(Integer costoadicional) {
        this.costoadicional = costoadicional;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
}
