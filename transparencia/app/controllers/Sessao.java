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


public class Sessao extends Controller {
    
    static Form<models.Sessao> sessaoForm = Form.form(models.Sessao.class);

    public static Result adminCriarSessao(){
        return ok(views.html.admin_criarSessao.render(sessaoForm));
    }
    
    public static Result doAdminCriarSessao(){
        Form<models.Sessao> cadastroForm = sessaoForm.bindFromRequest();
        if(cadastroForm.hasErrors()) {
            return badRequest(views.html.admin_criarSessao.render(cadastroForm));
        } else {
            models.Sessao s = cadastroForm.get();
            s.save();
            return redirect(routes.Administrador.listarSessao());
        }
    }

    public static Result adminListarSessao(){
        return ok(views.html.admin_listarSessao.render(models.Sessao.find.all()));
    }

    public static Result doAdminRemoverSessao(Long id){
        models.Sessao.find.ref(id).delete();
        return redirect(routes.Administrador.listarSessao());
    }
    
    public static Result adminEditarSessao(models.Sessao s){
        
        return ok(views.html.admin_editarSessao.render(sessaoForm.fill(s),s));
    }
}