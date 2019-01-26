package models.Lmat;

import models.GenericEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lmat")
public class Lmat extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @Column
    private String bum_number;
    /**
     * Id entidad.
     */

    @Column
    private String item_number;

    /**
     * lmatHija
     */

    @Column
    private Long cantidad;

    public String getBum_number() {
        return bum_number;
    }

    public void setBum_number(String bum_number) {
        this.bum_number = bum_number;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
