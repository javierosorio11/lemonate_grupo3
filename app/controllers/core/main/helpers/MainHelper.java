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
            articulo.setDirection(dynamicForm.get("direccion1")+" "+dynamicForm.get("direccion2")+" "+dynamicForm.get("direccion3")+dynamicForm.get("direccion4")+" - "+dynamicForm.get("direccion5"));
            articulo.setArticleName(dynamicForm.get("nombre_inmueble"));
            articulo.setUserId(dynamicForm.get("cedula"));
            articulo.save();
        }catch(Exception exeption){
            return "noData";
        }
        return "succes";
    }

}

