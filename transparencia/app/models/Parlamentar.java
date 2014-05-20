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
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<models.Processo> processos;

	
    @OneToMany(cascade=CascadeType.ALL)
    public List<models.Gastos> gastos;

    public static Finder<Long,models.Parlamentar> find = new Finder<Long,models.Parlamentar>(Long.class, models.Parlamentar.class);
}
