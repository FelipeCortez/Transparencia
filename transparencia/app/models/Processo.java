package models;

//import java.io.File;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
//import play.data.format.*;
//import play.data.validation.*;
import play.data.validation.Constraints.*;


@Entity
public class Processo extends Model {
	
	@Id
	public Long id;
	
	@Required
	public Parlamentar parlamentar;
	
	@Required
	public String descricao;
	
	@Required
	public String acusacoes;
	
	@Required
	public String processo;
	
	@Required
	public String status;
	
	@Required
	public String defesa;
	
	@Required
	public String textoDefesa;
	
	@Required
	public String orgaoDeInvestigacao;
	
	public static Finder<Long,models.Processo> find = new Finder<Long,models.Processo>(Long.class, models.Processo.class);
	
}
