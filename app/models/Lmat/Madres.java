package models.Lmat;

import models.GenericEntity;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "madres_disponibles")
public class Madres extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @Column
    private String codigo_de_articulo;
    /**
     * categoria
     */
    @Column
    private String categoria;
    /**
     * Color del articulo
     */
    @Column
    private String color;
    /**
     * id del color
     */
    @Column
    private String colour_id;
    /**
     * descripcion del articulo
     */
    @Column
    private String descripcion;
    /**
     * Estado del articulo para comprobar obsolescencia
     */
    @Column
    private String estado;

    /**
     * grupo al que pertence el articulo
     */
    @Column
    private String grupo_de_articulos;
    /**
     * descripcion del articulo
     */
    @Column
    private String imagen;

    /**
     * si es mainSelection o no
     */
    @Column
    private String main_selection;

    /**
     * Nombre del articulo
     */

    @Column
    private String nombre_del_articulo;

    /**
     * valor de venta del articulo
     */
    @Column
    private String precio;

    /**
     * si es sale o no
     */
    @Column
    private String sale;

    /**
     * tamaño
     */
    @Column
    private String size_id;


    /**
     * tipo de articulo
     */
    @Column
    private String tipo_de_articulo;


    public String getCodigo_de_articulo() {
        return codigo_de_articulo;
    }

    public void setCodigo_de_articulo(String codigo_de_articulo) {
        this.codigo_de_articulo = codigo_de_articulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColour_id() {
        return colour_id;
    }

    public void setColour_id(String colour_id) {
        this.colour_id = colour_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGrupo_de_articulos() {
        return grupo_de_articulos;
    }

    public void setGrupo_de_articulos(String grupo_de_articulos) {
        this.grupo_de_articulos = grupo_de_articulos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMain_selection() {
        return main_selection;
    }

    public void setMain_selection(String main_selection) {
        this.main_selection = main_selection;
    }

    public String getNombre_del_articulo() {
        return nombre_del_articulo;
    }

    public void setNombre_del_articulo(String nombre_del_articulo) {
        this.nombre_del_articulo = nombre_del_articulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getSize_id() {
        return size_id;
    }

    public void setSize_id(String size_id) {
        this.size_id = size_id;
    }

    public String getTipo_de_articulo() {
        return tipo_de_articulo;
    }

    public void setTipo_de_articulo(String tipo_de_articulo) {
        this.tipo_de_articulo = tipo_de_articulo;
    }
}
