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

    public static Result appPesqSessoes() {
        
        return ok(views.html.app_pesquisarSessoes.render());
    }

    public static Result appVerSessao() {
        String ano, mes, dia;
        ano = Form.form().bindFromRequest().get("ano");
        mes = Form.form().bindFromRequest().get("mes");
        dia = Form.form().bindFromRequest().get("dia");

        /* Obs: por enquanto, nao foi tratado bem o mes de FEVEREIRO (testes). */

        List<models.Sessao> sessoes;
        if(dia.length() < 2) { /* Se foi nao foi determinado um dia, a consulta sera para todos os dias do mes. */
            sessoes = models.Sessao.find.where().ilike("data_hora", ano+"-"+mes+"-%").findList();
        }else {
            sessoes = models.Sessao.find.where().ilike("data_hora", ano+"-"+mes+"-"+dia+"%").findList();
        }
        
        if(sessoes.get(0) != null) {
            return ok(views.html.app_verSessoes.render(sessoes));
        }else
            return redirect("/sessao");
    }

    public static Result adminCriarSessao() {
        return ok(views.html.admin_criarSessao.render(sessaoForm));
    }
    
    public static Result doAdminCriarSessao() {
        Form<models.Sessao> cadastroForm = sessaoForm.bindFromRequest();

        if(cadastroForm.hasErrors()) {
            return badRequest(views.html.admin_criarSessao.render(cadastroForm));
        } else {
            models.Sessao s = cadastroForm.get();
            for (models.Parlamentar pa : cadastroForm.get().parlamentares) {

                if(pa.id == null) cadastroForm.get().parlamentares.remove(pa);
            }
            
            s.save();
            s.saveManyToManyAssociations("parlamentares");
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

    public static Result adminEditarSessao(models.Sessao s) {

        return ok(views.html.admin_editarSessao.render(sessaoForm.fill(s),s));
    }

    public static Result doAdminAtualizarSessao(String s) {
        Form<models.Sessao> atualizarForm = sessaoForm.bindFromRequest();
        
        if(atualizarForm.hasErrors()){
            return ok(atualizarForm.errors().toString());
        }
        else{
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

            try {
                Date data_hora = formatter.parse(s);
                
                //Logger.info("Data entered = " + sessao.data_hora);
                for (models.Parlamentar pa : atualizarForm.get().parlamentares) {
                    //Logger.info("O pa eh " + pa.id);
                    if(pa.id == null) atualizarForm.get().parlamentares.remove(pa);
                }
                //Logger.info("Total pa selected = " + sessao.parlamentares.size());
                atualizarForm.get().update(data_hora);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            return redirect(routes.Administrador.listarSessao());
        }
    }

    public static Result adminVerParlamentares(models.Sessao s) {
        return ok(views.html.admin_verSessaoParlamentares.render(s.parlamentares));
    }
}