package models;

import java.io.File;

import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

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
	public File processo;
	
	@Required
	public String status;
	
	@Required
	public String defesa;
	
	@Required
	public String textoDefesa;
	
	@Required
	public String orgaoDeInvestigacao;
	
	public static Finder<Long,models.Processo> find = new Finder(Long.class, models.Processo.class);
	
}
