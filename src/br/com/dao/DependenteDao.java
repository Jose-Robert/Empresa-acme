package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.conexao.ConectionFactory;
import br.com.modelo.Dependente;

public class DependenteDao {
	
	private Connection conexao;

	public DependenteDao() {
		this.conexao = ConectionFactory.getConnection();
	}
	
	public void salvarDependente(Dependente dt) throws SQLException{
		
		FuncionarioDao fd = new FuncionarioDao();
		
   		String sql = "INSERT INTO dependente (nome, funcionario)" + "VALUES (?,?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
				
		stmt.setString(1, dt.getNome());
		stmt.setLong(2, fd.acharUltimoId());

		
		stmt.execute();
		this.conexao.close();
	}
	
	public long acharUltimoId() throws SQLException{
		
		String sql = "SELECT MAX(id) FROM dependente";
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
	
	public void removerDependente(Long id) throws SQLException{
		
		String sql = "DELETE FROM dependente WHERE funcionario=?";
		
		this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setLong(1,id);
		stmt.execute();
		this.conexao.close();
		
	}

}
