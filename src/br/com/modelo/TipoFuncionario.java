package br.com.modelo;

public enum TipoFuncionario {

	SECRETARO("Secretário"), GERENTE("Gerente"), PRESIDENTE("Presidente"), DIRETOR("Diretor");

	private String nome;

	private TipoFuncionario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
