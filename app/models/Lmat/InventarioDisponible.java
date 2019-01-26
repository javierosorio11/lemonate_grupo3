package models.Lmat;

import models.GenericEntity;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "InventarioDisponible.findReferenceInLatesInv", query = "select invd from InventarioDisponible invd where invd.tienda=:tienda and upper(invd.almacen) in('SAT','WPSAT','REM') and invd.codigo_articulo =:articleCode and invd.dia_inventario in (select max(invd.dia_inventario) from InventarioDisponible invd where invd.codigo_articulo=:articleCode)")
})
@Table(name = "inventario_disponible")
public class InventarioDisponible extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @Column
    private String id;

    /**
     * almacen en el que se encuentra
     */
    @Column
    private String almacen;

    /**
     * dia del inventario
     */
    @Column
    private Date dia_inventario;
    /**
     * inventario disponible del inventario fisico
     */
    @Column
    private String fisica_disponible;
    /**
     * inventario reservado del inventario fisico
     */
    @Column
    private String fisica_reservada;
    /**
     * inventario fisico
     */
    @Column
    private String inventario_fisico;

    /**
     * tienda en la que se encuentra ubicado
     */
    @Column
    private String tienda;

    /**
     * Atributo madre
     */
    @Column
    private String codigo_articulo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public Date getDia_inventario() {
        return dia_inventario;
    }

    public void setDia_inventario(Date dia_inventario) {
        this.dia_inventario = dia_inventario;
    }

    public String getFisica_disponible() {
        return fisica_disponible;
    }

    public void setFisica_disponible(String fisica_disponible) {
        this.fisica_disponible = fisica_disponible;
    }

    public String getFisica_reservada() {
        return fisica_reservada;
    }

    public void setFisica_reservada(String fisica_reservada) {
        this.fisica_reservada = fisica_reservada;
    }

    public String getInventario_fisico() {
        return inventario_fisico;
    }

    public void setInventario_fisico(String inventario_fisico) {
        this.inventario_fisico = inventario_fisico;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }
}
