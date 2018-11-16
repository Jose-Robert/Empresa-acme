package br.com.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.conexao.ConectionFactory;
import br.com.modelo.Departamento;
import br.com.modelo.Email;
import br.com.modelo.Funcionario;
import br.com.modelo.Telefone;

public class FuncionarioDao {

	private Connection conexao;

	public FuncionarioDao() {
		this.conexao = ConectionFactory.getConnection();
	}
	
	public void salvarFuncionario(Funcionario f) throws SQLException{
		
		EmailDao ed = new EmailDao();
		TelefoneDao td = new TelefoneDao();
		DepartamentoDao dd = new DepartamentoDao();
		
   		String sql = "INSERT INTO funcionario (nome, matricula, email, telefone, departamento, salario)" + "VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
				
		stmt.setString(1, f.getNome());
		stmt.setString(2, f.getMatricula());
		stmt.setLong(3, ed.acharUltimoId());
		stmt.setLong(4, td.acharUltimoId());
		stmt.setLong(5, dd.acharUltimoId());
		stmt.setDouble(6, f.getSalario());
		
		stmt.execute();
		this.conexao.close();
	}
	
	public long acharUltimoId() throws SQLException{
		
		String sql = "SELECT MAX(id) FROM funcionario";
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
	
	public void removerFuncionario(Long id) throws SQLException{
		
		String sql = "DELETE FROM funcionario WHERE id=?";
		
		this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setLong(1,id);
		stmt.execute();
		this.conexao.close();
		
	}
	
	public ArrayList listarTodos() throws SQLException {

        String sql = "select f.id as id, f.nome as nome, f.matricula as matricula, e.descricao as email, t.ddd as dddtelefone, t.numero as telefone, d.nome as departamento, f.salario as salario from funcionario f inner join email e on f.email = e.id inner join telefone t on f.telefone = t.id inner join departamento d on f.departamento = d.id";
        
        this.conexao = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        Funcionario f = null;
        Email e = null;
        Telefone t = null;
        Departamento d = null;
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	e = new Email();
            	e.setDescricao(rs.getString("email"));
            	t = new Telefone();
            	t.setDdd(rs.getString("dddtelefone"));
            	t.setNumero(rs.getString("telefone"));
            	d = new Departamento();
            	d.setNome(rs.getString("departamento"));
            	f = new Funcionario();
            	f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setMatricula(rs.getString("matricula"));                
                f.setEmail(e);    
                f.setTelefone(t);    
                f.setDepartamento(d);
                f.setSalario(rs.getDouble("salario"));
                
                listaFuncionario.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        stmt.execute();
        this.conexao.close();
        return listaFuncionario;
    }
	
	public void alterarFuncionario(Long id, Funcionario f) throws SQLException{
		
		EmailDao ed = new EmailDao();
		TelefoneDao td = new TelefoneDao();
		DepartamentoDao dd = new DepartamentoDao();
		
		String sql = "UPDATE funcionario SET nome =?, matricula =?, salario =? Where ID =?";
        
        this.conexao = ConectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, f.getNome());
		stmt.setString(2, f.getMatricula());
		stmt.setDouble(3, f.getSalario());
		stmt.setLong(4, id);
		
		stmt.execute();
	    this.conexao.close();
		
	    ed.alterarEmail(id, f);
	    td.alterarTelefone(id, f);
	    dd.alterarDepartamento(id, f);
	    	
	}
}
