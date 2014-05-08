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
    static Form<models.Parlamentar> criarParlamentarForm = Form.form(models.Parlamentar.class);
    static Form<models.Sessao> sessaoForm = Form.form(models.Sessao.class);
    static Form<models.Processo> criarProcessoForm = Form.form(models.Processo.class);

    public static Result index(){

        if(!isUserLogged()) return redirect("/signIn");

        response().setContentType("text/html; charset=utf-8");

        /* POSTERIORMENTE TEREMOS QUE OFERECER UM "MENU" PARA ESCOLHER SE QUEREMOS TRATAR DOS PARLAMENTARES, OU SESSOES, OU PROCESSOS, ETC. */
                /* Ate termos o MENU, ficaram "comentadas" aqui as demais operacoes */
        //return ok(views.html.adicionarParlamentar.render(criarParlamentarForm));
        //return ok(views.html.addprocess.render(criarProcessoForm));
        return redirect(routes.Administrador.sessoes());
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

    public static Result criarParlamentar(){
        Form<models.Parlamentar> filledForm = criarParlamentarForm.bindFromRequest();
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
                return badRequest(views.html.adicionarParlamentar.render(criarParlamentarForm));
            }

            models.Parlamentar p = filledForm.get();
            p.foto = newFile.getName(); // Adiciona o nome da imagem
            p.save();

            return redirect("/administrador");

        } else {
            return badRequest(views.html.adicionarParlamentar.render(criarParlamentarForm));
        }

    }

    public static Result deleteParlamentar(Long id) {
        models.Parlamentar.find.ref(id).delete();
        return redirect("/administrador");
    }

        public static Result criarProcesso() {
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

            return redirect("/administrador");

        } else {
            return badRequest(views.html.criarProcesso.render(criarProcessoForm));
        }
        //return null;
        }

        /* SESSOES */
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
}
