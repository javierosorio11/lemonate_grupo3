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

}

