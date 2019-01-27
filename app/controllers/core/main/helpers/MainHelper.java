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

    public boolean validateStrato(long calle, long carrera, long estrato){

        boolean valido=false;
        long estratoBD=0;

       try{

          if(calle > 0 & calle <= 20 & carrera > 0 & carrera <= 20){

              estratoBD=1;
          }else if(calle > 20 & calle <= 40 & carrera > 20 & carrera <= 40){

              estratoBD=2;
          }
          else if(calle > 40 & calle <= 60 & carrera > 40 & carrera <= 60){

              estratoBD=3;
          }else if(calle > 60 & calle <= 80 & carrera > 60 & carrera <= 80){

              estratoBD=4;
          }else if(calle > 80 & calle <= 100 & carrera > 80 & carrera <= 100){

              estratoBD=5;
          }else if(calle > 100 & carrera >100){

              estratoBD=6;

           }

            if(estrato==estratoBD){

                valido=true;

            }

        }catch(Exception exeption){

        }

        return valido;
    }

    public Double valorPrima(Long valorInmueble){

        Query queryPP=JPA.em().createQuery("select p.vch_valor from parametros p where p.vch_descripcion= 'porcentajePrima'");
        Long porcentajePrima = (Long) queryPP.getSingleResult();

        Query queryPC=JPA.em().createQuery("select p.vch_valor from parametros p where p.vch_descripcion= 'porcentajeComision'");
        Long porcentajeComision = (Long) queryPC.getSingleResult();

        Query queryPD=JPA.em().createQuery("select p.vch_valor from parametros p where p.vch_descripcion= 'devision'");
        Long division = (Long) queryPD.getSingleResult();


        double valorPrima = 0;

        valorPrima=((valorInmueble * porcentajePrima/100)/division)* porcentajeComision / 100;





        return valorPrima;
    }

}

