package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("Your new application is ready. Sr. - ");
    }
    
    public static Result verParlamentar(Long id){
        return controllers.Parlamentar.appVerParlamentar(id);
    }
    public static Result sessoes() {
    	return controllers.Sessao.appPesqSessoes();
    }
}