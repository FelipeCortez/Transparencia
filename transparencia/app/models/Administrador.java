package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;

@Entity
public class Administrador extends Model{

    @Id
    public Long id;
    
    @Required
    public String usuario;
    
    @Required
    public String senha;
    
    public static Finder<Long,models.Administrador> find = new Finder<Long,models.Administrador>(Long.class, models.Administrador.class); 

}