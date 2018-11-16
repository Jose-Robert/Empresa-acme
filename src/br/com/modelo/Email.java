package br.com.modelo;

public class Email {
	
	private long id;
	private String descricao;
	
	public Email(String descricao) {
		this.descricao = descricao;
	}
	
	public Email(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
