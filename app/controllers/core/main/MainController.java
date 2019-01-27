package controllers.core.main;

import controllers.core.main.helpers.MainHelper;
import models.Articulo;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.routing.JavaScriptReverseRouter;
import views.html.pages.core.main.Home;
import views.html.pages.core.main.registtration;
import views.html.pages.core.main.pageNotFound;
import javax.inject.Inject;

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
        return redirect(controllers.core.main.routes.MainController.home());
    }

    /**
     * pagina de inicio
     * @return
     */
    public Result home() {
        return ok(Home.render(false,null));
    }
    /**
     * pagina de inicio
     * @return
     */
    public Result registerForm() {
        return ok(registtration.render(true,null,null));
    }

    /**
     * Autenticacion de datos
     * @return
     */
    @Transactional
    public Result register() {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        Articulo articulo= mainHelper.registration(dynamicForm);
        if(null==articulo){
            return ok(registtration.render(true,dynamicForm,"Los datos ingresados no son validos"));
        }else{
            flash().put("generalSuccess", "Exito al crear el siguiente registro : " + articulo.getArticleName());
            return ok(Home.render(false,articulo.getArticleName()));
        }
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
