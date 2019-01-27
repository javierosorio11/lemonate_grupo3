package controllers.core.main.helpers;

import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.data.DynamicForm;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import models.Articulo;
import java.util.function.Supplier;

public class MainHelper {

    public String registration(DynamicForm dynamicForm){
        try{
            Articulo articulo=new Articulo();
            articulo.setUserName(dynamicForm.get("nombre"));
            articulo.setArticleType(dynamicForm.get("tipo_inmueble"));
            articulo.setEstrato(dynamicForm.get("estrato"));
            articulo.setDirection(dynamicForm.get("dr1")+" "+dynamicForm.get("dr2")+" "+dynamicForm.get("dr3")+dynamicForm.get("dr4")+" - "+dynamicForm.get("dr5"));
            articulo.setArticleName(dynamicForm.get("nombre_inmueble"));
            articulo.setUserId(dynamicForm.get("cedula"));
            articulo.setMetraje(dynamicForm.get("metraje"));
            articulo.save();
        }catch(Exception exeption){
            return "noData";
        }
        return "succes";
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

