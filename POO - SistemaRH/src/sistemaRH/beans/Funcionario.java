package sistemaRH.beans;

import java.time.*;

public class Funcionario {

	//ATRIBUTOS
	private int			codigo;
	private String		nome;
	private double 		salario;
	private LocalDate	dataAdmissao;

	//CONSTRUTORES
	public Funcionario() {
	}

	public Funcionario(int codigo, String nome, 
			double salario, LocalDate dataAdmissao) {
		setCodigo(codigo);
		setNome(nome);
		setSalario(salario);
		this.dataAdmissao = dataAdmissao;

	}
	
	//METODOS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(!(codigo <= 0)) {
			this.codigo = codigo;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null && nome != "") {
			this.nome = nome;
		}
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(!(salario <= 0)) {
			this.salario = salario;
		}
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}




}
