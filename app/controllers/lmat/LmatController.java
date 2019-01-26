package controllers.lmat;

import controllers.core.main.helpers.MainHelper;
import controllers.lmat.helpers.LmatHelper;
import controllers.lmat.routes;
import models.users.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.routing.JavaScriptReverseRouter;
import views.html.pages.core.main.lmatList;
import views.html.pages.core.main.login;
import views.html.pages.core.main.pageNotFound;
import views.vo.enums.WarehouseEnum;

import javax.inject.Inject;
import java.util.List;

public class LmatController extends Controller {
    private final FormFactory formFactory;
    private final MainHelper mainHelper;
    private final LmatHelper lmatHelper;
    @Inject
    public LmatController(FormFactory formFactory, MainHelper mainHelper,LmatHelper lmatHelper) {
        this.formFactory = formFactory;
        this.mainHelper=mainHelper;
        this.lmatHelper = lmatHelper;
    }


    /**
     * metodo que muestra la lista de lmat
     * @param page
     * @param isfirst
     * @return
     */
    @Transactional
    public Result listLmat(Long page,Boolean isfirst,String criteria) {
        if(null!=session("usuario")) {
            String quickSearch=session("quickSearch");
            if(null!=criteria && !"".equals(criteria)){
                String criteriaQuery="NONE";
                if(!"NONE".equals(criteria)){
                 criteriaQuery="and (lower(codigo_de_articulo) like \'%"+criteria+"%\' or lower(descripcion) like \'%"+criteria+"%\')";
                }
                session().put("criteria",criteriaQuery);
            }else {
                Long totalPages=lmatHelper.getLmatPages(session("criteria"),session("warehouse"), page,quickSearch);
                session().put("ListPages",totalPages.toString());
            }
            if(isfirst){
                session().remove("quickSearch");
                Long totalPages=lmatHelper.getLmatPages(session("criteria"),session("warehouse"), page,null);
                session().put("ListPages",totalPages.toString());
            }
            List<Long>aviablePages=lmatHelper.getAviablePages(Long.parseLong(session("ListPages")),page);
             return ok(lmatList.render(lmatHelper.getLmat(page,session("criteria"),session("warehouse"),session("quickSearch")),aviablePages,Long.parseLong(session("ListPages")),page,criteria));
        }else {
            return ok(login.render(false));
        }
    }
    /**
     * metodo para obtener los datos especificos de una lmat
     * @param lmatCode
     * @return
     */
    @Transactional
    public Result getLmatData(String lmatCode) {
        if(null!=session("usuario")) {
            return ok(lmatHelper.getLmatData(session("warehouse"),lmatCode));
        }else {
            return ok(login.render(false));
        }
    }
    /**
     * metodo para obtener los datos especificos de una lmat
     * @param criteria
     * @return
     */
    @Transactional
    public Result quickSearch(String criteria) {
        criteria=criteria.replace("\'","");
        criteria=criteria.replace("\"","");
        String queryAdd="and (codigo_de_articulo LIKE \'%"+criteria.toLowerCase()+"%\' or lower(nombre_del_articulo) like \'%"+criteria.toLowerCase()+"%\')";
        session().put("quickSearch",queryAdd);
        return redirect(controllers.lmat.routes.LmatController.listLmat(1L,false, null));
    }
}
