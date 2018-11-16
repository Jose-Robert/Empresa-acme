package br.com.modelo;

public class Telefone {
	
	private long id;
	private String numero;
	private String ddd;
	
	public Telefone(String numero, String ddd) {
		this.numero = numero;
		this.ddd = ddd;
	}
	
	public Telefone(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	

}
