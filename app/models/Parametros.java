package models;

import javax.persistence.*;

@Entity
@NamedQueries({

})
@Table(name = "parametros")
public class Parametros extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_id_param;

    /**
     * Nombre de usuario
     */
    @Column
    private String vch_descripcion;

    /**
     * Nombre de usuario
     */
    @Column
    private String vch_valor;

    public Long getNum_id_param() {
        return num_id_param;
    }

    public void setNum_id_param(Long num_id_param) {
        this.num_id_param = num_id_param;
    }

    public String getVch_descripcion() {
        return vch_descripcion;
    }

    public void setVch_descripcion(String vch_descripcion) {
        this.vch_descripcion = vch_descripcion;
    }

    public String getVch_valor() {
        return vch_valor;
    }

    public void setVch_valor(String vch_valor) {
        this.vch_valor = vch_valor;
    }
}
