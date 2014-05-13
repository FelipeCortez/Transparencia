package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import java.io.*;

import models.*;
import java.util.*;
import java.security.SecureRandom;

import views.html.*;


public class Processo extends Controller {
    
    static Form<models.Processo> processoForm = Form.form(models.Processo.class);

    /*public static Result listarUm(Long id) {

        response().setContentType("text/html; charset=utf-8");
        models.Processo processo = models.Processo.find.byId(id);
        if(processo != null) {
            return ok(views.html.processo.render(processo));
        } else {
            return redirect("/administrador");
        }
    }*/
    
    public static Result adminCriarProcesso(){
        return ok(views.html.admin_criarProcesso.render(processoForm));
    }
    
    public static Result doAdminCriarProcesso(){
        return null;
    }
    
}
