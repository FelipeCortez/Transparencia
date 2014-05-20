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
    
    public static Result adminCriarProcesso(List<models.Parlamentar> l){
        return ok(views.html.admin_criarProcesso.render(processoForm, l));
    }
    
    public static Result doAdminCriarProcesso(){
    	 Form<models.Processo> cadastroForm = processoForm.bindFromRequest();
         
         if(cadastroForm.hasErrors()) {
        	 return ok(cadastroForm.errors().toString());
         }
         else {
             models.Processo.create(cadastroForm.get());
             return redirect(routes.Administrador.index());
         }  
    }
    
    public static Result adminListarProcesso(){
        return ok(views.html.admin_listarProcesso.render(models.Processo.find.all()));
    }
    
    public static Result adminEditarProcesso(models.Processo p){   
        return ok(views.html.admin_editarProcesso.render(processoForm.fill(p), p));
    }
    
    /*public static Result adminListarProcessoEscolherParlamentar(){
        return ok(views.html.admin_listarProcessosEscolheParlamentar.render(models.Parlamentar.find.all()));
    }
    
    public static Result adminListarProcesso(){
        return ok(views.html.admin_listarProcesso.render(models.Processo.find.all()));
    }
    
    public static Result adminListarProcessoParlamentar(models.Parlamentar p){
    	return ok(views.html.admin_processosParlamentar.render(p.processos, p));
    }*/
    
    public static Result doAdminRemoverProcesso(Long idg){
        models.Processo.find.ref(idg).delete();
        return redirect(routes.Administrador.index());
    }

    public static Result doAdminAtualizarProcesso(){
        // Code
        return ok("Falta terminar!");
    }
}
