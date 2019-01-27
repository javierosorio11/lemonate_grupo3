package models;

import javax.persistence.*;

@Entity
@NamedQueries({

})
@Table(name = "estrato")
public class Estrato extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de estrato
     */
    @Column
    private Long estrato;

    /**
     * Calle
     */
    @Column
    private Long calle;

    /**
     * carrera
     */
    @Column
    private Long carrera;


    public Long getEstrato() {
        return estrato;
    }

    public void setEstrato(Long estrato) {
        this.estrato = estrato;
    }

    public Long getCalle() {
        return calle;
    }

    public void setCalle(Long calle) {
        this.calle = calle;
    }

    public Long getCarrera() {
        return carrera;
    }

    public void setCarrera(Long carrera) {
        this.carrera = carrera;
    }
}
