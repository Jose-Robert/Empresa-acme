package br.com.services;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dao.FuncionarioDao;
import br.com.modelo.Departamento;
import br.com.modelo.Email;
import br.com.modelo.Funcionario;
import br.com.modelo.Telefone;

public class FuncionarioService {
	
	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService(){
		this.funcionarioDao = new FuncionarioDao();
	}
	
	public void salvarFuncionarioService (Funcionario f)throws SQLException{
		this.funcionarioDao.salvarFuncionario(f);	
	}
	
	public ArrayList listarTodosFuncionarioService() throws SQLException {
		return funcionarioDao.listarTodos();
	}
	
	public void removerFuncionarioService(Long id) throws SQLException{
		this.funcionarioDao.removerFuncionario(id);
	}
	
	public void alterarFuncionarioService(Long id, Funcionario f) throws SQLException{
		this.funcionarioDao.alterarFuncionario(id, f);;
	}
}
