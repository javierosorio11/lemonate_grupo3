package controllers.core.main;

import controllers.core.main.helpers.MainHelper;
import models.GenericEntity;
import org.hibernate.SessionFactory;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.routing.JavaScriptReverseRouter;
import views.html.pages.core.main.login;
import views.html.pages.core.main.lmatList;
import views.html.pages.core.main.pageNotFound;
import views.vo.enums.WarehouseEnum;

import javax.inject.Inject;
import java.util.List;

public class MainController extends Controller {
    private final FormFactory formFactory;
    private final MainHelper mainHelper;
    @Inject
    public MainController(FormFactory formFactory, MainHelper mainHelper) {
        this.formFactory = formFactory;
        this.mainHelper=mainHelper;
    }

    /**
     * controlador para mostrar cuando la pagina no es encontrada
     * @return
     */
    public Result pageNotFound() {
        return notFound(pageNotFound.render());
    }

    /**
     * primera pagina a renderizar
     * @return
     */
    public Result index() {
        return redirect(controllers.core.main.routes.MainController.login());
    }

    /**
     * pagina de inicio
     * @return
     */
    public Result login() {
        session().remove("usuario");
        return ok(login.render(false));
    }

    /**
     * Autenticacion de datos
     * @return
     */
    @Transactional
    public Result register() {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        String response=mainHelper.registration(dynamicForm);
        if("error".equals(response)){
            return ok(login.render(true));
        }else{
            return ok(login.render(true));
        }
    }
    /**
     * Autenticacion de datos
     * @return
     */
    public Result home() {

            return ok();

    }
    /**
     * Autenticacion de datos
     * @return
     */
    public Result logOut() {
        session().remove("usuario");
        flash().put("success","Sesión cerrada correctamente");
        return ok(login.render(false));
    }
    /**
     * metodo que m muestra la lista de LmatMadre
     * @return
     */
    public Result getActualCountry() {

            return ok("");

    }

    /**
     * Autenticacion de datos
     * @return
     */
    public Result changeCountry(String country) {

            return ok();

    }

    /**
     * Rutas de javascript
     * @return
     */
    public Result javascriptRoutes() {
        return ok(JavaScriptReverseRouter.create("jsRoutes", ""
        )).as("text/javascript");
    }
}
