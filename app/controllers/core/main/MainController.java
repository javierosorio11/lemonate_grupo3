package controllers.core.main;

import controllers.core.main.helpers.MainHelper;
import controllers.lmat.routes;
import models.GenericEntity;
import models.users.User;
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
    public Result authenticate() {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        User user=mainHelper.authenticate(dynamicForm.get("user"),dynamicForm.get("inputPassword"));
        if(null == user){
            return ok(login.render(true));
        }else{
            session().put("usuario",user.getName());
            session().put("warehouse",user.getLocation());
            return redirect(controllers.core.main.routes.MainController.home());
        }
    }
    /**
     * Autenticacion de datos
     * @return
     */
    public Result home() {
        if(null!=session("usuario")) {
            return redirect(controllers.lmat.routes.LmatController.listLmat(1L,true,"NONE"));
        }else {
            return ok(login.render(false));
        }
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
        if(null!=session("usuario")) {
            WarehouseEnum warehouseEnum = WarehouseEnum.valueOf(session("warehouse")) ;
            return ok(warehouseEnum.getDisplayMessage());
        }else {
            return ok("");
        }
    }
    /**
     * Autenticacion de datos
     * @return
     */
    public Result recibirCargas() {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        User users = new User();
        users.setPassword("fff");
        return ok();
    }
    /**
     * Autenticacion de datos
     * @return
     */
    public Result changeCountry(String country) {
        if(null!=session("usuario")) {
            session().put("warehouse",country);
            return redirect(controllers.lmat.routes.LmatController.listLmat(1L,true,"NONE"));
        }else {
            flash().put("error", "Error en sesión, por favor ingrese con sus credenciales");
            return ok(login.render(false));
        }
    }

    /**
     * Rutas de javascript
     * @return
     */
    public Result javascriptRoutes() {
        return ok(JavaScriptReverseRouter.create("jsRoutes", controllers.core.main.routes.javascript.MainController.getActualCountry(),
                controllers.lmat.routes.javascript.LmatController.getLmatData()
        )).as("text/javascript");
    }
}
