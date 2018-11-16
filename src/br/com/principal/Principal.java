package br.com.principal;

import br.com.modelo.Departamento;
import br.com.modelo.Dependente;
import br.com.modelo.Email;
import br.com.modelo.Funcionario;
import br.com.modelo.Telefone;
import br.com.services.DepartamentoService;
import br.com.services.DependenteService;
import br.com.services.EmailService;
import br.com.services.FuncionarioService;
import br.com.services.TelefoneService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.dao.EmailDao;
import br.com.dao.TelefoneDao;
import br.com.dao.DepartamentoDao;

public class Principal {

	private static Scanner input;
	public static void main(String[] args) throws SQLException {
	
	Scanner input = new Scanner(System.in);
	int opcao;
	do{
		System.out.println("***************************1.Salvar Funcionário****************************");
		System.out.println("***************************2.Excluir Funcionário***************************");
		System.out.println("***************************3.Listar Funcionários***************************");
		System.out.println("***************************4.Alterar Funcionário******************************************");
		System.out.println("***************************5.Sair******************************************");
	
		System.out.println("Digite uma opção: ");
		opcao = input.nextInt();
	
		switch(opcao){
			case 1: salvar();
				break;
			case 2: remover();
				break;
			case 3: listar();
			    break;
			case 4: alterar();
		    	break;
			case 5: System.out.println("Obrigado!");
				break;
			default: System.out.println("Você escolheu uma opção invalida, tente outra vez!");
		}
	}while(opcao != 5);
	
}
	public static void salvar() throws SQLException {	
		EmailService es = new EmailService();
		TelefoneService ts = new TelefoneService();
		DepartamentoService ds = new DepartamentoService();
		FuncionarioService fs = new FuncionarioService();
		DependenteService dts = new DependenteService();
		
		input = new Scanner(System.in);
		String nomedepentende = null;
		String opcdpt = null;
		int flag;
		
		System.out.println("Digite o nome do Funcionario: ");
		String nome = input.next();
		
		System.out.println("Digite a matricula do Funcionario: ");
		String matricula = input.next();
		
		System.out.println("Digite o Email do Funcionario: ");
		String email = input.next();
		
		System.out.println("Digite o Telefone do Funcionario");
		System.out.println("DDD: ");
		String ddd = input.next();
		System.out.println("Numero: ");
		String numero = input.next();
		
		System.out.println("Digite o Departamento do Funcionario: ");
		String departamento = input.next();
		
		System.out.println("Digite o Salario do Funcionario: ");
		Double salario = input.nextDouble();
		
		System.out.println("O Funcionario possui dependentes? (S/N)");
		do{
			flag = 0;
			opcdpt = input.next();
			switch(opcdpt){
				case "S":
				case "s": System.out.println("Digite o Nome do Dependente: ");
						  nomedepentende = input.next();	
						  flag = 1;
					break;
					
				case "N":
				case "n": flag = 2;
					break;
				default: System.out.println("Você escolheu uma opção invalida, tente outra vez!");
			}
			
		}while(flag == 0);
		
		Email f1e = new Email(email);
		Telefone f1t = new Telefone(numero, ddd);
		Departamento f1d = new Departamento(departamento);
		Funcionario f1 = new Funcionario(nome, matricula, f1e, f1t, f1d, salario);
		Dependente dt1 = new Dependente(nomedepentende, f1);
		
		
		es.salvarEmailService(f1e);
		ts.salvarTelefoneService(f1t);
		ds.salvarDepartamentoService(f1d);
		fs.salvarFuncionarioService(f1);
		if(flag == 1)
			dts.salvarDependenteService(dt1);
		
		System.out.println("Funcionario Salvo no Banco de Dados");
		

	}
	
	public static void remover() throws SQLException {	
		EmailService es = new EmailService();
		TelefoneService ts = new TelefoneService();
		DepartamentoService ds = new DepartamentoService();
		FuncionarioService fs = new FuncionarioService();
		DependenteService dts = new DependenteService();
		
		input = new Scanner(System.in);
		
		System.out.println("Digite o ID do Funcionario a ser REMOVIDO: ");
		Long id = input.nextLong();
		
		dts.removerDependenteService(id);
		fs.removerFuncionarioService(id);
		es.removerEmailService(id);
		ts.removerTelefoneService(id);
		ds.removerDepartamentoService(id);
		
		System.out.println("Funcionario Removido do Banco de Dados");
		
	}
	
	public static void listar() throws SQLException {	

		System.out.println("Lista de Funcionarios Cadastrados no Banco de Dados: ");
		
		ArrayList funcionarioList = new FuncionarioService().listarTodosFuncionarioService();
       
		for(int i = 0 ; i < funcionarioList.size() ; i++){
			System.out.println(funcionarioList.get(i));	
		}
		
	}
	
	public static void alterar() throws SQLException {	
		EmailService es = new EmailService();
		TelefoneService ts = new TelefoneService();
		DepartamentoService ds = new DepartamentoService();
		FuncionarioService fs = new FuncionarioService();
		
		input = new Scanner(System.in);
		String nomedepentende = null;

		
		System.out.println("Digite o ID do Funcionario a ser alterado: ");
		long id = input.nextLong();
		
		System.out.println("Digite o nome do Funcionario: ");
		String nome = input.next();
		
		System.out.println("Digite a matricula do Funcionario: ");
		String matricula = input.next();
		
		System.out.println("Digite o Email do Funcionario: ");
		String email = input.next();
		
		System.out.println("Digite o Telefone do Funcionario");
		System.out.println("DDD: ");
		String ddd = input.next();
		System.out.println("Numero: ");
		String numero = input.next();
		
		System.out.println("Digite o Departamento do Funcionario: ");
		String departamento = input.next();
		
		System.out.println("Digite o Salario do Funcionario: ");
		Double salario = input.nextDouble();
		
		
		Email f1e = new Email(email);
		Telefone f1t = new Telefone(numero, ddd);
		Departamento f1d = new Departamento(departamento);
		Funcionario f1 = new Funcionario(nome, matricula, f1e, f1t, f1d, salario);
		
		
		fs.alterarFuncionarioService(id, f1);
		
		System.out.println("Funcionario Alterado");
		

	}

}
