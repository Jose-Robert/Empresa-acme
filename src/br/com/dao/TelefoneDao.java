package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.conexao.ConectionFactory;
import br.com.modelo.Funcionario;
import br.com.modelo.Telefone;

public class TelefoneDao {
	private Connection conexao;

	public TelefoneDao() {
		this.conexao = ConectionFactory.getConnection();
	}
	
	public void salvarTelefone(Telefone t) throws SQLException{
		
		String sql = "INSERT INTO telefone (numero, ddd)" + "VALUES (?,?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, t.getNumero());
		stmt.setString(2, t.getDdd());
		stmt.execute();
		this.conexao.close();
	}
	
	public long acharUltimoId() throws SQLException{
		
		String sql = "SELECT MAX(id) FROM telefone";
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
	
	public void removerTelefone(Long id) throws SQLException{
		
		String sql = "DELETE FROM telefone WHERE id=?";
		
		this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setLong(1,id);
		stmt.execute();
		this.conexao.close();
		
	}
	
	public void alterarTelefone(Long id, Funcionario f) throws SQLException{
		
		String sql = "UPDATE telefone SET ddd = ?, numero = ? Where ID =?";
        
        this.conexao = ConectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, f.getTelefone().getDdd());
		stmt.setString(2, f.getTelefone().getNumero());
		stmt.setLong(3, id);
		
		stmt.execute();
	    this.conexao.close();
	}
}
