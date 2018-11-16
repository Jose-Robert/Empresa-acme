package br.com.services;

import java.sql.SQLException;

import br.com.dao.DepartamentoDao;
import br.com.modelo.Departamento;


public class DepartamentoService {
	
	private DepartamentoDao departamentoDao;
	
	public DepartamentoService(){
		this.departamentoDao = new DepartamentoDao();
	}
	
	public void salvarDepartamentoService (Departamento d)throws SQLException{
		this.departamentoDao.salvarDepartamento(d);
	}
	
	public void removerDepartamentoService(Long id) throws SQLException{
		this.departamentoDao.removerDepartamento(id);
	}
}

