package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;


@Entity
public class Sessao extends Model {

    @Id
    @Formats.DateTime(pattern= "dd/MM/yyyy hh:mm")
    public Date data_hora; /* Tipo simultaneo para data e horario */

    @Required
    public String descricao;

    @Required
    public String ata;

    @Required
    public String carater;

    @Required
    public String presidente;

    public static Finder<Date,Sessao> find = new Finder<Date,Sessao>(Date.class, Sessao.class);
}