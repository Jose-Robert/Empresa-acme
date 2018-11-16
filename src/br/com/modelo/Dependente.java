package br.com.modelo;

public class Dependente {
	private long id;
	private String nome;
	private Funcionario funcionario;
	
	
	public Dependente(String nome, Funcionario funcionario) {
		this.nome = nome;
		this.funcionario = funcionario;
	}
	
	public Dependente (){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
