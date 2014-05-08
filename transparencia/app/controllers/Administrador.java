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
    static Form<models.Parlamentar> createParlamentarForm = Form.form(models.Parlamentar.class);
    static Form<models.Processo> criarProcessoForm = Form.form(models.Processo.class);

    public static Result index(){

        if(!isUserLogged()) return redirect("/signIn");

        response().setContentType("text/html; charset=utf-8");
        return ok(views.html.addprocess.render(criarProcessoForm));
    }

    public static Result doLogin(){

        Form<models.Administrador> filledForm = loginForm.bindFromRequest();

        if(filledForm.hasErrors()){
            return badRequest(views.html.signIn.render(filledForm));
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
        return ok(views.html.signIn.render(loginForm));
    }

    private static boolean isUserLogged(){
        if(session("logged")!=null) return true;
        return false;
    }

    public static Result createParlamentar(){

        Form<models.Parlamentar> filledForm = createParlamentarForm.bindFromRequest();
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart picture = body.getFile("foto");
        
        if (picture != null && !filledForm.hasErrors()) {
            
            String fileName = picture.getFilename();
            //String contentType = picture.getContentType(); 
            //File file = picture.getFile();
            File newFile = null;
            // Imagem vai pro server
            try{
                newFile = File.createTempFile("img_", fileName.replaceAll("[ -+^:,]",""), new File("public/images/upload/")); 
            }catch(Exception e){
                return badRequest(views.html.adicionarParlamentar.render(createParlamentarForm));
            }
            
            models.Parlamentar p = filledForm.get();
            p.foto = newFile.getName(); // Adiciona o nome da imagem
            p.save();

            return redirect("/administrador");
            
        } else {
            return badRequest(views.html.adicionarParlamentar.render(createParlamentarForm));
        }

    }

    public static Result deleteParlamentar(Long id) {
        models.Parlamentar.find.ref(id).delete();
        return redirect("/administrador");
    }
    
    public static Result createProcesso(){

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
                return badRequest(views.html.addprocess.render(criarProcessoForm));
            }
            
            models.Processo p = filledForm.get();
            p.processo = newFile.getName();
            p.save();

            return redirect("/administrador");
            
        } else {
            return badRequest(views.html.addprocess.render(criarProcessoForm));
        }
        //return null;
    }
    
    public static Result deleteProcesso(Long id) {
        models.Processo.find.ref(id).delete();
        return redirect("/administrador");
    }
}
