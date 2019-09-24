package sistemaRH.beans;

import java.time.LocalDate;

public class Vendedor extends Funcionario {
	//ATRIBUTOS
	private double		percentualComissao;
	
	//CONSTRUTORES
	/* default */
	public Vendedor() {
	}
	
	/* herdando da classe pai */
	public Vendedor(int codigo, String nome, double salario, LocalDate dataAdmissao, double percentualComissao) {
		super(codigo, nome, salario, dataAdmissao);
		setPercentualComissao(percentualComissao);
	}
	
	//METODOS
	public double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(double percentualComissao) {
		if(percentualComissao > 0) {
			this.percentualComissao = percentualComissao;	
		}
	}
}

