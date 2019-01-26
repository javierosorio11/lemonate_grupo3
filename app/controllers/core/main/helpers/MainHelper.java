package controllers.core.main.helpers;

import models.users.User;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.function.Supplier;

public class MainHelper {
    private final JPAApi jpaApi;
    @Inject
    public MainHelper(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    /**
     * Metodo para autenticarse
     * @param name
     * @param password
     * @return
     */
    public User authenticate(String name, String password){
            Query query = JPA.em().createNamedQuery("User.authTenticate").setParameter("name", name).setParameter("password",password);
            try {
                return  (User) query.getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
    }
}
