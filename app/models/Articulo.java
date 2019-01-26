package models.users;

import models.GenericEntity;

import javax.persistence.*;

@Entity
@NamedQueries({

})
@Table(name = "articulo")
public class Articulo extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario
     */
    @Column
    private String userName;

    /**
     * Cedula
     */
    @Column
    private String userId;

    /**
     * Tipo de articulo
     */
    @Column
    private String articleType;

    /**
     * Direccion
     */
    @Column
    private String direction;
    /**
     * estrato
     */
    @Column
    private String estrato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }
}