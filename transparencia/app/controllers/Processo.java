package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import java.util.*;

import views.html.*;


public class Processo extends Controller {

    public static Result listarUm(Long id) {

        response().setContentType("text/html; charset=utf-8");
        models.Processo processo = models.Processo.find.byId(id);
        if(processo != null) {
            return ok(views.html.processo.render(processo));
        } else {
            return redirect("/administrador");
        }
    }
}
