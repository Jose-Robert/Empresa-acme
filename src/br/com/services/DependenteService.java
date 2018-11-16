package br.com.services;

import java.sql.SQLException;

import br.com.dao.DependenteDao;
import br.com.modelo.Dependente;


public class DependenteService {
	
	private DependenteDao dependenteDao;
	
	public DependenteService(){
		this.dependenteDao = new DependenteDao();
	}
	
	public void salvarDependenteService (Dependente dt)throws SQLException{
		this.dependenteDao.salvarDependente(dt);
	}
	
	public void removerDependenteService(Long id) throws SQLException{
		this.dependenteDao.removerDependente(id);
	}
}
