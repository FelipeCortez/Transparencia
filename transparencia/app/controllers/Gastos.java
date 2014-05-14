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


public class Gastos extends Controller {
    
    static Form<models.Gastos> gastosForm = Form.form(models.Gastos.class);

    public static Result adminCriarGastos(){
        return ok(views.html.admin_criarGastos.render(gastosForm));
    }
    
    public static Result doAdminCriarGastos(){
        return null;
    }
    
}
