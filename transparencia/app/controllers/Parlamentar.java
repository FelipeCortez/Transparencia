package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import java.util.*;

import views.html.*;

public class Parlamentar extends Controller {

    public static Result listarUm(Long id){

        response().setContentType("text/html; charset=utf-8");
        models.Parlamentar parlamentar = models.Parlamentar.find.byId(id);
        if(parlamentar != null) {
            return ok(views.html.perfilParlamentar.render(parlamentar));
        } else {
            return redirect("/administrador");
        }
    }
}
