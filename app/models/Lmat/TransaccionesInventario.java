package models.Lmat;

import models.GenericEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "TransaccionesInventario.findAllAfterDateAndCode", query = "select sum(cast(ti.cantidad as long)) from TransaccionesInventario ti where ti.codigo_articulo=:articleCode and ti.fecha_financiera >= :invDate")
})
@Table(name = "transacciones_inventario")
public class TransaccionesInventario extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @Column
    private String id;
    /**
     * almacen al que llega
     */
    @Column
    private String almacen;
    /**
     * cantidad de unidades
     */
    @Column
    private String cantidad;
    /**
     * Codigo del articulo
     */
    @Column
    private String codigo_articulo;
    /**
     * estado en el que se encuentra el envio
     */
    @Column
    private String estado_emision;

    /**
     * fecha de llegada
     */
    @Column
    private Date fecha_financiera;
    /**
     * is del registro
     */
    @Column
    private String id_registro;
    /**
     * costo de compra
     */
    @Column
    private String importe_costo_financiero;
    /**
     * tienda a la que llega
     */
    @Column
    private String store;

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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getEstado_emision() {
        return estado_emision;
    }

    public void setEstado_emision(String estado_emision) {
        this.estado_emision = estado_emision;
    }

    public Date getFecha_financiera() {
        return fecha_financiera;
    }

    public void setFecha_financiera(Date fecha_financiera) {
        this.fecha_financiera = fecha_financiera;
    }

    public String getId_registro() {
        return id_registro;
    }

    public void setId_registro(String id_registro) {
        this.id_registro = id_registro;
    }

    public String getImporte_costo_financiero() {
        return importe_costo_financiero;
    }

    public void setImporte_costo_financiero(String importe_costo_financiero) {
        this.importe_costo_financiero = importe_costo_financiero;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
