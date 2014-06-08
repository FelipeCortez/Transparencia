package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {
        return ok(views.html.app_index.render());
    }
    
    public static Result verParlamentar(Long id){
        return controllers.Parlamentar.appVerParlamentar(id);
    }
    
    public static Result sessoes() {
    	return controllers.Sessao.appPesqSessoes();
    }

    public static Result listarParlamentar(){
        return controllers.Parlamentar.appListarParlamentar();
    }
    
    public static Result visualizarProcessos(Long id){
        return controllers.Processo.appVisualizarProcesso(models.Parlamentar.find.byId(id));
    }
}