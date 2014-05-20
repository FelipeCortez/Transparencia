package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;

@Entity
public class Gastos extends Model{

	public static Finder<Long,Gastos> finder = new Finder<Long,Gastos>(Long.class, Gastos.class);

	@Id 
	public Long id; /*chave primária*/

	@ManyToOne
	public Parlamentar parlamentar;

    @Required
    public float valor; 

    @Required
    public String justificativa;

    @Required
    public String documentoProva;

    @Required
    public String descricao;

    @Required
    public String data;
    
    @Required
    public String lei;
    
    @Required
    public String origemDoDinheiro;
    	
    public static Finder<Long,Gastos> find = new Finder<Long,Gastos>(Long.class, Gastos.class);

    public static List<Gastos> all() {
    	return find.all();
    }

    public static void create(Gastos g) {
    	g.save();
    }

    public static void delete(Long id) {
    	find.ref(id).delete();
    }
}
