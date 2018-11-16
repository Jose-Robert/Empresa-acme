package br.com.modelo;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

	private Long id;
	private String cnpj;
	private String endereco;
	private Telefone telefone;
	private Email email;
	private List<Produto> produtos;
	private String nome;
	private String razaoSocial;
	
	public Fornecedor() {
		
		this.produtos = new ArrayList<Produto>();
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
		
	}
	
	public void deleteProduto(Produto Produto) {
		this.produtos.remove(Produto);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}