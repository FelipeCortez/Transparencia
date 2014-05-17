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

public class Parlamentar extends Controller {
    
    static Form<models.Parlamentar> parlamentarForm = Form.form(models.Parlamentar.class);

    public static Result appVerParlamentar(Long id){

        models.Parlamentar parlamentar = models.Parlamentar.find.byId(id);
        if(parlamentar != null) {
            return ok(views.html.app_verParlamentar.render(parlamentar));
        } else {
            return redirect("/");
        }
        
    }
    
    public static Result adminCriarParlamentar(){
        return ok(views.html.admin_criarParlamentar.render(parlamentarForm));
    }
    
    public static Result doAdminCriarParlamentar(){
        
        Form<models.Parlamentar> filledForm = parlamentarForm.bindFromRequest();
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart picture = body.getFile("foto");

        if (picture != null && !filledForm.hasErrors()) {

            String fileName = picture.getFilename();
            File newFile = null;
            
            // Imagem vai pro server
            try{
                newFile = File.createTempFile("img_", fileName.replaceAll("[ -+^:,]",""), new File("public/images/upload/"));
            }catch(Exception e){
                return badRequest(views.html.admin_criarParlamentar.render(parlamentarForm));
            }

            models.Parlamentar p = filledForm.get();
            p.foto = newFile.getName(); // Adiciona o nome da imagem
            p.save();
            
            return redirect(routes.Administrador.listarParlamentar());

        } else {
            return badRequest(views.html.admin_criarParlamentar.render(filledForm));
        }

    }
    
    public static Result adminListarParlamentar(){
        return ok(views.html.admin_listarParlamentar.render(models.Parlamentar.find.all()));
    }
    
    public static Result doAdminRemoverParlamentar(Long id){
        models.Parlamentar.find.ref(id).delete();
        return redirect(routes.Administrador.listarParlamentar());
    }
    
    public static Result adminEditarParlamentar(models.Parlamentar p){
        
        return ok(views.html.admin_editarParlamentar.render(parlamentarForm.fill(p),p));
    }
    
    public static Result doAdminAtualizarParlamentar(){
        // Code
        return null;
    }
    
}
