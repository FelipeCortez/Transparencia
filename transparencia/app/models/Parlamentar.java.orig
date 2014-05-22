package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;

@Entity
public class Parlamentar extends Model {

	@Id
    public Long id;

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

    public String foto;

    @Required
    public String biografia;
    
    @OneToMany(mappedBy = "parlamentar")
    public List<models.Processo> processos;
	
    @OneToMany(cascade=CascadeType.ALL)
    public List<models.Gastos> gastos;

    public static Finder<Long,models.Parlamentar> find = new Finder<Long,models.Parlamentar>(Long.class, models.Parlamentar.class);

<<<<<<< HEAD
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Parlamentar p: Parlamentar.find.orderBy("nome").findList()) {
            options.put(p.id.toString(), p.nome);
        }
        return options;
    }

}
=======
    public Parlamentar(String n, Date dataNasc, String part, String form, String cid, String gab, float sal, String bio) {
        nome = n;
        dataNascimento = dataNasc;
        partido = part;
        formacao = form;
        cidade = cid;
        gabinete = gab;
        salario = sal;
        biografia = bio;
    }

    public static Parlamentar authenticate(String nome, String gab) {
        return find.where().eq("nome", nome)
            .eq("gabinete", gab).findUnique();
    }
}
>>>>>>> 20240a7283ec7de3ee014fdde010dc5a24ab3bfd
