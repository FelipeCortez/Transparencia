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

public class Administrador extends Controller {
    
    static Form<models.Administrador> loginForm = Form.form(models.Administrador.class);
    
    private static boolean isUserLogged(){
        if(session("logged")!=null) return true;
        return false;
    }

    public static Result index(){

        if(!isUserLogged()) return redirect(routes.Administrador.login());
        
        return redirect(routes.Administrador.criarParlamentar());
    }

    public static Result login(){
        return ok(views.html.admin_login.render(loginForm));
    }
    
    public static Result doLogin(){
        Form<models.Administrador> filledForm = loginForm.bindFromRequest();

        if(filledForm.hasErrors()){
            return badRequest(views.html.admin_login.render(filledForm));
        }else{
            models.Administrador admin = filledForm.get();

            List<models.Administrador> admins = models.Administrador.find.where().eq("usuario",admin.usuario).eq("senha",admin.senha).findList();

            if(admins.isEmpty()) return redirect(routes.Administrador.login());

            models.Administrador adminFinal = admins.get(admins.size()-1);

            session("logged",admin.usuario);

            return redirect(routes.Administrador.index());
        }
    }

    
    
    
    public static Result criarProcesso(){
        return controllers.Processo.adminCriarProcesso();
    }
    
    
    
    public static Result criarSessao(){
        return controllers.Sessao.adminCriarSessao();
    }

    public static Result criarGastos(){
        return controllers.Gastos.adminCriarGastos();
    }
    
    
    

    /*public static Result criarProcesso() {
        Form<models.Processo> filledForm = criarProcessoForm.bindFromRequest();
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart process = body.getFile("processo");

    if (process != null && !filledForm.hasErrors()) {

        String fileName = process.getFilename();
        //String contentType = process.getContentType();
        //File file = process.getFile();
        File newFile = null;
        // Imagem vai pro server
        try{
            newFile = File.createTempFile("proc_", fileName.replaceAll("[ -+^:,]",""), new File("public/process/upload/"));
        }catch(Exception e){
            return badRequest(views.html.criarProcesso.render(criarProcessoForm));
        }

        models.Processo p = filledForm.get();
        p.processo = newFile.getName();
        p.save();

        return redirect(routes.Administrador.index());

    } else {
        return badRequest(views.html.criarProcesso.render(criarProcessoForm));
    }
    //return null;
    }

        
    public static Result sessoes() {
        return ok(views.html.criarSessao.render(Sessao.all(), sessaoForm));
    }

    public static Result criarSessao() {
        Form<models.Sessao> cadastroForm = sessaoForm.bindFromRequest();
        if(cadastroForm.hasErrors()) {
            return badRequest(views.html.criarSessao.render(Sessao.all(), cadastroForm));
        } else {
            Sessao.create(cadastroForm.get());
            return redirect(routes.Administrador.sessoes());
        }
    }

    public static Result excluirSessao(Long id) {
        Sessao.delete(id);
        return redirect(routes.Administrador.sessoes());
    }
    */
    
    public static Result criarParlamentar(){
        return controllers.Parlamentar.adminCriarParlamentar();
    }
    
    public static Result listarParlamentar(){
        return controllers.Parlamentar.adminListarParlamentar();
    }
    
    public static Result editarParlamentar(Long id){
        return controllers.Parlamentar.adminEditarParlamentar(models.Parlamentar.find.byId(id));
    }
    
}
