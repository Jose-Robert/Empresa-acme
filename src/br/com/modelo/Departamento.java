package br.com.modelo;

public class Departamento {
	private long id;
	private String nome;

	public Departamento( String nome) {
		super();
		this.nome = nome;
	}
	
	public Departamento(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
