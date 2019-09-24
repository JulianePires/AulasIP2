package sistemaRH.dados;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import sistemaRH.beans.Funcionario;
import sistemaRH.beans.Gerente;
import sistemaRH.beans.Vendedor;

public class RepositorioFuncionarioArray {
	//ATRIBUTOS
	private ArrayList<Funcionario> funcionarios;

	//CONSTRUTOR
	public RepositorioFuncionarioArray() {
		this.funcionarios = new ArrayList<Funcionario>(50);
	}

	public boolean contains(int codigo) {
		boolean answ = false;
		for(Funcionario f: funcionarios) {
			if(f.getCodigo() == codigo) {
				answ = true;
			}
		}
		return answ;
	}

	public Funcionario buscar(int codigo) {
		Funcionario fun = null;
		if(this.contains(codigo) == true) {
			fun = funcionarios.get(codigo);
		}
		return fun;
	}


	public boolean inserir(Funcionario funcionario) {
		boolean answ = false;
		if(!funcionarios.contains(funcionario)) {
			funcionarios.add(funcionario);
			answ = true;
		}
		return answ;
	}

	public boolean remover(int codigo) {
		boolean answ = false;
		if(this.contains(codigo) == true) {
			funcionarios.remove(codigo);
			answ = true;
		}
		return answ;
	}

	public boolean atualizar(int codigo, Funcionario funcionario) {
		boolean answ = false;
		if(this.contains(codigo) == true) {
			funcionarios.set(codigo, funcionario);
			answ = true;
		}
		return answ;
	}

	public List<Funcionario> listarPorCargo(@SuppressWarnings("rawtypes") Class classe){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		for(Funcionario f: funcionarios) {
			if(f.getClass().equals(classe)) {
				lista.add(f);
			}
		}
		return lista;
	}

	public int calcularTotalVendedores() {
		int count = 0;
		for(Funcionario f: funcionarios) {
			if(f.getClass().equals(Vendedor.class)) {
				count++;
			}
		}
		return count;
	}

	public double calcularMediaSalarialGerentes() {
		int count = 0;
		double result = 0.0;
		for(Funcionario f: funcionarios) {
			if(f.getClass().equals(Gerente.class)) {
				result += f.getSalario();
				count++;
			}
		}
		if(count != 0) {
			result = result/count;
		}
		return result;
	}

	public List<Funcionario> ganhamAcimaDe(double salario){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		for(Funcionario f: funcionarios) {
			if(f.getSalario() > salario) {
				lista.add(f);
			}
		}
		return lista;
	}

	public Funcionario obterFuncionarioMaisAntigo() {
		Funcionario maisAntigo = null;
		for(Funcionario f: funcionarios) {
			if(maisAntigo == null) {
				maisAntigo = f;
			} else {
				if(f.getDataAdmissao().isBefore(maisAntigo.getDataAdmissao())){
					maisAntigo = f;
				}
			}
		}
		return maisAntigo;
	}
	
	public Funcionario obterFuncionarioMaisNovo() {
		Funcionario maisNovo = null;
		for(Funcionario f: funcionarios) {
			if(maisNovo == null) {
				maisNovo = f;
			} else {
				if(f.getDataAdmissao().isAfter(maisNovo.getDataAdmissao())) {
					maisNovo = f;
				}
			}
		}
		return maisNovo;
	}
	
	public double calcularMediaSalarialPorPeriodo(LocalDate inicio, LocalDate fim) {
		int count = 0;
		double result = 0.0;
		for(Funcionario f: funcionarios) {
			if(f.getDataAdmissao().isAfter(inicio) && f.getDataAdmissao().isBefore(fim)) {
				count++;
				result += f.getSalario();
			}
		}
		if(count != 0) {
			result = result/count;
		}
		return result;
	}

}
