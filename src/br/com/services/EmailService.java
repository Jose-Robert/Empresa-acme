package br.com.services;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dao.EmailDao;
import br.com.modelo.Email;
import br.com.modelo.Funcionario;

public class EmailService {

private EmailDao emailDao;
	
	public EmailService(){
		this.emailDao = new EmailDao();
	}
	
	public void salvarEmailService (Email e)throws SQLException{
		this.emailDao.salvarEmail(e);
	}
	
	public void removerEmailService(Long id) throws SQLException{
		this.emailDao.removerEmail(id);
	}
}
