package br.ufrpe.ip2ArrayList;

import java.time.*;

public class Funcionario {

	//CONSTANTES
	private static final String Gerente = "Gerente";
	private static final String Motorista = "Motorista";
	private static final String Vendedor = "Vendedor";

	//ATRIBUTOS
	private int			codigo;
	private String		nome;
	private double		salario;
	private String		cargo;
	private LocalDate	dataAdmissao;

	//CONSTRUTORES
	public Funcionario() {
		super();
	}

	@Override
	public String toString() {
		return ("Codigo=" + codigo + ", |Nome=" + nome + ", |Salario=" + salario + ", |Cargo=" + cargo
				+ " |dataAdmissao=" + dataAdmissao);
	}

	public Funcionario(int codigo, String nome, double salario, String cargo, LocalDate dataAdmissao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.dataAdmissao = dataAdmissao;
	}

	//METODOS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome == "") {
			System.out.print("Entrada inválida!");
		} else {
			this.nome = nome;
		}
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario > 0) {
			this.salario = salario;
		}
		else {
			System.out.print("Apenas valores acima de 0 são aceitáveis, tente novamente.");
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(int carg) {
		if(carg == 1) {
			this.cargo = Motorista;
		} else if(carg == 2) {
			this.cargo = Vendedor;
		}else if(carg == 3) {
			this.cargo = Gerente;
		}else {
			System.out.print("Entrada inválida! Escolha um dos cargos: Motorista | Vendedor | Gerente");
		}
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate data) {
		this.dataAdmissao = data;
	}
}
