package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class ControllerProcesso extends Controller {

    public static Result listarUm(Long id) {

        response().setContentType("text/html; charset=utf-8");
        models.Processo processo = models.Processo.find.byId(id);
        if(processo != null) {
            return ok(views.html.perfilProcesso.render(processo)); //falta o html
        } else {
            return redirect("/processo");
        }
    }


}
