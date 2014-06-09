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
    
    public static Result adminListarProcessosEscolherParlamentar(){
        return ok(views.html.admin_listarProcessosEscolherParlamentar.render(models.Parlamentar.find.all()));
    }
    
    public static Result adminListarProcesso(models.Parlamentar p){
        return ok(views.html.admin_listarProcesso.render(p.processos, p));
    }

    public static Result appVisualizarProcesso(models.Parlamentar p){
        return ok(views.html.app_visualizarProcessos.render(p.processos, p));
    }
    
    public static Result adminEditarProcesso(models.Processo p){   
        return ok(views.html.admin_editarProcesso.render(processoForm.fill(p), p, p.id));
    }
    
    public static Result doAdminRemoverProcesso(Long idp){
        models.Processo.find.ref(idp).delete();
        return redirect(routes.Administrador.index());
    }

    public static Result doAdminAtualizarProcesso(Long idp){
    	Form<models.Processo> atualizarForm = processoForm.bindFromRequest();
        
    	if(atualizarForm.hasErrors()){
    		return ok(atualizarForm.errors().toString());
    	}
    	else{
    		atualizarForm.get().update(idp);
    		return redirect(routes.Administrador.index());
    	}
    }
}