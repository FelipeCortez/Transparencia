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

    public static Result adminCriarGastos(List<models.Parlamentar> l){
        return ok(views.html.admin_criarGastos.render(gastosForm,l));
    }
    
    public static Result doAdminCriarGastos(){
         Form<models.Gastos> cadastroForm = gastosForm.bindFromRequest();
        
        if(cadastroForm.hasErrors()) {
        
             return ok(cadastroForm.errors().toString());
           // return badRequest(views.html.admin_criarGastos.render(cadastroForm));
            
        }else {
            models.Gastos.create(cadastroForm.get());
            return redirect(routes.Administrador.index());
        }   
    }

    public static Result adminListarGastosEscolherParlamentar(){
        return ok(views.html.admin_listarGastosEscolheParlamentar.render(models.Parlamentar.find.all()));
    }
    public static Result adminListarGastosParlamentar(models.Parlamentar p){
	return ok(views.html.admin_gastosParlamentar.render(p.gastos, p));
    }
    public static Result doAdminRemoverGasto(Long idg, Long idP){
        models.Gastos.find.ref(idg).delete();
        return redirect(routes.Administrador.listarGastosParlamentar(idP));
    }
    

   
    
}
