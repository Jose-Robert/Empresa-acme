package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.conexao.ConectionFactory;
import br.com.modelo.Departamento;
import br.com.modelo.Funcionario;

public class DepartamentoDao {
	
	private Connection conexao;

	public DepartamentoDao() {
		this.conexao = ConectionFactory.getConnection();
	}
	
	public void salvarDepartamento(Departamento d) throws SQLException{
		
		String sql = "INSERT INTO departamento (nome)" + "VALUES (?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, d.getNome());
		stmt.execute();
		this.conexao.close();
	}
	public long acharUltimoId() throws SQLException{
		
		String sql = "SELECT MAX(id) FROM departamento";
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
	
	public void removerDepartamento(Long id) throws SQLException{
		
		String sql = "DELETE FROM departamento WHERE id=?";
		
		this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setLong(1,id);
		stmt.execute();
		this.conexao.close();
		
	}
	
	public void alterarDepartamento(Long id, Funcionario f) throws SQLException{
		String sql = "UPDATE departamento SET nome = ? Where ID =?";
        
        this.conexao = ConectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, f.getDepartamento().getNome());
		stmt.setLong(2, id);
		
		stmt.execute();
	    this.conexao.close();
	}

}
