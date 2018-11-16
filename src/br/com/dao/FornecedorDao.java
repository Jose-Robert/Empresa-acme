package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.conexao.ConectionFactory;
import br.com.modelo.Fornecedor;
import br.com.modelo.Telefone;

public class FornecedorDao {

	private Connection conexao;
	
	public FornecedorDao() {
		this.conexao = ConectionFactory.getConnection();
	}
	
public void salvarFornecedor(Fornecedor fornecedor) throws SQLException{
		
		this.conexao = ConectionFactory.getConnection();
		
		String sql = "INSERT INTO fornecedor (nome, cnpj, endereco, nome, razao_social, produtos, email, telefone)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2,fornecedor.getCnpj());
		stmt.setString(3, fornecedor.getEndereco());
		stmt.setLong(4,fornecedor.getTelefone());
		
		
		
	}
}