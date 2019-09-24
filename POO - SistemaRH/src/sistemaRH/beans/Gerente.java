package sistemaRH.beans;

import java.time.*;

public class Gerente extends Funcionario {
	
	//ATRIBUTOS
	private String	departamento;
	
	//CONSTRUTORES
	/* default */
	public Gerente() {
	}
	
	/* herdando o construtor da classe pai */
	public Gerente(int codigo, String nome, double salario, LocalDate dataAdmissao, String departamento) {
		super(codigo, nome, salario, dataAdmissao);
		setDepartamento(departamento);
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		if(departamento != null && departamento != "") {
			this.departamento = departamento;
		}
	}
}
