package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;

@Entity
public class Parlamentar extends Model{
	
	@Id
	public Long id;
    // public Long cpf; CPF não pode ser Chave primária - não podemos usar CPF's de deputados
    
	@Required
    public String nome;
    
	@Required
    public Date dataNascimento;
    
	@Required
    public String partido;
    
	@Required
    public String formacao;
    
	@Required
    public String cidade;
    
	@Required
    public String gabinete;
    
	@Required
    public float salario;

    // O que seriam estes BENEFICIOS?
    
	@Required
    public String foto;
    
	@Required
    public String biografia;
	
	public static Finder<Long,Parlamentar> find = new Finder(
			Long.class, Parlamentar.class
	);
	
	public static List<Parlamentar> all(){
		return find.all();
	}
	
	public static void create(Parlamentar parlamentar) {
		parlamentar.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
    
}