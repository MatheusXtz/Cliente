package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Cliente extends Model {
    @Id
    @GeneratedValue
	private Long idCliente;
    
    private String nome;
    
    public static Model.Finder<Long, Cliente> find = new Model.Finder<Long, Cliente>(
			Long.class, Cliente.class);

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
