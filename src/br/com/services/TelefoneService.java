package br.com.services;

import java.sql.SQLException;

import br.com.dao.TelefoneDao;
import br.com.modelo.Telefone;

public class TelefoneService {

	private TelefoneDao telefoneDao;
	
	public TelefoneService(){
		this.telefoneDao = new TelefoneDao();
	}
	
	public void salvarTelefoneService (Telefone t)throws SQLException{
		this.telefoneDao.salvarTelefone(t);
	}
	
	public void removerTelefoneService(Long id) throws SQLException{
		this.telefoneDao.removerTelefone(id);
	}
}
