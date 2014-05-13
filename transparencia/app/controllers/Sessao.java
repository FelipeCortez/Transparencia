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
        return null;
    }
    
}
