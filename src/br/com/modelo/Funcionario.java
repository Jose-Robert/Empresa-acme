package br.com.modelo;

public class Funcionario {
	
	private long id;
	private String nome;
	private String matricula;
	private Email email;
	private Telefone telefone;
	private Departamento departamento;
	private double salario;
	
	public Funcionario(String nome, String matricula, Email email, Telefone telefone,
			Departamento departamento, double salario) {	
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
		this.departamento = departamento;
		this.salario = salario;
	}
	
	public Funcionario() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
        return "\nFuncionario:\n" + "ID do Funcionario = " + this.id + "\nNome = " + this.nome + "\nDepartamento = " + this.departamento.getNome() + "\nEmail = " + this.email.getDescricao() + "\nTelefone = " + this.telefone.getDdd()+this.telefone.getNumero() + "\nMatricula = " + this.matricula +"\nSalario = " + this.salario + "\n";
    }
	
	

}
