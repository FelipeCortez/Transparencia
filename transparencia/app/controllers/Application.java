package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Application extends Controller {

	public static Result index() {
        return ok(views.html.app_index.render());
    }
    
    public static Result verParlamentar(Long id){
        return controllers.Parlamentar.appVerParlamentar(id);
    }


    public static Result sessoes() {
    	return controllers.Sessao.appPesqSessoes();
    }
    public static Result verSessaoParlamentares(String data_hora) {
    	SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        Date tipo_data=null;
        try {
            tipo_data = formatter.parse(data_hora);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return controllers.Sessao.appVerParlamentares(models.Sessao.find.byId(tipo_data));
    }
    
    public static Result listarParlamentar(){
        return controllers.Parlamentar.appListarParlamentar();
    }
    
    public static Result visualizarProcessos(Long id){
        return controllers.Processo.appVisualizarProcesso(models.Parlamentar.find.byId(id));
    }
    
    public static Result visualizarGastos(Long id){
        return controllers.Gastos.appVisualizarGastos(models.Parlamentar.find.byId(id));
    }
}