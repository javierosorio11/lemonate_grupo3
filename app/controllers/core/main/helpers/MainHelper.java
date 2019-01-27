package controllers.core.main.helpers;

import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.data.DynamicForm;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.function.Supplier;

public class MainHelper {

    public String registration(DynamicForm dynamicForm){

        try{

        }catch(Exception exeption){
            return "noData";
        }
        return "";
    }

    public boolean validateStrato(String calle, String carrera, long estrato){

        boolean valido=false;
        Query query=JPA.em().createQuery("select e.strato from estrato e where carrera = :carrera and calle = :calle");
        query.setParameter("carrera", carrera);
        query.setParameter("calle", calle);
        Long estratoBD = (Long) query.getSingleResult();

        try{
            if(estrato==estratoBD){

                valido=true;

            }

        }catch(Exception exeption){

        }

        return valido;
    }

    public Double valorPrima(Long valorInmueble){

        Query queryPP=JPA.em().createQuery("select p.valor from parametros p where parametro = 'porcentajePrima'");
        Long porcentajePrima = (Long) queryPP.getSingleResult();

        Query queryPC=JPA.em().createQuery("select p.valor from parametros p where parametro = 'porcentajeComision'");
        Long porcentajeComision = (Long) queryPC.getSingleResult();

        Query queryPD=JPA.em().createQuery("select p.valor from parametros p where parametro = 'devision'");
        Long division = (Long) queryPD.getSingleResult();


        double valorPrima=0;

        valorPrima=((valorInmueble * porcentajePrima/100)/division)* porcentajeComision / 100;





        return valorPrima;
    }

}

