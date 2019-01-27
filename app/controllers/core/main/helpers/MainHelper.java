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

    public Articulo registration(DynamicForm dynamicForm){
        try{
            Articulo articulo=new Articulo();
            articulo.setUserName(dynamicForm.get("nombre"));
            articulo.setArticleType(dynamicForm.get("tipomueble"));
            articulo.setEstrato(dynamicForm.get("estrato"));
            articulo.setDirection(dynamicForm.get("dr1")+" "+dynamicForm.get("dr2")+" "+dynamicForm.get("dr3")+dynamicForm.get("dr4")+" - "+dynamicForm.get("dr5"));
            articulo.setArticleName(dynamicForm.get("nombremueble"));
            articulo.setUserId(dynamicForm.get("cedula"));
            articulo.setMetraje(dynamicForm.get("metraje"));
            articulo.setValor(Double.parseDouble(dynamicForm.get("valor")));
            articulo.save();
            return articulo;
        }catch(Exception exeption){
            return null;
        }

    }


    public Boolean validationArticle(DynamicForm dynamicForm){
        try {
            String calle = "";
            String carrera = "";
            String estrato = dynamicForm.get("estrato");
            if (dynamicForm.get("dr1").equals("Calle")) {
                calle = dynamicForm.get("dr2");
            } else if (dynamicForm.get("dr1").equals("Carrera")) {
                carrera = dynamicForm.get("dr2");
            }
            if (dynamicForm.get("dr3").equals("Calle")) {
                calle = dynamicForm.get("dr4");
            } else if (dynamicForm.get("dr3").equals("Carrera")) {
                carrera = dynamicForm.get("dr4");
            }
            return validateStrato(calle, carrera, Long.parseLong(estrato));
        }catch (Exception e){
            return true;
        }
    }


    public boolean validateStrato(String calle, String carrera, Long estrato){
        Long carreraLong = Long.parseLong(carrera);
        Long calleLong = Long.parseLong(calle);
        Long estratoToCompare=0L;
        if(carreraLong<=20 && calleLong<=20){
            estratoToCompare=1L;
        }else
        if(carreraLong<60 && calleLong<=60){
            estratoToCompare=2L;
        }else
        if(carreraLong<=80 && calleLong<=80){
            estratoToCompare=3L;
        }else
        if(carreraLong<=100 && calleLong<=100){
            estratoToCompare=4L;
        }else
        if(carreraLong<=120 && calleLong<=120){
            estratoToCompare=5L;
        }else
        if(carreraLong<=140 && calleLong<=140){
            estratoToCompare=6L;
        }
        if (estratoToCompare!=estrato){
            return false;
        }else{
            return  true;
        }
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

