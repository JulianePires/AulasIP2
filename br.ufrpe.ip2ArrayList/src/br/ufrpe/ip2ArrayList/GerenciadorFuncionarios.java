package br.ufrpe.ip2ArrayList;

import java.time.LocalDate;
import java.util.*;

public class GerenciadorFuncionarios {

	//ATRIBUTO
	private ArrayList <Funcionario> funcionarios;

	//CONSTRUTOR
	public GerenciadorFuncionarios() {
		super();
		this.funcionarios = new ArrayList<Funcionario>(50);
	}

	//METODOS

	public boolean inserir(Funcionario funcionario) {
		if(funcionarios == null || funcionarios.contains(funcionario)) {
			return false;
		} else {
			funcionarios.add(funcionario);
			return true;
		}

	}

	public Funcionario buscar(int codigo) {

		Funcionario func = new Funcionario();

		for(Funcionario func2: funcionarios) {
			if(func2.getCodigo() == codigo) {
				func = func2;
			}
			else {
				func = null;
			}
		}
		return func;
	}

	public boolean remover(int codigo) {
		boolean aux = false;
		if(!buscar(codigo).equals(null)) {
			funcionarios.remove(buscar(codigo));
			aux = true;
		}
		return aux;
	}

	public boolean atualizar(int codigo, Funcionario funcionario) {
		boolean aux = false;
		for(Funcionario func2: funcionarios) {
			if(func2.getCodigo() == codigo) {
				funcionarios.set(func2.getCodigo(), funcionario);
				aux = true;
			}
		}
		return aux;
	}
	
	public List<Funcionario>listarPorCargo(String cargo){
		List<Funcionario> funcs = new ArrayList<Funcionario>();
		for(Funcionario func2: funcionarios) {
			if(func2.getCargo().equals(cargo)) {
				funcs.add(func2);
			}
		}
		return funcs;
	}
	
	public double calcularMediaSalarialPorCargo(String cargo) {
		int n = 0;
		double somaSalario = 0;
		for(Funcionario func2: funcionarios) {
			if(func2.getCargo().equals(cargo)) {
				somaSalario+=func2.getSalario();
				n++;
			}
		}
		return somaSalario/n;
	}

	public List<Funcionario>ganhamAcimaDe(double salario){
		List<Funcionario> funcs = new ArrayList<Funcionario>();  
		for(Funcionario func2: funcionarios) {
			if(func2.getSalario() > salario) {
				funcs.add(func2);
			}
		}
		return funcs;
	}

	public Funcionario obterFuncionarioMaisAntigo() {
		Funcionario maisAntigo = new Funcionario();
		maisAntigo.setDataAdmissao(LocalDate.now());
		for(Funcionario func2: funcionarios) {
			if(func2.getDataAdmissao().isBefore(maisAntigo.getDataAdmissao())) {
				maisAntigo = func2;
			}
		}
		return maisAntigo;
	}

	public Funcionario obterFuncionarioMaisNovo() {
		Funcionario maisNovo = new Funcionario();
		maisNovo = funcionarios.get(0);
		for(Funcionario fun:funcionarios) {
			if(fun.getDataAdmissao().isAfter(maisNovo.getDataAdmissao())) {
				maisNovo = fun;
			}
		}
		return maisNovo;
	}

	public double calcularMediaSalarialPorPeriodo(LocalDate inicio, LocalDate fim) {
		int n = 0;
		double somaSalario = 0;
		for(Funcionario fun:funcionarios) {
			if(fun.getDataAdmissao().isAfter(inicio)&&fun.getDataAdmissao().isBefore(fim)) {
				somaSalario+=fun.getSalario();
				n++;
			}
		}
		return somaSalario/n;
	}
}
