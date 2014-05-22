package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import java.io.*;

import models.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.security.SecureRandom;

import views.html.*;


public class Sessao extends Controller {
    
    static Form<models.Sessao> sessaoForm = Form.form(models.Sessao.class);

    public static Result adminCriarSessao() {
        return ok(views.html.admin_criarSessao.render(sessaoForm));
    }
    
    public static Result doAdminCriarSessao() {
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

    public static Result doAdminRemoverSessao(String s){
        
        /* Conversao necessaria para a string passada como parametro */
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

        try {
            Date data_hora = formatter.parse(s);
            models.Sessao.find.ref(data_hora).delete();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return redirect(routes.Administrador.listarSessao());
    }

    public static Result adminEditarSessao(String s) {
        //return ok(views.html.admin_editarSessao.render(sessaoForm.fill(s),s));
        return TODO;
    }
}