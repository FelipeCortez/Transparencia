package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import java.util.*;

import views.html.*;

public class Administrador extends Controller {
    
    static Form<models.Administrador> loginForm = Form.form(models.Administrador.class);

    public static Result index(){
        if(!isUserLogged()) return redirect("/signIn");
        response().setContentType("text/html; charset=utf-8");
        return ok("Esta é a página do administrador.").as("text/html");
    }
    
    public static Result doLogin(){
        
        Form<models.Administrador> filledForm = loginForm.bindFromRequest();
        
        if(filledForm.hasErrors()){
            return badRequest(views.html.administrador.render(filledForm));
        }else{
            models.Administrador admin = filledForm.get();
            
            List<models.Administrador> admins = models.Administrador.find.where().eq("usuario",admin.usuario).eq("senha",admin.senha).findList();
            
            if(admins.isEmpty()) return redirect("/signIn");
            
            models.Administrador adminFinal = admins.get(admins.size()-1);
            
            session("logged",admin.usuario);
            
            return redirect("/administrador");
        }
    }
    
    public static Result signIn(){
        return ok(views.html.administrador.render(loginForm));
    }
    
    private static boolean isUserLogged(){
        if(session("logged")!=null) return true;
        return false;
    }    
    
}