package models;

import play.Logger;
import play.db.jpa.JPA;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

public abstract class GenericEntity {
    public void save() {
        JPA.em().persist(this);
    }

    public void delete() {
        JPA.em().remove(this);
    }

    public void update() {
        JPA.em().merge(this);
    }

    @SuppressWarnings("rawtypes")
    public static List findAll(Class pClass) {
        return JPA.em().createQuery("from " + pClass.getName()).getResultList();
    }

    public static Object findByAttribute(String attribute, String value,
                                  @SuppressWarnings("rawtypes")
                                          Class pClass) {
        Query query = JPA.em().createQuery("from " + pClass.getName() + " where "+attribute+" = '"+ value+"'");
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException nure) {
            Logger.warn("findById attribute - >" + attribute, nure);
            return query.getResultList().get(0);
        } catch (NoResultException nre) {
            Logger.warn("findById attribute - >" + attribute, nre);
            return null;
        }
    }
    public static Object findAllByAttribute(String attribute, String value,
                                         @SuppressWarnings("rawtypes")
                                                 Class pClass) {
        Query query = JPA.em().createQuery("from " + pClass.getName() + " where "+attribute+" = '"+ value+"'");
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            Logger.warn("findById attribute - >" + attribute, nre);
            return null;
        }
    }

}
