package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofrecen")
public class Ofrecen {

    
    @EmbeddedId
    private OfrecenPK pk;
    

    public Ofrecen() {
    }

    public Ofrecen(OfrecenPK pk) {
        this.pk = pk;
    }

    
    public OfrecenPK getId() {
        return pk;
    }

  
    public void setId(OfrecenPK id) {
        this.pk = id;
    }
}

