package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;

@Entity
public class Sessao extends Model{

	@Id /* CHAVE PRIMARIA TEMPORARIA */
	public Long id;

    @Required
    @Formats.DateTime(pattern= "dd/MM/yyyy")
    public Date data_hora; /* Aqui deve ser um tipo simultaneo para data e hora. Nao tenho certeza se da certo! */

    @Required
    public String descricao;

    @Required
    public String ata;

    @Required
    public String carater;

    @Required
    public String presidente;

    public static Finder<Long,Sessao> find = new Finder<Long,Sessao>(Long.class, Sessao.class);
}
