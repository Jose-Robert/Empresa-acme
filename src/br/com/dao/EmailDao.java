package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.conexao.ConectionFactory;
import br.com.modelo.Email;
import br.com.modelo.Funcionario;

public class EmailDao {
	private Connection conexao;

	public EmailDao() {
		this.conexao = ConectionFactory.getConnection();
	}
	
	public void salvarEmail(Email e) throws SQLException{
		
		String sql = "INSERT INTO email (descricao)" + "VALUES (?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, e.getDescricao());	
		stmt.execute();
		this.conexao.close();
	}


	public long acharUltimoId() throws SQLException{
		
		String sql = "SELECT MAX(id) FROM email";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = null;
        long id = 0;
        try {         
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stmt.execute();
        return id;
    }
	
	public void removerEmail(Long id) throws SQLException{
		
		String sql = "DELETE FROM email WHERE id=?";
		
		this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setLong(1,id);
		stmt.execute();
		this.conexao.close();
		
	}
	
	public void alterarEmail(Long id, Funcionario f) throws SQLException{
		String sql = "UPDATE email SET descricao = ? Where ID =?";
    
		this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
	
		stmt.setString(1, f.getEmail().getDescricao());
		stmt.setLong(2, id);
	
		stmt.execute();
		this.conexao.close();
	}
}