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
        
        return ok(views.html.admin_index.render());
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

    public static Result criarParlamentar(){
        return controllers.Parlamentar.adminCriarParlamentar();
    }
    
    public static Result listarParlamentar(){
        return controllers.Parlamentar.adminListarParlamentar();
    }
    
    public static Result editarParlamentar(Long id){
        return controllers.Parlamentar.adminEditarParlamentar(models.Parlamentar.find.byId(id));
    }
    
    
    public static Result criarProcesso(){
        return controllers.Processo.adminCriarProcesso(models.Parlamentar.find.all());
    }
    
    public static Result listarProcesso(){
        return controllers.Processo.adminListarProcesso();
    }
    
    public static Result editarProcesso(Long id){
        return controllers.Processo.adminEditarProcesso(models.Processo.find.byId(id));
    }
    
    public static Result criarSessao(){
        return controllers.Sessao.adminCriarSessao();
    }

    public static Result listarSessao(){
        return controllers.Sessao.adminListarSessao();
    }
    public static Result editarSessao(String data_hora){
        return controllers.Sessao.adminEditarSessao(data_hora);
    }

    public static Result criarGastos(){
        return controllers.Gastos.adminCriarGastos(models.Parlamentar.find.all());
    }
    
    public static Result listarGastosEscolherParlamentar(){
	return controllers.Gastos.adminListarGastosEscolherParlamentar();
    }
    
	public static Result listarGastosParlamentar(Long id){
        return controllers.Gastos.adminListarGastosParlamentar(models.Parlamentar.find.byId(id));
    }    

	public static Result editarGastos(Long id){
		return controllers.Gastos.adminEditarGasto(models.Gastos.find.byId(id));
	}
}
