package models.users;

import models.GenericEntity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.authTenticate", query = "select u from User u where u.name = :name and u.password= :password")
})
@Table(name = "usersAccess")
public class User extends GenericEntity {
    /**
     * Id entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Atributo para guardar la llave del nombre del estado
     */
    @Column
    private String name;

    /**
     * Atributo para guardar la llave del nombre del estado
     */
    @Column
    private String password;

    /**
     * Atributo para guardar la llave del nombre del estado
     */
    @Column
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
